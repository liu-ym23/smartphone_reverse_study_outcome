package com.larus.dora.impl.device.manage.settings;

import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.dynamic.n1;
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
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.manage.settings.DoraDeviceSettingsViewModel$doraLinkCallback$1$onDoraLinkStateChanged$1", f = "DoraDeviceSettingsViewModel.kt", i = {}, l = {238, 239, 242}, m = "invokeSuspend", n = {}, s = {})
public final class DoraDeviceSettingsViewModel$doraLinkCallback$1$onDoraLinkStateChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DoraDevice $device;
    final /* synthetic */ int $state;
    int label;
    final /* synthetic */ DoraDeviceSettingsViewModel this$0;

    public DoraDeviceSettingsViewModel$doraLinkCallback$1$onDoraLinkStateChanged$1(int r1, DoraDeviceSettingsViewModel r2, DoraDevice r3, Continuation<? super DoraDeviceSettingsViewModel$doraLinkCallback$1$onDoraLinkStateChanged$1> r4) {
        this.$state = r1;
        this.this$0 = r2;
        this.$device = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new DoraDeviceSettingsViewModel$doraLinkCallback$1$onDoraLinkStateChanged$1(this.$state, this.this$0, this.$device, r5);
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
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L9;
        ResultKt.throwOnFailure(r9);
    L24:
        DoraDeviceSettingsViewModel.checkLocalBindState$default(this.this$0, this.$device, 0, 2, null);
    L26:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r9);
        goto L26
    L11:
        ResultKt.throwOnFailure(r9);
    L17:
        z0 r10 = DoraDeviceSettingsViewModel.access$get_deviceStateFlow$p(this.this$0);
        long r2 = DoraDeviceSettingsViewModel.access$getDeviceStateSeq$p(this.this$0);
        DoraDeviceSettingsViewModel.access$setDeviceStateSeq$p(this.this$0, 1 + r2);
        DoraDeviceSettingsViewModel.e.a r3 = new DoraDeviceSettingsViewModel.e.a(r2, this.$device);
        this.label = 2;
        if (r10.emit(r3, this) != r0) goto L26;
        return r0;
    L12:
        ResultKt.throwOnFailure(r9);
        g49.d.d("DoraDynamicViewModelV2", "onDoraLinkStateChanged: state = " + this.$state);
        int r11 = this.$state;
        if (r11 != 2) goto L20;
        this.this$0.checkBindState(this.$device);
        this.label = 1;
        if (DelayKt.delay(500, this) != r0) goto L17;
        return r0;
    L20:
        if (r11 != 0) goto L26;
        int r12 = n1.a;
        z49.b r13 = n1.b(this.$device);
        z0 r4 = DoraDeviceSettingsViewModel.access$get_deviceStateFlow$p(this.this$0);
        DoraDeviceSettingsViewModel.e.c r5 = new DoraDeviceSettingsViewModel.e.c(r13);
        this.label = 3;
        if (r4.emit(r5, this) != r0) goto L24;
        return r0;
    }
}
