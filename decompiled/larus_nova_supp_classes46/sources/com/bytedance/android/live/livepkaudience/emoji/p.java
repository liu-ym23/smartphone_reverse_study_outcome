package com.bytedance.android.live.livepkaudience.emoji;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.live.core.setting.e0;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomEmojiListResponse;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.room.IMicRoomService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.log.model.FollowLog;
import com.bytedance.android.livesdkapi.depend.model.follow.FollowPair;
import com.bytedance.android.livesdkapi.depend.model.live.OfficialChannelInfo;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class p extends q46.b<a> {
    public boolean b;
    public boolean c;
    public long d;
    public final CompositeDisposable e;

    public interface a extends q46.a {
        void M40(FollowPair r1);

        void U2(Throwable r1);

        void j8(Throwable r1);

        void kH(TalkRoomEmojiListResponse r1);

        void q4(com.bytedance.android.live.liveinteract.voicechat.model.a r1);

        void za(Throwable r1);
    }

    public final void detachView() {
        ((q46.b) this).a = null;
        this.e.clear();
    }

    public p() {
        this.e = new CompositeDisposable();
    }

    public static void c0(Room r17, boolean r18, String r19, boolean r20) {
        Intrinsics.checkNotNullParameter(r17, PbRequest.SwitchType.ROOM);
        String r1 = "0";
        if (r19 != null) goto L5;
        String r2 = "0";
    L6:
        String r4 = "";
        FollowLog r3 = new FollowLog("", r2);
        IMicRoomService r5 = jc1.k.f(IMicRoomService.class);
        String r6 = dl0.n.d();
        if (r5 != null) goto L9;
    L11:
        boolean r9 = false;
    L12:
        if (r5 == null) goto L17;
        if (r9 == false) goto L17;
        if (r5.isLoyalAudience() == false) goto L17;
        boolean r10 = true;
    L18:
        if (r9 == true) goto L20;
    L22:
        boolean r7 = false;
    L23:
        if (r9 == true) goto L25;
    L27:
        boolean r11 = false;
    L28:
        User r12 = r17.getOwner();
        if (r12 == null) goto L31;
        String r13 = r12.getIdStr();
    L33:
        if (Intrinsics.areEqual(r13, r2) == false) goto L35;
        char r8 = 0;
    L51:
        if (r20 == true) goto L53;
        if (r9 == false) goto L80;
        if (r8 == 0) goto L66;
        if (r8 != 3) goto L80;
    L66:
        if (r8 != 0) goto L73;
        if (r7 == false) goto L69;
        r3.a = "carousel_host_c_anchor";
    L96:
        r3.a = "pk_with_audience";
        HashMap r14 = new HashMap();
        if (r18 == false) goto L100;
        r14.put("growth_deepevent", String.valueOf(1));
    L100:
        if (jc1.k.n(ILinkServiceExternal.class).getPkService().getPkState() != 1) goto L102;
        boolean r15 = true;
    L103:
        if (r15 == false) goto L105;
        r4 = String.valueOf(jc1.k.n(ILinkServiceExternal.class).getMultiDataHolder().getPkId());
    L105:
        r14.put("pk_id", r4);
        if (r15 == false) goto L108;
        Object r16 = "1";
    L109:
        r14.put("is_in_pk", r16);
        o0.a r21 = o0.a;
        User r22 = r17.getOwner();
        if (r22 == null) goto L112;
        String r23 = r22.getIdStr();
    L113:
        r21.getClass();
        if (o0.a.a(r2, r23) == false) goto L116;
        Object r24 = "1";
    L117:
        r14.put("is_anchor", r24);
        if (r18 == true) goto L120;
    L124:
        if (r18 == false) goto L126;
        HashMap r25 = new HashMap();
        r25.put("follow_type", "follow");
        r25.put("type", "native");
        LiveSlardarMonitor.monitorStatus("ttlive_monitor_profile_follow", 0, r25);
    L126:
        r14.putAll(h1.a(r17));
        r14.put("live_type", i1.a(r17.getStreamType()));
        el0.j.k(r14);
        if (r17.getAutoCover() == 0) goto L134;
        if (r17.getAutoCover() != 1) goto L131;
        String r0 = "autocover";
    L132:
        r14.put("cover_type", r0);
        goto L134
    L131:
        r0 = PbRequest.SwitchType.OTHER;
    L134:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.V.getValue()).booleanValue() == false) goto L136;
        Object r26 = "1";
    L137:
        r14.put("is_screen_clear", r26);
        r14.put("follow_source", "emoji_panel");
        r14.put("connection_type", ((IInteractService) jc1.k.n(IInteractService.class)).getLinkConnectionType());
        r14.put("anchor_cnt", jc1.k.n(ILinkServiceExternal.class).getAnchorCount());
        r14.put("is_emoji_panel", "1");
        ILinkServiceExternal r27 = jc1.k.f(ILinkServiceExternal.class);
        if (r27 == null) goto L142;
        lc0.d r28 = r27.getPkService();
        if (r28 == null) goto L142;
        HashMap r29 = r28.getFollowExtraParams(r2);
    L143:
        if (r29 == null) goto L145;
        r14.putAll(r29);
    L145:
        if (r18 == false) goto L155;
        RoomContext r30 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r30 == null) goto L153;
        com.bytedance.live.datacontext.m r31 = r30.isCleanMode();
        if (r31 == null) goto L153;
        if (((Boolean) r31.getValue()).booleanValue() != true) goto L153;
        r1 = "1";
    L153:
        r14.put("if_clear_mode", r1);
    L155:
        if (((Boolean) e0.a.getValue()).booleanValue() == false) goto L157;
        r14.put("to_user_id", r2);
    L157:
        com.bytedance.android.livesdk.log.g r32 = com.bytedance.android.livesdk.log.u.l();
        if (r18 == false) goto L160;
        String r33 = "livesdk_follow";
    L161:
        am2.x r34 = new am2.x();
        r34.a = "live_interact";
        r34.b = "live_detail";
        r32.sendLog(r33, r14, new Object[]{r3, am2.u.class, r34, Room.class, am2.n.f(), am2.q.class});
        return;
    L160:
        r33 = "livesdk_unfollow";
    L142:
        r29 = null;
        goto L143
    L136:
        r26 = "0";
        goto L137
    L120:
        if (jc1.k.n(IBroadcastService.class).isPlayingGame() == false) goto L122;
        Object r35 = "1";
    L123:
        r14.put("is_gaming", r35);
        goto L124
    L122:
        r35 = "0";
        goto L123
    L116:
        r24 = "0";
        goto L117
    L112:
        r23 = null;
        goto L113
    L108:
        r16 = "0";
        goto L109
    L102:
        r15 = false;
        goto L103
    L69:
        if (r10 == false) goto L71;
        String r36 = "loyal_audience_c_anchor";
    L72:
        r3.a = r36;
        goto L96
    L71:
        r36 = "carousel_audience_c_anchor";
        goto L72
    L73:
        if (r8 != 3) goto L96;
        if (r7 == false) goto L76;
        r3.a = "carousel_host_c_official_id";
        goto L96
    L76:
        if (r10 == false) goto L78;
        String r37 = "loyal_audience_c_official_id";
    L79:
        r3.a = r37;
        goto L96
    L78:
        r37 = "carousel_audience_c_official_id";
    L80:
        if (r8 == 1) goto L83;
        r3.a = "live_audience_c_anchor";
        goto L96
    L83:
        if (r9 == false) goto L89;
        if (r11 == false) goto L89;
        if (r10 == false) goto L87;
        String r38 = "loyal_audience_c_carousel_host";
    L88:
        r3.a = r38;
    L94:
        if (TextUtils.isEmpty(r38) == false) goto L96;
        r3.a = "live_audience_c_audience";
        goto L96
    L87:
        r38 = "carousel_audience_c_carousel_host";
    L89:
        r3.a = "live_audience_c_audience";
        if (r3.c != null) goto L92;
        r38 = "live_audience_c_audience";
        goto L94
    L92:
        r38 = null;
        goto L94
    L53:
        if (r9 == false) goto L56;
        if (r11 == false) goto L56;
        r3.a = "anchor_c_carousel_host";
    L59:
        CharSequence r39 = null;
    L61:
        if (TextUtils.isEmpty(r39) == false) goto L96;
        r3.a = "live_anchor_c_audience";
    L56:
        r3.a = "live_anchor_c_audience";
        if (r3.c != null) goto L59;
        r39 = "live_anchor_c_audience";
        goto L61
    L35:
        if (r5 != null) goto L37;
    L50:
        r8 = 1;
        goto L51
    L37:
        if (r5.isMicRoom(r17) == false) goto L50;
        OfficialChannelInfo r40 = r17.officialChannelInfo;
        if (r40 == null) goto L50;
        IBaseUser r41 = r40.getChannelUser();
        if ((r41 instanceof User) == true) goto L43;
        r41 = null;
    L43:
        User r42 = (User) r41;
        if (r42 == null) goto L46;
        String r43 = r42.getIdStr();
    L48:
        if (Intrinsics.areEqual(r43, r2) != true) goto L50;
        r8 = 3;
        goto L51
    L46:
        r43 = null;
        goto L48
    L31:
        r13 = null;
        goto L33
    L25:
        if (((IInteractService) jc1.k.n(IInteractService.class)).isMicRoomHost(r2) == false) goto L27;
        r11 = true;
        goto L28
    L20:
        if (((IInteractService) jc1.k.n(IInteractService.class)).isMicRoomHost(r6) == false) goto L22;
        r7 = true;
    L17:
        r10 = false;
        goto L18
    L9:
        if (r5.isMicRoom(r17) == false) goto L11;
        r9 = true;
        goto L12
    L5:
        r2 = r19;
        goto L6
    }
}
