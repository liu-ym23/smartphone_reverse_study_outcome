package com.ss.android.socialbase.downloader.model;

import com.ss.android.socialbase.downloader.exception.BaseException;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes2.dex */
public class h implements Closeable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private c f8198c;

    private class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private BufferedOutputStream f8199a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private FileDescriptor f8200b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private RandomAccessFile f8201c;

        public a(h r10, File r11, int r12) {
            RandomAccessFile r13 = new RandomAccessFile(r11, "rw");     // Catch: IOException -> L15
            this.f8201c = r13;     // Catch: IOException -> L15
            this.f8200b = r13.getFD();     // Catch: IOException -> L15
            if (r12 > 0) goto L6;
            BufferedOutputStream r14 = new BufferedOutputStream(new FileOutputStream(this.f8201c.getFD()));     // Catch: IOException -> L15
        L11:
            this.f8199a = r14;     // Catch: IOException -> L15
            return;
        L6:
            if (r12 >= 8192) goto L8;
            r12 = 8192;
        L10:
            r14 = new BufferedOutputStream(new FileOutputStream(this.f8201c.getFD()), r12);     // Catch: IOException -> L15
            goto L11
        L8:
            if (r12 <= 131072) goto L10;
            r12 = 131072;
        L15:
            e = move-exception;
            throw new BaseException(1039, e);
        }

        @Override // com.ss.android.socialbase.downloader.model.h.c
        public void a(long r10) {
            this.f8201c.seek(r10);
        }

        @Override // com.ss.android.socialbase.downloader.model.h.c
        public void b() {
            FileDescriptor r10 = this.f8200b;
            if (r10 == null) goto L6;
            r10.sync();
            return;
        }

        @Override // com.ss.android.socialbase.downloader.model.h.c
        public void close() {
            com.ss.android.socialbase.downloader.utils.g.b0(new Closeable[]{this.f8199a, this.f8201c});
        }

        @Override // com.ss.android.socialbase.downloader.model.h.c
        public void flush() {
            BufferedOutputStream r10 = this.f8199a;
            if (r10 == null) goto L6;
            r10.flush();
            return;
        }

        @Override // com.ss.android.socialbase.downloader.model.h.c
        public void write(byte[] r10, int r11, int r12) {
            this.f8199a.write(r10, r11, r12);
        }
    }

    private class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private RandomAccessFile f8202a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private FileChannel f8203b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private ByteBuffer f8204c;

        public b(h r10, File r11) {
            RandomAccessFile r12 = new RandomAccessFile(r11, "rw");     // Catch: IOException -> L5
            this.f8202a = r12;     // Catch: IOException -> L5
            this.f8203b = r12.getChannel();     // Catch: IOException -> L5
            this.f8204c = ByteBuffer.allocateDirect(ab.b.f132e);     // Catch: IOException -> L5
            return;
        L5:
            e = move-exception;
            throw new BaseException(1039, e);
        }

        @Override // com.ss.android.socialbase.downloader.model.h.c
        public void a(long r10) {
            this.f8203b.position(r10);
        }

        @Override // com.ss.android.socialbase.downloader.model.h.c
        public void b() {
        }

        @Override // com.ss.android.socialbase.downloader.model.h.c
        public void close() {
            com.ss.android.socialbase.downloader.utils.g.b0(new Closeable[]{this.f8203b, this.f8202a});
        }

        @Override // com.ss.android.socialbase.downloader.model.h.c
        public void flush() {
            this.f8203b.force(true);
        }

        @Override // com.ss.android.socialbase.downloader.model.h.c
        public void write(byte[] r10, int r11, int r12) {
            this.f8204c.clear();
            this.f8204c.put(r10, r11, r12);
            this.f8204c.flip();
        L4:
            if (this.f8204c.hasRemaining() == false) goto L6;
            this.f8203b.write(this.f8204c);
            goto L4
        }
    }

    private interface c {
        void a(long r10);

        void b();

        void close();

        void flush();

        void write(byte[] r10, int r11, int r12);
    }

    public h(File r10, int r11, boolean r12) {
        if (r12 == false) goto L5;
        this.f8198c = new b(this, r10);
        return;
    L5:
        this.f8198c = new a(this, r10, r11);
    }

    public void a(long r10) {
        this.f8198c.a(r10);
    }

    public void c() {
        this.f8198c.b();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f8198c.close();
    }

    public void flush() {
        this.f8198c.flush();
    }

    public void write(byte[] r10, int r11, int r12) {
        this.f8198c.write(r10, r11, r12);
    }
}
