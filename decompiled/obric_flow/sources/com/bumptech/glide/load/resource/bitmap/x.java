package com.bumptech.glide.load.resource.bitmap;

import android.media.MediaDataSource;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class x extends MediaDataSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ByteBuffer f1639a;

    public x(ByteBuffer r5) {
        this.f1639a = r5;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // android.media.MediaDataSource
    public final long getSize() {
        return this.f1639a.limit();
    }

    @Override // android.media.MediaDataSource
    public final int readAt(long r5, byte[] r10, int r11, int r12) {
        ByteBuffer r13 = this.f1639a;
        if (r5 < r13.limit()) goto L6;
        return -1;
    L6:
        r13.position((int) r5);
        int r14 = Math.min(r12, r13.remaining());
        r13.get(r10, r11, r14);
        return r14;
    }
}
