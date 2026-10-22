package com.bytedance.android.live.revlink.impl.multianchor.dynamic.context;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class r implements com.bytedance.android.live.revlink.impl.multianchor.ui.q {
    public final /* synthetic */ e0 a;

    @Override // com.bytedance.android.live.revlink.impl.multianchor.ui.q
    public final void b(boolean r1, boolean r2) {
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.ui.q
    public final void c(String r1, String r2, boolean r3, boolean r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "interactID");
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.ui.q
    public final void a() {
        e0 r0 = this.a;
        e r1 = r0.H;
        if (r1 == null) goto L7;
        com.bytedance.live.datacontext.n<f31.i> r2 = r1.getWindowStatus();
        if (r2 == null) goto L7;
        f31.i r3 = (f31.i) r2.getValue();
    L8:
        r0.m(r3);
        return;
    L7:
        r3 = null;
        goto L8
    }

    public r(e0 r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.ui.q
    public final void d(String r1, boolean r2, com.bytedance.android.live.revlink.impl.multianchor.ui.r.b r3) {
        Intrinsics.checkNotNullParameter(r3, "source");
        e0 r4 = this.a;
        e r5 = r4.H;
        if (r5 == null) goto L7;
        com.bytedance.live.datacontext.n<f31.i> r6 = r5.getWindowStatus();
        if (r6 == null) goto L7;
        f31.i r7 = (f31.i) r6.getValue();
    L8:
        r4.m(r7);
        return;
    L7:
        r7 = null;
        goto L8
    }
}
