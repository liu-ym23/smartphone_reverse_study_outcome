package com.bytedance.android.ec.core.imagex.tmplConv;

import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.base.settings.g;
import com.bytedance.android.ec.base.settings.h;
import com.bytedance.android.ec.hybrid.hostapi.IECHybridKevaService;
import com.bytedance.services.apm.api.EnsureManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"<anonymous>", "Config", "", "invoke", "()Ljava/lang/Object;", "com/bytedance/android/ec/core/opt/ab/LazyFastSDKSettingsKt$lazyFastSDKSettings$1", "com/bytedance/android/ec/core/opt/ab/LazyFastSDKSettingsKt$lazyFastSDKSettingsOrNull$2$$special$$inlined$lazyFastSDKSettings$1", "com/bytedance/android/ec/core/imagex/tmplConv/TmplConvConfig$lazyImageXSettingsOrNull$$inlined$lazyFastSDKSettingsOrNull$2$1"}, k = 3, mv = {1, 4, 3}, xi = 128)
public final class TmplConvConfig$lazyImageXSettingsOrNull$$inlined$lazyImageXSettingsOrNull$2$1 extends Lambda implements Function0<Object> {
    final /* synthetic */ String $configKey;
    final /* synthetic */ Object $defaultConfig;

    public TmplConvConfig$lazyImageXSettingsOrNull$$inlined$lazyImageXSettingsOrNull$2$1(String r1, Object r10) {
        this.$configKey = r1;
        this.$defaultConfig = r10;
        super(0);
    }

    public final Object invoke() {
        int r0 = com.bytedance.android.ec.base.settings.b.a;
        String r1 = this.$configKey;
        Object r10 = this.$defaultConfig;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L69
        h.a();     // Catch: Throwable -> L69
        SDKSettingsCacheManager r12 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L69
        Object r13 = null;
        r12.getClass();     // Catch: Throwable -> L13
        Object r14 = SDKSettingsCacheManager.b.get(r1);     // Catch: Throwable -> L13
        if (r14 != null) goto L10;
        r14 = null;
    L11:
        Object r15 = Result.constructor-impl(r14);     // Catch: Throwable -> L13
    L15:
        Throwable r16 = Result.exceptionOrNull-impl(r15);     // Catch: Throwable -> L69
        if (r16 == null) goto L19;
        EnsureManager.ensureNotReachHere(r16);     // Catch: Throwable -> L69
    L19:
        if (Result.isFailure-impl(r15) == false) goto L21;
        r15 = null;
    L21:
        Intrinsics.reifiedOperationMarker(2, "T");     // Catch: Throwable -> L69
        if (r15 != null) goto L25;
        r12.getClass();     // Catch: Throwable -> L69
        r15 = SDKSettingsCacheManager.a.get(r1);     // Catch: Throwable -> L69
        Intrinsics.reifiedOperationMarker(2, "T");     // Catch: Throwable -> L69
    L25:
        if (r15 != null) goto L88;
        int r17 = g.a;     // Catch: Throwable -> L69
    L56:
        th = move-exception;
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L69
        r13 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L69
    L59:
        if (Result.exceptionOrNull-impl(r13) != null) goto L84;
    L60:
        Object r19 = r13;
    L67:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L69
        SDKSettingsCacheManager.e(r1, r19);     // Catch: Throwable -> L69
        return r19;
    L84:
        IECHybridKevaService r20 = (IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class);     // Catch: Throwable -> L63
        Intrinsics.reifiedOperationMarker(4, "T");     // Catch: Throwable -> L63
        Object r21 = r20.getSDKSettingsValueFromRepo(r1, Object.class, r10);     // Catch: Throwable -> L63
    L64:
        if (r21 != null) goto L66;
        r19 = r10;
        goto L67
    L66:
        r19 = r21;
    L63:
        r21 = r10;
        goto L64
    L79:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L36
        Object r22 = SDKSettingsCacheManager.b.get(r1);     // Catch: Throwable -> L36
        if (r22 != null) goto L33;
        r22 = null;
    L34:
        Object r23 = Result.constructor-impl(r22);     // Catch: Throwable -> L36
    L38:
        Throwable r24 = Result.exceptionOrNull-impl(r23);     // Catch: Throwable -> L56
        if (r24 == null) goto L42;
        EnsureManager.ensureNotReachHere(r24);     // Catch: Throwable -> L56
    L42:
        if (Result.isFailure-impl(r23) == true) goto L45;
        r13 = r23;
    L45:
        Intrinsics.reifiedOperationMarker(2, "T");     // Catch: Throwable -> L56
        if (r13 == null) goto L48;
        Intrinsics.reifiedOperationMarker(3, "T");     // Catch: Throwable -> L56
        goto L60
    L48:
        jj4.b r25 = jj4.b.b;     // Catch: Throwable -> L56
        Intrinsics.reifiedOperationMarker(4, "T");     // Catch: Throwable -> L56
        Object r26 = jj4.a.a(r1, Object.class, r10, false);     // Catch: Throwable -> L56
        if (r26 != null) goto L51;
        Intrinsics.throwNpe();     // Catch: Throwable -> L56
    L51:
        Intrinsics.reifiedOperationMarker(2, "T");     // Catch: Throwable -> L56
        if (r26 != null) goto L54;
        r26 = r10;
    L54:
        r13 = Result.constructor-impl(r26);     // Catch: Throwable -> L56
        goto L59
    L33:
        Intrinsics.reifiedOperationMarker(2, "T");     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L56
        r23 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L56
        goto L38
    L88:
        return r15;
    L10:
        Intrinsics.reifiedOperationMarker(2, "T");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L69
        r15 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L69
    L69:
        th = move-exception;
        Result.Companion r29 = Result.Companion;
        Object r30 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r31 = Result.exceptionOrNull-impl(r30);
        if (r31 == null) goto L74;
        EnsureManager.ensureNotReachHere(r31);
    L74:
        if (Result.isFailure-impl(r30) == true) goto L78;
        r10 = r30;
    L78:
        return r10;
    }
}
