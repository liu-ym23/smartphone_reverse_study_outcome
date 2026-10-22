package com.ss.android.socialbase.downloader.utils;

import java.io.Closeable;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes2.dex */
public class b implements tb.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FileInputStream f8327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final FileChannel f8328b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ByteBuffer f8329c;

    public b(FileInputStream r10) {
        this.f8327a = r10;
        this.f8328b = r10.getChannel();
        this.f8329c = ByteBuffer.allocate(8192);
    }

    @Override // tb.b
    public void a(long r10, long r11) {
        this.f8328b.position(r10);
    }

    @Override // tb.b
    public void close() {
        g.b0(new Closeable[]{this.f8328b, this.f8327a});
    }

    @Override // tb.b
    public long length() {
        return this.f8328b.size();
    }

    @Override // tb.b
    public int read(byte[] r10, int r11, int r12) {
        int r13 = this.f8328b.read(this.f8329c);
        if (r13 == (-1)) goto L5;
        this.f8329c.flip();
        this.f8329c.get(r10, 0, r13);
        this.f8329c.clear();
    L5:
        return r13;
    }
}
