package com.bytedance.android.live.liveinteract.videotalk.emoji;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.broadcastgame.api.interactgame.IGameDataService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.digitavatar.DigitAvatarAuditStatus;
import com.bytedance.android.live.liveinteract.digitavatar.DigitAvatarContext;
import com.bytedance.android.live.liveinteract.linkcast.LinkCastAnchorDataContext;
import com.bytedance.android.live.liveinteract.model.LinkScreenCastType;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import com.bytedance.android.live.liveinteract.plantform.permission.model.OperateType;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.revenue.adventure.AdventureContext;
import com.bytedance.android.live.liveinteract.revenue.fight.TeamFightContext;
import com.bytedance.android.live.liveinteract.revenue.game.LinkMicGameContext;
import com.bytedance.android.live.liveinteract.utils.c1;
import com.bytedance.android.live.liveinteract.videotalk.cposition.CPositionContext;
import com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.SelfDisciplineContext;
import com.bytedance.android.live.liveinteract.videotalk.themecompetition.ThemedCompetitionContext;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.ChatRoomPanelItemAdapter;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.CleanScreenEntranceItem;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.w0;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.x0;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.y0;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.z0;
import com.bytedance.android.live.plugin_api.LivePluginSPIManager;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.model.interact.ThemedCompetitionRole;
import com.bytedance.android.livesdk.chatroom.model.interact.s0;
import com.bytedance.android.livesdk.config.sj1;
import com.bytedance.android.livesdk.config.w71;
import com.bytedance.android.livesdk.utils.p6;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.kmp.live.livelink.api.model.VideoShowMode;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import sh0.i0;
import sh0.j0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/emoji/VideoTalkDynamicEmojiDialog;", "Lcom/bytedance/android/live/liveinteract/videotalk/emoji/BaseDynamicEmojiDialog;", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class VideoTalkDynamicEmojiDialog extends BaseDynamicEmojiDialog {
    public static final /* synthetic */ int N = 0;
    public com.bytedance.android.live.liveinteract.voicechat.emoji.panel.l F;
    public y0 G;
    public com.bytedance.android.live.liveinteract.voicechat.emoji.panel.c H;
    public com.bytedance.android.live.liveinteract.voicechat.emoji.panel.k I;
    public TextView J;
    public String K;
    public final b L;
    public final boolean M;

    public static final class a {
    }

    public static final class b implements rj0.h.a {
        public final /* synthetic */ VideoTalkDynamicEmojiDialog a;

        @Override // rj0.h.a
        public final void v3(Map<String, Long> r2) {
            Intrinsics.checkNotNullParameter(r2, "guestTimeRemaining");
        }

        public b(VideoTalkDynamicEmojiDialog r1) {
            this.a = r1;
        }

        @Override // rj0.h.a
        public final void B0(long r4) {
            long r0 = 0;
            if (r4 < 0) goto L6;
            r0 = r4 / ((long) 1000);
        L6:
            TextView r5 = this.a.J;
            if (r5 == null) goto L10;
            r5.setText(p6.d(r0));
            return;
        }
    }

    public static final class c implements com.bytedance.android.live.liveinteract.plantform.camera.a {
        public final /* synthetic */ VideoTalkDynamicEmojiDialog a;

        @Override // com.bytedance.android.live.liveinteract.plantform.camera.a
        public final void onSuccess() {
            this.a.X0();
            VideoTalkDynamicEmojiDialog r0 = this.a;
            r0.getClass();
            BaseDynamicEmojiDialog.M0(r0);
        }

        public c(VideoTalkDynamicEmojiDialog r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.camera.a
        public final void onError(Exception r2) {
            Intrinsics.checkNotNullParameter(r2, "error");
            this.a.X0();
        }
    }

    public static final class d implements qh0.d<rh0.a> {
        public final /* synthetic */ VideoShowMode a;
        public final /* synthetic */ VideoTalkDynamicEmojiDialog b;
        public final /* synthetic */ VideoShowMode c;

        @Override // qh0.d
        public final void b(BaseCheckException r2) {
            Intrinsics.checkNotNullParameter(r2, "exception");
        }

        @Override // qh0.d
        public final void onResult(rh0.a r6) {
            if (hd0.c.f().h() == true) goto L8;
            rj0.l.n2.getClass();
            rj0.l r7 = rj0.l.a.a();
            if (r7 != null) goto L7;
            return;
        L7:
            if (r7.isEngineOn() == true) goto L8;
            return;
        L8:
            VideoTalkDynamicEmojiDialog r8 = this.b;
            VideoShowMode r0 = this.c;
            VideoShowMode r1 = this.a;
            int r2 = VideoTalkDynamicEmojiDialog.N;
            r8.getClass();
            rj0.l.n2.getClass();
            rj0.l r9 = rj0.l.a.a();
            if (r9 == null) goto L11;
            m00.g r10 = r9.hh();
        L12:
            rj0.l r3 = rj0.l.a.a();
            if (r3 == null) goto L18;
            r3.So(r0.getType(), new c0(r0, r1, r10), "link_interaction_panel_video", false);
            return;
        L18:
            return;
        L11:
            r10 = null;
            goto L12
        }

        public d(VideoShowMode r1, VideoTalkDynamicEmojiDialog r2, VideoShowMode r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.BaseDynamicEmojiDialog
    public final void O0() {
        ILinkPlayerInfoBridge r0 = null;
        Object r1 = null;
        r0 = null;
        r0 = null;
        if (li0.d.g(null) == false) goto L22;
        IMiddlewareUserService r2 = jc1.k.f(IMiddlewareUserService.class);
        if (r2 == null) goto L11;
        com.bytedance.android.livesdk.user.e r3 = r2.user();
        if (r3 == null) goto L11;
        String r4 = r3.n();
        if (r4 == null) goto L11;
    L12:
        int r5 = li0.d.c(r4);
        if (je0.d.r() == true) goto L17;
        if (com.bytedance.android.live.ktv.common.util.a.g() == false) goto L22;
    L17:
        if (TeamFightContext.Companion.h() == false) goto L22;
        if (r5 == (-1)) goto L22;
        ((ArrayList) this.w).add(new z0(this, r4));
    L11:
        r4 = "";
    L22:
        if (ThemedCompetitionContext.Companion.g() == true) goto L24;
    L49:
        i0 r6 = j0.a(this.D);
        if (r6 != null) goto L52;
        return;
    L52:
        if (r6.g() != true) goto L65;
        IGameDataService r7 = com.bytedance.android.live.liveinteract.api.utils.m.a();
        if (r7 == null) goto L66;
        com.bytedance.live.datacontext.m r8 = r7.getXplayRunning();
        if (r8 != null) goto L58;
        return;
    L58:
        if (((Boolean) r8.getValue()).booleanValue() != true) goto L68;
        ((ArrayList) this.w).add(new CleanScreenEntranceItem(this.D, this));
        return;
    L68:
        return;
    L66:
        return;
    L65:
        return;
    L24:
        if (ThemedCompetitionContext.a.e() == false) goto L49;
        IInteractService r9 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r9 == null) goto L42;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r10 = r9.getLinkUserInfoCenter();
        if (r10 == null) goto L42;
        Iterable r11 = r10.getOnlineUserList();
        if (r11 == null) goto L42;
        Iterator r12 = r11.iterator();
    L33:
        if (r12.hasNext() == false) goto L41;
        Object r13 = r12.next();
        IBaseUser r14 = ((ILinkPlayerInfoBridge) r13).getUser();
        if (r14 == null) goto L37;
        String r15 = r14.getIdString();
    L39:
        if (Intrinsics.areEqual(r15, je0.d.b0()) == false) goto L33;
        r1 = r13;
        goto L41
    L37:
        r15 = null;
    L41:
        r0 = (ILinkPlayerInfoBridge) r1;
    L42:
        if (r0 != null) goto L44;
    L45:
        if (r0 == null) goto L49;
        if (r0.getThemedCompetitionRole() != ThemedCompetitionRole.PERFORMER.getValue()) goto L49;
    L48:
        ((ArrayList) this.w).add(new w0(this, r0.getThemedCompetitionRole()));
        com.bytedance.android.live.liveinteract.videotalk.themecompetition.a r16 = com.bytedance.android.live.liveinteract.videotalk.themecompetition.b.a;
        com.bytedance.android.live.liveinteract.videotalk.themecompetition.b.b(false, r0.getThemedCompetitionRole());
        goto L49
    L44:
        if (r0.getThemedCompetitionRole() == ThemedCompetitionRole.CONTESTANT.getValue()) goto L48;
        goto L45
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.BaseDynamicEmojiDialog
    public final void R0() {
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.BaseDynamicEmojiDialog
    public final boolean T0() {
        return true;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.BaseDynamicEmojiDialog
    public final void W0() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.BaseDynamicEmojiDialog, com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void O() {
        IBaseUser r4 = jc1.k.n(IMiddlewareUserService.class).user().b();
        IRoom r5 = this.v;
        if (r5 == null) goto L7;
        if (r4 == null) goto L8;
        hi0.a.c(hi0.a.a, getContext(), this.D, r4, r5, false, 48);
        j1(this);
        return;
    L8:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.BaseDynamicEmojiDialog, com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void P() {
        int r0 = com.bytedance.android.live.liveinteract.digitavatar.x.a;
        com.bytedance.android.live.liveinteract.digitavatar.x.b(this.n, "emoji_panel");
        FragmentActivity r1 = ContextUtil.contextToFragmentActivity(getContext());
        if (r1 == null) goto L6;
        int r2 = com.bytedance.android.live.liveinteract.digitavatar.m.a;
        com.bytedance.android.live.liveinteract.digitavatar.m.a(getContext(), r1.getSupportFragmentManager(), this.D, true, null);
        j1(this);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.BaseDynamicEmojiDialog
    public final void P0() {
        this.J = (TextView) findViewById(2131391059);
        int r1 = cj0.e.h;
        rj0.h r2 = cj0.e.a.a();
        boolean r4 = false;
        if (this.n == false) goto L5;
    L19:
        IInteractService r3 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r3 == null) goto L30;
        IMiddlewareUserService r8 = jc1.k.f(IMiddlewareUserService.class);
        if (r8 == null) goto L26;
        com.bytedance.android.livesdk.user.e r9 = r8.user();
        if (r9 == null) goto L26;
        String r10 = r9.n();
    L28:
        if (r3.isAnonymousUser(r10) != true) goto L30;
        ALogger.i("DynamicEmojiDialog Refactor VideoTalk", "anonymous guest click own seat switch the connection method (voice, video, avatar) to be hidden");
    L197:
        boolean r5 = gd0.v.a(((Integer) this.D.get("data_link_state", 0)).intValue(), 32);
        com.bytedance.live.datacontext.j r6 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
        if (r6 == null) goto L204;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r7 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r6.getValue();
        if (r7 == null) goto L204;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r11 = r7.t();
        if (r11 == null) goto L204;
        Integer r12 = Integer.valueOf(r11.a);
    L205:
        com.bytedance.live.datacontext.j r13 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
        if (r13 == null) goto L212;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r14 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r13.getValue();
        if (r14 == null) goto L212;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r15 = r14.t();
        if (r15 == null) goto L212;
        int r16 = r15.c;
    L213:
        com.bytedance.live.datacontext.m r17 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r17 == null) goto L218;
        IRoom r18 = (IRoom) r17.getValue();
        if (r18 == null) goto L218;
        String r19 = r18.getOwnerUserIdString();
    L219:
        if (r5 == true) goto L223;
        if (aj0.a.d() == true) goto L223;
    L262:
        kj0.b r20 = SelfDisciplineContext.Companion.d();
        if (r20 != null) goto L265;
        return;
    L265:
        if (r20.canShowContributionPanelItem() == false) goto L271;
        ((ArrayList) this.w).add(new com.bytedance.android.live.liveinteract.voicechat.emoji.panel.j(this));
        return;
    L271:
        return;
    L223:
        if (hd0.c.f().h() == false) goto L262;
        if (TeamFightContext.Companion.h() == false) goto L229;
        if (li0.d.g(null) == false) goto L262;
    L229:
        if (je0.d.J(this.n, jc1.k.n(IMiddlewareUserService.class).user().E(Long.valueOf(this.p))) == false) goto L262;
        if (r12 != null) goto L233;
    L239:
        AdventureContext.Companion.getClass();
        if (AdventureContext.a.a() == true) goto L262;
        if (LinkMicGameContext.Companion.e() == true) goto L262;
        if (aj0.a.d() == false) goto L251;
        if (aj0.a.b(this.v) == false) goto L262;
    L251:
        if (((IInteractService) jc1.k.n(IInteractService.class)).isPCLandscape(0, r16) == true) goto L262;
        if (this.n == false) goto L258;
        rj0.k.m2.getClass();
        rj0.k r21 = rj0.k.a.a();
        if (r21 == null) goto L261;
        r4 = r21.userIsCPosition(je0.d.b0());
    L261:
        ((ArrayList) this.w).add(new com.bytedance.android.live.liveinteract.voicechat.emoji.panel.d(this, !r4, this.D));
        goto L262
    L258:
        rj0.l.n2.getClass();
        rj0.l r22 = rj0.l.a.a();
        if (r22 == null) goto L261;
        r4 = r22.userIsCPosition(je0.d.b0());
        goto L261
    L233:
        if (r12.intValue() != 8) goto L239;
        if (CPositionContext.Companion.c() == true) goto L239;
        if (Intrinsics.areEqual(je0.d.b0(), r19) == false) goto L239;
    L218:
        r19 = null;
    L212:
        r16 = 0;
    L204:
        r12 = null;
    L26:
        r10 = null;
    L30:
        int r23 = c1.a;
        if (c1.a(0, je0.d.h()) == false) goto L34;
        ALogger.i("DynamicEmojiDialog Refactor VideoTalk", "pc landscape guest click own seat switch the connection method (voice, video, avatar) to be hidden");
        goto L197
    L34:
        if (this.n == false) goto L102;
        LinkCastAnchorDataContext.a r24 = LinkCastAnchorDataContext.Companion;
        LinkCastAnchorDataContext r25 = r24.getContext();
        if (r25 == null) goto L40;
        com.bytedance.live.datacontext.n<s0> r26 = r25.getMLinkCastInfo();
        if (r26 == null) goto L40;
        s0 r27 = (s0) r26.getValue();
    L41:
        if (r27 == null) goto L102;
        ALogger.i("DynamicEmojiDialog Refactor VideoTalk", "in link cast anchor click own seat switch the connection method (voice, video, avatar) to be hidden");
        LinkCastAnchorDataContext r28 = r24.getContext();
        if (r28 == null) goto L47;
        com.bytedance.live.datacontext.n<s0> r29 = r28.getMLinkCastInfo();
        if (r29 == null) goto L47;
        s0 r30 = (s0) r29.getValue();
    L48:
        if (r30 == null) goto L197;
        LinkCastAnchorDataContext r31 = r24.getContext();
        if (r31 == null) goto L55;
        com.bytedance.live.datacontext.n<LinkScreenCastType> r32 = r31.getMCurrentScreenType();
        if (r32 == null) goto L55;
        LinkScreenCastType r33 = (LinkScreenCastType) r32.getValue();
        if (r33 == null) goto L55;
    L56:
        int r34 = com.bytedance.android.live.liveinteract.linkcast.i.a;
        String r35 = r30.getAppId();
        String r110 = "";
        if (r35 != null) goto L59;
        r35 = "";
    L59:
        com.bytedance.android.live.liveinteract.linkcast.c r36 = com.bytedance.android.live.liveinteract.linkcast.i.a.a(r33, r35);
        com.bytedance.android.live.liveinteract.linkcast.g.a r111 = com.bytedance.android.live.liveinteract.linkcast.g.b;
        if (r36 == null) goto L63;
        String r112 = r36.a;
        if (r112 == null) goto L63;
    L64:
        if (r36 == null) goto L67;
        String r113 = r36.c;
        if (r113 == null) goto L67;
    L68:
        int r114 = r33.getTypeValue();
        r111.getClass();
        HashMap r115 = new HashMap();
        com.bytedance.live.datacontext.m r116 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r116 == null) goto L75;
        IRoom r117 = (IRoom) r116.getValue();
        if (r117 == null) goto L75;
        if (r117.isLiveTypeAudio() != true) goto L75;
        String r118 = "voice_live";
    L76:
        r115.put("live_type", r118);
        TalkRoomLogUtils.B0(r115, null, null, 6);
        r115.put("content_id", r112);
        r115.put("content_name", r113);
        r115.put("source", com.bytedance.android.live.liveinteract.linkcast.g.a.b(r114));
        r115.put("user_type", "anchor");
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_seat_interact_panel_game_show", r115, new Object[]{IRoom.class, am2.x.class});
        int r37 = r33.getTypeValue();
        LinkScreenCastType r38 = LinkScreenCastType.CAST_TYPE_MINI_APP;
        if (r37 != r38.getTypeValue()) goto L90;
        if (r36 == null) goto L81;
        String r39 = r36.a;
        if (r39 == null) goto L81;
    L82:
        r33.getTypeValue();
        HashMap r40 = new HashMap();
        r40.put("_param_for_special", "micro_app");
        r40.put("mp_id", r39);
        r40.put("entrance_from", "solid_entrance");
        r40.put("enter_position", "connection_panel");
        r40.put("enter_from_merge", "connection_panel");
        r40.put("launch_from", "live");
        r40.put("scene", "023009");
        r40.put("location", "connection_panel");
        int r41 = je0.d.f();
        if (r41 != 8) goto L85;
        r110 = "1v6";
    L89:
        r40.put("live_category", r110);
        r40.put("projection_user_type", "anchor");
        com.bytedance.android.livesdk.log.j0.l().sendLog("mp_show", r40, new Object[]{IRoom.class});
        goto L90
    L85:
        if (r41 != 12) goto L89;
        r110 = "party";
    L81:
        r39 = "";
    L90:
        int r42 = r30.getItemType();
        LinkScreenCastType r43 = LinkScreenCastType.CAST_TYPE_GAME;
        if (r42 != r43.getTypeValue()) goto L94;
        r38 = r43;
    L98:
        if (((ArrayList) this.w).size() <= 0) goto L100;
        ListProtector.add(this.w, 0, new com.bytedance.android.live.liveinteract.voicechat.emoji.panel.e(r38, r36, this));
        goto L197
    L100:
        ((ArrayList) this.w).add(new com.bytedance.android.live.liveinteract.voicechat.emoji.panel.e(r38, r36, this));
        goto L197
    L94:
        if (r42 == r38.getTypeValue()) goto L98;
        r38 = LinkScreenCastType.CAST_TYPE_UNKNOWN;
    L75:
        r118 = "video_live";
    L67:
        r113 = "";
    L63:
        r112 = "";
    L55:
        r33 = LinkScreenCastType.CAST_TYPE_UNKNOWN;
    L47:
        r30 = null;
    L40:
        r27 = null;
    L102:
        if (aj0.a.e() == true) goto L110;
        if (aj0.a.d() == false) goto L113;
        IRoom r44 = this.v;
        if (r44 == null) goto L113;
        if (r44.isLiveTypeAudio() == true) goto L110;
    L113:
        if (hd0.c.f().h() == false) goto L197;
        List<VideoShowMode> r45 = com.bytedance.android.live.liveinteract.digitavatar.c0.a(this.n, this.v, true);
        int r46 = com.bytedance.android.live.liveinteract.plantform.utils.x.a;
        ArrayList r47 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r45, 10));
        ArrayList r48 = (ArrayList) r45;
        Iterator r119 = r48.iterator();
    L116:
        if (r119.hasNext() == false) goto L118;
        r47.add(((VideoShowMode) r119.next()).name());
        goto L116
    L118:
        Intrinsics.checkNotNullParameter(r47, "modes");
        LinkedHashMap r120 = new LinkedHashMap();
        r120.put("modes", r47.toString());
        com.bytedance.android.live.liveinteract.plantform.utils.x.t0("digit_avatar_supported_video_show_mode", r120);
        TalkRoomBusinessFullLinkMonitor r49 = TalkRoomBusinessFullLinkMonitor.a;
        ArrayList r121 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r45, 10));
        Iterator r50 = r48.iterator();
    L120:
        if (r50.hasNext() == false) goto L122;
        r121.add(((VideoShowMode) r50.next()).name());
        goto L120
    L122:
        r49.getClass();
        TalkRoomBusinessFullLinkMonitor.m(r121);
        if (r48.size() <= 1) goto L197;
        DigitAvatarContext.a r51 = DigitAvatarContext.Companion;
        DigitAvatarContext r52 = r51.getContext();
        if (r52 == null) goto L128;
        VideoShowMode r53 = r52.getCurrentVideoShowMode();
        if (r53 == null) goto L128;
    L129:
        DigitAvatarAuditStatus r54 = DigitAvatarAuditStatus.PASS;
        DigitAvatarContext r55 = r51.getContext();
        if (r55 == null) goto L147;
        com.bytedance.live.datacontext.m<com.bytedance.android.live.liveinteract.digitavatar.n> r56 = r55.getDigitAvatar();
        if (r56 == null) goto L147;
        com.bytedance.android.live.liveinteract.digitavatar.n r57 = (com.bytedance.android.live.liveinteract.digitavatar.n) r56.getValue();
        if (r57 == null) goto L147;
        boolean r122 = r57.a;
        if (r122 == false) goto L138;
    L141:
        if (r122 == true) goto L147;
        if (r57.e == false) goto L147;
        if (r57.c == true) goto L147;
        DigitAvatarAuditStatus r58 = DigitAvatarAuditStatus.NOT_PASS;
    L140:
        r54 = r58;
        goto L147
    L138:
        if (r57.e == true) goto L141;
        r58 = DigitAvatarAuditStatus.AUDITING;
    L147:
        Object[] r59 = r48.toArray(new VideoShowMode[0]);
        if (r59 == null) goto L196;
        com.bytedance.android.live.liveinteract.voicechat.emoji.panel.l r60 = new com.bytedance.android.live.liveinteract.voicechat.emoji.panel.l(this, new com.bytedance.android.live.liveinteract.voicechat.emoji.panel.m((VideoShowMode[]) r59, r53, r54));
        this.F = r60;
        ListProtector.add(this.w, 0, r60);
        com.bytedance.android.live.liveinteract.voicechat.emoji.panel.m r61 = r60.f;
        if (r61 == null) goto L194;
        Intrinsics.checkNotNullParameter(r53, "<set-?>");
        r61.b = r53;
        y0 r62 = this.G;
        if (r62 == null) goto L154;
        ((ArrayList) this.w).remove(r62);
    L154:
        com.bytedance.android.live.liveinteract.voicechat.emoji.panel.c r63 = this.H;
        if (r63 == null) goto L157;
        ((ArrayList) this.w).remove(r63);
    L157:
        com.bytedance.android.live.liveinteract.voicechat.emoji.panel.k r65 = this.I;
        if (r65 == null) goto L160;
        ((ArrayList) this.w).remove(r65);
    L160:
        int r66 = z.a[r53.ordinal()];
        if (r66 == 1) goto L172;
        if (r66 == 2) goto L165;
    L190:
        ChatRoomPanelItemAdapter r67 = this.f;
        if (r67 == null) goto L197;
        r67.notifyDataSetChanged();
        goto L197
    L165:
        if (this.I != null) goto L167;
        this.I = new com.bytedance.android.live.liveinteract.voicechat.emoji.panel.k(this);
    L167:
        com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g r68 = this.x;
        com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g r69 = r60;
        if (r68 == null) goto L170;
        r69 = r68;
    L170:
        int r70 = CollectionsKt.indexOf(this.w, r69);
        com.bytedance.android.live.liveinteract.voicechat.emoji.panel.k r71 = this.I;
        Intrinsics.checkNotNull(r71);
        ListProtector.add(this.w, r70 + 1, r71);
        goto L190
    L172:
        if (this.n == true) goto L190;
        if (this.G != null) goto L177;
        this.G = new y0(this);
    L177:
        if (this.H != null) goto L179;
        this.H = new com.bytedance.android.live.liveinteract.voicechat.emoji.panel.c(this);
    L179:
        com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g r72 = this.x;
        com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g r73 = r72;
        if (r72 != null) goto L183;
        r73 = r60;
    L183:
        int r74 = CollectionsKt.indexOf(this.w, r73);
        if (w71.a() == false) goto L186;
        com.bytedance.android.live.liveinteract.voicechat.emoji.panel.c r75 = this.H;
        Intrinsics.checkNotNull(r75);
        ListProtector.add(this.w, r74 + 1, r75);
    L186:
        com.bytedance.android.live.liveinteract.voicechat.emoji.panel.l r76 = this.F;
        com.bytedance.android.live.liveinteract.voicechat.emoji.panel.l r77 = r60;
        if (r76 == null) goto L189;
        r77 = r76;
    L189:
        int r78 = CollectionsKt.indexOf(this.w, r77);
        y0 r79 = this.G;
        Intrinsics.checkNotNull(r79);
        ListProtector.add(this.w, r78 + 1, r79);
        goto L190
    L194:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.voicechat.emoji.panel.DigitShowModeData");
    L196:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L128:
        r53 = VideoShowMode.AUDIO;
    L110:
        if (a1() == true) goto L113;
        ALogger.i("DynamicEmojiDialog Refactor VideoTalk", "room fight hidden guest click seat switch the connection method (voice, video, avatar) to be hidden");
        goto L197
    L5:
        if (je0.d.N() == false) goto L19;
        if (r2 == null) goto L19;
        if (r2.b() != true) goto L19;
        long r80 = r2.a() / ((long) 1000);
        TextView r81 = this.J;
        if (r81 != null) goto L12;
    L15:
        TextView r82 = this.J;
        if (r82 == null) goto L18;
        r82.setVisibility(0);
    L18:
        r2.e(this.L);
        goto L19
    L12:
        if (r80 >= 0) goto L14;
        r80 = 0;
    L14:
        r81.setText(p6.d(r80));
        goto L15
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.BaseDynamicEmojiDialog
    public final void Q0() {
        if (this.n == false) goto L8;
        if (vm2.d.A() == true) goto L8;
        return;
    L8:
        if (this.o == false) goto L10;
        com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g r0 = new com.bytedance.android.live.liveinteract.voicechat.emoji.panel.c1(this);
    L11:
        this.x = r0;
        ((ArrayList) this.w).add(r0);
        return;
    L10:
        r0 = new x0(this);
        goto L11
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.BaseDynamicEmojiDialog
    public final boolean S0() {
        if (this.n == true) goto L15;
        com.bytedance.android.live.liveinteract.voicechat.util.d.a.getClass();
        if (com.bytedance.android.live.liveinteract.voicechat.util.d.a.a() == 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L10;
        return false;
    L10:
        if (com.bytedance.android.live.liveinteract.voicechat.util.d.a.a() == 1) goto L12;
    L13:
        return true;
    L12:
        if (je0.d.f() != 10) goto L13;
        return false;
    L7:
        r0 = false;
        goto L8
    L15:
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.BaseDynamicEmojiDialog
    public final int U0() {
        int r1 = 1;
        if (this.M == true) goto L11;
        DigitAvatarContext r0 = DigitAvatarContext.Companion.getContext();
        if (r0 == null) goto L11;
        com.bytedance.live.datacontext.m<Boolean> r2 = r0.getCurrentUsingDigitAvatarInVideoTalkRoom();
        if (r2 == null) goto L11;
        if (((Boolean) r2.getValue()).booleanValue() != true) goto L11;
        r1 = 3;
    L11:
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.r0.getClass();
        if (com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.C0101b.b() == true) goto L14;
        return r1;
    L14:
        return r1 | 4;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.BaseDynamicEmojiDialog
    public final void Z0() {
        d0 r0 = new d0(this.n, this.D);
        this.h = r0;
        ((q46.b) r0).a = this;
        if ((r0 instanceof d0) == true) goto L6;
        r0 = null;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.BaseDynamicEmojiDialog
    public final void b1() {
        int r0 = y.a;
        y.d(this.u);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.BaseDynamicEmojiDialog
    public final void c1() {
        int r0 = y.a;
        y.e(this.D, getContext(), this.u);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.BaseDynamicEmojiDialog
    public final void dismiss() {
        int r0 = cj0.e.h;
        rj0.h r1 = cj0.e.a.a();
        if (r1 == null) goto L5;
        r1.f(this.L);
    L5:
        Handler r2 = DialogLancet.resolveDialogHandler(this);
        if (r2 != null) goto L8;
    L10:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L13 Exception -> L15
    L19:
        DialogLancet.afterDialogDismiss(this);
        return;
    L15:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L13
        Throwable r3 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L13
        if (r3 == null) goto L19;
        com.bytedance.crash.d.d(r3, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L8:
        if (Looper.myLooper() == r2.getLooper()) goto L10;
        r2.post(DialogLancet.createDismissRunnable(this));
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.BaseDynamicEmojiDialog, com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void y0() {
        Intrinsics.checkNotNullParameter("link_interaction_panel_beauty", "eventPage");
        if (this.n == false) goto L7;
        rj0.k.m2.getClass();
        rj0.k r0 = rj0.k.a.a();
        if (r0 == null) goto L35;
        r0.w5();
        return;
    L35:
        return;
    L7:
        LifecycleOwner r1 = this.D.lifecycleOwner;
        boolean r2 = r1 instanceof Fragment;
        Context r3 = null;
        if (r2 == false) goto L20;
        if (r2 == true) goto L11;
        r1 = null;
    L11:
        Fragment r4 = (Fragment) r1;
        if (r4 == null) goto L14;
        Context r5 = r4.getContext();
    L16:
        if ((r5 instanceof FragmentActivity) == false) goto L19;
        r3 = r5;
    L19:
        r3 = (FragmentActivity) r3;
    L25:
        if (r3 != null) goto L28;
        ALogger.e("", "fragmentActivity is null context:" + this.D.lifecycleOwner.getClass());
        return;
    L28:
        BaseDynamicEmojiDialog.M0(this);
        DigitAvatarContext r6 = DigitAvatarContext.Companion.getContext();
        if (r6 == null) goto L32;
        VideoShowMode r7 = r6.getCurrentVideoShowMode();
        if (r7 == null) goto L32;
    L33:
        b0 r8 = new b0(r7);
        LivePluginSPIManager.e.getClass();
        LivePluginSPIManager.a().addOnSuccess(new a0(this, r8)).callbackOnMainThread().syncCallbackIfReady(true).justPrepare();
        return;
    L32:
        r7 = VideoShowMode.AUDIO;
        goto L33
    L14:
        r5 = null;
        goto L16
    L20:
        boolean r9 = r1 instanceof FragmentActivity;
        if (r9 == false) goto L25;
        if (r9 == true) goto L24;
        r1 = null;
    L24:
        r3 = (FragmentActivity) r1;
        goto L25
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.BaseDynamicEmojiDialog
    public final void Y0() {
        UtilityKotlinExtentionsKt.t(findViewById(2131382836));
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.BaseDynamicEmojiDialog
    public final boolean a1() {
        if (je0.d.r() == false) goto L7;
        rj0.k.m2.getClass();
        rj0.k r0 = rj0.k.a.a();
        if (r0 != null) goto L12;
    L10:
        return false;
    L12:
        return r0.userIsCPosition(je0.d.b0());
    L7:
        rj0.l.n2.getClass();
        rj0.l r1 = rj0.l.a.a();
        if (r1 == null) goto L10;
        return r1.userIsCPosition(je0.d.b0());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void j1(VideoTalkDynamicEmojiDialog r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.BaseDynamicEmojiDialog, com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void b(boolean r9) {
        if (((Boolean) vm2.d.z3.getValue(null, vm2.d.a[231(0xe7, float:3.24E-43)])).booleanValue() == false) goto L13;
        com.bytedance.android.live.liveinteract.plantform.camera.b.o0.getClass();
        com.bytedance.android.live.liveinteract.plantform.camera.b r0 = com.bytedance.android.live.liveinteract.plantform.camera.b.a.a();
        if (r0 == null) goto L13;
        if (r0.a() == true) goto L13;
        if (r0.e() == false) goto L11;
        f2.b(2131917582, 0);
        return;
    L11:
        f2.b(2131917478, 0);
        return;
    L13:
        g1(2131911660);
        com.bytedance.android.live.liveinteract.plantform.camera.b.o0.getClass();
        com.bytedance.android.live.liveinteract.plantform.camera.b r1 = com.bytedance.android.live.liveinteract.plantform.camera.b.a.a();
        if (r1 == null) goto L18;
        r1.f(r9, false, false, false, new c(this), "videotalk dynamic emoji");
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.BaseDynamicEmojiDialog, com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void l(boolean r5) {
        if (hd0.c.f().h() == true) goto L5;
        return;
    L5:
        IRoom r0 = this.v;
        if (r0 == null) goto L12;
        long r1 = r0.getId();
        pj0.b r2 = ThemedCompetitionContext.Companion.c();
        if (r2 == null) goto L10;
        r2.Z6(r1, je0.d.b0(), r5);
    L10:
        j1(this);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.BaseDynamicEmojiDialog
    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        int r4 = c1.a;
        c1.b(getWindow(), 0, 14);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.BaseDynamicEmojiDialog, com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void L(com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g r9, VideoShowMode r10) {
        Intrinsics.checkNotNullParameter(r9, "panelItem");
        Intrinsics.checkNotNullParameter(r10, "selectMode");
        int r11 = com.bytedance.android.live.liveinteract.digitavatar.x.a;
        boolean r12 = this.n;
        String r0 = this.u;
        String r1 = this.K;
        Intrinsics.checkNotNullParameter(r10, "showMode");
        Intrinsics.checkNotNullParameter(r0, "requestPage");
        LinkedHashMap r2 = new LinkedHashMap();
        com.bytedance.android.live.liveinteract.digitavatar.x.c(r2, r12);
        r2.put("guest_connection_type", "live_chat");
        int r13 = com.bytedance.android.live.liveinteract.digitavatar.w.a[r10.ordinal()];
        if (r13 == 1) goto L11;
        if (r13 != 2) goto L6;
        String r14 = "on";
    L12:
        r2.put("button_type", r14);
        r2.put("request_page", r0);
        if (r1 == null) goto L15;
        r2.put("connect_type", r1);
    L15:
        TalkRoomLogUtils.g1(r2, je0.d.b0());
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_audience_connection_user_camera_open_click", r2, new Object[]{am2.x.class, IRoom.class});
        if (r10 == VideoShowMode.DIGIT_AVATAR) goto L18;
    L26:
        DigitAvatarContext.a r15 = DigitAvatarContext.Companion;
        DigitAvatarContext r3 = r15.getContext();
        if (r3 == null) goto L58;
        VideoShowMode r4 = r3.getCurrentVideoShowMode();
        if (r4 == null) goto L58;
        if (r4 == r10) goto L58;
        if (((Boolean) vm2.d.z3.getValue(null, vm2.d.a[231(0xe7, float:3.24E-43)])).booleanValue() == true) goto L34;
    L48:
        int r5 = je0.d.f();
        if (r10 != VideoShowMode.VIDEO) goto L55;
        rj0.l.n2.getClass();
        if (rj0.l.a.a() == null) goto L55;
        if (sj1.a(r5, je0.f.a()) == false) goto L55;
        ArrayList r16 = new ArrayList();
        r16.add(new qh0.f.c(getContext(), OperateType.APPLY, 1));
        qh0.f.a(r16).a(new d(r4, this, r10));
    L55:
        r10.setSource(1);
        DigitAvatarContext r17 = r15.getContext();
        if (r17 == null) goto L58;
        DigitAvatarContext.setVideoShowMode$default(r17, r10, null, 2, null);
        goto L58
    L34:
        if (r10 != VideoShowMode.VIDEO) goto L48;
        if (this.n == true) goto L48;
        com.bytedance.android.live.liveinteract.plantform.camera.b.o0.getClass();
        com.bytedance.android.live.liveinteract.plantform.camera.b r6 = com.bytedance.android.live.liveinteract.plantform.camera.b.a.a();
        if (r6 == null) goto L48;
        if (r6.a() == true) goto L48;
        com.bytedance.android.live.liveinteract.plantform.camera.b r18 = com.bytedance.android.live.liveinteract.plantform.camera.b.a.a();
        if (r18 != null) goto L44;
    L46:
        f2.b(2131917478, 0);
        return;
    L44:
        if (r18.e() != true) goto L46;
        f2.b(2131917582, 0);
        return;
    L58:
        j1(this);
        return;
    L18:
        if (((Boolean) b6.s.getValue()).booleanValue() == false) goto L26;
        FragmentActivity r19 = ContextUtil.contextToFragmentActivity(getContext());
        if (r19 != null) goto L22;
        return;
    L22:
        DataCenter r110 = this.D;
        if (r110 != null) goto L25;
        return;
    L25:
        int r7 = com.bytedance.android.live.liveinteract.digitavatar.m.a;
        com.bytedance.android.live.liveinteract.digitavatar.m.a(r19, r19.getSupportFragmentManager(), r110, false, null);
        goto L58
    L6:
        if (r13 != 3) goto L9;
        r14 = "off";
        goto L12
    L9:
        throw new NoWhenBranchMatchedException();
    L11:
        r14 = "avatar";
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.BaseDynamicEmojiDialog, com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void z0(boolean r8, DataCenter r9) {
        if (hd0.c.f().h() == true) goto L5;
        return;
    L5:
        IRoom r0 = this.v;
        if (r0 == null) goto L9;
        long r3 = r0.getId();
        oe0.d.c(r8, je0.d.b0(), r3, getContext(), r9);
        j1(this);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.BaseDynamicEmojiDialog, com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void H0(LinkScreenCastType r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "castType");
        Intrinsics.checkNotNullParameter(r4, "appId");
        Intrinsics.checkNotNullParameter(r5, "appName");
        super.H0(r3, r4, r5);
        com.bytedance.android.live.liveinteract.linkcast.g.a r0 = com.bytedance.android.live.liveinteract.linkcast.g.b;
        int r1 = r3.getTypeValue();
        r0.getClass();
        com.bytedance.android.live.liveinteract.linkcast.g.a.e(r4, r5, r1, true);
        if (r3.getTypeValue() != LinkScreenCastType.CAST_TYPE_MINI_APP.getTypeValue()) goto L5;
        com.bytedance.android.live.liveinteract.linkcast.g.a.d(r4, true);
    L5:
        j1(this);
    }

    public VideoTalkDynamicEmojiDialog(Context r1, DataCenter r2, boolean r3, boolean r4) {
        super(r1, r2, r3);
        this.M = r4;
        this.L = new b(this);
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.BaseDynamicEmojiDialog, com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void e5(int r7, int r8, long r9, String r11) {
        com.bytedance.android.live.liveinteract.revenue.fight.c r0 = TeamFightContext.Companion.c();
        if (r0 == null) goto L5;
        r0.e5(r7, r8, 0, r11);
    L5:
        j1(this);
    }
}
