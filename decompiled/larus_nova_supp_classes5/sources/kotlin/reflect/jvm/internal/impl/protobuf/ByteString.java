package kotlin.reflect.jvm.internal.impl.protobuf;

import com.ss.android.ugc.effectmanager.common.EffectRequest;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class ByteString implements Iterable<Byte> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final ByteString EMPTY = null;

    public static final class Output extends OutputStream {
        private static final byte[] EMPTY_BYTE_ARRAY = null;
        private byte[] buffer;
        private int bufferPos;
        private final ArrayList<ByteString> flushedBuffers;
        private int flushedBuffersTotalBytes;
        private final int initialCapacity;

        static {
            EMPTY_BYTE_ARRAY = new byte[0];
        }

        public synchronized int size() {
            monitor-enter(this);
            int r0 = this.flushedBuffersTotalBytes + this.bufferPos;
            monitor-exit(this);
            return r0;
        L7:
            th = move-exception;
            throw th;
        }

        public synchronized ByteString toByteString() {
            monitor-enter(this);
            flushLastBuffer();     // Catch: Throwable -> L6
            ByteString r0 = ByteString.copyFrom(this.flushedBuffers);     // Catch: Throwable -> L6
            monitor-exit(this);
            return r0;
        L6:
            th = move-exception;
            throw th;
        }

        public String toString() {
            return String.format("<ByteString.Output@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size())});
        }

        private void flushLastBuffer() {
            int r0 = this.bufferPos;
            byte[] r1 = this.buffer;
            if (r0 >= r1.length) goto L6;
            if (r0 <= 0) goto L7;
            this.flushedBuffers.add(new LiteralByteString(copyArray(r1, r0)));
        L7:
            this.flushedBuffersTotalBytes += this.bufferPos;
            this.bufferPos = 0;
            return;
        L6:
            this.flushedBuffers.add(new LiteralByteString(this.buffer));
            this.buffer = EMPTY_BYTE_ARRAY;
            goto L7
        }

        public Output(int r2) {
            if (r2 < 0) goto L7;
            this.initialCapacity = r2;
            this.flushedBuffers = new ArrayList();
            this.buffer = new byte[r2];
            return;
        L7:
            throw new IllegalArgumentException("Buffer size < 0");
        }

        private void flushFullBuffer(int r4) {
            this.flushedBuffers.add(new LiteralByteString(this.buffer));
            int r0 = this.flushedBuffersTotalBytes + this.buffer.length;
            this.flushedBuffersTotalBytes = r0;
            this.buffer = new byte[Math.max(this.initialCapacity, Math.max(r4, r0 >>> 1))];
            this.bufferPos = 0;
        }

        @Override // java.io.OutputStream
        public synchronized void write(int r4) {
            monitor-enter(this);
        L9:
            th = move-exception;
            throw th;
        L4:
            if (this.bufferPos != this.buffer.length) goto L6;
            flushFullBuffer(1);     // Catch: Throwable -> L9
        L6:
            byte[] r0 = this.buffer;     // Catch: Throwable -> L9
            int r1 = this.bufferPos;     // Catch: Throwable -> L9
            this.bufferPos = r1 + 1;     // Catch: Throwable -> L9
            r0[r1] = (byte) r4;     // Catch: Throwable -> L9
            monitor-exit(this);
        }

        private byte[] copyArray(byte[] r3, int r4) {
            byte[] r0 = new byte[r4];
            System.arraycopy(r3, 0, r0, 0, Math.min(r3.length, r4));
            return r0;
        }

        @Override // java.io.OutputStream
        public synchronized void write(byte[] r4, int r5, int r6) {
            monitor-enter(this);
            byte[] r0 = this.buffer;     // Catch: Throwable -> L9
            int r1 = r0.length;     // Catch: Throwable -> L9
            int r2 = this.bufferPos;     // Catch: Throwable -> L9
            if (r6 > (r1 - r2)) goto L6;
            System.arraycopy(r4, r5, r0, r2, r6);     // Catch: Throwable -> L9
            this.bufferPos += r6;     // Catch: Throwable -> L9
        L7:
            monitor-exit(this);
            return;
        L6:
            int r3 = r0.length - r2;     // Catch: Throwable -> L9
            System.arraycopy(r4, r5, r0, r2, r3);     // Catch: Throwable -> L9
            int r7 = r6 - r3;     // Catch: Throwable -> L9
            flushFullBuffer(r7);     // Catch: Throwable -> L9
            System.arraycopy(r4, r5 + r3, this.buffer, 0, r7);     // Catch: Throwable -> L9
            this.bufferPos = r7;     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            throw th;
        }
    }

    public ByteString() {
    }

    public abstract void copyToInternal(byte[] r1, int r2, int r3, int r4);

    public abstract int getTreeDepth();

    public abstract boolean isBalanced();

    public abstract boolean isValidUtf8();

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: iterator, reason: avoid collision after fix types in other method */
    public abstract Iterator<Byte> iterator2();

    public abstract CodedInputStream newCodedInput();

    public abstract int partialHash(int r1, int r2, int r3);

    public abstract int partialIsValidUtf8(int r1, int r2, int r3);

    public abstract int peekCachedHashCode();

    public abstract int size();

    public String toString() {
        return String.format("<ByteString@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size())});
    }

    public abstract String toString(String r1) throws UnsupportedEncodingException;

    public abstract void writeToInternal(OutputStream r1, int r2, int r3) throws IOException;

    static {
        EMPTY = new LiteralByteString(new byte[0]);
    }

    public static Output newOutput() {
        return new Output(128);
    }

    public String toStringUtf8() {
        return toString(EffectRequest.DEFAULT_PARAMS_ENCODING);
    L4:
        e = move-exception;
        throw new RuntimeException("UTF-8 not supported?", e);
    }

    public boolean isEmpty() {
        if (size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator<Byte> iterator() {
        return iterator2();
    }

    public byte[] toByteArray() {
        int r0 = size();
        if (r0 == 0) goto L5;
        byte[] r1 = new byte[r0];
        copyToInternal(r1, 0, 0, r0);
        return r1;
    L5:
        return Internal.EMPTY_BYTE_ARRAY;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.util.ArrayList] */
    public static ByteString copyFrom(Iterable<ByteString> r2) {
        if ((r2 instanceof Collection) == true) goto L8;
        ?? r0 = new ArrayList();
        Iterator<ByteString> r3 = r2.iterator();
    L6:
        if (r3.hasNext() == false) goto L10;
        r0.add(r3.next());
    L10:
        if (r0.isEmpty() == false) goto L13;
        return EMPTY;
    L13:
        return balancedConcat(r0.iterator(), r0.size());
    L8:
        r0 = (Collection) r2;
        goto L10
    }

    public static ByteString copyFromUtf8(String r2) {
        return new LiteralByteString(r2.getBytes(EffectRequest.DEFAULT_PARAMS_ENCODING));
    L4:
        e = move-exception;
        throw new RuntimeException("UTF-8 not supported?", e);
    }

    public ByteString concat(ByteString r8) {
        int r0 = size();
        int r1 = r8.size();
        if ((((long) r0) + ((long) r1)) < 2147483647L) goto L5;
        StringBuilder r2 = new StringBuilder(53);
        r2.append("ByteString would be too long: ");
        r2.append(r0);
        r2.append("+");
        r2.append(r1);
        throw new IllegalArgumentException(r2.toString());
    L5:
        return RopeByteString.concatenate(this, r8);
    }

    public static ByteString copyFrom(byte[] r2) {
        return copyFrom(r2, 0, r2.length);
    }

    private static ByteString balancedConcat(Iterator<ByteString> r2, int r3) {
        if (r3 == 1) goto L7;
        int r0 = r3 >>> 1;
        return balancedConcat(r2, r0).concat(balancedConcat(r2, r3 - r0));
    L7:
        return r2.next();
    }

    public static ByteString copyFrom(byte[] r2, int r3, int r4) {
        byte[] r0 = new byte[r4];
        System.arraycopy(r2, r3, r0, 0, r4);
        return new LiteralByteString(r0);
    }

    public void writeTo(OutputStream r3, int r4, int r5) throws IOException {
        if (r4 < 0) goto L13;
        if (r5 < 0) goto L11;
        int r0 = r4 + r5;
        if (r0 > size()) goto L9;
        if (r5 <= 0) goto L15;
        writeToInternal(r3, r4, r5);
        return;
    L15:
        return;
    L9:
        StringBuilder r6 = new StringBuilder(39);
        r6.append("Source end offset exceeded: ");
        r6.append(r0);
        throw new IndexOutOfBoundsException(r6.toString());
    L11:
        StringBuilder r7 = new StringBuilder(23);
        r7.append("Length < 0: ");
        r7.append(r5);
        throw new IndexOutOfBoundsException(r7.toString());
    L13:
        StringBuilder r8 = new StringBuilder(30);
        r8.append("Source offset < 0: ");
        r8.append(r4);
        throw new IndexOutOfBoundsException(r8.toString());
    }

    public void copyTo(byte[] r4, int r5, int r6, int r7) {
        if (r5 < 0) goto L21;
        if (r6 < 0) goto L19;
        if (r7 < 0) goto L17;
        int r0 = r5 + r7;
        if (r0 > size()) goto L15;
        int r1 = r6 + r7;
        if (r1 > r4.length) goto L13;
        if (r7 <= 0) goto L23;
        copyToInternal(r4, r5, r6, r7);
        return;
    L23:
        return;
    L13:
        StringBuilder r8 = new StringBuilder(34);
        r8.append("Target end offset < 0: ");
        r8.append(r1);
        throw new IndexOutOfBoundsException(r8.toString());
    L15:
        StringBuilder r9 = new StringBuilder(34);
        r9.append("Source end offset < 0: ");
        r9.append(r0);
        throw new IndexOutOfBoundsException(r9.toString());
    L17:
        StringBuilder r10 = new StringBuilder(23);
        r10.append("Length < 0: ");
        r10.append(r7);
        throw new IndexOutOfBoundsException(r10.toString());
    L19:
        StringBuilder r11 = new StringBuilder(30);
        r11.append("Target offset < 0: ");
        r11.append(r6);
        throw new IndexOutOfBoundsException(r11.toString());
    L21:
        StringBuilder r12 = new StringBuilder(30);
        r12.append("Source offset < 0: ");
        r12.append(r5);
        throw new IndexOutOfBoundsException(r12.toString());
    }
}
