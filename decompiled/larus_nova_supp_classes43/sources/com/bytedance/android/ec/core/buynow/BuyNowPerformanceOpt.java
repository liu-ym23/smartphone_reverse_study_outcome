package com.bytedance.android.ec.core.buynow;

import android.content.Context;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.base.settings.g;
import com.bytedance.android.ec.base.settings.h;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.abtest.j;
import com.bytedance.android.ec.core.utils.t0;
import com.bytedance.android.ec.hybrid.hostapi.IECHybridKevaService;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ecom.slice.ext.template.gecko.SlcGeckoTemplateMgr;
import com.bytedance.services.apm.api.EnsureManager;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class BuyNowPerformanceOpt {
    public static Boolean a;
    public static final Lazy b = null;

    public static final class a {
        public final String a;
        public final String b;

        public a(String r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, "sceneName");
            Intrinsics.checkNotNullParameter(r11, "fallbackSceneName");
            this.a = r10;
            this.b = r11;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\u0005\u0018\u00002\u00020\u0001R<\u0010\u0005\u001a$\u0012\u0004\u0012\u00020\u0003\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00020\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/ec/core/buynow/BuyNowPerformanceOpt$b;", "", "", "", "", "map", "Ljava/util/Map;", "a", "()Ljava/util/Map;", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("map")
        @JsonAdapter(FieldsAdapter.class)
        private final Map<String, List<Map<String, Object>>> map;

        public final Map<String, List<Map<String, Object>>> a() {
            return this.map;
        }
    }

    public static Map g() {
        return (Map) b.getValue();
    }

    static {
        b = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, BuyNowPerformanceOpt$performanceAB$2.INSTANCE);
    }

    public static boolean a() {
        Lazy r0 = ECAppInfoService.a;
        Object r10 = null;
        if (ECAppInfoService.h() == false) goto L8;
        Map r1 = g();
        if (r1 == null) goto L197;
        r10 = r1.get("iesec_enable_cache_detail_url");
    L197:
        return Intrinsics.areEqual(r10, 1);
    L8:
        com.bytedance.android.ec.core.abtest.d r11 = com.bytedance.android.ec.core.abtest.d.a;
        int r12 = j.a;
        Object r13 = 0;
        int r14 = com.bytedance.android.ec.base.settings.b.a;
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L169
        h.a();     // Catch: Throwable -> L169
        SDKSettingsCacheManager r16 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L169
        r16.getClass();     // Catch: Throwable -> L59
        Object r17 = SDKSettingsCacheManager.b.get("iesec_enable_cache_detail_url");     // Catch: Throwable -> L59
        if (r17 != null) goto L14;
    L56:
        Object r18 = null;
    L57:
        Object r19 = Result.constructor-impl(r18);     // Catch: Throwable -> L59
    L61:
        Throwable r20 = Result.exceptionOrNull-impl(r19);     // Catch: Throwable -> L169
        if (r20 == null) goto L65;
        EnsureManager.ensureNotReachHere(r20);     // Catch: Throwable -> L169
    L65:
        if (Result.isFailure-impl(r19) == false) goto L68;
        r19 = null;
    L68:
        if ((r19 instanceof Integer) == true) goto L70;
        r19 = null;
    L70:
        Object r21 = (Integer) r19;     // Catch: Throwable -> L169
        if (r21 != null) goto L77;
        r16.getClass();     // Catch: Throwable -> L169
        Object r22 = SDKSettingsCacheManager.a.get("iesec_enable_cache_detail_url");     // Catch: Throwable -> L169
        if ((r22 instanceof Integer) == true) goto L76;
        r22 = null;
    L76:
        r21 = (Integer) r22;     // Catch: Throwable -> L169
    L77:
        if (r21 != null) goto L179;
        int r23 = g.a;     // Catch: Throwable -> L169
    L156:
        th = move-exception;
        Result.Companion r24 = Result.Companion;     // Catch: Throwable -> L169
        Object r25 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L169
    L159:
        if (Result.exceptionOrNull-impl(r25) != null) goto L187;
    L166:
        r21 = r25;
    L167:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L169
        SDKSettingsCacheManager.e("iesec_enable_cache_detail_url", r21);     // Catch: Throwable -> L169
        goto L179
    L187:
        r25 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_enable_cache_detail_url", Integer.class, r13);     // Catch: Throwable -> L163
    L164:
        if (r25 != null) goto L166;
        r21 = r13;
    L163:
        r25 = r13;
        goto L164
    L193:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L130
        Object r26 = SDKSettingsCacheManager.b.get("iesec_enable_cache_detail_url");     // Catch: Throwable -> L130
        if (r26 != null) goto L85;
    L127:
        Object r27 = null;
    L128:
        Object r28 = Result.constructor-impl(r27);     // Catch: Throwable -> L130
    L132:
        Throwable r29 = Result.exceptionOrNull-impl(r28);     // Catch: Throwable -> L156
        if (r29 == null) goto L136;
        EnsureManager.ensureNotReachHere(r29);     // Catch: Throwable -> L156
    L136:
        if (Result.isFailure-impl(r28) == false) goto L139;
        r28 = null;
    L139:
        if ((r28 instanceof Integer) == true) goto L141;
        r28 = null;
    L141:
        Integer r30 = (Integer) r28;     // Catch: Throwable -> L156
        if (r30 == null) goto L144;
        r21 = r30;
        goto L167
    L144:
        jj4.b r31 = jj4.b.b;     // Catch: Throwable -> L156
        Object r32 = jj4.a.a("iesec_enable_cache_detail_url", Integer.class, r13, false);     // Catch: Throwable -> L156
        if (r32 != null) goto L148;
        Intrinsics.throwNpe();     // Catch: Throwable -> L156
    L148:
        if ((r32 instanceof Integer) == false) goto L151;
        r10 = r32;
    L151:
        Object r33 = (Integer) r10;     // Catch: Throwable -> L156
        if (r33 != null) goto L154;
        r33 = r13;
    L154:
        r25 = Result.constructor-impl(r33);     // Catch: Throwable -> L156
    L85:
        if ((r26 instanceof Integer) == true) goto L87;
        Object r34 = null;
    L88:
        r27 = (Integer) r34;     // Catch: Throwable -> L130
        if (r27 != null) goto L128;
        if ((r26 instanceof Number) == false) goto L115;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r35 = Float.valueOf(((Number) r26).floatValue());     // Catch: Throwable -> L130
        if ((r35 instanceof Integer) == true) goto L98;
        r35 = null;
    L98:
        r27 = (Integer) r35;     // Catch: Throwable -> L130
        goto L128
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r36 = Double.valueOf(((Number) r26).doubleValue());     // Catch: Throwable -> L130
        if ((r36 instanceof Integer) == true) goto L104;
        r36 = null;
    L104:
        r27 = (Integer) r36;     // Catch: Throwable -> L130
        goto L128
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L109;
        r27 = Integer.valueOf(((Number) r26).intValue());     // Catch: Throwable -> L130
        goto L128
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L115;
        Long r37 = Long.valueOf(((Number) r26).longValue());     // Catch: Throwable -> L130
        if ((r37 instanceof Integer) == true) goto L113;
        r37 = null;
    L113:
        r27 = (Integer) r37;     // Catch: Throwable -> L130
    L115:
        if ((r26 instanceof JSONObject) == false) goto L117;
    L185:
        Object r38 = SDKSettingsCacheManager.a().fromJson(r26.toString(), Integer.class);     // Catch: Throwable -> L123
        if ((r38 instanceof Integer) == true) goto L121;
        r38 = null;
    L121:
        Object r39 = Result.constructor-impl((Integer) r38);     // Catch: Throwable -> L123
    L125:
        r27 = r39;
        if (Result.isFailure-impl(r27) == false) goto L128;
    L123:
        th = move-exception;
        Result.Companion r40 = Result.Companion;     // Catch: Throwable -> L130
        r39 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L130
        goto L125
    L117:
        if ((r26 instanceof JSONArray) == false) goto L127;
    L87:
        r34 = r26;
    L130:
        th = move-exception;
        Result.Companion r41 = Result.Companion;     // Catch: Throwable -> L156
        r28 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L156
    L179:
        if (((Number) r21).intValue() == 1) goto L198;
        return false;
    L198:
        return true;
    L14:
        if ((r17 instanceof Integer) == true) goto L16;
        Object r42 = null;
    L17:
        r18 = (Integer) r42;     // Catch: Throwable -> L59
        if (r18 != null) goto L57;
        if ((r17 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L29;
        Float r43 = Float.valueOf(((Number) r17).floatValue());     // Catch: Throwable -> L59
        if ((r43 instanceof Integer) == true) goto L27;
        r43 = null;
    L27:
        r18 = (Integer) r43;     // Catch: Throwable -> L59
        goto L57
    L29:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L35;
        Double r44 = Double.valueOf(((Number) r17).doubleValue());     // Catch: Throwable -> L59
        if ((r44 instanceof Integer) == true) goto L33;
        r44 = null;
    L33:
        r18 = (Integer) r44;     // Catch: Throwable -> L59
        goto L57
    L35:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        r18 = Integer.valueOf(((Number) r17).intValue());     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r45 = Long.valueOf(((Number) r17).longValue());     // Catch: Throwable -> L59
        if ((r45 instanceof Integer) == true) goto L42;
        r45 = null;
    L42:
        r18 = (Integer) r45;     // Catch: Throwable -> L59
    L44:
        if ((r17 instanceof JSONObject) == false) goto L46;
    L183:
        Object r46 = SDKSettingsCacheManager.a().fromJson(r17.toString(), Integer.class);     // Catch: Throwable -> L52
        if ((r46 instanceof Integer) == true) goto L50;
        r46 = null;
    L50:
        Object r47 = Result.constructor-impl((Integer) r46);     // Catch: Throwable -> L52
    L54:
        r18 = r47;
        if (Result.isFailure-impl(r18) == false) goto L57;
    L52:
        th = move-exception;
        Result.Companion r48 = Result.Companion;     // Catch: Throwable -> L59
        r47 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L59
        goto L54
    L46:
        if ((r17 instanceof JSONArray) == false) goto L56;
    L16:
        r42 = r17;
    L59:
        th = move-exception;
        Result.Companion r49 = Result.Companion;     // Catch: Throwable -> L169
        r19 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L169
    L169:
        th = move-exception;
        Result.Companion r50 = Result.Companion;
        Object r51 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r52 = Result.exceptionOrNull-impl(r51);
        if (r52 == null) goto L174;
        EnsureManager.ensureNotReachHere(r52);
    L174:
        if (Result.isFailure-impl(r51) == true) goto L177;
        r13 = r51;
    L177:
        r21 = r13;
        goto L179
    }

    public static boolean b() {
        Lazy r0 = ECAppInfoService.a;
        Object r10 = null;
        if (ECAppInfoService.h() == false) goto L8;
        Map r1 = g();
        if (r1 == null) goto L197;
        r10 = r1.get("iesec_enable_cache_recommend_info");
    L197:
        return Intrinsics.areEqual(r10, 1);
    L8:
        com.bytedance.android.ec.core.abtest.d r11 = com.bytedance.android.ec.core.abtest.d.a;
        int r12 = j.a;
        Object r13 = 0;
        int r14 = com.bytedance.android.ec.base.settings.b.a;
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L169
        h.a();     // Catch: Throwable -> L169
        SDKSettingsCacheManager r16 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L169
        r16.getClass();     // Catch: Throwable -> L59
        Object r17 = SDKSettingsCacheManager.b.get("iesec_enable_cache_recommend_info");     // Catch: Throwable -> L59
        if (r17 != null) goto L14;
    L56:
        Object r18 = null;
    L57:
        Object r19 = Result.constructor-impl(r18);     // Catch: Throwable -> L59
    L61:
        Throwable r20 = Result.exceptionOrNull-impl(r19);     // Catch: Throwable -> L169
        if (r20 == null) goto L65;
        EnsureManager.ensureNotReachHere(r20);     // Catch: Throwable -> L169
    L65:
        if (Result.isFailure-impl(r19) == false) goto L68;
        r19 = null;
    L68:
        if ((r19 instanceof Integer) == true) goto L70;
        r19 = null;
    L70:
        Object r21 = (Integer) r19;     // Catch: Throwable -> L169
        if (r21 != null) goto L77;
        r16.getClass();     // Catch: Throwable -> L169
        Object r22 = SDKSettingsCacheManager.a.get("iesec_enable_cache_recommend_info");     // Catch: Throwable -> L169
        if ((r22 instanceof Integer) == true) goto L76;
        r22 = null;
    L76:
        r21 = (Integer) r22;     // Catch: Throwable -> L169
    L77:
        if (r21 != null) goto L179;
        int r23 = g.a;     // Catch: Throwable -> L169
    L156:
        th = move-exception;
        Result.Companion r24 = Result.Companion;     // Catch: Throwable -> L169
        Object r25 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L169
    L159:
        if (Result.exceptionOrNull-impl(r25) != null) goto L187;
    L166:
        r21 = r25;
    L167:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L169
        SDKSettingsCacheManager.e("iesec_enable_cache_recommend_info", r21);     // Catch: Throwable -> L169
        goto L179
    L187:
        r25 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_enable_cache_recommend_info", Integer.class, r13);     // Catch: Throwable -> L163
    L164:
        if (r25 != null) goto L166;
        r21 = r13;
    L163:
        r25 = r13;
        goto L164
    L193:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L130
        Object r26 = SDKSettingsCacheManager.b.get("iesec_enable_cache_recommend_info");     // Catch: Throwable -> L130
        if (r26 != null) goto L85;
    L127:
        Object r27 = null;
    L128:
        Object r28 = Result.constructor-impl(r27);     // Catch: Throwable -> L130
    L132:
        Throwable r29 = Result.exceptionOrNull-impl(r28);     // Catch: Throwable -> L156
        if (r29 == null) goto L136;
        EnsureManager.ensureNotReachHere(r29);     // Catch: Throwable -> L156
    L136:
        if (Result.isFailure-impl(r28) == false) goto L139;
        r28 = null;
    L139:
        if ((r28 instanceof Integer) == true) goto L141;
        r28 = null;
    L141:
        Integer r30 = (Integer) r28;     // Catch: Throwable -> L156
        if (r30 == null) goto L144;
        r21 = r30;
        goto L167
    L144:
        jj4.b r31 = jj4.b.b;     // Catch: Throwable -> L156
        Object r32 = jj4.a.a("iesec_enable_cache_recommend_info", Integer.class, r13, false);     // Catch: Throwable -> L156
        if (r32 != null) goto L148;
        Intrinsics.throwNpe();     // Catch: Throwable -> L156
    L148:
        if ((r32 instanceof Integer) == false) goto L151;
        r10 = r32;
    L151:
        Object r33 = (Integer) r10;     // Catch: Throwable -> L156
        if (r33 != null) goto L154;
        r33 = r13;
    L154:
        r25 = Result.constructor-impl(r33);     // Catch: Throwable -> L156
    L85:
        if ((r26 instanceof Integer) == true) goto L87;
        Object r34 = null;
    L88:
        r27 = (Integer) r34;     // Catch: Throwable -> L130
        if (r27 != null) goto L128;
        if ((r26 instanceof Number) == false) goto L115;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r35 = Float.valueOf(((Number) r26).floatValue());     // Catch: Throwable -> L130
        if ((r35 instanceof Integer) == true) goto L98;
        r35 = null;
    L98:
        r27 = (Integer) r35;     // Catch: Throwable -> L130
        goto L128
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r36 = Double.valueOf(((Number) r26).doubleValue());     // Catch: Throwable -> L130
        if ((r36 instanceof Integer) == true) goto L104;
        r36 = null;
    L104:
        r27 = (Integer) r36;     // Catch: Throwable -> L130
        goto L128
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L109;
        r27 = Integer.valueOf(((Number) r26).intValue());     // Catch: Throwable -> L130
        goto L128
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L115;
        Long r37 = Long.valueOf(((Number) r26).longValue());     // Catch: Throwable -> L130
        if ((r37 instanceof Integer) == true) goto L113;
        r37 = null;
    L113:
        r27 = (Integer) r37;     // Catch: Throwable -> L130
    L115:
        if ((r26 instanceof JSONObject) == false) goto L117;
    L185:
        Object r38 = SDKSettingsCacheManager.a().fromJson(r26.toString(), Integer.class);     // Catch: Throwable -> L123
        if ((r38 instanceof Integer) == true) goto L121;
        r38 = null;
    L121:
        Object r39 = Result.constructor-impl((Integer) r38);     // Catch: Throwable -> L123
    L125:
        r27 = r39;
        if (Result.isFailure-impl(r27) == false) goto L128;
    L123:
        th = move-exception;
        Result.Companion r40 = Result.Companion;     // Catch: Throwable -> L130
        r39 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L130
        goto L125
    L117:
        if ((r26 instanceof JSONArray) == false) goto L127;
    L87:
        r34 = r26;
    L130:
        th = move-exception;
        Result.Companion r41 = Result.Companion;     // Catch: Throwable -> L156
        r28 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L156
    L179:
        if (((Number) r21).intValue() == 1) goto L198;
        return false;
    L198:
        return true;
    L14:
        if ((r17 instanceof Integer) == true) goto L16;
        Object r42 = null;
    L17:
        r18 = (Integer) r42;     // Catch: Throwable -> L59
        if (r18 != null) goto L57;
        if ((r17 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L29;
        Float r43 = Float.valueOf(((Number) r17).floatValue());     // Catch: Throwable -> L59
        if ((r43 instanceof Integer) == true) goto L27;
        r43 = null;
    L27:
        r18 = (Integer) r43;     // Catch: Throwable -> L59
        goto L57
    L29:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L35;
        Double r44 = Double.valueOf(((Number) r17).doubleValue());     // Catch: Throwable -> L59
        if ((r44 instanceof Integer) == true) goto L33;
        r44 = null;
    L33:
        r18 = (Integer) r44;     // Catch: Throwable -> L59
        goto L57
    L35:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        r18 = Integer.valueOf(((Number) r17).intValue());     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r45 = Long.valueOf(((Number) r17).longValue());     // Catch: Throwable -> L59
        if ((r45 instanceof Integer) == true) goto L42;
        r45 = null;
    L42:
        r18 = (Integer) r45;     // Catch: Throwable -> L59
    L44:
        if ((r17 instanceof JSONObject) == false) goto L46;
    L183:
        Object r46 = SDKSettingsCacheManager.a().fromJson(r17.toString(), Integer.class);     // Catch: Throwable -> L52
        if ((r46 instanceof Integer) == true) goto L50;
        r46 = null;
    L50:
        Object r47 = Result.constructor-impl((Integer) r46);     // Catch: Throwable -> L52
    L54:
        r18 = r47;
        if (Result.isFailure-impl(r18) == false) goto L57;
    L52:
        th = move-exception;
        Result.Companion r48 = Result.Companion;     // Catch: Throwable -> L59
        r47 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L59
        goto L54
    L46:
        if ((r17 instanceof JSONArray) == false) goto L56;
    L16:
        r42 = r17;
    L59:
        th = move-exception;
        Result.Companion r49 = Result.Companion;     // Catch: Throwable -> L169
        r19 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L169
    L169:
        th = move-exception;
        Result.Companion r50 = Result.Companion;
        Object r51 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r52 = Result.exceptionOrNull-impl(r51);
        if (r52 == null) goto L174;
        EnsureManager.ensureNotReachHere(r52);
    L174:
        if (Result.isFailure-impl(r51) == true) goto L177;
        r13 = r51;
    L177:
        r21 = r13;
        goto L179
    }

    public static boolean d() {
        Lazy r0 = ECAppInfoService.a;
        Object r10 = null;
        if (ECAppInfoService.h() == false) goto L8;
        Map r1 = g();
        if (r1 == null) goto L197;
        r10 = r1.get("iesec_enable_yata_ultimate_buy_response_cache");
    L197:
        return Intrinsics.areEqual(r10, 1);
    L8:
        com.bytedance.android.ec.core.abtest.d r11 = com.bytedance.android.ec.core.abtest.d.a;
        int r12 = j.a;
        Object r13 = 0;
        int r14 = com.bytedance.android.ec.base.settings.b.a;
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L169
        h.a();     // Catch: Throwable -> L169
        SDKSettingsCacheManager r16 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L169
        r16.getClass();     // Catch: Throwable -> L59
        Object r17 = SDKSettingsCacheManager.b.get("iesec_enable_yata_ultimate_buy_response_cache");     // Catch: Throwable -> L59
        if (r17 != null) goto L14;
    L56:
        Object r18 = null;
    L57:
        Object r19 = Result.constructor-impl(r18);     // Catch: Throwable -> L59
    L61:
        Throwable r20 = Result.exceptionOrNull-impl(r19);     // Catch: Throwable -> L169
        if (r20 == null) goto L65;
        EnsureManager.ensureNotReachHere(r20);     // Catch: Throwable -> L169
    L65:
        if (Result.isFailure-impl(r19) == false) goto L68;
        r19 = null;
    L68:
        if ((r19 instanceof Integer) == true) goto L70;
        r19 = null;
    L70:
        Object r21 = (Integer) r19;     // Catch: Throwable -> L169
        if (r21 != null) goto L77;
        r16.getClass();     // Catch: Throwable -> L169
        Object r22 = SDKSettingsCacheManager.a.get("iesec_enable_yata_ultimate_buy_response_cache");     // Catch: Throwable -> L169
        if ((r22 instanceof Integer) == true) goto L76;
        r22 = null;
    L76:
        r21 = (Integer) r22;     // Catch: Throwable -> L169
    L77:
        if (r21 != null) goto L179;
        int r23 = g.a;     // Catch: Throwable -> L169
    L156:
        th = move-exception;
        Result.Companion r24 = Result.Companion;     // Catch: Throwable -> L169
        Object r25 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L169
    L159:
        if (Result.exceptionOrNull-impl(r25) != null) goto L187;
    L166:
        r21 = r25;
    L167:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L169
        SDKSettingsCacheManager.e("iesec_enable_yata_ultimate_buy_response_cache", r21);     // Catch: Throwable -> L169
        goto L179
    L187:
        r25 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_enable_yata_ultimate_buy_response_cache", Integer.class, r13);     // Catch: Throwable -> L163
    L164:
        if (r25 != null) goto L166;
        r21 = r13;
    L163:
        r25 = r13;
        goto L164
    L193:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L130
        Object r26 = SDKSettingsCacheManager.b.get("iesec_enable_yata_ultimate_buy_response_cache");     // Catch: Throwable -> L130
        if (r26 != null) goto L85;
    L127:
        Object r27 = null;
    L128:
        Object r28 = Result.constructor-impl(r27);     // Catch: Throwable -> L130
    L132:
        Throwable r29 = Result.exceptionOrNull-impl(r28);     // Catch: Throwable -> L156
        if (r29 == null) goto L136;
        EnsureManager.ensureNotReachHere(r29);     // Catch: Throwable -> L156
    L136:
        if (Result.isFailure-impl(r28) == false) goto L139;
        r28 = null;
    L139:
        if ((r28 instanceof Integer) == true) goto L141;
        r28 = null;
    L141:
        Integer r30 = (Integer) r28;     // Catch: Throwable -> L156
        if (r30 == null) goto L144;
        r21 = r30;
        goto L167
    L144:
        jj4.b r31 = jj4.b.b;     // Catch: Throwable -> L156
        Object r32 = jj4.a.a("iesec_enable_yata_ultimate_buy_response_cache", Integer.class, r13, false);     // Catch: Throwable -> L156
        if (r32 != null) goto L148;
        Intrinsics.throwNpe();     // Catch: Throwable -> L156
    L148:
        if ((r32 instanceof Integer) == false) goto L151;
        r10 = r32;
    L151:
        Object r33 = (Integer) r10;     // Catch: Throwable -> L156
        if (r33 != null) goto L154;
        r33 = r13;
    L154:
        r25 = Result.constructor-impl(r33);     // Catch: Throwable -> L156
    L85:
        if ((r26 instanceof Integer) == true) goto L87;
        Object r34 = null;
    L88:
        r27 = (Integer) r34;     // Catch: Throwable -> L130
        if (r27 != null) goto L128;
        if ((r26 instanceof Number) == false) goto L115;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r35 = Float.valueOf(((Number) r26).floatValue());     // Catch: Throwable -> L130
        if ((r35 instanceof Integer) == true) goto L98;
        r35 = null;
    L98:
        r27 = (Integer) r35;     // Catch: Throwable -> L130
        goto L128
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r36 = Double.valueOf(((Number) r26).doubleValue());     // Catch: Throwable -> L130
        if ((r36 instanceof Integer) == true) goto L104;
        r36 = null;
    L104:
        r27 = (Integer) r36;     // Catch: Throwable -> L130
        goto L128
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L109;
        r27 = Integer.valueOf(((Number) r26).intValue());     // Catch: Throwable -> L130
        goto L128
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L115;
        Long r37 = Long.valueOf(((Number) r26).longValue());     // Catch: Throwable -> L130
        if ((r37 instanceof Integer) == true) goto L113;
        r37 = null;
    L113:
        r27 = (Integer) r37;     // Catch: Throwable -> L130
    L115:
        if ((r26 instanceof JSONObject) == false) goto L117;
    L185:
        Object r38 = SDKSettingsCacheManager.a().fromJson(r26.toString(), Integer.class);     // Catch: Throwable -> L123
        if ((r38 instanceof Integer) == true) goto L121;
        r38 = null;
    L121:
        Object r39 = Result.constructor-impl((Integer) r38);     // Catch: Throwable -> L123
    L125:
        r27 = r39;
        if (Result.isFailure-impl(r27) == false) goto L128;
    L123:
        th = move-exception;
        Result.Companion r40 = Result.Companion;     // Catch: Throwable -> L130
        r39 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L130
        goto L125
    L117:
        if ((r26 instanceof JSONArray) == false) goto L127;
    L87:
        r34 = r26;
    L130:
        th = move-exception;
        Result.Companion r41 = Result.Companion;     // Catch: Throwable -> L156
        r28 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L156
    L179:
        if (((Number) r21).intValue() == 1) goto L198;
        return false;
    L198:
        return true;
    L14:
        if ((r17 instanceof Integer) == true) goto L16;
        Object r42 = null;
    L17:
        r18 = (Integer) r42;     // Catch: Throwable -> L59
        if (r18 != null) goto L57;
        if ((r17 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L29;
        Float r43 = Float.valueOf(((Number) r17).floatValue());     // Catch: Throwable -> L59
        if ((r43 instanceof Integer) == true) goto L27;
        r43 = null;
    L27:
        r18 = (Integer) r43;     // Catch: Throwable -> L59
        goto L57
    L29:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L35;
        Double r44 = Double.valueOf(((Number) r17).doubleValue());     // Catch: Throwable -> L59
        if ((r44 instanceof Integer) == true) goto L33;
        r44 = null;
    L33:
        r18 = (Integer) r44;     // Catch: Throwable -> L59
        goto L57
    L35:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        r18 = Integer.valueOf(((Number) r17).intValue());     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r45 = Long.valueOf(((Number) r17).longValue());     // Catch: Throwable -> L59
        if ((r45 instanceof Integer) == true) goto L42;
        r45 = null;
    L42:
        r18 = (Integer) r45;     // Catch: Throwable -> L59
    L44:
        if ((r17 instanceof JSONObject) == false) goto L46;
    L183:
        Object r46 = SDKSettingsCacheManager.a().fromJson(r17.toString(), Integer.class);     // Catch: Throwable -> L52
        if ((r46 instanceof Integer) == true) goto L50;
        r46 = null;
    L50:
        Object r47 = Result.constructor-impl((Integer) r46);     // Catch: Throwable -> L52
    L54:
        r18 = r47;
        if (Result.isFailure-impl(r18) == false) goto L57;
    L52:
        th = move-exception;
        Result.Companion r48 = Result.Companion;     // Catch: Throwable -> L59
        r47 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L59
        goto L54
    L46:
        if ((r17 instanceof JSONArray) == false) goto L56;
    L16:
        r42 = r17;
    L59:
        th = move-exception;
        Result.Companion r49 = Result.Companion;     // Catch: Throwable -> L169
        r19 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L169
    L169:
        th = move-exception;
        Result.Companion r50 = Result.Companion;
        Object r51 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r52 = Result.exceptionOrNull-impl(r51);
        if (r52 == null) goto L174;
        EnsureManager.ensureNotReachHere(r52);
    L174:
        if (Result.isFailure-impl(r51) == true) goto L177;
        r13 = r51;
    L177:
        r21 = r13;
        goto L179
    }

    public static boolean h() {
        Lazy r0 = ECAppInfoService.a;
        Object r10 = null;
        if (ECAppInfoService.h() == false) goto L8;
        Map r1 = g();
        if (r1 == null) goto L197;
        r10 = r1.get("iesec_buy_finance_risk_post");
    L197:
        return Intrinsics.areEqual(r10, 1);
    L8:
        com.bytedance.android.ec.core.abtest.d r11 = com.bytedance.android.ec.core.abtest.d.a;
        int r12 = j.a;
        Object r13 = 0;
        int r14 = com.bytedance.android.ec.base.settings.b.a;
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L169
        h.a();     // Catch: Throwable -> L169
        SDKSettingsCacheManager r16 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L169
        r16.getClass();     // Catch: Throwable -> L59
        Object r17 = SDKSettingsCacheManager.b.get("iesec_buy_finance_risk_post");     // Catch: Throwable -> L59
        if (r17 != null) goto L14;
    L56:
        Object r18 = null;
    L57:
        Object r19 = Result.constructor-impl(r18);     // Catch: Throwable -> L59
    L61:
        Throwable r20 = Result.exceptionOrNull-impl(r19);     // Catch: Throwable -> L169
        if (r20 == null) goto L65;
        EnsureManager.ensureNotReachHere(r20);     // Catch: Throwable -> L169
    L65:
        if (Result.isFailure-impl(r19) == false) goto L68;
        r19 = null;
    L68:
        if ((r19 instanceof Integer) == true) goto L70;
        r19 = null;
    L70:
        Object r21 = (Integer) r19;     // Catch: Throwable -> L169
        if (r21 != null) goto L77;
        r16.getClass();     // Catch: Throwable -> L169
        Object r22 = SDKSettingsCacheManager.a.get("iesec_buy_finance_risk_post");     // Catch: Throwable -> L169
        if ((r22 instanceof Integer) == true) goto L76;
        r22 = null;
    L76:
        r21 = (Integer) r22;     // Catch: Throwable -> L169
    L77:
        if (r21 != null) goto L179;
        int r23 = g.a;     // Catch: Throwable -> L169
    L156:
        th = move-exception;
        Result.Companion r24 = Result.Companion;     // Catch: Throwable -> L169
        Object r25 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L169
    L159:
        if (Result.exceptionOrNull-impl(r25) != null) goto L187;
    L166:
        r21 = r25;
    L167:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L169
        SDKSettingsCacheManager.e("iesec_buy_finance_risk_post", r21);     // Catch: Throwable -> L169
        goto L179
    L187:
        r25 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_buy_finance_risk_post", Integer.class, r13);     // Catch: Throwable -> L163
    L164:
        if (r25 != null) goto L166;
        r21 = r13;
    L163:
        r25 = r13;
        goto L164
    L193:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L130
        Object r26 = SDKSettingsCacheManager.b.get("iesec_buy_finance_risk_post");     // Catch: Throwable -> L130
        if (r26 != null) goto L85;
    L127:
        Object r27 = null;
    L128:
        Object r28 = Result.constructor-impl(r27);     // Catch: Throwable -> L130
    L132:
        Throwable r29 = Result.exceptionOrNull-impl(r28);     // Catch: Throwable -> L156
        if (r29 == null) goto L136;
        EnsureManager.ensureNotReachHere(r29);     // Catch: Throwable -> L156
    L136:
        if (Result.isFailure-impl(r28) == false) goto L139;
        r28 = null;
    L139:
        if ((r28 instanceof Integer) == true) goto L141;
        r28 = null;
    L141:
        Integer r30 = (Integer) r28;     // Catch: Throwable -> L156
        if (r30 == null) goto L144;
        r21 = r30;
        goto L167
    L144:
        jj4.b r31 = jj4.b.b;     // Catch: Throwable -> L156
        Object r32 = jj4.a.a("iesec_buy_finance_risk_post", Integer.class, r13, false);     // Catch: Throwable -> L156
        if (r32 != null) goto L148;
        Intrinsics.throwNpe();     // Catch: Throwable -> L156
    L148:
        if ((r32 instanceof Integer) == false) goto L151;
        r10 = r32;
    L151:
        Object r33 = (Integer) r10;     // Catch: Throwable -> L156
        if (r33 != null) goto L154;
        r33 = r13;
    L154:
        r25 = Result.constructor-impl(r33);     // Catch: Throwable -> L156
    L85:
        if ((r26 instanceof Integer) == true) goto L87;
        Object r34 = null;
    L88:
        r27 = (Integer) r34;     // Catch: Throwable -> L130
        if (r27 != null) goto L128;
        if ((r26 instanceof Number) == false) goto L115;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r35 = Float.valueOf(((Number) r26).floatValue());     // Catch: Throwable -> L130
        if ((r35 instanceof Integer) == true) goto L98;
        r35 = null;
    L98:
        r27 = (Integer) r35;     // Catch: Throwable -> L130
        goto L128
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r36 = Double.valueOf(((Number) r26).doubleValue());     // Catch: Throwable -> L130
        if ((r36 instanceof Integer) == true) goto L104;
        r36 = null;
    L104:
        r27 = (Integer) r36;     // Catch: Throwable -> L130
        goto L128
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L109;
        r27 = Integer.valueOf(((Number) r26).intValue());     // Catch: Throwable -> L130
        goto L128
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L115;
        Long r37 = Long.valueOf(((Number) r26).longValue());     // Catch: Throwable -> L130
        if ((r37 instanceof Integer) == true) goto L113;
        r37 = null;
    L113:
        r27 = (Integer) r37;     // Catch: Throwable -> L130
    L115:
        if ((r26 instanceof JSONObject) == false) goto L117;
    L185:
        Object r38 = SDKSettingsCacheManager.a().fromJson(r26.toString(), Integer.class);     // Catch: Throwable -> L123
        if ((r38 instanceof Integer) == true) goto L121;
        r38 = null;
    L121:
        Object r39 = Result.constructor-impl((Integer) r38);     // Catch: Throwable -> L123
    L125:
        r27 = r39;
        if (Result.isFailure-impl(r27) == false) goto L128;
    L123:
        th = move-exception;
        Result.Companion r40 = Result.Companion;     // Catch: Throwable -> L130
        r39 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L130
        goto L125
    L117:
        if ((r26 instanceof JSONArray) == false) goto L127;
    L87:
        r34 = r26;
    L130:
        th = move-exception;
        Result.Companion r41 = Result.Companion;     // Catch: Throwable -> L156
        r28 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L156
    L179:
        if (((Number) r21).intValue() == 1) goto L198;
        return false;
    L198:
        return true;
    L14:
        if ((r17 instanceof Integer) == true) goto L16;
        Object r42 = null;
    L17:
        r18 = (Integer) r42;     // Catch: Throwable -> L59
        if (r18 != null) goto L57;
        if ((r17 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L29;
        Float r43 = Float.valueOf(((Number) r17).floatValue());     // Catch: Throwable -> L59
        if ((r43 instanceof Integer) == true) goto L27;
        r43 = null;
    L27:
        r18 = (Integer) r43;     // Catch: Throwable -> L59
        goto L57
    L29:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L35;
        Double r44 = Double.valueOf(((Number) r17).doubleValue());     // Catch: Throwable -> L59
        if ((r44 instanceof Integer) == true) goto L33;
        r44 = null;
    L33:
        r18 = (Integer) r44;     // Catch: Throwable -> L59
        goto L57
    L35:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        r18 = Integer.valueOf(((Number) r17).intValue());     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r45 = Long.valueOf(((Number) r17).longValue());     // Catch: Throwable -> L59
        if ((r45 instanceof Integer) == true) goto L42;
        r45 = null;
    L42:
        r18 = (Integer) r45;     // Catch: Throwable -> L59
    L44:
        if ((r17 instanceof JSONObject) == false) goto L46;
    L183:
        Object r46 = SDKSettingsCacheManager.a().fromJson(r17.toString(), Integer.class);     // Catch: Throwable -> L52
        if ((r46 instanceof Integer) == true) goto L50;
        r46 = null;
    L50:
        Object r47 = Result.constructor-impl((Integer) r46);     // Catch: Throwable -> L52
    L54:
        r18 = r47;
        if (Result.isFailure-impl(r18) == false) goto L57;
    L52:
        th = move-exception;
        Result.Companion r48 = Result.Companion;     // Catch: Throwable -> L59
        r47 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L59
        goto L54
    L46:
        if ((r17 instanceof JSONArray) == false) goto L56;
    L16:
        r42 = r17;
    L59:
        th = move-exception;
        Result.Companion r49 = Result.Companion;     // Catch: Throwable -> L169
        r19 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L169
    L169:
        th = move-exception;
        Result.Companion r50 = Result.Companion;
        Object r51 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r52 = Result.exceptionOrNull-impl(r51);
        if (r52 == null) goto L174;
        EnsureManager.ensureNotReachHere(r52);
    L174:
        if (Result.isFailure-impl(r51) == true) goto L177;
        r13 = r51;
    L177:
        r21 = r13;
        goto L179
    }

    public static boolean c() {
        Map r0 = g();
        if (r0 == null) goto L5;
        Object r1 = r0.get("iesec_enable_pass_through_deprecated");
    L7:
        return Intrinsics.areEqual(r1, 1);
    L5:
        r1 = null;
        goto L7
    }

    public static boolean e() {
        Map r0 = g();
        if (r0 == null) goto L5;
        Object r1 = r0.get("buy_now_entrance_simplify");
    L7:
        return Intrinsics.areEqual(r1, 2);
    L5:
        r1 = null;
        goto L7
    }

    public static boolean f() {
        Map r0 = g();
        if (r0 == null) goto L5;
        Object r1 = r0.get("buy_now_entrance_simplify");
    L7:
        return Intrinsics.areEqual(r1, 1);
    L5:
        r1 = null;
        goto L7
    }

    public static boolean i() {
        Map r0 = g();
        if (r0 == null) goto L5;
        Object r1 = r0.get("ab_buy_now_precreate_slice_view");
    L7:
        return Intrinsics.areEqual(r1, 1);
    L5:
        r1 = null;
        goto L7
    }

    public static boolean j() {
        Map r0 = g();
        if (r0 == null) goto L5;
        Object r1 = r0.get("buy_now_render_simplify");
    L7:
        return Intrinsics.areEqual(r1, 1);
    L5:
        r1 = null;
        goto L7
    }

    public static boolean k() {
        Map r0 = g();
        if (r0 == null) goto L5;
        Object r1 = r0.get("buy_now_replace_host_v2");
    L7:
        return Intrinsics.areEqual(r1, 1);
    L5:
        r1 = null;
        goto L7
    }

    public static void l() {
        Map r0 = g();
        if (r0 == null) goto L5;
        Object r1 = r0.get("iesec_enable_yata_sku_params_simplify");
    L6:
        Intrinsics.areEqual(r1, 1);
        return;
    L5:
        r1 = null;
        goto L6
    }

    public static boolean m() {
        Map r0 = g();
        if (r0 == null) goto L5;
        Object r1 = r0.get("ec_sku_height_imp_all");
    L7:
        return Intrinsics.areEqual(r1, 1);
    L5:
        r1 = null;
        goto L7
    }

    public static boolean n() {
        Map r0 = g();
        if (r0 == null) goto L5;
        Object r1 = r0.get("ec_sku_height_imp_card");
    L7:
        return Intrinsics.areEqual(r1, 1);
    L5:
        r1 = null;
        goto L7
    }

    public static boolean o() {
        Map r0 = g();
        if (r0 == null) goto L5;
        Object r1 = r0.get("ec_sku_height_imp_force_type");
    L7:
        return Intrinsics.areEqual(r1, 2);
    L5:
        r1 = null;
        goto L7
    }

    public static boolean p() {
        Map r0 = g();
        if (r0 == null) goto L5;
        Object r1 = r0.get("ec_sku_height_imp_force_type");
    L7:
        return Intrinsics.areEqual(r1, 1);
    L5:
        r1 = null;
        goto L7
    }

    public static boolean q() {
        Map r0 = g();
        if (r0 == null) goto L5;
        Object r1 = r0.get("buy_now_slice_template_config_opt");
    L7:
        return Intrinsics.areEqual(r1, 1);
    L5:
        r1 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.util.ArrayList] */
    public static void r(BuyNowBizCode r12) {
        Intrinsics.checkNotNullParameter(r12, "buynowBizCode");
        Context r0 = ECAppInfoService.e.getApplicationContext();
        if (r0 != null) goto L5;
        return;
    L5:
        String r1 = r12.getValue();
        BuyNowBizCode r10 = BuyNowBizCode.YATA_SKUBUY;
        if (Intrinsics.areEqual(r1, r10.getValue()) == false) goto L11;
        if (q() == false) goto L11;
        a r11 = new a("performance_opt_ultimate_buynow", "ultimate_buynow");
    L22:
        z43.b r13 = ECSettingKeys.f();
        Map r14 = null;
        Object r15 = null;
        if (r13.b() == true) goto L26;
        r13 = null;
    L26:
        if (r13 == null) goto L63;
        Map r16 = r13.c();
        if (r16 == null) goto L31;
        List r17 = (List) r16.get(r11.a);
        if (r17 == null) goto L31;
    L35:
        if (r17 == null) goto L50;
        ArrayList r18 = new ArrayList();
        Iterator r19 = r17.iterator();
    L38:
        if (r19.hasNext() == false) goto L49;
        z43.a r20 = (z43.a) r19.next();
        int r21 = r20.b();
        Map r22 = r13.a();
        if (r22 == null) goto L47;
        List r23 = (List) r22.get(r20.a());
        if (r23 == null) goto L47;
        List r24 = r23;
        ?? r25 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r24, 10));
        Iterator r26 = r24.iterator();
    L45:
        if (r26.hasNext() == false) goto L48;
        com.bytedance.android.ecom.slice.ext.template.gecko.j r27 = (com.bytedance.android.ecom.slice.ext.template.gecko.j) r26.next();
        r25.add(new com.bytedance.android.ecom.slice.ext.template.gecko.j(r27.a(), r27.c(), r27.b() * r21));
    L48:
        CollectionsKt.addAll(r18, (Iterable) r25);
    L47:
        r25 = CollectionsKt.emptyList();
        goto L48
    L49:
        List r28 = CollectionsKt.toList(r18);
    L51:
        String r29 = ECSettingKeys.e();
        if (r29 != null) goto L66;
    L62:
        final com.bytedance.android.ecom.slice.ext.template.gecko.g r30 = new com.bytedance.android.ecom.slice.ext.template.gecko.g(r28, r14, i());
    L64:
        SlcGeckoTemplateMgr.f(SlcGeckoTemplateMgr.l, r12.getValue(), "ecom_buynow_card_template", wh.a.b(r0), new BuyNowPerformanceOpt$preloadTemplate$1(r30));
        return;
    L66:
        Result.Companion r31 = Result.Companion;     // Catch: Throwable -> L55
        int r32 = t0.a;     // Catch: Throwable -> L55
        Object r33 = Result.constructor-impl(((b) t0.a.a.fromJson("{\"map\":" + r29 + "}", b.class)).a());     // Catch: Throwable -> L55
    L58:
        if (Result.isFailure-impl(r33) == true) goto L61;
        r15 = r33;
    L61:
        r14 = (Map) r15;
    L55:
        th = move-exception;
        Result.Companion r34 = Result.Companion;
        r33 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L58
    L50:
        r28 = null;
    L31:
        Map r35 = r13.c();
        if (r35 == null) goto L34;
        r17 = (List) r35.get(r11.b);
        goto L35
    L34:
        r17 = null;
        goto L35
    L63:
        r30 = new com.bytedance.android.ecom.slice.ext.template.gecko.g(null, 7);
    L11:
        if (Intrinsics.areEqual(r12.getValue(), r10.getValue()) == false) goto L16;
        if (q() == true) goto L16;
        r11 = new a("ultimate_buynow", "ultimate_buynow");
    L16:
        if (Intrinsics.areEqual(r12.getValue(), BuyNowBizCode.CONTINUE_PAY.getValue()) == false) goto L19;
        r11 = new a("continue_pay", "continue_pay");
        goto L22
    L19:
        if (q() == false) goto L21;
        r11 = new a("performance_opt_single_product", "single_normal_product");
        goto L22
    L21:
        r11 = new a("single_normal_product", "single_normal_product");
        goto L22
    }
}
