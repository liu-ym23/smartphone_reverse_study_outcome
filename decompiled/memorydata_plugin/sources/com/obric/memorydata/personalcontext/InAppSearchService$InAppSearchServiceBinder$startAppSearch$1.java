package com.obric.memorydata.personalcontext;

import com.obric.capabilitykit.entity.search.IInAppSearchCallback;
import com.obric.capabilitykit.entity.search.InAppSearchRequest;
import com.obric.capabilitykit.search.IAppSearchCallback;
import com.obric.memorydata.database.model.EntitySearchRecordInfo;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.search.entity.CallMode;
import com.obric.memorydata.personalcontext.search.entity.SearchRequest;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.personalcontext.InAppSearchService$InAppSearchServiceBinder$startAppSearch$1", f = "InAppSearchService.kt", i = {}, l = {138}, m = "invokeSuspend", n = {}, s = {})
final class InAppSearchService$InAppSearchServiceBinder$startAppSearch$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $businessName;
    final /* synthetic */ String $callPkg;
    final /* synthetic */ IInAppSearchCallback $callback;
    final /* synthetic */ String $caller;
    final /* synthetic */ boolean $isPaginationMode;
    final /* synthetic */ InAppSearchRequest $request;
    final /* synthetic */ SearchRequest $searchRequest;
    final /* synthetic */ String $sessionId;
    final /* synthetic */ CopyOnWriteArrayList<String> $taskIds;
    int label;
    final /* synthetic */ InAppSearchService.b this$0;

    InAppSearchService$InAppSearchServiceBinder$startAppSearch$1(InAppSearchService.b r3, String r4, String r5, String r6, SearchRequest r7, CopyOnWriteArrayList<String> r8, String r9, boolean r10, IInAppSearchCallback r11, InAppSearchRequest r12, Continuation<? super InAppSearchService$InAppSearchServiceBinder$startAppSearch$1> r13) {
        IInAppSearchCallback r14 = (IInAppSearchCallback) ZeusTransformUtils.wrapperContextForParams(r11, IInAppSearchCallback.class, "com.obric.memorydata.plugin");
        Continuation r15 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        this.$caller = r4;
        this.$sessionId = r5;
        this.$callPkg = r6;
        this.$searchRequest = r7;
        this.$taskIds = r8;
        this.$businessName = r9;
        this.$isPaginationMode = r10;
        this.$callback = r14;
        this.$request = r12;
        super(2, r15);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r14, Continuation<?> r15) {
        Continuation r12 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r15, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new InAppSearchService$InAppSearchServiceBinder$startAppSearch$1(this.this$0, this.$caller, this.$sessionId, this.$callPkg, this.$searchRequest, this.$taskIds, this.$businessName, this.$isPaginationMode, this.$callback, this.$request, r12), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((InAppSearchService$InAppSearchServiceBinder$startAppSearch$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), InAppSearchService$InAppSearchServiceBinder$startAppSearch$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r74) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r74);
    L16:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r74);
        if (Intrinsics.areEqual(InAppSearchService.b.a(this.this$0).get(this.$caller), this.$sessionId) == true) goto L12;
        RunLog.INSTANCE.debug("InAppSearchService", "session " + this.$sessionId + " cancelled");
        return Unit.INSTANCE;
    L12:
        com.obric.memorydata.personalcontext.search.g r3 = com.obric.memorydata.personalcontext.search.g.INSTANCE;
        final InAppSearchService.b r5 = this.this$0;
        final String r6 = this.$caller;
        final String r7 = this.$sessionId;
        final boolean r8 = this.$isPaginationMode;
        final IInAppSearchCallback r9 = this.$callback;
        final InAppSearchRequest r10 = this.$request;
        IAppSearchCallback r11 = new AnonymousClass1(r5, r6, r7, r8, r9, r10);
        EntitySearchRecordInfo r12 = new EntitySearchRecordInfo(null, this.$callPkg, null, 0, null, 0, 0, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, false, null, -3, null);
        CallMode r13 = CallMode.IN_APP;
        final InAppSearchService.b r14 = this.this$0;
        final String r15 = this.$caller;
        final String r16 = this.$sessionId;
        com.obric.memorydata.personalcontext.search.h r4 = new AnonymousClass2(r14, r15, r16);
        SearchRequest r17 = this.$searchRequest;
        CopyOnWriteArrayList<String> r18 = this.$taskIds;
        IAppSearchCallback r19 = (IAppSearchCallback) ZeusTransformUtils.preCheckCast(r11, IAppSearchCallback.class, "com.obric.memorydata.plugin");
        String r110 = this.$businessName;
        com.obric.memorydata.personalcontext.search.h r111 = (com.obric.memorydata.personalcontext.search.h) ZeusTransformUtils.preCheckCast(r4, com.obric.memorydata.personalcontext.search.h.class, "com.obric.memorydata.plugin");
        Continuation<? super Unit> r112 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        if (r3.sendInAppSearchRequest(r17, r18, r19, r12, r13, r110, r111, r112) != r1) goto L16;
        return r1;
    }
}
