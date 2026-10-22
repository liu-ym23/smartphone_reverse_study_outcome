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
@DebugMetadata(c = "com.larus.bmhome.clarification.ClarificationComponent$submitFinish$1", f = "ClarificationComponent.kt", i = {}, l = {556}, m = "invokeSuspend", n = {}, s = {})
public final class ClarificationComponent$submitFinish$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ d2 $session;
    final /* synthetic */ f2 $submission;
    int label;
    final /* synthetic */ ClarificationComponent this$0;

    public ClarificationComponent$submitFinish$1(ClarificationComponent r1, f2 r2, d2 r3, Continuation<? super ClarificationComponent$submitFinish$1> r4) {
        this.this$0 = r1;
        this.$submission = r2;
        this.$session = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ClarificationComponent$submitFinish$1(this.this$0, this.$submission, this.$session, r5);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L11:
        h2 r7 = (h2) r6;
        ClarificationComponent.Y2(this.this$0, "finish", this.$session, r7);
        ClarificationComponent r2 = this.this$0;
        d2 r3 = this.$session;
        r2.getClass();
        if (Intrinsics.areEqual(r7, h2.c.a) == false) goto L15;
        r2.m3(r3, false);
        r2.Z3(r3, true, "finish_success");
    L26:
        return Unit.INSTANCE;
    L15:
        if ((r7 instanceof h2.b) == false) goto L17;
    L21:
        r2.c4(r3, r7);
        String r8 = u1.b(r7);
        if (r8 != null) goto L24;
        r8 = "finish_failed";
    L24:
        r2.Z3(r3, false, r8);
        goto L26
    L17:
        if ((r7 instanceof h2.a) == true) goto L21;
        throw new NoWhenBranchMatchedException();
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        ClarificationResultSubmitter r9 = this.this$0.p;
        f2 r4 = this.$submission;
        this.label = 1;
        r6 = r9.a(r4, this);
        if (r6 != r0) goto L11;
        return r0;
    }
}
