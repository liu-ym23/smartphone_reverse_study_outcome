package com.obric.memorydata.personalcontext.search.global;

import com.obric.memorydata.sdk.entity.global.GlobalAssistantSearchResponse;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.al;
import kotlinx.coroutines.ba;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantSearchResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.personalcontext.search.global.ReactAgentConcurrentExecutor$executeReActPackageSearchWithConcurrency$result$1", f = "ReactAgentConcurrentExecutor.kt", i = {}, l = {81}, m = "invokeSuspend", n = {}, s = {})
final class ReactAgentConcurrentExecutor$executeReActPackageSearchWithConcurrency$result$1 extends SuspendLambda implements Function2<al, Continuation<? super GlobalAssistantSearchResponse>, Object> {
    final /* synthetic */ Ref.ObjectRef<String> $agentPackage;
    final /* synthetic */ String $businessName;
    final /* synthetic */ String $meta;
    final /* synthetic */ boolean $needContent;
    final /* synthetic */ String $queryId;
    final /* synthetic */ List<String> $queryList;
    final /* synthetic */ String $referenceQuery;
    final /* synthetic */ GlobalAssistantSearchResponse $response;
    final /* synthetic */ String $searchContentDomain;
    final /* synthetic */ String $searchType;
    int label;

    /* JADX INFO: renamed from: com.obric.memorydata.personalcontext.search.global.ReactAgentConcurrentExecutor$executeReActPackageSearchWithConcurrency$result$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantSearchResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.personalcontext.search.global.ReactAgentConcurrentExecutor$executeReActPackageSearchWithConcurrency$result$1$1", f = "ReactAgentConcurrentExecutor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super GlobalAssistantSearchResponse>, Object> {
        final /* synthetic */ Ref.ObjectRef<String> $agentPackage;
        final /* synthetic */ String $businessName;
        final /* synthetic */ String $meta;
        final /* synthetic */ boolean $needContent;
        final /* synthetic */ String $queryId;
        final /* synthetic */ List<String> $queryList;
        final /* synthetic */ String $referenceQuery;
        final /* synthetic */ GlobalAssistantSearchResponse $response;
        final /* synthetic */ String $searchContentDomain;
        final /* synthetic */ String $searchType;
        int label;

        AnonymousClass1(String r3, List<String> r4, String r5, String r6, boolean r7, GlobalAssistantSearchResponse r8, String r9, Ref.ObjectRef<String> r10, String r11, String r12, Continuation<? super AnonymousClass1> r13) {
            List<String> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            Continuation r15 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin");
            this.$queryId = r3;
            this.$queryList = r14;
            this.$referenceQuery = r5;
            this.$searchType = r6;
            this.$needContent = r7;
            this.$response = r8;
            this.$businessName = r9;
            this.$agentPackage = r10;
            this.$meta = r11;
            this.$searchContentDomain = r12;
            super(2, r15);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r14, Continuation<?> r15) {
            Continuation r12 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r15, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.$queryId, this.$queryList, this.$referenceQuery, this.$searchType, this.$needContent, this.$response, this.$businessName, this.$agentPackage, this.$meta, this.$searchContentDomain, r12), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super GlobalAssistantSearchResponse> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super GlobalAssistantSearchResponse> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r13) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r13);
            return f.f12331a.b(this.$queryId, this.$queryList, this.$referenceQuery, this.$searchType, this.$needContent, this.$response, this.$businessName, (String) ZeusTransformUtils.preCheckCast(this.$agentPackage.element, String.class, "com.obric.memorydata.plugin"), this.$meta, this.$searchContentDomain);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    ReactAgentConcurrentExecutor$executeReActPackageSearchWithConcurrency$result$1(String r3, List<String> r4, String r5, String r6, boolean r7, GlobalAssistantSearchResponse r8, String r9, Ref.ObjectRef<String> r10, String r11, String r12, Continuation<? super ReactAgentConcurrentExecutor$executeReActPackageSearchWithConcurrency$result$1> r13) {
        List<String> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Continuation r15 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin");
        this.$queryId = r3;
        this.$queryList = r14;
        this.$referenceQuery = r5;
        this.$searchType = r6;
        this.$needContent = r7;
        this.$response = r8;
        this.$businessName = r9;
        this.$agentPackage = r10;
        this.$meta = r11;
        this.$searchContentDomain = r12;
        super(2, r15);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r14, Continuation<?> r15) {
        Continuation r12 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r15, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new ReactAgentConcurrentExecutor$executeReActPackageSearchWithConcurrency$result$1(this.$queryId, this.$queryList, this.$referenceQuery, this.$searchType, this.$needContent, this.$response, this.$businessName, this.$agentPackage, this.$meta, this.$searchContentDomain, r12), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super GlobalAssistantSearchResponse> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super GlobalAssistantSearchResponse> r4) {
        return ((ReactAgentConcurrentExecutor$executeReActPackageSearchWithConcurrency$result$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), ReactAgentConcurrentExecutor$executeReActPackageSearchWithConcurrency$result$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r19) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r19);
        return r19;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r19);
        CoroutineContext r3 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin");
        Function2 r4 = (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.$queryId, this.$queryList, this.$referenceQuery, this.$searchType, this.$needContent, this.$response, this.$businessName, this.$agentPackage, this.$meta, this.$searchContentDomain, null), Function2.class, "com.obric.memorydata.plugin");
        Continuation r5 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        Object r0 = kotlinx.coroutines.i.a(r3, r4, r5);
        if (r0 != r1) goto L12;
        return r1;
    L12:
        return r0;
    }
}
