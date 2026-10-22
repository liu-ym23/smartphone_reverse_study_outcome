package androidx.room.jarjarred.kotlinx.metadata.internal.protobuf;

import ai.j0;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
class LiteralByteString extends ByteString {
    protected final byte[] bytes;
    private int hash;

    /* JADX INFO: renamed from: androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.LiteralByteString$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class LiteralByteIterator implements ByteString.ByteIterator {
        private final int limit;
        private int position;
        final /* synthetic */ LiteralByteString this$0;

        public /* synthetic */ LiteralByteIterator(LiteralByteString r5, AnonymousClass1 r10) {
            this(r5);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.position >= this.limit) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Byte next() {
            return next();
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.ByteString.ByteIterator
        public byte nextByte() {
            byte[] r5 = this.this$0.bytes;     // Catch: ArrayIndexOutOfBoundsException -> L4
            int r10 = this.position;     // Catch: ArrayIndexOutOfBoundsException -> L4
            this.position = r10 + 1;     // Catch: ArrayIndexOutOfBoundsException -> L4
            return r5[r10];
        L4:
            e = move-exception;
            throw new NoSuchElementException(e.getMessage());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private LiteralByteIterator(LiteralByteString r5) {
            this.this$0 = r5;
            this.position = 0;
            this.limit = r5.size();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Byte next() {
            return Byte.valueOf(nextByte());
        }
    }

    public LiteralByteString(byte[] r5) {
        this.hash = 0;
        this.bytes = r5;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.ByteString
    public ByteBuffer asReadOnlyByteBuffer() {
        return ByteBuffer.wrap(this.bytes, getOffsetIntoBytes(), size()).asReadOnlyBuffer();
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.ByteString
    public List<ByteBuffer> asReadOnlyByteBufferList() {
        ArrayList r5 = new ArrayList(1);
        r5.add(asReadOnlyByteBuffer());
        return r5;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.ByteString
    public byte byteAt(int r5) {
        return this.bytes[r5];
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.ByteString
    public void copyTo(ByteBuffer r5) {
        r5.put(this.bytes, getOffsetIntoBytes(), size());
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.ByteString
    public void copyToInternal(byte[] r5, int r10, int r11, int r12) {
        System.arraycopy(this.bytes, r10, r5, r11, r12);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.ByteString
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof ByteString) == true) goto L9;
        return false;
    L9:
        if (size() == ((ByteString) r5).size()) goto L12;
        return false;
    L12:
        if (size() != 0) goto L15;
        return true;
    L15:
        if ((r5 instanceof LiteralByteString) == false) goto L19;
        return equalsRange((LiteralByteString) r5, 0, size());
    L19:
        if ((r5 instanceof RopeByteString) == true) goto L21;
        String r10 = String.valueOf(r5.getClass());
        throw new IllegalArgumentException(j0.q(new StringBuilder(r10.length() + 49), "Has a new type of ByteString been created? Found ", r10));
    L21:
        return r5.equals(this);
    }

    public boolean equalsRange(LiteralByteString r5, int r10, int r11) {
        if (r11 <= r5.size()) goto L5;
        int r12 = size();
        StringBuilder r13 = new StringBuilder(40);
        r13.append("Length too large: ");
        r13.append(r11);
        r13.append(r12);
        throw new IllegalArgumentException(r13.toString());
    L5:
        if ((r10 + r11) > r5.size()) goto L15;
        byte[] r14 = this.bytes;
        byte[] r15 = r5.bytes;
        int r16 = getOffsetIntoBytes() + r11;
        int r17 = getOffsetIntoBytes();
        int r18 = r5.getOffsetIntoBytes() + r10;
    L7:
        if (r17 >= r16) goto L13;
        if (r14[r17] != r15[r18]) goto L10;
        r17 = r17 + 1;
        r18 = r18 + 1;
        goto L7
    L10:
        return false;
    L13:
        return true;
    L15:
        int r19 = r5.size();
        StringBuilder r20 = new StringBuilder(59);
        r20.append("Ran off end of other: ");
        r20.append(r10);
        r20.append(", ");
        r20.append(r11);
        r20.append(", ");
        r20.append(r19);
        throw new IllegalArgumentException(r20.toString());
    }

    public int getOffsetIntoBytes() {
        return 0;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.ByteString
    public int getTreeDepth() {
        return 0;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.ByteString
    public int hashCode() {
        int r5 = this.hash;
        if (r5 != 0) goto L8;
        int r10 = size();
        r5 = partialHash(r10, 0, r10);
        if (r5 != 0) goto L7;
        r5 = 1;
    L7:
        this.hash = r5;
    L8:
        return r5;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.ByteString
    public boolean isBalanced() {
        return true;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.ByteString
    public boolean isValidUtf8() {
        int r5 = getOffsetIntoBytes();
        return Utf8.isValidUtf8(this.bytes, r5, size() + r5);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.ByteString, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator<Byte> iterator() {
        return iterator();
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.ByteString
    public CodedInputStream newCodedInput() {
        return CodedInputStream.newInstance(this);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.ByteString
    public InputStream newInput() {
        return new ByteArrayInputStream(this.bytes, getOffsetIntoBytes(), size());
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.ByteString
    public int partialHash(int r5, int r10, int r11) {
        return hashCode(r5, this.bytes, getOffsetIntoBytes() + r10, r11);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.ByteString
    public int partialIsValidUtf8(int r5, int r10, int r11) {
        int r12 = getOffsetIntoBytes() + r10;
        return Utf8.partialIsValidUtf8(r5, this.bytes, r12, r11 + r12);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.ByteString
    public int peekCachedHashCode() {
        return this.hash;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.ByteString
    public int size() {
        return this.bytes.length;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.ByteString
    public ByteString substring(int r5, int r10) {
        if (r5 >= 0) goto L4;
        StringBuilder r11 = new StringBuilder(32);
        r11.append("Beginning index: ");
        r11.append(r5);
        r11.append(" < 0");
        throw new IndexOutOfBoundsException(r11.toString());
    L4:
        if (r10 > size()) goto L13;
        int r12 = r10 - r5;
        if (r12 < 0) goto L11;
        if (r12 != 0) goto L10;
        return ByteString.EMPTY;
    L10:
        return new BoundedByteString(this.bytes, getOffsetIntoBytes() + r5, r12);
    L11:
        StringBuilder r13 = new StringBuilder(66);
        r13.append("Beginning index larger than ending index: ");
        r13.append(r5);
        r13.append(", ");
        r13.append(r10);
        throw new IndexOutOfBoundsException(r13.toString());
    L13:
        int r14 = size();
        StringBuilder r15 = new StringBuilder(36);
        r15.append("End index: ");
        r15.append(r10);
        r15.append(" > ");
        r15.append(r14);
        throw new IndexOutOfBoundsException(r15.toString());
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.ByteString
    public String toString(String r5) throws UnsupportedEncodingException {
        return new String(this.bytes, getOffsetIntoBytes(), size(), r5);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.ByteString
    public void writeTo(OutputStream r5) throws IOException {
        r5.write(toByteArray());
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.ByteString
    public void writeToInternal(OutputStream r5, int r10, int r11) throws IOException {
        r5.write(this.bytes, getOffsetIntoBytes() + r10, r11);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.ByteString, java.lang.Iterable
    public Iterator<Byte> iterator() {
        return new LiteralByteIterator(this, null);
    }

    public static int hashCode(int r5, byte[] r10, int r11, int r12) {
        int r13 = r11;
    L4:
        if (r13 >= (r11 + r12)) goto L6;
        r5 = (r5 * 31) + r10[r13];
        r13 = r13 + 1;
        goto L4
    L6:
        return r5;
    }

    public static int hashCode(byte[] r5) {
        int r10 = hashCode(r5.length, r5, 0, r5.length);
        if (r10 != 0) goto L6;
        return 1;
    L6:
        return r10;
    }
}
