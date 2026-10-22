package com.bytedance.android.live.liveinteract.utils;

import com.bytedance.android.live.user.IMiddlewareUserService;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(Map r2) {
        Boolean r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor();
        if (r0 == null) goto L5;
        boolean r1 = r0.booleanValue();
    L6:
        if (r1 == false) goto L8;
        String r3 = "anchor";
    L15:
        HashMap r4 = (HashMap) r2;
        r4.put("user_type", r3);
        IMiddlewareUserService r5 = jc1.k.f(IMiddlewareUserService.class);
        if (r5 == null) goto L21;
        com.bytedance.android.livesdk.user.e r6 = r5.user();
        if (r6 == null) goto L21;
        String r7 = r6.n();
        if (r7 == null) goto L21;
    L22:
        r4.put("user_id", r7);
        return;
    L21:
        r7 = "";
        goto L22
    L8:
        Integer r8 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r8 != null) goto L12;
    L13:
        r3 = "guest";
        goto L15
    L12:
        if (r8.intValue() != 0) goto L13;
        r3 = "user";
        goto L15
    L5:
        r1 = false;
        goto L6
    }
}
