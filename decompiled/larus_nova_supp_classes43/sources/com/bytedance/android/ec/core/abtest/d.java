package com.bytedance.android.ec.core.abtest;

import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.hybrid.hostapi.IECHybridKevaService;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.dataplatform.config.SettingPanel;
import com.bytedance.services.apm.api.EnsureManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d {
    public static final d a = null;

    public d() {
    }

    static {
        a = new d();
    }

    @SettingPanel("SaaS余额兑券")
    public static final int A() {
        int r0 = j.a;
        Object r1 = 0;
        int r10 = com.bytedance.android.ec.base.settings.b.a;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L166
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L166
        SDKSettingsCacheManager r12 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L166
        Object r13 = null;
        r12.getClass();     // Catch: Throwable -> L56
        Object r14 = SDKSettingsCacheManager.b.get("iesec_saas_balance_exchange");     // Catch: Throwable -> L56
        if (r14 != null) goto L11;
    L53:
        Object r15 = null;
    L54:
        Object r16 = Result.constructor-impl(r15);     // Catch: Throwable -> L56
    L58:
        Throwable r17 = Result.exceptionOrNull-impl(r16);     // Catch: Throwable -> L166
        if (r17 == null) goto L62;
        EnsureManager.ensureNotReachHere(r17);     // Catch: Throwable -> L166
    L62:
        if (Result.isFailure-impl(r16) == false) goto L65;
        r16 = null;
    L65:
        if ((r16 instanceof Integer) == true) goto L67;
        r16 = null;
    L67:
        Object r18 = (Integer) r16;     // Catch: Throwable -> L166
        if (r18 != null) goto L74;
        r12.getClass();     // Catch: Throwable -> L166
        Object r19 = SDKSettingsCacheManager.a.get("iesec_saas_balance_exchange");     // Catch: Throwable -> L166
        if ((r19 instanceof Integer) == true) goto L73;
        r19 = null;
    L73:
        r18 = (Integer) r19;     // Catch: Throwable -> L166
    L74:
        if (r18 != null) goto L176;
        int r20 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L166
    L153:
        th = move-exception;
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L166
        Object r22 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L156:
        if (Result.exceptionOrNull-impl(r22) != null) goto L183;
    L163:
        r18 = r22;
    L164:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L166
        SDKSettingsCacheManager.e("iesec_saas_balance_exchange", r18);     // Catch: Throwable -> L166
        goto L176
    L183:
        r22 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_saas_balance_exchange", Integer.class, r1);     // Catch: Throwable -> L160
    L161:
        if (r22 != null) goto L163;
        r18 = r1;
    L160:
        r22 = r1;
        goto L161
    L189:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L127
        Object r23 = SDKSettingsCacheManager.b.get("iesec_saas_balance_exchange");     // Catch: Throwable -> L127
        if (r23 != null) goto L82;
    L124:
        Object r24 = null;
    L125:
        Object r25 = Result.constructor-impl(r24);     // Catch: Throwable -> L127
    L129:
        Throwable r26 = Result.exceptionOrNull-impl(r25);     // Catch: Throwable -> L153
        if (r26 == null) goto L133;
        EnsureManager.ensureNotReachHere(r26);     // Catch: Throwable -> L153
    L133:
        if (Result.isFailure-impl(r25) == false) goto L136;
        r25 = null;
    L136:
        if ((r25 instanceof Integer) == true) goto L138;
        r25 = null;
    L138:
        Integer r27 = (Integer) r25;     // Catch: Throwable -> L153
        if (r27 == null) goto L141;
        r18 = r27;
        goto L164
    L141:
        jj4.b r28 = jj4.b.b;     // Catch: Throwable -> L153
        Object r29 = jj4.a.a("iesec_saas_balance_exchange", Integer.class, r1, false);     // Catch: Throwable -> L153
        if (r29 != null) goto L145;
        Intrinsics.throwNpe();     // Catch: Throwable -> L153
    L145:
        if ((r29 instanceof Integer) == false) goto L148;
        r13 = r29;
    L148:
        Object r30 = (Integer) r13;     // Catch: Throwable -> L153
        if (r30 != null) goto L151;
        r30 = r1;
    L151:
        r22 = Result.constructor-impl(r30);     // Catch: Throwable -> L153
    L82:
        if ((r23 instanceof Integer) == true) goto L84;
        Object r31 = null;
    L85:
        r24 = (Integer) r31;     // Catch: Throwable -> L127
        if (r24 != null) goto L125;
        if ((r23 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r32 = Float.valueOf(((Number) r23).floatValue());     // Catch: Throwable -> L127
        if ((r32 instanceof Integer) == true) goto L95;
        r32 = null;
    L95:
        r24 = (Integer) r32;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r33 = Double.valueOf(((Number) r23).doubleValue());     // Catch: Throwable -> L127
        if ((r33 instanceof Integer) == true) goto L101;
        r33 = null;
    L101:
        r24 = (Integer) r33;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r24 = Integer.valueOf(((Number) r23).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r34 = Long.valueOf(((Number) r23).longValue());     // Catch: Throwable -> L127
        if ((r34 instanceof Integer) == true) goto L110;
        r34 = null;
    L110:
        r24 = (Integer) r34;     // Catch: Throwable -> L127
    L112:
        if ((r23 instanceof JSONObject) == false) goto L114;
    L181:
        Object r35 = SDKSettingsCacheManager.a().fromJson(r23.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r35 instanceof Integer) == true) goto L118;
        r35 = null;
    L118:
        Object r36 = Result.constructor-impl((Integer) r35);     // Catch: Throwable -> L120
    L122:
        r24 = r36;
        if (Result.isFailure-impl(r24) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L127
        r36 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r23 instanceof JSONArray) == false) goto L124;
    L84:
        r31 = r23;
    L127:
        th = move-exception;
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L153
        r25 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L153
    L176:
        return ((Number) r18).intValue();
    L11:
        if ((r14 instanceof Integer) == true) goto L13;
        Object r39 = null;
    L14:
        r15 = (Integer) r39;     // Catch: Throwable -> L56
        if (r15 != null) goto L54;
        if ((r14 instanceof Number) == false) goto L41;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r40 = Float.valueOf(((Number) r14).floatValue());     // Catch: Throwable -> L56
        if ((r40 instanceof Integer) == true) goto L24;
        r40 = null;
    L24:
        r15 = (Integer) r40;     // Catch: Throwable -> L56
        goto L54
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r41 = Double.valueOf(((Number) r14).doubleValue());     // Catch: Throwable -> L56
        if ((r41 instanceof Integer) == true) goto L30;
        r41 = null;
    L30:
        r15 = (Integer) r41;     // Catch: Throwable -> L56
        goto L54
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L35;
        r15 = Integer.valueOf(((Number) r14).intValue());     // Catch: Throwable -> L56
        goto L54
    L35:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L41;
        Long r42 = Long.valueOf(((Number) r14).longValue());     // Catch: Throwable -> L56
        if ((r42 instanceof Integer) == true) goto L39;
        r42 = null;
    L39:
        r15 = (Integer) r42;     // Catch: Throwable -> L56
    L41:
        if ((r14 instanceof JSONObject) == false) goto L43;
    L179:
        Object r43 = SDKSettingsCacheManager.a().fromJson(r14.toString(), Integer.class);     // Catch: Throwable -> L49
        if ((r43 instanceof Integer) == true) goto L47;
        r43 = null;
    L47:
        Object r44 = Result.constructor-impl((Integer) r43);     // Catch: Throwable -> L49
    L51:
        r15 = r44;
        if (Result.isFailure-impl(r15) == false) goto L54;
    L49:
        th = move-exception;
        Result.Companion r45 = Result.Companion;     // Catch: Throwable -> L56
        r44 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L56
        goto L51
    L43:
        if ((r14 instanceof JSONArray) == false) goto L53;
    L13:
        r39 = r14;
    L56:
        th = move-exception;
        Result.Companion r46 = Result.Companion;     // Catch: Throwable -> L166
        r16 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L166:
        th = move-exception;
        Result.Companion r47 = Result.Companion;
        Object r48 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r49 = Result.exceptionOrNull-impl(r48);
        if (r49 == null) goto L171;
        EnsureManager.ensureNotReachHere(r49);
    L171:
        if (Result.isFailure-impl(r48) == true) goto L174;
        r1 = r48;
    L174:
        r18 = r1;
        goto L176
    }

    @SettingPanel("SaaS支持讲解回放")
    public static final int B() {
        int r0 = j.a;
        Object r1 = 0;
        int r10 = com.bytedance.android.ec.base.settings.b.a;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L166
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L166
        SDKSettingsCacheManager r12 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L166
        Object r13 = null;
        r12.getClass();     // Catch: Throwable -> L56
        Object r14 = SDKSettingsCacheManager.b.get("iesec_saas_live_replay");     // Catch: Throwable -> L56
        if (r14 != null) goto L11;
    L53:
        Object r15 = null;
    L54:
        Object r16 = Result.constructor-impl(r15);     // Catch: Throwable -> L56
    L58:
        Throwable r17 = Result.exceptionOrNull-impl(r16);     // Catch: Throwable -> L166
        if (r17 == null) goto L62;
        EnsureManager.ensureNotReachHere(r17);     // Catch: Throwable -> L166
    L62:
        if (Result.isFailure-impl(r16) == false) goto L65;
        r16 = null;
    L65:
        if ((r16 instanceof Integer) == true) goto L67;
        r16 = null;
    L67:
        Object r18 = (Integer) r16;     // Catch: Throwable -> L166
        if (r18 != null) goto L74;
        r12.getClass();     // Catch: Throwable -> L166
        Object r19 = SDKSettingsCacheManager.a.get("iesec_saas_live_replay");     // Catch: Throwable -> L166
        if ((r19 instanceof Integer) == true) goto L73;
        r19 = null;
    L73:
        r18 = (Integer) r19;     // Catch: Throwable -> L166
    L74:
        if (r18 != null) goto L176;
        int r20 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L166
    L153:
        th = move-exception;
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L166
        Object r22 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L156:
        if (Result.exceptionOrNull-impl(r22) != null) goto L183;
    L163:
        r18 = r22;
    L164:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L166
        SDKSettingsCacheManager.e("iesec_saas_live_replay", r18);     // Catch: Throwable -> L166
        goto L176
    L183:
        r22 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_saas_live_replay", Integer.class, r1);     // Catch: Throwable -> L160
    L161:
        if (r22 != null) goto L163;
        r18 = r1;
    L160:
        r22 = r1;
        goto L161
    L189:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L127
        Object r23 = SDKSettingsCacheManager.b.get("iesec_saas_live_replay");     // Catch: Throwable -> L127
        if (r23 != null) goto L82;
    L124:
        Object r24 = null;
    L125:
        Object r25 = Result.constructor-impl(r24);     // Catch: Throwable -> L127
    L129:
        Throwable r26 = Result.exceptionOrNull-impl(r25);     // Catch: Throwable -> L153
        if (r26 == null) goto L133;
        EnsureManager.ensureNotReachHere(r26);     // Catch: Throwable -> L153
    L133:
        if (Result.isFailure-impl(r25) == false) goto L136;
        r25 = null;
    L136:
        if ((r25 instanceof Integer) == true) goto L138;
        r25 = null;
    L138:
        Integer r27 = (Integer) r25;     // Catch: Throwable -> L153
        if (r27 == null) goto L141;
        r18 = r27;
        goto L164
    L141:
        jj4.b r28 = jj4.b.b;     // Catch: Throwable -> L153
        Object r29 = jj4.a.a("iesec_saas_live_replay", Integer.class, r1, false);     // Catch: Throwable -> L153
        if (r29 != null) goto L145;
        Intrinsics.throwNpe();     // Catch: Throwable -> L153
    L145:
        if ((r29 instanceof Integer) == false) goto L148;
        r13 = r29;
    L148:
        Object r30 = (Integer) r13;     // Catch: Throwable -> L153
        if (r30 != null) goto L151;
        r30 = r1;
    L151:
        r22 = Result.constructor-impl(r30);     // Catch: Throwable -> L153
    L82:
        if ((r23 instanceof Integer) == true) goto L84;
        Object r31 = null;
    L85:
        r24 = (Integer) r31;     // Catch: Throwable -> L127
        if (r24 != null) goto L125;
        if ((r23 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r32 = Float.valueOf(((Number) r23).floatValue());     // Catch: Throwable -> L127
        if ((r32 instanceof Integer) == true) goto L95;
        r32 = null;
    L95:
        r24 = (Integer) r32;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r33 = Double.valueOf(((Number) r23).doubleValue());     // Catch: Throwable -> L127
        if ((r33 instanceof Integer) == true) goto L101;
        r33 = null;
    L101:
        r24 = (Integer) r33;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r24 = Integer.valueOf(((Number) r23).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r34 = Long.valueOf(((Number) r23).longValue());     // Catch: Throwable -> L127
        if ((r34 instanceof Integer) == true) goto L110;
        r34 = null;
    L110:
        r24 = (Integer) r34;     // Catch: Throwable -> L127
    L112:
        if ((r23 instanceof JSONObject) == false) goto L114;
    L181:
        Object r35 = SDKSettingsCacheManager.a().fromJson(r23.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r35 instanceof Integer) == true) goto L118;
        r35 = null;
    L118:
        Object r36 = Result.constructor-impl((Integer) r35);     // Catch: Throwable -> L120
    L122:
        r24 = r36;
        if (Result.isFailure-impl(r24) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L127
        r36 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r23 instanceof JSONArray) == false) goto L124;
    L84:
        r31 = r23;
    L127:
        th = move-exception;
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L153
        r25 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L153
    L176:
        return ((Number) r18).intValue();
    L11:
        if ((r14 instanceof Integer) == true) goto L13;
        Object r39 = null;
    L14:
        r15 = (Integer) r39;     // Catch: Throwable -> L56
        if (r15 != null) goto L54;
        if ((r14 instanceof Number) == false) goto L41;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r40 = Float.valueOf(((Number) r14).floatValue());     // Catch: Throwable -> L56
        if ((r40 instanceof Integer) == true) goto L24;
        r40 = null;
    L24:
        r15 = (Integer) r40;     // Catch: Throwable -> L56
        goto L54
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r41 = Double.valueOf(((Number) r14).doubleValue());     // Catch: Throwable -> L56
        if ((r41 instanceof Integer) == true) goto L30;
        r41 = null;
    L30:
        r15 = (Integer) r41;     // Catch: Throwable -> L56
        goto L54
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L35;
        r15 = Integer.valueOf(((Number) r14).intValue());     // Catch: Throwable -> L56
        goto L54
    L35:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L41;
        Long r42 = Long.valueOf(((Number) r14).longValue());     // Catch: Throwable -> L56
        if ((r42 instanceof Integer) == true) goto L39;
        r42 = null;
    L39:
        r15 = (Integer) r42;     // Catch: Throwable -> L56
    L41:
        if ((r14 instanceof JSONObject) == false) goto L43;
    L179:
        Object r43 = SDKSettingsCacheManager.a().fromJson(r14.toString(), Integer.class);     // Catch: Throwable -> L49
        if ((r43 instanceof Integer) == true) goto L47;
        r43 = null;
    L47:
        Object r44 = Result.constructor-impl((Integer) r43);     // Catch: Throwable -> L49
    L51:
        r15 = r44;
        if (Result.isFailure-impl(r15) == false) goto L54;
    L49:
        th = move-exception;
        Result.Companion r45 = Result.Companion;     // Catch: Throwable -> L56
        r44 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L56
        goto L51
    L43:
        if ((r14 instanceof JSONArray) == false) goto L53;
    L13:
        r39 = r14;
    L56:
        th = move-exception;
        Result.Companion r46 = Result.Companion;     // Catch: Throwable -> L166
        r16 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L166:
        th = move-exception;
        Result.Companion r47 = Result.Companion;
        Object r48 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r49 = Result.exceptionOrNull-impl(r48);
        if (r49 == null) goto L171;
        EnsureManager.ensureNotReachHere(r49);
    L171:
        if (Result.isFailure-impl(r48) == true) goto L174;
        r1 = r48;
    L174:
        r18 = r1;
        goto L176
    }

    @SettingPanel("SaaS店铺推荐")
    public static final int C() {
        int r0 = j.a;
        Object r1 = 0;
        int r10 = com.bytedance.android.ec.base.settings.b.a;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L166
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L166
        SDKSettingsCacheManager r12 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L166
        Object r13 = null;
        r12.getClass();     // Catch: Throwable -> L56
        Object r14 = SDKSettingsCacheManager.b.get("iesec_saas_shop_recommend");     // Catch: Throwable -> L56
        if (r14 != null) goto L11;
    L53:
        Object r15 = null;
    L54:
        Object r16 = Result.constructor-impl(r15);     // Catch: Throwable -> L56
    L58:
        Throwable r17 = Result.exceptionOrNull-impl(r16);     // Catch: Throwable -> L166
        if (r17 == null) goto L62;
        EnsureManager.ensureNotReachHere(r17);     // Catch: Throwable -> L166
    L62:
        if (Result.isFailure-impl(r16) == false) goto L65;
        r16 = null;
    L65:
        if ((r16 instanceof Integer) == true) goto L67;
        r16 = null;
    L67:
        Object r18 = (Integer) r16;     // Catch: Throwable -> L166
        if (r18 != null) goto L74;
        r12.getClass();     // Catch: Throwable -> L166
        Object r19 = SDKSettingsCacheManager.a.get("iesec_saas_shop_recommend");     // Catch: Throwable -> L166
        if ((r19 instanceof Integer) == true) goto L73;
        r19 = null;
    L73:
        r18 = (Integer) r19;     // Catch: Throwable -> L166
    L74:
        if (r18 != null) goto L176;
        int r20 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L166
    L153:
        th = move-exception;
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L166
        Object r22 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L156:
        if (Result.exceptionOrNull-impl(r22) != null) goto L183;
    L163:
        r18 = r22;
    L164:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L166
        SDKSettingsCacheManager.e("iesec_saas_shop_recommend", r18);     // Catch: Throwable -> L166
        goto L176
    L183:
        r22 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_saas_shop_recommend", Integer.class, r1);     // Catch: Throwable -> L160
    L161:
        if (r22 != null) goto L163;
        r18 = r1;
    L160:
        r22 = r1;
        goto L161
    L189:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L127
        Object r23 = SDKSettingsCacheManager.b.get("iesec_saas_shop_recommend");     // Catch: Throwable -> L127
        if (r23 != null) goto L82;
    L124:
        Object r24 = null;
    L125:
        Object r25 = Result.constructor-impl(r24);     // Catch: Throwable -> L127
    L129:
        Throwable r26 = Result.exceptionOrNull-impl(r25);     // Catch: Throwable -> L153
        if (r26 == null) goto L133;
        EnsureManager.ensureNotReachHere(r26);     // Catch: Throwable -> L153
    L133:
        if (Result.isFailure-impl(r25) == false) goto L136;
        r25 = null;
    L136:
        if ((r25 instanceof Integer) == true) goto L138;
        r25 = null;
    L138:
        Integer r27 = (Integer) r25;     // Catch: Throwable -> L153
        if (r27 == null) goto L141;
        r18 = r27;
        goto L164
    L141:
        jj4.b r28 = jj4.b.b;     // Catch: Throwable -> L153
        Object r29 = jj4.a.a("iesec_saas_shop_recommend", Integer.class, r1, false);     // Catch: Throwable -> L153
        if (r29 != null) goto L145;
        Intrinsics.throwNpe();     // Catch: Throwable -> L153
    L145:
        if ((r29 instanceof Integer) == false) goto L148;
        r13 = r29;
    L148:
        Object r30 = (Integer) r13;     // Catch: Throwable -> L153
        if (r30 != null) goto L151;
        r30 = r1;
    L151:
        r22 = Result.constructor-impl(r30);     // Catch: Throwable -> L153
    L82:
        if ((r23 instanceof Integer) == true) goto L84;
        Object r31 = null;
    L85:
        r24 = (Integer) r31;     // Catch: Throwable -> L127
        if (r24 != null) goto L125;
        if ((r23 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r32 = Float.valueOf(((Number) r23).floatValue());     // Catch: Throwable -> L127
        if ((r32 instanceof Integer) == true) goto L95;
        r32 = null;
    L95:
        r24 = (Integer) r32;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r33 = Double.valueOf(((Number) r23).doubleValue());     // Catch: Throwable -> L127
        if ((r33 instanceof Integer) == true) goto L101;
        r33 = null;
    L101:
        r24 = (Integer) r33;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r24 = Integer.valueOf(((Number) r23).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r34 = Long.valueOf(((Number) r23).longValue());     // Catch: Throwable -> L127
        if ((r34 instanceof Integer) == true) goto L110;
        r34 = null;
    L110:
        r24 = (Integer) r34;     // Catch: Throwable -> L127
    L112:
        if ((r23 instanceof JSONObject) == false) goto L114;
    L181:
        Object r35 = SDKSettingsCacheManager.a().fromJson(r23.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r35 instanceof Integer) == true) goto L118;
        r35 = null;
    L118:
        Object r36 = Result.constructor-impl((Integer) r35);     // Catch: Throwable -> L120
    L122:
        r24 = r36;
        if (Result.isFailure-impl(r24) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L127
        r36 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r23 instanceof JSONArray) == false) goto L124;
    L84:
        r31 = r23;
    L127:
        th = move-exception;
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L153
        r25 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L153
    L176:
        return ((Number) r18).intValue();
    L11:
        if ((r14 instanceof Integer) == true) goto L13;
        Object r39 = null;
    L14:
        r15 = (Integer) r39;     // Catch: Throwable -> L56
        if (r15 != null) goto L54;
        if ((r14 instanceof Number) == false) goto L41;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r40 = Float.valueOf(((Number) r14).floatValue());     // Catch: Throwable -> L56
        if ((r40 instanceof Integer) == true) goto L24;
        r40 = null;
    L24:
        r15 = (Integer) r40;     // Catch: Throwable -> L56
        goto L54
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r41 = Double.valueOf(((Number) r14).doubleValue());     // Catch: Throwable -> L56
        if ((r41 instanceof Integer) == true) goto L30;
        r41 = null;
    L30:
        r15 = (Integer) r41;     // Catch: Throwable -> L56
        goto L54
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L35;
        r15 = Integer.valueOf(((Number) r14).intValue());     // Catch: Throwable -> L56
        goto L54
    L35:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L41;
        Long r42 = Long.valueOf(((Number) r14).longValue());     // Catch: Throwable -> L56
        if ((r42 instanceof Integer) == true) goto L39;
        r42 = null;
    L39:
        r15 = (Integer) r42;     // Catch: Throwable -> L56
    L41:
        if ((r14 instanceof JSONObject) == false) goto L43;
    L179:
        Object r43 = SDKSettingsCacheManager.a().fromJson(r14.toString(), Integer.class);     // Catch: Throwable -> L49
        if ((r43 instanceof Integer) == true) goto L47;
        r43 = null;
    L47:
        Object r44 = Result.constructor-impl((Integer) r43);     // Catch: Throwable -> L49
    L51:
        r15 = r44;
        if (Result.isFailure-impl(r15) == false) goto L54;
    L49:
        th = move-exception;
        Result.Companion r45 = Result.Companion;     // Catch: Throwable -> L56
        r44 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L56
        goto L51
    L43:
        if ((r14 instanceof JSONArray) == false) goto L53;
    L13:
        r39 = r14;
    L56:
        th = move-exception;
        Result.Companion r46 = Result.Companion;     // Catch: Throwable -> L166
        r16 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L166:
        th = move-exception;
        Result.Companion r47 = Result.Companion;
        Object r48 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r49 = Result.exceptionOrNull-impl(r48);
        if (r49 == null) goto L171;
        EnsureManager.ensureNotReachHere(r49);
    L171:
        if (Result.isFailure-impl(r48) == true) goto L174;
        r1 = r48;
    L174:
        r18 = r1;
        goto L176
    }

    @SettingPanel("sku面板选择规格时商详刷新优化-已固化")
    public static final boolean D() {
        jj4.b r0 = jj4.b.b;
        int r1 = e.a;
        Object r10 = jj4.a.a("detail_sku_refresh_opt", Boolean.class, e.a(Boolean.TRUE, Boolean.FALSE), false);
        if (r10 != null) goto L6;
        Intrinsics.throwNpe();
    L6:
        return ((Boolean) r10).booleanValue();
    }

    @SettingPanel("SKU数量加减 最小值支持为0")
    public static final boolean E() {
        jj4.b r0 = jj4.b.b;
        int r1 = e.a;
        Object r10 = jj4.a.a("iesec_sku_count_lower_to_zero", Boolean.class, e.a(Boolean.TRUE, Boolean.FALSE), false);
        if (r10 != null) goto L6;
        Intrinsics.throwNpe();
    L6:
        return ((Boolean) r10).booleanValue();
    }

    @SettingPanel("SKU面板改版一期实验")
    public static final int F() {
        jj4.b r0 = jj4.b.b;
        int r1 = e.a;
        Object r10 = jj4.a.a("iesec_sku_optimize", Integer.class, e.a(5, 0), false);
        if (r10 != null) goto L6;
        Intrinsics.throwNpe();
    L6:
        return ((Number) r10).intValue();
    }

    @SettingPanel("西头直播间讲解卡展示时长优化开关")
    public static final boolean G() {
        jj4.b r0 = jj4.b.b;
        Object r1 = jj4.a.a("iesec_live_card_duration_enable_ab", Integer.class, 0, false);
        if (r1 != null) goto L6;
        Intrinsics.throwNpe();
    L6:
        if (((Number) r1).intValue() != 1) goto L9;
        return true;
    L9:
        return false;
    }

    @SettingPanel("西头直播间讲解卡展示时长优化具体时长")
    public static final long H() {
        jj4.b r0 = jj4.b.b;
        Object r10 = jj4.a.a("iesec_saas_live_card_show_duration", Long.class, 10000L, false);
        if (r10 != null) goto L5;
        Intrinsics.throwNpe();
    L5:
        long r11 = ((Number) r10).longValue();
        if (r11 >= 0) goto L9;
        return r11;
    L9:
        if (r11 < 10000) goto L12;
        return r11 / 1000;
    L12:
        return 10;
    }

    @SettingPanel("商详组件化")
    public static final boolean a() {
        Lazy r0 = ECAppInfoService.a;
        Object r10 = null;
        if (ECAppInfoService.h() == false) goto L5;
    L186:
        int r1 = com.bytedance.android.ec.base.settings.a.a;
        Object r11 = Boolean.FALSE;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L349
        Object r13 = com.bytedance.android.ec.base.settings.d.c.get("ec_pdp_refactor_v2");     // Catch: Throwable -> L240
        if (r13 != null) goto L192;
    L237:
        Object r14 = null;
    L238:
        Object r15 = Result.constructor-impl(r14);     // Catch: Throwable -> L240
    L242:
        Throwable r16 = Result.exceptionOrNull-impl(r15);     // Catch: Throwable -> L349
        if (r16 == null) goto L246;
        EnsureManager.ensureNotReachHere(r16);     // Catch: Throwable -> L349
    L246:
        if (Result.isFailure-impl(r15) == false) goto L249;
        r15 = null;
    L249:
        if ((r15 instanceof Boolean) == true) goto L251;
        r15 = null;
    L251:
        Object r17 = (Boolean) r15;     // Catch: Throwable -> L349
        if (r17 != null) goto L258;
        Object r18 = com.bytedance.android.ec.base.settings.d.a.get("ec_pdp_refactor_v2");     // Catch: Throwable -> L349
        if ((r18 instanceof Boolean) == true) goto L257;
        r18 = null;
    L257:
        r17 = (Boolean) r18;     // Catch: Throwable -> L349
    L258:
        if (r17 != null) goto L359;
        int r19 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L349
        Object r20 = com.bytedance.android.ec.base.settings.d.c.get("ec_pdp_refactor_v2");     // Catch: Throwable -> L313
        if (r20 != null) goto L265;
    L310:
        Object r21 = null;
    L311:
        Object r22 = Result.constructor-impl(r21);     // Catch: Throwable -> L313
    L315:
        Throwable r23 = Result.exceptionOrNull-impl(r22);     // Catch: Throwable -> L339
        if (r23 == null) goto L319;
        EnsureManager.ensureNotReachHere(r23);     // Catch: Throwable -> L339
    L319:
        if (Result.isFailure-impl(r22) == false) goto L322;
        r22 = null;
    L322:
        if ((r22 instanceof Boolean) == true) goto L324;
        r22 = null;
    L324:
        r17 = (Boolean) r22;     // Catch: Throwable -> L339
        if (r17 != null) goto L347;
        IHybridHostService r24 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L339
        if (r24 == null) goto L330;
        Object r25 = r24.getHostABValue("ec_pdp_refactor_v2", r11);     // Catch: Throwable -> L339
    L331:
        if (r25 != null) goto L333;
    L345:
        r17 = r11;
        goto L347
    L333:
        if ((r25 instanceof Boolean) == false) goto L336;
        r10 = r25;
    L336:
        Object r26 = (Boolean) r10;     // Catch: Throwable -> L339
        if (r26 == null) goto L345;
    L346:
        r17 = r26;
        goto L347
    L330:
        r25 = null;
    L347:
        com.bytedance.android.ec.base.settings.d.d("ec_pdp_refactor_v2", r17);     // Catch: Throwable -> L349
        goto L359
    L265:
        if ((r20 instanceof Boolean) == true) goto L267;
        Object r27 = null;
    L268:
        r21 = (Boolean) r27;     // Catch: Throwable -> L313
        if (r21 != null) goto L311;
        if ((r20 instanceof Number) == false) goto L298;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L280;
        Float r28 = Float.valueOf(((Number) r20).floatValue());     // Catch: Throwable -> L313
        if ((r28 instanceof Boolean) == true) goto L278;
        r28 = null;
    L278:
        r21 = (Boolean) r28;     // Catch: Throwable -> L313
        goto L311
    L280:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L286;
        Double r29 = Double.valueOf(((Number) r20).doubleValue());     // Catch: Throwable -> L313
        if ((r29 instanceof Boolean) == true) goto L284;
        r29 = null;
    L284:
        r21 = (Boolean) r29;     // Catch: Throwable -> L313
        goto L311
    L286:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L292;
        Integer r30 = Integer.valueOf(((Number) r20).intValue());     // Catch: Throwable -> L313
        if ((r30 instanceof Boolean) == true) goto L290;
        r30 = null;
    L290:
        r21 = (Boolean) r30;     // Catch: Throwable -> L313
        goto L311
    L292:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L298;
        Long r31 = Long.valueOf(((Number) r20).longValue());     // Catch: Throwable -> L313
        if ((r31 instanceof Boolean) == true) goto L296;
        r31 = null;
    L296:
        r21 = (Boolean) r31;     // Catch: Throwable -> L313
    L298:
        if ((r20 instanceof JSONObject) == false) goto L300;
    L362:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L306
        Object r32 = SDKSettingsCacheManager.a().fromJson(r20.toString(), Boolean.class);     // Catch: Throwable -> L306
        if ((r32 instanceof Boolean) == true) goto L304;
        r32 = null;
    L304:
        Object r33 = Result.constructor-impl((Boolean) r32);     // Catch: Throwable -> L306
    L308:
        r21 = r33;
        if (Result.isFailure-impl(r21) == false) goto L311;
    L306:
        th = move-exception;
        Result.Companion r34 = Result.Companion;     // Catch: Throwable -> L313
        r33 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L313
        goto L308
    L300:
        if ((r20 instanceof JSONArray) == false) goto L310;
    L267:
        r27 = r20;
    L339:
        th = move-exception;
        Result.Companion r35 = Result.Companion;     // Catch: Throwable -> L349
        r26 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L349
        Throwable r36 = Result.exceptionOrNull-impl(r26);     // Catch: Throwable -> L349
        if (r36 == null) goto L344;
        EnsureManager.ensureNotReachHere(r36);     // Catch: Throwable -> L349
    L344:
        if (Result.isFailure-impl(r26) == false) goto L346;
    L313:
        th = move-exception;
        Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L339
        r22 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L339
    L359:
        return ((Boolean) r17).booleanValue();
    L192:
        if ((r13 instanceof Boolean) == true) goto L194;
        Object r38 = null;
    L195:
        r14 = (Boolean) r38;     // Catch: Throwable -> L240
        if (r14 != null) goto L238;
        if ((r13 instanceof Number) == false) goto L225;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L207;
        Float r39 = Float.valueOf(((Number) r13).floatValue());     // Catch: Throwable -> L240
        if ((r39 instanceof Boolean) == true) goto L205;
        r39 = null;
    L205:
        r14 = (Boolean) r39;     // Catch: Throwable -> L240
        goto L238
    L207:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L213;
        Double r40 = Double.valueOf(((Number) r13).doubleValue());     // Catch: Throwable -> L240
        if ((r40 instanceof Boolean) == true) goto L211;
        r40 = null;
    L211:
        r14 = (Boolean) r40;     // Catch: Throwable -> L240
        goto L238
    L213:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L219;
        Integer r41 = Integer.valueOf(((Number) r13).intValue());     // Catch: Throwable -> L240
        if ((r41 instanceof Boolean) == true) goto L217;
        r41 = null;
    L217:
        r14 = (Boolean) r41;     // Catch: Throwable -> L240
        goto L238
    L219:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L225;
        Long r42 = Long.valueOf(((Number) r13).longValue());     // Catch: Throwable -> L240
        if ((r42 instanceof Boolean) == true) goto L223;
        r42 = null;
    L223:
        r14 = (Boolean) r42;     // Catch: Throwable -> L240
    L225:
        if ((r13 instanceof JSONObject) == false) goto L227;
    L380:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L233
        Object r43 = SDKSettingsCacheManager.a().fromJson(r13.toString(), Boolean.class);     // Catch: Throwable -> L233
        if ((r43 instanceof Boolean) == true) goto L231;
        r43 = null;
    L231:
        Object r44 = Result.constructor-impl((Boolean) r43);     // Catch: Throwable -> L233
    L235:
        r14 = r44;
        if (Result.isFailure-impl(r14) == false) goto L238;
    L233:
        th = move-exception;
        Result.Companion r45 = Result.Companion;     // Catch: Throwable -> L240
        r44 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L240
        goto L235
    L227:
        if ((r13 instanceof JSONArray) == false) goto L237;
    L194:
        r38 = r13;
    L240:
        th = move-exception;
        Result.Companion r46 = Result.Companion;     // Catch: Throwable -> L349
        r15 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L349
    L349:
        th = move-exception;
        Result.Companion r47 = Result.Companion;
        Object r48 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r49 = Result.exceptionOrNull-impl(r48);
        if (r49 == null) goto L354;
        EnsureManager.ensureNotReachHere(r49);
    L354:
        if (Result.isFailure-impl(r48) == true) goto L357;
        r11 = r48;
    L357:
        r17 = r11;
        goto L359
    L5:
        if (ECAppInfoService.k() == true) goto L186;
        if (ECAppInfoService.m() == true) goto L186;
        int r50 = com.bytedance.android.ec.base.settings.b.a;
        Object r51 = Boolean.FALSE;
        Result.Companion r52 = Result.Companion;     // Catch: Throwable -> L176
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L176
        SDKSettingsCacheManager r53 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L176
        r53.getClass();     // Catch: Throwable -> L63
        Object r54 = SDKSettingsCacheManager.b.get("ec_pdp_refactor_v2");     // Catch: Throwable -> L63
        if (r54 != null) goto L15;
    L60:
        Object r55 = null;
    L61:
        Object r56 = Result.constructor-impl(r55);     // Catch: Throwable -> L63
    L65:
        Throwable r57 = Result.exceptionOrNull-impl(r56);     // Catch: Throwable -> L176
        if (r57 == null) goto L69;
        EnsureManager.ensureNotReachHere(r57);     // Catch: Throwable -> L176
    L69:
        if (Result.isFailure-impl(r56) == false) goto L72;
        r56 = null;
    L72:
        if ((r56 instanceof Boolean) == true) goto L74;
        r56 = null;
    L74:
        Object r58 = (Boolean) r56;     // Catch: Throwable -> L176
        if (r58 != null) goto L81;
        r53.getClass();     // Catch: Throwable -> L176
        Object r59 = SDKSettingsCacheManager.a.get("ec_pdp_refactor_v2");     // Catch: Throwable -> L176
        if ((r59 instanceof Boolean) == true) goto L80;
        r59 = null;
    L80:
        r58 = (Boolean) r59;     // Catch: Throwable -> L176
    L81:
        if (r58 != null) goto L385;
        int r60 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L176
    L163:
        th = move-exception;
        Result.Companion r61 = Result.Companion;     // Catch: Throwable -> L176
        Object r62 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L176
    L165:
        Object r63 = r62;
        if (Result.exceptionOrNull-impl(r63) != null) goto L366;
    L173:
        r58 = r63;
    L174:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L176
        SDKSettingsCacheManager.e("ec_pdp_refactor_v2", r58);     // Catch: Throwable -> L176
        goto L385
    L366:
        r63 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_pdp_refactor_v2", Boolean.class, r51);     // Catch: Throwable -> L170
    L171:
        if (r63 != null) goto L173;
        r58 = r51;
    L170:
        r63 = r51;
        goto L171
    L383:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L137
        Object r64 = SDKSettingsCacheManager.b.get("ec_pdp_refactor_v2");     // Catch: Throwable -> L137
        if (r64 != null) goto L89;
    L134:
        Object r65 = null;
    L135:
        Object r66 = Result.constructor-impl(r65);     // Catch: Throwable -> L137
    L139:
        Throwable r67 = Result.exceptionOrNull-impl(r66);     // Catch: Throwable -> L163
        if (r67 == null) goto L143;
        EnsureManager.ensureNotReachHere(r67);     // Catch: Throwable -> L163
    L143:
        if (Result.isFailure-impl(r66) == false) goto L146;
        r66 = null;
    L146:
        if ((r66 instanceof Boolean) == true) goto L148;
        r66 = null;
    L148:
        r63 = (Boolean) r66;     // Catch: Throwable -> L163
        if (r63 != null) goto L173;
        jj4.b r68 = jj4.b.b;     // Catch: Throwable -> L163
        Object r69 = jj4.a.a("ec_pdp_refactor_v2", Boolean.class, r51, false);     // Catch: Throwable -> L163
        if (r69 != null) goto L155;
        Intrinsics.throwNpe();     // Catch: Throwable -> L163
    L155:
        if ((r69 instanceof Boolean) == false) goto L158;
        r10 = r69;
    L158:
        Object r70 = (Boolean) r10;     // Catch: Throwable -> L163
        if (r70 != null) goto L161;
        r70 = r51;
    L161:
        r62 = Result.constructor-impl(r70);     // Catch: Throwable -> L163
    L89:
        if ((r64 instanceof Boolean) == true) goto L91;
        Object r71 = null;
    L92:
        r65 = (Boolean) r71;     // Catch: Throwable -> L137
        if (r65 != null) goto L135;
        if ((r64 instanceof Number) == false) goto L122;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L104;
        Float r72 = Float.valueOf(((Number) r64).floatValue());     // Catch: Throwable -> L137
        if ((r72 instanceof Boolean) == true) goto L102;
        r72 = null;
    L102:
        r65 = (Boolean) r72;     // Catch: Throwable -> L137
        goto L135
    L104:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L110;
        Double r73 = Double.valueOf(((Number) r64).doubleValue());     // Catch: Throwable -> L137
        if ((r73 instanceof Boolean) == true) goto L108;
        r73 = null;
    L108:
        r65 = (Boolean) r73;     // Catch: Throwable -> L137
        goto L135
    L110:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L116;
        Integer r74 = Integer.valueOf(((Number) r64).intValue());     // Catch: Throwable -> L137
        if ((r74 instanceof Boolean) == true) goto L114;
        r74 = null;
    L114:
        r65 = (Boolean) r74;     // Catch: Throwable -> L137
        goto L135
    L116:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L122;
        Long r75 = Long.valueOf(((Number) r64).longValue());     // Catch: Throwable -> L137
        if ((r75 instanceof Boolean) == true) goto L120;
        r75 = null;
    L120:
        r65 = (Boolean) r75;     // Catch: Throwable -> L137
    L122:
        if ((r64 instanceof JSONObject) == false) goto L124;
    L364:
        Object r76 = SDKSettingsCacheManager.a().fromJson(r64.toString(), Boolean.class);     // Catch: Throwable -> L130
        if ((r76 instanceof Boolean) == true) goto L128;
        r76 = null;
    L128:
        Object r77 = Result.constructor-impl((Boolean) r76);     // Catch: Throwable -> L130
    L132:
        r65 = r77;
        if (Result.isFailure-impl(r65) == false) goto L135;
    L130:
        th = move-exception;
        Result.Companion r78 = Result.Companion;     // Catch: Throwable -> L137
        r77 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L137
        goto L132
    L124:
        if ((r64 instanceof JSONArray) == false) goto L134;
    L91:
        r71 = r64;
    L137:
        th = move-exception;
        Result.Companion r79 = Result.Companion;     // Catch: Throwable -> L163
        r66 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
    L385:
        return ((Boolean) r58).booleanValue();
    L15:
        if ((r54 instanceof Boolean) == true) goto L17;
        Object r80 = null;
    L18:
        r55 = (Boolean) r80;     // Catch: Throwable -> L63
        if (r55 != null) goto L61;
        if ((r54 instanceof Number) == false) goto L48;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L30;
        Float r81 = Float.valueOf(((Number) r54).floatValue());     // Catch: Throwable -> L63
        if ((r81 instanceof Boolean) == true) goto L28;
        r81 = null;
    L28:
        r55 = (Boolean) r81;     // Catch: Throwable -> L63
        goto L61
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L36;
        Double r82 = Double.valueOf(((Number) r54).doubleValue());     // Catch: Throwable -> L63
        if ((r82 instanceof Boolean) == true) goto L34;
        r82 = null;
    L34:
        r55 = (Boolean) r82;     // Catch: Throwable -> L63
        goto L61
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L42;
        Integer r83 = Integer.valueOf(((Number) r54).intValue());     // Catch: Throwable -> L63
        if ((r83 instanceof Boolean) == true) goto L40;
        r83 = null;
    L40:
        r55 = (Boolean) r83;     // Catch: Throwable -> L63
        goto L61
    L42:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L48;
        Long r84 = Long.valueOf(((Number) r54).longValue());     // Catch: Throwable -> L63
        if ((r84 instanceof Boolean) == true) goto L46;
        r84 = null;
    L46:
        r55 = (Boolean) r84;     // Catch: Throwable -> L63
    L48:
        if ((r54 instanceof JSONObject) == false) goto L50;
    L378:
        Object r85 = SDKSettingsCacheManager.a().fromJson(r54.toString(), Boolean.class);     // Catch: Throwable -> L56
        if ((r85 instanceof Boolean) == true) goto L54;
        r85 = null;
    L54:
        Object r86 = Result.constructor-impl((Boolean) r85);     // Catch: Throwable -> L56
    L58:
        r55 = r86;
        if (Result.isFailure-impl(r55) == false) goto L61;
    L56:
        th = move-exception;
        Result.Companion r87 = Result.Companion;     // Catch: Throwable -> L63
        r86 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L63
        goto L58
    L50:
        if ((r54 instanceof JSONArray) == false) goto L60;
    L17:
        r80 = r54;
    L63:
        th = move-exception;
        Result.Companion r88 = Result.Companion;     // Catch: Throwable -> L176
        r56 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L176
    L176:
        th = move-exception;
        Result.Companion r89 = Result.Companion;
        Object r90 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r91 = Result.exceptionOrNull-impl(r90);
        if (r91 == null) goto L181;
        EnsureManager.ensureNotReachHere(r91);
    L181:
        if (Result.isFailure-impl(r90) == true) goto L184;
        r51 = r90;
    L184:
        r58 = r51;
        goto L385
    }

    @SettingPanel("事件链支持 action_map")
    public static final boolean b() {
        int r0 = com.bytedance.android.ec.base.settings.b.a;
        Object r1 = Boolean.TRUE;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r11 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L172
        Object r12 = null;
        r11.getClass();     // Catch: Throwable -> L59
        Object r13 = SDKSettingsCacheManager.b.get("ec_event_chain_supplement");     // Catch: Throwable -> L59
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
        Object r18 = SDKSettingsCacheManager.a.get("ec_event_chain_supplement");     // Catch: Throwable -> L172
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
        SDKSettingsCacheManager.e("ec_event_chain_supplement", r17);     // Catch: Throwable -> L172
        goto L182
    L185:
        r21 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_event_chain_supplement", Boolean.class, r1);     // Catch: Throwable -> L166
    L167:
        if (r21 != null) goto L169;
        r17 = r1;
    L166:
        r21 = r1;
        goto L167
    L191:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L133
        Object r22 = SDKSettingsCacheManager.b.get("ec_event_chain_supplement");     // Catch: Throwable -> L133
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
        Object r27 = jj4.a.a("ec_event_chain_supplement", Boolean.class, r1, false);     // Catch: Throwable -> L159
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

    @SettingPanel("商详容器滚动优化-已固化")
    public static final boolean c() {
        int r0 = j.a;
        int r1 = e.a;
        Object r10 = e.a(Boolean.TRUE, Boolean.FALSE);
        int r11 = com.bytedance.android.ec.base.settings.b.a;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r13 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L172
        Object r14 = null;
        r13.getClass();     // Catch: Throwable -> L59
        Object r15 = SDKSettingsCacheManager.b.get("ec_pdp_container_scroll_opt");     // Catch: Throwable -> L59
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
        if ((r17 instanceof Boolean) == true) goto L70;
        r17 = null;
    L70:
        Object r19 = (Boolean) r17;     // Catch: Throwable -> L172
        if (r19 != null) goto L77;
        r13.getClass();     // Catch: Throwable -> L172
        Object r20 = SDKSettingsCacheManager.a.get("ec_pdp_container_scroll_opt");     // Catch: Throwable -> L172
        if ((r20 instanceof Boolean) == true) goto L76;
        r20 = null;
    L76:
        r19 = (Boolean) r20;     // Catch: Throwable -> L172
    L77:
        if (r19 != null) goto L182;
        int r21 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L172
    L159:
        th = move-exception;
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L172
        Object r23 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L172
    L162:
        if (Result.exceptionOrNull-impl(r23) != null) goto L191;
    L169:
        r19 = r23;
    L170:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L172
        SDKSettingsCacheManager.e("ec_pdp_container_scroll_opt", r19);     // Catch: Throwable -> L172
        goto L182
    L191:
        r23 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_pdp_container_scroll_opt", Boolean.class, r10);     // Catch: Throwable -> L166
    L167:
        if (r23 != null) goto L169;
        r19 = r10;
    L166:
        r23 = r10;
        goto L167
    L183:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L133
        Object r24 = SDKSettingsCacheManager.b.get("ec_pdp_container_scroll_opt");     // Catch: Throwable -> L133
        if (r24 != null) goto L85;
    L130:
        Object r25 = null;
    L131:
        Object r26 = Result.constructor-impl(r25);     // Catch: Throwable -> L133
    L135:
        Throwable r27 = Result.exceptionOrNull-impl(r26);     // Catch: Throwable -> L159
        if (r27 == null) goto L139;
        EnsureManager.ensureNotReachHere(r27);     // Catch: Throwable -> L159
    L139:
        if (Result.isFailure-impl(r26) == false) goto L142;
        r26 = null;
    L142:
        if ((r26 instanceof Boolean) == true) goto L144;
        r26 = null;
    L144:
        r23 = (Boolean) r26;     // Catch: Throwable -> L159
        if (r23 != null) goto L169;
        jj4.b r28 = jj4.b.b;     // Catch: Throwable -> L159
        Object r29 = jj4.a.a("ec_pdp_container_scroll_opt", Boolean.class, r10, false);     // Catch: Throwable -> L159
        if (r29 != null) goto L151;
        Intrinsics.throwNpe();     // Catch: Throwable -> L159
    L151:
        if ((r29 instanceof Boolean) == false) goto L154;
        r14 = r29;
    L154:
        Object r30 = (Boolean) r14;     // Catch: Throwable -> L159
        if (r30 != null) goto L157;
        r30 = r10;
    L157:
        r23 = Result.constructor-impl(r30);     // Catch: Throwable -> L159
    L85:
        if ((r24 instanceof Boolean) == true) goto L87;
        Object r31 = null;
    L88:
        r25 = (Boolean) r31;     // Catch: Throwable -> L133
        if (r25 != null) goto L131;
        if ((r24 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r32 = Float.valueOf(((Number) r24).floatValue());     // Catch: Throwable -> L133
        if ((r32 instanceof Boolean) == true) goto L98;
        r32 = null;
    L98:
        r25 = (Boolean) r32;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r33 = Double.valueOf(((Number) r24).doubleValue());     // Catch: Throwable -> L133
        if ((r33 instanceof Boolean) == true) goto L104;
        r33 = null;
    L104:
        r25 = (Boolean) r33;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r34 = Integer.valueOf(((Number) r24).intValue());     // Catch: Throwable -> L133
        if ((r34 instanceof Boolean) == true) goto L110;
        r34 = null;
    L110:
        r25 = (Boolean) r34;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r35 = Long.valueOf(((Number) r24).longValue());     // Catch: Throwable -> L133
        if ((r35 instanceof Boolean) == true) goto L116;
        r35 = null;
    L116:
        r25 = (Boolean) r35;     // Catch: Throwable -> L133
    L118:
        if ((r24 instanceof JSONObject) == false) goto L120;
    L189:
        Object r36 = SDKSettingsCacheManager.a().fromJson(r24.toString(), Boolean.class);     // Catch: Throwable -> L126
        if ((r36 instanceof Boolean) == true) goto L124;
        r36 = null;
    L124:
        Object r37 = Result.constructor-impl((Boolean) r36);     // Catch: Throwable -> L126
    L128:
        r25 = r37;
        if (Result.isFailure-impl(r25) == false) goto L131;
    L126:
        th = move-exception;
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L133
        r37 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L133
        goto L128
    L120:
        if ((r24 instanceof JSONArray) == false) goto L130;
    L87:
        r31 = r24;
    L133:
        th = move-exception;
        Result.Companion r39 = Result.Companion;     // Catch: Throwable -> L159
        r26 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L159
    L182:
        return ((Boolean) r19).booleanValue();
    L11:
        if ((r15 instanceof Boolean) == true) goto L13;
        Object r40 = null;
    L14:
        r16 = (Boolean) r40;     // Catch: Throwable -> L59
        if (r16 != null) goto L57;
        if ((r15 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r41 = Float.valueOf(((Number) r15).floatValue());     // Catch: Throwable -> L59
        if ((r41 instanceof Boolean) == true) goto L24;
        r41 = null;
    L24:
        r16 = (Boolean) r41;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r42 = Double.valueOf(((Number) r15).doubleValue());     // Catch: Throwable -> L59
        if ((r42 instanceof Boolean) == true) goto L30;
        r42 = null;
    L30:
        r16 = (Boolean) r42;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r43 = Integer.valueOf(((Number) r15).intValue());     // Catch: Throwable -> L59
        if ((r43 instanceof Boolean) == true) goto L36;
        r43 = null;
    L36:
        r16 = (Boolean) r43;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r44 = Long.valueOf(((Number) r15).longValue());     // Catch: Throwable -> L59
        if ((r44 instanceof Boolean) == true) goto L42;
        r44 = null;
    L42:
        r16 = (Boolean) r44;     // Catch: Throwable -> L59
    L44:
        if ((r15 instanceof JSONObject) == false) goto L46;
    L195:
        Object r45 = SDKSettingsCacheManager.a().fromJson(r15.toString(), Boolean.class);     // Catch: Throwable -> L52
        if ((r45 instanceof Boolean) == true) goto L50;
        r45 = null;
    L50:
        Object r46 = Result.constructor-impl((Boolean) r45);     // Catch: Throwable -> L52
    L54:
        r16 = r46;
        if (Result.isFailure-impl(r16) == false) goto L57;
    L52:
        th = move-exception;
        Result.Companion r47 = Result.Companion;     // Catch: Throwable -> L59
        r46 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L59
        goto L54
    L46:
        if ((r15 instanceof JSONArray) == false) goto L56;
    L13:
        r40 = r15;
    L59:
        th = move-exception;
        Result.Companion r48 = Result.Companion;     // Catch: Throwable -> L172
        r17 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L172
    L172:
        th = move-exception;
        Result.Companion r49 = Result.Companion;
        Object r50 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r51 = Result.exceptionOrNull-impl(r50);
        if (r51 == null) goto L177;
        EnsureManager.ensureNotReachHere(r51);
    L177:
        if (Result.isFailure-impl(r50) == true) goto L180;
        r10 = r50;
    L180:
        r19 = r10;
        goto L182
    }

    @SettingPanel("商详预加载开关")
    public static final int d() {
        int r0 = j.a;
        Object r1 = 0;
        int r10 = com.bytedance.android.ec.base.settings.b.a;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L166
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L166
        SDKSettingsCacheManager r12 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L166
        Object r13 = null;
        r12.getClass();     // Catch: Throwable -> L56
        Object r14 = SDKSettingsCacheManager.b.get("iesec_pdp_enable_preload");     // Catch: Throwable -> L56
        if (r14 != null) goto L11;
    L53:
        Object r15 = null;
    L54:
        Object r16 = Result.constructor-impl(r15);     // Catch: Throwable -> L56
    L58:
        Throwable r17 = Result.exceptionOrNull-impl(r16);     // Catch: Throwable -> L166
        if (r17 == null) goto L62;
        EnsureManager.ensureNotReachHere(r17);     // Catch: Throwable -> L166
    L62:
        if (Result.isFailure-impl(r16) == false) goto L65;
        r16 = null;
    L65:
        if ((r16 instanceof Integer) == true) goto L67;
        r16 = null;
    L67:
        Object r18 = (Integer) r16;     // Catch: Throwable -> L166
        if (r18 != null) goto L74;
        r12.getClass();     // Catch: Throwable -> L166
        Object r19 = SDKSettingsCacheManager.a.get("iesec_pdp_enable_preload");     // Catch: Throwable -> L166
        if ((r19 instanceof Integer) == true) goto L73;
        r19 = null;
    L73:
        r18 = (Integer) r19;     // Catch: Throwable -> L166
    L74:
        if (r18 != null) goto L176;
        int r20 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L166
    L153:
        th = move-exception;
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L166
        Object r22 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L156:
        if (Result.exceptionOrNull-impl(r22) != null) goto L183;
    L163:
        r18 = r22;
    L164:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L166
        SDKSettingsCacheManager.e("iesec_pdp_enable_preload", r18);     // Catch: Throwable -> L166
        goto L176
    L183:
        r22 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_pdp_enable_preload", Integer.class, r1);     // Catch: Throwable -> L160
    L161:
        if (r22 != null) goto L163;
        r18 = r1;
    L160:
        r22 = r1;
        goto L161
    L189:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L127
        Object r23 = SDKSettingsCacheManager.b.get("iesec_pdp_enable_preload");     // Catch: Throwable -> L127
        if (r23 != null) goto L82;
    L124:
        Object r24 = null;
    L125:
        Object r25 = Result.constructor-impl(r24);     // Catch: Throwable -> L127
    L129:
        Throwable r26 = Result.exceptionOrNull-impl(r25);     // Catch: Throwable -> L153
        if (r26 == null) goto L133;
        EnsureManager.ensureNotReachHere(r26);     // Catch: Throwable -> L153
    L133:
        if (Result.isFailure-impl(r25) == false) goto L136;
        r25 = null;
    L136:
        if ((r25 instanceof Integer) == true) goto L138;
        r25 = null;
    L138:
        Integer r27 = (Integer) r25;     // Catch: Throwable -> L153
        if (r27 == null) goto L141;
        r18 = r27;
        goto L164
    L141:
        jj4.b r28 = jj4.b.b;     // Catch: Throwable -> L153
        Object r29 = jj4.a.a("iesec_pdp_enable_preload", Integer.class, r1, false);     // Catch: Throwable -> L153
        if (r29 != null) goto L145;
        Intrinsics.throwNpe();     // Catch: Throwable -> L153
    L145:
        if ((r29 instanceof Integer) == false) goto L148;
        r13 = r29;
    L148:
        Object r30 = (Integer) r13;     // Catch: Throwable -> L153
        if (r30 != null) goto L151;
        r30 = r1;
    L151:
        r22 = Result.constructor-impl(r30);     // Catch: Throwable -> L153
    L82:
        if ((r23 instanceof Integer) == true) goto L84;
        Object r31 = null;
    L85:
        r24 = (Integer) r31;     // Catch: Throwable -> L127
        if (r24 != null) goto L125;
        if ((r23 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r32 = Float.valueOf(((Number) r23).floatValue());     // Catch: Throwable -> L127
        if ((r32 instanceof Integer) == true) goto L95;
        r32 = null;
    L95:
        r24 = (Integer) r32;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r33 = Double.valueOf(((Number) r23).doubleValue());     // Catch: Throwable -> L127
        if ((r33 instanceof Integer) == true) goto L101;
        r33 = null;
    L101:
        r24 = (Integer) r33;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r24 = Integer.valueOf(((Number) r23).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r34 = Long.valueOf(((Number) r23).longValue());     // Catch: Throwable -> L127
        if ((r34 instanceof Integer) == true) goto L110;
        r34 = null;
    L110:
        r24 = (Integer) r34;     // Catch: Throwable -> L127
    L112:
        if ((r23 instanceof JSONObject) == false) goto L114;
    L181:
        Object r35 = SDKSettingsCacheManager.a().fromJson(r23.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r35 instanceof Integer) == true) goto L118;
        r35 = null;
    L118:
        Object r36 = Result.constructor-impl((Integer) r35);     // Catch: Throwable -> L120
    L122:
        r24 = r36;
        if (Result.isFailure-impl(r24) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L127
        r36 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r23 instanceof JSONArray) == false) goto L124;
    L84:
        r31 = r23;
    L127:
        th = move-exception;
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L153
        r25 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L153
    L176:
        return ((Number) r18).intValue();
    L11:
        if ((r14 instanceof Integer) == true) goto L13;
        Object r39 = null;
    L14:
        r15 = (Integer) r39;     // Catch: Throwable -> L56
        if (r15 != null) goto L54;
        if ((r14 instanceof Number) == false) goto L41;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r40 = Float.valueOf(((Number) r14).floatValue());     // Catch: Throwable -> L56
        if ((r40 instanceof Integer) == true) goto L24;
        r40 = null;
    L24:
        r15 = (Integer) r40;     // Catch: Throwable -> L56
        goto L54
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r41 = Double.valueOf(((Number) r14).doubleValue());     // Catch: Throwable -> L56
        if ((r41 instanceof Integer) == true) goto L30;
        r41 = null;
    L30:
        r15 = (Integer) r41;     // Catch: Throwable -> L56
        goto L54
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L35;
        r15 = Integer.valueOf(((Number) r14).intValue());     // Catch: Throwable -> L56
        goto L54
    L35:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L41;
        Long r42 = Long.valueOf(((Number) r14).longValue());     // Catch: Throwable -> L56
        if ((r42 instanceof Integer) == true) goto L39;
        r42 = null;
    L39:
        r15 = (Integer) r42;     // Catch: Throwable -> L56
    L41:
        if ((r14 instanceof JSONObject) == false) goto L43;
    L179:
        Object r43 = SDKSettingsCacheManager.a().fromJson(r14.toString(), Integer.class);     // Catch: Throwable -> L49
        if ((r43 instanceof Integer) == true) goto L47;
        r43 = null;
    L47:
        Object r44 = Result.constructor-impl((Integer) r43);     // Catch: Throwable -> L49
    L51:
        r15 = r44;
        if (Result.isFailure-impl(r15) == false) goto L54;
    L49:
        th = move-exception;
        Result.Companion r45 = Result.Companion;     // Catch: Throwable -> L56
        r44 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L56
        goto L51
    L43:
        if ((r14 instanceof JSONArray) == false) goto L53;
    L13:
        r39 = r14;
    L56:
        th = move-exception;
        Result.Companion r46 = Result.Companion;     // Catch: Throwable -> L166
        r16 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L166:
        th = move-exception;
        Result.Companion r47 = Result.Companion;
        Object r48 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r49 = Result.exceptionOrNull-impl(r48);
        if (r49 == null) goto L171;
        EnsureManager.ensureNotReachHere(r49);
    L171:
        if (Result.isFailure-impl(r48) == true) goto L174;
        r1 = r48;
    L174:
        r18 = r1;
        goto L176
    }

    @SettingPanel("商详预加载配置")
    public static final String e() {
        int r0 = j.a;
        Object r1 = "";
        int r10 = com.bytedance.android.ec.base.settings.b.a;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r12 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L172
        Object r13 = null;
        r12.getClass();     // Catch: Throwable -> L59
        Object r14 = SDKSettingsCacheManager.b.get("iesec_pdp_preload_config");     // Catch: Throwable -> L59
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
        if ((r16 instanceof String) == true) goto L70;
        r16 = null;
    L70:
        Object r18 = (String) r16;     // Catch: Throwable -> L172
        if (r18 != null) goto L77;
        r12.getClass();     // Catch: Throwable -> L172
        Object r19 = SDKSettingsCacheManager.a.get("iesec_pdp_preload_config");     // Catch: Throwable -> L172
        if ((r19 instanceof String) == true) goto L76;
        r19 = null;
    L76:
        r18 = (String) r19;     // Catch: Throwable -> L172
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
        SDKSettingsCacheManager.e("iesec_pdp_preload_config", r18);     // Catch: Throwable -> L172
        goto L182
    L185:
        r22 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_pdp_preload_config", String.class, "");     // Catch: Throwable -> L166
    L167:
        if (r22 != null) goto L169;
        r18 = "";
    L166:
        r22 = "";
        goto L167
    L191:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L133
        Object r23 = SDKSettingsCacheManager.b.get("iesec_pdp_preload_config");     // Catch: Throwable -> L133
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
        if ((r25 instanceof String) == true) goto L144;
        r25 = null;
    L144:
        r22 = (String) r25;     // Catch: Throwable -> L159
        if (r22 != null) goto L169;
        jj4.b r27 = jj4.b.b;     // Catch: Throwable -> L159
        Object r28 = jj4.a.a("iesec_pdp_preload_config", String.class, "", false);     // Catch: Throwable -> L159
        if (r28 != null) goto L151;
        Intrinsics.throwNpe();     // Catch: Throwable -> L159
    L151:
        if ((r28 instanceof String) == false) goto L154;
        r13 = r28;
    L154:
        String r29 = (String) r13;     // Catch: Throwable -> L159
        if (r29 != null) goto L157;
        r29 = "";
    L157:
        r22 = Result.constructor-impl(r29);     // Catch: Throwable -> L159
    L85:
        if ((r23 instanceof String) == true) goto L87;
        Object r30 = null;
    L88:
        r24 = (String) r30;     // Catch: Throwable -> L133
        if (r24 != null) goto L131;
        if ((r23 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r31 = Float.valueOf(((Number) r23).floatValue());     // Catch: Throwable -> L133
        if ((r31 instanceof String) == true) goto L98;
        r31 = null;
    L98:
        r24 = (String) r31;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r32 = Double.valueOf(((Number) r23).doubleValue());     // Catch: Throwable -> L133
        if ((r32 instanceof String) == true) goto L104;
        r32 = null;
    L104:
        r24 = (String) r32;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r33 = Integer.valueOf(((Number) r23).intValue());     // Catch: Throwable -> L133
        if ((r33 instanceof String) == true) goto L110;
        r33 = null;
    L110:
        r24 = (String) r33;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r34 = Long.valueOf(((Number) r23).longValue());     // Catch: Throwable -> L133
        if ((r34 instanceof String) == true) goto L116;
        r34 = null;
    L116:
        r24 = (String) r34;     // Catch: Throwable -> L133
    L118:
        if ((r23 instanceof JSONObject) == false) goto L120;
    L183:
        Object r35 = SDKSettingsCacheManager.a().fromJson(r23.toString(), String.class);     // Catch: Throwable -> L126
        if ((r35 instanceof String) == true) goto L124;
        r35 = null;
    L124:
        Object r36 = Result.constructor-impl((String) r35);     // Catch: Throwable -> L126
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
        return (String) r18;
    L11:
        if ((r14 instanceof String) == true) goto L13;
        Object r39 = null;
    L14:
        r15 = (String) r39;     // Catch: Throwable -> L59
        if (r15 != null) goto L57;
        if ((r14 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r40 = Float.valueOf(((Number) r14).floatValue());     // Catch: Throwable -> L59
        if ((r40 instanceof String) == true) goto L24;
        r40 = null;
    L24:
        r15 = (String) r40;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r41 = Double.valueOf(((Number) r14).doubleValue());     // Catch: Throwable -> L59
        if ((r41 instanceof String) == true) goto L30;
        r41 = null;
    L30:
        r15 = (String) r41;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r42 = Integer.valueOf(((Number) r14).intValue());     // Catch: Throwable -> L59
        if ((r42 instanceof String) == true) goto L36;
        r42 = null;
    L36:
        r15 = (String) r42;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r43 = Long.valueOf(((Number) r14).longValue());     // Catch: Throwable -> L59
        if ((r43 instanceof String) == true) goto L42;
        r43 = null;
    L42:
        r15 = (String) r43;     // Catch: Throwable -> L59
    L44:
        if ((r14 instanceof JSONObject) == false) goto L46;
    L189:
        Object r44 = SDKSettingsCacheManager.a().fromJson(r14.toString(), String.class);     // Catch: Throwable -> L52
        if ((r44 instanceof String) == true) goto L50;
        r44 = null;
    L50:
        Object r45 = Result.constructor-impl((String) r44);     // Catch: Throwable -> L52
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

    @SettingPanel("商详加载失败重试-已固化")
    public static final boolean f() {
        int r0 = j.a;
        int r1 = e.a;
        Object r10 = e.a(Boolean.TRUE, Boolean.FALSE);
        int r11 = com.bytedance.android.ec.base.settings.b.a;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r13 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L172
        Object r14 = null;
        r13.getClass();     // Catch: Throwable -> L59
        Object r15 = SDKSettingsCacheManager.b.get("ec_pdp_retry");     // Catch: Throwable -> L59
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
        if ((r17 instanceof Boolean) == true) goto L70;
        r17 = null;
    L70:
        Object r19 = (Boolean) r17;     // Catch: Throwable -> L172
        if (r19 != null) goto L77;
        r13.getClass();     // Catch: Throwable -> L172
        Object r20 = SDKSettingsCacheManager.a.get("ec_pdp_retry");     // Catch: Throwable -> L172
        if ((r20 instanceof Boolean) == true) goto L76;
        r20 = null;
    L76:
        r19 = (Boolean) r20;     // Catch: Throwable -> L172
    L77:
        if (r19 != null) goto L182;
        int r21 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L172
    L159:
        th = move-exception;
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L172
        Object r23 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L172
    L162:
        if (Result.exceptionOrNull-impl(r23) != null) goto L191;
    L169:
        r19 = r23;
    L170:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L172
        SDKSettingsCacheManager.e("ec_pdp_retry", r19);     // Catch: Throwable -> L172
        goto L182
    L191:
        r23 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_pdp_retry", Boolean.class, r10);     // Catch: Throwable -> L166
    L167:
        if (r23 != null) goto L169;
        r19 = r10;
    L166:
        r23 = r10;
        goto L167
    L183:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L133
        Object r24 = SDKSettingsCacheManager.b.get("ec_pdp_retry");     // Catch: Throwable -> L133
        if (r24 != null) goto L85;
    L130:
        Object r25 = null;
    L131:
        Object r26 = Result.constructor-impl(r25);     // Catch: Throwable -> L133
    L135:
        Throwable r27 = Result.exceptionOrNull-impl(r26);     // Catch: Throwable -> L159
        if (r27 == null) goto L139;
        EnsureManager.ensureNotReachHere(r27);     // Catch: Throwable -> L159
    L139:
        if (Result.isFailure-impl(r26) == false) goto L142;
        r26 = null;
    L142:
        if ((r26 instanceof Boolean) == true) goto L144;
        r26 = null;
    L144:
        r23 = (Boolean) r26;     // Catch: Throwable -> L159
        if (r23 != null) goto L169;
        jj4.b r28 = jj4.b.b;     // Catch: Throwable -> L159
        Object r29 = jj4.a.a("ec_pdp_retry", Boolean.class, r10, false);     // Catch: Throwable -> L159
        if (r29 != null) goto L151;
        Intrinsics.throwNpe();     // Catch: Throwable -> L159
    L151:
        if ((r29 instanceof Boolean) == false) goto L154;
        r14 = r29;
    L154:
        Object r30 = (Boolean) r14;     // Catch: Throwable -> L159
        if (r30 != null) goto L157;
        r30 = r10;
    L157:
        r23 = Result.constructor-impl(r30);     // Catch: Throwable -> L159
    L85:
        if ((r24 instanceof Boolean) == true) goto L87;
        Object r31 = null;
    L88:
        r25 = (Boolean) r31;     // Catch: Throwable -> L133
        if (r25 != null) goto L131;
        if ((r24 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r32 = Float.valueOf(((Number) r24).floatValue());     // Catch: Throwable -> L133
        if ((r32 instanceof Boolean) == true) goto L98;
        r32 = null;
    L98:
        r25 = (Boolean) r32;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r33 = Double.valueOf(((Number) r24).doubleValue());     // Catch: Throwable -> L133
        if ((r33 instanceof Boolean) == true) goto L104;
        r33 = null;
    L104:
        r25 = (Boolean) r33;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r34 = Integer.valueOf(((Number) r24).intValue());     // Catch: Throwable -> L133
        if ((r34 instanceof Boolean) == true) goto L110;
        r34 = null;
    L110:
        r25 = (Boolean) r34;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r35 = Long.valueOf(((Number) r24).longValue());     // Catch: Throwable -> L133
        if ((r35 instanceof Boolean) == true) goto L116;
        r35 = null;
    L116:
        r25 = (Boolean) r35;     // Catch: Throwable -> L133
    L118:
        if ((r24 instanceof JSONObject) == false) goto L120;
    L189:
        Object r36 = SDKSettingsCacheManager.a().fromJson(r24.toString(), Boolean.class);     // Catch: Throwable -> L126
        if ((r36 instanceof Boolean) == true) goto L124;
        r36 = null;
    L124:
        Object r37 = Result.constructor-impl((Boolean) r36);     // Catch: Throwable -> L126
    L128:
        r25 = r37;
        if (Result.isFailure-impl(r25) == false) goto L131;
    L126:
        th = move-exception;
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L133
        r37 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L133
        goto L128
    L120:
        if ((r24 instanceof JSONArray) == false) goto L130;
    L87:
        r31 = r24;
    L133:
        th = move-exception;
        Result.Companion r39 = Result.Companion;     // Catch: Throwable -> L159
        r26 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L159
    L182:
        return ((Boolean) r19).booleanValue();
    L11:
        if ((r15 instanceof Boolean) == true) goto L13;
        Object r40 = null;
    L14:
        r16 = (Boolean) r40;     // Catch: Throwable -> L59
        if (r16 != null) goto L57;
        if ((r15 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r41 = Float.valueOf(((Number) r15).floatValue());     // Catch: Throwable -> L59
        if ((r41 instanceof Boolean) == true) goto L24;
        r41 = null;
    L24:
        r16 = (Boolean) r41;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r42 = Double.valueOf(((Number) r15).doubleValue());     // Catch: Throwable -> L59
        if ((r42 instanceof Boolean) == true) goto L30;
        r42 = null;
    L30:
        r16 = (Boolean) r42;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r43 = Integer.valueOf(((Number) r15).intValue());     // Catch: Throwable -> L59
        if ((r43 instanceof Boolean) == true) goto L36;
        r43 = null;
    L36:
        r16 = (Boolean) r43;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r44 = Long.valueOf(((Number) r15).longValue());     // Catch: Throwable -> L59
        if ((r44 instanceof Boolean) == true) goto L42;
        r44 = null;
    L42:
        r16 = (Boolean) r44;     // Catch: Throwable -> L59
    L44:
        if ((r15 instanceof JSONObject) == false) goto L46;
    L195:
        Object r45 = SDKSettingsCacheManager.a().fromJson(r15.toString(), Boolean.class);     // Catch: Throwable -> L52
        if ((r45 instanceof Boolean) == true) goto L50;
        r45 = null;
    L50:
        Object r46 = Result.constructor-impl((Boolean) r45);     // Catch: Throwable -> L52
    L54:
        r16 = r46;
        if (Result.isFailure-impl(r16) == false) goto L57;
    L52:
        th = move-exception;
        Result.Companion r47 = Result.Companion;     // Catch: Throwable -> L59
        r46 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L59
        goto L54
    L46:
        if ((r15 instanceof JSONArray) == false) goto L56;
    L13:
        r40 = r15;
    L59:
        th = move-exception;
        Result.Companion r48 = Result.Companion;     // Catch: Throwable -> L172
        r17 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L172
    L172:
        th = move-exception;
        Result.Companion r49 = Result.Companion;
        Object r50 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r51 = Result.exceptionOrNull-impl(r50);
        if (r51 == null) goto L177;
        EnsureManager.ensureNotReachHere(r51);
    L177:
        if (Result.isFailure-impl(r50) == true) goto L180;
        r10 = r50;
    L180:
        r19 = r10;
        goto L182
    }

    @SettingPanel("商详schema老转新切流")
    public static final int g() {
        int r0 = com.bytedance.android.ec.base.settings.b.a;
        Object r1 = 0;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L166
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L166
        SDKSettingsCacheManager r11 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L166
        Object r12 = null;
        r11.getClass();     // Catch: Throwable -> L56
        Object r13 = SDKSettingsCacheManager.b.get("ec_pdp_schema_convert_config");     // Catch: Throwable -> L56
        if (r13 != null) goto L11;
    L53:
        Object r14 = null;
    L54:
        Object r15 = Result.constructor-impl(r14);     // Catch: Throwable -> L56
    L58:
        Throwable r16 = Result.exceptionOrNull-impl(r15);     // Catch: Throwable -> L166
        if (r16 == null) goto L62;
        EnsureManager.ensureNotReachHere(r16);     // Catch: Throwable -> L166
    L62:
        if (Result.isFailure-impl(r15) == false) goto L65;
        r15 = null;
    L65:
        if ((r15 instanceof Integer) == true) goto L67;
        r15 = null;
    L67:
        Object r17 = (Integer) r15;     // Catch: Throwable -> L166
        if (r17 != null) goto L74;
        r11.getClass();     // Catch: Throwable -> L166
        Object r18 = SDKSettingsCacheManager.a.get("ec_pdp_schema_convert_config");     // Catch: Throwable -> L166
        if ((r18 instanceof Integer) == true) goto L73;
        r18 = null;
    L73:
        r17 = (Integer) r18;     // Catch: Throwable -> L166
    L74:
        if (r17 != null) goto L176;
        int r19 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L166
    L153:
        th = move-exception;
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L166
        Object r21 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L156:
        if (Result.exceptionOrNull-impl(r21) != null) goto L179;
    L163:
        r17 = r21;
    L164:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L166
        SDKSettingsCacheManager.e("ec_pdp_schema_convert_config", r17);     // Catch: Throwable -> L166
        goto L176
    L179:
        r21 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_pdp_schema_convert_config", Integer.class, r1);     // Catch: Throwable -> L160
    L161:
        if (r21 != null) goto L163;
        r17 = r1;
    L160:
        r21 = r1;
        goto L161
    L185:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L127
        Object r22 = SDKSettingsCacheManager.b.get("ec_pdp_schema_convert_config");     // Catch: Throwable -> L127
        if (r22 != null) goto L82;
    L124:
        Object r23 = null;
    L125:
        Object r24 = Result.constructor-impl(r23);     // Catch: Throwable -> L127
    L129:
        Throwable r25 = Result.exceptionOrNull-impl(r24);     // Catch: Throwable -> L153
        if (r25 == null) goto L133;
        EnsureManager.ensureNotReachHere(r25);     // Catch: Throwable -> L153
    L133:
        if (Result.isFailure-impl(r24) == false) goto L136;
        r24 = null;
    L136:
        if ((r24 instanceof Integer) == true) goto L138;
        r24 = null;
    L138:
        Integer r26 = (Integer) r24;     // Catch: Throwable -> L153
        if (r26 == null) goto L141;
        r17 = r26;
        goto L164
    L141:
        jj4.b r27 = jj4.b.b;     // Catch: Throwable -> L153
        Object r28 = jj4.a.a("ec_pdp_schema_convert_config", Integer.class, r1, false);     // Catch: Throwable -> L153
        if (r28 != null) goto L145;
        Intrinsics.throwNpe();     // Catch: Throwable -> L153
    L145:
        if ((r28 instanceof Integer) == false) goto L148;
        r12 = r28;
    L148:
        Object r29 = (Integer) r12;     // Catch: Throwable -> L153
        if (r29 != null) goto L151;
        r29 = r1;
    L151:
        r21 = Result.constructor-impl(r29);     // Catch: Throwable -> L153
    L82:
        if ((r22 instanceof Integer) == true) goto L84;
        Object r30 = null;
    L85:
        r23 = (Integer) r30;     // Catch: Throwable -> L127
        if (r23 != null) goto L125;
        if ((r22 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r31 = Float.valueOf(((Number) r22).floatValue());     // Catch: Throwable -> L127
        if ((r31 instanceof Integer) == true) goto L95;
        r31 = null;
    L95:
        r23 = (Integer) r31;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r32 = Double.valueOf(((Number) r22).doubleValue());     // Catch: Throwable -> L127
        if ((r32 instanceof Integer) == true) goto L101;
        r32 = null;
    L101:
        r23 = (Integer) r32;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r23 = Integer.valueOf(((Number) r22).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r33 = Long.valueOf(((Number) r22).longValue());     // Catch: Throwable -> L127
        if ((r33 instanceof Integer) == true) goto L110;
        r33 = null;
    L110:
        r23 = (Integer) r33;     // Catch: Throwable -> L127
    L112:
        if ((r22 instanceof JSONObject) == false) goto L114;
    L177:
        Object r34 = SDKSettingsCacheManager.a().fromJson(r22.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r34 instanceof Integer) == true) goto L118;
        r34 = null;
    L118:
        Object r35 = Result.constructor-impl((Integer) r34);     // Catch: Throwable -> L120
    L122:
        r23 = r35;
        if (Result.isFailure-impl(r23) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L127
        r35 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r22 instanceof JSONArray) == false) goto L124;
    L84:
        r30 = r22;
    L127:
        th = move-exception;
        Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L153
        r24 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L153
    L176:
        return ((Number) r17).intValue();
    L11:
        if ((r13 instanceof Integer) == true) goto L13;
        Object r38 = null;
    L14:
        r14 = (Integer) r38;     // Catch: Throwable -> L56
        if (r14 != null) goto L54;
        if ((r13 instanceof Number) == false) goto L41;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r39 = Float.valueOf(((Number) r13).floatValue());     // Catch: Throwable -> L56
        if ((r39 instanceof Integer) == true) goto L24;
        r39 = null;
    L24:
        r14 = (Integer) r39;     // Catch: Throwable -> L56
        goto L54
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r40 = Double.valueOf(((Number) r13).doubleValue());     // Catch: Throwable -> L56
        if ((r40 instanceof Integer) == true) goto L30;
        r40 = null;
    L30:
        r14 = (Integer) r40;     // Catch: Throwable -> L56
        goto L54
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L35;
        r14 = Integer.valueOf(((Number) r13).intValue());     // Catch: Throwable -> L56
        goto L54
    L35:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L41;
        Long r41 = Long.valueOf(((Number) r13).longValue());     // Catch: Throwable -> L56
        if ((r41 instanceof Integer) == true) goto L39;
        r41 = null;
    L39:
        r14 = (Integer) r41;     // Catch: Throwable -> L56
    L41:
        if ((r13 instanceof JSONObject) == false) goto L43;
    L189:
        Object r42 = SDKSettingsCacheManager.a().fromJson(r13.toString(), Integer.class);     // Catch: Throwable -> L49
        if ((r42 instanceof Integer) == true) goto L47;
        r42 = null;
    L47:
        Object r43 = Result.constructor-impl((Integer) r42);     // Catch: Throwable -> L49
    L51:
        r14 = r43;
        if (Result.isFailure-impl(r14) == false) goto L54;
    L49:
        th = move-exception;
        Result.Companion r44 = Result.Companion;     // Catch: Throwable -> L56
        r43 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L56
        goto L51
    L43:
        if ((r13 instanceof JSONArray) == false) goto L53;
    L13:
        r38 = r13;
    L56:
        th = move-exception;
        Result.Companion r45 = Result.Companion;     // Catch: Throwable -> L166
        r15 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L166:
        th = move-exception;
        Result.Companion r46 = Result.Companion;
        Object r47 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r48 = Result.exceptionOrNull-impl(r47);
        if (r48 == null) goto L171;
        EnsureManager.ensureNotReachHere(r48);
    L171:
        if (Result.isFailure-impl(r47) == true) goto L174;
        r1 = r47;
    L174:
        r17 = r1;
        goto L176
    }

    @SettingPanel("商详schema diff")
    public static final boolean h() {
        int r0 = com.bytedance.android.ec.base.settings.b.a;
        Object r1 = Boolean.FALSE;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r11 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L172
        Object r12 = null;
        r11.getClass();     // Catch: Throwable -> L59
        Object r13 = SDKSettingsCacheManager.b.get("ec_pdp_schema_diff");     // Catch: Throwable -> L59
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
        Object r18 = SDKSettingsCacheManager.a.get("ec_pdp_schema_diff");     // Catch: Throwable -> L172
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
        SDKSettingsCacheManager.e("ec_pdp_schema_diff", r17);     // Catch: Throwable -> L172
        goto L182
    L185:
        r21 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_pdp_schema_diff", Boolean.class, r1);     // Catch: Throwable -> L166
    L167:
        if (r21 != null) goto L169;
        r17 = r1;
    L166:
        r21 = r1;
        goto L167
    L191:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L133
        Object r22 = SDKSettingsCacheManager.b.get("ec_pdp_schema_diff");     // Catch: Throwable -> L133
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
        Object r27 = jj4.a.a("ec_pdp_schema_diff", Boolean.class, r1, false);     // Catch: Throwable -> L159
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

    @SettingPanel("商详截图优化-已固化")
    public static final int i() {
        int r0 = j.a;
        int r1 = e.a;
        Object r10 = e.a(1, 0);
        int r11 = com.bytedance.android.ec.base.settings.b.a;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L166
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L166
        SDKSettingsCacheManager r13 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L166
        Object r14 = null;
        r13.getClass();     // Catch: Throwable -> L56
        Object r15 = SDKSettingsCacheManager.b.get("ec_php_screen_shot_style");     // Catch: Throwable -> L56
        if (r15 != null) goto L11;
    L53:
        Object r16 = null;
    L54:
        Object r17 = Result.constructor-impl(r16);     // Catch: Throwable -> L56
    L58:
        Throwable r18 = Result.exceptionOrNull-impl(r17);     // Catch: Throwable -> L166
        if (r18 == null) goto L62;
        EnsureManager.ensureNotReachHere(r18);     // Catch: Throwable -> L166
    L62:
        if (Result.isFailure-impl(r17) == false) goto L65;
        r17 = null;
    L65:
        if ((r17 instanceof Integer) == true) goto L67;
        r17 = null;
    L67:
        Object r19 = (Integer) r17;     // Catch: Throwable -> L166
        if (r19 != null) goto L74;
        r13.getClass();     // Catch: Throwable -> L166
        Object r20 = SDKSettingsCacheManager.a.get("ec_php_screen_shot_style");     // Catch: Throwable -> L166
        if ((r20 instanceof Integer) == true) goto L73;
        r20 = null;
    L73:
        r19 = (Integer) r20;     // Catch: Throwable -> L166
    L74:
        if (r19 != null) goto L176;
        int r21 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L166
    L153:
        th = move-exception;
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L166
        Object r23 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L155:
        Object r24 = r23;
        if (Result.exceptionOrNull-impl(r24) != null) goto L179;
    L163:
        r19 = r24;
    L164:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L166
        SDKSettingsCacheManager.e("ec_php_screen_shot_style", r19);     // Catch: Throwable -> L166
        goto L176
    L179:
        r24 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_php_screen_shot_style", Integer.class, r10);     // Catch: Throwable -> L160
    L161:
        if (r24 != null) goto L163;
        r19 = r10;
    L160:
        r24 = r10;
        goto L161
    L185:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L127
        Object r25 = SDKSettingsCacheManager.b.get("ec_php_screen_shot_style");     // Catch: Throwable -> L127
        if (r25 != null) goto L82;
    L124:
        Object r26 = null;
    L125:
        Object r27 = Result.constructor-impl(r26);     // Catch: Throwable -> L127
    L129:
        Throwable r28 = Result.exceptionOrNull-impl(r27);     // Catch: Throwable -> L153
        if (r28 == null) goto L133;
        EnsureManager.ensureNotReachHere(r28);     // Catch: Throwable -> L153
    L133:
        if (Result.isFailure-impl(r27) == false) goto L136;
        r27 = null;
    L136:
        if ((r27 instanceof Integer) == true) goto L138;
        r27 = null;
    L138:
        r24 = (Integer) r27;     // Catch: Throwable -> L153
        if (r24 != null) goto L163;
        jj4.b r29 = jj4.b.b;     // Catch: Throwable -> L153
        Object r30 = jj4.a.a("ec_php_screen_shot_style", Integer.class, r10, false);     // Catch: Throwable -> L153
        if (r30 != null) goto L145;
        Intrinsics.throwNpe();     // Catch: Throwable -> L153
    L145:
        if ((r30 instanceof Integer) == false) goto L148;
        r14 = r30;
    L148:
        Object r31 = (Integer) r14;     // Catch: Throwable -> L153
        if (r31 != null) goto L151;
        r31 = r10;
    L151:
        r23 = Result.constructor-impl(r31);     // Catch: Throwable -> L153
    L82:
        if ((r25 instanceof Integer) == true) goto L84;
        Object r32 = null;
    L85:
        r26 = (Integer) r32;     // Catch: Throwable -> L127
        if (r26 != null) goto L125;
        if ((r25 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r33 = Float.valueOf(((Number) r25).floatValue());     // Catch: Throwable -> L127
        if ((r33 instanceof Integer) == true) goto L95;
        r33 = null;
    L95:
        r26 = (Integer) r33;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r34 = Double.valueOf(((Number) r25).doubleValue());     // Catch: Throwable -> L127
        if ((r34 instanceof Integer) == true) goto L101;
        r34 = null;
    L101:
        r26 = (Integer) r34;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r26 = Integer.valueOf(((Number) r25).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r35 = Long.valueOf(((Number) r25).longValue());     // Catch: Throwable -> L127
        if ((r35 instanceof Integer) == true) goto L110;
        r35 = null;
    L110:
        r26 = (Integer) r35;     // Catch: Throwable -> L127
    L112:
        if ((r25 instanceof JSONObject) == false) goto L114;
    L177:
        Object r36 = SDKSettingsCacheManager.a().fromJson(r25.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r36 instanceof Integer) == true) goto L118;
        r36 = null;
    L118:
        Object r37 = Result.constructor-impl((Integer) r36);     // Catch: Throwable -> L120
    L122:
        r26 = r37;
        if (Result.isFailure-impl(r26) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L127
        r37 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r25 instanceof JSONArray) == false) goto L124;
    L84:
        r32 = r25;
    L127:
        th = move-exception;
        Result.Companion r39 = Result.Companion;     // Catch: Throwable -> L153
        r27 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L153
    L176:
        return ((Number) r19).intValue();
    L11:
        if ((r15 instanceof Integer) == true) goto L13;
        Object r40 = null;
    L14:
        r16 = (Integer) r40;     // Catch: Throwable -> L56
        if (r16 != null) goto L54;
        if ((r15 instanceof Number) == false) goto L41;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r41 = Float.valueOf(((Number) r15).floatValue());     // Catch: Throwable -> L56
        if ((r41 instanceof Integer) == true) goto L24;
        r41 = null;
    L24:
        r16 = (Integer) r41;     // Catch: Throwable -> L56
        goto L54
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r42 = Double.valueOf(((Number) r15).doubleValue());     // Catch: Throwable -> L56
        if ((r42 instanceof Integer) == true) goto L30;
        r42 = null;
    L30:
        r16 = (Integer) r42;     // Catch: Throwable -> L56
        goto L54
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L35;
        r16 = Integer.valueOf(((Number) r15).intValue());     // Catch: Throwable -> L56
        goto L54
    L35:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L41;
        Long r43 = Long.valueOf(((Number) r15).longValue());     // Catch: Throwable -> L56
        if ((r43 instanceof Integer) == true) goto L39;
        r43 = null;
    L39:
        r16 = (Integer) r43;     // Catch: Throwable -> L56
    L41:
        if ((r15 instanceof JSONObject) == false) goto L43;
    L189:
        Object r44 = SDKSettingsCacheManager.a().fromJson(r15.toString(), Integer.class);     // Catch: Throwable -> L49
        if ((r44 instanceof Integer) == true) goto L47;
        r44 = null;
    L47:
        Object r45 = Result.constructor-impl((Integer) r44);     // Catch: Throwable -> L49
    L51:
        r16 = r45;
        if (Result.isFailure-impl(r16) == false) goto L54;
    L49:
        th = move-exception;
        Result.Companion r46 = Result.Companion;     // Catch: Throwable -> L56
        r45 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L56
        goto L51
    L43:
        if ((r15 instanceof JSONArray) == false) goto L53;
    L13:
        r40 = r15;
    L56:
        th = move-exception;
        Result.Companion r47 = Result.Companion;     // Catch: Throwable -> L166
        r17 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L166:
        th = move-exception;
        Result.Companion r48 = Result.Companion;
        Object r49 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r50 = Result.exceptionOrNull-impl(r49);
        if (r50 == null) goto L171;
        EnsureManager.ensureNotReachHere(r50);
    L171:
        if (Result.isFailure-impl(r49) == true) goto L174;
        r10 = r49;
    L174:
        r19 = r10;
        goto L176
    }

    public static final boolean j() {
        int r0 = j.a;
        Object r1 = Boolean.TRUE;
        int r10 = com.bytedance.android.ec.base.settings.b.a;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r12 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L172
        Object r13 = null;
        r12.getClass();     // Catch: Throwable -> L59
        Object r14 = SDKSettingsCacheManager.b.get("ec_pdp_use_new_check_valid");     // Catch: Throwable -> L59
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
        Object r19 = SDKSettingsCacheManager.a.get("ec_pdp_use_new_check_valid");     // Catch: Throwable -> L172
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
        SDKSettingsCacheManager.e("ec_pdp_use_new_check_valid", r18);     // Catch: Throwable -> L172
        goto L182
    L185:
        r22 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_pdp_use_new_check_valid", Boolean.class, r1);     // Catch: Throwable -> L166
    L167:
        if (r22 != null) goto L169;
        r18 = r1;
    L166:
        r22 = r1;
        goto L167
    L191:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L133
        Object r23 = SDKSettingsCacheManager.b.get("ec_pdp_use_new_check_valid");     // Catch: Throwable -> L133
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
        Object r28 = jj4.a.a("ec_pdp_use_new_check_valid", Boolean.class, r1, false);     // Catch: Throwable -> L159
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

    public static final boolean k() {
        jj4.b r0 = jj4.b.b;
        int r1 = e.a;
        Object r10 = jj4.a.a("iesec_sku_preview", Boolean.class, e.a(Boolean.TRUE, Boolean.FALSE), false);
        if (r10 != null) goto L6;
        Intrinsics.throwNpe();
    L6:
        return ((Boolean) r10).booleanValue();
    }

    @SettingPanel("曝光时长开关")
    public static final boolean l() {
        int r0 = com.bytedance.android.ec.base.settings.b.a;
        Object r1 = Boolean.TRUE;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r11 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L172
        Object r12 = null;
        r11.getClass();     // Catch: Throwable -> L59
        Object r13 = SDKSettingsCacheManager.b.get("iesec_pdp_enable_exposure_engine");     // Catch: Throwable -> L59
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
        Object r18 = SDKSettingsCacheManager.a.get("iesec_pdp_enable_exposure_engine");     // Catch: Throwable -> L172
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
        SDKSettingsCacheManager.e("iesec_pdp_enable_exposure_engine", r17);     // Catch: Throwable -> L172
        goto L182
    L185:
        r21 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_pdp_enable_exposure_engine", Boolean.class, r1);     // Catch: Throwable -> L166
    L167:
        if (r21 != null) goto L169;
        r17 = r1;
    L166:
        r21 = r1;
        goto L167
    L191:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L133
        Object r22 = SDKSettingsCacheManager.b.get("iesec_pdp_enable_exposure_engine");     // Catch: Throwable -> L133
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
        Object r27 = jj4.a.a("iesec_pdp_enable_exposure_engine", Boolean.class, r1, false);     // Catch: Throwable -> L159
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

    @SettingPanel("曝光时长：商详顶导 alpha 遮挡阈值")
    public static final float m() {
        int r0 = com.bytedance.android.ec.base.settings.b.a;
        Object r1 = Float.valueOf(0.8f);
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L166
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L166
        SDKSettingsCacheManager r11 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L166
        Object r12 = null;
        r11.getClass();     // Catch: Throwable -> L56
        Object r13 = SDKSettingsCacheManager.b.get("iesec_pdp_exposure_alpha_percentage");     // Catch: Throwable -> L56
        if (r13 != null) goto L11;
    L53:
        Object r14 = null;
    L54:
        Object r15 = Result.constructor-impl(r14);     // Catch: Throwable -> L56
    L58:
        Throwable r16 = Result.exceptionOrNull-impl(r15);     // Catch: Throwable -> L166
        if (r16 == null) goto L62;
        EnsureManager.ensureNotReachHere(r16);     // Catch: Throwable -> L166
    L62:
        if (Result.isFailure-impl(r15) == false) goto L65;
        r15 = null;
    L65:
        if ((r15 instanceof Float) == true) goto L67;
        r15 = null;
    L67:
        Object r17 = (Float) r15;     // Catch: Throwable -> L166
        if (r17 != null) goto L74;
        r11.getClass();     // Catch: Throwable -> L166
        Object r18 = SDKSettingsCacheManager.a.get("iesec_pdp_exposure_alpha_percentage");     // Catch: Throwable -> L166
        if ((r18 instanceof Float) == true) goto L73;
        r18 = null;
    L73:
        r17 = (Float) r18;     // Catch: Throwable -> L166
    L74:
        if (r17 != null) goto L176;
        int r19 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L166
    L153:
        th = move-exception;
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L166
        Object r21 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L156:
        if (Result.exceptionOrNull-impl(r21) != null) goto L183;
    L163:
        r17 = r21;
    L164:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L166
        SDKSettingsCacheManager.e("iesec_pdp_exposure_alpha_percentage", r17);     // Catch: Throwable -> L166
        goto L176
    L183:
        r21 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_pdp_exposure_alpha_percentage", Float.class, r1);     // Catch: Throwable -> L160
    L161:
        if (r21 != null) goto L163;
        r17 = r1;
    L160:
        r21 = r1;
        goto L161
    L189:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L127
        Object r22 = SDKSettingsCacheManager.b.get("iesec_pdp_exposure_alpha_percentage");     // Catch: Throwable -> L127
        if (r22 != null) goto L82;
    L124:
        Object r23 = null;
    L125:
        Object r24 = Result.constructor-impl(r23);     // Catch: Throwable -> L127
    L129:
        Throwable r25 = Result.exceptionOrNull-impl(r24);     // Catch: Throwable -> L153
        if (r25 == null) goto L133;
        EnsureManager.ensureNotReachHere(r25);     // Catch: Throwable -> L153
    L133:
        if (Result.isFailure-impl(r24) == false) goto L136;
        r24 = null;
    L136:
        if ((r24 instanceof Float) == true) goto L138;
        r24 = null;
    L138:
        r21 = (Float) r24;     // Catch: Throwable -> L153
        if (r21 != null) goto L163;
        jj4.b r26 = jj4.b.b;     // Catch: Throwable -> L153
        Object r27 = jj4.a.a("iesec_pdp_exposure_alpha_percentage", Float.class, r1, false);     // Catch: Throwable -> L153
        if (r27 != null) goto L145;
        Intrinsics.throwNpe();     // Catch: Throwable -> L153
    L145:
        if ((r27 instanceof Float) == false) goto L148;
        r12 = r27;
    L148:
        Object r28 = (Float) r12;     // Catch: Throwable -> L153
        if (r28 != null) goto L151;
        r28 = r1;
    L151:
        r21 = Result.constructor-impl(r28);     // Catch: Throwable -> L153
    L82:
        if ((r22 instanceof Float) == true) goto L84;
        Object r29 = null;
    L85:
        r23 = (Float) r29;     // Catch: Throwable -> L127
        if (r23 != null) goto L125;
        if ((r22 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Float.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L94;
        r23 = Float.valueOf(((Number) r22).floatValue());     // Catch: Throwable -> L127
        goto L125
    L94:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Float.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L100;
        Double r30 = Double.valueOf(((Number) r22).doubleValue());     // Catch: Throwable -> L127
        if ((r30 instanceof Float) == true) goto L98;
        r30 = null;
    L98:
        r23 = (Float) r30;     // Catch: Throwable -> L127
        goto L125
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Float.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        Integer r31 = Integer.valueOf(((Number) r22).intValue());     // Catch: Throwable -> L127
        if ((r31 instanceof Float) == true) goto L104;
        r31 = null;
    L104:
        r23 = (Float) r31;     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Float.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r32 = Long.valueOf(((Number) r22).longValue());     // Catch: Throwable -> L127
        if ((r32 instanceof Float) == true) goto L110;
        r32 = null;
    L110:
        r23 = (Float) r32;     // Catch: Throwable -> L127
    L112:
        if ((r22 instanceof JSONObject) == false) goto L114;
    L181:
        Object r33 = SDKSettingsCacheManager.a().fromJson(r22.toString(), Float.class);     // Catch: Throwable -> L120
        if ((r33 instanceof Float) == true) goto L118;
        r33 = null;
    L118:
        Object r34 = Result.constructor-impl((Float) r33);     // Catch: Throwable -> L120
    L122:
        r23 = r34;
        if (Result.isFailure-impl(r23) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r35 = Result.Companion;     // Catch: Throwable -> L127
        r34 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r22 instanceof JSONArray) == false) goto L124;
    L84:
        r29 = r22;
    L127:
        th = move-exception;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L153
        r24 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L153
    L176:
        return ((Number) r17).floatValue();
    L11:
        if ((r13 instanceof Float) == true) goto L13;
        Object r37 = null;
    L14:
        r14 = (Float) r37;     // Catch: Throwable -> L56
        if (r14 != null) goto L54;
        if ((r13 instanceof Number) == false) goto L41;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Float.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L23;
        r14 = Float.valueOf(((Number) r13).floatValue());     // Catch: Throwable -> L56
        goto L54
    L23:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Float.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L29;
        Double r38 = Double.valueOf(((Number) r13).doubleValue());     // Catch: Throwable -> L56
        if ((r38 instanceof Float) == true) goto L27;
        r38 = null;
    L27:
        r14 = (Float) r38;     // Catch: Throwable -> L56
        goto L54
    L29:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Float.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L35;
        Integer r39 = Integer.valueOf(((Number) r13).intValue());     // Catch: Throwable -> L56
        if ((r39 instanceof Float) == true) goto L33;
        r39 = null;
    L33:
        r14 = (Float) r39;     // Catch: Throwable -> L56
        goto L54
    L35:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Float.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L41;
        Long r40 = Long.valueOf(((Number) r13).longValue());     // Catch: Throwable -> L56
        if ((r40 instanceof Float) == true) goto L39;
        r40 = null;
    L39:
        r14 = (Float) r40;     // Catch: Throwable -> L56
    L41:
        if ((r13 instanceof JSONObject) == false) goto L43;
    L179:
        Object r41 = SDKSettingsCacheManager.a().fromJson(r13.toString(), Float.class);     // Catch: Throwable -> L49
        if ((r41 instanceof Float) == true) goto L47;
        r41 = null;
    L47:
        Object r42 = Result.constructor-impl((Float) r41);     // Catch: Throwable -> L49
    L51:
        r14 = r42;
        if (Result.isFailure-impl(r14) == false) goto L54;
    L49:
        th = move-exception;
        Result.Companion r43 = Result.Companion;     // Catch: Throwable -> L56
        r42 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L56
        goto L51
    L43:
        if ((r13 instanceof JSONArray) == false) goto L53;
    L13:
        r37 = r13;
    L56:
        th = move-exception;
        Result.Companion r44 = Result.Companion;     // Catch: Throwable -> L166
        r15 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L166:
        th = move-exception;
        Result.Companion r45 = Result.Companion;
        Object r46 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r47 = Result.exceptionOrNull-impl(r46);
        if (r47 == null) goto L171;
        EnsureManager.ensureNotReachHere(r47);
    L171:
        if (Result.isFailure-impl(r46) == true) goto L174;
        r1 = r46;
    L174:
        r17 = r1;
        goto L176
    }

    @SettingPanel("曝光时长轮询间隔")
    public static final long n() {
        int r0 = com.bytedance.android.ec.base.settings.b.a;
        Object r1 = 100L;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L166
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L166
        SDKSettingsCacheManager r11 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L166
        Object r12 = null;
        r11.getClass();     // Catch: Throwable -> L56
        Object r13 = SDKSettingsCacheManager.b.get("iesec_pdp_exposure_duration");     // Catch: Throwable -> L56
        if (r13 != null) goto L11;
    L53:
        Object r14 = null;
    L54:
        Object r15 = Result.constructor-impl(r14);     // Catch: Throwable -> L56
    L58:
        Throwable r16 = Result.exceptionOrNull-impl(r15);     // Catch: Throwable -> L166
        if (r16 == null) goto L62;
        EnsureManager.ensureNotReachHere(r16);     // Catch: Throwable -> L166
    L62:
        if (Result.isFailure-impl(r15) == false) goto L65;
        r15 = null;
    L65:
        if ((r15 instanceof Long) == true) goto L67;
        r15 = null;
    L67:
        Object r17 = (Long) r15;     // Catch: Throwable -> L166
        if (r17 != null) goto L74;
        r11.getClass();     // Catch: Throwable -> L166
        Object r18 = SDKSettingsCacheManager.a.get("iesec_pdp_exposure_duration");     // Catch: Throwable -> L166
        if ((r18 instanceof Long) == true) goto L73;
        r18 = null;
    L73:
        r17 = (Long) r18;     // Catch: Throwable -> L166
    L74:
        if (r17 != null) goto L176;
        int r19 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L166
    L153:
        th = move-exception;
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L166
        Object r21 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L156:
        if (Result.exceptionOrNull-impl(r21) != null) goto L181;
    L163:
        r17 = r21;
    L164:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L166
        SDKSettingsCacheManager.e("iesec_pdp_exposure_duration", r17);     // Catch: Throwable -> L166
        goto L176
    L181:
        r21 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_pdp_exposure_duration", Long.class, r1);     // Catch: Throwable -> L160
    L161:
        if (r21 != null) goto L163;
        r17 = r1;
    L160:
        r21 = r1;
        goto L161
    L187:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L127
        Object r22 = SDKSettingsCacheManager.b.get("iesec_pdp_exposure_duration");     // Catch: Throwable -> L127
        if (r22 != null) goto L82;
    L124:
        Object r23 = null;
    L125:
        Object r24 = Result.constructor-impl(r23);     // Catch: Throwable -> L127
    L129:
        Throwable r25 = Result.exceptionOrNull-impl(r24);     // Catch: Throwable -> L153
        if (r25 == null) goto L133;
        EnsureManager.ensureNotReachHere(r25);     // Catch: Throwable -> L153
    L133:
        if (Result.isFailure-impl(r24) == false) goto L136;
        r24 = null;
    L136:
        if ((r24 instanceof Long) == true) goto L138;
        r24 = null;
    L138:
        r21 = (Long) r24;     // Catch: Throwable -> L153
        if (r21 != null) goto L163;
        jj4.b r26 = jj4.b.b;     // Catch: Throwable -> L153
        Object r27 = jj4.a.a("iesec_pdp_exposure_duration", Long.class, r1, false);     // Catch: Throwable -> L153
        if (r27 != null) goto L145;
        Intrinsics.throwNpe();     // Catch: Throwable -> L153
    L145:
        if ((r27 instanceof Long) == false) goto L148;
        r12 = r27;
    L148:
        Object r28 = (Long) r12;     // Catch: Throwable -> L153
        if (r28 != null) goto L151;
        r28 = r1;
    L151:
        r21 = Result.constructor-impl(r28);     // Catch: Throwable -> L153
    L82:
        if ((r22 instanceof Long) == true) goto L84;
        Object r29 = null;
    L85:
        r23 = (Long) r29;     // Catch: Throwable -> L127
        if (r23 != null) goto L125;
        if ((r22 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Long.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r30 = Float.valueOf(((Number) r22).floatValue());     // Catch: Throwable -> L127
        if ((r30 instanceof Long) == true) goto L95;
        r30 = null;
    L95:
        r23 = (Long) r30;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Long.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r31 = Double.valueOf(((Number) r22).doubleValue());     // Catch: Throwable -> L127
        if ((r31 instanceof Long) == true) goto L101;
        r31 = null;
    L101:
        r23 = (Long) r31;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Long.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L109;
        Integer r32 = Integer.valueOf(((Number) r22).intValue());     // Catch: Throwable -> L127
        if ((r32 instanceof Long) == true) goto L107;
        r32 = null;
    L107:
        r23 = (Long) r32;     // Catch: Throwable -> L127
        goto L125
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Long.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        r23 = Long.valueOf(((Number) r22).longValue());     // Catch: Throwable -> L127
    L112:
        if ((r22 instanceof JSONObject) == false) goto L114;
    L179:
        Object r33 = SDKSettingsCacheManager.a().fromJson(r22.toString(), Long.class);     // Catch: Throwable -> L120
        if ((r33 instanceof Long) == true) goto L118;
        r33 = null;
    L118:
        Object r34 = Result.constructor-impl((Long) r33);     // Catch: Throwable -> L120
    L122:
        r23 = r34;
        if (Result.isFailure-impl(r23) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r35 = Result.Companion;     // Catch: Throwable -> L127
        r34 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r22 instanceof JSONArray) == false) goto L124;
    L84:
        r29 = r22;
    L127:
        th = move-exception;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L153
        r24 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L153
    L176:
        return ((Number) r17).longValue();
    L11:
        if ((r13 instanceof Long) == true) goto L13;
        Object r37 = null;
    L14:
        r14 = (Long) r37;     // Catch: Throwable -> L56
        if (r14 != null) goto L54;
        if ((r13 instanceof Number) == false) goto L41;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Long.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r38 = Float.valueOf(((Number) r13).floatValue());     // Catch: Throwable -> L56
        if ((r38 instanceof Long) == true) goto L24;
        r38 = null;
    L24:
        r14 = (Long) r38;     // Catch: Throwable -> L56
        goto L54
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Long.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r39 = Double.valueOf(((Number) r13).doubleValue());     // Catch: Throwable -> L56
        if ((r39 instanceof Long) == true) goto L30;
        r39 = null;
    L30:
        r14 = (Long) r39;     // Catch: Throwable -> L56
        goto L54
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Long.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r40 = Integer.valueOf(((Number) r13).intValue());     // Catch: Throwable -> L56
        if ((r40 instanceof Long) == true) goto L36;
        r40 = null;
    L36:
        r14 = (Long) r40;     // Catch: Throwable -> L56
        goto L54
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Long.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L41;
        r14 = Long.valueOf(((Number) r13).longValue());     // Catch: Throwable -> L56
    L41:
        if ((r13 instanceof JSONObject) == false) goto L43;
    L177:
        Object r41 = SDKSettingsCacheManager.a().fromJson(r13.toString(), Long.class);     // Catch: Throwable -> L49
        if ((r41 instanceof Long) == true) goto L47;
        r41 = null;
    L47:
        Object r42 = Result.constructor-impl((Long) r41);     // Catch: Throwable -> L49
    L51:
        r14 = r42;
        if (Result.isFailure-impl(r14) == false) goto L54;
    L49:
        th = move-exception;
        Result.Companion r43 = Result.Companion;     // Catch: Throwable -> L56
        r42 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L56
        goto L51
    L43:
        if ((r13 instanceof JSONArray) == false) goto L53;
    L13:
        r37 = r13;
    L56:
        th = move-exception;
        Result.Companion r44 = Result.Companion;     // Catch: Throwable -> L166
        r15 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L166:
        th = move-exception;
        Result.Companion r45 = Result.Companion;
        Object r46 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r47 = Result.exceptionOrNull-impl(r46);
        if (r47 == null) goto L171;
        EnsureManager.ensureNotReachHere(r47);
    L171:
        if (Result.isFailure-impl(r46) == true) goto L174;
        r1 = r46;
    L174:
        r17 = r1;
        goto L176
    }

    @SettingPanel("头图视频容器标准化V1")
    public static final boolean o() {
        int r0 = com.bytedance.android.ec.base.settings.b.a;
        Object r1 = Boolean.FALSE;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r11 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L172
        Object r12 = null;
        r11.getClass();     // Catch: Throwable -> L59
        Object r13 = SDKSettingsCacheManager.b.get("iesec_andr_pdp_player_view_refactor");     // Catch: Throwable -> L59
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
        Object r18 = SDKSettingsCacheManager.a.get("iesec_andr_pdp_player_view_refactor");     // Catch: Throwable -> L172
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
        SDKSettingsCacheManager.e("iesec_andr_pdp_player_view_refactor", r17);     // Catch: Throwable -> L172
        goto L182
    L185:
        r21 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_andr_pdp_player_view_refactor", Boolean.class, r1);     // Catch: Throwable -> L166
    L167:
        if (r21 != null) goto L169;
        r17 = r1;
    L166:
        r21 = r1;
        goto L167
    L191:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L133
        Object r22 = SDKSettingsCacheManager.b.get("iesec_andr_pdp_player_view_refactor");     // Catch: Throwable -> L133
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
        Object r27 = jj4.a.a("iesec_andr_pdp_player_view_refactor", Boolean.class, r1, false);     // Catch: Throwable -> L159
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

    @SettingPanel("商详视频直播声音互斥优化")
    public static final boolean p() {
        Lazy r0 = ECAppInfoService.a;
        return ECAppInfoService.h();
    }

    @SettingPanel("黑灯页购买决策实验")
    public static final int q() {
        int r0 = j.a;
        int r1 = e.a;
        Object r10 = e.a(2, 0);
        int r11 = com.bytedance.android.ec.base.settings.b.a;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L166
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L166
        SDKSettingsCacheManager r13 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L166
        Object r14 = null;
        r13.getClass();     // Catch: Throwable -> L56
        Object r15 = SDKSettingsCacheManager.b.get("iesec_pdp_gallery_buy");     // Catch: Throwable -> L56
        if (r15 != null) goto L11;
    L53:
        Object r16 = null;
    L54:
        Object r17 = Result.constructor-impl(r16);     // Catch: Throwable -> L56
    L58:
        Throwable r18 = Result.exceptionOrNull-impl(r17);     // Catch: Throwable -> L166
        if (r18 == null) goto L62;
        EnsureManager.ensureNotReachHere(r18);     // Catch: Throwable -> L166
    L62:
        if (Result.isFailure-impl(r17) == false) goto L65;
        r17 = null;
    L65:
        if ((r17 instanceof Integer) == true) goto L67;
        r17 = null;
    L67:
        Object r19 = (Integer) r17;     // Catch: Throwable -> L166
        if (r19 != null) goto L74;
        r13.getClass();     // Catch: Throwable -> L166
        Object r20 = SDKSettingsCacheManager.a.get("iesec_pdp_gallery_buy");     // Catch: Throwable -> L166
        if ((r20 instanceof Integer) == true) goto L73;
        r20 = null;
    L73:
        r19 = (Integer) r20;     // Catch: Throwable -> L166
    L74:
        if (r19 != null) goto L176;
        int r21 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L166
    L153:
        th = move-exception;
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L166
        Object r23 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L155:
        Object r24 = r23;
        if (Result.exceptionOrNull-impl(r24) != null) goto L179;
    L163:
        r19 = r24;
    L164:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L166
        SDKSettingsCacheManager.e("iesec_pdp_gallery_buy", r19);     // Catch: Throwable -> L166
        goto L176
    L179:
        r24 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_pdp_gallery_buy", Integer.class, r10);     // Catch: Throwable -> L160
    L161:
        if (r24 != null) goto L163;
        r19 = r10;
    L160:
        r24 = r10;
        goto L161
    L185:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L127
        Object r25 = SDKSettingsCacheManager.b.get("iesec_pdp_gallery_buy");     // Catch: Throwable -> L127
        if (r25 != null) goto L82;
    L124:
        Object r26 = null;
    L125:
        Object r27 = Result.constructor-impl(r26);     // Catch: Throwable -> L127
    L129:
        Throwable r28 = Result.exceptionOrNull-impl(r27);     // Catch: Throwable -> L153
        if (r28 == null) goto L133;
        EnsureManager.ensureNotReachHere(r28);     // Catch: Throwable -> L153
    L133:
        if (Result.isFailure-impl(r27) == false) goto L136;
        r27 = null;
    L136:
        if ((r27 instanceof Integer) == true) goto L138;
        r27 = null;
    L138:
        r24 = (Integer) r27;     // Catch: Throwable -> L153
        if (r24 != null) goto L163;
        jj4.b r29 = jj4.b.b;     // Catch: Throwable -> L153
        Object r30 = jj4.a.a("iesec_pdp_gallery_buy", Integer.class, r10, false);     // Catch: Throwable -> L153
        if (r30 != null) goto L145;
        Intrinsics.throwNpe();     // Catch: Throwable -> L153
    L145:
        if ((r30 instanceof Integer) == false) goto L148;
        r14 = r30;
    L148:
        Object r31 = (Integer) r14;     // Catch: Throwable -> L153
        if (r31 != null) goto L151;
        r31 = r10;
    L151:
        r23 = Result.constructor-impl(r31);     // Catch: Throwable -> L153
    L82:
        if ((r25 instanceof Integer) == true) goto L84;
        Object r32 = null;
    L85:
        r26 = (Integer) r32;     // Catch: Throwable -> L127
        if (r26 != null) goto L125;
        if ((r25 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r33 = Float.valueOf(((Number) r25).floatValue());     // Catch: Throwable -> L127
        if ((r33 instanceof Integer) == true) goto L95;
        r33 = null;
    L95:
        r26 = (Integer) r33;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r34 = Double.valueOf(((Number) r25).doubleValue());     // Catch: Throwable -> L127
        if ((r34 instanceof Integer) == true) goto L101;
        r34 = null;
    L101:
        r26 = (Integer) r34;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r26 = Integer.valueOf(((Number) r25).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r35 = Long.valueOf(((Number) r25).longValue());     // Catch: Throwable -> L127
        if ((r35 instanceof Integer) == true) goto L110;
        r35 = null;
    L110:
        r26 = (Integer) r35;     // Catch: Throwable -> L127
    L112:
        if ((r25 instanceof JSONObject) == false) goto L114;
    L177:
        Object r36 = SDKSettingsCacheManager.a().fromJson(r25.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r36 instanceof Integer) == true) goto L118;
        r36 = null;
    L118:
        Object r37 = Result.constructor-impl((Integer) r36);     // Catch: Throwable -> L120
    L122:
        r26 = r37;
        if (Result.isFailure-impl(r26) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L127
        r37 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r25 instanceof JSONArray) == false) goto L124;
    L84:
        r32 = r25;
    L127:
        th = move-exception;
        Result.Companion r39 = Result.Companion;     // Catch: Throwable -> L153
        r27 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L153
    L176:
        return ((Number) r19).intValue();
    L11:
        if ((r15 instanceof Integer) == true) goto L13;
        Object r40 = null;
    L14:
        r16 = (Integer) r40;     // Catch: Throwable -> L56
        if (r16 != null) goto L54;
        if ((r15 instanceof Number) == false) goto L41;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r41 = Float.valueOf(((Number) r15).floatValue());     // Catch: Throwable -> L56
        if ((r41 instanceof Integer) == true) goto L24;
        r41 = null;
    L24:
        r16 = (Integer) r41;     // Catch: Throwable -> L56
        goto L54
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r42 = Double.valueOf(((Number) r15).doubleValue());     // Catch: Throwable -> L56
        if ((r42 instanceof Integer) == true) goto L30;
        r42 = null;
    L30:
        r16 = (Integer) r42;     // Catch: Throwable -> L56
        goto L54
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L35;
        r16 = Integer.valueOf(((Number) r15).intValue());     // Catch: Throwable -> L56
        goto L54
    L35:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L41;
        Long r43 = Long.valueOf(((Number) r15).longValue());     // Catch: Throwable -> L56
        if ((r43 instanceof Integer) == true) goto L39;
        r43 = null;
    L39:
        r16 = (Integer) r43;     // Catch: Throwable -> L56
    L41:
        if ((r15 instanceof JSONObject) == false) goto L43;
    L189:
        Object r44 = SDKSettingsCacheManager.a().fromJson(r15.toString(), Integer.class);     // Catch: Throwable -> L49
        if ((r44 instanceof Integer) == true) goto L47;
        r44 = null;
    L47:
        Object r45 = Result.constructor-impl((Integer) r44);     // Catch: Throwable -> L49
    L51:
        r16 = r45;
        if (Result.isFailure-impl(r16) == false) goto L54;
    L49:
        th = move-exception;
        Result.Companion r46 = Result.Companion;     // Catch: Throwable -> L56
        r45 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L56
        goto L51
    L43:
        if ((r15 instanceof JSONArray) == false) goto L53;
    L13:
        r40 = r15;
    L56:
        th = move-exception;
        Result.Companion r47 = Result.Companion;     // Catch: Throwable -> L166
        r17 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L166:
        th = move-exception;
        Result.Companion r48 = Result.Companion;
        Object r49 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r50 = Result.exceptionOrNull-impl(r49);
        if (r50 == null) goto L171;
        EnsureManager.ensureNotReachHere(r50);
    L171:
        if (Result.isFailure-impl(r49) == true) goto L174;
        r10 = r49;
    L174:
        r19 = r10;
        goto L176
    }

    @SettingPanel("商详头图测评视频预加载-已固化")
    public static final int r() {
        int r0 = j.a;
        int r1 = e.a;
        Object r10 = e.a(1, 0);
        int r11 = com.bytedance.android.ec.base.settings.b.a;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L166
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L166
        SDKSettingsCacheManager r13 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L166
        Object r14 = null;
        r13.getClass();     // Catch: Throwable -> L56
        Object r15 = SDKSettingsCacheManager.b.get("iesec_ecom_pdp_kol_preload");     // Catch: Throwable -> L56
        if (r15 != null) goto L11;
    L53:
        Object r16 = null;
    L54:
        Object r17 = Result.constructor-impl(r16);     // Catch: Throwable -> L56
    L58:
        Throwable r18 = Result.exceptionOrNull-impl(r17);     // Catch: Throwable -> L166
        if (r18 == null) goto L62;
        EnsureManager.ensureNotReachHere(r18);     // Catch: Throwable -> L166
    L62:
        if (Result.isFailure-impl(r17) == false) goto L65;
        r17 = null;
    L65:
        if ((r17 instanceof Integer) == true) goto L67;
        r17 = null;
    L67:
        Object r19 = (Integer) r17;     // Catch: Throwable -> L166
        if (r19 != null) goto L74;
        r13.getClass();     // Catch: Throwable -> L166
        Object r20 = SDKSettingsCacheManager.a.get("iesec_ecom_pdp_kol_preload");     // Catch: Throwable -> L166
        if ((r20 instanceof Integer) == true) goto L73;
        r20 = null;
    L73:
        r19 = (Integer) r20;     // Catch: Throwable -> L166
    L74:
        if (r19 != null) goto L176;
        int r21 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L166
    L153:
        th = move-exception;
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L166
        Object r23 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L155:
        Object r24 = r23;
        if (Result.exceptionOrNull-impl(r24) != null) goto L179;
    L163:
        r19 = r24;
    L164:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L166
        SDKSettingsCacheManager.e("iesec_ecom_pdp_kol_preload", r19);     // Catch: Throwable -> L166
        goto L176
    L179:
        r24 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_ecom_pdp_kol_preload", Integer.class, r10);     // Catch: Throwable -> L160
    L161:
        if (r24 != null) goto L163;
        r19 = r10;
    L160:
        r24 = r10;
        goto L161
    L185:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L127
        Object r25 = SDKSettingsCacheManager.b.get("iesec_ecom_pdp_kol_preload");     // Catch: Throwable -> L127
        if (r25 != null) goto L82;
    L124:
        Object r26 = null;
    L125:
        Object r27 = Result.constructor-impl(r26);     // Catch: Throwable -> L127
    L129:
        Throwable r28 = Result.exceptionOrNull-impl(r27);     // Catch: Throwable -> L153
        if (r28 == null) goto L133;
        EnsureManager.ensureNotReachHere(r28);     // Catch: Throwable -> L153
    L133:
        if (Result.isFailure-impl(r27) == false) goto L136;
        r27 = null;
    L136:
        if ((r27 instanceof Integer) == true) goto L138;
        r27 = null;
    L138:
        r24 = (Integer) r27;     // Catch: Throwable -> L153
        if (r24 != null) goto L163;
        jj4.b r29 = jj4.b.b;     // Catch: Throwable -> L153
        Object r30 = jj4.a.a("iesec_ecom_pdp_kol_preload", Integer.class, r10, false);     // Catch: Throwable -> L153
        if (r30 != null) goto L145;
        Intrinsics.throwNpe();     // Catch: Throwable -> L153
    L145:
        if ((r30 instanceof Integer) == false) goto L148;
        r14 = r30;
    L148:
        Object r31 = (Integer) r14;     // Catch: Throwable -> L153
        if (r31 != null) goto L151;
        r31 = r10;
    L151:
        r23 = Result.constructor-impl(r31);     // Catch: Throwable -> L153
    L82:
        if ((r25 instanceof Integer) == true) goto L84;
        Object r32 = null;
    L85:
        r26 = (Integer) r32;     // Catch: Throwable -> L127
        if (r26 != null) goto L125;
        if ((r25 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r33 = Float.valueOf(((Number) r25).floatValue());     // Catch: Throwable -> L127
        if ((r33 instanceof Integer) == true) goto L95;
        r33 = null;
    L95:
        r26 = (Integer) r33;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r34 = Double.valueOf(((Number) r25).doubleValue());     // Catch: Throwable -> L127
        if ((r34 instanceof Integer) == true) goto L101;
        r34 = null;
    L101:
        r26 = (Integer) r34;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r26 = Integer.valueOf(((Number) r25).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r35 = Long.valueOf(((Number) r25).longValue());     // Catch: Throwable -> L127
        if ((r35 instanceof Integer) == true) goto L110;
        r35 = null;
    L110:
        r26 = (Integer) r35;     // Catch: Throwable -> L127
    L112:
        if ((r25 instanceof JSONObject) == false) goto L114;
    L177:
        Object r36 = SDKSettingsCacheManager.a().fromJson(r25.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r36 instanceof Integer) == true) goto L118;
        r36 = null;
    L118:
        Object r37 = Result.constructor-impl((Integer) r36);     // Catch: Throwable -> L120
    L122:
        r26 = r37;
        if (Result.isFailure-impl(r26) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L127
        r37 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r25 instanceof JSONArray) == false) goto L124;
    L84:
        r32 = r25;
    L127:
        th = move-exception;
        Result.Companion r39 = Result.Companion;     // Catch: Throwable -> L153
        r27 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L153
    L176:
        return ((Number) r19).intValue();
    L11:
        if ((r15 instanceof Integer) == true) goto L13;
        Object r40 = null;
    L14:
        r16 = (Integer) r40;     // Catch: Throwable -> L56
        if (r16 != null) goto L54;
        if ((r15 instanceof Number) == false) goto L41;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r41 = Float.valueOf(((Number) r15).floatValue());     // Catch: Throwable -> L56
        if ((r41 instanceof Integer) == true) goto L24;
        r41 = null;
    L24:
        r16 = (Integer) r41;     // Catch: Throwable -> L56
        goto L54
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r42 = Double.valueOf(((Number) r15).doubleValue());     // Catch: Throwable -> L56
        if ((r42 instanceof Integer) == true) goto L30;
        r42 = null;
    L30:
        r16 = (Integer) r42;     // Catch: Throwable -> L56
        goto L54
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L35;
        r16 = Integer.valueOf(((Number) r15).intValue());     // Catch: Throwable -> L56
        goto L54
    L35:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L41;
        Long r43 = Long.valueOf(((Number) r15).longValue());     // Catch: Throwable -> L56
        if ((r43 instanceof Integer) == true) goto L39;
        r43 = null;
    L39:
        r16 = (Integer) r43;     // Catch: Throwable -> L56
    L41:
        if ((r15 instanceof JSONObject) == false) goto L43;
    L189:
        Object r44 = SDKSettingsCacheManager.a().fromJson(r15.toString(), Integer.class);     // Catch: Throwable -> L49
        if ((r44 instanceof Integer) == true) goto L47;
        r44 = null;
    L47:
        Object r45 = Result.constructor-impl((Integer) r44);     // Catch: Throwable -> L49
    L51:
        r16 = r45;
        if (Result.isFailure-impl(r16) == false) goto L54;
    L49:
        th = move-exception;
        Result.Companion r46 = Result.Companion;     // Catch: Throwable -> L56
        r45 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L56
        goto L51
    L43:
        if ((r15 instanceof JSONArray) == false) goto L53;
    L13:
        r40 = r15;
    L56:
        th = move-exception;
        Result.Companion r47 = Result.Companion;     // Catch: Throwable -> L166
        r17 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L166:
        th = move-exception;
        Result.Companion r48 = Result.Companion;
        Object r49 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r50 = Result.exceptionOrNull-impl(r49);
        if (r50 == null) goto L171;
        EnsureManager.ensureNotReachHere(r50);
    L171:
        if (Result.isFailure-impl(r49) == true) goto L174;
        r10 = r49;
    L174:
        r19 = r10;
        goto L176
    }

    @SettingPanel("商详网络错误码相关配置")
    public static Map s() {
        int r0 = com.bytedance.android.ec.base.settings.b.a;
        Object r1 = new HashMap();
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r11 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L172
        Object r12 = null;
        r11.getClass();     // Catch: Throwable -> L59
        Object r13 = SDKSettingsCacheManager.b.get("iesec_pdp_network_error_code_config_map");     // Catch: Throwable -> L59
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
        if ((r15 instanceof HashMap) == true) goto L70;
        r15 = null;
    L70:
        Object r17 = (HashMap) r15;     // Catch: Throwable -> L172
        if (r17 != null) goto L77;
        r11.getClass();     // Catch: Throwable -> L172
        Object r18 = SDKSettingsCacheManager.a.get("iesec_pdp_network_error_code_config_map");     // Catch: Throwable -> L172
        if ((r18 instanceof HashMap) == true) goto L76;
        r18 = null;
    L76:
        r17 = (HashMap) r18;     // Catch: Throwable -> L172
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
        SDKSettingsCacheManager.e("iesec_pdp_network_error_code_config_map", r17);     // Catch: Throwable -> L172
        goto L182
    L185:
        r21 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_pdp_network_error_code_config_map", HashMap.class, r1);     // Catch: Throwable -> L166
    L167:
        if (r21 != null) goto L169;
        r17 = r1;
    L166:
        r21 = r1;
        goto L167
    L191:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L133
        Object r22 = SDKSettingsCacheManager.b.get("iesec_pdp_network_error_code_config_map");     // Catch: Throwable -> L133
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
        if ((r24 instanceof HashMap) == true) goto L144;
        r24 = null;
    L144:
        r21 = (HashMap) r24;     // Catch: Throwable -> L159
        if (r21 != null) goto L169;
        jj4.b r26 = jj4.b.b;     // Catch: Throwable -> L159
        Object r27 = jj4.a.a("iesec_pdp_network_error_code_config_map", HashMap.class, r1, false);     // Catch: Throwable -> L159
        if (r27 != null) goto L151;
        Intrinsics.throwNpe();     // Catch: Throwable -> L159
    L151:
        if ((r27 instanceof HashMap) == false) goto L154;
        r12 = r27;
    L154:
        Object r28 = (HashMap) r12;     // Catch: Throwable -> L159
        if (r28 != null) goto L157;
        r28 = r1;
    L157:
        r21 = Result.constructor-impl(r28);     // Catch: Throwable -> L159
    L85:
        if ((r22 instanceof HashMap) == true) goto L87;
        Object r29 = null;
    L88:
        r23 = (HashMap) r29;     // Catch: Throwable -> L133
        if (r23 != null) goto L131;
        if ((r22 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(HashMap.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r30 = Float.valueOf(((Number) r22).floatValue());     // Catch: Throwable -> L133
        if ((r30 instanceof HashMap) == true) goto L98;
        r30 = null;
    L98:
        r23 = (HashMap) r30;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(HashMap.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r31 = Double.valueOf(((Number) r22).doubleValue());     // Catch: Throwable -> L133
        if ((r31 instanceof HashMap) == true) goto L104;
        r31 = null;
    L104:
        r23 = (HashMap) r31;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(HashMap.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r32 = Integer.valueOf(((Number) r22).intValue());     // Catch: Throwable -> L133
        if ((r32 instanceof HashMap) == true) goto L110;
        r32 = null;
    L110:
        r23 = (HashMap) r32;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(HashMap.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r33 = Long.valueOf(((Number) r22).longValue());     // Catch: Throwable -> L133
        if ((r33 instanceof HashMap) == true) goto L116;
        r33 = null;
    L116:
        r23 = (HashMap) r33;     // Catch: Throwable -> L133
    L118:
        if ((r22 instanceof JSONObject) == false) goto L120;
    L183:
        Object r34 = SDKSettingsCacheManager.a().fromJson(r22.toString(), HashMap.class);     // Catch: Throwable -> L126
        if ((r34 instanceof HashMap) == true) goto L124;
        r34 = null;
    L124:
        Object r35 = Result.constructor-impl((HashMap) r34);     // Catch: Throwable -> L126
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
        return (Map) r17;
    L11:
        if ((r13 instanceof HashMap) == true) goto L13;
        Object r38 = null;
    L14:
        r14 = (HashMap) r38;     // Catch: Throwable -> L59
        if (r14 != null) goto L57;
        if ((r13 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(HashMap.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r39 = Float.valueOf(((Number) r13).floatValue());     // Catch: Throwable -> L59
        if ((r39 instanceof HashMap) == true) goto L24;
        r39 = null;
    L24:
        r14 = (HashMap) r39;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(HashMap.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r40 = Double.valueOf(((Number) r13).doubleValue());     // Catch: Throwable -> L59
        if ((r40 instanceof HashMap) == true) goto L30;
        r40 = null;
    L30:
        r14 = (HashMap) r40;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(HashMap.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r41 = Integer.valueOf(((Number) r13).intValue());     // Catch: Throwable -> L59
        if ((r41 instanceof HashMap) == true) goto L36;
        r41 = null;
    L36:
        r14 = (HashMap) r41;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(HashMap.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r42 = Long.valueOf(((Number) r13).longValue());     // Catch: Throwable -> L59
        if ((r42 instanceof HashMap) == true) goto L42;
        r42 = null;
    L42:
        r14 = (HashMap) r42;     // Catch: Throwable -> L59
    L44:
        if ((r13 instanceof JSONObject) == false) goto L46;
    L189:
        Object r43 = SDKSettingsCacheManager.a().fromJson(r13.toString(), HashMap.class);     // Catch: Throwable -> L52
        if ((r43 instanceof HashMap) == true) goto L50;
        r43 = null;
    L50:
        Object r44 = Result.constructor-impl((HashMap) r43);     // Catch: Throwable -> L52
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

    public static final int t() {
        int r0 = j.a;
        Object r1 = 0;
        int r10 = com.bytedance.android.ec.base.settings.b.a;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L166
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L166
        SDKSettingsCacheManager r12 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L166
        Object r13 = null;
        r12.getClass();     // Catch: Throwable -> L56
        Object r14 = SDKSettingsCacheManager.b.get("iesec_ecom_pdp_update_exp");     // Catch: Throwable -> L56
        if (r14 != null) goto L11;
    L53:
        Object r15 = null;
    L54:
        Object r16 = Result.constructor-impl(r15);     // Catch: Throwable -> L56
    L58:
        Throwable r17 = Result.exceptionOrNull-impl(r16);     // Catch: Throwable -> L166
        if (r17 == null) goto L62;
        EnsureManager.ensureNotReachHere(r17);     // Catch: Throwable -> L166
    L62:
        if (Result.isFailure-impl(r16) == false) goto L65;
        r16 = null;
    L65:
        if ((r16 instanceof Integer) == true) goto L67;
        r16 = null;
    L67:
        Object r18 = (Integer) r16;     // Catch: Throwable -> L166
        if (r18 != null) goto L74;
        r12.getClass();     // Catch: Throwable -> L166
        Object r19 = SDKSettingsCacheManager.a.get("iesec_ecom_pdp_update_exp");     // Catch: Throwable -> L166
        if ((r19 instanceof Integer) == true) goto L73;
        r19 = null;
    L73:
        r18 = (Integer) r19;     // Catch: Throwable -> L166
    L74:
        if (r18 != null) goto L176;
        int r20 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L166
    L153:
        th = move-exception;
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L166
        Object r22 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L156:
        if (Result.exceptionOrNull-impl(r22) != null) goto L183;
    L163:
        r18 = r22;
    L164:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L166
        SDKSettingsCacheManager.e("iesec_ecom_pdp_update_exp", r18);     // Catch: Throwable -> L166
        goto L176
    L183:
        r22 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_ecom_pdp_update_exp", Integer.class, r1);     // Catch: Throwable -> L160
    L161:
        if (r22 != null) goto L163;
        r18 = r1;
    L160:
        r22 = r1;
        goto L161
    L189:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L127
        Object r23 = SDKSettingsCacheManager.b.get("iesec_ecom_pdp_update_exp");     // Catch: Throwable -> L127
        if (r23 != null) goto L82;
    L124:
        Object r24 = null;
    L125:
        Object r25 = Result.constructor-impl(r24);     // Catch: Throwable -> L127
    L129:
        Throwable r26 = Result.exceptionOrNull-impl(r25);     // Catch: Throwable -> L153
        if (r26 == null) goto L133;
        EnsureManager.ensureNotReachHere(r26);     // Catch: Throwable -> L153
    L133:
        if (Result.isFailure-impl(r25) == false) goto L136;
        r25 = null;
    L136:
        if ((r25 instanceof Integer) == true) goto L138;
        r25 = null;
    L138:
        Integer r27 = (Integer) r25;     // Catch: Throwable -> L153
        if (r27 == null) goto L141;
        r18 = r27;
        goto L164
    L141:
        jj4.b r28 = jj4.b.b;     // Catch: Throwable -> L153
        Object r29 = jj4.a.a("iesec_ecom_pdp_update_exp", Integer.class, r1, false);     // Catch: Throwable -> L153
        if (r29 != null) goto L145;
        Intrinsics.throwNpe();     // Catch: Throwable -> L153
    L145:
        if ((r29 instanceof Integer) == false) goto L148;
        r13 = r29;
    L148:
        Object r30 = (Integer) r13;     // Catch: Throwable -> L153
        if (r30 != null) goto L151;
        r30 = r1;
    L151:
        r22 = Result.constructor-impl(r30);     // Catch: Throwable -> L153
    L82:
        if ((r23 instanceof Integer) == true) goto L84;
        Object r31 = null;
    L85:
        r24 = (Integer) r31;     // Catch: Throwable -> L127
        if (r24 != null) goto L125;
        if ((r23 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r32 = Float.valueOf(((Number) r23).floatValue());     // Catch: Throwable -> L127
        if ((r32 instanceof Integer) == true) goto L95;
        r32 = null;
    L95:
        r24 = (Integer) r32;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r33 = Double.valueOf(((Number) r23).doubleValue());     // Catch: Throwable -> L127
        if ((r33 instanceof Integer) == true) goto L101;
        r33 = null;
    L101:
        r24 = (Integer) r33;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r24 = Integer.valueOf(((Number) r23).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r34 = Long.valueOf(((Number) r23).longValue());     // Catch: Throwable -> L127
        if ((r34 instanceof Integer) == true) goto L110;
        r34 = null;
    L110:
        r24 = (Integer) r34;     // Catch: Throwable -> L127
    L112:
        if ((r23 instanceof JSONObject) == false) goto L114;
    L181:
        Object r35 = SDKSettingsCacheManager.a().fromJson(r23.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r35 instanceof Integer) == true) goto L118;
        r35 = null;
    L118:
        Object r36 = Result.constructor-impl((Integer) r35);     // Catch: Throwable -> L120
    L122:
        r24 = r36;
        if (Result.isFailure-impl(r24) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L127
        r36 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r23 instanceof JSONArray) == false) goto L124;
    L84:
        r31 = r23;
    L127:
        th = move-exception;
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L153
        r25 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L153
    L176:
        return ((Number) r18).intValue();
    L11:
        if ((r14 instanceof Integer) == true) goto L13;
        Object r39 = null;
    L14:
        r15 = (Integer) r39;     // Catch: Throwable -> L56
        if (r15 != null) goto L54;
        if ((r14 instanceof Number) == false) goto L41;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r40 = Float.valueOf(((Number) r14).floatValue());     // Catch: Throwable -> L56
        if ((r40 instanceof Integer) == true) goto L24;
        r40 = null;
    L24:
        r15 = (Integer) r40;     // Catch: Throwable -> L56
        goto L54
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r41 = Double.valueOf(((Number) r14).doubleValue());     // Catch: Throwable -> L56
        if ((r41 instanceof Integer) == true) goto L30;
        r41 = null;
    L30:
        r15 = (Integer) r41;     // Catch: Throwable -> L56
        goto L54
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L35;
        r15 = Integer.valueOf(((Number) r14).intValue());     // Catch: Throwable -> L56
        goto L54
    L35:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L41;
        Long r42 = Long.valueOf(((Number) r14).longValue());     // Catch: Throwable -> L56
        if ((r42 instanceof Integer) == true) goto L39;
        r42 = null;
    L39:
        r15 = (Integer) r42;     // Catch: Throwable -> L56
    L41:
        if ((r14 instanceof JSONObject) == false) goto L43;
    L179:
        Object r43 = SDKSettingsCacheManager.a().fromJson(r14.toString(), Integer.class);     // Catch: Throwable -> L49
        if ((r43 instanceof Integer) == true) goto L47;
        r43 = null;
    L47:
        Object r44 = Result.constructor-impl((Integer) r43);     // Catch: Throwable -> L49
    L51:
        r15 = r44;
        if (Result.isFailure-impl(r15) == false) goto L54;
    L49:
        th = move-exception;
        Result.Companion r45 = Result.Companion;     // Catch: Throwable -> L56
        r44 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L56
        goto L51
    L43:
        if ((r14 instanceof JSONArray) == false) goto L53;
    L13:
        r39 = r14;
    L56:
        th = move-exception;
        Result.Companion r46 = Result.Companion;     // Catch: Throwable -> L166
        r16 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L166:
        th = move-exception;
        Result.Companion r47 = Result.Companion;
        Object r48 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r49 = Result.exceptionOrNull-impl(r48);
        if (r49 == null) goto L171;
        EnsureManager.ensureNotReachHere(r49);
    L171:
        if (Result.isFailure-impl(r48) == true) goto L174;
        r1 = r48;
    L174:
        r18 = r1;
        goto L176
    }

    public static final int u() {
        int r0 = j.a;
        Object r1 = 0;
        int r10 = com.bytedance.android.ec.base.settings.b.a;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L166
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L166
        SDKSettingsCacheManager r12 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L166
        Object r13 = null;
        r12.getClass();     // Catch: Throwable -> L56
        Object r14 = SDKSettingsCacheManager.b.get("iesec_pdp_fit_width");     // Catch: Throwable -> L56
        if (r14 != null) goto L11;
    L53:
        Object r15 = null;
    L54:
        Object r16 = Result.constructor-impl(r15);     // Catch: Throwable -> L56
    L58:
        Throwable r17 = Result.exceptionOrNull-impl(r16);     // Catch: Throwable -> L166
        if (r17 == null) goto L62;
        EnsureManager.ensureNotReachHere(r17);     // Catch: Throwable -> L166
    L62:
        if (Result.isFailure-impl(r16) == false) goto L65;
        r16 = null;
    L65:
        if ((r16 instanceof Integer) == true) goto L67;
        r16 = null;
    L67:
        Object r18 = (Integer) r16;     // Catch: Throwable -> L166
        if (r18 != null) goto L74;
        r12.getClass();     // Catch: Throwable -> L166
        Object r19 = SDKSettingsCacheManager.a.get("iesec_pdp_fit_width");     // Catch: Throwable -> L166
        if ((r19 instanceof Integer) == true) goto L73;
        r19 = null;
    L73:
        r18 = (Integer) r19;     // Catch: Throwable -> L166
    L74:
        if (r18 != null) goto L176;
        int r20 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L166
    L153:
        th = move-exception;
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L166
        Object r22 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L156:
        if (Result.exceptionOrNull-impl(r22) != null) goto L183;
    L163:
        r18 = r22;
    L164:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L166
        SDKSettingsCacheManager.e("iesec_pdp_fit_width", r18);     // Catch: Throwable -> L166
        goto L176
    L183:
        r22 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_pdp_fit_width", Integer.class, r1);     // Catch: Throwable -> L160
    L161:
        if (r22 != null) goto L163;
        r18 = r1;
    L160:
        r22 = r1;
        goto L161
    L189:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L127
        Object r23 = SDKSettingsCacheManager.b.get("iesec_pdp_fit_width");     // Catch: Throwable -> L127
        if (r23 != null) goto L82;
    L124:
        Object r24 = null;
    L125:
        Object r25 = Result.constructor-impl(r24);     // Catch: Throwable -> L127
    L129:
        Throwable r26 = Result.exceptionOrNull-impl(r25);     // Catch: Throwable -> L153
        if (r26 == null) goto L133;
        EnsureManager.ensureNotReachHere(r26);     // Catch: Throwable -> L153
    L133:
        if (Result.isFailure-impl(r25) == false) goto L136;
        r25 = null;
    L136:
        if ((r25 instanceof Integer) == true) goto L138;
        r25 = null;
    L138:
        Integer r27 = (Integer) r25;     // Catch: Throwable -> L153
        if (r27 == null) goto L141;
        r18 = r27;
        goto L164
    L141:
        jj4.b r28 = jj4.b.b;     // Catch: Throwable -> L153
        Object r29 = jj4.a.a("iesec_pdp_fit_width", Integer.class, r1, false);     // Catch: Throwable -> L153
        if (r29 != null) goto L145;
        Intrinsics.throwNpe();     // Catch: Throwable -> L153
    L145:
        if ((r29 instanceof Integer) == false) goto L148;
        r13 = r29;
    L148:
        Object r30 = (Integer) r13;     // Catch: Throwable -> L153
        if (r30 != null) goto L151;
        r30 = r1;
    L151:
        r22 = Result.constructor-impl(r30);     // Catch: Throwable -> L153
    L82:
        if ((r23 instanceof Integer) == true) goto L84;
        Object r31 = null;
    L85:
        r24 = (Integer) r31;     // Catch: Throwable -> L127
        if (r24 != null) goto L125;
        if ((r23 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r32 = Float.valueOf(((Number) r23).floatValue());     // Catch: Throwable -> L127
        if ((r32 instanceof Integer) == true) goto L95;
        r32 = null;
    L95:
        r24 = (Integer) r32;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r33 = Double.valueOf(((Number) r23).doubleValue());     // Catch: Throwable -> L127
        if ((r33 instanceof Integer) == true) goto L101;
        r33 = null;
    L101:
        r24 = (Integer) r33;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r24 = Integer.valueOf(((Number) r23).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r34 = Long.valueOf(((Number) r23).longValue());     // Catch: Throwable -> L127
        if ((r34 instanceof Integer) == true) goto L110;
        r34 = null;
    L110:
        r24 = (Integer) r34;     // Catch: Throwable -> L127
    L112:
        if ((r23 instanceof JSONObject) == false) goto L114;
    L181:
        Object r35 = SDKSettingsCacheManager.a().fromJson(r23.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r35 instanceof Integer) == true) goto L118;
        r35 = null;
    L118:
        Object r36 = Result.constructor-impl((Integer) r35);     // Catch: Throwable -> L120
    L122:
        r24 = r36;
        if (Result.isFailure-impl(r24) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L127
        r36 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r23 instanceof JSONArray) == false) goto L124;
    L84:
        r31 = r23;
    L127:
        th = move-exception;
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L153
        r25 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L153
    L176:
        return ((Number) r18).intValue();
    L11:
        if ((r14 instanceof Integer) == true) goto L13;
        Object r39 = null;
    L14:
        r15 = (Integer) r39;     // Catch: Throwable -> L56
        if (r15 != null) goto L54;
        if ((r14 instanceof Number) == false) goto L41;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r40 = Float.valueOf(((Number) r14).floatValue());     // Catch: Throwable -> L56
        if ((r40 instanceof Integer) == true) goto L24;
        r40 = null;
    L24:
        r15 = (Integer) r40;     // Catch: Throwable -> L56
        goto L54
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r41 = Double.valueOf(((Number) r14).doubleValue());     // Catch: Throwable -> L56
        if ((r41 instanceof Integer) == true) goto L30;
        r41 = null;
    L30:
        r15 = (Integer) r41;     // Catch: Throwable -> L56
        goto L54
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L35;
        r15 = Integer.valueOf(((Number) r14).intValue());     // Catch: Throwable -> L56
        goto L54
    L35:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L41;
        Long r42 = Long.valueOf(((Number) r14).longValue());     // Catch: Throwable -> L56
        if ((r42 instanceof Integer) == true) goto L39;
        r42 = null;
    L39:
        r15 = (Integer) r42;     // Catch: Throwable -> L56
    L41:
        if ((r14 instanceof JSONObject) == false) goto L43;
    L179:
        Object r43 = SDKSettingsCacheManager.a().fromJson(r14.toString(), Integer.class);     // Catch: Throwable -> L49
        if ((r43 instanceof Integer) == true) goto L47;
        r43 = null;
    L47:
        Object r44 = Result.constructor-impl((Integer) r43);     // Catch: Throwable -> L49
    L51:
        r15 = r44;
        if (Result.isFailure-impl(r15) == false) goto L54;
    L49:
        th = move-exception;
        Result.Companion r45 = Result.Companion;     // Catch: Throwable -> L56
        r44 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L56
        goto L51
    L43:
        if ((r14 instanceof JSONArray) == false) goto L53;
    L13:
        r39 = r14;
    L56:
        th = move-exception;
        Result.Companion r46 = Result.Companion;     // Catch: Throwable -> L166
        r16 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L166:
        th = move-exception;
        Result.Companion r47 = Result.Companion;
        Object r48 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r49 = Result.exceptionOrNull-impl(r48);
        if (r49 == null) goto L171;
        EnsureManager.ensureNotReachHere(r49);
    L171:
        if (Result.isFailure-impl(r48) == true) goto L174;
        r1 = r48;
    L174:
        r18 = r1;
        goto L176
    }

    @SettingPanel("不出重试按钮的code名单，比如限流Code 7180")
    public static final List<Double> v() {
        jj4.b r0 = jj4.b.b;
        Object r1 = jj4.a.a("iesec_pdp_not_retry_status_code_list", List.class, new ArrayList(), false);
        if (r1 != null) goto L6;
        Intrinsics.throwNpe();
    L6:
        return (List) r1;
    }

    @SettingPanel("商详播放器交互动态化")
    public static final boolean w() {
        int r0 = com.bytedance.android.ec.base.settings.b.a;
        Object r1 = Boolean.FALSE;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r11 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L172
        Object r12 = null;
        r11.getClass();     // Catch: Throwable -> L59
        Object r13 = SDKSettingsCacheManager.b.get("iesec_pdp_player_dynamic_interactor");     // Catch: Throwable -> L59
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
        Object r18 = SDKSettingsCacheManager.a.get("iesec_pdp_player_dynamic_interactor");     // Catch: Throwable -> L172
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
        SDKSettingsCacheManager.e("iesec_pdp_player_dynamic_interactor", r17);     // Catch: Throwable -> L172
        goto L182
    L185:
        r21 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_pdp_player_dynamic_interactor", Boolean.class, r1);     // Catch: Throwable -> L166
    L167:
        if (r21 != null) goto L169;
        r17 = r1;
    L166:
        r21 = r1;
        goto L167
    L191:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L133
        Object r22 = SDKSettingsCacheManager.b.get("iesec_pdp_player_dynamic_interactor");     // Catch: Throwable -> L133
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
        Object r27 = jj4.a.a("iesec_pdp_player_dynamic_interactor", Boolean.class, r1, false);     // Catch: Throwable -> L159
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

    @SettingPanel("商详刷新全量使用chunk接口")
    public static final boolean x() {
        int r0 = j.a;
        Object r1 = Boolean.FALSE;
        int r10 = com.bytedance.android.ec.base.settings.b.a;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r12 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L172
        Object r13 = null;
        r12.getClass();     // Catch: Throwable -> L59
        Object r14 = SDKSettingsCacheManager.b.get("detail_refresh_use_chunk");     // Catch: Throwable -> L59
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
        Object r19 = SDKSettingsCacheManager.a.get("detail_refresh_use_chunk");     // Catch: Throwable -> L172
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
        SDKSettingsCacheManager.e("detail_refresh_use_chunk", r18);     // Catch: Throwable -> L172
        goto L182
    L185:
        r22 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("detail_refresh_use_chunk", Boolean.class, r1);     // Catch: Throwable -> L166
    L167:
        if (r22 != null) goto L169;
        r18 = r1;
    L166:
        r22 = r1;
        goto L167
    L191:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L133
        Object r23 = SDKSettingsCacheManager.b.get("detail_refresh_use_chunk");     // Catch: Throwable -> L133
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
        Object r28 = jj4.a.a("detail_refresh_use_chunk", Boolean.class, r1, false);     // Catch: Throwable -> L159
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

    @SettingPanel("商详无效刷新治理-已固化")
    public static final boolean y() {
        jj4.b r0 = jj4.b.b;
        int r1 = e.a;
        Object r10 = jj4.a.a("detail_return_pdp_refresh_opt", Boolean.class, e.a(Boolean.TRUE, Boolean.FALSE), false);
        if (r10 != null) goto L6;
        Intrinsics.throwNpe();
    L6:
        return ((Boolean) r10).booleanValue();
    }

    public static final boolean z() {
        int r0 = j.a;
        Object r1 = Boolean.FALSE;
        int r10 = com.bytedance.android.ec.base.settings.b.a;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r12 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L172
        Object r13 = null;
        r12.getClass();     // Catch: Throwable -> L59
        Object r14 = SDKSettingsCacheManager.b.get("iesec_pdp_first_enter_use_chunk");     // Catch: Throwable -> L59
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
        Object r19 = SDKSettingsCacheManager.a.get("iesec_pdp_first_enter_use_chunk");     // Catch: Throwable -> L172
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
        SDKSettingsCacheManager.e("iesec_pdp_first_enter_use_chunk", r18);     // Catch: Throwable -> L172
        goto L182
    L185:
        r22 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_pdp_first_enter_use_chunk", Boolean.class, r1);     // Catch: Throwable -> L166
    L167:
        if (r22 != null) goto L169;
        r18 = r1;
    L166:
        r22 = r1;
        goto L167
    L191:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L133
        Object r23 = SDKSettingsCacheManager.b.get("iesec_pdp_first_enter_use_chunk");     // Catch: Throwable -> L133
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
        Object r28 = jj4.a.a("iesec_pdp_first_enter_use_chunk", Boolean.class, r1, false);     // Catch: Throwable -> L159
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
