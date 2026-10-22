package com.bumptech.glide.load.engine;

import android.content.Context;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final sj.k f1555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile b0.a f1556b;

    public r(sj.k r5) {
        this.f1555a = r5;
    }

    public final b0.a a() {
        if (this.f1556b != null) goto L32;
        monitor-enter(this);
    L22:
        th = move-exception;
        throw th;
    L6:
        if (this.f1556b != null) goto L25;
        File r5 = ((Context) ((sg.a) this.f1555a.f21937a).f21902a).getCacheDir();     // Catch: Throwable -> L22
        b0.c r10 = null;
        if (r5 != null) goto L10;
        File r11 = null;
    L11:
        if (r11 != null) goto L14;
    L21:
        this.f1556b = r10;     // Catch: Throwable -> L22
        goto L25
    L14:
        if (r11.mkdirs() == false) goto L16;
    L20:
        r10 = new b0.c();     // Catch: Throwable -> L22
        r10.d = new ai.p(2);     // Catch: Throwable -> L22
        r10.f809c = r11;     // Catch: Throwable -> L22
        r10.f807a = 262144000;     // Catch: Throwable -> L22
        r10.f808b = new b0.h();     // Catch: Throwable -> L22
        goto L21
    L16:
        if (r11.exists() == false) goto L21;
        if (r11.isDirectory() == true) goto L20;
    L10:
        r11 = new File(r5, "image_manager_disk_cache");     // Catch: Throwable -> L22
    L25:
        if (this.f1556b != null) goto L27;
        this.f1556b = new t9.a();     // Catch: Throwable -> L22
    L27:
        monitor-exit(this);     // Catch: Throwable -> L22
    L32:
        return this.f1556b;
    }
}
