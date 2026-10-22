package com.bytedance.crash.upload;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.crash.util.NpthLog;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FilterOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.zip.Deflater;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes.dex */
public class HttpOutputStream {
    private final CountableOutputStream mCountableOutputStream;
    private final boolean mGzip;
    private final OutputStream mImpl;

    static class CountableOutputStream extends FilterOutputStream {
        private long mCount;

        public CountableOutputStream(@NonNull OutputStream r10) {
            super(r10);
            this.mCount = 0;
        }

        long count() {
            return this.mCount;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(int r10) {
            this.mCount++;
            ((FilterOutputStream) this).out.write(r10);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(@NonNull byte[] r10, int r11, int r12) {
            this.mCount += (long) r12;
            ((FilterOutputStream) this).out.write(r10, r11, r12);
        }
    }

    static class WithoutCloseOutputStream extends DataOutputStream {
        public WithoutCloseOutputStream(OutputStream r10) {
            super(r10);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        public void realClose() {
            super.close();
        }
    }

    static class ZipOutputStream extends GZIPOutputStream {
        public ZipOutputStream(OutputStream r10) {
            super(r10);
        }

        @Override // java.util.zip.DeflaterOutputStream, java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.util.zip.GZIPOutputStream, java.util.zip.DeflaterOutputStream
        public void finish() {
        }

        public void realClose() {
            super.close();
        }

        public void realFinish() {
            super.finish();
        }
    }

    HttpOutputStream(OutputStream r10, boolean r11) {
        CountableOutputStream r12 = new CountableOutputStream(r10);
        this.mCountableOutputStream = r12;
        if (r11 == false) goto L5;
        OutputStream r13 = new ZipOutputStream(r12);
    L6:
        this.mImpl = r13;
        this.mGzip = r11;
        return;
    L5:
        r13 = new WithoutCloseOutputStream(r12);
        goto L6
    }

    static byte[] toByteArray(InputStream r10) {
        ByteArrayOutputStream r11 = new ByteArrayOutputStream();
        byte[] r12 = new byte[8192];
    L3:
        int r13 = r10.read(r12);
        if ((-1) == r13) goto L6;
        r11.write(r12, 0, r13);
        goto L3
    L6:
        r10.close();
        byte[] r14 = r11.toByteArray();     // Catch: Throwable -> L10
        FileSystemUtils.close(r11);
        return r14;
    L10:
        th = move-exception;
        FileSystemUtils.close(r11);
        throw th;
    }

    static byte[] wrapDeflateData(byte[] r10) {
        ByteArrayOutputStream r11 = new ByteArrayOutputStream(8192);
        Deflater r12 = new Deflater();
        r12.setInput(r10);
        r12.finish();
        byte[] r13 = new byte[8192];
    L4:
        if (r12.finished() == true) goto L6;
        r11.write(r13, 0, r12.deflate(r13));
        goto L4
    L6:
        r12.end();
        return r11.toByteArray();
    }

    @Nullable
    static byte[] wrapGzipData(byte[] r10) {
        ByteArrayOutputStream r11 = new ByteArrayOutputStream(8192);
        GZIPOutputStream r12 = new GZIPOutputStream(r11);
        r12.write(r10);     // Catch: Throwable -> L6
        r12.close();
        return r11.toByteArray();
    L6:
        th = move-exception;
        NpthLog.w(th);     // Catch: Throwable -> L10
        r12.close();
        return null;
    L10:
        th = move-exception;
        r12.close();
        throw th;
    }

    public void close() {
        boolean r10 = this.mGzip;
        OutputStream r11 = this.mImpl;
        if (r10 == false) goto L5;
        ZipOutputStream r12 = (ZipOutputStream) r11;
        r12.realFinish();
        r12.realClose();
        return;
    L5:
        WithoutCloseOutputStream r13 = (WithoutCloseOutputStream) r11;
        r13.flush();
        r13.realClose();
    }

    public long getCount() {
        return this.mCountableOutputStream.count();
    }

    public void write(String r10) {
        this.mImpl.write(r10.getBytes());
    }

    public void write(byte[] r10) {
        this.mImpl.write(r10);
    }

    public void write(byte[] r10, int r11, int r12) {
        this.mImpl.write(r10, r11, r12);
    }

    public void writeZipFiles(@NonNull List<File> r10) {
        FileUtils.zip(this.mImpl, r10);
    }
}
