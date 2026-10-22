package com.google.protobuf;

import com.obric.cae.libs.wifi.basicInfo.ChannelsEnvironment;
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

/* JADX INFO: loaded from: classes.dex */
final class RopeByteString extends ByteString {
    static final int[] minLengthByDepth = null;
    private static final long serialVersionUID = 1;
    private final ByteString left;
    private final int leftLength;
    private final ByteString right;
    private final int totalLength;
    private final int treeDepth;

    public static class Balancer {
        private final ArrayDeque<ByteString> prefixesStack;

        private Balancer() {
            this.prefixesStack = new ArrayDeque();
        }

        public static /* synthetic */ ByteString access$100(Balancer r8, ByteString r10, ByteString r11) {
            return r8.balance(r10, r11);
        }

        private ByteString balance(ByteString r8, ByteString r10) {
            doBalance(r8);
            doBalance(r10);
            ByteString r11 = this.prefixesStack.pop();
        L4:
            if (this.prefixesStack.isEmpty() == true) goto L6;
            r11 = new RopeByteString(this.prefixesStack.pop(), r11, null);
            goto L4
        L6:
            return r11;
        }

        private void doBalance(ByteString r8) {
            if (r8.isBalanced() == false) goto L6;
            insert(r8);
            return;
        L6:
            if ((r8 instanceof RopeByteString) == false) goto L10;
            RopeByteString r10 = (RopeByteString) r8;
            doBalance(RopeByteString.access$400(r10));
            doBalance(RopeByteString.access$500(r10));
            return;
        L10:
            throw new IllegalArgumentException("Has a new type of ByteString been created? Found " + r8.getClass());
        }

        private int getDepthBinForLength(int r8) {
            int r10 = Arrays.binarySearch(RopeByteString.minLengthByDepth, r8);
            if (r10 < 0) goto L5;
            return r10;
        L5:
            return (-(r10 + 1)) - 1;
        }

        private void insert(ByteString r8) {
            int r10 = getDepthBinForLength(r8.size());
            int r11 = RopeByteString.minLength(r10 + 1);
            if (this.prefixesStack.isEmpty() == false) goto L5;
        L20:
            this.prefixesStack.push(r8);
            return;
        L5:
            if (this.prefixesStack.peek().size() >= r11) goto L20;
            int r12 = RopeByteString.minLength(r10);
            ByteString r13 = this.prefixesStack.pop();
        L8:
            AnonymousClass1 r14 = null;
            if (this.prefixesStack.isEmpty() == true) goto L13;
            if (this.prefixesStack.peek().size() >= r12) goto L13;
            r13 = new RopeByteString(this.prefixesStack.pop(), r13, r14);
        L13:
            RopeByteString r15 = new RopeByteString(r13, r8, r14);
        L15:
            if (this.prefixesStack.isEmpty() == true) goto L19;
            int r16 = RopeByteString.minLength(getDepthBinForLength(r15.size()) + 1);
            if (this.prefixesStack.peek().size() >= r16) goto L19;
            r15 = new RopeByteString(this.prefixesStack.pop(), r15, r14);
        L19:
            this.prefixesStack.push(r15);
        }

        public /* synthetic */ Balancer(AnonymousClass1 r8) {
            this();
        }
    }

    public static final class PieceIterator implements Iterator<ByteString.LeafByteString> {
        private final ArrayDeque<RopeByteString> breadCrumbs;
        private ByteString.LeafByteString next;

        private PieceIterator(ByteString r8) {
            if ((r8 instanceof RopeByteString) == false) goto L5;
            RopeByteString r10 = (RopeByteString) r8;
            ArrayDeque<RopeByteString> r11 = new ArrayDeque(r10.getTreeDepth());
            this.breadCrumbs = r11;
            r11.push(r10);
            ByteString.LeafByteString r12 = getLeafByLeft(RopeByteString.access$400(r10));
        L6:
            this.next = r12;
            return;
        L5:
            this.breadCrumbs = null;
            r12 = (ByteString.LeafByteString) r8;
            goto L6
        }

        private ByteString.LeafByteString getLeafByLeft(ByteString r8) {
        L3:
            if ((r8 instanceof RopeByteString) == false) goto L6;
            RopeByteString r10 = (RopeByteString) r8;
            this.breadCrumbs.push(r10);
            r8 = RopeByteString.access$400(r10);
            goto L3
        L6:
            return (ByteString.LeafByteString) r8;
        }

        private ByteString.LeafByteString getNextNonEmptyLeaf() {
        L2:
            ArrayDeque<RopeByteString> r8 = this.breadCrumbs;
            if (r8 == null) goto L10;
            if (r8.isEmpty() == true) goto L16;
            ByteString.LeafByteString r10 = getLeafByLeft(RopeByteString.access$500(this.breadCrumbs.pop()));
            if (r10.isEmpty() == true) goto L2;
            return r10;
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
            ByteString.LeafByteString r8 = this.next;
            if (r8 == null) goto L7;
            this.next = getNextNonEmptyLeaf();
            return r8;
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        public /* synthetic */ PieceIterator(ByteString r8, AnonymousClass1 r10) {
            this(r8);
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ ByteString.LeafByteString next() {
            return next();
        }
    }

    public class RopeInputStream extends InputStream {
        private ByteString.LeafByteString currentPiece;
        private int currentPieceIndex;
        private int currentPieceOffsetInRope;
        private int currentPieceSize;
        private int mark;
        private PieceIterator pieceIterator;
        final /* synthetic */ RopeByteString this$0;

        public RopeInputStream(RopeByteString r8) {
            this.this$0 = r8;
            initialize();
        }

        private void advanceIfCurrentPieceFullyRead() {
            if (this.currentPiece == null) goto L12;
            int r8 = this.currentPieceIndex;
            int r10 = this.currentPieceSize;
            if (r8 != r10) goto L13;
            this.currentPieceOffsetInRope += r10;
            int r11 = 0;
            this.currentPieceIndex = 0;
            if (this.pieceIterator.hasNext() == false) goto L9;
            ByteString.LeafByteString r12 = this.pieceIterator.next();
            this.currentPiece = r12;
            r11 = r12.size();
        L10:
            this.currentPieceSize = r11;
            return;
        L9:
            this.currentPiece = null;
            goto L10
        L13:
            return;
        }

        private int availableInternal() {
            int r8 = this.currentPieceOffsetInRope + this.currentPieceIndex;
            return this.this$0.size() - r8;
        }

        private void initialize() {
            PieceIterator r8 = new PieceIterator(this.this$0, null);
            this.pieceIterator = r8;
            ByteString.LeafByteString r10 = r8.next();
            this.currentPiece = r10;
            this.currentPieceSize = r10.size();
            this.currentPieceIndex = 0;
            this.currentPieceOffsetInRope = 0;
        }

        private int readSkipInternal(byte[] r8, int r10, int r11) {
            int r12 = r11;
        L3:
            if (r12 <= 0) goto L12;
            advanceIfCurrentPieceFullyRead();
            if (this.currentPiece == null) goto L12;
            int r13 = Math.min(this.currentPieceSize - this.currentPieceIndex, r12);
            if (r8 == null) goto L10;
            this.currentPiece.copyTo(r8, this.currentPieceIndex, r10, r13);
            r10 = r10 + r13;
        L10:
            this.currentPieceIndex += r13;
            r12 = r12 - r13;
        L12:
            return r11 - r12;
        }

        @Override // java.io.InputStream
        public int available() {
            return availableInternal();
        }

        @Override // java.io.InputStream
        public void mark(int r8) {
            this.mark = this.currentPieceOffsetInRope + this.currentPieceIndex;
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public int read() {
            advanceIfCurrentPieceFullyRead();
            ByteString.LeafByteString r8 = this.currentPiece;
            if (r8 != null) goto L6;
            return -1;
        L6:
            int r10 = this.currentPieceIndex;
            this.currentPieceIndex = r10 + 1;
            return r8.byteAt(r10) & 255;
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
        public long skip(long r8) {
            if (r8 < 0) goto L10;
            if (r8 <= 2147483647L) goto L8;
            r8 = 2147483647L;
        L8:
            return readSkipInternal(null, 0, (int) r8);
        L10:
            throw new IndexOutOfBoundsException();
        }

        @Override // java.io.InputStream
        public int read(byte[] r8, int r10, int r11) {
            if (r8 == null) goto L18;
            if (r10 < 0) goto L16;
            if (r11 < 0) goto L16;
            if (r11 > (r8.length - r10)) goto L16;
            int r12 = readSkipInternal(r8, r10, r11);
            if (r12 != 0) goto L14;
            if (r11 <= 0) goto L11;
            return -1;
        L11:
            if (availableInternal() != 0) goto L14;
            return -1;
        L14:
            return r12;
        L16:
            throw new IndexOutOfBoundsException();
        L18:
            throw null;
        }
    }

    static {
        minLengthByDepth = new int[]{1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ChannelsEnvironment.BAND_6_GHZ_LAST_CH_NUM, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, Integer.MAX_VALUE};
    }

    private RopeByteString(ByteString r8, ByteString r10) {
        this.left = r8;
        this.right = r10;
        int r11 = r8.size();
        this.leftLength = r11;
        this.totalLength = r10.size() + r11;
        this.treeDepth = Math.max(r8.getTreeDepth(), r10.getTreeDepth()) + 1;
    }

    public static /* synthetic */ ByteString access$400(RopeByteString r8) {
        return r8.left;
    }

    public static /* synthetic */ ByteString access$500(RopeByteString r8) {
        return r8.right;
    }

    public static ByteString concatenate(ByteString r8, ByteString r10) {
        if (r10.size() != 0) goto L6;
        return r8;
    L6:
        if (r8.size() != 0) goto L8;
        return r10;
    L8:
        int r11 = r8.size();
        int r12 = r10.size() + r11;
        if (r12 >= 128) goto L13;
        return concatenateBytes(r8, r10);
    L13:
        if ((r8 instanceof RopeByteString) == false) goto L25;
        RopeByteString r13 = (RopeByteString) r8;
        int r14 = r13.right.size();
        if ((r10.size() + r14) >= 128) goto L19;
        ByteString r15 = concatenateBytes(r13.right, r10);
        return new RopeByteString(r13.left, r15);
    L19:
        if (r13.left.getTreeDepth() <= r13.right.getTreeDepth()) goto L25;
        if (r13.getTreeDepth() <= r10.getTreeDepth()) goto L25;
        RopeByteString r16 = new RopeByteString(r13.right, r10);
        return new RopeByteString(r13.left, r16);
    L25:
        if (r12 < minLength(Math.max(r8.getTreeDepth(), r10.getTreeDepth()) + 1)) goto L29;
        return new RopeByteString(r8, r10);
    L29:
        return Balancer.access$100(new Balancer(null), r8, r10);
    }

    private static ByteString concatenateBytes(ByteString r8, ByteString r10) {
        int r11 = r8.size();
        int r12 = r10.size();
        byte[] r13 = new byte[r11 + r12];
        r8.copyTo(r13, 0, 0, r11);
        r10.copyTo(r13, 0, r11, r12);
        return ByteString.wrap(r13);
    }

    private boolean equalsFragments(ByteString r12) {
        AnonymousClass1 r8 = null;
        PieceIterator r10 = new PieceIterator(this, r8);
        ByteString.LeafByteString r11 = r10.next();
        PieceIterator r13 = new PieceIterator(r12, r8);
        ByteString.LeafByteString r14 = r13.next();
        int r15 = 0;
        int r16 = 0;
        int r17 = 0;
    L3:
        int r18 = r11.size() - r15;
        int r19 = r14.size() - r16;
        int r20 = Math.min(r18, r19);
        if (r15 != 0) goto L6;
        boolean r110 = r11.equalsRange(r14, r16, r20);
    L7:
        if (r110 == false) goto L8;
        r17 = r17 + r20;
        int r111 = this.totalLength;
        if (r17 >= r111) goto L11;
        if (r20 != r18) goto L18;
        r15 = 0;
        r11 = r10.next();
    L19:
        if (r20 == r19) goto L20;
        r16 = r16 + r20;
        goto L3
    L20:
        r14 = r13.next();
        r16 = 0;
        goto L3
    L18:
        r15 = r15 + r20;
        r11 = r11;
        goto L19
    L11:
        if (r17 != r111) goto L15;
        return true;
    L15:
        throw new IllegalStateException();
    L8:
        return false;
    L6:
        r110 = r14.equalsRange(r11, r15, r20);
        goto L7
    }

    public static int minLength(int r8) {
        int[] r10 = minLengthByDepth;
        if (r8 < r10.length) goto L7;
        return Integer.MAX_VALUE;
    L7:
        return r10[r8];
    }

    public static RopeByteString newInstanceForTest(ByteString r8, ByteString r10) {
        return new RopeByteString(r8, r10);
    }

    private void readObject(ObjectInputStream r8) {
        throw new InvalidObjectException("RopeByteStream instances are not to be serialized directly");
    }

    @Override // com.google.protobuf.ByteString
    public ByteBuffer asReadOnlyByteBuffer() {
        return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
    }

    @Override // com.google.protobuf.ByteString
    public List<ByteBuffer> asReadOnlyByteBufferList() {
        ArrayList r8 = new ArrayList();
        PieceIterator r10 = new PieceIterator(this, null);
    L4:
        if (r10.hasNext() == false) goto L6;
        r8.add(r10.next().asReadOnlyByteBuffer());
        goto L4
    L6:
        return r8;
    }

    @Override // com.google.protobuf.ByteString
    public byte byteAt(int r8) {
        ByteString.checkIndex(r8, this.totalLength);
        return internalByteAt(r8);
    }

    @Override // com.google.protobuf.ByteString
    public void copyTo(ByteBuffer r8) {
        this.left.copyTo(r8);
        this.right.copyTo(r8);
    }

    @Override // com.google.protobuf.ByteString
    public void copyToInternal(byte[] r8, int r10, int r11, int r12) {
        int r13 = r10 + r12;
        int r14 = this.leftLength;
        if (r13 > r14) goto L6;
        ByteString r15 = this.left;
    L5:
        r15.copyToInternal(r8, r10, r11, r12);
        return;
    L6:
        if (r10 < r14) goto L8;
        r15 = this.right;
        r10 = r10 - r14;
        goto L5
    L8:
        int r16 = r14 - r10;
        this.left.copyToInternal(r8, r10, r11, r16);
        r15 = this.right;
        r11 = r11 + r16;
        r12 = r12 - r16;
        r10 = 0;
        goto L5
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
        if (this.totalLength == r10.size()) goto L12;
        return false;
    L12:
        if (this.totalLength != 0) goto L14;
        return true;
    L14:
        int r11 = peekCachedHashCode();
        int r12 = r10.peekCachedHashCode();
        if (r11 == 0) goto L20;
        if (r12 == 0) goto L20;
        if (r11 == r12) goto L20;
        return false;
    L20:
        return equalsFragments(r10);
    }

    @Override // com.google.protobuf.ByteString
    public int getTreeDepth() {
        return this.treeDepth;
    }

    @Override // com.google.protobuf.ByteString
    public byte internalByteAt(int r8) {
        int r10 = this.leftLength;
        if (r8 >= r10) goto L7;
        ByteString r11 = this.left;
    L6:
        return r11.internalByteAt(r8);
    L7:
        r11 = this.right;
        r8 = r8 - r10;
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
        int r8 = this.left.partialIsValidUtf8(0, 0, this.leftLength);
        ByteString r10 = this.right;
        if (r10.partialIsValidUtf8(r8, 0, r10.size()) != 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // com.google.protobuf.ByteString, java.lang.Iterable
    public Iterator<Byte> iterator() {
        return new AnonymousClass1(this);
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
    public int partialHash(int r8, int r10, int r11) {
        int r12 = r10 + r11;
        int r13 = this.leftLength;
        if (r12 > r13) goto L7;
        ByteString r14 = this.left;
    L6:
        return r14.partialHash(r8, r10, r11);
    L7:
        if (r10 < r13) goto L9;
        r14 = this.right;
        r10 = r10 - r13;
        goto L6
    L9:
        int r15 = r13 - r10;
        r8 = this.left.partialHash(r8, r10, r15);
        r14 = this.right;
        r10 = 0;
        r11 = r11 - r15;
        goto L6
    }

    @Override // com.google.protobuf.ByteString
    public int partialIsValidUtf8(int r8, int r10, int r11) {
        int r12 = r10 + r11;
        int r13 = this.leftLength;
        if (r12 > r13) goto L7;
        ByteString r14 = this.left;
    L6:
        return r14.partialIsValidUtf8(r8, r10, r11);
    L7:
        if (r10 < r13) goto L9;
        r14 = this.right;
        r10 = r10 - r13;
        goto L6
    L9:
        int r15 = r13 - r10;
        r8 = this.left.partialIsValidUtf8(r8, r10, r15);
        r14 = this.right;
        r10 = 0;
        r11 = r11 - r15;
        goto L6
    }

    @Override // com.google.protobuf.ByteString
    public int size() {
        return this.totalLength;
    }

    @Override // com.google.protobuf.ByteString
    public ByteString substring(int r8, int r10) {
        int r11 = ByteString.checkRange(r8, r10, this.totalLength);
        if (r11 != 0) goto L7;
        return ByteString.EMPTY;
    L7:
        if (r11 != this.totalLength) goto L9;
        return this;
    L9:
        int r12 = this.leftLength;
        if (r10 > r12) goto L14;
        ByteString r13 = this.left;
    L13:
        return r13.substring(r8, r10);
    L14:
        if (r8 < r12) goto L17;
        r13 = this.right;
        r8 = r8 - r12;
        r10 = r10 - r12;
        goto L13
    L17:
        return new RopeByteString(this.left.substring(r8), this.right.substring(0, r10 - this.leftLength));
    }

    @Override // com.google.protobuf.ByteString
    public String toStringInternal(Charset r8) {
        return new String(toByteArray(), r8);
    }

    public Object writeReplace() {
        return ByteString.wrap(toByteArray());
    }

    @Override // com.google.protobuf.ByteString
    public void writeTo(ByteOutput r8) {
        this.left.writeTo(r8);
        this.right.writeTo(r8);
    }

    @Override // com.google.protobuf.ByteString
    public void writeToInternal(OutputStream r8, int r10, int r11) {
        int r12 = r10 + r11;
        int r13 = this.leftLength;
        if (r12 > r13) goto L6;
        ByteString r14 = this.left;
    L5:
        r14.writeToInternal(r8, r10, r11);
        return;
    L6:
        if (r10 < r13) goto L8;
        r14 = this.right;
        r10 = r10 - r13;
        goto L5
    L8:
        int r15 = r13 - r10;
        this.left.writeToInternal(r8, r10, r15);
        r14 = this.right;
        r10 = 0;
        r11 = r11 - r15;
        goto L5
    }

    @Override // com.google.protobuf.ByteString
    public void writeToReverse(ByteOutput r8) {
        this.right.writeToReverse(r8);
        this.left.writeToReverse(r8);
    }

    public /* synthetic */ RopeByteString(ByteString r8, ByteString r10, AnonymousClass1 r11) {
        this(r8, r10);
    }

    @Override // com.google.protobuf.ByteString, java.lang.Iterable
    /* JADX INFO: renamed from: iterator, reason: avoid collision after fix types in other method */
    public /* bridge */ /* synthetic */ Iterator<Byte> iterator2() {
        return iterator();
    }

    @Override // com.google.protobuf.ByteString
    public void writeTo(OutputStream r8) {
        this.left.writeTo(r8);
        this.right.writeTo(r8);
    }
}
