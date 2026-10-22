package com.larus.avlink.notification;

import com.larus.avlink.model.DoraCallStateCode;
import com.larus.avlink.n1;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.notification.DoraLinkStatusReporter$reportStatus$1", f = "DoraLinkStatusReporter.kt", i = {0}, l = {DoraCallStateCode.ENV_OBSERVE_AUTO_TIMER_ENTER_PAUSE}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
public final class DoraLinkStatusReporter$reportStatus$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DoraLinkStatusReporter.a $currStatus;
    Object L$0;
    Object L$1;
    int label;

    public DoraLinkStatusReporter$reportStatus$1(DoraLinkStatusReporter.a r1, Continuation<? super DoraLinkStatusReporter$reportStatus$1> r2) {
        this.$currStatus = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraLinkStatusReporter$reportStatus$1(this.$currStatus, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = this.label;
        if (r4 == 0) goto L8;
        if (r4 != 1) goto L7;
        DoraLinkStatusReporter.a r5 = (DoraLinkStatusReporter.a) this.L$1;
        kotlinx.coroutines.sync.a r6 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r15);
    L35:
    L32:
        th = move-exception;
        r6.unlock(null);
        throw th;
    L14:
        if (Intrinsics.areEqual(r5, DoraLinkStatusReporter.c) == false) goto L16;
        n1.d("DoraLinkStatusReporter", "Cancel pending last: " + DoraLinkStatusReporter.c + ", curState: " + r5);     // Catch: Throwable -> L32
    L29:
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L32
        r6.unlock(null);
        return Unit.INSTANCE;
    L16:
        DoraLinkStatusReporter.a r17 = DoraLinkStatusReporter.c;     // Catch: Throwable -> L32
        if (r17 != null) goto L19;
        r17 = DoraLinkStatusReporter.b;     // Catch: Throwable -> L32
    L19:
        if (r17 != null) goto L21;
    L25:
        Job r18 = DoraLinkStatusReporter.d;     // Catch: Throwable -> L32
        if (r18 == null) goto L28;
        Job.DefaultImpls.cancel$default(r18, null, 1, null);     // Catch: Throwable -> L32
    L28:
        DoraLinkStatusReporter.d = null;     // Catch: Throwable -> L32
        DoraLinkStatusReporter.c = null;     // Catch: Throwable -> L32
        n1.d("DoraLinkStatusReporter", "New status to report: " + r5);     // Catch: Throwable -> L32
        DoraLinkStatusReporter.c = r5;     // Catch: Throwable -> L32
        DoraLinkStatusReporter.d = BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new DoraLinkStatusReporter$launchPendingReport$1(r5, null), 2, null);     // Catch: Throwable -> L32
        goto L29
    L21:
        if (r5.a != r17.a) goto L25;
        if (r5.b != r17.b) goto L25;
        n1.d("DoraLinkStatusReporter", "No change since last report (effective: " + r17 + ')');     // Catch: Throwable -> L32
        goto L29
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r15);
        r6 = DoraLinkStatusReporter.e;
        DoraLinkStatusReporter.a r19 = this.$currStatus;
        this.L$0 = r6;
        this.L$1 = r19;
        this.label = 1;
        if (r6.a(null, this) != r3) goto L11;
        return r3;
    L11:
        r5 = r19;
        goto L35
    }
}
