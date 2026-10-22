package com.larus.dora.impl.serviceimpl;

import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.nl.DoraUserSettingsManager;
import com.obric.assistant.spi.dora.IObricDoraService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.serviceimpl.DeviceService$WearStateCallback$onWearStateChanged$1", f = "DeviceService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DeviceService$WearStateCallback$onWearStateChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DoraDevice $device;
    final /* synthetic */ boolean $leftOn;
    final /* synthetic */ boolean $rightOn;
    int label;
    final /* synthetic */ DeviceService.WearStateCallback this$0;

    public DeviceService$WearStateCallback$onWearStateChanged$1(DeviceService.WearStateCallback r1, boolean r2, boolean r3, DoraDevice r4, Continuation<? super DeviceService$WearStateCallback$onWearStateChanged$1> r5) {
        this.this$0 = r1;
        this.$leftOn = r2;
        this.$rightOn = r3;
        this.$device = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new DeviceService$WearStateCallback$onWearStateChanged$1(this.this$0, this.$leftOn, this.$rightOn, this.$device, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L21;
        ResultKt.throwOnFailure(r5);
        if (DeviceService.WearStateCallback.a(this.this$0, this.$leftOn, this.$rightOn) == false) goto L19;
        boolean r0 = true;
        if (Intrinsics.areEqual(DoraUserSettingsManager.w.getValue(), Boxing.boxBoolean(true)) == false) goto L9;
        g49.d.d("DeviceService", "onWearStateChanged, wear remind on, HWearStateCallback: leftOn=" + this.$leftOn + ", rightOn=" + this.$rightOn);
        h49.l r6 = this.this$0.a;
        boolean r1 = this.$leftOn;
        boolean r2 = this.$rightOn;
        int r3 = DeviceService.f;
        r6.f(r1, r2, DeviceService.a.a(this.$device));
    L10:
        IObricDoraService r7 = (IObricDoraService) ServiceManager.get().getService(IObricDoraService.class);
        if (r7 != null) goto L13;
    L15:
        r0 = false;
    L16:
        if (r0 == false) goto L19;
        h49.l r8 = this.this$0.a;
        boolean r4 = this.$leftOn;
        boolean r9 = this.$rightOn;
        int r10 = DeviceService.f;
        r8.g(r4, r9, DeviceService.a.a(this.$device));
        goto L19
    L13:
        if (r7.t() != true) goto L15;
    L9:
        g49.d.d("DeviceService", "onWearStateChanged, wear remind off, HWearStateCallback: leftOn=" + this.$leftOn + ", rightOn=" + this.$rightOn);
    L19:
        return Unit.INSTANCE;
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
