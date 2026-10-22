package org.apache.poi.poifs.filesystem;

import androidx.fragment.app.FragmentTransaction;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import org.apache.poi.poifs.property.DocumentProperty;
import org.apache.poi.util.IOUtils;

/* JADX INFO: loaded from: classes7.dex */
public final class POIFSDocument implements Iterable<ByteBuffer> {
    private int _block_size;
    private POIFSFileSystem _filesystem;
    private DocumentProperty _property;
    private POIFSStream _stream;

    public POIFSDocument(String r3, int r4, POIFSFileSystem r5, POIFSWriterListener r6) {
        POIFSWriterListener r7 = (POIFSWriterListener) ZeusTransformUtils.wrapperContextForParams(r6, POIFSWriterListener.class, "com.obric.memorydata.plugin");
        this._filesystem = r5;
        if (r4 >= 4096) goto L5;
        this._stream = new POIFSStream(r5.getMiniStore());
        int r8 = this._filesystem.getMiniStore().getBlockStoreBlockSize();
    L6:
        this._block_size = r8;
        DocumentProperty r9 = new DocumentProperty(r3, r4);
        this._property = r9;
        r9.setStartBlock(this._stream.getStartBlock());
        this._property.setDocument(this);
        DocumentOutputStream r10 = new DocumentOutputStream(this, r4);
        POIFSDocumentPath r2 = new POIFSDocumentPath(r3.split("\\\\"));     // Catch: Throwable -> L10
        r7.processPOIFSWriterEvent(new POIFSWriterEvent(r10, r2, r2.getComponent(r2.length() - 1), r4));     // Catch: Throwable -> L10
        r10.close();
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        r10.close();     // Catch: Throwable -> L15
    L17:
        throw th;
    L15:
        th = move-exception;
        th.addSuppressed(th);
        goto L17
    L5:
        this._stream = new POIFSStream(r5);
        r8 = this._filesystem.getBlockStoreBlockSize();
        goto L6
    }

    public POIFSDocument(DocumentProperty r2, POIFSFileSystem r3) {
        this._property = r2;
        this._filesystem = r3;
        if (r2.getSize() >= 4096) goto L5;
        this._stream = new POIFSStream(this._filesystem.getMiniStore(), r2.getStartBlock());
        int r4 = this._filesystem.getMiniStore().getBlockStoreBlockSize();
    L6:
        this._block_size = r4;
        return;
    L5:
        this._stream = new POIFSStream(this._filesystem, r2.getStartBlock());
        r4 = this._filesystem.getBlockStoreBlockSize();
        goto L6
    }

    private int store(InputStream r6) {
        BufferedInputStream r0 = new BufferedInputStream(r6, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        r0.mark(4096);
        if (IOUtils.skipFully(r0, 4096) >= 4096) goto L5;
        this._stream = new POIFSStream(this._filesystem.getMiniStore());
        int r7 = this._filesystem.getMiniStore().getBlockStoreBlockSize();
    L6:
        this._block_size = r7;
        r0.reset();
        OutputStream r8 = this._stream.getOutputStream();
        long r1 = IOUtils.copy(r0, r8);     // Catch: Throwable -> L15
        int r5 = this._block_size;     // Catch: Throwable -> L15
        int r2 = (int) (r1 % ((long) r5));     // Catch: Throwable -> L15
        if (r2 == 0) goto L11;
        if (r2 == r5) goto L11;
        byte[] r9 = IOUtils.safelyAllocate(r5 - r2, POIFSFileSystem.getMaxRecordLength());     // Catch: Throwable -> L15
        Arrays.fill(r9, (byte) -1);     // Catch: Throwable -> L15
        r8.write(r9);     // Catch: Throwable -> L15
    L11:
        if (r8 == null) goto L14;
        r8.close();
    L14:
        return Math.toIntExact(r1);
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        if (r8 != null) goto L28;
    L23:
        throw th;
    L28:
        r8.close();     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        th.addSuppressed(th);
        goto L23
    L5:
        this._stream = new POIFSStream(this._filesystem);
        r7 = this._filesystem.getBlockStoreBlockSize();
        goto L6
    }

    void free() {
        this._stream.free();
        this._property.setStartBlock(-2);
    }

    Iterator<ByteBuffer> getBlockIterator() {
        if (getSize() <= 0) goto L5;
        Iterable r1 = this._stream;
    L7:
        return r1.iterator();
    L5:
        r1 = Collections.emptyList();
        goto L7
    }

    DocumentProperty getDocumentProperty() {
        return this._property;
    }

    POIFSFileSystem getFileSystem() {
        return this._filesystem;
    }

    public int getSize() {
        return this._property.getSize();
    }

    @Override // java.lang.Iterable
    public Iterator<ByteBuffer> iterator() {
        return getBlockIterator();
    }

    public void replaceContents(InputStream r3) {
        free();
        int r4 = store(r3);
        this._property.setStartBlock(this._stream.getStartBlock());
        this._property.updateSize(r4);
    }
}
