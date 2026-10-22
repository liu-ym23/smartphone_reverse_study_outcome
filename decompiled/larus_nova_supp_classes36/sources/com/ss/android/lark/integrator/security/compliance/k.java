package com.ss.android.lark.integrator.security.compliance;

import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Singleton
public final class k implements o3c.a {
    @Inject
    public k() {
    }

    public final void Y() {
    }

    public final void a(com.ss.android.lark.scs.policy.engine.manage.f r2) {
        Intrinsics.checkNotNullParameter(r2, "switchUserSwitchListener");
    }

    public final void b() {
        Intrinsics.checkNotNullParameter(com.ss.android.lark.scs.policy.engine.manage.e.a, "loginStatusListener");
        xzb.a r0 = (xzb.a) ApiUtils.getApi(xzb.a.class);
        r0.registerLoginListener(new i());
        r0.registerLogoutListener(new j());
    }

    public final User getForegroundUser() {
        return ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).getForegroundUser();
    }

    public final boolean isDoubaoEnterpriseUser() {
        c.a.getClass();
        return c.a();
    }
}
