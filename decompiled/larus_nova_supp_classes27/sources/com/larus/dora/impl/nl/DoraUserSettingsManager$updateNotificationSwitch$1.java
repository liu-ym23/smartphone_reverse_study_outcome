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
@DebugMetadata(c = "com.larus.dora.impl.nl.DoraUserSettingsManager$updateNotificationSwitch$1", f = "DoraUserSettingsManager.kt", i = {}, l = {211, 214}, m = "invokeSuspend", n = {}, s = {})
public final class DoraUserSettingsManager$updateNotificationSwitch$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isChecked;
    int label;

    public DoraUserSettingsManager$updateNotificationSwitch$1(boolean r1, Continuation<? super DoraUserSettingsManager$updateNotificationSwitch$1> r2) {
        this.$isChecked = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraUserSettingsManager$updateNotificationSwitch$1(this.$isChecked, r3);
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
        int r3 = 1;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r14);
    L30:
        AtomicBoolean r15 = n.a;
        m.a(new m());
        DoraUserSettingsManager.a();
        j49.b.i("dora_notification_status", this.$isChecked, FlowDoraConnectReason.SUCCESS);
    L32:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r14);
    L22:
        if (((Boolean) r14).booleanValue() == false) goto L32;
        NLServiceImpl r16 = DoraUserSettingsManager.t;
        if (this.$isChecked == true) goto L27;
        r3 = 2;
    L27:
        r16.g(r3);
        StateFlowImpl r17 = DoraUserSettingsManager.f;
        Boolean r2 = Boxing.boxBoolean(this.$isChecked);
        this.label = 2;
        r17.setValue(r2);
        if (Unit.INSTANCE != r0) goto L30;
        return r0;
    L10:
        ResultKt.throwOnFailure(r14);
        DoraUserSettingsManager r18 = DoraUserSettingsManager.a;
        com.larus.dora.impl.network.f0 r4 = DoraUserSettingsManager.c;
        com.larus.dora.impl.network.g0 r5 = r4.d();
        if (r5 != null) goto L13;
        com.larus.dora.impl.network.g0 r6 = null;
    L18:
        com.larus.dora.impl.network.f0 r7 = com.larus.dora.impl.network.f0.a(r4, null, r6, 15);
        this.label = 1;
        r14 = DoraUserSettingsManager.d(r18, r7, this);
        if (r14 != r0) goto L22;
        return r0;
    L13:
        if (this.$isChecked == false) goto L15;
        String r8 = "1";
    L16:
        r6 = com.larus.dora.impl.network.g0.a(r5, r8, null, null, null, null, null, 2045);
        goto L18
    L15:
        r8 = "2";
        goto L16
    }
}
