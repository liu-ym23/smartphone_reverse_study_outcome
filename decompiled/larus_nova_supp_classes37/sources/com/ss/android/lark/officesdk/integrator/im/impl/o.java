package com.ss.android.lark.officesdk.integrator.im.impl;

import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.y0;
import dagger.hilt.android.internal.Contexts;
import javax.inject.Inject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class o implements pmb.i {
    @Inject
    public o() {
    }

    public final String b() {
        return ((gpb.a) c(gpb.a.class)).getGeo();
    }

    public final String getDeviceId() {
        return ((epb.a) c(epb.a.class)).getDeviceId();
    }

    public final String getSession() {
        User r0 = ((yzb.b) c(yzb.b.class)).getForegroundUser();
        if (r0 != null) goto L5;
        return "";
    L5:
        if (r0.getSession() != null) goto L8;
        return "";
    L8:
        return r0.getSession();
    }

    public final String getSessionId() {
        User r0 = ((yzb.b) c(yzb.b.class)).getForegroundUser();
        if (r0 != null) goto L5;
        return "";
    L5:
        if (r0.getSession() != null) goto L8;
        return "";
    L8:
        return r0.getSession();
    }

    public final String getTenantBrand() {
        return ((gpb.a) c(gpb.a.class)).getTenantBrand();
    }

    public final String getTenantId() {
        User r0 = ((yzb.b) c(yzb.b.class)).getForegroundUser();
        if (r0 != null) goto L5;
        return "";
    L5:
        if (r0.getTenantId() != null) goto L8;
        return "";
    L8:
        return r0.getTenantId();
    }

    public final String getUserId() {
        return ((yzb.b) c(yzb.b.class)).d();
    }

    public final boolean isChinaMainlandGeo() {
        return ((gpb.a) c(gpb.a.class)).isChinaMainlandGeo();
    }

    public final boolean isFeishuBrand() {
        return ((gpb.a) c(gpb.a.class)).isFeishuBrand();
    }

    public final boolean isLogin() {
        return ((yzb.b) c(yzb.b.class)).isLogin();
    }

    public static Object c(Class r1) {
        return e0c.k.a(Contexts.getApplication(LarkContext.getApplication()), r1);
    }

    public final boolean a(String r2) {
        return y0.a(((yzb.b) c(yzb.b.class)).d(), r2);
    }
}
