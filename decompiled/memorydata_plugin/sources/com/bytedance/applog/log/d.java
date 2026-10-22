package com.bytedance.applog.log;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class d implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.applog.b f1628a;

    public d(com.bytedance.applog.b r2) {
        this.f1628a = r2;
        a(l.a().a(r2.b()).a(1).b(Thread.currentThread().getName()).c("Console logger is ready.").a());
    }

    @Override // com.bytedance.applog.log.k
    public void a(l r3) {
        if (this.f1628a.aN() == true) goto L5;
        return;
    L5:
        int r2 = r3.b();
        if (r2 != 0) goto L8;
        Log.v("AppLog", r3.h());
        return;
    L8:
        if (r2 != 2) goto L10;
        Log.i("AppLog", r3.h());
        return;
    L10:
        if (r2 != 3) goto L12;
        Log.w("AppLog", r3.h(), r3.c());
        return;
    L12:
        if (r2 != 4) goto L14;
    L16:
        Log.e("AppLog", r3.toString(), r3.c());
        return;
    L14:
        if (r2 == 5) goto L16;
        Log.d("AppLog", r3.toString());
    }
}
