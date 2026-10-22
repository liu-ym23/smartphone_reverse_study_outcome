package com.larus.dora.impl.device.manage;

import com.larus.platform.service.z2;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.manage.DoraGDeviceManagementFragment$updateTitleSettingsRedDotInMainThread$1$shouldShowRedDot$1", f = "DoraGDeviceManagementFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoraGDeviceManagementFragment$updateTitleSettingsRedDotInMainThread$1$shouldShowRedDot$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ boolean $hasBoundDevice;
    int label;

    public DoraGDeviceManagementFragment$updateTitleSettingsRedDotInMainThread$1$shouldShowRedDot$1(boolean r1, Continuation<? super DoraGDeviceManagementFragment$updateTitleSettingsRedDotInMainThread$1$shouldShowRedDot$1> r2) {
        this.$hasBoundDevice = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraGDeviceManagementFragment$updateTitleSettingsRedDotInMainThread$1$shouldShowRedDot$1(this.$hasBoundDevice, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r4);
        boolean r0 = false;
        if (this.$hasBoundDevice == false) goto L17;
        z2 r5 = z2.a;
        if (r5.f() == false) goto L17;
        boolean r1 = r5.j();
        boolean r2 = r5.e();
        boolean r6 = r5.s();
        if (r1 == true) goto L13;
        if (r2 == true) goto L13;
        if (r6 == true) goto L13;
    L15:
        return Boxing.boxBoolean(r0);
    L13:
        r0 = true;
    L17:
        return Boxing.boxBoolean(false);
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
