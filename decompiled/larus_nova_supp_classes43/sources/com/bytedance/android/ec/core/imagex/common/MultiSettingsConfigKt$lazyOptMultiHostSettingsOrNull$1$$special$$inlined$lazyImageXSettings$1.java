package com.bytedance.android.ec.core.imagex.common;

import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.hybrid.hostapi.IECHybridKevaService;
import com.bytedance.services.apm.api.EnsureManager;
import com.google.gson.internal.LinkedTreeMap;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"<anonymous>", "Config", "", "invoke", "()Ljava/lang/Object;", "com/bytedance/android/ec/core/opt/ab/LazyFastSDKSettingsKt$lazyFastSDKSettings$1", "com/bytedance/android/ec/core/imagex/common/MultiSettingsConfigKt$lazyOptMultiHostSettingsOrNull$1$lazyImageXSettings$$inlined$lazyFastSDKSettings$1", "com/bytedance/android/ec/core/imagex/common/MultiSettingsConfigKt$lazyOptMultiHostSettingsOrNull$1$lazyImageXSettings$$inlined$lazyImageXSettings$1"}, k = 3, mv = {1, 4, 3}, xi = 128)
public final class MultiSettingsConfigKt$lazyOptMultiHostSettingsOrNull$1$$special$$inlined$lazyImageXSettings$1 extends Lambda implements Function0<LinkedTreeMap<String, Object>> {
    final /* synthetic */ String $configKey;
    final /* synthetic */ Object $defaultConfig;

    public MultiSettingsConfigKt$lazyOptMultiHostSettingsOrNull$1$$special$$inlined$lazyImageXSettings$1(String r1, Object r10) {
        this.$configKey = r1;
        this.$defaultConfig = r10;
        super(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final LinkedTreeMap<String, Object> invoke() {
        int r0 = com.bytedance.android.ec.base.settings.b.a;
        String r1 = this.$configKey;
        Object r10 = this.$defaultConfig;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L170
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L170
        SDKSettingsCacheManager r12 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L170
        Object r13 = null;
        r12.getClass();     // Catch: Throwable -> L57
        Object r14 = SDKSettingsCacheManager.b.get(r1);     // Catch: Throwable -> L57
        if (r14 != null) goto L9;
    L54:
        Object r15 = null;
    L55:
        Object r16 = Result.constructor-impl(r15);     // Catch: Throwable -> L57
    L59:
        Throwable r17 = Result.exceptionOrNull-impl(r16);     // Catch: Throwable -> L170
        if (r17 == null) goto L63;
        EnsureManager.ensureNotReachHere(r17);     // Catch: Throwable -> L170
    L63:
        if (Result.isFailure-impl(r16) == false) goto L66;
        r16 = null;
    L66:
        if ((r16 instanceof LinkedTreeMap) == true) goto L68;
        r16 = null;
    L68:
        LinkedTreeMap<String, Object> r18 = (LinkedTreeMap) r16;     // Catch: Throwable -> L170
        if (r18 != null) goto L75;
        r12.getClass();     // Catch: Throwable -> L170
        Object r19 = SDKSettingsCacheManager.a.get(r1);     // Catch: Throwable -> L170
        if ((r19 instanceof LinkedTreeMap) == true) goto L74;
        r19 = null;
    L74:
        r18 = (LinkedTreeMap) r19;     // Catch: Throwable -> L170
    L75:
        if (r18 != null) goto L194;
        int r20 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L170
    L157:
        th = move-exception;
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L170
        Object r22 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L170
    L160:
        if (Result.exceptionOrNull-impl(r22) != null) goto L182;
    L167:
        LinkedTreeMap<String, Object> r23 = r22;
    L168:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L170
        SDKSettingsCacheManager.e(r1, r23);     // Catch: Throwable -> L170
        return r23;
    L182:
        r22 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo(r1, LinkedTreeMap.class, r10);     // Catch: Throwable -> L164
    L165:
        if (r22 != null) goto L167;
        r23 = r10;
    L164:
        r22 = r10;
        goto L165
    L188:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L131
        Object r24 = SDKSettingsCacheManager.b.get(r1);     // Catch: Throwable -> L131
        if (r24 != null) goto L83;
    L128:
        Object r25 = null;
    L129:
        Object r26 = Result.constructor-impl(r25);     // Catch: Throwable -> L131
    L133:
        Throwable r27 = Result.exceptionOrNull-impl(r26);     // Catch: Throwable -> L157
        if (r27 == null) goto L137;
        EnsureManager.ensureNotReachHere(r27);     // Catch: Throwable -> L157
    L137:
        if (Result.isFailure-impl(r26) == false) goto L140;
        r26 = null;
    L140:
        if ((r26 instanceof LinkedTreeMap) == true) goto L142;
        r26 = null;
    L142:
        r22 = (LinkedTreeMap) r26;     // Catch: Throwable -> L157
        if (r22 != null) goto L167;
        jj4.b r28 = jj4.b.b;     // Catch: Throwable -> L157
        Object r29 = jj4.a.a(r1, LinkedTreeMap.class, r10, false);     // Catch: Throwable -> L157
        if (r29 != null) goto L149;
        Intrinsics.throwNpe();     // Catch: Throwable -> L157
    L149:
        if ((r29 instanceof LinkedTreeMap) == false) goto L152;
        r13 = r29;
    L152:
        Object r30 = (LinkedTreeMap) r13;     // Catch: Throwable -> L157
        if (r30 != null) goto L155;
        r30 = r10;
    L155:
        r22 = Result.constructor-impl(r30);     // Catch: Throwable -> L157
    L83:
        if ((r24 instanceof LinkedTreeMap) == true) goto L85;
        Object r31 = null;
    L86:
        r25 = (LinkedTreeMap) r31;     // Catch: Throwable -> L131
        if (r25 != null) goto L129;
        if ((r24 instanceof Number) == false) goto L116;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(LinkedTreeMap.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L98;
        Float r32 = Float.valueOf(((Number) r24).floatValue());     // Catch: Throwable -> L131
        if ((r32 instanceof LinkedTreeMap) == true) goto L96;
        r32 = null;
    L96:
        r25 = (LinkedTreeMap) r32;     // Catch: Throwable -> L131
        goto L129
    L98:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(LinkedTreeMap.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L104;
        Double r33 = Double.valueOf(((Number) r24).doubleValue());     // Catch: Throwable -> L131
        if ((r33 instanceof LinkedTreeMap) == true) goto L102;
        r33 = null;
    L102:
        r25 = (LinkedTreeMap) r33;     // Catch: Throwable -> L131
        goto L129
    L104:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(LinkedTreeMap.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L110;
        Integer r34 = Integer.valueOf(((Number) r24).intValue());     // Catch: Throwable -> L131
        if ((r34 instanceof LinkedTreeMap) == true) goto L108;
        r34 = null;
    L108:
        r25 = (LinkedTreeMap) r34;     // Catch: Throwable -> L131
        goto L129
    L110:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(LinkedTreeMap.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L116;
        Long r35 = Long.valueOf(((Number) r24).longValue());     // Catch: Throwable -> L131
        if ((r35 instanceof LinkedTreeMap) == true) goto L114;
        r35 = null;
    L114:
        r25 = (LinkedTreeMap) r35;     // Catch: Throwable -> L131
    L116:
        if ((r24 instanceof JSONObject) == false) goto L118;
    L180:
        Object r36 = SDKSettingsCacheManager.a().fromJson(r24.toString(), LinkedTreeMap.class);     // Catch: Throwable -> L124
        if ((r36 instanceof LinkedTreeMap) == true) goto L122;
        r36 = null;
    L122:
        Object r37 = Result.constructor-impl((LinkedTreeMap) r36);     // Catch: Throwable -> L124
    L126:
        r25 = r37;
        if (Result.isFailure-impl(r25) == false) goto L129;
    L124:
        th = move-exception;
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L131
        r37 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L131
        goto L126
    L118:
        if ((r24 instanceof JSONArray) == false) goto L128;
    L85:
        r31 = r24;
    L131:
        th = move-exception;
        Result.Companion r39 = Result.Companion;     // Catch: Throwable -> L157
        r26 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L157
        goto L133
    L194:
        return r18;
    L9:
        if ((r14 instanceof LinkedTreeMap) == true) goto L11;
        Object r40 = null;
    L12:
        r15 = (LinkedTreeMap) r40;     // Catch: Throwable -> L57
        if (r15 != null) goto L55;
        if ((r14 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(LinkedTreeMap.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L24;
        Float r41 = Float.valueOf(((Number) r14).floatValue());     // Catch: Throwable -> L57
        if ((r41 instanceof LinkedTreeMap) == true) goto L22;
        r41 = null;
    L22:
        r15 = (LinkedTreeMap) r41;     // Catch: Throwable -> L57
        goto L55
    L24:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(LinkedTreeMap.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L30;
        Double r42 = Double.valueOf(((Number) r14).doubleValue());     // Catch: Throwable -> L57
        if ((r42 instanceof LinkedTreeMap) == true) goto L28;
        r42 = null;
    L28:
        r15 = (LinkedTreeMap) r42;     // Catch: Throwable -> L57
        goto L55
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(LinkedTreeMap.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        Integer r43 = Integer.valueOf(((Number) r14).intValue());     // Catch: Throwable -> L57
        if ((r43 instanceof LinkedTreeMap) == true) goto L34;
        r43 = null;
    L34:
        r15 = (LinkedTreeMap) r43;     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(LinkedTreeMap.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r44 = Long.valueOf(((Number) r14).longValue());     // Catch: Throwable -> L57
        if ((r44 instanceof LinkedTreeMap) == true) goto L40;
        r44 = null;
    L40:
        r15 = (LinkedTreeMap) r44;     // Catch: Throwable -> L57
    L42:
        if ((r14 instanceof JSONObject) == false) goto L44;
    L186:
        Object r45 = SDKSettingsCacheManager.a().fromJson(r14.toString(), LinkedTreeMap.class);     // Catch: Throwable -> L50
        if ((r45 instanceof LinkedTreeMap) == true) goto L48;
        r45 = null;
    L48:
        Object r46 = Result.constructor-impl((LinkedTreeMap) r45);     // Catch: Throwable -> L50
    L52:
        r15 = r46;
        if (Result.isFailure-impl(r15) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r47 = Result.Companion;     // Catch: Throwable -> L57
        r46 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r14 instanceof JSONArray) == false) goto L54;
    L11:
        r40 = r14;
    L57:
        th = move-exception;
        Result.Companion r48 = Result.Companion;     // Catch: Throwable -> L170
        r16 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L170
    L170:
        th = move-exception;
        Result.Companion r49 = Result.Companion;
        Object r50 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r51 = Result.exceptionOrNull-impl(r50);
        if (r51 == null) goto L175;
        EnsureManager.ensureNotReachHere(r51);
    L175:
        if (Result.isFailure-impl(r50) == true) goto L179;
        r10 = r50;
    L179:
        return r10;
    }
}
