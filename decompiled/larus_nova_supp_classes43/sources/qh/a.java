package qh;

import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.base.settings.b;
import com.bytedance.android.ec.base.settings.g;
import com.bytedance.android.ec.base.settings.h;
import com.bytedance.android.ec.core.abtest.d;
import com.bytedance.android.ec.hybrid.hostapi.IECHybridKevaService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.services.apm.api.EnsureManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static boolean a() {
        d r0 = d.a;
        int r1 = b.a;
        Object r10 = Boolean.FALSE;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L172
        h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r12 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L172
        Object r13 = null;
        r12.getClass();     // Catch: Throwable -> L59
        Object r14 = SDKSettingsCacheManager.b.get("ec_degrade_preload_for_anr");     // Catch: Throwable -> L59
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
        Object r19 = SDKSettingsCacheManager.a.get("ec_degrade_preload_for_anr");     // Catch: Throwable -> L172
        if ((r19 instanceof Boolean) == true) goto L76;
        r19 = null;
    L76:
        r18 = (Boolean) r19;     // Catch: Throwable -> L172
    L77:
        if (r18 != null) goto L182;
        int r20 = g.a;     // Catch: Throwable -> L172
    L159:
        th = move-exception;
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L172
        Object r22 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L172
    L162:
        if (Result.exceptionOrNull-impl(r22) != null) goto L187;
    L169:
        r18 = r22;
    L170:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L172
        SDKSettingsCacheManager.e("ec_degrade_preload_for_anr", r18);     // Catch: Throwable -> L172
        goto L182
    L187:
        r22 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_degrade_preload_for_anr", Boolean.class, r10);     // Catch: Throwable -> L166
    L167:
        if (r22 != null) goto L169;
        r18 = r10;
    L166:
        r22 = r10;
        goto L167
    L195:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L133
        Object r23 = SDKSettingsCacheManager.b.get("ec_degrade_preload_for_anr");     // Catch: Throwable -> L133
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
        Object r28 = jj4.a.a("ec_degrade_preload_for_anr", Boolean.class, r10, false);     // Catch: Throwable -> L159
        if (r28 != null) goto L151;
        Intrinsics.throwNpe();     // Catch: Throwable -> L159
    L151:
        if ((r28 instanceof Boolean) == false) goto L154;
        r13 = r28;
    L154:
        Object r29 = (Boolean) r13;     // Catch: Throwable -> L159
        if (r29 != null) goto L157;
        r29 = r10;
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
    L191:
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
        if (((Boolean) r18).booleanValue() == false) goto L186;
        int r39 = ECSdk.a;
        cj.b r40 = (cj.b) ECSdk.a(cj.b.class);
        if (r40 == null) goto L186;
        r40.g();
    L186:
        return false;
    L11:
        if ((r14 instanceof Boolean) == true) goto L13;
        Object r41 = null;
    L14:
        r15 = (Boolean) r41;     // Catch: Throwable -> L59
        if (r15 != null) goto L57;
        if ((r14 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r42 = Float.valueOf(((Number) r14).floatValue());     // Catch: Throwable -> L59
        if ((r42 instanceof Boolean) == true) goto L24;
        r42 = null;
    L24:
        r15 = (Boolean) r42;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r43 = Double.valueOf(((Number) r14).doubleValue());     // Catch: Throwable -> L59
        if ((r43 instanceof Boolean) == true) goto L30;
        r43 = null;
    L30:
        r15 = (Boolean) r43;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r44 = Integer.valueOf(((Number) r14).intValue());     // Catch: Throwable -> L59
        if ((r44 instanceof Boolean) == true) goto L36;
        r44 = null;
    L36:
        r15 = (Boolean) r44;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r45 = Long.valueOf(((Number) r14).longValue());     // Catch: Throwable -> L59
        if ((r45 instanceof Boolean) == true) goto L42;
        r45 = null;
    L42:
        r15 = (Boolean) r45;     // Catch: Throwable -> L59
    L44:
        if ((r14 instanceof JSONObject) == false) goto L46;
    L193:
        Object r46 = SDKSettingsCacheManager.a().fromJson(r14.toString(), Boolean.class);     // Catch: Throwable -> L52
        if ((r46 instanceof Boolean) == true) goto L50;
        r46 = null;
    L50:
        Object r47 = Result.constructor-impl((Boolean) r46);     // Catch: Throwable -> L52
    L54:
        r15 = r47;
        if (Result.isFailure-impl(r15) == false) goto L57;
    L52:
        th = move-exception;
        Result.Companion r48 = Result.Companion;     // Catch: Throwable -> L59
        r47 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L59
        goto L54
    L46:
        if ((r14 instanceof JSONArray) == false) goto L56;
    L13:
        r41 = r14;
    L59:
        th = move-exception;
        Result.Companion r49 = Result.Companion;     // Catch: Throwable -> L172
        r16 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L172
    L172:
        th = move-exception;
        Result.Companion r50 = Result.Companion;
        Object r51 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r52 = Result.exceptionOrNull-impl(r51);
        if (r52 == null) goto L177;
        EnsureManager.ensureNotReachHere(r52);
    L177:
        if (Result.isFailure-impl(r51) == true) goto L180;
        r10 = r51;
    L180:
        r18 = r10;
        goto L182
    }

    static {
    }
}
