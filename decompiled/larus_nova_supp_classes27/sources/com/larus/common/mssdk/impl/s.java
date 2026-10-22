package com.larus.common.mssdk.impl;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.router.SmartRouter;
import com.larus.common_ui.dialog.k1;
import com.larus.network.HttpConst;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class s implements k1 {
    public final /* synthetic */ FragmentActivity a;
    public final /* synthetic */ String b;

    @Override // com.larus.common_ui.dialog.k1
    public final void a() {
        com.bytedance.router.i r0 = SmartRouter.buildRoute(this.a, this.b);
        HttpConst.a.getClass();
        String r1 = HttpConst.L;
        r0.c.putExtra("open_link", r1);
        r0.d();
    }

    @Override // com.larus.common_ui.dialog.k1
    public final void b() {
        com.bytedance.router.i r0 = SmartRouter.buildRoute(this.a, this.b);
        HttpConst.a.getClass();
        String r1 = HttpConst.M;
        r0.c.putExtra("open_link", r1);
        r0.d();
    }

    public s(FragmentActivity r1) {
        this.a = r1;
        this.b = "//flow/privacy_web";
    }
}
