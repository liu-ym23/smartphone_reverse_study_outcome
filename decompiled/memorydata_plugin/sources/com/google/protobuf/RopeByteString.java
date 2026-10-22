package com.google.protobuf;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

/* JADX INFO: loaded from: classes3.dex */
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

        /* synthetic */ Balancer(AnonymousClass1 r1) {
            this();
        }

        static /* synthetic */ ByteString access$100(Balancer r0, ByteString r1, ByteString r2) {
            return r0.balance(r1, r2);
        }

        private ByteString balance(ByteString r4, ByteString r5) {
            doBalance(r4);
            doBalance(r5);
            ByteString r6 = (ByteString) ZeusTransformUtils.preCheckCast(this.prefixesStack.pop(), ByteString.class, "com.obric.memorydata.plugin");
        L4:
            if (this.prefixesStack.isEmpty() == true) goto L6;
            r6 = new RopeByteString((ByteString) ZeusTransformUtils.preCheckCast(this.prefixesStack.pop(), ByteString.class, "com.obric.memorydata.plugin"), r6, null);
            goto L4
        L6:
            return r6;
        }

        private void doBalance(ByteString r3) {
            if (r3.isBalanced() == false) goto L6;
            insert(r3);
            return;
        L6:
            if (ZeusTransformUtils.instanceOf(r3, RopeByteString.class) == false) goto L10;
            RopeByteString r4 = (RopeByteString) ZeusTransformUtils.preCheckCast(r3, RopeByteString.class, "com.obric.memorydata.plugin");
            doBalance(RopeByteString.access$400(r4));
            doBalance(RopeByteString.access$500(r4));
            return;
        L10:
            throw new IllegalArgumentException("Has a new type of ByteString been created? Found " + r3.getClass());
        }

        private int getDepthBinForLength(int r1) {
            int r0 = Arrays.binarySearch(RopeByteString.minLengthByDepth, r1);
            if (r0 < 0) goto L5;
            return r0;
        L5:
            return (-(r0 + 1)) - 1;
        }

        private void insert(ByteString r7) {
            int r0 = getDepthBinForLength(r7.size());
            int r1 = RopeByteString.minLength(r0 + 1);
            if (this.prefixesStack.isEmpty() == false) goto L5;
        L20:
            this.prefixesStack.push(r7);
            return;
        L5:
            if (((ByteString) ZeusTransformUtils.preCheckCast(this.prefixesStack.peek(), ByteString.class, "com.obric.memorydata.plugin")).size() >= r1) goto L20;
            int r2 = RopeByteString.minLength(r0);
            ByteString r3 = (ByteString) ZeusTransformUtils.preCheckCast(this.prefixesStack.pop(), ByteString.class, "com.obric.memorydata.plugin");
        L8:
            AnonymousClass1 r4 = null;
            if (this.prefixesStack.isEmpty() == true) goto L13;
            if (((ByteString) ZeusTransformUtils.preCheckCast(this.prefixesStack.peek(), ByteString.class, "com.obric.memorydata.plugin")).size() >= r2) goto L13;
            r3 = new RopeByteString((ByteString) ZeusTransformUtils.preCheckCast(this.prefixesStack.pop(), ByteString.class, "com.obric.memorydata.plugin"), r3, r4);
        L13:
            RopeByteString r5 = new RopeByteString(r3, r7, r4);
        L15:
            if (this.prefixesStack.isEmpty() == true) goto L19;
            int r8 = RopeByteString.minLength(getDepthBinForLength(r5.size()) + 1);
            if (((ByteString) ZeusTransformUtils.preCheckCast(this.prefixesStack.peek(), ByteString.class, "com.obric.memorydata.plugin")).size() >= r8) goto L19;
            r5 = new RopeByteString((ByteString) ZeusTransformUtils.preCheckCast(this.prefixesStack.pop(), ByteString.class, "com.obric.memorydata.plugin"), r5, r4);
        L19:
            this.prefixesStack.push(r5);
        }
    }

    private static final class PieceIterator implements Iterator<ByteString.LeafByteString> {
        private final ArrayDeque<RopeByteString> breadCrumbs;
        private ByteString.LeafByteString next;

        private PieceIterator(ByteString r3) {
            if (ZeusTransformUtils.instanceOf(r3, RopeByteString.class) == false) goto L5;
            RopeByteString r4 = (RopeByteString) ZeusTransformUtils.preCheckCast(r3, RopeByteString.class, "com.obric.memorydata.plugin");
            ArrayDeque<RopeByteString> r0 = new ArrayDeque(r4.getTreeDepth());
            this.breadCrumbs = r0;
            r0.push(r4);
            ByteString.LeafByteString r5 = getLeafByLeft(RopeByteString.access$400(r4));
        L6:
            this.next = r5;
            return;
        L5:
            this.breadCrumbs = null;
            r5 = (ByteString.LeafByteString) ZeusTransformUtils.preCheckCast(r3, ByteString.LeafByteString.class, "com.obric.memorydata.plugin");
            goto L6
        }

        /* synthetic */ PieceIterator(ByteString r1, AnonymousClass1 r2) {
            this(r1);
        }

        private ByteString.LeafByteString getLeafByLeft(ByteString r3) {
        L3:
            if (ZeusTransformUtils.instanceOf(r3, RopeByteString.class) == false) goto L6;
            RopeByteString r4 = (RopeByteString) ZeusTransformUtils.preCheckCast(r3, RopeByteString.class, "com.obric.memorydata.plugin");
            this.breadCrumbs.push(r4);
            r3 = RopeByteString.access$400(r4);
            goto L3
        L6:
            return (ByteString.LeafByteString) ZeusTransformUtils.preCheckCast(r3, ByteString.LeafByteString.class, "com.obric.memorydata.plugin");
        }

        private ByteString.LeafByteString getNextNonEmptyLeaf() {
        L2:
            ArrayDeque<RopeByteString> r0 = this.breadCrumbs;
            if (r0 == null) goto L10;
            if (r0.isEmpty() == true) goto L16;
            ByteString.LeafByteString r1 = getLeafByLeft(RopeByteString.access$500((RopeByteString) ZeusTransformUtils.preCheckCast(this.breadCrumbs.pop(), RopeByteString.class, "com.obric.memorydata.plugin")));
            if (r1.isEmpty() == true) goto L2;
            return r1;
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
            ByteString.LeafByteString r0 = this.next;
            if (r0 == null) goto L7;
            this.next = getNextNonEmptyLeaf();
            return r0;
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

        public RopeInputStream(RopeByteString r1) {
            this.this$0 = r1;
            initialize();
        }

        private void advanceIfCurrentPieceFullyRead() {
            if (this.currentPiece == null) goto L12;
            int r0 = this.currentPieceIndex;
            int r1 = this.currentPieceSize;
            if (r0 != r1) goto L13;
            this.currentPieceOffsetInRope += r1;
            int r2 = 0;
            this.currentPieceIndex = 0;
            if (this.pieceIterator.hasNext() == false) goto L9;
            ByteString.LeafByteString r3 = this.pieceIterator.next();
            this.currentPiece = r3;
            r2 = r3.size();
        L10:
            this.currentPieceSize = r2;
            return;
        L9:
            this.currentPiece = null;
            goto L10
        L13:
            return;
        }

        private int availableInternal() {
            int r0 = this.currentPieceOffsetInRope + this.currentPieceIndex;
            return this.this$0.size() - r0;
        }

        private void initialize() {
            PieceIterator r0 = new PieceIterator(this.this$0, null);
            this.pieceIterator = r0;
            ByteString.LeafByteString r1 = r0.next();
            this.currentPiece = r1;
            this.currentPieceSize = r1.size();
            this.currentPieceIndex = 0;
            this.currentPieceOffsetInRope = 0;
        }

        private int readSkipInternal(byte[] r5, int r6, int r7) {
            int r0 = r7;
        L3:
            if (r0 <= 0) goto L12;
            advanceIfCurrentPieceFullyRead();
            if (this.currentPiece == null) goto L12;
            int r1 = Math.min(this.currentPieceSize - this.currentPieceIndex, r0);
            if (r5 == null) goto L10;
            this.currentPiece.copyTo(r5, this.currentPieceIndex, r6, r1);
            r6 = r6 + r1;
        L10:
            this.currentPieceIndex += r1;
            r0 = r0 - r1;
        L12:
            return r7 - r0;
        }

        @Override // java.io.InputStream
        public int available() {
            return availableInternal();
        }

        @Override // java.io.InputStream
        public void mark(int r2) {
            this.mark = this.currentPieceOffsetInRope + this.currentPieceIndex;
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public int read() {
            advanceIfCurrentPieceFullyRead();
            ByteString.LeafByteString r0 = this.currentPiece;
            if (r0 != null) goto L6;
            return -1;
        L6:
            int r1 = this.currentPieceIndex;
            this.currentPieceIndex = r1 + 1;
            return r0.byteAt(r1) & 255;
        }

        @Override // java.io.InputStream
        public int read(byte[] r2, int r3, int r4) {
            Objects.requireNonNull(r2);
            if (r3 < 0) goto L16;
            if (r4 < 0) goto L16;
            if (r4 > (r2.length - r3)) goto L16;
            int r5 = readSkipInternal(r2, r3, r4);
            if (r5 != 0) goto L14;
            if (r4 <= 0) goto L11;
            return -1;
        L11:
            if (availableInternal() != 0) goto L14;
            return -1;
        L14:
            return r5;
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
        public long skip(long r4) {
            if (r4 < 0) goto L10;
            if (r4 <= 2147483647L) goto L8;
            r4 = 2147483647L;
        L8:
            return readSkipInternal(null, 0, (int) r4);
        L10:
            throw new IndexOutOfBoundsException();
        }
    }

    static {
        minLengthByDepth = new int[]{1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, Integer.MAX_VALUE};
    }

    private RopeByteString(ByteString r3, ByteString r4) {
        this.left = r3;
        this.right = r4;
        int r0 = r3.size();
        this.leftLength = r0;
        this.totalLength = r0 + r4.size();
        this.treeDepth = Math.max(r3.getTreeDepth(), r4.getTreeDepth()) + 1;
    }

    /* synthetic */ RopeByteString(ByteString r1, ByteString r2, AnonymousClass1 r3) {
        this(r1, r2);
    }

    static /* synthetic */ ByteString access$400(RopeByteString r0) {
        return r0.left;
    }

    static /* synthetic */ ByteString access$500(RopeByteString r0) {
        return r0.right;
    }

    static ByteString concatenate(ByteString r5, ByteString r6) {
        if (r6.size() != 0) goto L6;
        return r5;
    L6:
        if (r5.size() != 0) goto L8;
        return r6;
    L8:
        int r1 = r5.size() + r6.size();
        if (r1 >= 128) goto L13;
        return concatenateBytes(r5, r6);
    L13:
        if (ZeusTransformUtils.instanceOf(r5, RopeByteString.class) == false) goto L25;
        RopeByteString r0 = (RopeByteString) ZeusTransformUtils.preCheckCast(r5, RopeByteString.class, "com.obric.memorydata.plugin");
        if ((r0.right.size() + r6.size()) >= 128) goto L19;
        ByteString r7 = concatenateBytes(r0.right, r6);
        return new RopeByteString(r0.left, r7);
    L19:
        if (r0.left.getTreeDepth() <= r0.right.getTreeDepth()) goto L25;
        if (r0.getTreeDepth() <= r6.getTreeDepth()) goto L25;
        RopeByteString r8 = new RopeByteString(r0.right, r6);
        return new RopeByteString(r0.left, r8);
    L25:
        if (r1 < minLength(Math.max(r5.getTreeDepth(), r6.getTreeDepth()) + 1)) goto L29;
        return new RopeByteString(r5, r6);
    L29:
        return Balancer.access$100(new Balancer(null), r5, r6);
    }

    private static ByteString concatenateBytes(ByteString r4, ByteString r5) {
        int r0 = r4.size();
        int r1 = r5.size();
        byte[] r2 = new byte[r0 + r1];
        r4.copyTo(r2, 0, 0, r0);
        r5.copyTo(r2, 0, r0, r1);
        return ByteString.wrap(r2);
    }

    private boolean equalsFragments(ByteString r13) {
        AnonymousClass1 r1 = null;
        PieceIterator r0 = new PieceIterator(this, r1);
        ByteString.LeafByteString r2 = (ByteString.LeafByteString) ZeusTransformUtils.preCheckCast(r0.next(), ByteString.LeafByteString.class, "com.obric.memorydata.plugin");
        PieceIterator r3 = new PieceIterator(r13, r1);
        ByteString.LeafByteString r14 = (ByteString.LeafByteString) ZeusTransformUtils.preCheckCast(r3.next(), ByteString.LeafByteString.class, "com.obric.memorydata.plugin");
        int r5 = 0;
        int r6 = 0;
        int r7 = 0;
    L3:
        int r8 = r2.size() - r5;
        int r9 = r14.size() - r6;
        int r10 = Math.min(r8, r9);
        if (r5 != 0) goto L6;
        boolean r11 = r2.equalsRange(r14, r6, r10);
    L7:
        if (r11 == false) goto L8;
        r7 = r7 + r10;
        int r12 = this.totalLength;
        if (r7 >= r12) goto L11;
        if (r10 != r8) goto L18;
        r5 = 0;
        r2 = (ByteString.LeafByteString) ZeusTransformUtils.preCheckCast(r0.next(), ByteString.LeafByteString.class, "com.obric.memorydata.plugin");
    L19:
        if (r10 == r9) goto L20;
        r6 = r6 + r10;
        goto L3
    L20:
        r14 = (ByteString.LeafByteString) ZeusTransformUtils.preCheckCast(r3.next(), ByteString.LeafByteString.class, "com.obric.memorydata.plugin");
        r6 = 0;
        goto L3
    L18:
        r5 = r5 + r10;
        r2 = r2;
        goto L19
    L11:
        if (r7 != r12) goto L15;
        return true;
    L15:
        throw new IllegalStateException();
    L8:
        return false;
    L6:
        r11 = r14.equalsRange(r2, r5, r10);
        goto L7
    }

    static int minLength(int r2) {
        int[] r0 = minLengthByDepth;
        if (r2 < r0.length) goto L7;
        return Integer.MAX_VALUE;
    L7:
        return r0[r2];
    }

    static RopeByteString newInstanceForTest(ByteString r1, ByteString r2) {
        return new RopeByteString(r1, r2);
    }

    private void readObject(ObjectInputStream r1) {
        throw new InvalidObjectException("RopeByteStream instances are not to be serialized directly");
    }

    @Override // com.google.protobuf.ByteString
    public ByteBuffer asReadOnlyByteBuffer() {
        return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
    }

    @Override // com.google.protobuf.ByteString
    public List<ByteBuffer> asReadOnlyByteBufferList() {
        ArrayList r0 = new ArrayList();
        PieceIterator r1 = new PieceIterator(this, null);
    L4:
        if (r1.hasNext() == false) goto L6;
        r0.add(r1.next().asReadOnlyByteBuffer());
        goto L4
    L6:
        return r0;
    }

    @Override // com.google.protobuf.ByteString
    public byte byteAt(int r2) {
        checkIndex(r2, this.totalLength);
        return internalByteAt(r2);
    }

    @Override // com.google.protobuf.ByteString
    public void copyTo(ByteBuffer r2) {
        this.left.copyTo(r2);
        this.right.copyTo(r2);
    }

    @Override // com.google.protobuf.ByteString
    public void copyToInternal(byte[] r3, int r4, int r5, int r6) {
        int r0 = r4 + r6;
        int r1 = this.leftLength;
        if (r0 > r1) goto L6;
        ByteString r2 = this.left;
    L5:
        r2.copyToInternal(r3, r4, r5, r6);
        return;
    L6:
        if (r4 < r1) goto L8;
        r2 = this.right;
        r4 = r4 - r1;
        goto L5
    L8:
        int r7 = r1 - r4;
        this.left.copyToInternal(r3, r4, r5, r7);
        r2 = this.right;
        r4 = 0;
        r5 = r5 + r7;
        r6 = r6 - r7;
        goto L5
    }

    @Override // com.google.protobuf.ByteString
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ByteString.class) == true) goto L8;
        return false;
    L8:
        ByteString r6 = (ByteString) ZeusTransformUtils.preCheckCast(r5, ByteString.class, "com.obric.memorydata.plugin");
        if (this.totalLength == r6.size()) goto L12;
        return false;
    L12:
        if (this.totalLength != 0) goto L14;
        return true;
    L14:
        int r0 = peekCachedHashCode();
        int r1 = r6.peekCachedHashCode();
        if (r0 == 0) goto L20;
        if (r1 == 0) goto L20;
        if (r0 == r1) goto L20;
        return false;
    L20:
        return equalsFragments(r6);
    }

    @Override // com.google.protobuf.ByteString
    public int getTreeDepth() {
        return this.treeDepth;
    }

    @Override // com.google.protobuf.ByteString
    byte internalByteAt(int r2) {
        int r0 = this.leftLength;
        if (r2 >= r0) goto L7;
        ByteString r1 = this.left;
    L6:
        return r1.internalByteAt(r2);
    L7:
        r1 = this.right;
        r2 = r2 - r0;
        goto L6
    }

    @Override // com.google.protobuf.ByteString
    public boolean isBalanced() {
        if (this.totalLength < minLength(this.treeDepth)) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.protobuf.ByteString
    public boolean isValidUtf8() {
        int r0 = this.left.partialIsValidUtf8(0, 0, this.leftLength);
        ByteString r3 = this.right;
        if (r3.partialIsValidUtf8(r0, 0, r3.size()) != 0) goto L6;
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
    public int partialHash(int r3, int r4, int r5) {
        int r0 = r4 + r5;
        int r1 = this.leftLength;
        if (r0 > r1) goto L7;
        ByteString r2 = this.left;
    L6:
        return r2.partialHash(r3, r4, r5);
    L7:
        if (r4 < r1) goto L9;
        r2 = this.right;
        r4 = r4 - r1;
        goto L6
    L9:
        int r6 = r1 - r4;
        r3 = this.left.partialHash(r3, r4, r6);
        r2 = this.right;
        r4 = 0;
        r5 = r5 - r6;
        goto L6
    }

    @Override // com.google.protobuf.ByteString
    public int partialIsValidUtf8(int r3, int r4, int r5) {
        int r0 = r4 + r5;
        int r1 = this.leftLength;
        if (r0 > r1) goto L7;
        ByteString r2 = this.left;
    L6:
        return r2.partialIsValidUtf8(r3, r4, r5);
    L7:
        if (r4 < r1) goto L9;
        r2 = this.right;
        r4 = r4 - r1;
        goto L6
    L9:
        int r6 = r1 - r4;
        r3 = this.left.partialIsValidUtf8(r3, r4, r6);
        r2 = this.right;
        r4 = 0;
        r5 = r5 - r6;
        goto L6
    }

    @Override // com.google.protobuf.ByteString
    public int size() {
        return this.totalLength;
    }

    @Override // com.google.protobuf.ByteString
    public ByteString substring(int r3, int r4) {
        int r0 = checkRange(r3, r4, this.totalLength);
        if (r0 != 0) goto L7;
        return ByteString.EMPTY;
    L7:
        if (r0 != this.totalLength) goto L9;
        return this;
    L9:
        int r1 = this.leftLength;
        if (r4 > r1) goto L14;
        ByteString r2 = this.left;
    L13:
        return r2.substring(r3, r4);
    L14:
        if (r3 < r1) goto L17;
        r2 = this.right;
        r3 = r3 - r1;
        r4 = r4 - r1;
        goto L13
    L17:
        return new RopeByteString(this.left.substring(r3), this.right.substring(0, r4 - this.leftLength));
    }

    @Override // com.google.protobuf.ByteString
    public String toStringInternal(Charset r2) {
        return new String(toByteArray(), r2);
    }

    Object writeReplace() {
        return ByteString.wrap(toByteArray());
    }

    @Override // com.google.protobuf.ByteString
    void writeTo(ByteOutput r2) {
        this.left.writeTo(r2);
        this.right.writeTo(r2);
    }

    @Override // com.google.protobuf.ByteString
    public void writeTo(OutputStream r2) {
        this.left.writeTo(r2);
        this.right.writeTo(r2);
    }

    @Override // com.google.protobuf.ByteString
    void writeToInternal(OutputStream r3, int r4, int r5) {
        int r0 = r4 + r5;
        int r1 = this.leftLength;
        if (r0 > r1) goto L6;
        ByteString r2 = this.left;
    L5:
        r2.writeToInternal(r3, r4, r5);
        return;
    L6:
        if (r4 < r1) goto L8;
        r2 = this.right;
        r4 = r4 - r1;
        goto L5
    L8:
        int r6 = r1 - r4;
        this.left.writeToInternal(r3, r4, r6);
        r2 = this.right;
        r4 = 0;
        r5 = r5 - r6;
        goto L5
    }

    @Override // com.google.protobuf.ByteString
    void writeToReverse(ByteOutput r2) {
        this.right.writeToReverse(r2);
        this.left.writeToReverse(r2);
    }
}
