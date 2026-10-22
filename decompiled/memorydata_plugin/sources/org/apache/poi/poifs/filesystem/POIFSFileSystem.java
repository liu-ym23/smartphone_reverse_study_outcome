package org.apache.poi.poifs.filesystem;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.EmptyFileException;
import org.apache.poi.poifs.common.POIFSBigBlockSize;
import org.apache.poi.poifs.common.POIFSConstants;
import org.apache.poi.poifs.nio.ByteArrayBackedDataSource;
import org.apache.poi.poifs.nio.DataSource;
import org.apache.poi.poifs.nio.FileBackedDataSource;
import org.apache.poi.poifs.property.DocumentProperty;
import org.apache.poi.poifs.property.PropertyTable;
import org.apache.poi.poifs.storage.BATBlock;
import org.apache.poi.poifs.storage.HeaderBlock;
import org.apache.poi.util.IOUtils;

/* JADX INFO: loaded from: classes7.dex */
public class POIFSFileSystem extends BlockStore implements Closeable {
    private static final c LOG = null;
    private static int MAX_RECORD_LENGTH = 100000;
    private final List<BATBlock> _bat_blocks;
    protected DataSource _data;
    private HeaderBlock _header;
    private POIFSMiniStore _mini_store;
    private PropertyTable _property_table;
    private DirectoryNode _root;
    private final List<BATBlock> _xbat_blocks;
    private POIFSBigBlockSize bigBlockSize;

    static {
        LOG = b.a(POIFSFileSystem.class);
    }

    public POIFSFileSystem() {
        this(true);
        this._header.setBATCount(1);
        this._header.setBATArray(new int[]{1});
        BATBlock r1 = BATBlock.createEmptyBATBlock(this.bigBlockSize, false);
        r1.setOurBlockIndex(1);
        this._bat_blocks.add(r1);
        setNextBlock(0, -2);
        setNextBlock(1, -3);
        this._property_table.setStartBlock(0);
    }

    public POIFSFileSystem(File r2) {
        this(r2, true);
    }

    public POIFSFileSystem(File r7, boolean r8) {
        this(null, r7, r8, true, true);
    }

    public POIFSFileSystem(InputStream r8) {
        this(false);
        ReadableByteChannel r1 = Channels.newChannel(r8);     // Catch: Throwable -> L23
        ByteBuffer r2 = ByteBuffer.allocate(512);     // Catch: Throwable -> L14
        IOUtils.readFully(r1, r2);     // Catch: Throwable -> L14
        HeaderBlock r3 = new HeaderBlock(r2);     // Catch: Throwable -> L14
        this._header = r3;     // Catch: Throwable -> L14
        sanityCheckBlockCount(r3.getBATCount());     // Catch: Throwable -> L14
        long r4 = BATBlock.calculateMaximumSize(this._header);     // Catch: Throwable -> L14
        if (r4 > 2147483647L) goto L13;
        IOUtils.safelyAllocateCheck(r4, 250000000);     // Catch: Throwable -> L14
        ByteBuffer r5 = ByteBuffer.allocate((int) r4);     // Catch: Throwable -> L14
        r2.position(0);     // Catch: Throwable -> L14
        r5.put(r2);     // Catch: Throwable -> L14
        r5.position(r2.capacity());     // Catch: Throwable -> L14
        IOUtils.readFully(r1, r5);     // Catch: Throwable -> L14
        this._data = new ByteArrayBackedDataSource(r5.array(), r5.position());     // Catch: Throwable -> L14
        if (r1 == null) goto L10;
        r1.close();     // Catch: Throwable -> L23
    L10:
        closeInputStream(r8, true);
        readCoreContents();
        return;
    L13:
        throw new IllegalArgumentException("Unable read a >2gb file via an InputStream");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        if (r1 != null) goto L26;
    L22:
        throw th;     // Catch: Throwable -> L23
    L26:
        r1.close();     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        closeInputStream(r8, false);
        throw th;
    }

    private POIFSFileSystem(FileChannel r5, File r6, boolean r7, boolean r8, boolean r9) {
        this(false);
        if (r6 != null) goto L5;
        this._data = new FileBackedDataSource(r5, r7, r9);     // Catch: Throwable -> L12
    L10:
        ByteBuffer r10 = ByteBuffer.allocate(512);     // Catch: Throwable -> L12
        IOUtils.readFully(r5, r10);     // Catch: Throwable -> L12
        this._header = new HeaderBlock(r10);     // Catch: Throwable -> L12
        readCoreContents();     // Catch: Throwable -> L12
        return;
    L5:
        if (r6.length() == 0) goto L8;
        FileBackedDataSource r11 = new FileBackedDataSource(r6, r7);     // Catch: Throwable -> L12
        r5 = r11.getChannel();     // Catch: Throwable -> L12
        this._data = r11;     // Catch: Throwable -> L12
        goto L10
    L8:
        throw new EmptyFileException(r6);     // Catch: Throwable -> L12
    L12:
        e = move-exception;
        if (r8 == false) goto L16;
        if (r5 == null) goto L16;
        r5.close();
    L16:
        throw e;
    }

    private POIFSFileSystem(boolean r5) {
        this.bigBlockSize = POIFSConstants.SMALLER_BIG_BLOCK_SIZE_DETAILS;
        this._header = new HeaderBlock(this.bigBlockSize);
        this._property_table = new PropertyTable(this._header);
        this._mini_store = new POIFSMiniStore(this, this._property_table.getRoot(), new ArrayList(), this._header);
        this._xbat_blocks = new ArrayList();
        this._bat_blocks = new ArrayList();
        this._root = null;
        if (r5 == false) goto L6;
        createNewDataSource();
        return;
    }

    private void closeInputStream(InputStream r1, boolean r2) {
        r1.close();     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        if (r2 == true) goto L9;
        LOG.atError().a(e).a("can't close input stream");
        return;
    L9:
        throw new RuntimeException(e);
    }

    private BATBlock createBAT(int r6, boolean r7) {
        BATBlock r8 = BATBlock.createEmptyBATBlock(this.bigBlockSize, !r7);
        r8.setOurBlockIndex(r6);
        this._data.write(ByteBuffer.allocate(this.bigBlockSize.getBigBlockSize()), Math.multiplyExact(((long) r6) + 1, this.bigBlockSize.getBigBlockSize()));
        return r8;
    }

    public static int getMaxRecordLength() {
        return MAX_RECORD_LENGTH;
    }

    private void readBAT(int r2, BlockStore.ChainLoopDetector r3) {
        r3.claim(r2);
        ByteBuffer r4 = getBlockAt(r2);
        BATBlock r5 = BATBlock.createBATBlock(this.bigBlockSize, r4);
        r5.setOurBlockIndex(r2);
        this._bat_blocks.add(r5);
    }

    private void readCoreContents() {
        this.bigBlockSize = this._header.getBigBlockSize();
        BlockStore.ChainLoopDetector r0 = getChainLoopDetector();
        int[] r1 = this._header.getBATArray();
        int r2 = r1.length;
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L5;
        readBAT(r1[r4], r0);
        r4 = r4 + 1;
        goto L3
    L5:
        int r5 = this._header.getBATCount() - this._header.getBATArray().length;
        int r6 = this._header.getXBATIndex();
        int r7 = 0;
    L7:
        if (r7 >= this._header.getXBATCount()) goto L16;
        r0.claim(r6);
        BATBlock r8 = BATBlock.createBATBlock(this.bigBlockSize, getBlockAt(r6));
        r8.setOurBlockIndex(r6);
        r6 = r8.getValueAt(this.bigBlockSize.getXBATEntriesPerBlock());
        this._xbat_blocks.add(r8);
        int r9 = Math.min(r5, this.bigBlockSize.getXBATEntriesPerBlock());
        int r10 = 0;
    L9:
        if (r10 >= r9) goto L15;
        int r11 = r8.getValueAt(r10);
        if (r11 == (-1)) goto L15;
        if (r11 == (-2)) goto L15;
        readBAT(r11, r0);
        r10 = r10 + 1;
    L15:
        r5 = r5 - r9;
        r7 = r7 + 1;
        goto L7
    L16:
        this._property_table = new PropertyTable(this._header, this);
        ArrayList r12 = new ArrayList();
        this._mini_store = new POIFSMiniStore(this, this._property_table.getRoot(), r12, this._header);
        int r13 = this._header.getSBATStart();
    L18:
        if (r3 >= this._header.getSBATCount()) goto L21;
        if (r13 == (-2)) goto L29;
        r0.claim(r13);
        BATBlock r14 = BATBlock.createBATBlock(this.bigBlockSize, getBlockAt(r13));
        r14.setOurBlockIndex(r13);
        r12.add(r14);
        r13 = getNextBlock(r13);
        r3 = r3 + 1;
        goto L18
    L29:
        return;
    }

    private static void sanityCheckBlockCount(int r4) {
        if (r4 <= 0) goto L9;
        if (r4 > 65535) goto L7;
        return;
    L7:
        throw new IOException("Block count " + r4 + " is too high. POI maximum is 65535.");
    L9:
        throw new IOException("Illegal block count; minimum count is 1, got " + r4 + " instead");
    }

    PropertyTable _get_property_table() {
        return this._property_table;
    }

    void addDocument(POIFSDocument r1) {
        this._property_table.addProperty(r1.getDocumentProperty());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this._data.close();
    }

    @Override // org.apache.poi.poifs.filesystem.BlockStore
    public ByteBuffer createBlockIfNeeded(int r5) {
        return getBlockAt(r5);
    L4:
        long r0 = (((long) r5) + 1) * ((long) this.bigBlockSize.getBigBlockSize());
        ByteBuffer r2 = ByteBuffer.allocate(getBigBlockSize());
        this._data.write(r2, r0);
        return getBlockAt(r5);
    }

    public void createNewDataSource() {
        this._data = new ByteArrayBackedDataSource(IOUtils.safelyAllocate(Math.multiplyExact(this.bigBlockSize.getBigBlockSize(), 3), MAX_RECORD_LENGTH));
    }

    public BATBlock.BATBlockAndIndex getBATBlockAndIndex(int r2) {
        return BATBlock.getBATBlockAndIndex(r2, this._header, this._bat_blocks);
    }

    public int getBigBlockSize() {
        return this.bigBlockSize.getBigBlockSize();
    }

    public POIFSBigBlockSize getBigBlockSizeDetails() {
        return this.bigBlockSize;
    }

    @Override // org.apache.poi.poifs.filesystem.BlockStore
    public ByteBuffer getBlockAt(int r5) {
        return this._data.read(this.bigBlockSize.getBigBlockSize(), (((long) r5) + 1) * ((long) this.bigBlockSize.getBigBlockSize()));
    L5:
        e = move-exception;
        IndexOutOfBoundsException r0 = new IndexOutOfBoundsException("Block " + r5 + " not found");
        r0.initCause(e);
        throw r0;
    }

    @Override // org.apache.poi.poifs.filesystem.BlockStore
    public int getBlockStoreBlockSize() {
        return getBigBlockSize();
    }

    @Override // org.apache.poi.poifs.filesystem.BlockStore
    public BlockStore.ChainLoopDetector getChainLoopDetector() {
        return new BlockStore.ChainLoopDetector(this, this._data.size());
    }

    @Override // org.apache.poi.poifs.filesystem.BlockStore
    public int getFreeBlock() {
        int r0 = this.bigBlockSize.getBATEntriesPerBlock();
        Iterator<BATBlock> r1 = this._bat_blocks.iterator();
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r1.hasNext() == false) goto L15;
        BATBlock r4 = (BATBlock) ZeusTransformUtils.preCheckCast(r1.next(), BATBlock.class, "com.obric.memorydata.plugin");
        if (r4.hasFreeSectors() == false) goto L14;
        int r6 = 0;
    L8:
        if (r6 >= r0) goto L14;
        if (r4.getValueAt(r6) == (-1)) goto L12;
        r6 = r6 + 1;
        goto L8
    L12:
        return r3 + r6;
    L14:
        r3 = r3 + r0;
        goto L4
    L15:
        BATBlock r5 = createBAT(r3, true);
        r5.setValueAt(0, -3);
        this._bat_blocks.add(r5);
        if (this._header.getBATCount() < 109) goto L35;
        BATBlock r7 = null;
        Iterator<BATBlock> r8 = this._xbat_blocks.iterator();
    L19:
        if (r8.hasNext() == false) goto L23;
        BATBlock r9 = (BATBlock) ZeusTransformUtils.preCheckCast(r8.next(), BATBlock.class, "com.obric.memorydata.plugin");
        if (r9.hasFreeSectors() == false) goto L19;
        r7 = r9;
    L23:
        if (r7 != null) goto L30;
        int r10 = r3 + 1;
        BATBlock r11 = createBAT(r10, false);
        r11.setValueAt(0, r3);
        r5.setValueAt(1, -4);
        if (this._xbat_blocks.isEmpty() == false) goto L27;
        this._header.setXBATStart(r10);
    L28:
        this._xbat_blocks.add(r11);
        this._header.setXBATCount(this._xbat_blocks.size());
        r3 = r10;
    L36:
        this._header.setBATCount(this._bat_blocks.size());
        return r3 + 1;
    L27:
        List<BATBlock> r12 = this._xbat_blocks;
        ((BATBlock) ZeusTransformUtils.preCheckCast(r12.get(r12.size() - 1), BATBlock.class, "com.obric.memorydata.plugin")).setValueAt(this.bigBlockSize.getXBATEntriesPerBlock(), r10);
    L30:
        if (r2 >= this.bigBlockSize.getXBATEntriesPerBlock()) goto L36;
        if (r7.getValueAt(r2) == (-1)) goto L33;
        r2 = r2 + 1;
        goto L30
    L33:
        r7.setValueAt(r2, r3);
        goto L36
    L35:
        int r13 = this._header.getBATCount() + 1;
        int[] r14 = new int[r13];
        int r15 = r13 - 1;
        System.arraycopy(this._header.getBATArray(), 0, r14, 0, r15);
        r14[r15] = r3;
        this._header.setBATArray(r14);
        goto L36
    }

    POIFSMiniStore getMiniStore() {
        return this._mini_store;
    }

    @Override // org.apache.poi.poifs.filesystem.BlockStore
    public int getNextBlock(int r1) {
        BATBlock.BATBlockAndIndex r0 = getBATBlockAndIndex(r1);
        return r0.getBlock().getValueAt(r0.getIndex());
    }

    public DirectoryNode getRoot() {
        if (this._root != null) goto L6;
        this._root = new DirectoryNode(this._property_table.getRoot(), this, null);
    L6:
        return this._root;
    }

    @Override // org.apache.poi.poifs.filesystem.BlockStore
    public void releaseBuffer(ByteBuffer r3) {
        if (ZeusTransformUtils.instanceOf(this._data, FileBackedDataSource.class) == false) goto L6;
        ((FileBackedDataSource) ZeusTransformUtils.preCheckCast(this._data, FileBackedDataSource.class, "com.obric.memorydata.plugin")).releaseBuffer(r3);
        return;
    }

    void remove(EntryNode r5) {
        if (ZeusTransformUtils.instanceOf(r5, DocumentEntry.class) == false) goto L5;
        new POIFSDocument((DocumentProperty) ZeusTransformUtils.preCheckCast(r5.getProperty(), DocumentProperty.class, "com.obric.memorydata.plugin"), this).free();
    L5:
        this._property_table.removeProperty(r5.getProperty());
    }

    @Override // org.apache.poi.poifs.filesystem.BlockStore
    public void setNextBlock(int r1, int r2) {
        BATBlock.BATBlockAndIndex r0 = getBATBlockAndIndex(r1);
        r0.getBlock().setValueAt(r0.getIndex(), r2);
    }
}
