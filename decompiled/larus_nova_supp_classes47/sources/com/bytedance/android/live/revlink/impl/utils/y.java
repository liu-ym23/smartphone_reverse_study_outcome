package com.bytedance.android.live.revlink.impl.utils;

import com.bytedance.android.live.revlink.impl.monitor.LiveFullLinkPKMonitor;
import fr2.i0;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class y {
    public final com.bytedance.android.live.revenuelink.rtc.i a;

    public static boolean b() {
        r11.h r0 = com.bytedance.android.live.revlink.impl.settings.live.b.p.a();
        Intrinsics.checkNotNullParameter(r0, "$this$isForceEnable");
        if (r0.getEnable() == true) goto L5;
    L11:
        boolean r1 = false;
    L12:
        if (r1 == false) goto L14;
    L17:
        return true;
    L14:
        if (com.bytedance.android.live.revlink.impl.perf.f.b() == true) goto L17;
        if (com.bytedance.android.live.revlink.impl.perf.f.a() == true) goto L17;
        return false;
    L5:
        if (r0.f4() == false) goto L11;
        Map<Integer, r11.h.b> r2 = r0.k();
        if (r2 == null) goto L11;
        if ((!r2.isEmpty()) != true) goto L11;
        r1 = true;
        goto L12
    }

    public y(com.bytedance.android.live.revenuelink.rtc.i r1) {
        this.a = r1;
    }

    public static String e(String r17) {
        Intrinsics.checkNotNullParameter(r17, "rtcExtInfo");
        com.bytedance.android.live.revlink.impl.settings.live.b r8 = com.bytedance.android.live.revlink.impl.settings.live.b.p;
        r11.h r9 = r8.a();
        Intrinsics.checkNotNullParameter(r9, "$this$isRtcEnable");
        if (r9.getEnable() == false) goto L9;
        Map<Integer, r11.h.b> r10 = r9.k();
        if (r10 == null) goto L9;
        boolean r12 = true;
        if ((!r10.isEmpty()) != true) goto L9;
    L10:
        if (r12 == true) goto L13;
        return r17;
    L13:
        if (b() == true) goto L46;
        return r17;
    L46:
        JSONObject r13 = new JSONObject(r17);     // Catch: Exception -> L40
        JSONObject r14 = r13.optJSONObject("live_rtc_video_param");     // Catch: Exception -> L40
        if (r14 == null) goto L45;
        JSONObject r15 = r14.optJSONObject("rtc_video_param_1v1_client");     // Catch: Exception -> L40
        if (r15 == null) goto L45;
        int r16 = r15.optInt("width", -1);     // Catch: Exception -> L40
        int r18 = r15.optInt("height", -1);     // Catch: Exception -> L40
        int r19 = r15.optInt("bitparseLiveRtcOtherrate_kbps", -1);     // Catch: Exception -> L40
        int r110 = r15.optInt("bitrate_kbps", -1);     // Catch: Exception -> L40
        if (r16 <= 0) goto L45;
        if (r18 <= 0) goto L45;
        if (r19 <= 0) goto L45;
        if (r110 <= 0) goto L45;
        if (r18 <= 0) goto L33;
        Map<Integer, r11.h.b> r20 = r8.a().k();     // Catch: Exception -> L40
        if (r20 == null) goto L33;
        Collection<r11.h.b> r22 = r20.values();     // Catch: Exception -> L40
        if (r22 == null) goto L33;
        r11.h.b r23 = c(r16, r18, CollectionsKt.toList(r22));     // Catch: Exception -> L40
    L34:
        if (r23 == null) goto L45;
        r15.put("width", r23.getW());     // Catch: Exception -> L40
        r15.put("height", r23.getH());     // Catch: Exception -> L40
        r15.put("bitparseLiveRtcOtherrate_kbps", r23.j());     // Catch: Exception -> L40
        r15.put("bitrate_kbps", r23.j());     // Catch: Exception -> L40
        r14.put("rtc_video_param_1v1_client", r15);     // Catch: Exception -> L40
        JSONObject r2 = r14.optJSONObject("rtc_video_param_1v1_server");     // Catch: Exception -> L40
        if (r2 == null) goto L38;
        r2.put("width", r23.getW());     // Catch: Exception -> L40
        r2.put("height", r23.getH());     // Catch: Exception -> L40
        r2.put("bitparseLiveRtcOtherrate_kbps", r23.j());     // Catch: Exception -> L40
        r2.put("bitrate_kbps", r23.j());     // Catch: Exception -> L40
        r14.put("rtc_video_param_1v1_server", r2);     // Catch: Exception -> L40
    L38:
        r13.put("live_rtc_video_param", r14);     // Catch: Exception -> L40
        return r13.toString();
    L33:
        r23 = null;
    L45:
        return r17;
    L40:
        e = move-exception;
        String r0 = e.getMessage();
        if (r0 != null) goto L44;
        r0 = "";
    L44:
        jy0.b.c("RevLinkParamsAdjustUtils", "interceptRtcExt error".concat(r0), null, 4);
    L9:
        r12 = false;
        goto L10
    }

    public final String a(String r15) {
        com.bytedance.android.live.revlink.impl.settings.live.b r1 = com.bytedance.android.live.revlink.impl.settings.live.b.p;
        r1.getClass();
        ReadOnlyProperty r2 = com.bytedance.android.live.revlink.impl.settings.live.b.k;
        KProperty[] r3 = com.bytedance.android.live.revlink.impl.settings.live.b.a;
        if (((r11.g) r2.getValue(r1, r3[9])).getEnable() == true) goto L64;
        return r15;
    L64:
        JSONObject r6 = new JSONObject(r15);     // Catch: Exception -> L58
        JSONObject r7 = r6.optJSONObject("PushBase");     // Catch: Exception -> L58
        if (((r11.g) r2.getValue(r1, r3[9])).S1() == false) goto L24;
        if (r7 == null) goto L11;
        int r8 = r7.optInt("defaultBitrate");     // Catch: Exception -> L58
    L12:
        if (r7 == null) goto L14;
        int r12 = r7.optInt("minBitrate");     // Catch: Exception -> L58
    L15:
        if (r7 == null) goto L17;
        int r13 = r7.optInt("maxBitrate");     // Catch: Exception -> L58
    L18:
        if (r8 <= 0) goto L24;
        if (r12 <= 0) goto L24;
        if (r13 <= 0) goto L24;
        if (r7 == null) goto L23;
        r7.put("enable_siti", false);     // Catch: Exception -> L58
    L23:
        r6.put("PushBase", r7);     // Catch: Exception -> L58
        boolean r9 = true;
    L26:
        if (((r11.g) r2.getValue(r1, r3[9])).X5() == false) goto L46;
        if (r7 == null) goto L29;
        int r4 = r7.optInt("fps");     // Catch: Exception -> L58
    L30:
        if (r4 <= 0) goto L46;
        com.bytedance.android.live.revenuelink.rtc.i r5 = this.a;     // Catch: Exception -> L58
        if (r5 == null) goto L38;
        vc0.a r10 = r5.getLiveCore();     // Catch: Exception -> L58
        if (r10 == null) goto L38;
        fr2.p r14 = i0.a(r10);     // Catch: Exception -> L58
        if (r14 == null) goto L38;
        r14.R();     // Catch: Exception -> L58
    L38:
        com.bytedance.android.live.revenuelink.rtc.i r16 = this.a;     // Catch: Exception -> L58
        if (r16 == null) goto L41;
        r16.q0();     // Catch: Exception -> L58
    L41:
        if (r9 == true) goto L45;
        if (r7 == null) goto L44;
        r7.put("enable_siti", false);     // Catch: Exception -> L58
    L44:
        r6.put("PushBase", r7);     // Catch: Exception -> L58
        boolean r0 = true;
        r9 = true;
    L47:
        o41.a r17 = (o41.a) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), o41.a.class);     // Catch: Exception -> L58
        if (r17 == null) goto L56;
        o11.b r18 = r17.a;     // Catch: Exception -> L58
        if (r18 == null) goto L56;
        com.bytedance.android.scope.m.e.getClass();     // Catch: Exception -> L58
        com.bytedance.android.live.revlink.impl.global.c r19 = (com.bytedance.android.live.revlink.impl.global.c) com.bytedance.android.scope.m.b(r18).a(Reflection.getOrCreateKotlinClass(com.bytedance.android.live.revlink.impl.global.c.class));     // Catch: Exception -> L58
        if (r19 == null) goto L56;
        LiveFullLinkPKMonitor r20 = r19.getLiveFullLinkPKMonitor();     // Catch: Exception -> L58
        if (r20 == null) goto L56;
        LiveFullLinkPKMonitor.t(r20, "live_pk_adjust_params", null, MapsKt.mapOf(new Pair[]{TuplesKt.to("disable_siti", Boolean.valueOf(r9)), TuplesKt.to("disable_fps_fallback", Boolean.valueOf(r0))}), 2);     // Catch: Exception -> L58
    L56:
        return r6.toString();
    L45:
        r0 = true;
        goto L47
    L29:
        r4 = 0;
    L46:
        r0 = false;
        goto L47
    L17:
        r13 = 0;
        goto L18
    L14:
        r12 = 0;
        goto L15
    L11:
        r8 = 0;
    L24:
        r9 = false;
    L58:
        e = move-exception;
        String r22 = e.getMessage();
        if (r22 != null) goto L62;
        r22 = "";
    L62:
        jy0.b.c("RevLinkParamsAdjustUtils", "adjustLiveCoreParams error".concat(r22), null, 4);
        return r15;
    }

    public final String d(String r10) {
        Intrinsics.checkNotNullParameter(r10, "liveCoreInfo");
        com.bytedance.android.live.revlink.impl.settings.live.b r3 = com.bytedance.android.live.revlink.impl.settings.live.b.p;
        r11.h r4 = r3.a();
        Intrinsics.checkNotNullParameter(r4, "$this$isLiveCoreEnable");
        if (r4.getEnable() == false) goto L9;
        Map<Integer, r11.h.b> r5 = r4.n4();
        if (r5 == null) goto L9;
        boolean r6 = true;
        if ((!r5.isEmpty()) != true) goto L9;
    L10:
        if (r6 == false) goto L39;
        if (b() == false) goto L39;
        JSONObject r7 = new JSONObject(r10);     // Catch: Exception -> L32
        JSONObject r8 = r7.optJSONObject("PushBase");     // Catch: Exception -> L32
        if (r8 == null) goto L37;
        int r9 = r8.optInt("cap_adapted_width", -1);     // Catch: Exception -> L32
        int r12 = r8.optInt("cap_adapted_height", -1);     // Catch: Exception -> L32
        if (r9 <= 0) goto L37;
        if (r12 <= 0) goto L37;
        if (r12 <= 0) goto L28;
        Map<Integer, r11.h.b> r13 = r3.a().n4();     // Catch: Exception -> L32
        if (r13 == null) goto L28;
        Collection<r11.h.b> r14 = r13.values();     // Catch: Exception -> L32
        if (r14 == null) goto L28;
        r11.h.b r15 = c(r9, r12, CollectionsKt.toList(r14));     // Catch: Exception -> L32
    L29:
        if (r15 == null) goto L37;
        r8.put("cap_adapted_width", r15.getW());     // Catch: Exception -> L32
        r8.put("cap_adapted_height", r15.getH());     // Catch: Exception -> L32
        r7.put("PushBase", r8);     // Catch: Exception -> L32
        return r7.toString();
    L28:
        r15 = null;
    L37:
        return r10;
    L32:
        e = move-exception;
        String r0 = e.getMessage();
        if (r0 != null) goto L36;
        r0 = "";
    L36:
        jy0.b.c("RevLinkParamsAdjustUtils", "interceptLiveCoreExt error".concat(r0), null, 4);
    L39:
        return a(r10);
    L9:
        r6 = false;
        goto L10
    }

    public static r11.h.b c(int r5, int r6, Collection r7) {
        r11.h.b r0 = null;
        if (r6 != 0) goto L5;
        return null;
    L5:
        float r1 = r5 / r6;
        Iterator r8 = r7.iterator();
    L7:
        if (r8.hasNext() == false) goto L24;
        r11.h.b r2 = (r11.h.b) r8.next();
        if (r11.i.b(r2) == false) goto L7;
        if (r2.getW() > r5) goto L7;
        if (r2.getH() > r6) goto L7;
        if (r2.getH() == 0) goto L7;
        if (r1 != (r2.getW() / r2.getH())) goto L7;
        if (r0 == null) goto L23;
        if (r0.getW() >= r2.getW()) goto L7;
    L23:
        r0 = r2;
        goto L7
    L24:
        return r0;
    }
}
