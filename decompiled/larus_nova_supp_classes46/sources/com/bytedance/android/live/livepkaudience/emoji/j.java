package com.bytedance.android.live.livepkaudience.emoji;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ d a;
    public final /* synthetic */ String b;

    public j(d r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r3) {
        Throwable r4 = (Throwable) r3;
        this.a.b = false;
        com.bytedance.android.live.liveinteract.plantform.utils.x.x0(this.b.toString(), r4, "self_panel");
        d.a r0 = (d.a) ((q46.b) this.a).a;
        if (r0 == null) goto L6;
        r0.F(this.b, r4);
        return;
    }
}
