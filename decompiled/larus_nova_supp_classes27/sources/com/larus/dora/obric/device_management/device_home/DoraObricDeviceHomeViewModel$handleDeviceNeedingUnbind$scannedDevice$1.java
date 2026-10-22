package com.larus.dora.obric.device_management.device_home;

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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/dora/device/DoraDevice;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel$handleDeviceNeedingUnbind$scannedDevice$1", f = "DoraObricDeviceHomeViewModel.kt", i = {}, l = {2453}, m = "invokeSuspend", n = {}, s = {})
public final class DoraObricDeviceHomeViewModel$handleDeviceNeedingUnbind$scannedDevice$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super DoraDevice>, Object> {
    final /* synthetic */ DoraDevice $device;
    int label;
    final /* synthetic */ DoraObricDeviceHomeViewModel this$0;

    public DoraObricDeviceHomeViewModel$handleDeviceNeedingUnbind$scannedDevice$1(DoraObricDeviceHomeViewModel r1, DoraDevice r2, Continuation<? super DoraObricDeviceHomeViewModel$handleDeviceNeedingUnbind$scannedDevice$1> r3) {
        this.this$0 = r1;
        this.$device = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraObricDeviceHomeViewModel$handleDeviceNeedingUnbind$scannedDevice$1(this.this$0, this.$device, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super DoraDevice> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r9);
    L11:
        return r9;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        DoraObricDeviceHomeViewModel r2 = this.this$0;
        String r10 = this.$device.mac;
        this.label = 1;
        r9 = DoraObricDeviceHomeViewModel.scanBleInfo$default(r2, r10, 0, this, 2, null);
        if (r9 != r0) goto L11;
        return r0;
    }
}
