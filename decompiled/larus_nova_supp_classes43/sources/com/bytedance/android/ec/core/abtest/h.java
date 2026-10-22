package com.bytedance.android.ec.core.abtest;

import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.core.opt.ab.n;
import com.bytedance.android.ec.core.opt.ab.p;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.services.apm.api.EnsureManager;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class h {
    public static volatile boolean a;
    public static ECSettingsConfig b;
    public static Boolean c;

    static {
        new ConcurrentHashMap();
    }

    public static boolean a() {
        if (c != null) goto L176;
        int r0 = com.bytedance.android.ec.core.opt.ab.c.a;
        int r1 = n.a;
        Object r10 = 0;
        int r11 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L162
        Object r13 = null;
        Object r14 = com.bytedance.android.ec.base.settings.d.c.get("ecom_host_settings_opt_enable");     // Catch: Throwable -> L56
        if (r14 != null) goto L11;
    L53:
        Object r15 = null;
    L54:
        Object r16 = Result.constructor-impl(r15);     // Catch: Throwable -> L56
    L58:
        Throwable r17 = Result.exceptionOrNull-impl(r16);     // Catch: Throwable -> L162
        if (r17 == null) goto L62;
        EnsureManager.ensureNotReachHere(r17);     // Catch: Throwable -> L162
    L62:
        if (Result.isFailure-impl(r16) == false) goto L65;
        r16 = null;
    L65:
        if ((r16 instanceof Integer) == true) goto L67;
        r16 = null;
    L67:
        Object r18 = (Integer) r16;     // Catch: Throwable -> L162
        if (r18 != null) goto L74;
        Object r19 = com.bytedance.android.ec.base.settings.d.a.get("ecom_host_settings_opt_enable");     // Catch: Throwable -> L162
        if ((r19 instanceof Integer) == true) goto L73;
        r19 = null;
    L73:
        r18 = (Integer) r19;     // Catch: Throwable -> L162
    L74:
        if (r18 != null) goto L172;
        int r20 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L162
        Object r21 = com.bytedance.android.ec.base.settings.d.c.get("ecom_host_settings_opt_enable");     // Catch: Throwable -> L126
        if (r21 != null) goto L81;
    L123:
        Object r22 = null;
    L124:
        Object r23 = Result.constructor-impl(r22);     // Catch: Throwable -> L126
    L128:
        Throwable r24 = Result.exceptionOrNull-impl(r23);     // Catch: Throwable -> L152
        if (r24 == null) goto L132;
        EnsureManager.ensureNotReachHere(r24);     // Catch: Throwable -> L152
    L132:
        if (Result.isFailure-impl(r23) == false) goto L135;
        r23 = null;
    L135:
        if ((r23 instanceof Integer) == true) goto L137;
        r23 = null;
    L137:
        r18 = (Integer) r23;     // Catch: Throwable -> L152
        if (r18 != null) goto L160;
        IHybridHostService r25 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L152
        if (r25 == null) goto L143;
        Object r26 = r25.getHostABValue("ecom_host_settings_opt_enable", r10);     // Catch: Throwable -> L152
    L144:
        if (r26 != null) goto L146;
    L151:
        r18 = r10;
        goto L160
    L146:
        if ((r26 instanceof Integer) == false) goto L149;
        r13 = r26;
    L149:
        Object r27 = (Integer) r13;     // Catch: Throwable -> L152
        if (r27 == null) goto L151;
    L159:
        r18 = r27;
        goto L160
    L143:
        r26 = null;
    L160:
        com.bytedance.android.ec.base.settings.d.d("ecom_host_settings_opt_enable", r18);     // Catch: Throwable -> L162
        goto L172
    L81:
        if ((r21 instanceof Integer) == true) goto L83;
        Object r28 = null;
    L84:
        r22 = (Integer) r28;     // Catch: Throwable -> L126
        if (r22 != null) goto L124;
        if ((r21 instanceof Number) == false) goto L111;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L96;
        Float r29 = Float.valueOf(((Number) r21).floatValue());     // Catch: Throwable -> L126
        if ((r29 instanceof Integer) == true) goto L94;
        r29 = null;
    L94:
        r22 = (Integer) r29;     // Catch: Throwable -> L126
        goto L124
    L96:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L102;
        Double r30 = Double.valueOf(((Number) r21).doubleValue());     // Catch: Throwable -> L126
        if ((r30 instanceof Integer) == true) goto L100;
        r30 = null;
    L100:
        r22 = (Integer) r30;     // Catch: Throwable -> L126
        goto L124
    L102:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L105;
        r22 = Integer.valueOf(((Number) r21).intValue());     // Catch: Throwable -> L126
        goto L124
    L105:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L111;
        Long r31 = Long.valueOf(((Number) r21).longValue());     // Catch: Throwable -> L126
        if ((r31 instanceof Integer) == true) goto L109;
        r31 = null;
    L109:
        r22 = (Integer) r31;     // Catch: Throwable -> L126
    L111:
        if ((r21 instanceof JSONObject) == false) goto L113;
    L186:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L119
        Object r32 = SDKSettingsCacheManager.a().fromJson(r21.toString(), Integer.class);     // Catch: Throwable -> L119
        if ((r32 instanceof Integer) == true) goto L117;
        r32 = null;
    L117:
        Object r33 = Result.constructor-impl((Integer) r32);     // Catch: Throwable -> L119
    L121:
        r22 = r33;
        if (Result.isFailure-impl(r22) == false) goto L124;
    L119:
        th = move-exception;
        Result.Companion r34 = Result.Companion;     // Catch: Throwable -> L126
        r33 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L126
        goto L121
    L113:
        if ((r21 instanceof JSONArray) == false) goto L123;
    L83:
        r28 = r21;
    L152:
        th = move-exception;
        Result.Companion r35 = Result.Companion;     // Catch: Throwable -> L162
        r27 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L162
        Throwable r36 = Result.exceptionOrNull-impl(r27);     // Catch: Throwable -> L162
        if (r36 == null) goto L157;
        EnsureManager.ensureNotReachHere(r36);     // Catch: Throwable -> L162
    L157:
        if (Result.isFailure-impl(r27) == false) goto L159;
        r27 = r10;
    L126:
        th = move-exception;
        Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L152
        r23 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L152
    L172:
        if (((Number) r18).intValue() != 1) goto L174;
        boolean r38 = true;
    L175:
        c = Boolean.valueOf(r38);
        goto L176
    L174:
        r38 = false;
        goto L175
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
    L184:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L49
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
        Result.Companion r46 = Result.Companion;     // Catch: Throwable -> L162
        r16 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L162
    L162:
        th = move-exception;
        Result.Companion r47 = Result.Companion;
        Object r48 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r49 = Result.exceptionOrNull-impl(r48);
        if (r49 == null) goto L167;
        EnsureManager.ensureNotReachHere(r49);
    L167:
        if (Result.isFailure-impl(r48) == true) goto L170;
        r10 = r48;
    L170:
        r18 = r10;
    L176:
        ECSettingsConfig r50 = b();
        if (r50 != null) goto L179;
        return false;
    L179:
        if (r50.getPreloadEnable() == true) goto L181;
        return false;
    L181:
        if (Intrinsics.areEqual(c, Boolean.TRUE) == false) goto L197;
        return true;
    L197:
        return false;
    }

    public static ECSettingsConfig b() {
        if (b != null) goto L19;
        if (a == false) goto L19;
        Lazy r0 = ECSettingKeys.a;
        int r1 = p.a;
        Object r11 = new ECSettingsConfig(false, false, 0, 0, 0, 31, null);
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L11
        jj4.b r12 = jj4.b.b;     // Catch: Throwable -> L11
        Object r13 = jj4.a.a("ecom_shop_settings_opt_config", ECSettingsConfig.class, r11, false);     // Catch: Throwable -> L11
        if (r13 != null) goto L17;
        Intrinsics.throwNpe();     // Catch: Throwable -> L11
    L17:
        b = (ECSettingsConfig) r13;
    L11:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        Object r15 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r15) == true) goto L16;
        r11 = r15;
    L16:
        r13 = r11;
    L19:
        return b;
    }
}
