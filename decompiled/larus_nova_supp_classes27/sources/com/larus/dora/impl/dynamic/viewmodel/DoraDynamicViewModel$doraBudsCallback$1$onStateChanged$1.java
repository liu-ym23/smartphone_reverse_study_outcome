package com.larus.dora.impl.dynamic.viewmodel;

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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModel$doraBudsCallback$1$onStateChanged$1", f = "DoraDynamicViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoraDynamicViewModel$doraBudsCallback$1$onStateChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DoraDevice $device;
    int label;
    final /* synthetic */ DoraDynamicViewModel this$0;

    public DoraDynamicViewModel$doraBudsCallback$1$onStateChanged$1(DoraDevice r1, DoraDynamicViewModel r2, Continuation<? super DoraDynamicViewModel$doraBudsCallback$1$onStateChanged$1> r3) {
        this.$device = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraDynamicViewModel$doraBudsCallback$1$onStateChanged$1(this.$device, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r6);
        DoraDevice r7 = this.$device;
        if (r7 == null) goto L8;
        DoraDynamicViewModel r0 = this.this$0;
        DoraDynamicViewModel.a r3 = new DoraDynamicViewModel.a(((DoraDynamicViewModel.a) DoraDynamicViewModel.access$get_deviceBatteryStateFlow$p(r0).getValue()).a + 1, r7);
        g49.d.d(DoraDynamicViewModel.TAG, "onStateChanged: newBatteryState=" + r3);
        DoraDynamicViewModel.access$get_deviceBatteryStateFlow$p(r0).setValue(r3);
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
