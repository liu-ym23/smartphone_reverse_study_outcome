package com.bytedance.android.live.liveinteract.linkcast;

import am2.x;
import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.broadcastgame.api.interactgame.IGameDataService;
import com.bytedance.android.live.liveinteract.model.LinkScreenCastType;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.openplatform.api.IMiddlewareOpenPlatformAudienceService;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.business.depend.livead.IMiddlewareLiveMiniAppService;
import com.bytedance.android.livesdk.chatroom.model.interact.s0;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomStampInfo;
import com.bytedance.common.utility.Lists;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import rj0.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g {
    public static long a;
    public static final a b = null;

    public static final class a {
        public a() {
        }

        public static boolean c() {
            l.n2.getClass();
            l r0 = l.a.a();
            if (r0 != null) goto L5;
        L7:
            return false;
        L5:
            if (r0.isLinkCasting() != true) goto L7;
            return true;
        }

        public static void a() {
            m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
            if (r0 == null) goto L7;
            IRoom r1 = (IRoom) r0.getValue();
            if (r1 == null) goto L7;
            r1.setLiveRoomStampsJson("");
        L7:
            m r2 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
            if (r2 == null) goto L13;
            IRoom r3 = (IRoom) r2.getValue();
            if (r3 == null) goto L14;
            r3.setLiveRoomStampsInfo(null);
            return;
        L14:
            return;
        }

        public static void g() {
            Room r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getCurrentRoom();
            Integer r1 = null;
            if (r0 == null) goto L7;
            IBaseUser r2 = r0.getOwner();
            if (r2 == null) goto L7;
            String r3 = r2.getIdString();
        L8:
            boolean r4 = Intrinsics.areEqual(r3, k.n(IMiddlewareUserService.class).user().n());
            LinkCastGuestDataContext r5 = LinkCastGuestDataContext.Companion.getContext();
            if (r5 == null) goto L15;
            n<s0> r6 = r5.getMLinkCastInfo();
            if (r6 == null) goto L15;
            s0 r7 = (s0) r6.getValue();
            if (r7 == null) goto L15;
            r1 = Integer.valueOf(r7.getItemType());
        L15:
            if (r4 == true) goto L29;
            int r8 = LinkScreenCastType.CAST_TYPE_MINI_APP.getTypeValue();
            if (r1 != null) goto L20;
            return;
        L20:
            if (r1.intValue() != r8) goto L30;
            g.a = System.currentTimeMillis();
            IMiddlewareOpenPlatformAudienceService r9 = (IMiddlewareOpenPlatformAudienceService) k.n(IMiddlewareOpenPlatformAudienceService.class);
            l.n2.getClass();
            l r10 = l.a.a();
            if (r10 == null) goto L26;
            boolean r11 = true;
            if (r10.isEngineOn() != true) goto L26;
        L27:
            r9.reportAudienceLiveProjectionWatch(r11);
            return;
        L26:
            r11 = false;
            goto L27
        L30:
            return;
        L29:
            return;
        L7:
            r3 = null;
            goto L8
        }

        public static String b(int r1) {
            if (r1 != LinkScreenCastType.CAST_TYPE_GAME.getTypeValue()) goto L6;
            return "game";
        L6:
            if (r1 != LinkScreenCastType.CAST_TYPE_MINI_APP.getTypeValue()) goto L8;
            return "program";
        L8:
            return "";
        }

        public static void h(boolean r5) {
            Room r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getCurrentRoom();
            Integer r1 = null;
            if (r0 == null) goto L7;
            IBaseUser r2 = r0.getOwner();
            if (r2 == null) goto L7;
            String r3 = r2.getIdString();
        L8:
            boolean r4 = Intrinsics.areEqual(r3, k.n(IMiddlewareUserService.class).user().n());
            LinkCastGuestDataContext r6 = LinkCastGuestDataContext.Companion.getContext();
            if (r6 == null) goto L15;
            n<s0> r7 = r6.getMLinkCastInfo();
            if (r7 == null) goto L15;
            s0 r8 = (s0) r7.getValue();
            if (r8 == null) goto L15;
            r1 = Integer.valueOf(r8.getItemType());
        L15:
            if (r4 == true) goto L23;
            int r9 = LinkScreenCastType.CAST_TYPE_MINI_APP.getTypeValue();
            if (r1 != null) goto L20;
            return;
        L20:
            if (r1.intValue() != r9) goto L24;
            ((IMiddlewareOpenPlatformAudienceService) k.n(IMiddlewareOpenPlatformAudienceService.class)).reportAudienceLiveProjectionWatchDuration((System.currentTimeMillis() - g.a) / ((long) 1000), r5);
            return;
        L24:
            return;
        L23:
            return;
        L7:
            r3 = null;
            goto L8
        }

        public static void d(String r3, boolean r4) {
            HashMap r0 = new HashMap();
            r0.put("_param_for_special", "micro_app");
            r0.put("mp_id", r3);
            r0.put("entrance_from", "solid_entrance");
            r0.put("enter_position", "connection_panel");
            r0.put("enter_from_merge", "connection_panel");
            r0.put("launch_from", "live");
            r0.put("scene", "023009");
            r0.put("location", "connection_panel");
            int r5 = je0.d.f();
            if (r5 != 8) goto L5;
            String r6 = "1v6";
        L9:
            r0.put("live_category", r6);
            if (r4 == false) goto L12;
            String r7 = "anchor";
        L13:
            r0.put("projection_user_type", r7);
            j0.l().sendLog("mp_click", r0, new Object[]{IRoom.class});
            return;
        L12:
            r7 = "guest";
            goto L13
        L5:
            if (r5 == 12) goto L7;
            r6 = "";
            goto L9
        L7:
            r6 = "party";
            goto L9
        }

        public static void f(Map r9, RoomStampInfo r10) {
            Intrinsics.checkNotNullParameter(r9, "logMap");
            m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
            String r1 = null;
            if (r0 == null) goto L7;
            IRoom r2 = (IRoom) r0.getValue();
            if (r2 == null) goto L7;
            List r3 = r2.getRoomStamps();
        L8:
            IMiddlewareLiveMiniAppService r4 = k.f(IMiddlewareLiveMiniAppService.class);
            int r5 = 0;
            if (r4 == null) goto L11;
            boolean r6 = r4.getMiniAppActivityState();
        L12:
            boolean r7 = true;
            String r8 = "";
            if (r6 == true) goto L31;
            com.bytedance.android.live.openplatform.api.model.datacontext.a r11 = (com.bytedance.android.live.openplatform.api.model.datacontext.a) k.f(com.bytedance.android.live.openplatform.api.model.datacontext.a.class);
            if (r11 == null) goto L17;
            com.bytedance.android.live.openplatform.api.model.shelf.b r12 = r11.getSelfInfo();
        L18:
            if (r12 != null) goto L31;
            if (Lists.isEmpty(r3) == true) goto L30;
            if (r3 == null) goto L26;
            RoomStampInfo r13 = (RoomStampInfo) ListProtector.get(r3, 0);
            if (r13 == null) goto L26;
            String r14 = r13.getId();
            if (r14 == null) goto L26;
        L28:
            if (TextUtils.isEmpty(r14) == true) goto L30;
        L26:
            r14 = "";
        L30:
            boolean r15 = false;
        L32:
            IGameDataService r16 = k.f(IGameDataService.class);
            if (r16 != null) goto L35;
        L39:
            boolean r17 = false;
        L40:
            if (r15 == true) goto L44;
            if (r17 == true) goto L44;
            r7 = false;
        L44:
            if (r7 == true) goto L46;
            return;
        L46:
            if (c() == false) goto L136;
            r9.put("is_share_screen", "1");
            LinkCastAnchorDataContext.a r18 = LinkCastAnchorDataContext.Companion;
            LinkCastAnchorDataContext r19 = r18.getContext();
            if (r19 == null) goto L53;
            n<s0> r20 = r19.getMLinkCastInfo();
            if (r20 == null) goto L53;
            s0 r21 = (s0) r20.getValue();
            if (r21 == null) goto L53;
        L60:
            if (r21 == null) goto L62;
            int r22 = r21.getItemType();
        L71:
            r9.put("source", b(r22));
            if (r21 == null) goto L75;
            String r23 = r21.getAppId();
            if (r23 == null) goto L75;
        L78:
            if (r23 != null) goto L80;
            r23 = "";
        L80:
            r9.put("content_id", r23);
            LinkCastAnchorDataContext r24 = r18.getContext();
            if (r24 == null) goto L86;
            n<s0> r25 = r24.getMLinkCastInfo();
            if (r25 == null) goto L86;
            s0 r26 = (s0) r25.getValue();
            if (r26 == null) goto L86;
        L92:
            if (r26 == null) goto L112;
            int r27 = r26.getItemType();
            LinkScreenCastType r28 = LinkScreenCastType.CAST_TYPE_GAME;
            if (r27 == r28.getTypeValue()) goto L100;
            r28 = LinkScreenCastType.CAST_TYPE_MINI_APP;
            if (r27 == r28.getTypeValue()) goto L100;
            r28 = LinkScreenCastType.CAST_TYPE_UNKNOWN;
        L100:
            int r29 = i.a;
            String r30 = r26.getAppId();
            if (r30 != null) goto L103;
            r30 = "";
        L103:
            c r31 = i.a.a(r28, r30);
            if (r31 == null) goto L107;
            String r32 = r31.c;
            if (r32 == null) goto L107;
        L110:
            if (r32 != null) goto L128;
            r32 = "";
        L128:
            if (r32 != null) goto L131;
            if (r10 == null) goto L132;
            r1 = r10.getName();
        L132:
            if (r1 == null) goto L135;
            r8 = r1;
        L135:
            r9.put("content_name", r8);
            return;
        L131:
            r1 = r32;
        L107:
            if (r10 == null) goto L109;
            r32 = r10.getName();
            goto L110
        L109:
            r32 = null;
            goto L110
        L112:
            int r33 = i.a;
            if (r10 == null) goto L115;
            r5 = r10.getType();
        L115:
            if (r5 == 4) goto L119;
            if (r5 == 10) goto L118;
            LinkScreenCastType r34 = LinkScreenCastType.CAST_TYPE_UNKNOWN;
        L120:
            if (r10 == null) goto L123;
            String r35 = r10.getId();
            if (r35 == null) goto L123;
        L124:
            c r36 = i.a.a(r34, r35);
            if (r36 == null) goto L127;
            r32 = r36.c;
            goto L128
        L127:
            r32 = null;
        L123:
            r35 = "";
            goto L124
        L118:
            r34 = LinkScreenCastType.CAST_TYPE_GAME;
            goto L120
        L119:
            r34 = LinkScreenCastType.CAST_TYPE_MINI_APP;
        L86:
            LinkCastGuestDataContext r37 = LinkCastGuestDataContext.Companion.getContext();
            if (r37 == null) goto L91;
            n<s0> r38 = r37.getMLinkCastInfo();
            if (r38 == null) goto L91;
            r26 = (s0) r38.getValue();
        L91:
            r26 = null;
        L75:
            if (r10 == null) goto L77;
            r23 = r10.getId();
            goto L78
        L77:
            r23 = null;
            goto L78
        L62:
            if (r10 == null) goto L64;
            int r39 = r10.getType();
        L65:
            if (r39 == 4) goto L69;
            if (r39 == 10) goto L68;
            LinkScreenCastType r40 = LinkScreenCastType.CAST_TYPE_UNKNOWN;
        L70:
            r22 = r40.getTypeValue();
            goto L71
        L68:
            r40 = LinkScreenCastType.CAST_TYPE_GAME;
            goto L70
        L69:
            r40 = LinkScreenCastType.CAST_TYPE_MINI_APP;
            goto L70
        L64:
            r39 = 0;
        L53:
            LinkCastGuestDataContext r41 = LinkCastGuestDataContext.Companion.getContext();
            if (r41 == null) goto L58;
            n<s0> r42 = r41.getMLinkCastInfo();
            if (r42 == null) goto L58;
            r21 = (s0) r42.getValue();
        L58:
            r21 = null;
            goto L60
        L136:
            r9.put("is_share_screen", "0");
            return;
        L35:
            if (r16.isAnchorPlayingGame() == false) goto L37;
        L38:
            r17 = true;
            goto L40
        L37:
            if (r16.isRunningPlugin() == false) goto L39;
        L17:
            r12 = null;
        L31:
            r15 = true;
            goto L32
        L11:
            r6 = false;
        L7:
            r3 = null;
            goto L8
        }

        public static void e(String r4, String r5, int r6, boolean r7) {
            HashMap r0 = new HashMap();
            m r1 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
            if (r1 == null) goto L9;
            IRoom r2 = (IRoom) r1.getValue();
            if (r2 == null) goto L9;
            if (r2.isLiveTypeAudio() != true) goto L9;
            String r3 = "voice_live";
        L10:
            r0.put("live_type", r3);
            TalkRoomLogUtils.B0(r0, null, null, 6);
            r0.put("content_id", r4);
            r0.put("content_name", r5);
            r0.put("source", b(r6));
            if (r7 == false) goto L13;
            String r8 = "anchor";
        L14:
            r0.put("user_type", r8);
            j0.l().sendLog("livesdk_seat_interact_panel_game_click", r0, new Object[]{IRoom.class, x.class});
            return;
        L13:
            r8 = "guest";
        L9:
            r3 = "video_live";
            goto L10
        }
    }

    static {
        b = new a();
    }
}
