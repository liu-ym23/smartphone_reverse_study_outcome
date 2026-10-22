package org.apache.commons.compress.compressors.lz4;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import org.apache.commons.compress.compressors.lz77support.AbstractLZ77CompressorInputStream;
import org.apache.commons.compress.utils.ByteUtils;

/* JADX INFO: loaded from: classes6.dex */
public class BlockLZ4CompressorInputStream extends AbstractLZ77CompressorInputStream {
    private int nextBackReferenceSize;
    private State state;

    /* JADX INFO: renamed from: org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorInputStream$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$compress$compressors$lz4$BlockLZ4CompressorInputStream$State = null;

        static {
            int[] r0 = new int[State.values().length];
            $SwitchMap$org$apache$commons$compress$compressors$lz4$BlockLZ4CompressorInputStream$State = r0;
            r0[State.EOF.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$org$apache$commons$compress$compressors$lz4$BlockLZ4CompressorInputStream$State[State.NO_BLOCK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$org$apache$commons$compress$compressors$lz4$BlockLZ4CompressorInputStream$State[State.IN_LITERAL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$org$apache$commons$compress$compressors$lz4$BlockLZ4CompressorInputStream$State[State.LOOKING_FOR_BACK_REFERENCE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$org$apache$commons$compress$compressors$lz4$BlockLZ4CompressorInputStream$State[State.IN_BACK_REFERENCE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    private static final enum State extends Enum<State> {
        private static final /* synthetic */ State[] $VALUES = null;
        public static final State EOF = null;
        public static final State IN_BACK_REFERENCE = null;
        public static final State IN_LITERAL = null;
        public static final State LOOKING_FOR_BACK_REFERENCE = null;
        public static final State NO_BLOCK = null;

        static {
            State r0 = new State("NO_BLOCK", 0);
            NO_BLOCK = r0;
            State r1 = new State("IN_LITERAL", 1);
            IN_LITERAL = r1;
            State r3 = new State("LOOKING_FOR_BACK_REFERENCE", 2);
            LOOKING_FOR_BACK_REFERENCE = r3;
            State r5 = new State("IN_BACK_REFERENCE", 3);
            IN_BACK_REFERENCE = r5;
            State r7 = new State("EOF", 4);
            EOF = r7;
            $VALUES = new State[]{r0, r1, r3, r5, r7};
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

    private boolean initializeBackReference() {
        int r0 = (int) ByteUtils.fromLittleEndian(this.supplier, 2);
        int r1 = this.nextBackReferenceSize;
        long r2 = r1;
        if (r1 != 15) goto L7;
        r2 = r2 + readSizeBytes();
    L7:
        if (r2 < 0) goto L16;
        startBackReference(r0, r2 + 4);     // Catch: IllegalArgumentException -> L12
        this.state = State.IN_BACK_REFERENCE;
        return true;
    L12:
        e = move-exception;
        throw new IOException("Illegal block with bad offset found", e);
    L16:
        throw new IOException("Illegal block with a negative match length found");
    L17:
        e = move-exception;
        if (this.nextBackReferenceSize != 0) goto L22;
        return false;
    L22:
        throw e;
    }

    private long readSizeBytes() {
        long r0 = 0;
    L3:
        int r2 = readOneByte();
        if (r2 == (-1)) goto L9;
        r0 = r0 + ((long) r2);
        if (r2 == 255) goto L3;
        return r0;
    L9:
        throw new IOException("Premature end of stream while parsing length");
    }

    private void readSizes() {
        int r0 = readOneByte();
        if (r0 == (-1)) goto L14;
        this.nextBackReferenceSize = r0 & 15;
        long r1 = (r0 & 240) >> 4;
        if (r1 != 15) goto L8;
        r1 = r1 + readSizeBytes();
    L8:
        if (r1 < 0) goto L12;
        startLiteral(r1);
        this.state = State.IN_LITERAL;
        return;
    L12:
        throw new IOException("Illegal block with a negative literal size found");
    L14:
        throw new IOException("Premature end of stream while looking for next block");
    }

    @Override // java.io.InputStream
    public int read(byte[] r4, int r5, int r6) {
        if (r6 != 0) goto L5;
        return 0;
    L5:
        int r0 = AnonymousClass1.$SwitchMap$org$apache$commons$compress$compressors$lz4$BlockLZ4CompressorInputStream$State[this.state.ordinal()];
        if (r0 != 1) goto L8;
        return -1;
    L8:
        if (r0 != 2) goto L10;
        readSizes();
    L30:
        int r1 = readLiteral(r4, r5, r6);
        if (hasMoreDataInBlock() == true) goto L33;
        this.state = State.LOOKING_FOR_BACK_REFERENCE;
    L33:
        if (r1 <= 0) goto L36;
        return r1;
    L36:
        return read(r4, r5, r6);
    L10:
        if (r0 == 3) goto L30;
        if (r0 == 4) goto L19;
        if (r0 != 5) goto L17;
    L22:
        int r2 = readBackReference(r4, r5, r6);
        if (hasMoreDataInBlock() == true) goto L25;
        this.state = State.NO_BLOCK;
    L25:
        if (r2 <= 0) goto L28;
        return r2;
    L28:
        return read(r4, r5, r6);
    L17:
        throw new IOException("Unknown stream state " + this.state);
    L19:
        if (initializeBackReference() == true) goto L22;
        this.state = State.EOF;
        return -1;
    }
}
