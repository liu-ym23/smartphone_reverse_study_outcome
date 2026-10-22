package androidx.room.jarjarred.kotlinx.metadata.internal.protobuf;

import ai.j0;
import androidx.constraintlayout.motion.widget.a;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;
import kotlin.UByte;

/* JADX INFO: loaded from: classes.dex */
class RopeByteString extends ByteString {
    private static final int[] minLengthByDepth = null;
    private int hash;
    private final ByteString left;
    private final int leftLength;
    private final ByteString right;
    private final int totalLength;
    private final int treeDepth;

    /* JADX INFO: renamed from: androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.RopeByteString$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Balancer {
        private final Stack<ByteString> prefixesStack;

        private Balancer() {
            this.prefixesStack = new Stack();
        }

        public static /* synthetic */ ByteString access$100(Balancer r5, ByteString r10, ByteString r11) {
            return r5.balance(r10, r11);
        }

        private ByteString balance(ByteString r5, ByteString r10) {
            doBalance(r5);
            doBalance(r10);
            ByteString r11 = this.prefixesStack.pop();
        L4:
            if (this.prefixesStack.isEmpty() == true) goto L6;
            r11 = new RopeByteString(this.prefixesStack.pop(), r11, null);
            goto L4
        L6:
            return r11;
        }

        private void doBalance(ByteString r5) {
            if (r5.isBalanced() == false) goto L6;
            insert(r5);
            return;
        L6:
            if ((r5 instanceof RopeByteString) == false) goto L9;
            RopeByteString r10 = (RopeByteString) r5;
            doBalance(RopeByteString.access$400(r10));
            doBalance(RopeByteString.access$500(r10));
            return;
        L9:
            String r11 = String.valueOf(r5.getClass());
            throw new IllegalArgumentException(j0.q(new StringBuilder(r11.length() + 49), "Has a new type of ByteString been created? Found ", r11));
        }

        private int getDepthBinForLength(int r5) {
            int r10 = Arrays.binarySearch(RopeByteString.access$600(), r5);
            if (r10 < 0) goto L5;
            return r10;
        L5:
            return (-(r10 + 1)) - 1;
        }

        private void insert(ByteString r10) {
            int r5 = getDepthBinForLength(r10.size());
            int r11 = RopeByteString.access$600()[r5 + 1];
            if (this.prefixesStack.isEmpty() == false) goto L5;
        L20:
            this.prefixesStack.push(r10);
            return;
        L5:
            if (this.prefixesStack.peek().size() >= r11) goto L20;
            int r12 = RopeByteString.access$600()[r5];
            ByteString r13 = this.prefixesStack.pop();
        L8:
            AnonymousClass1 r14 = null;
            if (this.prefixesStack.isEmpty() == true) goto L13;
            if (this.prefixesStack.peek().size() >= r12) goto L13;
            r13 = new RopeByteString(this.prefixesStack.pop(), r13, r14);
        L13:
            RopeByteString r15 = new RopeByteString(r13, r10, r14);
        L15:
            if (this.prefixesStack.isEmpty() == true) goto L19;
            int r16 = getDepthBinForLength(r15.size());
            int r17 = RopeByteString.access$600()[r16 + 1];
            if (this.prefixesStack.peek().size() >= r17) goto L19;
            r15 = new RopeByteString(this.prefixesStack.pop(), r15, r14);
        L19:
            this.prefixesStack.push(r15);
        }

        public /* synthetic */ Balancer(AnonymousClass1 r5) {
            this();
        }
    }

    public static class PieceIterator implements Iterator<LiteralByteString> {
        private final Stack<RopeByteString> breadCrumbs;
        private LiteralByteString next;

        public /* synthetic */ PieceIterator(ByteString r5, AnonymousClass1 r10) {
            this(r5);
        }

        private LiteralByteString getLeafByLeft(ByteString r5) {
        L3:
            if ((r5 instanceof RopeByteString) == false) goto L6;
            RopeByteString r10 = (RopeByteString) r5;
            this.breadCrumbs.push(r10);
            r5 = RopeByteString.access$400(r10);
            goto L3
        L6:
            return (LiteralByteString) r5;
        }

        private LiteralByteString getNextNonEmptyLeaf() {
        L3:
            if (this.breadCrumbs.isEmpty() == true) goto L4;
            LiteralByteString r5 = getLeafByLeft(RopeByteString.access$500(this.breadCrumbs.pop()));
            if (r5.isEmpty() == true) goto L3;
            return r5;
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
            return next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private PieceIterator(ByteString r5) {
            this.breadCrumbs = new Stack();
            this.next = getLeafByLeft(r5);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public LiteralByteString next() {
            LiteralByteString r5 = this.next;
            if (r5 == null) goto L7;
            this.next = getNextNonEmptyLeaf();
            return r5;
        L7:
            throw new NoSuchElementException();
        }
    }

    public class RopeByteIterator implements ByteString.ByteIterator {
        private ByteString.ByteIterator bytes;
        int bytesRemaining;
        private final PieceIterator pieces;
        final /* synthetic */ RopeByteString this$0;

        public /* synthetic */ RopeByteIterator(RopeByteString r5, AnonymousClass1 r10) {
            this(r5);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.bytesRemaining <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Byte next() {
            return next();
        }

        /* JADX WARN: Type inference failed for: r0v6, types: [androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.ByteString$ByteIterator] */
        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.ByteString.ByteIterator
        public byte nextByte() {
            if (this.bytes.hasNext() == true) goto L5;
            this.bytes = this.pieces.next().iterator();
        L5:
            this.bytesRemaining--;
            return this.bytes.nextByte();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.ByteString$ByteIterator] */
        private RopeByteIterator(RopeByteString r5) {
            this.this$0 = r5;
            PieceIterator r10 = new PieceIterator(r5, null);
            this.pieces = r10;
            this.bytes = r10.next().iterator();
            this.bytesRemaining = r5.size();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Byte next() {
            return Byte.valueOf(nextByte());
        }
    }

    public class RopeInputStream extends InputStream {
        private LiteralByteString currentPiece;
        private int currentPieceIndex;
        private int currentPieceOffsetInRope;
        private int currentPieceSize;
        private int mark;
        private PieceIterator pieceIterator;
        final /* synthetic */ RopeByteString this$0;

        public RopeInputStream(RopeByteString r5) {
            this.this$0 = r5;
            initialize();
        }

        private void advanceIfCurrentPieceFullyRead() {
            if (this.currentPiece == null) goto L11;
            int r5 = this.currentPieceIndex;
            int r10 = this.currentPieceSize;
            if (r5 != r10) goto L12;
            this.currentPieceOffsetInRope += r10;
            this.currentPieceIndex = 0;
            if (this.pieceIterator.hasNext() == false) goto L9;
            LiteralByteString r11 = this.pieceIterator.next();
            this.currentPiece = r11;
            this.currentPieceSize = r11.size();
            return;
        L9:
            this.currentPiece = null;
            this.currentPieceSize = 0;
            return;
        L12:
            return;
        }

        private void initialize() {
            PieceIterator r5 = new PieceIterator(this.this$0, null);
            this.pieceIterator = r5;
            LiteralByteString r10 = r5.next();
            this.currentPiece = r10;
            this.currentPieceSize = r10.size();
            this.currentPieceIndex = 0;
            this.currentPieceOffsetInRope = 0;
        }

        private int readSkipInternal(byte[] r5, int r10, int r11) {
            int r12 = r11;
        L3:
            if (r12 <= 0) goto L14;
            advanceIfCurrentPieceFullyRead();
            if (this.currentPiece == null) goto L6;
            int r13 = Math.min(this.currentPieceSize - this.currentPieceIndex, r12);
            if (r5 == null) goto L12;
            this.currentPiece.copyTo(r5, this.currentPieceIndex, r10, r13);
            r10 = r10 + r13;
        L12:
            this.currentPieceIndex += r13;
            r12 = r12 - r13;
            goto L3
        L6:
            if (r12 != r11) goto L14;
            return -1;
        L14:
            return r11 - r12;
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            int r5 = this.currentPieceOffsetInRope + this.currentPieceIndex;
            return this.this$0.size() - r5;
        }

        @Override // java.io.InputStream
        public void mark(int r5) {
            this.mark = this.currentPieceOffsetInRope + this.currentPieceIndex;
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public int read(byte[] r5, int r10, int r11) {
            r5.getClass();
            if (r10 < 0) goto L10;
            if (r11 < 0) goto L10;
            if (r11 > (r5.length - r10)) goto L10;
            return readSkipInternal(r5, r10, r11);
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
        public long skip(long r5) {
            if (r5 < 0) goto L10;
            if (r5 <= 2147483647L) goto L8;
            r5 = 2147483647L;
        L8:
            return readSkipInternal(null, 0, (int) r5);
        L10:
            throw new IndexOutOfBoundsException();
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            advanceIfCurrentPieceFullyRead();
            LiteralByteString r5 = this.currentPiece;
            if (r5 != null) goto L6;
            return -1;
        L6:
            int r10 = this.currentPieceIndex;
            this.currentPieceIndex = r10 + 1;
            return r5.byteAt(r10) & UByte.MAX_VALUE;
        }
    }

    static {
        ArrayList r5 = new ArrayList();
        int r10 = 1;
        int r11 = 1;
    L3:
        if (r10 <= 0) goto L5;
        int r12 = j0.d(r10, r5, r11, r10);
        r11 = r10;
        r10 = r12;
        goto L3
    L5:
        r5.add(Integer.MAX_VALUE);
        minLengthByDepth = new int[r5.size()];
        int r13 = 0;
    L6:
        int[] r14 = minLengthByDepth;
        if (r13 >= r14.length) goto L9;
        r14[r13] = ((Integer) r5.get(r13)).intValue();
        r13 = r13 + 1;
        goto L6
    }

    public /* synthetic */ RopeByteString(ByteString r5, ByteString r10, AnonymousClass1 r11) {
        this(r5, r10);
    }

    public static /* synthetic */ ByteString access$400(RopeByteString r5) {
        return r5.left;
    }

    public static /* synthetic */ ByteString access$500(RopeByteString r5) {
        return r5.right;
    }

    public static /* synthetic */ int[] access$600() {
        return minLengthByDepth;
    }

    public static ByteString concatenate(ByteString r10, ByteString r11) {
        AnonymousClass1 r5 = null;
        if ((r10 instanceof RopeByteString) == false) goto L5;
        RopeByteString r12 = (RopeByteString) r10;
    L7:
        if (r11.size() != 0) goto L10;
        return r10;
    L10:
        if (r10.size() == 0) goto L30;
        int r13 = r11.size() + r10.size();
        if (r13 < 128) goto L31;
        if (r12 != null) goto L17;
    L19:
        if (r12 == null) goto L26;
        if (r12.left.getTreeDepth() <= r12.right.getTreeDepth()) goto L26;
        if (r12.getTreeDepth() <= r11.getTreeDepth()) goto L26;
        r11 = new RopeByteString(r12.left, new RopeByteString(r12.right, r11));
    L26:
        if (r13 < minLengthByDepth[Math.max(r10.getTreeDepth(), r11.getTreeDepth()) + 1]) goto L29;
        return new RopeByteString(r10, r11);
    L29:
        return Balancer.access$100(new Balancer(r5), r10, r11);
    L17:
        if ((r11.size() + r12.right.size()) >= 128) goto L19;
        r11 = new RopeByteString(r12.left, concatenateBytes(r12.right, r11));
        goto L30
    L31:
        return concatenateBytes(r10, r11);
    L30:
        return r11;
    L5:
        r12 = null;
        goto L7
    }

    private static LiteralByteString concatenateBytes(ByteString r5, ByteString r10) {
        int r11 = r5.size();
        int r12 = r10.size();
        byte[] r13 = new byte[r11 + r12];
        r5.copyTo(r13, 0, 0, r11);
        r10.copyTo(r13, 0, r11, r12);
        return new LiteralByteString(r13);
    }

    private boolean equalsFragments(ByteString r12) {
        AnonymousClass1 r5 = null;
        PieceIterator r10 = new PieceIterator(this, r5);
        LiteralByteString r11 = r10.next();
        PieceIterator r13 = new PieceIterator(r12, r5);
        LiteralByteString r14 = r13.next();
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
        r11 = r10.next();
        r15 = 0;
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

    public static RopeByteString newInstanceForTest(ByteString r5, ByteString r10) {
        return new RopeByteString(r5, r10);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.ByteString
    public ByteBuffer asReadOnlyByteBuffer() {
        return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.ByteString
    public List<ByteBuffer> asReadOnlyByteBufferList() {
        ArrayList r5 = new ArrayList();
        PieceIterator r10 = new PieceIterator(this, null);
    L4:
        if (r10.hasNext() == false) goto L6;
        r5.add(r10.next().asReadOnlyByteBuffer());
        goto L4
    L6:
        return r5;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.ByteString
    public byte byteAt(int r5) {
        if (r5 < 0) goto L13;
        if (r5 > this.totalLength) goto L10;
        int r10 = this.leftLength;
        if (r5 >= r10) goto L9;
        return this.left.byteAt(r5);
    L9:
        return this.right.byteAt(r5 - r10);
    L10:
        int r11 = this.totalLength;
        StringBuilder r12 = new StringBuilder(40);
        r12.append("Index > length: ");
        r12.append(r5);
        r12.append(", ");
        r12.append(r11);
        throw new ArrayIndexOutOfBoundsException(r12.toString());
    L13:
        throw new ArrayIndexOutOfBoundsException(a.i(22, "Index < 0: ", r5));
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.ByteString
    public void copyTo(ByteBuffer r5) {
        this.left.copyTo(r5);
        this.right.copyTo(r5);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.ByteString
    public void copyToInternal(byte[] r5, int r10, int r11, int r12) {
        int r13 = r10 + r12;
        int r14 = this.leftLength;
        if (r13 > r14) goto L5;
        this.left.copyToInternal(r5, r10, r11, r12);
        return;
    L5:
        if (r10 < r14) goto L7;
        this.right.copyToInternal(r5, r10 - r14, r11, r12);
        return;
    L7:
        int r15 = r14 - r10;
        this.left.copyToInternal(r5, r10, r11, r15);
        this.right.copyToInternal(r5, 0, r11 + r15, r12 - r15);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.ByteString
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof ByteString) == true) goto L8;
        return false;
    L8:
        ByteString r10 = (ByteString) r5;
        if (this.totalLength == r10.size()) goto L12;
        return false;
    L12:
        if (this.totalLength != 0) goto L15;
        return true;
    L15:
        if (this.hash == 0) goto L22;
        int r11 = r10.peekCachedHashCode();
        if (r11 == 0) goto L22;
        if (this.hash == r11) goto L22;
        return false;
    L22:
        return equalsFragments(r10);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.ByteString
    public int getTreeDepth() {
        return this.treeDepth;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.ByteString
    public int hashCode() {
        int r5 = this.hash;
        if (r5 != 0) goto L8;
        int r10 = this.totalLength;
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
        if (this.totalLength < minLengthByDepth[this.treeDepth]) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.ByteString
    public boolean isValidUtf8() {
        int r5 = this.left.partialIsValidUtf8(0, 0, this.leftLength);
        ByteString r10 = this.right;
        if (r10.partialIsValidUtf8(r5, 0, r10.size()) != 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.ByteString, java.lang.Iterable
    /* JADX INFO: renamed from: iterator, reason: avoid collision after fix types in other method */
    public /* bridge */ /* synthetic */ Iterator<Byte> iterator2() {
        return iterator();
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.ByteString
    public CodedInputStream newCodedInput() {
        return CodedInputStream.newInstance(new RopeInputStream(this));
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.ByteString
    public InputStream newInput() {
        return new RopeInputStream(this);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.ByteString
    public int partialHash(int r5, int r10, int r11) {
        int r12 = r10 + r11;
        int r13 = this.leftLength;
        if (r12 <= r13) goto L5;
        if (r10 >= r13) goto L8;
        int r14 = r13 - r10;
        int r15 = this.left.partialHash(r5, r10, r14);
        return this.right.partialHash(r15, 0, r11 - r14);
    L8:
        return this.right.partialHash(r5, r10 - r13, r11);
    L5:
        return this.left.partialHash(r5, r10, r11);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.ByteString
    public int partialIsValidUtf8(int r5, int r10, int r11) {
        int r12 = r10 + r11;
        int r13 = this.leftLength;
        if (r12 <= r13) goto L5;
        if (r10 >= r13) goto L8;
        int r14 = r13 - r10;
        int r15 = this.left.partialIsValidUtf8(r5, r10, r14);
        return this.right.partialIsValidUtf8(r15, 0, r11 - r14);
    L8:
        return this.right.partialIsValidUtf8(r5, r10 - r13, r11);
    L5:
        return this.left.partialIsValidUtf8(r5, r10, r11);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.ByteString
    public int peekCachedHashCode() {
        return this.hash;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.ByteString
    public int size() {
        return this.totalLength;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.ByteString
    public ByteString substring(int r5, int r10) {
        if (r5 < 0) goto L22;
        int r11 = this.totalLength;
        if (r10 > r11) goto L20;
        int r12 = r10 - r5;
        if (r12 < 0) goto L18;
        if (r12 == 0) goto L24;
        if (r12 == r11) goto L27;
        int r13 = this.leftLength;
        if (r10 <= r13) goto L25;
        if (r5 < r13) goto L17;
        return this.right.substring(r5 - r13, r10 - r13);
    L17:
        return new RopeByteString(this.left.substring(r5), this.right.substring(0, r10 - this.leftLength));
    L25:
        return this.left.substring(r5, r10);
    L27:
        return this;
    L24:
        return ByteString.EMPTY;
    L18:
        StringBuilder r14 = new StringBuilder(66);
        r14.append("Beginning index larger than ending index: ");
        r14.append(r5);
        r14.append(", ");
        r14.append(r10);
        throw new IndexOutOfBoundsException(r14.toString());
    L20:
        int r15 = this.totalLength;
        StringBuilder r16 = new StringBuilder(36);
        r16.append("End index: ");
        r16.append(r10);
        r16.append(" > ");
        r16.append(r15);
        throw new IndexOutOfBoundsException(r16.toString());
    L22:
        StringBuilder r17 = new StringBuilder(32);
        r17.append("Beginning index: ");
        r17.append(r5);
        r17.append(" < 0");
        throw new IndexOutOfBoundsException(r17.toString());
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.ByteString
    public String toString(String r5) throws UnsupportedEncodingException {
        return new String(toByteArray(), r5);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.ByteString
    public void writeTo(OutputStream r5) throws IOException {
        this.left.writeTo(r5);
        this.right.writeTo(r5);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.ByteString
    public void writeToInternal(OutputStream r5, int r10, int r11) throws IOException {
        int r12 = r10 + r11;
        int r13 = this.leftLength;
        if (r12 > r13) goto L5;
        this.left.writeToInternal(r5, r10, r11);
        return;
    L5:
        if (r10 < r13) goto L7;
        this.right.writeToInternal(r5, r10 - r13, r11);
        return;
    L7:
        int r14 = r13 - r10;
        this.left.writeToInternal(r5, r10, r14);
        this.right.writeToInternal(r5, 0, r11 - r14);
    }

    private RopeByteString(ByteString r5, ByteString r10) {
        this.hash = 0;
        this.left = r5;
        this.right = r10;
        int r11 = r5.size();
        this.leftLength = r11;
        this.totalLength = r10.size() + r11;
        this.treeDepth = Math.max(r5.getTreeDepth(), r10.getTreeDepth()) + 1;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.ByteString, java.lang.Iterable
    public Iterator<Byte> iterator() {
        return new RopeByteIterator(this, null);
    }
}
