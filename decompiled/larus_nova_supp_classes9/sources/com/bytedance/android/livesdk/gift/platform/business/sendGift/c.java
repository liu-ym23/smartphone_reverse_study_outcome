package com.bytedance.android.livesdk.gift.platform.business.sendGift;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ d a;

    public c(d r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        Long r2 = (Long) r1;
        this.a.b.invoke();
        Disposable r3 = this.a.a;
        if (r3 == null) goto L6;
        r3.dispose();
        return;
    }
}
