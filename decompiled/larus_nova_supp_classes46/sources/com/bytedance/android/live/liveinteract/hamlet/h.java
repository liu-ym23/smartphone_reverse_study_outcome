package com.bytedance.android.live.liveinteract.hamlet;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ HamletAvatarWidget a;

    public h(HamletAvatarWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        sh6.b r5 = (sh6.b) r4;
        com.bytedance.android.live.liveinteract.hamlet.model.l r0 = (com.bytedance.android.live.liveinteract.hamlet.model.l) sh6.c.b(r5);
        Double r1 = null;
        if (r0 == null) goto L5;
        Double r2 = r0.a();
    L6:
        com.bytedance.android.live.liveinteract.hamlet.model.l r3 = (com.bytedance.android.live.liveinteract.hamlet.model.l) sh6.c.b(r5);
        if (r3 == null) goto L9;
        r1 = r3.b();
    L9:
        if (r2 == null) goto L15;
        if (r1 == null) goto L16;
        r1.doubleValue();
        r2.doubleValue();
        com.bytedance.android.live.liveinteract.plantform.datamerge.handler.g r6 = this.a.s;
        if (r6 == null) goto L17;
        r6.b = (com.bytedance.android.live.liveinteract.hamlet.model.l) sh6.c.b(r5);
        r6.c();
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    L5:
        r2 = null;
        goto L6
    }
}
