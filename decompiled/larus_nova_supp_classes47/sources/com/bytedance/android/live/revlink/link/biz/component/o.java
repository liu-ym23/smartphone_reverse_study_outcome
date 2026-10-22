package com.bytedance.android.live.revlink.link.biz.component;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class o<T> implements Consumer {
    public final /* synthetic */ p a;

    public o(p r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Long r3 = (Long) r2;
        this.a.getContext().m6().setValue(com.bytedance.android.live.revlink.link.core.layoutstatus.l.c);
    }
}
