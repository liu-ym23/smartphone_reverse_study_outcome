package com.bytedance.android.live.revenue.common;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.IBaseUser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(IBaseUser r2, boolean r3) {
        if (r2 != null) goto L4;
        String r0 = null;
    L11:
        if (r0 != null) goto L14;
        return "";
    L14:
        return r0;
    L4:
        if (vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).isAudienceLinkEngineOn() == false) goto L9;
        r0 = r2.getSafeNicName();
        if (TextUtils.isEmpty(r0) == false) goto L11;
        r0 = r2.getProperNickName(r3);
        goto L11
    L9:
        r0 = r2.getProperNickName(r3);
        goto L11
    }
}
