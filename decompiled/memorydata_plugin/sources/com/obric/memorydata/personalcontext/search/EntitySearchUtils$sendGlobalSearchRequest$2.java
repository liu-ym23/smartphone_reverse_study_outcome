package com.obric.memorydata.personalcontext.search;

import androidx.media.MediaBrowserServiceCompat;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.search.InAppSearchRequest;
import com.obric.capabilitykit.entity.search.global.GlobalSearchEntity;
import com.obric.capabilitykit.entity.search.global.GlobalSearchRequest;
import com.obric.capabilitykit.entity.search.global.GlobalSearchResult;
import com.obric.capabilitykit.search.global.IGlobalSearchCallback;
import com.obric.memorydata.constants.AppInfo;
import com.obric.memorydata.database.model.EntitySearchRecordInfo;
import com.obric.memorydata.middleware.api.device.DeviceInfoState;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.riskcontrol.RiskControlManager;
import com.obric.memorydata.personalcontext.search.entity.SearchRequest;
import com.obric.memorydata.personalcontext.search.entity.SearchResultEntry;
import com.obric.memorydata.task.impl.TaskInfo;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.utils.u;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.personalcontext.search.EntitySearchUtils$sendGlobalSearchRequest$2", f = "EntitySearchUtils.kt", i = {0}, l = {740}, m = "invokeSuspend", n = {"globalSearchTaskName"}, s = {"L$0"})
final class EntitySearchUtils$sendGlobalSearchRequest$2 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ IGlobalSearchCallback $callback;
    final /* synthetic */ EntitySearchRecordInfo $entitySearchRecordInfo;
    final /* synthetic */ SearchRequest $request;
    final /* synthetic */ List<String> $taskIds;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/personalcontext/search/EntitySearchUtils$sendGlobalSearchRequest$2$2$searchRequest$2", "Lcom/obric/memorydata/task/scheduler/OnTaskInfoCallBack;", "onChanged", "", "taskInfo", "Lcom/obric/memorydata/task/impl/TaskInfo;", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements com.obric.memorydata.task.scheduler.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ IGlobalSearchCallback f12270a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Integer f12271b;
        final /* synthetic */ SearchRequest c;
        final /* synthetic */ String d;
        final /* synthetic */ AtomicInteger e;
        final /* synthetic */ EntitySearchRecordInfo f;
        final /* synthetic */ long g;

        /* JADX INFO: renamed from: com.obric.memorydata.personalcontext.search.EntitySearchUtils$sendGlobalSearchRequest$2$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonExtKt$toListObj$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class C0658a extends TypeToken<List<? extends SearchResultEntry>> {
            public C0658a() {
            }
        }

        a(IGlobalSearchCallback r3, Integer r4, SearchRequest r5, String r6, AtomicInteger r7, EntitySearchRecordInfo r8, long r9) {
            this.f12270a = (IGlobalSearchCallback) ZeusTransformUtils.wrapperContextForParams(r3, IGlobalSearchCallback.class, "com.obric.memorydata.plugin");
            this.f12271b = r4;
            this.c = r5;
            this.d = r6;
            this.e = r7;
            this.f = r8;
            this.g = r9;
        }

        @Override // com.obric.memorydata.task.scheduler.c
        public void a(TaskInfo r24) {
            Intrinsics.checkNotNullParameter(r24, "taskInfo");
            if (r24.e().getCode() != 0) goto L5;
        L10:
            String r0 = r24.e().getOutput().optString(MediaBrowserServiceCompat.KEY_SEARCH_RESULTS).toString();
            String r7 = r24.e().getOutput().optString("package_total_time_cost_log").toString();
            RunLog.INSTANCE.debug("EntitySearchUtils", "Search result entry:" + r0);
            RunLog.INSTANCE.debug("EntitySearchUtils", "requestInfo: " + u.a(this.c) + '\n' + r7);
            List r1 = (List) ZeusTransformUtils.preCheckCast(u.a().fromJson(r0, new C0658a().getType()), List.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L13 JsonParseException -> L15 JsonSyntaxException -> L18
        L21:
            if (r1 != null) goto L24;
            r1 = CollectionsKt.emptyList();     // Catch: Exception -> L13
        L24:
            if (r1.isEmpty() == false) goto L27;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntitySearchUtils", "Search results are empty", false, 4, null);
            IGlobalSearchCallback r2 = this.f12270a;
            Integer r4 = g.INSTANCE.getTaskNameToEntityTypeMap().get(this.d);
            Intrinsics.checkNotNull(r4);
            r2.onSearchResult(new GlobalSearchResult(((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).intValue(), CollectionsKt.emptyList(), this.e.getAndIncrement()));
            IGlobalSearchCallback r3 = this.f12270a;
            Integer r5 = g.INSTANCE.getTaskNameToEntityTypeMap().get(this.d);
            Intrinsics.checkNotNull(r5);
            r3.onCompleted(((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin")).intValue());
            return;
        L27:
            List r6 = g.loadAppEntitiesBySearchResultEntries$default(g.INSTANCE, r1, null, 2, null);
            if (r6.isEmpty() == false) goto L32;
            String r8 = "Fail to load app entities by search result entries: " + r1 + '.';
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntitySearchUtils", r8, null, 4, null);
            this.f12270a.onError(1, this.f12271b.intValue(), r8);
            return;
        L32:
            if (r1.size() == r6.size()) goto L34;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntitySearchUtils", "The size of search result entries does not match the size of app entities.", null, 4, null);
        L34:
            Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.zip((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin");
            Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
            Iterator r11 = r9.iterator();
        L36:
            if (r11.hasNext() == false) goto L44;
            Object r12 = r11.next();
            Pair r13 = (Pair) ZeusTransformUtils.preCheckCast(r12, Pair.class, "com.obric.memorydata.plugin");
            SearchResultEntry r14 = (SearchResultEntry) ZeusTransformUtils.preCheckCast(r13.component1(), SearchResultEntry.class, "com.obric.memorydata.plugin");
            AppEntity r15 = (AppEntity) ZeusTransformUtils.preCheckCast(r13.component2(), AppEntity.class, "com.obric.memorydata.plugin");
            if (r14.getInAppSearchParams() == null) goto L41;
            if (r15 == null) goto L41;
            boolean r16 = true;
        L42:
            if (r16 == false) goto L36;
            r10.add(r12);
        L41:
            r16 = false;
            goto L42
        L44:
            Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
            Collection r18 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10)), Collection.class, "com.obric.memorydata.plugin");
            Iterator r19 = r17.iterator();
        L46:
            if (r19.hasNext() == false) goto L48;
            Pair r20 = (Pair) ZeusTransformUtils.preCheckCast(r19.next(), Pair.class, "com.obric.memorydata.plugin");
            r18.add(new GlobalSearchEntity((AppEntity) ZeusTransformUtils.preCheckCast(r20.component2(), AppEntity.class, "com.obric.memorydata.plugin"), ((SearchResultEntry) ZeusTransformUtils.preCheckCast(r20.component1(), SearchResultEntry.class, "com.obric.memorydata.plugin")).getInAppSearchParams()));
            goto L46
        L48:
            List r21 = (List) ZeusTransformUtils.preCheckCast(r18, List.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.c.getPackageName(), AppInfo.FileManager.getPackageName()) == false) goto L55;
            EntitySearchRecordInfo r22 = this.f;
            if (r22 == null) goto L59;
            StringBuilder r23 = new StringBuilder();
            String r25 = "file_manager_search_";
        L53:
            r22.setType(r23.append(r25).append(this.d).toString());
        L59:
            IGlobalSearchCallback r26 = this.f12270a;
            Integer r27 = g.INSTANCE.getTaskNameToEntityTypeMap().get(this.d);
            Intrinsics.checkNotNull(r27);
            r26.onSearchResult(new GlobalSearchResult(((Number) ZeusTransformUtils.preCheckCast(r27, Number.class, "com.obric.memorydata.plugin")).intValue(), r21, this.e.getAndIncrement()));
            IGlobalSearchCallback r28 = this.f12270a;
            Integer r29 = g.INSTANCE.getTaskNameToEntityTypeMap().get(this.d);
            Intrinsics.checkNotNull(r29);
            r28.onCompleted(((Number) ZeusTransformUtils.preCheckCast(r29, Number.class, "com.obric.memorydata.plugin")).intValue());
            long r30 = System.currentTimeMillis();
            double r31 = r30 - this.g;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntitySearchUtils", "InAppSearchTask cost: " + r31 + "ms", false, 4, null);
            g.trackSearchPerfInfo$default(g.INSTANCE, this.f, this.g, r30, r31, r24.e(), false, 32, null);
            RunLog.INSTANCE.debug("EntitySearchUtils", "global search success: " + u.a(r21));
            return;
        L55:
            if (Intrinsics.areEqual(this.c.getPackageName(), AppInfo.QuickSearch.getPackageName()) == false) goto L59;
            r22 = this.f;
            if (r22 == null) goto L59;
            r23 = new StringBuilder();
            r25 = "quick_search_";
            goto L53
        L13:
            e = move-exception;
            String r32 = "Error parsing search results: " + e.getMessage();
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntitySearchUtils", r32, null, 4, null);
            this.f12270a.onError(1, this.f12271b.intValue(), r32);
            return;
        L15:
            e = move-exception;
            IRunLog r110 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L13
            String r111 = "GsonExt";
            String r112 = "toListObj error : " + e;     // Catch: Exception -> L13
        L17:
            IRunLog.a.b(r110, r111, r112, null, 4, null);     // Catch: Exception -> L13
            r1 = null;
        L18:
            e = move-exception;
            r110 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L13
            r111 = "GsonExt";
            r112 = "toListObj error : " + e;     // Catch: Exception -> L13
            goto L17
        L5:
            if (r24.c() == TaskInfo.State.SUCCEEDED) goto L10;
            if (r24.c() != TaskInfo.State.FAILED) goto L72;
            this.f12270a.onError(1, this.f12271b.intValue(), "Search task execution failed, taskResult msg:" + r24.e().getMsg() + ", taskResult code:" + r24.e().getCode() + '.');
            return;
        }
    }

    EntitySearchUtils$sendGlobalSearchRequest$2(IGlobalSearchCallback r3, SearchRequest r4, List<String> r5, EntitySearchRecordInfo r6, Continuation<? super EntitySearchUtils$sendGlobalSearchRequest$2> r7) {
        IGlobalSearchCallback r8 = (IGlobalSearchCallback) ZeusTransformUtils.wrapperContextForParams(r3, IGlobalSearchCallback.class, "com.obric.memorydata.plugin");
        List<String> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        this.$callback = r8;
        this.$request = r4;
        this.$taskIds = r9;
        this.$entitySearchRecordInfo = r6;
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new EntitySearchUtils$sendGlobalSearchRequest$2(this.$callback, this.$request, this.$taskIds, this.$entitySearchRecordInfo, r6), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((EntitySearchUtils$sendGlobalSearchRequest$2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), EntitySearchUtils$sendGlobalSearchRequest$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x016f -> B:40:0x0172). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r24) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        int r3 = -1;
        ?? r4 = 1;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        Iterator r5 = (Iterator) ZeusTransformUtils.preCheckCast(this.L$2, Iterator.class, "com.obric.memorydata.plugin");
        IGlobalSearchCallback r6 = (IGlobalSearchCallback) ZeusTransformUtils.preCheckCast(this.L$1, IGlobalSearchCallback.class, "com.obric.memorydata.plugin");
        List r7 = (List) ZeusTransformUtils.preCheckCast(this.L$0, List.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r24);
        Object r8 = r24;
    L41:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r8, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L36;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntitySearchUtils", "error: model is not ready", null, 4, null);
        r6.onError(1, -1, "error: model is not ready");
        r6.onAllCompleted();
    L15:
        return Unit.INSTANCE;
    L36:
        if (r5.hasNext() == false) goto L43;
        String r9 = (String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.memorydata.plugin");
        g r10 = g.INSTANCE;
        this.L$0 = r7;
        this.L$1 = r6;
        this.L$2 = r5;
        this.label = 1;
        r8 = g.access$checkModelIsReady(r10, this);
        if (r8 != r1) goto L41;
        return r1;
    L43:
        AtomicInteger r11 = new AtomicInteger(0);
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin");
        SearchRequest r15 = this.$request;
        IGlobalSearchCallback r13 = this.$callback;
        List<String> r14 = this.$taskIds;
        EntitySearchRecordInfo r0 = this.$entitySearchRecordInfo;
        Iterator r16 = r12.iterator();
        IGlobalSearchCallback r17 = r13;
    L45:
        if (r16.hasNext() == false) goto L55;
        String r18 = (String) ZeusTransformUtils.preCheckCast(r16.next(), String.class, "com.obric.memorydata.plugin");
        InAppSearchRequest r19 = new InAppSearchRequest(((GlobalSearchRequest) ZeusTransformUtils.preCheckCast(r15.getSearchParams(), GlobalSearchRequest.class, "com.obric.memorydata.plugin")).getQuery(), ((GlobalSearchRequest) ZeusTransformUtils.preCheckCast(r15.getSearchParams(), GlobalSearchRequest.class, "com.obric.memorydata.plugin")).getDefaultEntityCount(), ((GlobalSearchRequest) ZeusTransformUtils.preCheckCast(r15.getSearchParams(), GlobalSearchRequest.class, "com.obric.memorydata.plugin")).getUseSemantic(), ((GlobalSearchRequest) ZeusTransformUtils.preCheckCast(r15.getSearchParams(), GlobalSearchRequest.class, "com.obric.memorydata.plugin")).getEnableSemanticRanking(), ((GlobalSearchRequest) ZeusTransformUtils.preCheckCast(r15.getSearchParams(), GlobalSearchRequest.class, "com.obric.memorydata.plugin")).getMaxSemanticResultCount());
        Integer r20 = (Integer) ZeusTransformUtils.preCheckCast(g.INSTANCE.getTaskNameToEntityTypeMap().get(r18), Integer.class, "com.obric.memorydata.plugin");
        if (r20 != null) goto L49;
        r17.onError(r4, r3, "can not find entityType " + r18);
        List<String> r21 = r14;
    L53:
        r14 = r21;
        r17 = r17;
        r0 = r0;
        r3 = -1;
        r4 = 1;
        goto L45
    L49:
        String r22 = (String) ZeusTransformUtils.preCheckCast(g.INSTANCE.getEntityTypeToPackageNameMap().get(g.INSTANCE.getTaskNameToEntityTypeMap().get(r18)), String.class, "com.obric.memorydata.plugin");
        if (r22 != null) goto L52;
        r22 = "";
    L52:
        r19.setPackageName(r22);
        long r110 = System.currentTimeMillis();
        TaskRequest.Builder r23 = new TaskRequest.Builder(r18);
        JSONObject r25 = new JSONObject();
        r25.put("search_params", u.a(r19));
        r25.put("search_type", r15.getSearchType().getValue());
        r25.put("search_control_params", new JSONObject().put("embedding_type", com.obric.memorydata.personalcontext.util.c.f12363a.c()).toString());
        EntitySearchRecordInfo r111 = r0;
        r21 = r14;
        TaskRequest r26 = (TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(r23.setInputParam(r25), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setForegroundCallerPkg(r15.getPackageName()), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExecuteImmediately(r4), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setPriority(10), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setTaskInfoCallback((com.obric.memorydata.task.scheduler.c) ZeusTransformUtils.preCheckCast(new a(r17, r20, r15, r18, r11, r111, r110), com.obric.memorydata.task.scheduler.c.class, "com.obric.memorydata.plugin")), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin");
        r26.enqueue();
        String r27 = r26.getTaskParameter().getUuid().toString();
        Intrinsics.checkNotNullExpressionValue(r27, "toString(...)");
        r21.add(r27);
        goto L53
    L55:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r24);
        if (DeviceInfoState.INSTANCE.isObricOsDevice() == true) goto L17;
        String r28 = "here is not support GlobalAppSearch on non-Ocean OS device";
    L11:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntitySearchUtils", r28, null, 4, null);
    L12:
        this.$callback.onError(1, -1, r28);
    L13:
        this.$callback.onAllCompleted();
        goto L15
    L17:
        if (this.$request.getSearchParams() != null) goto L20;
        r28 = "error: Search request params is null";
        goto L11
    L20:
        if (ZeusTransformUtils.instanceOf(this.$request.getSearchParams(), GlobalSearchRequest.class) == true) goto L23;
        r28 = "Search request searchParams is not of type InAppSearchRequest";
        goto L11
    L23:
        if (RiskControlManager.INSTANCE.haveAppSearchSensitiveWordCategories(((GlobalSearchRequest) ZeusTransformUtils.preCheckCast(this.$request.getSearchParams(), GlobalSearchRequest.class, "com.obric.memorydata.plugin")).getQuery()) == false) goto L25;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntitySearchUtils", "sensitive word in query of local global search", null, 4, null);
        goto L13
    L25:
        Iterable r29 = (Iterable) ZeusTransformUtils.preCheckCast(((GlobalSearchRequest) ZeusTransformUtils.preCheckCast(this.$request.getSearchParams(), GlobalSearchRequest.class, "com.obric.memorydata.plugin")).getSearchEntityTypes(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r30 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r31 = r29.iterator();
    L27:
        if (r31.hasNext() == false) goto L31;
        String r32 = (String) ZeusTransformUtils.preCheckCast(g.INSTANCE.getEntityTypeToTaskNameMap().get(Boxing.boxInt(((Number) ZeusTransformUtils.preCheckCast(r31.next(), Number.class, "com.obric.memorydata.plugin")).intValue())), String.class, "com.obric.memorydata.plugin");
        if (r32 == null) goto L27;
        r30.add(r32);
        goto L27
    L31:
        List r33 = (List) ZeusTransformUtils.preCheckCast(r30, List.class, "com.obric.memorydata.plugin");
        if (r33.isEmpty() == false) goto L34;
        r28 = "Could not find inAppSearchTaskName by packageName";
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntitySearchUtils", "Could not find inAppSearchTaskName by packageName", null, 4, null);
        goto L12
    L34:
        Iterable r34 = (Iterable) ZeusTransformUtils.preCheckCast(r33, Iterable.class, "com.obric.memorydata.plugin");
        IGlobalSearchCallback r35 = this.$callback;
        r7 = r33;
        r5 = r34.iterator();
        r6 = r35;
        goto L36
    }
}
