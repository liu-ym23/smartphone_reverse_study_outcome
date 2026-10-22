package com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher;

import com.bytedance.android.live.revlink.impl.utils.t;
import io.reactivex.functions.Consumer;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ PkAnchorLauncher a;
    public final /* synthetic */ int b;
    public final /* synthetic */ long c;
    public final /* synthetic */ long d;
    public final /* synthetic */ long e;
    public final /* synthetic */ String f;
    public final /* synthetic */ JSONObject g;
    public final /* synthetic */ a.b h;

    public e(PkAnchorLauncher r1, int r2, long r3, long r5, long r7, String r9, JSONObject r10, com.bytedance.android.live.revlink.impl.jsb.a r12) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r5;
        this.e = r7;
        this.f = r9;
        this.g = r10;
        this.h = r12;
    }

    public final void accept(Object r25) {
        Throwable r10 = (Throwable) r25;
        d31.f r1 = PkAnchorLauncher.r(this.a);
        if (r1 == null) goto L5;
        r1.c("linkmic/battle/open/", new d31.a(0, 0, 0, 0, null, 0, this.b, null, null, "duration=" + this.c, null, 3007), r10, t.a(this.d));
    L5:
        h41.b.a(r10);
        b21.e r2 = this.a.z();
        if (r2 == null) goto L8;
        r2.g(this.e, this.f, this.g, t.a(this.d), ((Number) this.a.u.invoke()).intValue(), r10);
    L8:
        com.bytedance.android.live.revenue.common.k.c(r10);
        a.b r3 = this.h;
        if (r3 == null) goto L12;
        r3.onFailed(r10);
        return;
    }
}
