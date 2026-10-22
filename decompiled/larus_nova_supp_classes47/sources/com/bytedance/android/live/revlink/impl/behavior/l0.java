package com.bytedance.android.live.revlink.impl.behavior;

import com.bytedance.ies.sdk.widgets.NextLiveData;
import io.reactivex.functions.Action;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l0 implements Action {
    public final /* synthetic */ ToolbarPkIdleHolder a;
    public final /* synthetic */ Function0 b;

    public l0(ToolbarPkIdleHolder r1, Function0 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void run() {
        ld.a r0 = ld.d.a();
        if (r0 == null) goto L7;
        NextLiveData r1 = r0.uf();
        if (r1 == null) goto L7;
        r1.setValue(1);
    L7:
        com.bytedance.android.livesdk.revenue.datacenter.e r2 = wq2.e.a();
        k r3 = this.a.a;
        PkPanelType r4 = PkPanelType.Anchor;
        r3.getClass();
        r2.f(k.e(r4));
        ld.a r5 = ld.d.a();
        if (r5 == null) goto L12;
        NextLiveData r6 = r5.A4();
        if (r6 == null) goto L12;
        this.a.a.getClass();
        r6.setValue(k.f(r4));
    L12:
        ToolbarPkIdleHolder r7 = this.a;
        IvPkId r8 = IvPkId.MAIN;
        r7.getClass();
        r7.d(r4, r8, true);
        this.b.invoke();
        this.a.e.clear();
    }
}
