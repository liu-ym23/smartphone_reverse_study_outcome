package com.bytedance.android.ec.core.cps;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.bytedance.bpea.cert.token.TokenCert;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.ec.core.cps.CyberProtectionCollectorKt$getMac$macAddress$1", f = "CyberProtectionCollector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CyberProtectionCollectorKt$getMac$macAddress$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    int label;

    public CyberProtectionCollectorKt$getMac$macAddress$1(Continuation r10) {
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "completion");
        return new CyberProtectionCollectorKt$getMac$macAddress$1(r10);
    }

    public final Object invoke(Object r1, Object r10) {
        return create(r1, (Continuation) r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L17;
        ResultKt.throwOnFailure(r10);
        Context r0 = b.m();     // Catch: Throwable -> L18
        if (r0 == null) goto L8;
        Object r1 = r0.getSystemService("wifi");     // Catch: Throwable -> L18
    L9:
        if (r1 == null) goto L14;
        int r11 = com.bytedance.bpea.entry.api.device.info.h.a;     // Catch: Throwable -> L18
        TokenCert.Companion r12 = TokenCert.Companion;     // Catch: Throwable -> L18
        WifiInfo r13 = com.bytedance.bpea.entry.api.device.info.h.a.a((WifiManager) r1, r12.with("bpea-track_sdk_get_wifi_info"));     // Catch: Throwable -> L18
        if (r13 == null) goto L15;
        int r14 = com.bytedance.bpea.entry.api.device.info.g.a;     // Catch: Throwable -> L18
        return com.bytedance.bpea.entry.api.device.info.g.a.b(r13, r12.with("bpea-track_sdk_get_device_info"));
    L15:
        return null;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.net.wifi.WifiManager");     // Catch: Throwable -> L18
    L8:
        r1 = null;
        goto L9
    L21:
        return null;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
