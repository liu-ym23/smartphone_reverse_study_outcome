package org.apache.poi.poifs.filesystem;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes7.dex */
public abstract class BlockStore {

    protected class ChainLoopDetector {
        final /* synthetic */ BlockStore this$0;
        private final boolean[] used_blocks;

        public ChainLoopDetector(BlockStore r7, long r8) {
            this.this$0 = r7;
            if (r8 < 0) goto L10;
            long r2 = r7.getBlockStoreBlockSize();
            int r9 = (int) (r8 / r2);
            if ((r8 % r2) == 0) goto L7;
            r9 = r9 + 1;
        L7:
            this.used_blocks = new boolean[r9];
            return;
        L10:
            throw new IllegalArgumentException("Cannot create a ChainLoopDetector with negative size, but had: " + r8);
        }

        public void claim(int r3) {
            boolean[] r2 = this.used_blocks;
            if (r3 < r2.length) goto L6;
            return;
        L6:
            if (r2[r3] == true) goto L10;
            r2[r3] = true;
            return;
        L10:
            throw new IllegalStateException("Potential loop detected - Block " + r3 + " was already claimed but was just requested again");
        }
    }

    public BlockStore() {
    }

    public abstract ByteBuffer createBlockIfNeeded(int r1);

    public abstract ByteBuffer getBlockAt(int r1);

    public abstract int getBlockStoreBlockSize();

    public abstract ChainLoopDetector getChainLoopDetector();

    public abstract int getFreeBlock();

    public abstract int getNextBlock(int r1);

    public abstract void releaseBuffer(ByteBuffer r1);

    public abstract void setNextBlock(int r1, int r2);
}
