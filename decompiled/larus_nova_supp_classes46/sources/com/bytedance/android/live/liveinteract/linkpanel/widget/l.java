package com.bytedance.android.live.liveinteract.linkpanel.widget;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l<T> implements Consumer {
    public final /* synthetic */ LinkApplyListWidget a;

    public l(LinkApplyListWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r10) {
        Boolean r11 = (Boolean) r10;
        LinkApplyListWidget r12 = this.a;
        int r0 = LinkApplyListWidget.O;
        yf0.a r1 = (yf0.a) r12.b;
        if (r1 == null) goto L6;
        yf0.a.h(r1, true, "audienceIncreasePriceApplySuccess", 50, "", r12.B, 32);
        return;
    }
}
