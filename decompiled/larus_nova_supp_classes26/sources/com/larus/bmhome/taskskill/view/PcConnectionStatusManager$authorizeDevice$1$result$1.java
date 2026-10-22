package com.larus.bmhome.taskskill.view;

import com.larus.bmhome.taskskill.network.PcDeviceRepository;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.taskskill.view.PcConnectionStatusManager$authorizeDevice$1$result$1", f = "PcConnectionStatusManager.kt", i = {}, l = {429}, m = "invokeSuspend", n = {}, s = {})
public final class PcConnectionStatusManager$authorizeDevice$1$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object> {
    final /* synthetic */ String $targetDeviceId;
    final /* synthetic */ String $ticket;
    int label;

    public PcConnectionStatusManager$authorizeDevice$1$result$1(String r1, String r2, Continuation<? super PcConnectionStatusManager$authorizeDevice$1$result$1> r3) {
        this.$targetDeviceId = r1;
        this.$ticket = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new PcConnectionStatusManager$authorizeDevice$1$result$1(this.$targetDeviceId, this.$ticket, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Result<Unit>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
        Object r6 = ((Result) r5).unbox-impl();
    L12:
        return Result.box-impl(r6);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        PcDeviceRepository r7 = PcDeviceRepository.a;
        String r2 = this.$targetDeviceId;
        String r3 = this.$ticket;
        this.label = 1;
        r6 = r7.a(r2, r3, this);
        if (r6 != r0) goto L12;
        return r0;
    }
}
