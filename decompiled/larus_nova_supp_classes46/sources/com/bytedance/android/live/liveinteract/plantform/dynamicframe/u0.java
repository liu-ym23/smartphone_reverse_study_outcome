package com.bytedance.android.live.liveinteract.plantform.dynamicframe;

import io.reactivex.functions.Action;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class u0 implements Action {
    public final /* synthetic */ ih0.c a;
    public final /* synthetic */ e0 b;
    public final /* synthetic */ Long c;

    public u0(ih0.c r1, e0 r2, Long r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void run() {
        e0.c(this.b, this.a, this.c);
        e0.b(this.b, this.a);
    }
}
