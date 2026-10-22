package org.apache.poi.openxml4j.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.util.Enumeration;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;

/* JADX INFO: loaded from: classes7.dex */
public class ZipFileZipEntrySource implements ZipEntrySource {
    private ZipFile zipArchive;

    public ZipFileZipEntrySource(ZipFile r1) {
        this.zipArchive = r1;
    }

    @Override // org.apache.poi.openxml4j.util.ZipEntrySource, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ZipFile r0 = this.zipArchive;
        if (r0 == null) goto L5;
        r0.close();
    L5:
        this.zipArchive = null;
    }

    @Override // org.apache.poi.openxml4j.util.ZipEntrySource
    public Enumeration<? extends ZipArchiveEntry> getEntries() {
        ZipFile r1 = this.zipArchive;
        if (r1 == null) goto L7;
        return r1.getEntries();
    L7:
        throw new IllegalStateException("Zip File is closed");
    }

    @Override // org.apache.poi.openxml4j.util.ZipEntrySource
    public ZipArchiveEntry getEntry(String r6) {
        String r7 = r6.replace('\\', '/');
        ZipArchiveEntry r2 = this.zipArchive.getEntry(r7);
        if (r2 == null) goto L5;
        return r2;
    L5:
        Enumeration<ZipArchiveEntry> r5 = this.zipArchive.getEntries();
    L7:
        if (r5.hasMoreElements() == false) goto L11;
        ZipArchiveEntry r3 = (ZipArchiveEntry) ZeusTransformUtils.preCheckCast(r5.nextElement(), ZipArchiveEntry.class, "com.obric.memorydata.plugin");
        if (r7.equalsIgnoreCase(r3.getName().replace('\\', '/')) == false) goto L7;
        return r3;
    L11:
        return null;
    }

    @Override // org.apache.poi.openxml4j.util.ZipEntrySource
    public InputStream getInputStream(ZipArchiveEntry r1) {
        ZipFile r0 = this.zipArchive;
        if (r0 == null) goto L7;
        return r0.getInputStream(r1);
    L7:
        throw new IllegalStateException("Zip File is closed");
    }

    @Override // org.apache.poi.openxml4j.util.ZipEntrySource
    public boolean isClosed() {
        if (this.zipArchive != null) goto L5;
        return true;
    L5:
        return false;
    }
}
