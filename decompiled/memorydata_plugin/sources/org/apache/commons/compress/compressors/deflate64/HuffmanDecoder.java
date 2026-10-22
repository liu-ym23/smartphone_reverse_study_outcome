package org.apache.commons.compress.compressors.deflate64;

import java.io.Closeable;
import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteOrder;
import java.util.Arrays;
import okhttp3.internal.ws.WebSocketProtocol;
import org.apache.commons.compress.utils.BitInputStream;
import org.apache.commons.compress.utils.ByteUtils;

/* JADX INFO: loaded from: classes6.dex */
class HuffmanDecoder implements Closeable {
    private static final int[] CODE_LENGTHS_ORDER = null;
    private static final int[] DISTANCE_TABLE = null;
    private static final int[] FIXED_DISTANCE = null;
    private static final int[] FIXED_LITERALS = null;
    private static final short[] RUN_LENGTH_TABLE = null;
    private boolean finalBlock;
    private final InputStream in;
    private final DecodingMemory memory;
    private BitInputStream reader;
    private DecoderState state;

    /* JADX INFO: renamed from: org.apache.commons.compress.compressors.deflate64.HuffmanDecoder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class BinaryTreeNode {
        private final int bits;
        BinaryTreeNode leftNode;
        int literal;
        BinaryTreeNode rightNode;

        private BinaryTreeNode(int r2) {
            this.literal = -1;
            this.bits = r2;
        }

        /* synthetic */ BinaryTreeNode(int r1, AnonymousClass1 r2) {
            this(r1);
        }

        void leaf(int r1) {
            this.literal = r1;
            this.leftNode = null;
            this.rightNode = null;
        }

        BinaryTreeNode left() {
            if (this.leftNode != null) goto L8;
            if (this.literal != (-1)) goto L8;
            this.leftNode = new BinaryTreeNode(this.bits + 1);
        L8:
            return this.leftNode;
        }

        BinaryTreeNode right() {
            if (this.rightNode != null) goto L8;
            if (this.literal != (-1)) goto L8;
            this.rightNode = new BinaryTreeNode(this.bits + 1);
        L8:
            return this.rightNode;
        }
    }

    private static abstract class DecoderState {
        private DecoderState() {
        }

        /* synthetic */ DecoderState(AnonymousClass1 r1) {
            this();
        }

        abstract int available();

        abstract boolean hasData();

        abstract int read(byte[] r1, int r2, int r3);

        abstract HuffmanState state();
    }

    private static class DecodingMemory {
        private final int mask;
        private final byte[] memory;
        private int wHead;
        private boolean wrappedAround;

        private DecodingMemory() {
            this(16);
        }

        private DecodingMemory(int r2) {
            byte[] r3 = new byte[1 << r2];
            this.memory = r3;
            this.mask = r3.length - 1;
        }

        /* synthetic */ DecodingMemory(AnonymousClass1 r1) {
            this();
        }

        private int incCounter(int r3) {
            int r0 = (r3 + 1) & this.mask;
            if (this.wrappedAround == true) goto L6;
            if (r0 >= r3) goto L6;
            this.wrappedAround = true;
        L6:
            return r0;
        }

        byte add(byte r3) {
            byte[] r0 = this.memory;
            int r1 = this.wHead;
            r0[r1] = r3;
            this.wHead = incCounter(r1);
            return r3;
        }

        void add(byte[] r3, int r4, int r5) {
            int r0 = r4;
        L4:
            if (r0 >= (r4 + r5)) goto L6;
            add(r3[r0]);
            r0 = r0 + 1;
            goto L4
        }

        void recordToBuffer(int r4, int r5, byte[] r6) {
            if (r4 > this.memory.length) goto L15;
            int r0 = this.wHead;
            int r1 = (r0 - r4) & this.mask;
            if (this.wrappedAround == true) goto L10;
            if (r1 < r0) goto L10;
            throw new IllegalStateException("Attempt to read beyond memory: dist=" + r4);
        L10:
            int r7 = 0;
        L11:
            if (r7 >= r5) goto L13;
            r6[r7] = add(this.memory[r1]);
            r7 = r7 + 1;
            r1 = incCounter(r1);
            goto L11
        L13:
            return;
        L15:
            throw new IllegalStateException("Illegal distance parameter: " + r4);
        }
    }

    private class HuffmanCodes extends DecoderState {
        private final BinaryTreeNode distanceTree;
        private boolean endOfBlock;
        private final BinaryTreeNode lengthTree;
        private byte[] runBuffer;
        private int runBufferLength;
        private int runBufferPos;
        private final HuffmanState state;
        final /* synthetic */ HuffmanDecoder this$0;

        HuffmanCodes(HuffmanDecoder r1, HuffmanState r2, int[] r3, int[] r4) {
            this.this$0 = r1;
            super(null);
            this.runBuffer = ByteUtils.EMPTY_BYTE_ARRAY;
            this.state = r2;
            this.lengthTree = HuffmanDecoder.access$800(r3);
            this.distanceTree = HuffmanDecoder.access$800(r4);
        }

        private int copyFromRunBuffer(byte[] r3, int r4, int r5) {
            int r0 = this.runBufferLength - this.runBufferPos;
            if (r0 <= 0) goto L5;
            int r6 = Math.min(r5, r0);
            System.arraycopy(this.runBuffer, this.runBufferPos, r3, r4, r6);
            this.runBufferPos += r6;
            return r6;
        L5:
            return 0;
        }

        private int decodeNext(byte[] r8, int r9, int r10) {
            if (this.endOfBlock == false) goto L6;
            return -1;
        L6:
            int r0 = copyFromRunBuffer(r8, r9, r10);
        L7:
            if (r0 >= r10) goto L17;
            int r1 = HuffmanDecoder.access$900(HuffmanDecoder.access$400(this.this$0), this.lengthTree);
            if (r1 < 256) goto L10;
            if (r1 <= 256) goto L16;
            short r2 = HuffmanDecoder.access$1000()[r1 - 257];
            int r3 = (int) (((long) (r2 >>> 5)) + HuffmanDecoder.access$500(this.this$0, r2 & 31));
            int r4 = HuffmanDecoder.access$1100()[HuffmanDecoder.access$900(HuffmanDecoder.access$400(this.this$0), this.distanceTree)];
            int r5 = (int) (((long) (r4 >>> 4)) + HuffmanDecoder.access$500(this.this$0, r4 & 15));
            if (this.runBuffer.length >= r3) goto L15;
            this.runBuffer = new byte[r3];
        L15:
            this.runBufferLength = r3;
            this.runBufferPos = 0;
            HuffmanDecoder.access$600(this.this$0).recordToBuffer(r5, r3, this.runBuffer);
            r0 = r0 + copyFromRunBuffer(r8, r9 + r0, r10 - r0);
            goto L7
        L16:
            this.endOfBlock = true;
            goto L17
        L10:
            r8[r0 + r9] = HuffmanDecoder.access$600(this.this$0).add((byte) r1);
            r0 = r0 + 1;
        L17:
            return r0;
        }

        @Override // org.apache.commons.compress.compressors.deflate64.HuffmanDecoder.DecoderState
        int available() {
            return this.runBufferLength - this.runBufferPos;
        }

        @Override // org.apache.commons.compress.compressors.deflate64.HuffmanDecoder.DecoderState
        boolean hasData() {
            return !this.endOfBlock;
        }

        @Override // org.apache.commons.compress.compressors.deflate64.HuffmanDecoder.DecoderState
        int read(byte[] r1, int r2, int r3) {
            if (r3 != 0) goto L6;
            return 0;
        L6:
            return decodeNext(r1, r2, r3);
        }

        @Override // org.apache.commons.compress.compressors.deflate64.HuffmanDecoder.DecoderState
        HuffmanState state() {
            if (this.endOfBlock == false) goto L6;
            return HuffmanState.INITIAL;
        L6:
            return this.state;
        }
    }

    private static class InitialState extends DecoderState {
        private InitialState() {
            super(null);
        }

        /* synthetic */ InitialState(AnonymousClass1 r1) {
            this();
        }

        @Override // org.apache.commons.compress.compressors.deflate64.HuffmanDecoder.DecoderState
        int available() {
            return 0;
        }

        @Override // org.apache.commons.compress.compressors.deflate64.HuffmanDecoder.DecoderState
        boolean hasData() {
            return false;
        }

        @Override // org.apache.commons.compress.compressors.deflate64.HuffmanDecoder.DecoderState
        int read(byte[] r1, int r2, int r3) {
            if (r3 != 0) goto L6;
            return 0;
        L6:
            throw new IllegalStateException("Cannot read in this state");
        }

        @Override // org.apache.commons.compress.compressors.deflate64.HuffmanDecoder.DecoderState
        HuffmanState state() {
            return HuffmanState.INITIAL;
        }
    }

    private class UncompressedState extends DecoderState {
        private final long blockLength;
        private long read;
        final /* synthetic */ HuffmanDecoder this$0;

        private UncompressedState(HuffmanDecoder r1, long r2) {
            this.this$0 = r1;
            super(null);
            this.blockLength = r2;
        }

        /* synthetic */ UncompressedState(HuffmanDecoder r1, long r2, AnonymousClass1 r4) {
            this(r1, r2);
        }

        @Override // org.apache.commons.compress.compressors.deflate64.HuffmanDecoder.DecoderState
        int available() {
            return (int) Math.min(this.blockLength - this.read, HuffmanDecoder.access$400(this.this$0).bitsAvailable() / 8);
        }

        @Override // org.apache.commons.compress.compressors.deflate64.HuffmanDecoder.DecoderState
        boolean hasData() {
            if (this.read >= this.blockLength) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // org.apache.commons.compress.compressors.deflate64.HuffmanDecoder.DecoderState
        int read(byte[] r7, int r8, int r9) {
            int r0 = 0;
            if (r9 != 0) goto L5;
            return 0;
        L5:
            int r10 = (int) Math.min(this.blockLength - this.read, r9);
        L6:
            if (r0 >= r10) goto L16;
            if (HuffmanDecoder.access$400(this.this$0).bitsCached() <= 0) goto L10;
            r7[r8 + r0] = HuffmanDecoder.access$600(this.this$0).add((byte) HuffmanDecoder.access$500(this.this$0, 8));
            int r1 = 1;
        L13:
            this.read += (long) r1;
            r0 = r0 + r1;
            goto L6
        L10:
            int r2 = r8 + r0;
            r1 = HuffmanDecoder.access$700(this.this$0).read(r7, r2, r10 - r0);
            if (r1 == (-1)) goto L15;
            HuffmanDecoder.access$600(this.this$0).add(r7, r2, r1);
            goto L13
        L15:
            throw new EOFException("Truncated Deflate64 Stream");
        L16:
            return r10;
        }

        @Override // org.apache.commons.compress.compressors.deflate64.HuffmanDecoder.DecoderState
        HuffmanState state() {
            if (this.read >= this.blockLength) goto L6;
            return HuffmanState.STORED;
        L6:
            return HuffmanState.INITIAL;
        }
    }

    static {
        RUN_LENGTH_TABLE = new short[]{96, 128, 160, 192, 224, 256, 288, 320, 353, 417, 481, 545, 610, 738, 866, 994, 1123, 1379, 1635, 1891, 2148, 2660, 3172, 3684, 4197, 5221, 6245, 7269, 112};
        DISTANCE_TABLE = new int[]{16, 32, 48, 64, 81, 113, 146, 210, 275, 403, 532, 788, 1045, 1557, 2070, 3094, 4119, 6167, 8216, 12312, 16409, 24601, 32794, 49178, 65563, 98331, 131100, 196636, 262173, 393245, 524318, 786462};
        CODE_LENGTHS_ORDER = new int[]{16, 17, 18, 0, 8, 7, 9, 6, 10, 5, 11, 4, 12, 3, 13, 2, 14, 1, 15};
        int[] r2 = new int[288];
        FIXED_LITERALS = r2;
        Arrays.fill(r2, 0, 144, 8);
        Arrays.fill(r2, 144, 256, 9);
        Arrays.fill(r2, 256, 280, 7);
        Arrays.fill(r2, 280, 288, 8);
        int[] r0 = new int[32];
        FIXED_DISTANCE = r0;
        Arrays.fill(r0, 5);
    }

    HuffmanDecoder(InputStream r4) {
        AnonymousClass1 r1 = null;
        this.memory = new DecodingMemory(r1);
        this.reader = new BitInputStream(r4, ByteOrder.LITTLE_ENDIAN);
        this.in = r4;
        this.state = new InitialState(r1);
    }

    static /* synthetic */ short[] access$1000() {
        return RUN_LENGTH_TABLE;
    }

    static /* synthetic */ int[] access$1100() {
        return DISTANCE_TABLE;
    }

    static /* synthetic */ BitInputStream access$400(HuffmanDecoder r0) {
        return r0.reader;
    }

    static /* synthetic */ long access$500(HuffmanDecoder r0, int r1) {
        return r0.readBits(r1);
    }

    static /* synthetic */ DecodingMemory access$600(HuffmanDecoder r0) {
        return r0.memory;
    }

    static /* synthetic */ InputStream access$700(HuffmanDecoder r0) {
        return r0.in;
    }

    static /* synthetic */ BinaryTreeNode access$800(int[] r0) {
        return buildTree(r0);
    }

    static /* synthetic */ int access$900(BitInputStream r0, BinaryTreeNode r1) {
        return nextSymbol(r0, r1);
    }

    private static BinaryTreeNode buildTree(int[] r8) {
        int[] r0 = getCodes(r8);
        int r2 = 0;
        BinaryTreeNode r1 = new BinaryTreeNode(r2, null);
    L4:
        if (r2 >= r8.length) goto L20;
        int r3 = r8[r2];
        if (r3 == 0) goto L19;
        int r4 = r3 - 1;
        int r5 = r0[r4];
        BinaryTreeNode r6 = r1;
        int r7 = r4;
    L9:
        if (r7 < 0) goto L18;
        if (((1 << r7) & r5) != 0) goto L13;
        r6 = r6.left();
    L14:
        if (r6 == null) goto L17;
        r7 = r7 - 1;
        goto L9
    L17:
        throw new IllegalStateException("node doesn't exist in Huffman tree");
    L13:
        r6 = r6.right();
        goto L14
    L18:
        r6.leaf(r2);
        r0[r4] = r0[r4] + 1;
    L19:
        r2 = r2 + 1;
        goto L4
    L20:
        return r1;
    }

    private static int[] getCodes(int[] r7) {
        int[] r0 = new int[65];
        int r1 = r7.length;
        int r2 = 0;
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r3 >= r1) goto L11;
        int r5 = r7[r3];
        if (r5 < 0) goto L10;
        if (r5 > 64) goto L10;
        r4 = Math.max(r4, r5);
        r0[r5] = r0[r5] + 1;
        r3 = r3 + 1;
    L10:
        throw new IllegalArgumentException("Invalid code " + r5 + " in literal table");
    L11:
        int r8 = r4 + 1;
        int[] r6 = Arrays.copyOf(r0, r8);
        int[] r9 = new int[r8];
        int r10 = 0;
    L12:
        if (r2 > r4) goto L14;
        r10 = (r10 + r6[r2]) << 1;
        r9[r2] = r10;
        r2 = r2 + 1;
        goto L12
    L14:
        return r9;
    }

    private static int nextSymbol(BitInputStream r4, BinaryTreeNode r5) {
    L3:
        if (r5 == null) goto L10;
        if (r5.literal != (-1)) goto L10;
        if (readBits(r4, 1) == 0) goto L8;
        r5 = r5.rightNode;
        goto L3
    L8:
        r5 = r5.leftNode;
    L10:
        if (r5 != null) goto L12;
        return -1;
    L12:
        return r5.literal;
    }

    private static void populateDynamicTables(BitInputStream r11, int[] r12, int[] r13) {
        int r0 = (int) (readBits(r11, 4) + 4);
        int[] r1 = new int[19];
        int r3 = 0;
    L4:
        if (r3 >= r0) goto L6;
        r1[CODE_LENGTHS_ORDER[r3]] = (int) readBits(r11, 3);
        r3 = r3 + 1;
        goto L4
    L6:
        BinaryTreeNode r2 = buildTree(r1);
        int r4 = r12.length + r13.length;
        int[] r5 = new int[r4];
        int r6 = -1;
        int r7 = 0;
        int r8 = 0;
    L7:
        if (r7 >= r4) goto L20;
        if (r8 > 0) goto L9;
        int r9 = nextSymbol(r11, r2);
        if (r9 < 16) goto L12;
        long r10 = 3;
        switch(r9) {
            case 16: goto L19;
            case 17: goto L17;
            case 18: goto L16;
            default: goto L7;
        };
    L16:
        long r14 = readBits(r11, 7);
        r10 = 11;
    L18:
        r8 = (int) (r14 + r10);
        r6 = 0;
        goto L7
    L17:
        r14 = readBits(r11, 3);
        goto L18
    L19:
        r8 = (int) (readBits(r11, 2) + 3);
        goto L7
    L12:
        r5[r7] = r9;
        r7 = r7 + 1;
        r6 = r9;
        goto L7
    L9:
        r5[r7] = r6;
        r8 = r8 - 1;
        r7 = r7 + 1;
        goto L7
    L20:
        System.arraycopy(r5, 0, r12, 0, r12.length);
        System.arraycopy(r5, r12.length, r13, 0, r13.length);
    }

    private long readBits(int r1) {
        return readBits(this.reader, r1);
    }

    private static long readBits(BitInputStream r2, int r3) {
        long r4 = r2.readBits(r3);
        if (r4 == (-1)) goto L6;
        return r4;
    L6:
        throw new EOFException("Truncated Deflate64 Stream");
    }

    private int[][] readDynamicTables() {
        int[][] r0 = {new int[(int) (readBits(5) + 257)], new int[(int) (readBits(5) + 1)]};
        populateDynamicTables(this.reader, r0[0], r0[1]);
        return r0;
    }

    private void switchToUncompressedState() {
        this.reader.alignWithByteBoundary();
        long r1 = readBits(16);
        long r3 = readBits(16);
        if ((WebSocketProtocol.PAYLOAD_SHORT_MAX & (r1 ^ WebSocketProtocol.PAYLOAD_SHORT_MAX)) != r3) goto L7;
        this.state = new UncompressedState(this, r1, null);
        return;
    L7:
        throw new IllegalStateException("Illegal LEN / NLEN values");
    }

    int available() {
        return this.state.available();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.state = new InitialState(null);
        this.reader = null;
    }

    public int decode(byte[] r6, int r7, int r8) {
    L3:
        if (this.finalBlock == false) goto L10;
        if (this.state.hasData() == true) goto L10;
        return -1;
    L10:
        if (this.state.state() == HuffmanState.INITIAL) goto L12;
        int r0 = this.state.read(r6, r7, r8);
        if (r0 == 0) goto L3;
        return r0;
    L12:
        if (readBits(1) != 1) goto L14;
        boolean r1 = true;
    L15:
        this.finalBlock = r1;
        int r3 = (int) readBits(2);
        if (r3 != 0) goto L17;
        switchToUncompressedState();
        goto L3
    L17:
        if (r3 != 1) goto L18;
        this.state = new HuffmanCodes(this, HuffmanState.FIXED_CODES, FIXED_LITERALS, FIXED_DISTANCE);
        goto L3
    L18:
        if (r3 != 2) goto L21;
        int[][] r2 = readDynamicTables();
        this.state = new HuffmanCodes(this, HuffmanState.DYNAMIC_CODES, r2[0], r2[1]);
        goto L3
    L21:
        throw new IllegalStateException("Unsupported compression: " + r3);
    L14:
        r1 = false;
        goto L15
    }

    long getBytesRead() {
        return this.reader.getBytesRead();
    }
}
