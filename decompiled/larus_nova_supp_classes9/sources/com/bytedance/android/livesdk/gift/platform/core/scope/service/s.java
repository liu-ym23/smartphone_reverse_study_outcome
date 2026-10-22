package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class s implements com.bytedance.android.scope.o {
    public s() {
    }

    public final void onStart() {
    }

    public final void onStop() {
        w r0 = (w) com.bytedance.android.live.revenue.core.util.f.a(w.class);
        Disposable r1 = r0.b;
        if (r1 == null) goto L8;
        if (r1.isDisposed() == true) goto L8;
        return;
    L8:
        if (r0.c == false) goto L13;
        r0.c = false;
        r0.b = Single.create(new t(r0)).observeOn(Schedulers.io()).subscribe();
        return;
    }
}
