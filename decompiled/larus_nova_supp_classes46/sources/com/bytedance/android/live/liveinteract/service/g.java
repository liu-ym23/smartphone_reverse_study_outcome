package com.bytedance.android.live.liveinteract.service;

import am2.x;
import android.app.Application;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.m2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.floatwindow.applywindow.LinkmicApplyFloatWindowManager;
import com.bytedance.android.live.liveinteract.floatwindow.onlinewindow.LinkmicOnlineFloatWindowManager;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.log.filter.t;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.log.l0;
import com.bytedance.android.livesdk.utils.IMessageManagerProviderService;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g implements gd0.i {
    public g() {
    }

    public final boolean b() {
        String r0 = LinkmicOnlineFloatWindowManager.Y;
        return LinkmicOnlineFloatWindowManager.c.a().e;
    }

    public final boolean a(long r5) {
        String r0 = LinkmicOnlineFloatWindowManager.Y;
        LinkmicOnlineFloatWindowManager r1 = LinkmicOnlineFloatWindowManager.c.a();
        IRoom r2 = r1.m;
        if (r2 == null) goto L8;
        if (r5 != r2.getRoomId()) goto L8;
        return true;
    L8:
        if (r1.floatWindowIsShowing() == false) goto L10;
        f2.b(2131917754, 0);
    L10:
        return false;
    }

    public final void c(DataCenter r2) {
        LinkmicApplyFloatWindowManager.d r0 = LinkmicApplyFloatWindowManager.y;
        LinkmicApplyFloatWindowManager.e.a().k = r2;
        String r1 = LinkmicOnlineFloatWindowManager.Y;
        LinkmicOnlineFloatWindowManager.c.a().l = r2;
    }

    public final void d(boolean r12) {
        tc0.c r0 = tc0.c.h();
        com.bytedance.live.datacontext.m r1 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r1 == null) goto L7;
        IRoom r2 = (IRoom) r1.getValue();
        if (r2 == null) goto L7;
    L8:
        IRoom r3 = r2;
        String r4 = r0.f;
        if (r3 == null) goto L49;
        if (r4 == null) goto L50;
        jc1.k.n(IKtvService.class).isUserSelectMusic(jc1.k.n(IMiddlewareUserService.class).user().n());
        ArrayList r5 = new ArrayList();
        IInteractService r6 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r6 == null) goto L19;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r7 = r6.getLinkUserInfoCenter();
        if (r7 == null) goto L19;
        List r8 = r7.getOnlineUserList();
        if (r8 == null) goto L19;
        List r9 = r8;
    L21:
        if (je0.d.h() == null) goto L23;
        Integer r10 = je0.d.h();
        Intrinsics.checkNotNull(r10);
        int r11 = r10.intValue();
    L24:
        we0.b r13 = new we0.b.a().a();
        rj0.l.n2.getClass();
        if (rj0.l.a.a() == null) goto L31;
        rj0.l r14 = rj0.l.a.a();
        Intrinsics.checkNotNull(r14);
        tf0.k r15 = r14.getLinkmicReturnRoomParams();
        if (r15 == null) goto L30;
        r13 = (we0.b) r15;
    L37:
        we0.b r16 = r13;
    L38:
        HashMap r17 = new HashMap();
        t r18 = j0.l().c(x.class);
        if (r18 == null) goto L48;
        t r19 = r18;
        r17.put("enter_from_merge", l0.a("enter_from_merge", r19));
        r17.put("enter_method", l0.a("enter_method", r19));
        r17.put("action_type", l0.a("action_type", r19));
        LinkmicApplyFloatWindowManager.d r20 = LinkmicApplyFloatWindowManager.y;
        LinkmicApplyFloatWindowManager r21 = LinkmicApplyFloatWindowManager.e.a();
        Intrinsics.checkNotNull(r3);
        int r22 = TalkRoomLogUtils.q();
        IInteractService r23 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r23 == null) goto L44;
        String r24 = r23.getFunctionType2();
        if (r24 == null) goto L44;
    L45:
        r21.m(r3, r9, r22, r11, r24, r16, r17, r12);
        return;
    L44:
        r24 = "";
        goto L45
    L48:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.log.filter.IMiddlewarePageFilter");
    L30:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.floatwindow.LinkmicReturnRoomParams");
    L31:
        IVoiceChatGuestService.Companion.getClass();
        if (IVoiceChatGuestService.a.a() == null) goto L34;
        IVoiceChatGuestService r25 = IVoiceChatGuestService.a.a();
        Intrinsics.checkNotNull(r25);
        r13 = r25.getLinkmicReturnRoomParams();
        goto L37
    L34:
        tf0.k r26 = jc1.k.n(IKtvService.class).getLinkmicReturnRoomParams();
        if (r26 == null) goto L37;
        r16 = (we0.b) r26;
        goto L38
    L23:
        r11 = 0;
    L19:
        r9 = r5;
        goto L21
    L50:
        return;
    L49:
        return;
    L7:
        r2 = null;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e(boolean r17) {
        tc0.c r0 = tc0.c.h();
        com.bytedance.live.datacontext.m r1 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        Long r2 = null;
        if (r1 == null) goto L7;
        IRoom r3 = (IRoom) r1.getValue();
        if (r3 == null) goto L7;
    L8:
        String r4 = r0.f;
        if (r3 == null) goto L126;
        if (r4 == null) goto L127;
        List r5 = new ArrayList();
        IInteractService r6 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r6 == null) goto L20;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r7 = r6.getLinkUserInfoCenter();
        if (r7 == null) goto L20;
        List r8 = r7.getOnlineUserList();
        if (r8 == null) goto L20;
        r5 = r8;
    L20:
        if (je0.d.h() == null) goto L22;
        Integer r9 = je0.d.h();
        Intrinsics.checkNotNull(r9);
        int r10 = r9.intValue();
    L23:
        HashMap<String, String> r11 = new HashMap();
        t r12 = j0.l().c(x.class);
        if (r12 == null) goto L125;
        t r13 = r12;
        r11.put("enter_from_merge", l0.a("enter_from_merge", r13));
        r11.put("enter_method", l0.a("enter_method", r13));
        r11.put("action_type", l0.a("action_type", r13));
        String r14 = LinkmicOnlineFloatWindowManager.Y;
        LinkmicOnlineFloatWindowManager r15 = LinkmicOnlineFloatWindowManager.c.a();
        Intrinsics.checkNotNull(r3);
        int r16 = TalkRoomLogUtils.q();
        IInteractService r18 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r18 == null) goto L29;
        String r19 = r18.getFunctionType2();
        if (r19 == null) goto L29;
    L30:
        r15.getClass();
        Intrinsics.checkNotNullParameter(r3, PbRequest.SwitchType.ROOM);
        Intrinsics.checkNotNullParameter(r0, "dataHolder");
        Intrinsics.checkNotNullParameter(r5, "onlineUserList");
        Intrinsics.checkNotNullParameter(r19, "functionType");
        Intrinsics.checkNotNullParameter(r11, "enterParams");
        r15.m = r3;
        r15.n = r0;
        r15.J = r16;
        r15.K = r10;
        r15.L = r19;
        r15.i = false;
        r15.O = r11;
        r15.j = r17;
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        TalkRoomBusinessFullLinkMonitor.T("createFloatWindow", 1);
        LinkmicOnlineFloatWindowManager.t("call createFloatWindow");
        com.bytedance.android.live.liveinteract.floatwindow.onlinewindow.b r20 = new com.bytedance.android.live.liveinteract.floatwindow.onlinewindow.b(jc1.a.b(), r15);
        Application r21 = jc1.a.b();
        Map r22 = rx1.l.a;
        rx1.l.a r23 = new rx1.l.a(r21);
        r23.b = r20;
        float r24 = 100;
        r23.c = s1.f(r24);
        r23.d = s1.f(r24);
        r23.q = LinkmicOnlineFloatWindowManager.Y;
        r23.e = 3;
        float r25 = 8;
        int r26 = s1.f(r25);
        float r27 = 12;
        int r28 = s1.f(r27);
        int r29 = s1.f(r25);
        int r30 = s1.f(r27);
        r23.f = r26;
        r23.h = r28;
        r23.g = r29;
        r23.i = r30;
        AccelerateDecelerateInterpolator r31 = new AccelerateDecelerateInterpolator();
        r23.o = 300;
        r23.p = r31;
        r23.r = true;
        r23.t = true;
        r23.s = new com.bytedance.android.live.liveinteract.floatwindow.onlinewindow.f(r15);
        r23.a();
        long r32 = 0;
        if (r15.m != null) goto L33;
    L113:
        r15.z(r5);
        rx1.g r33 = LinkmicOnlineFloatWindowManager.m();
        if (r33 == null) goto L116;
        r33.e();
    L116:
        LinkmicOnlineFloatWindowManager.d();
        r15.s(r5);
        HashMap r34 = new HashMap();
        r34.put("is_link_reserve", "1");
        r34.put("open_source", r15.M);
        r34.put("is_auto_play", m2.b(r15.j));
        boolean r35 = xe0.k.a;
        xe0.k.d(r15.J, r15.K, r15.L, r34);
        IRoom r36 = r15.m;
        if (r36 == null) goto L119;
        r32 = r36.getRoomId();
    L119:
        TalkRoomBusinessFullLinkMonitor.x0(r32);
        StringBuilder r37 = new StringBuilder("call logOnShow, roomId = ");
        IRoom r38 = r15.m;
        if (r38 == null) goto L122;
        r2 = Long.valueOf(r38.getRoomId());
    L122:
        r37.append(r2);
        LinkmicOnlineFloatWindowManager.t(r37.toString());
        r15.u = new we0.b.a().a();
        return;
    L33:
        if (r15.n == null) goto L113;
        IMiddlewareHostBusiness r39 = jc1.k.f(IMiddlewareHostBusiness.class);
        if (r39 == null) goto L38;
        r39.setLinkMicFloatWindowState(true);
    L38:
        com.bytedance.android.livesdk.sharedpref.e r40 = b6.e0;
        Boolean r41 = Boolean.TRUE;
        r40.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r40, r41);
        r15.e = true;
        r15.f = false;
        r15.T = new CompositeDisposable();
        r15.I = System.currentTimeMillis();
        rx1.g r42 = LinkmicOnlineFloatWindowManager.m();
        if (r42 == null) goto L43;
        rx1.f r43 = r42.a;
        if (r43 == null) goto L43;
        View r44 = r43.c;
    L45:
        if ((r44 instanceof com.bytedance.android.live.liveinteract.floatwindow.onlinewindow.b) == true) goto L47;
        r44 = null;
    L47:
        com.bytedance.android.live.liveinteract.floatwindow.onlinewindow.b r45 = (com.bytedance.android.live.liveinteract.floatwindow.onlinewindow.b) r44;
        if (r45 == null) goto L51;
        r45.setInitState(r15.m);
    L51:
        if (v.a() == true) goto L53;
    L55:
        IMessageManagerProviderService r110 = jc1.k.n(IMessageManagerProviderService.class);
        Application r111 = jc1.a.b();
        IRoom r46 = r15.m;
        if (r46 == null) goto L58;
        long r112 = r46.getRoomId();
    L59:
        LinkedHashMap r113 = new LinkedHashMap();
        com.bytedance.android.livesdk.chatroom.t r47 = com.bytedance.android.live.liveinteract.api.utils.m.b();
        if (r47 == null) goto L64;
        com.bytedance.live.datacontext.j r48 = r47.w1();
        if (r48 == null) goto L64;
        ylc.e r114 = (ylc.e) r48.getValue();
    L65:
        vlc.d r49 = r110.configFloatWindow(r111, r112, r113, r114);
        r15.a = r49;
        if (r49 == null) goto L68;
        r49.startMessage();
    L68:
        vlc.d r50 = r15.a;
        if (r50 == null) goto L71;
        r50.addMessageListener(MessageType.LINK_MIC.getKey(), r15);
    L71:
        vlc.d r51 = r15.a;
        if (r51 == null) goto L74;
        r51.addMessageListener(MessageType.LINKER.getKey(), r15);
    L74:
        vlc.d r52 = r15.a;
        if (r52 == null) goto L77;
        r52.addMessageListener(MessageType.LINK_MIC_PROFIT.getKey(), r15);
    L77:
        vlc.d r53 = r15.a;
        if (r53 == null) goto L80;
        r53.addMessageListener(MessageType.MEMBER.getKey(), r15);
    L80:
        vlc.d r54 = r15.a;
        if (r54 == null) goto L83;
        r54.addMessageListener(MessageType.CONTROL.getKey(), r15);
    L83:
        vlc.d r55 = r15.a;
        if (r55 == null) goto L86;
        r55.addMessageListener(MessageType.LINK_GUEST_BATTLE_MESSAGE.getKey(), r15);
    L86:
        vlc.d r56 = r15.a;
        if (r56 == null) goto L89;
        r56.addMessageListener(MessageType.KTV_MESSAGE.getKey(), r15);
    L89:
        vlc.d r57 = r15.a;
        if (r57 == null) goto L92;
        r57.addMessageListener(MessageType.LINK_TEAM_FIGHT_MESSAGE.getKey(), r15);
    L92:
        vlc.d r58 = r15.a;
        if (r58 == null) goto L95;
        r58.addMessageListener(MessageType.LINK_MIC_AUDIENCE_KTV_MESSAGE.getKey(), r15);
    L95:
        vlc.d r59 = r15.a;
        if (r59 == null) goto L98;
        r59.addMessageListener(MessageType.LINK_MIC_ORDER_SING_MESSAGE.getKey(), r15);
    L98:
        vlc.d r60 = r15.a;
        if (r60 == null) goto L101;
        r60.addMessageListener(MessageType.THEMED_COMPETITION_MESSAGE.getKey(), r15);
    L101:
        xe0.a r61 = new xe0.a(r15.m, r15, r15.a);
        r15.c = r61;
        vlc.d r62 = r61.a;
        if (r62 == null) goto L104;
        r62.addMessageListener(MessageType.LINK_MIC.getKey(), r61);
    L104:
        vlc.d r63 = r61.a;
        if (r63 == null) goto L107;
        r63.addMessageListener(MessageType.CONTROL.getKey(), r61);
    L107:
        vlc.d r65 = r61.a;
        if (r65 == null) goto L110;
        r65.addMessageListener(MessageType.LINKER.getKey(), r61);
    L110:
        xe0.h r66 = new xe0.h();
        r15.b = r66;
        com.bytedance.android.live.core.utils.rxutils.j.a r67 = com.bytedance.android.live.core.utils.rxutils.j.a;
        r66.c = com.bytedance.android.live.core.utils.rxutils.j.a(0, 1000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new xe0.i(r66));
        xe0.h r68 = r15.b;
        if (r68 == null) goto L113;
        Intrinsics.checkNotNullParameter(r15, "listener");
        r68.d.add(r15);
    L64:
        r114 = null;
        goto L65
    L58:
        r112 = 0;
        goto L59
    L53:
        if (vm2.c.h().b() == false) goto L55;
    L43:
        r44 = null;
    L29:
        r19 = "";
        goto L30
    L125:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.log.filter.IMiddlewarePageFilter");
    L22:
        r10 = 0;
        goto L23
    L127:
        return;
    L126:
        return;
    L7:
        r3 = null;
        goto L8
    }
}
