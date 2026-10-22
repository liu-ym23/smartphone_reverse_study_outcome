package com.bytedance.android.live.revlink.impl.pk.vm.linkout;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ PkAutoMatchManager a;

    public e(PkAutoMatchManager r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        Boolean r2 = (Boolean) r1;
        this.a.k.f();
    }
}
