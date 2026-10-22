package com.obric.memorydata.personalcontext.search.global;

import com.obric.memorydata.database.model.EntitySearchRecordInfo;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.sdk.entity.global.GlobalAssistantSearchResponse;
import com.obric.memorydata.sdk.entity.search.GlobalQUResult;
import com.obric.memorydata.sdk.entity.search.RewriteQuery;
import com.obric.memorydata.utils.u;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
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
@DebugMetadata(c = "com.obric.memorydata.personalcontext.search.global.EntityGlobalSearch$cloudSearch$1", f = "EntityGlobalSearch.kt", i = {}, l = {729}, m = "invokeSuspend", n = {}, s = {})
final class EntityGlobalSearch$cloudSearch$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ EntitySearchRecordInfo $entitySearchRecordInfo;
    final /* synthetic */ String $inputType;
    final /* synthetic */ String $quResult;
    final /* synthetic */ String $queryId;
    final /* synthetic */ GlobalAssistantSearchResponse $response;
    final /* synthetic */ long $startTime;
    int label;

    EntityGlobalSearch$cloudSearch$1(String r3, GlobalAssistantSearchResponse r4, long r5, String r7, EntitySearchRecordInfo r8, String r9, Continuation<? super EntityGlobalSearch$cloudSearch$1> r10) {
        Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        this.$quResult = r3;
        this.$response = r4;
        this.$startTime = r5;
        this.$queryId = r7;
        this.$entitySearchRecordInfo = r8;
        this.$inputType = r9;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new EntityGlobalSearch$cloudSearch$1(this.$quResult, this.$response, this.$startTime, this.$queryId, this.$entitySearchRecordInfo, this.$inputType, r9), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((EntityGlobalSearch$cloudSearch$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), EntityGlobalSearch$cloudSearch$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r14);
    L47:
        f.a(f.f12331a, this.$response, (GlobalAssistantSearchResponse) ZeusTransformUtils.preCheckCast(r14, GlobalAssistantSearchResponse.class, "com.obric.memorydata.plugin"));
        RunLog.INSTANCE.debug("EntityGlobalSearch", "cloud global assistant search response: " + u.a(this.$response));
    L21:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        String r15 = this.$quResult;
        List<RewriteQuery> r2 = null;
        if (r15 != null) goto L48;
        GlobalQUResult r10 = null;
    L17:
        if (r10 != null) goto L22;
        this.$response.setCode(1003);
        GlobalAssistantSearchResponse r3 = this.$response;
        StringBuilder r4 = new StringBuilder();
    L19:
        r3.setMessage(r4.append("QueryUnderStanding: ").append(this.$quResult).toString());
        goto L21
    L22:
        List<RewriteQuery> r6 = r10.getQuery_rewrite();
        boolean r7 = false;
        if (r6 == null) goto L37;
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r9 = r5.iterator();
    L26:
        if (r9.hasNext() == false) goto L36;
        Object r11 = r9.next();
        RewriteQuery r12 = (RewriteQuery) ZeusTransformUtils.preCheckCast(r11, RewriteQuery.class, "com.obric.memorydata.plugin");
        if (com.obric.memorydata.personalcontext.search.d.f12308a.b().contains(r12.getDomain()) == false) goto L30;
    L33:
        boolean r13 = true;
    L34:
        if (r13 == false) goto L26;
        r8.add(r11);
        goto L26
    L30:
        if (Intrinsics.areEqual(r12.getDomain(), "All") == true) goto L33;
        r13 = false;
        goto L34
    L36:
        r2 = (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin");
    L37:
        r10.setQuery_rewrite(r2);
        Collection r16 = (Collection) ZeusTransformUtils.preCheckCast(r10.getQuery_rewrite(), Collection.class, "com.obric.memorydata.plugin");
        if (r16 != null) goto L40;
    L41:
        r7 = true;
    L42:
        if (r7 == false) goto L44;
        this.$response.setCode(1003);
        r3 = this.$response;
        r4 = new StringBuilder();
        goto L19
    L44:
        RunLog.INSTANCE.debug("EntityGlobalSearch", "raw query: " + r10.getOrigin_query());
        b r17 = new b(this.$startTime, r10.getOrigin_query(), this.$queryId, r10, this.$entitySearchRecordInfo, this.$inputType);
        Continuation<? super GlobalAssistantSearchResponse> r18 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        r14 = r17.c(r18);
        if (r14 != r0) goto L47;
        return r0;
    L40:
        if (r16.isEmpty() == false) goto L42;
    L48:
        Object r19 = u.a().fromJson(r15, GlobalQUResult.class);     // Catch: Exception -> L12
    L14:
        r10 = (GlobalQUResult) ZeusTransformUtils.preCheckCast(r19, GlobalQUResult.class, "com.obric.memorydata.plugin");
    L12:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GsonExt", "convert content: " + r15 + " toObj error : " + e, null, 4, null);
        r19 = null;
        goto L14
    }
}
