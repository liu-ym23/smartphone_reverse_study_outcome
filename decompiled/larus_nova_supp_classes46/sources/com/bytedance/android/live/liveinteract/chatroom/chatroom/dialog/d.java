package com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog;

import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.revenue.fight.TeamFightContext;
import com.bytedance.android.live.liveinteract.revenuebase.MultiRevenueDataContext;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdkapi.model.MultiLinkFrequencyOptConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d {
    public static final ArrayList<com.bytedance.android.livesdk.multilink.base.model.c0> a = null;

    static {
        a = new ArrayList();
    }

    public static boolean a() {
        String r0 = jc1.k.n(IMiddlewareUserService.class).user().n();
        com.bytedance.live.datacontext.m r1 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r1 == null) goto L7;
        IRoom r2 = (IRoom) r1.getValue();
        if (r2 == null) goto L7;
        String r3 = r2.getOwnerUserIdString();
    L9:
        return Intrinsics.areEqual(r0, r3);
    L7:
        r3 = null;
        goto L9
    }

    public static boolean d() {
        IInteractService r0 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r0 == null) goto L7;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r1 = r0.getLinkUserInfoCenter();
        if (r1 == null) goto L7;
        Iterable r2 = r1.getOnlineUserList();
    L9:
        if (r2 != null) goto L11;
        return false;
    L11:
        Iterator r3 = r2.iterator();
    L13:
        if (r3.hasNext() == false) goto L18;
        if (((ILinkPlayerInfoBridge) r3.next()).isEnlarged() == false) goto L13;
        return true;
    L18:
        return false;
    L7:
        r2 = null;
        goto L9
    }

    public static boolean f() {
        MultiLinkFrequencyOptConfig r0 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.a;
        Integer r1 = Integer.valueOf(je0.d.f());
        Integer r3 = je0.d.h();
        if (r3 == null) goto L5;
        int r4 = r3.intValue();
    L7:
        if (com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.l(r1, 0, Integer.valueOf(r4)) == false) goto L19;
        if (TeamFightContext.Companion.h() == true) goto L11;
    L12:
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.revenuebase.b r2 = MultiRevenueDataContext.a.b();
        if (r2 != null) goto L15;
        return false;
    L15:
        if (r2.isFightShowing() != true) goto L52;
    L16:
        return true;
    L52:
        return false;
    L11:
        if (li0.d.g(null) == false) goto L16;
    L19:
        if (je0.d.v() == false) goto L22;
        return true;
    L22:
        if (TeamFightContext.Companion.h() == true) goto L24;
    L25:
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.revenuebase.b r5 = MultiRevenueDataContext.a.b();
        if (r5 != null) goto L28;
    L29:
        Integer r6 = je0.d.h();
        if (r6 != null) goto L33;
    L34:
        Integer r7 = je0.d.h();
        if (r7 != null) goto L38;
    L39:
        Integer r8 = je0.d.h();
        if (r8 != null) goto L43;
    L44:
        Integer r9 = je0.d.h();
        if (r9 != null) goto L48;
        return false;
    L48:
        if (r9.intValue() != 25) goto L53;
    L49:
        return true;
    L53:
        return false;
    L43:
        if (r8.intValue() == 24) goto L49;
    L38:
        if (r7.intValue() == 2) goto L49;
    L33:
        if (r6.intValue() == 7) goto L49;
    L28:
        if (r5.isFightShowing() == true) goto L49;
    L24:
        if (li0.d.g(null) == false) goto L49;
    L5:
        r4 = 0;
        goto L7
    }

    public static boolean c() {
        if (je0.d.f() != 8) goto L10;
        Integer r0 = je0.d.h();
        if (r0 == null) goto L10;
        if (r0.intValue() != 1) goto L10;
        return true;
    L10:
        return false;
    }

    public static boolean e() {
        if (je0.d.v() == false) goto L6;
        return true;
    L6:
        if (TeamFightContext.Companion.h() == true) goto L8;
    L9:
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.revenuebase.b r0 = MultiRevenueDataContext.a.b();
        if (r0 != null) goto L12;
    L13:
        Integer r1 = je0.d.h();
        if (r1 != null) goto L17;
    L18:
        Integer r2 = je0.d.h();
        if (r2 != null) goto L22;
    L23:
        Integer r3 = je0.d.h();
        if (r3 != null) goto L27;
    L29:
        return false;
    L27:
        if (r3.intValue() != 25) goto L29;
        return true;
    L22:
        if (r2.intValue() != 2) goto L23;
        return true;
    L17:
        if (r1.intValue() != 7) goto L18;
        return true;
    L12:
        if (r0.isFightShowing() != true) goto L13;
        return true;
    L8:
        if (li0.d.g(null) == true) goto L9;
        return true;
    }

    public static boolean h() {
        com.bytedance.live.datacontext.j r0 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
        if (r0 == null) goto L9;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r1 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r0.getValue();
        if (r1 == null) goto L9;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r2 = r1.t();
        if (r2 == null) goto L9;
        List r3 = r2.b;
    L10:
        boolean r4 = com.bytedance.android.livesdk.chatroom.interact.model.d0.e(r3);
        if (je0.d.f() != 5) goto L18;
        Integer r5 = je0.d.h();
        if (r5 == null) goto L18;
        if (r5.intValue() != 22) goto L18;
    L25:
        return true;
    L18:
        if (je0.d.f() != 12) goto L26;
        Integer r6 = je0.d.h();
        if (r6 == null) goto L26;
        if (r6.intValue() != 5) goto L26;
        if (r4 == false) goto L25;
    L26:
        return false;
    L9:
        r3 = null;
        goto L10
    }

    public static boolean b(int r3) {
        IInteractService r0 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r0 == null) goto L7;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r1 = r0.getLinkUserInfoCenter();
        if (r1 == null) goto L7;
        Iterable r2 = r1.getOnlineUserList();
    L9:
        if (r2 != null) goto L11;
        return true;
    L11:
        Iterator r4 = r2.iterator();
    L13:
        if (r4.hasNext() == false) goto L18;
        if (((ILinkPlayerInfoBridge) r4.next()).getUserPosition() != r3) goto L13;
        return false;
    L18:
        return true;
    L7:
        r2 = null;
        goto L9
    }

    public static boolean g(String r1) {
        com.bytedance.live.datacontext.m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r0 == null) goto L7;
        IRoom r2 = (IRoom) r0.getValue();
        if (r2 == null) goto L7;
        String r3 = r2.getOwnerUserIdString();
    L9:
        return Intrinsics.areEqual(r1, r3);
    L7:
        r3 = null;
        goto L9
    }
}
