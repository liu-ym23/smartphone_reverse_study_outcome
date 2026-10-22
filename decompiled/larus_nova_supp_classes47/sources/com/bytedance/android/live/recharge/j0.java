package com.bytedance.android.live.recharge;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j0<T> implements Consumer {
    public final /* synthetic */ a0 a;

    public j0(a0 r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Long r3 = (Long) r2;
        if (((Boolean) this.a.u.a).booleanValue() == true) goto L6;
        a0 r4 = this.a;
        r4.T = true;
        r4.R.onNext(8);
        return;
    }
}
