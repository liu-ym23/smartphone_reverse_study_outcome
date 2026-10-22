package com.obric.memorydata.personalcontext;

import com.obric.capabilitykit.entity.search.global.IGlobalSearchCallback;
import com.obric.memorydata.database.model.EntitySearchRecordInfo;
import com.obric.memorydata.personalcontext.search.entity.SearchRequest;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.personalcontext.GlobalSearchService$binder$1$startGlobalSearch$1", f = "GlobalSearchService.kt", i = {}, l = {92}, m = "invokeSuspend", n = {}, s = {})
final class GlobalSearchService$binder$1$startGlobalSearch$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $callPkg;
    final /* synthetic */ IGlobalSearchCallback $callback;
    final /* synthetic */ String $caller;
    final /* synthetic */ SearchRequest $searchRequest;
    final /* synthetic */ String $sessionId;
    final /* synthetic */ List<String> $taskIds;
    int label;
    final /* synthetic */ GlobalSearchService.b this$0;

    GlobalSearchService$binder$1$startGlobalSearch$1(SearchRequest r3, List<String> r4, String r5, GlobalSearchService.b r6, String r7, String r8, IGlobalSearchCallback r9, Continuation<? super GlobalSearchService$binder$1$startGlobalSearch$1> r10) {
        List<String> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        IGlobalSearchCallback r12 = (IGlobalSearchCallback) ZeusTransformUtils.wrapperContextForParams(r9, IGlobalSearchCallback.class, "com.obric.memorydata.plugin");
        Continuation r13 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        this.$searchRequest = r3;
        this.$taskIds = r11;
        this.$callPkg = r5;
        this.this$0 = r6;
        this.$caller = r7;
        this.$sessionId = r8;
        this.$callback = r12;
        super(2, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new GlobalSearchService$binder$1$startGlobalSearch$1(this.$searchRequest, this.$taskIds, this.$callPkg, this.this$0, this.$caller, this.$sessionId, this.$callback, r9), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((GlobalSearchService$binder$1$startGlobalSearch$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), GlobalSearchService$binder$1$startGlobalSearch$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r75) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r75);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r75);
        final AtomicInteger r10 = new AtomicInteger(0);
        com.obric.memorydata.personalcontext.search.g r3 = com.obric.memorydata.personalcontext.search.g.INSTANCE;
        SearchRequest r11 = this.$searchRequest;
        List<String> r12 = this.$taskIds;
        final GlobalSearchService.b r5 = this.this$0;
        final String r6 = this.$caller;
        final String r7 = this.$sessionId;
        final IGlobalSearchCallback r8 = this.$callback;
        final SearchRequest r9 = this.$searchRequest;
        com.obric.capabilitykit.search.global.IGlobalSearchCallback r13 = (com.obric.capabilitykit.search.global.IGlobalSearchCallback) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r5, r6, r7, r8, r9, r10), com.obric.capabilitykit.search.global.IGlobalSearchCallback.class, "com.obric.memorydata.plugin");
        EntitySearchRecordInfo r14 = new EntitySearchRecordInfo(null, this.$callPkg, null, 0, null, 0, 0, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, false, null, -3, null);
        Continuation<? super Unit> r15 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        if (r3.sendGlobalSearchRequest(r11, r12, r13, r14, r15) != r1) goto L12;
        return r1;
    }
}
