package com.bytedance.android.live.livepkaudience.widget;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ LinkPkInteractAudienceAnchorWidget a;

    public a(LinkPkInteractAudienceAnchorWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        Integer r2 = (Integer) r1;
        if (r2 != null) goto L6;
        return;
    L6:
        if (r2.intValue() != 0) goto L11;
        gy.f r3 = this.a.c;
        if (r3 == null) goto L12;
        r3.K();
        return;
    L12:
        return;
    }
}
