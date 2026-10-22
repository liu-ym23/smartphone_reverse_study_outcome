package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
class LiteralByteString extends ByteString {
    protected final byte[] bytes;
    private int hash;

    public int getOffsetIntoBytes() {
        return 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public int getTreeDepth() {
        return 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public boolean isBalanced() {
        return true;
    }

    public int hashCode() {
        int r0 = this.hash;
        if (r0 != 0) goto L8;
        int r1 = size();
        r0 = partialHash(r1, 0, r1);
        if (r0 != 0) goto L7;
        r0 = 1;
    L7:
        this.hash = r0;
    L8:
        return r0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString, java.lang.Iterable
    /* JADX INFO: renamed from: iterator, reason: avoid collision after fix types in other method */
    public Iterator<Byte> iterator2() {
        return new LiteralByteIterator(this, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public int size() {
        return this.bytes.length;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public boolean isValidUtf8() {
        int r0 = getOffsetIntoBytes();
        return Utf8.isValidUtf8(this.bytes, r0, size() + r0);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public CodedInputStream newCodedInput() {
        return CodedInputStream.newInstance(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public int peekCachedHashCode() {
        return this.hash;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator<Byte> iterator() {
        return iterator2();
    }

    public LiteralByteString(byte[] r2) {
        this.hash = 0;
        this.bytes = r2;
    }

    public byte byteAt(int r2) {
        return this.bytes[r2];
    }

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
        String r6 = String.valueOf(r5.getClass());
        StringBuilder r1 = new StringBuilder(r6.length() + 49);
        r1.append("Has a new type of ByteString been created? Found ");
        r1.append(r6);
        throw new IllegalArgumentException(r1.toString());
    L21:
        return r5.equals(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public String toString(String r5) throws UnsupportedEncodingException {
        return new String(this.bytes, getOffsetIntoBytes(), size(), r5);
    }

    public boolean equalsRange(LiteralByteString r5, int r6, int r7) {
        if (r7 <= r5.size()) goto L5;
        int r8 = size();
        StringBuilder r0 = new StringBuilder(40);
        r0.append("Length too large: ");
        r0.append(r7);
        r0.append(r8);
        throw new IllegalArgumentException(r0.toString());
    L5:
        if ((r6 + r7) > r5.size()) goto L15;
        byte[] r1 = this.bytes;
        byte[] r2 = r5.bytes;
        int r3 = getOffsetIntoBytes() + r7;
        int r9 = getOffsetIntoBytes();
        int r10 = r5.getOffsetIntoBytes() + r6;
    L7:
        if (r9 >= r3) goto L13;
        if (r1[r9] != r2[r10]) goto L10;
        r9 = r9 + 1;
        r10 = r10 + 1;
        goto L7
    L10:
        return false;
    L13:
        return true;
    L15:
        int r11 = r5.size();
        StringBuilder r4 = new StringBuilder(59);
        r4.append("Ran off end of other: ");
        r4.append(r6);
        r4.append(", ");
        r4.append(r7);
        r4.append(", ");
        r4.append(r11);
        throw new IllegalArgumentException(r4.toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public int partialHash(int r3, int r4, int r5) {
        return hashCode(r3, this.bytes, getOffsetIntoBytes() + r4, r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public int partialIsValidUtf8(int r2, int r3, int r4) {
        int r0 = getOffsetIntoBytes() + r3;
        return Utf8.partialIsValidUtf8(r2, this.bytes, r0, r4 + r0);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public void writeToInternal(OutputStream r3, int r4, int r5) throws IOException {
        r3.write(this.bytes, getOffsetIntoBytes() + r4, r5);
    }

    public static int hashCode(int r2, byte[] r3, int r4, int r5) {
        int r0 = r4;
    L4:
        if (r0 >= (r4 + r5)) goto L6;
        r2 = (r2 * 31) + r3[r0];
        r0 = r0 + 1;
        goto L4
    L6:
        return r2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public void copyToInternal(byte[] r2, int r3, int r4, int r5) {
        System.arraycopy(this.bytes, r3, r2, r4, r5);
    }
}
