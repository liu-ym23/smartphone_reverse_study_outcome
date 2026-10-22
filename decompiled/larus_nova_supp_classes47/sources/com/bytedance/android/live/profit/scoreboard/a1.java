package com.bytedance.android.live.profit.scoreboard;

import io.reactivex.functions.Action;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a1 implements Action {
    public final /* synthetic */ r0 a;
    public final /* synthetic */ dv0.f b;

    public a1(r0 r1, dv0.f r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void run() {
        if (((dv0.f) sh6.c.b((sh6.b) this.a.c.k().a)) != this.b) goto L6;
        this.a.c.k().a(sh6.a.a);
        return;
    }
}
