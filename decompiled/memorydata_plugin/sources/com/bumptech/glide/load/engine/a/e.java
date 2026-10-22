package com.bumptech.glide.load.engine.a;

import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class e implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f723a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f724b;
    private final long c;
    private final c d;
    private com.bumptech.glide.a.a e;

    @Deprecated
    public e(File r2, long r3) {
        this.d = new c();
        this.f724b = r2;
        this.c = r3;
        this.f723a = new j();
    }

    private synchronized com.bumptech.glide.a.a a() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.e != null) goto L6;
        this.e = com.bumptech.glide.a.a.a(this.f724b, 1, 1, this.c);     // Catch: Throwable -> L9
    L6:
        com.bumptech.glide.a.a r0 = this.e;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }

    public static a a(File r1, long r2) {
        return new e(r1, r2);
    }

    @Override // com.bumptech.glide.load.engine.a.a
    public File a(com.bumptech.glide.load.c r5) {
        com.bumptech.glide.load.c r6 = (com.bumptech.glide.load.c) ZeusTransformUtils.wrapperContextForParams(r5, com.bumptech.glide.load.c.class, "com.obric.memorydata.plugin");
        String r0 = this.f723a.a(r6);
        if (Log.isLoggable("DiskLruCacheWrapper", 2) == false) goto L15;
        Log.v("DiskLruCacheWrapper", "Get: Obtained: " + r0 + " for for Key: " + r6);
    L15:
        com.bumptech.glide.a.a.d r4 = a().a(r0);     // Catch: IOException -> L10
        if (r4 == null) goto L17;
        return r4.a(0);
    L17:
        return null;
    L10:
        e = move-exception;
        if (Log.isLoggable("DiskLruCacheWrapper", 5) == false) goto L19;
        Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", e);
        return null;
    L19:
        return null;
    }

    @Override // com.bumptech.glide.load.engine.a.a
    public void a(com.bumptech.glide.load.c r5, a.b r6) {
        com.bumptech.glide.load.c r7 = (com.bumptech.glide.load.c) ZeusTransformUtils.wrapperContextForParams(r5, com.bumptech.glide.load.c.class, "com.obric.memorydata.plugin");
        a.b r8 = (a.b) ZeusTransformUtils.wrapperContextForParams(r6, a.b.class, "com.obric.memorydata.plugin");
        String r1 = this.f723a.a(r7);
        this.d.a(r1);
    L29:
        th = move-exception;
        this.d.b(r1);
        throw th;
    L4:
        if (Log.isLoggable("DiskLruCacheWrapper", 2) == false) goto L34;
        Log.v("DiskLruCacheWrapper", "Put: Obtained: " + r1 + " for for Key: " + r7);     // Catch: Throwable -> L29
    L34:
        com.bumptech.glide.a.a r9 = a();     // Catch: IOException -> L22 Throwable -> L29
        if (r9.a(r1) == null) goto L10;
        this.d.b(r1);
        return;
    L10:
        com.bumptech.glide.a.a.b r10 = r9.b(r1);     // Catch: IOException -> L22 Throwable -> L29
        if (r10 == null) goto L21;
    L17:
        th = move-exception;
        r10.c();     // Catch: IOException -> L22 Throwable -> L29
        throw th;     // Catch: IOException -> L22 Throwable -> L29
    L14:
        if (r8.a(r10.a(0)) == false) goto L16;
        r10.a();     // Catch: Throwable -> L17
    L16:
        r10.c();     // Catch: IOException -> L22 Throwable -> L29
    L27:
        this.d.b(r1);
        return;
    L21:
        throw new IllegalStateException("Had two simultaneous puts for: " + r1);     // Catch: IOException -> L22 Throwable -> L29
    L22:
        e = move-exception;
        if (Log.isLoggable("DiskLruCacheWrapper", 5) == false) goto L27;
        Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", e);     // Catch: Throwable -> L29
        goto L27
    }

    @Override // com.bumptech.glide.load.engine.a.a
    public void delete(com.bumptech.glide.load.c r3) {
        com.bumptech.glide.load.c r4 = (com.bumptech.glide.load.c) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.c.class, "com.obric.memorydata.plugin");
        String r5 = this.f723a.a(r4);
        a().c(r5);     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        if (Log.isLoggable("DiskLruCacheWrapper", 5) == false) goto L12;
        Log.w("DiskLruCacheWrapper", "Unable to delete from disk cache", e);
        return;
    }
}
