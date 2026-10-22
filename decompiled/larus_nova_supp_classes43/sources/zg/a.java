package zg;

import com.bytedance.android.ec.ab.opt.HostExperimentKey;
import com.bytedance.android.ec.ab.opt.OptSetting;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.base.settings.c;
import com.bytedance.android.ec.base.settings.d;
import com.bytedance.android.ec.core.opt.ab.n;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.services.apm.api.EnsureManager;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@OptSetting(business = "电商跨端Setting集合")
public final class a {
    public static final /* synthetic */ int a = 0;

    @HostExperimentKey
    public static final int a() {
        int r0 = n.a;
        Object r1 = 0;
        int r10 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L160
        Object r12 = null;
        Object r13 = d.c.get("ab_order_schema_optimize");     // Catch: Throwable -> L54
        if (r13 != null) goto L9;
    L51:
        Object r14 = null;
    L52:
        Object r15 = Result.constructor-impl(r14);     // Catch: Throwable -> L54
    L56:
        Throwable r16 = Result.exceptionOrNull-impl(r15);     // Catch: Throwable -> L160
        if (r16 == null) goto L60;
        EnsureManager.ensureNotReachHere(r16);     // Catch: Throwable -> L160
    L60:
        if (Result.isFailure-impl(r15) == false) goto L63;
        r15 = null;
    L63:
        if ((r15 instanceof Integer) == true) goto L65;
        r15 = null;
    L65:
        Object r17 = (Integer) r15;     // Catch: Throwable -> L160
        if (r17 != null) goto L72;
        Object r18 = d.a.get("ab_order_schema_optimize");     // Catch: Throwable -> L160
        if ((r18 instanceof Integer) == true) goto L71;
        r18 = null;
    L71:
        r17 = (Integer) r18;     // Catch: Throwable -> L160
    L72:
        if (r17 != null) goto L170;
        int r19 = c.a;     // Catch: Throwable -> L160
        Object r20 = d.c.get("ab_order_schema_optimize");     // Catch: Throwable -> L124
        if (r20 != null) goto L79;
    L121:
        Object r21 = null;
    L122:
        Object r22 = Result.constructor-impl(r21);     // Catch: Throwable -> L124
    L126:
        Throwable r23 = Result.exceptionOrNull-impl(r22);     // Catch: Throwable -> L150
        if (r23 == null) goto L130;
        EnsureManager.ensureNotReachHere(r23);     // Catch: Throwable -> L150
    L130:
        if (Result.isFailure-impl(r22) == false) goto L133;
        r22 = null;
    L133:
        if ((r22 instanceof Integer) == true) goto L135;
        r22 = null;
    L135:
        r17 = (Integer) r22;     // Catch: Throwable -> L150
        if (r17 != null) goto L158;
        IHybridHostService r24 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L150
        if (r24 == null) goto L141;
        Object r25 = r24.getHostABValue("ab_order_schema_optimize", r1);     // Catch: Throwable -> L150
    L142:
        if (r25 != null) goto L144;
    L149:
        r17 = r1;
        goto L158
    L144:
        if ((r25 instanceof Integer) == false) goto L147;
        r12 = r25;
    L147:
        Object r26 = (Integer) r12;     // Catch: Throwable -> L150
        if (r26 == null) goto L149;
    L157:
        r17 = r26;
        goto L158
    L141:
        r25 = null;
    L158:
        d.d("ab_order_schema_optimize", r17);     // Catch: Throwable -> L160
        goto L170
    L79:
        if ((r20 instanceof Integer) == true) goto L81;
        Object r27 = null;
    L82:
        r21 = (Integer) r27;     // Catch: Throwable -> L124
        if (r21 != null) goto L122;
        if ((r20 instanceof Number) == false) goto L109;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L94;
        Float r28 = Float.valueOf(((Number) r20).floatValue());     // Catch: Throwable -> L124
        if ((r28 instanceof Integer) == true) goto L92;
        r28 = null;
    L92:
        r21 = (Integer) r28;     // Catch: Throwable -> L124
        goto L122
    L94:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L100;
        Double r29 = Double.valueOf(((Number) r20).doubleValue());     // Catch: Throwable -> L124
        if ((r29 instanceof Integer) == true) goto L98;
        r29 = null;
    L98:
        r21 = (Integer) r29;     // Catch: Throwable -> L124
        goto L122
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L103;
        r21 = Integer.valueOf(((Number) r20).intValue());     // Catch: Throwable -> L124
        goto L122
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L109;
        Long r30 = Long.valueOf(((Number) r20).longValue());     // Catch: Throwable -> L124
        if ((r30 instanceof Integer) == true) goto L107;
        r30 = null;
    L107:
        r21 = (Integer) r30;     // Catch: Throwable -> L124
    L109:
        if ((r20 instanceof JSONObject) == false) goto L111;
    L180:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L117
        Object r31 = SDKSettingsCacheManager.a().fromJson(r20.toString(), Integer.class);     // Catch: Throwable -> L117
        if ((r31 instanceof Integer) == true) goto L115;
        r31 = null;
    L115:
        Object r32 = Result.constructor-impl((Integer) r31);     // Catch: Throwable -> L117
    L119:
        r21 = r32;
        if (Result.isFailure-impl(r21) == false) goto L122;
    L117:
        th = move-exception;
        Result.Companion r33 = Result.Companion;     // Catch: Throwable -> L124
        r32 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L124
        goto L119
    L111:
        if ((r20 instanceof JSONArray) == false) goto L121;
    L81:
        r27 = r20;
    L150:
        th = move-exception;
        Result.Companion r34 = Result.Companion;     // Catch: Throwable -> L160
        r26 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L160
        Throwable r35 = Result.exceptionOrNull-impl(r26);     // Catch: Throwable -> L160
        if (r35 == null) goto L155;
        EnsureManager.ensureNotReachHere(r35);     // Catch: Throwable -> L160
    L155:
        if (Result.isFailure-impl(r26) == false) goto L157;
        r26 = r1;
    L124:
        th = move-exception;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L150
        r22 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L150
    L170:
        return ((Number) r17).intValue();
    L9:
        if ((r13 instanceof Integer) == true) goto L11;
        Object r37 = null;
    L12:
        r14 = (Integer) r37;     // Catch: Throwable -> L54
        if (r14 != null) goto L52;
        if ((r13 instanceof Number) == false) goto L39;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L24;
        Float r38 = Float.valueOf(((Number) r13).floatValue());     // Catch: Throwable -> L54
        if ((r38 instanceof Integer) == true) goto L22;
        r38 = null;
    L22:
        r14 = (Integer) r38;     // Catch: Throwable -> L54
        goto L52
    L24:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L30;
        Double r39 = Double.valueOf(((Number) r13).doubleValue());     // Catch: Throwable -> L54
        if ((r39 instanceof Integer) == true) goto L28;
        r39 = null;
    L28:
        r14 = (Integer) r39;     // Catch: Throwable -> L54
        goto L52
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L33;
        r14 = Integer.valueOf(((Number) r13).intValue());     // Catch: Throwable -> L54
        goto L52
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L39;
        Long r40 = Long.valueOf(((Number) r13).longValue());     // Catch: Throwable -> L54
        if ((r40 instanceof Integer) == true) goto L37;
        r40 = null;
    L37:
        r14 = (Integer) r40;     // Catch: Throwable -> L54
    L39:
        if ((r13 instanceof JSONObject) == false) goto L41;
    L178:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L47
        Object r41 = SDKSettingsCacheManager.a().fromJson(r13.toString(), Integer.class);     // Catch: Throwable -> L47
        if ((r41 instanceof Integer) == true) goto L45;
        r41 = null;
    L45:
        Object r42 = Result.constructor-impl((Integer) r41);     // Catch: Throwable -> L47
    L49:
        r14 = r42;
        if (Result.isFailure-impl(r14) == false) goto L52;
    L47:
        th = move-exception;
        Result.Companion r43 = Result.Companion;     // Catch: Throwable -> L54
        r42 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L54
        goto L49
    L41:
        if ((r13 instanceof JSONArray) == false) goto L51;
    L11:
        r37 = r13;
    L54:
        th = move-exception;
        Result.Companion r44 = Result.Companion;     // Catch: Throwable -> L160
        r15 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L160
    L160:
        th = move-exception;
        Result.Companion r45 = Result.Companion;
        Object r46 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r47 = Result.exceptionOrNull-impl(r46);
        if (r47 == null) goto L165;
        EnsureManager.ensureNotReachHere(r47);
    L165:
        if (Result.isFailure-impl(r46) == true) goto L168;
        r1 = r46;
    L168:
        r17 = r1;
        goto L170
    }

    static {
    }
}
