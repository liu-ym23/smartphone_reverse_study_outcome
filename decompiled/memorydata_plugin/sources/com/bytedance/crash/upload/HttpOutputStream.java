package com.bytedance.crash.upload;

import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.crash.util.NpthLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FilterOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.zip.Deflater;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class HttpOutputStream {
    private final CountableOutputStream mCountableOutputStream;
    private final boolean mGzip;
    private final OutputStream mImpl;

    static class CountableOutputStream extends FilterOutputStream {
        private long mCount;

        public CountableOutputStream(OutputStream r3) {
            super(r3);
            this.mCount = 0;
        }

        long count() {
            return this.mCount;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(int r5) {
            this.mCount++;
            this.out.write(r5);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] r5, int r6, int r7) {
            this.mCount += (long) r7;
            this.out.write(r5, r6, r7);
        }
    }

    static class WithoutCloseOutputStream extends DataOutputStream {
        public WithoutCloseOutputStream(OutputStream r1) {
            super(r1);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        public void realClose() {
            super.close();
        }
    }

    static class ZipOutputStream extends GZIPOutputStream {
        public ZipOutputStream(OutputStream r1) {
            super(r1);
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

    HttpOutputStream(OutputStream r2, boolean r3) {
        CountableOutputStream r0 = new CountableOutputStream(r2);
        this.mCountableOutputStream = r0;
        if (r3 == false) goto L5;
        OutputStream r4 = new ZipOutputStream(r0);
    L6:
        this.mImpl = r4;
        this.mGzip = r3;
        return;
    L5:
        r4 = new WithoutCloseOutputStream(r0);
        goto L6
    }

    static byte[] toByteArray(InputStream r4) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        byte[] r1 = new byte[8192];
    L3:
        int r3 = r4.read(r1);
        if ((-1) == r3) goto L6;
        r0.write(r1, 0, r3);
        goto L3
    L6:
        r4.close();
        byte[] r5 = r0.toByteArray();     // Catch: Throwable -> L10
        FileSystemUtils.close(r0);
        return r5;
    L10:
        th = move-exception;
        FileSystemUtils.close(r0);
        throw th;
    }

    static byte[] wrapDeflateData(byte[] r4) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream(8192);
        Deflater r2 = new Deflater();
        r2.setInput(r4);
        r2.finish();
        byte[] r5 = new byte[8192];
    L4:
        if (r2.finished() == true) goto L6;
        r0.write(r5, 0, r2.deflate(r5));
        goto L4
    L6:
        r2.end();
        return r0.toByteArray();
    }

    static byte[] wrapGzipData(byte[] r2) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream(8192);
        GZIPOutputStream r1 = new GZIPOutputStream(r0);
        r1.write(r2);     // Catch: Throwable -> L6
        r1.close();
        return r0.toByteArray();
    L6:
        th = move-exception;
        NpthLog.w(th);     // Catch: Throwable -> L10
        r1.close();
        return null;
    L10:
        th = move-exception;
        r1.close();
        throw th;
    }

    public void close() {
        boolean r0 = this.mGzip;
        OutputStream r2 = this.mImpl;
        if (r0 == false) goto L5;
        ZipOutputStream r3 = (ZipOutputStream) ZeusTransformUtils.preCheckCast(r2, ZipOutputStream.class, "com.obric.memorydata.plugin");
        r3.realFinish();
        r3.realClose();
        return;
    L5:
        WithoutCloseOutputStream r4 = (WithoutCloseOutputStream) ZeusTransformUtils.preCheckCast(r2, WithoutCloseOutputStream.class, "com.obric.memorydata.plugin");
        r4.flush();
        r4.realClose();
    }

    public long getCount() {
        return this.mCountableOutputStream.count();
    }

    public void write(String r1) {
        this.mImpl.write(r1.getBytes());
    }

    public void write(byte[] r1) {
        this.mImpl.write(r1);
    }

    public void write(byte[] r1, int r2, int r3) {
        this.mImpl.write(r1, r2, r3);
    }

    public void writeZipFiles(List<File> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        FileUtils.zip(this.mImpl, r4);
    }
}
