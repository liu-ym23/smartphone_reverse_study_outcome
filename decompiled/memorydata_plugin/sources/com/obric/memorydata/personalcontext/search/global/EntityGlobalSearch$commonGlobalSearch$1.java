package com.obric.memorydata.personalcontext.search.global;

import com.obric.memorydata.database.model.EntitySearchRecordInfo;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.sdk.entity.global.GlobalAssistantSearchResponse;
import com.obric.memorydata.utils.u;
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
@DebugMetadata(c = "com.obric.memorydata.personalcontext.search.global.EntityGlobalSearch$commonGlobalSearch$1", f = "EntityGlobalSearch.kt", i = {}, l = {667}, m = "invokeSuspend", n = {}, s = {})
final class EntityGlobalSearch$commonGlobalSearch$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ EntitySearchRecordInfo $entitySearchRecordInfo;
    final /* synthetic */ String $inputType;
    final /* synthetic */ String $memoryScene;
    final /* synthetic */ boolean $obtainDetailedResults;
    final /* synthetic */ String $originQuery;
    final /* synthetic */ String $queryId;
    final /* synthetic */ GlobalAssistantSearchResponse $response;
    final /* synthetic */ String $searchParams;
    final /* synthetic */ long $startTime;
    final /* synthetic */ String $taskName;
    int label;

    EntityGlobalSearch$commonGlobalSearch$1(String r3, long r4, String r6, String r7, String r8, String r9, String r10, EntitySearchRecordInfo r11, boolean r12, GlobalAssistantSearchResponse r13, Continuation<? super EntityGlobalSearch$commonGlobalSearch$1> r14) {
        Continuation r15 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r14, Continuation.class, "com.obric.memorydata.plugin");
        this.$originQuery = r3;
        this.$startTime = r4;
        this.$queryId = r6;
        this.$searchParams = r7;
        this.$inputType = r8;
        this.$memoryScene = r9;
        this.$taskName = r10;
        this.$entitySearchRecordInfo = r11;
        this.$obtainDetailedResults = r12;
        this.$response = r13;
        super(2, r15);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r17, Continuation<?> r18) {
        Continuation r15 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r18, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new EntityGlobalSearch$commonGlobalSearch$1(this.$originQuery, this.$startTime, this.$queryId, this.$searchParams, this.$inputType, this.$memoryScene, this.$taskName, this.$entitySearchRecordInfo, this.$obtainDetailedResults, this.$response, r15), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((EntityGlobalSearch$commonGlobalSearch$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), EntityGlobalSearch$commonGlobalSearch$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r17) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r17);
        Object r3 = r17;
    L11:
        f.a(f.f12331a, this.$response, (GlobalAssistantSearchResponse) ZeusTransformUtils.preCheckCast(r3, GlobalAssistantSearchResponse.class, "com.obric.memorydata.plugin"));
        RunLog.INSTANCE.debug("EntityGlobalSearch", "cloud global assistant search response: " + u.a(this.$response));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r17);
        d r4 = new d(this.$originQuery, this.$startTime, this.$queryId, this.$searchParams, this.$inputType, this.$memoryScene, this.$taskName, this.$entitySearchRecordInfo, this.$obtainDetailedResults);
        Continuation<? super GlobalAssistantSearchResponse> r5 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        r3 = r4.a(r5);
        if (r3 != r1) goto L11;
        return r1;
    }
}
