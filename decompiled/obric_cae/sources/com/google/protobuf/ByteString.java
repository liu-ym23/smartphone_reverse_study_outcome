package com.google.protobuf;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
@CheckReturnValue
public abstract class ByteString implements Iterable<Byte>, Serializable {
    static final int CONCATENATE_BY_COPY_SIZE = 128;
    public static final ByteString EMPTY = null;
    static final int MAX_READ_FROM_CHUNK_SIZE = 8192;
    static final int MIN_READ_FROM_CHUNK_SIZE = 256;
    private static final int UNSIGNED_BYTE_MASK = 255;
    private static final Comparator<ByteString> UNSIGNED_LEXICOGRAPHICAL_COMPARATOR = null;
    private static final ByteArrayCopier byteArrayCopier = null;
    private static final long serialVersionUID = 1;
    private int hash;

    public static abstract class AbstractByteIterator implements ByteIterator {
        public AbstractByteIterator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public final Byte next() {
            return Byte.valueOf(nextByte());
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Byte next() {
            return next();
        }
    }

    public static final class ArraysByteArrayCopier implements ByteArrayCopier {
        private ArraysByteArrayCopier() {
        }

        public /* synthetic */ ArraysByteArrayCopier(AnonymousClass1 r8) {
            this();
        }

        @Override // com.google.protobuf.ByteString.ByteArrayCopier
        public byte[] copyFrom(byte[] r8, int r10, int r11) {
            return Arrays.copyOfRange(r8, r10, r11 + r10);
        }
    }

    public static final class BoundedByteString extends LiteralByteString {
        private static final long serialVersionUID = 1;
        private final int bytesLength;
        private final int bytesOffset;

        public BoundedByteString(byte[] r8, int r10, int r11) {
            super(r8);
            ByteString.checkRange(r10, r10 + r11, r8.length);
            this.bytesOffset = r10;
            this.bytesLength = r11;
        }

        private void readObject(ObjectInputStream r8) {
            throw new InvalidObjectException("BoundedByteStream instances are not to be serialized directly");
        }

        @Override // com.google.protobuf.ByteString.LiteralByteString, com.google.protobuf.ByteString
        public byte byteAt(int r8) {
            ByteString.checkIndex(r8, size());
            return this.bytes[this.bytesOffset + r8];
        }

        @Override // com.google.protobuf.ByteString.LiteralByteString, com.google.protobuf.ByteString
        public void copyToInternal(byte[] r8, int r10, int r11, int r12) {
            System.arraycopy(this.bytes, getOffsetIntoBytes() + r10, r8, r11, r12);
        }

        @Override // com.google.protobuf.ByteString.LiteralByteString
        public int getOffsetIntoBytes() {
            return this.bytesOffset;
        }

        @Override // com.google.protobuf.ByteString.LiteralByteString, com.google.protobuf.ByteString
        public byte internalByteAt(int r8) {
            return this.bytes[this.bytesOffset + r8];
        }

        @Override // com.google.protobuf.ByteString.LiteralByteString, com.google.protobuf.ByteString
        public int size() {
            return this.bytesLength;
        }

        public Object writeReplace() {
            return ByteString.wrap(toByteArray());
        }
    }

    public interface ByteArrayCopier {
        byte[] copyFrom(byte[] r8, int r10, int r11);
    }

    public interface ByteIterator extends Iterator<Byte> {
        byte nextByte();
    }

    public static final class CodedBuilder {
        private final byte[] buffer;
        private final CodedOutputStream output;

        private CodedBuilder(int r8) {
            byte[] r10 = new byte[r8];
            this.buffer = r10;
            this.output = CodedOutputStream.newInstance(r10);
        }

        public ByteString build() {
            this.output.checkNoSpaceLeft();
            return new LiteralByteString(this.buffer);
        }

        public CodedOutputStream getCodedOutput() {
            return this.output;
        }

        public /* synthetic */ CodedBuilder(int r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public static abstract class LeafByteString extends ByteString {
        private static final long serialVersionUID = 1;

        private LeafByteString() {
        }

        public /* synthetic */ LeafByteString(AnonymousClass1 r8) {
            this();
        }

        public abstract boolean equalsRange(ByteString r8, int r10, int r11);

        @Override // com.google.protobuf.ByteString
        public final int getTreeDepth() {
            return 0;
        }

        @Override // com.google.protobuf.ByteString
        public final boolean isBalanced() {
            return true;
        }

        @Override // com.google.protobuf.ByteString, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator<Byte> iterator() {
            return super.iterator();
        }

        @Override // com.google.protobuf.ByteString
        public void writeToReverse(ByteOutput r8) {
            writeTo(r8);
        }
    }

    public static class LiteralByteString extends LeafByteString {
        private static final long serialVersionUID = 1;
        protected final byte[] bytes;

        public LiteralByteString(byte[] r8) {
            super(null);
            if (r8 == null) goto L6;
            this.bytes = r8;
            return;
        L6:
            throw null;
        }

        @Override // com.google.protobuf.ByteString
        public final ByteBuffer asReadOnlyByteBuffer() {
            return ByteBuffer.wrap(this.bytes, getOffsetIntoBytes(), size()).asReadOnlyBuffer();
        }

        @Override // com.google.protobuf.ByteString
        public final List<ByteBuffer> asReadOnlyByteBufferList() {
            return Collections.singletonList(asReadOnlyByteBuffer());
        }

        @Override // com.google.protobuf.ByteString
        public byte byteAt(int r8) {
            return this.bytes[r8];
        }

        @Override // com.google.protobuf.ByteString
        public final void copyTo(ByteBuffer r8) {
            r8.put(this.bytes, getOffsetIntoBytes(), size());
        }

        @Override // com.google.protobuf.ByteString
        public void copyToInternal(byte[] r8, int r10, int r11, int r12) {
            System.arraycopy(this.bytes, r10, r8, r11, r12);
        }

        @Override // com.google.protobuf.ByteString
        public final boolean equals(Object r8) {
            if (r8 != this) goto L6;
            return true;
        L6:
            if ((r8 instanceof ByteString) == true) goto L9;
            return false;
        L9:
            if (size() == ((ByteString) r8).size()) goto L12;
            return false;
        L12:
            if (size() != 0) goto L15;
            return true;
        L15:
            if ((r8 instanceof LiteralByteString) == false) goto L24;
            LiteralByteString r10 = (LiteralByteString) r8;
            int r11 = peekCachedHashCode();
            int r12 = r10.peekCachedHashCode();
            if (r11 == 0) goto L22;
            if (r12 == 0) goto L22;
            if (r11 == r12) goto L22;
            return false;
        L22:
            return equalsRange(r10, 0, size());
        L24:
            return r8.equals(this);
        }

        @Override // com.google.protobuf.ByteString.LeafByteString
        public final boolean equalsRange(ByteString r8, int r10, int r11) {
            if (r11 > r8.size()) goto L21;
            int r12 = r10 + r11;
            if (r12 <= r8.size()) goto L7;
            StringBuilder r13 = defpackage.a.g("Ran off end of other: ", r10, ", ", r11, ", ");
            r13.append(r8.size());
            throw new IllegalArgumentException(r13.toString());
        L7:
            if ((r8 instanceof LiteralByteString) == false) goto L17;
            LiteralByteString r14 = (LiteralByteString) r8;
            byte[] r15 = this.bytes;
            byte[] r16 = r14.bytes;
            int r17 = getOffsetIntoBytes() + r11;
            int r18 = getOffsetIntoBytes();
            int r19 = r14.getOffsetIntoBytes() + r10;
        L9:
            if (r18 >= r17) goto L14;
            if (r15[r18] != r16[r19]) goto L12;
            r18 = r18 + 1;
            r19 = r19 + 1;
            goto L9
        L12:
            return false;
        L14:
            return true;
        L17:
            return r8.substring(r10, r12).equals(substring(0, r11));
        L21:
            throw new IllegalArgumentException("Length too large: " + r11 + size());
        }

        public int getOffsetIntoBytes() {
            return 0;
        }

        @Override // com.google.protobuf.ByteString
        public byte internalByteAt(int r8) {
            return this.bytes[r8];
        }

        @Override // com.google.protobuf.ByteString
        public final boolean isValidUtf8() {
            int r8 = getOffsetIntoBytes();
            return Utf8.isValidUtf8(this.bytes, r8, size() + r8);
        }

        @Override // com.google.protobuf.ByteString
        public final CodedInputStream newCodedInput() {
            return CodedInputStream.newInstance(this.bytes, getOffsetIntoBytes(), size(), true);
        }

        @Override // com.google.protobuf.ByteString
        public final InputStream newInput() {
            return new ByteArrayInputStream(this.bytes, getOffsetIntoBytes(), size());
        }

        @Override // com.google.protobuf.ByteString
        public final int partialHash(int r8, int r10, int r11) {
            return Internal.partialHash(r8, this.bytes, getOffsetIntoBytes() + r10, r11);
        }

        @Override // com.google.protobuf.ByteString
        public final int partialIsValidUtf8(int r8, int r10, int r11) {
            int r12 = getOffsetIntoBytes() + r10;
            return Utf8.partialIsValidUtf8(r8, this.bytes, r12, r11 + r12);
        }

        @Override // com.google.protobuf.ByteString
        public int size() {
            return this.bytes.length;
        }

        @Override // com.google.protobuf.ByteString
        public final ByteString substring(int r8, int r10) {
            int r11 = ByteString.checkRange(r8, r10, size());
            if (r11 != 0) goto L7;
            return ByteString.EMPTY;
        L7:
            return new BoundedByteString(this.bytes, getOffsetIntoBytes() + r8, r11);
        }

        @Override // com.google.protobuf.ByteString
        public final String toStringInternal(Charset r8) {
            return new String(this.bytes, getOffsetIntoBytes(), size(), r8);
        }

        @Override // com.google.protobuf.ByteString
        public final void writeTo(ByteOutput r8) {
            r8.writeLazy(this.bytes, getOffsetIntoBytes(), size());
        }

        @Override // com.google.protobuf.ByteString
        public final void writeToInternal(OutputStream r8, int r10, int r11) {
            r8.write(this.bytes, getOffsetIntoBytes() + r10, r11);
        }

        @Override // com.google.protobuf.ByteString
        public final void writeTo(OutputStream r8) {
            r8.write(toByteArray());
        }
    }

    public static final class NioByteString extends LeafByteString {
        private final ByteBuffer buffer;

        public NioByteString(ByteBuffer r8) {
            super(null);
            Internal.checkNotNull(r8, "buffer");
            this.buffer = r8.slice().order(ByteOrder.nativeOrder());
        }

        public static /* synthetic */ ByteBuffer access$500(NioByteString r8) {
            return r8.buffer;
        }

        private void readObject(ObjectInputStream r8) {
            throw new InvalidObjectException("NioByteString instances are not to be serialized directly");
        }

        private ByteBuffer slice(int r8, int r10) {
            if (r8 < this.buffer.position()) goto L10;
            if (r10 > this.buffer.limit()) goto L10;
            if (r8 > r10) goto L10;
            ByteBuffer r11 = this.buffer.slice();
            Java8Compatibility.position(r11, r8 - this.buffer.position());
            Java8Compatibility.limit(r11, r10 - this.buffer.position());
            return r11;
        L10:
            throw new IllegalArgumentException(String.format("Invalid indices [%d, %d]", new Object[]{Integer.valueOf(r8), Integer.valueOf(r10)}));
        }

        private Object writeReplace() {
            return ByteString.copyFrom(this.buffer.slice());
        }

        @Override // com.google.protobuf.ByteString
        public ByteBuffer asReadOnlyByteBuffer() {
            return this.buffer.asReadOnlyBuffer();
        }

        @Override // com.google.protobuf.ByteString
        public List<ByteBuffer> asReadOnlyByteBufferList() {
            return Collections.singletonList(asReadOnlyByteBuffer());
        }

        @Override // com.google.protobuf.ByteString
        public byte byteAt(int r8) {
            return this.buffer.get(r8);
        L7:
            e = move-exception;
            throw e;
        L4:
            e = move-exception;
            throw new ArrayIndexOutOfBoundsException(e.getMessage());
        }

        @Override // com.google.protobuf.ByteString
        public void copyTo(ByteBuffer r8) {
            r8.put(this.buffer.slice());
        }

        @Override // com.google.protobuf.ByteString
        public void copyToInternal(byte[] r8, int r10, int r11, int r12) {
            ByteBuffer r13 = this.buffer.slice();
            Java8Compatibility.position(r13, r10);
            r13.get(r8, r11, r12);
        }

        @Override // com.google.protobuf.ByteString
        public boolean equals(Object r8) {
            if (r8 != this) goto L6;
            return true;
        L6:
            if ((r8 instanceof ByteString) == true) goto L8;
            return false;
        L8:
            ByteString r10 = (ByteString) r8;
            if (size() == r10.size()) goto L12;
            return false;
        L12:
            if (size() != 0) goto L15;
            return true;
        L15:
            if ((r8 instanceof NioByteString) == false) goto L20;
            ByteBuffer r11 = this.buffer;
            ByteBuffer r12 = ((NioByteString) r8).buffer;
        L18:
            return r11.equals(r12);
        L20:
            if ((r8 instanceof RopeByteString) == true) goto L22;
            r11 = this.buffer;
            r12 = r10.asReadOnlyByteBuffer();
            goto L18
        L22:
            return r8.equals(this);
        }

        @Override // com.google.protobuf.ByteString.LeafByteString
        public boolean equalsRange(ByteString r8, int r10, int r11) {
            return substring(0, r11).equals(r8.substring(r10, r11 + r10));
        }

        @Override // com.google.protobuf.ByteString
        public byte internalByteAt(int r8) {
            return byteAt(r8);
        }

        @Override // com.google.protobuf.ByteString
        public boolean isValidUtf8() {
            return Utf8.isValidUtf8(this.buffer);
        }

        @Override // com.google.protobuf.ByteString
        public CodedInputStream newCodedInput() {
            return CodedInputStream.newInstance(this.buffer, true);
        }

        @Override // com.google.protobuf.ByteString
        public InputStream newInput() {
            return new AnonymousClass1(this);
        }

        @Override // com.google.protobuf.ByteString
        public int partialHash(int r8, int r10, int r11) {
            int r12 = r10;
        L4:
            if (r12 >= (r10 + r11)) goto L6;
            r8 = (r8 * 31) + this.buffer.get(r12);
            r12 = r12 + 1;
            goto L4
        L6:
            return r8;
        }

        @Override // com.google.protobuf.ByteString
        public int partialIsValidUtf8(int r8, int r10, int r11) {
            return Utf8.partialIsValidUtf8(r8, this.buffer, r10, r11 + r10);
        }

        @Override // com.google.protobuf.ByteString
        public int size() {
            return this.buffer.remaining();
        }

        @Override // com.google.protobuf.ByteString
        public ByteString substring(int r8, int r10) {
            return new NioByteString(slice(r8, r10));
        L7:
            e = move-exception;
            throw e;
        L4:
            e = move-exception;
            throw new ArrayIndexOutOfBoundsException(e.getMessage());
        }

        @Override // com.google.protobuf.ByteString
        public String toStringInternal(Charset r8) {
            if (this.buffer.hasArray() == false) goto L5;
            byte[] r10 = this.buffer.array();
            int r11 = this.buffer.arrayOffset();
            int r12 = this.buffer.position() + r11;
            int r13 = this.buffer.remaining();
        L7:
            return new String(r10, r12, r13, r8);
        L5:
            r10 = toByteArray();
            r13 = r10.length;
            r12 = 0;
            goto L7
        }

        @Override // com.google.protobuf.ByteString
        public void writeTo(ByteOutput r8) {
            r8.writeLazy(this.buffer.slice());
        }

        @Override // com.google.protobuf.ByteString
        public void writeToInternal(OutputStream r8, int r10, int r11) {
            if (this.buffer.hasArray() == false) goto L6;
            int r12 = this.buffer.arrayOffset();
            int r13 = (this.buffer.position() + r12) + r10;
            r8.write(this.buffer.array(), r13, r11);
            return;
        L6:
            ByteBufferWriter.write(slice(r10, r11 + r10), r8);
        }

        @Override // com.google.protobuf.ByteString
        public void writeTo(OutputStream r8) {
            r8.write(toByteArray());
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

        public Output(int r8) {
            if (r8 < 0) goto L7;
            this.initialCapacity = r8;
            this.flushedBuffers = new ArrayList();
            this.buffer = new byte[r8];
            return;
        L7:
            throw new IllegalArgumentException("Buffer size < 0");
        }

        private void flushFullBuffer(int r8) {
            this.flushedBuffers.add(new LiteralByteString(this.buffer));
            int r10 = this.flushedBuffersTotalBytes + this.buffer.length;
            this.flushedBuffersTotalBytes = r10;
            this.buffer = new byte[Math.max(this.initialCapacity, Math.max(r8, r10 >>> 1))];
            this.bufferPos = 0;
        }

        private void flushLastBuffer() {
            int r8 = this.bufferPos;
            byte[] r10 = this.buffer;
            if (r8 >= r10.length) goto L6;
            if (r8 <= 0) goto L7;
            this.flushedBuffers.add(new LiteralByteString(Arrays.copyOf(r10, r8)));
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
            int r8 = this.flushedBuffersTotalBytes + this.bufferPos;
            monitor-exit(this);
            return r8;
        L7:
            th = move-exception;
            throw th;
        }

        public synchronized ByteString toByteString() {
            monitor-enter(this);
            flushLastBuffer();     // Catch: Throwable -> L6
            ByteString r8 = ByteString.copyFrom(this.flushedBuffers);     // Catch: Throwable -> L6
            monitor-exit(this);
            return r8;
        L6:
            th = move-exception;
            throw th;
        }

        public String toString() {
            return String.format("<ByteString.Output@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size())});
        }

        @Override // java.io.OutputStream
        public synchronized void write(int r8) {
            monitor-enter(this);
        L9:
            th = move-exception;
            throw th;
        L4:
            if (this.bufferPos != this.buffer.length) goto L6;
            flushFullBuffer(1);     // Catch: Throwable -> L9
        L6:
            byte[] r10 = this.buffer;     // Catch: Throwable -> L9
            int r11 = this.bufferPos;     // Catch: Throwable -> L9
            this.bufferPos = r11 + 1;     // Catch: Throwable -> L9
            r10[r11] = (byte) r8;     // Catch: Throwable -> L9
            monitor-exit(this);
        }

        public void writeTo(OutputStream r8) {
            monitor-enter(this);
            int r10 = 0;
            ByteString[] r11 = (ByteString[]) this.flushedBuffers.toArray(new ByteString[0]);     // Catch: Throwable -> L10
            byte[] r12 = this.buffer;     // Catch: Throwable -> L10
            int r13 = this.bufferPos;     // Catch: Throwable -> L10
            monitor-exit(this);     // Catch: Throwable -> L10
            int r14 = r11.length;
        L6:
            if (r10 >= r14) goto L8;
            r11[r10].writeTo(r8);
            r10 = r10 + 1;
            goto L6
        L8:
            r8.write(Arrays.copyOf(r12, r13));
            return;
        L10:
            th = move-exception;
            throw th;
        }

        @Override // java.io.OutputStream
        public synchronized void write(byte[] r8, int r10, int r11) {
            monitor-enter(this);
            byte[] r12 = this.buffer;     // Catch: Throwable -> L9
            int r13 = r12.length;     // Catch: Throwable -> L9
            int r14 = this.bufferPos;     // Catch: Throwable -> L9
            if (r11 > (r13 - r14)) goto L6;
            System.arraycopy(r8, r10, r12, r14, r11);     // Catch: Throwable -> L9
            this.bufferPos += r11;     // Catch: Throwable -> L9
        L7:
            monitor-exit(this);
            return;
        L6:
            int r15 = r12.length - r14;     // Catch: Throwable -> L9
            System.arraycopy(r8, r10, r12, r14, r15);     // Catch: Throwable -> L9
            int r16 = r11 - r15;     // Catch: Throwable -> L9
            flushFullBuffer(r16);     // Catch: Throwable -> L9
            System.arraycopy(r8, r10 + r15, this.buffer, 0, r16);     // Catch: Throwable -> L9
            this.bufferPos = r16;     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            throw th;
        }
    }

    public static final class SystemByteArrayCopier implements ByteArrayCopier {
        private SystemByteArrayCopier() {
        }

        public /* synthetic */ SystemByteArrayCopier(AnonymousClass1 r8) {
            this();
        }

        @Override // com.google.protobuf.ByteString.ByteArrayCopier
        public byte[] copyFrom(byte[] r8, int r10, int r11) {
            byte[] r12 = new byte[r11];
            System.arraycopy(r8, r10, r12, 0, r11);
            return r12;
        }
    }

    static {
        EMPTY = new LiteralByteString(Internal.EMPTY_BYTE_ARRAY);
        AnonymousClass1 r8 = null;
        if (Android.isOnAndroidDevice() == false) goto L5;
        ByteArrayCopier r10 = new SystemByteArrayCopier(r8);
    L6:
        byteArrayCopier = r10;
        UNSIGNED_LEXICOGRAPHICAL_COMPARATOR = new AnonymousClass2();
        return;
    L5:
        r10 = new ArraysByteArrayCopier(r8);
        goto L6
    }

    public ByteString() {
        this.hash = 0;
    }

    public static /* synthetic */ int access$200(byte r8) {
        return toInt(r8);
    }

    private static ByteString balancedConcat(Iterator<ByteString> r8, int r10) {
        if (r10 < 1) goto L9;
        if (r10 == 1) goto L10;
        int r11 = r10 >>> 1;
        return balancedConcat(r8, r11).concat(balancedConcat(r8, r10 - r11));
    L10:
        return r8.next();
    L9:
        throw new IllegalArgumentException(String.format("length (%s) must be >= 1", new Object[]{Integer.valueOf(r10)}));
    }

    public static void checkIndex(int r8, int r10) {
        if (((r10 - (r8 + 1)) | r8) >= 0) goto L9;
        if (r8 >= 0) goto L8;
        throw new ArrayIndexOutOfBoundsException(defpackage.a.d("Index < 0: ", r8));
    L8:
        throw new ArrayIndexOutOfBoundsException("Index > length: " + r8 + ", " + r10);
    }

    @CanIgnoreReturnValue
    public static int checkRange(int r8, int r10, int r11) {
        int r12 = r10 - r8;
        if ((((r8 | r10) | r12) | (r11 - r10)) >= 0) goto L12;
        if (r8 < 0) goto L11;
        if (r10 >= r8) goto L9;
        throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + r8 + ", " + r10);
    L9:
        throw new IndexOutOfBoundsException("End index: " + r10 + " >= " + r11);
    L11:
        throw new IndexOutOfBoundsException(android.aimedia.a.c("Beginning index: ", r8, " < 0"));
    L12:
        return r12;
    }

    public static ByteString copyFrom(Iterable<ByteString> r8) {
        if ((r8 instanceof Collection) == true) goto L8;
        Iterator<ByteString> r10 = r8.iterator();
        int r11 = 0;
    L6:
        if (r10.hasNext() == false) goto L9;
        r10.next();
        r11 = r11 + 1;
    L9:
        if (r11 != 0) goto L13;
        return EMPTY;
    L13:
        return balancedConcat(r8.iterator(), r11);
    L8:
        r11 = ((Collection) r8).size();
        goto L9
    }

    public static ByteString copyFromUtf8(String r8) {
        return new LiteralByteString(r8.getBytes(Internal.UTF_8));
    }

    public static final ByteString empty() {
        return EMPTY;
    }

    private static int extractHexDigit(String r8, int r10) {
        int r11 = hexDigit(r8.charAt(r10));
        if (r11 == (-1)) goto L5;
        return r11;
    L5:
        StringBuilder r12 = defpackage.b.h("Invalid hexString ", r8, " must only contain [0-9a-fA-F] but contained ");
        r12.append(r8.charAt(r10));
        r12.append(" at index ");
        r12.append(r10);
        throw new NumberFormatException(r12.toString());
    }

    public static ByteString fromHex(@CompileTimeConstant String r8) {
        if ((r8.length() % 2) != 0) goto L9;
        int r10 = r8.length() / 2;
        byte[] r11 = new byte[r10];
        int r12 = 0;
    L5:
        if (r12 >= r10) goto L8;
        int r13 = r12 * 2;
        int r14 = extractHexDigit(r8, r13);
        r11[r12] = (byte) (extractHexDigit(r8, r13 + 1) | (r14 << 4));
        r12 = r12 + 1;
        goto L5
    L8:
        return new LiteralByteString(r11);
    L9:
        StringBuilder r15 = defpackage.b.h("Invalid hexString ", r8, " of length ");
        r15.append(r8.length());
        r15.append(" must be even.");
        throw new NumberFormatException(r15.toString());
    }

    private static int hexDigit(char r8) {
        if (r8 >= '0') goto L5;
    L8:
        char r10 = 'A';
        if (r8 >= 'A') goto L11;
    L14:
        r10 = 'a';
        if (r8 >= 'a') goto L17;
        return -1;
    L17:
        if (r8 <= 'f') goto L13;
        return -1;
    L13:
        return (r8 - r10) + 10;
    L11:
        if (r8 > 'F') goto L14;
    L5:
        if (r8 > '9') goto L8;
        return r8 - '0';
    }

    public static CodedBuilder newCodedBuilder(int r8) {
        return new CodedBuilder(r8, null);
    }

    public static Output newOutput() {
        return new Output(128);
    }

    public static ByteString nioByteString(ByteBuffer r8) {
        return new NioByteString(r8);
    }

    private static ByteString readChunk(InputStream r8, int r10) {
        byte[] r11 = new byte[r10];
        int r12 = 0;
    L3:
        if (r12 >= r10) goto L8;
        int r13 = r8.read(r11, r12, r10 - r12);
        if (r13 == (-1)) goto L8;
        r12 = r12 + r13;
    L8:
        if (r12 != 0) goto L12;
        return null;
    L12:
        return copyFrom(r11, 0, r12);
    }

    public static ByteString readFrom(InputStream r8) {
        return readFrom(r8, 256, 8192);
    }

    private static int toInt(byte r8) {
        return r8 & 255;
    }

    private String truncateAndEscapeForDisplay() {
        if (size() > 50) goto L6;
        return TextFormatEscaper.escapeBytes(this);
    L6:
        return android.aimedia.a.i(new StringBuilder(), TextFormatEscaper.escapeBytes(substring(0, 47)), "...");
    }

    public static Comparator<ByteString> unsignedLexicographicalComparator() {
        return UNSIGNED_LEXICOGRAPHICAL_COMPARATOR;
    }

    public static ByteString wrap(ByteBuffer r8) {
        if (r8.hasArray() == false) goto L7;
        int r10 = r8.arrayOffset();
        return wrap(r8.array(), r8.position() + r10, r8.remaining());
    L7:
        return new NioByteString(r8);
    }

    public abstract ByteBuffer asReadOnlyByteBuffer();

    public abstract List<ByteBuffer> asReadOnlyByteBufferList();

    public abstract byte byteAt(int r8);

    public final ByteString concat(ByteString r8) {
        if ((Integer.MAX_VALUE - size()) < r8.size()) goto L7;
        return RopeByteString.concatenate(this, r8);
    L7:
        throw new IllegalArgumentException("ByteString would be too long: " + size() + "+" + r8.size());
    }

    public abstract void copyTo(ByteBuffer r8);

    public void copyTo(byte[] r8, int r10) {
        copyTo(r8, 0, r10, size());
    }

    public abstract void copyToInternal(byte[] r8, int r10, int r11, int r12);

    public final boolean endsWith(ByteString r8) {
        if (size() >= r8.size()) goto L5;
    L7:
        return false;
    L5:
        if (substring(size() - r8.size()).equals(r8) == false) goto L7;
        return true;
    }

    public abstract boolean equals(Object r8);

    public abstract int getTreeDepth();

    public final int hashCode() {
        int r8 = this.hash;
        if (r8 != 0) goto L8;
        int r10 = size();
        r8 = partialHash(r10, 0, r10);
        if (r8 != 0) goto L7;
        r8 = 1;
    L7:
        this.hash = r8;
    L8:
        return r8;
    }

    public abstract byte internalByteAt(int r8);

    public abstract boolean isBalanced();

    public final boolean isEmpty() {
        if (size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public abstract boolean isValidUtf8();

    @Override // java.lang.Iterable
    public Iterator<Byte> iterator() {
        return new AnonymousClass1(this);
    }

    public abstract CodedInputStream newCodedInput();

    public abstract InputStream newInput();

    public abstract int partialHash(int r8, int r10, int r11);

    public abstract int partialIsValidUtf8(int r8, int r10, int r11);

    public final int peekCachedHashCode() {
        return this.hash;
    }

    public abstract int size();

    public final boolean startsWith(ByteString r8) {
        if (size() >= r8.size()) goto L5;
        return false;
    L5:
        if (substring(0, r8.size()).equals(r8) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public final ByteString substring(int r8) {
        return substring(r8, size());
    }

    public abstract ByteString substring(int r8, int r10);

    public final byte[] toByteArray() {
        int r8 = size();
        if (r8 == 0) goto L5;
        byte[] r10 = new byte[r8];
        copyToInternal(r10, 0, 0, r8);
        return r10;
    L5:
        return Internal.EMPTY_BYTE_ARRAY;
    }

    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()), truncateAndEscapeForDisplay()});
    }

    public abstract String toStringInternal(Charset r8);

    public final String toStringUtf8() {
        return toString(Internal.UTF_8);
    }

    public abstract void writeTo(ByteOutput r8);

    public abstract void writeTo(OutputStream r8);

    public final void writeTo(OutputStream r8, int r10, int r11) {
        checkRange(r10, r10 + r11, size());
        if (r11 <= 0) goto L6;
        writeToInternal(r8, r10, r11);
        return;
    }

    public abstract void writeToInternal(OutputStream r8, int r10, int r11);

    public abstract void writeToReverse(ByteOutput r8);

    public static ByteString copyFrom(String r8, String r10) {
        return new LiteralByteString(r8.getBytes(r10));
    }

    public static Output newOutput(int r8) {
        return new Output(r8);
    }

    public static ByteString readFrom(InputStream r8, int r10) {
        return readFrom(r8, r10, r10);
    }

    public static ByteString wrap(byte[] r8) {
        return new LiteralByteString(r8);
    }

    @Deprecated
    public final void copyTo(byte[] r8, int r10, int r11, int r12) {
        checkRange(r10, r10 + r12, size());
        checkRange(r11, r11 + r12, r8.length);
        if (r12 <= 0) goto L6;
        copyToInternal(r8, r10, r11, r12);
        return;
    }

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: iterator, reason: avoid collision after fix types in other method */
    public /* bridge */ /* synthetic */ Iterator<Byte> iterator2() {
        return iterator();
    }

    public final String toString(String r8) {
        return toString(Charset.forName(r8));
    L4:
        e = move-exception;
        UnsupportedEncodingException r10 = new UnsupportedEncodingException(r8);
        r10.initCause(e);
        throw r10;
    }

    public static ByteString copyFrom(String r8, Charset r10) {
        return new LiteralByteString(r8.getBytes(r10));
    }

    public static ByteString readFrom(InputStream r8, int r10, int r11) {
        ArrayList r12 = new ArrayList();
    L3:
        ByteString r13 = readChunk(r8, r10);
        if (r13 == null) goto L6;
        r12.add(r13);
        r10 = Math.min(r10 * 2, r11);
        goto L3
    L6:
        return copyFrom(r12);
    }

    public static ByteString wrap(byte[] r8, int r10, int r11) {
        return new BoundedByteString(r8, r10, r11);
    }

    public final String toString(Charset r8) {
        if (size() != 0) goto L6;
        return "";
    L6:
        return toStringInternal(r8);
    }

    public static ByteString copyFrom(ByteBuffer r8) {
        return copyFrom(r8, r8.remaining());
    }

    public static ByteString copyFrom(ByteBuffer r8, int r10) {
        checkRange(0, r10, r8.remaining());
        byte[] r11 = new byte[r10];
        r8.get(r11);
        return new LiteralByteString(r11);
    }

    public static ByteString copyFrom(byte[] r8) {
        return copyFrom(r8, 0, r8.length);
    }

    public static ByteString copyFrom(byte[] r8, int r10, int r11) {
        checkRange(r10, r10 + r11, r8.length);
        return new LiteralByteString(byteArrayCopier.copyFrom(r8, r10, r11));
    }
}
