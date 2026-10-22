package com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher;

import com.bytedance.android.live.revlink.impl.monitor.LiveFullLinkPKMonitor;
import com.bytedance.android.live.revlink.impl.utils.t;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ PkAnchorLauncher a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ long d;
    public final /* synthetic */ JSONObject e;
    public final /* synthetic */ a.b f;

    public c(PkAnchorLauncher r1, int r2, int r3, long r4, JSONObject r6, com.bytedance.android.live.revlink.impl.jsb.a r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r6;
        this.f = r7;
    }

    public final void accept(Object r25) {
        Throwable r10 = (Throwable) r25;
        Disposable r1 = this.a.f;
        if (r1 == null) goto L5;
        r1.dispose();
    L5:
        PkAnchorLauncher r2 = this.a;
        r2.c = false;
        r2.h.setValue(c21.c.C0008c.a);
        d31.f r3 = PkAnchorLauncher.r(this.a);
        if (r3 == null) goto L8;
        r3.c("linkmic/battle/invite/", new d31.a(0, this.b, 0, 0, null, 0, this.c, null, null, null, null, 4029), r10, t.a(this.d));
    L8:
        b21.e r4 = this.a.z();
        if (r4 == null) goto L18;
        JSONObject r5 = this.e;
        long r6 = t.a(this.d);
        int r7 = ((Number) this.a.u.invoke()).intValue();
        Intrinsics.checkNotNullParameter(r10, "throwable");
        HashMap<String, String> r8 = new HashMap();
        r4.b(r8);
        if (r5 == null) goto L14;
        String r9 = r5.toString();
        if (r9 == null) goto L14;
    L15:
        r8.put("extra", r9);
        LiveFullLinkPKMonitor r12 = r4.c();
        if (r12 == null) goto L18;
        LiveFullLinkPKMonitor.r(r12, "linkmic/battle/invite", r10, r6, 0, r7, r8, 8);
    L14:
        r9 = "";
    L18:
        a.b r13 = this.f;
        if (r13 == null) goto L21;
        r13.onFailed(r10);
    L21:
        h41.b.a(r10);
        com.bytedance.android.live.revenue.common.k.c(r10);
    }
}
