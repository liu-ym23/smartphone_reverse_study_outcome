package com.larus.dora.obric.device_management.setting.earbuds.general;

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
@DebugMetadata(c = "com.larus.dora.obric.device_management.setting.earbuds.general.DoraObricEarbudsGeneralSettingsFragment$bindMultiDeviceSwitch$1$1$1", f = "DoraObricEarbudsGeneralSettingsFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DoraObricEarbudsGeneralSettingsFragment$bindMultiDeviceSwitch$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isChecked;
    int label;
    final /* synthetic */ DoraObricEarbudsGeneralSettingsFragment this$0;

    public DoraObricEarbudsGeneralSettingsFragment$bindMultiDeviceSwitch$1$1$1(boolean r1, DoraObricEarbudsGeneralSettingsFragment r2, Continuation<? super DoraObricEarbudsGeneralSettingsFragment$bindMultiDeviceSwitch$1$1$1> r3) {
        this.$isChecked = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraObricEarbudsGeneralSettingsFragment$bindMultiDeviceSwitch$1$1$1(this.$isChecked, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r2);
        int r3 = kj4.a.g().p(this.$isChecked ? 1 : 0);
        t39.c r0 = j49.b.a;
        j49.b.g(this.$isChecked, r3);
        DoraObricEarbudsGeneralSettingsFragment r4 = this.this$0;
        int r1 = DoraObricEarbudsGeneralSettingsFragment.p;
        r4.ca0().updateMultiDeviceEnable();
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
