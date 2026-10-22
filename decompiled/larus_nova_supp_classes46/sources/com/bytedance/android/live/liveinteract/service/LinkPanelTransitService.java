package com.bytedance.android.live.liveinteract.service;

import android.content.Context;
import android.view.MotionEvent;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.TalkRoomFeedbackDialog;
import com.bytedance.android.live.liveinteract.component.api.linkpanel.ILinkPanelService;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import com.bytedance.android.live.liveinteract.linkpanel.widget.LinkApplyListWidget;
import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.utils.OpenPanelSource;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomOperate;
import com.bytedance.android.live.liveinteract.plantform.utils.i0;
import com.bytedance.android.live.liveinteract.plantform.utils.x;
import com.bytedance.android.live.liveinteract.revenue.adventure.AdventureContext;
import com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.LinkRoomFightContext;
import com.bytedance.android.live.liveinteract.revenuebase.MultiRevenueDataContext;
import com.bytedance.android.live.liveinteract.utils.c1;
import com.bytedance.android.live.liveinteract.videotalk.themecompetition.ThemedCompetitionContext;
import com.bytedance.android.live.liveinteract.videotalk.utils.TalkRoomIntegrationPlayMethodUtils;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.interact.model.d0;
import com.bytedance.android.livesdk.chatroom.model.k1;
import com.bytedance.android.livesdk.chatroom.model.q1;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdk.utils.g0;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import gd0.v;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import zg1.a2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class LinkPanelTransitService implements gd0.m {
    public LinkPanelTransitService() {
    }

    public final boolean d() {
        if (ThemedCompetitionContext.Companion.g() == false) goto L6;
        f2.b(2131922725, 0);
        return false;
    L6:
        rj0.k.m2.getClass();
        rj0.k r0 = rj0.k.a.a();
        if (r0 != null) goto L9;
    L12:
        com.bytedance.live.datacontext.j r1 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
        if (r1 == null) goto L18;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r2 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r1.getValue();
        if (r2 == null) goto L18;
        r2.t();
    L18:
        if (d0.d() == false) goto L21;
        f2.b(2131922723, 0);
        return false;
    L21:
        HashMap r3 = g0.a;
        g0.c r4 = g0.b.a("on_dynamic_mode_change_click", LinkPanelTransitService$cPositionCanSwitchScene$1.INSTANCE);
        if (r4 != null) goto L24;
    L26:
        return true;
    L24:
        if (r4.b() == false) goto L26;
        return false;
    L9:
        if (r0.isLinkCasting() != true) goto L12;
        f2.b(2131922724, 0);
        return false;
    }

    public final void e() {
        Intrinsics.checkNotNullParameter("", "requestPage");
        com.bytedance.android.live.liveinteract.plantform.base.g r0 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.k0(32) == false) goto L11;
        rj0.l.n2.getClass();
        rj0.l r1 = rj0.l.a.a();
        if (r1 == null) goto L22;
        rj0.l.b.c(r1, null, 7);
        return;
    L22:
        return;
    L11:
        if (v.a(r0.getCurrentMode(), 2) == false) goto L15;
        com.bytedance.android.live.liveinteract.plantform.base.c.i0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.c r2 = com.bytedance.android.live.liveinteract.plantform.base.c.a.a();
        if (r2 == null) goto L24;
        com.bytedance.android.live.liveinteract.plantform.base.e.b.a(r2);
        return;
    L24:
        return;
    L15:
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r3 = IVoiceChatGuestService.a.a();
        if (r3 == null) goto L18;
        IVoiceChatGuestService.b.a(r3, null, 7);
    L18:
        IKtvService r4 = jc1.k.f(IKtvService.class);
        if (r4 == null) goto L26;
        r4.cancelApply(null, true, null);
        return;
    }

    public final void k() {
        int r0 = c1.a;
        if (e5.n() == false) goto L6;
        f2.b(2131917689, 0);
        return;
    L6:
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r1 = IVoiceChatGuestService.a.a();
        if (r1 == null) goto L9;
        r1.tryAutoFastMatch();
    L9:
        rj0.l.n2.getClass();
        rj0.l r2 = rj0.l.a.a();
        if (r2 == null) goto L12;
        r2.tryAutoFastMatch();
    L12:
        jc1.k.n(IKtvService.class).tryAutoFastMatch();
    }

    public final boolean f(MotionEvent r4) {
        if (r4 != null) goto L5;
    L47:
        return false;
    L5:
        if (r4.getAction() != 0) goto L47;
        HashMap r5 = g0.a;
        g0.c r6 = g0.b.a("on_dynamic_mode_change_click", LinkPanelTransitService$enableSwitchDynamic$1.INSTANCE);
        if (r6 == null) goto L12;
        if (r6.b() == false) goto L12;
        return true;
    L12:
        if (ThemedCompetitionContext.Companion.g() == false) goto L15;
        f2.b(2131922725, 0);
        return true;
    L15:
        rj0.k.m2.getClass();
        rj0.k r7 = rj0.k.a.a();
        if (r7 != null) goto L18;
    L21:
        com.bytedance.live.datacontext.j r8 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
        if (r8 == null) goto L27;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r9 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r8.getValue();
        if (r9 == null) goto L27;
        r9.t();
    L27:
        if (d0.d() == false) goto L30;
        f2.b(2131922722, 0);
        return true;
    L30:
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.a r10 = MultiRevenueDataContext.a.d();
        if (r10 != null) goto L33;
    L35:
        AdventureContext.Companion.getClass();
        if (AdventureContext.a.a() == false) goto L40;
        f2.c(s1.B(2131914600), 0);
        return true;
    L40:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.B() == false) goto L44;
        f2.b(2131922795, 0);
        return true;
    L44:
        if (LinkRoomFightContext.Companion.c() == false) goto L47;
        f2.b(2131918756, 0);
        return true;
    L33:
        if (r10.n(7) == true) goto L35;
        return true;
    L18:
        if (r7.isLinkCasting() != true) goto L21;
        f2.b(2131922724, 0);
        return true;
    }

    public final void g(com.bytedance.android.live.liveinteract.videolink.a r3) {
        Intrinsics.checkNotNullParameter(r3, "inviteAudienceParams");
        rj0.k.m2.getClass();
        rj0.k r0 = rj0.k.a.a();
        if (r0 == null) goto L5;
        r3.c = true;
        r0.invite(r3);
    L8:
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        IVoiceChatAdminService r1 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r1 != null) goto L13;
        IVoiceChatAdminService.Companion.getClass();
        r1 = IVoiceChatAdminService.a.a();
        if (r1 != null) goto L13;
    L14:
        IKtvService r2 = jc1.k.f(IKtvService.class);
        if (r2 == null) goto L18;
        r3.c = true;
        r2.invite(r3);
        return;
    L18:
        return;
    L13:
        r3.c = true;
        r1.invite(r3);
        goto L14
    L5:
        com.bytedance.android.live.liveinteract.plantform.base.k.n0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.k r4 = com.bytedance.android.live.liveinteract.plantform.base.k.a.a();
        if (r4 == null) goto L8;
        r3.c = true;
        r4.invite(r3);
        goto L8
    }

    public static void a(TalkRoomFeedbackDialog r2, FragmentManager r3) {
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r2, "TalkRoomFeedbackDialog", r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r2, r0) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r2.show(r3, "TalkRoomFeedbackDialog");
    }

    public final void h(int r9, boolean r10) {
        if (gh0.a.d() == false) goto L10;
        rj0.k.m2.getClass();
        rj0.k r0 = rj0.k.a.a();
        if (r0 == null) goto L16;
        if (r10 == false) goto L8;
        LinkmicPositionItem.LinkmicPositionStatus r1 = LinkmicPositionItem.LinkmicPositionStatus.LOCKED;
    L9:
        r0.g2(r9, r1.ordinal());
        goto L16
    L8:
        r1 = LinkmicPositionItem.LinkmicPositionStatus.NORMAL;
    L16:
        HashMap r2 = new HashMap();
        r2.put("live_type", "video_live");
        com.bytedance.live.datacontext.j r3 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
        if (r3 == null) goto L23;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r4 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r3.getValue();
        if (r4 == null) goto L23;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r5 = r4.t();
        if (r5 == null) goto L23;
        com.bytedance.android.live.liveinteract.linkpanel.util.m.B(r2, Integer.valueOf(r5.a), 4);
    L23:
        com.bytedance.android.live.liveinteract.linkpanel.util.m.J(r2);
        if (r10 == false) goto L26;
        String r11 = "on";
    L27:
        r2.put("button_type", r11);
        r2.put("seat_num", String.valueOf(r9 + 1));
        rj0.k.m2.getClass();
        rj0.k r12 = rj0.k.a.a();
        if (r12 == null) goto L49;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r13 = r12.getLinkUserInfoCenter();
        if (r13 == null) goto L49;
        List<LinkmicPositionItem> r14 = r13.d();
        if (r14 == null) goto L49;
        Iterator<T> r15 = r14.iterator();
    L35:
        if (r15.hasNext() == false) goto L42;
        Object r6 = r15.next();
        LinkmicPositionItem r7 = (LinkmicPositionItem) r6;
        if (r7.getPosition() != r7.getPosition()) goto L39;
        boolean r8 = true;
    L40:
        if (r8 == false) goto L35;
    L43:
        LinkmicPositionItem r16 = (LinkmicPositionItem) r6;
        if (r16 == null) goto L49;
        String r17 = r16.getActiveName();
        if (r17 != null) goto L48;
        r17 = "";
    L48:
        r2.put("seat_name", r17);
        goto L49
    L39:
        r8 = false;
        goto L40
    L42:
        r6 = null;
    L49:
        r2.put("setting_page", "party_setting");
        j0.l().sendLog("livesdk_anchor_audience_connection_seat_lock_click", r2, new Object[]{IRoom.class});
        return;
    L26:
        r11 = "off";
        goto L27
    L10:
        rj0.l.n2.getClass();
        rj0.l r18 = rj0.l.a.a();
        if (r18 == null) goto L16;
        if (r10 == false) goto L14;
        LinkmicPositionItem.LinkmicPositionStatus r19 = LinkmicPositionItem.LinkmicPositionStatus.LOCKED;
    L15:
        r18.g2(r9, r19.ordinal());
        goto L16
    L14:
        r19 = LinkmicPositionItem.LinkmicPositionStatus.NORMAL;
        goto L15
    }

    public final void i(IBaseUser r5, LinkApplyListWidget.b.a r6) {
        Intrinsics.checkNotNullParameter(r5, "targetUser");
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.m() == false) goto L12;
        IVoiceChatAdminService.Companion.getClass();
        IVoiceChatAdminService r0 = IVoiceChatAdminService.a.a();
        if (r0 == null) goto L7;
        r0.setPermitCallback(r6);
    L7:
        IVoiceChatAdminService r1 = IVoiceChatAdminService.a.a();
        if (r1 == null) goto L10;
        String r2 = r5.getIdString();
        Intrinsics.checkNotNullParameter(r5, "$this$secUidExt");
        r1.accept(r2, r5.getCastSecUid());
    L10:
        jc1.k.n(IKtvService.class).setPermitCallback(r6);
        IKtvService r7 = jc1.k.n(IKtvService.class);
        String r3 = r5.getIdString();
        Intrinsics.checkNotNullParameter(r5, "$this$secUidExt");
        r7.accept(r3, r5.getCastSecUid());
        return;
    L12:
        if (gh0.a.d() == false) goto L20;
        rj0.k.m2.getClass();
        rj0.k r4 = rj0.k.a.a();
        if (r4 == null) goto L16;
        r4.setPermitCallback(r6);
    L16:
        rj0.k r8 = rj0.k.a.a();
        if (r8 == null) goto L34;
        r8.g0(r5);
        return;
    L34:
        return;
    L20:
        if (jc1.k.n(IMiddlewareUserService.class).user().c() == false) goto L28;
        com.bytedance.android.live.liveinteract.plantform.base.k.n0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.k r9 = com.bytedance.android.live.liveinteract.plantform.base.k.a.a();
        if (r9 == null) goto L24;
        r9.setPermitCallback(r6);
    L24:
        com.bytedance.android.live.liveinteract.plantform.base.k r10 = com.bytedance.android.live.liveinteract.plantform.base.k.a.a();
        if (r10 == null) goto L36;
        r10.g0(r5);
        return;
    L36:
        return;
    L28:
        if (jc1.k.n(IMiddlewareUserService.class).user().isAdmin() == false) goto L30;
        f2.b(2131914522, 0);
    L31:
        x.C0(TalkRoomOperate.PERMIT);
        return;
    L30:
        f2.b(2131917298, 0);
        goto L31
    }

    public final void b(String r4, String r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "requestPage");
        Intrinsics.checkNotNullParameter(r5, "fromSource");
        com.bytedance.android.live.liveinteract.plantform.base.g r7 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r7 != null) goto L6;
        return;
    L6:
        if (v.a(r7.getCurrentMode(), 32) == false) goto L11;
        rj0.l.n2.getClass();
        rj0.l r8 = rj0.l.a.a();
        if (r8 == null) goto L22;
        rj0.l.b.a(r8, r6, 112, r5);
        return;
    L22:
        return;
    L11:
        if (v.a(r7.getCurrentMode(), 2) == false) goto L15;
        com.bytedance.android.live.liveinteract.plantform.base.c.i0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.c r9 = com.bytedance.android.live.liveinteract.plantform.base.c.a.a();
        if (r9 == null) goto L24;
        int r10 = bh0.a.a;
        r9.c2(2, 101, r5, null);
        return;
    L24:
        return;
    L15:
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r11 = IVoiceChatGuestService.a.a();
        if (r11 == null) goto L18;
        r11.checkAndApply(r6, String.valueOf(112), LinkApplyType.NORMAL.getValue(), r5);
    L18:
        IKtvService r12 = jc1.k.f(IKtvService.class);
        if (r12 == null) goto L26;
        r12.checkAndApply(-1, String.valueOf(112), LinkApplyType.NORMAL.getValue(), r5);
        return;
    }

    public final void c(Context r7, DataCenter r8, String r9, k1 r10) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "dataCenter");
        Intrinsics.checkNotNullParameter(r9, "source");
        int r3 = TalkRoomIntegrationPlayMethodUtils.a;
        boolean r4 = false;
        if (r10 == null) goto L5;
        int r5 = r10.getType();
    L6:
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "dataCenter");
        Intrinsics.checkNotNullParameter("Link_panel", "requestPage");
        Intrinsics.checkNotNullParameter(r9, "source");
        if ((!Intrinsics.areEqual(r9, OpenPanelSource.LINK_PLAYMODE_PANEL.getValue())) == false) goto L9;
        TalkRoomLogUtils.k0(r5, "Link_panel", r9);
    L9:
        if (r10 == null) goto L18;
        if (r10.isDynamic() != true) goto L18;
        if (r2.a(r10.getSchema()) == false) goto L18;
        IBaseLiveActionHandler r11 = jc1.k.f(IBaseLiveActionHandler.class);
        if (r11 == null) goto L75;
        r11.handle(r7, r10.getSchema());
    L75:
        r4 = true;
    L76:
        if (r4 == false) goto L83;
        ILinkPanelService r12 = com.bytedance.android.live.liveinteract.component.b.a();
        if (r12 == null) goto L80;
        r12.close();
    L80:
        if (r10 == null) goto L84;
        int r13 = Integer.valueOf(r10.getType()).intValue();
        Set<Integer> r14 = com.bytedance.android.live.liveinteract.linkpanel.util.h.a;
        r14.add(Integer.valueOf(r13));
        com.bytedance.android.livesdk.sharedpref.e r15 = b6.b0;
        r15.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r15, r14);
        return;
    L84:
        return;
    L83:
        return;
    L18:
        if (r5 != 2) goto L20;
        li0.b r16 = li0.b.b;
        li0.b.g("link_panel", r9);
        com.bytedance.android.live.liveinteract.revenue.fight.b r17 = ((IInteractService) jc1.k.n(IInteractService.class)).teamFightService();
        if (r17 == null) goto L75;
        r17.d3("link_panel");
        goto L75
    L20:
        if (r5 != 3) goto L22;
        r8.put("cmd_video_talk_guest_battle_open_panel", "Link_panel");
        goto L75
    L22:
        if (r5 == 5) goto L65;
        if (r5 != 7) goto L26;
        xi0.a r18 = ((IInteractService) jc1.k.n(IInteractService.class)).linkRoomFightService();
        if (r18 == null) goto L75;
        r18.d0(bj0.b.b, new bj0.c(r9));
        goto L75
    L26:
        if (r5 == 15) goto L60;
        String r0 = null;
        switch(r5) {
            case 10: goto L43;
            case 11: goto L39;
            case 12: goto L33;
            case 13: goto L32;
            default: goto L29;
        };
    L29:
        switch(r5) {
            case 100: goto L49;
            case 101: goto L48;
            case 102: goto L47;
            case 103: goto L46;
            default: goto L30;
        };
    L30:
        if (r10 == null) goto L50;
        int r19 = r10.getGameDataType();
    L52:
        if (je0.d.I(Integer.valueOf(r19)) == false) goto L76;
        xs2.b r20 = xs2.b.a();
        if (r10 == null) goto L58;
        q1 r1 = r10.getInteractInfo();
        if (r1 == null) goto L58;
        String r2 = r1.getAppId();
    L59:
        r20.post(new a2(null, r2, null, 5));
    L58:
        r2 = null;
        goto L59
    L50:
        r19 = 0;
        goto L52
    L46:
        TalkRoomIntegrationPlayMethodUtils.a(r7, "radio");
        goto L75
    L47:
        TalkRoomIntegrationPlayMethodUtils.a(r7, "chorus");
        goto L75
    L48:
        TalkRoomIntegrationPlayMethodUtils.a(r7, "ktv");
        goto L75
    L49:
        TalkRoomIntegrationPlayMethodUtils.a(r7, PbRequest.SwitchType.ROOM);
        goto L75
    L32:
        int r21 = gj0.h.a;
        gj0.h.a(jc1.a.b(), MapsKt.mapOf(TuplesKt.to("request_page", "link_playmode_panel")), true);
        goto L75
    L33:
        i0 r22 = TalkRoomLogUtils.a;
        LinkedHashMap r23 = new LinkedHashMap();
        r23.put("request_page", "link_panel");
        r23.put("function_type", TalkRoomLogUtils.g());
        IMiddlewareUserService r24 = jc1.k.f(IMiddlewareUserService.class);
        if (r24 == null) goto L38;
        com.bytedance.android.livesdk.user.e r25 = r24.user();
        if (r25 == null) goto L38;
        r0 = r25.n();
    L38:
        r23.put("user_id", String.valueOf(r0));
        r23.put("user_type", "anchor");
        j0.l().sendLog("livesdk_room_meetgame_icon_click", r23, new Object[]{IRoom.class});
        String r26 = bi0.a.a;
        bi0.a.b(jc1.a.b(), MapsKt.mapOf(TuplesKt.to("request_page", "link_panel")));
        goto L75
    L39:
        pj0.b r27 = ThemedCompetitionContext.Companion.c();
        if (r27 == null) goto L75;
        r27.ja(r9);
        goto L75
    L43:
        if (qf0.b.e() == true) goto L76;
        qf0.b.d(r7, r9);
        goto L75
    L60:
        int r28 = mf0.b.a;
        mf0.b.a(jc1.a.b(), r9);
        goto L75
    L65:
        if (cj0.h.a() == true) goto L76;
        if (InteractiveSongContext.Companion.f() == false) goto L70;
        f2.b(2131919594, 0);
        goto L76
    L70:
        ((IInteractService) jc1.k.n(IInteractService.class)).getAudioTalkService().c(r7, r9);
        goto L75
    L5:
        r5 = 0;
        goto L6
    }

    public final void j(long r8, String r10, String r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "secFromUserId");
        Intrinsics.checkNotNullParameter(r11, "fromUserIdString");
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r1 = IVoiceChatGuestService.a.a();
        if (r1 == null) goto L5;
        r1.checkAndReply(r8, r10, r11, r12);
    L5:
        IKtvService r2 = jc1.k.f(IKtvService.class);
        if (r2 == null) goto L8;
        r2.checkAndReply(r8, r10, r11, r12);
    L8:
        rj0.l.n2.getClass();
        rj0.l r3 = rj0.l.a.a();
        if (r3 == null) goto L12;
        r3.X3(r8, r10, r11, r12);
        return;
    }

    public final void l(Context r8, DataCenter r9, String r10, k1 r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "dataCenter");
        Intrinsics.checkNotNullParameter(r10, "source");
        int r0 = TalkRoomIntegrationPlayMethodUtils.a;
        if (r11 == null) goto L5;
        int r3 = r11.getType();
    L7:
        if (TalkRoomIntegrationPlayMethodUtils.b(r8, r9, r3, "Link_panel", r10, r11) == false) goto L15;
        ILinkPanelService r13 = com.bytedance.android.live.liveinteract.component.b.a();
        if (r13 == null) goto L11;
        r13.close();
    L11:
        if (r12 == false) goto L16;
        if (r11 == null) goto L17;
        int r14 = Integer.valueOf(r11.getType()).intValue();
        Set<Integer> r15 = com.bytedance.android.live.liveinteract.linkpanel.util.h.a;
        r15.add(Integer.valueOf(r14));
        com.bytedance.android.livesdk.sharedpref.e r16 = b6.b0;
        r16.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r16, r15);
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    L5:
        r3 = 0;
        goto L7
    }
}
