package com.larus.dora.impl.device.battery;

import com.larus.dora.impl.ota.g2.j0;
import g49.d;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.battery.DoraDeviceBoxBattery$startLoop$1", f = "DoraDeviceBoxBattery.kt", i = {0}, l = {95}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
final class DoraDeviceBoxBattery$startLoop$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    public DoraDeviceBoxBattery$startLoop$1(Continuation<? super DoraDeviceBoxBattery$startLoop$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        DoraDeviceBoxBattery$startLoop$1 r0 = new DoraDeviceBoxBattery$startLoop$1(r3);
        r0.L$0 = r2;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0039 -> B:16:0x003c). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        CoroutineScope r2 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r8);
        DoraDeviceBoxBattery$startLoop$1 r9 = this;
    L16:
        int r3 = DoraDeviceBoxBattery.c;
        int r4 = DoraDeviceBoxBattery.b;
        d.d("DoraDeviceBoxBattery", "loop...inputBattery=" + r4 + ", displayedBattery=" + r3);
        if (Math.abs(r4 - r3) <= 0) goto L22;
        if (r4 <= r3) goto L20;
        int r5 = 1;
    L21:
        DoraDeviceBoxBattery.a(r3 + r5, DoraDeviceBoxBattery.From.LOOP);
    L10:
        if (DoraDeviceBoxBattery.d == false) goto L24;
        if (CoroutineScopeKt.isActive(r2) == false) goto L24;
        r9.L$0 = r2;
        r9.label = 1;
        if (DelayKt.delay(j0.G2_OTA_DISCONNECT_WATCHDOG_MS, r9) != r0) goto L16;
        return r0;
    L24:
        return Unit.INSTANCE;
    L20:
        r5 = -1;
        goto L21
    L22:
        DoraDeviceBoxBattery.d = false;
        goto L10
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        r2 = (CoroutineScope) this.L$0;
        r9 = this;
        goto L10
    }
}
