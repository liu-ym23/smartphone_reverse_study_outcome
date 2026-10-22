package com.bytedance.android.live.recharge.utils;

import com.bytedance.android.live.link.data.RevPkState;
import com.bytedance.android.live.revlink.api.ILinkService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class p {
    public static final /* synthetic */ int a = 0;

    public static boolean a() {
        p11.h r0 = ((ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class)).mo470getPkService();
        if (r0.d() == RevPkState.PK) goto L5;
    L7:
        return false;
    L5:
        if (r0.isInBreakThrough() == true) goto L7;
        return true;
    }

    static {
    }
}
