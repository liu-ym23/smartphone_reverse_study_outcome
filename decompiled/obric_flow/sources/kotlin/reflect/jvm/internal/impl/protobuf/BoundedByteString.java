package kotlin.reflect.jvm.internal.impl.protobuf;

import androidx.constraintlayout.motion.widget.a;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes3.dex */
class BoundedByteString extends LiteralByteString {
    private final int bytesLength;
    private final int bytesOffset;

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.protobuf.BoundedByteString$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class BoundedByteIterator implements ByteString.ByteIterator {
        private final int limit;
        private int position;
        final /* synthetic */ BoundedByteString this$0;

        public /* synthetic */ BoundedByteIterator(BoundedByteString r5, AnonymousClass1 r10) {
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

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString.ByteIterator
        public byte nextByte() {
            int r5 = this.position;
            if (r5 >= this.limit) goto L7;
            byte[] r10 = this.this$0.bytes;
            this.position = r5 + 1;
            return r10[r5];
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private BoundedByteIterator(BoundedByteString r5) {
            this.this$0 = r5;
            int r10 = r5.getOffsetIntoBytes();
            this.position = r10;
            this.limit = r10 + r5.size();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Byte next() {
            return Byte.valueOf(nextByte());
        }
    }

    public BoundedByteString(byte[] r5, int r10, int r11) {
        super(r5);
        if (r10 < 0) goto L14;
        if (r11 < 0) goto L12;
        if ((((long) r10) + ((long) r11)) > r5.length) goto L9;
        this.bytesOffset = r10;
        this.bytesLength = r11;
        return;
    L9:
        StringBuilder r12 = new StringBuilder(48);
        r12.append("Offset+Length too large: ");
        r12.append(r10);
        r12.append("+");
        r12.append(r11);
        throw new IllegalArgumentException(r12.toString());
    L12:
        throw new IllegalArgumentException(a.i(29, "Length too small: ", r10));
    L14:
        throw new IllegalArgumentException(a.i(29, "Offset too small: ", r10));
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.LiteralByteString
    public byte byteAt(int r5) {
        if (r5 < 0) goto L10;
        if (r5 < size()) goto L6;
        int r10 = size();
        StringBuilder r11 = new StringBuilder(41);
        r11.append("Index too large: ");
        r11.append(r5);
        r11.append(", ");
        r11.append(r10);
        throw new ArrayIndexOutOfBoundsException(r11.toString());
    L6:
        return this.bytes[this.bytesOffset + r5];
    L10:
        throw new ArrayIndexOutOfBoundsException(a.i(28, "Index too small: ", r5));
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.LiteralByteString, kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public void copyToInternal(byte[] r5, int r10, int r11, int r12) {
        System.arraycopy(this.bytes, getOffsetIntoBytes() + r10, r5, r11, r12);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.LiteralByteString
    public int getOffsetIntoBytes() {
        return this.bytesOffset;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.LiteralByteString, kotlin.reflect.jvm.internal.impl.protobuf.ByteString, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator<Byte> iterator() {
        return iterator2();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.LiteralByteString, kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public int size() {
        return this.bytesLength;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.LiteralByteString, kotlin.reflect.jvm.internal.impl.protobuf.ByteString, java.lang.Iterable
    /* JADX INFO: renamed from: iterator, reason: avoid collision after fix types in other method */
    public Iterator<Byte> iterator2() {
        return new BoundedByteIterator(this, null);
    }
}
