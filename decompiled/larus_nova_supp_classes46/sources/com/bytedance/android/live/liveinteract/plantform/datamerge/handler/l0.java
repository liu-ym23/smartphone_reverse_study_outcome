package com.bytedance.android.live.liveinteract.plantform.datamerge.handler;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l0<T> implements Consumer {
    public final /* synthetic */ j0 a;
    public final /* synthetic */ int b;

    public l0(j0 r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r3) {
        Long r4 = (Long) r3;
        boolean r5 = gh0.b.a;
        gh0.b.a("AudioAnchorGuide", "Handler finish interval, value = " + this.b, false);
        this.a.c = true;
    }
}
