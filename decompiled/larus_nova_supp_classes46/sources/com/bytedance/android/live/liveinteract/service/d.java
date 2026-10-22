package com.bytedance.android.live.liveinteract.service;

import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.o0;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import com.bytedance.android.live.liveinteract.plantform.permission.model.OperateType;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.x;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService;
import com.bytedance.android.live.multilink.internal.api.core.service.IMultiLinkInternalService;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.common.utility.Lists;
import com.google.gson.JsonObject;
import hh1.w0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import w20.xc;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d implements qd0.a {
    public Integer b;

    public static final class a {
    }

    public static final class b implements qh0.d<rh0.a> {
        public final /* synthetic */ rj0.b a;

        public b(rj0.b r1) {
            this.a = r1;
        }

        @Override // qh0.d
        public final void b(BaseCheckException r3) {
            Intrinsics.checkNotNullParameter(r3, "exception");
            this.a.onFailed(r3);
            InteractLinkFullLinkMonitor.e(OperateType.APPLY.ordinal(), 2, r3);
            TalkRoomBusinessFullLinkMonitor.a.getClass();
            TalkRoomBusinessFullLinkMonitor.U(r3);
            x.K(r3);
        }

        @Override // qh0.d
        public final void onResult(rh0.a r2) {
            this.a.onSuccess();
            InteractLinkFullLinkMonitor.f(OperateType.APPLY.ordinal(), 2);
            TalkRoomBusinessFullLinkMonitor.a.getClass();
            TalkRoomBusinessFullLinkMonitor.V();
            x.L();
        }
    }

    static {
    }

    public d() {
    }

    @Override // qd0.a
    public final boolean L() {
        IVoiceChatAdminService.Companion.getClass();
        IVoiceChatAdminService r0 = IVoiceChatAdminService.a.a();
        if (r0 == null) goto L11;
        jg6.a r1 = r0.getAdminStatusCenter();
        if (r1 == null) goto L11;
        kg6.e r2 = r1.b();
        if (r2 == null) goto L11;
        if (r2.q() != true) goto L11;
        return true;
    L11:
        return false;
    }

    @Override // qd0.a
    public final int b() {
        IVoiceChatAdminService.Companion.getClass();
        IVoiceChatAdminService r0 = IVoiceChatAdminService.a.a();
        if (r0 == null) goto L7;
        hg6.g r1 = r0.rtcManger();
        if (r1 == null) goto L7;
        return r1.b();
    L7:
        return -1;
    }

    @Override // qd0.a
    public final JsonObject getLinkmicAreaFrameInfo() {
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r0 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r1 = IVoiceChatGuestService.a.a();
        if (r0 != null) goto L5;
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.getLinkmicAreaFrameInfo();
    L5:
        return r0.getLinkmicAreaFrameInfo();
    }

    @Override // qd0.a
    public final JsonObject getLinkmicSeatListInfo() {
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r0 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r1 = IVoiceChatGuestService.a.a();
        if (r0 != null) goto L5;
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.getLinkmicSeatListInfo();
    L5:
        return r0.getLinkmicSeatListInfo();
    }

    @Override // qd0.a
    public final JsonObject getTopLeftSeatFrameInfo() {
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r0 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r1 = IVoiceChatGuestService.a.a();
        if (r0 != null) goto L5;
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.getTopLeftSeatFrameInfo();
    L5:
        return r0.getTopLeftSeatFrameInfo();
    }

    @Override // qd0.a
    public final com.bytedance.android.live.pushstream.d guestLiveStream() {
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r0 = IVoiceChatGuestService.a.a();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.guestLiveStream();
    }

    @Override // qd0.a
    public final boolean isEngineOn() {
        IVoiceChatAdminService.Companion.getClass();
        IVoiceChatAdminService r0 = IVoiceChatAdminService.a.a();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isEngineOn();
    }

    @Override // qd0.a
    public final boolean isKtvOn() {
        IVoiceChatAdminService.Companion.getClass();
        IVoiceChatAdminService r0 = IVoiceChatAdminService.a.a();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isKtvOn();
    }

    @Override // qd0.a
    public final boolean ktvWillAutoSilenceSelf() {
        IVoiceChatAdminService.Companion.getClass();
        IVoiceChatAdminService r0 = IVoiceChatAdminService.a.a();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.ktvWillAutoSilenceSelf();
    }

    @Override // qd0.a
    public final void n() {
        IVoiceChatGuestService.Companion.getClass();
        if (IVoiceChatGuestService.a.a() == null) goto L8;
        IVoiceChatGuestService r0 = IVoiceChatGuestService.a.a();
        if (r0 == null) goto L9;
        r0.logChatMatchShow("song_guide", true);
        return;
    L9:
        return;
    }

    @Override // qd0.a
    public final void v() {
        IVoiceChatGuestService.Companion.getClass();
        if (IVoiceChatGuestService.a.a() == null) goto L8;
        IVoiceChatGuestService r0 = IVoiceChatGuestService.a.a();
        if (r0 == null) goto L9;
        r0.logChatMatchClick(9);
        return;
    L9:
        return;
    }

    @Override // qd0.a
    public final String getFunctionType() {
        if (isKtvOn() == false) goto L6;
        return "ktv";
    L6:
        IVoiceChatAdminService.Companion.getClass();
        if (IVoiceChatAdminService.a.a() == null) goto L9;
        return "radio";
    L9:
        return "live";
    }

    @Override // rj0.d
    public final com.bytedance.android.live.pushstream.d getLiveStream() {
        if (je0.d.D() == false) goto L7;
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r0 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r0 != null) goto L12;
    L10:
        return null;
    L12:
        return r0.Ri();
    L7:
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r1 = IVoiceChatGuestService.a.a();
        if (r1 == null) goto L10;
        return r1.guestLiveStream();
    }

    @Override // qd0.a
    public final boolean isSelfVoiceChatRoomAudience() {
        return je0.d.q();
    }

    @Override // qd0.a
    public final boolean B(String r6) {
        IVoiceChatAdminService.Companion.getClass();
        IVoiceChatAdminService r0 = IVoiceChatAdminService.a.a();
        if (r0 == null) goto L5;
        List<ILinkPlayerInfoBridge> r1 = r0.getOnlineUserList();
    L7:
        if (Lists.isEmpty(r1) == false) goto L9;
        return false;
    L9:
        Intrinsics.checkNotNull(r1);
        Iterator<ILinkPlayerInfoBridge> r2 = r1.iterator();
    L11:
        if (r2.hasNext() == false) goto L25;
        ILinkPlayerInfoBridge r3 = r2.next();
        if (r3.getUser() == null) goto L11;
        IBaseUser r4 = r3.getUser();
        if (r4 == null) goto L17;
        String r5 = r4.getIdString();
    L18:
        if (r6 != null) goto L20;
        String r7 = "";
    L22:
        if (Intrinsics.areEqual(r5, r7) == false) goto L11;
        return true;
    L20:
        r7 = r6;
        goto L22
    L17:
        r5 = null;
        goto L18
    L25:
        return false;
    L5:
        r1 = null;
        goto L7
    }

    @Override // qd0.a
    public final void a(tf0.q r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r0 = IVoiceChatGuestService.a.a();
        if (r0 == null) goto L6;
        r0.showFollowGuideDialog(true, r3);
        return;
    }

    @Override // qd0.a
    public final void finishAudioTalk(String r2) {
        Intrinsics.checkNotNullParameter(r2, "reason");
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r0 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r0 == null) goto L5;
        r0.finishAudioTalk(r2);
    L5:
        IKtvService r3 = jc1.k.f(IKtvService.class);
        if (r3 == null) goto L9;
        r3.finishAudioTalk();
        return;
    }

    @Override // qd0.a
    public final void h(h80.a r3) {
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r0 = IVoiceChatGuestService.a.a();
        if (r0 == null) goto L6;
        IVoiceChatGuestService.b.a(r0, r3, 4);
        return;
    }

    @Override // qd0.a
    public final void i(String r9) {
        LinkApplyType r0 = LinkApplyType.STRONG_REACH;
        this.b = Integer.valueOf(r0.getValue());
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r1 = IVoiceChatGuestService.a.a();
        if (r1 == null) goto L9;
        int r5 = bh0.a.a;
        String r6 = String.valueOf(103);
        int r7 = r0.getValue();
        if (r9 != null) goto L7;
        String r8 = "";
    L8:
        r1.checkAndApply(-1, r6, r7, r8);
        goto L9
    L7:
        r8 = r9;
    L9:
        IKtvService r2 = jc1.k.f(IKtvService.class);
        if (r2 == null) goto L16;
        int r10 = bh0.a.a;
        String r3 = String.valueOf(103);
        int r4 = r0.getValue();
        if (r9 != null) goto L14;
        r9 = "";
    L14:
        r2.checkAndApply(-1, r3, r4, r9);
        return;
    }

    @Override // qd0.a
    public final void muteLocalAudio(boolean r3) {
        Intrinsics.checkNotNullParameter("singer cut music", "reason");
        IVoiceChatAdminService.Companion.getClass();
        IVoiceChatAdminService r0 = IVoiceChatAdminService.a.a();
        if (r0 == null) goto L10;
        jg6.a r1 = r0.getAdminStatusCenter();
        if (r1 == null) goto L11;
        kg6.e r2 = r1.b();
        if (r2 == null) goto L12;
        r2.u(r3, "singer cut music");
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // qd0.a
    public final boolean p(User r5) {
        IVoiceChatAdminService.Companion.getClass();
        IVoiceChatAdminService r0 = IVoiceChatAdminService.a.a();
        if (r0 == null) goto L22;
        List<ILinkPlayerInfoBridge> r1 = r0.getLinkWaitingList();
        if (Lists.isEmpty(r1) == false) goto L7;
        return false;
    L7:
        Iterator<ILinkPlayerInfoBridge> r2 = r1.iterator();
    L9:
        if (r2.hasNext() == false) goto L22;
        ILinkPlayerInfoBridge r3 = r2.next();
        if (r3 == null) goto L9;
        if (r3.getUser() == null) goto L9;
        IBaseUser r4 = r3.getUser();
        if (r4 == null) goto L17;
        String r6 = r4.getIdString();
    L19:
        if (Intrinsics.areEqual(r6, r5.getIdString()) == false) goto L9;
        return true;
    L17:
        r6 = null;
    L22:
        return false;
    }

    @Override // qd0.a
    public final void c(Context r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "source");
        if (InteractiveSongContext.Companion.f() == false) goto L7;
        f2.b(2131919594, 0);
        return;
    L7:
        if (fj0.c.a() == false) goto L11;
        if (r3 == null) goto L12;
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "source");
        cj0.h.b(r3, r4);
        return;
    L12:
        return;
    }

    @Override // qd0.a
    public final BaseMultiLinkWidget createVoiceChatRoomGuestWidget(w0 r2, gd0.p r3) {
        Intrinsics.checkNotNullParameter(r3, "liveCycleCallback");
        IMultiLinkInternalService r0 = (IMultiLinkInternalService) jc1.k.f(IMultiLinkInternalService.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.createVoiceGuestContainerWidget(r2, r3);
    }

    @Override // qd0.a
    public final boolean d(String r19, boolean r20) {
        IVoiceChatAdminService.Companion.getClass();
        IVoiceChatAdminService r0 = IVoiceChatAdminService.a.a();
        if (r0 != null) goto L5;
        return false;
    L5:
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r1 = r0.getLinkUserInfoCenter();
        if (r1 != null) goto L8;
        return false;
    L8:
        List<T> r2 = r1.a();
        if (r2 != 0) goto L11;
        return false;
    L11:
        if (r2.isEmpty() == true) goto L45;
        Iterator r3 = r2.iterator();
    L14:
        if (r3.hasNext() == false) goto L48;
        ILinkPlayerInfoBridge r4 = (ILinkPlayerInfoBridge) r3.next();
        IBaseUser r5 = r4.getUser();
        if (r5 == null) goto L14;
        if (Intrinsics.areEqual(r19, r5.getIdString()) == false) goto L14;
        IVoiceChatAdminService.Companion.getClass();
        IVoiceChatAdminService r6 = IVoiceChatAdminService.a.a();
        if (r6 == null) goto L46;
        r6.accept(r5);
        TalkRoomLogUtils r7 = TalkRoomLogUtils.B;
        String r8 = r5.getIdString();
        if (r20 == false) goto L24;
        String r9 = "anchor";
    L25:
        String r10 = r9;
        List<KtvMusic> r11 = r4.getSongList();
        if (r4.getWaitingListUserInfo() == null) goto L34;
        o0 r12 = r4.getWaitingListUserInfo();
        if (r12 == null) goto L30;
        String r13 = r12.getApplyReason();
    L32:
        if (TextUtils.isEmpty(r13) == true) goto L34;
        boolean r14 = true;
    L35:
        IBaseUser r15 = r4.getUser();
        Intrinsics.checkNotNull(r15);
        TalkRoomLogUtils.s0(r7, r8, r10, r11, "up_link", r14, null, null, null, null, r15.isSubscriber(), Long.valueOf(com.bytedance.android.live.liveinteract.plantform.model.n.b(r4)), null, 2528);
        return true;
    L30:
        r13 = null;
    L34:
        r14 = false;
        goto L35
    L24:
        r9 = "administrator";
        goto L25
    L46:
        return false;
    L48:
        return false;
    L45:
        return false;
    }

    @Override // qd0.a
    public final boolean e(boolean r6, String r7) {
        IVoiceChatAdminService.Companion.getClass();
        IVoiceChatAdminService r8 = IVoiceChatAdminService.a.a();
        if (r8 == null) goto L5;
        List<ILinkPlayerInfoBridge> r9 = r8.getOnlineUserList();
    L7:
        if (Lists.isEmpty(r9) == false) goto L9;
        return false;
    L9:
        Intrinsics.checkNotNull(r9);
        Iterator<ILinkPlayerInfoBridge> r10 = r9.iterator();
    L11:
        if (r10.hasNext() == false) goto L34;
        ILinkPlayerInfoBridge r1 = r10.next();
        if (r1.getUser() == null) goto L11;
        IBaseUser r3 = r1.getUser();
        if (r3 == null) goto L17;
        String r4 = r3.getIdString();
    L18:
        if (r7 != null) goto L20;
        String r5 = "";
    L22:
        if (Intrinsics.areEqual(r4, r5) == false) goto L11;
        if (r1.getSilenceStatus() != 0) goto L33;
        return true;
    L33:
        return false;
    L20:
        r5 = r7;
        goto L22
    L17:
        r4 = null;
        goto L18
    L34:
        return false;
    L5:
        r9 = null;
        goto L7
    }

    @Override // qd0.a
    public final void openEmojiDialog(String r4, String r5) {
        Boolean r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor();
        if (r0 == null) goto L5;
        boolean r1 = r0.booleanValue();
    L7:
        if (B(r4) == true) goto L9;
        return;
    L9:
        if (r1 == false) goto L17;
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r2 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r2 == null) goto L26;
        if (r4 != null) goto L14;
        r4 = "";
    L14:
        if (r5 != null) goto L16;
        r5 = "seat";
    L16:
        r2.openEmojiDialog(r4, r5);
        return;
    L26:
        return;
    L17:
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r3 = IVoiceChatGuestService.a.a();
        if (r3 == null) goto L28;
        if (r4 != null) goto L21;
        r4 = "";
    L21:
        if (r5 != null) goto L23;
        r5 = "seat";
    L23:
        r3.openEmojiDialog(r4, r5);
        return;
    L28:
        return;
    L5:
        r1 = false;
        goto L7
    }

    @Override // qd0.a
    public final boolean q(boolean r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "uid");
        if (B(r3) == true) goto L6;
        return false;
    L6:
        if (r2 == false) goto L10;
        return true;
    L10:
        return isEngineOn();
    }

    @Override // qd0.a
    public final void switchVoiceSceneWithCheck(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "toScene");
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r0 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r0 == null) goto L5;
        r0.switchVoiceSceneWithCheck(r2, r3);
    L5:
        IKtvService r1 = jc1.k.f(IKtvService.class);
        if (r1 == null) goto L9;
        r1.switchVoiceSceneWithCheck(r2, r3);
        return;
    }

    @Override // qd0.a
    public final void r0(Context r5, IRoom r6, rj0.b r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, PbRequest.SwitchType.ROOM);
        Intrinsics.checkNotNullParameter(r7, "listener");
        OperateType r8 = OperateType.APPLY;
        ArrayList r0 = new ArrayList();
        r0.add(qh0.g.a(r8, 2));
        r0.add(new qh0.f.g(r5, r8, 2));
        r0.add(new qh0.f.c(r5, r8, 2));
        r0.add(new qh0.f.a(r5));
        r0.add(new qh0.f.d(r5, r8, 2, true));
        r0.add(new qh0.f.C0257f(r5, r8, 2, true));
        r0.add(new qh0.f.e(r5, r8));
        qh0.f.a(r0).a(new b(r7));
    }

    @Override // qd0.a
    public final BaseMultiLinkWidget w(FragmentManager r3, com.bytedance.android.live.pushstream.d r4, w0 r5) {
        if (r4 != null) goto L5;
        return null;
    L5:
        IMultiLinkInternalService r1 = (IMultiLinkInternalService) jc1.k.f(IMultiLinkInternalService.class);
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.createVoiceAnchorContainerWidget(r3, r4, r5);
    }

    @Override // qd0.a
    public final void ktvApply(KtvMusic r8, String r9, LinkApplyType r10, int r11, tf0.b r12) {
        Intrinsics.checkNotNullParameter(r8, "ktvMusic");
        Intrinsics.checkNotNullParameter(r9, "requestType");
        Intrinsics.checkNotNullParameter(r10, "applyType");
        this.b = Integer.valueOf(r10.getValue());
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r1 = IVoiceChatGuestService.a.a();
        if (r1 == null) goto L6;
        r1.ktvApply(r8, r9, r10, r11, r12);
        return;
    }

    @Override // qd0.a
    public final void D5(int r12, int r13, boolean r14, boolean r15, int r16, xc.a r17) {
        Intrinsics.checkNotNullParameter(r17, "linkmicDiscountInfo");
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r1 = IVoiceChatGuestService.a.a();
        if (r1 != null) goto L5;
        return;
    L5:
        Integer r2 = this.b;
        if (r2 == null) goto L8;
        int r3 = r2.intValue();
    L9:
        r1.checkAndApply(-1, r3, "paid_link", r12, r13, r14, r15, r16, r17);
        return;
    L8:
        r3 = LinkApplyType.NORMAL.getValue();
        goto L9
    }
}
