package com.bytedance.android.livesdk.gift.platform.core;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revenue.common.r0;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.android.livesdk.revenue.monitor.EventModule;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bdlocation.BuildConfig;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c0 {
    public static final c0 a = null;

    public c0() {
    }

    static {
        a = new c0();
    }

    public static void f(int r10) {
        JSONObject r0 = new JSONObject();
        r(r0, "gift_page_type", Integer.valueOf(r10));
        yz0.k r11 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r11 == null) goto L5;
        IRoom r13 = r11.getRoom();
    L6:
        if (r13 == null) goto L11;
        String r1 = r13.getAnchorId();
        if (r1 != null) goto L10;
        r1 = BuildConfig.FLAVOR;
    L10:
        r(r0, "anchor_id", r1);
        r(r0, "room_id", Long.valueOf(r13.getId()));
    L11:
        String r2 = com.bytedance.android.livesdk.gift.platform.core.utils.z.a("ttlive_gift_panel_red_dot_show");
        JSONObject r5 = new JSONObject();
        JSONObject r6 = new JSONObject();
        JSONObject r7 = new JSONObject();
        Intrinsics.checkNotNullParameter(r7, "extra");
        Intrinsics.checkNotNullParameter(r6, "metric");
        EventModule r14 = EventModule.LIVE_GIFT;
        Intrinsics.checkNotNullParameter(r14, "eventModule");
        String r3 = r14.getValue();
        r6.put("status", String.valueOf(0));
        Intrinsics.checkNotNullParameter(r7, "map");
        Iterator<String> r15 = r0.keys();
    L13:
        if (r15.hasNext() == false) goto L15;
        String r4 = r15.next();
        Object r8 = r0.get(r4);
        Intrinsics.checkNotNullParameter(r4, "key");
        Intrinsics.checkNotNullParameter(r8, "value");
        r7.put(r4, r8);
        goto L13
    L15:
        cy0.e.a.getClass();
        cy0.j r9 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r16 = com.bytedance.android.scope.m.b(r9).b(n97.a.class);
        Intrinsics.checkNotNull(r16);
        ((com.bytedance.live.kmp.core.c) r16).g(r2, r3, "bussiness_api_call", r5, r6, r7);
        return;
    L5:
        r13 = null;
        goto L6
    }

    public static void h(int r8) {
        JSONObject r4 = new JSONObject();
        JSONObject r5 = new JSONObject();
        JSONObject r6 = new JSONObject();
        Intrinsics.checkNotNullParameter(r6, "extra");
        Intrinsics.checkNotNullParameter(r5, "metric");
        EventModule r0 = EventModule.LIVE_GIFT;
        Intrinsics.checkNotNullParameter(r0, "eventModule");
        String r2 = r0.getValue();
        r5.put("status", String.valueOf(r8));
        cy0.e.a.getClass();
        cy0.j r1 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r9 = com.bytedance.android.scope.m.b(r1).b(n97.a.class);
        Intrinsics.checkNotNull(r9);
        ((com.bytedance.live.kmp.core.c) r9).g("ttlive_gift_prop_timeout_report_status", r2, "bussiness_api_call", r4, r5, r6);
    }

    public static void m(int r8) {
        JSONObject r4 = new JSONObject();
        JSONObject r5 = new JSONObject();
        JSONObject r6 = new JSONObject();
        Intrinsics.checkNotNullParameter(r6, "extra");
        Intrinsics.checkNotNullParameter(r5, "metric");
        EventModule r0 = EventModule.LIVE_GIFT;
        Intrinsics.checkNotNullParameter(r0, "eventModule");
        String r2 = r0.getValue();
        r5.put("status", String.valueOf(r8));
        cy0.e.a.getClass();
        cy0.j r1 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r9 = com.bytedance.android.scope.m.b(r1).b(n97.a.class);
        Intrinsics.checkNotNull(r9);
        ((com.bytedance.live.kmp.core.c) r9).g("ttlive_gift_send_timeout_report_status", r2, "bussiness_api_call", r4, r5, r6);
    }

    public static void e(long r10, int r13) {
        String r2 = com.bytedance.android.livesdk.gift.platform.core.utils.z.a("ttlive_gift_list_status");
        JSONObject r5 = new JSONObject();
        JSONObject r6 = new JSONObject();
        JSONObject r7 = new JSONObject();
        Intrinsics.checkNotNullParameter(r7, "extra");
        Intrinsics.checkNotNullParameter(r6, "metric");
        EventModule r0 = EventModule.LIVE_GIFT;
        Intrinsics.checkNotNullParameter(r0, "eventModule");
        String r3 = r0.getValue();
        r6.put("status", String.valueOf(0));
        Intrinsics.checkNotNullParameter(r5, "map");
        Integer r14 = Integer.valueOf(r13);
        Intrinsics.checkNotNullParameter("source", "key");
        Intrinsics.checkNotNullParameter(r14, "value");
        r5.put("source", r14);
        Intrinsics.checkNotNullParameter(r7, "map");
        Long r11 = Long.valueOf(r10);
        Intrinsics.checkNotNullParameter("duration", "key");
        Intrinsics.checkNotNullParameter(r11, "value");
        r7.put("duration", r11);
        cy0.e.a.getClass();
        cy0.j r15 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r16 = com.bytedance.android.scope.m.b(r15).b(n97.a.class);
        Intrinsics.checkNotNull(r16);
        ((com.bytedance.live.kmp.core.c) r16).g(r2, r3, "bussiness_api_call", r5, r6, r7);
    }

    public final void a(long r3, long r5) {
        JSONObject r0 = new JSONObject();
        r(r0, "gift_id", Long.valueOf(r3));
        r(r0, "asset_id", Long.valueOf(r5));
        yz0.k r4 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        IRoom r6 = null;
        if (r4 == null) goto L5;
        IRoom r7 = r4.getRoom();
    L7:
        if ((r7 instanceof Room) == false) goto L10;
        r6 = r7;
    L10:
        Room r8 = (Room) r6;
        if (r8 == null) goto L16;
        r(r0, "room_type", Integer.valueOf(r8.orientation));
        r(r0, "room_id", Long.valueOf(r8.id));
        String r9 = r8.getAnchorId();
        if (r9 != null) goto L15;
        r9 = BuildConfig.FLAVOR;
    L15:
        r(r0, "anchor_id", r9);
    L16:
        n(this, com.bytedance.android.livesdk.gift.platform.core.utils.z.b("ttlive_asset_id_not_found"), r0, 1);
        return;
    L5:
        r7 = null;
        goto L7
    }

    public final void o(String r3, JSONObject r4) {
        n(this, com.bytedance.android.livesdk.gift.platform.core.utils.z.a(r3), r4, 1);
        n(this, com.bytedance.android.livesdk.gift.platform.core.utils.z.b(r3), r4, 1);
    }

    public final void p(String r5, JSONObject r6) {
        n(this, com.bytedance.android.livesdk.gift.platform.core.utils.z.b(r5), r6, 1);
        r(r6, "duration", 0L);
        n(this, com.bytedance.android.livesdk.gift.platform.core.utils.z.a(r5), r6, 1);
    }

    @JvmStatic
    public static final void i(String r4, int r5, Boolean r6) {
        JSONObject r0 = new JSONObject();
        c0 r1 = a;
        r(r0, "error_code", Integer.valueOf(r5));
        String r7 = BuildConfig.FLAVOR;
        if (r4 != null) goto L5;
        r4 = BuildConfig.FLAVOR;
    L5:
        r(r0, "error_msg", r4);
        yz0.k r8 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r8 == null) goto L8;
        IRoom r9 = r8.getRoom();
    L9:
        if (r9 == null) goto L15;
        r(r0, "room_id", Long.valueOf(r9.getId()));
        String r10 = r9.getAnchorId();
        if (r10 == null) goto L14;
        r7 = r10;
    L14:
        r(r0, "anchor_id", r7);
    L15:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f r11 = com.bytedance.android.livesdk.gift.platform.core.utils.s.c();
        if (r11 == null) goto L21;
        IBaseUser r13 = r11.a;
        if (r13 == null) goto L21;
        Object r14 = r13.getIdString();
        if (r14 == null) goto L21;
    L22:
        r(r0, "to_anchor_id", r14);
        r(new JSONObject(), "use_uplink", Boolean.valueOf(Intrinsics.areEqual(r6, Boolean.TRUE)));
        r1.p("ttlive_prop_list_status", r0);
        return;
    L21:
        r14 = 0L;
        goto L22
    L8:
        r9 = null;
        goto L9
    }

    @JvmStatic
    public static final void j(long r10, int r13, boolean r14) {
        String r2 = com.bytedance.android.livesdk.gift.platform.core.utils.z.a("ttlive_prop_list_status");
        JSONObject r5 = new JSONObject();
        JSONObject r6 = new JSONObject();
        JSONObject r7 = new JSONObject();
        Intrinsics.checkNotNullParameter(r7, "extra");
        Intrinsics.checkNotNullParameter(r6, "metric");
        Intrinsics.checkNotNullParameter(r5, "map");
        Boolean r15 = Boolean.valueOf(r14);
        Intrinsics.checkNotNullParameter("use_uplink", "key");
        Intrinsics.checkNotNullParameter(r15, "value");
        r5.put("use_uplink", r15);
        EventModule r16 = EventModule.LIVE_GIFT;
        Intrinsics.checkNotNullParameter(r16, "eventModule");
        String r17 = r16.getValue();
        r6.put("status", String.valueOf(0));
        Intrinsics.checkNotNullParameter(r7, "map");
        Long r11 = Long.valueOf(r10);
        Intrinsics.checkNotNullParameter("duration", "key");
        Intrinsics.checkNotNullParameter(r11, "value");
        r7.put("duration", r11);
        Integer r18 = Integer.valueOf(r13);
        Intrinsics.checkNotNullParameter("prop_count", "key");
        Intrinsics.checkNotNullParameter(r18, "value");
        r7.put("prop_count", r18);
        cy0.e.a.getClass();
        cy0.j r19 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r110 = com.bytedance.android.scope.m.b(r19).b(n97.a.class);
        Intrinsics.checkNotNull(r110);
        ((com.bytedance.live.kmp.core.c) r110).g(r2, r17, "bussiness_api_call", r5, r6, r7);
    }

    public static void r(JSONObject r1, String r2, Object r3) {
        Intrinsics.checkNotNullParameter(r1, "$this$safePut");
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "value");
        r1.put(r2, r3);     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        String r4 = e.getMessage();
        if (r4 != null) goto L9;
        r4 = BuildConfig.FLAVOR;
    L9:
        jy0.b.c("LiveGiftMonitor", r4, null, 4);
    }

    public final void d(String r5, int r6, int r7) {
        JSONObject r0 = new JSONObject();
        r(r0, "error_code", Integer.valueOf(r6));
        String r8 = BuildConfig.FLAVOR;
        if (r5 != null) goto L5;
        r5 = BuildConfig.FLAVOR;
    L5:
        r(r0, "error_msg", r5);
        yz0.k r9 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        String r1 = null;
        if (r9 == null) goto L8;
        IRoom r10 = r9.getRoom();
    L9:
        if (r10 == null) goto L15;
        r(r0, "room_id", Long.valueOf(r10.getId()));
        String r2 = r10.getAnchorId();
        if (r2 == null) goto L14;
        r8 = r2;
    L14:
        r(r0, "anchor_id", r8);
    L15:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f r11 = com.bytedance.android.livesdk.gift.platform.core.utils.s.c();
        if (r11 == null) goto L21;
        String r13 = r11.a;
        if (r13 == null) goto L21;
        r1 = r13;
    L23:
        if (r1 != null) goto L25;
        r1 = "0";
    L25:
        r(r0, "to_anchor_id", r1);
        r(r0, "source", Integer.valueOf(r7));
        p("ttlive_gift_list_status", r0);
        return;
    L21:
        if (r10 == null) goto L23;
        r1 = r10.getAnchorId();
        goto L23
    L8:
        r10 = null;
        goto L9
    }

    @JvmStatic
    public static final void c(long r3, String r5, List<String> r6, String r7) {
        JSONObject r0 = new JSONObject();
        c0 r1 = a;
        r(r0, "gift_id", Long.valueOf(r3));
        if (r5 != null) goto L5;
        r5 = BuildConfig.FLAVOR;
    L5:
        r(r0, "gift_icon_url", r5);
        if (r7 != null) goto L8;
        r7 = BuildConfig.FLAVOR;
    L8:
        r(r0, "error_msg", r7);
        r(r0, "domain_opt", Integer.valueOf(com.bytedance.android.livesdk.gift.platform.business.i.h().w0() ? 1 : 0));
        r(r0, "domain_check", Integer.valueOf(w12.b.a() ? 1 : 0));
        if (r6 == null) goto L14;
        Iterator<T> r4 = r6.iterator();
    L12:
        if (r4.hasNext() == false) goto L14;
        r0.put("url_0", (String) r4.next());
    L14:
        r1.o("ttlive_gift_icon_load_status", r0);
    }

    public static void n(c0 r7, String r8, JSONObject r9, int r10) {
        r7.getClass();
        JSONObject r4 = new JSONObject();
        JSONObject r5 = new JSONObject();
        JSONObject r6 = new JSONObject();
        Intrinsics.checkNotNullParameter(r6, "extra");
        Intrinsics.checkNotNullParameter(r5, "metric");
        EventModule r11 = EventModule.LIVE_GIFT;
        Intrinsics.checkNotNullParameter(r11, "eventModule");
        String r2 = r11.getValue();
        r5.put("status", String.valueOf(r10));
        Intrinsics.checkNotNullParameter(r6, "map");
        Iterator<String> r13 = r9.keys();
    L4:
        if (r13.hasNext() == false) goto L6;
        String r14 = r13.next();
        Object r0 = r9.get(r14);
        Intrinsics.checkNotNullParameter(r14, "key");
        Intrinsics.checkNotNullParameter(r0, "value");
        r6.put(r14, r0);
        goto L4
    L6:
        cy0.e.a.getClass();
        cy0.j r15 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r16 = com.bytedance.android.scope.m.b(r15).b(n97.a.class);
        Intrinsics.checkNotNull(r16);
        ((com.bytedance.live.kmp.core.c) r16).g(r8, r2, "bussiness_api_call", r4, r5, r6);
    }

    public final void k(long r3, long r5, Throwable r7, IBaseUser r8) {
        Intrinsics.checkNotNullParameter(r7, "error");
        Intrinsics.checkNotNullParameter(r8, "toUser");
        JSONObject r0 = new JSONObject();
        r(r0, "room_id", Long.valueOf(r5));
        r(r0, "gift_id", Long.valueOf(r3));
        yz0.k r6 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r6 == null) goto L5;
        IRoom r9 = r6.getRoom();
    L6:
        if (r9 == null) goto L11;
        String r10 = r9.getAnchorId();
        if (r10 != null) goto L10;
        r10 = BuildConfig.FLAVOR;
    L10:
        r(r0, "anchor_id", r10);
    L11:
        r(r0, "to_anchor_id", r8.getIdString());
        r(r0, "error_code", Integer.valueOf(r0.a(r7)));
        r(r0, "error_msg", Arrays.toString(r7.getStackTrace()));
        h2 r4 = GiftManagerKt.l(r3);
        if (r4 != null) goto L14;
    L17:
        p("ttlive_gift_send_status", r0);
        return;
    L14:
        if (l0.e(r4) == false) goto L16;
        r(r0, "free_display", 1);
        goto L17
    L16:
        r(r0, "free_display", 0);
        goto L17
    L5:
        r9 = null;
        goto L6
    }

    public final void q(String r3, long r4, int r6, Throwable r7) {
        Intrinsics.checkNotNullParameter(r3, "giftIds");
        JSONObject r0 = new JSONObject();
        r(r0, "room_id", Long.valueOf(r4));
        r(r0, "gift_id", r3);
        r(r0, "fetch_from", Integer.valueOf(r6));
        if (r7 == null) goto L5;
        r(r0, "error", String.valueOf(r7.getMessage()));
        n(this, com.bytedance.android.livesdk.gift.platform.core.utils.z.b("ttlive_gift_detail_status"), r0, 1);
        return;
    L5:
        n(this, com.bytedance.android.livesdk.gift.platform.core.utils.z.a("ttlive_gift_detail_status"), r0, 0);
    }

    public static void l(long r8, long r10, String r13, long r14, IBaseUser r15) {
        Intrinsics.checkNotNullParameter(r15, "toUser");
        JSONObject r0 = new JSONObject();
        r(r0, "room_id", Long.valueOf(r10));
        r(r0, "gift_id", Long.valueOf(r8));
        String r11 = BuildConfig.FLAVOR;
        if (r13 != null) goto L5;
        r13 = BuildConfig.FLAVOR;
    L5:
        r(r0, "log_id", r13);
        yz0.k r16 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r16 == null) goto L8;
        IRoom r17 = r16.getRoom();
    L9:
        if (r17 == null) goto L15;
        String r18 = r17.getAnchorId();
        if (r18 == null) goto L14;
        r11 = r18;
    L14:
        r(r0, "anchor_id", r11);
    L15:
        r(r0, "to_anchor_id", r15.getIdString());
        h2 r9 = GiftManagerKt.l(r8);
        if (r9 != null) goto L18;
    L21:
        r(r0, "duration", Long.valueOf(r14));
        String r2 = com.bytedance.android.livesdk.gift.platform.core.utils.z.a("ttlive_gift_send_status");
        JSONObject r5 = new JSONObject();
        JSONObject r6 = new JSONObject();
        JSONObject r7 = new JSONObject();
        Intrinsics.checkNotNullParameter(r7, "extra");
        Intrinsics.checkNotNullParameter(r6, "metric");
        EventModule r19 = EventModule.LIVE_GIFT;
        Intrinsics.checkNotNullParameter(r19, "eventModule");
        String r3 = r19.getValue();
        r6.put("status", String.valueOf(0));
        Intrinsics.checkNotNullParameter(r7, "map");
        Iterator<String> r20 = r0.keys();
    L23:
        if (r20.hasNext() == false) goto L25;
        String r21 = r20.next();
        Object r110 = r0.get(r21);
        Intrinsics.checkNotNullParameter(r21, "key");
        Intrinsics.checkNotNullParameter(r110, "value");
        r7.put(r21, r110);
        goto L23
    L25:
        cy0.e.a.getClass();
        cy0.j r23 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r24 = com.bytedance.android.scope.m.b(r23).b(n97.a.class);
        Intrinsics.checkNotNull(r24);
        ((com.bytedance.live.kmp.core.c) r24).g(r2, r3, "bussiness_api_call", r5, r6, r7);
        return;
    L18:
        if (l0.e(r9) == false) goto L20;
        r(r0, "free_display", 1);
        goto L21
    L20:
        r(r0, "free_display", 0);
        goto L21
    L8:
        r17 = null;
        goto L9
    }

    @JvmStatic
    public static final void s(long r11, int r13, String r14, boolean r15, boolean r16, boolean r17) {
        Intrinsics.checkNotNullParameter(r14, "msg");
        JSONObject r2 = new JSONObject();
        c0 r3 = a;
        r(r2, "asset_id", Long.valueOf(r11));
        r(r2, "open_sr", Boolean.valueOf(r15));
        r(r2, "use_sr", Boolean.valueOf(r16));
        r(r2, "msg", r14);
        r(r2, "error_code", Integer.valueOf(r13));
        if (r17 == false) goto L9;
        String r0 = com.bytedance.android.livesdk.gift.platform.core.utils.z.a("ttlive_gift_open_sr_status");
        JSONObject r1 = new JSONObject();
        JSONObject r4 = new JSONObject();
        JSONObject r5 = new JSONObject();
        Intrinsics.checkNotNullParameter(r5, "extra");
        Intrinsics.checkNotNullParameter(r4, "metric");
        EventModule r6 = EventModule.LIVE_GIFT;
        Intrinsics.checkNotNullParameter(r6, "eventModule");
        String r7 = r6.getValue();
        r4.put("status", String.valueOf(0));
        Intrinsics.checkNotNullParameter(r5, "map");
        Iterator<String> r8 = r2.keys();
    L6:
        if (r8.hasNext() == false) goto L8;
        String r9 = r8.next();
        Object r10 = r2.get(r9);
        Intrinsics.checkNotNullParameter(r9, "key");
        Intrinsics.checkNotNullParameter(r10, "value");
        r5.put(r9, r10);
        goto L6
    L8:
        cy0.e.a.getClass();
        cy0.j r18 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r19 = com.bytedance.android.scope.m.b(r18).b(n97.a.class);
        Intrinsics.checkNotNull(r19);
        ((com.bytedance.live.kmp.core.c) r19).g(r0, r7, "bussiness_api_call", r1, r4, r5);
        return;
    L9:
        r3.o("ttlive_gift_open_sr_status", r2);
    }

    public static void g(long r13, int r15, long r16, long r18, int r20, float r21, double r23, double r24, double r26, boolean r28, int r29, boolean r30) {
        JSONObject r0 = new JSONObject();
        r(r0, "room_id", Long.valueOf(r13));
        r(r0, "gift_id", Long.valueOf(r16));
        r(r0, "is_anchor", Integer.valueOf(r15));
        r(r0, "asset_id", Long.valueOf(r18));
        r(r0, "stay_room_duration", Integer.valueOf(r20));
        r(r0, "temperature", Float.valueOf(r21));
        r(r0, "GPU", Double.valueOf(r24));
        r(r0, "CPU", Double.valueOf(r26));
        r(r0, "FPS", Double.valueOf(r23));
        r(r0, "video_asset_type", Integer.valueOf(r29));
        r(r0, "enable_sr", Boolean.valueOf(r30));
        if (r28 == false) goto L9;
        JSONObject r10 = new JSONObject();
        JSONObject r11 = new JSONObject();
        JSONObject r14 = new JSONObject();
        Intrinsics.checkNotNullParameter(r14, "extra");
        Intrinsics.checkNotNullParameter(r11, "metric");
        EventModule r4 = EventModule.LIVE_GIFT;
        Intrinsics.checkNotNullParameter(r4, "eventModule");
        String r2 = r4.getValue();
        r11.put("status", String.valueOf(0));
        Intrinsics.checkNotNullParameter(r14, "map");
        Iterator<String> r1 = r0.keys();
    L6:
        if (r1.hasNext() == false) goto L8;
        String r5 = r1.next();
        Object r7 = r0.get(r5);
        Intrinsics.checkNotNullParameter(r5, "key");
        Intrinsics.checkNotNullParameter(r7, "value");
        r14.put(r5, r7);
        goto L6
    L8:
        cy0.e.a.getClass();
        cy0.j r3 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r6 = com.bytedance.android.scope.m.b(r3).b(n97.a.class);
        Intrinsics.checkNotNull(r6);
        ((com.bytedance.live.kmp.core.c) r6).g("ttlive_gift_effect_play_perf_status_post", r2, "bussiness_api_call", r10, r11, r14);
        return;
    L9:
        JSONObject r17 = new JSONObject();
        JSONObject r19 = new JSONObject();
        JSONObject r110 = new JSONObject();
        Intrinsics.checkNotNullParameter(r110, "extra");
        Intrinsics.checkNotNullParameter(r19, "metric");
        EventModule r8 = EventModule.LIVE_GIFT;
        Intrinsics.checkNotNullParameter(r8, "eventModule");
        String r9 = r8.getValue();
        r19.put("status", String.valueOf(0));
        Intrinsics.checkNotNullParameter(r110, "map");
        Iterator<String> r25 = r0.keys();
    L11:
        if (r25.hasNext() == false) goto L13;
        String r27 = r25.next();
        Object r31 = r0.get(r27);
        Intrinsics.checkNotNullParameter(r27, "key");
        Intrinsics.checkNotNullParameter(r31, "value");
        r110.put(r27, r31);
        goto L11
    L13:
        cy0.e.a.getClass();
        cy0.j r33 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r34 = com.bytedance.android.scope.m.b(r33).b(n97.a.class);
        Intrinsics.checkNotNull(r34);
        ((com.bytedance.live.kmp.core.c) r34).g("ttlive_gift_effect_play_perf_status_during", r9, "bussiness_api_call", r17, r19, r110);
    }

    public static void b(boolean r19, long r20, String r23, int r24, String r25, int r26, String r27, String r28, Map r29, Map r210, boolean r30, boolean r31, boolean r33) {
        boolean r1 = d0.a;
        if (r210 != null) goto L5;
        Map r2 = MapsKt.emptyMap();
    L6:
        d0.g(r2);
        LinkedHashMap r3 = new LinkedHashMap();
        if (r29 == null) goto L12;
        Iterator r4 = r29.entrySet().iterator();
    L10:
        if (r4.hasNext() == false) goto L12;
        Map.Entry r5 = (Map.Entry) r4.next();
        r3.put((String) r5.getKey(), r5.getValue());
    L12:
        String r6 = BuildConfig.FLAVOR;
        if (r23 != null) goto L15;
        String r7 = BuildConfig.FLAVOR;
    L16:
        r3.put("url", r7);
        if (r25 != null) goto L19;
        String r8 = BuildConfig.FLAVOR;
    L20:
        r3.put("error_msg", r8);
        r3.put("asset_show_extra", Integer.valueOf(r26));
        LinkedHashMap r9 = new LinkedHashMap();
        r9.put("error_code", Integer.valueOf(r24));
        if (r27 != null) goto L23;
        String r10 = BuildConfig.FLAVOR;
    L24:
        r9.put("gift_player_type", r10);
        String r11 = "1";
        if (r30 == false) goto L27;
        Object r13 = "1";
    L28:
        r9.put("is_anchor", r13);
        if (r31 == false) goto L31;
        Object r14 = "1";
    L32:
        r9.put("is_gift_receiver", r14);
        if (r33 == true) goto L36;
        r11 = "0";
    L36:
        r9.put("is_gift_sender", r11);
        LinkedHashMap r15 = new LinkedHashMap();
        r15.put("asset_id", Long.valueOf(r20));
        if (r28 == null) goto L40;
        r6 = r28;
    L40:
        r15.put("log_id", r6);
        if (TextUtils.equals("TTGiftPlayerImpl", r27) == false) goto L43;
    L44:
        r15.put("gift_ttplayer_hardcore", Integer.valueOf(com.bytedance.android.livesdk.gift.platform.business.effect.a.h()));
    L45:
        String r16 = com.bytedance.android.livesdk.gift.platform.core.utils.z.a("ttlive_gift_asset_show_status");
        JSONObject r17 = new JSONObject();
        JSONObject r18 = new JSONObject();
        JSONObject r21 = new JSONObject();
        Intrinsics.checkNotNullParameter(r21, "extra");
        Intrinsics.checkNotNullParameter(r18, "metric");
        EventModule r110 = EventModule.LIVE_GIFT;
        String r111 = "eventModule";
        Intrinsics.checkNotNullParameter(r110, "eventModule");
        String r112 = r110.getValue();
        String r113 = "status";
        if (r19 == false) goto L48;
        r18.put("status", String.valueOf(0));
    L49:
        Intrinsics.checkNotNullParameter(r17, "map");
        Iterator r114 = r9.entrySet().iterator();
    L50:
        LinkedHashMap r211 = r9;
        if (r114.hasNext() == false) goto L53;
        Map.Entry r115 = (Map.Entry) r114.next();
        String r212 = r113;
        String r116 = (String) r115.getKey();
        String r34 = r111;
        Object r117 = r115.getValue();
        Intrinsics.checkNotNullParameter(r116, "key");
        Intrinsics.checkNotNullParameter(r117, "value");
        r17.put(r116, r117);
        r9 = r211;
        r113 = r212;
        r111 = r34;
        goto L50
    L53:
        String r35 = r111;
        String r213 = r113;
        Intrinsics.checkNotNullParameter(r18, "map");
        Iterator r118 = r15.entrySet().iterator();
    L55:
        if (r118.hasNext() == false) goto L57;
        Map.Entry r119 = (Map.Entry) r118.next();
        Iterator r214 = r118;
        String r120 = (String) r119.getKey();
        Object r121 = r119.getValue();
        Intrinsics.checkNotNullParameter(r120, "key");
        Intrinsics.checkNotNullParameter(r121, "value");
        r18.put(r120, r121);
        r118 = r214;
        goto L55
    L57:
        Intrinsics.checkNotNullParameter(r21, "map");
        Iterator r122 = r3.entrySet().iterator();
    L59:
        if (r122.hasNext() == false) goto L61;
        Map.Entry r123 = (Map.Entry) r122.next();
        Iterator r215 = r122;
        String r124 = (String) r123.getKey();
        Object r125 = r123.getValue();
        Intrinsics.checkNotNullParameter(r124, "key");
        Intrinsics.checkNotNullParameter(r125, "value");
        r21.put(r124, r125);
        r122 = r215;
        goto L59
    L61:
        cy0.e.a.getClass();
        cy0.j r126 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r127 = com.bytedance.android.scope.m.b(r126).b(n97.a.class);
        Intrinsics.checkNotNull(r127);
        ((com.bytedance.live.kmp.core.c) r127).g(r16, r112, "bussiness_api_call", r17, r18, r21);
        if (r19 == true) goto L84;
        String r0 = com.bytedance.android.livesdk.gift.platform.core.utils.z.b("ttlive_gift_asset_show_status");
        JSONObject r36 = new JSONObject();
        JSONObject r37 = new JSONObject();
        JSONObject r38 = new JSONObject();
        Intrinsics.checkNotNullParameter(r38, "extra");
        Intrinsics.checkNotNullParameter(r37, "metric");
        EventModule r39 = EventModule.LIVE_GIFT;
        Intrinsics.checkNotNullParameter(r39, r35);
        String r40 = r39.getValue();
        r37.put(r213, String.valueOf(1));
        Intrinsics.checkNotNullParameter(r36, "map");
        Iterator r41 = r211.entrySet().iterator();
    L65:
        if (r41.hasNext() == false) goto L67;
        Map.Entry r128 = (Map.Entry) r41.next();
        String r129 = (String) r128.getKey();
        Object r130 = r128.getValue();
        Intrinsics.checkNotNullParameter(r129, "key");
        Intrinsics.checkNotNullParameter(r130, "value");
        r36.put(r129, r130);
        goto L65
    L67:
        Intrinsics.checkNotNullParameter(r37, "map");
        Iterator r43 = r15.entrySet().iterator();
    L69:
        if (r43.hasNext() == false) goto L71;
        Map.Entry r44 = (Map.Entry) r43.next();
        String r131 = (String) r44.getKey();
        Object r45 = r44.getValue();
        Intrinsics.checkNotNullParameter(r131, "key");
        Intrinsics.checkNotNullParameter(r45, "value");
        r37.put(r131, r45);
        goto L69
    L71:
        Intrinsics.checkNotNullParameter(r38, "map");
        Iterator r46 = r3.entrySet().iterator();
    L73:
        if (r46.hasNext() == false) goto L75;
        Map.Entry r47 = (Map.Entry) r46.next();
        String r48 = (String) r47.getKey();
        Object r49 = r47.getValue();
        Intrinsics.checkNotNullParameter(r48, "key");
        Intrinsics.checkNotNullParameter(r49, "value");
        r38.put(r48, r49);
        goto L73
    L75:
        cy0.e.a.getClass();
        cy0.j r50 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r51 = com.bytedance.android.scope.m.b(r50).b(n97.a.class);
        Intrinsics.checkNotNull(r51);
        ((com.bytedance.live.kmp.core.c) r51).g(r0, r40, "bussiness_api_call", r36, r37, r38);
        return;
    L84:
        return;
    L48:
        r18.put("status", String.valueOf(1));
        goto L49
    L43:
        if (TextUtils.equals("TTEnginePlayerImpl", r27) == false) goto L45;
    L31:
        r14 = "0";
        goto L32
    L27:
        r13 = "0";
        goto L28
    L23:
        r10 = r27;
        goto L24
    L19:
        r8 = r25;
        goto L20
    L15:
        r7 = r23;
        goto L16
    L5:
        r2 = r210;
        goto L6
    }
}
