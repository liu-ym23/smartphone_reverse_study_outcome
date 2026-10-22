package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Stack;

/* JADX INFO: loaded from: classes3.dex */
class RopeByteString extends ByteString {
    private static final int[] minLengthByDepth = null;
    private int hash;
    private final ByteString left;
    private final int leftLength;
    private final ByteString right;
    private final int totalLength;
    private final int treeDepth;

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.protobuf.RopeByteString$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class Balancer {
        private final Stack<ByteString> prefixesStack;

        private Balancer() {
            this.prefixesStack = new Stack();
        }

        /* synthetic */ Balancer(AnonymousClass1 r10) {
            this();
        }

        static /* synthetic */ ByteString access$100(Balancer r10, ByteString r11, ByteString r12) {
            return r10.balance(r11, r12);
        }

        private ByteString balance(ByteString r10, ByteString r11) {
            doBalance(r10);
            doBalance(r11);
            ByteString r12 = this.prefixesStack.pop();
        L4:
            if (this.prefixesStack.isEmpty() == true) goto L6;
            r12 = new RopeByteString(this.prefixesStack.pop(), r12, null);
            goto L4
        L6:
            return r12;
        }

        private void doBalance(ByteString r10) {
            if (r10.isBalanced() == false) goto L6;
            insert(r10);
            return;
        L6:
            if ((r10 instanceof RopeByteString) == false) goto L9;
            RopeByteString r11 = (RopeByteString) r10;
            doBalance(RopeByteString.access$400(r11));
            doBalance(RopeByteString.access$500(r11));
            return;
        L9:
            String r12 = String.valueOf(r10.getClass());
            StringBuilder r13 = new StringBuilder(r12.length() + 49);
            r13.append("Has a new type of ByteString been created? Found ");
            r13.append(r12);
            throw new IllegalArgumentException(r13.toString());
        }

        private int getDepthBinForLength(int r10) {
            int r11 = Arrays.binarySearch(RopeByteString.access$600(), r10);
            if (r11 < 0) goto L5;
            return r11;
        L5:
            return (-(r11 + 1)) - 1;
        }

        private void insert(ByteString r10) {
            int r11 = getDepthBinForLength(r10.size());
            int r12 = RopeByteString.access$600()[r11 + 1];
            if (this.prefixesStack.isEmpty() == false) goto L5;
        L20:
            this.prefixesStack.push(r10);
            return;
        L5:
            if (this.prefixesStack.peek().size() >= r12) goto L20;
            int r13 = RopeByteString.access$600()[r11];
            ByteString r14 = this.prefixesStack.pop();
        L8:
            AnonymousClass1 r15 = null;
            if (this.prefixesStack.isEmpty() == true) goto L13;
            if (this.prefixesStack.peek().size() >= r13) goto L13;
            r14 = new RopeByteString(this.prefixesStack.pop(), r14, r15);
        L13:
            RopeByteString r16 = new RopeByteString(r14, r10, r15);
        L15:
            if (this.prefixesStack.isEmpty() == true) goto L19;
            int r17 = getDepthBinForLength(r16.size());
            int r18 = RopeByteString.access$600()[r17 + 1];
            if (this.prefixesStack.peek().size() >= r18) goto L19;
            r16 = new RopeByteString(this.prefixesStack.pop(), r16, r15);
        L19:
            this.prefixesStack.push(r16);
        }
    }

    private static class PieceIterator implements Iterator<LiteralByteString> {
        private final Stack<RopeByteString> breadCrumbs;
        private LiteralByteString next;

        private PieceIterator(ByteString r10) {
            this.breadCrumbs = new Stack();
            this.next = getLeafByLeft(r10);
        }

        /* synthetic */ PieceIterator(ByteString r10, AnonymousClass1 r11) {
            this(r10);
        }

        private LiteralByteString getLeafByLeft(ByteString r10) {
        L3:
            if ((r10 instanceof RopeByteString) == false) goto L6;
            RopeByteString r11 = (RopeByteString) r10;
            this.breadCrumbs.push(r11);
            r10 = RopeByteString.access$400(r11);
            goto L3
        L6:
            return (LiteralByteString) r10;
        }

        private LiteralByteString getNextNonEmptyLeaf() {
        L3:
            if (this.breadCrumbs.isEmpty() == true) goto L4;
            LiteralByteString r10 = getLeafByLeft(RopeByteString.access$500(this.breadCrumbs.pop()));
            if (r10.isEmpty() == true) goto L3;
            return r10;
        L4:
            return null;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.next == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ LiteralByteString next() {
            return next2();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: next, reason: avoid collision after fix types in other method */
        public LiteralByteString next2() {
            LiteralByteString r10 = this.next;
            if (r10 == null) goto L7;
            this.next = getNextNonEmptyLeaf();
            return r10;
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class RopeByteIterator implements ByteString.ByteIterator {
        private ByteString.ByteIterator bytes;
        int bytesRemaining;
        private final PieceIterator pieces;
        final /* synthetic */ RopeByteString this$0;

        /* JADX WARN: Type inference failed for: r0v2, types: [kotlin.reflect.jvm.internal.impl.protobuf.ByteString$ByteIterator] */
        private RopeByteIterator(RopeByteString r10) {
            this.this$0 = r10;
            PieceIterator r11 = new PieceIterator(r10, null);
            this.pieces = r11;
            this.bytes = r11.next2().iterator();
            this.bytesRemaining = r10.size();
        }

        /* synthetic */ RopeByteIterator(RopeByteString r10, AnonymousClass1 r11) {
            this(r10);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.bytesRemaining <= 0) goto L5;
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

        /* JADX WARN: Type inference failed for: r0v6, types: [kotlin.reflect.jvm.internal.impl.protobuf.ByteString$ByteIterator] */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString.ByteIterator
        public byte nextByte() {
            if (this.bytes.hasNext() == true) goto L5;
            this.bytes = this.pieces.next2().iterator();
        L5:
            this.bytesRemaining--;
            return this.bytes.nextByte();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class RopeInputStream extends InputStream {
        private LiteralByteString currentPiece;
        private int currentPieceIndex;
        private int currentPieceOffsetInRope;
        private int currentPieceSize;
        private int mark;
        private PieceIterator pieceIterator;
        final /* synthetic */ RopeByteString this$0;

        public RopeInputStream(RopeByteString r10) {
            this.this$0 = r10;
            initialize();
        }

        private void advanceIfCurrentPieceFullyRead() {
            if (this.currentPiece == null) goto L12;
            int r10 = this.currentPieceIndex;
            int r11 = this.currentPieceSize;
            if (r10 != r11) goto L13;
            this.currentPieceOffsetInRope += r11;
            int r12 = 0;
            this.currentPieceIndex = 0;
            if (this.pieceIterator.hasNext() == false) goto L9;
            LiteralByteString r13 = this.pieceIterator.next2();
            this.currentPiece = r13;
            r12 = r13.size();
        L10:
            this.currentPieceSize = r12;
            return;
        L9:
            this.currentPiece = null;
            goto L10
        L13:
            return;
        }

        private void initialize() {
            PieceIterator r10 = new PieceIterator(this.this$0, null);
            this.pieceIterator = r10;
            LiteralByteString r11 = r10.next2();
            this.currentPiece = r11;
            this.currentPieceSize = r11.size();
            this.currentPieceIndex = 0;
            this.currentPieceOffsetInRope = 0;
        }

        private int readSkipInternal(byte[] r10, int r11, int r12) {
            int r13 = r12;
        L3:
            if (r13 <= 0) goto L14;
            advanceIfCurrentPieceFullyRead();
            if (this.currentPiece == null) goto L6;
            int r14 = Math.min(this.currentPieceSize - this.currentPieceIndex, r13);
            if (r10 == null) goto L12;
            this.currentPiece.copyTo(r10, this.currentPieceIndex, r11, r14);
            r11 = r11 + r14;
        L12:
            this.currentPieceIndex += r14;
            r13 = r13 - r14;
            goto L3
        L6:
            if (r13 != r12) goto L14;
            return -1;
        L14:
            return r12 - r13;
        }

        @Override // java.io.InputStream
        public int available() {
            int r10 = this.currentPieceOffsetInRope + this.currentPieceIndex;
            return this.this$0.size() - r10;
        }

        @Override // java.io.InputStream
        public void mark(int r10) {
            this.mark = this.currentPieceOffsetInRope + this.currentPieceIndex;
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public int read() {
            advanceIfCurrentPieceFullyRead();
            LiteralByteString r10 = this.currentPiece;
            if (r10 != null) goto L6;
            return -1;
        L6:
            int r11 = this.currentPieceIndex;
            this.currentPieceIndex = r11 + 1;
            return r10.byteAt(r11) & 255;
        }

        @Override // java.io.InputStream
        public int read(byte[] r10, int r11, int r12) {
            Objects.requireNonNull(r10);
            if (r11 < 0) goto L10;
            if (r12 < 0) goto L10;
            if (r12 > (r10.length - r11)) goto L10;
            return readSkipInternal(r10, r11, r12);
        L10:
            throw new IndexOutOfBoundsException();
        }

        @Override // java.io.InputStream
        public synchronized void reset() {
            monitor-enter(this);
            initialize();     // Catch: Throwable -> L6
            readSkipInternal(null, 0, this.mark);     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        @Override // java.io.InputStream
        public long skip(long r10) {
            if (r10 < 0) goto L10;
            if (r10 <= 2147483647L) goto L8;
            r10 = 2147483647L;
        L8:
            return readSkipInternal(null, 0, (int) r10);
        L10:
            throw new IndexOutOfBoundsException();
        }
    }

    static {
        ArrayList r10 = new ArrayList();
        int r11 = 1;
        int r12 = 1;
    L3:
        if (r11 <= 0) goto L5;
        r10.add(Integer.valueOf(r11));
        int r13 = r12 + r11;
        r12 = r11;
        r11 = r13;
        goto L3
    L5:
        r10.add(Integer.MAX_VALUE);
        minLengthByDepth = new int[r10.size()];
        int r14 = 0;
    L6:
        int[] r15 = minLengthByDepth;
        if (r14 >= r15.length) goto L9;
        r15[r14] = ((Integer) r10.get(r14)).intValue();
        r14 = r14 + 1;
        goto L6
    }

    private RopeByteString(ByteString r10, ByteString r11) {
        this.hash = 0;
        this.left = r10;
        this.right = r11;
        int r12 = r10.size();
        this.leftLength = r12;
        this.totalLength = r12 + r11.size();
        this.treeDepth = Math.max(r10.getTreeDepth(), r11.getTreeDepth()) + 1;
    }

    /* synthetic */ RopeByteString(ByteString r10, ByteString r11, AnonymousClass1 r12) {
        this(r10, r11);
    }

    static /* synthetic */ ByteString access$400(RopeByteString r10) {
        return r10.left;
    }

    static /* synthetic */ ByteString access$500(RopeByteString r10) {
        return r10.right;
    }

    static /* synthetic */ int[] access$600() {
        return minLengthByDepth;
    }

    static ByteString concatenate(ByteString r10, ByteString r11) {
        AnonymousClass1 r12 = null;
        if ((r10 instanceof RopeByteString) == false) goto L5;
        RopeByteString r13 = (RopeByteString) r10;
    L7:
        if (r11.size() != 0) goto L10;
        return r10;
    L10:
        if (r10.size() == 0) goto L30;
        int r14 = r10.size() + r11.size();
        if (r14 < 128) goto L31;
        if (r13 != null) goto L17;
    L19:
        if (r13 == null) goto L26;
        if (r13.left.getTreeDepth() <= r13.right.getTreeDepth()) goto L26;
        if (r13.getTreeDepth() <= r11.getTreeDepth()) goto L26;
        r11 = new RopeByteString(r13.left, new RopeByteString(r13.right, r11));
    L26:
        if (r14 < minLengthByDepth[Math.max(r10.getTreeDepth(), r11.getTreeDepth()) + 1]) goto L29;
        return new RopeByteString(r10, r11);
    L29:
        return Balancer.access$100(new Balancer(r12), r10, r11);
    L17:
        if ((r13.right.size() + r11.size()) >= 128) goto L19;
        r11 = new RopeByteString(r13.left, concatenateBytes(r13.right, r11));
        goto L30
    L31:
        return concatenateBytes(r10, r11);
    L30:
        return r11;
    L5:
        r13 = null;
        goto L7
    }

    private static LiteralByteString concatenateBytes(ByteString r10, ByteString r11) {
        int r12 = r10.size();
        int r13 = r11.size();
        byte[] r14 = new byte[r12 + r13];
        r10.copyTo(r14, 0, 0, r12);
        r11.copyTo(r14, 0, r12, r13);
        return new LiteralByteString(r14);
    }

    private boolean equalsFragments(ByteString r12) {
        AnonymousClass1 r10 = null;
        PieceIterator r11 = new PieceIterator(this, r10);
        LiteralByteString r13 = r11.next();
        PieceIterator r14 = new PieceIterator(r12, r10);
        LiteralByteString r15 = r14.next();
        int r16 = 0;
        int r17 = 0;
        int r18 = 0;
    L3:
        int r19 = r13.size() - r16;
        int r20 = r15.size() - r17;
        int r21 = Math.min(r19, r20);
        if (r16 != 0) goto L6;
        boolean r110 = r13.equalsRange(r15, r17, r21);
    L7:
        if (r110 == false) goto L8;
        r18 = r18 + r21;
        int r111 = this.totalLength;
        if (r18 >= r111) goto L11;
        if (r21 != r19) goto L18;
        r13 = r11.next();
        r16 = 0;
    L19:
        if (r21 == r20) goto L20;
        r17 = r17 + r21;
        goto L3
    L20:
        r15 = r14.next();
        r17 = 0;
        goto L3
    L18:
        r16 = r16 + r21;
        goto L19
    L11:
        if (r18 != r111) goto L15;
        return true;
    L15:
        throw new IllegalStateException();
    L8:
        return false;
    L6:
        r110 = r15.equalsRange(r13, r16, r21);
        goto L7
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    protected void copyToInternal(byte[] r10, int r11, int r12, int r13) {
        int r14 = r11 + r13;
        int r15 = this.leftLength;
        if (r14 > r15) goto L6;
        ByteString r16 = this.left;
    L5:
        r16.copyToInternal(r10, r11, r12, r13);
        return;
    L6:
        if (r11 < r15) goto L8;
        r16 = this.right;
        r11 = r11 - r15;
        goto L5
    L8:
        int r17 = r15 - r11;
        this.left.copyToInternal(r10, r11, r12, r17);
        r16 = this.right;
        r11 = 0;
        r12 = r12 + r17;
        r13 = r13 - r17;
        goto L5
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof ByteString) == true) goto L8;
        return false;
    L8:
        ByteString r11 = (ByteString) r10;
        if (this.totalLength == r11.size()) goto L12;
        return false;
    L12:
        if (this.totalLength != 0) goto L15;
        return true;
    L15:
        if (this.hash == 0) goto L22;
        int r12 = r11.peekCachedHashCode();
        if (r12 == 0) goto L22;
        if (this.hash == r12) goto L22;
        return false;
    L22:
        return equalsFragments(r11);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    protected int getTreeDepth() {
        return this.treeDepth;
    }

    public int hashCode() {
        int r10 = this.hash;
        if (r10 != 0) goto L8;
        int r11 = this.totalLength;
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
        if (this.totalLength < minLengthByDepth[this.treeDepth]) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public boolean isValidUtf8() {
        int r10 = this.left.partialIsValidUtf8(0, 0, this.leftLength);
        ByteString r11 = this.right;
        if (r11.partialIsValidUtf8(r10, 0, r11.size()) != 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator<Byte> iterator() {
        return iterator2();
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

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    protected int partialHash(int r10, int r11, int r12) {
        int r13 = r11 + r12;
        int r14 = this.leftLength;
        if (r13 > r14) goto L7;
        ByteString r15 = this.left;
    L6:
        return r15.partialHash(r10, r11, r12);
    L7:
        if (r11 < r14) goto L9;
        r15 = this.right;
        r11 = r11 - r14;
        goto L6
    L9:
        int r16 = r14 - r11;
        r10 = this.left.partialHash(r10, r11, r16);
        r15 = this.right;
        r11 = 0;
        r12 = r12 - r16;
        goto L6
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    protected int partialIsValidUtf8(int r10, int r11, int r12) {
        int r13 = r11 + r12;
        int r14 = this.leftLength;
        if (r13 > r14) goto L7;
        ByteString r15 = this.left;
    L6:
        return r15.partialIsValidUtf8(r10, r11, r12);
    L7:
        if (r11 < r14) goto L9;
        r15 = this.right;
        r11 = r11 - r14;
        goto L6
    L9:
        int r16 = r14 - r11;
        r10 = this.left.partialIsValidUtf8(r10, r11, r16);
        r15 = this.right;
        r11 = 0;
        r12 = r12 - r16;
        goto L6
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    protected int peekCachedHashCode() {
        return this.hash;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public int size() {
        return this.totalLength;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public String toString(String r10) {
        return new String(toByteArray(), r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    void writeToInternal(OutputStream r10, int r11, int r12) {
        int r13 = r11 + r12;
        int r14 = this.leftLength;
        if (r13 > r14) goto L6;
        ByteString r15 = this.left;
    L5:
        r15.writeToInternal(r10, r11, r12);
        return;
    L6:
        if (r11 < r14) goto L8;
        r15 = this.right;
        r11 = r11 - r14;
        goto L5
    L8:
        int r16 = r14 - r11;
        this.left.writeToInternal(r10, r11, r16);
        r15 = this.right;
        r11 = 0;
        r12 = r12 - r16;
        goto L5
    }
}
