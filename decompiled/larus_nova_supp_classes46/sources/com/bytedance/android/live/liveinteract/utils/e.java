package com.bytedance.android.live.liveinteract.utils;

import com.bytedance.android.live.base.model.user.UserAttr;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.LiveRoomPermission;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e {
    public static final boolean a = false;

    static {
        a = !tb1.d.a;
    }

    public static boolean b() {
        boolean r0 = jc1.k.n(IMiddlewareUserService.class).user().isAdmin();
        IMiddlewareUserService r1 = jc1.k.f(IMiddlewareUserService.class);
        if (r1 == null) goto L12;
        com.bytedance.android.livesdk.user.e r2 = r1.user();
        if (r2 == null) goto L12;
        UserAttr r3 = r2.q();
        if (r3 == null) goto L12;
        List r4 = r3.getAdminPrivileges();
        if (r4 == null) goto L12;
        LiveRoomPermission.D.getClass();
        if (r4.contains(Integer.valueOf(LiveRoomPermission.u.a)) != true) goto L12;
    L22:
        if (r0 == true) goto L26;
    L24:
        return false;
    L26:
        return true;
    L12:
        IMiddlewareUserService r5 = jc1.k.f(IMiddlewareUserService.class);
        if (r5 == null) goto L24;
        com.bytedance.android.livesdk.user.e r6 = r5.user();
        if (r6 == null) goto L24;
        UserAttr r7 = r6.q();
        if (r7 == null) goto L24;
        List r8 = r7.getAdminPrivileges();
        if (r8 == null) goto L24;
        LiveRoomPermission.D.getClass();
        if (r8.contains(Integer.valueOf(LiveRoomPermission.r.a)) != true) goto L24;
        goto L22
    }

    public static boolean a() {
        com.bytedance.live.datacontext.m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r0 == null) goto L7;
        IRoom r1 = (IRoom) r0.getValue();
        if (r1 == null) goto L7;
        String r2 = r1.getAnchorAbValue("live_linkmic_battle_optimize");
    L9:
        return Intrinsics.areEqual(r2, "1");
    L7:
        r2 = null;
        goto L9
    }

    public static boolean c(List r5) {
        boolean r0 = jc1.k.n(IMiddlewareUserService.class).user().isAdmin();
        Boolean r1 = com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor();
        if (r1 == null) goto L5;
        boolean r2 = r1.booleanValue();
    L6:
        if (r5 != null) goto L16;
        IMiddlewareUserService r6 = jc1.k.f(IMiddlewareUserService.class);
        if (r6 == null) goto L14;
        com.bytedance.android.livesdk.user.e r7 = r6.user();
        if (r7 == null) goto L14;
        UserAttr r8 = r7.q();
        if (r8 == null) goto L14;
        r5 = r8.getAdminPrivileges();
    L14:
        r5 = null;
    L16:
        if (r5 == null) goto L19;
        LiveRoomPermission.D.getClass();
        if (r5.contains(Integer.valueOf(LiveRoomPermission.u.a)) != true) goto L19;
    L22:
        if (r0 == true) goto L24;
        if (r2 == true) goto L24;
        return false;
    L24:
        return true;
    L19:
        if (r5 == null) goto L26;
        LiveRoomPermission.D.getClass();
        if (r5.contains(Integer.valueOf(LiveRoomPermission.r.a)) == true) goto L22;
        return false;
    L26:
        return false;
    L5:
        r2 = false;
        goto L6
    }
}
