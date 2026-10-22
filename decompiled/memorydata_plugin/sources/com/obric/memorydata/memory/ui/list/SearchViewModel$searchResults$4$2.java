package com.obric.memorydata.memory.ui.list;

import androidx.paging.PagingData;
import androidx.paging.PagingDataTransforms;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\n"}, d2 = {"<anonymous>", "Landroidx/paging/PagingData;", "Lcom/obric/memorydata/memory/memoryentity/search/MemorySearchResult;", "pagingData", "deletedIds", "", "Lcom/obric/memorydata/memory/ui/list/EntityIdentifier;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.ui.list.SearchViewModel$searchResults$4$2", f = "MemorySearchResultCache.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class SearchViewModel$searchResults$4$2 extends SuspendLambda implements Function3<PagingData<com.obric.memorydata.memory.memoryentity.search.c>, Set<? extends g>, Continuation<? super PagingData<com.obric.memorydata.memory.memoryentity.search.c>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.SearchViewModel$searchResults$4$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "memorySearchResult", "Lcom/obric/memorydata/memory/memoryentity/search/MemorySearchResult;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.SearchViewModel$searchResults$4$2$1", f = "MemorySearchResultCache.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<com.obric.memorydata.memory.memoryentity.search.c, Continuation<? super Boolean>, Object> {
        final /* synthetic */ Set<g> $deletedIds;
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(Set<g> r3, Continuation<? super AnonymousClass1> r4) {
            Set<g> r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.$deletedIds = r5;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            AnonymousClass1 r0 = new AnonymousClass1(this.$deletedIds, r5);
            r0.L$0 = r3;
            return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(com.obric.memorydata.memory.memoryentity.search.c r3, Continuation<? super Boolean> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(com.obric.memorydata.memory.memoryentity.search.c r3, Continuation<? super Boolean> r4) {
            return invoke2((com.obric.memorydata.memory.memoryentity.search.c) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.memory.memoryentity.search.c.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L14;
            ResultKt.throwOnFailure(r3);
            com.obric.memorydata.memory.memoryentity.search.c r4 = (com.obric.memorydata.memory.memoryentity.search.c) ZeusTransformUtils.preCheckCast(this.L$0, com.obric.memorydata.memory.memoryentity.search.c.class, "com.obric.memorydata.plugin");
            g r5 = g.f11310a.a(r4.a());
            if (r5 != null) goto L7;
        L10:
            boolean r2 = true;
        L12:
            return Boxing.boxBoolean(r2);
        L7:
            if (this.$deletedIds.contains(r5) == false) goto L10;
            r2 = false;
            goto L12
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    SearchViewModel$searchResults$4$2(Continuation<? super SearchViewModel$searchResults$4$2> r3) {
        super(3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(PagingData<com.obric.memorydata.memory.memoryentity.search.c> r2, Set<g> r3, Continuation<? super PagingData<com.obric.memorydata.memory.memoryentity.search.c>> r4) {
        Set r1 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
        SearchViewModel$searchResults$4$2 r5 = new SearchViewModel$searchResults$4$2((Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
        r5.L$0 = r2;
        r5.L$1 = r1;
        return r5.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* synthetic */ Object invoke(PagingData<com.obric.memorydata.memory.memoryentity.search.c> r3, Set<? extends g> r4, Continuation<? super PagingData<com.obric.memorydata.memory.memoryentity.search.c>> r5) {
        return invoke2((PagingData) ZeusTransformUtils.preCheckCast(r3, PagingData.class, "com.obric.memorydata.plugin"), (Set) ZeusTransformUtils.preCheckCast(r4, Set.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r4);
        return PagingDataTransforms.filter((PagingData) ZeusTransformUtils.preCheckCast(this.L$0, PagingData.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1((Set) ZeusTransformUtils.preCheckCast(this.L$1, Set.class, "com.obric.memorydata.plugin"), null), Function2.class, "com.obric.memorydata.plugin"));
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
