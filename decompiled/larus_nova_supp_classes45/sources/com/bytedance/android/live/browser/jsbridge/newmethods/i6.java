package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.common.utility.concurrent.TTExecutors;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i6<T> implements Consumer {
    public final /* synthetic */ n6 a;
    public final /* synthetic */ w20.ua b;

    public i6(n6 r1, w20.ua r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r5) {
        Throwable r6 = (Throwable) r5;
        n6 r0 = this.a;
        w20.ua r1 = this.b;
        String r2 = r0.a;
        if (r2 == null) goto L5;
        TTExecutors.getNormalExecutor().submit(new h6(r2, r1));
    L5:
        this.a.finishWithFailure(r6);
    }
}
