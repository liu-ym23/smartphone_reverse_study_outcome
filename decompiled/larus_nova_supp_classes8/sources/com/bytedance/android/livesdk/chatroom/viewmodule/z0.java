package com.bytedance.android.livesdk.chatroom.viewmodule;

import com.bytedance.android.live.user.IMiddlewareUserService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class z0 {
    public static boolean a;
    public static boolean b;

    static {
        a = true;
    }

    public static String a() {
        com.bytedance.android.livesdk.user.e r0 = jc1.k.n(IMiddlewareUserService.class).user();
        if (r0.isLogin() == true) goto L7;
        return "unknown";
    L7:
        return r0.n();
    }
}
