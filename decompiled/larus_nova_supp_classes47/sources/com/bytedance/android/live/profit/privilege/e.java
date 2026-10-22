package com.bytedance.android.live.profit.privilege;

import com.bytedance.android.live.profit.dress.api.OpenAssetPlayErrorType;
import com.bytedance.android.livesdk.revenue.monitor.EventModule;
import com.bytedance.android.scope.m;
import com.bytedance.badger.collect.impl.constants.Constants;
import cy0.j;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import zt0.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e implements f {
    public static final e a = null;

    public e() {
    }

    static {
        a = new e();
    }

    public static JSONObject n(Long r2) {
        return s(new Pair[]{TuplesKt.to(Constants.Keys.duration, r2)});
    }

    public static JSONObject s(Pair... r5) {
        JSONObject r0 = new JSONObject();
        int r1 = r5.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        Pair r3 = r5[r2];
        r0.put((String) r3.getFirst(), r3.getSecond());
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }

    public static JSONObject l(Long r3, String r4) {
        JSONObject r0 = new JSONObject();
        if (r3 == null) goto L5;
        t(r0, "room_id", Long.valueOf(r3.longValue()));
    L5:
        if (r4 == null) goto L7;
        t(r0, "anchor_id", r4);
    L7:
        return r0;
    }

    public static void o(JSONObject r3, JSONObject r4) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        Iterator<String> r1 = r4.keys();     // Catch: Throwable -> L8
    L4:
        if (r1.hasNext() == false) goto L6;
        String r2 = r1.next();     // Catch: Throwable -> L8
        r3.put(r2, r4.get(r2));     // Catch: Throwable -> L8
        goto L4
    L6:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    @Override // zt0.f
    public final void b(String r3, long r4) {
        Intrinsics.checkNotNullParameter(r3, "dressId");
        JSONObject r5 = s(new Pair[]{TuplesKt.to("dress_id", r3), TuplesKt.to("asset_id", Long.valueOf(r4))});
        JSONObject r6 = k(true, null, null);
        o(r6, r5);
        p("ttlive_open_asset_play_status", r6, null, r5);
    }

    public static JSONObject k(boolean r2, String r3, Integer r4) {
        JSONObject r0 = new JSONObject();
        if (r2 == false) goto L5;
        int r5 = 0;
    L6:
        t(r0, "status", Integer.valueOf(r5));
        t(r0, "error_msg", r3);
        t(r0, "error_code", r4);
        return r0;
    L5:
        r5 = -1;
        goto L6
    }

    public static /* synthetic */ JSONObject m(e r1, Long r2, int r3) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r1.getClass();
        return l(r2, null);
    }

    public static void t(JSONObject r1, String r2, Object r3) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        if (r3 == null) goto L5;
        r1.put(r2, r3);     // Catch: Throwable -> L7
    L5:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    @Override // zt0.f
    public final void c(JSONObject r3, JSONObject r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "category");
        Intrinsics.checkNotNullParameter(r4, "metrics");
        Intrinsics.checkNotNullParameter(r5, "userId");
        JSONObject r0 = new JSONObject();
        t(r0, "msg_id", r5);
        p("ttlive_enter_anim_resource_load_status", r3, r4, r0);
    }

    @Override // zt0.f
    public final void h(String r2, int r3, long r4) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        JSONObject r5 = k(true, null, null);
        JSONObject r6 = n(Long.valueOf(r4));
        JSONObject r7 = m(this, null, 6);
        t(r7, "emoji_size", Integer.valueOf(r3));
        p("ttlive_subscribe_emoji_add_all", r5, r6, r7);
    }

    @Override // zt0.f
    public final void j(JSONObject r3, JSONObject r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "category");
        Intrinsics.checkNotNullParameter(r4, "metrics");
        Intrinsics.checkNotNullParameter(r5, "userId");
        JSONObject r0 = new JSONObject();
        t(r0, "msg_id", r5);
        p("ttlive_enter_anim_show_time", r3, r4, r0);
    }

    public static void p(String r12, JSONObject r13, JSONObject r14, JSONObject r15) {
        JSONObject r4 = new JSONObject();
        JSONObject r5 = new JSONObject();
        JSONObject r6 = new JSONObject();
        Intrinsics.checkNotNullParameter(r6, "extra");
        Intrinsics.checkNotNullParameter(r5, "metric");
        EventModule r0 = EventModule.DRESS;
        Intrinsics.checkNotNullParameter(r0, "eventModule");
        String r2 = r0.getValue();
        Intrinsics.checkNotNullParameter(r4, "map");
        Iterator<String> r1 = r13.keys();
        if (r1 != null) goto L5;
    L12:
        Intrinsics.checkNotNullParameter(r5, "map");
        if (r14 == null) goto L24;
        Iterator<String> r16 = r14.keys();
        if (r16 == null) goto L24;
    L17:
        if (r16.hasNext() == false) goto L24;
        String r3 = r16.next();
        Object r10 = r14.opt(r3);
        if (r10 == null) goto L22;
        String r17 = r10.toString();
        if (r17 == null) goto L22;
    L23:
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r17, "value");
        r5.put(r3, r17);
    L22:
        r17 = "";
    L24:
        Intrinsics.checkNotNullParameter(r6, "map");
        Iterator<String> r18 = r15.keys();
        if (r18 != null) goto L27;
    L34:
        cy0.e.a.getClass();
        j r19 = cy0.e.a.a;
        m.e.getClass();
        Object r110 = m.b(r19).b(n97.a.class);
        Intrinsics.checkNotNull(r110);
        ((com.bytedance.live.kmp.core.c) r110).g(r12, r2, "bussiness_api_call", r4, r5, r6);
        return;
    L27:
        if (r18.hasNext() == false) goto L34;
        String r111 = r18.next();
        Object r7 = r15.opt(r111);
        if (r7 == null) goto L32;
        String r8 = r7.toString();
        if (r8 == null) goto L32;
    L33:
        Intrinsics.checkNotNullParameter(r111, "key");
        Intrinsics.checkNotNullParameter(r8, "value");
        r6.put(r111, r8);
    L32:
        r8 = "";
    L5:
        if (r1.hasNext() == false) goto L12;
        String r112 = r1.next();
        Object r113 = r13.opt(r112);
        if (r113 == null) goto L10;
        String r114 = r113.toString();
        if (r114 == null) goto L10;
    L11:
        Intrinsics.checkNotNullParameter(r112, "key");
        Intrinsics.checkNotNullParameter(r114, "value");
        r4.put(r112, r114);
    L10:
        r114 = "";
        goto L11
    }

    @Override // zt0.f
    public final void d(String r2, long r3, long r5, long r7) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        JSONObject r4 = k(true, null, null);
        JSONObject r8 = n(Long.valueOf(r7));
        JSONObject r6 = m(this, Long.valueOf(r3), 4);
        t(r6, "emoji_id", Long.valueOf(r5));
        p("ttlive_subscribe_send_emoji_all", r4, r8, r6);
    }

    @Override // zt0.f
    public final void e(String r3, long r4, OpenAssetPlayErrorType r6, String r7) {
        Intrinsics.checkNotNullParameter(r3, "dressId");
        Intrinsics.checkNotNullParameter(r6, "errorType");
        Intrinsics.checkNotNullParameter(r7, "reason");
        JSONObject r5 = s(new Pair[]{TuplesKt.to("dress_id", r3), TuplesKt.to("asset_id", Long.valueOf(r4))});
        JSONObject r8 = k(false, r7, Integer.valueOf(r6.getValue()));
        o(r8, r5);
        p("ttlive_open_asset_play_status_error", r8, null, r5);
        p("ttlive_open_asset_play_status", r8, null, r5);
    }

    @Override // zt0.f
    public final void g(String r2, int r3, String r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        Intrinsics.checkNotNullParameter(r4, Constants.Keys.ERROR);
        JSONObject r6 = k(false, r4, Integer.valueOf(r5));
        JSONObject r7 = n(null);
        JSONObject r8 = m(this, null, 6);
        t(r8, "emoji_size", Integer.valueOf(r3));
        p("ttlive_subscribe_emoji_add_all", r6, r7, r8);
    }

    @Override // zt0.f
    public final void i(String r2, long r3, long r5, int r7) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        JSONObject r4 = k(true, null, null);
        JSONObject r6 = n(Long.valueOf(r5));
        JSONObject r8 = m(this, Long.valueOf(r3), 4);
        t(r8, "style", Integer.valueOf(r7));
        p("ttlive_privilege_danmaku_send_status_all", r4, r6, r8);
    }

    @Override // zt0.f
    public final void a(String r2, long r3, long r5, String r7, int r8) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        Intrinsics.checkNotNullParameter(r7, Constants.Keys.ERROR);
        JSONObject r4 = k(false, r7, Integer.valueOf(r8));
        JSONObject r9 = n(null);
        JSONObject r6 = m(this, Long.valueOf(r3), 4);
        t(r6, "emoji_id", Long.valueOf(r5));
        p("ttlive_subscribe_send_emoji_all", r4, r9, r6);
    }

    @Override // zt0.f
    public final void f(String r2, long r3, int r5, String r6, int r7) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        Intrinsics.checkNotNullParameter(r6, Constants.Keys.ERROR);
        JSONObject r4 = k(false, r6, Integer.valueOf(r7));
        JSONObject r8 = n(null);
        JSONObject r9 = m(this, Long.valueOf(r3), 4);
        t(r9, "style", Integer.valueOf(r5));
        p("ttlive_privilege_danmaku_send_status_all", r4, r8, r9);
    }

    public final void r(String r2, String r3, long r4, long r6, boolean r8) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        Intrinsics.checkNotNullParameter(r3, "anchorId");
        JSONObject r5 = k(true, null, null);
        JSONObject r7 = n(Long.valueOf(r6));
        JSONObject r9 = l(Long.valueOf(r4), r3);
        t(r9, "is_vs", Integer.valueOf(r8 ? 1 : 0));
        p("ttlive_fansclub_me_status_all", r5, r7, r9);
    }

    public static void q(String r1, String r2, long r3, String r5, int r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r1, "userId");
        Intrinsics.checkNotNullParameter(r2, "anchorId");
        Intrinsics.checkNotNullParameter(r5, Constants.Keys.ERROR);
        JSONObject r4 = k(false, r5, Integer.valueOf(r6));
        JSONObject r8 = n(null);
        JSONObject r9 = l(Long.valueOf(r3), r2);
        t(r9, "is_vs", Integer.valueOf(r7 ? 1 : 0));
        p("ttlive_fansclub_me_status_all", r4, r8, r9);
        p("ttlive_fansclub_me_status_error", r4, r8, r9);
    }
}
