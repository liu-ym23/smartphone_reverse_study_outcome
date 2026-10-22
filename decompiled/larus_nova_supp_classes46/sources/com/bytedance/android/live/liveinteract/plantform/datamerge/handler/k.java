package com.bytedance.android.live.liveinteract.plantform.datamerge.handler;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k<T> implements Consumer {
    public final /* synthetic */ l a;

    public k(l r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Long r3 = (Long) r2;
        l r4 = this.a;
        r4.d = true;
        r4.a().E0(true);
        this.a.c();
    }
}
