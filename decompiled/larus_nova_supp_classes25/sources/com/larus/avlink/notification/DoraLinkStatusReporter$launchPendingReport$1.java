package com.larus.avlink.notification;

import com.larus.avlink.model.DoraCallStateCode;
import com.larus.avlink.n1;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.network.bean.BizResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.notification.DoraLinkStatusReporter$launchPendingReport$1", f = "DoraLinkStatusReporter.kt", i = {2, 2}, l = {DoraCallStateCode.DOUBAO_CMD_5, DoraCallStateCode.DOUBAO_CMD_13, DoraCallStateCode.ENV_OBSERVE_AUTO_TIMER_ENTER_PAUSE}, m = "invokeSuspend", n = {"result", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1"})
final class DoraLinkStatusReporter$launchPendingReport$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DoraLinkStatusReporter.a $currStatus;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    public DoraLinkStatusReporter$launchPendingReport$1(DoraLinkStatusReporter.a r1, Continuation<? super DoraLinkStatusReporter$launchPendingReport$1> r2) {
        this.$currStatus = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraLinkStatusReporter$launchPendingReport$1(this.$currStatus, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = this.label;
        boolean r7 = true;
        if (r3 == 0) goto L12;
        if (r3 == 1) goto L11;
        if (r3 == 2) goto L10;
        if (r3 != 3) goto L9;
        DoraLinkStatusReporter.a r4 = (DoraLinkStatusReporter.a) this.L$2;
        kotlinx.coroutines.sync.a r5 = (kotlinx.coroutines.sync.a) this.L$1;
        BizResponse r6 = (BizResponse) this.L$0;
        ResultKt.throwOnFailure(r15);
    L38:
        DoraLinkStatusReporter.c = null;     // Catch: Throwable -> L35
        if (r6 != null) goto L25;
    L27:
        r7 = false;
    L29:
        if (r7 == false) goto L31;
        DoraLinkStatusReporter.b = r4;     // Catch: Throwable -> L35
        n1.d("DoraLinkStatusReporter", "Report success: " + DoraLinkStatusReporter.b + ", " + r6);     // Catch: Throwable -> L35
    L32:
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L35
        r5.unlock(null);
        return Unit.INSTANCE;
    L31:
        n1.d("DoraLinkStatusReporter", "Report failed: " + r4 + ", " + r6);     // Catch: Throwable -> L35
        goto L32
    L25:
        if (r6.isSuccess() != true) goto L27;
    L35:
        th = move-exception;
        r5.unlock(null);
        throw th;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r15);
    L18:
        BizResponse r17 = (BizResponse) r15;
        r5 = DoraLinkStatusReporter.e;
        DoraLinkStatusReporter.a r8 = this.$currStatus;
        this.L$0 = r17;
        this.L$1 = r5;
        this.L$2 = r8;
        this.label = 3;
        if (r5.a(null, this) != r2) goto L21;
        return r2;
    L21:
        r6 = r17;
        r4 = r8;
        goto L38
    L11:
        ResultKt.throwOnFailure(r15);
    L15:
        DoraLinkStatusReporter r9 = DoraLinkStatusReporter.a;
        DoraLinkStatusReporter.a r18 = this.$currStatus;
        boolean r10 = r18.a;
        int r11 = r18.b;
        int r12 = r18.c;
        this.label = 2;
        r15 = DoraLinkStatusReporter.a(r9, r10, r11, r12, 5, this);
        if (r15 != r2) goto L18;
        return r2;
    L12:
        ResultKt.throwOnFailure(r15);
        this.label = 1;
        if (DelayKt.delay(250, this) != r2) goto L15;
        return r2;
    }
}
