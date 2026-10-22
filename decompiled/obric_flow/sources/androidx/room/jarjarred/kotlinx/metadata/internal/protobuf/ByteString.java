package androidx.room.jarjarred.kotlinx.metadata.internal.protobuf;

import androidx.constraintlayout.motion.widget.a;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class ByteString implements Iterable<Byte> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int CONCATENATE_BY_COPY_SIZE = 128;
    public static final ByteString EMPTY = null;
    static final int MAX_READ_FROM_CHUNK_SIZE = 8192;
    static final int MIN_READ_FROM_CHUNK_SIZE = 256;

    /* JADX INFO: renamed from: androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.ByteString$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public interface ByteIterator extends Iterator<Byte> {
        byte nextByte();
    }

    public static final class CodedBuilder {
        private final byte[] buffer;
        private final CodedOutputStream output;

        public /* synthetic */ CodedBuilder(int r5, AnonymousClass1 r10) {
            this(r5);
        }

        public ByteString build() {
            this.output.checkNoSpaceLeft();
            return new LiteralByteString(this.buffer);
        }

        public CodedOutputStream getCodedOutput() {
            return this.output;
        }

        private CodedBuilder(int r5) {
            byte[] r10 = new byte[r5];
            this.buffer = r10;
            this.output = CodedOutputStream.newInstance(r10);
        }
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

        public Output(int r5) {
            if (r5 < 0) goto L7;
            this.initialCapacity = r5;
            this.flushedBuffers = new ArrayList();
            this.buffer = new byte[r5];
            return;
        L7:
            throw new IllegalArgumentException("Buffer size < 0");
        }

        private byte[] copyArray(byte[] r5, int r10) {
            byte[] r11 = new byte[r10];
            System.arraycopy(r5, 0, r11, 0, Math.min(r5.length, r10));
            return r11;
        }

        private void flushFullBuffer(int r5) {
            this.flushedBuffers.add(new LiteralByteString(this.buffer));
            int r10 = this.flushedBuffersTotalBytes + this.buffer.length;
            this.flushedBuffersTotalBytes = r10;
            this.buffer = new byte[Math.max(this.initialCapacity, Math.max(r5, r10 >>> 1))];
            this.bufferPos = 0;
        }

        private void flushLastBuffer() {
            int r5 = this.bufferPos;
            byte[] r10 = this.buffer;
            if (r5 >= r10.length) goto L6;
            if (r5 <= 0) goto L7;
            this.flushedBuffers.add(new LiteralByteString(copyArray(r10, r5)));
        L7:
            this.flushedBuffersTotalBytes += this.bufferPos;
            this.bufferPos = 0;
            return;
        L6:
            this.flushedBuffers.add(new LiteralByteString(this.buffer));
            this.buffer = EMPTY_BYTE_ARRAY;
            goto L7
        }

        public synchronized void reset() {
            monitor-enter(this);
            this.flushedBuffers.clear();     // Catch: Throwable -> L6
            this.flushedBuffersTotalBytes = 0;     // Catch: Throwable -> L6
            this.bufferPos = 0;     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public synchronized int size() {
            monitor-enter(this);
            int r5 = this.flushedBuffersTotalBytes + this.bufferPos;
            monitor-exit(this);
            return r5;
        L7:
            th = move-exception;
            throw th;
        }

        public synchronized ByteString toByteString() {
            monitor-enter(this);
            flushLastBuffer();     // Catch: Throwable -> L6
            ByteString r5 = ByteString.copyFrom(this.flushedBuffers);     // Catch: Throwable -> L6
            monitor-exit(this);
            return r5;
        L6:
            th = move-exception;
            throw th;
        }

        public String toString() {
            return String.format("<ByteString.Output@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size())});
        }

        @Override // java.io.OutputStream
        public synchronized void write(int r5) {
            monitor-enter(this);
        L6:
            th = move-exception;
            throw th;
        L4:
            if (this.bufferPos != this.buffer.length) goto L8;
            flushFullBuffer(1);     // Catch: Throwable -> L6
        L8:
            byte[] r10 = this.buffer;     // Catch: Throwable -> L6
            int r11 = this.bufferPos;     // Catch: Throwable -> L6
            this.bufferPos = r11 + 1;     // Catch: Throwable -> L6
            r10[r11] = (byte) r5;     // Catch: Throwable -> L6
            monitor-exit(this);
        }

        public void writeTo(OutputStream r10) throws IOException {
            monitor-enter(this);
            ArrayList<ByteString> r5 = this.flushedBuffers;     // Catch: Throwable -> L10
            ByteString[] r11 = (ByteString[]) r5.toArray(new ByteString[r5.size()]);     // Catch: Throwable -> L10
            byte[] r12 = this.buffer;     // Catch: Throwable -> L10
            int r13 = this.bufferPos;     // Catch: Throwable -> L10
            monitor-exit(this);     // Catch: Throwable -> L10
            int r14 = r11.length;
            int r15 = 0;
        L6:
            if (r15 >= r14) goto L8;
            r11[r15].writeTo(r10);
            r15 = r15 + 1;
            goto L6
        L8:
            r10.write(copyArray(r12, r13));
            return;
        L10:
            th = move-exception;
            throw th;
        }

        @Override // java.io.OutputStream
        public synchronized void write(byte[] r5, int r10, int r11) {
            monitor-enter(this);
            byte[] r12 = this.buffer;     // Catch: Throwable -> L6
            int r13 = r12.length;     // Catch: Throwable -> L6
            int r14 = this.bufferPos;     // Catch: Throwable -> L6
            if (r11 > (r13 - r14)) goto L8;
            System.arraycopy(r5, r10, r12, r14, r11);     // Catch: Throwable -> L6
            this.bufferPos += r11;     // Catch: Throwable -> L6
        L9:
            monitor-exit(this);
            return;
        L8:
            int r15 = r12.length - r14;     // Catch: Throwable -> L6
            System.arraycopy(r5, r10, r12, r14, r15);     // Catch: Throwable -> L6
            int r16 = r11 - r15;     // Catch: Throwable -> L6
            flushFullBuffer(r16);     // Catch: Throwable -> L6
            System.arraycopy(r5, r10 + r15, this.buffer, 0, r16);     // Catch: Throwable -> L6
            this.bufferPos = r16;     // Catch: Throwable -> L6
        L6:
            th = move-exception;
            throw th;
        }
    }

    static {
        EMPTY = new LiteralByteString(new byte[0]);
    }

    public ByteString() {
    }

    private static ByteString balancedConcat(Iterator<ByteString> r5, int r10) {
        if (r10 == 1) goto L7;
        int r11 = r10 >>> 1;
        return balancedConcat(r5, r11).concat(balancedConcat(r5, r10 - r11));
    L7:
        return r5.next();
    }

    public static ByteString copyFrom(byte[] r5, int r10, int r11) {
        byte[] r12 = new byte[r11];
        System.arraycopy(r5, r10, r12, 0, r11);
        return new LiteralByteString(r12);
    }

    public static ByteString copyFromUtf8(String r5) {
        return new LiteralByteString(r5.getBytes("UTF-8"));
    L4:
        e = move-exception;
        throw new RuntimeException("UTF-8 not supported?", e);
    }

    public static CodedBuilder newCodedBuilder(int r5) {
        return new CodedBuilder(r5, null);
    }

    public static Output newOutput(int r5) {
        return new Output(r5);
    }

    private static ByteString readChunk(InputStream r5, int r10) throws IOException {
        byte[] r11 = new byte[r10];
        int r12 = 0;
    L3:
        if (r12 >= r10) goto L8;
        int r13 = r5.read(r11, r12, r10 - r12);
        if (r13 == (-1)) goto L8;
        r12 = r12 + r13;
    L8:
        if (r12 != 0) goto L12;
        return null;
    L12:
        return copyFrom(r11, 0, r12);
    }

    public static ByteString readFrom(InputStream r5) throws IOException {
        return readFrom(r5, 256, 8192);
    }

    public abstract ByteBuffer asReadOnlyByteBuffer();

    public abstract List<ByteBuffer> asReadOnlyByteBufferList();

    public abstract byte byteAt(int r5);

    public ByteString concat(ByteString r10) {
        int r5 = size();
        int r11 = r10.size();
        if ((((long) r5) + ((long) r11)) < 2147483647L) goto L5;
        StringBuilder r12 = new StringBuilder(53);
        r12.append("ByteString would be too long: ");
        r12.append(r5);
        r12.append("+");
        r12.append(r11);
        throw new IllegalArgumentException(r12.toString());
    L5:
        return RopeByteString.concatenate(this, r10);
    }

    public abstract void copyTo(ByteBuffer r5);

    public void copyTo(byte[] r5, int r10) {
        copyTo(r5, 0, r10, size());
    }

    public abstract void copyToInternal(byte[] r5, int r10, int r11, int r12);

    public boolean endsWith(ByteString r5) {
        if (size() >= r5.size()) goto L5;
    L7:
        return false;
    L5:
        if (substring(size() - r5.size()).equals(r5) == false) goto L7;
        return true;
    }

    public abstract boolean equals(Object r5);

    public abstract int getTreeDepth();

    public abstract int hashCode();

    public abstract boolean isBalanced();

    public boolean isEmpty() {
        if (size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public abstract boolean isValidUtf8();

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.lang.Iterable
    public abstract Iterator<Byte> iterator();

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator<Byte> iterator() {
        return iterator();
    }

    public abstract CodedInputStream newCodedInput();

    public abstract InputStream newInput();

    public abstract int partialHash(int r5, int r10, int r11);

    public abstract int partialIsValidUtf8(int r5, int r10, int r11);

    public abstract int peekCachedHashCode();

    public abstract int size();

    public boolean startsWith(ByteString r5) {
        if (size() >= r5.size()) goto L5;
        return false;
    L5:
        if (substring(0, r5.size()).equals(r5) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public ByteString substring(int r5) {
        return substring(r5, size());
    }

    public abstract ByteString substring(int r5, int r10);

    public byte[] toByteArray() {
        int r5 = size();
        if (r5 == 0) goto L5;
        byte[] r10 = new byte[r5];
        copyToInternal(r10, 0, 0, r5);
        return r10;
    L5:
        return Internal.EMPTY_BYTE_ARRAY;
    }

    public String toString() {
        return String.format("<ByteString@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size())});
    }

    public abstract String toString(String r5) throws UnsupportedEncodingException;

    public String toStringUtf8() {
        return toString("UTF-8");
    L4:
        e = move-exception;
        throw new RuntimeException("UTF-8 not supported?", e);
    }

    public abstract void writeTo(OutputStream r5) throws IOException;

    public void writeTo(OutputStream r5, int r10, int r11) throws IOException {
        if (r10 < 0) goto L14;
        if (r11 < 0) goto L12;
        int r12 = r10 + r11;
        if (r12 > size()) goto L10;
        if (r11 <= 0) goto L15;
        writeToInternal(r5, r10, r11);
        return;
    L15:
        return;
    L10:
        throw new IndexOutOfBoundsException(a.i(39, "Source end offset exceeded: ", r12));
    L12:
        throw new IndexOutOfBoundsException(a.i(23, "Length < 0: ", r11));
    L14:
        throw new IndexOutOfBoundsException(a.i(30, "Source offset < 0: ", r10));
    }

    public abstract void writeToInternal(OutputStream r5, int r10, int r11) throws IOException;

    public static Output newOutput() {
        return new Output(128);
    }

    public static ByteString readFrom(InputStream r5, int r10) throws IOException {
        return readFrom(r5, r10, r10);
    }

    public void copyTo(byte[] r5, int r10, int r11, int r12) {
        if (r10 < 0) goto L22;
        if (r11 < 0) goto L20;
        if (r12 < 0) goto L18;
        int r13 = r10 + r12;
        if (r13 > size()) goto L16;
        int r14 = r11 + r12;
        if (r14 > r5.length) goto L14;
        if (r12 <= 0) goto L23;
        copyToInternal(r5, r10, r11, r12);
        return;
    L23:
        return;
    L14:
        throw new IndexOutOfBoundsException(a.i(34, "Target end offset < 0: ", r14));
    L16:
        throw new IndexOutOfBoundsException(a.i(34, "Source end offset < 0: ", r13));
    L18:
        throw new IndexOutOfBoundsException(a.i(23, "Length < 0: ", r12));
    L20:
        throw new IndexOutOfBoundsException(a.i(30, "Target offset < 0: ", r11));
    L22:
        throw new IndexOutOfBoundsException(a.i(30, "Source offset < 0: ", r10));
    }

    public static ByteString readFrom(InputStream r5, int r10, int r11) throws IOException {
        ArrayList r12 = new ArrayList();
    L3:
        ByteString r13 = readChunk(r5, r10);
        if (r13 == null) goto L6;
        r12.add(r13);
        r10 = Math.min(r10 * 2, r11);
        goto L3
    L6:
        return copyFrom(r12);
    }

    public static ByteString copyFrom(byte[] r5) {
        return copyFrom(r5, 0, r5.length);
    }

    public static ByteString copyFrom(ByteBuffer r5, int r10) {
        byte[] r11 = new byte[r10];
        r5.get(r11);
        return new LiteralByteString(r11);
    }

    public static ByteString copyFrom(ByteBuffer r5) {
        return copyFrom(r5, r5.remaining());
    }

    public static ByteString copyFrom(String r5, String r10) throws UnsupportedEncodingException {
        return new LiteralByteString(r5.getBytes(r10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.util.ArrayList] */
    public static ByteString copyFrom(Iterable<ByteString> r5) {
        if ((r5 instanceof Collection) == true) goto L8;
        ?? r10 = new ArrayList();
        Iterator<ByteString> r11 = r5.iterator();
    L6:
        if (r11.hasNext() == false) goto L10;
        r10.add(r11.next());
    L10:
        if (r10.isEmpty() == false) goto L13;
        return EMPTY;
    L13:
        return balancedConcat(r10.iterator(), r10.size());
    L8:
        r10 = (Collection) r5;
        goto L10
    }
}
