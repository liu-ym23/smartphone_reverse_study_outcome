package com.bytedance.android.ec.core.arch.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleKt;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.core.opt.ab.n;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.services.apm.api.EnsureManager;
import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e {
    public static final CoroutineScope a(LifecycleOwner r11) {
        Intrinsics.checkNotNullParameter(r11, "$this$lifecycleScopeForEC");
        int r0 = n.a;
        Object r10 = 0;
        int r12 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L157
        Object r14 = com.bytedance.android.ec.base.settings.d.c.get("ec_use_lifecycle_scope_for_ec");     // Catch: Throwable -> L53
        if (r14 != null) goto L8;
    L50:
        Object r15 = null;
    L51:
        Object r16 = Result.constructor-impl(r15);     // Catch: Throwable -> L53
    L55:
        Throwable r17 = Result.exceptionOrNull-impl(r16);     // Catch: Throwable -> L157
        if (r17 == null) goto L59;
        EnsureManager.ensureNotReachHere(r17);     // Catch: Throwable -> L157
    L59:
        if (Result.isFailure-impl(r16) == false) goto L62;
        r16 = null;
    L62:
        if ((r16 instanceof Integer) == true) goto L64;
        r16 = null;
    L64:
        Object r18 = (Integer) r16;     // Catch: Throwable -> L157
        if (r18 != null) goto L71;
        Object r19 = com.bytedance.android.ec.base.settings.d.a.get("ec_use_lifecycle_scope_for_ec");     // Catch: Throwable -> L157
        if ((r19 instanceof Integer) == true) goto L70;
        r19 = null;
    L70:
        r18 = (Integer) r19;     // Catch: Throwable -> L157
    L71:
        if (r18 != null) goto L167;
        int r20 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L157
        Object r21 = com.bytedance.android.ec.base.settings.d.c.get("ec_use_lifecycle_scope_for_ec");     // Catch: Throwable -> L123
        if (r21 != null) goto L78;
    L120:
        Object r22 = null;
    L121:
        Object r23 = Result.constructor-impl(r22);     // Catch: Throwable -> L123
    L125:
        Throwable r24 = Result.exceptionOrNull-impl(r23);     // Catch: Throwable -> L148
        if (r24 == null) goto L129;
        EnsureManager.ensureNotReachHere(r24);     // Catch: Throwable -> L148
    L129:
        if (Result.isFailure-impl(r23) == false) goto L132;
        r23 = null;
    L132:
        if ((r23 instanceof Integer) == true) goto L134;
        r23 = null;
    L134:
        r18 = (Integer) r23;     // Catch: Throwable -> L148
        if (r18 != null) goto L155;
        IHybridHostService r25 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L148
        if (r25 == null) goto L140;
        Object r26 = r25.getHostABValue("ec_use_lifecycle_scope_for_ec", r10);     // Catch: Throwable -> L148
    L141:
        if (r26 != null) goto L143;
    L154:
        r18 = r10;
        goto L155
    L143:
        if ((r26 instanceof Integer) == true) goto L145;
        r26 = null;
    L145:
        r18 = (Integer) r26;     // Catch: Throwable -> L148
        if (r18 != null) goto L155;
    L148:
        th = move-exception;
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L157
        r18 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L157
        Throwable r28 = Result.exceptionOrNull-impl(r18);     // Catch: Throwable -> L157
        if (r28 == null) goto L153;
        EnsureManager.ensureNotReachHere(r28);     // Catch: Throwable -> L157
    L153:
        if (Result.isFailure-impl(r18) == false) goto L155;
    L140:
        r26 = null;
    L155:
        com.bytedance.android.ec.base.settings.d.d("ec_use_lifecycle_scope_for_ec", r18);     // Catch: Throwable -> L157
        goto L167
    L78:
        if ((r21 instanceof Integer) == true) goto L80;
        Object r29 = null;
    L81:
        r22 = (Integer) r29;     // Catch: Throwable -> L123
        if (r22 != null) goto L121;
        if ((r21 instanceof Number) == false) goto L108;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L93;
        Float r30 = Float.valueOf(((Number) r21).floatValue());     // Catch: Throwable -> L123
        if ((r30 instanceof Integer) == true) goto L91;
        r30 = null;
    L91:
        r22 = (Integer) r30;     // Catch: Throwable -> L123
        goto L121
    L93:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L99;
        Double r31 = Double.valueOf(((Number) r21).doubleValue());     // Catch: Throwable -> L123
        if ((r31 instanceof Integer) == true) goto L97;
        r31 = null;
    L97:
        r22 = (Integer) r31;     // Catch: Throwable -> L123
        goto L121
    L99:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L102;
        r22 = Integer.valueOf(((Number) r21).intValue());     // Catch: Throwable -> L123
        goto L121
    L102:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L108;
        Long r32 = Long.valueOf(((Number) r21).longValue());     // Catch: Throwable -> L123
        if ((r32 instanceof Integer) == true) goto L106;
        r32 = null;
    L106:
        r22 = (Integer) r32;     // Catch: Throwable -> L123
    L108:
        if ((r21 instanceof JSONObject) == false) goto L110;
    L208:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L116
        Object r33 = SDKSettingsCacheManager.a().fromJson(r21.toString(), Integer.class);     // Catch: Throwable -> L116
        if ((r33 instanceof Integer) == true) goto L114;
        r33 = null;
    L114:
        Object r34 = Result.constructor-impl((Integer) r33);     // Catch: Throwable -> L116
    L118:
        r22 = r34;
        if (Result.isFailure-impl(r22) == false) goto L121;
    L116:
        th = move-exception;
        Result.Companion r35 = Result.Companion;     // Catch: Throwable -> L123
        r34 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L123
        goto L118
    L110:
        if ((r21 instanceof JSONArray) == false) goto L120;
    L80:
        r29 = r21;
    L123:
        th = move-exception;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L148
        r23 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L148
    L167:
        if (((Number) r18).intValue() != 1) goto L169;
        boolean r1 = true;
    L170:
        if (r1 == false) goto L204;
        Lifecycle r110 = r11.getLifecycle();
        Intrinsics.checkNotNullParameter(r110, "$this$coroutineScopeForEC");
        Class<? super Object> r37 = r110.getClass().getSuperclass();     // Catch: Error -> L205
        if (r37 == null) goto L226;
        Field r38 = r37.getDeclaredField("mInternalScopeRef");     // Catch: Error -> L205
        if (r38 == null) goto L227;
        r38.setAccessible(true);     // Catch: Error -> L205
        Object r39 = r38.get(r110);     // Catch: Error -> L205
        if (r39 == null) goto L202;
        AtomicReference r40 = (AtomicReference) r39;     // Catch: Error -> L205
    L179:
        Object r41 = r40.get();     // Catch: Error -> L205
        if ((r41 instanceof LifecycleCoroutineScopeImpl) == true) goto L182;
        r41 = null;
    L182:
        LifecycleCoroutineScopeImpl r42 = (LifecycleCoroutineScopeImpl) r41;     // Catch: Error -> L205
        if (r42 != null) goto L228;
        r42 = new LifecycleCoroutineScopeImpl(r110, SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));     // Catch: Error -> L205
    L187:
        if (r40.compareAndSet(null, r42) == true) goto L188;
        if (r40.get() == null) goto L187;
        boolean r43 = false;
    L192:
        if (r43 == true) goto L193;
        if ((r40.get() instanceof CoroutineScope) == false) goto L179;
        Object r111 = r40.get();     // Catch: Error -> L205
        if (r111 == null) goto L200;
        return (CoroutineScope) r111;
    L200:
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.CoroutineScope");     // Catch: Error -> L205
    L193:
        BuildersKt.launch$default(r42, Dispatchers.getMain().getImmediate(), null, new LifecycleCoroutineScopeImpl$register$1(r42, null), 2, null);     // Catch: Error -> L205
        goto L228
    L188:
        r43 = true;
    L228:
        return r42;
    L202:
        throw new NullPointerException("null cannot be cast to non-null type java.util.concurrent.atomic.AtomicReference<kotlin.Any>");     // Catch: Error -> L205
    L227:
        return null;
    L226:
        return null;
    L230:
        return null;
    L204:
        return LifecycleKt.getCoroutineScope(r11.getLifecycle());
    L169:
        r1 = false;
        goto L170
    L8:
        if ((r14 instanceof Integer) == true) goto L10;
        Object r44 = null;
    L11:
        r15 = (Integer) r44;     // Catch: Throwable -> L53
        if (r15 != null) goto L51;
        if ((r14 instanceof Number) == false) goto L38;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L23;
        Float r45 = Float.valueOf(((Number) r14).floatValue());     // Catch: Throwable -> L53
        if ((r45 instanceof Integer) == true) goto L21;
        r45 = null;
    L21:
        r15 = (Integer) r45;     // Catch: Throwable -> L53
        goto L51
    L23:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L29;
        Double r46 = Double.valueOf(((Number) r14).doubleValue());     // Catch: Throwable -> L53
        if ((r46 instanceof Integer) == true) goto L27;
        r46 = null;
    L27:
        r15 = (Integer) r46;     // Catch: Throwable -> L53
        goto L51
    L29:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L32;
        r15 = Integer.valueOf(((Number) r14).intValue());     // Catch: Throwable -> L53
        goto L51
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L38;
        Long r47 = Long.valueOf(((Number) r14).longValue());     // Catch: Throwable -> L53
        if ((r47 instanceof Integer) == true) goto L36;
        r47 = null;
    L36:
        r15 = (Integer) r47;     // Catch: Throwable -> L53
    L38:
        if ((r14 instanceof JSONObject) == false) goto L40;
    L206:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L46
        Object r48 = SDKSettingsCacheManager.a().fromJson(r14.toString(), Integer.class);     // Catch: Throwable -> L46
        if ((r48 instanceof Integer) == true) goto L44;
        r48 = null;
    L44:
        Object r49 = Result.constructor-impl((Integer) r48);     // Catch: Throwable -> L46
    L48:
        r15 = r49;
        if (Result.isFailure-impl(r15) == false) goto L51;
    L46:
        th = move-exception;
        Result.Companion r50 = Result.Companion;     // Catch: Throwable -> L53
        r49 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L53
        goto L48
    L40:
        if ((r14 instanceof JSONArray) == false) goto L50;
    L10:
        r44 = r14;
    L53:
        th = move-exception;
        Result.Companion r51 = Result.Companion;     // Catch: Throwable -> L157
        r16 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L157
    L157:
        th = move-exception;
        Result.Companion r52 = Result.Companion;
        Object r53 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r54 = Result.exceptionOrNull-impl(r53);
        if (r54 == null) goto L162;
        EnsureManager.ensureNotReachHere(r54);
    L162:
        if (Result.isFailure-impl(r53) == true) goto L165;
        r10 = r53;
    L165:
        r18 = r10;
        goto L167
    }
}
