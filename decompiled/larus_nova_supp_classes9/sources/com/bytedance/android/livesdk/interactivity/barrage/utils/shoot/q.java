package com.bytedance.android.livesdk.interactivity.barrage.utils.shoot;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class q<T> implements Consumer {
    public final /* synthetic */ o a;
    public final /* synthetic */ q22.a b;

    public q(o r1, q22.a r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r2) {
        Long r3 = (Long) r2;
        this.a.l(this.b);
    }
}
