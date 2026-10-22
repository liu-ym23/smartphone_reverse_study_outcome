package com.bytedance.android.live.liveinteract.videotalk.utils;

import android.content.Context;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import com.bytedance.android.live.liveinteract.plantform.utils.OpenPanelSource;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.i0;
import com.bytedance.android.live.liveinteract.revenue.fight.TeamFightContext;
import com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.SelfDisciplineContext;
import com.bytedance.android.live.liveinteract.videotalk.themecompetition.ThemedCompetitionContext;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.chatroom.model.k1;
import com.bytedance.android.livesdk.chatroom.model.q1;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.utils.g0;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.HashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import zg1.a2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class TalkRoomIntegrationPlayMethodUtils {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(Context r1, String r2) {
        i0 r0 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.o1("link_setting_panel");
        TalkRoomLogUtils.e = "link_setting_panel";
        IInteractService r3 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r3 == null) goto L8;
        qd0.a r4 = r3.getAudioTalkService();
        if (r4 == null) goto L9;
        r4.switchVoiceSceneWithCheck(r1, r2);
        return;
    L9:
        return;
    }

    public static boolean b(Context r9, DataCenter r10, int r11, String r12, String r13, k1 r14) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "dataCenter");
        Intrinsics.checkNotNullParameter(r12, "requestPage");
        Intrinsics.checkNotNullParameter(r13, "source");
        if ((!Intrinsics.areEqual(r13, OpenPanelSource.LINK_PLAYMODE_PANEL.getValue())) == false) goto L5;
        TalkRoomLogUtils.k0(r11, r12, r13);
    L5:
        if (r14 != null) goto L7;
    L14:
        xh0.g r3 = null;
        if (r11 == 1) goto L100;
        if (r11 != 2) goto L19;
        com.bytedance.android.live.liveinteract.revenue.fight.b r15 = ((IInteractService) jc1.k.n(IInteractService.class)).teamFightService();
        if (r15 == null) goto L98;
        r15.d0(mi0.a.b, new mi0.b("link_panel", r13));
    L98:
        return true;
    L19:
        if (r11 == 3) goto L93;
        if (r11 != 5) goto L22;
        xh0.d r16 = ((IInteractService) jc1.k.n(IInteractService.class)).getPlayModeService();
        if (r16 == null) goto L69;
        r3 = r16.a(11, null);
    L69:
        if (r3 != null) goto L71;
    L79:
        HashMap r17 = g0.a;
        g0.c r18 = g0.b.a("on_pay_link_try_open_check", TalkRoomIntegrationPlayMethodUtils$videoTalkOpenPlayMethod$1.INSTANCE);
        if (r18 == null) goto L85;
        if (r18.b() == false) goto L85;
        return false;
    L85:
        if (InteractiveSongContext.Companion.f() == false) goto L89;
        f2.b(2131919594, 0);
        return false;
    L89:
        if (cj0.h.a() == true) goto L92;
        ((IInteractService) jc1.k.n(IInteractService.class)).getVideoTalkService().c(r9, r13);
    L92:
        return true;
    L71:
        if (r3.c == true) goto L79;
        if (r3.e.length() <= 0) goto L75;
        boolean r19 = true;
    L76:
        if (r19 == false) goto L79;
        f2.c(r3.e, 0);
        return false;
    L75:
        r19 = false;
        goto L76
    L22:
        if (r11 != 15) goto L24;
        int r20 = mf0.b.a;
        mf0.b.a(jc1.a.b(), r13);
        return true;
    L24:
        if (r11 != 7) goto L26;
        xi0.a r21 = ((IInteractService) jc1.k.n(IInteractService.class)).linkRoomFightService();
        if (r21 == null) goto L63;
        r21.d0(bj0.b.b, new bj0.c(r13));
    L63:
        return true;
    L26:
        if (r11 == 8) goto L53;
        switch(r11) {
            case 10: goto L40;
            case 11: goto L35;
            case 12: goto L33;
            case 13: goto L31;
            default: goto L29;
        };
    L29:
        switch(r11) {
            case 100: goto L50;
            case 101: goto L48;
            case 102: goto L46;
            case 103: goto L44;
            default: goto L121;
        };
    L44:
        a(r9, "radio");
        return true;
    L46:
        a(r9, "chorus");
        return true;
    L48:
        a(r9, "ktv");
        return true;
    L50:
        a(r9, PbRequest.SwitchType.ROOM);
        return true;
    L121:
        if (r14 == null) goto L123;
        int r22 = r14.getGameDataType();
    L125:
        if (je0.d.I(Integer.valueOf(r22)) == false) goto L134;
        xs2.b r23 = xs2.b.a();
        if (r14 == null) goto L131;
        q1 r110 = r14.getInteractInfo();
        if (r110 == null) goto L131;
        String r111 = r110.getAppId();
    L132:
        r23.post(new a2(null, r111, null, 5));
        return true;
    L131:
        r111 = null;
        goto L132
    L134:
        return false;
    L123:
        r22 = 0;
        goto L125
    L31:
        int r24 = gj0.h.a;
        gj0.h.a(jc1.a.b(), MapsKt.mapOf(TuplesKt.to("request_page", "link_playmode_panel")), true);
        return true;
    L33:
        String r25 = bi0.a.a;
        bi0.a.b(jc1.a.b(), MapsKt.mapOf(TuplesKt.to("request_page", "link_playmode_panel")));
        return true;
    L35:
        pj0.b r26 = ThemedCompetitionContext.Companion.c();
        if (r26 == null) goto L38;
        r26.ja(r13);
    L38:
        return true;
    L40:
        if (qf0.b.e() == false) goto L42;
        return false;
    L42:
        qf0.b.d(r9, r13);
        return true;
    L53:
        if (InteractiveSongContext.Companion.f() == false) goto L56;
        f2.b(2131919959, 0);
        return false;
    L56:
        kj0.b r27 = SelfDisciplineContext.Companion.d();
        if (r27 == null) goto L59;
        r27.showManagePanel(r13);
    L59:
        return true;
    L93:
        r10.put("cmd_video_talk_guest_battle_open_panel", r12);
        return true;
    L100:
        if (TeamFightContext.Companion.h() == false) goto L104;
        f2.b(2131922787, 0);
        return false;
    L104:
        if (((Boolean) vm2.d.c1.getValue(null, vm2.d.a[104(0x68, float:1.46E-43)])).booleanValue() == false) goto L107;
        f2.b(2131918307, 0);
        return false;
    L107:
        boolean r28 = jc1.k.n(IKtvService.class).isMultipleKtvEnable(r10);
        boolean r112 = jc1.k.n(IKtvService.class).isKtvComponentV2Enable();
        if (r28 == false) goto L121;
        if (r112 == true) goto L111;
        r10.put("cmd_open_ktv_component_with_link_check", new Pair(Boolean.TRUE, r13));
    L120:
        return true;
    L111:
        if (Intrinsics.areEqual(r13, OpenPanelSource.LINK_SETTING_PANEL.getValue()) == false) goto L115;
        String r29 = "link_setting_panel";
    L113:
        String r7 = r29;
        TalkRoomLogUtils.l0(r7);
        IKtvService r2 = jc1.k.n(IKtvService.class);
        Boolean r6 = Boolean.TRUE;
        jc1.k.n(IKtvService.class).sendKtvComponentV2Command(r2.createKtvComponentCmd(1, r6, r13, r6, r7, null));
        goto L120
    L115:
        if (Intrinsics.areEqual(r13, OpenPanelSource.LINK_INTERACT_PANEL_TAB.getValue()) == false) goto L117;
        r29 = "link_interact_panel_tab";
        goto L113
    L117:
        r29 = "";
        goto L113
    L7:
        if (r14.isDynamic() != true) goto L14;
        if (r2.a(r14.getSchema()) == false) goto L14;
        IBaseLiveActionHandler r113 = jc1.k.f(IBaseLiveActionHandler.class);
        if (r113 == null) goto L13;
        r113.handle(r9, r14.getSchema());
    L13:
        return true;
    }
}
