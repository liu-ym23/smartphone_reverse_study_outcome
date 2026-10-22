package com.larus.bootprotector.activity;

import android.widget.LinearLayout;
import com.larus.common_ui.dialog.u;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import kotlin.Pair;
import kotlin.TuplesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class k implements u {
    public final /* synthetic */ BootProtectorLandingActivity a;

    public final void cancel() {
        final BootProtectorLandingActivity r0 = this.a;
        int r1 = BootProtectorLandingActivity.b;
        r0.getClass();
        nu8.a.e("BootProtectorLandingAct", "onOptimizeBtnClick: try opt");
        ((LinearLayout) r0.findViewById(2131378741)).setVisibility(0);
        hu8.a.b("bootprotector_click_opt", 1);
        int r2 = au8.b.a;
        au8.b.a("bootprotector_click_btn", com.larus.utils.f.c(new Pair[]{TuplesKt.to("click", "opt"), TuplesKt.to("white_list", hu8.e.d())}));
        ThreadMethodProxy.start(new PthreadThreadV2(new f(r0), "BootProtectorLandingActivity"));
    }

    public k(BootProtectorLandingActivity r1) {
        this.a = r1;
    }
}
