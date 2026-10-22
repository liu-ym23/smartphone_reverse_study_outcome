package com.bytedance.android.livesdk.interactivity.common.utils;

import com.bytedance.android.live.base.model.user.UserAttr;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.LiveRoomPermission;
import java.util.List;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h {
    static {
    }

    @JvmStatic
    public static final boolean a(boolean r1) {
        if (r1 == true) goto L15;
        IMiddlewareUserService r2 = jc1.k.f(IMiddlewareUserService.class);
        if (r2 == null) goto L13;
        com.bytedance.android.livesdk.user.e r3 = r2.user();
        if (r3 == null) goto L13;
        UserAttr r4 = r3.q();
        if (r4 == null) goto L13;
        if (r4.isAdmin() != true) goto L13;
        return true;
    L13:
        return false;
    L15:
        return true;
    }

    @JvmStatic
    public static final boolean b(boolean r3) {
        if (r3 == true) goto L24;
        IMiddlewareUserService r4 = jc1.k.f(IMiddlewareUserService.class);
        if (r4 == null) goto L9;
        com.bytedance.android.livesdk.user.e r5 = r4.user();
        if (r5 == null) goto L9;
        UserAttr r6 = r5.q();
    L11:
        if (r6 != null) goto L13;
    L19:
        boolean r7 = false;
    L20:
        if (r7 == true) goto L25;
        return false;
    L25:
        return true;
    L13:
        if (r6.isAdmin() == false) goto L19;
        List r8 = r6.getAdminPrivileges();
        if (r8 == null) goto L19;
        LiveRoomPermission.D.getClass();
        if (r8.contains(Integer.valueOf(LiveRoomPermission.x.a)) != true) goto L19;
        r7 = true;
    L9:
        r6 = null;
        goto L11
    L24:
        return true;
    }
}
