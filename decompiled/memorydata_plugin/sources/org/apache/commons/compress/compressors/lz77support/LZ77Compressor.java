package org.apache.commons.compress.compressors.lz77support;

import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public class LZ77Compressor {
    private static final Block THE_EOD = null;
    private int blockStart;
    private final Callback callback;
    private int currentPosition;
    private final int[] head;
    private boolean initialized;
    private int insertHash;
    private int lookahead;
    private int matchStart;
    private int missedInserts;
    private final Parameters params;
    private final int[] prev;
    private final int wMask;
    private final byte[] window;

    public static final class BackReference extends Block {
        private final int length;
        private final int offset;

        public BackReference(int r1, int r2) {
            this.offset = r1;
            this.length = r2;
        }

        public int getLength() {
            return this.length;
        }

        public int getOffset() {
            return this.offset;
        }

        @Override // org.apache.commons.compress.compressors.lz77support.LZ77Compressor.Block
        public Block.BlockType getType() {
            return Block.BlockType.BACK_REFERENCE;
        }

        public String toString() {
            return "BackReference with offset " + this.offset + " and length " + this.length;
        }
    }

    public static abstract class Block {

        public static final enum BlockType extends Enum<BlockType> {
            private static final /* synthetic */ BlockType[] $VALUES = null;
            public static final BlockType BACK_REFERENCE = null;
            public static final BlockType EOD = null;
            public static final BlockType LITERAL = null;

            static {
                BlockType r0 = new BlockType("LITERAL", 0);
                LITERAL = r0;
                BlockType r1 = new BlockType("BACK_REFERENCE", 1);
                BACK_REFERENCE = r1;
                BlockType r3 = new BlockType("EOD", 2);
                EOD = r3;
                $VALUES = new BlockType[]{r0, r1, r3};
            }

            private BlockType(String r1, int r2) {
                super(r1, r2);
            }

            public static BlockType valueOf(String r2) {
                return (BlockType) ZeusTransformUtils.preCheckCast(Enum.valueOf(BlockType.class, r2), BlockType.class, "com.obric.memorydata.plugin");
            }

            public static BlockType[] values() {
                return (BlockType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), BlockType[].class, "com.obric.memorydata.plugin");
            }
        }

        public Block() {
        }

        public abstract BlockType getType();
    }

    public interface Callback {
        void accept(Block r1);
    }

    public static final class EOD extends Block {
        public EOD() {
        }

        @Override // org.apache.commons.compress.compressors.lz77support.LZ77Compressor.Block
        public Block.BlockType getType() {
            return Block.BlockType.EOD;
        }
    }

    public static final class LiteralBlock extends Block {
        private final byte[] data;
        private final int length;
        private final int offset;

        public LiteralBlock(byte[] r1, int r2, int r3) {
            this.data = r1;
            this.offset = r2;
            this.length = r3;
        }

        public byte[] getData() {
            return this.data;
        }

        public int getLength() {
            return this.length;
        }

        public int getOffset() {
            return this.offset;
        }

        @Override // org.apache.commons.compress.compressors.lz77support.LZ77Compressor.Block
        public Block.BlockType getType() {
            return Block.BlockType.LITERAL;
        }

        public String toString() {
            return "LiteralBlock starting at " + this.offset + " with length " + this.length;
        }
    }

    static {
        THE_EOD = new EOD();
    }

    public LZ77Compressor(Parameters r3, Callback r4) {
        Callback r5 = (Callback) ZeusTransformUtils.wrapperContextForParams(r4, Callback.class, "com.obric.memorydata.plugin");
        this.matchStart = -1;
        Objects.requireNonNull(r3, TrackerImpl.PARAMS);
        Objects.requireNonNull(r5, "callback");
        this.params = r3;
        this.callback = r5;
        int r6 = r3.getWindowSize();
        this.window = new byte[r6 * 2];
        this.wMask = r6 - 1;
        int[] r7 = new int[32768];
        this.head = r7;
        Arrays.fill(r7, -1);
        this.prev = new int[r6];
    }

    private void catchUpMissedInserts() {
    L2:
        int r0 = this.missedInserts;
        if (r0 <= 0) goto L5;
        int r1 = this.currentPosition;
        this.missedInserts = r0 - 1;
        insertString(r1 - r0);
        goto L2
    }

    private void compress() {
        int r0 = this.params.getMinBackReferenceLength();
        boolean r1 = this.params.getLazyMatching();
        int r2 = this.params.getLazyMatchingThreshold();
    L4:
        if (this.lookahead < r0) goto L23;
        catchUpMissedInserts();
        int r3 = 0;
        int r4 = insertString(this.currentPosition);
        if (r4 != (-1)) goto L8;
    L15:
        if (r3 >= r0) goto L17;
        this.lookahead--;
        int r5 = this.currentPosition + 1;
        this.currentPosition = r5;
        if ((r5 - this.blockStart) < this.params.getMaxLiteralLength()) goto L4;
        flushLiteralBlock();
        this.blockStart = this.currentPosition;
        goto L4
    L17:
        if (this.blockStart == this.currentPosition) goto L19;
        flushLiteralBlock();
        this.blockStart = -1;
    L19:
        flushBackReference(r3);
        insertStringsInMatch(r3);
        this.lookahead -= r3;
        int r6 = this.currentPosition + r3;
        this.currentPosition = r6;
        this.blockStart = r6;
        goto L4
    L8:
        if ((r4 - this.currentPosition) > this.params.getMaxOffset()) goto L15;
        r3 = longestMatch(r4);
        if (r1 == false) goto L15;
        if (r3 > r2) goto L15;
        if (this.lookahead <= r0) goto L15;
        r3 = longestMatchForNextPosition(r3);
        goto L15
    }

    private void doCompress(byte[] r4, int r5, int r6) {
        if (r6 <= ((this.window.length - this.currentPosition) - this.lookahead)) goto L5;
        slide();
    L5:
        System.arraycopy(r4, r5, this.window, this.currentPosition + this.lookahead, r6);
        int r7 = this.lookahead + r6;
        this.lookahead = r7;
        if (this.initialized == true) goto L11;
        if (r7 < this.params.getMinBackReferenceLength()) goto L11;
        initialize();
    L11:
        if (this.initialized == false) goto L14;
        compress();
        return;
    }

    private void flushBackReference(int r4) {
        this.callback.accept(new BackReference(this.currentPosition - this.matchStart, r4));
    }

    private void flushLiteralBlock() {
        Callback r0 = this.callback;
        byte[] r2 = this.window;
        int r3 = this.blockStart;
        r0.accept(new LiteralBlock(r2, r3, this.currentPosition - r3));
    }

    private void initialize() {
        int r0 = 0;
    L4:
        if (r0 >= 2) goto L6;
        this.insertHash = nextHash(this.insertHash, this.window[r0]);
        r0 = r0 + 1;
        goto L4
    L6:
        this.initialized = true;
    }

    private int insertString(int r5) {
        int r0 = nextHash(this.insertHash, this.window[(r5 - 1) + 3]);
        this.insertHash = r0;
        int[] r1 = this.head;
        int r2 = r1[r0];
        this.prev[this.wMask & r5] = r2;
        r1[r0] = r5;
        return r2;
    }

    private void insertStringsInMatch(int r5) {
        int r0 = Math.min(r5 - 1, this.lookahead - 3);
        int r2 = 1;
    L3:
        if (r2 > r0) goto L5;
        insertString(this.currentPosition + r2);
        r2 = r2 + 1;
        goto L3
    L5:
        this.missedInserts = (r5 - r0) - 1;
    }

    private int longestMatch(int r13) {
        int r0 = this.params.getMinBackReferenceLength() - 1;
        int r1 = Math.min(this.params.getMaxBackReferenceLength(), this.lookahead);
        int r2 = Math.max(0, this.currentPosition - this.params.getMaxOffset());
        int r4 = Math.min(r1, this.params.getNiceBackReferenceLength());
        int r5 = this.params.getMaxCandidates();
        int r6 = 0;
    L3:
        if (r6 >= r5) goto L16;
        if (r13 < r2) goto L16;
        int r7 = 0;
        int r8 = 0;
    L6:
        if (r7 >= r1) goto L11;
        byte[] r9 = this.window;
        if (r9[r13 + r7] != r9[this.currentPosition + r7]) goto L11;
        r8 = r8 + 1;
        r7 = r7 + 1;
    L11:
        if (r8 <= r0) goto L15;
        this.matchStart = r13;
        r0 = r8;
        if (r8 >= r4) goto L16;
    L15:
        r13 = this.prev[r13 & this.wMask];
        r6 = r6 + 1;
    L16:
        return r0;
    }

    private int longestMatchForNextPosition(int r7) {
        int r0 = this.matchStart;
        int r1 = this.insertHash;
        this.lookahead--;
        int r2 = this.currentPosition + 1;
        this.currentPosition = r2;
        int r3 = insertString(r2);
        int r4 = this.prev[this.currentPosition & this.wMask];
        int r5 = longestMatch(r3);
        if (r5 > r7) goto L6;
        this.matchStart = r0;
        this.head[this.insertHash] = r4;
        this.insertHash = r1;
        this.currentPosition--;
        this.lookahead++;
        return r7;
    L6:
        return r5;
    }

    private int nextHash(int r1, byte r2) {
        return ((r2 & 255) ^ (r1 << 5)) & 32767;
    }

    private void slide() {
        int r0 = this.params.getWindowSize();
        int r1 = this.blockStart;
        if (r1 == this.currentPosition) goto L6;
        if (r1 >= r0) goto L6;
        flushLiteralBlock();
        this.blockStart = this.currentPosition;
    L6:
        byte[] r2 = this.window;
        int r3 = 0;
        System.arraycopy(r2, r0, r2, 0, r0);
        this.currentPosition -= r0;
        this.matchStart -= r0;
        this.blockStart -= r0;
        int r4 = 0;
    L7:
        int r5 = -1;
        if (r4 >= 32768) goto L13;
        int[] r6 = this.head;
        int r7 = r6[r4];
        if (r7 < r0) goto L12;
        r5 = r7 - r0;
    L12:
        r6[r4] = r5;
        r4 = r4 + 1;
    L13:
        if (r3 >= r0) goto L19;
        int[] r8 = this.prev;
        int r9 = r8[r3];
        if (r9 < r0) goto L17;
        int r10 = r9 - r0;
    L18:
        r8[r3] = r10;
        r3 = r3 + 1;
        goto L13
    L17:
        r10 = -1;
        goto L18
    }

    public void compress(byte[] r2, int r3, int r4) {
        int r0 = this.params.getWindowSize();
    L3:
        if (r4 <= r0) goto L5;
        doCompress(r2, r3, r0);
        r3 = r3 + r0;
        r4 = r4 - r0;
        goto L3
    L5:
        if (r4 <= 0) goto L9;
        doCompress(r2, r3, r4);
        return;
    }

    public void finish() {
        int r0 = this.blockStart;
        int r1 = this.currentPosition;
        if (r0 == r1) goto L5;
    L6:
        this.currentPosition = r1 + this.lookahead;
        flushLiteralBlock();
    L7:
        this.callback.accept(THE_EOD);
        return;
    L5:
        if (this.lookahead <= 0) goto L7;
        goto L6
    }

    public void prefill(byte[] r5) {
        if (this.currentPosition != 0) goto L16;
        if (this.lookahead != 0) goto L16;
        int r0 = Math.min(this.params.getWindowSize(), r5.length);
        int r3 = 0;
        System.arraycopy(r5, r5.length - r0, this.window, 0, r0);
        if (r0 < 3) goto L12;
        initialize();
        int r6 = (r0 - 3) + 1;
    L9:
        if (r3 >= r6) goto L11;
        insertString(r3);
        r3 = r3 + 1;
        goto L9
    L11:
        this.missedInserts = 2;
    L13:
        this.currentPosition = r0;
        this.blockStart = r0;
        return;
    L12:
        this.missedInserts = r0;
    L16:
        throw new IllegalStateException("The compressor has already started to accept data, can't prefill anymore");
    }
}
