package v12;

import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revenue.common.h;
import com.bytedance.android.live.revenue.platform.trace.api.ProductId;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.p2;
import com.bytedance.android.livesdk.gift.model.y1;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.gift.platform.business.normal.model.NormalGiftMessage;
import com.bytedance.android.livesdk.message.model.o7;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.revenue.log.i;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKt_androidKt;
import com.bytedance.android.scope.m;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.revenue.platform.api.core.rx.p;
import com.bytedance.revenue.platform.api.core.rx.q;
import cy0.j;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.random.Random;
import mz0.n;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f {
    public static String a;
    public static int b;
    public static final ConcurrentHashMap<String, Map<String, Object>> c = null;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ String a;
        public final /* synthetic */ g b;

        public a(String r1, g r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            Unit r3 = (Unit) r2;
            String r4 = f.a;
            f.a(this.a, this.b);
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Unit r2 = (Unit) r1;
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
            jy0.b.b("LiveSendGiftTraceMonitor", "send gift event error", (Throwable) r3);
        }
    }

    static {
        a = BuildConfig.FLAVOR;
        c = new ConcurrentHashMap();
    }

    public static String f() {
        cy0.e.a.getClass();
        j r1 = cy0.e.a.a;
        m.e.getClass();
        Object r0 = m.b(r1).b(com.bytedance.android.livesdk.revenue.service.user.a.class);
        Intrinsics.checkNotNull(r0);
        String r2 = ((com.bytedance.live.kmp.core.c) r0).getCurrentUserId();
        com.bytedance.live.kmp.util.c r3 = com.bytedance.live.kmp.util.c.a;
        long r4 = System.currentTimeMillis();
        int r5 = (int) (Random.Default.nextDouble() * ((double) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW));
        int r6 = h.a;
        return h.a(r2 + r4 + r5);
    }

    public static String g() {
        if (a.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L13;
        cy0.e.a.getClass();
        j r1 = cy0.e.a.a;
        m.e.getClass();
        Object r2 = m.b(r1).b(com.bytedance.android.livesdk.revenue.service.user.a.class);
        Intrinsics.checkNotNull(r2);
        IBaseUser r3 = ((com.bytedance.live.kmp.core.c) r2).b();
        if (r3 == null) goto L10;
        String r4 = com.bytedance.android.live.base.model.user.m.a(r3);
    L11:
        a = r4;
        goto L13
    L10:
        r4 = BuildConfig.FLAVOR;
    L13:
        return a;
    L5:
        r0 = false;
        goto L6
    }

    public static int l() {
        if (b != 0) goto L6;
        cy0.e.a.getClass();
        j r1 = cy0.e.a.a;
        m.e.getClass();
        Object r0 = m.b(r1).b(wh6.a.class);
        Intrinsics.checkNotNull(r0);
        b = ((com.bytedance.live.kmp.core.c) r0).getAppId();
    L6:
        return b;
    }

    public static yz0.g m() {
        return com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.g.class);
    }

    public static void B(String r3) {
        Intrinsics.checkNotNullParameter(r3, "errorMessage");
        if (com.bytedance.android.livesdk.gift.platform.core.f.b() == true) goto L5;
        return;
    L5:
        JSONObject r0 = new JSONObject();
        r0.put("errormessage", r3);
        t("playExceptionEvent", "0", r0);
        com.bytedance.android.livesdk.gift.platform.core.utils.e.a("0", r3);
    }

    public static boolean O(IBaseUser r3) {
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.core.f.d.getValue(null, com.bytedance.android.livesdk.gift.platform.core.f.a[2])).booleanValue() == true) goto L6;
        return false;
    L6:
        if (r3 != null) goto L8;
    L16:
        yz0.g r4 = m();
        if (r4 != null) goto L19;
    L21:
        return false;
    L19:
        if (r4.isAnchor() != true) goto L21;
        return true;
    L8:
        if (com.bytedance.android.live.base.model.user.m.a(r3).length() != 0) goto L10;
        boolean r2 = true;
    L11:
        if (r2 == true) goto L16;
        if (Intrinsics.areEqual(com.bytedance.android.live.base.model.user.m.a(r3), g()) == false) goto L21;
        return true;
    L10:
        r2 = false;
        goto L11
    }

    public static boolean b(o7 r4) {
        if (com.bytedance.android.livesdk.gift.platform.core.f.b() == true) goto L6;
        return false;
    L6:
        if (g().length() != 0) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        return false;
    L11:
        String r1 = r4.getTraceId();
        if (r1 != null) goto L14;
    L17:
        boolean r3 = true;
    L18:
        if (r3 == false) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual("1060288732361669873273777357", r1) == false) goto L24;
        return true;
    L24:
        if (r4.isLocal() == false) goto L26;
        return true;
    L26:
        return O(r4.getToUser());
    L14:
        if (r1.length() == 0) goto L17;
        r3 = false;
        goto L18
    L8:
        r0 = false;
        goto L9
    }

    public static boolean c(v12.c r4) {
        if (com.bytedance.android.livesdk.gift.platform.core.f.b() == true) goto L6;
        return false;
    L6:
        if (g().length() != 0) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        return false;
    L11:
        if (r4 != null) goto L13;
        return false;
    L13:
        String r1 = r4.getTraceId();
        if (r1 != null) goto L16;
    L19:
        boolean r3 = true;
    L20:
        if (r3 == false) goto L23;
        return false;
    L23:
        if (Intrinsics.areEqual("1060288732361669873273777357", r1) == false) goto L26;
        return true;
    L26:
        if (r4.isLocal() == false) goto L28;
        return true;
    L28:
        return O(r4.getToUser());
    L16:
        if (r1.length() == 0) goto L19;
        r3 = false;
        goto L20
    L8:
        r0 = false;
        goto L9
    }

    public static boolean d(d r4) {
        if (com.bytedance.android.livesdk.gift.platform.core.f.b() == true) goto L5;
        return false;
    L5:
        String r0 = r4.getTraceId();
        if (r0 != null) goto L8;
    L11:
        boolean r3 = true;
    L12:
        if (r3 == false) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual("1060288732361669873273777357", r0) == false) goto L18;
        return true;
    L18:
        if (r4.isLocal() == false) goto L20;
        return true;
    L20:
        return O(r4.getToUser());
    L8:
        if (r0.length() == 0) goto L11;
        r3 = false;
        goto L12
    }

    public static String i(String r2) {
        String r3 = k(r2);
        Object r0 = null;
        if (r3 == null) goto L12;
        Map<String, Object> r4 = c.get(r3);
        if (r4 == null) goto L13;
        Object r5 = r4.get("gift_id");
        if ((r5 instanceof String) == false) goto L11;
        r0 = r5;
    L11:
        return (String) r0;
    L13:
        return null;
    L12:
        return null;
    }

    public static String k(String r5) {
        Iterator<Map.Entry<String, Map<String, Object>>> r0 = c.entrySet().iterator();
        String r1 = null;
    L4:
        if (r0.hasNext() == false) goto L8;
        Map.Entry<String, Map<String, Object>> r2 = r0.next();
        String r3 = r2.getKey();
        if (Intrinsics.areEqual(r2.getValue().get("msg_id"), r5) == false) goto L4;
        r1 = r3;
        goto L4
    L8:
        return r1;
    }

    public static void p(o7 r3) {
        Intrinsics.checkNotNullParameter(r3, "giftMessage");
        if (b(r3) == true) goto L5;
        return;
    L5:
        String r0 = r3.getTraceId();
        if (r0 != null) goto L8;
        r0 = "0";
    L8:
        e(r0, "msg_id", String.valueOf(r3.getMessageId()));
        JSONObject r1 = new JSONObject();
        J(r3, r1);
        t("mock_gift_message", r0, r1);
    }

    public static void C(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "errorMessage");
        if (com.bytedance.android.livesdk.gift.platform.core.f.b() == true) goto L5;
        return;
    L5:
        if (r3 != null) goto L7;
    L10:
        boolean r0 = true;
    L11:
        if (r0 == false) goto L13;
        r3 = "0";
    L13:
        JSONObject r1 = new JSONObject();
        r1.put("errormessage", r2);
        t("playExceptionEvent", r3, r1);
        com.bytedance.android.livesdk.gift.platform.core.utils.e.a(r3, r2);
        return;
    L7:
        if (r3.length() == 0) goto L10;
        r0 = false;
        goto L11
    }

    public static void D(v12.c r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r2, "effectMessage");
        Intrinsics.checkNotNullParameter(r3, "extra");
        if (c(r2) == true) goto L5;
        return;
    L5:
        r3.put("play_type", "mp4");
        I(r2, r3);
        String r4 = r2.getTraceId();
        if (r4 != null) goto L8;
        r4 = "0";
    L8:
        t("effect_play_begin", r4, r3);
    }

    public static void I(v12.c r4, JSONObject r5) {
        r5.put("gift_id", r4.getGiftId());
        r5.put("msg_id", String.valueOf(r4.getMsgId()));
        r5.put("effect_id", r4.getEffectId());
        r5.put("priority", r4.getPriority());
        IBaseUser r0 = r4.getToUser();
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.getIdString();
    L6:
        r5.put("toUser", r2);
        r5.put("repeatCount", r4.getRepeatCount());
        r5.put("logId", r4.getLogId());
        r5.put("isIntercepted", r4.c());
        IBaseUser r3 = r4.getFromUser();
        if (r3 == null) goto L9;
        r1 = com.bytedance.android.live.base.model.user.m.a(r3);
    L9:
        r5.put("fromUserId", r1);
        r5.put("interactGiftInfo", r4.getInteractGiftInfo());
        r5.put("resourceLocalPath", r4.b());
        r5.put("description", r4.getDescription());
        r5.put("isHarmony", false);
        return;
    L5:
        r2 = null;
        goto L6
    }

    public static void J(o7 r4, JSONObject r5) {
        r5.put("giftId", r4.getGiftId());
        r5.put("repeatCount", r4.getRepeatCount());
        r5.put("repeatEnd", r4.getRepeatEnd());
        r5.put("comboCount", r4.getComboCount());
        r5.put("groupCount", r4.getGroupCount());
        r5.put("groupId", r4.getGroupId());
        IBaseUser r0 = r4.getToUser();
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.getIdString();
    L6:
        r5.put("toUser", r2);
        r5.put("isLocal", r4.isLocal());
        r5.put("logId", r4.getLogId());
        String r3 = String.valueOf(r4.getMessageId());
        if (r3 != null) goto L9;
        r3 = BuildConfig.FLAVOR;
    L9:
        r5.put("msg_id", r3);
        IBaseUser r6 = r4.getFromUser();
        if (r6 == null) goto L12;
        r1 = r6.getIdString();
    L12:
        r5.put("fromUserId", r1);
        r5.put("isDisplayForSelf", r4.getDisplayForSelf());
        r5.put("interactGiftInfo", r4.getInteractGiftInfo());
        r5.put("roomFanTicketCount", r4.getRoomFanTicketCount());
        r5.put("fanTicketCount", r4.getFanTicketCount());
        Intrinsics.checkNotNullParameter(r4, "$this$isUrgent");
        r5.put("isUrgent", r4.isUrgent());
        r5.put("bannedDisplayEffects", r4.getBannedDisplayEffects());
        r5.put("appId", l());
        r5.put("isHarmony", false);
        return;
    L5:
        r2 = null;
        goto L6
    }

    public static void L(d r3, JSONObject r4) {
        r4.put("giftId", r3.getGiftId());
        r4.put("giftInfo", r3.getGiftInfo());
        r4.put("giftEnd", r3.d());
        r4.put("comboCount", r3.e());
        r4.put("groupCount", r3.getGroupCount());
        r4.put("groupId", r3.getGroupId());
        IBaseUser r0 = r3.getToUser();
        if (r0 == null) goto L5;
        String r1 = r0.getIdString();
    L6:
        r4.put("toUser", r1);
        r4.put("messageId", String.valueOf(r3.getMsgId()));
        r4.put("isLocal", r3.isLocal());
        r4.put("logId", r3.getLogId());
        r4.put("fromUserId", r3.getFromUserId());
        r4.put("userJson", r3.f());
        r4.put("endDescription", r3.a());
        r4.put("description", r3.getDescription());
        r4.put("isLocal", r3.isLocal());
        r4.put("assetId", r3.getAssetId());
        r4.put("appId", l());
        r4.put("isHarmony", false);
        return;
    L5:
        r1 = null;
        goto L6
    }

    public static void P(String r2, g r3) {
        Intrinsics.checkNotNullParameter(r2, "transactionId");
        Intrinsics.checkNotNullParameter(r3, "giftParams");
        if (com.bytedance.android.livesdk.gift.platform.core.f.a().J3() == false) goto L5;
        a(r2, r3);
        return;
    L5:
        int r0 = q.a;
        Single r4 = Single.just(Unit.INSTANCE).doOnSuccess(new a(r2, r3));
        int r5 = p.a;
        r4.subscribeOn(AndroidSchedulers.mainThread()).subscribe(b.a, c.a);
    }

    public static void Q(String r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r3, "transactionId");
        Intrinsics.checkNotNullParameter("0", "logId");
        if (com.bytedance.android.livesdk.gift.platform.core.f.b() == true) goto L5;
        return;
    L5:
        e(r3, "log_id", "0");
        r(1, "sendGift fail", "send_gift_callback", r3, r4);
    }

    public static void S(v12.c r1, JSONObject r2) {
        Intrinsics.checkNotNullParameter(r1, "effectMessage");
        Intrinsics.checkNotNullParameter(r2, "extra");
        if (c(r1) == true) goto L5;
        return;
    L5:
        I(r1, r2);
        String r3 = r1.getTraceId();
        if (r3 != null) goto L8;
        r3 = BuildConfig.FLAVOR;
    L8:
        t("tryConsumeEffectMessageEvent", r3, r2);
    }

    public static void a(String r13, g r14) {
        if (com.bytedance.android.livesdk.gift.platform.core.f.b() == true) goto L5;
        return;
    L5:
        yz0.g r0 = m();
        if (r0 == null) goto L54;
        IRoom r1 = r0.getRoom();
        if (r1 == null) goto L55;
        IRoom r2 = r1;
        String r3 = r2.getIdStr();
        cy0.e.a.getClass();
        j r4 = cy0.e.a.a;
        m.e.getClass();
        Object r5 = m.b(r4).b(com.bytedance.android.livesdk.revenue.service.user.a.class);
        Intrinsics.checkNotNull(r5);
        String r6 = ((com.bytedance.live.kmp.core.c) r5).getCurrentUserId();
        String r7 = IRoomKt_androidKt.getAnchorId(r2);
        Object r8 = BuildConfig.FLAVOR;
        if (r7 != null) goto L12;
        r7 = BuildConfig.FLAVOR;
    L12:
        String r9 = r14.q;
        JSONObject r10 = new JSONObject();
        r10.put("gift_id", r14.a);
        r10.put("toUserId", r14.c);
        r10.put("sendGiftFrom", r14.b.getSourceName());
        r10.put("_toRoomId", r14.d);
        r10.put("sendType", r14.e);
        r10.put("buffLevel", r14.f);
        r10.put("isCustomizeGift", r14.g);
        r10.put("sendGiftStrategy", r14.h.toString());
        r10.put("groupCount", r14.i);
        r10.put("isProp", r14.j);
        r10.put("toEpisodeId", r14.k);
        r10.put("scene", r14.l);
        r10.put("sendToAllMic", r14.m);
        r10.put("extra", r14.n);
        r10.put("isHarmony", false);
        h1 r11 = r14.p;
        if (r11 == null) goto L21;
        Intrinsics.checkNotNullParameter(r11, "$this$isFreeDisplay");
        if (r11.isFreeDisplay() == false) goto L17;
        r10.put("free_display", 1);
    L19:
        if (r11.getType() != 4) goto L21;
        r10.put("anchor_closed_sticker_effect_status", r14.s);
        goto L21
    L17:
        r10.put("free_display", 0);
    L21:
        r10.put("userTrace", r9);
        JSONArray r15 = new JSONArray();
        List<IBaseUser> r16 = r14.o;
        if (r16 == null) goto L27;
        Iterator<T> r17 = r16.iterator();
    L25:
        if (r17.hasNext() == false) goto L27;
        r15.put(((IBaseUser) r17.next()).getIdString());
    L27:
        r10.put("toUserList", r15);
        e(r13, "gift_id", String.valueOf(r14.a));
        e(r13, "room_id", r3);
        e(r13, "anchor_id", r7);
        e(r13, "user_id", r6);
        e(r13, "link_type", "0");
        t("send_gift_api", r13, r10);
        JSONObject r18 = new JSONObject();
        r18.put("action_trace", r14.q);
        JSONObject r19 = r14.r;
        if (r19 == null) goto L31;
        r8 = r19;
    L31:
        r18.put("initial_state", r8);
        Unit r110 = Unit.INSTANCE;
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.core.f.c.getValue(null, com.bytedance.android.livesdk.gift.platform.core.f.a[1])).booleanValue() == false) goto L60;
        yz0.g r111 = m();
        if (r111 == null) goto L56;
        IRoom r112 = r111.getRoom();
        if (r112 == null) goto L57;
        String r113 = IRoomKt_androidKt.getAnchorId(r112);
        if (r113 == null) goto L61;
        yz0.g r20 = m();
        if (r20 == null) goto L58;
        IRoomBase r21 = r20.getRoom();
        if (r21 == null) goto L59;
        String r23 = r21.getIdStr();
        if (r23 == null) goto L62;
        LinkedHashMap r24 = new LinkedHashMap();
        cy0.e.a.getClass();
        j r114 = cy0.e.a.a;
        m.e.getClass();
        Object r115 = m.b(r114).b(com.bytedance.android.livesdk.revenue.service.user.a.class);
        Intrinsics.checkNotNull(r115);
        String r116 = ((com.bytedance.live.kmp.core.c) r115).getCurrentUserId();
        r24.put("gift_id", j(r13, "gift_id"));
        r24.put("room_id", j(r13, "room_id"));
        r24.put("user_id", j(r13, "user_id"));
        r24.put("anchor_id", j(r13, "anchor_id"));
        r24.put("log_id", j(r13, "log_id"));
        String r25 = j(r13, "link_type");
        if (r25 != null) goto L51;
        r25 = "1";
    L51:
        r24.put("link_type", r25);
        JSONObject r26 = new JSONObject();
        j01.d.a(r26, r18);
        j01.e r27 = new j01.e("send_gift_panel_action", "gift");
        JSONObject r28 = new JSONObject();
        JSONObject r29 = new JSONObject();
        JSONObject r30 = new JSONObject();
        Intrinsics.checkNotNullParameter(r27, "metaBuilder");
        Intrinsics.checkNotNullParameter(r29, "category");
        Intrinsics.checkNotNullParameter(r30, "metric");
        Intrinsics.checkNotNullParameter(r28, "extra");
        r27.h(r13);
        r27.d(ProductId.REVENUE_GIFT_PANEL_SEND_ACTION);
        r27.i(r116);
        r27.b(r24);
        r27.g("send_gift");
        r27.f(0);
        r27.a(r113);
        r27.e(r23);
        r27.c(String.valueOf(r24.get("log_id")));
        Intrinsics.checkNotNullParameter(r30, "json");
        Intrinsics.checkNotNullParameter(r26, "jsonObject");
        j01.d.a(r30, r26);
        com.bytedance.android.live.revenue.core.util.f.a(j01.b.class).R4(r27.a, r29, r30, r28);
        return;
    L62:
        return;
    L59:
        return;
    L58:
        return;
    L61:
        return;
    L57:
        return;
    L56:
        return;
    L60:
        return;
    L55:
        return;
    }

    public static String j(String r1, String r2) {
        Map<String, Object> r3 = c.get(r1);
        Object r0 = null;
        if (r3 == null) goto L5;
        Object r4 = r3.get(r2);
    L7:
        if ((r4 instanceof String) == false) goto L11;
        r0 = r4;
    L11:
        return (String) r0;
    L5:
        r4 = null;
        goto L7
    }

    public static void q(String r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter("mockGiftMessage", "step");
        Intrinsics.checkNotNullParameter(r3, "extra");
        if (com.bytedance.android.livesdk.gift.platform.core.f.b() == true) goto L5;
        return;
    L5:
        if (r2 != null) goto L7;
    L10:
        boolean r0 = true;
    L11:
        if (r0 == false) goto L13;
        t("mockGiftMessage", "0", r3);
        return;
    L13:
        t("mockGiftMessage", r2, r3);
        return;
    L7:
        if (r2.length() == 0) goto L10;
        r0 = false;
        goto L11
    }

    public static void v(d r3, int r4) {
        if (d(r3) == true) goto L5;
        return;
    L5:
        JSONObject r0 = new JSONObject();
        String r1 = r3.getTraceId();
        if (r1 != null) goto L9;
        r1 = BuildConfig.FLAVOR;
    L9:
        if (r1.length() != 0) goto L11;
        boolean r2 = true;
    L12:
        if (r2 == false) goto L14;
        return;
    L14:
        r0.put("status", r4);
        L(r3, r0);
        t("notifyConsumeMsgEvent", r1, r0);
        return;
    L11:
        r2 = false;
        goto L12
    }

    public static void w(d r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "normalGiftMessage");
        if (d(r2) == true) goto L5;
        return;
    L5:
        JSONObject r0 = new JSONObject();
        String r1 = r2.getTraceId();
        if (r1 != null) goto L8;
        r1 = "0";
    L8:
        L(r2, r0);
        r0.put("effectPlayDone", r3);
        t("onConsumeCGiftMessageEvent", r1, r0);
    }

    public static void x(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "msgIdStr");
        Intrinsics.checkNotNullParameter(r3, "assetId");
        if (com.bytedance.android.livesdk.gift.platform.core.f.b() == true) goto L5;
        return;
    L5:
        JSONObject r0 = new JSONObject();
        String r4 = k(r2);
        if (r4 != null) goto L8;
    L11:
        boolean r1 = true;
    L12:
        if (r1 == false) goto L14;
        return;
    L14:
        r0.put("assertId", r3);
        if (r4 != null) goto L17;
        r4 = "0";
    L17:
        t("onConsumeTimeoutEvent", r4, r0);
        return;
    L8:
        if (r4.length() == 0) goto L11;
        r1 = false;
        goto L12
    }

    public static void A(String r2, JSONObject r3, Map r4) {
        Intrinsics.checkNotNullParameter(r4, "param");
        if (r2 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        t("effect_first_frame", r2, r3);
        int r5 = com.bytedance.android.livesdk.gift.platform.core.utils.e.a;
        Intrinsics.checkNotNullParameter(r4, "param");
        n r6 = new n();
        Map r7 = r6.a;
        Intrinsics.checkNotNullParameter(r7, "map");
        Intrinsics.checkNotNullParameter(r4, "map");
        r7.putAll(r4);
        mz0.m r8 = new mz0.m();
        r8.b(LogCommon.LIVE_SHARE_LOG);
        r8.b(LogCommon.ROOM);
        i r9 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r9, "pageSourceLog");
        List r0 = r8.a;
        ArrayList r10 = (ArrayList) r0;
        r10.add(r9.a);
        List r11 = r6.b;
        ArrayList r13 = (ArrayList) r11;
        r13.addAll(r8.a);
        cy0.e.a.getClass();
        j r14 = cy0.e.a.a;
        m.e.getClass();
        Object r15 = m.b(r14).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r15);
        ((f80.a) r15).w3("livesdk_gift_effect_render", r6.a, r6.b);
        return;
    L5:
        if (r2.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public static void E(String r1, long r2, boolean r4) {
        Intrinsics.checkNotNullParameter(r1, "state");
        F(r1, r2, r4, null);
    }

    public static void H(NormalGiftMessage r3, boolean r4, long r5) {
        Intrinsics.checkNotNullParameter(r3, "giftMessage");
        if (d(r3) == true) goto L5;
        return;
    L5:
        String r0 = r3.getTraceId();
        if (r0 != null) goto L8;
        r0 = "0";
    L8:
        JSONObject r1 = new JSONObject();
        r1.put("result", r4);
        r1.put("download_time", String.valueOf(r5));
        L(r3, r1);
        t("preDownloadAssetForGiftMessageEvent", r0, r1);
    }

    public static void K(d r3, int r4, List r5) {
        Intrinsics.checkNotNullParameter(r3, "giftMessage");
        Intrinsics.checkNotNullParameter(r5, "mListeners");
        if (d(r3) == true) goto L5;
        return;
    L5:
        String r0 = r3.getTraceId();
        if (r0 != null) goto L8;
        r0 = "0";
    L8:
        JSONObject r1 = new JSONObject();
        r1.put("queueSize", r4);
        L(r3, r1);
        Iterator r6 = r5.iterator();
    L10:
        if (r6.hasNext() == false) goto L12;
        r1.put("listener0", (String) r6.next());
        goto L10
    L12:
        t("putMsgIntoQueueEvent", r0, r1);
    }

    public static void M(o7 r5, boolean r6, boolean r7) {
        if (r5 != null) goto L5;
        return;
    L5:
        if (b(r5) == true) goto L7;
        return;
    L7:
        String r0 = r5.getTraceId();
        String r1 = "0";
        if (r0 != null) goto L11;
        r0 = "0";
    L11:
        if (r5.isLocal() == true) goto L30;
        cy0.e.a.getClass();
        j r3 = cy0.e.a.a;
        m.e.getClass();
        Object r2 = m.b(r3).b(com.bytedance.android.livesdk.revenue.service.user.a.class);
        Intrinsics.checkNotNull(r2);
        String r4 = ((com.bytedance.live.kmp.core.c) r2).getCurrentUserId();
        e(r0, "msg_id", String.valueOf(r5.getMessageId()));
        String r8 = String.valueOf(r5.getGiftId());
        if (r8 != null) goto L15;
        r8 = "0";
    L15:
        e(r0, "gift_id", r8);
        m0 r9 = r5.getCommonData();
        if (r9 == null) goto L19;
        Intrinsics.checkNotNullParameter(r9, "$this$roomIdKt");
        String r10 = String.valueOf(r9.getRoomId());
        if (r10 == null) goto L19;
    L20:
        e(r0, "room_id", r10);
        IBaseUser r11 = r5.getToUser();
        if (r11 == null) goto L24;
        String r13 = r11.getIdString();
        if (r13 == null) goto L24;
    L25:
        e(r0, "anchor_id", r13);
        if (r4 == null) goto L29;
        r1 = r4;
    L29:
        e(r0, "user_id", r1);
    L24:
        r13 = r4;
    L19:
        r10 = "0";
    L30:
        JSONObject r14 = new JSONObject();
        r14.put("quick_play", r7);
        J(r5, r14);
        new JSONObject().put("isViewValid", r6);
        String r15 = r5.getTraceId();
        if (r15 != null) goto L33;
        r15 = BuildConfig.FLAVOR;
    L33:
        t("receive_gift_message", r15, r14);
    }

    public static void N(o7 r5, boolean r6, int r7) {
        if (r5 != null) goto L5;
        return;
    L5:
        if (b(r5) == true) goto L7;
        return;
    L7:
        String r0 = r5.getTraceId();
        String r1 = "0";
        if (r0 != null) goto L11;
        r0 = "0";
    L11:
        if (r5.isLocal() == true) goto L30;
        cy0.e.a.getClass();
        j r3 = cy0.e.a.a;
        m.e.getClass();
        Object r2 = m.b(r3).b(com.bytedance.android.livesdk.revenue.service.user.a.class);
        Intrinsics.checkNotNull(r2);
        String r4 = ((com.bytedance.live.kmp.core.c) r2).getCurrentUserId();
        e(r0, "msg_id", String.valueOf(r5.getMessageId()));
        String r8 = String.valueOf(r5.getGiftId());
        if (r8 != null) goto L15;
        r8 = "0";
    L15:
        e(r0, "gift_id", r8);
        m0 r9 = r5.getCommonData();
        if (r9 == null) goto L19;
        Intrinsics.checkNotNullParameter(r9, "$this$roomIdKt");
        String r10 = String.valueOf(r9.getRoomId());
        if (r10 == null) goto L19;
    L20:
        e(r0, "room_id", r10);
        IBaseUser r11 = r5.getToUser();
        if (r11 == null) goto L24;
        String r13 = r11.getIdString();
        if (r13 == null) goto L24;
    L25:
        e(r0, "anchor_id", r13);
        if (r4 == null) goto L29;
        r1 = r4;
    L29:
        e(r0, "user_id", r1);
    L24:
        r13 = r4;
    L19:
        r10 = "0";
    L30:
        JSONObject r14 = new JSONObject();
        r14.put("quick_play", false);
        r14.put("flag_code", r7);
        J(r5, r14);
        new JSONObject().put("isViewValid", r6);
        t("receive_gift_msg_pre_intercept", r0, r14);
    }

    public static void e(String r2, String r3, String r4) {
        ConcurrentHashMap<String, Map<String, Object>> r0 = c;
        if (r0.get(r2) != null) goto L6;
        r0.put(r2, new LinkedHashMap());
    L6:
        if (r3.length() != 0) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        Map<String, Object> r5 = r0.get(r2);
        if (r5 == null) goto L15;
        r5.put(r3, r4);
        return;
    L15:
        return;
    L8:
        r1 = false;
        goto L9
    }

    public static void h(d r2, int r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "normalGiftMessage");
        if (d(r2) == true) goto L5;
        return;
    L5:
        JSONObject r0 = new JSONObject();
        String r1 = r2.getTraceId();
        if (r1 != null) goto L8;
        r1 = "0";
    L8:
        L(r2, r0);
        r0.put("errorMsg", r4);
        new JSONObject().put("result", r3);
        t("dispatchToEffectMsgManagerEvent", r1, r0);
    }

    public static void n(v12.c r3, com.bytedance.android.live.core.resources.e r4, Integer r5) {
        Intrinsics.checkNotNullParameter(r3, "effectMessage");
        Intrinsics.checkNotNullParameter(r4, "assets");
        if (c(r3) == true) goto L5;
        return;
    L5:
        JSONObject r0 = new JSONObject();
        if (r5 == null) goto L8;
        int r6 = r5.intValue();
    L9:
        r0.put("resultCode", r6);
        r0.put("assetId", r4.getId());
        r0.put("play_type", "lynx");
        I(r3, r0);
        String r7 = r3.getTraceId();
        if (r7 != null) goto L12;
        r7 = "0";
    L12:
        t("effect_play_begin", r7, r0);
        return;
    L8:
        r6 = -1;
        goto L9
    }

    public static void o(d r3, boolean r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "giftMessage");
        Intrinsics.checkNotNullParameter(r5, "enableReason");
        if (d(r3) == true) goto L5;
        return;
    L5:
        String r1 = r3.getTraceId();
        if (r1 != null) goto L8;
        r1 = "0";
    L8:
        JSONObject r2 = new JSONObject();
        r2.put("enableReason", r5);
        r2.put("isEnable", r4);
        L(r3, r2);
        t("managerReceiveGiftMessageEvent", r1, r2);
    }

    public static void t(String r2, String r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r3, "transactionId");
        if (com.bytedance.android.livesdk.gift.platform.core.f.b() == true) goto L5;
        return;
    L5:
        r(0, BuildConfig.FLAVOR, r2, r3, r4);
    }

    public static void y(v12.c r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "effectMessage");
        if (c(r2) == true) goto L5;
        return;
    L5:
        JSONObject r0 = new JSONObject();
        r0.put("queueSize", r3);
        r0.put("isSuccess", r4);
        I(r2, r0);
        String r5 = r2.getTraceId();
        if (r5 != null) goto L8;
        r5 = "0";
    L8:
        t("onMsgLoadEffectOnceEvent", r5, r0);
    }

    public static void z(v12.c r3, com.bytedance.android.live.core.resources.e r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "effectMessage");
        Intrinsics.checkNotNullParameter(r4, "assets");
        if (c(r3) == true) goto L5;
        return;
    L5:
        JSONObject r0 = new JSONObject();
        r0.put("resultCode", r5);
        r0.put("assetId", r4.getId());
        r0.put("resourceType", r4.getResourceType());
        I(r3, r0);
        String r6 = r3.getTraceId();
        if (r6 != null) goto L8;
        r6 = "0";
    L8:
        t("onPlayEffectGiftEvent", r6, r0);
    }

    public static void F(String r2, long r3, boolean r5, Function1 r6) {
        Intrinsics.checkNotNullParameter(r2, "state");
        if (com.bytedance.android.livesdk.gift.platform.core.f.b() == true) goto L5;
        return;
    L5:
        String r0 = k(String.valueOf(r3));
        JSONObject r1 = new JSONObject();
        r1.put("giftID", i(String.valueOf(r3)));
        if (r0 != null) goto L8;
    L11:
        boolean r4 = true;
    L12:
        if (r4 == false) goto L14;
        return;
    L14:
        if (r6 == null) goto L16;
        Unit r7 = (Unit) r6.invoke(r0);
    L16:
        t(r2, r0, r1);
        if (r5 == false) goto L20;
        c.remove(r0);
        return;
    L20:
        return;
    L8:
        if (r0.length() == 0) goto L11;
        r4 = false;
        goto L12
    }

    public static void G(long r3, long r5, long r7, int r9) {
        if (com.bytedance.android.livesdk.gift.platform.core.f.b() == true) goto L5;
        return;
    L5:
        String r0 = k(String.valueOf(r3));
        if (r0 != null) goto L8;
    L11:
        boolean r1 = true;
    L12:
        if (r1 == false) goto L14;
        return;
    L14:
        JSONObject r2 = new JSONObject();
        r2.put("msgId", r3);
        r2.put("playStartResult", r9);
        r2.put("giftId", r5);
        r2.put("effectId", r7);
        t("playerStartResultEvent", r0, r2);
        return;
    L8:
        if (r0.length() == 0) goto L11;
        r1 = false;
        goto L12
    }

    public static void R(p2 r6, String r7, String r8, long r9, long r11) {
        Intrinsics.checkNotNullParameter(r6, "ISendGiftResult");
        Intrinsics.checkNotNullParameter(r7, "traceId");
        Intrinsics.checkNotNullParameter(r8, "logId");
        if (com.bytedance.android.livesdk.gift.platform.core.f.b() == true) goto L5;
        return;
    L5:
        e(r7, "log_id", r8);
        Iterator<T> r10 = r6.getGifts().iterator();
    L7:
        if (r10.hasNext() == false) goto L9;
        y1 r1 = (y1) r10.next();
        JSONObject r2 = new JSONObject();
        r2.put("giftId", r1.getGiftId());
        r2.put("buffLevel", r1.getBuffLevel());
        r2.put("comboCount", r1.getComboCount());
        r2.put("groupCount", r1.getGroupCount());
        r2.put("repeatCount", r1.getRepeatCount());
        r2.put("msgId", String.valueOf(r1.getMsgId()));
        r2.put("describe", r1.getDescribe());
        r2.put("logId", r8);
        r2.put("duration", r11 - r9);
        r2.put("isHarmony", false);
        t("send_gift_callback", r7, r2);
        goto L7
    }

    public static void r(int r11, String r13, String r14, String r15, JSONObject r16) {
        if (com.bytedance.android.livesdk.gift.platform.core.f.b() == true) goto L5;
        return;
    L5:
        yz0.g r0 = m();
        if (r0 == null) goto L10;
        IRoom r1 = r0.getRoom();
        if (r1 == null) goto L10;
        IRoom r2 = r1;
    L11:
        if (r2 == null) goto L29;
        IRoomKtKt.getId((IRoomBase) r2);
        String r3 = IRoomKt_androidKt.getAnchorId(r2);
        if (r3 != null) goto L15;
        r3 = BuildConfig.FLAVOR;
    L15:
        String r4 = r2.getIdStr();
        LinkedHashMap r5 = new LinkedHashMap();
        cy0.e.a.getClass();
        j r6 = cy0.e.a.a;
        m.e.getClass();
        Object r7 = m.b(r6).b(com.bytedance.android.livesdk.revenue.service.user.a.class);
        Intrinsics.checkNotNull(r7);
        String r8 = ((com.bytedance.live.kmp.core.c) r7).getCurrentUserId();
        r5.put("gift_id", j(r15, "gift_id"));
        r5.put("room_id", j(r15, "room_id"));
        r5.put("user_id", j(r15, "user_id"));
        r5.put("anchor_id", j(r15, "anchor_id"));
        r5.put("log_id", j(r15, "log_id"));
        String r9 = j(r15, "link_type");
        if (r9 != null) goto L18;
        r9 = "1";
    L18:
        r5.put("link_type", r9);
        j01.e r10 = new j01.e("live_send_gift", "gift");
        JSONObject r17 = new JSONObject();
        JSONObject r18 = new JSONObject();
        JSONObject r19 = new JSONObject();
        Intrinsics.checkNotNullParameter(r10, "metaBuilder");
        Intrinsics.checkNotNullParameter(r18, "category");
        Intrinsics.checkNotNullParameter(r19, "metric");
        Intrinsics.checkNotNullParameter(r17, "extra");
        r10.h(r15);
        r10.d(ProductId.REVENUE_SEND_GIFT);
        r10.i(r8);
        r10.b(r5);
        if (r14 != null) goto L21;
        r14 = BuildConfig.FLAVOR;
    L21:
        r10.g(r14);
        r10.f(r11);
        if (r13 != null) goto L24;
        r13 = BuildConfig.FLAVOR;
    L24:
        Intrinsics.checkNotNullParameter(r13, "msg");
        r10.a.k = r13;
        r10.a(r3);
        r10.e(r4);
        r10.c(String.valueOf(r5.get("log_id")));
        Intrinsics.checkNotNullParameter(r17, "json");
        if (r16 != null) goto L27;
        r16 = new JSONObject();
    L27:
        Intrinsics.checkNotNullParameter(r16, "jsonObject");
        j01.d.a(r17, r16);
        com.bytedance.android.live.revenue.core.util.f.a(j01.b.class).R4(r10.a, r18, r19, r17);
        return;
    L29:
        return;
    L10:
        r2 = null;
        goto L11
    }

    public static void s(o7 r1, String r2, int r3, String r4, JSONObject r5) {
        Intrinsics.checkNotNullParameter(r1, "giftMessage");
        Intrinsics.checkNotNullParameter(r2, "step");
        if (b(r1) == true) goto L5;
        return;
    L5:
        if (r5 != null) goto L7;
        r5 = new JSONObject();
    L7:
        J(r1, r5);
        String r6 = r1.getTraceId();
        if (r6 != null) goto L10;
        r6 = "0";
    L10:
        r(r3, r4, r2, r6, r5);
    }

    public static void u(v12.c r1, String r2, int r3, String r4, JSONObject r5) {
        Intrinsics.checkNotNullParameter(r1, "message");
        Intrinsics.checkNotNullParameter(r2, "step");
        if (c(r1) == true) goto L5;
        return;
    L5:
        if (r5 != null) goto L7;
        r5 = new JSONObject();
    L7:
        I(r1, r5);
        String r6 = r1.getTraceId();
        if (r6 != null) goto L10;
        r6 = "0";
    L10:
        r(r3, r4, r2, r6, r5);
    }
}
