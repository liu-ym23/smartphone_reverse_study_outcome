package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class n implements com.bytedance.android.scope.o {
    public Disposable a;
    public long b;
    public r2 c;

    public n() {
    }

    public final void onStart() {
    }

    public final void a() {
        this.b = 0;
        Disposable r0 = this.a;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.a = null;
        r2 r1 = this.c;
        if (r1 == null) goto L9;
        r1.onEnd();
        return;
    }

    public final void onStop() {
        a();
    }
}
