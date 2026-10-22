package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m3 implements com.bytedance.android.scope.o, dy0.c {
    public long a;
    public Disposable b;

    public m3() {
    }

    public final void onStart() {
    }

    public final void onStop() {
        Disposable r0 = this.b;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.b = null;
    }
}
