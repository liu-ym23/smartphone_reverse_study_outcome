package com.larus.bmhome.clarification;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.clarification.ClarificationComponent$submitCancelAndHandleResult$1", f = "ClarificationComponent.kt", i = {}, l = {956}, m = "invokeSuspend", n = {}, s = {})
public final class ClarificationComponent$submitCancelAndHandleResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $handleResult;
    final /* synthetic */ String $reason;
    final /* synthetic */ d2 $session;
    final /* synthetic */ f2 $submission;
    int label;
    final /* synthetic */ ClarificationComponent this$0;

    public ClarificationComponent$submitCancelAndHandleResult$1(ClarificationComponent r1, f2 r2, d2 r3, boolean r4, String r5, Continuation<? super ClarificationComponent$submitCancelAndHandleResult$1> r6) {
        this.this$0 = r1;
        this.$submission = r2;
        this.$session = r3;
        this.$handleResult = r4;
        this.$reason = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new ClarificationComponent$submitCancelAndHandleResult$1(this.this$0, this.$submission, this.$session, this.$handleResult, this.$reason, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L11:
        h2 r6 = (h2) r5;
        ClarificationComponent.Y2(this.this$0, "cancel", this.$session, r6);
        if (this.$handleResult == false) goto L27;
        ClarificationComponent r2 = this.this$0;
        d2 r3 = this.$session;
        r2.getClass();
        if (Intrinsics.areEqual(r6, h2.c.a) == false) goto L17;
        r2.m3(r3, true);
        r2.Z3(r3, true, "cancel_success");
    L32:
        return Unit.INSTANCE;
    L17:
        if ((r6 instanceof h2.b) == false) goto L19;
    L23:
        r2.c4(r3, r6);
        String r7 = u1.b(r6);
        if (r7 != null) goto L26;
        r7 = "cancel_failed";
    L26:
        r2.Z3(r3, false, r7);
        goto L32
    L19:
        if ((r6 instanceof h2.a) == true) goto L23;
        throw new NoWhenBranchMatchedException();
    L27:
        ClarificationComponent r4 = this.this$0;
        d2 r8 = this.$session;
        boolean r9 = Intrinsics.areEqual(r6, h2.c.a);
        String r10 = u1.b(r6);
        if (r10 != null) goto L30;
        r10 = "cancel_" + this.$reason;
    L30:
        r4.Z3(r8, r9, r10);
        goto L32
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        ClarificationResultSubmitter r11 = this.this$0.p;
        f2 r12 = this.$submission;
        this.label = 1;
        r5 = r11.a(r12, this);
        if (r5 != r0) goto L11;
        return r0;
    }
}
