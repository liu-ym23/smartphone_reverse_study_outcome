package com.larus.suggest.impl.wcb.render;

import com.larus.im.bean.message.MessageTag;
import com.tencent.open.log.TraceLevel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import yc9.f0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/suggest/impl/wcb/render/WcbRenderSubmission;", "ext", "", ""}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.suggest.impl.wcb.render.ImSdkWcbRenderer$renderPlan$2", f = "ImSdkWcbRenderer.kt", i = {}, l = {70}, m = "invokeSuspend", n = {}, s = {})
final class ImSdkWcbRenderer$renderPlan$2 extends SuspendLambda implements Function2<Map<String, ? extends String>, Continuation<? super n>, Object> {
    final /* synthetic */ l $plan;
    final /* synthetic */ com.larus.suggest.impl.wcb.request.f $snapshot;
    final /* synthetic */ jx9.a $traceData;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ImSdkWcbRenderer this$0;

    public ImSdkWcbRenderer$renderPlan$2(ImSdkWcbRenderer r1, com.larus.suggest.impl.wcb.request.f r2, l r3, jx9.a r4, Continuation<? super ImSdkWcbRenderer$renderPlan$2> r5) {
        this.this$0 = r1;
        this.$snapshot = r2;
        this.$plan = r3;
        this.$traceData = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        ImSdkWcbRenderer$renderPlan$2 r6 = new ImSdkWcbRenderer$renderPlan$2(this.this$0, this.$snapshot, this.$plan, this.$traceData, r9);
        r6.L$0 = r8;
        return r6;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((Map) r1, (Continuation) r2);
    }

    public final Object invoke(Map<String, String> r1, Continuation<? super n> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r31) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r31);
        return r31;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r31);
        Map r17 = (Map) this.L$0;
        ImSdkWcbRenderer r3 = this.this$0;
        final com.larus.suggest.impl.wcb.request.f r15 = this.$snapshot;
        final String r14 = ((l.a) this.$plan).b;
        jx9.a r13 = this.$traceData;
        this.label = 1;
        int r4 = ImSdkWcbRenderer.c;
        r3.getClass();
        final f0 r5 = new f0(r15.b, null, r15.c, 2, 1, null, r14, null, 21, null, false, null, r17, null, null, CollectionsKt.listOf(Boxing.boxInt(MessageTag.MessageTag_Onboarding_WELCOMEBACK.value)), null, null, null, null, null, 535689954);
        Object r6 = r3.e("addLocalMessage", r13, new b(r15, r14, r5), this);
        if (r6 != r1) goto L12;
        return r1;
    L12:
        return r6;
    }
}
