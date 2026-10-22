package org.apache.poi.poifs.nio;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.IdentityHashMap;
import org.apache.logging.log4j.a;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.util.IOUtils;

/* JADX INFO: loaded from: classes7.dex */
public class FileBackedDataSource extends DataSource implements Closeable {
    private static final c LOG = null;
    private final IdentityHashMap<ByteBuffer, ByteBuffer> buffersToClean;
    private final FileChannel channel;
    private Long channelSize;
    private final boolean closeChannelOnClose;
    private final RandomAccessFile srcFile;
    private final boolean writable;

    static {
        LOG = b.a(FileBackedDataSource.class);
    }

    public FileBackedDataSource(File r2, boolean r3) {
        if (r3 == false) goto L4;
        String r0 = "r";
    L5:
        this(newSrcFile(r2, r0), r3);
        return;
    L4:
        r0 = "rw";
        goto L5
    }

    private FileBackedDataSource(RandomAccessFile r2, FileChannel r3, boolean r4, boolean r5) {
        this.buffersToClean = new IdentityHashMap();
        this.srcFile = r2;
        this.channel = r3;
        this.writable = !r4;
        this.closeChannelOnClose = r5;
    }

    public FileBackedDataSource(RandomAccessFile r3, boolean r4) {
        this(r3, r3.getChannel(), r4, false);
    }

    public FileBackedDataSource(FileChannel r2, boolean r3, boolean r4) {
        this(null, r2, r3, r4);
    }

    static /* synthetic */ void lambda$close$0(ByteBuffer r0, ByteBuffer r1) {
        unmap(r1);
    }

    private static RandomAccessFile newSrcFile(File r1, String r2) {
        if (r1.exists() == false) goto L7;
        return new RandomAccessFile(r1, r2);
    L7:
        throw new FileNotFoundException(r1.toString());
    }

    private static void unmap(ByteBuffer r2) {
        if (r2.getClass().getName().endsWith("HeapByteBuffer") == false) goto L6;
        return;
    L6:
        if (CleanerUtil.UNMAP_SUPPORTED == true) goto L14;
        a r3 = LOG.atDebug();
        String r0 = CleanerUtil.UNMAP_NOT_SUPPORTED_REASON;
    L12:
        r3.a(r0);
        return;
    L14:
        CleanerUtil.getCleaner().freeBuffer(r2);     // Catch: IOException -> L9
        return;
    L9:
        e = move-exception;
        r3 = LOG.atWarn().a(e);
        r0 = "Failed to unmap the buffer";
        goto L12
    }

    @Override // org.apache.poi.poifs.nio.DataSource
    public void close() {
        this.buffersToClean.forEach($$Lambda$FileBackedDataSource$umlZ4JMICKh4_O1kkVqU7q0nF3c.INSTANCE);
        this.buffersToClean.clear();
        RandomAccessFile r0 = this.srcFile;
        if (r0 == null) goto L6;
        r0.close();
        return;
    L6:
        if (this.closeChannelOnClose == false) goto L10;
        this.channel.close();
        return;
    }

    public FileChannel getChannel() {
        return this.channel;
    }

    @Override // org.apache.poi.poifs.nio.DataSource
    public ByteBuffer read(int r10, long r11) {
        if (r11 >= size()) goto L14;
        if (this.writable == false) goto L7;
        ByteBuffer r12 = this.channel.map(FileChannel.MapMode.READ_WRITE, r11, r10);
        this.buffersToClean.put(r12, r12);
    L9:
        r12.position(0);
        return r12;
    L7:
        this.channel.position(r11);
        r12 = ByteBuffer.allocate(r10);
        if (IOUtils.readFully(this.channel, r12) != (-1)) goto L9;
        throw new IndexOutOfBoundsException("Position " + r11 + " past the end of the file");
    L14:
        throw new IndexOutOfBoundsException("Position " + r11 + " past the end of the file");
    }

    public void releaseBuffer(ByteBuffer r2) {
        ByteBuffer r1 = (ByteBuffer) ZeusTransformUtils.preCheckCast(this.buffersToClean.remove(r2), ByteBuffer.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L6;
        unmap(r1);
        return;
    }

    @Override // org.apache.poi.poifs.nio.DataSource
    public long size() {
        if (this.channelSize != null) goto L6;
        this.channelSize = Long.valueOf(this.channel.size());
    L6:
        return this.channelSize.longValue();
    }

    @Override // org.apache.poi.poifs.nio.DataSource
    public void write(ByteBuffer r3, long r4) {
        this.channel.write(r3, r4);
        Long r5 = this.channelSize;
        if (r5 != null) goto L5;
        return;
    L5:
        if (r4 < r5.longValue()) goto L9;
        this.channelSize = null;
        return;
    }
}
