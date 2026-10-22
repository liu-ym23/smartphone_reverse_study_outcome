package com.bytedance.android.live.browser.jsbridge.newmethods;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h2<T> implements Consumer {
    public final /* synthetic */ f2 a;
    public final /* synthetic */ Object b;

    public h2(f2 r1, Object r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r1) {
        if (((com.bytedance.android.livesdk.event.z) r1).b == false) goto L5;
        this.a.finishWithSuccess();
        return;
    L5:
        this.a.finishWithFailure();
    }
}
