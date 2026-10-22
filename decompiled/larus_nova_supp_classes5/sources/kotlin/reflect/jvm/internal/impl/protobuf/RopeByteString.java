package kotlin.reflect.jvm.internal.impl.protobuf;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
class RopeByteString extends ByteString {
    private static final int[] minLengthByDepth = null;
    private int hash;
    private final ByteString left;
    private final int leftLength;
    private final ByteString right;
    private final int totalLength;
    private final int treeDepth;

    static {
        ArrayList r0 = new ArrayList();
        int r1 = 1;
        int r2 = 1;
    L3:
        if (r1 <= 0) goto L5;
        r0.add(Integer.valueOf(r1));
        int r3 = r2 + r1;
        r2 = r1;
        r1 = r3;
        goto L3
    L5:
        r0.add(Integer.MAX_VALUE);
        minLengthByDepth = new int[r0.size()];
        int r4 = 0;
    L6:
        int[] r5 = minLengthByDepth;
        if (r4 >= r5.length) goto L9;
        r5[r4] = ((Integer) ListProtector.get(r0, r4)).intValue();
        r4 = r4 + 1;
        goto L6
    }

    public int hashCode() {
        int r0 = this.hash;
        if (r0 != 0) goto L8;
        int r1 = this.totalLength;
        r0 = partialHash(r1, 0, r1);
        if (r0 != 0) goto L7;
        r0 = 1;
    L7:
        this.hash = r0;
    L8:
        return r0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public boolean isBalanced() {
        if (this.totalLength < minLengthByDepth[this.treeDepth]) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public boolean isValidUtf8() {
        int r0 = this.left.partialIsValidUtf8(0, 0, this.leftLength);
        ByteString r1 = this.right;
        if (r1.partialIsValidUtf8(r0, 0, r1.size()) != 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString, java.lang.Iterable
    /* JADX INFO: renamed from: iterator, reason: avoid collision after fix types in other method */
    public Iterator<Byte> iterator2() {
        return new RopeByteIterator(this, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public CodedInputStream newCodedInput() {
        return CodedInputStream.newInstance(new RopeInputStream(this));
    }

    public static /* synthetic */ int[] access$600() {
        return minLengthByDepth;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public int getTreeDepth() {
        return this.treeDepth;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public int peekCachedHashCode() {
        return this.hash;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public int size() {
        return this.totalLength;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator<Byte> iterator() {
        return iterator2();
    }

    public static /* synthetic */ ByteString access$400(RopeByteString r0) {
        return r0.left;
    }

    public static /* synthetic */ ByteString access$500(RopeByteString r0) {
        return r0.right;
    }

    private boolean equalsFragments(ByteString r12) {
        PieceIterator r0 = new PieceIterator(this, null);
        LiteralByteString r2 = (LiteralByteString) r0.next();
        PieceIterator r3 = new PieceIterator(r12, null);
        LiteralByteString r13 = (LiteralByteString) r3.next();
        int r4 = 0;
        int r5 = 0;
        int r6 = 0;
    L3:
        int r7 = r2.size() - r4;
        int r8 = r13.size() - r5;
        int r9 = Math.min(r7, r8);
        if (r4 != 0) goto L6;
        boolean r10 = r2.equalsRange(r13, r5, r9);
    L7:
        if (r10 == false) goto L8;
        r6 = r6 + r9;
        int r11 = this.totalLength;
        if (r6 >= r11) goto L11;
        if (r9 != r7) goto L18;
        r2 = (LiteralByteString) r0.next();
        r4 = 0;
    L19:
        if (r9 == r8) goto L20;
        r5 = r5 + r9;
        goto L3
    L20:
        r13 = (LiteralByteString) r3.next();
        r5 = 0;
        goto L3
    L18:
        r4 = r4 + r9;
        goto L19
    L11:
        if (r6 != r11) goto L15;
        return true;
    L15:
        throw new IllegalStateException();
    L8:
        return false;
    L6:
        r10 = r13.equalsRange(r2, r4, r9);
        goto L7
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof ByteString) == true) goto L8;
        return false;
    L8:
        ByteString r6 = (ByteString) r5;
        if (this.totalLength == r6.size()) goto L12;
        return false;
    L12:
        if (this.totalLength != 0) goto L15;
        return true;
    L15:
        if (this.hash == 0) goto L22;
        int r0 = r6.peekCachedHashCode();
        if (r0 == 0) goto L22;
        if (this.hash == r0) goto L22;
        return false;
    L22:
        return equalsFragments(r6);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public String toString(String r3) throws UnsupportedEncodingException {
        return new String(toByteArray(), r3);
    }

    private RopeByteString(ByteString r3, ByteString r4) {
        this.hash = 0;
        this.left = r3;
        this.right = r4;
        int r0 = r3.size();
        this.leftLength = r0;
        this.totalLength = r0 + r4.size();
        this.treeDepth = Math.max(r3.getTreeDepth(), r4.getTreeDepth()) + 1;
    }

    public static ByteString concatenate(ByteString r6, ByteString r7) {
        if ((r6 instanceof RopeByteString) == false) goto L5;
        RopeByteString r0 = (RopeByteString) r6;
    L7:
        if (r7.size() != 0) goto L10;
        return r6;
    L10:
        if (r6.size() == 0) goto L30;
        int r2 = r6.size() + r7.size();
        if (r2 < 128) goto L31;
        if (r0 != null) goto L17;
    L19:
        if (r0 == null) goto L26;
        if (r0.left.getTreeDepth() <= r0.right.getTreeDepth()) goto L26;
        if (r0.getTreeDepth() <= r7.getTreeDepth()) goto L26;
        r7 = new RopeByteString(r0.left, new RopeByteString(r0.right, r7));
    L26:
        if (r2 < minLengthByDepth[Math.max(r6.getTreeDepth(), r7.getTreeDepth()) + 1]) goto L29;
        return new RopeByteString(r6, r7);
    L29:
        return Balancer.access$100(new Balancer(null), r6, r7);
    L17:
        if ((r0.right.size() + r7.size()) >= 128) goto L19;
        r7 = new RopeByteString(r0.left, concatenateBytes(r0.right, r7));
        goto L30
    L31:
        return concatenateBytes(r6, r7);
    L30:
        return r7;
    L5:
        r0 = null;
        goto L7
    }

    private static LiteralByteString concatenateBytes(ByteString r4, ByteString r5) {
        int r0 = r4.size();
        int r1 = r5.size();
        byte[] r2 = new byte[r0 + r1];
        r4.copyTo(r2, 0, 0, r0);
        r5.copyTo(r2, 0, r0, r1);
        return new LiteralByteString(r2);
    }

    public /* synthetic */ RopeByteString(ByteString r1, ByteString r2, 1 r3) {
        this(r1, r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public int partialHash(int r3, int r4, int r5) {
        int r0 = r4 + r5;
        int r1 = this.leftLength;
        if (r0 <= r1) goto L5;
        if (r4 >= r1) goto L8;
        int r2 = r1 - r4;
        int r6 = this.left.partialHash(r3, r4, r2);
        return this.right.partialHash(r6, 0, r5 - r2);
    L8:
        return this.right.partialHash(r3, r4 - r1, r5);
    L5:
        return this.left.partialHash(r3, r4, r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public int partialIsValidUtf8(int r3, int r4, int r5) {
        int r0 = r4 + r5;
        int r1 = this.leftLength;
        if (r0 <= r1) goto L5;
        if (r4 >= r1) goto L8;
        int r2 = r1 - r4;
        int r6 = this.left.partialIsValidUtf8(r3, r4, r2);
        return this.right.partialIsValidUtf8(r6, 0, r5 - r2);
    L8:
        return this.right.partialIsValidUtf8(r3, r4 - r1, r5);
    L5:
        return this.left.partialIsValidUtf8(r3, r4, r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public void writeToInternal(OutputStream r3, int r4, int r5) throws IOException {
        int r0 = r4 + r5;
        int r1 = this.leftLength;
        if (r0 > r1) goto L5;
        this.left.writeToInternal(r3, r4, r5);
        return;
    L5:
        if (r4 < r1) goto L7;
        this.right.writeToInternal(r3, r4 - r1, r5);
        return;
    L7:
        int r2 = r1 - r4;
        this.left.writeToInternal(r3, r4, r2);
        this.right.writeToInternal(r3, 0, r5 - r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public void copyToInternal(byte[] r3, int r4, int r5, int r6) {
        int r0 = r4 + r6;
        int r1 = this.leftLength;
        if (r0 > r1) goto L5;
        this.left.copyToInternal(r3, r4, r5, r6);
        return;
    L5:
        if (r4 < r1) goto L7;
        this.right.copyToInternal(r3, r4 - r1, r5, r6);
        return;
    L7:
        int r2 = r1 - r4;
        this.left.copyToInternal(r3, r4, r5, r2);
        this.right.copyToInternal(r3, 0, r5 + r2, r6 - r2);
    }
}
