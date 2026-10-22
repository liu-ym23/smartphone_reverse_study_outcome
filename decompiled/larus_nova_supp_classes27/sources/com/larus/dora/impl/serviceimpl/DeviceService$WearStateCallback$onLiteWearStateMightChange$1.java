package com.larus.dora.impl.serviceimpl;

import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.nl.DoraUserSettingsManager;
import com.larus.dora.impl.settings.DoraSetting;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.serviceimpl.DeviceService$WearStateCallback$onLiteWearStateMightChange$1", f = "DeviceService.kt", i = {}, l = {787, 794}, m = "invokeSuspend", n = {}, s = {})
public final class DeviceService$WearStateCallback$onLiteWearStateMightChange$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DoraDevice $device;
    int label;
    final /* synthetic */ DeviceService.WearStateCallback this$0;

    public DeviceService$WearStateCallback$onLiteWearStateMightChange$1(DeviceService.WearStateCallback r1, DoraDevice r2, Continuation<? super DeviceService$WearStateCallback$onLiteWearStateMightChange$1> r3) {
        this.this$0 = r1;
        this.$device = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DeviceService$WearStateCallback$onLiteWearStateMightChange$1(this.this$0, this.$device, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r14);
    L24:
        DeviceService.WearStateCallback r15 = this.this$0;
        h49.l r2 = r15.a;
        boolean r3 = r15.c;
        boolean r16 = r15.d;
        int r4 = DeviceService.f;
        r2.f(r3, r16, DeviceService.a.a(this.$device));
    L27:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r14);
    L17:
        Long r17 = (Long) r14;
        if (r17 == null) goto L20;
        long r5 = r17.longValue();
    L21:
        this.label = 2;
        if (DelayKt.delay(r5, this) != r0) goto L24;
        return r0;
    L20:
        r5 = 4000;
        goto L21
    L10:
        ResultKt.throwOnFailure(r14);
        DeviceService.WearStateCallback r18 = this.this$0;
        if (DeviceService.WearStateCallback.a(r18, r18.c, r18.d) == false) goto L27;
        if (Intrinsics.areEqual(DoraUserSettingsManager.w.getValue(), Boxing.boxBoolean(true)) == false) goto L25;
        g49.d.d("DeviceService", "onWearStateMightChange, wear remind on, LiteWearStateCallback: isLeftOn=" + this.this$0.c + ", isRightOn=" + this.this$0.d);
        DoraSetting r6 = DoraSetting.a;
        Function0 r11 = new o();
        this.label = 1;
        r14 = r6.b(5000, 100, "DeviceService-onLiteWearStateMightChange-autoGreetLiteEventDelayTime", r11, this);
        if (r14 != r0) goto L17;
        return r0;
    L25:
        g49.d.d("DeviceService", "onWearStateMightChange, wear remind off, LiteWearStateCallback: isLeftOn=" + this.this$0.c + ", isRightOn=" + this.this$0.d);
        goto L27
    }
}
