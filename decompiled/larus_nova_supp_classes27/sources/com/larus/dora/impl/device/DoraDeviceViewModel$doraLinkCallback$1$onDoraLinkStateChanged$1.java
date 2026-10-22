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
@DebugMetadata(c = "com.larus.dora.impl.device.DoraDeviceViewModel$doraLinkCallback$1$onDoraLinkStateChanged$1", f = "DoraDeviceViewModel.kt", i = {}, l = {107, 111}, m = "invokeSuspend", n = {}, s = {})
public final class DoraDeviceViewModel$doraLinkCallback$1$onDoraLinkStateChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DoraDevice $device;
    final /* synthetic */ int $state;
    int label;
    final /* synthetic */ DoraDeviceViewModel this$0;

    public DoraDeviceViewModel$doraLinkCallback$1$onDoraLinkStateChanged$1(int r1, DoraDeviceViewModel r2, DoraDevice r3, Continuation<? super DoraDeviceViewModel$doraLinkCallback$1$onDoraLinkStateChanged$1> r4) {
        this.$state = r1;
        this.this$0 = r2;
        this.$device = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new DoraDeviceViewModel$doraLinkCallback$1$onDoraLinkStateChanged$1(this.$state, this.this$0, this.$device, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r9);
    L23:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r9);
    L15:
        DoraDeviceViewModel.access$loadDeviceFeature(this.this$0);
        goto L23
    L10:
        ResultKt.throwOnFailure(r9);
        g49.d.d("DoraDeviceViewModel", "onDoraLinkStateChanged: state = " + this.$state);
        int r10 = this.$state;
        if (r10 != 2) goto L16;
        DoraDeviceViewModel.access$stopDisconnectedRetry(this.this$0, false);
        this.this$0.stopConnectAndScan("LinkState.CONNECTED");
        this.this$0.checkBindState(this.$device);
        z0 r11 = DoraDeviceViewModel.access$get_deviceStateFlow$p(this.this$0);
        long r3 = DoraDeviceViewModel.access$getDeviceStateSeq$p(this.this$0);
        DoraDeviceViewModel.access$setDeviceStateSeq$p(this.this$0, 1 + r3);
        c.a r2 = new c.a(r3, this.$device);
        this.label = 1;
        if (r11.emit(r2, this) != r0) goto L15;
        return r0;
    L16:
        if (r10 != 0) goto L23;
        if ((DoraDeviceViewModel.access$get_deviceStateFlow$p(this.this$0).getValue() instanceof c.d) == true) goto L23;
        z0 r12 = DoraDeviceViewModel.access$get_deviceStateFlow$p(this.this$0);
        c.b r4 = new c.b(false, DoraDeviceViewModel.access$getLastConnectDevice(this.this$0));
        this.label = 2;
        if (r12.emit(r4, this) != r0) goto L23;
        return r0;
    }
}
