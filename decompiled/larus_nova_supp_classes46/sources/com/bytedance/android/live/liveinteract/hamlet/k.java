package com.bytedance.android.live.liveinteract.hamlet;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k<T> implements Consumer {
    public final /* synthetic */ HamletAvatarWidget a;

    public k(HamletAvatarWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Boolean r3 = (Boolean) r2;
        com.bytedance.android.live.liveinteract.plantform.datamerge.handler.g r0 = this.a.s;
        if (r0 == null) goto L6;
        r0.d = r3;
        r0.c();
        return;
    }
}
