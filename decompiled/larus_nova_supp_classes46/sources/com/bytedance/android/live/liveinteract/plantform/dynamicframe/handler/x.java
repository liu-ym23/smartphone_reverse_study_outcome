package com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler;

import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class x<T> implements Consumer {
    public final /* synthetic */ v a;

    public x(v r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        List<? extends tf0.e> r3 = (List) r2;
        this.a.m(r3);
        v.h(this.a, r3);
        v.f(this.a, r3);
        v.g(this.a, r3);
    }
}
