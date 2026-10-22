package com.obric.memorydata.memory.ui.list;

import com.obric.capabilitykit.common.Ext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/obric/memorydata/memory/ui/list/SearchViewModel$SearchRequest;", Ext.KEY_REQUEST, "<unused var>", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.ui.list.SearchViewModel$searchResults$3", f = "MemorySearchResultCache.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class SearchViewModel$searchResults$3 extends SuspendLambda implements Function3<SearchViewModel.b, Unit, Continuation<? super SearchViewModel.b>, Object> {
    /* synthetic */ Object L$0;
    int label;

    SearchViewModel$searchResults$3(Continuation<? super SearchViewModel$searchResults$3> r3) {
        super(3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(SearchViewModel.b r1, Unit r2, Continuation<? super SearchViewModel.b> r3) {
        SearchViewModel$searchResults$3 r4 = new SearchViewModel$searchResults$3((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
        r4.L$0 = r1;
        return r4.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* synthetic */ Object invoke(SearchViewModel.b r3, Unit r4, Continuation<? super SearchViewModel.b> r5) {
        return invoke2((SearchViewModel.b) ZeusTransformUtils.preCheckCast(r3, SearchViewModel.b.class, "com.obric.memorydata.plugin"), (Unit) ZeusTransformUtils.preCheckCast(r4, Unit.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r2);
        return (SearchViewModel.b) ZeusTransformUtils.preCheckCast(this.L$0, SearchViewModel.b.class, "com.obric.memorydata.plugin");
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
