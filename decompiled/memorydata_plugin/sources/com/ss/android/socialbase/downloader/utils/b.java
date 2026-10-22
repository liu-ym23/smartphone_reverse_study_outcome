package com.ss.android.socialbase.downloader.utils;

import java.io.Closeable;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes6.dex */
public class b implements com.ss.android.ttmd5.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FileInputStream f15650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final FileChannel f15651b;
    private final ByteBuffer c;

    public b(FileInputStream r1) {
        this.f15650a = r1;
        this.f15651b = r1.getChannel();
        this.c = ByteBuffer.allocate(8192);
    }

    @Override // com.ss.android.ttmd5.b
    public int a(byte[] r2, int r3, int r4) {
        int r5 = this.f15651b.read(this.c);
        if (r5 == (-1)) goto L5;
        this.c.flip();
        this.c.get(r2, 0, r5);
        this.c.clear();
    L5:
        return r5;
    }

    @Override // com.ss.android.ttmd5.b
    public long a() {
        return this.f15651b.size();
    }

    @Override // com.ss.android.ttmd5.b
    public void a(long r1, long r3) {
        this.f15651b.position(r1);
    }

    @Override // com.ss.android.ttmd5.b
    public void b() {
        g.a(new Closeable[]{this.f15651b, this.f15650a});
    }
}
