package com.bytedance.android.ec.core.opt.ab;

import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.dataplatform.config.SettingPanel;
import com.bytedance.services.apm.api.EnsureManager;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class t {
    public static final /* synthetic */ int a = 0;

    @SettingPanel("Android电商业务监控开关")
    public static final int a() {
        int r0 = p.a;
        Object r1 = 1;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r11 = jj4.b.b;     // Catch: Throwable -> L7
        Object r12 = jj4.a.a("ec_business_monitor_switch", Integer.class, r1, false);     // Catch: Throwable -> L7
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Number) r12).intValue();
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r1 = r14;
    L12:
        r12 = r1;
        goto L14
    }

    @SettingPanel("开启Text缓存优化")
    public static final boolean b() {
        int r0 = p.a;
        Object r1 = Boolean.FALSE;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r11 = jj4.b.b;     // Catch: Throwable -> L7
        Object r12 = jj4.a.a("enable_slice_text_layout_cache", Boolean.class, r1, false);     // Catch: Throwable -> L7
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Boolean) r12).booleanValue();
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r1 = r14;
    L12:
        r12 = r1;
        goto L14
    }

    @SettingPanel("Text排版缓存大小")
    public static final int c() {
        int r0 = p.a;
        Object r10 = 0;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r12 = jj4.b.b;     // Catch: Throwable -> L7
        Object r1 = jj4.a.a("text_slice_layout_cache_size", Integer.class, r10, false);     // Catch: Throwable -> L7
        if (r1 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Number) r1).intValue();
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r10 = r14;
    L12:
        r1 = r10;
        goto L14
    }

    @SettingPanel("ECImage Slice适配")
    public static final boolean d() {
        int r0 = n.a;
        Object r1 = Boolean.FALSE;
        int r10 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L166
        Object r12 = null;
        Object r13 = com.bytedance.android.ec.base.settings.d.c.get("ec_image_slc_loader_hooker_enable");     // Catch: Throwable -> L57
        if (r13 != null) goto L9;
    L54:
        Object r14 = null;
    L55:
        Object r15 = Result.constructor-impl(r14);     // Catch: Throwable -> L57
    L59:
        Throwable r16 = Result.exceptionOrNull-impl(r15);     // Catch: Throwable -> L166
        if (r16 == null) goto L63;
        EnsureManager.ensureNotReachHere(r16);     // Catch: Throwable -> L166
    L63:
        if (Result.isFailure-impl(r15) == false) goto L66;
        r15 = null;
    L66:
        if ((r15 instanceof Boolean) == true) goto L68;
        r15 = null;
    L68:
        Object r17 = (Boolean) r15;     // Catch: Throwable -> L166
        if (r17 != null) goto L75;
        Object r18 = com.bytedance.android.ec.base.settings.d.a.get("ec_image_slc_loader_hooker_enable");     // Catch: Throwable -> L166
        if ((r18 instanceof Boolean) == true) goto L74;
        r18 = null;
    L74:
        r17 = (Boolean) r18;     // Catch: Throwable -> L166
    L75:
        if (r17 != null) goto L176;
        int r19 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L166
        Object r20 = com.bytedance.android.ec.base.settings.d.c.get("ec_image_slc_loader_hooker_enable");     // Catch: Throwable -> L130
        if (r20 != null) goto L82;
    L127:
        Object r21 = null;
    L128:
        Object r22 = Result.constructor-impl(r21);     // Catch: Throwable -> L130
    L132:
        Throwable r23 = Result.exceptionOrNull-impl(r22);     // Catch: Throwable -> L156
        if (r23 == null) goto L136;
        EnsureManager.ensureNotReachHere(r23);     // Catch: Throwable -> L156
    L136:
        if (Result.isFailure-impl(r22) == false) goto L139;
        r22 = null;
    L139:
        if ((r22 instanceof Boolean) == true) goto L141;
        r22 = null;
    L141:
        r17 = (Boolean) r22;     // Catch: Throwable -> L156
        if (r17 != null) goto L164;
        IHybridHostService r24 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r24 == null) goto L147;
        Object r25 = r24.getHostABValue("ec_image_slc_loader_hooker_enable", r1);     // Catch: Throwable -> L156
    L148:
        if (r25 != null) goto L150;
    L155:
        r17 = r1;
        goto L164
    L150:
        if ((r25 instanceof Boolean) == false) goto L153;
        r12 = r25;
    L153:
        Object r26 = (Boolean) r12;     // Catch: Throwable -> L156
        if (r26 == null) goto L155;
    L163:
        r17 = r26;
        goto L164
    L147:
        r25 = null;
    L164:
        com.bytedance.android.ec.base.settings.d.d("ec_image_slc_loader_hooker_enable", r17);     // Catch: Throwable -> L166
        goto L176
    L82:
        if ((r20 instanceof Boolean) == true) goto L84;
        Object r27 = null;
    L85:
        r21 = (Boolean) r27;     // Catch: Throwable -> L130
        if (r21 != null) goto L128;
        if ((r20 instanceof Number) == false) goto L115;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r28 = Float.valueOf(((Number) r20).floatValue());     // Catch: Throwable -> L130
        if ((r28 instanceof Boolean) == true) goto L95;
        r28 = null;
    L95:
        r21 = (Boolean) r28;     // Catch: Throwable -> L130
        goto L128
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r29 = Double.valueOf(((Number) r20).doubleValue());     // Catch: Throwable -> L130
        if ((r29 instanceof Boolean) == true) goto L101;
        r29 = null;
    L101:
        r21 = (Boolean) r29;     // Catch: Throwable -> L130
        goto L128
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L109;
        Integer r30 = Integer.valueOf(((Number) r20).intValue());     // Catch: Throwable -> L130
        if ((r30 instanceof Boolean) == true) goto L107;
        r30 = null;
    L107:
        r21 = (Boolean) r30;     // Catch: Throwable -> L130
        goto L128
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L115;
        Long r31 = Long.valueOf(((Number) r20).longValue());     // Catch: Throwable -> L130
        if ((r31 instanceof Boolean) == true) goto L113;
        r31 = null;
    L113:
        r21 = (Boolean) r31;     // Catch: Throwable -> L130
    L115:
        if ((r20 instanceof JSONObject) == false) goto L117;
    L184:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L123
        Object r32 = SDKSettingsCacheManager.a().fromJson(r20.toString(), Boolean.class);     // Catch: Throwable -> L123
        if ((r32 instanceof Boolean) == true) goto L121;
        r32 = null;
    L121:
        Object r33 = Result.constructor-impl((Boolean) r32);     // Catch: Throwable -> L123
    L125:
        r21 = r33;
        if (Result.isFailure-impl(r21) == false) goto L128;
    L123:
        th = move-exception;
        Result.Companion r34 = Result.Companion;     // Catch: Throwable -> L130
        r33 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L130
        goto L125
    L117:
        if ((r20 instanceof JSONArray) == false) goto L127;
    L84:
        r27 = r20;
    L156:
        th = move-exception;
        Result.Companion r35 = Result.Companion;     // Catch: Throwable -> L166
        r26 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
        Throwable r36 = Result.exceptionOrNull-impl(r26);     // Catch: Throwable -> L166
        if (r36 == null) goto L161;
        EnsureManager.ensureNotReachHere(r36);     // Catch: Throwable -> L166
    L161:
        if (Result.isFailure-impl(r26) == false) goto L163;
        r26 = r1;
    L130:
        th = move-exception;
        Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L156
        r22 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L156
    L176:
        return ((Boolean) r17).booleanValue();
    L9:
        if ((r13 instanceof Boolean) == true) goto L11;
        Object r38 = null;
    L12:
        r14 = (Boolean) r38;     // Catch: Throwable -> L57
        if (r14 != null) goto L55;
        if ((r13 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L24;
        Float r39 = Float.valueOf(((Number) r13).floatValue());     // Catch: Throwable -> L57
        if ((r39 instanceof Boolean) == true) goto L22;
        r39 = null;
    L22:
        r14 = (Boolean) r39;     // Catch: Throwable -> L57
        goto L55
    L24:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L30;
        Double r40 = Double.valueOf(((Number) r13).doubleValue());     // Catch: Throwable -> L57
        if ((r40 instanceof Boolean) == true) goto L28;
        r40 = null;
    L28:
        r14 = (Boolean) r40;     // Catch: Throwable -> L57
        goto L55
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        Integer r41 = Integer.valueOf(((Number) r13).intValue());     // Catch: Throwable -> L57
        if ((r41 instanceof Boolean) == true) goto L34;
        r41 = null;
    L34:
        r14 = (Boolean) r41;     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r42 = Long.valueOf(((Number) r13).longValue());     // Catch: Throwable -> L57
        if ((r42 instanceof Boolean) == true) goto L40;
        r42 = null;
    L40:
        r14 = (Boolean) r42;     // Catch: Throwable -> L57
    L42:
        if ((r13 instanceof JSONObject) == false) goto L44;
    L181:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L50
        Object r43 = SDKSettingsCacheManager.a().fromJson(r13.toString(), Boolean.class);     // Catch: Throwable -> L50
        if ((r43 instanceof Boolean) == true) goto L48;
        r43 = null;
    L48:
        Object r44 = Result.constructor-impl((Boolean) r43);     // Catch: Throwable -> L50
    L52:
        r14 = r44;
        if (Result.isFailure-impl(r14) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r45 = Result.Companion;     // Catch: Throwable -> L57
        r44 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r13 instanceof JSONArray) == false) goto L54;
    L11:
        r38 = r13;
    L57:
        th = move-exception;
        Result.Companion r46 = Result.Companion;     // Catch: Throwable -> L166
        r15 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
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
        r17 = r1;
        goto L176
    }

    static {
    }
}
