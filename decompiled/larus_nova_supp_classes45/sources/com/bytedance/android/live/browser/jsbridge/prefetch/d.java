package com.bytedance.android.live.browser.jsbridge.prefetch;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ a.c a;

    public d(a.c r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        a r0 = this.a.a;
        r0.finishWithFailure((Throwable) r2);
    }
}
