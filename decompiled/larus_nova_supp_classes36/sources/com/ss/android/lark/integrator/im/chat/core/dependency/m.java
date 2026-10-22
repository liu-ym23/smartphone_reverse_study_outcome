package com.ss.android.lark.integrator.im.chat.core.dependency;

import com.ss.android.lark.MessageTenantConfTask;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class m implements w4b.u {
    public final ConcurrentHashMap<Object, qzb.a> a;

    public final void b() {
        MessageTenantConfTask.a r0 = MessageTenantConfTask.a.a;
        qzb.a r1 = new l();
        this.a.put(r0, r1);
    }

    public m() {
        this.a = new ConcurrentHashMap();
    }

    public final String getSession() {
        return nmb.a.a().getPassportDependency().getSession();
    }

    public final String getTenantId() {
        return nmb.a.a().getPassportDependency().getTenantId();
    }

    public final String getUserId() {
        String r0 = nmb.a.a().getPassportDependency().getUserId();
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public final boolean isLogin() {
        return nmb.a.a().getPassportDependency().isLogin();
    }

    public final boolean a(String r2) {
        return nmb.a.a().getPassportDependency().a(r2);
    }
}
