package com.obric.memorydata.personalcontext.search.global;

import com.obric.memorydata.database.model.EntitySearchRecordInfo;
import com.obric.memorydata.sdk.entity.global.GlobalAssistantSearchResponse;
import com.obric.memorydata.sdk.entity.search.GlobalQUResult;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.personalcontext.search.global.EntityGlobalSearch$cloudSearchForDoubao$2", f = "EntityGlobalSearch.kt", i = {}, l = {787}, m = "invokeSuspend", n = {}, s = {})
final class EntityGlobalSearch$cloudSearchForDoubao$2 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ GlobalQUResult $assistantQuResult;
    final /* synthetic */ EntitySearchRecordInfo $entitySearchRecordInfo;
    final /* synthetic */ Ref.ObjectRef<GlobalAssistantSearchResponse> $innerResponse;
    final /* synthetic */ String $inputType;
    final /* synthetic */ String $queryId;
    final /* synthetic */ long $startTime;
    Object L$0;
    int label;

    EntityGlobalSearch$cloudSearchForDoubao$2(Ref.ObjectRef<GlobalAssistantSearchResponse> r3, long r4, GlobalQUResult r6, String r7, EntitySearchRecordInfo r8, String r9, Continuation<? super EntityGlobalSearch$cloudSearchForDoubao$2> r10) {
        Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        this.$innerResponse = r3;
        this.$startTime = r4;
        this.$assistantQuResult = r6;
        this.$queryId = r7;
        this.$entitySearchRecordInfo = r8;
        this.$inputType = r9;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new EntityGlobalSearch$cloudSearchForDoubao$2(this.$innerResponse, this.$startTime, this.$assistantQuResult, this.$queryId, this.$entitySearchRecordInfo, this.$inputType, r9), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((EntityGlobalSearch$cloudSearchForDoubao$2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), EntityGlobalSearch$cloudSearchForDoubao$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        Ref.ObjectRef<GlobalAssistantSearchResponse> r13 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(this.L$0, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r14);
        T r15 = r14;
    L12:
        r13.element = r15;
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        Ref.ObjectRef<GlobalAssistantSearchResponse> r16 = this.$innerResponse;
        e r2 = new e(this.$startTime, this.$assistantQuResult.getOrigin_query(), this.$queryId, this.$assistantQuResult, this.$entitySearchRecordInfo, this.$inputType);
        Continuation<? super GlobalAssistantSearchResponse> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r16;
        this.label = 1;
        Object r17 = r2.c(r3);
        if (r17 != r0) goto L11;
        return r0;
    L11:
        r15 = r17;
        r13 = r16;
        goto L12
    }
}
