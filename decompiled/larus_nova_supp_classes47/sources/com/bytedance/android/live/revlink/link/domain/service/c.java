package com.bytedance.android.live.revlink.link.domain.service;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ RevLinkDomainAnchorService a;

    public c(RevLinkDomainAnchorService r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        Long r2 = (Long) r1;
        this.a.s.f.f();
    }
}
