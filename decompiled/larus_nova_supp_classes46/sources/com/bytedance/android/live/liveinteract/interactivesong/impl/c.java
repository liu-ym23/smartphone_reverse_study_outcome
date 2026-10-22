package com.bytedance.android.live.liveinteract.interactivesong.impl;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ InteractiveSongWidget a;

    public c(InteractiveSongWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.c.b r5 = (com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.c.b) r4;
        if (InteractiveSongContext.Companion.f() == true) goto L5;
        return;
    L5:
        if ((r5 instanceof com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.c.b.C0092b) == false) goto L7;
    L8:
        InteractiveSongWidget r0 = this.a;
        int r2 = InteractiveSongWidget.C;
        r0.Jq(true, null);
    L10:
        if (r5.a() == false) goto L14;
        InteractiveSongWidget r6 = this.a;
        int r1 = InteractiveSongWidget.C;
        r6.Jq(false, null);
        return;
    L14:
        return;
    L7:
        if ((r5 instanceof com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.c.b.C0093c) == false) goto L10;
        goto L8
    }
}
