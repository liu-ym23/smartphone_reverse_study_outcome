package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.OutputStream;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes3.dex */
class LiteralByteString extends ByteString {
    protected final byte[] bytes;
    private int hash;

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.protobuf.LiteralByteString$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class LiteralByteIterator implements ByteString.ByteIterator {
        private final int limit;
        private int position;
        final /* synthetic */ LiteralByteString this$0;

        private LiteralByteIterator(LiteralByteString r10) {
            this.this$0 = r10;
            this.position = 0;
            this.limit = r10.size();
        }

        /* synthetic */ LiteralByteIterator(LiteralByteString r10, AnonymousClass1 r11) {
            this(r10);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.position >= this.limit) goto L5;
            return true;
        L5:
            return false;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Byte next() {
            return Byte.valueOf(nextByte());
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Byte next() {
            return next();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString.ByteIterator
        public byte nextByte() {
            byte[] r10 = this.this$0.bytes;     // Catch: ArrayIndexOutOfBoundsException -> L4
            int r11 = this.position;     // Catch: ArrayIndexOutOfBoundsException -> L4
            this.position = r11 + 1;     // Catch: ArrayIndexOutOfBoundsException -> L4
            return r10[r11];
        L4:
            e = move-exception;
            throw new NoSuchElementException(e.getMessage());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    LiteralByteString(byte[] r10) {
        this.hash = 0;
        this.bytes = r10;
    }

    static int hashCode(int r10, byte[] r11, int r12, int r13) {
        int r14 = r12;
    L4:
        if (r14 >= (r12 + r13)) goto L6;
        r10 = (r10 * 31) + r11[r14];
        r14 = r14 + 1;
        goto L4
    L6:
        return r10;
    }

    public byte byteAt(int r10) {
        return this.bytes[r10];
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    protected void copyToInternal(byte[] r10, int r11, int r12, int r13) {
        System.arraycopy(this.bytes, r11, r10, r12, r13);
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof ByteString) == true) goto L9;
        return false;
    L9:
        if (size() == ((ByteString) r10).size()) goto L12;
        return false;
    L12:
        if (size() != 0) goto L15;
        return true;
    L15:
        if ((r10 instanceof LiteralByteString) == false) goto L19;
        return equalsRange((LiteralByteString) r10, 0, size());
    L19:
        if ((r10 instanceof RopeByteString) == true) goto L21;
        String r11 = String.valueOf(r10.getClass());
        StringBuilder r12 = new StringBuilder(r11.length() + 49);
        r12.append("Has a new type of ByteString been created? Found ");
        r12.append(r11);
        throw new IllegalArgumentException(r12.toString());
    L21:
        return r10.equals(this);
    }

    boolean equalsRange(LiteralByteString r10, int r11, int r12) {
        if (r12 <= r10.size()) goto L5;
        int r13 = size();
        StringBuilder r14 = new StringBuilder(40);
        r14.append("Length too large: ");
        r14.append(r12);
        r14.append(r13);
        throw new IllegalArgumentException(r14.toString());
    L5:
        if ((r11 + r12) > r10.size()) goto L15;
        byte[] r15 = this.bytes;
        byte[] r16 = r10.bytes;
        int r17 = getOffsetIntoBytes() + r12;
        int r18 = getOffsetIntoBytes();
        int r19 = r10.getOffsetIntoBytes() + r11;
    L7:
        if (r18 >= r17) goto L13;
        if (r15[r18] != r16[r19]) goto L10;
        r18 = r18 + 1;
        r19 = r19 + 1;
        goto L7
    L10:
        return false;
    L13:
        return true;
    L15:
        int r20 = r10.size();
        StringBuilder r21 = new StringBuilder(59);
        r21.append("Ran off end of other: ");
        r21.append(r11);
        r21.append(", ");
        r21.append(r12);
        r21.append(", ");
        r21.append(r20);
        throw new IllegalArgumentException(r21.toString());
    }

    protected int getOffsetIntoBytes() {
        return 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    protected int getTreeDepth() {
        return 0;
    }

    public int hashCode() {
        int r10 = this.hash;
        if (r10 != 0) goto L8;
        int r11 = size();
        r10 = partialHash(r11, 0, r11);
        if (r10 != 0) goto L7;
        r10 = 1;
    L7:
        this.hash = r10;
    L8:
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    protected boolean isBalanced() {
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public boolean isValidUtf8() {
        int r10 = getOffsetIntoBytes();
        return Utf8.isValidUtf8(this.bytes, r10, size() + r10);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator<Byte> iterator() {
        return iterator();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString, java.lang.Iterable
    public Iterator<Byte> iterator() {
        return new LiteralByteIterator(this, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public CodedInputStream newCodedInput() {
        return CodedInputStream.newInstance(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    protected int partialHash(int r10, int r11, int r12) {
        return hashCode(r10, this.bytes, getOffsetIntoBytes() + r11, r12);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    protected int partialIsValidUtf8(int r10, int r11, int r12) {
        int r13 = getOffsetIntoBytes() + r11;
        return Utf8.partialIsValidUtf8(r10, this.bytes, r13, r12 + r13);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    protected int peekCachedHashCode() {
        return this.hash;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public int size() {
        return this.bytes.length;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public String toString(String r10) {
        return new String(this.bytes, getOffsetIntoBytes(), size(), r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    void writeToInternal(OutputStream r10, int r11, int r12) {
        r10.write(this.bytes, getOffsetIntoBytes() + r11, r12);
    }
}
