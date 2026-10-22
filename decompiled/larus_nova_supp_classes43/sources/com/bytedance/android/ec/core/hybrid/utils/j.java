package com.bytedance.android.ec.core.hybrid.utils;

import android.net.Uri;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.common.impl.order.OrderSchema;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.monitor.ECMonitorService;
import com.bytedance.android.ec.core.monitor.MetricNames;
import com.bytedance.android.ec.core.monitor.MonitorScenes;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.model.order.IOrderSchema;
import com.bytedance.android.ecom.bcm.track.api.EcomBcmTracker;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.services.apm.api.EnsureManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class j {
    public static final HashMap<String, JSONObject> a = null;
    public static final String[] b = null;

    public j() {
    }

    static {
        a = new HashMap();
        b = new String[]{"meta_params", com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, com.bytedance.android.ec.core.event.a.KEY_LOG_DATA, com.bytedance.android.ec.core.event.a.KEY_CID, com.bytedance.android.ec.core.event.a.KEY_CREATIVE_ID, com.bytedance.android.ec.core.event.a.KEY_LOG_EXTRA, com.bytedance.android.ec.core.event.a.KEY_CJ_INFO};
    }

    public static void a(IOrderSchema r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        if (r10.x1() == false) goto L30;
        OrderSchema.b r0 = r10.P0();
        OrderSchema.b r1 = r10.P();
        if (r0 == null) goto L7;
        r0.c(r1);
    L7:
        Object r11 = r10.Q();
        if ((r11 instanceof String) == true) goto L10;
        r11 = null;
    L10:
        String r12 = (String) r11;
        int r13 = 0;
        if (r12 != null) goto L13;
    L16:
        boolean r14 = true;
    L18:
        if (r14 == false) goto L20;
        r12 = r10.getQueryParam(com.bytedance.android.ec.core.event.a.KEY_CJ_INFO);
    L20:
        r10.t0(com.bytedance.android.ec.core.event.a.KEY_CJ_INFO, r12);
        JSONObject r15 = r10.q1();
        if (r15 == null) goto L26;
        Iterator<String> r16 = r15.keys();
    L24:
        if (r16.hasNext() == false) goto L26;
        String r17 = r16.next();
        r10.t0(r17, r15.opt(r17));
    L26:
        String[] r18 = b;
        int r19 = r18.length;
    L27:
        if (r13 >= r19) goto L29;
        r10.c(r18[r13]);
        r13 = r13 + 1;
        goto L27
    L29:
        return;
    L13:
        if (r12.length() == 0) goto L16;
        r14 = false;
        goto L18
    L30:
        r10.m1(r10.A0());
        a(r10);
    }

    public static JSONObject d(String r1) {
        Intrinsics.checkNotNullParameter(r1, "id");
        return a.get(r1);
    }

    public static boolean e(String r0) {
        if (r0 != null) goto L4;
    L6:
        return false;
    L4:
        if (r0.length() <= 0) goto L6;
        return true;
    }

    public static JSONObject i(String r1) {
    L6:
        e = move-exception;
        ECExceptionMonitor.f(e, "json_format_error");
        return null;
    L3:
        if (e(r1) == false) goto L12;
        return new JSONObject(r1);
    L12:
        return null;
    }

    public static String f(String r10, String r11) {
        JSONObject r12 = i(r11);
        if (r12 == null) goto L14;
        JSONObject r13 = i(r10);
        if (r13 == null) goto L12;
        Iterator<String> r0 = r12.keys();
    L8:
        if (r0.hasNext() == false) goto L15;
        String r1 = r0.next();
        r13.put(r1, r12.get(r1));
        goto L8
    L15:
        return r13.toString();
    L12:
        return r12.toString();
    L14:
        return r10;
    }

    public static void h(String r1, JSONObject r10) {
        Intrinsics.checkNotNullParameter(r1, "id");
        if (r10 == null) goto L5;
        a.put(r1, r10);
        return;
    L5:
        JSONObject r11 = a.remove(r1);
    }

    public static /* synthetic */ String c(String r10, boolean r11, int r12) {
        if ((r12 & 2) == 0) goto L5;
        boolean r0 = true;
    L7:
        if ((r12 & 4) == 0) goto L9;
        String r13 = "";
    L11:
        if ((r12 & 8) == 0) goto L14;
        r11 = false;
    L14:
        return b(r10, r0, r13, r11);
    L9:
        r13 = null;
        goto L11
    L5:
        r0 = false;
        goto L7
    }

    public static void g(JSONObject r1, String r10, String r11) {
        if (r11 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L10;
        return;
    L10:
        r1.put(r10, r11);
        return;
    L4:
        if (r11.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public static String b(String r21, boolean r22, String r23, boolean r24) {
        String r0 = r21;
        Intrinsics.checkNotNullParameter(r0, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r23, "passThroughMonitorId");
        int r10 = 0;
        if (r23.length() != 0) goto L5;
        boolean r11 = true;
    L7:
        if (r11 == false) goto L9;
        Map<String, com.bytedance.android.ec.core.monitor.a> r12 = com.bytedance.android.ec.core.monitor.c.a;
        String r13 = com.bytedance.android.ec.core.monitor.c.c(MonitorScenes.EC_JSON_DEAL_DURATION, null);
        com.bytedance.android.ec.core.monitor.c.e(r13, "type", "mega_object");
        com.bytedance.android.ec.core.monitor.c.f(r13, com.bytedance.android.ec.core.event.a.KEY_URL, r0);
        com.bytedance.android.ec.core.monitor.c.h(r13, MetricNames.DEAL_DURATION, null);
    L10:
        if (r22 == false) goto L12;
        String r14 = com.bytedance.android.ec.core.event.a.KEY_RIFLE_MEGA_OBJECT;
        String r15 = "rifle_mega_object_id";
    L14:
        if (StringsKt.contains$default(r0, r14, false, 2, null) == false) goto L271;
        Uri r1 = UriProtector.parse(r21);
        String r16 = UriProtector.getQueryParameter(r1, r14);
        if (r16 == null) goto L270;
        JSONObject r17 = i(r16);
        if (r17 == null) goto L270;
        JSONObject r18 = new JSONObject(r17.toString());
        String r19 = r17.optString(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO);
        String r110 = UriProtector.getQueryParameter(r1, com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO);
        if (r110 != null) goto L23;
    L31:
        String r111 = EcomBcmTracker.b(null, r19);
        String r112 = r17.optString(com.bytedance.android.ec.core.event.a.KEY_LOG_DATA);
        String r20 = UriProtector.getQueryParameter(r1, com.bytedance.android.ec.core.event.a.KEY_LOG_DATA);
        if (r20 != null) goto L34;
    L42:
        int r25 = com.bytedance.android.ec.core.opt.ab.a.a;
        int r26 = com.bytedance.android.ec.core.opt.ab.o.a;
        Object r27 = 1;
        boolean r113 = ECServiceManager.a;
        Object r28 = ((IAdapterService) ECServiceManager.c(IAdapterService.class)).getLiveSettingsValue("ec_fix_log_data", r27);
        if (r28 == null) goto L47;
        r27 = r28;
    L47:
        if (((Number) r27).intValue() != 1) goto L49;
        boolean r29 = true;
    L50:
        if (r29 == false) goto L65;
        if (r112 != null) goto L53;
    L56:
        boolean r30 = true;
    L57:
        if (r30 == true) goto L65;
        if (r24 == true) goto L65;
        JSONObject r31 = new JSONObject(r112);     // Catch: Exception -> L63
        if (r31.has(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO) == false) goto L65;
        r31.remove(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO);     // Catch: Exception -> L63
        r31.toString();     // Catch: Exception -> L63
    L63:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L65
    L53:
        if (r112.length() == 0) goto L56;
        r30 = false;
    L65:
        String r32 = r17.optString(com.bytedance.android.ec.core.event.a.KEY_LOG_EXTRA);
        String r33 = r17.optString(com.bytedance.android.ec.core.event.a.KEY_CID);
        String r34 = r17.optString(com.bytedance.android.ec.core.event.a.KEY_AD_EXTRA_DATA);
        String r210 = r13;
        String r114 = r17.optString(com.bytedance.android.ec.core.event.a.KEY_CJ_INFO);
        if (r114 != null) goto L68;
    L71:
        boolean r115 = true;
    L72:
        if (r115 == false) goto L74;
        r114 = UriProtector.getQueryParameter(r1, com.bytedance.android.ec.core.event.a.KEY_CJ_INFO);
    L74:
        String r116 = r15;
        String r117 = r17.optString(com.bytedance.android.ec.core.event.a.KEY_CREATIVE_ID);
        String r211 = r14;
        Uri r212 = r1;
        String r35 = r17.optString("ecom_live_lynx_log_data");
        String r36 = r17.optString("ecom_live_lynx_data");
        g(r18, com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, r111);
        g(r18, com.bytedance.android.ec.core.event.a.KEY_LOG_EXTRA, r32);
        g(r18, com.bytedance.android.ec.core.event.a.KEY_CID, r33);
        g(r18, com.bytedance.android.ec.core.event.a.KEY_AD_EXTRA_DATA, r34);
        g(r18, com.bytedance.android.ec.core.event.a.KEY_CJ_INFO, r114);
        g(r18, com.bytedance.android.ec.core.event.a.KEY_CREATIVE_ID, r117);
        g(r18, "ecom_live_lynx_log_data", r35);
        g(r18, "ecom_live_lynx_data", r36);
        String r37 = r17.optString("adinfojson");
        if (r37 == null) goto L85;
        JSONObject r38 = i(r37);
        if (r38 == null) goto L85;
        Iterator<String> r39 = r38.keys();
    L285:
    L83:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L85
    L80:
        if (r39.hasNext() == false) goto L85;
        String r40 = r39.next();     // Catch: Exception -> L83
        r18.put(r40, r38.opt(r40));     // Catch: Exception -> L83
    L85:
        String[] r41 = b;
        Set r42 = UriProtector.getQueryParameterNames(r212);
        Uri.Builder r43 = r212.buildUpon().clearQuery();
        Iterator r44 = r42.iterator();
    L87:
        if (r44.hasNext() == false) goto L95;
        String r45 = (String) r44.next();
        String r46 = r211;
        if ((!Intrinsics.areEqual(r45, r46)) == true) goto L91;
    L93:
        Uri r47 = r212;
    L94:
        r212 = r47;
        r211 = r46;
        goto L87
    L91:
        if (ArraysKt.contains(r41, r45) == true) goto L93;
        r47 = r212;
        r43.appendQueryParameter(r45, UriProtector.getQueryParameter(r47, r45));
        goto L94
    L95:
        Uri r48 = r43.build();
        String r49 = UUID.randomUUID().toString();
        Uri.Builder r50 = r48.buildUpon();
        r50.appendQueryParameter(r116, r49);
        int r51 = zg.a.a;
        int r52 = com.bytedance.android.ec.core.opt.ab.n.a;
        boolean r53 = false;
        Object r54 = 0;
        int r55 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r56 = Result.Companion;     // Catch: Throwable -> L250
        Object r57 = com.bytedance.android.ec.base.settings.d.c.get("ec_mega_object_inject");     // Catch: Throwable -> L146
        if (r57 != null) goto L101;
    L143:
        Object r58 = null;
    L144:
        Object r59 = Result.constructor-impl(r58);     // Catch: Throwable -> L146
    L148:
        Throwable r60 = Result.exceptionOrNull-impl(r59);     // Catch: Throwable -> L250
        if (r60 == null) goto L152;
        EnsureManager.ensureNotReachHere(r60);     // Catch: Throwable -> L250
    L152:
        if (Result.isFailure-impl(r59) == false) goto L155;
        r59 = null;
    L155:
        if ((r59 instanceof Integer) == true) goto L157;
        r59 = null;
    L157:
        Object r61 = (Integer) r59;     // Catch: Throwable -> L250
        if (r61 != null) goto L164;
        Object r62 = com.bytedance.android.ec.base.settings.d.a.get("ec_mega_object_inject");     // Catch: Throwable -> L250
        if ((r62 instanceof Integer) == true) goto L163;
        r62 = null;
    L163:
        r61 = (Integer) r62;     // Catch: Throwable -> L250
    L164:
        if (r61 != null) goto L260;
        int r63 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L250
        Object r64 = com.bytedance.android.ec.base.settings.d.c.get("ec_mega_object_inject");     // Catch: Throwable -> L216
        if (r64 != null) goto L171;
    L213:
        Object r65 = null;
    L214:
        Object r66 = Result.constructor-impl(r65);     // Catch: Throwable -> L216
    L218:
        Throwable r67 = Result.exceptionOrNull-impl(r66);     // Catch: Throwable -> L241
        if (r67 == null) goto L222;
        EnsureManager.ensureNotReachHere(r67);     // Catch: Throwable -> L241
    L222:
        if (Result.isFailure-impl(r66) == false) goto L225;
        r66 = null;
    L225:
        if ((r66 instanceof Integer) == true) goto L227;
        r66 = null;
    L227:
        r61 = (Integer) r66;     // Catch: Throwable -> L241
        if (r61 != null) goto L248;
        IHybridHostService r68 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L241
        if (r68 == null) goto L233;
        Object r69 = r68.getHostABValue("ec_mega_object_inject", r54);     // Catch: Throwable -> L241
    L234:
        if (r69 != null) goto L236;
    L247:
        r61 = r54;
        goto L248
    L236:
        if ((r69 instanceof Integer) == true) goto L238;
        r69 = null;
    L238:
        r61 = (Integer) r69;     // Catch: Throwable -> L241
        if (r61 != null) goto L248;
    L241:
        th = move-exception;
        Result.Companion r70 = Result.Companion;     // Catch: Throwable -> L250
        r61 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L250
        Throwable r71 = Result.exceptionOrNull-impl(r61);     // Catch: Throwable -> L250
        if (r71 == null) goto L246;
        EnsureManager.ensureNotReachHere(r71);     // Catch: Throwable -> L250
    L246:
        if (Result.isFailure-impl(r61) == false) goto L248;
    L233:
        r69 = null;
    L248:
        com.bytedance.android.ec.base.settings.d.d("ec_mega_object_inject", r61);     // Catch: Throwable -> L250
        goto L260
    L171:
        if ((r64 instanceof Integer) == true) goto L173;
        Object r72 = null;
    L174:
        r65 = (Integer) r72;     // Catch: Throwable -> L216
        if (r65 != null) goto L214;
        if ((r64 instanceof Number) == false) goto L201;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L186;
        Float r73 = Float.valueOf(((Number) r64).floatValue());     // Catch: Throwable -> L216
        if ((r73 instanceof Integer) == true) goto L184;
        r73 = null;
    L184:
        r65 = (Integer) r73;     // Catch: Throwable -> L216
        goto L214
    L186:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L192;
        Double r74 = Double.valueOf(((Number) r64).doubleValue());     // Catch: Throwable -> L216
        if ((r74 instanceof Integer) == true) goto L190;
        r74 = null;
    L190:
        r65 = (Integer) r74;     // Catch: Throwable -> L216
        goto L214
    L192:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L195;
        r65 = Integer.valueOf(((Number) r64).intValue());     // Catch: Throwable -> L216
        goto L214
    L195:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L201;
        Long r75 = Long.valueOf(((Number) r64).longValue());     // Catch: Throwable -> L216
        if ((r75 instanceof Integer) == true) goto L199;
        r75 = null;
    L199:
        r65 = (Integer) r75;     // Catch: Throwable -> L216
    L201:
        if ((r64 instanceof JSONObject) == false) goto L203;
    L289:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L209
        Object r76 = SDKSettingsCacheManager.a().fromJson(r64.toString(), Integer.class);     // Catch: Throwable -> L209
        if ((r76 instanceof Integer) == true) goto L207;
        r76 = null;
    L207:
        Object r77 = Result.constructor-impl((Integer) r76);     // Catch: Throwable -> L209
    L211:
        r65 = r77;
        if (Result.isFailure-impl(r65) == false) goto L214;
    L209:
        th = move-exception;
        Result.Companion r78 = Result.Companion;     // Catch: Throwable -> L216
        r77 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L216
        goto L211
    L203:
        if ((r64 instanceof JSONArray) == false) goto L213;
    L173:
        r72 = r64;
    L216:
        th = move-exception;
        Result.Companion r79 = Result.Companion;     // Catch: Throwable -> L241
        r66 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L241
    L260:
        if (((Number) r61).intValue() != 1) goto L262;
        boolean r80 = true;
    L263:
        if (r80 == false) goto L265;
        r50.appendQueryParameter("mega_object", r18.toString());
    L265:
        a.put(r49, r18);
        r0 = r50.toString();
        JSONObject r81 = new JSONObject();
        r81.put(com.bytedance.android.ec.core.event.a.KEY_URL, r0);
        r81.put(r116, r49);
        int r82 = ECMonitorService.b;
        ECMonitorService.a.a("ec_rifle_mega_object", r81, null, null);
        if (r210.length() <= 0) goto L268;
        r53 = true;
    L268:
        if (r53 == false) goto L270;
        Map<String, com.bytedance.android.ec.core.monitor.a> r83 = com.bytedance.android.ec.core.monitor.c.a;
        com.bytedance.android.ec.core.monitor.c.j(r210, MetricNames.DEAL_DURATION);
        com.bytedance.android.ec.core.monitor.c.d(r210);
        goto L270
    L262:
        r80 = false;
        goto L263
    L101:
        if ((r57 instanceof Integer) == true) goto L103;
        Object r84 = null;
    L104:
        r58 = (Integer) r84;     // Catch: Throwable -> L146
        if (r58 != null) goto L144;
        if ((r57 instanceof Number) == false) goto L131;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L116;
        Float r85 = Float.valueOf(((Number) r57).floatValue());     // Catch: Throwable -> L146
        if ((r85 instanceof Integer) == true) goto L114;
        r85 = null;
    L114:
        r58 = (Integer) r85;     // Catch: Throwable -> L146
        goto L144
    L116:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L122;
        Double r86 = Double.valueOf(((Number) r57).doubleValue());     // Catch: Throwable -> L146
        if ((r86 instanceof Integer) == true) goto L120;
        r86 = null;
    L120:
        r58 = (Integer) r86;     // Catch: Throwable -> L146
        goto L144
    L122:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L125;
        r58 = Integer.valueOf(((Number) r57).intValue());     // Catch: Throwable -> L146
        goto L144
    L125:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L131;
        Long r87 = Long.valueOf(((Number) r57).longValue());     // Catch: Throwable -> L146
        if ((r87 instanceof Integer) == true) goto L129;
        r87 = null;
    L129:
        r58 = (Integer) r87;     // Catch: Throwable -> L146
    L131:
        if ((r57 instanceof JSONObject) == false) goto L133;
    L287:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L139
        Object r88 = SDKSettingsCacheManager.a().fromJson(r57.toString(), Integer.class);     // Catch: Throwable -> L139
        if ((r88 instanceof Integer) == true) goto L137;
        r88 = null;
    L137:
        Object r89 = Result.constructor-impl((Integer) r88);     // Catch: Throwable -> L139
    L141:
        r58 = r89;
        if (Result.isFailure-impl(r58) == false) goto L144;
    L139:
        th = move-exception;
        Result.Companion r90 = Result.Companion;     // Catch: Throwable -> L146
        r89 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L146
        goto L141
    L133:
        if ((r57 instanceof JSONArray) == false) goto L143;
    L103:
        r84 = r57;
    L146:
        th = move-exception;
        Result.Companion r91 = Result.Companion;     // Catch: Throwable -> L250
        r59 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L250
    L250:
        th = move-exception;
        Result.Companion r92 = Result.Companion;
        Object r93 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r94 = Result.exceptionOrNull-impl(r93);
        if (r94 == null) goto L255;
        EnsureManager.ensureNotReachHere(r94);
    L255:
        if (Result.isFailure-impl(r93) == true) goto L258;
        r54 = r93;
    L258:
        r61 = r54;
        goto L260
    L68:
        if (r114.length() == 0) goto L71;
        r115 = false;
        goto L72
    L49:
        r29 = false;
        goto L50
    L34:
        if (r20.length() <= 0) goto L36;
        boolean r118 = true;
    L37:
        if (r118 == true) goto L40;
        r20 = null;
    L40:
        if (r20 == null) goto L42;
        r112 = f(r112, r20);
        goto L42
    L36:
        r118 = false;
        goto L37
    L23:
        if (r110.length() <= 0) goto L25;
        boolean r119 = true;
    L26:
        if (r119 == true) goto L29;
        r110 = null;
    L29:
        if (r110 == null) goto L31;
        r19 = f(r19, r110);
        goto L31
    L25:
        r119 = false;
    L270:
        return r0;
    L271:
        JSONObject r95 = new JSONObject();
        Uri r96 = UriProtector.parse(r21);
        String[] r97 = b;
        int r98 = r97.length;
    L272:
        if (r10 >= r98) goto L277;
        String r99 = r97[r10];
        String r120 = UriProtector.getQueryParameter(r96, r99);
        if (r120 == null) goto L276;
        r95.put(r99, r120);
    L276:
        r10 = r10 + 1;
        goto L272
    L277:
        Set r100 = UriProtector.getQueryParameterNames(r96);
        Uri.Builder r101 = r96.buildUpon().clearQuery();
        Iterator r102 = r100.iterator();
    L279:
        if (r102.hasNext() == false) goto L283;
        String r103 = (String) r102.next();
        if (ArraysKt.contains(b, r103) == true) goto L279;
        r101.appendQueryParameter(r103, UriProtector.getQueryParameter(r96, r103));
        goto L279
    L283:
        r101.appendQueryParameter(r14, r95.toString());
        return b(r101.toString(), r22, r13, r24);
    L12:
        r15 = "mega_object_id";
        r14 = "mega_object";
        goto L14
    L9:
        r13 = r23;
        goto L10
    L5:
        r11 = false;
        goto L7
    }
}
