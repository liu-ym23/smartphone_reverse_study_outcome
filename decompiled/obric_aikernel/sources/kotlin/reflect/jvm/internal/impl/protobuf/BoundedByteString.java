package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes3.dex */
class BoundedByteString extends LiteralByteString {
    private final int bytesLength;
    private final int bytesOffset;

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.protobuf.BoundedByteString$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class BoundedByteIterator implements ByteString.ByteIterator {
        private final int limit;
        private int position;
        final /* synthetic */ BoundedByteString this$0;

        private BoundedByteIterator(BoundedByteString r10) {
            this.this$0 = r10;
            int r11 = r10.getOffsetIntoBytes();
            this.position = r11;
            this.limit = r11 + r10.size();
        }

        /* synthetic */ BoundedByteIterator(BoundedByteString r10, AnonymousClass1 r11) {
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
            int r10 = this.position;
            if (r10 >= this.limit) goto L7;
            byte[] r11 = this.this$0.bytes;
            this.position = r10 + 1;
            return r11[r10];
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    BoundedByteString(byte[] r10, int r11, int r12) {
        super(r10);
        if (r11 < 0) goto L13;
        if (r12 >= 0) goto L6;
        StringBuilder r13 = new StringBuilder(29);
        r13.append("Length too small: ");
        r13.append(r11);
        throw new IllegalArgumentException(r13.toString());
    L6:
        if ((((long) r11) + ((long) r12)) > r10.length) goto L9;
        this.bytesOffset = r11;
        this.bytesLength = r12;
        return;
    L9:
        StringBuilder r14 = new StringBuilder(48);
        r14.append("Offset+Length too large: ");
        r14.append(r11);
        r14.append("+");
        r14.append(r12);
        throw new IllegalArgumentException(r14.toString());
    L13:
        StringBuilder r15 = new StringBuilder(29);
        r15.append("Offset too small: ");
        r15.append(r11);
        throw new IllegalArgumentException(r15.toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.LiteralByteString
    public byte byteAt(int r10) {
        if (r10 >= 0) goto L4;
        StringBuilder r11 = new StringBuilder(28);
        r11.append("Index too small: ");
        r11.append(r10);
        throw new ArrayIndexOutOfBoundsException(r11.toString());
    L4:
        if (r10 < size()) goto L6;
        int r12 = size();
        StringBuilder r13 = new StringBuilder(41);
        r13.append("Index too large: ");
        r13.append(r10);
        r13.append(", ");
        r13.append(r12);
        throw new ArrayIndexOutOfBoundsException(r13.toString());
    L6:
        return this.bytes[this.bytesOffset + r10];
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.LiteralByteString, kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    protected void copyToInternal(byte[] r10, int r11, int r12, int r13) {
        System.arraycopy(this.bytes, getOffsetIntoBytes() + r11, r10, r12, r13);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.LiteralByteString
    protected int getOffsetIntoBytes() {
        return this.bytesOffset;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.LiteralByteString, kotlin.reflect.jvm.internal.impl.protobuf.ByteString, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator<Byte> iterator() {
        return iterator2();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.LiteralByteString, kotlin.reflect.jvm.internal.impl.protobuf.ByteString, java.lang.Iterable
    /* JADX INFO: renamed from: iterator, reason: avoid collision after fix types in other method */
    public Iterator<Byte> iterator2() {
        return new BoundedByteIterator(this, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.LiteralByteString, kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public int size() {
        return this.bytesLength;
    }
}
