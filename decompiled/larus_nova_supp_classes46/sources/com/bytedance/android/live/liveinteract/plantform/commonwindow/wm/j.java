package com.bytedance.android.live.liveinteract.plantform.commonwindow.wm;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ CommonMultiLinkWindowManager a;

    public j(CommonMultiLinkWindowManager r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Boolean r5 = (Boolean) r4;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r6 = this.a.d;
        if (r6 == null) goto L9;
        String r0 = tc0.c.h().e;
        if (r0 != null) goto L7;
        r0 = "";
    L7:
        r6.hi(r0, true, this.a.n, true);
        return;
    }
}
