package com.larus.dora.impl.nl;

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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.nl.DoraUserSettingsManager$updateWearingRemind$1", f = "DoraUserSettingsManager.kt", i = {}, l = {337, 338}, m = "invokeSuspend", n = {}, s = {})
public final class DoraUserSettingsManager$updateWearingRemind$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isChecked;
    int label;

    public DoraUserSettingsManager$updateWearingRemind$1(boolean r1, Continuation<? super DoraUserSettingsManager$updateWearingRemind$1> r2) {
        this.$isChecked = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraUserSettingsManager$updateWearingRemind$1(this.$isChecked, r3);
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
        boolean r3 = true;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r6);
    L32:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r6);
    L18:
        if (((Boolean) r6).booleanValue() == false) goto L32;
        StateFlowImpl r7 = DoraUserSettingsManager.v;
        DoraUserSettingsManager r2 = DoraUserSettingsManager.a;
        IObricDoraService r4 = (IObricDoraService) ServiceManager.get().getService(IObricDoraService.class);
        boolean r5 = false;
        if (r4 != null) goto L22;
    L24:
        r3 = false;
    L25:
        if (r3 == true) goto L28;
        r5 = this.$isChecked;
    L28:
        Boolean r8 = Boxing.boxBoolean(r5);
        this.label = 2;
        r7.setValue(r8);
        if (Unit.INSTANCE != r0) goto L32;
        return r0;
    L22:
        if (r4.t() != true) goto L24;
    L10:
        ResultKt.throwOnFailure(r6);
        DoraUserSettingsManager r9 = DoraUserSettingsManager.a;
        if (this.$isChecked == false) goto L13;
        String r10 = "1";
    L14:
        this.label = 1;
        r6 = DoraUserSettingsManager.c(r9, "wearing_reminder_switch", r10, this);
        if (r6 != r0) goto L18;
        return r0;
    L13:
        r10 = "2";
        goto L14
    }
}
