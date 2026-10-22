package com.bytedance.android.live.revlink.impl.pk.vm.linkout;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ d a;

    public b(d r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        Long r2 = (Long) r1;
        com.bytedance.android.live.revlink.impl.pk.service.i r3 = PkAutoMatchManager.g(this.a.a);
        if (r3 == null) goto L6;
        r3.f3();
        return;
    }
}
