package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ByteString implements Iterable<Byte> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final ByteString EMPTY = null;

    public interface ByteIterator extends Iterator<Byte> {
        byte nextByte();
    }

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

        Output(int r10) {
            if (r10 < 0) goto L7;
            this.initialCapacity = r10;
            this.flushedBuffers = new ArrayList();
            this.buffer = new byte[r10];
            return;
        L7:
            throw new IllegalArgumentException("Buffer size < 0");
        }

        private byte[] copyArray(byte[] r10, int r11) {
            byte[] r12 = new byte[r11];
            System.arraycopy(r10, 0, r12, 0, Math.min(r10.length, r11));
            return r12;
        }

        private void flushFullBuffer(int r10) {
            this.flushedBuffers.add(new LiteralByteString(this.buffer));
            int r11 = this.flushedBuffersTotalBytes + this.buffer.length;
            this.flushedBuffersTotalBytes = r11;
            this.buffer = new byte[Math.max(this.initialCapacity, Math.max(r10, r11 >>> 1))];
            this.bufferPos = 0;
        }

        private void flushLastBuffer() {
            int r10 = this.bufferPos;
            byte[] r11 = this.buffer;
            if (r10 >= r11.length) goto L6;
            if (r10 <= 0) goto L7;
            this.flushedBuffers.add(new LiteralByteString(copyArray(r11, r10)));
        L7:
            this.flushedBuffersTotalBytes += this.bufferPos;
            this.bufferPos = 0;
            return;
        L6:
            this.flushedBuffers.add(new LiteralByteString(this.buffer));
            this.buffer = EMPTY_BYTE_ARRAY;
            goto L7
        }

        public synchronized int size() {
            monitor-enter(this);
            int r10 = this.flushedBuffersTotalBytes + this.bufferPos;
            monitor-exit(this);
            return r10;
        L7:
            th = move-exception;
            throw th;
        }

        public synchronized ByteString toByteString() {
            monitor-enter(this);
            flushLastBuffer();     // Catch: Throwable -> L6
            ByteString r10 = ByteString.copyFrom(this.flushedBuffers);     // Catch: Throwable -> L6
            monitor-exit(this);
            return r10;
        L6:
            th = move-exception;
            throw th;
        }

        public String toString() {
            return String.format("<ByteString.Output@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size())});
        }

        @Override // java.io.OutputStream
        public synchronized void write(int r10) {
            monitor-enter(this);
        L9:
            th = move-exception;
            throw th;
        L4:
            if (this.bufferPos != this.buffer.length) goto L6;
            flushFullBuffer(1);     // Catch: Throwable -> L9
        L6:
            byte[] r11 = this.buffer;     // Catch: Throwable -> L9
            int r12 = this.bufferPos;     // Catch: Throwable -> L9
            this.bufferPos = r12 + 1;     // Catch: Throwable -> L9
            r11[r12] = (byte) r10;     // Catch: Throwable -> L9
            monitor-exit(this);
        }

        @Override // java.io.OutputStream
        public synchronized void write(byte[] r10, int r11, int r12) {
            monitor-enter(this);
            byte[] r13 = this.buffer;     // Catch: Throwable -> L9
            int r14 = r13.length;     // Catch: Throwable -> L9
            int r15 = this.bufferPos;     // Catch: Throwable -> L9
            if (r12 > (r14 - r15)) goto L6;
            System.arraycopy(r10, r11, r13, r15, r12);     // Catch: Throwable -> L9
            this.bufferPos += r12;     // Catch: Throwable -> L9
        L7:
            monitor-exit(this);
            return;
        L6:
            int r16 = r13.length - r15;     // Catch: Throwable -> L9
            System.arraycopy(r10, r11, r13, r15, r16);     // Catch: Throwable -> L9
            int r17 = r12 - r16;     // Catch: Throwable -> L9
            flushFullBuffer(r17);     // Catch: Throwable -> L9
            System.arraycopy(r10, r11 + r16, this.buffer, 0, r17);     // Catch: Throwable -> L9
            this.bufferPos = r17;     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            throw th;
        }
    }

    static {
        EMPTY = new LiteralByteString(new byte[0]);
    }

    ByteString() {
    }

    private static ByteString balancedConcat(Iterator<ByteString> r10, int r11) {
        if (r11 == 1) goto L7;
        int r12 = r11 >>> 1;
        return balancedConcat(r10, r12).concat(balancedConcat(r10, r11 - r12));
    L7:
        return r10.next();
    }

    public static ByteString copyFrom(Iterable<ByteString> r10) {
        if ((r10 instanceof Collection) == true) goto L8;
        Collection r11 = new ArrayList();
        Iterator<ByteString> r12 = r10.iterator();
    L6:
        if (r12.hasNext() == false) goto L10;
        r11.add(r12.next());
    L10:
        if (r11.isEmpty() == false) goto L13;
        return EMPTY;
    L13:
        return balancedConcat(r11.iterator(), r11.size());
    L8:
        r11 = (Collection) r10;
        goto L10
    }

    public static ByteString copyFrom(byte[] r10) {
        return copyFrom(r10, 0, r10.length);
    }

    public static ByteString copyFrom(byte[] r10, int r11, int r12) {
        byte[] r13 = new byte[r12];
        System.arraycopy(r10, r11, r13, 0, r12);
        return new LiteralByteString(r13);
    }

    public static ByteString copyFromUtf8(String r10) {
        return new LiteralByteString(r10.getBytes("UTF-8"));
    L4:
        e = move-exception;
        throw new RuntimeException("UTF-8 not supported?", e);
    }

    public static Output newOutput() {
        return new Output(128);
    }

    public ByteString concat(ByteString r10) {
        int r11 = size();
        int r12 = r10.size();
        if ((((long) r11) + ((long) r12)) < 2147483647L) goto L5;
        StringBuilder r13 = new StringBuilder(53);
        r13.append("ByteString would be too long: ");
        r13.append(r11);
        r13.append("+");
        r13.append(r12);
        throw new IllegalArgumentException(r13.toString());
    L5:
        return RopeByteString.concatenate(this, r10);
    }

    public void copyTo(byte[] r10, int r11, int r12, int r13) {
        if (r11 < 0) goto L21;
        if (r12 < 0) goto L19;
        if (r13 < 0) goto L17;
        int r14 = r11 + r13;
        if (r14 > size()) goto L15;
        int r15 = r12 + r13;
        if (r15 > r10.length) goto L13;
        if (r13 <= 0) goto L23;
        copyToInternal(r10, r11, r12, r13);
        return;
    L23:
        return;
    L13:
        StringBuilder r16 = new StringBuilder(34);
        r16.append("Target end offset < 0: ");
        r16.append(r15);
        throw new IndexOutOfBoundsException(r16.toString());
    L15:
        StringBuilder r17 = new StringBuilder(34);
        r17.append("Source end offset < 0: ");
        r17.append(r14);
        throw new IndexOutOfBoundsException(r17.toString());
    L17:
        StringBuilder r18 = new StringBuilder(23);
        r18.append("Length < 0: ");
        r18.append(r13);
        throw new IndexOutOfBoundsException(r18.toString());
    L19:
        StringBuilder r19 = new StringBuilder(30);
        r19.append("Target offset < 0: ");
        r19.append(r12);
        throw new IndexOutOfBoundsException(r19.toString());
    L21:
        StringBuilder r20 = new StringBuilder(30);
        r20.append("Source offset < 0: ");
        r20.append(r11);
        throw new IndexOutOfBoundsException(r20.toString());
    }

    protected abstract void copyToInternal(byte[] r10, int r11, int r12, int r13);

    protected abstract int getTreeDepth();

    protected abstract boolean isBalanced();

    public boolean isEmpty() {
        if (size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public abstract boolean isValidUtf8();

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator<Byte> iterator() {
        return iterator();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.lang.Iterable
    public abstract Iterator<Byte> iterator();

    public abstract CodedInputStream newCodedInput();

    protected abstract int partialHash(int r10, int r11, int r12);

    protected abstract int partialIsValidUtf8(int r10, int r11, int r12);

    protected abstract int peekCachedHashCode();

    public abstract int size();

    public byte[] toByteArray() {
        int r10 = size();
        if (r10 == 0) goto L5;
        byte[] r11 = new byte[r10];
        copyToInternal(r11, 0, 0, r10);
        return r11;
    L5:
        return Internal.EMPTY_BYTE_ARRAY;
    }

    public String toString() {
        return String.format("<ByteString@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size())});
    }

    public abstract String toString(String r10);

    public String toStringUtf8() {
        return toString("UTF-8");
    L4:
        e = move-exception;
        throw new RuntimeException("UTF-8 not supported?", e);
    }

    void writeTo(OutputStream r10, int r11, int r12) {
        if (r11 < 0) goto L13;
        if (r12 < 0) goto L11;
        int r13 = r11 + r12;
        if (r13 > size()) goto L9;
        if (r12 <= 0) goto L15;
        writeToInternal(r10, r11, r12);
        return;
    L15:
        return;
    L9:
        StringBuilder r14 = new StringBuilder(39);
        r14.append("Source end offset exceeded: ");
        r14.append(r13);
        throw new IndexOutOfBoundsException(r14.toString());
    L11:
        StringBuilder r15 = new StringBuilder(23);
        r15.append("Length < 0: ");
        r15.append(r12);
        throw new IndexOutOfBoundsException(r15.toString());
    L13:
        StringBuilder r16 = new StringBuilder(30);
        r16.append("Source offset < 0: ");
        r16.append(r11);
        throw new IndexOutOfBoundsException(r16.toString());
    }

    abstract void writeToInternal(OutputStream r10, int r11, int r12);
}
