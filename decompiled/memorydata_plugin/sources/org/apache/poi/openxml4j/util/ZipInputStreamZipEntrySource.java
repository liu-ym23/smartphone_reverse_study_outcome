package org.apache.poi.openxml4j.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;

/* JADX INFO: loaded from: classes7.dex */
public class ZipInputStreamZipEntrySource implements ZipEntrySource {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static boolean encryptTempFiles = false;
    private static int thresholdForTempFiles = -1;
    private InputStream streamToClose;
    private final Map<String, ZipArchiveFakeEntry> zipEntries;

    static {
    }

    public ZipInputStreamZipEntrySource(ZipArchiveThresholdInputStream r5) {
        this.zipEntries = new HashMap();
    L3:
        ZipArchiveEntry r0 = r5.getNextEntry();
        if (r0 == null) goto L5;
        this.zipEntries.put(r0.getName(), new ZipArchiveFakeEntry(r0, r5));
        goto L3
    L5:
        this.streamToClose = r5;
    }

    public static int getThresholdBytesForTempFiles() {
        return thresholdForTempFiles;
    }

    public static boolean shouldEncryptTempFiles() {
        return encryptTempFiles;
    }

    @Override // org.apache.poi.openxml4j.util.ZipEntrySource, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Iterator<ZipArchiveFakeEntry> r0 = this.zipEntries.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((ZipArchiveFakeEntry) ZeusTransformUtils.preCheckCast(r0.next(), ZipArchiveFakeEntry.class, "com.obric.memorydata.plugin")).close();
        goto L4
    L6:
        this.zipEntries.clear();
        this.streamToClose.close();
    }

    @Override // org.apache.poi.openxml4j.util.ZipEntrySource
    public Enumeration<? extends ZipArchiveEntry> getEntries() {
        return Collections.enumeration(this.zipEntries.values());
    }

    @Override // org.apache.poi.openxml4j.util.ZipEntrySource
    public ZipArchiveEntry getEntry(String r5) {
        String r6 = r5.replace('\\', '/');
        ZipArchiveEntry r0 = (ZipArchiveEntry) ZeusTransformUtils.preCheckCast(this.zipEntries.get(r6), ZipArchiveEntry.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        return r0;
    L5:
        Iterator<Map.Entry<String, ZipArchiveFakeEntry>> r4 = this.zipEntries.entrySet().iterator();
    L7:
        if (r4.hasNext() == false) goto L12;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (r6.equalsIgnoreCase((String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.memorydata.plugin")) == false) goto L7;
        return (ZipArchiveEntry) ZeusTransformUtils.preCheckCast(r1.getValue(), ZipArchiveEntry.class, "com.obric.memorydata.plugin");
    L12:
        return null;
    }

    @Override // org.apache.poi.openxml4j.util.ZipEntrySource
    public InputStream getInputStream(ZipArchiveEntry r2) {
        return ((ZipArchiveFakeEntry) ZeusTransformUtils.preCheckCast(r2, ZipArchiveFakeEntry.class, "com.obric.memorydata.plugin")).getInputStream();
    }

    @Override // org.apache.poi.openxml4j.util.ZipEntrySource
    public boolean isClosed() {
        return this.zipEntries.isEmpty();
    }
}
