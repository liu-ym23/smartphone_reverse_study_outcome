package org.apache.commons.compress.archivers.zip;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import org.apache.commons.compress.utils.FileNameUtils;

/* JADX INFO: loaded from: classes6.dex */
class ZipSplitOutputStream extends OutputStream {
    private long currentSplitSegmentBytesWritten;
    private int currentSplitSegmentIndex;
    private boolean finished;
    private OutputStream outputStream;
    private final byte[] singleByte;
    private final long splitSize;
    private File zipFile;

    private File createNewSplitSegmentFile(Integer r4) {
        if (r4 != null) goto L4;
        int r5 = this.currentSplitSegmentIndex + 2;
    L5:
        String r0 = FileNameUtils.getBaseName(this.zipFile.getName());
        if (r5 > 9) goto L8;
        StringBuilder r1 = new StringBuilder().append(".z").append("0");
    L9:
        String r6 = r1.append(r5).toString();
        File r2 = new File(this.zipFile.getParent(), r0 + r6);
        if (r2.exists() == true) goto L13;
        return r2;
    L13:
        throw new IOException("split zip segment " + r0 + r6 + " already exists");
    L8:
        r1 = new StringBuilder().append(".z");
        goto L9
    L4:
        r5 = r4.intValue();
        goto L5
    }

    private void finish() {
        if (this.finished == true) goto L11;
        File r1 = new File(this.zipFile.getParentFile(), FileNameUtils.getBaseName(this.zipFile.getName()) + ".zip");
        this.outputStream.close();
        if (this.zipFile.renameTo(r1) == false) goto L9;
        this.finished = true;
        return;
    L9:
        throw new IOException("Failed to rename " + this.zipFile + " to " + r1);
    L11:
        throw new IOException("This archive has already been finished");
    }

    private void openNewSplitSegment() {
        if (this.currentSplitSegmentIndex != 0) goto L9;
        this.outputStream.close();
        File r0 = createNewSplitSegmentFile(1);
        if (this.zipFile.renameTo(r0) == true) goto L9;
        throw new IOException("Failed to rename " + this.zipFile + " to " + r0);
    L9:
        File r1 = createNewSplitSegmentFile(null);
        this.outputStream.close();
        this.outputStream = Files.newOutputStream(r1.toPath(), new OpenOption[0]);
        this.currentSplitSegmentBytesWritten = 0;
        this.zipFile = r1;
        this.currentSplitSegmentIndex++;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.finished == true) goto L6;
        finish();
        return;
    }

    public long getCurrentSplitSegmentBytesWritten() {
        return this.currentSplitSegmentBytesWritten;
    }

    public int getCurrentSplitSegmentIndex() {
        return this.currentSplitSegmentIndex;
    }

    public void prepareToWriteUnsplittableContent(long r5) {
        long r0 = this.splitSize;
        if (r5 > r0) goto L9;
        if ((r0 - this.currentSplitSegmentBytesWritten) >= r5) goto L10;
        openNewSplitSegment();
        return;
    L10:
        return;
    L9:
        throw new IllegalArgumentException("The unsplittable content size is bigger than the split segment size");
    }

    @Override // java.io.OutputStream
    public void write(int r3) {
        byte[] r0 = this.singleByte;
        r0[0] = (byte) (r3 & 255);
        write(r0);
    }

    @Override // java.io.OutputStream
    public void write(byte[] r3) {
        write(r3, 0, r3.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] r9, int r10, int r11) {
        if (r11 > 0) goto L4;
        return;
    L4:
        long r0 = this.currentSplitSegmentBytesWritten;
        long r2 = this.splitSize;
        if (r0 < r2) goto L8;
        openNewSplitSegment();
    L7:
        write(r9, r10, r11);
        return;
    L8:
        long r4 = r11;
        if ((r0 + r4) <= r2) goto L11;
        int r3 = ((int) r2) - ((int) r0);
        write(r9, r10, r3);
        openNewSplitSegment();
        r10 = r10 + r3;
        r11 = r11 - r3;
        goto L7
    L11:
        this.outputStream.write(r9, r10, r11);
        this.currentSplitSegmentBytesWritten += r4;
    }
}
