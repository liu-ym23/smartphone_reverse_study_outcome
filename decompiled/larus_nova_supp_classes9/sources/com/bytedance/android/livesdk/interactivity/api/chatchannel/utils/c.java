package com.bytedance.android.livesdk.interactivity.api.chatchannel.utils;

import android.os.Build;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.interactivity.api.settings.config.v0;
import com.bytedance.android.livesdk.interactivity.api.settings.config.w0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import r52.c4;
import r52.d4;
import r52.f0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c {
    public static final v0 a = null;
    public static final boolean b = false;
    public static final List<Integer> c = null;
    public static final List<Integer> d = null;
    public static final w0 e = null;
    public static final Boolean f = null;
    public static final boolean g = false;
    public static final boolean h = false;
    public static final boolean i = false;

    static {
        c4 r0 = c4.a;
        v0 r1 = (v0) r0.getValue();
        a = r1;
        b = ((v0) r0.getValue()).h();
        List<Integer> r2 = r1.a();
        if (r2 != null) goto L5;
        r2 = CollectionsKt.emptyList();
    L5:
        c = r2;
        List<Integer> r3 = r1.d();
        if (r3 != null) goto L8;
        r3 = CollectionsKt.emptyList();
    L8:
        d = r3;
        w0 r4 = (w0) d4.a.getValue();
        e = r4;
        f = (Boolean) f0.a.getValue();
        g = r4.i();
        h = r4.g();
        if (r4.h() == true) goto L11;
    L13:
        boolean r5 = false;
    L14:
        i = r5;
        return;
    L11:
        if (Build.VERSION.SDK_INT < 31) goto L13;
        r5 = true;
        goto L14
    }

    public static boolean d(User r3) {
        if (r3 != null) goto L6;
        return true;
    L6:
        if (r3.isMysteryMan() == true) goto L16;
        IInteractService r1 = jc1.k.f(IInteractService.class);
        if (r1 == null) goto L12;
        if (r1.isAnonymousUser(r3.getUserId()) != true) goto L12;
        return true;
    L12:
        if (r3.isAnonymous() == true) goto L18;
        return false;
    L18:
        return true;
    L16:
        return true;
    }

    public static boolean a(DataCenter r10, MiddlewareRoomContext r11) {
        Intrinsics.checkNotNullParameter(r11, "roomContext");
        boolean r0 = ((Boolean) r11.isAnchor().getValue()).booleanValue();
        boolean r1 = ((Room) r11.getRoom().getValue()).getRoomAuthStatus().isEnableAnchorChannel();
        boolean r13 = ((Room) r11.getRoom().getValue()).getRoomAuthStatus().isEnableRoomChannel();
        com.bytedance.android.livesdk.interactivity.api.h r2 = com.bytedance.android.livesdk.interactivity.api.i.b(null, 3);
        if (r2 == null) goto L9;
        com.bytedance.live.datacontext.j<Long> r3 = r2.getUserFansCountOnStart();
        if (r3 == null) goto L9;
        Long r4 = (Long) r3.getValue();
        if (r4 == null) goto L9;
        long r5 = r4.longValue();
    L10:
        w0 r6 = e;
        if (r5 < r6.c()) goto L13;
        boolean r7 = true;
    L14:
        boolean r8 = r6.b();
        List<Integer> r9 = r6.a();
        if (r9 != null) goto L17;
        r9 = CollectionsKt.emptyList();
    L17:
        boolean r14 = c(r10, r9);
        if (r8 == false) goto L26;
        if (r0 == false) goto L27;
        if (r13 == false) goto L28;
        if (r1 == false) goto L29;
        if (r7 == false) goto L30;
        if (r14 == true) goto L31;
        return true;
    L31:
        return false;
    L30:
        return false;
    L29:
        return false;
    L28:
        return false;
    L27:
        return false;
    L26:
        return false;
    L13:
        r7 = false;
    L9:
        r5 = 0;
        goto L10
    }

    public static boolean b(DataCenter r11, IBaseUser r13) {
        if (b == true) goto L5;
        return false;
    L5:
        MiddlewareRoomContext.a r0 = MiddlewareRoomContext.Companion;
        User r2 = null;
        long r3 = 0;
        MiddlewareRoomContext r6 = MiddlewareRoomContext.a.c(r0, null, 0, 3);
        if (r6 == null) goto L12;
        com.bytedance.live.datacontext.i r7 = r6.isAnchor();
        if (r7 == null) goto L12;
        if (((Boolean) r7.getValue()).booleanValue() != true) goto L12;
        boolean r8 = true;
    L13:
        com.bytedance.android.livesdk.interactivity.api.h r9 = com.bytedance.android.livesdk.interactivity.api.i.b(null, 3);
        MiddlewareRoomContext r10 = MiddlewareRoomContext.a.c(r0, null, 0, 3);
        if (r10 == null) goto L18;
        com.bytedance.live.datacontext.m r14 = r10.getRoom();
        if (r14 == null) goto L18;
        Room r15 = (Room) r14.getValue();
    L19:
        if (r15 == null) goto L156;
        RoomAuthStatus r16 = r15.getRoomAuthStatus();
        if (r16 != null) goto L23;
        return false;
    L23:
        if (r16.isEnableSecretChat() != true) goto L168;
        if (r13 == null) goto L37;
        String r17 = r13.getUserId();
        if (r17 == null) goto L37;
        com.bytedance.live.datacontext.m r18 = o3.f().getRoom();
        if (r18 == null) goto L33;
        IRoom r19 = (IRoom) r18.getValue();
        if (r19 == null) goto L33;
        String r110 = r19.getAnchorId();
    L35:
        if (r17.equals(r110) != true) goto L37;
    L54:
        boolean r111 = true;
    L55:
        if (r111 == true) goto L57;
        return false;
    L57:
        MiddlewareRoomContext r112 = MiddlewareRoomContext.a.c(r0, null, 0, 3);
        if (r112 == null) goto L63;
        com.bytedance.live.datacontext.m r113 = r112.getUser();
        if (r113 == null) goto L63;
        r2 = (User) r113.getValue();
    L63:
        if (d(r2) == false) goto L65;
        return false;
    L65:
        if (r8 == false) goto L85;
        v0 r114 = a;
        if (r114.b() == false) goto L158;
        if (r9 == null) goto L75;
        com.bytedance.live.datacontext.j<Long> r1 = r9.getUserFansCountOnStart();
        if (r1 == null) goto L75;
        Long r4 = (Long) r1.getValue();
        if (r4 == null) goto L75;
        r3 = r4.longValue();
    L75:
        if (r3 < r114.c()) goto L159;
        Map r115 = r15.anchorAbMap;
        if (r115 == null) goto L160;
        String r116 = (String) r115.get("room_secret_chat");
        if (r116 != null) goto L81;
        return false;
    L81:
        if (r116.equals("1") == true) goto L83;
        return false;
    L83:
        if (c(r11, c) == true) goto L163;
    L154:
        return true;
    L163:
        return false;
    L160:
        return false;
    L159:
        return false;
    L158:
        return false;
    L85:
        v0 r117 = a;
        if (r117.e() == false) goto L164;
        List<Integer> r5 = d;
        if (r5.contains(1) == false) goto L92;
        if (y3.m(r11).n(ToolbarButton.COMMERCE) == false) goto L92;
    L127:
        boolean r118 = true;
    L129:
        if (r118 == true) goto L165;
        if (r9 == null) goto L136;
        com.bytedance.live.datacontext.j<Integer> r119 = r9.getUserHonorLevelOnStart();
        if (r119 == null) goto L136;
        Integer r120 = (Integer) r119.getValue();
        if (r120 == null) goto L136;
        int r121 = r120.intValue();
    L138:
        if (r121 >= r117.g()) goto L154;
        IInteractService r122 = jc1.k.f(IInteractService.class);
        if (r122 != null) goto L142;
    L144:
        boolean r123 = false;
    L145:
        if (r123 != true) goto L166;
        if (r9 == null) goto L153;
        com.bytedance.live.datacontext.j<Long> r124 = r9.getUserFansCountOnStart();
        if (r124 == null) goto L153;
        Long r125 = (Long) r124.getValue();
        if (r125 == null) goto L153;
        r3 = r125.longValue();
    L153:
        if (r3 >= r117.f()) goto L154;
        return false;
    L166:
        return false;
    L142:
        if (r122.isAudienceLinkEngineOn() != true) goto L144;
        r123 = true;
    L136:
        r121 = 0;
        goto L138
    L165:
        return false;
    L92:
        if (r5.contains(2) != true) goto L96;
        if (y3.m(r11).n(ToolbarButton.COMMERCE_LIVE_AD) == true) goto L127;
    L96:
        if (r5.contains(3) == false) goto L100;
        if (y3.m(r11).n(ToolbarButton.MINI_APP) == true) goto L127;
    L100:
        if (r5.contains(4) == false) goto L104;
        if (y3.m(r11).n(ToolbarButton.WELFARE) == true) goto L127;
    L104:
        if (r5.contains(5) == false) goto L108;
        if (y3.m(r11).n(ToolbarButton.GAME_PROMOTE_AUDIENCE) == true) goto L127;
    L108:
        if (r5.contains(6) == false) goto L112;
        if (y3.m(r11).n(ToolbarButton.OPEN_PLATFORM_MINI_GAME) == true) goto L127;
    L112:
        if (r5.contains(6) == false) goto L116;
        if (y3.m(r11).n(ToolbarButton.LITTLE_GAME) == true) goto L127;
    L116:
        if (r5.contains(6) == false) goto L120;
        if (y3.m(r11).n(ToolbarButton.OPEN_PLATFORM_LYNX_GAME) == true) goto L127;
    L120:
        if (r5.contains(7) == false) goto L124;
        if (y3.m(r11).n(ToolbarButton.GROUP_PURCHASE_AUDIENCE) == true) goto L127;
    L124:
        if (r5.contains(8) == true) goto L126;
    L128:
        r118 = false;
        goto L129
    L126:
        if (y3.m(r11).n(ToolbarButton.TICKET_SALE) == false) goto L128;
    L164:
        return false;
    L33:
        r110 = null;
    L37:
        com.bytedance.live.datacontext.m r126 = o3.f().getRoom();
        if (r126 == null) goto L54;
        IRoom r127 = (IRoom) r126.getValue();
        if (r127 == null) goto L54;
        IRoomAuthStatus r128 = r127.getRoomAuthStatus();
        if (r128 == null) goto L54;
        if (r128.getEnableUserCard() == true) goto L54;
        if ((!Intrinsics.areEqual(o3.f().isAnchor(), Boolean.TRUE)) == false) goto L54;
        User r129 = o3.f().getUser();
        if (r129 == null) goto L53;
        py.t r130 = r129.getUserAttr();
        if (r130 == null) goto L53;
        if (r130.isAdmin() == true) goto L54;
    L53:
        r111 = false;
        goto L55
    L168:
        return false;
    L156:
        return false;
    L18:
        r15 = null;
    L12:
        r8 = false;
        goto L13
    }

    public static boolean c(DataCenter r3, List r4) {
        if (r4.contains(1) == false) goto L7;
        if (y3.m(r3).n(ToolbarButton.COMMERCE) == false) goto L7;
        return true;
    L7:
        if (r4.contains(2) != true) goto L11;
        if (y3.m(r3).n(ToolbarButton.TRANSFORM_WIDGET) == false) goto L11;
        return true;
    L11:
        if (r4.contains(3) == false) goto L15;
        if (y3.m(r3).n(ToolbarButton.MINI_APP) == false) goto L15;
        return true;
    L15:
        if (r4.contains(4) == false) goto L19;
        if (y3.m(r3).n(ToolbarButton.WELFARE) == false) goto L19;
        return true;
    L19:
        if (r4.contains(5) == false) goto L23;
        if (y3.m(r3).n(ToolbarButton.GAME_PROMOTE) == false) goto L23;
        return true;
    L23:
        if (r4.contains(6) == false) goto L27;
        if (y3.m(r3).n(ToolbarButton.LITTLE_GAME) == false) goto L27;
        return true;
    L27:
        if (r4.contains(7) == false) goto L31;
        if (y3.m(r3).n(ToolbarButton.GROUP_PURCHASE) == false) goto L31;
        return true;
    L31:
        if (r4.contains(8) == true) goto L33;
    L35:
        return false;
    L33:
        if (y3.m(r3).n(ToolbarButton.TICKET_SALE_ANCHOR) == false) goto L35;
        return true;
    }
}
