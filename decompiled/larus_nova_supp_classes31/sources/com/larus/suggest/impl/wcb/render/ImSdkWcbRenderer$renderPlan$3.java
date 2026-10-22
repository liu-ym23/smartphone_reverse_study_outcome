package com.larus.suggest.impl.wcb.render;

import com.tencent.open.log.TraceLevel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/suggest/impl/wcb/render/WcbRenderSubmission;", "ext", "", ""}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.suggest.impl.wcb.render.ImSdkWcbRenderer$renderPlan$3", f = "ImSdkWcbRenderer.kt", i = {}, l = {73}, m = "invokeSuspend", n = {}, s = {})
final class ImSdkWcbRenderer$renderPlan$3 extends SuspendLambda implements Function2<Map<String, ? extends String>, Continuation<? super n>, Object> {
    final /* synthetic */ l $plan;
    final /* synthetic */ jx9.a $traceData;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ImSdkWcbRenderer this$0;

    public ImSdkWcbRenderer$renderPlan$3(ImSdkWcbRenderer r1, l r2, jx9.a r3, Continuation<? super ImSdkWcbRenderer$renderPlan$3> r4) {
        this.this$0 = r1;
        this.$plan = r2;
        this.$traceData = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        ImSdkWcbRenderer$renderPlan$3 r0 = new ImSdkWcbRenderer$renderPlan$3(this.this$0, this.$plan, this.$traceData, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((Map) r1, (Continuation) r2);
    }

    public final Object invoke(Map<String, String> r1, Continuation<? super n> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L11:
        return r6;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        Map r7 = (Map) this.L$0;
        ImSdkWcbRenderer r2 = this.this$0;
        p r3 = ((l.c) this.$plan).a;
        jx9.a r4 = this.$traceData;
        this.label = 1;
        r6 = ImSdkWcbRenderer.c(r2, r3, r7, r4, this);
        if (r6 != r0) goto L11;
        return r0;
    }
}
