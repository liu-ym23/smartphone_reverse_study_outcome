package com.larus.dora.impl.device.manage;

import android.view.View;
import com.larus.dora.impl.databinding.LarusDoraGDeviceManagementPageBinding;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.manage.DoraGDeviceManagementFragment$updateTitleSettingsRedDotInMainThread$1", f = "DoraGDeviceManagementFragment.kt", i = {}, l = {242}, m = "invokeSuspend", n = {}, s = {})
public final class DoraGDeviceManagementFragment$updateTitleSettingsRedDotInMainThread$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $hasBoundDevice;
    int label;
    final /* synthetic */ DoraGDeviceManagementFragment this$0;

    public DoraGDeviceManagementFragment$updateTitleSettingsRedDotInMainThread$1(boolean r1, DoraGDeviceManagementFragment r2, Continuation<? super DoraGDeviceManagementFragment$updateTitleSettingsRedDotInMainThread$1> r3) {
        this.$hasBoundDevice = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraGDeviceManagementFragment$updateTitleSettingsRedDotInMainThread$1(this.$hasBoundDevice, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L11:
        boolean r7 = ((Boolean) r6).booleanValue();
        g49.d.d("DoraGDeviceManagementFragment", "updateTitleSettingsRedDot shouldShowRedDot=" + r7 + " hasBoundDevice=" + this.$hasBoundDevice);
        LarusDoraGDeviceManagementPageBinding r2 = this.this$0.g;
        if (r2 == null) goto L20;
        View r3 = r2.k;
        if (r3 == null) goto L20;
        if (r7 == false) goto L17;
        int r8 = 0;
    L18:
        r3.setVisibility(r8);
        goto L20
    L17:
        r8 = 8;
    L20:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        CoroutineDispatcher r9 = Dispatchers.getDefault();
        DoraGDeviceManagementFragment$updateTitleSettingsRedDotInMainThread$1$shouldShowRedDot$1 r4 = new DoraGDeviceManagementFragment$updateTitleSettingsRedDotInMainThread$1$shouldShowRedDot$1(this.$hasBoundDevice, null);
        this.label = 1;
        r6 = BuildersKt.withContext(r9, r4, this);
        if (r6 != r0) goto L11;
        return r0;
    }
}
