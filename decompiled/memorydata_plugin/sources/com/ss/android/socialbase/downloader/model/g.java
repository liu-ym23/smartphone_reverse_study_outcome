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

/* JADX INFO: loaded from: classes6.dex */
public class g implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f15575a;

    private class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f15576a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private BufferedOutputStream f15577b;
        private FileDescriptor c;
        private RandomAccessFile d;

        public a(g r2, File r3, int r4) {
            this.f15576a = r2;
            RandomAccessFile r5 = new RandomAccessFile(r3, "rw");     // Catch: IOException -> L15
            this.d = r5;     // Catch: IOException -> L15
            this.c = r5.getFD();     // Catch: IOException -> L15
            if (r4 > 0) goto L6;
            BufferedOutputStream r6 = new BufferedOutputStream(new FileOutputStream(this.d.getFD()));     // Catch: IOException -> L15
        L11:
            this.f15577b = r6;     // Catch: IOException -> L15
            return;
        L6:
            if (r4 >= 8192) goto L8;
            r4 = 8192;
        L10:
            r6 = new BufferedOutputStream(new FileOutputStream(this.d.getFD()), r4);     // Catch: IOException -> L15
            goto L11
        L8:
            if (r4 <= 131072) goto L10;
            r4 = 131072;
        L15:
            e = move-exception;
            throw new BaseException(1039, e);
        }

        @Override // com.ss.android.socialbase.downloader.model.g.c
        public void a() {
            BufferedOutputStream r0 = this.f15577b;
            if (r0 == null) goto L6;
            r0.flush();
            return;
        }

        @Override // com.ss.android.socialbase.downloader.model.g.c
        public void a(long r1) {
            this.d.seek(r1);
        }

        @Override // com.ss.android.socialbase.downloader.model.g.c
        public void a(byte[] r1, int r2, int r3) {
            this.f15577b.write(r1, r2, r3);
        }

        @Override // com.ss.android.socialbase.downloader.model.g.c
        public void b() {
            FileDescriptor r0 = this.c;
            if (r0 == null) goto L6;
            r0.sync();
            return;
        }

        @Override // com.ss.android.socialbase.downloader.model.g.c
        public void c() {
            com.ss.android.socialbase.downloader.utils.g.a(new Closeable[]{this.f15577b, this.d});
        }
    }

    private class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f15578a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private RandomAccessFile f15579b;
        private FileChannel c;
        private ByteBuffer d;

        public b(g r2, File r3) {
            this.f15578a = r2;
            RandomAccessFile r4 = new RandomAccessFile(r3, "rw");     // Catch: IOException -> L5
            this.f15579b = r4;     // Catch: IOException -> L5
            this.c = r4.getChannel();     // Catch: IOException -> L5
            this.d = ByteBuffer.allocateDirect(com.ss.android.socialbase.downloader.constants.b.e);     // Catch: IOException -> L5
            return;
        L5:
            e = move-exception;
            throw new BaseException(1039, e);
        }

        @Override // com.ss.android.socialbase.downloader.model.g.c
        public void a() {
            this.c.force(true);
        }

        @Override // com.ss.android.socialbase.downloader.model.g.c
        public void a(long r1) {
            this.c.position(r1);
        }

        @Override // com.ss.android.socialbase.downloader.model.g.c
        public void a(byte[] r2, int r3, int r4) {
            this.d.clear();
            this.d.put(r2, r3, r4);
            this.d.flip();
        L4:
            if (this.d.hasRemaining() == false) goto L6;
            this.c.write(this.d);
            goto L4
        }

        @Override // com.ss.android.socialbase.downloader.model.g.c
        public void b() {
        }

        @Override // com.ss.android.socialbase.downloader.model.g.c
        public void c() {
            com.ss.android.socialbase.downloader.utils.g.a(new Closeable[]{this.c, this.f15579b});
        }
    }

    private interface c {
        void a();

        void a(long r1);

        void a(byte[] r1, int r2, int r3);

        void b();

        void c();
    }

    public g(File r1, int r2, boolean r3) {
        if (r3 == false) goto L5;
        this.f15575a = new b(this, r1);
        return;
    L5:
        this.f15575a = new a(this, r1, r2);
    }

    public void a() {
        this.f15575a.a();
    }

    public void a(long r1) {
        this.f15575a.a(r1);
    }

    public void a(byte[] r1, int r2, int r3) {
        this.f15575a.a(r1, r2, r3);
    }

    public void b() {
        this.f15575a.b();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f15575a.c();
    }
}
