package com.obric.memorydata.personalcontext.search;

import androidx.media.MediaBrowserServiceCompat;
import com.bytedance.bdinstall.Api;
import com.bytedance.crash.entity.EventBody;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.capabilitykit.entity.search.InAppSearchRequest;
import com.obric.capabilitykit.entity.search.InAppSearchResult;
import com.obric.capabilitykit.entity.search.InAppSearchResultWithoutEntity;
import com.obric.capabilitykit.search.IAppSearchCallback;
import com.obric.memorydata.constants.AppInfo;
import com.obric.memorydata.database.model.EntitySearchRecordInfo;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.device.DeviceInfoState;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.riskcontrol.RiskControlManager;
import com.obric.memorydata.personalcontext.log.EvaluationResult;
import com.obric.memorydata.personalcontext.q;
import com.obric.memorydata.personalcontext.search.entity.QuResultItem;
import com.obric.memorydata.personalcontext.search.entity.SearchRequest;
import com.obric.memorydata.personalcontext.search.entity.SearchResultEntry;
import com.obric.memorydata.sdk.entity.search.AssistantQuResult;
import com.obric.memorydata.sdk.entity.search.BertQUAction;
import com.obric.memorydata.sdk.entity.search.QuAction;
import com.obric.memorydata.sdk.entity.search.RewriteQuery;
import com.obric.memorydata.task.impl.TaskInfo;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.task.impl.TaskResult;
import com.obric.memorydata.task.scheduler.impl.ExistingTaskPolicy;
import com.obric.memorydata.utils.RegionUtil;
import com.obric.memorydata.utils.ab;
import com.obric.memorydata.utils.ac;
import com.obric.memorydata.utils.u;
import com.obric.memorydata.utils.y;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.personalcontext.search.EntitySearchUtils$sendInAppSearchRequest$2", f = "EntitySearchUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class EntitySearchUtils$sendInAppSearchRequest$2 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $businessName;
    final /* synthetic */ IAppSearchCallback $callback;
    final /* synthetic */ EntitySearchRecordInfo $entitySearchRecordInfo;
    final /* synthetic */ h $isBusinessCancelled;
    final /* synthetic */ SearchRequest $request;
    final /* synthetic */ CopyOnWriteArrayList<String> $taskIds;
    private /* synthetic */ Object L$0;
    int label;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/obric/memorydata/personalcontext/search/EntitySearchUtils$sendInAppSearchRequest$2$quResultItems$2$2$1", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/obric/memorydata/personalcontext/search/entity/QuResultItem;", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends TypeToken<List<? extends QuResultItem>> {
        a() {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/personalcontext/search/EntitySearchUtils$sendInAppSearchRequest$2$searchRequest$2", "Lcom/obric/memorydata/task/scheduler/OnTaskInfoCallBack;", "onChanged", "", "taskInfo", "Lcom/obric/memorydata/task/impl/TaskInfo;", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements com.obric.memorydata.task.scheduler.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f12272a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ IAppSearchCallback f12273b;
        final /* synthetic */ Ref.ObjectRef<String> c;
        final /* synthetic */ long d;
        final /* synthetic */ EntitySearchRecordInfo e;
        final /* synthetic */ SearchRequest f;
        final /* synthetic */ String g;
        final /* synthetic */ long h;

        @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonExtKt$toListObj$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class a extends TypeToken<List<? extends SearchResultEntry>> {
            public a() {
            }
        }

        b(String r3, IAppSearchCallback r4, Ref.ObjectRef<String> r5, long r6, EntitySearchRecordInfo r8, SearchRequest r9, String r10, long r11) {
            IAppSearchCallback r7 = (IAppSearchCallback) ZeusTransformUtils.wrapperContextForParams(r4, IAppSearchCallback.class, "com.obric.memorydata.plugin");
            this.f12272a = r3;
            this.f12273b = r7;
            this.c = r5;
            this.d = r6;
            this.e = r8;
            this.f = r9;
            this.g = r10;
            this.h = r11;
        }

        @Override // com.obric.memorydata.task.scheduler.c
        public void a(TaskInfo r31) {
            Intrinsics.checkNotNullParameter(r31, "taskInfo");
            if (r31.c() != TaskInfo.State.FAILED) goto L5;
        L6:
            String r0 = "Search task " + this.f12272a + " execution failed, taskResult msg:" + r31.e().getMsg() + ", taskResult code:" + r31.e().getCode() + '.';
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntitySearchUtils", r0, null, 4, null);
            if (r31.e().getCode() != 1005) goto L9;
            this.f12273b.onError(3, r31.e().getMsg());
        L11:
            if (r31.c().isFinished() == false) goto L19;
            if (this.c.element == null) goto L19;
            com.obric.memorydata.personalcontext.search.bridge.a.a r1 = com.obric.memorydata.personalcontext.search.bridge.a.a.f12280a.a((String) ZeusTransformUtils.preCheckCast(this.c.element, String.class, "com.obric.memorydata.plugin"));
            if (r1.f() == true) goto L17;
            r1.c().c().await();
        L17:
            g.INSTANCE.getSearchOptResultCallback().remove(this.c.element);
            com.obric.memorydata.personalcontext.search.bridge.a.a.f12280a.b((String) ZeusTransformUtils.preCheckCast(this.c.element, String.class, "com.obric.memorydata.plugin"));
        L19:
            if (r31.c() == TaskInfo.State.SUCCEEDED) goto L21;
            return;
        L21:
            long r7 = System.currentTimeMillis();
            double r9 = r7 - this.d;
            EntitySearchRecordInfo r2 = this.e;
            if (r2 == null) goto L24;
            r2.setStageTaskExecuteCost(r9);
        L24:
            String r4 = "ms";
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntitySearchUtils", "InAppSearchTask cost: " + r9 + "ms", false, 4, null);
            String r3 = r31.e().getOutput().optString("package_total_time_cost_log").toString();
            if (this.c.element == null) goto L33;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntitySearchUtils", "Optimized Search Task cost:\n" + r3, false, 4, null);
            int r5 = 0;
            g.INSTANCE.trackSearchPerfInfo(this.e, this.d, r7, r9, r31.e(), true);
            if (r31.e().getOutput().optBoolean("is_optimized_search", false) == false) goto L32;
            this.f12273b.onCompleted();
            EvaluationResult r6 = com.obric.memorydata.personalcontext.log.a.f12229a.a();
            if (r6 == null) goto L94;
            r6.setQuResult(new AssistantQuResult(CollectionsKt.listOf(new QuAction(0, r31.e().getOutput().optString("query_understanding_results").toString(), null, 0, 8, null))));
            return;
        L94:
            return;
        L32:
            String r8 = "query_understanding_results";
        L34:
            String r10 = r31.e().getOutput().optString(MediaBrowserServiceCompat.KEY_SEARCH_RESULTS).toString();
            String r13 = r31.e().getOutput().optString(r8).toString();
            int r11 = r31.e().getOutput().optInt("code", r5);
            EvaluationResult r15 = com.obric.memorydata.personalcontext.log.a.f12229a.a();
            if (r15 == null) goto L37;
            r15.setQuResult(new AssistantQuResult(CollectionsKt.listOf(new QuAction(0, r13, null, 0, 8, null))));
        L37:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntitySearchUtils", "Search Task cost:\n" + r3, false, 4, null);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntitySearchUtils", "Search result entry:" + r10, null, 4, null);
            if (r11 != 101) goto L41;
            RunLog.INSTANCE.debug("EntitySearchUtils", "No results were found in the slot, retrieve all entities.");
            this.f12273b.onError(101, "No results were found in the slot, retrieve all entities.");
            return;
        L41:
            List<SearchResultEntry> r12 = null;
            r12 = (List) ZeusTransformUtils.preCheckCast(u.a().fromJson(r10, new a().getType()), List.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L44 JsonParseException -> L46 JsonSyntaxException -> L49
        L51:
            if (r12 != null) goto L53;
            r12 = CollectionsKt.emptyList();     // Catch: Exception -> L44
        L53:
            EvaluationResult r14 = com.obric.memorydata.personalcontext.log.a.f12229a.a();     // Catch: Exception -> L44
            if (r14 == null) goto L56;
            r14.addResultList(r12);     // Catch: Exception -> L44
        L56:
            EvaluationResult r16 = com.obric.memorydata.personalcontext.log.a.f12229a.a();
            if (r16 == null) goto L60;
            r16.addQueryTimeCost(this.e);
        L60:
            if (q.f12255a.t().contains(this.f.getPackageName()) == false) goto L62;
        L81:
            String r23 = "ms";
            double r17 = r9;
            List r18 = g.access$constructInAppSearchResponse(g.INSTANCE, this.f, r12, this.f12273b, this.e);
            if (r18.isEmpty() == false) goto L84;
            return;
        L84:
            long r19 = System.currentTimeMillis();
            this.f12273b.onSearchResult(new InAppSearchResult(r18));
            this.f12273b.onCompleted();
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntitySearchUtils", "response callback cost: " + (System.currentTimeMillis() - r19), false, 4, null);
            r18.size();
        L85:
            RunLog.INSTANCE.debugLocalTest("EntitySearchUtils", "inAppSearchEntities: ", r18);
        L86:
            g.trackSearchPerfInfo$default(g.INSTANCE, this.e, this.d, r7, r17, r31.e(), false, 32, null);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntitySearchUtils", "In app search finished, cost:" + (System.currentTimeMillis() - this.h) + r23, false, 4, null);
            return;
        L62:
            if (Intrinsics.areEqual(this.f.getPackageName(), AppContext.INSTANCE.getPackageName()) == false) goto L67;
            if (Intrinsics.areEqual(this.g, "SearchAllMemory") == false) goto L81;
        L67:
            if (com.obric.memorydata.utils.d.f13204a.a(this.f.getPackageName()) == true) goto L69;
        L77:
            r23 = "ms";
            r17 = r9;
            List r20 = g.access$constructInAppSearchResponseWithoutEntity(g.INSTANCE, this.f, r12, this.f12273b, this.e);
            if (r20.isEmpty() == false) goto L80;
            return;
        L80:
            long r21 = System.currentTimeMillis();
            this.f12273b.onSearchResultWithoutEntity(new InAppSearchResultWithoutEntity(r20, g.access$parseSearchExtraMap(g.INSTANCE, r31.e().getOutput().opt("extra_data"))));
            this.f12273b.onCompleted();
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntitySearchUtils", "response without entity callback, cost: " + (System.currentTimeMillis() - r21), false, 4, null);
            r20.size();
            goto L86
        L69:
            if (Intrinsics.areEqual(this.g, "SearchAllMemory") == true) goto L77;
            r18 = g.access$constructInAppSearchResponse(g.INSTANCE, this.f, r12, this.f12273b, this.e);
            if (r18.isEmpty() == false) goto L73;
            return;
        L73:
            long r110 = System.currentTimeMillis();
            int r22 = ((r18.size() + 500) - 1) / 500;
            int r111 = 0;
        L74:
            if (r111 >= r22) goto L76;
            int r112 = r111 * 500;
            String r24 = r4;
            this.f12273b.onSearchResult(new InAppSearchResult(r18.subList(r112, Math.min(r112 + 500, r18.size()))));
            r111 = r111 + 1;
            r22 = r22;
            r9 = r9;
            r4 = r24;
            goto L74
        L76:
            r23 = r4;
            r17 = r9;
            this.f12273b.onCompleted();
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntitySearchUtils", "response callback cost: " + (System.currentTimeMillis() - r110), false, 4, null);
            goto L85
        L44:
            e = move-exception;
            String r25 = "Error parsing search results: " + e.getMessage();
            RunLog.INSTANCE.debug("EntitySearchUtils", r25);
            this.f12273b.onError(1, r25);
            return;
        L46:
            e = move-exception;
            IRunLog r26 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L44
            String r27 = "GsonExt";
            String r28 = "toListObj error : " + e;     // Catch: Exception -> L44
        L48:
            IRunLog.a.b(r26, r27, r28, null, 4, null);     // Catch: Exception -> L44
        L49:
            e = move-exception;
            r26 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L44
            r27 = "GsonExt";
            r28 = "toListObj error : " + e;     // Catch: Exception -> L44
            goto L48
        L33:
            r8 = "query_understanding_results";
            r5 = 0;
            goto L34
        L9:
            this.f12273b.onError(1, r0);
            goto L11
        L5:
            if (r31.c() != TaskInfo.State.CANCELLED) goto L11;
            goto L6
        }
    }

    EntitySearchUtils$sendInAppSearchRequest$2(SearchRequest r3, IAppSearchCallback r4, String r5, EntitySearchRecordInfo r6, CopyOnWriteArrayList<String> r7, h r8, Continuation<? super EntitySearchUtils$sendInAppSearchRequest$2> r9) {
        IAppSearchCallback r10 = (IAppSearchCallback) ZeusTransformUtils.wrapperContextForParams(r4, IAppSearchCallback.class, "com.obric.memorydata.plugin");
        h r11 = (h) ZeusTransformUtils.wrapperContextForParams(r8, h.class, "com.obric.memorydata.plugin");
        Continuation r12 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        this.$request = r3;
        this.$callback = r10;
        this.$businessName = r5;
        this.$entitySearchRecordInfo = r6;
        this.$taskIds = r7;
        this.$isBusinessCancelled = r11;
        super(2, r12);
    }

    private static final List invokeSuspend$lambda$10(TaskResult r3) {
        String r4 = r3.getOutput().optString("qu_response");
        Intrinsics.checkNotNull(r4);
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L6;
        r4 = null;
    L6:
        if (r4 == null) goto L11;
        List r5 = (List) ZeusTransformUtils.preCheckCast(ab.a().fromJson(r4, new a().getType()), List.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L11;
        return r5;
    L11:
        return CollectionsKt.emptyList();
    }

    private static final Unit invokeSuspend$lambda$16(IAppSearchCallback r5, SearchRequest r6, EntitySearchRecordInfo r7, List r8, Map r9) {
        IAppSearchCallback r10 = (IAppSearchCallback) ZeusTransformUtils.wrapperContextForParams(r5, IAppSearchCallback.class, "com.obric.memorydata.plugin");
        List<SearchResultEntry> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        Map r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.memorydata.plugin");
        EvaluationResult r2 = com.obric.memorydata.personalcontext.log.a.f12229a.a();     // Catch: Exception -> L7
        if (r2 == null) goto L9;
        r2.addResultList(r11);     // Catch: Exception -> L7
    L9:
        List r13 = g.access$constructInAppSearchResponseWithoutEntity(g.INSTANCE, r6, r11, r10, r7);
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r13, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L13;
        r10.onSearchResultWithoutEntity(new InAppSearchResultWithoutEntity(r13, r12));
    L13:
        return Unit.INSTANCE;
    L7:
        e = move-exception;
        String r3 = "Error parsing search results: " + e.getMessage();
        RunLog.INSTANCE.debug("EntitySearchUtils", r3);
        r10.onError(1, r3);
        goto L9
    }

    private static final List invokeSuspend$lambda$7(Exception r3) {
        RunLog.INSTANCE.error("EntitySearchUtils", "Query result json parse failed", (Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.memorydata.plugin"));
        return CollectionsKt.emptyList();
    }

    /* JADX INFO: renamed from: lambda$9-C46lv0m_M29t-X4c6p3-ujAfk, reason: not valid java name */
    public static /* synthetic */ List m1088lambda$9C46lv0m_M29tX4c6p3ujAfk(TaskResult r0) {
        return invokeSuspend$lambda$10(r0);
    }

    /* JADX INFO: renamed from: lambda$eE7o65bRevI-Pdp1sN_d_WeX5-A, reason: not valid java name */
    public static /* synthetic */ Unit m1089lambda$eE7o65bRevIPdp1sN_d_WeX5A(IAppSearchCallback r0, SearchRequest r1, EntitySearchRecordInfo r2, List r3, Map r4) {
        return invokeSuspend$lambda$16(r0, r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: lambda$rnZasSVForkv-tS54rxZJoVAQA4, reason: not valid java name */
    public static /* synthetic */ List m1090lambda$rnZasSVForkvtS54rxZJoVAQA4(Exception r0) {
        return invokeSuspend$lambda$7(r0);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        EntitySearchUtils$sendInAppSearchRequest$2 r13 = new EntitySearchUtils$sendInAppSearchRequest$2(this.$request, this.$callback, this.$businessName, this.$entitySearchRecordInfo, this.$taskIds, this.$isBusinessCancelled, r9);
        r13.L$0 = r11;
        return (Continuation) ZeusTransformUtils.preCheckCast(r13, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((EntitySearchUtils$sendInAppSearchRequest$2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), EntitySearchUtils$sendInAppSearchRequest$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r0v72, types: [T, org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r2v20, types: [T, org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r2v59, types: [T, java.lang.String] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r26) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L173;
        ResultKt.throwOnFailure(r26);
        al r0 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        RunLog.INSTANCE.debug("EntitySearchUtils", "sendInAppSearchRequest: " + this.$request);
        String r5 = null;
        if (DeviceInfoState.INSTANCE.isObricOsDevice() == true) goto L22;
        if (com.obric.memorydata.utils.d.f13204a.a(this.$request.getPackageName()) == true) goto L22;
        if (Intrinsics.areEqual(this.$request.getPackageName(), AppContext.INSTANCE.getPackageName()) == true) goto L22;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntitySearchUtils", "here is not support inAppSearch on non-Ocean OS device", null, 4, null);
        if (q.f12255a.t().contains(this.$request.getPackageName()) == false) goto L13;
    L17:
        IAppSearchCallback r1 = this.$callback;
        InAppSearchResult r2 = new InAppSearchResult(CollectionsKt.emptyList());
    L72:
        r1.onSearchResult(r2);
    L18:
        this.$callback.onCompleted();
    L20:
        return Unit.INSTANCE;
    L13:
        if (Intrinsics.areEqual(this.$request.getPackageName(), AppContext.INSTANCE.getPackageName()) == true) goto L17;
        IAppSearchCallback r3 = this.$callback;
        InAppSearchResultWithoutEntity r4 = new InAppSearchResultWithoutEntity(CollectionsKt.emptyList(), null, 2, null);
    L16:
        r3.onSearchResultWithoutEntity(r4);
    L22:
        if (Intrinsics.areEqual(this.$request.getPackageName(), AppInfo.ASSISTANT_AI_AGENT.getPackageName()) == true) goto L24;
    L34:
        long r13 = System.currentTimeMillis();
        if (this.$request.getSearchParams() != null) goto L39;
        String r6 = "error: Search request params is null";
    L37:
        RunLog.INSTANCE.debug("EntitySearchUtils", r6);
        this.$callback.onError(1, r6);
        goto L20
    L39:
        if (ZeusTransformUtils.instanceOf(this.$request.getSearchParams(), InAppSearchRequest.class) == true) goto L42;
        r6 = "Search request searchParams is not of type InAppSearchRequest";
        goto L37
    L42:
        if (RiskControlManager.INSTANCE.haveAppSearchSensitiveWordCategories(((InAppSearchRequest) ZeusTransformUtils.preCheckCast(this.$request.getSearchParams(), InAppSearchRequest.class, "com.obric.memorydata.plugin")).getQuery()) == false) goto L53;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntitySearchUtils", "sensitive word in query of in app search", null, 4, null);
        if (q.f12255a.t().contains(this.$request.getPackageName()) == false) goto L46;
    L51:
        r1 = this.$callback;
        r2 = new InAppSearchResult(CollectionsKt.emptyList());
        goto L72
    L46:
        if (Intrinsics.areEqual(this.$request.getPackageName(), AppContext.INSTANCE.getPackageName()) == true) goto L51;
        if (com.obric.memorydata.utils.d.f13204a.a(this.$request.getPackageName()) == true) goto L51;
        r3 = this.$callback;
        r4 = new InAppSearchResultWithoutEntity(CollectionsKt.emptyList(), null, 2, null);
        goto L16
    L53:
        if (g.INSTANCE.enablePresetQUResult(this.$request.getPackageName()) == false) goto L55;
        String r7 = ((InAppSearchRequest) ZeusTransformUtils.preCheckCast(this.$request.getSearchParams(), InAppSearchRequest.class, "com.obric.memorydata.plugin")).getPresetQUResult();
    L56:
        if (r7 != null) goto L174;
        String r8 = g.access$getTaskName(g.INSTANCE, this.$request.getPackageName(), this.$businessName);
        BertQUAction r9 = null;
    L77:
        CharSequence r10 = (CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L80;
    L83:
        boolean r11 = true;
    L85:
        if (r11 == true) goto L87;
        EntitySearchRecordInfo r12 = this.$entitySearchRecordInfo;
        if (r12 == null) goto L99;
        r12.setType(r8);
        Unit r14 = Unit.INSTANCE;
    L99:
        EntitySearchRecordInfo r15 = this.$entitySearchRecordInfo;
        if (r15 == null) goto L102;
        r15.setStageSearchParamPrepareCost(System.currentTimeMillis() - r13);
        Unit r16 = Unit.INSTANCE;
    L102:
        String r17 = g.INSTANCE.getDomainNameByTaskName(r8);
        String r18 = g.INSTANCE.getActionNameByDomain(r17);
        Ref.ObjectRef r19 = new Ref.ObjectRef();
        CharSequence r20 = (CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.memorydata.plugin");
        if (r20 != null) goto L105;
    L108:
        boolean r21 = true;
    L110:
        if (r21 == false) goto L113;
        String r22 = "Could not find actionName for domain: " + r17;
        RunLog.INSTANCE.debug("EntitySearchUtils", r22);
        this.$callback.onError(5, r22);
    L142:
        long r23 = System.currentTimeMillis();
        Ref.ObjectRef r24 = new Ref.ObjectRef();
        if (Intrinsics.areEqual(this.$request.getPackageName(), AppInfo.Gallery.getPackageName()) == false) goto L145;
        r24.element = com.obric.memorydata.personalcontext.search.bridge.a.a.f12280a.a();
    L145:
        TaskRequest.Builder r25 = new TaskRequest.Builder(r8);
        JSONObject r27 = new JSONObject();
        SearchRequest r28 = this.$request;
        r27.put("search_params", u.a(r28.getSearchParams()));
        r27.put("search_type", r28.getSearchType().getValue());
        r27.put("lang", ac.f13156a.a());
        r27.put(Api.KEY_REGION, RegionUtil.f13145a.a().name());
        if (Intrinsics.areEqual(r8, "in_app_search_all_memory") == false) goto L148;
        r27.put("audio_memory_configured", g.access$isAudioMemoryConfiguredForCurrentUser(g.INSTANCE));
    L148:
        JSONObject r29 = (JSONObject) ZeusTransformUtils.preCheckCast(r19.element, JSONObject.class, "com.obric.memorydata.plugin");
        if (r29 == null) goto L151;
        r27.put("query_understanding_results", r29);
    L151:
        String r30 = g.access$getSearchControlPrams(g.INSTANCE, r28.getPackageName());
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r30, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L154;
        boolean r31 = true;
    L155:
        if (r31 == false) goto L158;
        r27.put("search_control_params", r30);
    L158:
        if (r24.element == 0) goto L160;
        r27.put("search_opt_task_id", r24.element);
    L160:
        TaskRequest r32 = (TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(r25.setInputParam(r27), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExistingTaskPolicy(ExistingTaskPolicy.CANCEL_EXISTING), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExecuteImmediately(true), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setForegroundCallerPkg(this.$request.getPackageName()), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setPriority(10), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setTaskInfoCallback((com.obric.memorydata.task.scheduler.c) ZeusTransformUtils.preCheckCast(new b(r8, this.$callback, r24, r23, this.$entitySearchRecordInfo, this.$request, r18, r13), com.obric.memorydata.task.scheduler.c.class, "com.obric.memorydata.plugin")), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin");
        this.$taskIds.add(r32.getTaskParameter().getUuid().toString());
        if (r24.element == 0) goto L163;
        Map r33 = (Map) ZeusTransformUtils.preCheckCast(g.INSTANCE.getSearchOptResultCallback(), Map.class, "com.obric.memorydata.plugin");
        T r34 = r24.element;
        final IAppSearchCallback r35 = this.$callback;
        final SearchRequest r36 = this.$request;
        final EntitySearchRecordInfo r37 = this.$entitySearchRecordInfo;
        r33.put(r34, new $$Lambda$EntitySearchUtils$sendInAppSearchRequest$2$eE7o65bRevIPdp1sN_d_WeX5A(r35, r36, r37));
    L163:
        h r38 = this.$isBusinessCancelled;
        if (r38 != null) goto L166;
    L171:
        r32.enqueue();
        goto L20
    L166:
        if (r38.a() == false) goto L171;
        if (r24.element == 0) goto L170;
        g.INSTANCE.getSearchOptResultCallback().remove(r24.element);
        com.obric.memorydata.personalcontext.search.bridge.a.a.f12280a.b((String) ZeusTransformUtils.preCheckCast(r24.element, String.class, "com.obric.memorydata.plugin"));
    L170:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntitySearchUtils", "Business is cancelled, cancel search task.", null, 4, null);
        goto L20
    L154:
        r31 = false;
        goto L155
    L113:
        if (Intrinsics.areEqual(r18, "SearchPhoto") == true) goto L142;
        if (Intrinsics.areEqual(r18, "SearchRecording") == true) goto L142;
        if (r7 != null) goto L142;
        long r110 = System.currentTimeMillis();
        if (Intrinsics.areEqual(r17, "AllMemory") == false) goto L120;
        String r111 = "MemoryMark";
    L121:
        String r39 = "SearchMemoryMark";
        if (Intrinsics.areEqual(r17, "AllMemory") == true) goto L124;
    L126:
        List r40 = CollectionsKt.listOf(new RewriteQuery(r111, ((InAppSearchRequest) ZeusTransformUtils.preCheckCast(this.$request.getSearchParams(), InAppSearchRequest.class, "com.obric.memorydata.plugin")).getQuery(), null, null, 12, null));
        TaskRequest.Builder r41 = (TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder("bert_all_in_one").setForegroundCallerPkg(this.$request.getPackageName()), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExecuteImmediately(true), TaskRequest.Builder.class, "com.obric.memorydata.plugin");
        JSONObject r42 = new JSONObject();
        r42.put("qu_request", new JSONArray(ab.a().toJson(r40)));
        r42.put("lang", ac.f13156a.a());
        r42.put(Api.KEY_REGION, RegionUtil.f13145a.a().name());
        final TaskResult r43 = ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(r41.setInputParam(r42), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setPriority(10), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).execute();
        if (r43.getCode() == 0) goto L129;
        String r44 = "quResult failed, error code: " + r43.getCode() + ", error message: " + r43.getMsg();
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntitySearchUtils", r44, null, 4, null);
    L95:
        this.$callback.onError(5, r44);
        goto L20
    L129:
        List r45 = (List) ZeusTransformUtils.preCheckCast(y.a($$Lambda$EntitySearchUtils$sendInAppSearchRequest$2$rnZasSVForkvtS54rxZJoVAQA4.INSTANCE, new $$Lambda$EntitySearchUtils$sendInAppSearchRequest$2$9C46lv0m_M29tX4c6p3ujAfk(r43)), List.class, "com.obric.memorydata.plugin");
        if (r45 != null) goto L133;
        r45 = CollectionsKt.emptyList();
    L133:
        if (Intrinsics.areEqual(r18, "SearchAllMemory") == true) goto L136;
        r39 = r18;
    L136:
        QuResultItem r46 = com.obric.memorydata.personalcontext.search.entity.a.a(r45, r39);
        if (r46 == null) goto L141;
        r19.element = new JSONObject(ab.a().toJson(r46));
        EntitySearchRecordInfo r47 = this.$entitySearchRecordInfo;
        if (r47 == null) goto L142;
        r47.setQueryUnderstandingCost(System.currentTimeMillis() - r110);
        Unit r48 = Unit.INSTANCE;
        goto L142
    L141:
        IAppSearchCallback r49 = this.$callback;
        String r50 = "No QU result for action: " + r18;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntitySearchUtils", r50, null, 4, null);
        r49.onError(5, r50);
        goto L20
    L124:
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == true) goto L126;
        RunLog.INSTANCE.debug("EntitySearchUtils", "AIKernel not available, skip bert model");
        ?? r51 = new JSONObject();
        SearchRequest r52 = this.$request;
        r51.put("actionName", "SearchMemoryMark");
        r51.put("isStandardQuery", true);
        JSONObject r53 = new JSONObject();
        JSONObject r54 = new JSONObject();
        JSONArray r112 = new JSONArray();
        r112.put(((InAppSearchRequest) ZeusTransformUtils.preCheckCast(r52.getSearchParams(), InAppSearchRequest.class, "com.obric.memorydata.plugin")).getQuery());
        Unit r55 = Unit.INSTANCE;
        r54.put(EventBody.KEY_VALUE, r112);
        Unit r56 = Unit.INSTANCE;
        r53.put(Params.CONTENT, r54);
        Unit r57 = Unit.INSTANCE;
        r51.put("inputParams", r53);
        r19.element = r51;
        goto L142
    L120:
        r111 = r17;
        goto L121
    L105:
        if (r20.length() == 0) goto L108;
        r21 = false;
        goto L110
    L87:
        if (r7 != null) goto L90;
        StringBuilder r58 = new StringBuilder().append("Could not find inAppSearchTaskName for ").append(this.$request.getPackageName());
    L89:
        r44 = r58.toString();
        RunLog.INSTANCE.debug("EntitySearchUtils", r44);
        goto L95
    L90:
        StringBuilder r59 = new StringBuilder().append("Could not find inAppSearchTaskName for ");
        if (r9 == null) goto L93;
        r5 = r9.getActionName();
    L93:
        r58 = r59.append(r5);
        goto L89
    L80:
        if (r10.length() == 0) goto L83;
        r11 = false;
        goto L85
    L174:
        Object r60 = u.a().fromJson(r7, BertQUAction.class);     // Catch: Exception -> L60
    L62:
        r9 = (BertQUAction) ZeusTransformUtils.preCheckCast(r60, BertQUAction.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L76;
        String r61 = (String) ZeusTransformUtils.preCheckCast(q.f12255a.k().get(r9.getActionName()), String.class, "com.obric.memorydata.plugin");
        if (r61 != null) goto L67;
    L69:
        boolean r62 = false;
    L70:
        if (r62 == false) goto L73;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntitySearchUtils", "in-app search domain switch off", false, 4, null);
        r1 = this.$callback;
        r2 = new InAppSearchResult(CollectionsKt.emptyList());
        goto L72
    L73:
        String r63 = (String) ZeusTransformUtils.preCheckCast(q.f12255a.k().get(r9.getActionName()), String.class, "com.obric.memorydata.plugin");
        if (r63 == null) goto L76;
        r8 = (String) ZeusTransformUtils.preCheckCast(d.f12308a.d().get(r63), String.class, "com.obric.memorydata.plugin");
        goto L77
    L67:
        if (com.obric.memorydata.personalcontext.search.a.f12274a.a().contains(r61) != true) goto L69;
        r62 = true;
    L76:
        r8 = null;
    L60:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GsonExt", "convert content: " + r7 + " toObj error : " + e, null, 4, null);
        r60 = null;
        goto L62
    L55:
        r7 = null;
        goto L56
    L24:
        if (UserSettings.INSTANCE.hasAgreePrivacy() == true) goto L34;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntitySearchUtils", "user not agree privacy", false, 4, null);
        if (q.f12255a.t().contains(this.$request.getPackageName()) == false) goto L28;
    L33:
        r1 = this.$callback;
        r2 = new InAppSearchResult(CollectionsKt.emptyList());
        goto L72
    L28:
        if (Intrinsics.areEqual(this.$request.getPackageName(), AppContext.INSTANCE.getPackageName()) == true) goto L33;
        if (com.obric.memorydata.utils.d.f13204a.a(this.$request.getPackageName()) == true) goto L33;
        r3 = this.$callback;
        r4 = new InAppSearchResultWithoutEntity(CollectionsKt.emptyList(), null, 2, null);
        goto L16
    L173:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
