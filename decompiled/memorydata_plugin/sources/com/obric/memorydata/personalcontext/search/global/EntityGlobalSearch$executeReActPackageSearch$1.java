package com.obric.memorydata.personalcontext.search.global;

import com.obric.memorydata.sdk.entity.global.GlobalAssistantSearchResponse;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantSearchResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.personalcontext.search.global.EntityGlobalSearch$executeReActPackageSearch$1", f = "EntityGlobalSearch.kt", i = {}, l = {349}, m = "invokeSuspend", n = {}, s = {})
final class EntityGlobalSearch$executeReActPackageSearch$1 extends SuspendLambda implements Function2<al, Continuation<? super GlobalAssistantSearchResponse>, Object> {
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

    EntityGlobalSearch$executeReActPackageSearch$1(String r3, List<String> r4, String r5, String r6, boolean r7, GlobalAssistantSearchResponse r8, String r9, String r10, String r11, Continuation<? super EntityGlobalSearch$executeReActPackageSearch$1> r12) {
        List<String> r13 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Continuation r14 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        this.$queryId = r3;
        this.$queryList = r13;
        this.$referenceQuery = r5;
        this.$searchType = r6;
        this.$needContent = r7;
        this.$response = r8;
        this.$businessName = r9;
        this.$meta = r10;
        this.$searchContentDomain = r11;
        super(2, r14);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r13, Continuation<?> r14) {
        Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r14, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new EntityGlobalSearch$executeReActPackageSearch$1(this.$queryId, this.$queryList, this.$referenceQuery, this.$searchType, this.$needContent, this.$response, this.$businessName, this.$meta, this.$searchContentDomain, r11), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super GlobalAssistantSearchResponse> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super GlobalAssistantSearchResponse> r4) {
        return ((EntityGlobalSearch$executeReActPackageSearch$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), EntityGlobalSearch$executeReActPackageSearch$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r20) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r20);
        return r20;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r20);
        h r3 = h.f12333a;
        String r4 = this.$queryId;
        List<String> r5 = this.$queryList;
        String r6 = this.$referenceQuery;
        String r7 = this.$searchType;
        boolean r8 = this.$needContent;
        GlobalAssistantSearchResponse r9 = this.$response;
        String r10 = this.$businessName;
        String r13 = this.$meta;
        String r14 = this.$searchContentDomain;
        Continuation r15 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        Object r0 = h.a(r3, r4, r5, r6, r7, r8, r9, r10, 0, r13, r14, r15, 128, null);
        if (r0 != r1) goto L12;
        return r1;
    L12:
        return r0;
    }
}
