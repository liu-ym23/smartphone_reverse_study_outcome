package com.ss.android.socialbase.downloader.model;

import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes3.dex */
public class RandomAccessOutputStream implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RandomOutputStream f15914a;

    public class BufferRandomAccessOutputStream implements RandomOutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final BufferedOutputStream f15915a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final FileDescriptor f15916b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final RandomAccessFile f15917c;

        public BufferRandomAccessOutputStream(File r5, int r10) {
            RandomAccessFile r11 = new RandomAccessFile(r5, "rw");     // Catch: IOException -> L13
            this.f15917c = r11;     // Catch: IOException -> L13
            this.f15916b = r11.getFD();     // Catch: IOException -> L13
            if (r10 <= 0) goto L15;
            int r12 = 8192;
            if (r10 >= 8192) goto L8;
        L7:
            r10 = r12;
        L11:
            this.f15915a = new BufferedOutputStream(new FileOutputStream(r11.getFD()), r10);     // Catch: IOException -> L13
            return;
        L8:
            r12 = 131072;
            if (r10 <= 131072) goto L11;
        L15:
            this.f15915a = new BufferedOutputStream(new FileOutputStream(r11.getFD()));     // Catch: IOException -> L13
            return;
        L13:
            e = move-exception;
            throw new BaseException(1039, DownloadUtils.a(e));
        }

        @Override // com.ss.android.socialbase.downloader.model.RandomAccessOutputStream.RandomOutputStream
        public final void a(byte[] r5, int r10) {
            this.f15915a.write(r5, 0, r10);
        }

        @Override // com.ss.android.socialbase.downloader.model.RandomAccessOutputStream.RandomOutputStream
        public final void close() {
            DownloadUtils.a(new Closeable[]{this.f15915a, this.f15917c});
        }

        @Override // com.ss.android.socialbase.downloader.model.RandomAccessOutputStream.RandomOutputStream
        public final void flush() {
            BufferedOutputStream r5 = this.f15915a;
            if (r5 == null) goto L6;
            r5.flush();
            return;
        }

        @Override // com.ss.android.socialbase.downloader.model.RandomAccessOutputStream.RandomOutputStream
        public final void a() {
            FileDescriptor r5 = this.f15916b;
            if (r5 == null) goto L6;
            r5.sync();
            return;
        }

        @Override // com.ss.android.socialbase.downloader.model.RandomAccessOutputStream.RandomOutputStream
        public final void a(long r5) {
            this.f15917c.seek(r5);
        }
    }

    public class ChannelRandomAccessOutputStream implements RandomOutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RandomAccessFile f15918a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final FileChannel f15919b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ByteBuffer f15920c;

        public ChannelRandomAccessOutputStream(File r5) {
            RandomAccessFile r10 = new RandomAccessFile(r5, "rw");     // Catch: IOException -> L5
            this.f15918a = r10;     // Catch: IOException -> L5
            this.f15919b = r10.getChannel();     // Catch: IOException -> L5
            String r11 = DownloadConstants.f15275a;     // Catch: IOException -> L5
            this.f15920c = ByteBuffer.allocateDirect(32768);     // Catch: IOException -> L5
            return;
        L5:
            e = move-exception;
            throw new BaseException(1039, DownloadUtils.a(e));
        }

        @Override // com.ss.android.socialbase.downloader.model.RandomAccessOutputStream.RandomOutputStream
        public final void a() {
        }

        @Override // com.ss.android.socialbase.downloader.model.RandomAccessOutputStream.RandomOutputStream
        public final void close() {
            DownloadUtils.a(new Closeable[]{this.f15919b, this.f15918a});
        }

        @Override // com.ss.android.socialbase.downloader.model.RandomAccessOutputStream.RandomOutputStream
        public final void flush() {
            this.f15919b.force(true);
        }

        @Override // com.ss.android.socialbase.downloader.model.RandomAccessOutputStream.RandomOutputStream
        public final void a(byte[] r5, int r10) {
            this.f15920c.clear();
            this.f15920c.put(r5, 0, r10);
            this.f15920c.flip();
        L4:
            if (this.f15920c.hasRemaining() == false) goto L6;
            this.f15919b.write(this.f15920c);
            goto L4
        }

        @Override // com.ss.android.socialbase.downloader.model.RandomAccessOutputStream.RandomOutputStream
        public final void a(long r5) {
            this.f15919b.position(r5);
        }
    }

    public interface RandomOutputStream {
        void a();

        void a(long r5);

        void a(byte[] r5, int r10);

        void close();

        void flush();
    }

    public RandomAccessOutputStream(File r5, int r10, boolean r11) {
        if (r11 == false) goto L6;
        this.f15914a = new ChannelRandomAccessOutputStream(r5);
        return;
    L6:
        this.f15914a = new BufferRandomAccessOutputStream(r5, r10);
    }

    public final void a(byte[] r5, int r10) {
        this.f15914a.a(r5, r10);
    }

    public final void b() {
        this.f15914a.flush();
    }

    public final void c() {
        this.f15914a.a();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f15914a.close();
    }

    public final void a(long r5) {
        this.f15914a.a(r5);
    }
}
