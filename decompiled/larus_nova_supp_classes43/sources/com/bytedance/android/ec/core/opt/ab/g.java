package com.bytedance.android.ec.core.opt.ab;

import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.core.imagex.common.z;
import com.bytedance.android.ec.hybrid.hostapi.IECHybridKevaService;
import com.bytedance.services.apm.api.EnsureManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g {
    public static final <T extends z> List<T> a(List<? extends T> r11) {
        if (r11 == null) goto L216;
        ArrayList r1 = new ArrayList();
        Iterator<T> r12 = r11.iterator();
    L6:
        if (r12.hasNext() == false) goto L196;
        Object r10 = r12.next();
        z r13 = (z) r10;
        Boolean r14 = r13.b();
        boolean r15 = true;
        if (Intrinsics.areEqual(r14, Boolean.TRUE) == false) goto L190;
        String r16 = r13.a();
        if (r16 != null) goto L12;
    L15:
        boolean r17 = true;
    L16:
        if (r17 == true) goto L192;
        int r18 = com.bytedance.android.ec.base.settings.b.a;
        String r19 = r13.a();
        Object r20 = 0;
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L177
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L177
        SDKSettingsCacheManager r22 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L177
        r22.getClass();     // Catch: Throwable -> L68
        Object r23 = SDKSettingsCacheManager.b.get(r19);     // Catch: Throwable -> L68
        if (r23 != null) goto L23;
    L65:
        Object r24 = null;
    L66:
        Object r25 = Result.constructor-impl(r24);     // Catch: Throwable -> L68
    L70:
        Throwable r26 = Result.exceptionOrNull-impl(r25);     // Catch: Throwable -> L177
        if (r26 == null) goto L74;
        EnsureManager.ensureNotReachHere(r26);     // Catch: Throwable -> L177
    L74:
        if (Result.isFailure-impl(r25) == false) goto L77;
        r25 = null;
    L77:
        if ((r25 instanceof Integer) == true) goto L79;
        r25 = null;
    L79:
        Object r27 = (Integer) r25;     // Catch: Throwable -> L177
        if (r27 != null) goto L86;
        r22.getClass();     // Catch: Throwable -> L177
        Object r28 = SDKSettingsCacheManager.a.get(r19);     // Catch: Throwable -> L177
        if ((r28 instanceof Integer) == true) goto L85;
        r28 = null;
    L85:
        r27 = (Integer) r28;     // Catch: Throwable -> L177
    L86:
        if (r27 != null) goto L187;
        int r29 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L177
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L139
        Object r30 = SDKSettingsCacheManager.b.get(r19);     // Catch: Throwable -> L139
        if (r30 != null) goto L94;
    L136:
        Object r31 = null;
    L137:
        Object r32 = Result.constructor-impl(r31);     // Catch: Throwable -> L139
    L141:
        Throwable r33 = Result.exceptionOrNull-impl(r32);     // Catch: Throwable -> L164
        if (r33 == null) goto L145;
        EnsureManager.ensureNotReachHere(r33);     // Catch: Throwable -> L164
    L145:
        if (Result.isFailure-impl(r32) == false) goto L148;
        r32 = null;
    L148:
        if ((r32 instanceof Integer) == true) goto L150;
        r32 = null;
    L150:
        Object r34 = (Integer) r32;     // Catch: Throwable -> L164
        if (r34 != null) goto L174;
        jj4.b r35 = jj4.b.b;     // Catch: Throwable -> L164
        Object r36 = jj4.a.a(r19, Integer.class, r20, false);     // Catch: Throwable -> L164
        if (r36 != null) goto L157;
        Intrinsics.throwNpe();     // Catch: Throwable -> L164
    L157:
        if ((r36 instanceof Integer) == true) goto L159;
        r36 = null;
    L159:
        Object r37 = (Integer) r36;     // Catch: Throwable -> L164
        if (r37 != null) goto L162;
        r37 = r20;
    L162:
        r34 = Result.constructor-impl(r37);     // Catch: Throwable -> L164
    L167:
        if (Result.exceptionOrNull-impl(r34) == null) goto L174;
        r34 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo(r19, Integer.class, r20);     // Catch: Throwable -> L171
    L172:
        if (r34 != null) goto L174;
        r27 = r20;
    L175:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L177
        SDKSettingsCacheManager.e(r19, r27);     // Catch: Throwable -> L177
    L171:
        r34 = r20;
    L174:
        r27 = r34;
        goto L175
    L94:
        if ((r30 instanceof Integer) == true) goto L96;
        Object r38 = null;
    L97:
        r31 = (Integer) r38;     // Catch: Throwable -> L139
        if (r31 != null) goto L137;
        if ((r30 instanceof Number) == false) goto L124;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L109;
        Float r39 = Float.valueOf(((Number) r30).floatValue());     // Catch: Throwable -> L139
        if ((r39 instanceof Integer) == true) goto L107;
        r39 = null;
    L107:
        r31 = (Integer) r39;     // Catch: Throwable -> L139
        goto L137
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L115;
        Double r40 = Double.valueOf(((Number) r30).doubleValue());     // Catch: Throwable -> L139
        if ((r40 instanceof Integer) == true) goto L113;
        r40 = null;
    L113:
        r31 = (Integer) r40;     // Catch: Throwable -> L139
        goto L137
    L115:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L118;
        r31 = Integer.valueOf(((Number) r30).intValue());     // Catch: Throwable -> L139
        goto L137
    L118:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L124;
        Long r41 = Long.valueOf(((Number) r30).longValue());     // Catch: Throwable -> L139
        if ((r41 instanceof Integer) == true) goto L122;
        r41 = null;
    L122:
        r31 = (Integer) r41;     // Catch: Throwable -> L139
    L124:
        if ((r30 instanceof JSONObject) == false) goto L126;
    L209:
        Object r42 = SDKSettingsCacheManager.a().fromJson(r30.toString(), Integer.class);     // Catch: Throwable -> L132
        if ((r42 instanceof Integer) == true) goto L130;
        r42 = null;
    L130:
        Object r43 = Result.constructor-impl((Integer) r42);     // Catch: Throwable -> L132
    L134:
        r31 = r43;
        if (Result.isFailure-impl(r31) == false) goto L137;
    L132:
        th = move-exception;
        Result.Companion r44 = Result.Companion;     // Catch: Throwable -> L139
        r43 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L139
        goto L134
    L126:
        if ((r30 instanceof JSONArray) == false) goto L136;
    L96:
        r38 = r30;
        goto L97
    L139:
        th = move-exception;
        Result.Companion r45 = Result.Companion;     // Catch: Throwable -> L164
        r32 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L164
        goto L141
    L164:
        th = move-exception;
        Result.Companion r46 = Result.Companion;     // Catch: Throwable -> L177
        r34 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L177
    L187:
        if (((Number) r27).intValue() != 1) goto L192;
    L193:
        if (r15 == false) goto L6;
        r1.add(r10);
        goto L6
    L23:
        if ((r23 instanceof Integer) == true) goto L25;
        Object r47 = null;
    L26:
        r24 = (Integer) r47;     // Catch: Throwable -> L68
        if (r24 != null) goto L66;
        if ((r23 instanceof Number) == false) goto L53;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L38;
        Float r48 = Float.valueOf(((Number) r23).floatValue());     // Catch: Throwable -> L68
        if ((r48 instanceof Integer) == true) goto L36;
        r48 = null;
    L36:
        r24 = (Integer) r48;     // Catch: Throwable -> L68
        goto L66
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L44;
        Double r49 = Double.valueOf(((Number) r23).doubleValue());     // Catch: Throwable -> L68
        if ((r49 instanceof Integer) == true) goto L42;
        r49 = null;
    L42:
        r24 = (Integer) r49;     // Catch: Throwable -> L68
        goto L66
    L44:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L47;
        r24 = Integer.valueOf(((Number) r23).intValue());     // Catch: Throwable -> L68
        goto L66
    L47:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L53;
        Long r50 = Long.valueOf(((Number) r23).longValue());     // Catch: Throwable -> L68
        if ((r50 instanceof Integer) == true) goto L51;
        r50 = null;
    L51:
        r24 = (Integer) r50;     // Catch: Throwable -> L68
    L53:
        if ((r23 instanceof JSONObject) == false) goto L55;
    L203:
        Object r51 = SDKSettingsCacheManager.a().fromJson(r23.toString(), Integer.class);     // Catch: Throwable -> L61
        if ((r51 instanceof Integer) == true) goto L59;
        r51 = null;
    L59:
        Object r52 = Result.constructor-impl((Integer) r51);     // Catch: Throwable -> L61
    L63:
        r24 = r52;
        if (Result.isFailure-impl(r24) == false) goto L66;
    L61:
        th = move-exception;
        Result.Companion r53 = Result.Companion;     // Catch: Throwable -> L68
        r52 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L68
        goto L63
    L55:
        if ((r23 instanceof JSONArray) == false) goto L65;
    L25:
        r47 = r23;
        goto L26
    L68:
        th = move-exception;
        Result.Companion r54 = Result.Companion;     // Catch: Throwable -> L177
        r25 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L177
    L177:
        th = move-exception;
        Result.Companion r55 = Result.Companion;
        Object r56 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r57 = Result.exceptionOrNull-impl(r56);
        if (r57 == null) goto L182;
        EnsureManager.ensureNotReachHere(r57);
    L182:
        if (Result.isFailure-impl(r56) == true) goto L185;
        r20 = r56;
    L185:
        r27 = r20;
    L192:
        r15 = false;
        goto L193
    L12:
        if (r16.length() == 0) goto L15;
        r17 = false;
        goto L16
    L190:
        if (Intrinsics.areEqual(r14, Boolean.FALSE) == false) goto L192;
    L196:
        return r1;
    L216:
        return null;
    }
}
