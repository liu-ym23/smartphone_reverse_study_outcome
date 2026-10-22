package com.larus.dora.impl.device.manage.viewmodel;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel$batteryCallback$1$onBatteryChanged$1", f = "DoraGDeviceManagementViewModel.kt", i = {}, l = {295, 296}, m = "invokeSuspend", n = {}, s = {})
public final class DoraGDeviceManagementViewModel$batteryCallback$1$onBatteryChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DoraGDeviceManagementViewModel this$0;

    public DoraGDeviceManagementViewModel$batteryCallback$1$onBatteryChanged$1(DoraGDeviceManagementViewModel r1, Continuation<? super DoraGDeviceManagementViewModel$batteryCallback$1$onBatteryChanged$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraGDeviceManagementViewModel$batteryCallback$1$onBatteryChanged$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r7);
    L17:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r7);
    L13:
        DoraGDeviceManagementViewModel r8 = this.this$0;
        this.label = 2;
        if (DoraGDeviceManagementViewModel.access$updateOnlyDeviceComponent(r8, this) != r0) goto L17;
        return r0;
    L10:
        ResultKt.throwOnFailure(r7);
        long r4 = DoraGDeviceManagementViewModel.access$getDebounceDelayMs$p(this.this$0);
        this.label = 1;
        if (DelayKt.delay(r4, this) != r0) goto L13;
        return r0;
    }
}
