package com.bytedance.android.live.broadcastgame.widget;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ AnchorGameWidget a;

    public a(AnchorGameWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Boolean r3 = (Boolean) r2;
        j20.c r0 = this.a.g;
        if (r0 == null) goto L6;
        r0.setPerformancePanelVisible(r3.booleanValue());
        return;
    }
}
