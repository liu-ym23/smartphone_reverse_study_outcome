package org.apache.poi.openxml4j.util;

import com.bytedance.common.wschannel.WsConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.zip.ZipException;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.apache.commons.compress.utils.InputStreamStatistics;
import org.apache.poi.openxml4j.exceptions.NotOfficeXmlFileException;
import org.apache.poi.util.IOUtils;

/* JADX INFO: loaded from: classes7.dex */
public class ZipArchiveThresholdInputStream extends FilterInputStream {
    private ZipArchiveEntry entry;
    private boolean guardState;

    public ZipArchiveThresholdInputStream(InputStream r3) {
        super(r3);
        this.guardState = true;
        if (ZeusTransformUtils.instanceOf(r3, InputStreamStatistics.class) == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("InputStream of class " + r3.getClass() + " is not implementing InputStreamStatistics.");
    }

    private void checkThreshold() {
        if (this.guardState == true) goto L5;
        return;
    L5:
        InputStreamStatistics r0 = (InputStreamStatistics) ZeusTransformUtils.preCheckCast(this.in, InputStreamStatistics.class, "com.obric.memorydata.plugin");
        long r1 = r0.getUncompressedCount();
        long r3 = r0.getCompressedCount();     // Catch: NullPointerException -> L8
    L9:
        ZipArchiveEntry r14 = this.entry;
        if (r14 != null) goto L12;
        String r15 = "not set";
    L14:
        if (r1 > ZipSecureFile.MAX_ENTRY_SIZE) goto L24;
        if (r1 > WsConstants.DEFAULT_IO_LIMIT) goto L18;
        return;
    L18:
        double r10 = r3 / r1;
        if (r10 < ZipSecureFile.MIN_INFLATE_RATIO) goto L22;
        return;
    L22:
        throw new IOException(String.format(Locale.ROOT, "Zip bomb detected! The file would exceed the max. ratio of compressed file size to the size of the expanded data.\nThis may indicate that the file is used to inflate memory usage and thus could pose a security risk.\nYou can adjust this limit via ZipSecureFile.setMinInflateRatio() if you need to work with files which exceed this limit.\nUncompressed size: %d, Raw/compressed size: %d, ratio: %f\nLimits: MIN_INFLATE_RATIO: %f, Entry: %s", new Object[]{Long.valueOf(r1), Long.valueOf(r3), Double.valueOf(r10), Double.valueOf(ZipSecureFile.MIN_INFLATE_RATIO), r15}));
    L24:
        throw new IOException(String.format(Locale.ROOT, "Zip bomb detected! The file would exceed the max size of the expanded data in the zip-file.\nThis may indicates that the file is used to inflate memory usage and thus could pose a security risk.\nYou can adjust this limit via ZipSecureFile.setMaxEntrySize() if you need to work with files which are very large.\nUncompressed size: %d, Raw/compressed size: %d\nLimits: MAX_ENTRY_SIZE: %d, Entry: %s", new Object[]{Long.valueOf(r1), Long.valueOf(r3), Long.valueOf(ZipSecureFile.MAX_ENTRY_SIZE), r15}));
    L12:
        r15 = r14.getName();
    L8:
        r3 = 0;
        goto L9
    }

    ZipArchiveEntry getNextEntry() {
        if (ZeusTransformUtils.instanceOf(this.in, ZipArchiveInputStream.class) == false) goto L15;
        ZipArchiveEntry r0 = ((ZipArchiveInputStream) ZeusTransformUtils.preCheckCast(this.in, ZipArchiveInputStream.class, "com.obric.memorydata.plugin")).getNextZipEntry();     // Catch: EOFException -> L6 ZipException -> L8
        this.entry = r0;     // Catch: EOFException -> L6 ZipException -> L8
        return r0;
    L6:
        return null;
    L8:
        e = move-exception;
        if (e.getMessage().startsWith("Unexpected record signature") == true) goto L12;
        throw e;
    L12:
        throw new NotOfficeXmlFileException("No valid entries or contents found, this is not a valid OOXML (Office Open XML) file", e);
    L15:
        throw new IllegalStateException("getNextEntry() is only allowed for stream based zip processing.");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        int r0 = super.read();
        if (r0 <= (-1)) goto L5;
        checkThreshold();
    L5:
        return r0;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] r1, int r2, int r3) {
        int r4 = super.read(r1, r2, r3);
        if (r4 <= (-1)) goto L5;
        checkThreshold();
    L5:
        return r4;
    }

    void setEntry(ZipArchiveEntry r1) {
        this.entry = r1;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long r3) {
        long r4 = IOUtils.skipFully(((FilterInputStream) this).in, r3);
        if (r4 <= 0) goto L5;
        checkThreshold();
    L5:
        return r4;
    }
}
