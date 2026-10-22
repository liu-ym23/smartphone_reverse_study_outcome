package com.larus.dora.obric.device_management.setting.g.general;

import com.larus.dora.impl.sysinfo.DoraSystemInfoManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.obric.device_management.setting.g.general.DoraObricGGeneralSettingsFragment$wearSensorCheckedChangeListener$1$1", f = "DoraObricGGeneralSettingsFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoraObricGGeneralSettingsFragment$wearSensorCheckedChangeListener$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isChecked;
    int label;
    final /* synthetic */ DoraObricGGeneralSettingsFragment this$0;

    public DoraObricGGeneralSettingsFragment$wearSensorCheckedChangeListener$1$1(boolean r1, DoraObricGGeneralSettingsFragment r2, Continuation<? super DoraObricGGeneralSettingsFragment$wearSensorCheckedChangeListener$1$1> r3) {
        this.$isChecked = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraObricGGeneralSettingsFragment$wearSensorCheckedChangeListener$1$1(this.$isChecked, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r3);
        int r4 = kj4.a.g().x(this.$isChecked ? 1 : 0);
        t39.c r0 = j49.b.a;
        j49.b.j(this.$isChecked, r4);
        DoraObricGGeneralSettingsFragment r1 = this.this$0;
        int r2 = DoraObricGGeneralSettingsFragment.x;
        r1.ba0().updateWearSensorEnable();
        g49.d.d("DoraObricGGeneralSettings", "doraWearSensor set: " + this.$isChecked + ", ret: " + r4);
        if (r4 != 0) goto L12;
        if (this.$isChecked == false) goto L9;
        String r5 = "1";
    L10:
        DoraSystemInfoManager r6 = DoraSystemInfoManager.a;
        DoraSystemInfoManager.f(CollectionsKt.listOf(TuplesKt.to("wear_detection_switch", r5)));
        goto L12
    L9:
        r5 = "0";
    L12:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
