package com.bytedance.android.live.effect.sticker.presenter;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class w<T> implements Consumer {
    public final /* synthetic */ m a;

    public w(s.d.a.RunnableC0192a.C0193a r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        Throwable r2 = (Throwable) r1;
        m r3 = this.a;
        if (r3 == null) goto L6;
        r3.onFail();
        return;
    }
}
