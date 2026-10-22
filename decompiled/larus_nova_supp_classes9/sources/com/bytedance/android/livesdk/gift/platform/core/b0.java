package com.bytedance.android.livesdk.gift.platform.core;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.revenue.monitor.EventModule;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKt_androidKt;
import com.bytedance.bdlocation.BuildConfig;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b0 {
    public static final b0 a = null;

    public b0() {
    }

    static {
        a = new b0();
    }

    public static void a(long r10, int r13) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("status_code", 0);
        r0.put("status", 0);
        r0.put("source_type", Integer.valueOf(r13));
        LinkedHashMap r14 = new LinkedHashMap();
        r14.put("duration", Long.valueOf(r10));
        LinkedHashMap r11 = new LinkedHashMap();
        yz0.g r15 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.g.class);
        String r1 = null;
        if (r15 == null) goto L5;
        IRoomBase r16 = r15.getRoom();
    L7:
        if ((r16 instanceof IRoom) == true) goto L9;
        r16 = null;
    L9:
        IRoomBase r17 = (IRoom) r16;
        String r2 = BuildConfig.FLAVOR;
        if (r17 == null) goto L15;
        r11.put("room_id", Long.valueOf(IRoomKtKt.getId(r17)));
        String r3 = IRoomKt_androidKt.getAnchorId(r17);
        if (r3 != null) goto L14;
        r3 = BuildConfig.FLAVOR;
    L14:
        r11.put("anchor_id", r3);
    L15:
        i12.d r4 = i12.m.e2.a();
        if (r4 == null) goto L18;
        com.bytedance.android.scope.m.e.getClass();
        com.bytedance.android.scope.o r5 = (com.bytedance.android.scope.o) com.bytedance.android.scope.m.b(r4).a(Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f.class));
    L19:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f r6 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f) r5;
        if (r6 == null) goto L27;
        IBaseUser r7 = r6.a;
        if (r7 == null) goto L27;
        String r8 = r7.getIdString();
        if (r8 == null) goto L27;
        r1 = r8;
    L29:
        if (r1 == null) goto L32;
        r2 = r1;
    L32:
        r11.put("to_anchor_id", r2);
        String r9 = com.bytedance.android.livesdk.gift.platform.core.utils.z.a("ttlive_asset_list_status");
        JSONObject r18 = new JSONObject();
        JSONObject r19 = new JSONObject();
        JSONObject r20 = new JSONObject();
        Intrinsics.checkNotNullParameter(r20, "extra");
        Intrinsics.checkNotNullParameter(r19, "metric");
        EventModule r110 = EventModule.LIVE_GIFT;
        Intrinsics.checkNotNullParameter(r110, "eventModule");
        String r21 = r110.getValue();
        Intrinsics.checkNotNullParameter(r18, "map");
        Intrinsics.checkNotNullParameter(r0, "value");
        Iterator r23 = r0.entrySet().iterator();
    L34:
        if (r23.hasNext() == false) goto L36;
        Map.Entry r24 = (Map.Entry) r23.next();
        r18.put((String) r24.getKey(), r24.getValue());
        goto L34
    L36:
        Intrinsics.checkNotNullParameter(r19, "map");
        Intrinsics.checkNotNullParameter(r14, "value");
        Iterator r111 = r14.entrySet().iterator();
    L38:
        if (r111.hasNext() == false) goto L40;
        Map.Entry r25 = (Map.Entry) r111.next();
        r19.put((String) r25.getKey(), r25.getValue());
        goto L38
    L40:
        Intrinsics.checkNotNullParameter(r20, "map");
        Intrinsics.checkNotNullParameter(r11, "value");
        Iterator r112 = r11.entrySet().iterator();
    L42:
        if (r112.hasNext() == false) goto L44;
        Map.Entry r113 = (Map.Entry) r112.next();
        r20.put((String) r113.getKey(), r113.getValue());
        goto L42
    L44:
        cy0.e.a.getClass();
        cy0.j r114 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r115 = com.bytedance.android.scope.m.b(r114).b(n97.a.class);
        Intrinsics.checkNotNull(r115);
        ((com.bytedance.live.kmp.core.c) r115).g(r9, r21, "bussiness_api_call", r18, r19, r20);
        return;
    L27:
        if (r17 == null) goto L29;
        r1 = IRoomKt_androidKt.getAnchorId(r17);
        goto L29
    L18:
        r5 = null;
        goto L19
    L5:
        r16 = null;
        goto L7
    }

    public static void c(b0 r7, String r8, JSONObject r9, int r10) {
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

    public final void d(long r3, long r5, int r7, Throwable r8) {
        JSONObject r0 = new JSONObject();
        j01.d.b(r0, "room_id", Long.valueOf(r5));
        j01.d.b(r0, "gift_id", Long.valueOf(r3));
        j01.d.b(r0, "action", Integer.valueOf(r7));
        if (r8 == null) goto L5;
        j01.d.b(r0, "error", String.valueOf(r8.getMessage()));
        c(this, com.bytedance.android.livesdk.gift.platform.core.utils.z.b("ttlive_gift_mostly_used_operate_status"), r0, 1);
        return;
    L5:
        c(this, com.bytedance.android.livesdk.gift.platform.core.utils.z.a("ttlive_gift_mostly_used_operate_status"), r0, 0);
    }

    public final void e(int r3, long r4, Long r6, Throwable r7) {
        JSONObject r0 = new JSONObject();
        j01.d.b(r0, "room_id", Long.valueOf(r4));
        j01.d.b(r0, "sort_strategy", Integer.valueOf(r3));
        if (r6 == null) goto L6;
        r6.longValue();
        j01.d.b(r0, "new_sort_strategy", r6);
    L6:
        if (r7 == null) goto L8;
        j01.d.b(r0, "error", String.valueOf(r7.getMessage()));
        c(this, com.bytedance.android.livesdk.gift.platform.core.utils.z.b("ttlive_gift_mostly_used_pin_status"), r0, 1);
        return;
    L8:
        c(this, com.bytedance.android.livesdk.gift.platform.core.utils.z.a("ttlive_gift_mostly_used_pin_status"), r0, 0);
    }

    public final void b(long r3, long r5, String r7, long r8, long r10, long r13) {
        JSONObject r0 = new JSONObject();
        j01.d.b(r0, "gift_id", Long.valueOf(r3));
        j01.d.b(r0, "asset_id", Long.valueOf(r5));
        if (r7 != null) goto L5;
        r7 = BuildConfig.FLAVOR;
    L5:
        j01.d.b(r0, "log_id", r7);
        j01.d.b(r0, "receive_time_mills", Long.valueOf(r8));
        j01.d.b(r0, "expired_time_mills", Long.valueOf(r10));
        j01.d.b(r0, "total_spend_time", Long.valueOf(r13));
        j01.d.b(r0, "duration", 0);
        c(this, "ttlive_gift_message_expired_status", r0, 1);
        jy0.b.b("IGiftMessage", "sticker message expired extra:" + r0, null);
    }
}
