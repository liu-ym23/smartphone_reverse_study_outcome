package com.ss.android.socialbase.downloader.utils;

import com.ss.android.socialbase.downloader.md5.IRandomAccess;
import java.io.Closeable;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadFileRandomAccess implements IRandomAccess {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FileInputStream f16130a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FileChannel f16131b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ByteBuffer f16132c;

    public DownloadFileRandomAccess(FileInputStream r5) {
        this.f16130a = r5;
        this.f16131b = r5.getChannel();
        this.f16132c = ByteBuffer.allocate(8192);
    }

    @Override // com.ss.android.socialbase.downloader.md5.IRandomAccess
    public final int a(byte[] r5, int r10) {
        int r11 = this.f16131b.read(this.f16132c);
        if (r11 == (-1)) goto L5;
        this.f16132c.flip();
        this.f16132c.get(r5, 0, r11);
        this.f16132c.clear();
    L5:
        return r11;
    }

    @Override // com.ss.android.socialbase.downloader.md5.IRandomAccess
    public final void close() {
        DownloadUtils.a(new Closeable[]{this.f16131b, this.f16130a});
    }

    @Override // com.ss.android.socialbase.downloader.md5.IRandomAccess
    public final long length() {
        return this.f16131b.size();
    }

    @Override // com.ss.android.socialbase.downloader.md5.IRandomAccess
    public final void a(long r5) {
        this.f16131b.position(r5);
    }
}
