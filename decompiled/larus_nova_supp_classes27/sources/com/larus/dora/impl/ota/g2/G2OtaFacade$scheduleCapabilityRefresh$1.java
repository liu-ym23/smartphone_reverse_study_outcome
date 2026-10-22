package com.larus.dora.impl.ota.g2;

import com.bytedance.dora.device.DoraDevice;
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
@DebugMetadata(c = "com.larus.dora.impl.ota.g2.G2OtaFacade$scheduleCapabilityRefresh$1", f = "G2OtaFacade.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class G2OtaFacade$scheduleCapabilityRefresh$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ n $connection;
    final /* synthetic */ Trigger $trigger;
    int label;

    public G2OtaFacade$scheduleCapabilityRefresh$1(Trigger r1, n r2, Continuation<? super G2OtaFacade$scheduleCapabilityRefresh$1> r3) {
        this.$trigger = r1;
        this.$connection = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new G2OtaFacade$scheduleCapabilityRefresh$1(this.$trigger, this.$connection, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L17;
        ResultKt.throwOnFailure(r15);
        G2OtaFacade r1 = G2OtaFacade.INSTANCE;
        r1.getClass();
        DoraDevice r16 = G2OtaFacade.s();
        if (r16 == null) goto L15;
        if (G2OtaFacade.E(this.$connection, r16) == true) goto L10;
        r16 = null;
    L10:
        DoraDevice r2 = r16;
        if (r2 == null) goto L15;
        G2OtaFacade.O(r1, r2, this.$trigger, false, null, null, null, null, null, null, null, this.$connection, 1020);
        return Unit.INSTANCE;
    L15:
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
