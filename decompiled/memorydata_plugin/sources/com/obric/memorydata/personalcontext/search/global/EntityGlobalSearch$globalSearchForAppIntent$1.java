package com.obric.memorydata.personalcontext.search.global;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.database.model.EntitySearchRecordInfo;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.sdk.entity.global.GlobalAssistantIntentSearchResponse;
import com.obric.memorydata.sdk.entity.search.GlobalIntentSearchModel;
import com.obric.memorydata.sdk.entity.search.GlobalQUResult;
import com.obric.memorydata.sdk.entity.search.RewriteQuery;
import com.obric.memorydata.sdk.entity.search.SearchDomainQuery;
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
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.personalcontext.search.global.EntityGlobalSearch$globalSearchForAppIntent$1", f = "EntityGlobalSearch.kt", i = {0}, l = {937}, m = "invokeSuspend", n = {CommonConsts.APM_INNER_EVENT_COST_START}, s = {"J$0"})
final class EntityGlobalSearch$globalSearchForAppIntent$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ EntitySearchRecordInfo $entitySearchRecordInfo;
    final /* synthetic */ int $limitCount;
    final /* synthetic */ String $meta;
    final /* synthetic */ String $quResult;
    final /* synthetic */ String $queryId;
    final /* synthetic */ GlobalAssistantIntentSearchResponse $response;
    final /* synthetic */ long $startTime;
    long J$0;
    int label;

    EntityGlobalSearch$globalSearchForAppIntent$1(String r3, GlobalAssistantIntentSearchResponse r4, long r5, String r7, EntitySearchRecordInfo r8, int r9, String r10, Continuation<? super EntityGlobalSearch$globalSearchForAppIntent$1> r11) {
        Continuation r12 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        this.$quResult = r3;
        this.$response = r4;
        this.$startTime = r5;
        this.$queryId = r7;
        this.$entitySearchRecordInfo = r8;
        this.$limitCount = r9;
        this.$meta = r10;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r12, Continuation<?> r13) {
        Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new EntityGlobalSearch$globalSearchForAppIntent$1(this.$quResult, this.$response, this.$startTime, this.$queryId, this.$entitySearchRecordInfo, this.$limitCount, this.$meta, r10), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((EntityGlobalSearch$globalSearchForAppIntent$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), EntityGlobalSearch$globalSearchForAppIntent$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r28) {
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        long r6 = this.J$0;
        ResultKt.throwOnFailure(r28);
        Object r1 = r28;
    L60:
        f.a(f.f12331a, this.$response, (GlobalAssistantIntentSearchResponse) ZeusTransformUtils.preCheckCast(r1, GlobalAssistantIntentSearchResponse.class, "com.obric.memorydata.plugin"));
        long r4 = System.currentTimeMillis() - r6;
        JSONObject r3 = new JSONObject();
        r3.put("type", "normal");
        r3.put("iteration", 1);
        r3.put("cost", r4);
        com.obric.memorydata.database.util.b.f9624a.a(r3.put("search_cost", r4), "memory_react_agent", this.$meta);
        RunLog.INSTANCE.debug("EntityGlobalSearch", "cloud global assistant search response: " + u.a(this.$response));
    L21:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r28);
        String r7 = this.$quResult;
        if (r7 != null) goto L61;
        GlobalIntentSearchModel r5 = null;
    L17:
        if (r5 != null) goto L22;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityGlobalSearch", "toObj<GlobalIntentSearchModel> fail", null, 4, null);
        this.$response.setCode(1003);
        GlobalAssistantIntentSearchResponse r8 = this.$response;
        StringBuilder r9 = new StringBuilder();
    L19:
        r8.setMessage(r9.append("QueryUnderStanding: ").append(this.$quResult).toString());
        goto L21
    L22:
        List r10 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r5.getSearchAppEntity(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L24:
        if (r11.hasNext() == false) goto L26;
        SearchDomainQuery r12 = (SearchDomainQuery) ZeusTransformUtils.preCheckCast(r11.next(), SearchDomainQuery.class, "com.obric.memorydata.plugin");
        r10.add(new RewriteQuery(r12.getDomain(), r12.getQuery(), "app_entity", null, 8, null));
        goto L24
    L26:
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(r5.getSearchAppEntityContent(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L28:
        if (r13.hasNext() == false) goto L30;
        SearchDomainQuery r14 = (SearchDomainQuery) ZeusTransformUtils.preCheckCast(r13.next(), SearchDomainQuery.class, "com.obric.memorydata.plugin");
        r10.add(new RewriteQuery(r14.getDomain(), r14.getQuery(), "app_entity_content", null, 8, null));
        goto L28
    L30:
        Iterator r15 = ((Iterable) ZeusTransformUtils.preCheckCast(r5.getSearchMemoryEntity(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L32:
        if (r15.hasNext() == false) goto L34;
        SearchDomainQuery r16 = (SearchDomainQuery) ZeusTransformUtils.preCheckCast(r15.next(), SearchDomainQuery.class, "com.obric.memorydata.plugin");
        r10.add(new RewriteQuery(r16.getDomain(), r16.getQuery(), "memory_entity", null, 8, null));
        goto L32
    L34:
        GlobalQUResult r17 = new GlobalQUResult(r5.getOriginQuery(), f.a(f.f12331a, r10), null, 4, null);
        List<RewriteQuery> r18 = r17.getQuery_rewrite();
        boolean r19 = false;
        if (r18 == null) goto L49;
        Iterable r20 = (Iterable) ZeusTransformUtils.preCheckCast(r18, Iterable.class, "com.obric.memorydata.plugin");
        Collection r21 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r22 = r20.iterator();
    L38:
        if (r22.hasNext() == false) goto L48;
        Object r23 = r22.next();
        RewriteQuery r110 = (RewriteQuery) ZeusTransformUtils.preCheckCast(r23, RewriteQuery.class, "com.obric.memorydata.plugin");
        if (com.obric.memorydata.personalcontext.search.d.f12308a.b().contains(r110.getDomain()) == false) goto L42;
    L45:
        boolean r111 = true;
    L46:
        if (r111 == false) goto L38;
        r21.add(r23);
        goto L38
    L42:
        if (Intrinsics.areEqual(r110.getDomain(), "All") == true) goto L45;
        r111 = false;
        goto L46
    L48:
        List<RewriteQuery> r24 = (List) ZeusTransformUtils.preCheckCast(r21, List.class, "com.obric.memorydata.plugin");
    L50:
        r17.setQuery_rewrite(r24);
        Collection r25 = (Collection) ZeusTransformUtils.preCheckCast(r17.getQuery_rewrite(), Collection.class, "com.obric.memorydata.plugin");
        if (r25 != null) goto L53;
    L54:
        r19 = true;
    L55:
        if (r19 == false) goto L57;
        this.$response.setCode(1003);
        r8 = this.$response;
        r9 = new StringBuilder();
        goto L19
    L57:
        RunLog.INSTANCE.debug("EntityGlobalSearch", "raw query: " + r17.getOrigin_query());
        r6 = System.currentTimeMillis();
        c r26 = new c(this.$startTime, r17.getOrigin_query(), this.$queryId, r17, this.$entitySearchRecordInfo, this.$limitCount);
        Continuation<? super GlobalAssistantIntentSearchResponse> r27 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.J$0 = r6;
        this.label = 1;
        r1 = r26.d(r27);
        if (r1 != r2) goto L60;
        return r2;
    L53:
        if (r25.isEmpty() == false) goto L55;
    L49:
        r24 = null;
        goto L50
    L61:
        Object r29 = u.a().fromJson(r7, GlobalIntentSearchModel.class);     // Catch: Exception -> L12
    L14:
        r5 = (GlobalIntentSearchModel) ZeusTransformUtils.preCheckCast(r29, GlobalIntentSearchModel.class, "com.obric.memorydata.plugin");
    L12:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GsonExt", "convert content: " + r7 + " toObj error : " + e, null, 4, null);
        r29 = null;
        goto L14
    }
}
