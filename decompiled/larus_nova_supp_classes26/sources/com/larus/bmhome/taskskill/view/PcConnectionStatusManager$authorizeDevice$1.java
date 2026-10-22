package com.larus.bmhome.taskskill.view;

import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Result;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.taskskill.view.PcConnectionStatusManager$authorizeDevice$1", f = "PcConnectionStatusManager.kt", i = {}, l = {428}, m = "invokeSuspend", n = {}, s = {})
public final class PcConnectionStatusManager$authorizeDevice$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $targetDeviceId;
    final /* synthetic */ String $ticket;
    int label;
    final /* synthetic */ PcConnectionStatusManager this$0;

    public PcConnectionStatusManager$authorizeDevice$1(String r1, String r2, PcConnectionStatusManager r3, Continuation<? super PcConnectionStatusManager$authorizeDevice$1> r4) {
        this.$targetDeviceId = r1;
        this.$ticket = r2;
        this.this$0 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new PcConnectionStatusManager$authorizeDevice$1(this.$targetDeviceId, this.$ticket, this.this$0, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L11:
        Object r8 = ((Result) r7).unbox-impl();
        String r2 = this.$targetDeviceId;
        PcConnectionStatusManager r3 = this.this$0;
        if (Result.isSuccess-impl(r8) == false) goto L14;
        Unit r4 = (Unit) r8;
        FLogger.a.i("PcConnectionStatusManager", "[authorizeDevice] success, targetDeviceId=" + r2);
        int r5 = PcConnectionStatusManager.k;
        r3.b.d();
        r3.h.postValue(b.a.a);
    L14:
        String r6 = this.$targetDeviceId;
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L18;
        FLogger.a.w("PcConnectionStatusManager", "[authorizeDevice] failed, targetDeviceId=" + r6, r9);
    L18:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        CoroutineDispatcher r10 = Dispatchers.getIO();
        PcConnectionStatusManager$authorizeDevice$1$result$1 r11 = new PcConnectionStatusManager$authorizeDevice$1$result$1(this.$targetDeviceId, this.$ticket, null);
        this.label = 1;
        r7 = BuildersKt.withContext(r10, r11, this);
        if (r7 != r0) goto L11;
        return r0;
    }
}
