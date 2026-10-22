package com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher;

import com.bytedance.android.live.revlink.impl.utils.t;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ PkAnchorLauncher a;
    public final /* synthetic */ String b;
    public final /* synthetic */ int c;
    public final /* synthetic */ long d;
    public final /* synthetic */ a.b e;

    public g(PkAnchorLauncher r1, String r2, int r3, long r4, com.bytedance.android.live.revlink.impl.jsb.a r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r6;
    }

    public final void accept(Object r8) {
        Throwable r9 = (Throwable) r8;
        b21.e r0 = this.a.z();
        if (r0 == null) goto L5;
        r0.h(this.b, this.c, r9, ((Number) this.a.u.invoke()).intValue(), t.a(this.d));
    L5:
        com.bytedance.android.live.revenue.common.k.c(r9);
        this.a.h.setValue(c21.c.C0008c.a);
        a.b r1 = this.e;
        if (r1 == null) goto L9;
        r1.onFailed(r9);
        return;
    }
}
