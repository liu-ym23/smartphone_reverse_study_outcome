package com.bytedance.android.ec.core.imagex.opt;

import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.hybrid.hostapi.IECHybridKevaService;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.dataplatform.config.SettingPanel;
import com.bytedance.services.apm.api.EnsureManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class z {
    @SettingPanel("电商图片优化-AB实验API兼容Saas端开关")
    public static final boolean a() {
        int r0 = com.bytedance.android.ec.base.settings.b.a;
        Object r1 = Boolean.FALSE;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r11 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L172
        Object r12 = null;
        r11.getClass();     // Catch: Throwable -> L59
        Object r13 = SDKSettingsCacheManager.b.get("ec_image_opt_abtest_saas_enable");     // Catch: Throwable -> L59
        if (r13 != null) goto L11;
    L56:
        Object r14 = null;
    L57:
        Object r15 = Result.constructor-impl(r14);     // Catch: Throwable -> L59
    L61:
        Throwable r16 = Result.exceptionOrNull-impl(r15);     // Catch: Throwable -> L172
        if (r16 == null) goto L65;
        EnsureManager.ensureNotReachHere(r16);     // Catch: Throwable -> L172
    L65:
        if (Result.isFailure-impl(r15) == false) goto L68;
        r15 = null;
    L68:
        if ((r15 instanceof Boolean) == true) goto L70;
        r15 = null;
    L70:
        Object r17 = (Boolean) r15;     // Catch: Throwable -> L172
        if (r17 != null) goto L77;
        r11.getClass();     // Catch: Throwable -> L172
        Object r18 = SDKSettingsCacheManager.a.get("ec_image_opt_abtest_saas_enable");     // Catch: Throwable -> L172
        if ((r18 instanceof Boolean) == true) goto L76;
        r18 = null;
    L76:
        r17 = (Boolean) r18;     // Catch: Throwable -> L172
    L77:
        if (r17 != null) goto L182;
        int r19 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L172
    L159:
        th = move-exception;
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L172
        Object r21 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L172
    L162:
        if (Result.exceptionOrNull-impl(r21) != null) goto L185;
    L169:
        r17 = r21;
    L170:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L172
        SDKSettingsCacheManager.e("ec_image_opt_abtest_saas_enable", r17);     // Catch: Throwable -> L172
        goto L182
    L185:
        r21 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_image_opt_abtest_saas_enable", Boolean.class, r1);     // Catch: Throwable -> L166
    L167:
        if (r21 != null) goto L169;
        r17 = r1;
    L166:
        r21 = r1;
        goto L167
    L191:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L133
        Object r22 = SDKSettingsCacheManager.b.get("ec_image_opt_abtest_saas_enable");     // Catch: Throwable -> L133
        if (r22 != null) goto L85;
    L130:
        Object r23 = null;
    L131:
        Object r24 = Result.constructor-impl(r23);     // Catch: Throwable -> L133
    L135:
        Throwable r25 = Result.exceptionOrNull-impl(r24);     // Catch: Throwable -> L159
        if (r25 == null) goto L139;
        EnsureManager.ensureNotReachHere(r25);     // Catch: Throwable -> L159
    L139:
        if (Result.isFailure-impl(r24) == false) goto L142;
        r24 = null;
    L142:
        if ((r24 instanceof Boolean) == true) goto L144;
        r24 = null;
    L144:
        r21 = (Boolean) r24;     // Catch: Throwable -> L159
        if (r21 != null) goto L169;
        jj4.b r26 = jj4.b.b;     // Catch: Throwable -> L159
        Object r27 = jj4.a.a("ec_image_opt_abtest_saas_enable", Boolean.class, r1, false);     // Catch: Throwable -> L159
        if (r27 != null) goto L151;
        Intrinsics.throwNpe();     // Catch: Throwable -> L159
    L151:
        if ((r27 instanceof Boolean) == false) goto L154;
        r12 = r27;
    L154:
        Object r28 = (Boolean) r12;     // Catch: Throwable -> L159
        if (r28 != null) goto L157;
        r28 = r1;
    L157:
        r21 = Result.constructor-impl(r28);     // Catch: Throwable -> L159
    L85:
        if ((r22 instanceof Boolean) == true) goto L87;
        Object r29 = null;
    L88:
        r23 = (Boolean) r29;     // Catch: Throwable -> L133
        if (r23 != null) goto L131;
        if ((r22 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r30 = Float.valueOf(((Number) r22).floatValue());     // Catch: Throwable -> L133
        if ((r30 instanceof Boolean) == true) goto L98;
        r30 = null;
    L98:
        r23 = (Boolean) r30;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r31 = Double.valueOf(((Number) r22).doubleValue());     // Catch: Throwable -> L133
        if ((r31 instanceof Boolean) == true) goto L104;
        r31 = null;
    L104:
        r23 = (Boolean) r31;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r32 = Integer.valueOf(((Number) r22).intValue());     // Catch: Throwable -> L133
        if ((r32 instanceof Boolean) == true) goto L110;
        r32 = null;
    L110:
        r23 = (Boolean) r32;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r33 = Long.valueOf(((Number) r22).longValue());     // Catch: Throwable -> L133
        if ((r33 instanceof Boolean) == true) goto L116;
        r33 = null;
    L116:
        r23 = (Boolean) r33;     // Catch: Throwable -> L133
    L118:
        if ((r22 instanceof JSONObject) == false) goto L120;
    L183:
        Object r34 = SDKSettingsCacheManager.a().fromJson(r22.toString(), Boolean.class);     // Catch: Throwable -> L126
        if ((r34 instanceof Boolean) == true) goto L124;
        r34 = null;
    L124:
        Object r35 = Result.constructor-impl((Boolean) r34);     // Catch: Throwable -> L126
    L128:
        r23 = r35;
        if (Result.isFailure-impl(r23) == false) goto L131;
    L126:
        th = move-exception;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L133
        r35 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L133
        goto L128
    L120:
        if ((r22 instanceof JSONArray) == false) goto L130;
    L87:
        r29 = r22;
    L133:
        th = move-exception;
        Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L159
        r24 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L159
    L182:
        return ((Boolean) r17).booleanValue();
    L11:
        if ((r13 instanceof Boolean) == true) goto L13;
        Object r38 = null;
    L14:
        r14 = (Boolean) r38;     // Catch: Throwable -> L59
        if (r14 != null) goto L57;
        if ((r13 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r39 = Float.valueOf(((Number) r13).floatValue());     // Catch: Throwable -> L59
        if ((r39 instanceof Boolean) == true) goto L24;
        r39 = null;
    L24:
        r14 = (Boolean) r39;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r40 = Double.valueOf(((Number) r13).doubleValue());     // Catch: Throwable -> L59
        if ((r40 instanceof Boolean) == true) goto L30;
        r40 = null;
    L30:
        r14 = (Boolean) r40;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r41 = Integer.valueOf(((Number) r13).intValue());     // Catch: Throwable -> L59
        if ((r41 instanceof Boolean) == true) goto L36;
        r41 = null;
    L36:
        r14 = (Boolean) r41;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r42 = Long.valueOf(((Number) r13).longValue());     // Catch: Throwable -> L59
        if ((r42 instanceof Boolean) == true) goto L42;
        r42 = null;
    L42:
        r14 = (Boolean) r42;     // Catch: Throwable -> L59
    L44:
        if ((r13 instanceof JSONObject) == false) goto L46;
    L189:
        Object r43 = SDKSettingsCacheManager.a().fromJson(r13.toString(), Boolean.class);     // Catch: Throwable -> L52
        if ((r43 instanceof Boolean) == true) goto L50;
        r43 = null;
    L50:
        Object r44 = Result.constructor-impl((Boolean) r43);     // Catch: Throwable -> L52
    L54:
        r14 = r44;
        if (Result.isFailure-impl(r14) == false) goto L57;
    L52:
        th = move-exception;
        Result.Companion r45 = Result.Companion;     // Catch: Throwable -> L59
        r44 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L59
        goto L54
    L46:
        if ((r13 instanceof JSONArray) == false) goto L56;
    L13:
        r38 = r13;
    L59:
        th = move-exception;
        Result.Companion r46 = Result.Companion;     // Catch: Throwable -> L172
        r15 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L172
    L172:
        th = move-exception;
        Result.Companion r47 = Result.Companion;
        Object r48 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r49 = Result.exceptionOrNull-impl(r48);
        if (r49 == null) goto L177;
        EnsureManager.ensureNotReachHere(r49);
    L177:
        if (Result.isFailure-impl(r48) == true) goto L180;
        r1 = r48;
    L180:
        r17 = r1;
        goto L182
    }

    @JvmStatic
    public static final boolean b() {
        Lazy r0 = ECAppInfoService.a;
        boolean r1 = we.a.a;
        dm.a.a("ImageXABTestSaasEpx").a("supportSaasABTest isSaas: " + r1 + ", saasABTestEnable: " + a());
        if (r1 == true) goto L5;
    L7:
        return false;
    L5:
        if (a() == false) goto L7;
        return true;
    }

    static {
    }
}
