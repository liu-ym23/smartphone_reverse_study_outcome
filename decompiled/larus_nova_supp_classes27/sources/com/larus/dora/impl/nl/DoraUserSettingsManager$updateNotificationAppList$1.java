package com.larus.dora.impl.nl;

import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.nl.DoraUserSettingsManager$updateNotificationAppList$1", f = "DoraUserSettingsManager.kt", i = {}, l = {235, 237}, m = "invokeSuspend", n = {}, s = {})
final class DoraUserSettingsManager$updateNotificationAppList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<com.larus.dora.impl.network.s> $appList;
    int label;

    public DoraUserSettingsManager$updateNotificationAppList$1(List<com.larus.dora.impl.network.s> r1, Continuation<? super DoraUserSettingsManager$updateNotificationAppList$1> r2) {
        this.$appList = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraUserSettingsManager$updateNotificationAppList$1(this.$appList, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        List<com.larus.dora.impl.network.s> r2 = null;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r8);
    L26:
        DoraUserSettingsManager.a();
    L28:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r8);
    L14:
        if (((Boolean) r8).booleanValue() == false) goto L28;
        Type r9 = k.e;
        k r10 = k.b.a;
        List<com.larus.dora.impl.network.s> r3 = this.$appList;
        if ((true ^ r3.isEmpty()) == false) goto L18;
        r2 = r3;
    L18:
        if (r2 != null) goto L20;
        r2 = DoraUserSettingsManager.u;
    L20:
        r10.c(r2);
        StateFlowImpl r4 = DoraUserSettingsManager.j;
        List r11 = r10.a;
        if (r11 != null) goto L23;
        r11 = DoraUserSettingsManager.u;
    L23:
        this.label = 2;
        r4.setValue(r11);
        if (Unit.INSTANCE != r0) goto L26;
        return r0;
    L10:
        ResultKt.throwOnFailure(r8);
        DoraUserSettingsManager r12 = DoraUserSettingsManager.a;
        com.larus.dora.impl.network.f0 r5 = com.larus.dora.impl.network.f0.a(DoraUserSettingsManager.c, this.$appList, null, 23);
        this.label = 1;
        r8 = DoraUserSettingsManager.d(r12, r5, this);
        if (r8 != r0) goto L14;
        return r0;
    }
}
