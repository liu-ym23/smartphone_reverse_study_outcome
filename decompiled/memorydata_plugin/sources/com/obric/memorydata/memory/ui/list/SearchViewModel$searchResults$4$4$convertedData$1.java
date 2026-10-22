package com.obric.memorydata.memory.ui.list;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Lcom/obric/memorydata/memory/ui/data/MemoryItem;", "memorySearchResult", "Lcom/obric/memorydata/memory/memoryentity/search/MemorySearchResult;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.ui.list.SearchViewModel$searchResults$4$4$convertedData$1", f = "MemorySearchResultCache.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class SearchViewModel$searchResults$4$4$convertedData$1 extends SuspendLambda implements Function2<com.obric.memorydata.memory.memoryentity.search.c, Continuation<? super Iterable<? extends com.obric.memorydata.memory.ui.data.a>>, Object> {
    final /* synthetic */ SearchViewModel.b $request;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SearchViewModel this$0;

    SearchViewModel$searchResults$4$4$convertedData$1(SearchViewModel r3, SearchViewModel.b r4, Continuation<? super SearchViewModel$searchResults$4$4$convertedData$1> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        this.$request = r4;
        super(2, r6);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        SearchViewModel$searchResults$4$4$convertedData$1 r0 = new SearchViewModel$searchResults$4$4$convertedData$1(this.this$0, this.$request, r6);
        r0.L$0 = r4;
        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(com.obric.memorydata.memory.memoryentity.search.c r3, Continuation<? super Iterable<? extends com.obric.memorydata.memory.ui.data.a>> r4) {
        return ((SearchViewModel$searchResults$4$4$convertedData$1) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), SearchViewModel$searchResults$4$4$convertedData$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(com.obric.memorydata.memory.memoryentity.search.c r3, Continuation<? super Iterable<? extends com.obric.memorydata.memory.ui.data.a>> r4) {
        return invoke2((com.obric.memorydata.memory.memoryentity.search.c) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.memory.memoryentity.search.c.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L13;
        ResultKt.throwOnFailure(r3);
        com.obric.memorydata.memory.memoryentity.search.c r4 = (com.obric.memorydata.memory.memoryentity.search.c) ZeusTransformUtils.preCheckCast(this.L$0, com.obric.memorydata.memory.memoryentity.search.c.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.memory.ui.data.a r2 = SearchViewModel.access$convertToMemoryItem(this.this$0, r4, this.$request.a());
        if (r2 == null) goto L9;
        List r5 = CollectionsKt.listOf(r2);
        if (r5 == null) goto L9;
    L11:
        return (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin");
    L9:
        r5 = CollectionsKt.emptyList();
        goto L11
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
