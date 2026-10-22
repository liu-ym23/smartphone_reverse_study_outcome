package com.larus.suggest.impl.wcb.request;

import com.larus.suggest.impl.wcb.render.p;
import com.larus.suggest.impl.wcb.render.q;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "emission", "Lcom/larus/suggest/impl/wcb/request/WcbTransportEmission;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.suggest.impl.wcb.request.WcbRequestPipeline$executeDecision$2", f = "WcbRequestPipeline.kt", i = {}, l = {86}, m = "invokeSuspend", n = {}, s = {})
public final class WcbRequestPipeline$executeDecision$2 extends SuspendLambda implements Function2<g, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<p> $renderedTarget;
    final /* synthetic */ f $snapshot;
    final /* synthetic */ jx9.a $traceData;
    final /* synthetic */ q $transaction;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ WcbRequestPipeline this$0;

    public WcbRequestPipeline$executeDecision$2(Ref.ObjectRef<p> r1, WcbRequestPipeline r2, f r3, jx9.a r4, q r5, Continuation<? super WcbRequestPipeline$executeDecision$2> r6) {
        this.$renderedTarget = r1;
        this.this$0 = r2;
        this.$snapshot = r3;
        this.$traceData = r4;
        this.$transaction = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        WcbRequestPipeline$executeDecision$2 r7 = new WcbRequestPipeline$executeDecision$2(this.$renderedTarget, this.this$0, this.$snapshot, this.$traceData, this.$transaction, r10);
        r7.L$0 = r9;
        return r7;
    }

    public final Object invoke(g r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((g) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r12);
    L15:
        p r13 = (p) r12;
        if (r13 == null) goto L19;
        this.$renderedTarget.element = r13;
    L19:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        g r6 = (g) this.L$0;
        if (r6.c == false) goto L11;
        p r14 = (p) this.$renderedTarget.element;
    L12:
        p r8 = r14;
        WcbRequestPipeline r15 = this.this$0;
        WcbResponseConsumer r3 = r15.f;
        f r4 = this.$snapshot;
        jx9.a r5 = this.$traceData;
        q r7 = this.$transaction;
        d r9 = new d(r15, r4, r7);
        this.label = 1;
        r12 = r3.c(r4, r5, r6, r7, r8, r9, this);
        if (r12 != r0) goto L15;
        return r0;
    L11:
        r14 = null;
        goto L12
    }
}
