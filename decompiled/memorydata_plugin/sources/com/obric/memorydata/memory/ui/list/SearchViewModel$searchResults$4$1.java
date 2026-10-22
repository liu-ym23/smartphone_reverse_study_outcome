package com.obric.memorydata.memory.ui.list;

import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.ui.list.SearchViewModel$searchResults$4$1", f = "MemorySearchResultCache.kt", i = {0}, l = {337}, m = "invokeSuspend", n = {"startTime"}, s = {"J$0"})
final class SearchViewModel$searchResults$4$1 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
    final /* synthetic */ SearchViewModel.b $request;
    long J$0;
    int label;
    final /* synthetic */ SearchViewModel this$0;

    SearchViewModel$searchResults$4$1(SearchViewModel r3, SearchViewModel.b r4, Continuation<? super SearchViewModel$searchResults$4$1> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        this.$request = r4;
        super(2, r6);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new SearchViewModel$searchResults$4$1(this.this$0, this.$request, r5), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
        return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
        return ((SearchViewModel$searchResults$4$1) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), SearchViewModel$searchResults$4$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        long r2 = this.J$0;
        ResultKt.throwOnFailure(r9);
    L12:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), SearchViewModel.TAG, "Emitting loadingFlow for version=" + this.$request.b() + " at " + r2, false, 4, null);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        long r4 = System.currentTimeMillis();
        kotlinx.coroutines.flow.ad r10 = SearchViewModel.access$get_loadingFlow$p(this.this$0);
        Pair r3 = TuplesKt.to(Boxing.boxLong(this.$request.b()), Boxing.boxLong(r4));
        Continuation<? super Unit> r6 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.J$0 = r4;
        this.label = 1;
        if (r10.emit(r3, r6) != r0) goto L11;
        return r0;
    L11:
        r2 = r4;
        goto L12
    }
}
