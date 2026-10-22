package org.apache.poi.openxml4j.util;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.io.input.UnsynchronizedByteArrayInputStream;
import org.apache.logging.log4j.a;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.logging.log4j.util.t;
import org.apache.poi.poifs.crypt.temp.EncryptedTempData;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.TempFile;

/* JADX INFO: loaded from: classes7.dex */
class ZipArchiveFakeEntry extends ZipArchiveEntry implements Closeable {
    private static final c LOG = null;
    private static int MAX_ENTRY_SIZE;
    private byte[] data;
    private EncryptedTempData encryptedTempData;
    private File tempFile;

    static {
        LOG = b.a(ZipArchiveFakeEntry.class);
        MAX_ENTRY_SIZE = 100000000;
    }

    ZipArchiveFakeEntry(final ZipArchiveEntry r7, InputStream r8) {
        super(r7.getName());
        final long r0 = r7.getSize();
        int r2 = ZipInputStreamZipEntrySource.getThresholdBytesForTempFiles();
        if (r2 < 0) goto L23;
        if (r0 < r2) goto L23;
        if (ZipInputStreamZipEntrySource.shouldEncryptTempFiles() == false) goto L21;
        EncryptedTempData r9 = new EncryptedTempData();
        this.encryptedTempData = r9;
        OutputStream r6 = r9.getOutputStream();
        IOUtils.copy(r8, r6);     // Catch: Throwable -> L12
        if (r6 == null) goto L39;
        r6.close();
        return;
    L39:
        return;
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        if (r6 != null) goto L37;
    L20:
        throw th;
    L37:
        r6.close();     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        th.addSuppressed(th);
        goto L20
    L21:
        this.tempFile = TempFile.createTempFile("poi-zip-entry", ".tmp");
        a r3 = LOG.atInfo();
        r7.getClass();
        r3.a("created for temp file {} for zip entry {} of size {} bytes", new t[]{new $$Lambda$ZipArchiveFakeEntry$t8hqPMHZ0NmbeLWrJbOAE_RSsvM(this), new $$Lambda$xgsndAl1SX2GjN05DdVd3oGJ3g(r7), new $$Lambda$ZipArchiveFakeEntry$Q9AxxEOQmD7iGzKu_zidw7oh1w(r0)});
        IOUtils.copy(r8, this.tempFile);
        return;
    L23:
        if (r0 < (-1)) goto L32;
        if (r0 >= 2147483647L) goto L32;
        if (r0 != (-1)) goto L28;
        byte[] r10 = IOUtils.toByteArrayWithMaxLength(r8, getMaxEntrySize());
    L29:
        this.data = r10;
        return;
    L28:
        r10 = IOUtils.toByteArray(r8, (int) r0, getMaxEntrySize());
    L32:
        throw new IOException("ZIP entry size is too large or invalid");
    }

    public static int getMaxEntrySize() {
        return MAX_ENTRY_SIZE;
    }

    static /* synthetic */ Object lambda$new$1(long r0) {
        return Long.valueOf(r0);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.data = null;
        EncryptedTempData r0 = this.encryptedTempData;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        File r1 = this.tempFile;
        if (r1 != null) goto L8;
        return;
    L8:
        if (r1.exists() == true) goto L10;
        return;
    L10:
        if (this.tempFile.delete() == true) goto L15;
        LOG.atDebug().a("temp file was already deleted (probably due to previous call to close this resource)");
        return;
    }

    public InputStream getInputStream() {
        EncryptedTempData r0 = this.encryptedTempData;
        if (r0 == null) goto L10;
        return r0.getInputStream();
    L6:
        e = move-exception;
        throw new IOException("failed to read from encrypted temp data", e);
    L10:
        if (this.tempFile == null) goto L16;
        return new FileInputStream(this.tempFile);
    L14:
        throw new IOException("temp file " + this.tempFile.getAbsolutePath() + " is missing");
    L16:
        if (this.data == null) goto L20;
        return new UnsynchronizedByteArrayInputStream(this.data);
    L20:
        throw new IOException("Cannot retrieve data from Zip Entry, probably because the Zip Entry was closed before the data was requested.");
    }

    public /* synthetic */ Object lambda$new$0$ZipArchiveFakeEntry() {
        return this.tempFile.getAbsolutePath();
    }
}
