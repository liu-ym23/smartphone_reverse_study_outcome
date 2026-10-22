package com.ss.android.lark.integrator.todo.dependency;

import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.utils.ApiUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class r implements g7c.m {
    public r() {
    }

    public final void getTenantId() {
    }

    public final boolean a() {
        return !((gpb.a) ApiUtils.getApi(gpb.a.class)).isChinaMainlandGeo();
    }

    public final String getUserId() {
        String r0 = OfficeSDKManager.getCurrentUid();
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }
}
