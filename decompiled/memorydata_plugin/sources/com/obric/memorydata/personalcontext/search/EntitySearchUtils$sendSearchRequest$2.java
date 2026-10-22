package com.obric.memorydata.personalcontext.search;

import android.util.Log;
import androidx.media.MediaBrowserServiceCompat;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.memorydata.constants.AppInfo;
import com.obric.memorydata.database.model.EntitySearchRecordInfo;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.api.EvaluationService;
import com.obric.memorydata.personalcontext.log.EvaluationResult;
import com.obric.memorydata.personalcontext.search.entity.CallMode;
import com.obric.memorydata.personalcontext.search.entity.SearchRequest;
import com.obric.memorydata.personalcontext.search.entity.SearchResultEntry;
import com.obric.memorydata.sdk.entity.search.AssistantQuResult;
import com.obric.memorydata.sdk.entity.search.QuAction;
import com.obric.memorydata.sdk.entity.search.SearchResponse;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.task.impl.TaskResult;
import com.obric.memorydata.utils.u;
import com.obric.memorydata.utils.y;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.personalcontext.search.EntitySearchUtils$sendSearchRequest$2", f = "EntitySearchUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class EntitySearchUtils$sendSearchRequest$2 extends SuspendLambda implements Function2<al, Continuation<? super List<? extends AppEntity>>, Object> {
    final /* synthetic */ CallMode $callMode;
    final /* synthetic */ EntitySearchRecordInfo $entitySearchRecordInfo;
    final /* synthetic */ String $inputType;
    final /* synthetic */ boolean $isAppFunc;
    final /* synthetic */ AssistantQuResult $quResult;
    final /* synthetic */ SearchRequest $request;
    final /* synthetic */ SearchResponse $response;
    private /* synthetic */ Object L$0;
    int label;

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonExtKt$toListObj$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends TypeToken<List<? extends SearchResultEntry>> {
        public a() {
        }
    }

    EntitySearchUtils$sendSearchRequest$2(SearchRequest r3, SearchResponse r4, EntitySearchRecordInfo r5, boolean r6, AssistantQuResult r7, CallMode r8, String r9, Continuation<? super EntitySearchUtils$sendSearchRequest$2> r10) {
        Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        this.$request = r3;
        this.$response = r4;
        this.$entitySearchRecordInfo = r5;
        this.$isAppFunc = r6;
        this.$quResult = r7;
        this.$callMode = r8;
        this.$inputType = r9;
        super(2, r11);
    }

    private static final List invokeSuspend$lambda$13$lambda$11(Integer r2) {
        return (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
    }

    private static final List invokeSuspend$lambda$13$lambda$12(Function1 r2, Object r3) {
        return (List) ZeusTransformUtils.preCheckCast(((Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin")).invoke(r3), List.class, "com.obric.memorydata.plugin");
    }

    private static final JSONObject invokeSuspend$lambda$7$lambda$4(String r2, Exception r3) {
        JSONObject r4 = new JSONObject();
        r4.put("entity_switch_status", g.INSTANCE.getEntitySwitchStatus());
        r4.put("embedding_type", r2);
        return r4;
    }

    private static final JSONObject invokeSuspend$lambda$7$lambda$6(String r2, String r3) {
        JSONObject r0 = new JSONObject(r2);
        r0.put("entity_switch_status", g.INSTANCE.getEntitySwitchStatus());
        r0.put("embedding_type", r3);
        return r0;
    }

    /* JADX INFO: renamed from: lambda$SLLzA8-r9p1HK5k7ecMFuwb83MQ, reason: not valid java name */
    public static /* synthetic */ JSONObject m1091lambda$SLLzA8r9p1HK5k7ecMFuwb83MQ(String r0, String r1) {
        return invokeSuspend$lambda$7$lambda$6(r0, r1);
    }

    public static /* synthetic */ JSONObject lambda$SaBbP1Yls_sM1yRPk2gVBERe4Z8(String r0, Exception r1) {
        return invokeSuspend$lambda$7$lambda$4(r0, r1);
    }

    public static /* synthetic */ List lambda$aQVFHkzxCcWLXnc7zqsCWn3YKQM(Integer r0) {
        return invokeSuspend$lambda$13$lambda$11(r0);
    }

    public static /* synthetic */ List lambda$kpAkUnXxgPIlkkF1lRPetgzxlqQ(Function1 r0, Object r1) {
        return invokeSuspend$lambda$13$lambda$12(r0, r1);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r12, Continuation<?> r13) {
        Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin");
        EntitySearchUtils$sendSearchRequest$2 r14 = new EntitySearchUtils$sendSearchRequest$2(this.$request, this.$response, this.$entitySearchRecordInfo, this.$isAppFunc, this.$quResult, this.$callMode, this.$inputType, r10);
        r14.L$0 = r12;
        return (Continuation) ZeusTransformUtils.preCheckCast(r14, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super List<? extends AppEntity>> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super List<? extends AppEntity>> r4) {
        return ((EntitySearchUtils$sendSearchRequest$2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), EntitySearchUtils$sendSearchRequest$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r30) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L143;
        ResultKt.throwOnFailure(r30);
        al r0 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        long r5 = System.currentTimeMillis();
        if (this.$request.getSearchParams() != null) goto L12;
        RunLog.INSTANCE.debug("EntitySearchUtils", "Search request searchParams is null");
        SearchResponse r1 = this.$response;
        if (r1 == null) goto L10;
        r1.setCode(1002);
        r1.setMessage("Search request searchParams is null");
        com.obric.memorydata.personalcontext.log.a.f12229a.a(r1);
    L10:
        return CollectionsKt.emptyList();
    L12:
        if (ZeusTransformUtils.instanceOf(this.$request.getSearchParams(), com.obric.memorydata.personalcontext.search.entity.b.class) == true) goto L20;
        RunLog.INSTANCE.debug("EntitySearchUtils", "Search request searchParams is not of type SearchParams");
        SearchResponse r2 = this.$response;
        if (r2 == null) goto L19;
        r2.setCode(1002);
        r2.setMessage("Search request searchParams is not of type SearchParams");
        EvaluationResult r3 = com.obric.memorydata.personalcontext.log.a.f12229a.a();
        if (r3 == null) goto L19;
        r3.setResponse(r2);
    L19:
        return CollectionsKt.emptyList();
    L20:
        EntitySearchRecordInfo r4 = this.$entitySearchRecordInfo;
        if (r4 == null) goto L23;
        r4.setStageSearchParamPrepareCost(System.currentTimeMillis() - r5);
    L23:
        long r6 = System.currentTimeMillis();
        String r7 = "search_app_entity";
        TaskRequest.Builder r8 = (TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder("search_app_entity").setExecuteImmediately(true), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setForegroundCallerPkg(AppInfo.OAssistant.getPackageName()), TaskRequest.Builder.class, "com.obric.memorydata.plugin");
        JSONObject r9 = new JSONObject();
        SearchRequest r10 = this.$request;
        String r11 = this.$inputType;
        r9.put("search_params", u.a(r10.getSearchParams()));
        r9.put("search_type", r10.getSearchType().getValue());
        r9.put("input_type", r11);
        final String r12 = EvaluationService.INSTANCE.getSearchControlParams();
        final String r13 = com.obric.memorydata.personalcontext.util.c.f12363a.c();
        CharSequence r14 = (CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin");
        if (r14 != null) goto L26;
    L29:
        boolean r15 = true;
    L30:
        if (r15 == false) goto L32;
        JSONObject r16 = new JSONObject();
        r16.put("entity_switch_status", g.INSTANCE.getEntitySwitchStatus());
        r16.put("embedding_type", r13);
    L33:
        r9.put("search_control_params", String.valueOf(r16));
        TaskRequest r17 = (TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(r8.setInputParam(r9), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setPriority(10), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin");
        EntitySearchRecordInfo r18 = this.$entitySearchRecordInfo;
        if (r18 != null) goto L36;
    L39:
        EntitySearchRecordInfo r19 = this.$entitySearchRecordInfo;
        if (r19 == null) goto L42;
        String r110 = r17.getTaskParameter().getUuid().toString();
        Intrinsics.checkNotNullExpressionValue(r110, "toString(...)");
        r19.setTaskUUID(r110);
    L42:
        TaskResult r22 = r17.execute();
        long r111 = System.currentTimeMillis();
        double r112 = r111 - r6;
        EntitySearchRecordInfo r20 = this.$entitySearchRecordInfo;
        if (r20 == null) goto L45;
        r20.setStageTaskExecuteCost(r112);
    L45:
        Log.i("EntitySearchUtils", "SearchTask cost: " + r112 + "ms");
        if (r22.getCode() == 0) goto L58;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntitySearchUtils", "Search fail， error code: " + r22.getCode() + ", error message: " + r22.getMsg(), null, 4, null);
        if (r22.getCode() != 1005) goto L52;
        SearchResponse r21 = this.$response;
        if (r21 == null) goto L57;
        r21.setCode(1005);
        String r23 = r22.getMsg();
    L55:
        r21.setMessage(r23);
        com.obric.memorydata.personalcontext.log.a.f12229a.a(r21);
    L57:
        return CollectionsKt.emptyList();
    L52:
        r21 = this.$response;
        if (r21 == null) goto L57;
        r21.setCode(1006);
        r23 = "package error code: " + r22.getCode() + ", error message: " + r22.getMsg();
        goto L55
    L58:
        String r24 = r22.getOutput().optString(MediaBrowserServiceCompat.KEY_SEARCH_RESULTS).toString();
        String r25 = r22.getOutput().optString("package_total_time_cost_log").toString();
        RunLog.INSTANCE.debug("EntitySearchUtils", "Search result entry:" + r24);
        RunLog.INSTANCE.debug("EntitySearchUtils", "requestInfo: " + u.a(this.$request) + '\n' + r25);
        List<SearchResultEntry> r26 = (List) ZeusTransformUtils.preCheckCast(u.a().fromJson(r24, new a().getType()), List.class, "com.obric.memorydata.plugin");     // Catch: JsonParseException -> L61 JsonSyntaxException -> L63
    L66:
        if (r26 != null) goto L70;
        RunLog.INSTANCE.debug("EntitySearchUtils", "Search result entry failed, could not parse search results");
    L69:
        return CollectionsKt.emptyList();
    L70:
        long r27 = System.currentTimeMillis();
        if (this.$isAppFunc == false) goto L93;
        AssistantQuResult r28 = this.$quResult;
        if (r28 == null) goto L79;
        List<QuAction> r29 = r28.getActions();
        if (r29 == null) goto L79;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r29, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) != true) goto L79;
        boolean r113 = true;
    L80:
        if (r113 == false) goto L93;
        HashMap r31 = new HashMap();
        Iterator r114 = ((Iterable) ZeusTransformUtils.preCheckCast(r26, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L83:
        if (r114.hasNext() == false) goto L85;
        SearchResultEntry r32 = (SearchResultEntry) ZeusTransformUtils.preCheckCast(r114.next(), SearchResultEntry.class, "com.obric.memorydata.plugin");
        Integer r115 = Boxing.boxInt(r32.getActionId());
        final $$Lambda$EntitySearchUtils$sendSearchRequest$2$aQVFHkzxCcWLXnc7zqsCWn3YKQM r33 = $$Lambda$EntitySearchUtils$sendSearchRequest$2$aQVFHkzxCcWLXnc7zqsCWn3YKQM.INSTANCE;
        ((List) ZeusTransformUtils.preCheckCast(r31.computeIfAbsent(r115, new $$Lambda$EntitySearchUtils$sendSearchRequest$2$kpAkUnXxgPIlkkF1lRPetgzxlqQ(r33)), List.class, "com.obric.memorydata.plugin")).add(r32);
        r114 = r114;
        goto L83
    L85:
        List r34 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        List<QuAction> r35 = this.$quResult.getActions();
        if (r35 != null) goto L88;
        r35 = CollectionsKt.emptyList();
    L88:
        Iterator<QuAction> r36 = r35.iterator();
    L90:
        if (r36.hasNext() == false) goto L92;
        QuAction r116 = (QuAction) ZeusTransformUtils.preCheckCast(r36.next(), QuAction.class, "com.obric.memorydata.plugin");
        int r117 = r116.getActionId();
        Iterator<QuAction> r37 = r36;
        g r38 = g.INSTANCE;
        Object r118 = r31.getOrDefault(Boxing.boxInt(r117), (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNullExpressionValue(r118, "getOrDefault(...)");
        List r39 = g.loadAppEntitiesBySearchResultEntries$default(r38, (List) ZeusTransformUtils.preCheckCast(r118, List.class, "com.obric.memorydata.plugin"), null, 2, null);
        r116.setSearchResultCount(r39.size());
        r34.addAll((Collection) ZeusTransformUtils.preCheckCast(r39, Collection.class, "com.obric.memorydata.plugin"));
        r36 = r37;
        r112 = r112;
        goto L90
    L92:
        double r119 = r112;
    L115:
        EntitySearchRecordInfo r40 = this.$entitySearchRecordInfo;
        if (r40 == null) goto L118;
        r40.setLoadResultCost(System.currentTimeMillis() - r27);
    L118:
        g.trackSearchPerfInfo$default(g.INSTANCE, this.$entitySearchRecordInfo, r6, r111, r119, r22, false, 32, null);
        EvaluationResult r41 = com.obric.memorydata.personalcontext.log.a.f12229a.a();
        if (r41 == null) goto L121;
        r41.setType("search");
    L121:
        EvaluationResult r42 = com.obric.memorydata.personalcontext.log.a.f12229a.a();
        if (r42 == null) goto L124;
        r42.addResultEntitiesList(CollectionsKt.toMutableList((Collection) ZeusTransformUtils.preCheckCast(r34, Collection.class, "com.obric.memorydata.plugin")));
    L124:
        EvaluationResult r43 = com.obric.memorydata.personalcontext.log.a.f12229a.a();
        if (r43 == null) goto L127;
        r43.setQuResult(this.$quResult);
    L127:
        EvaluationResult r44 = com.obric.memorydata.personalcontext.log.a.f12229a.a();
        if (r44 == null) goto L130;
        r44.addQueryTimeCost(this.$entitySearchRecordInfo);
    L130:
        EvaluationResult r45 = com.obric.memorydata.personalcontext.log.a.f12229a.a();
        if (r45 == null) goto L133;
        r45.addResultList(r26);
    L133:
        EvaluationResult r46 = com.obric.memorydata.personalcontext.log.a.f12229a.a();
        if (r46 == null) goto L136;
        r46.setCallType(this.$callMode);
    L136:
        com.obric.memorydata.personalcontext.log.a.f12229a.a(this.$response);
        if (com.obric.memorydata.personalcontext.log.a.f12229a.b() == true) goto L139;
    L141:
        return r34;
    L139:
        if (com.obric.memorydata.personalcontext.log.a.f12229a.c() == true) goto L141;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntitySearchUtils", "return empty result when evaluating", null, 4, null);
    L79:
        r113 = false;
    L93:
        r119 = r112;
        if (this.$quResult == null) goto L114;
        Iterable r47 = (Iterable) ZeusTransformUtils.preCheckCast(r26, Iterable.class, "com.obric.memorydata.plugin");
        AssistantQuResult r48 = this.$quResult;
        Iterator r49 = r47.iterator();
    L97:
        if (r49.hasNext() == false) goto L114;
        SearchResultEntry r50 = (SearchResultEntry) ZeusTransformUtils.preCheckCast(r49.next(), SearchResultEntry.class, "com.obric.memorydata.plugin");
        List<QuAction> r120 = r48.getActions();
        if (r120 == null) goto L97;
        Iterator r121 = ((Iterable) ZeusTransformUtils.preCheckCast(r120, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L102:
        if (r121.hasNext() == false) goto L109;
        Object r122 = r121.next();
        if (((QuAction) ZeusTransformUtils.preCheckCast(r122, QuAction.class, "com.obric.memorydata.plugin")).getActionId() != r50.getActionId()) goto L106;
        boolean r123 = true;
    L107:
        if (r123 == false) goto L102;
    L110:
        QuAction r51 = (QuAction) ZeusTransformUtils.preCheckCast(r122, QuAction.class, "com.obric.memorydata.plugin");
        if (r51 == null) goto L97;
        r51.setSearchResultCount(r51.getSearchResultCount() + 1);
        goto L97
    L106:
        r123 = false;
        goto L107
    L109:
        r122 = null;
    L114:
        r34 = g.loadAppEntitiesBySearchResultEntries$default(g.INSTANCE, r26, null, 2, null);
        goto L115
    L63:
        e = e;
        IRunLog r210 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r52 = new StringBuilder();
    L65:
        IRunLog.a.b(r210, "GsonExt", r52.append("toListObj error : ").append(e).toString(), null, 4, null);
        r26 = null;
    L61:
        e = e;
        r210 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r52 = new StringBuilder();
        goto L65
    L36:
        if (this.$isAppFunc == false) goto L38;
        r7 = "app_func_entity_search";
    L38:
        r18.setType(r7);
        goto L39
    L32:
        r16 = (JSONObject) ZeusTransformUtils.preCheckCast(y.a(new $$Lambda$EntitySearchUtils$sendSearchRequest$2$SaBbP1Yls_sM1yRPk2gVBERe4Z8(r13), new $$Lambda$EntitySearchUtils$sendSearchRequest$2$SLLzA8r9p1HK5k7ecMFuwb83MQ(r12, r13)), JSONObject.class, "com.obric.memorydata.plugin");
        goto L33
    L26:
        if (r14.length() == 0) goto L29;
        r15 = false;
        goto L30
    L143:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
