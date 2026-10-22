package org.apache.poi.openxml4j.util;

import java.io.Closeable;
import java.io.InputStream;
import java.util.Enumeration;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;

/* JADX INFO: loaded from: classes7.dex */
public interface ZipEntrySource extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    Enumeration<? extends ZipArchiveEntry> getEntries();

    ZipArchiveEntry getEntry(String r1);

    InputStream getInputStream(ZipArchiveEntry r1);

    boolean isClosed();
}
