package com.obric.memorydata.memory.ui.list;

import com.obric.memorydata.memory.memoryentity.search.MemorySearchResultCategory;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "size", "", "state", "Lcom/obric/memorydata/memory/ui/list/SearchResultCache$SearchState;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.ui.list.SearchResultCache$waitForDataAvailable$2", f = "MemorySearchResultCache.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class SearchResultCache$waitForDataAvailable$2 extends SuspendLambda implements Function3<Integer, bh.a, Continuation<? super Boolean>, Object> {
    final /* synthetic */ MemorySearchResultCategory $category;
    final /* synthetic */ int $requiredSize;
    /* synthetic */ int I$0;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ bh this$0;

    SearchResultCache$waitForDataAvailable$2(bh r3, MemorySearchResultCategory r4, int r5, Continuation<? super SearchResultCache$waitForDataAvailable$2> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        this.$category = r4;
        this.$requiredSize = r5;
        super(3, r7);
    }

    public final Object invoke(int r4, bh.a r5, Continuation<? super Boolean> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        SearchResultCache$waitForDataAvailable$2 r0 = new SearchResultCache$waitForDataAvailable$2(this.this$0, this.$category, this.$requiredSize, r7);
        r0.I$0 = r4;
        r0.L$0 = r5;
        return r0.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* synthetic */ Object invoke(Integer r3, bh.a r4, Continuation<? super Boolean> r5) {
        return invoke(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).intValue(), (bh.a) ZeusTransformUtils.preCheckCast(r4, bh.a.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L22;
        ResultKt.throwOnFailure(r4);
        int r5 = this.I$0;
        bh.a r0 = (bh.a) ZeusTransformUtils.preCheckCast(this.L$0, bh.a.class, "com.obric.memorydata.plugin");
        boolean r2 = true;
        if (ZeusTransformUtils.instanceOf(r0, bh.a.b.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r0, bh.a.C0594a.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r0, bh.a.c.class) == false) goto L20;
        if (r5 > 0) goto L14;
    L16:
        r2 = false;
        goto L18
    L14:
        if (this.this$0.b(this.$category) < this.$requiredSize) goto L16;
    L20:
        throw new NoWhenBranchMatchedException();
    L18:
        return Boxing.boxBoolean(r2);
    L22:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
