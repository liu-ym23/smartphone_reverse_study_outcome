package com.bytedance.android.live.revlink.impl.behavior;

import com.bytedance.ies.sdk.widgets.NextLiveData;
import io.reactivex.functions.Action;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h0 implements Action {
    public final /* synthetic */ ToolbarPkIdleHolder a;
    public final /* synthetic */ PkPanelType b;
    public final /* synthetic */ Function0 c;

    public h0(ToolbarPkIdleHolder r1, PkPanelType r2, Function0 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void run() {
        ld.a r0 = ld.d.a();
        if (r0 == null) goto L11;
        NextLiveData r1 = r0.uf();
        if (r1 == null) goto L11;
        if (this.b != PkPanelType.PK) goto L9;
        int r2 = 2;
    L10:
        r1.setValue(r2);
        goto L11
    L9:
        r2 = 1;
    L11:
        com.bytedance.android.livesdk.revenue.datacenter.e r3 = wq2.e.a();
        k r4 = this.a.a;
        PkPanelType r5 = this.b;
        r4.getClass();
        r3.f(k.e(r5));
        ld.a r6 = ld.d.a();
        if (r6 == null) goto L16;
        NextLiveData r7 = r6.A4();
        if (r7 == null) goto L16;
        k r8 = this.a.a;
        PkPanelType r9 = this.b;
        r8.getClass();
        r7.setValue(k.f(r9));
    L16:
        this.a.d(this.b, IvPkId.MAIN, true);
        this.c.invoke();
        this.a.e.clear();
    }
}
