package com.bytedance.android.ec.core.opt.ab;

import com.bytedance.android.ec.ab.opt.HostExperimentKey;
import com.bytedance.android.ec.ab.opt.OptSetting;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.services.apm.api.EnsureManager;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@OptSetting(business = "交易标准化能力开关")
public final class u {
    public static final /* synthetic */ int a = 0;

    @HostExperimentKey
    public static final int b() {
        int r0 = m.a;
        Object r1 = 0;
        boolean r10 = ECServiceManager.a;
        s83.g r11 = (s83.g) ECServiceManager.c(s83.g.class);
        if (r11 == null) goto L8;
        s83.a r12 = r11.q();
        if (r12 == null) goto L8;
        Object r13 = r12.e("shopping_abilities_enter_cart");
        if (r13 == null) goto L8;
    L175:
        return ((Number) r13).intValue();
    L8:
        int r14 = n.a;
        int r15 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L165
        Object r17 = null;
        Object r18 = com.bytedance.android.ec.base.settings.d.c.get("shopping_abilities_enter_cart");     // Catch: Throwable -> L60
        if (r18 != null) goto L15;
    L57:
        Object r19 = null;
    L58:
        Object r20 = Result.constructor-impl(r19);     // Catch: Throwable -> L60
    L62:
        Throwable r21 = Result.exceptionOrNull-impl(r20);     // Catch: Throwable -> L165
        if (r21 == null) goto L66;
        EnsureManager.ensureNotReachHere(r21);     // Catch: Throwable -> L165
    L66:
        if (Result.isFailure-impl(r20) == false) goto L69;
        r20 = null;
    L69:
        if ((r20 instanceof Integer) == true) goto L71;
        r20 = null;
    L71:
        Integer r22 = (Integer) r20;     // Catch: Throwable -> L165
        if (r22 != null) goto L78;
        Object r23 = com.bytedance.android.ec.base.settings.d.a.get("shopping_abilities_enter_cart");     // Catch: Throwable -> L165
        if ((r23 instanceof Integer) == true) goto L77;
        r23 = null;
    L77:
        r22 = (Integer) r23;     // Catch: Throwable -> L165
    L78:
        if (r22 == null) goto L80;
        r13 = r22;
        goto L175
    L80:
        int r24 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L165
        Object r25 = com.bytedance.android.ec.base.settings.d.c.get("shopping_abilities_enter_cart");     // Catch: Throwable -> L130
        if (r25 != null) goto L85;
    L127:
        Object r26 = null;
    L128:
        Object r27 = Result.constructor-impl(r26);     // Catch: Throwable -> L130
    L132:
        Throwable r28 = Result.exceptionOrNull-impl(r27);     // Catch: Throwable -> L156
        if (r28 == null) goto L136;
        EnsureManager.ensureNotReachHere(r28);     // Catch: Throwable -> L156
    L136:
        if (Result.isFailure-impl(r27) == false) goto L139;
        r27 = null;
    L139:
        if ((r27 instanceof Integer) == true) goto L141;
        r27 = null;
    L141:
        Integer r29 = (Integer) r27;     // Catch: Throwable -> L156
        if (r29 == null) goto L144;
        r13 = r29;
    L163:
        com.bytedance.android.ec.base.settings.d.d("shopping_abilities_enter_cart", r13);     // Catch: Throwable -> L165
        goto L175
    L144:
        IHybridHostService r30 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r30 == null) goto L147;
        Object r31 = r30.getHostABValue("shopping_abilities_enter_cart", r1);     // Catch: Throwable -> L156
    L148:
        if (r31 != null) goto L150;
    L162:
        r13 = r1;
        goto L163
    L150:
        if ((r31 instanceof Integer) == false) goto L153;
        r17 = r31;
    L153:
        r13 = (Integer) r17;     // Catch: Throwable -> L156
        if (r13 != null) goto L163;
    L147:
        r31 = null;
        goto L148
    L85:
        if ((r25 instanceof Integer) == true) goto L87;
        Object r32 = null;
    L88:
        r26 = (Integer) r32;     // Catch: Throwable -> L130
        if (r26 != null) goto L128;
        if ((r25 instanceof Number) == false) goto L115;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r33 = Float.valueOf(((Number) r25).floatValue());     // Catch: Throwable -> L130
        if ((r33 instanceof Integer) == true) goto L98;
        r33 = null;
    L98:
        r26 = (Integer) r33;     // Catch: Throwable -> L130
        goto L128
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r34 = Double.valueOf(((Number) r25).doubleValue());     // Catch: Throwable -> L130
        if ((r34 instanceof Integer) == true) goto L104;
        r34 = null;
    L104:
        r26 = (Integer) r34;     // Catch: Throwable -> L130
        goto L128
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L109;
        r26 = Integer.valueOf(((Number) r25).intValue());     // Catch: Throwable -> L130
        goto L128
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L115;
        Long r35 = Long.valueOf(((Number) r25).longValue());     // Catch: Throwable -> L130
        if ((r35 instanceof Integer) == true) goto L113;
        r35 = null;
    L113:
        r26 = (Integer) r35;     // Catch: Throwable -> L130
    L115:
        if ((r25 instanceof JSONObject) == false) goto L117;
    L183:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L123
        Object r36 = SDKSettingsCacheManager.a().fromJson(r25.toString(), Integer.class);     // Catch: Throwable -> L123
        if ((r36 instanceof Integer) == true) goto L121;
        r36 = null;
    L121:
        Object r37 = Result.constructor-impl((Integer) r36);     // Catch: Throwable -> L123
    L125:
        r26 = r37;
        if (Result.isFailure-impl(r26) == false) goto L128;
    L123:
        th = move-exception;
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L130
        r37 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L130
        goto L125
    L117:
        if ((r25 instanceof JSONArray) == false) goto L127;
    L87:
        r32 = r25;
    L156:
        th = move-exception;
        Result.Companion r39 = Result.Companion;     // Catch: Throwable -> L165
        r13 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L165
        Throwable r40 = Result.exceptionOrNull-impl(r13);     // Catch: Throwable -> L165
        if (r40 == null) goto L161;
        EnsureManager.ensureNotReachHere(r40);     // Catch: Throwable -> L165
    L161:
        if (Result.isFailure-impl(r13) == false) goto L163;
    L130:
        th = move-exception;
        Result.Companion r41 = Result.Companion;     // Catch: Throwable -> L156
        r27 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L156
        goto L132
    L15:
        if ((r18 instanceof Integer) == true) goto L17;
        Object r42 = null;
    L18:
        r19 = (Integer) r42;     // Catch: Throwable -> L60
        if (r19 != null) goto L58;
        if ((r18 instanceof Number) == false) goto L45;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L30;
        Float r43 = Float.valueOf(((Number) r18).floatValue());     // Catch: Throwable -> L60
        if ((r43 instanceof Integer) == true) goto L28;
        r43 = null;
    L28:
        r19 = (Integer) r43;     // Catch: Throwable -> L60
        goto L58
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L36;
        Double r44 = Double.valueOf(((Number) r18).doubleValue());     // Catch: Throwable -> L60
        if ((r44 instanceof Integer) == true) goto L34;
        r44 = null;
    L34:
        r19 = (Integer) r44;     // Catch: Throwable -> L60
        goto L58
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L39;
        r19 = Integer.valueOf(((Number) r18).intValue());     // Catch: Throwable -> L60
        goto L58
    L39:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L45;
        Long r45 = Long.valueOf(((Number) r18).longValue());     // Catch: Throwable -> L60
        if ((r45 instanceof Integer) == true) goto L43;
        r45 = null;
    L43:
        r19 = (Integer) r45;     // Catch: Throwable -> L60
    L45:
        if ((r18 instanceof JSONObject) == false) goto L47;
    L181:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L53
        Object r46 = SDKSettingsCacheManager.a().fromJson(r18.toString(), Integer.class);     // Catch: Throwable -> L53
        if ((r46 instanceof Integer) == true) goto L51;
        r46 = null;
    L51:
        Object r47 = Result.constructor-impl((Integer) r46);     // Catch: Throwable -> L53
    L55:
        r19 = r47;
        if (Result.isFailure-impl(r19) == false) goto L58;
    L53:
        th = move-exception;
        Result.Companion r48 = Result.Companion;     // Catch: Throwable -> L60
        r47 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L60
        goto L55
    L47:
        if ((r18 instanceof JSONArray) == false) goto L57;
    L17:
        r42 = r18;
    L60:
        th = move-exception;
        Result.Companion r49 = Result.Companion;     // Catch: Throwable -> L165
        r20 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L165
    L165:
        th = move-exception;
        Result.Companion r50 = Result.Companion;
        Object r51 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r52 = Result.exceptionOrNull-impl(r51);
        if (r52 == null) goto L170;
        EnsureManager.ensureNotReachHere(r52);
    L170:
        if (Result.isFailure-impl(r51) == true) goto L173;
        r1 = r51;
    L173:
        r13 = r1;
        goto L175
    }

    @HostExperimentKey
    public static final int c() {
        int r0 = m.a;
        Object r1 = 0;
        boolean r10 = ECServiceManager.a;
        s83.g r11 = (s83.g) ECServiceManager.c(s83.g.class);
        if (r11 == null) goto L8;
        s83.a r12 = r11.q();
        if (r12 == null) goto L8;
        Object r13 = r12.e("shopping_abilities_open_im");
        if (r13 == null) goto L8;
    L175:
        return ((Number) r13).intValue();
    L8:
        int r14 = n.a;
        int r15 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L165
        Object r17 = null;
        Object r18 = com.bytedance.android.ec.base.settings.d.c.get("shopping_abilities_open_im");     // Catch: Throwable -> L60
        if (r18 != null) goto L15;
    L57:
        Object r19 = null;
    L58:
        Object r20 = Result.constructor-impl(r19);     // Catch: Throwable -> L60
    L62:
        Throwable r21 = Result.exceptionOrNull-impl(r20);     // Catch: Throwable -> L165
        if (r21 == null) goto L66;
        EnsureManager.ensureNotReachHere(r21);     // Catch: Throwable -> L165
    L66:
        if (Result.isFailure-impl(r20) == false) goto L69;
        r20 = null;
    L69:
        if ((r20 instanceof Integer) == true) goto L71;
        r20 = null;
    L71:
        Integer r22 = (Integer) r20;     // Catch: Throwable -> L165
        if (r22 != null) goto L78;
        Object r23 = com.bytedance.android.ec.base.settings.d.a.get("shopping_abilities_open_im");     // Catch: Throwable -> L165
        if ((r23 instanceof Integer) == true) goto L77;
        r23 = null;
    L77:
        r22 = (Integer) r23;     // Catch: Throwable -> L165
    L78:
        if (r22 == null) goto L80;
        r13 = r22;
        goto L175
    L80:
        int r24 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L165
        Object r25 = com.bytedance.android.ec.base.settings.d.c.get("shopping_abilities_open_im");     // Catch: Throwable -> L130
        if (r25 != null) goto L85;
    L127:
        Object r26 = null;
    L128:
        Object r27 = Result.constructor-impl(r26);     // Catch: Throwable -> L130
    L132:
        Throwable r28 = Result.exceptionOrNull-impl(r27);     // Catch: Throwable -> L156
        if (r28 == null) goto L136;
        EnsureManager.ensureNotReachHere(r28);     // Catch: Throwable -> L156
    L136:
        if (Result.isFailure-impl(r27) == false) goto L139;
        r27 = null;
    L139:
        if ((r27 instanceof Integer) == true) goto L141;
        r27 = null;
    L141:
        Integer r29 = (Integer) r27;     // Catch: Throwable -> L156
        if (r29 == null) goto L144;
        r13 = r29;
    L163:
        com.bytedance.android.ec.base.settings.d.d("shopping_abilities_open_im", r13);     // Catch: Throwable -> L165
        goto L175
    L144:
        IHybridHostService r30 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r30 == null) goto L147;
        Object r31 = r30.getHostABValue("shopping_abilities_open_im", r1);     // Catch: Throwable -> L156
    L148:
        if (r31 != null) goto L150;
    L162:
        r13 = r1;
        goto L163
    L150:
        if ((r31 instanceof Integer) == false) goto L153;
        r17 = r31;
    L153:
        r13 = (Integer) r17;     // Catch: Throwable -> L156
        if (r13 != null) goto L163;
    L147:
        r31 = null;
        goto L148
    L85:
        if ((r25 instanceof Integer) == true) goto L87;
        Object r32 = null;
    L88:
        r26 = (Integer) r32;     // Catch: Throwable -> L130
        if (r26 != null) goto L128;
        if ((r25 instanceof Number) == false) goto L115;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r33 = Float.valueOf(((Number) r25).floatValue());     // Catch: Throwable -> L130
        if ((r33 instanceof Integer) == true) goto L98;
        r33 = null;
    L98:
        r26 = (Integer) r33;     // Catch: Throwable -> L130
        goto L128
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r34 = Double.valueOf(((Number) r25).doubleValue());     // Catch: Throwable -> L130
        if ((r34 instanceof Integer) == true) goto L104;
        r34 = null;
    L104:
        r26 = (Integer) r34;     // Catch: Throwable -> L130
        goto L128
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L109;
        r26 = Integer.valueOf(((Number) r25).intValue());     // Catch: Throwable -> L130
        goto L128
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L115;
        Long r35 = Long.valueOf(((Number) r25).longValue());     // Catch: Throwable -> L130
        if ((r35 instanceof Integer) == true) goto L113;
        r35 = null;
    L113:
        r26 = (Integer) r35;     // Catch: Throwable -> L130
    L115:
        if ((r25 instanceof JSONObject) == false) goto L117;
    L183:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L123
        Object r36 = SDKSettingsCacheManager.a().fromJson(r25.toString(), Integer.class);     // Catch: Throwable -> L123
        if ((r36 instanceof Integer) == true) goto L121;
        r36 = null;
    L121:
        Object r37 = Result.constructor-impl((Integer) r36);     // Catch: Throwable -> L123
    L125:
        r26 = r37;
        if (Result.isFailure-impl(r26) == false) goto L128;
    L123:
        th = move-exception;
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L130
        r37 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L130
        goto L125
    L117:
        if ((r25 instanceof JSONArray) == false) goto L127;
    L87:
        r32 = r25;
    L156:
        th = move-exception;
        Result.Companion r39 = Result.Companion;     // Catch: Throwable -> L165
        r13 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L165
        Throwable r40 = Result.exceptionOrNull-impl(r13);     // Catch: Throwable -> L165
        if (r40 == null) goto L161;
        EnsureManager.ensureNotReachHere(r40);     // Catch: Throwable -> L165
    L161:
        if (Result.isFailure-impl(r13) == false) goto L163;
    L130:
        th = move-exception;
        Result.Companion r41 = Result.Companion;     // Catch: Throwable -> L156
        r27 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L156
        goto L132
    L15:
        if ((r18 instanceof Integer) == true) goto L17;
        Object r42 = null;
    L18:
        r19 = (Integer) r42;     // Catch: Throwable -> L60
        if (r19 != null) goto L58;
        if ((r18 instanceof Number) == false) goto L45;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L30;
        Float r43 = Float.valueOf(((Number) r18).floatValue());     // Catch: Throwable -> L60
        if ((r43 instanceof Integer) == true) goto L28;
        r43 = null;
    L28:
        r19 = (Integer) r43;     // Catch: Throwable -> L60
        goto L58
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L36;
        Double r44 = Double.valueOf(((Number) r18).doubleValue());     // Catch: Throwable -> L60
        if ((r44 instanceof Integer) == true) goto L34;
        r44 = null;
    L34:
        r19 = (Integer) r44;     // Catch: Throwable -> L60
        goto L58
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L39;
        r19 = Integer.valueOf(((Number) r18).intValue());     // Catch: Throwable -> L60
        goto L58
    L39:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L45;
        Long r45 = Long.valueOf(((Number) r18).longValue());     // Catch: Throwable -> L60
        if ((r45 instanceof Integer) == true) goto L43;
        r45 = null;
    L43:
        r19 = (Integer) r45;     // Catch: Throwable -> L60
    L45:
        if ((r18 instanceof JSONObject) == false) goto L47;
    L181:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L53
        Object r46 = SDKSettingsCacheManager.a().fromJson(r18.toString(), Integer.class);     // Catch: Throwable -> L53
        if ((r46 instanceof Integer) == true) goto L51;
        r46 = null;
    L51:
        Object r47 = Result.constructor-impl((Integer) r46);     // Catch: Throwable -> L53
    L55:
        r19 = r47;
        if (Result.isFailure-impl(r19) == false) goto L58;
    L53:
        th = move-exception;
        Result.Companion r48 = Result.Companion;     // Catch: Throwable -> L60
        r47 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L60
        goto L55
    L47:
        if ((r18 instanceof JSONArray) == false) goto L57;
    L17:
        r42 = r18;
    L60:
        th = move-exception;
        Result.Companion r49 = Result.Companion;     // Catch: Throwable -> L165
        r20 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L165
    L165:
        th = move-exception;
        Result.Companion r50 = Result.Companion;
        Object r51 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r52 = Result.exceptionOrNull-impl(r51);
        if (r52 == null) goto L170;
        EnsureManager.ensureNotReachHere(r52);
    L170:
        if (Result.isFailure-impl(r51) == true) goto L173;
        r1 = r51;
    L173:
        r13 = r1;
        goto L175
    }

    public static final int d() {
        int r0 = n.a;
        Object r1 = 0;
        int r10 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L160
        Object r12 = null;
        Object r13 = com.bytedance.android.ec.base.settings.d.c.get("shopping_abilities_open_product_detail");     // Catch: Throwable -> L54
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
        Object r18 = com.bytedance.android.ec.base.settings.d.a.get("shopping_abilities_open_product_detail");     // Catch: Throwable -> L160
        if ((r18 instanceof Integer) == true) goto L71;
        r18 = null;
    L71:
        r17 = (Integer) r18;     // Catch: Throwable -> L160
    L72:
        if (r17 != null) goto L170;
        int r19 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L160
        Object r20 = com.bytedance.android.ec.base.settings.d.c.get("shopping_abilities_open_product_detail");     // Catch: Throwable -> L124
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
        Object r25 = r24.getHostABValue("shopping_abilities_open_product_detail", r1);     // Catch: Throwable -> L150
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
        com.bytedance.android.ec.base.settings.d.d("shopping_abilities_open_product_detail", r17);     // Catch: Throwable -> L160
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

    public static boolean a() {
        if (d() != 1) goto L192;
        int r0 = m.a;
        Object r1 = 0;
        boolean r10 = ECServiceManager.a;
        s83.g r11 = (s83.g) ECServiceManager.c(s83.g.class);
        if (r11 == null) goto L10;
        s83.a r12 = r11.q();
        if (r12 == null) goto L10;
        Object r13 = r12.e("shopping_abilities_preload_product_detail");
        if (r13 == null) goto L10;
    L177:
        if (((Number) r13).intValue() != 1) goto L193;
        return true;
    L193:
        return false;
    L10:
        int r14 = n.a;
        int r15 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L167
        Object r17 = null;
        Object r18 = com.bytedance.android.ec.base.settings.d.c.get("shopping_abilities_preload_product_detail");     // Catch: Throwable -> L62
        if (r18 != null) goto L17;
    L59:
        Object r19 = null;
    L60:
        Object r20 = Result.constructor-impl(r19);     // Catch: Throwable -> L62
    L64:
        Throwable r21 = Result.exceptionOrNull-impl(r20);     // Catch: Throwable -> L167
        if (r21 == null) goto L68;
        EnsureManager.ensureNotReachHere(r21);     // Catch: Throwable -> L167
    L68:
        if (Result.isFailure-impl(r20) == false) goto L71;
        r20 = null;
    L71:
        if ((r20 instanceof Integer) == true) goto L73;
        r20 = null;
    L73:
        Integer r22 = (Integer) r20;     // Catch: Throwable -> L167
        if (r22 != null) goto L80;
        Object r23 = com.bytedance.android.ec.base.settings.d.a.get("shopping_abilities_preload_product_detail");     // Catch: Throwable -> L167
        if ((r23 instanceof Integer) == true) goto L79;
        r23 = null;
    L79:
        r22 = (Integer) r23;     // Catch: Throwable -> L167
    L80:
        if (r22 == null) goto L82;
        r13 = r22;
        goto L177
    L82:
        int r24 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L167
        Object r25 = com.bytedance.android.ec.base.settings.d.c.get("shopping_abilities_preload_product_detail");     // Catch: Throwable -> L132
        if (r25 != null) goto L87;
    L129:
        Object r26 = null;
    L130:
        Object r27 = Result.constructor-impl(r26);     // Catch: Throwable -> L132
    L134:
        Throwable r28 = Result.exceptionOrNull-impl(r27);     // Catch: Throwable -> L158
        if (r28 == null) goto L138;
        EnsureManager.ensureNotReachHere(r28);     // Catch: Throwable -> L158
    L138:
        if (Result.isFailure-impl(r27) == false) goto L141;
        r27 = null;
    L141:
        if ((r27 instanceof Integer) == true) goto L143;
        r27 = null;
    L143:
        Integer r29 = (Integer) r27;     // Catch: Throwable -> L158
        if (r29 == null) goto L146;
        r13 = r29;
    L165:
        com.bytedance.android.ec.base.settings.d.d("shopping_abilities_preload_product_detail", r13);     // Catch: Throwable -> L167
        goto L177
    L146:
        IHybridHostService r30 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L158
        if (r30 == null) goto L149;
        Object r31 = r30.getHostABValue("shopping_abilities_preload_product_detail", r1);     // Catch: Throwable -> L158
    L150:
        if (r31 != null) goto L152;
    L164:
        r13 = r1;
        goto L165
    L152:
        if ((r31 instanceof Integer) == false) goto L155;
        r17 = r31;
    L155:
        r13 = (Integer) r17;     // Catch: Throwable -> L158
        if (r13 != null) goto L165;
    L158:
        th = move-exception;
        Result.Companion r32 = Result.Companion;     // Catch: Throwable -> L167
        r13 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L167
        Throwable r33 = Result.exceptionOrNull-impl(r13);     // Catch: Throwable -> L167
        if (r33 == null) goto L163;
        EnsureManager.ensureNotReachHere(r33);     // Catch: Throwable -> L167
    L163:
        if (Result.isFailure-impl(r13) == false) goto L165;
    L149:
        r31 = null;
        goto L150
    L87:
        if ((r25 instanceof Integer) == true) goto L89;
        Object r34 = null;
    L90:
        r26 = (Integer) r34;     // Catch: Throwable -> L132
        if (r26 != null) goto L130;
        if ((r25 instanceof Number) == false) goto L117;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L102;
        Float r35 = Float.valueOf(((Number) r25).floatValue());     // Catch: Throwable -> L132
        if ((r35 instanceof Integer) == true) goto L100;
        r35 = null;
    L100:
        r26 = (Integer) r35;     // Catch: Throwable -> L132
        goto L130
    L102:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L108;
        Double r36 = Double.valueOf(((Number) r25).doubleValue());     // Catch: Throwable -> L132
        if ((r36 instanceof Integer) == true) goto L106;
        r36 = null;
    L106:
        r26 = (Integer) r36;     // Catch: Throwable -> L132
        goto L130
    L108:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L111;
        r26 = Integer.valueOf(((Number) r25).intValue());     // Catch: Throwable -> L132
        goto L130
    L111:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L117;
        Long r37 = Long.valueOf(((Number) r25).longValue());     // Catch: Throwable -> L132
        if ((r37 instanceof Integer) == true) goto L115;
        r37 = null;
    L115:
        r26 = (Integer) r37;     // Catch: Throwable -> L132
    L117:
        if ((r25 instanceof JSONObject) == false) goto L119;
    L180:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L125
        Object r38 = SDKSettingsCacheManager.a().fromJson(r25.toString(), Integer.class);     // Catch: Throwable -> L125
        if ((r38 instanceof Integer) == true) goto L123;
        r38 = null;
    L123:
        Object r39 = Result.constructor-impl((Integer) r38);     // Catch: Throwable -> L125
    L127:
        r26 = r39;
        if (Result.isFailure-impl(r26) == false) goto L130;
    L125:
        th = move-exception;
        Result.Companion r40 = Result.Companion;     // Catch: Throwable -> L132
        r39 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L132
        goto L127
    L119:
        if ((r25 instanceof JSONArray) == false) goto L129;
    L89:
        r34 = r25;
    L132:
        th = move-exception;
        Result.Companion r41 = Result.Companion;     // Catch: Throwable -> L158
        r27 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L158
        goto L134
    L17:
        if ((r18 instanceof Integer) == true) goto L19;
        Object r42 = null;
    L20:
        r19 = (Integer) r42;     // Catch: Throwable -> L62
        if (r19 != null) goto L60;
        if ((r18 instanceof Number) == false) goto L47;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L32;
        Float r43 = Float.valueOf(((Number) r18).floatValue());     // Catch: Throwable -> L62
        if ((r43 instanceof Integer) == true) goto L30;
        r43 = null;
    L30:
        r19 = (Integer) r43;     // Catch: Throwable -> L62
        goto L60
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L38;
        Double r44 = Double.valueOf(((Number) r18).doubleValue());     // Catch: Throwable -> L62
        if ((r44 instanceof Integer) == true) goto L36;
        r44 = null;
    L36:
        r19 = (Integer) r44;     // Catch: Throwable -> L62
        goto L60
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L41;
        r19 = Integer.valueOf(((Number) r18).intValue());     // Catch: Throwable -> L62
        goto L60
    L41:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L47;
        Long r45 = Long.valueOf(((Number) r18).longValue());     // Catch: Throwable -> L62
        if ((r45 instanceof Integer) == true) goto L45;
        r45 = null;
    L45:
        r19 = (Integer) r45;     // Catch: Throwable -> L62
    L47:
        if ((r18 instanceof JSONObject) == false) goto L49;
    L190:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L55
        Object r46 = SDKSettingsCacheManager.a().fromJson(r18.toString(), Integer.class);     // Catch: Throwable -> L55
        if ((r46 instanceof Integer) == true) goto L53;
        r46 = null;
    L53:
        Object r47 = Result.constructor-impl((Integer) r46);     // Catch: Throwable -> L55
    L57:
        r19 = r47;
        if (Result.isFailure-impl(r19) == false) goto L60;
    L55:
        th = move-exception;
        Result.Companion r48 = Result.Companion;     // Catch: Throwable -> L62
        r47 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L62
        goto L57
    L49:
        if ((r18 instanceof JSONArray) == false) goto L59;
    L19:
        r42 = r18;
    L62:
        th = move-exception;
        Result.Companion r49 = Result.Companion;     // Catch: Throwable -> L167
        r20 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L167
    L167:
        th = move-exception;
        Result.Companion r50 = Result.Companion;
        Object r51 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r52 = Result.exceptionOrNull-impl(r51);
        if (r52 == null) goto L172;
        EnsureManager.ensureNotReachHere(r52);
    L172:
        if (Result.isFailure-impl(r51) == true) goto L175;
        r1 = r51;
    L175:
        r13 = r1;
        goto L177
    L192:
        return false;
    }

    static {
    }
}
