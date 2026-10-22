package org.apache.poi.openxml4j.util;

import java.io.File;
import java.io.InputStream;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;

/* JADX INFO: loaded from: classes7.dex */
public class ZipSecureFile extends ZipFile {
    private static final c LOG = null;
    static long MAX_ENTRY_SIZE;
    private static long MAX_TEXT_SIZE;
    static double MIN_INFLATE_RATIO;
    private final String fileName;

    static {
        LOG = b.a(ZipSecureFile.class);
        MIN_INFLATE_RATIO = 0.01d;
        MAX_ENTRY_SIZE = 4294967295L;
        MAX_TEXT_SIZE = 10485760;
    }

    public ZipSecureFile(File r1) {
        super(r1);
        this.fileName = r1.getAbsolutePath();
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipFile
    public /* bridge */ /* synthetic */ InputStream getInputStream(ZipArchiveEntry r1) {
        return getInputStream(r1);
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipFile
    public ZipArchiveThresholdInputStream getInputStream(ZipArchiveEntry r2) {
        ZipArchiveThresholdInputStream r0 = new ZipArchiveThresholdInputStream(super.getInputStream(r2));
        r0.setEntry(r2);
        return r0;
    }
}
