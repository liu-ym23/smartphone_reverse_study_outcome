package com.bytedance.android.live.browser.jsbridge.newmethods;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class y0<T> implements Consumer {
    public final /* synthetic */ l1 a;

    public y0(l1 r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        l1 r0 = this.a;
        r0.finishWithFailure((Throwable) r2);
    }
}
