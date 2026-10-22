package com.obric.memorydata.memory.ui.list;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.paging.CachedPagingDataKt;
import com.obric.memorydata.memory.memoryentity.search.MemorySearchResultCategory;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0005\u001a\u0002H\u0002H\u008a@¨\u0006\u0006"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it", "kotlinx/coroutines/flow/FlowKt__MergeKt$flatMapLatest$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.ui.list.SearchViewModel$special$$inlined$flatMapLatest$1", f = "MemorySearchResultCache.kt", i = {}, l = {189}, m = "invokeSuspend", n = {}, s = {})
public final class SearchViewModel$special$$inlined$flatMapLatest$1 extends SuspendLambda implements Function3<kotlinx.coroutines.flow.j<? super bj>, SearchViewModel.b, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ SearchViewModel this$0;

    public SearchViewModel$special$$inlined$flatMapLatest$1(Continuation r3, SearchViewModel r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r4;
        super(3, r5);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* synthetic */ Object invoke(kotlinx.coroutines.flow.j<? super bj> r3, SearchViewModel.b r4, Continuation<? super Unit> r5) {
        return invoke((kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin"), r4, (Continuation) ZeusTransformUtils.preCheckCast(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public final Object invoke(kotlinx.coroutines.flow.j<? super bj> r3, SearchViewModel.b r4, Continuation<? super Unit> r5) {
        kotlinx.coroutines.flow.j r6 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
        SearchViewModel$special$$inlined$flatMapLatest$1 r0 = new SearchViewModel$special$$inlined$flatMapLatest$1((Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin"), this.this$0);
        r0.L$0 = r6;
        r0.L$1 = r4;
        return r0.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r13);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        kotlinx.coroutines.flow.j r14 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(this.L$0, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
        Object r2 = this.L$1;
        Continuation r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        SearchViewModel.b r3 = (SearchViewModel.b) ZeusTransformUtils.preCheckCast(r2, SearchViewModel.b.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.i.a(ViewModelKt.getViewModelScope((ViewModel) ZeusTransformUtils.preCheckCast(this.this$0, ViewModel.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new SearchViewModel$searchResults$4$1(this.this$0, r3, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        SearchViewModel.access$get_deletedIdentifiers$p(this.this$0).b(SetsKt.emptySet());
        SearchViewModel.access$get_selectedCategory$p(this.this$0).b(MemorySearchResultCategory.ALL);
        SearchViewModel.access$get_availableCategories$p(this.this$0).b(CollectionsKt.emptyList());
        kotlinx.coroutines.flow.i r5 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(new SearchViewModel.c(kotlinx.coroutines.flow.k.a(kotlinx.coroutines.flow.k.a(CachedPagingDataKt.cachedIn(SearchViewModel.access$searchInternal(this.this$0, r3.a()), ViewModelKt.getViewModelScope((ViewModel) ZeusTransformUtils.preCheckCast(this.this$0, ViewModel.class, "com.obric.memorydata.plugin"))), (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(SearchViewModel.access$get_deletedIdentifiers$p(this.this$0), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), (Function3) ZeusTransformUtils.preCheckCast(new SearchViewModel$searchResults$4$2(null), Function3.class, "com.obric.memorydata.plugin")), (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(SearchViewModel.access$get_selectedCategory$p(this.this$0), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), (Function3) ZeusTransformUtils.preCheckCast(new SearchViewModel$searchResults$4$3(null), Function3.class, "com.obric.memorydata.plugin")), r3, this.this$0), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
        Continuation r6 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        if (kotlinx.coroutines.flow.k.a(r14, r5, r6) != r0) goto L12;
        return r0;
    }
}
