package com.ss.android.lark.integrator.ccm.dependency.di;

import com.ss.android.lark.rustinfrabridge.netstate.api.NetworkLevelListener;
import com.ss.android.lark.rustinfrabridge.netstate.impl.LarkNetworkLevelManager;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class p0 implements com.bytedance.ee.bear.lark.dependency.w {
    public p0() {
    }

    public final void a(final com.bytedance.ee.bear.middleground.drive.rustsdk.d r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        List r0 = com.ss.android.lark.rustinfrabridge.netstate.impl.d.a;
        com.ss.android.lark.rustinfrabridge.netstate.impl.d r1 = com.ss.android.lark.rustinfrabridge.netstate.impl.d.b.a;
        NetworkLevelListener r2 = new o0(r3);
        r1.getClass();
        Object r4 = LarkNetworkLevelManager.d;
        LarkNetworkLevelManager.a.a().w0(r2);
    }
}
