package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.revenue.model.extension.IMainRoom;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.GiftPanelBizBoostUtils;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ClickGiftPanelIcon;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftPanelDataExtra;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.OnDialogFullyShowed;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.RefreshGiftList;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.StartScrollGiftVerticalPanel;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.UpdatePanelGiftList;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.revenue.monitor.EventModule;
import com.bytedance.android.livesdkapi.depend.model.live.IGroupLiveData;
import com.bytedance.bdlocation.BuildConfig;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.sequences.SequencesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftPanelMonitorService implements com.bytedance.android.scope.o {
    public static boolean Q;
    public volatile long A;
    public volatile long B;
    public final HashMap<String, Long> C;
    public com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.e0 D;
    public final Map<String, String> E;
    public final Map<String, String> F;
    public final Map<String, String> G;
    public b H;
    public final GiftInRoomService I;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f J;
    public final yz0.k K;
    public final w1 L;
    public final u1 M;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.i N;
    public final SendGiftRelationService O;
    public final GiftDataStorageService P;
    public long a;
    public long b;
    public long c;
    public long d;
    public long e;
    public long f;
    public long g;
    public long h;
    public long i;
    public long j;
    public long k;
    public long l;
    public long m;
    public boolean n;
    public boolean o;
    public String p;
    public int q;
    public int r;
    public final Map<String, String> s;
    public volatile int t;
    public volatile long u;
    public volatile int v;
    public volatile long w;
    public volatile int x;
    public volatile long y;
    public volatile int z;

    public static final class a {
    }

    public static final class b {
        public final long a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;

        public final boolean equals(Object r6) {
            if (this != r6) goto L4;
            return true;
        L4:
            if ((r6 instanceof b) == false) goto L16;
            b r7 = (b) r6;
            if (this.a == r7.a) goto L8;
            return false;
        L8:
            if (this.b == r7.b) goto L10;
            return false;
        L10:
            if (this.c == r7.c) goto L12;
            return false;
        L12:
            if (this.d == r7.d) goto L14;
            return false;
        L14:
            if (this.e == r7.e) goto L25;
            return false;
        L25:
            return true;
        L16:
            return false;
        }

        public final int hashCode() {
            long r0 = this.a;
            return (((((((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + this.e;
        }

        public final String toString() {
            return "DefaultSelectInfo(giftId=" + this.a + ", position=" + this.b + ", row=" + this.c + ", pagePosition=" + this.d + ", pageType=" + this.e + ")";
        }

        public b(long r1, int r3, int r4, int r5, int r6) {
            this.a = r1;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    public final void onStart() {
    }

    public final void onStop() {
        Q = false;
    }

    static {
        Q = true;
    }

    public final void i() {
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.e0 r0 = this.D;
        if (r0 == null) goto L6;
        this.t = r0.a;
        this.u = r0.b;
        this.v = r0.c;
        this.w = r0.d;
        this.x = r0.h;
        this.y = r0.i;
        this.z = r0.f;
        this.A = r0.g;
        this.B = r0.k;
        return;
    }

    public final void a(Map<String, String> r4) {
        r4.put("consume_level", String.valueOf(ay1.b.u()));
        r4.put("panel_open_times", String.valueOf(this.P.p));
        r4.put("first_open_after_launch", String.valueOf(Q));
        r4.put("send_gift_scene", vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).changeMode2String(x12.b.a()));
        r4.put("send_gift_relation_cnt", String.valueOf(this.O.a.size()));
        r4.put("send_gift_relation", String.valueOf(this.O.a(this.p)));
        this.M.n(r4);
        r4.putAll(this.G);
        r4.putAll(MapsKt.toMap(this.E));
        Map<String, String> r0 = this.F;
        if (r0.isEmpty() == true) goto L5;
    L7:
        Unit r1 = Unit.INSTANCE;
        r4.putAll(r0);
        return;
    L5:
        if (this.H == null) goto L7;
        r0.put("display_list_change_type", "not_refresh");
        goto L7
    }

    public final void f(long r3) {
        long r0 = System.currentTimeMillis();
        this.e = r0;
        this.d = r0 - r3;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.g.a(true, new GiftPanelMonitorService$onGiftPanelWidgetLoaded$1(this));
        jy0.b.d("ttlive_gift_panel_metrics", "GiftPanelWidget load cost " + this.d + "ms");
    }

    public final void j(final List<? extends com.bytedance.android.livesdk.gift.model.w1> r3) {
        GiftPanelBizBoostUtils.E.getClass();
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.g.a(GiftPanelBizBoostUtils.b().k8(), new GiftPanelMonitorService$reportGiftPanelProfitCheck$1(this, r3));
    }

    public final void c(GiftAction r8, long r9) {
        Intrinsics.checkNotNullParameter(r8, "action");
        if ((r8 instanceof RefreshGiftList) == true) goto L7;
        if ((r8 instanceof UpdatePanelGiftList) == true) goto L7;
    L10:
        if ((r8 instanceof ClickGiftPanelIcon) == true) goto L14;
        if ((r8 instanceof StartScrollGiftVerticalPanel) == true) goto L14;
    L17:
        if (this.o == false) goto L19;
        return;
    L19:
        long r3 = System.currentTimeMillis() - r9;
        Long r10 = this.C.get(r8.getTag());
        if (r10 != null) goto L22;
        r10 = 0L;
    L22:
        long r11 = r10.longValue();
        this.C.put(r8.getTag(), Long.valueOf(r11 + r3));
        if ((r8 instanceof OnDialogFullyShowed) == false) goto L26;
        UtilityKotlinExtentionsKt.s(1500, false, false, new GiftPanelMonitorService$onActionReduced$1(this), 6);
        return;
    L26:
        return;
    L14:
        if (this.g != 0) goto L17;
        this.g = r8.getCreateTs() - this.b;
    L7:
        if (this.f != 0) goto L10;
        long r4 = this.b;
        this.f = System.currentTimeMillis() - r4;
        goto L10
    }

    public final void g(long r5, long r7, long r9) {
        this.h = r5;
        this.i = r9 - r5;
        this.j = System.currentTimeMillis() - r5;
        this.k = System.currentTimeMillis() - this.b;
        Pair<GiftContext, ? extends Disposable> r0 = this.I.b;
        if (r0 == null) goto L5;
        GiftContext r1 = (GiftContext) r0.getFirst();
    L6:
        if (r1 == null) goto L12;
        com.bytedance.live.datacontext.m<Long> r2 = r1.getGiftPanelFirstRenderTs();
        if (r2 == null) goto L12;
        Long r3 = (Long) r2.getValue();
        if (r3 == null) goto L12;
        long r4 = r3.longValue();
    L13:
        long r6 = r5 - r4;
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L17;
        jy0.b.c("ttlive_gift_panel_metrics", "LynxLoaded, lynxInitInterval:     " + r6 + " \n            lynxLoad:             " + (r9 - r7) + " \n            lynxInit:             " + this.i + " \n            lynxLoaded:           " + this.j + " \n            lynxPanelFirstScreen: " + this.k + " \n", null, 4);
        return;
    L17:
        return;
    L12:
        r4 = 0;
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    public static void h(int r17, int r18, int r19, IBaseUser r20) {
        Intrinsics.checkNotNullParameter(r20, "toUser");
        boolean r0 = com.bytedance.android.livesdk.gift.platform.core.d0.a;
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.l(r20) == false) goto L5;
        String r1 = "anchor";
    L6:
        yz0.k r2 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r2 == null) goto L9;
        boolean r3 = r2.isLiveTypeSandbox();
    L10:
        Intrinsics.checkNotNullParameter(r1, "receiverType");
        LinkedHashMap r4 = new LinkedHashMap();
        r4.put("to_user_type", r1);
        r4.put("is_in_beta_testing", String.valueOf(r3));
        LinkedHashMap r5 = new LinkedHashMap();
        r5.put("prop_list_count", Integer.valueOf(r17));
        r5.put("server_display_on_panel_count", Integer.valueOf(r18));
        r5.put("panel_display_count", Integer.valueOf(r19));
        JSONObject r8 = new JSONObject();
        JSONObject r9 = new JSONObject();
        JSONObject r10 = new JSONObject();
        Intrinsics.checkNotNullParameter(r10, "extra");
        Intrinsics.checkNotNullParameter(r9, "metric");
        EventModule r11 = EventModule.LIVE_GIFT;
        Intrinsics.checkNotNullParameter(r11, "eventModule");
        String r6 = r11.getValue();
        Intrinsics.checkNotNullParameter(r8, "map");
        Intrinsics.checkNotNullParameter(r4, "value");
        Iterator r7 = r4.entrySet().iterator();
    L12:
        if (r7.hasNext() == false) goto L14;
        Map.Entry r15 = (Map.Entry) r7.next();
        Iterator r110 = r7;
        r8.put((String) r15.getKey(), r15.getValue());
        r7 = r110;
        goto L12
    L14:
        Intrinsics.checkNotNullParameter(r9, "map");
        Intrinsics.checkNotNullParameter(r5, "value");
        Iterator r13 = r5.entrySet().iterator();
    L16:
        if (r13.hasNext() == false) goto L18;
        Map.Entry r16 = (Map.Entry) r13.next();
        Iterator r111 = r13;
        r9.put((String) r16.getKey(), r16.getValue());
        r13 = r111;
        goto L16
    L18:
        cy0.e.a.getClass();
        cy0.j r112 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r14 = com.bytedance.android.scope.m.b(r112).b(n97.a.class);
        Intrinsics.checkNotNull(r14);
        ((com.bytedance.live.kmp.core.c) r14).g("ttlive_prop_panel_show_icon_count_all", r6, "bussiness_api_call", r8, r9, r10);
        if (r18 == r19) goto L34;
        JSONObject r21 = new JSONObject();
        JSONObject r23 = new JSONObject();
        JSONObject r113 = new JSONObject();
        Intrinsics.checkNotNullParameter(r113, "extra");
        Intrinsics.checkNotNullParameter(r23, "metric");
        Intrinsics.checkNotNullParameter(r11, "eventModule");
        String r24 = r11.getValue();
        Intrinsics.checkNotNullParameter(r21, "map");
        Intrinsics.checkNotNullParameter(r4, "value");
        Iterator r25 = r4.entrySet().iterator();
    L22:
        if (r25.hasNext() == false) goto L24;
        Map.Entry r26 = (Map.Entry) r25.next();
        r21.put((String) r26.getKey(), r26.getValue());
        goto L22
    L24:
        Intrinsics.checkNotNullParameter(r23, "map");
        Intrinsics.checkNotNullParameter(r5, "value");
        Iterator r27 = r5.entrySet().iterator();
    L26:
        if (r27.hasNext() == false) goto L28;
        Map.Entry r28 = (Map.Entry) r27.next();
        r23.put((String) r28.getKey(), r28.getValue());
        goto L26
    L28:
        Object r29 = com.bytedance.android.scope.m.b(r112).b(n97.a.class);
        Intrinsics.checkNotNull(r29);
        ((com.bytedance.live.kmp.core.c) r29).g("ttlive_prop_panel_show_icon_count_error", r24, "bussiness_api_call", r21, r23, r113);
        return;
    L34:
        return;
    L9:
        r3 = false;
        goto L10
    L5:
        r1 = "guest";
        goto L6
    }

    public final void d(com.bytedance.android.livesdk.gift.platform.core.model.j r17, int r18, int r19, Pair<Integer, Long> r20, IBaseUser r21, boolean r23, GiftPanelDataExtra r24) {
        Intrinsics.checkNotNullParameter(r17, "giftPanelData");
        Intrinsics.checkNotNullParameter(r20, "orderChangeIndex");
        Intrinsics.checkNotNullParameter(r21, "toUser");
        List r2 = SequencesKt.toMutableList(SequencesKt.flatMap(CollectionsKt.asSequence(r17.c), GiftPanelMonitorService$onGiftPanelLoadStatusMonitor$giftList$1.INSTANCE));
        if (r2 != null) goto L5;
        return;
    L5:
        int r5 = r2.size();
        if (r5 != 0) goto L8;
        return;
    L8:
        Iterator r3 = r2.iterator();
        int r7 = 0;
        int r8 = 0;
    L10:
        if (r3.hasNext() == false) goto L19;
        com.bytedance.android.livesdk.gift.model.h1 r9 = (com.bytedance.android.livesdk.gift.model.h1) r3.next();
        if (r9.isDisplayedOnPanel() == false) goto L15;
        r7 = r7 + 1;
    L15:
        if (r9.isForLinkMic() == false) goto L10;
        if (r9.isDisplayedOnPanel() == false) goto L10;
        r8 = r8 + 1;
        goto L10
    L19:
        if (r5 != 0) goto L22;
        return;
    L22:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.l(r21) == false) goto L25;
    L33:
        String r4 = "anchor";
    L34:
        LinkedHashMap r6 = new LinkedHashMap();
        r6.put("to_user_type", r4);
        r6.put("panel_display_count", String.valueOf(r18));
        r6.put("gift_list_count", String.valueOf(r5));
        r6.put("server_display_on_panel_count", String.valueOf(r7));
        r6.put("link_mic_display_count", String.valueOf(r8));
        r6.put("pending_show_count", String.valueOf(r19));
        r6.put("order_change", String.valueOf(((Number) r20.getFirst()).intValue()));
        r6.put("order_change_gift", String.valueOf(((Number) r20.getSecond()).longValue()));
        if (r24 == null) goto L37;
        int r10 = r24.getPageDataFrom();
    L38:
        r6.put("gift_source", String.valueOf((r10 * 100) + r17.e));
        r6.put("new_log_id", r17.g);
        r6.put("ohr_value", String.valueOf(r17.a));
        r6.put("ohr_which_type", String.valueOf(r17.b));
        if (r24 == null) goto L42;
        String r11 = r24.getLogId();
        if (r11 == null) goto L42;
    L43:
        r6.put("last_log_id", r11);
        long r13 = System.currentTimeMillis();
        long r14 = this.b;
        if (r24 == null) goto L46;
        r13 = r24.getPageDataUpdateTime();
    L46:
        r6.put("cache_duration", String.valueOf(r14 - r13));
        if (r17.f == 0) goto L57;
        if (r24 != null) goto L50;
    L51:
        long r15 = r17.f;
        if (r24 != null) goto L54;
    L56:
        r6.put("room_change", "1");
    L59:
        if (r19 <= 0) goto L61;
        r6.put("status", "1");
    L62:
        IMainRoom r16 = this.K.getRoom().castToOrNull(IMainRoom.class);
        if (r16 == null) goto L69;
        com.bytedance.android.live.revenue.model.extension.main.c r25 = r16.getMainOthers();
        if (r25 == null) goto L69;
        IGroupLiveData r26 = r25.getGroupLiveData();
        if (r26 == null) goto L69;
        boolean r27 = r26.isCurrentGroupLive();
    L71:
        if (r27 == false) goto L73;
        r6.put("is_group", "1");
    L74:
        yz0.k r28 = this.K;
        if (r28 == null) goto L77;
        Long r29 = Long.valueOf(r28.Hl());
    L78:
        r6.put("stay_room_duration", String.valueOf(System.currentTimeMillis() - r29.longValue()));
        Iterator<T> r1 = r17.c.iterator();
        boolean r30 = false;
    L80:
        if (r1.hasNext() == false) goto L96;
        com.bytedance.android.livesdk.gift.model.w1 r31 = (com.bytedance.android.livesdk.gift.model.w1) r1.next();
        if (r31.getPageType() != 1) goto L80;
        Map<Integer, Long> r33 = r31.getForceInsertMap();
        if (r33 == null) goto L80;
        Iterator<Map.Entry<Integer, Long>> r34 = r33.entrySet().iterator();
        int r35 = 0;
    L87:
        if (r34.hasNext() == false) goto L80;
        Map.Entry<Integer, Long> r110 = r34.next();
        Iterator<Map.Entry<Integer, Long>> r111 = r34;
        if (r110.getValue().longValue() >= 9) goto L94;
        if (r35 >= 9) goto L94;
        r35 = r35 + 1;
        r6.put("force_" + r110.getValue().longValue(), String.valueOf(r110.getKey().intValue()));
        if (((Number) r20.getSecond()).longValue() != r110.getKey().intValue()) goto L94;
        r30 = true;
    L94:
        r34 = r111;
        goto L87
    L96:
        if (r30 == false) goto L98;
        r6.put("change_force", "1");
    L99:
        a(r6);
        mz0.n r36 = new mz0.n();
        Map r37 = r36.a;
        Intrinsics.checkNotNullParameter(r37, "map");
        Intrinsics.checkNotNullParameter(r6, "map");
        r37.putAll(r6);
        mz0.m r38 = new mz0.m();
        r38.b(LogCommon.ROOM);
        ((ArrayList) r36.b).addAll(r38.a);
        cy0.e.a.getClass();
        cy0.j r39 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r40 = com.bytedance.android.scope.m.b(r39).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r40);
        ((f80.a) r40).w3("livesdk_gift_panel_load_end", r36.a, r36.b);
        return;
    L98:
        r6.put("change_force", "0");
        goto L99
    L77:
        r29 = null;
        goto L78
    L73:
        r6.put("is_group", "0");
    L69:
        r27 = false;
        goto L71
    L61:
        r6.put("status", "0");
        goto L62
    L54:
        if (r15 != r24.getPageDataForRoomId()) goto L56;
        r6.put("room_change", "0");
        goto L59
    L50:
        if (r24.getPageDataForRoomId() != 0) goto L51;
    L57:
        r6.put("room_change", "-1");
    L42:
        r11 = "default";
        goto L43
    L37:
        r10 = 0;
        goto L38
    L25:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.m(r21) == false) goto L29;
        if (r23 == false) goto L29;
        r4 = "otherAnchor";
    L29:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.l(r21) == true) goto L33;
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.m(r21) == true) goto L33;
        r4 = "guest";
        goto L34
    }

    public GiftPanelMonitorService(GiftInRoomService r2, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f r3, yz0.k r4, w1 r5, u1 r6, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.i r7, SendGiftRelationService r8, GiftDataStorageService r9) {
        Intrinsics.checkNotNullParameter(r2, "giftInRoomService");
        Intrinsics.checkNotNullParameter(r3, "receiverService");
        Intrinsics.checkNotNullParameter(r4, "roomDataService");
        Intrinsics.checkNotNullParameter(r5, "giftPanelMetrics");
        Intrinsics.checkNotNullParameter(r6, "panelLogService");
        Intrinsics.checkNotNullParameter(r7, "giftPreloaderService");
        Intrinsics.checkNotNullParameter(r8, "sendGiftRelationService");
        Intrinsics.checkNotNullParameter(r9, "dataStorageService");
        this.I = r2;
        this.J = r3;
        this.K = r4;
        this.L = r5;
        this.M = r6;
        this.N = r7;
        this.O = r8;
        this.P = r9;
        this.p = BuildConfig.FLAVOR;
        this.q = -1;
        this.s = new LinkedHashMap();
        this.C = new HashMap();
        this.E = new LinkedHashMap();
        this.F = new LinkedHashMap();
        this.G = new LinkedHashMap();
    }
}
