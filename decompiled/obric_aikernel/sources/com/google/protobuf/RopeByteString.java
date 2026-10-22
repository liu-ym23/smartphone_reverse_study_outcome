package com.google.protobuf;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
final class RopeByteString extends ByteString {
    static final int[] minLengthByDepth = null;
    private static final long serialVersionUID = 1;
    private final ByteString left;
    private final int leftLength;
    private final ByteString right;
    private final int totalLength;
    private final int treeDepth;

    private static class Balancer {
        private final ArrayDeque<ByteString> prefixesStack;

        private Balancer() {
            this.prefixesStack = new ArrayDeque();
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
            if ((r10 instanceof RopeByteString) == false) goto L10;
            RopeByteString r11 = (RopeByteString) r10;
            doBalance(RopeByteString.access$400(r11));
            doBalance(RopeByteString.access$500(r11));
            return;
        L10:
            throw new IllegalArgumentException("Has a new type of ByteString been created? Found " + r10.getClass());
        }

        private int getDepthBinForLength(int r10) {
            int r11 = Arrays.binarySearch(RopeByteString.minLengthByDepth, r10);
            if (r11 < 0) goto L5;
            return r11;
        L5:
            return (-(r11 + 1)) - 1;
        }

        private void insert(ByteString r10) {
            int r11 = getDepthBinForLength(r10.size());
            int r12 = RopeByteString.minLength(r11 + 1);
            if (this.prefixesStack.isEmpty() == false) goto L5;
        L20:
            this.prefixesStack.push(r10);
            return;
        L5:
            if (this.prefixesStack.peek().size() >= r12) goto L20;
            int r13 = RopeByteString.minLength(r11);
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
            int r17 = RopeByteString.minLength(getDepthBinForLength(r16.size()) + 1);
            if (this.prefixesStack.peek().size() >= r17) goto L19;
            r16 = new RopeByteString(this.prefixesStack.pop(), r16, r15);
        L19:
            this.prefixesStack.push(r16);
        }
    }

    private static final class PieceIterator implements Iterator<ByteString.LeafByteString> {
        private final ArrayDeque<RopeByteString> breadCrumbs;
        private ByteString.LeafByteString next;

        private PieceIterator(ByteString r10) {
            if ((r10 instanceof RopeByteString) == false) goto L5;
            RopeByteString r11 = (RopeByteString) r10;
            ArrayDeque<RopeByteString> r12 = new ArrayDeque(r11.getTreeDepth());
            this.breadCrumbs = r12;
            r12.push(r11);
            ByteString.LeafByteString r13 = getLeafByLeft(RopeByteString.access$400(r11));
        L6:
            this.next = r13;
            return;
        L5:
            this.breadCrumbs = null;
            r13 = (ByteString.LeafByteString) r10;
            goto L6
        }

        /* synthetic */ PieceIterator(ByteString r10, AnonymousClass1 r11) {
            this(r10);
        }

        private ByteString.LeafByteString getLeafByLeft(ByteString r10) {
        L3:
            if ((r10 instanceof RopeByteString) == false) goto L6;
            RopeByteString r11 = (RopeByteString) r10;
            this.breadCrumbs.push(r11);
            r10 = RopeByteString.access$400(r11);
            goto L3
        L6:
            return (ByteString.LeafByteString) r10;
        }

        private ByteString.LeafByteString getNextNonEmptyLeaf() {
        L2:
            ArrayDeque<RopeByteString> r10 = this.breadCrumbs;
            if (r10 == null) goto L10;
            if (r10.isEmpty() == true) goto L16;
            ByteString.LeafByteString r11 = getLeafByLeft(RopeByteString.access$500(this.breadCrumbs.pop()));
            if (r11.isEmpty() == true) goto L2;
            return r11;
        L16:
            return null;
        L10:
            return null;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.next == null) goto L5;
            return true;
        L5:
            return false;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public ByteString.LeafByteString next() {
            ByteString.LeafByteString r10 = this.next;
            if (r10 == null) goto L7;
            this.next = getNextNonEmptyLeaf();
            return r10;
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ ByteString.LeafByteString next() {
            return next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class RopeInputStream extends InputStream {
        private ByteString.LeafByteString currentPiece;
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
            ByteString.LeafByteString r13 = this.pieceIterator.next();
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

        private int availableInternal() {
            int r10 = this.currentPieceOffsetInRope + this.currentPieceIndex;
            return this.this$0.size() - r10;
        }

        private void initialize() {
            PieceIterator r10 = new PieceIterator(this.this$0, null);
            this.pieceIterator = r10;
            ByteString.LeafByteString r11 = r10.next();
            this.currentPiece = r11;
            this.currentPieceSize = r11.size();
            this.currentPieceIndex = 0;
            this.currentPieceOffsetInRope = 0;
        }

        private int readSkipInternal(byte[] r10, int r11, int r12) {
            int r13 = r12;
        L3:
            if (r13 <= 0) goto L12;
            advanceIfCurrentPieceFullyRead();
            if (this.currentPiece == null) goto L12;
            int r14 = Math.min(this.currentPieceSize - this.currentPieceIndex, r13);
            if (r10 == null) goto L10;
            this.currentPiece.copyTo(r10, this.currentPieceIndex, r11, r14);
            r11 = r11 + r14;
        L10:
            this.currentPieceIndex += r14;
            r13 = r13 - r14;
        L12:
            return r12 - r13;
        }

        @Override // java.io.InputStream
        public int available() {
            return availableInternal();
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
            ByteString.LeafByteString r10 = this.currentPiece;
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
            if (r11 < 0) goto L16;
            if (r12 < 0) goto L16;
            if (r12 > (r10.length - r11)) goto L16;
            int r13 = readSkipInternal(r10, r11, r12);
            if (r13 != 0) goto L14;
            if (r12 <= 0) goto L11;
            return -1;
        L11:
            if (availableInternal() != 0) goto L14;
            return -1;
        L14:
            return r13;
        L16:
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
        minLengthByDepth = new int[]{1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, Integer.MAX_VALUE};
    }

    private RopeByteString(ByteString r10, ByteString r11) {
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

    static ByteString concatenate(ByteString r10, ByteString r11) {
        if (r11.size() != 0) goto L6;
        return r10;
    L6:
        if (r10.size() != 0) goto L8;
        return r11;
    L8:
        int r12 = r10.size() + r11.size();
        if (r12 >= 128) goto L13;
        return concatenateBytes(r10, r11);
    L13:
        if ((r10 instanceof RopeByteString) == false) goto L25;
        RopeByteString r13 = (RopeByteString) r10;
        if ((r13.right.size() + r11.size()) >= 128) goto L19;
        ByteString r14 = concatenateBytes(r13.right, r11);
        return new RopeByteString(r13.left, r14);
    L19:
        if (r13.left.getTreeDepth() <= r13.right.getTreeDepth()) goto L25;
        if (r13.getTreeDepth() <= r11.getTreeDepth()) goto L25;
        RopeByteString r15 = new RopeByteString(r13.right, r11);
        return new RopeByteString(r13.left, r15);
    L25:
        if (r12 < minLength(Math.max(r10.getTreeDepth(), r11.getTreeDepth()) + 1)) goto L29;
        return new RopeByteString(r10, r11);
    L29:
        return Balancer.access$100(new Balancer(null), r10, r11);
    }

    private static ByteString concatenateBytes(ByteString r10, ByteString r11) {
        int r12 = r10.size();
        int r13 = r11.size();
        byte[] r14 = new byte[r12 + r13];
        r10.copyTo(r14, 0, 0, r12);
        r11.copyTo(r14, 0, r12, r13);
        return ByteString.wrap(r14);
    }

    private boolean equalsFragments(ByteString r12) {
        AnonymousClass1 r10 = null;
        PieceIterator r11 = new PieceIterator(this, r10);
        ByteString.LeafByteString r13 = r11.next();
        PieceIterator r14 = new PieceIterator(r12, r10);
        ByteString.LeafByteString r15 = r14.next();
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
        r16 = 0;
        r13 = r11.next();
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
        r13 = r13;
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

    static int minLength(int r10) {
        int[] r11 = minLengthByDepth;
        if (r10 < r11.length) goto L7;
        return Integer.MAX_VALUE;
    L7:
        return r11[r10];
    }

    static RopeByteString newInstanceForTest(ByteString r10, ByteString r11) {
        return new RopeByteString(r10, r11);
    }

    private void readObject(ObjectInputStream r10) {
        throw new InvalidObjectException("RopeByteStream instances are not to be serialized directly");
    }

    @Override // com.google.protobuf.ByteString
    public ByteBuffer asReadOnlyByteBuffer() {
        return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
    }

    @Override // com.google.protobuf.ByteString
    public List<ByteBuffer> asReadOnlyByteBufferList() {
        ArrayList r10 = new ArrayList();
        PieceIterator r11 = new PieceIterator(this, null);
    L4:
        if (r11.hasNext() == false) goto L6;
        r10.add(r11.next().asReadOnlyByteBuffer());
        goto L4
    L6:
        return r10;
    }

    @Override // com.google.protobuf.ByteString
    public byte byteAt(int r10) {
        ByteString.checkIndex(r10, this.totalLength);
        return internalByteAt(r10);
    }

    @Override // com.google.protobuf.ByteString
    public void copyTo(ByteBuffer r10) {
        this.left.copyTo(r10);
        this.right.copyTo(r10);
    }

    @Override // com.google.protobuf.ByteString
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

    @Override // com.google.protobuf.ByteString
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
        if (this.totalLength != 0) goto L14;
        return true;
    L14:
        int r12 = peekCachedHashCode();
        int r13 = r11.peekCachedHashCode();
        if (r12 == 0) goto L20;
        if (r13 == 0) goto L20;
        if (r12 == r13) goto L20;
        return false;
    L20:
        return equalsFragments(r11);
    }

    @Override // com.google.protobuf.ByteString
    protected int getTreeDepth() {
        return this.treeDepth;
    }

    @Override // com.google.protobuf.ByteString
    byte internalByteAt(int r10) {
        int r11 = this.leftLength;
        if (r10 >= r11) goto L7;
        ByteString r12 = this.left;
    L6:
        return r12.internalByteAt(r10);
    L7:
        r12 = this.right;
        r10 = r10 - r11;
        goto L6
    }

    @Override // com.google.protobuf.ByteString
    protected boolean isBalanced() {
        if (this.totalLength < minLength(this.treeDepth)) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.protobuf.ByteString
    public boolean isValidUtf8() {
        int r10 = this.left.partialIsValidUtf8(0, 0, this.leftLength);
        ByteString r11 = this.right;
        if (r11.partialIsValidUtf8(r10, 0, r11.size()) != 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // com.google.protobuf.ByteString, java.lang.Iterable
    public Iterator<Byte> iterator() {
        return new AnonymousClass1(this);
    }

    @Override // com.google.protobuf.ByteString, java.lang.Iterable
    /* JADX INFO: renamed from: iterator, reason: avoid collision after fix types in other method */
    public /* bridge */ /* synthetic */ Iterator<Byte> iterator2() {
        return iterator();
    }

    @Override // com.google.protobuf.ByteString
    public CodedInputStream newCodedInput() {
        return CodedInputStream.newInstance(asReadOnlyByteBufferList(), true);
    }

    @Override // com.google.protobuf.ByteString
    public InputStream newInput() {
        return new RopeInputStream(this);
    }

    @Override // com.google.protobuf.ByteString
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

    @Override // com.google.protobuf.ByteString
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

    @Override // com.google.protobuf.ByteString
    public int size() {
        return this.totalLength;
    }

    @Override // com.google.protobuf.ByteString
    public ByteString substring(int r10, int r11) {
        int r12 = ByteString.checkRange(r10, r11, this.totalLength);
        if (r12 != 0) goto L7;
        return ByteString.EMPTY;
    L7:
        if (r12 != this.totalLength) goto L9;
        return this;
    L9:
        int r13 = this.leftLength;
        if (r11 > r13) goto L14;
        ByteString r14 = this.left;
    L13:
        return r14.substring(r10, r11);
    L14:
        if (r10 < r13) goto L17;
        r14 = this.right;
        r10 = r10 - r13;
        r11 = r11 - r13;
        goto L13
    L17:
        return new RopeByteString(this.left.substring(r10), this.right.substring(0, r11 - this.leftLength));
    }

    @Override // com.google.protobuf.ByteString
    protected String toStringInternal(Charset r10) {
        return new String(toByteArray(), r10);
    }

    Object writeReplace() {
        return ByteString.wrap(toByteArray());
    }

    @Override // com.google.protobuf.ByteString
    void writeTo(ByteOutput r10) {
        this.left.writeTo(r10);
        this.right.writeTo(r10);
    }

    @Override // com.google.protobuf.ByteString
    public void writeTo(OutputStream r10) {
        this.left.writeTo(r10);
        this.right.writeTo(r10);
    }

    @Override // com.google.protobuf.ByteString
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

    @Override // com.google.protobuf.ByteString
    void writeToReverse(ByteOutput r10) {
        this.right.writeToReverse(r10);
        this.left.writeToReverse(r10);
    }
}
