package com.bytedance.ies.bullet.core;

import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f5319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f5320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f5321c;
    public Object d;

    public j() {
        this.f5319a = true;
        this.f5320b = new s6.b(7);
    }

    public void a() {
        w.c.b((w.c) this.d, this, false);
    }

    public File b() {
        w.c r5 = (w.c) this.d;
        monitor-enter(r5);
        w.b r10 = (w.b) this.f5320b;     // Catch: Throwable -> L9
        if (r10.f != this) goto L17;
        if (r10.e == true) goto L11;
        ((boolean[]) this.f5321c)[0] = true;     // Catch: Throwable -> L9
    L11:
        File r11 = r10.d[0];     // Catch: Throwable -> L9
        if (((w.c) this.d).f22657a.exists() == true) goto L14;
        ((w.c) this.d).f22657a.mkdirs();     // Catch: Throwable -> L9
    L14:
        monitor-exit(r5);     // Catch: Throwable -> L9
        return r11;
    L17:
        throw new IllegalStateException();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public j(w.c r5, w.b r10) {
        this.d = r5;
        this.f5320b = r10;
        if (r10.e == false) goto L5;
        boolean[] r11 = null;
    L6:
        this.f5321c = r11;
        return;
    L5:
        r11 = new boolean[r5.g];
        goto L6
    }
}
