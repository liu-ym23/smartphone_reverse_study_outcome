package com.obric.memorydata.personalcontext.search;

import com.obric.memorydata.database.model.EntitySearchRecordInfo;
import com.obric.memorydata.sdk.entity.search.SearchResponse;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
@DebugMetadata(c = "com.obric.memorydata.personalcontext.search.EntityAssistantSearch$cloudSearch$1", f = "EntityAssistantSearch.kt", i = {}, l = {53}, m = "invokeSuspend", n = {}, s = {})
final class EntityAssistantSearch$cloudSearch$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ EntitySearchRecordInfo $entitySearchRecordInfo;
    final /* synthetic */ String $inputType;
    final /* synthetic */ boolean $isAppFunc;
    final /* synthetic */ String $quResult;
    final /* synthetic */ String $queryId;
    final /* synthetic */ SearchResponse $response;
    final /* synthetic */ long $startTime;
    int label;

    EntityAssistantSearch$cloudSearch$1(String r3, SearchResponse r4, String r5, EntitySearchRecordInfo r6, long r7, String r9, boolean r10, Continuation<? super EntityAssistantSearch$cloudSearch$1> r11) {
        Continuation r12 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        this.$quResult = r3;
        this.$response = r4;
        this.$queryId = r5;
        this.$entitySearchRecordInfo = r6;
        this.$startTime = r7;
        this.$inputType = r9;
        this.$isAppFunc = r10;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r12, Continuation<?> r13) {
        Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new EntityAssistantSearch$cloudSearch$1(this.$quResult, this.$response, this.$queryId, this.$entitySearchRecordInfo, this.$startTime, this.$inputType, this.$isAppFunc, r10), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((EntityAssistantSearch$cloudSearch$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), EntityAssistantSearch$cloudSearch$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r14);
    L16:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        b r2 = b.f12278a;
        String r3 = this.$quResult;
        if (r3 != null) goto L11;
        String r15 = "";
    L12:
        SearchResponse r4 = this.$response;
        String r5 = this.$queryId;
        EntitySearchRecordInfo r6 = this.$entitySearchRecordInfo;
        long r7 = this.$startTime;
        String r9 = this.$inputType;
        boolean r10 = this.$isAppFunc;
        Continuation r11 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        if (b.a(r2, r15, r3, r4, r5, r6, r7, r9, r10, r11) != r0) goto L16;
        return r0;
    L11:
        r15 = r3;
        goto L12
    }
}
