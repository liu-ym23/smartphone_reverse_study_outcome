package com.bytedance.android.live.liveinteract.plantform.utils;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j0<T> implements Consumer {
    public final /* synthetic */ m0 a;

    public j0(m0 r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Boolean r3 = (Boolean) r2;
        if (this.a.a() == false) goto L8;
        m0 r4 = this.a;
        r4.b = 100;
        hg6.g r5 = r4.h;
        if (r5 == null) goto L9;
        r5.d(100);
        return;
    L9:
        return;
    }
}
