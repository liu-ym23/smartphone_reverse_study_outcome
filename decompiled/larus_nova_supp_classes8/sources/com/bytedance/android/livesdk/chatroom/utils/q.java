package com.bytedance.android.livesdk.chatroom.utils;

import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class q {
    @JvmStatic
    public static final boolean a() {
        Integer r0 = (Integer) com.bytedance.android.livesdk.chatroom.setting.j.b.getValue();
        String r2 = null;
        com.bytedance.live.datacontext.m r1 = IRoomContextService.a.a(jc1.k.n(IRoomContextService.class), null, 0, 3).getRoom();
        if (r1 == null) goto L5;
        IRoom r3 = (IRoom) r1.getValue();
    L6:
        if (r3 == null) goto L8;
        String r4 = r3.getAnchorId();
    L10:
        if (Intrinsics.areEqual(r4, jc1.k.n(IMiddlewareUserService.class).user().b().getIdString()) == false) goto L12;
        return true;
    L12:
        com.bytedance.live.datacontext.m r5 = IRoomContextService.a.a(jc1.k.n(IRoomContextService.class), null, 0, 3).getRoom();
        if (r5 == null) goto L15;
        IRoom r6 = (IRoom) r5.getValue();
    L16:
        if (r6 == null) goto L19;
        r2 = r6.getAnchorAbValue("ecom_room_disable_gift");
    L19:
        if (Intrinsics.areEqual(r2, "1") == false) goto L27;
        if (r0 != null) goto L23;
    L25:
        return false;
    L23:
        if (r0.intValue() != 0) goto L25;
        return true;
    L27:
        return true;
    L15:
        r6 = null;
        goto L16
    L8:
        r4 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    static {
    }
}
