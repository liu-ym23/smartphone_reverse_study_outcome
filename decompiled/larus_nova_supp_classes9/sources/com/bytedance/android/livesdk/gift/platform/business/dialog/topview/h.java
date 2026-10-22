package com.bytedance.android.livesdk.gift.platform.business.dialog.topview;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ i a;
    public final /* synthetic */ e b;

    public h(i r1, c02.a r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r3) {
        this.a.b.invoke(r3, this.b);
    }
}
