package com.bytedance.android.live.browser.jsbridge.newmethods;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h4<T> implements Consumer {
    public final /* synthetic */ e4 a;

    public h4(e4 r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        e4 r0 = this.a;
        r0.finishWithFailure((Throwable) r2);
    }
}
