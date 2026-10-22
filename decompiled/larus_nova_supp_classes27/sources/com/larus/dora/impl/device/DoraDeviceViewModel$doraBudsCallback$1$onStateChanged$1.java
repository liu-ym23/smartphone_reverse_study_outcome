package com.larus.dora.impl.device;

import com.bytedance.dora.device.DoraDevice;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.DoraDeviceViewModel$doraBudsCallback$1$onStateChanged$1", f = "DoraDeviceViewModel.kt", i = {}, l = {139}, m = "invokeSuspend", n = {}, s = {})
public final class DoraDeviceViewModel$doraBudsCallback$1$onStateChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DoraDevice $device;
    int label;
    final /* synthetic */ DoraDeviceViewModel this$0;

    public DoraDeviceViewModel$doraBudsCallback$1$onStateChanged$1(DoraDeviceViewModel r1, DoraDevice r2, Continuation<? super DoraDeviceViewModel$doraBudsCallback$1$onStateChanged$1> r3) {
        this.this$0 = r1;
        this.$device = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraDeviceViewModel$doraBudsCallback$1$onStateChanged$1(this.this$0, this.$device, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L16:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        if ((((c) DoraDeviceViewModel.access$get_deviceStateFlow$p(this.this$0).getValue()) instanceof c.a) == false) goto L16;
        DoraDevice r11 = this.$device;
        if (r11 == null) goto L16;
        DoraDeviceViewModel r2 = this.this$0;
        z0 r3 = DoraDeviceViewModel.access$get_deviceStateFlow$p(r2);
        long r5 = DoraDeviceViewModel.access$getDeviceStateSeq$p(r2);
        DoraDeviceViewModel.access$setDeviceStateSeq$p(r2, 1 + r5);
        c.a r4 = new c.a(r5, r11);
        this.label = 1;
        if (r3.emit(r4, this) != r0) goto L16;
        return r0;
    }
}
