package com.bytedance.android.live.revlink.impl.multianchor.pk.pklaunch;

import b30.p;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ MultiAnchorPkLaunchControlWidget a;

    public e(MultiAnchorPkLaunchControlWidget r1) {
        this.a = r1;
    }

    public final void accept(T r5) {
        MultiAnchorPkLaunchControlWidget r0 = this.a;
        r0.getClass();
        if ((r5 instanceof p) == false) goto L6;
        p r6 = (p) r5;
        com.bytedance.android.live.revlink.impl.multianchor.service.c.a.a(r0, r6.a, r6.b, null, 4);
        return;
    }
}
