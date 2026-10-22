package com.larus.dora.impl.nl;

import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.network.DoraNetworkApi;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
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
@DebugMetadata(c = "com.larus.dora.impl.nl.DoraUserSettingsManager$syncNotificationBroadcastV3Settings$1", f = "DoraUserSettingsManager.kt", i = {}, l = {253, 259}, m = "invokeSuspend", n = {}, s = {})
public final class DoraUserSettingsManager$syncNotificationBroadcastV3Settings$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DoraDevice $device;
    final /* synthetic */ String $where;
    Object L$0;
    int label;

    public DoraUserSettingsManager$syncNotificationBroadcastV3Settings$1(DoraDevice r1, String r2, Continuation<? super DoraUserSettingsManager$syncNotificationBroadcastV3Settings$1> r3) {
        this.$device = r1;
        this.$where = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraUserSettingsManager$syncNotificationBroadcastV3Settings$1(this.$device, this.$where, r4);
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
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        Object r2 = this.L$0;
        ResultKt.throwOnFailure(r8);
    L19:
        Object r9 = r2;
    L20:
        String r3 = this.$where;
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L24;
        g49.d.c("DoraUserSettingsManager", "syncNotificationBroadcastV3Settings failed, where=" + r3, r10);
    L24:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r8);
        r9 = ((Result) r8).unbox-impl();
    L13:
        String r4 = this.$where;
        if (Result.isSuccess-impl(r9) == false) goto L20;
        q59.a r5 = q59.b.b(((com.larus.dora.impl.network.d) r9).a());
        g49.d.d("DoraUserSettingsManager", "syncNotificationBroadcastV3Settings success, where=" + r4 + ", settings=" + r5);
        StateFlowImpl r6 = DoraUserSettingsManager.l;
        this.L$0 = r9;
        this.label = 2;
        r6.setValue(r5);
        if (Unit.INSTANCE != r0) goto L18;
        return r0;
    L18:
        r2 = r9;
        goto L19
    L10:
        ResultKt.throwOnFailure(r8);
        DoraNetworkApi r11 = DoraNetworkApi.a;
        DoraDevice r7 = this.$device;
        List<String> r12 = q59.c.a;
        this.label = 1;
        r9 = r11.l(r7, r12, this);
        if (r9 != r0) goto L13;
        return r0;
    }
}
