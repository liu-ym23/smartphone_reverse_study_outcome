package com.bytedance.android.live.liveinteract.plantform.utils;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.browser.GsonMap;
import com.bytedance.android.live.browser.UtilsKt;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.live.link.IMultiLinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;
import com.bytedance.android.live.liveinteract.digitavatar.DigitAvatarContext;
import com.bytedance.android.live.liveinteract.floatwindow.applywindow.LinkmicApplyFloatWindowManager;
import com.bytedance.android.live.liveinteract.hamlet.HamletAvatarContext;
import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.datamerge.LinkUserDataMergeContext;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.IMessageBoardInfo;
import com.bytedance.android.live.liveinteract.plantform.model.UserType;
import com.bytedance.android.live.liveinteract.revenue.battle.GuestBattleContext;
import com.bytedance.android.live.liveinteract.revenue.fight.TeamFightContext;
import com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.LinkRoomFightContext;
import com.bytedance.android.live.liveinteract.revenue.paid.viewmodel.PaidLinkMicContext;
import com.bytedance.android.live.liveinteract.videotalk.cposition.CPositionContext;
import com.bytedance.android.live.liveinteract.videotalk.dialog.CPositionBeInvitedDialog;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService;
import com.bytedance.android.live.liveinteract.voicechat.match.viewmodel.ChatMatchViewModel;
import com.bytedance.android.live.liveinteract.widget.widget.LinkDistributeSettingDialog;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.model.ILinkmicAudienceSetting;
import com.bytedance.android.livesdk.chatroom.model.g1;
import com.bytedance.android.livesdk.chatroom.model.interact.EnlargeGuestInfo;
import com.bytedance.android.livesdk.chatroom.model.interact.b1;
import com.bytedance.android.livesdk.chatroom.model.u1;
import com.bytedance.android.livesdk.chatroom.viewmodel.LivePlayModeLogContext;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdk.utils.s2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.livesdkapi.depend.model.live.circleinfo.ICircleInfo;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class TalkRoomLogUtils implements com.bytedance.android.live.liveinteract.utils.q {
    public static long A;
    public static final TalkRoomLogUtils B = null;
    public static i0 a;
    public static final h b = null;
    public static final e33.e c = null;
    public static String d;
    public static String e;
    public static final Map<r0, String> f = null;
    public static final Map<Integer, String> g = null;
    public static String h;
    public static String i;
    public static String j;
    public static String k;
    public static com.bytedance.android.live.liveinteract.utils.m0 l;
    public static Boolean m;
    public static String n;
    public static String o;
    public static String p;
    public static String q;
    public static long r;
    public static String s;
    public static final Map<Integer, Long> t = null;
    public static long u;
    public static long v;
    public static final Map<Integer, Long> w = null;
    public static String x;
    public static long y;
    public static long z;

    public TalkRoomLogUtils() {
    }

    public static String r1(int r1) {
        if (r1 != 10) goto L5;
        return "room_grouppk_interrupt";
    L5:
        if (r1 != 4) goto L7;
        return "func_switch";
    L7:
        if (r1 != 5) goto L9;
        return "close_member_cnt";
    L9:
        if (r1 != 6) goto L11;
    L13:
        return "chatroom_over";
    L11:
        if (r1 == 7) goto L13;
        return "manual_close";
    }

    @JvmStatic
    public static final void z0(Map<String, String> r2, Integer r3) {
        B0(r2, r3, null, 4);
    }

    public final void r0(String r15, String r16, List r17, String r18, boolean r19, boolean r20, Long r21) {
        s0(this, r15, r16, r17, r18, r19, "", "", "null", "", r20, r21, null, 2048);
    }

    static {
        B = new TalkRoomLogUtils();
        a = new i0(null, null, null);
        b = new h();
        c = new e33.e(new HashMap(), TalkRoomLogUtils$$special$$inlined$multiMapOf$1.INSTANCE);
        f = new LinkedHashMap();
        g = new LinkedHashMap();
        h = "live";
        i = "";
        j = "";
        k = "";
        n = "";
        o = "";
        p = "";
        s = "1";
        t = new LinkedHashMap();
        u = System.currentTimeMillis();
        w = new LinkedHashMap();
    }

    @JvmStatic
    public static final void F() {
        LinkedHashMap r0 = new LinkedHashMap();
        com.bytedance.live.datacontext.m r1 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r1 == null) goto L7;
        IRoom r2 = (IRoom) r1.getValue();
        if (r2 == null) goto L7;
        long r4 = r2.getRoomId();
    L8:
        com.bytedance.live.datacontext.m r3 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r3 == null) goto L14;
        IRoom r5 = (IRoom) r3.getValue();
        if (r5 == null) goto L14;
        Object r6 = r5.getOwnerUserIdString();
        if (r6 == null) goto L14;
    L15:
        J0(r0);
        B0(r0, null, null, 6);
        r0.put("room_id", String.valueOf(r4));
        r0.put("anchor_id", r6.toString());
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_anchor_connection_playmode_entry_show", r0, new Object[]{IRoom.class});
        return;
    L14:
        r6 = 0L;
    L7:
        r4 = 0;
        goto L8
    }

    public static void c0() {
        LinkedHashMap r0 = new LinkedHashMap();
        J0(r0);
        B0(r0, null, null, 6);
        V0(r0);
        r0.put("play_mode", "link_room");
        r0.put("duration", String.valueOf((System.currentTimeMillis() - u) / ((long) 1000)));
        r0.put("is_link_room", s);
        c1(r0);
        zi0.d.b(r0, true);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_audience_playmode_room_watch_duration", r0, new Object[]{IRoom.class});
    }

    public static Map e() {
        rj0.l.n2.getClass();
        rj0.l r0 = rj0.l.a.a();
        if (r0 == null) goto L5;
        String r1 = r0.currentCPositionChangeTrackData();
    L6:
        rj0.k.m2.getClass();
        rj0.k r2 = rj0.k.a.a();
        if (r2 == null) goto L9;
        r1 = r2.currentCPositionChangeTrackData();
    L9:
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r3 = IVoiceChatGuestService.a.a();
        if (r3 == null) goto L12;
        r1 = r3.currentCPositionChangeTrackData();
    L12:
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r4 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r4 == null) goto L16;
        r1 = r4.currentCPositionChangeTrackData();
    L16:
        if (r1.length() != 0) goto L18;
        boolean r5 = true;
    L19:
        if (r5 == true) goto L21;
        JsonObject r6 = JsonUtil.parseObject(r1);     // Catch: JsonParseException -> L34
        if (r6 == null) goto L26;
        GsonMap r7 = UtilsKt.i(r6);     // Catch: JsonParseException -> L34
    L27:
        if (r7 == null) goto L33;
        LinkedHashMap r8 = new LinkedHashMap(MapsKt.mapCapacity(r7.size()));
        Iterator r9 = r7.entrySet().iterator();
    L30:
        if (r9.hasNext() == false) goto L39;
        Map.Entry r10 = (Map.Entry) r9.next();
        r8.put(r10.getKey(), String.valueOf(r10.getValue()));
        goto L30
    L39:
        return r8;
    L33:
        return MapsKt.emptyMap();
    L26:
        r7 = null;
    L35:
        return MapsKt.emptyMap();
    L21:
        return MapsKt.emptyMap();
    L18:
        r5 = false;
        goto L19
    L5:
        r1 = "";
        goto L6
    }

    public static int f() {
        rj0.l.n2.getClass();
        rj0.l r0 = rj0.l.a.a();
        if (r0 != null) goto L5;
        rj0.k.m2.getClass();
        rj0.k r1 = rj0.k.a.a();
        if (r1 != null) goto L9;
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r2 = IVoiceChatGuestService.a.a();
        if (r2 != null) goto L13;
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r3 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r3 != null) goto L17;
        return -1;
    L17:
        return r3.currentCPositionOpenSource();
    L13:
        return r2.currentCPositionOpenSource();
    L9:
        return r1.currentCPositionOpenSource();
    L5:
        return r0.currentCPositionOpenSource();
    }

    @JvmStatic
    public static final void l1() {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("live_type", "voice_live");
        r0.put("function_type", "party");
        r0.put("seat_fit_status", "off");
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_guest_connection_pre_link_show", r0, new Object[]{IRoom.class, am2.x.class});
    }

    public static void n1() {
        Intrinsics.checkNotNullParameter("", "source");
        Intrinsics.checkNotNullParameter("", "gameId");
        Intrinsics.checkNotNullParameter("", "gameName");
        ALogger.i("TalkRoomLogUtils", "setBroadcastMultiLinkGameParams source:, gameId:, gameName:");
        n = "";
        o = "";
        p = "";
    }

    @JvmStatic
    public static final int q() {
        return ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
    }

    public static String t() {
        LinkRoomFightContext r0 = LinkRoomFightContext.Companion.getContext();
        if (r0 == null) goto L8;
        com.bytedance.live.datacontext.m<com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.c.b> r1 = r0.getFightState();
        if (r1 == null) goto L8;
        Object r2 = (com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.c.b) r1.getValue();
        if (r2 == null) goto L8;
    L9:
        r2.getClass();
        if ((r2 instanceof com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.c.b.a) == false) goto L12;
    L15:
        boolean r3 = true;
    L16:
        if (r3 == false) goto L19;
        return "processing";
    L19:
        if ((r2 instanceof com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.c.b.e) == false) goto L21;
        return "punish";
    L21:
        return "punish_finish";
    L12:
        if ((r2 instanceof com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.c.b.f) == true) goto L15;
        r3 = false;
    L8:
        r2 = com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.c.b.C0093c.c;
        goto L9
    }

    public static String v() {
        Integer r0 = (Integer) b6.B.getValue();
        if (r0 != null) goto L6;
    L8:
        if (r0 != null) goto L11;
    L13:
        if (r0 != null) goto L16;
    L18:
        return "time_first";
    L16:
        if (r0.intValue() != 42) goto L18;
        return "complex_value";
    L11:
        if (r0.intValue() != 41) goto L13;
        return "money_first";
    L6:
        if (r0.intValue() != 40) goto L8;
        goto L8
    }

    public static String x() {
        TeamFightContext.a r0 = TeamFightContext.Companion;
        if (r0.d() == false) goto L6;
        return "prepare";
    L6:
        if (r0.f() == false) goto L9;
        return "processing";
    L9:
        if (r0.e() == false) goto L11;
        return "punish";
    L11:
        return "punish_finish";
    }

    public final void g0() {
        com.bytedance.android.live.liveinteract.utils.m0 r0 = l;
        if (r0 == null) goto L10;
        String r1 = r0.a;
        Long r2 = r0.j;
        int r4 = r0.b;
        boolean r5 = r0.c;
        IRoom r7 = r0.h;
        String r8 = r0.i;
        String r11 = r0.d;
        boolean r12 = r0.e;
        boolean r13 = r0.f;
        String r14 = r0.g;
        w0 r17 = new w0();
        if (je0.d.f() != 1) goto L7;
        Map<String, String> r3 = r0.o;
    L8:
        b0(r1, r2, null, r4, r5, false, r7, r8, null, null, r11, r12, r13, r14, null, null, r17, r3, null, null, 1572864);
        return;
    L7:
        r3 = null;
        goto L8
    }

    public static boolean E() {
        com.bytedance.live.datacontext.j r0 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
        if (r0 == null) goto L8;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r1 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r0.getValue();
        if (r1 == null) goto L8;
        r1.t();
    L8:
        if (com.bytedance.android.livesdk.chatroom.interact.model.d0.d() == true) goto L22;
        com.bytedance.live.datacontext.j r2 = com.bytedance.android.live.liveinteract.api.utils.m.d().J();
        if (r2 == null) goto L20;
        LivePlayModeLogContext r3 = (LivePlayModeLogContext) r2.getValue();
        if (r3 == null) goto L20;
        com.bytedance.live.datacontext.m r4 = r3.getPlayModes();
        if (r4 == null) goto L20;
        Set r5 = (Set) r4.getValue();
        if (r5 == null) goto L20;
        if (r5.contains(13) != true) goto L20;
        return true;
    L20:
        return false;
    L22:
        return true;
    }

    public static String g() {
        Integer r0 = Integer.valueOf(q());
        LinkedHashMap r1 = new LinkedHashMap();
        A0(r1, r0, null);
        String r2 = (String) r1.get("function_type");
        if (r2 != null) goto L6;
        return "live";
    L6:
        return r2;
    }

    public static String r() {
        com.bytedance.android.livesdk.log.filter.o r0 = com.bytedance.android.livesdk.log.j0.l().c(am2.x.class);
        if ((r0 instanceof com.bytedance.android.livesdk.log.filter.t) == true) goto L5;
        r0 = null;
    L5:
        com.bytedance.android.livesdk.log.filter.t r1 = (com.bytedance.android.livesdk.log.filter.t) r0;
        if (r1 != null) goto L9;
        return null;
    L9:
        if (TextUtils.isEmpty(r1.f()) == true) goto L18;
        String r2 = r1.l();
        if (r2 == null) goto L13;
        String r3 = r2.toLowerCase(Locale.getDefault());
    L15:
        if (Intrinsics.areEqual(r3, "true") == false) goto L18;
        return "invite_mutual";
    L13:
        r3 = null;
    L18:
        return null;
    }

    public static String u() {
        if (Intrinsics.areEqual(com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor(), Boolean.TRUE) == false) goto L7;
        return "anchor";
    L7:
        if (jc1.k.n(IMiddlewareUserService.class).user().c() == false) goto L10;
        return "user";
    L10:
        return "guest";
    }

    public static String y() {
        if (Intrinsics.areEqual(com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor(), Boolean.TRUE) == false) goto L6;
        return "anchor";
    L6:
        boolean r0 = jc1.k.n(IMiddlewareUserService.class).user().isAdmin();
        Integer r1 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r1 != null) goto L10;
        return "user";
    L10:
        if (r1.intValue() != 2) goto L15;
        if (r0 == false) goto L13;
        return "administrator";
    L13:
        return "guest";
    L15:
        return "user";
    }

    public static void C0(Map r4) {
        Integer r0 = Integer.valueOf(q());
        Integer r1 = je0.d.h();
        Intrinsics.checkNotNullParameter(r4, "logMap");
        if (r0 != null) goto L5;
    L7:
        r4.put("function_type", h);
    L8:
        r4.put("function_type2", h);
        return;
    L5:
        if (r0.intValue() == 0) goto L7;
        r4.put("function_type", p(r0, r1, null));
        goto L8
    }

    @JvmStatic
    public static final void E0(Map<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "logMap");
        LinkmicApplyFloatWindowManager.d r0 = LinkmicApplyFloatWindowManager.y;
        if (LinkmicApplyFloatWindowManager.e.a().f == false) goto L5;
        String r1 = "1";
    L6:
        ((HashMap) r2).put("is_apply_reserve", r1);
        LinkmicApplyFloatWindowManager.e.a().f = false;
        return;
    L5:
        r1 = "0";
        goto L6
    }

    @JvmStatic
    public static final void H0(Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r3, "logMap");
        com.bytedance.live.datacontext.m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r0 == null) goto L5;
        IRoom r1 = (IRoom) r0.getValue();
    L6:
        com.bytedance.android.livesdk.vscore_api.paidlive.b r2 = com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.c(r1).J0();
        if (r2 != null) goto L9;
    L11:
        String r4 = "0";
    L12:
        r3.put("is_paidlive", r4);
        return;
    L9:
        if (r2.j(r1, null) != true) goto L11;
        r4 = "1";
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    public static /* synthetic */ void J0(Map r1) {
        I0(r1, q());
    }

    public static void K0(Map r5) {
        int r0 = q();
        Intrinsics.checkNotNullParameter(r5, "logMap");
        if (r0 != 4) goto L5;
        r5.put("live_type", "video_live");
        return;
    L5:
        if (r0 != 5) goto L7;
        r5.put("live_type", "voice_live");
        return;
    L7:
        if (r0 == 12) goto L13;
        switch(r0) {
            case 8: goto L12;
            case 9: goto L11;
            case 10: goto L10;
            default: goto L22;
        };
    L10:
        r5.put("live_type", "voice_live");
        return;
    L11:
        r5.put("live_type", "voice_live");
        return;
    L12:
        r5.put("live_type", "video_live");
        return;
    L22:
        return;
    L13:
        r5.put("live_type", "video_live");
    }

    @JvmStatic
    public static final void L0(Map<String, String> r5) {
        Intrinsics.checkNotNullParameter(r5, "logMap");
        com.bytedance.android.livesdk.log.filter.o r0 = com.bytedance.android.livesdk.log.j0.l().c(am2.x.class);
        com.bytedance.android.livesdk.log.filter.t r2 = null;
        if ((r0 instanceof com.bytedance.android.livesdk.log.filter.t) == true) goto L5;
        r0 = null;
    L5:
        com.bytedance.android.livesdk.log.filter.t r1 = (com.bytedance.android.livesdk.log.filter.t) r0;
        String r3 = "";
        if (r1 == null) goto L11;
        Map r4 = r1.getMap();
        if (r4 == null) goto L11;
        String r6 = (String) r4.get("enter_from_merge");
        if (r6 == null) goto L11;
    L13:
        if (TextUtils.equals("homepage_fresh", r6) == false) goto L38;
        com.bytedance.android.livesdk.log.filter.t r7 = com.bytedance.android.livesdk.log.j0.l().c(am2.x.class);
        if ((r7 instanceof com.bytedance.android.livesdk.log.filter.t) == false) goto L18;
        r2 = r7;
    L18:
        com.bytedance.android.livesdk.log.filter.t r8 = r2;
        if (r8 == null) goto L26;
        Map r9 = r8.getMap();
        if (r9 == null) goto L26;
        String r10 = (String) r9.get("enter_method");
        if (r10 == null) goto L26;
        r3 = r10;
    L26:
        int r11 = r3.hashCode();
        if (r11 == 103668165) goto L35;
        if (r11 == 109399814) goto L32;
        return;
    L32:
        if (r3.equals(ChatMatchViewModel.ENTER_METHOD_SHAKE) == false) goto L41;
        ((HashMap) r5).put("match_enter_from", "live_outside");
        return;
    L41:
        return;
    L35:
        if (r3.equals(ChatMatchViewModel.ENTER_METHOD_MATCH) == false) goto L43;
        ((HashMap) r5).put("match_enter_from", "live_outside");
        return;
    L43:
        return;
    L38:
        if (TextUtils.equals("live_detail", r6) == false) goto L45;
        ((HashMap) r5).put("match_enter_from", "live_detail");
        return;
    L45:
        return;
    L11:
        r6 = "";
        goto L13
    }

    public static void M(int r5) {
        HashMap r0 = new HashMap();
        com.bytedance.live.datacontext.m r1 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r1 == null) goto L5;
        IRoom r2 = (IRoom) r1.getValue();
    L6:
        if (r2 != null) goto L8;
    L10:
        String r3 = "video_live";
    L11:
        r0.put("live_type", r3);
        if (r2 == null) goto L17;
        IBaseUser r4 = r2.getOwner();
        if (r4 == null) goto L17;
        String r6 = r4.getIdString();
        if (r6 == null) goto L17;
    L18:
        r0.put("anchor_id", r6);
        if (r2 == null) goto L21;
        Long r7 = Long.valueOf(r2.getId());
    L22:
        r0.put("room_id", String.valueOf(r7));
        r0.put("icon_type", "empty");
        r0.put("user_type", "audience");
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r8 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkUserInfoCenter();
        if (r8 == null) goto L26;
        String r9 = String.valueOf(je0.d.j(r8));
        if (r9 == null) goto L26;
    L27:
        r0.put("link_cnt", r9);
        B0(r0, null, null, 6);
        String r10 = u0.i(Integer.valueOf(com.bytedance.android.live.liveinteract.linkpanel.util.o.d()), je0.d.d(), Integer.valueOf(b.a));
        if (r10 == null) goto L31;
        r0.put("layout_type", r10);
    L31:
        if (r5 == (-1)) goto L33;
        F0(r5, r0);
    L33:
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_anchor_audience_connection_empty_seat_show", r0, new Object[0]);
        return;
    L26:
        r9 = "0";
        goto L27
    L21:
        r7 = null;
    L17:
        r6 = "";
        goto L18
    L8:
        if (r2.isLiveTypeAudio() != true) goto L10;
        r3 = "voice_live";
        goto L11
    L5:
        r2 = null;
        goto L6
    }

    @JvmStatic
    public static final void O0(Map<String, String> r5) {
        Intrinsics.checkNotNullParameter(r5, "logMap");
        com.bytedance.android.livesdk.chatroom.o r0 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        int r1 = com.bytedance.android.livesdk.chatroom.paidlive.e.a;
        IRoom r2 = null;
        if (r0 == null) goto L17;
        com.bytedance.live.datacontext.m r3 = r0.getRoom();
        if (r3 == null) goto L17;
        IRoom r4 = (IRoom) r3.getValue();
        if (r4 == null) goto L17;
        com.bytedance.live.datacontext.m r6 = r0.getCameraId();
        if (r6 == null) goto L12;
        Long r7 = (Long) r6.getValue();
    L13:
        if (r7 == null) goto L15;
        long r8 = r7.longValue();
    L16:
        boolean r9 = com.bytedance.android.livesdk.chatroom.paidlive.e.c(r4, Long.valueOf(r8));
    L18:
        H0(r5);
        if (r9 == false) goto L21;
        String r10 = "paid";
    L22:
        r5.put("pay_ticket_status", r10);
        if (r9 == false) goto L33;
        com.bytedance.live.datacontext.m r11 = r0.getRoom();
        if (r11 == null) goto L27;
        IRoom r12 = (IRoom) r11.getValue();
    L28:
        r5.put("is_other_channel", com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.c(r12).J0().b());
        com.bytedance.live.datacontext.m r13 = r0.getRoom();
        if (r13 == null) goto L31;
        r2 = (IRoom) r13.getValue();
    L31:
        r5.put("ticket_id", String.valueOf(com.bytedance.android.livesdk.vscore_api.paidlive.b.a.b(com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.c(r2).J0(), r0.getDataCenter())));
        return;
    L27:
        r12 = null;
        goto L28
    L33:
        return;
    L21:
        r10 = "unpaid";
        goto L22
    L15:
        r8 = 0;
        goto L16
    L12:
        r7 = null;
    L17:
        r9 = false;
        goto L18
    }

    @JvmStatic
    public static final void Q0(Map<String, String> r7) {
        Intrinsics.checkNotNullParameter(r7, "logMap");
        com.bytedance.live.datacontext.j r0 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
        IRoom r1 = null;
        boolean r2 = true;
        if (r0 == null) goto L16;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r3 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r0.getValue();
        if (r3 == null) goto L16;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r4 = r3.t();
        if (r4 == null) goto L16;
        List r5 = r4.b;
        if (r5 == null) goto L16;
        if (r5.contains(1) == true) goto L14;
        r5 = null;
    L14:
        if (r5 == null) goto L16;
        String r6 = "video_friend";
    L17:
        int r8 = je0.d.f();
        if (r8 != 8) goto L20;
    L24:
        boolean r9 = true;
    L25:
        if (r9 == false) goto L72;
        GuestBattleContext.a r10 = GuestBattleContext.Companion;
        if (r10.e() == true) goto L65;
        GuestBattleContext r11 = r10.getContext();
        if (r11 == null) goto L72;
        com.bytedance.live.datacontext.m<Integer> r12 = r11.getBattleState();
        if (r12 == null) goto L72;
        if (((Number) r12.getValue()).intValue() != 0) goto L72;
        com.bytedance.live.datacontext.j r13 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
        if (r13 == null) goto L48;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r14 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r13.getValue();
        if (r14 == null) goto L48;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r15 = r14.t();
        if (r15 == null) goto L48;
        List r16 = r15.b;
        if (r16 == null) goto L48;
        if (r16.contains(5) == true) goto L46;
        r16 = null;
    L46:
        if (r16 == null) goto L48;
    L61:
        boolean r17 = true;
    L63:
        if (r17 == false) goto L72;
    L48:
        com.bytedance.live.datacontext.m r18 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r18 == null) goto L51;
        r1 = (IRoom) r18.getValue();
    L51:
        if (r1 == null) goto L59;
        z5 r19 = r1.getLinkerDetail();
        if (r19 == null) goto L59;
        List r20 = r19.getPlayModes();
        if (r20 == null) goto L59;
        if (r20.contains(Long.valueOf(5)) != true) goto L59;
        boolean r21 = true;
    L60:
        if (r21 == true) goto L61;
        r17 = false;
    L59:
        r21 = false;
    L65:
        if (r6.length() > 0) goto L68;
        r2 = false;
    L68:
        if (r2 == false) goto L70;
        String r22 = ",bomb";
    L71:
        r6 = r6.concat(r22);
        goto L72
    L70:
        r22 = "bomb";
    L72:
        r7.put("play_type", r6);
        return;
    L20:
        if (r8 == 12) goto L24;
        if (r8 == 5) goto L24;
        r9 = false;
    L16:
        r6 = "";
        goto L17
    }

    @JvmStatic
    public static final void R0(Map<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "logMap");
        com.bytedance.android.live.liveinteract.plantform.base.g r0 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        boolean r1 = true;
        if (r0 != null) goto L5;
    L6:
        com.bytedance.android.live.liveinteract.plantform.base.g r3 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r3 != null) goto L9;
    L11:
        r1 = false;
    L12:
        if (r1 == false) goto L14;
        String r4 = "0";
    L15:
        ((HashMap) r2).put("pre_status", r4);
        return;
    L14:
        r4 = "1";
        goto L15
    L9:
        if (r3.s8() != true) goto L11;
    L5:
        if (r0.nd() == true) goto L12;
        goto L6
    }

    public static void U(Long r4) {
        if (r4 == null) goto L5;
        r4.longValue();
        HashMap r0 = new HashMap();
        J0(r0);
        w0(r0);
        r0.put("duration", String.valueOf(r4.longValue()));
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_audience_chatroom_interact_loading_duration", r0, new Object[]{IRoom.class, am2.x.class});
        return;
    L5:
        ALogger.e("TalkRoomLogUtils", "logChatRoomInteractDurationV2 error, duration is null!");
    }

    @JvmStatic
    public static final void V0(Map<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "logMap");
        com.bytedance.live.datacontext.j r0 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
        if (r0 == null) goto L13;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r1 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r0.getValue();
        if (r1 == null) goto L14;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r3 = r1.t();
        if (r3 != null) goto L9;
        return;
    L9:
        if (com.bytedance.android.livesdk.chatroom.interact.model.d0.e(r3.b) == false) goto L11;
        r2.put("seat_fit_status", "on");
        return;
    L11:
        r2.put("seat_fit_status", "off");
        return;
    L14:
        return;
    }

    public static void Y0(Map r2) {
        Intrinsics.checkNotNullParameter(r2, "logMap");
        com.bytedance.live.datacontext.j r0 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
        if (r0 == null) goto L13;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r1 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r0.getValue();
        if (r1 == null) goto L14;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r3 = r1.t();
        if (r3 != null) goto L9;
        return;
    L9:
        if (com.bytedance.android.livesdk.chatroom.interact.model.d0.e(r3.b) == false) goto L11;
        r2.put("seat_fit_status", "on");
        return;
    L11:
        r2.put("seat_fit_status", "off");
        return;
    L14:
        return;
    }

    @JvmStatic
    public static final void Z0(Map<String, String> r5) {
        Intrinsics.checkNotNullParameter(r5, "logMap");
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r0 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkUserInfoCenter();
        if ((r0 instanceof com.bytedance.android.live.liveinteract.plantform.core.y) == false) goto L26;
        com.bytedance.android.live.liveinteract.plantform.core.y r1 = (com.bytedance.android.live.liveinteract.plantform.core.y) r0;
        HashMap r6 = (HashMap) r5;
        r6.put("seat_num", String.valueOf(r1.n()));
        Iterator<LinkmicPositionItem> r2 = r1.e.iterator();
    L6:
        if (r2.hasNext() == false) goto L13;
        LinkmicPositionItem r3 = r2.next();
        if (((int) r3.getPosition()) != r0.O4(je0.d.b0())) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == false) goto L6;
    L14:
        LinkmicPositionItem r7 = r3;
        if (r7 == null) goto L18;
        String r8 = r7.getActiveName();
        if (r8 == null) goto L18;
    L19:
        r6.put("seat_name", r8);
        return;
    L18:
        r8 = "";
        goto L19
    L10:
        r4 = false;
        goto L11
    L13:
        r3 = null;
        goto L14
    }

    @JvmStatic
    public static final void b(Map<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        com.bytedance.android.livesdk.log.filter.t r0 = com.bytedance.android.livesdk.log.j0.l().c(am2.x.class);
        if ((r0 instanceof com.bytedance.android.livesdk.log.filter.t) == false) goto L8;
        String r1 = r0.w();
        if (r1 == null) goto L9;
        String r3 = (String) ((HashMap) r2).put("shoot_way", r1);
        return;
    L9:
        return;
    }

    @JvmStatic
    public static final void c(String r5) {
        Intrinsics.checkNotNullParameter(r5, "userId");
        String r1 = null;
        if (Intrinsics.areEqual(r5, jc1.k.n(IMiddlewareUserService.class).user().n()) == false) goto L5;
        String r0 = "oneself";
    L15:
        com.bytedance.android.livesdk.log.filter.o r2 = com.bytedance.android.livesdk.log.j0.l().c(am2.x.class);
        if ((r2 instanceof com.bytedance.android.livesdk.log.filter.t) == true) goto L18;
        r2 = null;
    L18:
        com.bytedance.android.livesdk.log.filter.t r3 = (com.bytedance.android.livesdk.log.filter.t) r2;
        if (r3 == null) goto L23;
        Map r4 = r3.getMap();
        if (r4 == null) goto L23;
        String r6 = (String) r4.get("enter_from_merge");
    L24:
        if (r6 == null) goto L28;
        String.valueOf(r3.getMap().get("enter_from_merge"));
    L28:
        if (r3 == null) goto L32;
        Map r7 = r3.getMap();
        if (r7 == null) goto L32;
        String r8 = (String) r7.get("enter_method");
    L33:
        if (r8 == null) goto L40;
        if (r3 == null) goto L40;
        Map r9 = r3.getMap();
        if (r9 == null) goto L40;
        String r10 = (String) r9.get("enter_method");
    L40:
        if (r3 == null) goto L44;
        Map r11 = r3.getMap();
        if (r11 == null) goto L44;
        r1 = (String) r11.get("action_type");
    L44:
        if (r1 == null) goto L50;
        if (r3 == null) goto L50;
        Map r12 = r3.getMap();
        if (r12 == null) goto L50;
        String r13 = (String) r12.get("action_type");
    L50:
        LinkedHashMap r14 = new LinkedHashMap();
        r14.put("user_id", r5.toString());
        r14.put("user_type", r0);
        int r15 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
        u0(r14);
        I0(r14, r15);
        r14.put("function_type", g());
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_mic_counter_click", r14, new Object[]{am2.x.class, IRoom.class});
        return;
    L32:
        r8 = null;
    L23:
        r6 = null;
        goto L24
    L5:
        com.bytedance.live.datacontext.m r16 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r16 == null) goto L10;
        IRoom r17 = (IRoom) r16.getValue();
        if (r17 == null) goto L10;
        String r18 = r17.getOwnerUserIdString();
    L12:
        if (Intrinsics.areEqual(r5, r18) == false) goto L14;
        r0 = "anchor";
        goto L15
    L14:
        r0 = "audience";
    L10:
        r18 = null;
        goto L12
    }

    public static void c1(Map r2) {
        Intrinsics.checkNotNullParameter(r2, "logMap");
        if (Intrinsics.areEqual(com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor(), Boolean.TRUE) == false) goto L6;
        String r0 = "anchor";
    L15:
        r2.put("user_type", r0);
        return;
    L6:
        if (jc1.k.n(IMiddlewareUserService.class).user().c() == false) goto L8;
        r0 = "admin";
        goto L15
    L8:
        Integer r1 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r1 != null) goto L12;
    L13:
        r0 = "guest";
        goto L15
    L12:
        if (r1.intValue() != 0) goto L13;
        r0 = "user";
        goto L15
    }

    public static void i1(Map r2) {
        Intrinsics.checkNotNullParameter(r2, "param");
        if (Intrinsics.areEqual(com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor(), Boolean.TRUE) == false) goto L5;
        String r0 = "anchor";
    L6:
        r2.put("user_type", r0);
        return;
    L5:
        r0 = "admin";
        goto L6
    }

    @JvmStatic
    public static final void l0(String r7) {
        Intrinsics.checkNotNullParameter(r7, "source");
        com.bytedance.live.datacontext.m r1 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r1 == null) goto L7;
        IRoom r2 = (IRoom) r1.getValue();
        if (r2 == null) goto L7;
        long r4 = r2.getRoomId();
    L8:
        com.bytedance.live.datacontext.m r3 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r3 == null) goto L14;
        IRoom r5 = (IRoom) r3.getValue();
        if (r5 == null) goto L14;
        Object r6 = r5.getOwnerUserIdString();
        if (r6 == null) goto L14;
    L15:
        LinkedHashMap r8 = new LinkedHashMap();
        J0(r8);
        B0(r8, null, null, 6);
        V0(r8);
        r8.put("source", r7);
        r8.put("room_id", String.valueOf(r4));
        r8.put("anchor_id", r6.toString());
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_live_music_icon_click", r8, new Object[]{IRoom.class});
        return;
    L14:
        r6 = 0L;
    L7:
        r4 = 0;
        goto L8
    }

    public static void n0(Map r4) {
        Intrinsics.checkNotNullParameter(r4, "logMap");
        HashMap r0 = new HashMap(r4);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_audience_voice_room_show_v2", r0, new Object[]{IRoom.class, am2.x.class});
    }

    public static String o(Integer r9) {
        if (r9 != null) goto L5;
    L8:
        CPositionContext r10 = CPositionContext.Companion.getContext();
        if (r10 == null) goto L73;
        com.bytedance.live.datacontext.m<EnlargeGuestInfo> r11 = r10.getEnlargeGuestInfo();
        if (r11 == null) goto L73;
        EnlargeGuestInfo r12 = (EnlargeGuestInfo) r11.getValue();
        if (r12 == null) goto L73;
        int r1 = r12.getEnlargeGuestType();
        Integer r7 = null;
        String r8 = null;
        r8 = null;
        String r13 = null;
        r13 = null;
        Boolean r14 = null;
        if (r1 != EnlargeGuestInfo.EnlargeGuestType.EnlargeGuestType_Unkown.ordinal()) goto L49;
        ArrayList r15 = new ArrayList();
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r2 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkUserInfoCenter();
        if (r2 == null) goto L31;
        Iterable r3 = r2.getOnlineUserList();
        if (r3 == null) goto L31;
        Iterator r4 = r3.iterator();
    L22:
        if (r4.hasNext() == false) goto L31;
        ILinkPlayerInfoBridge r5 = (ILinkPlayerInfoBridge) r4.next();
        if (r5.isEnlarged() == false) goto L22;
        IBaseUser r6 = r5.getUser();
        if (r6 == null) goto L29;
        String r16 = r6.getIdString();
        if (r16 == null) goto L29;
    L30:
        r15.add(r16);
    L29:
        r16 = "";
    L31:
        int r0 = r15.size();
        if (r0 != 1) goto L34;
        String r17 = (String) ListProtector.get(r15, 0);
        com.bytedance.live.datacontext.m r18 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r18 == null) goto L44;
        IRoom r19 = (IRoom) r18.getValue();
        if (r19 == null) goto L44;
        r8 = r19.getOwnerUserIdString();
    L44:
        if (Intrinsics.areEqual(r17, r8) == false) goto L47;
        return "anchor";
    L47:
        return "guest";
    L34:
        if (r0 == 2) goto L37;
        return "normal";
    L37:
        return "double";
    L49:
        if (r1 != EnlargeGuestInfo.EnlargeGuestType.EnlargeGuestType_Single.ordinal()) goto L64;
        List r20 = com.bytedance.android.livesdk.chatroom.model.interact.b.a(r12);
        if (r20 == null) goto L59;
        List r21 = r20;
        com.bytedance.live.datacontext.m r22 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r22 == null) goto L57;
        IRoom r23 = (IRoom) r22.getValue();
        if (r23 == null) goto L57;
        r13 = r23.getOwnerUserIdString();
    L57:
        r14 = Boolean.valueOf(CollectionsKt.contains(r21, r13));
    L59:
        if (r14.booleanValue() == false) goto L62;
        return "anchor";
    L62:
        return "guest";
    L64:
        if (r1 != EnlargeGuestInfo.EnlargeGuestType.EnlargeGuestType_Double.ordinal()) goto L73;
        List r24 = com.bytedance.android.livesdk.chatroom.model.interact.b.a(r12);
        if (r24 == null) goto L69;
        r7 = Integer.valueOf(r24.size());
    L69:
        if (r7.intValue() > 1) goto L81;
        return "double_one";
    L81:
        return "double";
    L73:
        return "";
    L5:
        if (r9.intValue() != 26) goto L8;
        return "stable_double";
    }

    public static void o0(Map r4) {
        Intrinsics.checkNotNullParameter(r4, "logMap");
        HashMap r0 = new HashMap(r4);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_audience_voice_room_show_v3", r0, new Object[]{IRoom.class, am2.x.class});
    }

    public static void o1(String r7) {
        int r0 = je0.d.f();
        Integer r1 = je0.d.h();
        boolean r2 = false;
        if (r1 == null) goto L5;
        int r3 = r1.intValue();
    L6:
        String r4 = d;
        if (r4 != null) goto L10;
        r4 = "";
    L10:
        if (r2.a(r4) == false) goto L19;
        if (r3 == 0) goto L19;
        Map<r0, String> r5 = f;
        LinkedHashMap r6 = (LinkedHashMap) r5;
        CharSequence r8 = (CharSequence) r6.get(new r0(r0, r3));
        if (r8 != null) goto L15;
    L16:
        r2 = true;
    L17:
        if (r2 == false) goto L19;
        r5.put(new r0(r0, r3), r4);
        goto L19
    L15:
        if (StringsKt.isBlank(r8) == false) goto L17;
    L19:
        d = r7;
        return;
    L5:
        r3 = 0;
        goto L6
    }

    public static String s(DataCenter r2) {
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r3 = LinkUserDataMergeContext.a.b(LinkUserDataMergeContext.Companion, r2);
        int r0 = 0;
        if (r3 == null) goto L15;
        BehaviorSubject<List<ILinkPlayerInfoBridge>> r4 = r3.N0();
        if (r4 == null) goto L15;
        List r5 = (List) r4.getValue();
        if (r5 == null) goto L15;
        Iterator r6 = r5.iterator();
    L10:
        if (r6.hasNext() == false) goto L15;
        if (((ILinkPlayerInfoBridge) r6.next()).isEnlarged() == false) goto L10;
        r0 = r0 + 1;
    L15:
        if (r0 != 2) goto L17;
        return "0";
    L17:
        return "1";
    }

    @JvmStatic
    public static final boolean t0(int r1) {
        LivePlayModeLogContext.Companion.getClass();
        return LivePlayModeLogContext.access$getPlayModesSupportCrossFunctionTypes$cp().contains(Integer.valueOf(r1));
    }

    public static void t1(z5 r3) {
        Intrinsics.checkNotNullParameter(r3, "linkerDetail");
        ALogger.d("TalkRoomLogUtils", "update room, uiLayout " + r3.getUiLayout() + " play modes " + r3.getPlayModes());
        List r0 = r3.getPlayModes();
        if (r0 == null) goto L22;
        Iterator r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L22;
        int r2 = (int) ((Number) r1.next()).longValue();
        if (r2 != 8) goto L10;
    L15:
        boolean r4 = true;
    L16:
        if (r4 == true) goto L6;
        com.bytedance.live.datacontext.j r5 = com.bytedance.android.live.liveinteract.api.utils.m.d().J();
        if (r5 == null) goto L6;
        LivePlayModeLogContext r6 = (LivePlayModeLogContext) r5.getValue();
        if (r6 == null) goto L6;
        r6.addPlayMode(r2);
        goto L6
    L10:
        if (r2 == 9) goto L15;
        if (r2 == 10) goto L15;
        r4 = false;
    L22:
        x = u0.j(Integer.valueOf(r3.getUiLayout()));
    }

    @JvmStatic
    public static final void u0(Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r3, "logMap");
        com.bytedance.live.datacontext.m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r0 == null) goto L8;
        IRoom r1 = (IRoom) r0.getValue();
        if (r1 == null) goto L9;
        r3.put("anchor_id", r1.getOwnerUserIdString());
        r3.put("room_id", String.valueOf(r1.getId()));
        return;
    L9:
        return;
    }

    @JvmStatic
    public static final void v0(Map<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "logMap");
        rj0.l.n2.getClass();
        rj0.l r0 = rj0.l.a.a();
        if (r0 == null) goto L5;
        String r1 = r0.currentCPositionUserType();
    L21:
        HashMap r3 = (HashMap) r2;
        r3.put("current_enlarge_user_type", r1);
        r3.put("enlarge_open_from", String.valueOf(f()));
        return;
    L5:
        rj0.k.m2.getClass();
        rj0.k r4 = rj0.k.a.a();
        if (r4 == null) goto L8;
        r1 = r4.currentCPositionUserType();
        goto L21
    L8:
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r5 = IVoiceChatGuestService.a.a();
        if (r5 == null) goto L11;
        r1 = r5.currentCPositionUserType();
        goto L21
    L11:
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r6 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r6 == null) goto L14;
        r1 = r6.currentCPositionUserType();
        goto L21
    L14:
        IVoiceChatGuestService r7 = IVoiceChatGuestService.a.a();
        if (r7 == null) goto L17;
        r1 = r7.currentCPositionUserType();
        goto L21
    L17:
        com.bytedance.android.live.liveinteract.voicechat.d r8 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r8 == null) goto L20;
        r1 = r8.currentCPositionUserType();
        goto L21
    L20:
        r1 = "normal";
        goto L21
    }

    public static void w0(Map r2) {
        Intrinsics.checkNotNullParameter(r2, "logMap");
        if (((Boolean) b6.q.getValue()).booleanValue() == false) goto L5;
        String r0 = "on";
    L6:
        r2.put("link_distribute_switch_type", r0);
        return;
    L5:
        r0 = "off";
        goto L6
    }

    public static void x0(Map r4) {
        com.bytedance.live.datacontext.m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r0 == null) goto L29;
        IRoom r1 = (IRoom) r0.getValue();
        if (r1 == null) goto L30;
        Map r2 = r1.getAnchorABMap();
        if (r2 != null) goto L9;
    L16:
        int r3 = ((Number) vm2.d.S5.getValue(null, vm2.d.a[354(0x162, float:4.96E-43)])).intValue();
    L17:
        if (r3 == 0) goto L26;
        if (r3 != 1) goto L20;
    L25:
        String r5 = "video_fit";
    L27:
        r4.put("enlarge_show_type", r5);
        return;
    L20:
        if (r3 == 2) goto L25;
        if (r3 == 3) goto L24;
        r5 = "unknown";
        goto L27
    L24:
        r5 = "video_normal";
        goto L27
    L26:
        r5 = "normal";
        goto L27
    L9:
        if (r2.containsKey("linkmic_video_equal_enlarge_full") != true) goto L16;
        Map r6 = r1.getAnchorABMap();
        if (r6 == null) goto L15;
        String r7 = (String) r6.get("linkmic_video_equal_enlarge_full");
        if (r7 == null) goto L15;
        r3 = CastIntegerProtector.parseInt(r7);
    L15:
        r3 = 0;
        goto L17
    L30:
        return;
    }

    @JvmStatic
    public static final void B(String r6, List r7) {
        Intrinsics.checkNotNullParameter(r6, "requestPage");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("request_page", r6);
        int r8 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
        I0(r0, r8);
        B0(r0, Integer.valueOf(r8), null, 4);
        Integer r1 = Integer.valueOf(r8);
        List r2 = r7;
        if (r2 != null) goto L5;
    L8:
        boolean r5 = true;
    L9:
        D0(r0, r1, !r5);
        if (r8 == 0) goto L19;
        if (r2 != null) goto L13;
    L16:
        boolean r9 = true;
    L17:
        if (r9 == true) goto L19;
        a1(r0, r7);
        goto L19
    L13:
        if (r2.isEmpty() == true) goto L16;
        r9 = false;
    L19:
        Q0(r0);
        w0(r0);
        V0(r0);
        O0(r0);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_guest_connection_break_click", r0, new Object[]{am2.x.class, IRoom.class});
        return;
    L5:
        if (r2.isEmpty() == true) goto L8;
        r5 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge] */
    /* JADX WARN: Type inference failed for: r1v3 */
    public static boolean D(List r4, DataCenter r5) {
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r6 = LinkUserDataMergeContext.a.b(LinkUserDataMergeContext.Companion, r5);
        Object r0 = null;
        if (r6 == null) goto L20;
        BehaviorSubject<List<ILinkPlayerInfoBridge>> r7 = r6.N0();
        if (r7 == null) goto L20;
        List r8 = (List) r7.getValue();
        if (r8 == null) goto L20;
        Iterator r9 = r8.iterator();
    L10:
        if (r9.hasNext() == false) goto L18;
        Object r1 = r9.next();
        IBaseUser r2 = ((ILinkPlayerInfoBridge) r1).getUser();
        if (r2 == null) goto L14;
        String r3 = r2.getIdString();
    L16:
        if (Intrinsics.areEqual(r3, je0.d.a()) == false) goto L10;
    L19:
        ?? r10 = (ILinkPlayerInfoBridge) r1;
    L21:
        if (r10 != 0) goto L35;
        if (r4 == null) goto L34;
        Iterator r11 = r4.iterator();
    L25:
        if (r11.hasNext() == false) goto L33;
        Object r12 = r11.next();
        IBaseUser r13 = ((ILinkPlayerInfoBridge) r12).getUser();
        if (r13 == null) goto L29;
        String r14 = r13.getIdString();
    L31:
        if (Intrinsics.areEqual(r14, je0.d.a()) == false) goto L25;
        r0 = r12;
        goto L33
    L29:
        r14 = null;
    L33:
        r0 = (ILinkPlayerInfoBridge) r0;
    L34:
        r10 = r0;
    L35:
        if (r10 != 0) goto L37;
    L39:
        return false;
    L37:
        if (r10.isEnlarged() != true) goto L39;
        return true;
    L14:
        r3 = null;
        goto L16
    L18:
        r1 = null;
    L20:
        r10 = 0;
        goto L21
    }

    @JvmStatic
    public static final void F0(int r4, Map<String, String> r5) {
        Intrinsics.checkNotNullParameter(r5, "logMap");
        CPositionContext r0 = CPositionContext.Companion.getContext();
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.m<EnlargeGuestInfo> r1 = r0.getEnlargeGuestInfo();
        if (r1 == null) goto L9;
        EnlargeGuestInfo r2 = (EnlargeGuestInfo) r1.getValue();
        if (r2 == null) goto L9;
        Integer r3 = Integer.valueOf(r2.getEnlargeGuestType());
    L10:
        int r6 = EnlargeGuestInfo.EnlargeGuestType.EnlargeGuestType_Unkown.ordinal();
        if (r3 != null) goto L14;
    L16:
        int r7 = EnlargeGuestInfo.EnlargeGuestType.EnlargeGuestType_Single.ordinal();
        boolean r8 = true;
        if (r3 != null) goto L20;
    L23:
        int r9 = EnlargeGuestInfo.EnlargeGuestType.EnlargeGuestType_Double.ordinal();
        if (r3 != null) goto L27;
    L31:
        r8 = false;
    L32:
        if (r8 == false) goto L35;
        ((HashMap) r5).put("is_enlarge_seat", "1");
        return;
    L35:
        return;
    L27:
        if (r3.intValue() != r9) goto L31;
        if (r4 == 0) goto L32;
        if (r4 != 1) goto L31;
    L20:
        if (r3.intValue() != r7) goto L23;
        if (r4 != 0) goto L31;
    L14:
        if (r3.intValue() != r6) goto L16;
    L9:
        r3 = null;
        goto L10
    }

    @JvmStatic
    public static final void G0(int r4, Map<String, String> r5) {
        Intrinsics.checkNotNullParameter(r5, "logMap");
        CPositionContext r0 = CPositionContext.Companion.getContext();
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.m<EnlargeGuestInfo> r1 = r0.getEnlargeGuestInfo();
        if (r1 == null) goto L9;
        EnlargeGuestInfo r2 = (EnlargeGuestInfo) r1.getValue();
        if (r2 == null) goto L9;
        Integer r3 = Integer.valueOf(r2.getEnlargeGuestType());
    L10:
        int r6 = EnlargeGuestInfo.EnlargeGuestType.EnlargeGuestType_Unkown.ordinal();
        if (r3 != null) goto L14;
    L16:
        int r7 = EnlargeGuestInfo.EnlargeGuestType.EnlargeGuestType_Single.ordinal();
        boolean r8 = true;
        if (r3 != null) goto L20;
    L23:
        int r9 = EnlargeGuestInfo.EnlargeGuestType.EnlargeGuestType_Double.ordinal();
        if (r3 != null) goto L27;
    L42:
        r8 = false;
    L43:
        if (r8 == false) goto L46;
        ((HashMap) r5).put("is_enlarge", "1");
        return;
    L46:
        return;
    L27:
        if (r3.intValue() != r9) goto L42;
        com.bytedance.live.datacontext.m r10 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r10 == null) goto L39;
        IRoom r11 = (IRoom) r10.getValue();
        if (r11 == null) goto L39;
        if (r11.isLiveTypeAudio() != true) goto L39;
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.d() != 26) goto L42;
        if (r4 == 0) goto L43;
        if (r4 != 1) goto L42;
    L39:
        if (r4 == 0) goto L43;
        if (r4 != 1) goto L42;
    L20:
        if (r3.intValue() != r7) goto L23;
        if (r4 != 0) goto L42;
    L14:
        if (r3.intValue() != r6) goto L16;
    L9:
        r3 = null;
        goto L10
    }

    @JvmStatic
    public static final void I0(Map<String, String> r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "logMap");
        if (r5 != 1) goto L5;
    L17:
        r4.put("live_type", "video_live");
        return;
    L5:
        if (r5 != 12) goto L7;
        r4.put("live_type", "video_live");
        return;
    L7:
        if (r5 == 4) goto L17;
        if (r5 == 5) goto L15;
        switch(r5) {
            case 8: goto L14;
            case 9: goto L13;
            case 10: goto L12;
            default: goto L24;
        };
    L12:
        r4.put("live_type", "voice_live");
        return;
    L13:
        r4.put("live_type", "voice_live");
        return;
    L14:
        r4.put("live_type", "video_live");
        return;
    L24:
        return;
    L15:
        r4.put("live_type", "voice_live");
    }

    public static /* synthetic */ void J(String r1, int r2) {
        if ((r2 & 2) == 0) goto L5;
        r1 = null;
    L5:
        I(null, r1, "layout_type_close", null);
    }

    @JvmStatic
    public static final void P0(Map<String, String> r2, Integer r3) {
        Intrinsics.checkNotNullParameter(r2, "logMap");
        if (r3 != null) goto L6;
        return;
    L6:
        if (r3.intValue() != 1) goto L9;
        r2.put("pk_id", String.valueOf(jc1.k.n(IMultiLinkServiceExternal.class).getMultiDataHolderExternal().getPkId()));
        r2.put("is_in_pk", "1");
        return;
    }

    @JvmStatic
    public static final void T0(Map<String, String> r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "logMap");
        com.bytedance.android.livesdk.log.filter.o r2 = com.bytedance.android.livesdk.log.j0.l().c(am2.x.class);     // Catch: Exception -> L17
        if ((r2 instanceof com.bytedance.android.livesdk.log.filter.t) == true) goto L6;
        r2 = null;
    L6:
        com.bytedance.android.livesdk.log.filter.t r3 = (com.bytedance.android.livesdk.log.filter.t) r2;     // Catch: Exception -> L17
        if (r3 == null) goto L19;
        String r6 = r3.i();     // Catch: Exception -> L17
        if (r6 == null) goto L19;
        JSONObject r7 = s2.a(r6);     // Catch: Exception -> L17
        String r8 = r7.optString("video_id");     // Catch: Exception -> L17
        if (r8 == null) goto L13;
        r4.put("video_id", r8);     // Catch: Exception -> L17
    L13:
        String r1 = r7.optString("video_live_label");     // Catch: Exception -> L17
        if (r1 == null) goto L19;
        r4.put("video_live_label", r1);     // Catch: Exception -> L17
    L19:
        if (r5 == false) goto L28;
        com.bytedance.live.datacontext.n r9 = com.bytedance.android.live.liveinteract.api.utils.m.i().C2();
        if (r9 == null) goto L29;
        Integer r10 = (Integer) r9.getValue();
        if (r10 == null) goto L30;
        r4.put("order", String.valueOf(r10.intValue()));
        return;
    L30:
        return;
    L29:
        return;
    L28:
        return;
    L17:
        e = move-exception;
        ALogger.e("TalkRoomLogUtils", "can't parse json for relevant log", e);
        goto L19
    }

    @JvmStatic
    public static final void U0(Map<String, String> r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "logMap");
        if (r2 == null) goto L6;
        ((HashMap) r1).put("request_id", r2);
        return;
    }

    public static void W(boolean r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "cancelEnlargeUserType");
        LinkedHashMap r0 = new LinkedHashMap();
        J0(r0);
        B0(r0, null, null, 6);
        V0(r0);
        r0.put("current_enlarge_user_type", o(Integer.valueOf(b.a)));
        if (r3 == false) goto L5;
        String r5 = "anchor";
    L6:
        r0.put("user_type", r5);
        r0.put("cancel_enlarge_user_type", r4);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_live_anchor_enlarge_guest_cancel", r0, new Object[]{IRoom.class, am2.x.class});
        return;
    L5:
        r5 = "admin";
        goto L6
    }

    @JvmStatic
    public static final void W0(Map<String, String> r1, Boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "logMap");
        if (Intrinsics.areEqual(r2, Boolean.TRUE) == false) goto L5;
        String r3 = "on";
    L6:
        ((HashMap) r1).put("seat_fit_status", r3);
        return;
    L5:
        r3 = "off";
        goto L6
    }

    @JvmStatic
    public static final void X0(Map<String, String> r1, List<Integer> r2) {
        Intrinsics.checkNotNullParameter(r1, "logMap");
        if (com.bytedance.android.livesdk.chatroom.interact.model.d0.e(r2) == false) goto L5;
        String r3 = "on";
    L6:
        r1.put("seat_fit_status", r3);
        return;
    L5:
        r3 = "off";
        goto L6
    }

    @JvmStatic
    public static final void a(Map<String, String> r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "params");
        String r1 = "on";
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.v1.getValue()).booleanValue() == false) goto L5;
        Object r0 = "on";
    L6:
        HashMap r6 = (HashMap) r4;
        r6.put("admin_switch_type", r0);
        if (r5 == false) goto L18;
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.p1.getValue()).booleanValue() == false) goto L11;
        Object r7 = "on";
    L12:
        r6.put("fans_apply_switch_type", r7);
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.t1.getValue()).booleanValue() == true) goto L16;
        r1 = "off";
    L16:
        r6.put("apply_approve_switch_type", r1);
        return;
    L11:
        r7 = "off";
        goto L12
    L18:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.M0.getValue()).booleanValue() == false) goto L20;
        Object r8 = "on";
    L21:
        r6.put("fans_apply_switch_type", r8);
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.L0.getValue()).booleanValue() == true) goto L25;
        r1 = "off";
    L25:
        r6.put("apply_approve_switch_type", r1);
        return;
    L20:
        r8 = "off";
        goto L21
    L5:
        r0 = "off";
        goto L6
    }

    public static void a1(Map r7, List r8) {
        Intrinsics.checkNotNullParameter(r7, "logMap");
        Intrinsics.checkNotNullParameter(r8, "songList");
        StringBuilder r0 = new StringBuilder();
        StringBuilder r1 = new StringBuilder();
        Iterator r9 = r8.iterator();
        int r2 = 0;
    L4:
        if (r9.hasNext() == false) goto L15;
        Object r3 = r9.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        KtvMusic r5 = (KtvMusic) r3;
        if (r2 <= 0) goto L11;
        r0.append(",");
        r1.append(",");
    L11:
        r0.append(r5.getId());
        String r6 = r5.getTitle();
        if (r6 != null) goto L14;
        r6 = "";
    L14:
        r1.append(r6);
        r2 = r4;
        goto L4
    L15:
        r7.put("song_id", r0.toString());
        r7.put("song_name", r1.toString());
    }

    @JvmStatic
    public static final void b1(Map<String, String> r3, Integer r4) {
        Intrinsics.checkNotNullParameter(r3, "logMap");
        if (r4 != null) goto L6;
    L7:
        if (r4 != null) goto L10;
    L11:
        if (r4 != null) goto L14;
        return;
    L14:
        if (r4.intValue() != 5) goto L51;
    L15:
        com.bytedance.android.livesdk.sharedpref.e r5 = com.bytedance.android.livesdk.sharedpref.c.t0;
        Integer r0 = (Integer) r5.getValue();
        if (r0 != null) goto L19;
    L20:
        String r1 = "on";
    L22:
        HashMap r6 = (HashMap) r3;
        r6.put("reminder_type", r1);
        Integer r7 = (Integer) r5.getValue();
        if (r7 != null) goto L26;
    L28:
        if (r7 != null) goto L31;
    L33:
        if (r7 != null) goto L36;
    L38:
        if (r7 != null) goto L41;
    L43:
        if (r7 != null) goto L46;
    L48:
        String r8 = "";
    L49:
        r6.put("reminder_selection", r8);
        return;
    L46:
        if (r7.intValue() != 23) goto L48;
        r8 = "all";
        goto L49
    L41:
        if (r7.intValue() != 22) goto L43;
        r8 = "fans";
        goto L49
    L36:
        if (r7.intValue() != 21) goto L38;
        r8 = PbRequest.SwitchType.FANS_CLUB;
        goto L49
    L31:
        if (r7.intValue() != 20) goto L33;
        r8 = "follow";
        goto L49
    L26:
        if (r7.intValue() != 2) goto L28;
        r8 = "close";
        goto L49
    L19:
        if (r0.intValue() != 2) goto L20;
        r1 = "off";
        goto L22
    L51:
        return;
    L10:
        if (r4.intValue() == 8) goto L15;
    L6:
        if (r4.intValue() == 12) goto L15;
        goto L7
    }

    public static void d1(Map r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r3, "logMap");
        boolean r0 = Intrinsics.areEqual(com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor(), Boolean.TRUE);
        IInteractService r1 = (IInteractService) jc1.k.f(IInteractService.class);
        IVoiceLiveTheme r2 = null;
        if (r1 == null) goto L5;
        x00.a r5 = r1.getThemeManager(r0, r4);
    L6:
        if (r5 == null) goto L8;
        r2 = r5.q(r5.e());
    L8:
        if (r2 != null) goto L10;
        return;
    L10:
        if (r2.isUgcImage() != true) goto L12;
        String r6 = "0";
    L15:
        r3.put("template_id", r6);
        return;
    L12:
        r6 = String.valueOf(r2.getId());
        if (r6 != null) goto L15;
        r6 = "";
        goto L15
    L5:
        r5 = null;
        goto L6
    }

    @JvmStatic
    public static final void e1(Map<String, String> r3, IVoiceLiveTheme r4) {
        Intrinsics.checkNotNullParameter(r3, "logMap");
        if (r4 == null) goto L16;
        String r2 = "";
        if (r4.isUgcImage() != true) goto L7;
        String r0 = "0";
    L10:
        HashMap r5 = (HashMap) r3;
        r5.put("template_id", r0);
        String r6 = r4.getImageUri();
        if (r6 == null) goto L14;
        r2 = r6;
    L14:
        r5.put("pic_uri", r2);
        return;
    L7:
        r0 = String.valueOf(r4.getId());
        if (r0 != null) goto L10;
        r0 = "";
        goto L10
    }

    @JvmStatic
    public static final void f1(Map<String, String> r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "logMap");
        if (r3 != UserType.ANCHOR.getValue()) goto L6;
        ((HashMap) r2).put("to_user_type", "anchor");
        return;
    L6:
        if (r3 != UserType.AUDIENCE.getValue()) goto L9;
        ((HashMap) r2).put("to_user_type", "link_user");
        return;
    L9:
        if (r3 != UserType.GUEST.getValue()) goto L14;
        ((HashMap) r2).put("to_user_type", "guest");
        return;
    }

    @JvmStatic
    public static final void g1(Map<String, String> r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "logMap");
        Intrinsics.checkNotNullParameter(r2, "uid");
        if (E() == true) goto L5;
    L7:
        String r3 = "0";
    L8:
        r1.put("is_audience_enlarged_currently", r3);
        r1.put("enlarge_open_from", String.valueOf(f()));
        return;
    L5:
        if (je0.d.j0(r2) == false) goto L7;
        r3 = "1";
        goto L8
    }

    @JvmStatic
    public static final void h0(int r6, int r7) {
        HashMap r0 = new HashMap();
        J0(r0);
        String r1 = "party_room";
        if (r6 == 8) goto L7;
        if (r6 != 12) goto L7;
        Object r8 = "party_room";
    L8:
        r0.put("before_function", r8);
        if (r7 == 8) goto L11;
        if (r7 != 12) goto L11;
    L12:
        r0.put("interact_function", r1);
        if (r2.a(e) == false) goto L15;
        String r9 = e;
        Intrinsics.checkNotNull(r9);
        r0.put("request_page", r9);
    L16:
        com.bytedance.android.livesdk.log.j0.l().sendLog("anchor_switch_room_type", r0, new Object[]{IRoom.class, am2.x.class});
        e = null;
        return;
    L15:
        r0.put("request_page", "link_setting_panel");
    L11:
        r1 = "chat_room";
    L7:
        r8 = "chat_room";
        goto L8
    }

    @JvmStatic
    public static final void h1(Map<String, String> r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "logMap");
        Intrinsics.checkNotNullParameter(r2, "uid");
        if (E() == true) goto L5;
    L7:
        String r3 = "0";
    L8:
        r1.put("is_audience_enlarged_currently", r3);
        r1.put("enlarge_open_from", String.valueOf(f()));
        return;
    L5:
        if (je0.d.j0(r2) == false) goto L7;
        r3 = "1";
        goto L8
    }

    @JvmStatic
    public static final void i0(IVoiceLiveTheme r13, int r14) {
        LinkedHashMap r0 = new LinkedHashMap();
        String r1 = "";
        if (r13 != null) goto L5;
    L7:
        if (r13 == null) goto L10;
        String r3 = String.valueOf(r13.getId());
        if (r3 == null) goto L10;
    L11:
        r0.put("template_id", r3);
        if (r13 == null) goto L15;
        String r4 = r13.getImageUri();
        if (r4 == null) goto L15;
    L16:
        r0.put("pic_uri", r4);
        Long r5 = null;
        if (r13 == null) goto L19;
        Integer r6 = Integer.valueOf(r13.getFormatType());
    L21:
        if (r6 != null) goto L24;
    L26:
        if (r6 != null) goto L29;
    L31:
        r0.put("pic_type", r1);
        if (r14 == 1) goto L54;
        if (r14 != 2) goto L35;
        r0.put("live_type", "voice_live");
        r0.put("function_type", "radio");
        r0.put("function_type2", "radio");
        com.bytedance.live.datacontext.m r15 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r15 == null) goto L50;
        IRoom r16 = (IRoom) r15.getValue();
    L52:
        if (com.bytedance.android.livesdk.chatroom.interact.model.d0.h(r16) == false) goto L55;
        r0.put("function_type", "party");
        r0.put("function_type2", "party");
    L55:
        r0.put("play_mode", u0.b());
        r0.put("function_type2", h);
        if (r13 == null) goto L58;
        r5 = Long.valueOf(r13.getId());
    L58:
        r0.put("template_id", String.valueOf(r5));
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_live_theme_show", r0, new Object[]{IRoom.class, am2.x.class});
        ALogger.d("TalkRoomLogUtils", "logThemeShow:" + CollectionsKt.joinToString$default(r0.entrySet(), null, null, null, 0, null, null, 63, null));
        return;
    L50:
        r16 = null;
        goto L52
    L35:
        if (r14 != 3) goto L37;
        r0.put("live_type", "video_live");
        r0.put("function_type", "radio");
        r0.put("function_type2", h);
        goto L55
    L37:
        if (r14 != 4) goto L39;
        r0.put("live_type", "video_live");
        r0.put("function_type", "ktv");
        r0.put("function_type2", h);
        goto L55
    L39:
        if (r14 != 5) goto L41;
        r0.put("live_type", "voice_live");
        r0.put("function_type", "live");
        r0.put("function_type2", "radio");
        goto L55
    L41:
        if (r14 != 100) goto L55;
        r0.put("live_type", "voice_live");
        r0.put("function_type", "chorus");
        r0.put("function_type2", "chorus");
        goto L55
    L54:
        r0.put("live_type", "voice_live");
        r0.put("function_type", "ktv");
        r0.put("function_type2", "radio");
        goto L55
    L29:
        if (r6.intValue() != 2) goto L31;
        r1 = "dynamic";
        goto L31
    L24:
        if (r6.intValue() != 1) goto L26;
        r1 = "static";
        goto L31
    L19:
        r6 = null;
    L15:
        r4 = "";
    L10:
        r3 = "";
        goto L11
    L5:
        if (r13.isUgcImage() != true) goto L7;
        r3 = "0";
        goto L11
    }

    public static void j1(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "requestPage");
        LinkedHashMap r0 = new LinkedHashMap();
        if (r5 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == true) goto L11;
        r5 = null;
    L11:
        if (r5 == null) goto L13;
        r0.put("to_user_id", r5);
    L13:
        r0.put("request_page", r4);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_guest_return_gift_icon_click", r0, new Object[]{am2.x.class, IRoom.class});
        return;
    L5:
        if (r2.a(r5) != true) goto L7;
        r3 = true;
        goto L8
    }

    public static void k1(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "requestPage");
        LinkedHashMap r0 = new LinkedHashMap();
        if (r5 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == true) goto L11;
        r5 = null;
    L11:
        if (r5 == null) goto L13;
        r0.put("to_user_id", r5);
    L13:
        r0.put("request_page", r4);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_guest_return_gift_icon_show", r0, new Object[]{am2.x.class, IRoom.class});
        return;
    L5:
        if (r2.a(r5) != true) goto L7;
        r3 = true;
        goto L8
    }

    public static void m1(String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "anchorId");
        HashMap r0 = new HashMap();
        if (r4 == false) goto L5;
        String r5 = "click";
    L6:
        r0.put("action_type", r5);
        r0.put("anchor_id", r3);
        IInteractService r6 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r6 == null) goto L11;
        String r7 = r6.getCurrentFunctionType();
        if (r7 == null) goto L11;
        String r8 = (String) r0.put("function_type", r7);
    L11:
        String r9 = ((IInteractService) jc1.k.n(IInteractService.class)).getFunctionType2();
        if (r9 == null) goto L14;
        r0.put("function_type2", r9);
    L14:
        R0(r0);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_audience_associated_apply_entry", r0, new Object[]{IRoom.class, am2.x.class});
        return;
    L5:
        r5 = "show";
        goto L6
    }

    public static void p0(Map r4, Long r5) {
        Intrinsics.checkNotNullParameter(r4, "logMap");
        if (r5 == null) goto L16;
        r5.longValue();
        HashMap r0 = new HashMap(r4);
        r0.put("duration", String.valueOf(r5.longValue()));
        com.bytedance.live.datacontext.m r6 = com.bytedance.android.live.liveinteract.api.utils.m.i().X1();
        if (r6 != null) goto L7;
    L8:
        com.bytedance.live.datacontext.m r7 = com.bytedance.android.live.liveinteract.api.utils.m.i().n2();
        if (r7 != null) goto L11;
    L13:
        String r8 = "off";
    L14:
        r0.put("earphone_status", r8);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_voice_room_watch_duration_v2", r0, new Object[]{IRoom.class, am2.x.class});
        return;
    L11:
        if (((Boolean) r7.getValue()).booleanValue() != true) goto L13;
    L12:
        r8 = "on";
        goto L14
    L7:
        if (((Boolean) r6.getValue()).booleanValue() == true) goto L12;
    L16:
        ALogger.e("TalkRoomLogUtils", "logVoiceRoomWatchDurationV2WhenSwitch error, duration is null!");
    }

    public static void q0(Map r4, Long r5) {
        Intrinsics.checkNotNullParameter(r4, "logMap");
        if (r5 == null) goto L16;
        r5.longValue();
        HashMap r0 = new HashMap(r4);
        r0.put("duration", String.valueOf(r5.longValue()));
        com.bytedance.live.datacontext.m r6 = com.bytedance.android.live.liveinteract.api.utils.m.i().X1();
        if (r6 != null) goto L7;
    L8:
        com.bytedance.live.datacontext.m r7 = com.bytedance.android.live.liveinteract.api.utils.m.i().n2();
        if (r7 != null) goto L11;
    L13:
        String r8 = "off";
    L14:
        r0.put("earphone_status", r8);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_voice_room_watch_duration_v3", r0, new Object[]{IRoom.class, am2.x.class});
        return;
    L11:
        if (((Boolean) r7.getValue()).booleanValue() != true) goto L13;
    L12:
        r8 = "on";
        goto L14
    L7:
        if (((Boolean) r6.getValue()).booleanValue() == true) goto L12;
    L16:
        ALogger.e("TalkRoomLogUtils", "logVoiceRoomWatchDurationV3WhenSwitch error, duration is null!");
    }

    @JvmStatic
    public static final void q1(String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "connectionType");
        HashMap r0 = new HashMap();
        r0.put("connection_type", r3);
        if (r4 == false) goto L5;
        String r5 = "open";
    L6:
        r0.put("is_open", r5);
        r0.put("_param_live_platfom", "live");
        r0.put("event_belong", "live");
        r0.put("local_time_ms", String.valueOf(System.currentTimeMillis()));
        B0(r0, Integer.valueOf(((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene()), null, 4);
        Q0(r0);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_admin_authorization_switch_use", r0, new Object[]{am2.x.class, IRoom.class});
        return;
    L5:
        r5 = "close";
        goto L6
    }

    public static void s1(int r1, boolean r2) {
        if (r2 == false) goto L4;
        b.b = 0;
    L5:
        b.a = r1;
        return;
    L4:
        h r3 = b;
        r3.b = r3.a;
        goto L5
    }

    public static String w(int r2, LinkApplyType r3) {
        int r0 = bh0.a.a;
        if (r2 != 101) goto L6;
        return "seat";
    L6:
        if (r2 != 102) goto L9;
        return "bottom";
    L9:
        if (r2 != 103) goto L12;
        return "popup";
    L12:
        if (r2 != 110) goto L15;
        return "task";
    L15:
        if (r2 != 111) goto L18;
        return "top";
    L18:
        if (r2 != 113) goto L21;
        return "card";
    L21:
        if (r2 != 112) goto L24;
        return "apply_panel";
    L24:
        if (r2 != 104) goto L27;
        return "seat_popup";
    L27:
        if (r2 != 109) goto L30;
        return "emoji_panel";
    L30:
        if (r2 != 108) goto L33;
        return "pre_link_seat";
    L33:
        if (r2 != 114) goto L38;
        if (r3 == LinkApplyType.KTV_MULTI_CHORUS) goto L48;
    L49:
        return "live_song";
    L48:
        return "live_chorus";
    L38:
        if (r2 != 115) goto L41;
        return "associated_apply";
    L41:
        if (r2 != 116) goto L44;
        return "associated_invite";
    L44:
        if (tc0.c.h().J == 114) goto L47;
        return null;
    L47:
        if (r3 != LinkApplyType.KTV_MULTI_CHORUS) goto L49;
        goto L48
    }

    public static void y0(Map r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r7, "logMap");
        com.bytedance.android.livesdk.log.filter.o r0 = com.bytedance.android.livesdk.log.j0.l().c(am2.x.class);
        String r2 = null;
        if ((r0 instanceof com.bytedance.android.livesdk.log.filter.t) == true) goto L5;
        r0 = null;
    L5:
        com.bytedance.android.livesdk.log.filter.t r1 = (com.bytedance.android.livesdk.log.filter.t) r0;
        if (r1 != null) goto L8;
        return;
    L8:
        String r3 = r1.f();
        boolean r4 = true;
        if (r3 != null) goto L11;
    L14:
        boolean r5 = true;
    L15:
        if (r5 == false) goto L18;
        r3 = null;
    L18:
        if (r3 == null) goto L20;
        r7.put("from_user_id", r3);
    L21:
        String r6 = r1.A();
        if (r6 != null) goto L24;
    L27:
        boolean r9 = true;
    L28:
        if (r9 == false) goto L31;
        r6 = null;
    L31:
        if (r6 == null) goto L33;
        r7.put("from_user_type", r6);
    L33:
        String r10 = r1.p();
        if (r10 != null) goto L36;
    L39:
        boolean r11 = true;
    L40:
        if (r11 == false) goto L43;
        r10 = null;
    L43:
        if (r10 == null) goto L45;
        r7.put("distribute_source", r10);
    L45:
        if (r8 == false) goto L56;
        String r12 = r1.l();
        if (r12 == null) goto L53;
        if (r12.length() == 0) goto L53;
        r4 = false;
    L53:
        if (r4 == false) goto L55;
        r7.put("invite_type", "in_room");
        goto L56
    L55:
        r7.put("invite_type", "out_room");
    L56:
        if (r3 == null) goto L64;
        String r13 = r1.l();
        if (r13 == null) goto L61;
        r2 = r13.toLowerCase(Locale.getDefault());
    L61:
        if (Intrinsics.areEqual(r2, "true") == false) goto L65;
        r7.put("request_page", "link_user_invite");
        r7.put("connect_type", "invite_mutual");
        r7.put("guest_connection_type", "live_chat");
        return;
    L65:
        return;
    L64:
        return;
    L36:
        if (r10.length() == 0) goto L39;
        r11 = false;
        goto L40
    L24:
        if (r6.length() == 0) goto L27;
        r9 = false;
        goto L28
    L20:
        r3 = null;
        goto L21
    L11:
        if (r3.length() == 0) goto L14;
        r5 = false;
        goto L15
    }

    public final void T(boolean r9, DataCenter r10) {
        LinkedHashMap r0 = new LinkedHashMap();
        J0(r0);
        B0(r0, null, null, 6);
        V0(r0);
        h r1 = b;
        r0.put("current_enlarge_user_type", o(Integer.valueOf(r1.a)));
        if (r1.a != 26) goto L5;
        r0.put("is_empty_enlarge_seat", s(r10));
    L5:
        r0.put("action_type", "default_accept");
        r0.put("seat_num", String.valueOf(je0.d.R()));
        com.bytedance.live.datacontext.m r2 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r2 == null) goto L10;
        IRoom r3 = (IRoom) r2.getValue();
        if (r3 == null) goto L10;
        String r4 = r3.getOwnerUserIdString();
    L11:
        String r5 = je0.d.b0();
        String r6 = "anchor";
        if (Intrinsics.areEqual(r5, r4) == false) goto L14;
        Object r7 = "anchor";
    L15:
        r0.put("user_type", r7);
        r0.put("enlarge_user_id", r5.toString());
        if (Intrinsics.areEqual(r5, r4) == true) goto L19;
        r6 = "guest";
    L19:
        r0.put("enlarge_user_type", r6);
        r0.put("enlarge_open_from", String.valueOf(f()));
        if (je0.d.f() != 12) goto L23;
        x0(r0);
    L23:
        if (r9 == false) goto L25;
        r0.put("is_double", "1");
    L27:
        if (D(null, r10) == false) goto L29;
        r0.put("is_anchor_enlarge", "1");
    L30:
        Integer r11 = je0.d.h();
        if (r11 != null) goto L34;
    L36:
        String r12 = "classic";
    L37:
        r0.put("play_layout", r12);
        HamletAvatarContext r13 = HamletAvatarContext.Companion.getContext();
        if (r13 == null) goto L46;
        com.bytedance.live.datacontext.j<gd0.g> r14 = r13.getHamletAvatarService();
        if (r14 == null) goto L46;
        gd0.g r15 = (gd0.g) r14.getValue();
        if (r15 == null) goto L46;
        Long r16 = r15.Ue();
        if (r16 == null) goto L46;
        r0.put("avatar_id", String.valueOf(r16.longValue()));
    L46:
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_live_guest_enlarge_open_success", r0, new Object[]{IRoom.class, am2.x.class});
        return;
    L34:
        if (r11.intValue() != 28) goto L36;
        r12 = "avatar";
        goto L37
    L29:
        r0.put("is_anchor_enlarge", "0");
        goto L30
    L25:
        r0.put("is_double", "0");
        goto L27
    L14:
        r7 = "guest";
    L10:
        r4 = null;
        goto L11
    }

    @JvmStatic
    public static final void A0(Map<String, String> r2, Integer r3, Integer r4) {
        Intrinsics.checkNotNullParameter(r2, "logMap");
        if (vm2.d.v0() == false) goto L5;
        r2.put("function_type", h);
    L13:
        r2.put("function_type2", h);
        return;
    L5:
        if (r3 != null) goto L7;
    L12:
        r2.put("function_type", h);
        goto L13
    L7:
        if (r3.intValue() == 0) goto L12;
        String r5 = p(r3, r4, null);
        if (r5 != null) goto L11;
        r5 = "";
    L11:
        r2.put("function_type", r5);
        goto L13
    }

    @JvmStatic
    public static final void D0(Map<String, String> r2, Integer r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "logMap");
        if (r3 != null) goto L6;
    L9:
        r2.put("guest_connection_type", "live_chat");
        return;
    L6:
        if (r3.intValue() != 9) goto L9;
        if (r4 == false) goto L9;
        r2.put("guest_connection_type", "live_song");
    }

    public static void K(Integer r8, Map r9, int r10) {
        Set r1 = null;
        if ((r10 & 4) == 0) goto L6;
        r8 = null;
    L6:
        if ((r10 & 8) == 0) goto L8;
        r9 = null;
    L8:
        HashMap r11 = new HashMap();
        u0(r11);
        J0(r11);
        B0(r11, null, null, 6);
        String r0 = d;
        if (r0 == null) goto L11;
        r11.put("source", r0);
    L11:
        Map<Integer, String> r2 = g;
        if (r8 == null) goto L14;
        int r3 = r8.intValue();
    L15:
        Integer r4 = Integer.valueOf(r3);
        String r5 = d;
        if (r5 != null) goto L18;
        r5 = "";
    L18:
        r2.put(r4, r5);
        if (r9 == null) goto L24;
        Iterator r12 = r9.entrySet().iterator();
    L22:
        if (r12.hasNext() == false) goto L24;
        Map.Entry r6 = (Map.Entry) r12.next();
        r11.put(r6.getKey(), r6.getValue());
    L24:
        r11.put("is_link_room", s);
        xi0.a r13 = ((IInteractService) jc1.k.n(IInteractService.class)).linkRoomFightService();
        if (r13 == null) goto L27;
        Boolean r14 = Boolean.valueOf(r13.isFightShowing());
    L28:
        xi0.a r7 = ((IInteractService) jc1.k.n(IInteractService.class)).linkRoomFightService();
        if (r7 == null) goto L31;
        r7.L1();
    L31:
        ALogger.i("livesdk_anchor_playmode_open_success", "scene:" + je0.d.f() + ",showing:" + r14 + ",isLinkRoomOpen:" + s);
        zi0.d.b(r11, false);
        if (r8 == null) goto L34;
        r11.put("play_mode", u0.k(r8.intValue()));
        t.put(r8, Long.valueOf(System.currentTimeMillis()));
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_anchor_playmode_open_success", r11, new Object[]{IRoom.class, am2.x.class});
        return;
    L34:
        com.bytedance.live.datacontext.j r15 = com.bytedance.android.live.liveinteract.api.utils.m.d().J();
        if (r15 == null) goto L41;
        LivePlayModeLogContext r16 = (LivePlayModeLogContext) r15.getValue();
        if (r16 == null) goto L41;
        com.bytedance.live.datacontext.m r17 = r16.getPlayModes();
        if (r17 == null) goto L41;
        r1 = (Set) r17.getValue();
    L41:
        if (r1 == null) goto L56;
        Iterator r18 = r1.iterator();
    L45:
        if (r18.hasNext() == false) goto L57;
        int r19 = ((Number) r18.next()).intValue();
        if (t0(r19) == false) goto L45;
        r11.put("play_mode", u0.k(r19));
        t.put(Integer.valueOf(r19), Long.valueOf(System.currentTimeMillis()));
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_anchor_playmode_open_success", r11, new Object[]{IRoom.class, am2.x.class});
        goto L45
    L57:
        return;
    L56:
        return;
    L27:
        r14 = null;
        goto L28
    L14:
        r3 = 0;
        goto L15
    }

    @JvmStatic
    public static final void N0(Map<String, String> r9, String r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r9, "logMap");
        com.bytedance.android.livesdk.log.filter.t r0 = com.bytedance.android.livesdk.log.j0.l().c(am2.x.class);
        if (r0 != null) goto L5;
    L15:
        int r1 = bh0.a.a;
        if (TextUtils.equals(String.valueOf(com.bytedance.android.live.liveinteract.multianchor.model.b.TYPE_CANCELED_BY_SERVER), r10) == true) goto L18;
        return;
    L18:
        String r8 = "";
        if (r11 == false) goto L34;
        String r12 = hk0.a.a.get("age");
        if (r12 != null) goto L23;
        r12 = "";
    L23:
        HashMap r13 = (HashMap) r9;
        r13.put("age_tag", r12);
        String r14 = hk0.a.a.get("gender");
        if (r14 != null) goto L26;
        r14 = "";
    L26:
        r13.put("gender_tag", r14);
        String r15 = hk0.a.a.get("location");
        if (r15 != null) goto L29;
        r15 = "";
    L29:
        r13.put("location_tag", r15);
        String r16 = hk0.a.a.get("challenge");
        if (r16 == null) goto L33;
        r8 = r16;
    L33:
        r13.put("challenge_tag", r8);
        r13.put("link_cnt_tag", String.valueOf(hk0.a.c));
        return;
    L34:
        String r17 = hk0.a.b.get("age");
        if (r17 != null) goto L37;
        r17 = "";
    L37:
        HashMap r18 = (HashMap) r9;
        r18.put("age_tag", r17);
        String r19 = hk0.a.b.get("gender");
        if (r19 != null) goto L40;
        r19 = "";
    L40:
        r18.put("gender_tag", r19);
        String r110 = hk0.a.b.get("location");
        if (r110 != null) goto L43;
        r110 = "";
    L43:
        r18.put("location_tag", r110);
        String r111 = hk0.a.b.get("challenge");
        if (r111 == null) goto L47;
        r8 = r111;
    L47:
        r18.put("challenge_tag", r8);
        r18.put("link_cnt_tag", String.valueOf(hk0.a.d));
        return;
    L5:
        if ((r0 instanceof com.bytedance.android.livesdk.log.filter.t) == false) goto L15;
        String r2 = r0.getMatchType();
        if (r2 != null) goto L9;
    L12:
        boolean r3 = true;
    L13:
        if (r3 == false) goto L15;
        return;
    L9:
        if (r2.length() == 0) goto L12;
        r3 = false;
        goto L13
    }

    @JvmStatic
    public static final void P(String r6, String r7, String r8) {
        if (v > 0) goto L5;
        return;
    L5:
        HashMap r0 = new HashMap();
        u0(r0);
        J0(r0);
        if (r6 == null) goto L8;
        r0.put("function_type", r6);
        r0.put("function_type2", r6);
    L9:
        if (r7 == null) goto L11;
        r0.put("layout_type", r7);
    L11:
        if (r8 == null) goto L13;
        r0.put("enlarge_show_type", r8);
    L13:
        r0.put("duration", String.valueOf((System.currentTimeMillis() - v) / ((long) 1000)));
        v = 0;
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_voice_room_layout_watch_duration", r0, new Object[]{IRoom.class, am2.x.class});
        return;
    L8:
        B0(r0, null, null, 6);
        goto L9
    }

    public static /* synthetic */ void Q(String r2, String r3, int r4) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = null;
    L8:
        P(null, r2, r3);
    }

    @JvmStatic
    public static final void R(String r2, String r3, String r4) {
        HashMap r0 = new HashMap();
        u0(r0);
        J0(r0);
        if (r2 == null) goto L5;
        r0.put("function_type", r2);
    L6:
        if (r3 == null) goto L8;
        r0.put("layout_type", r3);
    L8:
        if (r4 == null) goto L10;
        r0.put("enlarge_show_type", r4);
    L10:
        v = System.currentTimeMillis();
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_audience_room_layout_show", r0, new Object[]{IRoom.class, am2.x.class});
        return;
    L5:
        B0(r0, null, null, 6);
        goto L6
    }

    public static /* synthetic */ void S(String r2, String r3, int r4) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = null;
    L8:
        R(null, r2, r3);
    }

    public static void S0(HashMap r3, int r4, int r5) {
        fj0.a r0 = fj0.b.a;
        int r1 = r0.h;
        int r2 = r0.i;
        if (r5 != 1) goto L6;
        int r6 = r4 - r1;
    L12:
        if (r6 < 0) goto L14;
        String r7 = String.valueOf(r6);
    L15:
        r3.put("pay_price", r7);
        return;
    L14:
        r7 = "0";
        goto L15
    L6:
        if (r5 != 2) goto L8;
    L11:
        r6 = r4 - r2;
        goto L12
    L8:
        if (r5 == 3) goto L11;
        r6 = 0;
        goto L12
    }

    @JvmStatic
    public static final void V(long r4, long r6, int r8) {
        LinkedHashMap r0 = new LinkedHashMap();
        int r1 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
        if (r8 != 0) goto L6;
        r8 = r1;
    L6:
        B0(r0, Integer.valueOf(r8), null, 4);
        I0(r0, r1);
        r0.put("total_apply_cnt", String.valueOf(r4));
        r0.put("total_link_cnt", String.valueOf(r6));
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_anchor_audience_connection_link_data_collection", r0, new Object[]{IRoom.class});
    }

    public static void X(boolean r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "targetUserId");
        Intrinsics.checkNotNullParameter(r6, "enlargeType");
        LinkedHashMap r0 = new LinkedHashMap();
        J0(r0);
        String r2 = null;
        B0(r0, null, null, 6);
        V0(r0);
        r0.put("current_enlarge_user_type", o(Integer.valueOf(b.a)));
        String r1 = "anchor";
        if (r4 == false) goto L5;
        String r7 = "anchor";
    L6:
        r0.put("user_type", r7);
        r0.put("enlarge_user_id", r5.toString());
        com.bytedance.live.datacontext.m r8 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r8 == null) goto L12;
        IRoom r9 = (IRoom) r8.getValue();
        if (r9 == null) goto L12;
        r2 = r9.getOwnerUserIdString();
    L12:
        if (Intrinsics.areEqual(r2, r5) == true) goto L15;
        r1 = "guest";
    L15:
        r0.put("enlarge_user_type", r1);
        r0.put("enlarge_type", r6);
        Integer r10 = je0.d.h();
        if (r10 != null) goto L19;
    L21:
        String r11 = "classic";
    L22:
        r0.put("play_layout", r11);
        zi0.d.b(r0, false);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_live_anchor_enlarge_guest_invite", r0, new Object[]{IRoom.class, am2.x.class});
        return;
    L19:
        if (r10.intValue() != 28) goto L21;
        r11 = "avatar";
        goto L22
    L5:
        r7 = "admin";
        goto L6
    }

    @JvmStatic
    public static final void d(String r3, String r4, long r5) {
        Intrinsics.checkNotNullParameter(r3, "userId");
        Intrinsics.checkNotNullParameter(r4, "userType");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("user_id", r3.toString());
        r0.put("user_type", r4);
        int r6 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
        I0(r0, r6);
        B0(r0, Integer.valueOf(r6), null, 4);
        Q0(r0);
        V0(r0);
        w0(r0);
        r0.put("user_cnt", String.valueOf(je0.d.S()));
        if (GuestBattleContext.Companion.e() == false) goto L5;
        r0.put("game_name", "bomb");
    L5:
        g1(r0, r3);
        if (r5 <= 0) goto L8;
        r0.put("tag_type", String.valueOf(r5));
    L8:
        Integer r7 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r7 != null) goto L12;
    L14:
        String r8 = "0";
    L15:
        r0.put("is_user_guest", r8);
        r0.put("act_user_type", y());
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_seat_head_click", r0, new Object[]{am2.x.class, IRoom.class});
        return;
    L12:
        if (r7.intValue() != 2) goto L14;
        r8 = "1";
        goto L15
    }

    public static void h(String r6, String r7, List r8) {
        Intrinsics.checkNotNullParameter(r6, "applicantId");
        Intrinsics.checkNotNullParameter(r7, "interruptType");
        HashMap r0 = new HashMap();
        r0.put("applicant_id", r6.toString());
        r0.put("interrupt_type", r7);
        r0.put("user_type", u());
        int r9 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
        B0(r0, Integer.valueOf(r9), null, 4);
        I0(r0, r9);
        Integer r1 = Integer.valueOf(r9);
        List r2 = r8;
        if (r2 != null) goto L5;
    L8:
        boolean r5 = true;
    L9:
        D0(r0, r1, !r5);
        if (r9 == 0) goto L19;
        if (r2 != null) goto L13;
    L16:
        boolean r3 = true;
    L17:
        if (r3 == true) goto L19;
        a1(r0, r8);
        goto L19
    L13:
        if (r2.isEmpty() == true) goto L16;
        r3 = false;
    L19:
        Q0(r0);
        P0(r0, Integer.valueOf(r9));
        H0(r0);
        h r10 = b;
        if (r10.a == 26) goto L22;
    L25:
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_anchor_audience_connection_interrupt", r0, new Object[]{am2.x.class, IRoom.class});
        return;
    L22:
        if (r10.c.contains(r6) == false) goto L24;
        r0.put("is_enlarge_seat", "1");
        goto L25
    L24:
        r0.put("is_enlarge_seat", "0");
        goto L25
    L5:
        if (r2.isEmpty() == true) goto L8;
        r5 = false;
        goto L9
    }

    @JvmStatic
    public static final void j0(boolean r5, boolean r6, boolean r7) {
        Intrinsics.checkNotNullParameter("audience_link_setting", "requestPage");
        LinkedHashMap r0 = new LinkedHashMap();
        J0(r0);
        B0(r0, null, null, 6);
        if (r5 == false) goto L5;
        V0(r0);
    L5:
        String r2 = "1";
        if (r5 == false) goto L8;
        Object r8 = "1";
    L9:
        r0.put("is_guest_apply_allowed", r8);
        if (r6 == false) goto L12;
        Object r9 = "1";
    L13:
        r0.put("is_fans_only", r9);
        if (r7 == true) goto L17;
        r2 = "0";
    L17:
        r0.put("is_invite_only", r2);
        r0.put("request_page", "audience_link_setting");
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_anchor_link_setting_change_success", r0, new Object[]{IRoom.class});
        return;
    L12:
        r9 = "0";
        goto L13
    L8:
        r8 = "0";
        goto L9
    }

    @JvmStatic
    public static final void k0(int r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "requestPage");
        Intrinsics.checkNotNullParameter(r6, "source");
        LinkedHashMap r1 = new LinkedHashMap();
        J0(r1);
        B0(r1, null, null, 6);
        V0(r1);
        r1.put("playmode_type", String.valueOf(r4));
        r1.put("request_page", r5);
        r1.put("source", r6);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_live_function_interact_playmode_panel_item_click", r1, new Object[]{IRoom.class});
    }

    @JvmStatic
    public static final void l(boolean r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "requestPage");
        LinkedHashMap r0 = new LinkedHashMap();
        if (r2 == false) goto L6;
        String r5 = "anchor";
    L9:
        r0.put("user_type", r5);
        r0.put("user_id", jc1.k.n(IMiddlewareUserService.class).user().n());
        r0.put("request_page", r3);
        if (r4 == false) goto L12;
        String r6 = "self";
    L13:
        r0.put("interact_type", r6);
        int r7 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
        I0(r0, r7);
        B0(r0, Integer.valueOf(r7), null, 4);
        Q0(r0);
        P0(r0, Integer.valueOf(r7));
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_chat_emoji_panel_show", r0, new Object[]{am2.x.class, IRoom.class});
        return;
    L12:
        r6 = "others";
        goto L13
    L6:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.b0.a() == false) goto L8;
        r5 = "pre_link";
        goto L9
    L8:
        r5 = "guest";
        goto L9
    }

    public static void m0(IRoom r6, long r7, long r9) {
        if (r6 != null) goto L5;
        ALogger.e("TalkRoomLogUtils", "logVoiceRoomShowV2 error, room is null!");
        return;
    L5:
        HashMap r0 = new HashMap();
        String r1 = ((IInteractService) jc1.k.n(IInteractService.class)).getLiveTypeForLog();
        if (r1 != null) goto L8;
    L13:
        z5 r2 = r6.getLinkerDetail();
        if (r2 == null) goto L18;
        String r3 = r2.getFunctionType2();
        if (r3 == null) goto L18;
        r0.put("function_type", r3);
        r0.put("function_type2", r3);
    L18:
        r0.put("play_mode", u0.c(r6));
        z5 r4 = r6.getLinkerDetail();
        if (r4 == null) goto L24;
        String r5 = u0.j(Integer.valueOf(r4.getUiLayout()));
        if (r5 != null) goto L23;
        r5 = "";
    L23:
        r0.put("layout_type", r5);
    L24:
        z5 r8 = r6.getLinkerDetail();
        if (r8 == null) goto L29;
        List r10 = r8.getPlayModes();
        if (r10 == null) goto L29;
        W0(r0, Boolean.valueOf(com.bytedance.android.livesdk.chatroom.interact.model.d0.f(r10)));
    L29:
        w0(r0);
        r0.put("chatroom_visible_duration", String.valueOf(Math.max(0, r7 - r9)));
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_audience_voice_room_show_v2", r0, new Object[]{IRoom.class, am2.x.class});
        return;
    L8:
        if (r1.length() != 0) goto L10;
        boolean r11 = true;
    L11:
        if (r11 == true) goto L13;
        r0.put("live_type", r1);
        goto L13
    L10:
        r11 = false;
        goto L11
    }

    @JvmStatic
    public static final String p(Integer r8, Integer r9, Integer r10) {
        if (r8 == null) goto L69;
        r8.intValue();
        if (r8.intValue() != 5) goto L23;
        if (r9 != null) goto L7;
    L16:
        com.bytedance.live.datacontext.m r11 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r11 == null) goto L71;
        IRoom r12 = (IRoom) r11.getValue();
        if (r12 != null) goto L21;
        return "radio";
    L21:
        if (com.bytedance.android.livesdk.chatroom.interact.model.d0.h(r12) == true) goto L79;
        return "radio";
    L79:
        return "party";
    L71:
        return "radio";
    L7:
        if (r9.intValue() == 0) goto L16;
        if (r9.intValue() == 22) goto L79;
        if (r10 != null) goto L14;
        return "radio";
    L14:
        if (r10.intValue() == 22) goto L79;
        return "radio";
    L23:
        boolean r5 = true;
        boolean r6 = false;
        if (r8.intValue() != 8) goto L39;
        if (((IInteractService) jc1.k.n(IInteractService.class)).dynamicFromAudience() == false) goto L28;
    L31:
        if (r9 != null) goto L33;
    L35:
        r6 = r5;
    L36:
        if (r6 == false) goto L74;
        return "new_audience";
    L74:
        return "radio";
    L33:
        if (r9.intValue() == 7) goto L35;
    L28:
        if (((IInteractService) jc1.k.n(IInteractService.class)).dynamicFromAudienceGuestCache() == true) goto L31;
        r5 = false;
        goto L31
    L39:
        if (r8.intValue() != 9) goto L47;
        if (r9 != null) goto L43;
    L45:
        return "ktv";
    L43:
        if (r9.intValue() != 61) goto L45;
        return "chorus";
    L47:
        if (r8.intValue() != 10) goto L50;
        return "watch";
    L50:
        if (r8.intValue() != 4) goto L53;
    L78:
        return "audience";
    L53:
        if (r8.intValue() != 1) goto L63;
        boolean r13 = ((IInteractService) jc1.k.n(IInteractService.class)).dynamicFromAudience();
        if (r9 != null) goto L57;
    L59:
        r6 = r13;
    L60:
        if (r6 == false) goto L78;
        return "new_audience";
    L57:
        if (r9.intValue() == 7) goto L59;
    L63:
        if (r8.intValue() == 12) goto L79;
        if (r8.intValue() == 16) goto L79;
        return "radio";
    L69:
        return null;
    }

    @JvmStatic
    public static final void z(String r7, List r8, String r9) {
        Intrinsics.checkNotNullParameter(r7, "requestPage");
        Intrinsics.checkNotNullParameter(r9, "targetUid");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("request_page", r7);
        r0.put("play_mode", u0.b());
        int r10 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
        I0(r0, r10);
        String r2 = null;
        B0(r0, Integer.valueOf(r10), null, 4);
        Q0(r0);
        V0(r0);
        Integer r1 = Integer.valueOf(r10);
        List r3 = r8;
        if (r3 != null) goto L5;
    L8:
        boolean r6 = true;
    L9:
        D0(r0, r1, !r6);
        if (r10 == 0) goto L19;
        if (r3 != null) goto L13;
    L16:
        boolean r4 = true;
    L17:
        if (r4 == true) goto L19;
        a1(r0, r8);
        goto L19
    L13:
        if (r3.isEmpty() == true) goto L16;
        r4 = false;
    L19:
        r0.put("user_type", u());
        com.bytedance.android.live.liveinteract.voicechat.util.d.a.getClass();
        int r11 = com.bytedance.android.live.liveinteract.voicechat.util.d.a.a();
        if (r11 == 1) goto L28;
        if (r11 != 2) goto L30;
        if (((ILinkmicAudienceSetting.LinkmicSettingStatus) b6.r.getValue()).getValue() == ILinkmicAudienceSetting.LinkmicSettingStatus.SETTING_OFF.getValue()) goto L26;
        String r12 = "on";
    L27:
        r0.put("link_distribute_switch_type", r12);
        goto L30
    L26:
        r12 = "off";
    L30:
        if (r2.a(r9) == false) goto L41;
        g1(r0, r9);
        com.bytedance.live.datacontext.m r13 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r13 == null) goto L37;
        IRoom r14 = (IRoom) r13.getValue();
        if (r14 == null) goto L37;
        r2 = r14.getOwnerUserIdString();
    L37:
        if (Intrinsics.areEqual(r9, r2) == false) goto L39;
        String r15 = "anchor";
    L40:
        r0.put("mute_user_type", r15);
        goto L41
    L39:
        r15 = "guest";
    L41:
        r0.put("user_id", gh0.a.c());
        r0.put("to_user_id", r9);
        P0(r0, Integer.valueOf(r10));
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_guest_connection_mute_cancel", r0, new Object[]{am2.x.class, IRoom.class});
        return;
    L28:
        w0(r0);
        goto L30
    L5:
        if (r3.isEmpty() == true) goto L8;
        r6 = false;
        goto L9
    }

    @JvmStatic
    public static final void A(String r7, Integer r8, List<KtvMusic> r9, String r10) {
        Intrinsics.checkNotNullParameter(r7, "requestPage");
        Intrinsics.checkNotNullParameter(r10, "targetUid");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("request_page", r7);
        r0.put("play_mode", u0.b());
        int r11 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
        I0(r0, r11);
        String r2 = null;
        B0(r0, Integer.valueOf(r11), null, 4);
        V0(r0);
        Integer r1 = Integer.valueOf(r11);
        List<KtvMusic> r3 = r9;
        if (r3 != null) goto L5;
    L8:
        boolean r6 = true;
    L9:
        D0(r0, r1, !r6);
        if (r11 == 0) goto L19;
        if (r3 != null) goto L13;
    L16:
        boolean r4 = true;
    L17:
        if (r4 == true) goto L19;
        a1(r0, r9);
        goto L19
    L13:
        if (r3.isEmpty() == true) goto L16;
        r4 = false;
    L19:
        r0.put("user_type", u());
        if (r8 == null) goto L23;
        r0.put("link_cnt", String.valueOf(r8.intValue()));
    L23:
        if (r2.a(r10) == false) goto L34;
        g1(r0, r10);
        com.bytedance.live.datacontext.m r12 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r12 == null) goto L30;
        IRoom r13 = (IRoom) r12.getValue();
        if (r13 == null) goto L30;
        r2 = r13.getOwnerUserIdString();
    L30:
        if (Intrinsics.areEqual(r10, r2) == false) goto L32;
        String r14 = "anchor";
    L33:
        r0.put("mute_user_type", r14);
        goto L34
    L32:
        r14 = "guest";
    L34:
        r0.put("user_id", gh0.a.c());
        r0.put("to_user_id", r10);
        Q0(r0);
        com.bytedance.android.live.liveinteract.voicechat.util.d.a.getClass();
        int r15 = com.bytedance.android.live.liveinteract.voicechat.util.d.a.a();
        if (r15 == 1) goto L43;
        if (r15 == 2) goto L39;
    L44:
        P0(r0, Integer.valueOf(r11));
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_guest_connection_mute", r0, new Object[]{am2.x.class, IRoom.class});
        return;
    L39:
        if (((ILinkmicAudienceSetting.LinkmicSettingStatus) b6.r.getValue()).getValue() == ILinkmicAudienceSetting.LinkmicSettingStatus.SETTING_OFF.getValue()) goto L41;
        String r16 = "on";
    L42:
        r0.put("link_distribute_switch_type", r16);
        goto L44
    L41:
        r16 = "off";
        goto L42
    L43:
        w0(r0);
        goto L44
    L5:
        if (r3.isEmpty() == true) goto L8;
        r6 = false;
        goto L9
    }

    public static /* synthetic */ void B0(Map r1, Integer r2, Integer r3, int r4) {
        if ((r4 & 2) == 0) goto L6;
        r2 = Integer.valueOf(q());
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = null;
    L8:
        A0(r1, r2, r3);
    }

    @JvmStatic
    public static final void C(String r7, String r8, String r9, int r10) {
        Intrinsics.checkNotNullParameter(r7, "inviteType");
        Intrinsics.checkNotNullParameter(r8, "inviteeId");
        Intrinsics.checkNotNullParameter(r9, "requestPage");
        HashMap r0 = new HashMap();
        r0.put("invite_type", r7);
        r0.put("invitee_id", r8.toString());
        r0.put("request_page", r9);
        String r11 = "1";
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.s1.getValue()).booleanValue() == false) goto L5;
        Object r12 = "1";
    L6:
        r0.put("is_invite_only", r12);
        com.bytedance.android.live.liveinteract.plantform.core.y r13 = (com.bytedance.android.live.liveinteract.plantform.core.y) ((IInteractService) jc1.k.n(IInteractService.class)).getLinkUserInfoCenter();
        if (r13 == null) goto L27;
        CopyOnWriteArrayList<LinkmicPositionItem> r14 = r13.e;
        if (r14 == null) goto L27;
        Iterator<LinkmicPositionItem> r15 = r14.iterator();
    L12:
        if (r15.hasNext() == false) goto L19;
        LinkmicPositionItem r4 = r15.next();
        if (((int) r4.getPosition()) != r10) goto L16;
        boolean r5 = true;
    L17:
        if (r5 == false) goto L12;
    L20:
        LinkmicPositionItem r6 = r4;
        if (r6 == null) goto L27;
        if (r6.getStatus() == LinkmicPositionItem.LinkmicPositionStatus.LOCKED.ordinal()) goto L26;
        r11 = "0";
    L26:
        r0.put("is_lock", r11);
        goto L27
    L16:
        r5 = false;
        goto L17
    L19:
        r4 = null;
    L27:
        int r16 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
        B0(r0, Integer.valueOf(r16), null, 4);
        if (((IInteractService) jc1.k.n(IInteractService.class)).dynamicFromAudience() == false) goto L30;
        r0.put("function_type2", "new_audience");
    L30:
        I0(r0, r16);
        Q0(r0);
        V0(r0);
        r0.put("play_mode", u0.b());
        P0(r0, Integer.valueOf(r16));
        H0(r0);
        R0(r0);
        u0.j(Integer.valueOf(com.bytedance.android.live.liveinteract.linkpanel.util.o.d()));
        F0(r10, r0);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_anchor_audience_connection_invite", r0, new Object[]{am2.x.class, IRoom.class});
        return;
    L5:
        r12 = "0";
        goto L6
    }

    @JvmStatic
    public static final void I(String r5, String r6, String r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "closeType");
        if (r > 0) goto L5;
        return;
    L5:
        HashMap r0 = new HashMap();
        u0(r0);
        J0(r0);
        if (r5 == null) goto L8;
        r0.put("function_type", r5);
        r0.put("function_type2", r5);
    L9:
        if (r6 == null) goto L11;
        r0.put("layout_type", r6);
    L11:
        r0.put("close_type", r7);
        if (r8 == null) goto L14;
        r0.put("enlarge_show_type", r8);
    L14:
        String r9 = d;
        if (r9 == null) goto L17;
        r0.put("source", r9);
    L17:
        r0.put("duration", String.valueOf((System.currentTimeMillis() - r) / ((long) 1000)));
        r = 0;
        r0.putAll(e());
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_anchor_layout_type_over", r0, new Object[]{IRoom.class, am2.x.class});
        return;
    L8:
        B0(r0, null, null, 6);
        goto L9
    }

    public static void j(com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r3, boolean r4, boolean r5, String r6) {
        Intrinsics.checkNotNullParameter(r3, "emoji");
        Intrinsics.checkNotNullParameter(r6, "requestPage");
        LinkedHashMap r0 = new LinkedHashMap();
        if (r4 == false) goto L6;
        String r7 = "anchor";
    L9:
        r0.put("user_type", r7);
        r0.put("user_id", jc1.k.n(IMiddlewareUserService.class).user().n());
        r0.put("request_page", r6);
        if (r3.isRandomEmoji() == false) goto L12;
        String r8 = "random";
    L13:
        r0.put("emoji_type", r8);
        r0.put("emoji_id", String.valueOf(r3.getEmojiId()));
        r0.put("emoji_name", r3.getEmojiName());
        r0.put("emoji_status", String.valueOf(r3.getEmojiStatus()));
        if (r5 == false) goto L16;
        String r9 = "self";
    L17:
        r0.put("interact_type", r9);
        if (r3.isDigitAvatarEmoji() == false) goto L20;
        String r10 = "1";
    L21:
        r0.put("is_avatar_emoji", r10);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_chat_emoji_click", r0, new Object[]{am2.x.class, IRoom.class});
        return;
    L20:
        r10 = "0";
        goto L21
    L16:
        r9 = "others";
        goto L17
    L12:
        r8 = "normal";
        goto L13
    L6:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.b0.a() == false) goto L8;
        r7 = "pre_link";
        goto L9
    L8:
        r7 = "guest";
        goto L9
    }

    public static void k(boolean r7, String r8, com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r8, "requestPage");
        Intrinsics.checkNotNullParameter(r9, "emoji");
        LinkedHashMap r0 = new LinkedHashMap();
        LinkRoomFightContext.a r1 = LinkRoomFightContext.Companion;
        String r4 = "0";
        if (r1.c() == false) goto L14;
        LinkRoomFightContext r2 = r1.getContext();
        if (r2 == null) goto L13;
        com.bytedance.live.datacontext.m<com.bytedance.android.live.liveinteract.multiscene.a> r3 = r2.getFightInfo();
        if (r3 == null) goto L13;
        com.bytedance.android.live.liveinteract.multiscene.a r5 = (com.bytedance.android.live.liveinteract.multiscene.a) r3.getValue();
        if (r5 == null) goto L13;
        com.bytedance.android.live.liveinteract.multiscene.j r6 = li0.d.a(r5);
        if (r6 == null) goto L13;
        Object r11 = com.bytedance.android.live.liveinteract.multiscene.k.b(r6);
    L15:
        if (r7 == false) goto L18;
        String r12 = "anchor";
    L21:
        r0.put("user_type", r12);
        r0.put("user_id", jc1.k.n(IMiddlewareUserService.class).user().n());
        r0.put("request_page", r8);
        Q0(r0);
        String r13 = "random";
        if (r9.isRandomEmoji() == false) goto L24;
        String r14 = "random";
    L25:
        r0.put("emoji_type", r14);
        r0.put("emoji_id", String.valueOf(r9.getEmojiId()));
        r0.put("emoji_name", r9.getEmojiName());
        r0.put("emoji_status", String.valueOf(r9.getEmojiStatus()));
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.a r15 = r9.getCustomizedRandomResource();
        if (r15 != null) goto L28;
    L36:
        if (r10 == false) goto L38;
        String r16 = "self";
    L39:
        r0.put("interact_type", r16);
        if (r9.isDigitAvatarEmoji() == false) goto L42;
        r4 = "1";
    L42:
        r0.put("is_avatar_emoji", r4);
        if (r11 == null) goto L48;
        if ((!Intrinsics.areEqual(r11, 0L)) == false) goto L48;
        r0.put("to_anchor_id", r11.toString());
    L48:
        if (r1.c() == false) goto L50;
        r0.put("play_stage", t());
    L55:
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_chat_emoji_show", r0, new Object[]{am2.x.class, IRoom.class});
        return;
    L50:
        TeamFightContext.a r17 = TeamFightContext.Companion;
        if (r17.h() == false) goto L53;
    L54:
        r0.put("play_stage", x());
        goto L55
    L53:
        if (r17.g() == false) goto L55;
    L38:
        r16 = "others";
        goto L39
    L28:
        if (r15.isRandomEmoji() != true) goto L36;
        if (r9.getDisable() != true) goto L33;
        r13 = "unavailable";
    L35:
        r0.put("random_emoji_status", r13);
        goto L36
    L33:
        if (r15.getStatus() != 1) goto L35;
        r13 = "public";
        goto L35
    L24:
        r14 = "normal";
        goto L25
    L18:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.b0.a() == false) goto L20;
        r12 = "pre_link";
        goto L21
    L20:
        r12 = "guest";
    L13:
        r11 = "0";
        goto L15
    L14:
        r11 = 0L;
        goto L15
    }

    public static /* synthetic */ void n(boolean r6, String r7, int r8, com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r9) {
        m(r6, r7, r8, r9, null, null);
    }

    @JvmStatic
    public static final void p1(int r10, int r11, Integer r12, Integer r13) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("original_seat", String.valueOf(r10));
        r0.put("switch_seat", String.valueOf(r11));
        r0.put("guest_connection_type", "live_chat");
        int r1 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
        LinkmicPositionItem r3 = null;
        B0(r0, Integer.valueOf(r1), null, 4);
        Q0(r0);
        I0(r0, r1);
        com.bytedance.android.live.liveinteract.plantform.core.y r2 = (com.bytedance.android.live.liveinteract.plantform.core.y) ((IInteractService) jc1.k.n(IInteractService.class)).getLinkUserInfoCenter();
        if (r2 == null) goto L5;
        Integer r4 = Integer.valueOf(r2.n());
    L6:
        r0.put("seat_num", String.valueOf(r4));
        String r5 = "";
        if (r2 == null) goto L29;
        CopyOnWriteArrayList<LinkmicPositionItem> r6 = r2.e;
        if (r6 == null) goto L29;
        Iterator<LinkmicPositionItem> r7 = r6.iterator();
    L12:
        if (r7.hasNext() == false) goto L22;
        LinkmicPositionItem r8 = r7.next();
        int r9 = (int) r8.getPosition();
        if (je0.d.w() == false) goto L16;
        int r14 = r10 - 1;
    L17:
        if (r9 != r14) goto L19;
        boolean r15 = true;
    L20:
        if (r15 == false) goto L12;
    L23:
        LinkmicPositionItem r16 = r8;
        if (r16 == null) goto L29;
        String r17 = r16.getActiveName();
        if (r17 != null) goto L28;
        r17 = "";
    L28:
        r0.put("seat_name_before", r17);
        goto L29
    L19:
        r15 = false;
        goto L20
    L16:
        r14 = r10;
        goto L17
    L22:
        r8 = null;
    L29:
        if (r2 == null) goto L52;
        CopyOnWriteArrayList<LinkmicPositionItem> r18 = r2.e;
        if (r18 == null) goto L52;
        Iterator<LinkmicPositionItem> r19 = r18.iterator();
    L34:
        if (r19.hasNext() == false) goto L44;
        LinkmicPositionItem r20 = r19.next();
        int r21 = (int) r20.getPosition();
        if (je0.d.w() == false) goto L38;
        int r22 = r11 - 1;
    L39:
        if (r21 != r22) goto L41;
        boolean r23 = true;
    L42:
        if (r23 == false) goto L34;
        r3 = r20;
        goto L44
    L41:
        r23 = false;
        goto L42
    L38:
        r22 = r11;
    L44:
        LinkmicPositionItem r24 = r3;
        if (r24 == null) goto L52;
        String r110 = r24.getActiveName();
        if (r110 == null) goto L50;
        r5 = r110;
    L50:
        r0.put("seat_name_after", r5);
    L52:
        if (TeamFightContext.Companion.h() == false) goto L68;
        String r111 = "red";
        if (r12 != null) goto L57;
    L59:
        Object r112 = "blue";
    L60:
        r0.put("grouppk_origin_group", r112);
        if (r13 != null) goto L64;
    L66:
        r111 = "blue";
    L67:
        r0.put("grouppk_switch_group", r111);
        li0.b r113 = li0.b.b;
        li0.b.k(r0);
        goto L68
    L64:
        if (r13.intValue() != 1) goto L66;
    L57:
        if (r12.intValue() != 1) goto L59;
        r112 = "red";
    L68:
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_guest_switch_connection_seat", r0, new Object[]{am2.x.class, IRoom.class});
        return;
    L5:
        r4 = null;
        goto L6
    }

    @JvmStatic
    public static final void G(String r3, String r4, String r5, boolean r6, String r7) {
        HashMap r0 = new HashMap();
        u0(r0);
        J0(r0);
        if (r3 == null) goto L5;
        r0.put("function_type", r3);
    L6:
        if (r4 == null) goto L9;
        r0.put("layout_type", r4);
    L9:
        if (r5 == null) goto L11;
        r0.put("source", r5);
    L14:
        if (r6 == false) goto L16;
        r0.put("source", "null");
    L16:
        if (r7 == null) goto L18;
        r0.put("enlarge_show_type", r7);
    L18:
        String r8 = q;
        if (r8 == null) goto L21;
        r0.put("enlarge_user_id", r8);
        q = null;
    L21:
        r = System.currentTimeMillis();
        r0.putAll(e());
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_anchor_layout_type_open_success", r0, new Object[]{IRoom.class, am2.x.class});
        return;
    L11:
        String r9 = d;
        if (r9 == null) goto L14;
        r0.put("source", r9);
        goto L14
    L5:
        B0(r0, null, null, 6);
        goto L6
    }

    public static /* synthetic */ void H(String r2, String r3, boolean r4, String r5, int r6) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 16) == 0) goto L11;
        r5 = null;
    L11:
        G(r2, r3, null, r4, r5);
    }

    public static void M0(Map r7, int r8, String r9, boolean r10, int r11) {
        String r1 = "";
        if ((r11 & 4) == 0) goto L5;
        r9 = "";
    L5:
        boolean r0 = false;
        if ((r11 & 8) == 0) goto L8;
        r10 = false;
    L8:
        Intrinsics.checkNotNullParameter(r7, "logMap");
        Intrinsics.checkNotNullParameter(r9, "matchType");
        com.bytedance.android.livesdk.log.filter.t r12 = com.bytedance.android.livesdk.log.j0.l().c(am2.x.class);
        if (r12 != null) goto L11;
    L25:
        int r13 = bh0.a.a;
        if (r8 == 105) goto L29;
        return;
    L29:
        if (r10 == false) goto L44;
        String r14 = hk0.a.a.get("age");
        if (r14 != null) goto L33;
        r14 = "";
    L33:
        HashMap r15 = (HashMap) r7;
        r15.put("age_tag", r14);
        String r16 = hk0.a.a.get("gender");
        if (r16 != null) goto L36;
        r16 = "";
    L36:
        r15.put("gender_tag", r16);
        String r17 = hk0.a.a.get("location");
        if (r17 != null) goto L39;
        r17 = "";
    L39:
        r15.put("location_tag", r17);
        String r18 = hk0.a.a.get("challenge");
        if (r18 == null) goto L43;
        r1 = r18;
    L43:
        r15.put("challenge_tag", r1);
        r15.put("link_cnt_tag", String.valueOf(hk0.a.c));
        return;
    L44:
        String r19 = hk0.a.b.get("age");
        if (r19 != null) goto L47;
        r19 = "";
    L47:
        HashMap r20 = (HashMap) r7;
        r20.put("age_tag", r19);
        String r110 = hk0.a.b.get("gender");
        if (r110 != null) goto L50;
        r110 = "";
    L50:
        r20.put("gender_tag", r110);
        String r111 = hk0.a.b.get("location");
        if (r111 != null) goto L53;
        r111 = "";
    L53:
        r20.put("location_tag", r111);
        String r21 = hk0.a.b.get("challenge");
        if (r21 == null) goto L57;
        r1 = r21;
    L57:
        r20.put("challenge_tag", r1);
        r20.put("link_cnt_tag", String.valueOf(hk0.a.d));
        return;
    L11:
        if ((r12 instanceof com.bytedance.android.livesdk.log.filter.t) == false) goto L25;
        String r112 = r12.getMatchType();
        if (r112 != null) goto L15;
    L18:
        boolean r113 = true;
    L19:
        if (r113 == false) goto L25;
        if (r9.length() != 0) goto L23;
        r0 = true;
    L23:
        if (r0 == false) goto L25;
        return;
    L15:
        if (r112.length() == 0) goto L18;
        r113 = false;
        goto L19
    }

    public static void N(String r17, Integer r18, Map r19, long r20, int r22) {
        if ((r22 & 2) == 0) goto L5;
        String r0 = null;
    L7:
        if ((r22 & 4) == 0) goto L9;
        Integer r2 = null;
    L11:
        if ((r22 & 8) == 0) goto L13;
        Map r3 = null;
    L14:
        long r5 = 0;
        if ((r22 & 16) == 0) goto L17;
        long r7 = 0;
    L18:
        HashMap r4 = new HashMap();
        u0(r4);
        J0(r4);
        B0(r4, null, null, 6);
        if (r0 == null) goto L21;
        r4.put("layout_type", r0);
    L21:
        if (r3 == null) goto L26;
        Iterator r1 = r3.entrySet().iterator();
    L24:
        if (r1.hasNext() == false) goto L26;
        Map.Entry r6 = (Map.Entry) r1.next();
        r4.put(r6.getKey(), r6.getValue());
    L26:
        zi0.d.b(r4, true);
        if (r2 == null) goto L35;
        r4.put("play_mode", u0.k(r2.intValue()));
        if (r7 == 0) goto L31;
        r4.put("duration", String.valueOf((System.currentTimeMillis() - r7) / ((long) 1000)));
    L34:
        w.put(r2, null);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_audience_playmode_room_watch_duration", r4, new Object[]{IRoom.class, am2.x.class});
        return;
    L31:
        Long r8 = (Long) ((LinkedHashMap) w).get(r2);
        if (r8 == null) goto L58;
        r4.put("duration", String.valueOf((System.currentTimeMillis() - r8.longValue()) / ((long) 1000)));
        goto L34
    L58:
        return;
    L35:
        com.bytedance.live.datacontext.j r9 = com.bytedance.android.live.liveinteract.api.utils.m.d().J();
        if (r9 == null) goto L42;
        LivePlayModeLogContext r10 = (LivePlayModeLogContext) r9.getValue();
        if (r10 == null) goto L42;
        com.bytedance.live.datacontext.m r11 = r10.getPlayModes();
        if (r11 == null) goto L42;
        Set r12 = (Set) r11.getValue();
    L43:
        if (r12 == null) goto L65;
        Iterator r13 = r12.iterator();
    L47:
        if (r13.hasNext() == false) goto L67;
        int r14 = ((Number) r13.next()).intValue();
        if (t0(r14) == false) goto L57;
        r4.put("play_mode", u0.k(r14));
        if (r7 == r5) goto L53;
        r4.put("duration", String.valueOf((System.currentTimeMillis() - r7) / ((long) 1000)));
    L56:
        w.put(Integer.valueOf(r14), null);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_audience_playmode_room_watch_duration", r4, new Object[]{IRoom.class, am2.x.class});
        goto L57
    L53:
        Long r15 = (Long) ((LinkedHashMap) w).get(Integer.valueOf(r14));
        if (r15 == null) goto L66;
        r4.put("duration", String.valueOf((System.currentTimeMillis() - r15.longValue()) / ((long) 1000)));
        goto L56
    L66:
        return;
    L57:
        r5 = 0;
        goto L47
    L67:
        return;
    L65:
        return;
    L42:
        r12 = null;
        goto L43
    L17:
        r7 = r20;
        goto L18
    L13:
        r3 = r19;
        goto L14
    L9:
        r2 = r18;
        goto L11
    L5:
        r0 = r17;
        goto L7
    }

    public static void O(String r7, Integer r8, Map r9, boolean r10, int r11) {
        Set r1 = null;
        if ((r11 & 2) == 0) goto L6;
        r7 = null;
    L6:
        if ((r11 & 4) == 0) goto L9;
        r8 = null;
    L9:
        if ((r11 & 8) == 0) goto L12;
        r9 = null;
    L12:
        if ((r11 & 16) == 0) goto L14;
        r10 = false;
    L14:
        HashMap r12 = new HashMap();
        if (r9 == null) goto L20;
        Iterator r13 = r9.entrySet().iterator();
    L18:
        if (r13.hasNext() == false) goto L20;
        Map.Entry r2 = (Map.Entry) r13.next();
        r12.put(r2.getKey(), r2.getValue());
    L20:
        u0(r12);
        J0(r12);
        B0(r12, null, null, 6);
        if (r7 == null) goto L23;
        r12.put("layout_type", r7);
    L23:
        c1(r12);
        zi0.d.b(r12, false);
        if (r8 == null) goto L28;
        r12.put("play_mode", u0.k(r8.intValue()));
        w.put(r8, Long.valueOf(System.currentTimeMillis()));
        if (r10 == true) goto L45;
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_audience_playmode_room_watch", r12, new Object[]{IRoom.class, am2.x.class});
        return;
    L45:
        return;
    L28:
        com.bytedance.live.datacontext.j r14 = com.bytedance.android.live.liveinteract.api.utils.m.d().J();
        if (r14 == null) goto L35;
        LivePlayModeLogContext r15 = (LivePlayModeLogContext) r14.getValue();
        if (r15 == null) goto L35;
        com.bytedance.live.datacontext.m r16 = r15.getPlayModes();
        if (r16 == null) goto L35;
        r1 = (Set) r16.getValue();
    L35:
        if (r1 == null) goto L55;
        Iterator r17 = r1.iterator();
    L39:
        if (r17.hasNext() == false) goto L56;
        int r3 = ((Number) r17.next()).intValue();
        if (t0(r3) == false) goto L39;
        r12.put("play_mode", u0.k(r3));
        w.put(Integer.valueOf(r3), Long.valueOf(System.currentTimeMillis()));
        if (r10 == true) goto L39;
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_audience_playmode_room_watch", r12, new Object[]{IRoom.class, am2.x.class});
        goto L39
    L56:
        return;
    }

    public static boolean i(Integer r3, Integer r4, Integer r5, Integer r6, List r7, List r8) {
        if (r3 == null) goto L15;
        if (r3.intValue() != 8) goto L15;
        if (r4 == null) goto L15;
        if (r4.intValue() != 7) goto L15;
        if (((IInteractService) jc1.k.n(IInteractService.class)).dynamicFromAudienceGuestCache() == false) goto L15;
        return true;
    L15:
        if (r3 != null) goto L18;
    L22:
        if (r5 == null) goto L31;
        if (r5.intValue() != 16) goto L31;
        if (r3 == null) goto L31;
        if (r3.intValue() == 0) goto L31;
    L29:
        return true;
    L31:
        if (r4 != null) goto L34;
    L35:
        if (r6 == null) goto L41;
        if (r6.intValue() != 4) goto L41;
    L57:
        return true;
    L41:
        if (r4 == null) goto L43;
        int r9 = r4.intValue();
    L45:
        if (com.bytedance.android.livesdk.chatroom.interact.model.e0.a(r9) == false) goto L56;
        if (r6 == null) goto L48;
        int r10 = r6.intValue();
    L50:
        if (com.bytedance.android.livesdk.chatroom.interact.model.e0.a(r10) == false) goto L56;
        if (com.bytedance.android.livesdk.chatroom.interact.model.d0.e(r7) == false) goto L56;
        if (com.bytedance.android.livesdk.chatroom.interact.model.d0.e(r8) == false) goto L56;
        return true;
    L48:
        r10 = 0;
    L56:
        return false;
    L43:
        r9 = 0;
        goto L45
    L34:
        if (r4.intValue() == 4) goto L57;
    L18:
        if (r3.intValue() != 16) goto L22;
        if (r5 == null) goto L22;
        if (r5.intValue() != 0) goto L29;
        goto L22
    }

    @JvmStatic
    public static final void m(boolean r17, String r18, int r19, com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r20, String r21, Boolean r22) {
        Intrinsics.checkNotNullParameter(r18, "requestPage");
        if (r20 != null) goto L5;
        return;
    L5:
        LinkedHashMap r2 = new LinkedHashMap();
        LinkRoomFightContext.a r3 = LinkRoomFightContext.Companion;
        String r7 = "0";
        if (r3.c() == false) goto L17;
        LinkRoomFightContext r4 = r3.getContext();
        if (r4 == null) goto L16;
        com.bytedance.live.datacontext.m<com.bytedance.android.live.liveinteract.multiscene.a> r5 = r4.getFightInfo();
        if (r5 == null) goto L16;
        com.bytedance.android.live.liveinteract.multiscene.a r6 = (com.bytedance.android.live.liveinteract.multiscene.a) r5.getValue();
        if (r6 == null) goto L16;
        com.bytedance.android.live.liveinteract.multiscene.j r8 = li0.d.a(r6);
        if (r8 == null) goto L16;
        Object r9 = com.bytedance.android.live.liveinteract.multiscene.k.b(r8);
    L18:
        String r10 = "guest";
        if (r17 == false) goto L22;
        String r11 = "anchor";
    L25:
        r2.put("user_type", r11);
        r2.put("user_id", jc1.k.n(IMiddlewareUserService.class).user().n());
        r2.put("request_page", r18);
        I0(r2, r19);
        Object r12 = null;
        B0(r2, Integer.valueOf(r19), null, 4);
        Q0(r2);
        String r13 = "random";
        if (r20.isRandomEmoji() == false) goto L28;
        String r0 = "random";
    L29:
        r2.put("emoji_type", r0);
        r2.put("emoji_id", String.valueOf(r20.getEmojiId()));
        String r1 = r20.getEmojiName();
        if (r1 == null) goto L32;
        r2.put("emoji_name", r1);
    L32:
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.a r14 = r20.getCustomizedRandomResource();
        if (r14 == null) goto L47;
        if (r14.isRandomEmoji() == true) goto L38;
        r14 = null;
    L38:
        if (r14 == null) goto L47;
        if (r14.isRandomEmoji() != true) goto L47;
        if (r14.getStatus() == 1) goto L45;
        r13 = "public";
    L45:
        r2.put("random_emoji_status", r13);
    L47:
        if (r20.isInteractEmoji() == false) goto L49;
        String r15 = "others";
    L50:
        r2.put("interact_type", r15);
        if (r20.isSoundEmoji() == false) goto L53;
        Object r16 = "1";
    L54:
        r2.put("is_voice", r16);
        if (r21 == null) goto L61;
        r2.put("to_user_id", r21);
        if (Intrinsics.areEqual(r22, Boolean.TRUE) == false) goto L59;
        r10 = "anchor";
    L59:
        r2.put("to_user_type", r10);
    L61:
        if (r20.isDigitAvatarEmoji() == false) goto L63;
        Object r23 = "1";
    L64:
        r2.put("is_avatar_emoji", r23);
        yr0.d r24 = jc1.k.n(IMultiLinkServiceExternal.class).getMultiDataHolderExternal();
        if (jc1.k.n(IMultiLinkServiceExternal.class).getPkServiceExternal().getPkState() != 1) goto L67;
        boolean r25 = true;
    L68:
        if (r25 == false) goto L70;
        r2.put("channel_id", String.valueOf(r24.getChannelId()));
    L70:
        if (r25 == false) goto L72;
        String r26 = String.valueOf(r24.getPkId());
    L73:
        r2.put("pk_id", r26);
        if (r25 == false) goto L76;
        Object r27 = "1";
    L77:
        r2.put("is_in_pk", r27);
        if (r3.c() == false) goto L103;
        r2.put("play_stage", t());
        LinkRoomFightContext r28 = r3.getContext();
        if (r28 == null) goto L160;
        com.bytedance.live.datacontext.m<com.bytedance.android.live.liveinteract.multiscene.a> r29 = r28.getFightInfo();
        if (r29 == null) goto L160;
        com.bytedance.android.live.liveinteract.multiscene.a r30 = (com.bytedance.android.live.liveinteract.multiscene.a) r29.getValue();
        if (r30 == null) goto L160;
        com.bytedance.android.live.liveinteract.multiscene.j r31 = li0.d.i(r30);
        if (r31 == null) goto L160;
        List<com.bytedance.android.live.liveinteract.multiscene.f> r32 = r31.getPlayers();
        if (r32 == null) goto L100;
        Iterator<T> r33 = r32.iterator();
    L91:
        if (r33.hasNext() == false) goto L99;
        Object r34 = r33.next();
        com.bytedance.android.live.liveinteract.multiscene.f r110 = (com.bytedance.android.live.liveinteract.multiscene.f) r34;
        if (r110 == null) goto L95;
        String r111 = r110.getUserIdString();
    L97:
        if (Intrinsics.areEqual(r111, r21) == false) goto L91;
        r12 = r34;
        goto L99
    L95:
        r111 = null;
    L99:
        r12 = (com.bytedance.android.live.liveinteract.multiscene.f) r12;
    L100:
        if (r12 == null) goto L102;
        r7 = "1";
    L102:
        r2.put("is_my_team", r7);
    L160:
        if (r9 != null) goto L162;
    L164:
        r2.put("voice_mode", "head");
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_chat_emoji_send", r2, new Object[]{am2.x.class, IRoom.class});
        return;
    L162:
        if ((!Intrinsics.areEqual(r9, 0L)) == false) goto L164;
        r2.put("to_anchor_id", r9.toString());
        goto L164
    L103:
        TeamFightContext.a r35 = TeamFightContext.Companion;
        if (r35.h() == false) goto L106;
    L107:
        r2.put("play_stage", x());
        if (r17 == true) goto L160;
        com.bytedance.android.live.liveinteract.multiscene.a r36 = r35.b();
        if (r36 == null) goto L160;
        Intrinsics.checkNotNullParameter(r36, "$this$selfTeamId");
        if (com.bytedance.android.live.liveinteract.multiscene.b.c(r36, je0.d.b0()) != 1) goto L136;
        com.bytedance.android.live.liveinteract.multiscene.a r37 = r35.b();
        if (r37 == null) goto L136;
        com.bytedance.android.live.liveinteract.multiscene.j r38 = li0.d.i(r37);
        if (r38 == null) goto L136;
        List<com.bytedance.android.live.liveinteract.multiscene.f> r39 = r38.getPlayers();
        if (r39 == null) goto L131;
        Iterator<T> r40 = r39.iterator();
    L121:
        if (r40.hasNext() == false) goto L129;
        Object r112 = r40.next();
        com.bytedance.android.live.liveinteract.multiscene.f r113 = (com.bytedance.android.live.liveinteract.multiscene.f) r112;
        if (r113 == null) goto L126;
        r12 = r113.getUserIdString();
    L126:
        if (Intrinsics.areEqual(r12, r21) == true) goto L130;
        r12 = null;
    L130:
        com.bytedance.android.live.liveinteract.multiscene.f r114 = (com.bytedance.android.live.liveinteract.multiscene.f) r112;
    L132:
        if (r114 == null) goto L134;
        Object r41 = "1";
    L135:
        r2.put("is_my_team", r41);
        goto L136
    L134:
        r41 = "0";
        goto L135
    L129:
        r112 = null;
        goto L130
    L131:
        r114 = null;
    L136:
        Intrinsics.checkNotNullParameter(r36, "$this$selfTeamId");
        if (com.bytedance.android.live.liveinteract.multiscene.b.c(r36, je0.d.b0()) != 2) goto L160;
        com.bytedance.android.live.liveinteract.multiscene.a r42 = TeamFightContext.Companion.b();
        if (r42 == null) goto L160;
        com.bytedance.android.live.liveinteract.multiscene.j r43 = li0.d.a(r42);
        if (r43 == null) goto L160;
        List<com.bytedance.android.live.liveinteract.multiscene.f> r44 = r43.getPlayers();
        if (r44 == null) goto L156;
        Iterator<T> r45 = r44.iterator();
    L146:
        if (r45.hasNext() == false) goto L154;
        Object r46 = r45.next();
        com.bytedance.android.live.liveinteract.multiscene.f r115 = (com.bytedance.android.live.liveinteract.multiscene.f) r46;
        if (r115 == null) goto L150;
        String r116 = r115.getUserIdString();
    L152:
        if (Intrinsics.areEqual(r116, r21) == false) goto L146;
        Object r117 = r46;
    L155:
        com.bytedance.android.live.liveinteract.multiscene.f r118 = (com.bytedance.android.live.liveinteract.multiscene.f) r117;
    L157:
        if (r118 == null) goto L159;
        r7 = "1";
    L159:
        r2.put("is_my_team", r7);
        goto L160
    L150:
        r116 = null;
        goto L152
    L154:
        r117 = null;
        goto L155
    L156:
        r118 = null;
        goto L157
    L106:
        if (r35.g() == false) goto L160;
    L76:
        r27 = "0";
        goto L77
    L72:
        r26 = "";
        goto L73
    L67:
        r25 = false;
        goto L68
    L63:
        r23 = "0";
        goto L64
    L53:
        r16 = "0";
        goto L54
    L49:
        r15 = "self";
        goto L50
    L28:
        r0 = "normal";
        goto L29
    L22:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.b0.a() == false) goto L24;
        r11 = "pre_link";
        goto L25
    L24:
        r11 = "guest";
    L16:
        r9 = "0";
        goto L18
    L17:
        r9 = 0L;
        goto L18
    }

    public final void d0(boolean r9, boolean r10, String r11, CPositionBeInvitedDialog.ShowType r12, boolean r13, DataCenter r14) {
        Intrinsics.checkNotNullParameter(r11, "fromUid");
        Intrinsics.checkNotNullParameter(r12, "showType");
        LinkedHashMap r0 = new LinkedHashMap();
        J0(r0);
        B0(r0, null, null, 6);
        V0(r0);
        if (r9 == false) goto L5;
        String r15 = "accept";
    L8:
        r0.put("action_type", r15);
        h r16 = b;
        r0.put("current_enlarge_user_type", o(Integer.valueOf(r16.a)));
        if (r16.a != 26) goto L11;
        r0.put("is_empty_enlarge_seat", s(r14));
    L11:
        r0.put("seat_num", String.valueOf(je0.d.R()));
        com.bytedance.live.datacontext.m r17 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r17 == null) goto L16;
        IRoom r18 = (IRoom) r17.getValue();
        if (r18 == null) goto L16;
        String r19 = r18.getOwnerUserIdString();
    L17:
        String r110 = je0.d.b0();
        if (Intrinsics.areEqual(r110, r19) == false) goto L20;
        Object r1 = "anchor";
    L21:
        r0.put("user_type", r1);
        if ((!Intrinsics.areEqual(r110, r19)) == false) goto L24;
        r0.put("enlarge_user_id", r110.toString());
        r0.put("enlarge_user_type", "guest");
    L30:
        r0.put("enlarge_open_from", String.valueOf(f()));
        if (je0.d.f() != 12) goto L34;
        x0(r0);
    L34:
        if (r13 == false) goto L37;
        r0.put("is_double", "1");
    L37:
        if (D(null, r14) == false) goto L39;
        r0.put("is_anchor_enlarge", "1");
    L39:
        Integer r20 = je0.d.h();
        if (r20 != null) goto L43;
    L45:
        String r21 = "classic";
    L46:
        r0.put("play_layout", r21);
        HamletAvatarContext r22 = HamletAvatarContext.Companion.getContext();
        if (r22 == null) goto L55;
        com.bytedance.live.datacontext.j<gd0.g> r23 = r22.getHamletAvatarService();
        if (r23 == null) goto L55;
        gd0.g r24 = (gd0.g) r23.getValue();
        if (r24 == null) goto L55;
        Long r25 = r24.Ue();
        if (r25 == null) goto L55;
        r0.put("avatar_id", String.valueOf(r25.longValue()));
    L55:
        zi0.d.b(r0, false);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_live_guest_enlarge_open_success", r0, new Object[]{IRoom.class, am2.x.class});
        return;
    L43:
        if (r20.intValue() != 28) goto L45;
        r21 = "avatar";
        goto L46
    L24:
        int r26 = t0.a[r12.ordinal()];
        if (r26 == 1) goto L29;
        if (r26 != 2) goto L30;
        q = r11.toString();
        r0.put("enlarge_user_id", r11);
        r0.put("enlarge_user_type", "guest");
        goto L30
    L29:
        q = r110.toString();
        r0.put("enlarge_user_id", r110);
        r0.put("enlarge_user_type", "anchor");
        goto L30
    L20:
        r1 = "guest";
    L16:
        r19 = null;
        goto L17
    L5:
        if (r10 == false) goto L7;
        r15 = "over_time";
        goto L8
    L7:
        r15 = "reject";
        goto L8
    }

    public static void L(Integer r8, Integer r9, Integer r10, Integer r11, String r12, String r13, Map r14, int r15) {
        if ((r15 & 4) == 0) goto L6;
        r8 = null;
    L6:
        if ((r15 & 8) == 0) goto L9;
        r9 = null;
    L9:
        if ((r15 & 16) == 0) goto L12;
        r10 = null;
    L12:
        if ((r15 & 32) == 0) goto L15;
        r11 = null;
    L15:
        if ((r15 & 64) == 0) goto L18;
        r12 = null;
    L18:
        if ((r15 & 128) == 0) goto L21;
        r13 = null;
    L21:
        if ((r15 & 256) == 0) goto L23;
        r14 = null;
    L23:
        HashMap r16 = new HashMap();
        u0(r16);
        J0(r16);
        B0(r16, null, null, 6);
        if (r14 == null) goto L29;
        Iterator r17 = r14.entrySet().iterator();
    L27:
        if (r17.hasNext() == false) goto L29;
        Map.Entry r0 = (Map.Entry) r17.next();
        r16.put(r0.getKey(), r0.getValue());
    L29:
        r16.put("guess_cnt", String.valueOf(r9));
        r16.put("income_cnt", String.valueOf(r10));
        r16.put("user_id", String.valueOf(r12));
        if (r13 == null) goto L32;
        String r18 = (String) r16.put("user_type", r13);
    L32:
        if (r11 == null) goto L34;
        String r19 = r1(r11.intValue());
    L35:
        if (r19 == null) goto L37;
        String r20 = (String) r16.put("result", r19);
    L37:
        Map<Integer, String> r21 = g;
        if (r8 == null) goto L40;
        int r110 = r8.intValue();
    L41:
        LinkedHashMap r22 = (LinkedHashMap) r21;
        if (TextUtils.isEmpty((CharSequence) r22.get(Integer.valueOf(r110))) == true) goto L50;
        if (r8 == null) goto L45;
        int r111 = r8.intValue();
    L46:
        String r23 = (String) r22.get(Integer.valueOf(r111));
        if (r23 != null) goto L49;
        r23 = "";
    L49:
        r16.put("source", r23);
        goto L50
    L45:
        r111 = 0;
    L50:
        r16.put("is_link_room", s);
        zi0.d.b(r16, true);
        if (r8 == null) goto L55;
        r16.put("play_mode", u0.k(r8.intValue()));
        Map<Integer, Long> r1 = t;
        Long r2 = (Long) ((LinkedHashMap) r1).get(r8);
        if (r2 == null) goto L73;
        r16.put("duration", String.valueOf((System.currentTimeMillis() - r2.longValue()) / ((long) 1000)));
        r1.put(r8, null);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_anchor_playmode_over", r16, new Object[]{IRoom.class, am2.x.class});
        return;
    L73:
        return;
    L55:
        com.bytedance.live.datacontext.j r24 = com.bytedance.android.live.liveinteract.api.utils.m.d().J();
        if (r24 == null) goto L62;
        LivePlayModeLogContext r25 = (LivePlayModeLogContext) r24.getValue();
        if (r25 == null) goto L62;
        com.bytedance.live.datacontext.m r26 = r25.getPlayModes();
        if (r26 == null) goto L62;
        Set r27 = (Set) r26.getValue();
    L63:
        if (r27 == null) goto L82;
        Iterator r28 = r27.iterator();
    L67:
        if (r28.hasNext() == false) goto L83;
        int r3 = ((Number) r28.next()).intValue();
        if (t0(r3) == false) goto L67;
        r16.put("play_mode", u0.k(r3));
        Map<Integer, Long> r4 = t;
        Long r5 = (Long) ((LinkedHashMap) r4).get(Integer.valueOf(r3));
        if (r5 == null) goto L84;
        r16.put("duration", String.valueOf((System.currentTimeMillis() - r5.longValue()) / ((long) 1000)));
        r4.put(Integer.valueOf(r3), null);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_anchor_playmode_over", r16, new Object[]{IRoom.class, am2.x.class});
        goto L67
    L84:
        return;
    L83:
        return;
    L82:
        return;
    L62:
        r27 = null;
        goto L63
    L40:
        r110 = 0;
        goto L41
    L34:
        r19 = null;
        goto L35
    }

    public static /* synthetic */ void f0(g1 r10, IRoom r11, String r12, int r13, boolean r14, int r15, boolean r16, List r17, LinkApplyType r18) {
        e0(r10, r11, r12, r13, r14, r15, r16, r17, r18, null);
    }

    @JvmStatic
    public static final void e0(g1 r2, IRoom r3, String r4, int r5, boolean r6, int r7, boolean r8, List<KtvMusic> r9, LinkApplyType r10, Map<String, String> r11) {
        Intrinsics.checkNotNullParameter(r3, PbRequest.SwitchType.ROOM);
        HashMap r0 = new HashMap();
        J0(r0);
        u0(r0);
        String r12 = r3.getRequestId();
        if (r12 == null) goto L5;
        r0.put("request_id", r12);
    L5:
        r0.put("function_type", g());
        if (r4 != null) goto L8;
        String r13 = "";
    L9:
        r0.put("connect_type", r13);
        boolean r14 = Intrinsics.areEqual(r4, "apply");
        String r15 = "0";
        if (r14 == false) goto L21;
        String r16 = w(r5, r10);
        if (r16 == null) goto L15;
        r0.put("request_page", r16);
    L15:
        if (tc0.c.h().K != LinkApplyType.MATCH.getValue()) goto L18;
        r0.put("request_page", tc0.c.h().L.getValue());
    L18:
        if (r6 == false) goto L20;
        r0.put("is_approve_needed", "0");
        goto L21
    L20:
        r0.put("is_approve_needed", "1");
    L21:
        y0(r0, false);
        if (r7 != 201) goto L24;
        r0.put("break_page", "seat");
    L28:
        if (r2 == null) goto L41;
        r0.put("link_duration", String.valueOf(r2.getLink_duration()));
        u1 r17 = r2.getUserInfoDuringLinkmic();
        Long r18 = null;
        if (r17 == null) goto L32;
        String r19 = r17.getFanTicket();
    L33:
        r0.put("money", String.valueOf(r19));
        u1 r20 = r2.getUserInfoDuringLinkmic();
        if (r20 == null) goto L36;
        Long r21 = Long.valueOf(r20.getAddFollowerCount());
    L37:
        r0.put("new_fans_cnt", String.valueOf(r21));
        u1 r22 = r2.getUserInfoDuringLinkmic();
        if (r22 == null) goto L40;
        r18 = Long.valueOf(r22.getScoreBeyond());
    L40:
        r0.put("win_part", String.valueOf(r18));
    L46:
        if (r8 == false) goto L48;
        r15 = "1";
    L48:
        r0.put("if_activity_icon", r15);
        int r23 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
        Integer r24 = Integer.valueOf(r23);
        List<KtvMusic> r25 = r9;
        if (r25 != null) goto L51;
    L54:
        boolean r26 = true;
    L55:
        D0(r0, r24, !r26);
        if (r23 == 0) goto L65;
        if (r25 != null) goto L59;
    L62:
        boolean r27 = true;
    L63:
        if (r27 == true) goto L65;
        a1(r0, r9);
        goto L65
    L59:
        if (r25.isEmpty() == true) goto L62;
        r27 = false;
    L65:
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_guest_connection_endpage_show", r0, new Object[]{IRoom.class, am2.x.class});
        return;
    L51:
        if (r25.isEmpty() == true) goto L54;
        r26 = false;
        goto L55
    L36:
        r21 = null;
        goto L37
    L32:
        r19 = null;
        goto L33
    L41:
        if (r11 == null) goto L46;
        Iterator<Map.Entry<String, String>> r28 = r11.entrySet().iterator();
    L44:
        if (r28.hasNext() == false) goto L46;
        Map.Entry<String, String> r29 = r28.next();
        r0.put(r29.getKey(), r29.getValue());
        goto L44
    L24:
        if (r7 != 202) goto L28;
        r0.put("break_page", "bottom");
        goto L28
    L8:
        r13 = r4;
        goto L9
    }

    public static void s0(TalkRoomLogUtils r16, String r17, String r18, List r19, String r20, boolean r21, String r22, String r23, String r24, String r25, boolean r26, Long r27, Map r28, int r29) {
        if ((r29 & 4) == 0) goto L5;
        List r2 = null;
    L6:
        String r5 = "";
        if ((r29 & 8) == 0) goto L9;
        String r4 = "";
    L11:
        if ((r29 & 16) == 0) goto L13;
        boolean r6 = false;
    L15:
        if ((r29 & 32) == 0) goto L17;
        String r8 = "";
    L19:
        if ((r29 & 64) == 0) goto L21;
        String r9 = "";
    L23:
        if ((r29 & 128) == 0) goto L25;
        String r10 = "null";
    L27:
        if ((r29 & 256) != 0) goto L31;
        r5 = r25;
    L31:
        if ((r29 & 1024) == 0) goto L33;
        Long r11 = null;
    L35:
        if ((r29 & 2048) == 0) goto L37;
        Map r1 = MapsKt.emptyMap();
    L38:
        r16.getClass();
        Intrinsics.checkNotNullParameter(r17, "applicantId");
        Intrinsics.checkNotNullParameter(r18, "passType");
        Intrinsics.checkNotNullParameter(r4, "page");
        Intrinsics.checkNotNullParameter(r8, "fanTicket");
        Intrinsics.checkNotNullParameter(r9, "relationship");
        Intrinsics.checkNotNullParameter(r10, "topPos");
        Intrinsics.checkNotNullParameter(r5, "userLevel");
        Intrinsics.checkNotNullParameter(r1, PbRequest.SwitchType.OTHER);
        HashMap r14 = new HashMap();
        r14.put("applicant_id", r17.toString());
        r14.put("pass_type", r18);
        if (r4.length() != 0) goto L41;
        boolean r0 = true;
    L43:
        if (r0 == true) goto L45;
        r14.put("request_page", r4);
    L45:
        String r3 = "1";
        String r7 = "0";
        if (r6 == false) goto L48;
        Object r12 = "1";
    L49:
        r14.put("is_application", r12);
        int r13 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
        B0(r14, Integer.valueOf(r13), null, 4);
        if (Intrinsics.areEqual((String) r14.get("request_page"), "user_chorus_accept_button") == false) goto L52;
    L62:
        r14.put("guest_connection_type", "live_song");
    L63:
        if (r13 == 0) goto L74;
        List r15 = r2;
        if (r15 != null) goto L67;
    L70:
        boolean r30 = true;
    L71:
        if (r30 == true) goto L74;
        a1(r14, r2);
        goto L74
    L67:
        if (r15.isEmpty() == true) goto L70;
        r30 = false;
    L74:
        if (vm2.d.r() != 1) goto L76;
        r14.put("ordering_mode", v());
        r14.put("money", r8.toString());
        r14.put("relationship", r9);
        r14.put("top_r", r10);
        r14.put("contribution_level", r5);
    L76:
        if (r11 == null) goto L78;
        r14.put("tag_type", String.valueOf(r11.longValue()));
    L78:
        Q0(r14);
        I0(r14, r13);
        li0.b r31 = li0.b.b;
        li0.b.k(r14);
        if (r26 == true) goto L82;
        r3 = "0";
    L82:
        r14.put("if_invitee_subscribe", r3);
        H0(r14);
        if (com.bytedance.android.live.liveinteract.utils.g1.a() == false) goto L94;
        cj0.c r32 = PaidLinkMicContext.Companion.a();
        if (r32 == null) goto L94;
        if (r32.isPaidLinkOn() == true) goto L94;
        if ((!Intrinsics.areEqual((String) r1.get("paid_amount"), "0")) == false) goto L91;
        String r33 = "priority";
    L92:
        r14.put("queue_from", r33);
        goto L94
    L91:
        r33 = "normal";
    L94:
        if ((!r1.isEmpty()) == false) goto L100;
        String r34 = (String) r1.get("position");
        if (r34 == null) goto L99;
        r7 = r34;
    L99:
        r14.put("order", r7);
    L100:
        P0(r14, Integer.valueOf(r13));
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_anchor_audience_connection_pass", r14, new Object[]{am2.x.class, IRoom.class});
        return;
    L52:
        if (Intrinsics.areEqual((String) r14.get("request_page"), "live_song_accept_button") == true) goto L62;
        Integer r35 = Integer.valueOf(r13);
        List r36 = r2;
        if (r36 != null) goto L57;
    L60:
        boolean r37 = true;
    L61:
        D0(r14, r35, !r37);
        goto L63
    L57:
        if (r36.isEmpty() == true) goto L60;
        r37 = false;
        goto L61
    L48:
        r12 = "0";
        goto L49
    L41:
        r0 = false;
        goto L43
    L37:
        r1 = r28;
        goto L38
    L33:
        r11 = r27;
        goto L35
    L25:
        r10 = r24;
        goto L27
    L21:
        r9 = r23;
        goto L23
    L17:
        r8 = r22;
        goto L19
    L13:
        r6 = r21;
        goto L15
    L9:
        r4 = r20;
        goto L11
    L5:
        r2 = r19;
        goto L6
    }

    @JvmStatic
    public static final void a0(String r35, Long r36, Long r37, int r38, boolean r39, boolean r40, IRoom r41, String r42, String r43, String r44, String r45, boolean r46, boolean r47, String r48, String r49, x00.a r50, w0 r51, Map r52, String r53, LinkApplyType r54) {
        Intrinsics.checkNotNullParameter("live_chat", "guestConnectionType");
        Intrinsics.checkNotNullParameter(r45, "linkCnt");
        String r6 = "is_quick_invite";
        Intrinsics.checkNotNullParameter(r48, "is_quick_invite");
        Intrinsics.checkNotNullParameter(r51, "logParams");
        HashMap r15 = new HashMap();
        if (r41 == null) goto L9;
        ICircleInfo r10 = r41.getCircleInfo();
        if (r10 == null) goto L9;
        String r11 = r10.getCircleName();
        if (r11 == null) goto L9;
        r15.put("circle_name", r11);
        Unit r12 = Unit.INSTANCE;
    L9:
        if (r41 == null) goto L13;
        String r13 = r41.getRequestId();
        if (r13 == null) goto L13;
        r15.put("request_id", r13);
        Unit r14 = Unit.INSTANCE;
    L13:
        J0(r15);
        u0(r15);
        if (r35 != null) goto L16;
        String r16 = "";
    L17:
        r15.put("connect_type", r16);
        if (Intrinsics.areEqual(r35, "apply") == false) goto L69;
        int r17 = bh0.a.a;
        if (r38 != 101) goto L23;
        r15.put("request_page", "seat");
    L59:
        Object r21 = "card";
    L82:
        if (Intrinsics.areEqual(r35, "apply") == false) goto L88;
        if (r39 == false) goto L85;
        Object r5 = "0";
    L86:
        r15.put("is_approve_needed", r5);
        goto L88
    L85:
        r5 = "1";
    L88:
        if (tc0.c.h().K != LinkApplyType.MATCH.getValue()) goto L90;
        r15.put("request_page", tc0.c.h().L.getValue());
    L90:
        int r7 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
        if (r42 == null) goto L93;
        r15.put("function_type", r42);
        Unit r8 = Unit.INSTANCE;
    L94:
        V0(r15);
        Q0(r15);
        if (r47 == false) goto L97;
        Object r1 = "1";
    L98:
        r15.put("is_camera_open", r1);
        if (r49 == null) goto L101;
        r15.put("tag_type", r49);
    L101:
        if (r50 == null) goto L103;
        e1(r15, r50.q(r50.e()));
    L103:
        fj0.a r2 = fj0.b.a;
        fj0.a r3 = fj0.b.a;
        if (r3.b == true) goto L106;
    L108:
        Object r4 = "0";
    L109:
        r15.put("is_rechargeble", r4);
        long r23 = 0;
        if (fj0.e.l() == false) goto L143;
        r15.put("recharge_mode", "normal");
        com.bytedance.android.live.liveinteract.api.data.a.h.getClass();
        r15.put("recharge_price", String.valueOf(com.bytedance.android.live.liveinteract.api.data.a.C0017a.g()));
        if (fj0.e.g(r41) == false) goto L123;
        com.bytedance.android.live.liveinteract.plantform.model.n0 r9 = tc0.c.h().P;
        if (r9 == null) goto L116;
        long r25 = r9.getPaidAmount();
    L117:
        long r26 = r25 - ((long) com.bytedance.android.live.liveinteract.api.data.a.C0017a.g());
        if (r26 < 0) goto L120;
        String r18 = String.valueOf(r26);
    L121:
        r15.put("add_price", r18);
        goto L123
    L120:
        r18 = String.valueOf(r3.f);
        goto L121
    L116:
        r25 = 0;
    L123:
        r15.put("time", String.valueOf(fj0.a.b()));
        b1 r19 = (b1) com.bytedance.android.livesdk.sharedpref.c.g1.getValue();
        r15.put("rechargeable_label", fj0.b.i(r19.getSavedTagInfos()));
        r15.put("rechargeable_intro", r19.getSavedDesc());
        Integer r20 = (Integer) com.bytedance.android.livesdk.sharedpref.c.w.getValue();
        PaidLinkMicContext r22 = PaidLinkMicContext.Companion.getContext();
        if (r22 == null) goto L130;
        com.bytedance.live.datacontext.m<Integer> r24 = r22.getDiscountMode();
        if (r24 == null) goto L130;
        Integer r27 = (Integer) r24.getValue();
        if (r27 == null) goto L130;
        int r28 = r27.intValue();
    L131:
        if (r28 != 1) goto L133;
        String r29 = "vip";
    L140:
        r15.put("discount_type", r29);
        S0(r15, r20.intValue(), r28);
        if (r3.g == false) goto L144;
        r15.put("is_vip_recharge_privilege", "1");
    L144:
        y0(r15, true);
        gk0.a.b.getClass();
        r15.put("previous_page", gk0.a.C0214a.c());
        L0(r15);
        v0(r15);
        V0(r15);
        if (r40 == false) goto L147;
        Object r30 = "1";
    L148:
        r15.put("is_full", r30);
        w0(r15);
        r15.put(r6, r48);
        r15.put("match_enter_from", gk0.a.C0214a.a());
        Intrinsics.checkNotNullParameter(r15, "logMap");
        com.bytedance.android.livesdk.log.filter.o r31 = com.bytedance.android.livesdk.log.j0.l().c(am2.x.class);
        if ((r31 instanceof com.bytedance.android.livesdk.log.filter.t) == true) goto L151;
        r31 = null;
    L151:
        com.bytedance.android.livesdk.log.filter.t r32 = (com.bytedance.android.livesdk.log.filter.t) r31;
        if (r32 == null) goto L178;
        String r33 = r32.f();
        if (r33 != null) goto L157;
    L160:
        boolean r34 = true;
    L161:
        if (r34 == false) goto L164;
        r33 = null;
    L164:
        if (r33 == null) goto L166;
        r15.put("from_user_id", r33);
    L166:
        String r55 = r32.A();
        if (r55 != null) goto L169;
    L172:
        boolean r56 = true;
    L173:
        if (r56 == false) goto L176;
        r55 = null;
    L176:
        if (r55 == null) goto L178;
        r15.put("from_user_type", r55);
        goto L178
    L169:
        if (r55.length() == 0) goto L172;
        r56 = false;
        goto L173
    L157:
        if (r33.length() == 0) goto L160;
        r34 = false;
    L178:
        Z0(r15);
        if (com.bytedance.android.live.liveinteract.utils.g1.b() == false) goto L181;
        Object r57 = "1";
    L182:
        r15.put("is_priority_queue", r57);
        if (com.bytedance.android.live.liveinteract.utils.g1.b() == false) goto L188;
        com.bytedance.android.live.liveinteract.plantform.model.n0 r58 = tc0.c.h().P;
        if (r58 == null) goto L187;
        r23 = r58.getPaidAmount();
    L187:
        String r59 = String.valueOf(r23);
    L189:
        r15.put("pay_amt", r59);
        r15.put("is_guest_apply_allowed", String.valueOf(((Boolean) b6.k.getValue()).booleanValue()));
        r15.put("is_fans_only", String.valueOf(((Boolean) com.bytedance.android.livesdk.sharedpref.c.p1.getValue()).booleanValue()));
        if (r43 == null) goto L193;
        r15.put("layout_type", r43);
    L193:
        if (Intrinsics.areEqual((String) r15.get("request_page"), "live_song") == false) goto L195;
    L198:
        r15.put("guest_connection_type", "live_song");
    L199:
        if (r40 == false) goto L201;
        Object r0 = "1";
    L202:
        r15.put("is_candidate", r0);
        r15.put("link_cnt", r45);
        if (r46 == false) goto L205;
        Object r60 = "1";
    L206:
        r15.put("is_fans_guide", r60);
        if (Intrinsics.areEqual(r51.a, "invite") == false) goto L209;
    L212:
        r15.put("from_user_id", r51.b.toString());
        if (Intrinsics.areEqual(r51.b, r51.c) == false) goto L215;
        r15.put("from_user_type", "anchor");
    L216:
        if (r36 == null) goto L220;
        long r61 = r36.longValue();
        Object r410 = "admin";
        if (r15.containsValue("invite_mutual") == true) goto L221;
        r15.put("wait_time", String.valueOf(r61));
    L221:
        if (r37 == null) goto L223;
        r15.put("watch_duration", String.valueOf(r37.longValue()));
    L223:
        if (r52 == null) goto L230;
        Iterator r62 = r52.entrySet().iterator();
    L226:
        if (r62.hasNext() == false) goto L228;
        Map.Entry r63 = (Map.Entry) r62.next();
        r15.put(r63.getKey(), r63.getValue());
        goto L226
    L228:
        Unit r65 = Unit.INSTANCE;
    L230:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.s1.getValue()).booleanValue() == false) goto L232;
        Object r66 = "1";
    L233:
        r15.put("is_invite_only", r66);
        E0(r15);
        ii0.a.c(r15, true);
        O0(r15);
        com.bytedance.android.live.liveinteract.linkcast.g.b.getClass();
        com.bytedance.android.live.liveinteract.linkcast.g.a.f(r15, null);
        if (((IInteractService) jc1.k.n(IInteractService.class)).dynamicFromAudience() == false) goto L237;
        r15.put("function_type2", "new_audience");
    L237:
        if (us1.e.a == false) goto L240;
        r15.put("is_from_audience", "0");
    L240:
        if (us1.e.a == false) goto L242;
        r15.put("source", "pre_apply");
    L242:
        Object r210 = r410;
        Object r310 = r21;
        com.bytedance.android.live.liveinteract.utils.m0 r67 = new com.bytedance.android.live.liveinteract.utils.m0(r35, r38, r39, r45, r46, r47, r48, r41, r42, r36, null, 31744);
        Intrinsics.checkNotNullParameter(r67, "params");
        l = r67;
        com.bytedance.android.live.liveinteract.utils.f0.b(r15);
        com.bytedance.live.datacontext.j r68 = com.bytedance.android.live.liveinteract.api.utils.m.i().A2();
        if (r68 == null) goto L245;
        DataCenter r110 = (DataCenter) r68.getValue();
    L246:
        if (r110 == null) goto L248;
        Boolean r69 = (Boolean) r110.get("data_audience_pre_linkmic_waiting", Boolean.FALSE);
    L249:
        Boolean r70 = Boolean.TRUE;
        if (Intrinsics.areEqual(r69, r70) == false) goto L252;
        r15.put("pre_status", "1");
    L253:
        if (r110 == null) goto L255;
        Boolean r111 = (Boolean) r110.get("data_linkmic_prepare_reply", Boolean.FALSE);
    L257:
        if (Intrinsics.areEqual(r111, r70) == false) goto L269;
        r15.put("pre_status", "1");
        if (r38 != 113) goto L262;
        r15.put("request_page", r310);
    L264:
        r15.put("from_user_id", r51.b.toString());
        if (Intrinsics.areEqual(r51.b, r51.c) == false) goto L267;
        r15.put("from_user_type", "anchor");
        goto L269
    L267:
        r15.put("from_user_type", r210);
        goto L269
    L262:
        if (r38 != 116) goto L264;
        r15.put("request_page", "associated_invite");
    L269:
        if (je0.d.f() != 12) goto L277;
        CPositionContext r71 = CPositionContext.Companion.getContext();
        if (r71 == null) goto L277;
        com.bytedance.live.datacontext.m<Boolean> r72 = r71.isCPositionOpen();
        if (r72 == null) goto L277;
        char r73 = 1;
        if (((Boolean) r72.getValue()).booleanValue() != true) goto L278;
        x0(r15);
    L278:
        li0.b r74 = li0.b.b;
        li0.b.i(r15);
        IInteractService r75 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r75 == null) goto L284;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r76 = r75.getLinkUserInfoCenter();
        if (r76 == null) goto L284;
        G0(r76.O4(je0.d.b0()), r15);
    L284:
        if (TextUtils.isEmpty(r44) == true) goto L286;
        Intrinsics.checkNotNull(r44);
        r15.put("current_enlarge_user_type", r44);
    L286:
        r15.put("ordering_mode", v());
        String r77 = qi0.a.a;
        qi0.a.i = System.currentTimeMillis();
        com.bytedance.android.livesdk.log.j0 r78 = com.bytedance.android.livesdk.log.j0.l();
        Object[] r79 = new Object[2];
        r79[0] = IRoom.class;
        r79[r73] = am2.x.class;
        r78.sendLog("livesdk_guest_connection_success", r15, r79);
        return;
    L277:
        r73 = 1;
        goto L278
    L255:
        r111 = null;
        goto L257
    L252:
        r15.put("pre_status", "0");
        goto L253
    L248:
        r69 = null;
        goto L249
    L245:
        r110 = null;
        goto L246
    L232:
        r66 = "0";
        goto L233
    L220:
        r410 = "admin";
        goto L221
    L215:
        r15.put("from_user_type", "admin");
        goto L216
    L209:
        if (Intrinsics.areEqual(r51.a, "game_invite") == true) goto L212;
        if (Intrinsics.areEqual(r51.a, "gift_message_invite") == false) goto L216;
    L205:
        r60 = "0";
        goto L206
    L201:
        r0 = "0";
        goto L202
    L195:
        if (Intrinsics.areEqual((String) r15.get("request_page"), "live_chorus") == true) goto L198;
        r15.put("guest_connection_type", "live_chat");
        goto L199
    L188:
        r59 = "0";
        goto L189
    L181:
        r57 = "0";
        goto L182
    L147:
        r30 = "0";
        goto L148
    L133:
        if (r28 != 2) goto L135;
        r29 = "activity";
        goto L140
    L135:
        if (r28 == 3) goto L137;
        r29 = "";
        goto L140
    L137:
        r29 = "strategy";
    L130:
        r28 = 0;
        goto L131
    L143:
        r6 = "is_quick_invite";
        goto L144
    L106:
        if (fj0.e.l() == false) goto L108;
        r4 = "1";
        goto L109
    L97:
        r1 = "0";
        goto L98
    L93:
        B0(r15, Integer.valueOf(r7), null, 4);
        Unit r80 = Unit.INSTANCE;
        goto L94
    L23:
        if (r38 != 102) goto L26;
        r15.put("request_page", "bottom");
        goto L59
    L26:
        if (r38 != 103) goto L29;
        r15.put("request_page", "popup");
        goto L59
    L29:
        if (r38 != 110) goto L32;
        r15.put("request_page", "task");
        goto L59
    L32:
        if (r38 != 111) goto L35;
        r15.put("request_page", "top");
        goto L59
    L35:
        if (r38 != 113) goto L38;
        r15.put("request_page", "card");
        goto L59
    L38:
        if (r38 != 112) goto L41;
        r15.put("request_page", "apply_panel");
        goto L59
    L41:
        if (r38 != 114) goto L48;
        if (r54 != LinkApplyType.KTV_MULTI_CHORUS) goto L45;
        Object r81 = "live_chorus";
    L46:
        r15.put("request_page", r81);
        goto L59
    L45:
        r81 = "live_song";
        goto L46
    L48:
        if (r38 != 115) goto L51;
        r15.put("request_page", "associated_apply");
        goto L59
    L51:
        if (r38 != 116) goto L54;
        r15.put("request_page", "associated_invite");
        goto L59
    L54:
        if (r38 != 118) goto L57;
        r15.put("request_page", "preview_theme_promote_link");
        goto L59
    L57:
        if (r38 != 119) goto L60;
        r15.put("request_page", "preview_game_promote_link");
        goto L59
    L60:
        r21 = "card";
        if (tc0.c.h().J != 114) goto L82;
        if (r54 != LinkApplyType.KTV_MULTI_CHORUS) goto L66;
        Object r82 = "live_chorus";
    L67:
        r15.put("request_page", r82);
        goto L82
    L66:
        r82 = "live_song";
        goto L67
    L69:
        r21 = "card";
        if (Intrinsics.areEqual(r35, "invite") == false) goto L76;
        if (r38 != 116) goto L76;
        r15.put("request_page", "associated_invite");
    L76:
        if (TextUtils.isEmpty(r53) == true) goto L82;
        if (r53 != null) goto L79;
        String r83 = "";
    L80:
        r15.put("request_page", r83);
        goto L82
    L79:
        r83 = r53;
        goto L80
    L16:
        r16 = r35;
        goto L17
    }

    public static /* synthetic */ void b0(String r23, Long r24, Long r25, int r26, boolean r27, boolean r28, IRoom r29, String r30, String r31, String r32, String r33, boolean r34, boolean r35, String r36, String r37, x00.a r38, w0 r39, Map r40, String r41, LinkApplyType r42, int r43) {
        if ((r43 & 2) == 0) goto L5;
        Long r4 = null;
    L7:
        if ((r43 & 4) == 0) goto L9;
        Long r5 = null;
    L11:
        if ((r43 & 128) == 0) goto L13;
        String r10 = null;
    L15:
        if ((r43 & 256) == 0) goto L17;
        String r11 = null;
    L19:
        if ((r43 & 512) == 0) goto L21;
        String r12 = null;
    L23:
        if ((32768 & r43) == 0) goto L25;
        String r17 = null;
    L27:
        if ((65536 & r43) == 0) goto L29;
        x00.a r18 = null;
    L31:
        if ((262144 & r43) == 0) goto L33;
        Map r20 = null;
    L35:
        if ((524288 & r43) == 0) goto L37;
        String r21 = null;
    L39:
        if ((r43 & 1048576) == 0) goto L41;
        LinkApplyType r22 = null;
    L42:
        a0(r23, r4, r5, r26, r27, r28, r29, r10, r11, r12, r33, r34, r35, r36, r17, r18, r39, r20, r21, r22);
        return;
    L41:
        r22 = r42;
        goto L42
    L37:
        r21 = r41;
        goto L39
    L33:
        r20 = r40;
        goto L35
    L29:
        r18 = r38;
        goto L31
    L25:
        r17 = r37;
        goto L27
    L21:
        r12 = r32;
        goto L23
    L17:
        r11 = r31;
        goto L19
    L13:
        r10 = r30;
        goto L15
    L9:
        r5 = r25;
        goto L11
    L5:
        r4 = r24;
        goto L7
    }

    @JvmStatic
    public static final void Y(String r18, Long r19, Long r20, Long r21, int r22, LinkApplyType r23, boolean r24, String r25, IRoom r26, String r27, String r28, String r29, String r30, String r31, String r32, boolean r33, String r34, String r35, String r36, x00.a r37, com.bytedance.android.live.liveinteract.videotalk.utils.a r38, oe0.b r39, w0 r40, Map r41, String r42, String r43) {
        Intrinsics.checkNotNullParameter(r23, "applyType");
        Intrinsics.checkNotNullParameter(r27, "overType");
        Intrinsics.checkNotNullParameter("live_chat", "guestConnectionType");
        Intrinsics.checkNotNullParameter(r40, "logParams");
        HashMap r14 = new HashMap();
        if (r26 == null) goto L9;
        ICircleInfo r16 = r26.getCircleInfo();
        if (r16 == null) goto L9;
        String r10 = r16.getCircleName();
        if (r10 == null) goto L9;
        r14.put("circle_name", r10);
        Unit r7 = Unit.INSTANCE;
    L9:
        if (r26 == null) goto L13;
        String r8 = r26.getRequestId();
        if (r8 == null) goto L13;
        r14.put("request_id", r8);
        Unit r9 = Unit.INSTANCE;
    L13:
        J0(r14);
        u0(r14);
        String r11 = r();
        if (r11 != null) goto L18;
        if (r18 != null) goto L17;
        r11 = "";
        String r17 = r11;
    L19:
        r14.put("connect_type", r11);
        String r15 = "0";
        if (Intrinsics.areEqual(r18, "apply") == false) goto L32;
        String r0 = w(r22, r23);
        if (r0 == null) goto L25;
        r14.put("request_page", r0);
        Unit r1 = Unit.INSTANCE;
    L25:
        if (tc0.c.h().K != LinkApplyType.MATCH.getValue()) goto L28;
        r14.put("request_page", tc0.c.h().L.getValue());
    L28:
        if (r24 == false) goto L30;
        r14.put("is_approve_needed", "0");
    L42:
        r14.put("over_type", r27);
        if ("gift_message_invite".equals(r40.a) == false) goto L47;
        IMessageBoardInfo r2 = r40.d;
        if (r2 == null) goto L47;
        r14.put("message_text", com.bytedance.android.live.liveinteract.plantform.model.f0.a(r2));
        Unit r3 = Unit.INSTANCE;
    L47:
        if (r28 == null) goto L49;
        r14.put("break_page", r28);
        Unit r4 = Unit.INSTANCE;
    L49:
        String r5 = tc0.c.h().M;
        if (TextUtils.isEmpty(r5) == true) goto L53;
        r14.put("is_task", "1");
        r14.put("activity_name", r5);
    L53:
        if (((IInteractService) jc1.k.n(IInteractService.class)).dynamicFromAudience() == false) goto L55;
    L63:
        r14.put("function_type", "new_audience");
        r14.put("function_type2", "new_audience");
    L65:
        if (us1.e.a == false) goto L67;
        r14.put("source", "pre_apply");
        r14.put("request_page", "bottom");
    L67:
        w0(r14);
        if (r33 == false) goto L70;
        Object r6 = "1";
    L71:
        r14.put("is_camera_open", r6);
        DigitAvatarContext r12 = DigitAvatarContext.Companion.getContext();
        if (r12 == null) goto L78;
        com.bytedance.live.datacontext.m<Boolean> r13 = r12.getUsedAvatarThisLinkRound();
        if (r13 == null) goto L78;
        if (((Boolean) r13.getValue()).booleanValue() != true) goto L78;
        Object r44 = "1";
    L79:
        r14.put("is_avatar_used", r44);
        if (r25 == null) goto L82;
        r14.put("link_cnt", r25);
        Unit r45 = Unit.INSTANCE;
    L82:
        if (r34 == null) goto L84;
        r14.put("camera_duration", r34);
        Unit r46 = Unit.INSTANCE;
    L84:
        if (r35 == null) goto L93;
        r14.put("talk_duration", r35);
        if (fj0.b.a.b == true) goto L88;
    L90:
        Object r47 = "0";
    L91:
        r14.put("is_rechargeble", r47);
        Unit r48 = Unit.INSTANCE;
        goto L93
    L88:
        if (fj0.e.l() == false) goto L90;
        r47 = "1";
    L93:
        if (fj0.e.l() == false) goto L127;
        r14.put("recharge_mode", "normal");
        com.bytedance.android.live.liveinteract.api.data.a.h.getClass();
        int r49 = com.bytedance.android.live.liveinteract.api.data.a.C0017a.g();
        r14.put("recharge_price", String.valueOf(r49));
        if (fj0.e.g(r26) == false) goto L105;
        com.bytedance.android.live.liveinteract.plantform.model.n0 r50 = tc0.c.h().P;
        if (r50 == null) goto L99;
        long r51 = r50.getPaidAmount();
    L100:
        long r52 = r51 - ((long) r49);
        if (r52 < 0) goto L103;
        String r53 = String.valueOf(r52);
    L104:
        r14.put("add_price", r53);
        goto L105
    L103:
        r53 = String.valueOf(fj0.b.a.f);
        goto L104
    L99:
        r51 = 0;
    L105:
        fj0.a r54 = fj0.b.a;
        fj0.a r55 = fj0.b.a;
        r55.getClass();
        r14.put("time", String.valueOf(fj0.a.b()));
        b1 r56 = (b1) com.bytedance.android.livesdk.sharedpref.c.g1.getValue();
        r14.put("rechargeable_label", fj0.b.i(r56.getSavedTagInfos()));
        r14.put("rechargeable_intro", r56.getSavedDesc());
        PaidLinkMicContext r57 = PaidLinkMicContext.Companion.getContext();
        if (r57 == null) goto L112;
        com.bytedance.live.datacontext.m<Integer> r58 = r57.getDiscountMode();
        if (r58 == null) goto L112;
        Integer r59 = (Integer) r58.getValue();
        if (r59 == null) goto L112;
        int r60 = r59.intValue();
    L114:
        if (r60 != 1) goto L116;
        String r61 = "vip";
    L123:
        r14.put("discount_type", r61);
        S0(r14, r49, r60);
        if (r55.g == false) goto L127;
        r14.put("is_vip_recharge_privilege", "1");
        goto L127
    L116:
        if (r60 != 2) goto L118;
        r61 = "activity";
        goto L123
    L118:
        if (r60 == 3) goto L120;
        r61 = r17;
        goto L123
    L120:
        r61 = "strategy";
    L112:
        r60 = 0;
    L127:
        if (com.bytedance.android.live.liveinteract.utils.g1.b() == false) goto L129;
        Object r62 = "1";
    L130:
        r14.put("is_priority_queue", r62);
        if (com.bytedance.android.live.liveinteract.utils.g1.b() == false) goto L137;
        com.bytedance.android.live.liveinteract.plantform.model.n0 r63 = tc0.c.h().P;
        if (r63 == null) goto L135;
        long r65 = r63.getPaidAmount();
    L136:
        String r66 = String.valueOf(r65);
    L138:
        r14.put("pay_amt", r66);
        r14.put("is_guest_apply_allowed", String.valueOf(((Boolean) b6.k.getValue()).booleanValue()));
        r14.put("is_fans_only", String.valueOf(((Boolean) com.bytedance.android.livesdk.sharedpref.c.p1.getValue()).booleanValue()));
        Z0(r14);
        M0(r14, r22, null, true, 4);
        T0(r14, false);
        Q0(r14);
        y0(r14, true);
        com.bytedance.android.livesdk.log.filter.o r67 = com.bytedance.android.livesdk.log.j0.l().c(am2.x.class);
        if ((r67 instanceof com.bytedance.android.livesdk.log.filter.t) == true) goto L141;
        r67 = null;
    L141:
        com.bytedance.android.livesdk.log.filter.t r68 = (com.bytedance.android.livesdk.log.filter.t) r67;
        if (r68 == null) goto L144;
        r68.F(null);
    L144:
        int r69 = LinkDistributeSettingDialog.i;
        r14.put("distribute_status", LinkDistributeSettingDialog.a.a());
        gk0.a.b.getClass();
        r14.put("previous_page", gk0.a.C0214a.c());
        L0(r14);
        if (r37 == null) goto L148;
        e1(r14, r37.q(r37.e()));
        Unit r70 = Unit.INSTANCE;
    L148:
        if (com.bytedance.android.live.liveinteract.voicechat.util.e.a(true) == false) goto L150;
        r14.put("is_pre_link", "1");
    L152:
        if (r30 == null) goto L155;
        r14.put("layout_type", r30);
        Unit r71 = Unit.INSTANCE;
    L155:
        if (Intrinsics.areEqual((String) r14.get("request_page"), "live_song") == false) goto L157;
    L160:
        r14.put("guest_connection_type", "live_song");
    L161:
        if (r19 == null) goto L163;
        r14.put("duration", String.valueOf(r19.longValue()));
        Unit r72 = Unit.INSTANCE;
    L163:
        v0(r14);
        V0(r14);
        Object r73 = "request_page";
        if (r38 != null) goto L166;
        r73 = r73;
    L177:
        if (r39 == null) goto L179;
        r14.put("double_enlarge_duration", String.valueOf((r39.b() + ((long) 500)) / ((long) 1000)));
        Unit r74 = Unit.INSTANCE;
    L179:
        Intrinsics.checkNotNullParameter(r14, "logParam");
        com.bytedance.android.live.liveinteract.plantform.model.n0 r75 = tc0.c.h().P;
        if (r75 == null) goto L203;
        r14.put("ordering_mode", v());
        String r76 = r75.getFanTicket();
        if (r76 != null) goto L184;
        r76 = "0";
    L184:
        r14.put("money", r76);
        long r77 = r75.getRank();
        if (r77 != 1) goto L188;
        String r78 = "top1";
    L194:
        r14.put("top_r", r78);
        IBaseUser r79 = r75.getUserFlex();
        if (r79 == null) goto L197;
        String r80 = r79.getRelationship();
    L198:
        r14.put("relationship", String.valueOf(r80));
        IBaseUser r81 = r75.getUserFlex();
        if (r81 == null) goto L201;
        Integer r82 = Integer.valueOf(r81.getLevel());
    L202:
        r14.put("contribution_level", String.valueOf(r82));
        goto L203
    L201:
        r82 = null;
        goto L202
    L197:
        r80 = null;
        goto L198
    L188:
        if (r77 != 2) goto L191;
        r78 = "top2";
        goto L194
    L191:
        if (r77 != 3) goto L193;
        r78 = "top3";
        goto L194
    L193:
        r78 = "null";
    L203:
        if (r20 == null) goto L208;
        long r83 = r20.longValue();
        if (r14.containsValue("invite_mutual") == true) goto L207;
        r14.put("wait_time", String.valueOf(r83));
    L207:
        Unit r84 = Unit.INSTANCE;
    L208:
        if (r21 == null) goto L211;
        r14.put("watch_duration", String.valueOf(r21.longValue()));
        Unit r85 = Unit.INSTANCE;
    L211:
        if (r32 == null) goto L213;
        r14.put("tag_type", r32);
        Unit r86 = Unit.INSTANCE;
    L213:
        r14.put("mic_type", "normal_mic");
        if (r36 == null) goto L216;
        r14.put("seat_position", r36);
        Unit r87 = Unit.INSTANCE;
    L216:
        r14.put("is_invite_only", String.valueOf(((Boolean) com.bytedance.android.livesdk.sharedpref.c.s1.getValue()).booleanValue()));
        if (r41 == null) goto L223;
        Iterator r88 = r41.entrySet().iterator();
    L220:
        if (r88.hasNext() == false) goto L222;
        Map.Entry r89 = (Map.Entry) r88.next();
        r14.put(r89.getKey(), r89.getValue());
        goto L220
    L222:
        Unit r90 = Unit.INSTANCE;
    L223:
        ii0.a.c(r14, true);
        O0(r14);
        com.bytedance.android.live.liveinteract.linkcast.g.b.getClass();
        com.bytedance.android.live.liveinteract.linkcast.g.a.a();
        String r91 = null;
        com.bytedance.android.live.liveinteract.linkcast.g.a.f(r14, null);
        com.bytedance.live.datacontext.j r92 = com.bytedance.android.live.liveinteract.api.utils.m.i().A2();
        if (r92 == null) goto L226;
        DataCenter r93 = (DataCenter) r92.getValue();
    L227:
        if (r93 == null) goto L229;
        Boolean r94 = (Boolean) r93.get("data_audience_pre_linkmic_waiting", Boolean.FALSE);
    L230:
        Boolean r95 = Boolean.TRUE;
        if (Intrinsics.areEqual(r94, r95) == false) goto L233;
        r14.put("pre_status", "1");
    L235:
        if (r93 == null) goto L237;
        Boolean r96 = (Boolean) r93.get("data_linkmic_prepare_reply", Boolean.FALSE);
    L239:
        if (Intrinsics.areEqual(r96, r95) == false) goto L253;
        r14.put("pre_status", "1");
        if (r22 != 113) goto L243;
        r14.put(r73, "card");
    L246:
        r14.put("from_user_id", r40.b.toString());
        if (Intrinsics.areEqual(r40.b, r40.c) == false) goto L249;
        r14.put("from_user_type", "anchor");
    L250:
        if (r93 == null) goto L253;
        r93.put("data_linkmic_prepare_reply", Boolean.FALSE);
        goto L253
    L249:
        r14.put("from_user_type", "admin");
        goto L250
    L243:
        Object r97 = r73;
        if (r22 != 116) goto L246;
        r14.put(r97, "associated_invite");
    L253:
        if (je0.d.f() != 12) goto L261;
        CPositionContext r98 = CPositionContext.Companion.getContext();
        if (r98 == null) goto L261;
        com.bytedance.live.datacontext.m<Boolean> r99 = r98.isCPositionOpen();
        if (r99 == null) goto L261;
        if (((Boolean) r99.getValue()).booleanValue() != true) goto L261;
        x0(r14);
    L261:
        li0.b r100 = li0.b.b;
        li0.b.i(r14);
        IInteractService r101 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r101 == null) goto L266;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r102 = r101.getLinkUserInfoCenter();
        if (r102 == null) goto L266;
        int r103 = r102.O4(je0.d.b0());
    L267:
        G0(r103, r14);
        if (TextUtils.isEmpty(r31) == true) goto L271;
        Intrinsics.checkNotNull(r31);
        r14.put("current_enlarge_user_type", r31);
    L271:
        if (jc0.a.a == false) goto L273;
        Object r104 = "1";
    L274:
        r14.put("is_lead_singer", r104);
        if (jc0.a.b == false) goto L277;
        r15 = "1";
    L277:
        r14.put("is_setting_lead", r15);
        if (r43 != null) goto L280;
    L287:
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_guest_connection_over", r14, new Object[]{IRoom.class, am2.x.class});
        return;
    L280:
        if (r43.length() <= 0) goto L282;
        boolean r105 = true;
    L283:
        if (r105 == false) goto L285;
        r91 = r43;
    L285:
        if (r91 == null) goto L287;
        r14.put("connection_over_type_detail", r91);
        Unit r106 = Unit.INSTANCE;
        goto L287
    L282:
        r105 = false;
        goto L283
    L273:
        r104 = "0";
    L266:
        r103 = -1;
        goto L267
    L237:
        r96 = null;
        goto L239
    L233:
        r14.put("pre_status", "0");
        goto L235
    L229:
        r94 = null;
        goto L230
    L226:
        r93 = null;
        goto L227
    L166:
        if (r38.e == false) goto L168;
        Object r107 = "1";
    L169:
        r14.put("is_guest_enlarged_before", r107);
        if (r38.h == true) goto L172;
    L174:
        long r108 = r38.d;
    L175:
        r14.put("enlarge_duration", String.valueOf((r108 + ((long) 500)) / ((long) 1000)));
        Unit r109 = Unit.INSTANCE;
        goto L177
    L172:
        if (r38.c <= 0) goto L174;
        r108 = r38.d + (SystemClock.elapsedRealtime() - r38.c);
        goto L175
    L168:
        r107 = "0";
        goto L169
    L157:
        if (Intrinsics.areEqual((String) r14.get("request_page"), "live_chorus") == true) goto L160;
        r14.put("guest_connection_type", "live_chat");
        goto L161
    L150:
        r14.put("is_pre_link", "0");
        goto L152
    L135:
        r65 = 0;
        goto L136
    L137:
        r66 = "0";
        goto L138
    L129:
        r62 = "0";
    L78:
        r44 = "0";
        goto L79
    L70:
        r6 = "0";
        goto L71
    L55:
        if (((IInteractService) jc1.k.n(IInteractService.class)).dynamicFromAudience() == true) goto L63;
        if ("new_audience".equals(r29) == true) goto L63;
        if (r29 == null) goto L61;
        r14.put("function_type", r29);
        r14.put("function_type2", r29);
    L62:
        Unit r110 = Unit.INSTANCE;
        goto L65
    L61:
        B0(r14, null, null, 6);
        goto L62
    L30:
        r14.put("is_approve_needed", "1");
        goto L42
    L32:
        if (Intrinsics.areEqual(r18, "invite") == false) goto L37;
        if (r22 != 116) goto L37;
        r14.put("request_page", "associated_invite");
    L37:
        if (TextUtils.isEmpty(r42) == true) goto L42;
        if (r42 != null) goto L40;
        String r111 = r17;
    L41:
        r14.put("request_page", r111);
        goto L42
    L40:
        r111 = r42;
        goto L41
    L17:
        r11 = r18;
    L18:
        r17 = "";
        goto L19
    }

    public static /* synthetic */ void Z(String r29, Long r30, Long r31, Long r32, int r33, LinkApplyType r34, boolean r35, String r36, IRoom r37, String r38, String r39, String r40, String r41, String r42, String r43, boolean r44, String r45, String r46, String r47, x00.a r48, com.bytedance.android.live.liveinteract.videotalk.utils.a r49, oe0.b r50, w0 r51, Map r52, String r53, int r54) {
        if ((r54 & 4) == 0) goto L5;
        Long r5 = null;
    L7:
        if ((r54 & 8) == 0) goto L9;
        Long r6 = null;
    L11:
        if ((r54 & 128) == 0) goto L13;
        String r10 = null;
    L15:
        if ((r54 & 2048) == 0) goto L17;
        String r14 = null;
    L19:
        if ((r54 & 4096) == 0) goto L21;
        String r15 = null;
    L23:
        if ((r54 & 8192) == 0) goto L25;
        String r16 = null;
    L27:
        if ((32768 & r54) == 0) goto L29;
        String r17 = null;
    L31:
        if ((131072 & r54) == 0) goto L33;
        String r19 = null;
    L35:
        if ((262144 & r54) == 0) goto L37;
        String r20 = null;
    L39:
        if ((524288 & r54) == 0) goto L41;
        String r21 = null;
    L43:
        if ((1048576 & r54) == 0) goto L45;
        x00.a r22 = null;
    L47:
        if ((2097152 & r54) == 0) goto L49;
        com.bytedance.android.live.liveinteract.videotalk.utils.a r23 = null;
    L51:
        if ((4194304 & r54) == 0) goto L53;
        oe0.b r24 = null;
    L55:
        if ((16777216 & r54) == 0) goto L57;
        Map r26 = null;
    L59:
        if ((r54 & 33554432) == 0) goto L61;
        String r27 = null;
    L62:
        Y(r29, r30, r5, r6, r33, r34, r35, r10, r37, r38, r39, r14, r15, r16, r17, r44, r19, r20, r21, r22, r23, r24, r51, r26, r27, null);
        return;
    L61:
        r27 = r53;
        goto L62
    L57:
        r26 = r52;
        goto L59
    L53:
        r24 = r50;
        goto L55
    L49:
        r23 = r49;
        goto L51
    L45:
        r22 = r48;
        goto L47
    L41:
        r21 = r47;
        goto L43
    L37:
        r20 = r46;
        goto L39
    L33:
        r19 = r45;
        goto L35
    L29:
        r17 = r43;
        goto L31
    L25:
        r16 = r42;
        goto L27
    L21:
        r15 = r41;
        goto L23
    L17:
        r14 = r40;
        goto L19
    L13:
        r10 = r36;
        goto L15
    L9:
        r6 = r32;
        goto L11
    L5:
        r5 = r31;
        goto L7
    }
}
