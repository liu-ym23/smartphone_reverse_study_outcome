package com.obric.aikernel.res.update;

import com.obric.aikernel.res.metadata.config.UpdateTaskConfig;
import java.util.List;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.res.update.MetadataRequest$requestOutcome$2$1", f = "MetadataRequest.kt", i = {}, l = {56}, m = "invokeSuspend", n = {}, s = {})
final class MetadataRequest$requestOutcome$2$1 extends SuspendLambda implements Function2<Integer, Continuation<? super List<? extends UpdateTaskConfig>>, Object> {
    final /* synthetic */ b8.a $adapter;
    final /* synthetic */ Map<String, MetadataRequest.b> $bizMap;
    final /* synthetic */ MetadataRequest $this_runCatching;
    final /* synthetic */ boolean $updateAll;
    /* synthetic */ int I$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    MetadataRequest$requestOutcome$2$1(MetadataRequest r10, boolean r11, Map<String, ? extends MetadataRequest.b> r12, b8.a r13, Continuation<? super MetadataRequest$requestOutcome$2$1> r14) {
        this.$this_runCatching = r10;
        this.$updateAll = r11;
        this.$bizMap = r12;
        this.$adapter = r13;
        super(2, r14);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        MetadataRequest$requestOutcome$2$1 r12 = new MetadataRequest$requestOutcome$2$1(this.$this_runCatching, this.$updateAll, this.$bizMap, this.$adapter, r11);
        r12.I$0 = ((Number) r10).intValue();
        return r12;
    }

    public final Object invoke(int r10, Continuation<? super List<? extends UpdateTaskConfig>> r11) {
        return ((MetadataRequest$requestOutcome$2$1) create(Integer.valueOf(r10), r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Integer r10, Continuation<? super List<? extends UpdateTaskConfig>> r11) {
        return invoke(r10.intValue(), r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L11:
        return r10;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        int r13 = this.I$0;
        com.obric.aikernel.runtime.utils.c.a.a(com.obric.aikernel.runtime.utils.d.f5417a, "MetadataRequest", "request attempt=" + r13, 0, 4, null);
        MetadataRequest r14 = this.$this_runCatching;
        boolean r15 = this.$updateAll;
        Map<String, MetadataRequest.b> r16 = this.$bizMap;
        b8.a r17 = this.$adapter;
        this.label = 1;
        r10 = MetadataRequest.g(r14, r15, r16, r17, this);
        if (r10 != r11) goto L11;
        return r11;
    }
}
