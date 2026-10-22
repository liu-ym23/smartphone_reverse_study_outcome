package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d0 implements com.bytedance.android.scope.o {
    public String a;
    public long b;
    public Disposable c;
    public Disposable d;
    public r2 e;

    public d0() {
    }

    public final void onStart() {
    }

    public final void a() {
        this.b = 0;
        Disposable r0 = this.d;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.d = null;
        this.a = null;
        r2 r1 = this.e;
        if (r1 == null) goto L9;
        r1.onEnd();
        return;
    }

    public final void c() {
        Disposable r0 = this.c;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.c = null;
        r2 r1 = this.e;
        if (r1 == null) goto L9;
        r1.onEnd();
        return;
    }

    public final void onStop() {
        c();
        a();
    }
}
