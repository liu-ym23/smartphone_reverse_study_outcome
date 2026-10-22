package com.larus.dora.impl.nl;

import com.larus.dora.api.model.FlowDoraConnectReason;
import java.util.concurrent.atomic.AtomicBoolean;
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
import kotlinx.coroutines.flow.StateFlowImpl;
import pk4.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.nl.DoraUserSettingsManager$updateProactiveSwitch$1", f = "DoraUserSettingsManager.kt", i = {}, l = {299, 300}, m = "invokeSuspend", n = {}, s = {})
public final class DoraUserSettingsManager$updateProactiveSwitch$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isChecked;
    int label;

    public DoraUserSettingsManager$updateProactiveSwitch$1(boolean r1, Continuation<? super DoraUserSettingsManager$updateProactiveSwitch$1> r2) {
        this.$isChecked = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraUserSettingsManager$updateProactiveSwitch$1(this.$isChecked, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r14);
    L26:
        AtomicBoolean r15 = n.a;
        m.a(new m());
        DoraUserSettingsManager.b();
        j49.b.i("dora_proactive_status", this.$isChecked, FlowDoraConnectReason.SUCCESS);
    L28:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r14);
    L22:
        if (((Boolean) r14).booleanValue() == false) goto L28;
        StateFlowImpl r16 = DoraUserSettingsManager.n;
        Boolean r2 = Boxing.boxBoolean(this.$isChecked);
        this.label = 2;
        r16.setValue(r2);
        if (Unit.INSTANCE != r0) goto L26;
        return r0;
    L10:
        ResultKt.throwOnFailure(r14);
        DoraUserSettingsManager r17 = DoraUserSettingsManager.a;
        com.larus.dora.impl.network.f0 r3 = DoraUserSettingsManager.c;
        com.larus.dora.impl.network.g0 r4 = r3.d();
        if (r4 != null) goto L13;
        com.larus.dora.impl.network.g0 r5 = null;
    L18:
        com.larus.dora.impl.network.f0 r6 = com.larus.dora.impl.network.f0.a(r3, null, r5, 15);
        this.label = 1;
        r14 = DoraUserSettingsManager.d(r17, r6, this);
        if (r14 != r0) goto L22;
        return r0;
    L13:
        if (this.$isChecked == false) goto L15;
        String r8 = "1";
    L16:
        r5 = com.larus.dora.impl.network.g0.a(r4, null, null, null, r8, null, null, 2031);
        goto L18
    L15:
        r8 = "2";
        goto L16
    }
}
