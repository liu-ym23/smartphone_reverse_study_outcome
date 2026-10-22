package com.ss.android.lark.officesdk.integrator.im.sdk.service;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.utils.LarkContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class h implements okb.h {

    public static final class a {
    }

    static {
    }

    public h() {
    }

    public final boolean a() {
        User r0 = ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).getForegroundUser();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isGuest;
    }

    public final String getCurrentTenantId() {
        User r0 = ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).getForegroundUser();
        if (r0 == null) goto L6;
        String r1 = r0.getTenantId();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    public final String getCurrentUserId() {
        return ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).d();
    }

    public final void registerUserSwitchListener(qzb.a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        Log.w("ImSdkUserProxy", "unsupported in office sdk");
    }
}
