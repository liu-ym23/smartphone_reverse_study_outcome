package com.bytedance.android.live.liveinteract.videotalk;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.broadcastgame.api.interactgame.IGameDataService;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.permission.model.OperateType;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.s0;
import com.bytedance.android.live.liveinteract.revenue.battle.GuestBattleContext;
import com.bytedance.android.live.liveinteract.revenue.fight.TeamFightContext;
import com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.LinkRoomFightContext;
import com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.SelfDisciplineContext;
import com.bytedance.android.live.liveinteract.videotalk.themecompetition.ThemedCompetitionContext;
import com.bytedance.android.live.liveinteract.videotalk.utils.TalkRoomIntegrationPlayMethodUtils;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.SongListItemViewHolder;
import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.android.livesdkapi.depend.model.live.IAudienceLinkmicEntranceInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.common.utility.Lists;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.google.gson.JsonObject;
import hh1.v0;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import w20.xc;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i0 implements rj0.m {
    public i0() {
    }

    @Override // rj0.m
    public final void r() {
    }

    @Override // rj0.m
    public final Observable<Boolean> D() {
        return Observable.defer(new f0()).flatMap(new g0());
    }

    @Override // rj0.m
    public final com.bytedance.android.live.liveinteract.videotalk.ui.a F() {
        return new com.bytedance.android.live.liveinteract.videotalk.ui.a();
    }

    @Override // rj0.m
    public final boolean G() {
        int r0 = TalkRoomIntegrationPlayMethodUtils.a;
        com.bytedance.android.live.liveinteract.plantform.base.g r1 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r1 == null) goto L5;
        int r2 = r1.getCurrentMode();
    L7:
        if (gd0.v.a(r2, 32) == true) goto L10;
    L8:
        return true;
    L10:
        if (((IInteractService) jc1.k.n(IInteractService.class)).dynamicFromAudience() == true) goto L19;
        com.bytedance.live.datacontext.j r3 = com.bytedance.android.live.liveinteract.api.utils.m.i().A2();
        if (r3 == null) goto L14;
        DataCenter r4 = (DataCenter) r3.getValue();
    L16:
        if (s0.h(r4) == true) goto L19;
        f2.b(2131922650, 0);
        return false;
    L14:
        r4 = null;
    L19:
        int r5 = je0.d.f();
        Integer r6 = je0.d.h();
        if (r5 != 8) goto L27;
        if (r6 == null) goto L27;
        if (r6.intValue() != 6) goto L27;
        f2.c(s1.C(2131921477, new Object[]{s1.B(2131918683)}), 0);
        return false;
    L27:
        if (LinkRoomFightContext.Companion.c() == false) goto L30;
        f2.c(s1.C(2131921477, new Object[]{s1.B(2131918743)}), 0);
        return false;
    L30:
        if (TeamFightContext.Companion.h() == false) goto L33;
        f2.c(s1.C(2131921477, new Object[]{s1.B(2131922798)}), 0);
        return false;
    L33:
        if (SelfDisciplineContext.Companion.e() == false) goto L36;
        f2.c(s1.C(2131921477, new Object[]{s1.B(2131922430)}), 0);
        return false;
    L36:
        if (GuestBattleContext.Companion.e() == false) goto L39;
        f2.c(s1.C(2131921477, new Object[]{s1.B(2131917225)}), 0);
        return false;
    L39:
        if (fj0.e.k() == false) goto L42;
        f2.c(s1.C(2131921477, new Object[]{s1.B(2131921167)}), 0);
        return false;
    L42:
        if (jc1.k.n(IKtvService.class).inMultipleKtvOld() == false) goto L45;
        f2.c(s1.C(2131921477, new Object[]{s1.B(2131918597)}), 0);
        return false;
    L45:
        if (ThemedCompetitionContext.Companion.g() == false) goto L47;
        f2.c(s1.C(2131921477, new Object[]{s1.B(2131922888)}), 0);
        return false;
    L47:
        IInteractService r7 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r7 == null) goto L54;
        ih0.b r8 = r7.dynamicService(null);
        if (r8 == null) goto L54;
        if (r8.jl("star_wish") != true) goto L54;
        f2.c(s1.C(2131921477, new Object[]{s1.B(2131922640)}), 0);
        return false;
    L54:
        IGameDataService r9 = jc1.k.f(IGameDataService.class);
        if (r9 != null) goto L57;
    L62:
        IMiddlewareUserService r10 = jc1.k.f(IMiddlewareUserService.class);
        if (r10 == null) goto L68;
        com.bytedance.android.livesdk.user.e r11 = r10.user();
        if (r11 == null) goto L68;
        String r12 = r11.n();
        if (r12 == null) goto L68;
    L69:
        IInteractService r13 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r13 == null) goto L76;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r14 = r13.getLinkUserInfoCenter();
        if (r14 == null) goto L76;
        ILinkPlayerInfoBridge r15 = (ILinkPlayerInfoBridge) r14.a5(r12, "");
        if (r15 == null) goto L76;
        int r16 = r15.getLinkType();
    L78:
        if (r16 != 3) goto L8;
        f2.c(s1.B(2131921476), 0);
        return false;
    L76:
        r16 = 0;
    L68:
        r12 = "";
        goto L69
    L57:
        if (r9.isRunningPlugin() == false) goto L62;
        String r17 = r9.isRunningPluginName();
        if (r17 != null) goto L61;
        r17 = s1.B(2131916812);
    L61:
        f2.c(s1.C(2131921477, new Object[]{r17}), 0);
        return false;
    L5:
        r2 = 0;
        goto L7
    }

    @Override // rj0.m
    public final int H() {
        rj0.k.m2.getClass();
        if (rj0.k.a.a() != null) goto L5;
        return 0;
    L5:
        if (rj0.k.a.a().getOnlineList() != null) goto L7;
        return 0;
    L7:
        return rj0.k.a.a().getOnlineList().size() - 1;
    }

    @Override // rj0.m
    public final void Q() {
        rj0.k.m2.getClass();
        if (rj0.k.a.a() == null) goto L6;
        rj0.k.a.a().Q();
        return;
    }

    @Override // rj0.m
    public final void b3() {
        rj0.l.n2.getClass();
        if (rj0.l.a.a() == null) goto L6;
        rj0.l.a.a().b3();
        return;
    }

    @Override // rj0.m
    public final void forceReverseCamera() {
        rj0.l.n2.getClass();
        if (rj0.l.a.a() == null) goto L5;
        rj0.l.a.a().forceReverseCamera();
    L5:
        rj0.k.m2.getClass();
        if (rj0.k.a.a() == null) goto L9;
        rj0.k.a.a().forceReverseCamera();
        return;
    }

    @Override // rj0.m
    public final JsonObject getLinkmicAreaFrameInfo() {
        rj0.k.m2.getClass();
        if (rj0.k.a.a() != null) goto L5;
        rj0.l.n2.getClass();
        if (rj0.l.a.a() != null) goto L9;
        return null;
    L9:
        return rj0.l.a.a().getLinkmicAreaFrameInfo();
    L5:
        return rj0.k.a.a().getLinkmicAreaFrameInfo();
    }

    @Override // rj0.m
    public final JsonObject getLinkmicSeatListInfo() {
        rj0.k.m2.getClass();
        if (rj0.k.a.a() != null) goto L5;
        rj0.l.n2.getClass();
        if (rj0.l.a.a() != null) goto L9;
        return null;
    L9:
        return rj0.l.a.a().getLinkmicSeatListInfo();
    L5:
        return rj0.k.a.a().getLinkmicSeatListInfo();
    }

    @Override // rj0.d
    public final com.bytedance.android.live.pushstream.d getLiveStream() {
        rj0.k.m2.getClass();
        rj0.k r0 = rj0.k.a.a();
        if (r0 != null) goto L5;
        rj0.l.n2.getClass();
        rj0.l r1 = rj0.l.a.a();
        if (r1 != null) goto L9;
        return null;
    L9:
        return r1.getLiveStream();
    L5:
        return r0.getLiveStream();
    }

    @Override // rj0.m
    public final boolean isRtcEngineOn() {
        rj0.k.m2.getClass();
        if (rj0.k.a.a() != null) goto L5;
        return false;
    L5:
        return rj0.k.a.a().isEngineOn();
    }

    @Override // rj0.m
    public final com.bytedance.android.live.liveinteract.api.data.a j() {
        com.bytedance.android.live.liveinteract.api.data.a.h.getClass();
        return com.bytedance.android.live.liveinteract.api.data.a.C0017a.k();
    }

    @Override // rj0.m
    public final int m() {
        if (gd0.v.a(((IInteractService) jc1.k.f(IInteractService.class)).getLinkMode(), 32) == true) goto L5;
        return 0;
    L5:
        if (((IInteractService) jc1.k.f(IInteractService.class)).getCurrentScene() != 12) goto L8;
        return 0;
    L8:
        return ((int) ((s1.G(s1.w()) - 200.0f) / 6.0f)) / 2;
    }

    @Override // rj0.m
    public final String s() {
        String r0 = ak0.a.a;
        String r2 = null;
        boolean r1 = true;
        if (((Boolean) vm2.d.j.getValue(null, vm2.d.a[8])).booleanValue() == true) goto L6;
    L8:
        boolean r3 = false;
    L9:
        if (r3 == false) goto L24;
        IAudienceLinkmicEntranceInfo r4 = ak0.a.a();
        if (r4 == null) goto L22;
        String r5 = r4.getText();
        if (r5 != null) goto L16;
    L19:
        if (r1 == true) goto L22;
        r2 = r5;
        goto L22
    L16:
        if (r5.length() == 0) goto L19;
        r1 = false;
    L22:
        if (r2 == null) goto L24;
        return r2;
    L24:
        return ak0.a.a;
    L6:
        if (ak0.a.a() == null) goto L8;
        r3 = true;
        goto L9
    }

    @Override // rj0.m
    public final void s3() {
        rj0.k.m2.getClass();
        rj0.k r0 = rj0.k.a.a();
        if (r0 != null) goto L5;
        return;
    L5:
        r0.s3();
    }

    @Override // rj0.m
    public final int t() {
        rj0.k.m2.getClass();
        if (rj0.k.a.a() != null) goto L5;
        return 0;
    L5:
        if (rj0.k.a.a().getOnlineList() != null) goto L7;
        return 0;
    L7:
        if (((IInteractService) jc1.k.f(IInteractService.class)).getCurrentScene() == 8) goto L9;
        return 0;
    L9:
        if (((IInteractService) jc1.k.f(IInteractService.class)).getCurrentUiLayout() == 7) goto L13;
        if (((IInteractService) jc1.k.f(IInteractService.class)).getCurrentUiLayout() == 52) goto L13;
        return 0;
    L13:
        return rj0.k.a.a().getOnlineList().size() - 1;
    }

    @Override // rj0.m
    public final BehaviorSubject<Boolean> U4() {
        if (com.bytedance.android.live.liveinteract.plantform.base.f.a() != null) goto L5;
        return null;
    L5:
        return com.bytedance.android.live.liveinteract.plantform.base.f.a().U4();
    }

    @Override // rj0.m
    public final boolean z() {
        com.bytedance.android.livesdk.chatroom.u r0 = com.bytedance.android.live.liveinteract.api.utils.m.d();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.getVideoTalkRoomSubScene() != null) goto L7;
        return false;
    L7:
        if (r0.getVideoTalkRoomSubScene().getValue() == null) goto L22;
        List r1 = ((com.bytedance.android.livesdk.chatroom.viewmodel.e) r0.getVideoTalkRoomSubScene().getValue()).t().b;
        if (r1 == null) goto L23;
        Iterator r2 = r1.iterator();
    L12:
        if (r2.hasNext() == false) goto L24;
        if (((Integer) r2.next()).intValue() != 1) goto L12;
        return true;
    L24:
        return false;
    L23:
        return false;
    L22:
        return false;
    }

    @Override // rj0.m
    public final tf0.v E() {
        return rj0.m.a;
    }

    public static List<ILinkPlayerInfoBridge> O(boolean r2) {
        if (r2 == false) goto L7;
        rj0.k.m2.getClass();
        rj0.k r3 = rj0.k.a.a();
        if (r3 == null) goto L10;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r4 = r3.getLinkUserInfoCenter();
    L11:
        if (r4 != null) goto L13;
    L16:
        return null;
    L13:
        if (Lists.isEmpty(r4.getOnlineUserList()) == true) goto L16;
        return r4.getOnlineUserList();
    L10:
        r4 = null;
        goto L11
    L7:
        com.bytedance.android.live.liveinteract.plantform.base.k.n0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.k r5 = com.bytedance.android.live.liveinteract.plantform.base.k.a.a();
        if (r5 == null) goto L10;
        r4 = r5.getLinkUserInfoCenter();
        goto L11
    }

    @Override // rj0.m
    public final void A(dq2.w.a r2) {
        rj0.k.m2.getClass();
        if (rj0.k.a.a() == null) goto L6;
        rj0.k.a.a().h2(r2);
        return;
    }

    @Override // rj0.m
    public final int K(boolean r2) {
        if (r2 == false) goto L8;
        com.bytedance.android.live.liveinteract.plantform.base.a.g0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.a r3 = com.bytedance.android.live.liveinteract.plantform.base.a.C0047a.a();
        if (r3 != null) goto L7;
        return -1;
    L7:
        hg6.g r4 = r3.R1();
    L12:
        if (r4 != null) goto L15;
        return -1;
    L15:
        return r4.b();
    L8:
        com.bytedance.android.live.liveinteract.plantform.base.b.h0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.b r5 = com.bytedance.android.live.liveinteract.plantform.base.b.a.a();
        if (r5 != null) goto L11;
        return -1;
    L11:
        r4 = r5.P2();
        goto L12
    }

    @Override // rj0.m
    public final Pair<Boolean, Long> M(String r3) {
        Map.Entry r4 = tc0.c.h().g(r3);
        if (r4 == null) goto L7;
        return new Pair(Boolean.TRUE, (Long) r4.getKey());
    L7:
        return new Pair(Boolean.FALSE, null);
    }

    @Override // rj0.m
    public final void a(tf0.q r4) {
        rj0.l.n2.getClass();
        if (rj0.l.a.a() == null) goto L6;
        rj0.l.a.a().o2(true, (SongListItemViewHolder.bindClickListener.3.c) r4, null);
        return;
    }

    @Override // rj0.m
    public final void f(String r4) {
        int r0 = bh0.a.a;
        N(r4, 103, LinkApplyType.NORMAL, null);
    }

    @Override // rj0.m
    public final boolean finishVideoTalk(String r2) {
        rj0.k.m2.getClass();
        if (rj0.k.a.a() == null) goto L6;
        rj0.k.a.a().finishVideoTalk(r2);
        return true;
    L6:
        return false;
    }

    @Override // rj0.m
    public final void l(String r5) {
        if (je0.d.f() == 16) goto L5;
        return;
    L5:
        g2 r0 = zi0.d.b;
        Intrinsics.checkNotNullParameter(r5, "guestId");
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("guest_id", r5.toString());
        TalkRoomLogUtils.J0(r1);
        TalkRoomLogUtils.B0(r1, null, null, 6);
        TalkRoomLogUtils.u0(r1);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_room_grouppk_others_live_icon_click", r1, new Object[]{IRoom.class});
    }

    @Override // rj0.m
    public final void o(h80.a r4) {
        rj0.l.n2.getClass();
        rj0.l r0 = rj0.l.a.a();
        if (r0 != null) goto L5;
        return;
    L5:
        r0.cancelApply(r4, false, null);
    }

    @Override // rj0.m
    public final MultiLinkVideoTalkRoomGuestWidget y(gd0.p r2) {
        return new MultiLinkVideoTalkRoomGuestWidget(r2);
    }

    @Override // rj0.m
    public final boolean C(boolean r2, String r3) {
        if (u(r2, r3) == true) goto L5;
        return false;
    L5:
        if (r2 == false) goto L8;
        return true;
    L8:
        com.bytedance.android.live.liveinteract.plantform.base.b.h0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.b r4 = com.bytedance.android.live.liveinteract.plantform.base.b.a.a();
        if (r4 != null) goto L11;
        return false;
    L11:
        hg6.g r5 = r4.P2();
        if (r5 != null) goto L15;
        return false;
    L15:
        return r5.A();
    }

    @Override // rj0.m
    public final boolean I(boolean r3, User r4) {
        if (r3 == false) goto L6;
        rj0.k.m2.getClass();
        rj0.k r5 = rj0.k.a.a();
        if (r5 == null) goto L9;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r6 = r5.getLinkUserInfoCenter();
    L10:
        if (r6 != null) goto L12;
    L24:
        return false;
    L12:
        if (Lists.isEmpty(r6.a()) == true) goto L24;
        Iterator r7 = r6.a().iterator();
    L16:
        if (r7.hasNext() == false) goto L24;
        ILinkPlayerInfoBridge r0 = (ILinkPlayerInfoBridge) r7.next();
        if (r0 == null) goto L16;
        if (r0.getUser() == null) goto L16;
        if (TextUtils.equals(r0.getUser().getIdString(), r4.getIdString()) == false) goto L16;
        return true;
    L9:
        r6 = null;
        goto L10
    L6:
        com.bytedance.android.live.liveinteract.plantform.base.k.n0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.k r8 = com.bytedance.android.live.liveinteract.plantform.base.k.a.a();
        if (r8 == null) goto L9;
        r6 = r8.getLinkUserInfoCenter();
        goto L10
    }

    @Override // rj0.m
    public final void c(Context r2, String r3) {
        if (fj0.c.a() == false) goto L6;
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "source");
        cj0.h.b(r2, r3);
        return;
    }

    @Override // rj0.m
    public final boolean d(String r16, boolean r17) {
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r0 = ((IInteractService) jc1.k.f(IInteractService.class)).getLinkUserInfoCenter();
        if (r0 != null) goto L5;
        return false;
    L5:
        List<T> r1 = r0.a();
        if (r1 != 0) goto L8;
        return false;
    L8:
        if (r1.isEmpty() == true) goto L50;
        Iterator r2 = r1.iterator();
    L11:
        if (r2.hasNext() == false) goto L54;
        ILinkPlayerInfoBridge r3 = (ILinkPlayerInfoBridge) r2.next();
        IBaseUser r4 = r3.getUser();
        if (r4 == null) goto L11;
        if (TextUtils.equals(r16, r4.getIdString()) == false) goto L11;
        if (r17 == false) goto L29;
        rj0.k.m2.getClass();
        rj0.k r6 = rj0.k.a.a();
        if (r6 == null) goto L51;
        r6.permit(r3);
        if (r17 == false) goto L23;
        String r9 = "anchor";
    L25:
        if (r3.getWaitingListUserInfo() == null) goto L27;
        boolean r12 = !TextUtils.isEmpty(r3.getWaitingListUserInfo().getApplyReason());
    L28:
        TalkRoomLogUtils.B.r0(r4.getIdString(), r9, r3.getSongList(), "up_link", r12, r4.isSubscriber(), Long.valueOf(r3.getLinkMicPosTagType()));
    L40:
        return true;
    L27:
        r12 = false;
        goto L28
    L23:
        r9 = "administrator";
        goto L25
    L51:
        return false;
    L29:
        com.bytedance.android.live.liveinteract.plantform.base.k.n0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.k r7 = com.bytedance.android.live.liveinteract.plantform.base.k.a.a();
        if (r7 == null) goto L52;
        r7.permit(r3);
        if (r17 == false) goto L34;
        String r10 = "anchor";
    L36:
        if (r3.getWaitingListUserInfo() == null) goto L38;
        boolean r13 = !TextUtils.isEmpty(r3.getWaitingListUserInfo().getApplyReason());
    L39:
        TalkRoomLogUtils.B.r0(r4.getIdString(), r10, r3.getSongList(), "up_link", r13, r4.isSubscriber(), Long.valueOf(r3.getLinkMicPosTagType()));
        goto L40
    L38:
        r13 = false;
        goto L39
    L34:
        r10 = "administrator";
        goto L36
    L52:
        return false;
    L54:
        return false;
    L50:
        return false;
    }

    @Override // rj0.m
    public final boolean e(boolean r4, String r5) {
        List<ILinkPlayerInfoBridge> r6 = O(r4);
        if (Lists.isEmpty(r6) == false) goto L5;
        return false;
    L5:
        Iterator<ILinkPlayerInfoBridge> r7 = r6.iterator();
    L7:
        if (r7.hasNext() == false) goto L27;
        ILinkPlayerInfoBridge r0 = r7.next();
        if (r0 == null) goto L7;
        if (r0.getUser() == null) goto L7;
        if (r0.getUser().getIdString().equals(r5) == false) goto L7;
        if (r0.getSilenceStatus() != 0) goto L26;
        return true;
    L26:
        return false;
    L27:
        return false;
    }

    @Override // rj0.m
    public final MultiLinkVideoTalkRoomAnchorWidget g(v0 r3, com.bytedance.android.live.pushstream.d r4) {
        return new MultiLinkVideoTalkRoomAnchorWidget(r3, r4, tc0.c.h());
    }

    @Override // rj0.m
    public final void openEmojiDialog(String r3, String r4) {
        if (com.bytedance.android.live.liveinteract.api.utils.m.i() == null) goto L5;
        boolean r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor().booleanValue();
    L7:
        if (u(r0, r3) == false) goto L16;
        if (r0 == false) goto L12;
        rj0.k.m2.getClass();
        rj0.k r1 = rj0.k.a.a();
        if (r1 == null) goto L17;
        r1.Qj(r3, r4);
        return;
    L17:
        return;
    L12:
        rj0.l.n2.getClass();
        rj0.l r2 = rj0.l.a.a();
        if (r2 == null) goto L19;
        r2.tm(r3, r4);
        return;
    L19:
        return;
    L16:
        return;
    L5:
        r0 = false;
        goto L7
    }

    @Override // rj0.m
    public final boolean u(boolean r4, String r5) {
        List<ILinkPlayerInfoBridge> r6 = O(r4);
        if (Lists.isEmpty(r6) == false) goto L5;
        return false;
    L5:
        Iterator<ILinkPlayerInfoBridge> r7 = r6.iterator();
    L7:
        if (r7.hasNext() == false) goto L16;
        ILinkPlayerInfoBridge r0 = r7.next();
        if (r0 == null) goto L7;
        if (r0.getUser() == null) goto L7;
        if (r0.getUser().getIdString().equals(r5) == false) goto L7;
        return true;
    L16:
        return false;
    }

    @Override // rj0.m
    public final void x(String r3, LinkApplyType r4) {
        TalkRoomLogUtils.a.getClass();
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r0 = new com.bytedance.android.live.liveinteract.plantform.utils.i0(r3, 114, r4);
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        TalkRoomLogUtils.a = r0;
    }

    @Override // rj0.m
    public final void J(Context r5, IRoom r6, rj0.b r7) {
        rj0.l.n2.getClass();
        rj0.l r0 = rj0.l.a.a();
        if (r0 != null) goto L6;
        int r8 = com.bytedance.android.live.liveinteract.videotalk.utils.k.a;
        OperateType r9 = OperateType.APPLY;
        h0 r1 = new h0(r7);
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r9, "operateType");
        Intrinsics.checkNotNullParameter(r1, "consumer");
        ArrayList r10 = new ArrayList();
        r10.add(qh0.g.a(r9, 2));
        r10.add(new qh0.f.g(r5, r9, 2));
        r10.add(new qh0.f.c(r5, r9, 2));
        r10.add(new qh0.f.a(r5));
        r10.add(new qh0.f.d(r5, r9, 2, true));
        r10.add(new qh0.f.C0257f(r5, r9, 2, true));
        r10.add(new qh0.f.e(r5, r9));
        qh0.f.a(r10).a(r1);
        return;
    L6:
        r0.r0(r5, r6, r7);
    }

    @Override // rj0.m
    public final void N(String r3, int r4, LinkApplyType r5, tf0.b r6) {
        rj0.l.n2.getClass();
        rj0.l r0 = rj0.l.a.a();
        if (r0 != null) goto L5;
        return;
    L5:
        sf0.a r1 = new sf0.a();
        r1.b = r4;
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r1.h = r3;
        r1.c = r5.getValue();
        r1.o = r6;
        r0.apply(r1);
    }

    @Override // rj0.m
    public final void k(int r5, int r6, boolean r7, boolean r8, int r9, xc.a r10) {
        rj0.l.n2.getClass();
        rj0.l r0 = rj0.l.a.a();
        if (r0 != null) goto L5;
        return;
    L5:
        sf0.a r1 = new sf0.a();
        Intrinsics.checkNotNullParameter("paid_link", "<set-?>");
        r1.h = "paid_link";
        r1.j = r5;
        r1.k = r6;
        r1.l = r7;
        r1.m = r8;
        r1.n = r9;
        r1.p = r10;
        r0.apply(r1);
    }
}
