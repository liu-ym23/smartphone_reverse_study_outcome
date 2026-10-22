package com.bytedance.android.livesdk.gift.blindbox;

import com.bytedance.android.live.base.model.message.PieceType;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.c5;
import com.bytedance.android.livesdk.gift.model.e0;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.revenue.monitor.EventModule;
import com.bytedance.bdlocation.BuildConfig;
import cy0.e;
import cy0.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.i;
import mz0.m;
import mz0.n;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c {
    public static final String a(e0 r14) {
        String r0 = "null";
        if (r14 != null) goto L5;
        return "null";
    L5:
        StringBuilder r1 = new StringBuilder("GiftBanner(text=");
        a5 r2 = r14.text;
        if (r2 == null) goto L24;
        List r3 = r2.getPieces();
        String r4 = null;
        if (r3 == null) goto L23;
        List r5 = r3;
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator r7 = r5.iterator();
    L12:
        if (r7.hasNext() == false) goto L22;
        c5 r8 = (c5) r7.next();
        if (r8 == null) goto L20;
        StringBuilder r9 = new StringBuilder("TextPiece(");
        if (r8.getType() != PieceType.STRING.getPieceType()) goto L18;
        String r10 = r8.getStringValue();
    L19:
        r9.append(r10);
        r9.append(')');
        String r11 = r9.toString();
    L21:
        r6.add(r11);
        goto L12
    L18:
        r10 = "type=" + r8.getType();
        goto L19
    L20:
        r11 = null;
        goto L21
    L22:
        r4 = CollectionsKt.joinToString$default(r6, null, "[", "]", 0, null, null, 57, null);
    L23:
        r0 = "Text(key=" + r2.getKey() + ", pattern=" + r2.getDefaultPattern() + ", pieces=" + r4 + ')';
    L24:
        r1.append(r0);
        r1.append(", textBgColor=");
        r1.append(r14.textBackgroundColor);
        r1.append(", boxImage=");
        r1.append(r14.boxImage);
        r1.append(", bgImage=");
        r1.append(r14.backgroundImage);
        r1.append(", uri=");
        r1.append(r14.uri);
        r1.append(", animate=");
        r1.append(r14.animate);
        r1.append(')');
        return r1.toString();
    }

    public static final void d(h1 r3) {
        Intrinsics.checkNotNullParameter(r3, "gift");
        JSONObject r0 = new JSONObject();
        f(r0, "gift_ids", String.valueOf(r3.getId()));
        e("ttlive_blind_box_gift_send", 0, r0);
        jy0.b.a("ttlive_blind_box", "ttlive_blind_box_gift_send " + r0);
    }

    public static final void b(String r2, Long r3) {
        JSONObject r0 = new JSONObject();
        f(r0, "uri", String.valueOf(r2));
        e("ttlive_blind_box_banner_click", 0, r0);
        jy0.b.a("ttlive_blind_box", "ttlive_blind_box_banner_click " + r0);
        Object r4 = r3;
        if (r3 != null) goto L5;
        r4 = BuildConfig.FLAVOR;
    L5:
        Map r5 = MapsKt.mapOf(TuplesKt.to("blind_box_gift_id", r4.toString()));
        n r6 = new n();
        Map r1 = r6.a;
        Intrinsics.checkNotNullParameter(r1, "map");
        Intrinsics.checkNotNullParameter(r5, "map");
        r1.putAll(r5);
        m r7 = new m();
        r7.b(LogCommon.ROOM);
        r7.b(LogCommon.PAGE_SOURCE_LOG);
        ((ArrayList) r6.b).addAll(r7.a);
        e.a.getClass();
        j r8 = e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r9 = com.bytedance.android.scope.m.b(r8).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r9);
        ((f80.a) r9).w3("livesdk_blind_box_entrance_click", r6.a, r6.b);
    }

    public static final void c(e0 r3, Long r4, boolean r5) {
        JSONObject r0 = new JSONObject();
        if (r4 == null) goto L5;
        long r1 = r4.longValue();
    L6:
        f(r0, "gift_id", Long.valueOf(r1));
        f(r0, "gift_banner", a(r3));
        f(r0, "visible", Boolean.valueOf(r5));
        e("ttlive_blind_box_banner_status", 0, r0);
        jy0.b.a("ttlive_blind_box", "ttlive_blind_box_banner_status " + r0);
        if (r5 == false) goto L10;
        Map r6 = MapsKt.mapOf(TuplesKt.to("blind_box_gift_id", String.valueOf(r4)));
        n r7 = new n();
        Map r8 = r7.a;
        Intrinsics.checkNotNullParameter(r8, "map");
        Intrinsics.checkNotNullParameter(r6, "map");
        r8.putAll(r6);
        m r9 = new m();
        r9.b(LogCommon.ROOM);
        r9.b(LogCommon.PAGE_SOURCE_LOG);
        ((ArrayList) r7.b).addAll(r9.a);
        e.a.getClass();
        j r10 = e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r11 = com.bytedance.android.scope.m.b(r10).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r11);
        ((f80.a) r11).w3("livesdk_blind_box_entrance_show", r7.a, r7.b);
        return;
    L10:
        return;
    L5:
        r1 = 0;
        goto L6
    }

    public static final void e(String r8, int r9, JSONObject r10) {
        Intrinsics.checkNotNullParameter(r8, "eventName");
        Intrinsics.checkNotNullParameter(r10, "extras");
        JSONObject r5 = new JSONObject();
        JSONObject r6 = new JSONObject();
        JSONObject r7 = new JSONObject();
        Intrinsics.checkNotNullParameter(r7, "extra");
        Intrinsics.checkNotNullParameter(r6, "metric");
        EventModule r0 = EventModule.GIFT;
        Intrinsics.checkNotNullParameter(r0, "eventModule");
        String r3 = r0.getValue();
        r6.put("status", String.valueOf(r9));
        Intrinsics.checkNotNullParameter(r7, "map");
        Iterator<String> r11 = r10.keys();
    L4:
        if (r11.hasNext() == false) goto L6;
        String r1 = r11.next();
        Object r2 = r10.get(r1);
        Intrinsics.checkNotNullParameter(r1, "key");
        Intrinsics.checkNotNullParameter(r2, "value");
        r7.put(r1, r2);
        goto L4
    L6:
        e.a.getClass();
        j r13 = e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r14 = com.bytedance.android.scope.m.b(r13).b(n97.a.class);
        Intrinsics.checkNotNull(r14);
        ((com.bytedance.live.kmp.core.c) r14).g(r8, r3, "bussiness_api_call", r5, r6, r7);
    }

    public static final void f(JSONObject r1, String r2, Object r3) {
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
        jy0.b.c("BindBoxTracing", r4, null, 4);
    }
}
