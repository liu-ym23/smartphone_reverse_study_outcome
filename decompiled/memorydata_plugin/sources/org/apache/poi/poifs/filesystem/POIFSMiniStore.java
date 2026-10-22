package org.apache.poi.poifs.filesystem;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.poifs.property.RootProperty;
import org.apache.poi.poifs.storage.BATBlock;
import org.apache.poi.poifs.storage.HeaderBlock;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: loaded from: classes7.dex */
public class POIFSMiniStore extends BlockStore {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final POIFSFileSystem _filesystem;
    private final HeaderBlock _header;
    private POIFSStream _mini_stream;
    private final RootProperty _root;
    private final List<BATBlock> _sbat_blocks;

    static {
    }

    POIFSMiniStore(POIFSFileSystem r3, RootProperty r4, List<BATBlock> r5, HeaderBlock r6) {
        List<BATBlock> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L7;
        this._filesystem = r3;
        this._sbat_blocks = r7;
        this._header = r6;
        this._root = r4;
        this._mini_stream = new POIFSStream(r3, r4.getStartBlock());
        return;
    L7:
        throw new RecordFormatException("Invalid argument to POIFSMiniStore: root is null");
    }

    @Override // org.apache.poi.poifs.filesystem.BlockStore
    public ByteBuffer createBlockIfNeeded(int r6) {
        if (this._mini_stream.getStartBlock() != (-2)) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L20;
    L9:
        int r2 = this._filesystem.getFreeBlock();
        this._filesystem.createBlockIfNeeded(r2);
        if (r0 == false) goto L12;
        this._filesystem._get_property_table().getRoot().setStartBlock(r2);
        this._mini_stream = new POIFSStream(this._filesystem, r2);
    L16:
        this._filesystem.setNextBlock(r2, -2);
        return createBlockIfNeeded(r6);
    L12:
        BlockStore.ChainLoopDetector r1 = this._filesystem.getChainLoopDetector();
        int r3 = this._mini_stream.getStartBlock();
    L13:
        r1.claim(r3);
        int r4 = this._filesystem.getNextBlock(r3);
        if (r4 == (-2)) goto L15;
        r3 = r4;
        goto L13
    L15:
        this._filesystem.setNextBlock(r3, r2);
        goto L16
    L20:
        return getBlockAt(r6);
    L5:
        r0 = false;
        goto L6
    }

    public BATBlock.BATBlockAndIndex getBATBlockAndIndex(int r2) {
        return BATBlock.getSBATBlockAndIndex(r2, this._header, this._sbat_blocks);
    }

    @Override // org.apache.poi.poifs.filesystem.BlockStore
    public ByteBuffer getBlockAt(int r5) {
        int r6 = r5 * 64;
        int r1 = r6 / this._filesystem.getBigBlockSize();
        int r7 = r6 % this._filesystem.getBigBlockSize();
        Iterator<Integer> r2 = this._mini_stream.getBlockOffsetIterator();
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L5;
        r2.next();
        r3 = r3 + 1;
        goto L3
    L5:
        ByteBuffer r4 = this._filesystem.getBlockAt(((Integer) ZeusTransformUtils.preCheckCast(r2.next(), Integer.class, "com.obric.memorydata.plugin")).intValue());
        r4.position(r4.position() + r7);
        ByteBuffer r8 = r4.slice();
        r8.limit(64);
        return r8;
    }

    @Override // org.apache.poi.poifs.filesystem.BlockStore
    public int getBlockStoreBlockSize() {
        return 64;
    }

    @Override // org.apache.poi.poifs.filesystem.BlockStore
    public BlockStore.ChainLoopDetector getChainLoopDetector() {
        return new BlockStore.ChainLoopDetector(this, this._root.getSize());
    }

    @Override // org.apache.poi.poifs.filesystem.BlockStore
    public int getFreeBlock() {
        int r0 = this._filesystem.getBigBlockSizeDetails().getBATEntriesPerBlock();
        Iterator<BATBlock> r1 = this._sbat_blocks.iterator();
        int r3 = 0;
    L4:
        if (r1.hasNext() == false) goto L15;
        BATBlock r4 = (BATBlock) ZeusTransformUtils.preCheckCast(r1.next(), BATBlock.class, "com.obric.memorydata.plugin");
        if (r4.hasFreeSectors() == false) goto L14;
        int r5 = 0;
    L8:
        if (r5 >= r0) goto L14;
        if (r4.getValueAt(r5) == (-1)) goto L12;
        r5 = r5 + 1;
        goto L8
    L12:
        return r3 + r5;
    L14:
        r3 = r3 + r0;
        goto L4
    L15:
        BATBlock r2 = BATBlock.createEmptyBATBlock(this._filesystem.getBigBlockSizeDetails(), false);
        int r6 = this._filesystem.getFreeBlock();
        r2.setOurBlockIndex(r6);
        if (this._header.getSBATCount() != 0) goto L18;
        this._header.setSBATStart(r6);
        this._header.setSBATBlockCount(1);
    L22:
        this._filesystem.setNextBlock(r6, -2);
        this._sbat_blocks.add(r2);
        return r3;
    L18:
        BlockStore.ChainLoopDetector r7 = this._filesystem.getChainLoopDetector();
        int r8 = this._header.getSBATStart();
    L19:
        r7.claim(r8);
        int r9 = this._filesystem.getNextBlock(r8);
        if (r9 == (-2)) goto L21;
        r8 = r9;
        goto L19
    L21:
        this._filesystem.setNextBlock(r8, r6);
        HeaderBlock r10 = this._header;
        r10.setSBATBlockCount(r10.getSBATCount() + 1);
        goto L22
    }

    @Override // org.apache.poi.poifs.filesystem.BlockStore
    public int getNextBlock(int r1) {
        BATBlock.BATBlockAndIndex r0 = getBATBlockAndIndex(r1);
        return r0.getBlock().getValueAt(r0.getIndex());
    }

    @Override // org.apache.poi.poifs.filesystem.BlockStore
    public void releaseBuffer(ByteBuffer r1) {
        this._filesystem.releaseBuffer(r1);
    }

    @Override // org.apache.poi.poifs.filesystem.BlockStore
    public void setNextBlock(int r1, int r2) {
        BATBlock.BATBlockAndIndex r0 = getBATBlockAndIndex(r1);
        r0.getBlock().setValueAt(r0.getIndex(), r2);
    }
}
