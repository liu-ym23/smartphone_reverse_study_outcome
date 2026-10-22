package com.larus.dora.impl.wlan.wifi.add;

import com.larus.dora.impl.wlan.wifi.DoraWifiEntity;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "T", "Lkotlinx/coroutines/CoroutineScope;", "com/larus/dora/impl/util/DoraExtKt$suspendCoroutineWithTimeoutOrNull$2"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.wlan.wifi.add.DoraWifiScanListViewModel$doConnectWifi$$inlined$suspendCoroutineWithTimeoutOrNull$1", f = "DoraWifiScanListViewModel.kt", i = {}, l = {53}, m = "invokeSuspend", n = {}, s = {})
public final class DoraWifiScanListViewModel$doConnectWifi$$inlined$suspendCoroutineWithTimeoutOrNull$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super h>, Object> {
    final /* synthetic */ String $pwd$inlined;
    final /* synthetic */ DoraWifiEntity $wifiEntity$inlined;
    Object L$0;
    int label;

    public DoraWifiScanListViewModel$doConnectWifi$$inlined$suspendCoroutineWithTimeoutOrNull$1(Continuation r1, DoraWifiEntity r2, String r3) {
        this.$wifiEntity$inlined = r2;
        this.$pwd$inlined = r3;
        super(2, r1);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraWifiScanListViewModel$doConnectWifi$$inlined$suspendCoroutineWithTimeoutOrNull$1(r4, this.$wifiEntity$inlined, this.$pwd$inlined);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super h> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L13:
        return r7;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        this.label = 1;
        kotlinx.coroutines.j r8 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(this), 1);
        r8.C();
        ak4.a r2 = vk4.f.c;
        vk4.f r3 = vk4.f.a.a;
        DoraWifiScanListViewModel.c r4 = new DoraWifiScanListViewModel.c(r3, r8);
        ((CopyOnWriteArraySet) r3.b).add(r4);
        g49.d.d("DoraWifiAddViewModel", "connectWifi: ret=" + r3.b(2, this.$wifiEntity$inlined.c(), this.$pwd$inlined));
        r8.i(new DoraWifiScanListViewModel.b(r3, r4));
        r7 = r8.B();
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L11;
        DebugProbesKt.probeCoroutineSuspended(this);
    L11:
        if (r7 != r0) goto L13;
        return r0;
    }
}
