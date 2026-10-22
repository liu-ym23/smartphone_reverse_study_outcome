package com.bytedance.android.livesdk.interactivity.api.publicscreen.utils;

import com.bytedance.android.live.base.model.user.UserAttr;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.m4;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveAudiencePanelConfig;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h {
    public static final boolean a = false;

    static {
        a = ((LiveAudiencePanelConfig) m4.a.getValue()).getEnable();
    }

    @JvmStatic
    public static final boolean c() {
        IRoomContextService r0 = jc1.k.f(IRoomContextService.class);
        if (r0 == null) goto L22;
        com.bytedance.android.livesdk.chatroom.o r1 = IRoomContextService.a.a(r0, null, 0, 3);
        if (r1 == null) goto L23;
        boolean r2 = Intrinsics.areEqual(r1.isAnchor(), Boolean.TRUE);
        IMiddlewareUserService r3 = jc1.k.f(IMiddlewareUserService.class);
        if (r3 == null) goto L16;
        com.bytedance.android.livesdk.user.e r4 = r3.user();
        if (r4 == null) goto L16;
        UserAttr r5 = r4.q();
        if (r5 == null) goto L16;
        if (r5.isAdmin() != true) goto L16;
        boolean r6 = true;
    L17:
        if (r2 == true) goto L20;
        if (r6 == true) goto L20;
        return true;
    L20:
        return false;
    L16:
        r6 = false;
        goto L17
    L23:
        return true;
    L22:
        return true;
    }

    @JvmStatic
    public static final boolean a(com.bytedance.android.livesdk.chatroom.o r3) {
        if (r3 == null) goto L13;
        com.bytedance.live.datacontext.m r4 = r3.getRoom();
        if (r4 == null) goto L13;
        IRoom r5 = (IRoom) r4.getValue();
        if (r5 == null) goto L13;
        IRoomAuthStatus r6 = r5.getRoomAuthStatus();
        if (r6 == null) goto L13;
        if (r6.isEnableShowLikeCount() != true) goto L13;
        boolean r7 = true;
    L15:
        if (a == false) goto L19;
        if (r7 == false) goto L20;
        return true;
    L20:
        return false;
    L19:
        return false;
    L13:
        r7 = false;
        goto L15
    }

    @JvmStatic
    public static final boolean b(com.bytedance.android.live.base.model.message.t r6) {
        IRoomContextService r0 = jc1.k.f(IRoomContextService.class);
        if (r0 == null) goto L32;
        com.bytedance.android.livesdk.chatroom.o r1 = IRoomContextService.a.a(r0, null, 0, 3);
        if (r1 == null) goto L39;
        com.bytedance.live.datacontext.m r2 = r1.getRoom();
        if (r2 == null) goto L16;
        IRoom r3 = (IRoom) r2.getValue();
        if (r3 == null) goto L16;
        IRoomAuthStatus r4 = r3.getRoomAuthStatus();
        if (r4 == null) goto L16;
        if (r4.isEnableAudienceOpPanel() != true) goto L16;
        boolean r5 = true;
    L17:
        boolean r7 = Intrinsics.areEqual(r1.isPortraitInteraction(), Boolean.TRUE);
        if (a == true) goto L20;
        return false;
    L20:
        if (c() == false) goto L34;
        if (r5 == false) goto L35;
        if (r7 == true) goto L24;
        return false;
    L24:
        if ((r6 instanceof com.bytedance.android.live.base.model.message.m4) == true) goto L26;
        r6 = null;
    L26:
        com.bytedance.android.live.base.model.message.m4 r8 = (com.bytedance.android.live.base.model.message.m4) r6;
        if (r8 != null) goto L29;
        return false;
    L29:
        if (r8.enablePanel() != true) goto L38;
        return true;
    L38:
        return false;
    L35:
        return false;
    L34:
        return false;
    L16:
        r5 = false;
        goto L17
    L39:
        return false;
    L32:
        return false;
    }

    @JvmStatic
    public static final boolean d(com.bytedance.android.live.base.model.data.b r5, com.bytedance.android.live.base.model.data.b r6) {
        if (r5 != null) goto L6;
        return true;
    L6:
        if (r6 != null) goto L9;
        return false;
    L9:
        if (r5.e() == r6.e()) goto L11;
    L14:
        return true;
    L11:
        if (r5.a() != r6.a()) goto L14;
        return false;
    }
}
