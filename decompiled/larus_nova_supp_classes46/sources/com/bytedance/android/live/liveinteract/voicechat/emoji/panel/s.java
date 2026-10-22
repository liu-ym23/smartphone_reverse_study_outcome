package com.bytedance.android.live.liveinteract.voicechat.emoji.panel;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService;
import com.bytedance.android.live.broadcastgame.api.interactgame.IAudienceGameDataService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.link.IMultiLinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.plantform.model.ContributeShowResponse;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.room.IMiddlewareMicRoomService;
import com.bytedance.android.livesdk.chatroom.model.ILinkmicInteractEntrance;
import com.bytedance.android.livesdk.chatroom.model.j1;
import com.bytedance.android.livesdk.log.model.FollowLog;
import com.bytedance.android.livesdk.message.model.nd;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdkapi.depend.model.live.IOfficialChannelInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class s extends q46.b<a> {
    public boolean b;
    public boolean c;
    public long d;
    public final CompositeDisposable e;

    public interface a extends q46.a {
        void A2(List<? extends j1> r1);

        void B4();

        void G3(Throwable r1);

        void GN(IFollowPair r1);

        void U2(Throwable r1);

        void j8(Throwable r1);

        void j9(List<? extends ILinkmicInteractEntrance> r1);

        void q4(com.bytedance.android.live.liveinteract.voicechat.model.a r1);

        void ta(ContributeShowResponse.OwnerHonorInfo r1);

        void up(com.bytedance.android.live.liveinteract.videotalk.emoji.model.k r1);

        void za(Throwable r1);
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ LinkApi.UpdateMcAction a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Function1 c;

        public b(LinkApi.UpdateMcAction r1, String r2, Function1 r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r5) {
            com.bytedance.android.live.network.response.a r6 = (com.bytedance.android.live.network.response.a) r5;
            com.bytedance.live.datacontext.m r7 = com.bytedance.android.live.liveinteract.api.utils.m.d().q();
            if (r7 == null) goto L5;
            nd r8 = (nd) r7.getValue();
        L6:
            int r0 = t.a[this.a.ordinal()];
            int r1 = 1;
            if (r0 != 1) goto L9;
            if (r8 == null) goto L18;
            r1 = r8.a;
        L18:
            if (r8 == null) goto L20;
            int r9 = r8.b;
        L21:
            String r2 = this.b;
            this.a.ordinal();
            nd.b r3 = new nd.b(r1, r9, r2);
            com.bytedance.live.datacontext.m r10 = com.bytedance.android.live.liveinteract.api.utils.m.d().q();
            if (r10 == null) goto L24;
            r10.setValue(r3);
        L24:
            this.c.invoke(r3);
            return;
        L20:
            r9 = 0;
            goto L21
        L9:
            if (r0 != 2) goto L14;
            if (r8 == null) goto L12;
            r1 = r8.a;
            goto L18
        L12:
            r1 = -1;
            goto L18
        L14:
            throw new IllegalArgumentException("passed an error argument on action: " + this.a.ordinal());
        L5:
            r8 = null;
            goto L6
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r3) {
            ALogger.e("update_mc_status", "update_mc_status failed " + ((Throwable) r3));
        }
    }

    public final void detachView() {
        ((q46.b) this).a = null;
        this.e.clear();
    }

    public s() {
        this.e = new CompositeDisposable();
    }

    public final void d0(String r9, LinkApi.UpdateMcAction r10, Function1<? super nd.b, Unit> r11) {
        Intrinsics.checkNotNullParameter(r9, "userId");
        Intrinsics.checkNotNullParameter(r10, "action");
        Intrinsics.checkNotNullParameter(r11, "onSuccess");
        if (com.bytedance.android.live.liveinteract.api.utils.m.i() != null) goto L5;
        return;
    L5:
        LinkApi r1 = (LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class);
        com.bytedance.live.datacontext.m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r0 == null) goto L10;
        IRoom r2 = (IRoom) r0.getValue();
        if (r2 == null) goto L10;
        long r3 = r2.getRoomId();
    L11:
        RxUtilKt.c(r1.updateMcStatus(r3, d5.c(r9), r9, r10.ordinal()).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(r10, r9, r11), c.a), this.e);
        return;
    L10:
        r3 = 0;
        goto L11
    }

    public static void c0(IRoom r12, boolean r13, String r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r12, PbRequest.SwitchType.ROOM);
        Intrinsics.checkNotNullParameter(r14, "userId");
        FollowLog r0 = new FollowLog("", r14.toString());
        IMiddlewareMicRoomService r1 = jc1.k.f(IMiddlewareMicRoomService.class);
        String r2 = je0.d.b0();
        if (r1 != null) goto L5;
    L7:
        boolean r5 = false;
    L8:
        if (r1 == null) goto L13;
        if (r5 == false) goto L13;
        if (r1.isLoyalAudience() == false) goto L13;
        boolean r6 = true;
    L14:
        if (r5 == true) goto L16;
    L18:
        boolean r3 = false;
    L19:
        if (r5 == true) goto L21;
    L23:
        boolean r7 = false;
    L25:
        if (Intrinsics.areEqual(r12.getOwnerUserIdString(), r14) == false) goto L27;
        char r4 = 0;
    L40:
        if (r15 == true) goto L42;
        if (r5 == false) goto L69;
        if (r4 == 0) goto L55;
        if (r4 != 3) goto L69;
    L55:
        if (r4 != 0) goto L62;
        if (r3 == false) goto L58;
        r0.a = "carousel_host_c_anchor";
    L85:
        HashMap r16 = new HashMap();
        if (r13 == false) goto L88;
        r16.put("growth_deepevent", String.valueOf(1));
    L88:
        String r8 = "0";
        if (Intrinsics.areEqual(r14, r12.getOwnerUserIdString()) == false) goto L91;
        Object r9 = "1";
    L92:
        r16.put("is_anchor", r9);
        if (r13 == true) goto L95;
    L99:
        if (r13 == false) goto L101;
        HashMap r10 = new HashMap();
        r10.put("follow_type", "follow");
        r10.put("type", "native");
        LiveSlardarMonitor.monitorStatus("ttlive_monitor_profile_follow", 0, r10);
    L101:
        r16.putAll(h1.a(r12));
        r16.put("live_type", i1.a(r12.getStreamType()));
        TalkRoomLogUtils.B0(r16, null, null, 6);
        if (r12.getAutoCover() == 0) goto L109;
        if (r12.getAutoCover() != 1) goto L106;
        String r17 = "autocover";
    L107:
        r16.put("cover_type", r17);
        goto L109
    L106:
        r17 = PbRequest.SwitchType.OTHER;
    L109:
        if (((Boolean) b6.X.getValue()).booleanValue() == false) goto L111;
        Object r18 = "1";
    L112:
        r16.put("is_screen_clear", r18);
        IAudienceGameDataService r19 = jc1.k.f(IAudienceGameDataService.class);
        if (r19 == null) goto L115;
        r16.put("game_id", String.valueOf(r19.getCurrentGameId()));
        r16.put("game_name", r19.getCurrentGameName());
    L115:
        r16.put("follow_source", "emoji_panel");
        r16.put("connection_type", ((IInteractService) jc1.k.n(IInteractService.class)).getLinkConnectionType());
        r16.put("anchor_cnt", jc1.k.n(IMultiLinkServiceExternal.class).getLinkAnchorCountString());
        r16.put("is_emoji_panel", "1");
        if (r13 == false) goto L124;
        com.bytedance.live.datacontext.m r110 = com.bytedance.android.live.liveinteract.api.utils.m.i().isCleanMode();
        if (r110 != null) goto L120;
    L122:
        r16.put("if_clear_mode", r8);
        goto L124
    L120:
        if (((Boolean) r110.getValue()).booleanValue() != true) goto L122;
        r8 = "1";
    L124:
        if (vm2.c.d() == false) goto L126;
        r16.put("to_user_id", r14);
    L126:
        com.bytedance.android.livesdk.log.j0 r111 = com.bytedance.android.livesdk.log.j0.l();
        if (r13 == false) goto L129;
        String r112 = "livesdk_follow";
    L130:
        am2.x r11 = new am2.x();
        r11.a = "live_interact";
        r11.b = "live_detail";
        r111.sendLog(r112, r16, new Object[]{r0, am2.u.class, r11, IRoom.class, am2.n.f(), am2.q.class});
        return;
    L129:
        r112 = "livesdk_unfollow";
        goto L130
    L111:
        r18 = "0";
        goto L112
    L95:
        if (((IMiddlewareBroadcastService) va1.b.a.a.a(IMiddlewareBroadcastService.class)).isPlayingGame() == false) goto L97;
        Object r20 = "1";
    L98:
        r16.put("is_gaming", r20);
        goto L99
    L97:
        r20 = "0";
        goto L98
    L91:
        r9 = "0";
        goto L92
    L58:
        if (r6 == false) goto L60;
        String r113 = "loyal_audience_c_anchor";
    L61:
        r0.a = r113;
        goto L85
    L60:
        r113 = "carousel_audience_c_anchor";
        goto L61
    L62:
        if (r4 != 3) goto L85;
        if (r3 == false) goto L65;
        r0.a = "carousel_host_c_official_id";
        goto L85
    L65:
        if (r6 == false) goto L67;
        String r114 = "loyal_audience_c_official_id";
    L68:
        r0.a = r114;
        goto L85
    L67:
        r114 = "carousel_audience_c_official_id";
    L69:
        if (r4 == 1) goto L72;
        r0.a = "live_audience_c_anchor";
        goto L85
    L72:
        if (r5 == false) goto L78;
        if (r7 == false) goto L78;
        if (r6 == false) goto L76;
        String r21 = "loyal_audience_c_carousel_host";
    L77:
        r0.a = r21;
    L83:
        if (TextUtils.isEmpty(r21) == false) goto L85;
        r0.a = "live_audience_c_audience";
        goto L85
    L76:
        r21 = "carousel_audience_c_carousel_host";
    L78:
        r0.a = "live_audience_c_audience";
        if (r0.c != null) goto L81;
        r21 = "live_audience_c_audience";
        goto L83
    L81:
        r21 = null;
        goto L83
    L42:
        if (r5 == false) goto L45;
        if (r7 == false) goto L45;
        r0.a = "anchor_c_carousel_host";
    L48:
        CharSequence r22 = null;
    L50:
        if (TextUtils.isEmpty(r22) == false) goto L85;
        r0.a = "live_anchor_c_audience";
    L45:
        r0.a = "live_anchor_c_audience";
        if (r0.c != null) goto L48;
        r22 = "live_anchor_c_audience";
        goto L50
    L27:
        if (r1 != null) goto L29;
    L39:
        r4 = 1;
        goto L40
    L29:
        if (r1.isMicRoom(r12) == false) goto L39;
        IOfficialChannelInfo r23 = r12.getOfficialChannelInfo();
        if (r23 == null) goto L39;
        IBaseUser r24 = r23.getChannelUser();
        if (r24 == null) goto L35;
        String r25 = r24.getIdString();
    L37:
        if (Intrinsics.areEqual(r25, r14) != true) goto L39;
        r4 = 3;
        goto L40
    L35:
        r25 = null;
        goto L37
    L21:
        if (((IInteractService) jc1.k.n(IInteractService.class)).isMicRoomHost(r14) == false) goto L23;
        r7 = true;
        goto L25
    L16:
        if (((IInteractService) jc1.k.n(IInteractService.class)).isMicRoomHost(r2) == false) goto L18;
        r3 = true;
    L13:
        r6 = false;
        goto L14
    L5:
        if (r1.isMicRoom(r12) == false) goto L7;
        r5 = true;
        goto L8
    }
}
