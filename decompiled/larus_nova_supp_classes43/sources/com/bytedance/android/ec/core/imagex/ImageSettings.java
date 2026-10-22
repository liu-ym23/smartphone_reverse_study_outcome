package com.bytedance.android.ec.core.imagex;

import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.hybrid.hostapi.IECHybridKevaService;
import com.bytedance.services.apm.api.EnsureManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ImageSettings {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;
    public static final Lazy e = null;
    public static final Lazy f = null;
    public static final Lazy g = null;
    public static final Lazy h = null;
    public static final Lazy i = null;
    public static final Lazy j = null;
    public static final Lazy k = null;
    public static final Lazy l = null;
    public static final Lazy m = null;
    public static final Lazy n = null;
    public static final Lazy o = null;
    public static final Lazy p = null;
    public static final Lazy q = null;
    public static final Lazy r = null;
    public static final Lazy s = null;

    public static HashMap c() {
        return (HashMap) k.getValue();
    }

    public static boolean d() {
        return ((Boolean) j.getValue()).booleanValue();
    }

    static {
        a = LazyKt.lazy(ImageSettings$optEnable$2.INSTANCE);
        b = LazyKt.lazy(ImageSettings$requestedUrlCacheSize$2.INSTANCE);
        c = LazyKt.lazy(ImageSettings$urlTransformCacheEnable$2.INSTANCE);
        d = LazyKt.lazy(ImageSettings$urlTransformCacheSize$2.INSTANCE);
        e = LazyKt.lazy(ImageSettings$urlTransformAsyncEnable$2.INSTANCE);
        f = LazyKt.lazy(ImageSettings$urlTransformRecordOpt$2.INSTANCE);
        g = LazyKt.lazy(ImageSettings$urlTransformAppendQueryEnable$2.INSTANCE);
        h = LazyKt.lazy(ImageSettings$storeLynxOptEnable$2.INSTANCE);
        i = LazyKt.lazy(ImageSettings$preferredSizeOffset$2.INSTANCE);
        j = LazyKt.lazy(ImageSettings$monitorCopyExtraToCategoryEnable$2.INSTANCE);
        k = LazyKt.lazy(ImageSettings$largeImageWhiteList$2.INSTANCE);
        l = LazyKt.lazy(ImageSettings$largeImageMemoryLimit$2.INSTANCE);
        m = LazyKt.lazy(ImageSettings$maxCapacityOfBackgroundTimeRange$2.INSTANCE);
        n = LazyKt.lazy(ImageSettings$hitCacheMonitorSampleRate$2.INSTANCE);
        o = LazyKt.lazy(ImageSettings$fetchToDiskStrategy$2.INSTANCE);
        p = LazyKt.lazy(ImageSettings$enableDefaultRotationOptions$2.INSTANCE);
        q = LazyKt.lazy(ImageSettings$modifyHttpToHttps$2.INSTANCE);
        r = LazyKt.lazy(ImageSettings$ecForceRgb565BizTag$2.INSTANCE);
        s = LazyKt.lazy(ImageSettings$ecForceRgb565SceneTag$2.INSTANCE);
    }

    public static final HashMap<String, Object> a() {
        int r0 = com.bytedance.android.ec.core.abtest.j.a;
        HashMap r1 = new HashMap();
        r1.put("ec_image_requested_url_cache_size", 4096);
        Boolean r10 = Boolean.TRUE;
        r1.put("ec_image_url_transform_cache_enable", r10);
        r1.put("ec_image_url_transform_cache_size", 4096);
        r1.put("ec_image_url_transform_async_enable", Boolean.FALSE);
        r1.put("ec_store_lynx_image_opt_enable", r10);
        r1.put("ec_image_preferred_size_offset", 30);
        int r11 = com.bytedance.android.ec.base.settings.b.a;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r13 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L172
        Object r14 = null;
        r13.getClass();     // Catch: Throwable -> L59
        Object r15 = SDKSettingsCacheManager.b.get("ec_image_opt_configs");     // Catch: Throwable -> L59
        if (r15 != null) goto L11;
    L56:
        Object r16 = null;
    L57:
        Object r17 = Result.constructor-impl(r16);     // Catch: Throwable -> L59
    L61:
        Throwable r18 = Result.exceptionOrNull-impl(r17);     // Catch: Throwable -> L172
        if (r18 == null) goto L65;
        EnsureManager.ensureNotReachHere(r18);     // Catch: Throwable -> L172
    L65:
        if (Result.isFailure-impl(r17) == false) goto L68;
        r17 = null;
    L68:
        if ((r17 instanceof HashMap) == true) goto L70;
        r17 = null;
    L70:
        HashMap r19 = (HashMap) r17;     // Catch: Throwable -> L172
        if (r19 == null) goto L73;
        HashMap r20 = r19;
    L77:
        if (r20 == null) goto L79;
        Object r21 = r20;
    L182:
        return (HashMap) r21;
    L79:
        int r22 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L172
    L159:
        th = move-exception;
        Result.Companion r23 = Result.Companion;     // Catch: Throwable -> L172
        Object r24 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L172
    L162:
        if (Result.exceptionOrNull-impl(r24) != null) goto L185;
    L169:
        Object r25 = r24;
    L170:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L172
        SDKSettingsCacheManager.e("ec_image_opt_configs", r25);     // Catch: Throwable -> L172
        r21 = r25;
        goto L182
    L185:
        r24 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_image_opt_configs", HashMap.class, r1);     // Catch: Throwable -> L166
    L167:
        if (r24 != null) goto L169;
        r25 = r1;
    L166:
        r24 = r1;
        goto L167
    L191:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L133
        Object r26 = SDKSettingsCacheManager.b.get("ec_image_opt_configs");     // Catch: Throwable -> L133
        if (r26 != null) goto L85;
    L130:
        Object r27 = null;
    L131:
        Object r28 = Result.constructor-impl(r27);     // Catch: Throwable -> L133
    L135:
        Throwable r29 = Result.exceptionOrNull-impl(r28);     // Catch: Throwable -> L159
        if (r29 == null) goto L139;
        EnsureManager.ensureNotReachHere(r29);     // Catch: Throwable -> L159
    L139:
        if (Result.isFailure-impl(r28) == false) goto L142;
        r28 = null;
    L142:
        if ((r28 instanceof HashMap) == true) goto L144;
        r28 = null;
    L144:
        r24 = (HashMap) r28;     // Catch: Throwable -> L159
        if (r24 != null) goto L169;
        jj4.b r30 = jj4.b.b;     // Catch: Throwable -> L159
        Object r31 = jj4.a.a("ec_image_opt_configs", HashMap.class, r1, false);     // Catch: Throwable -> L159
        if (r31 != null) goto L151;
        Intrinsics.throwNpe();     // Catch: Throwable -> L159
    L151:
        if ((r31 instanceof HashMap) == false) goto L154;
        r14 = r31;
    L154:
        HashMap r32 = (HashMap) r14;     // Catch: Throwable -> L159
        HashMap r33 = r32;
        if (r32 != null) goto L157;
        r33 = r1;
    L157:
        r24 = Result.constructor-impl(r33);     // Catch: Throwable -> L159
    L85:
        if ((r26 instanceof HashMap) == true) goto L87;
        Object r34 = null;
    L88:
        r27 = (HashMap) r34;     // Catch: Throwable -> L133
        if (r27 != null) goto L131;
        if ((r26 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(HashMap.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r35 = Float.valueOf(((Number) r26).floatValue());     // Catch: Throwable -> L133
        if ((r35 instanceof HashMap) == true) goto L98;
        r35 = null;
    L98:
        r27 = (HashMap) r35;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(HashMap.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r36 = Double.valueOf(((Number) r26).doubleValue());     // Catch: Throwable -> L133
        if ((r36 instanceof HashMap) == true) goto L104;
        r36 = null;
    L104:
        r27 = (HashMap) r36;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(HashMap.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r37 = Integer.valueOf(((Number) r26).intValue());     // Catch: Throwable -> L133
        if ((r37 instanceof HashMap) == true) goto L110;
        r37 = null;
    L110:
        r27 = (HashMap) r37;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(HashMap.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r38 = Long.valueOf(((Number) r26).longValue());     // Catch: Throwable -> L133
        if ((r38 instanceof HashMap) == true) goto L116;
        r38 = null;
    L116:
        r27 = (HashMap) r38;     // Catch: Throwable -> L133
    L118:
        if ((r26 instanceof JSONObject) == false) goto L120;
    L183:
        Object r39 = SDKSettingsCacheManager.a().fromJson(r26.toString(), HashMap.class);     // Catch: Throwable -> L126
        if ((r39 instanceof HashMap) == true) goto L124;
        r39 = null;
    L124:
        Object r40 = Result.constructor-impl((HashMap) r39);     // Catch: Throwable -> L126
    L128:
        r27 = r40;
        if (Result.isFailure-impl(r27) == false) goto L131;
    L126:
        th = move-exception;
        Result.Companion r41 = Result.Companion;     // Catch: Throwable -> L133
        r40 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L133
        goto L128
    L120:
        if ((r26 instanceof JSONArray) == false) goto L130;
    L87:
        r34 = r26;
    L133:
        th = move-exception;
        Result.Companion r42 = Result.Companion;     // Catch: Throwable -> L159
        r28 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L159
        goto L135
    L73:
        r13.getClass();     // Catch: Throwable -> L172
        Object r43 = SDKSettingsCacheManager.a.get("ec_image_opt_configs");     // Catch: Throwable -> L172
        if ((r43 instanceof HashMap) == true) goto L76;
        r43 = null;
    L76:
        r20 = (HashMap) r43;     // Catch: Throwable -> L172
        goto L77
    L11:
        if ((r15 instanceof HashMap) == true) goto L13;
        Object r44 = null;
    L14:
        r16 = (HashMap) r44;     // Catch: Throwable -> L59
        if (r16 != null) goto L57;
        if ((r15 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(HashMap.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r45 = Float.valueOf(((Number) r15).floatValue());     // Catch: Throwable -> L59
        if ((r45 instanceof HashMap) == true) goto L24;
        r45 = null;
    L24:
        r16 = (HashMap) r45;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(HashMap.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r46 = Double.valueOf(((Number) r15).doubleValue());     // Catch: Throwable -> L59
        if ((r46 instanceof HashMap) == true) goto L30;
        r46 = null;
    L30:
        r16 = (HashMap) r46;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(HashMap.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r47 = Integer.valueOf(((Number) r15).intValue());     // Catch: Throwable -> L59
        if ((r47 instanceof HashMap) == true) goto L36;
        r47 = null;
    L36:
        r16 = (HashMap) r47;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(HashMap.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r48 = Long.valueOf(((Number) r15).longValue());     // Catch: Throwable -> L59
        if ((r48 instanceof HashMap) == true) goto L42;
        r48 = null;
    L42:
        r16 = (HashMap) r48;     // Catch: Throwable -> L59
    L44:
        if ((r15 instanceof JSONObject) == false) goto L46;
    L189:
        Object r49 = SDKSettingsCacheManager.a().fromJson(r15.toString(), HashMap.class);     // Catch: Throwable -> L52
        if ((r49 instanceof HashMap) == true) goto L50;
        r49 = null;
    L50:
        Object r50 = Result.constructor-impl((HashMap) r49);     // Catch: Throwable -> L52
    L54:
        r16 = r50;
        if (Result.isFailure-impl(r16) == false) goto L57;
    L52:
        th = move-exception;
        Result.Companion r51 = Result.Companion;     // Catch: Throwable -> L59
        r50 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L59
        goto L54
    L46:
        if ((r15 instanceof JSONArray) == false) goto L56;
    L13:
        r44 = r15;
    L59:
        th = move-exception;
        Result.Companion r52 = Result.Companion;     // Catch: Throwable -> L172
        r17 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L172
    L172:
        th = move-exception;
        Result.Companion r53 = Result.Companion;
        Object r54 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r55 = Result.exceptionOrNull-impl(r54);
        if (r55 == null) goto L176;
        EnsureManager.ensureNotReachHere(r55);
    L176:
        Object r56 = r1;
        if (Result.isFailure-impl(r54) == true) goto L180;
        r56 = r54;
    L180:
        r21 = r56;
        goto L182
    }

    public static final boolean b() {
        int r0 = com.bytedance.android.ec.core.abtest.j.a;
        Object r1 = Boolean.TRUE;
        int r10 = com.bytedance.android.ec.base.settings.b.a;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r12 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L172
        Object r13 = null;
        r12.getClass();     // Catch: Throwable -> L59
        Object r14 = SDKSettingsCacheManager.b.get("ec_image_opt_enable");     // Catch: Throwable -> L59
        if (r14 != null) goto L11;
    L56:
        Object r15 = null;
    L57:
        Object r16 = Result.constructor-impl(r15);     // Catch: Throwable -> L59
    L61:
        Throwable r17 = Result.exceptionOrNull-impl(r16);     // Catch: Throwable -> L172
        if (r17 == null) goto L65;
        EnsureManager.ensureNotReachHere(r17);     // Catch: Throwable -> L172
    L65:
        if (Result.isFailure-impl(r16) == false) goto L68;
        r16 = null;
    L68:
        if ((r16 instanceof Boolean) == true) goto L70;
        r16 = null;
    L70:
        Object r18 = (Boolean) r16;     // Catch: Throwable -> L172
        if (r18 != null) goto L77;
        r12.getClass();     // Catch: Throwable -> L172
        Object r19 = SDKSettingsCacheManager.a.get("ec_image_opt_enable");     // Catch: Throwable -> L172
        if ((r19 instanceof Boolean) == true) goto L76;
        r19 = null;
    L76:
        r18 = (Boolean) r19;     // Catch: Throwable -> L172
    L77:
        if (r18 != null) goto L182;
        int r20 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L172
    L159:
        th = move-exception;
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L172
        Object r22 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L172
    L162:
        if (Result.exceptionOrNull-impl(r22) != null) goto L185;
    L169:
        r18 = r22;
    L170:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L172
        SDKSettingsCacheManager.e("ec_image_opt_enable", r18);     // Catch: Throwable -> L172
        goto L182
    L185:
        r22 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_image_opt_enable", Boolean.class, r1);     // Catch: Throwable -> L166
    L167:
        if (r22 != null) goto L169;
        r18 = r1;
    L166:
        r22 = r1;
        goto L167
    L191:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L133
        Object r23 = SDKSettingsCacheManager.b.get("ec_image_opt_enable");     // Catch: Throwable -> L133
        if (r23 != null) goto L85;
    L130:
        Object r24 = null;
    L131:
        Object r25 = Result.constructor-impl(r24);     // Catch: Throwable -> L133
    L135:
        Throwable r26 = Result.exceptionOrNull-impl(r25);     // Catch: Throwable -> L159
        if (r26 == null) goto L139;
        EnsureManager.ensureNotReachHere(r26);     // Catch: Throwable -> L159
    L139:
        if (Result.isFailure-impl(r25) == false) goto L142;
        r25 = null;
    L142:
        if ((r25 instanceof Boolean) == true) goto L144;
        r25 = null;
    L144:
        r22 = (Boolean) r25;     // Catch: Throwable -> L159
        if (r22 != null) goto L169;
        jj4.b r27 = jj4.b.b;     // Catch: Throwable -> L159
        Object r28 = jj4.a.a("ec_image_opt_enable", Boolean.class, r1, false);     // Catch: Throwable -> L159
        if (r28 != null) goto L151;
        Intrinsics.throwNpe();     // Catch: Throwable -> L159
    L151:
        if ((r28 instanceof Boolean) == false) goto L154;
        r13 = r28;
    L154:
        Object r29 = (Boolean) r13;     // Catch: Throwable -> L159
        if (r29 != null) goto L157;
        r29 = r1;
    L157:
        r22 = Result.constructor-impl(r29);     // Catch: Throwable -> L159
    L85:
        if ((r23 instanceof Boolean) == true) goto L87;
        Object r30 = null;
    L88:
        r24 = (Boolean) r30;     // Catch: Throwable -> L133
        if (r24 != null) goto L131;
        if ((r23 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r31 = Float.valueOf(((Number) r23).floatValue());     // Catch: Throwable -> L133
        if ((r31 instanceof Boolean) == true) goto L98;
        r31 = null;
    L98:
        r24 = (Boolean) r31;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r32 = Double.valueOf(((Number) r23).doubleValue());     // Catch: Throwable -> L133
        if ((r32 instanceof Boolean) == true) goto L104;
        r32 = null;
    L104:
        r24 = (Boolean) r32;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r33 = Integer.valueOf(((Number) r23).intValue());     // Catch: Throwable -> L133
        if ((r33 instanceof Boolean) == true) goto L110;
        r33 = null;
    L110:
        r24 = (Boolean) r33;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r34 = Long.valueOf(((Number) r23).longValue());     // Catch: Throwable -> L133
        if ((r34 instanceof Boolean) == true) goto L116;
        r34 = null;
    L116:
        r24 = (Boolean) r34;     // Catch: Throwable -> L133
    L118:
        if ((r23 instanceof JSONObject) == false) goto L120;
    L183:
        Object r35 = SDKSettingsCacheManager.a().fromJson(r23.toString(), Boolean.class);     // Catch: Throwable -> L126
        if ((r35 instanceof Boolean) == true) goto L124;
        r35 = null;
    L124:
        Object r36 = Result.constructor-impl((Boolean) r35);     // Catch: Throwable -> L126
    L128:
        r24 = r36;
        if (Result.isFailure-impl(r24) == false) goto L131;
    L126:
        th = move-exception;
        Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L133
        r36 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L133
        goto L128
    L120:
        if ((r23 instanceof JSONArray) == false) goto L130;
    L87:
        r30 = r23;
    L133:
        th = move-exception;
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L159
        r25 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L159
    L182:
        return ((Boolean) r18).booleanValue();
    L11:
        if ((r14 instanceof Boolean) == true) goto L13;
        Object r39 = null;
    L14:
        r15 = (Boolean) r39;     // Catch: Throwable -> L59
        if (r15 != null) goto L57;
        if ((r14 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r40 = Float.valueOf(((Number) r14).floatValue());     // Catch: Throwable -> L59
        if ((r40 instanceof Boolean) == true) goto L24;
        r40 = null;
    L24:
        r15 = (Boolean) r40;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r41 = Double.valueOf(((Number) r14).doubleValue());     // Catch: Throwable -> L59
        if ((r41 instanceof Boolean) == true) goto L30;
        r41 = null;
    L30:
        r15 = (Boolean) r41;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r42 = Integer.valueOf(((Number) r14).intValue());     // Catch: Throwable -> L59
        if ((r42 instanceof Boolean) == true) goto L36;
        r42 = null;
    L36:
        r15 = (Boolean) r42;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r43 = Long.valueOf(((Number) r14).longValue());     // Catch: Throwable -> L59
        if ((r43 instanceof Boolean) == true) goto L42;
        r43 = null;
    L42:
        r15 = (Boolean) r43;     // Catch: Throwable -> L59
    L44:
        if ((r14 instanceof JSONObject) == false) goto L46;
    L189:
        Object r44 = SDKSettingsCacheManager.a().fromJson(r14.toString(), Boolean.class);     // Catch: Throwable -> L52
        if ((r44 instanceof Boolean) == true) goto L50;
        r44 = null;
    L50:
        Object r45 = Result.constructor-impl((Boolean) r44);     // Catch: Throwable -> L52
    L54:
        r15 = r45;
        if (Result.isFailure-impl(r15) == false) goto L57;
    L52:
        th = move-exception;
        Result.Companion r46 = Result.Companion;     // Catch: Throwable -> L59
        r45 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L59
        goto L54
    L46:
        if ((r14 instanceof JSONArray) == false) goto L56;
    L13:
        r39 = r14;
    L59:
        th = move-exception;
        Result.Companion r47 = Result.Companion;     // Catch: Throwable -> L172
        r16 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L172
    L172:
        th = move-exception;
        Result.Companion r48 = Result.Companion;
        Object r49 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r50 = Result.exceptionOrNull-impl(r49);
        if (r50 == null) goto L177;
        EnsureManager.ensureNotReachHere(r50);
    L177:
        if (Result.isFailure-impl(r49) == true) goto L180;
        r1 = r49;
    L180:
        r18 = r1;
        goto L182
    }
}
