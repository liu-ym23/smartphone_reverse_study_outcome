package org.apache.commons.compress.compressors.snappy;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import org.apache.commons.compress.compressors.lz77support.AbstractLZ77CompressorInputStream;
import org.apache.commons.compress.utils.ByteUtils;

/* JADX INFO: loaded from: classes6.dex */
public class SnappyCompressorInputStream extends AbstractLZ77CompressorInputStream {
    private boolean endReached;
    private State state;
    private int uncompressedBytesRemaining;

    /* JADX INFO: renamed from: org.apache.commons.compress.compressors.snappy.SnappyCompressorInputStream$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$compress$compressors$snappy$SnappyCompressorInputStream$State = null;

        static {
            int[] r0 = new int[State.values().length];
            $SwitchMap$org$apache$commons$compress$compressors$snappy$SnappyCompressorInputStream$State = r0;
            r0[State.NO_BLOCK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$org$apache$commons$compress$compressors$snappy$SnappyCompressorInputStream$State[State.IN_LITERAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$org$apache$commons$compress$compressors$snappy$SnappyCompressorInputStream$State[State.IN_BACK_REFERENCE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    private static final enum State extends Enum<State> {
        private static final /* synthetic */ State[] $VALUES = null;
        public static final State IN_BACK_REFERENCE = null;
        public static final State IN_LITERAL = null;
        public static final State NO_BLOCK = null;

        static {
            State r0 = new State("NO_BLOCK", 0);
            NO_BLOCK = r0;
            State r1 = new State("IN_LITERAL", 1);
            IN_LITERAL = r1;
            State r3 = new State("IN_BACK_REFERENCE", 2);
            IN_BACK_REFERENCE = r3;
            $VALUES = new State[]{r0, r1, r3};
        }

        private State(String r1, int r2) {
            super(r1, r2);
        }

        public static State valueOf(String r2) {
            return (State) ZeusTransformUtils.preCheckCast(Enum.valueOf(State.class, r2), State.class, "com.obric.memorydata.plugin");
        }

        public static State[] values() {
            return (State[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), State[].class, "com.obric.memorydata.plugin");
        }
    }

    private void fill() {
        if (this.uncompressedBytesRemaining != 0) goto L6;
        this.endReached = true;
        return;
    L6:
        int r0 = readOneByte();
        if (r0 == (-1)) goto L58;
        int r3 = r0 & 3;
        if (r3 != 0) goto L11;
        int r1 = readLiteralLength(r0);
        if (r1 < 0) goto L56;
        this.uncompressedBytesRemaining -= r1;
        startLiteral(r1);
        State r2 = State.IN_LITERAL;
    L53:
        this.state = r2;
        return;
    L56:
        throw new IOException("Illegal block with a negative literal size found");
    L11:
        if (r3 != 1) goto L13;
        int r4 = ((r0 >> 2) & 7) + 4;
        if (r4 < 0) goto L49;
        this.uncompressedBytesRemaining -= r4;
        int r5 = (r0 & 224) << 3;
        int r6 = readOneByte();
        if (r6 == (-1)) goto L47;
        startBackReference(r5 | r6, r4);     // Catch: IllegalArgumentException -> L43
    L30:
        r2 = State.IN_BACK_REFERENCE;
    L43:
        e = move-exception;
        throw new IOException("Illegal block with bad offset found", e);
    L47:
        throw new IOException("Premature end of stream reading back-reference length");
    L49:
        throw new IOException("Illegal block with a negative match length found");
    L13:
        if (r3 == 2) goto L26;
        if (r3 != 3) goto L65;
        int r7 = (r0 >> 2) + 1;
        if (r7 < 0) goto L25;
        this.uncompressedBytesRemaining -= r7;
        startBackReference(((int) ByteUtils.fromLittleEndian(this.supplier, 4)) & Integer.MAX_VALUE, r7);     // Catch: IllegalArgumentException -> L21
    L21:
        e = move-exception;
        throw new IOException("Illegal block with bad offset found", e);
    L25:
        throw new IOException("Illegal block with a negative match length found");
    L65:
        return;
    L26:
        int r8 = (r0 >> 2) + 1;
        if (r8 < 0) goto L35;
        this.uncompressedBytesRemaining -= r8;
        startBackReference((int) ByteUtils.fromLittleEndian(this.supplier, 2), r8);     // Catch: IllegalArgumentException -> L31
    L31:
        e = move-exception;
        throw new IOException("Illegal block with bad offset found", e);
    L35:
        throw new IOException("Illegal block with a negative match length found");
    L58:
        throw new IOException("Premature end of stream reading block start");
    }

    private int readLiteralLength(int r2) {
        int r3 = r2 >> 2;
        switch(r3) {
            case 60: goto L10;
            case 61: goto L8;
            case 62: goto L6;
            case 63: goto L5;
            default: goto L16;
        };
    L5:
        ByteUtils.ByteSupplier r1 = this.supplier;
        int r4 = 4;
    L7:
        long r5 = ByteUtils.fromLittleEndian(r1, r4);
    L9:
        r3 = (int) r5;
        goto L16
    L6:
        r1 = this.supplier;
        r4 = 3;
        goto L7
    L8:
        r5 = ByteUtils.fromLittleEndian(this.supplier, 2);
        goto L9
    L10:
        r3 = readOneByte();
        if (r3 != (-1)) goto L16;
        throw new IOException("Premature end of stream reading literal length");
    L16:
        return r3 + 1;
    }

    @Override // java.io.InputStream
    public int read(byte[] r3, int r4, int r5) {
        if (r5 != 0) goto L6;
        return 0;
    L6:
        if (this.endReached == false) goto L9;
        return -1;
    L9:
        int r0 = AnonymousClass1.$SwitchMap$org$apache$commons$compress$compressors$snappy$SnappyCompressorInputStream$State[this.state.ordinal()];
        if (r0 != 1) goto L12;
        fill();
        return read(r3, r4, r5);
    L12:
        if (r0 != 2) goto L14;
        int r1 = readLiteral(r3, r4, r5);
        if (hasMoreDataInBlock() == true) goto L27;
        this.state = State.NO_BLOCK;
    L27:
        if (r1 <= 0) goto L30;
        return r1;
    L30:
        return read(r3, r4, r5);
    L14:
        if (r0 != 3) goto L23;
        int r2 = readBackReference(r3, r4, r5);
        if (hasMoreDataInBlock() == true) goto L18;
        this.state = State.NO_BLOCK;
    L18:
        if (r2 <= 0) goto L21;
        return r2;
    L21:
        return read(r3, r4, r5);
    L23:
        throw new IOException("Unknown stream state " + this.state);
    }
}
