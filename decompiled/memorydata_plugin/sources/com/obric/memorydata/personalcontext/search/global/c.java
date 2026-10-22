package com.obric.memorydata.personalcontext.search.global;

import android.os.Bundle;
import androidx.media.MediaBrowserServiceCompat;
import com.bytedance.bdinstall.Api;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.memorydata.database.model.EntitySearchRecordInfo;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.search.entity.SearchResultEntry;
import com.obric.memorydata.sdk.entity.global.GlobalAssistantIntentSearchResponse;
import com.obric.memorydata.sdk.entity.global.GlobalAssistantSearchEntityResult;
import com.obric.memorydata.sdk.entity.global.GlobalAssistantSearchMemoryResult;
import com.obric.memorydata.sdk.entity.global.GlobalAssistantSearchResponse;
import com.obric.memorydata.sdk.entity.global.ProactiveRecommendationSearchResult;
import com.obric.memorydata.sdk.entity.search.GlobalQUResult;
import com.obric.memorydata.sdk.entity.search.RewriteQuery;
import com.obric.memorydata.sdk.entity.search.SearchResponse;
import com.obric.memorydata.sdk.entity.search.SearchResult;
import com.obric.memorydata.task.impl.TaskInfo;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.task.impl.TaskResult;
import com.obric.memorydata.utils.RegionUtil;
import com.obric.memorydata.utils.ab;
import com.obric.memorydata.utils.ac;
import com.obric.memorydata.utils.u;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 )2\u00020\u0001:\u0001)B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u001d\u001a\u00020\bH\u0094@¢\u0006\u0002\u0010\u001eJ\u000e\u0010\u001f\u001a\u00020 H\u0086@¢\u0006\u0002\u0010\u001eJ \u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00120\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/obric/memorydata/personalcontext/search/global/CloudGlobalIntentAssistantSearchSession;", "Lcom/obric/memorydata/personalcontext/search/global/AbstractGlobalAssistantSearchSession;", "startTime", "", "userQuery", "", "queryId", "quResult", "Lcom/obric/memorydata/sdk/entity/search/GlobalQUResult;", "entitySearchRecordInfo", "Lcom/obric/memorydata/database/model/EntitySearchRecordInfo;", "limitCount", "", "<init>", "(JLjava/lang/String;Ljava/lang/String;Lcom/obric/memorydata/sdk/entity/search/GlobalQUResult;Lcom/obric/memorydata/database/model/EntitySearchRecordInfo;I)V", "appEntityNoneSemanticAllResultEntries", "", "", "Lcom/obric/memorydata/personalcontext/search/entity/SearchResultEntry;", "appEntitySemanticAllResultEntries", "contentNoneSemanticAllResultEntries", "contentSemanticAllResultEntries", "memoryContentSearchResultEntry", "", "getMemoryContentSearchResultEntry", "()Ljava/util/List;", "setMemoryContentSearchResultEntry", "(Ljava/util/List;)V", "proactiveRecommendationSearchResultEntry", "getQuUnderStandingResult", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantIntentSearchResponse;", "createTaskCallback", "Lcom/obric/memorydata/task/scheduler/OnTaskInfoCallBack;", "rewriteQuery", "Lcom/obric/memorydata/sdk/entity/search/RewriteQuery;", "taskStartTime", "useInputRawQuery", "", "getSpecificLimitCount", "Companion", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c extends com.obric.memorydata.personalcontext.search.global.a {
    public static final a d = null;
    private final long e;
    private final String f;
    private final String g;
    private final GlobalQUResult h;
    private final EntitySearchRecordInfo i;
    private final int j;
    private final Map<String, List<SearchResultEntry>> k;
    private final Map<String, List<SearchResultEntry>> l;
    private final Map<String, List<SearchResultEntry>> m;
    private final Map<String, List<SearchResultEntry>> n;
    private List<SearchResultEntry> o;
    private List<SearchResultEntry> p;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/personalcontext/search/global/CloudGlobalIntentAssistantSearchSession$Companion;", "", "<init>", "()V", "TAG", "", "MAX_LIMIT_COUNT", "", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/personalcontext/search/global/CloudGlobalIntentAssistantSearchSession$createTaskCallback$1", "Lcom/obric/memorydata/task/scheduler/OnTaskInfoCallBack;", "onChanged", "", "taskInfo", "Lcom/obric/memorydata/task/impl/TaskInfo;", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements com.obric.memorydata.task.scheduler.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ EntitySearchRecordInfo f12326a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f12327b;
        final /* synthetic */ RewriteQuery c;
        final /* synthetic */ long d;

        @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonExtKt$toListObj$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class a extends TypeToken<List<? extends SearchResultEntry>> {
            public a() {
            }
        }

        b(EntitySearchRecordInfo r1, c r2, RewriteQuery r3, long r4) {
            this.f12326a = r1;
            this.f12327b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // com.obric.memorydata.task.scheduler.c
        public void a(TaskInfo r12) {
            Intrinsics.checkNotNullParameter(r12, "taskInfo");
            if (Intrinsics.areEqual(r12.b(), "queryAndDownloadFinish") == false) goto L6;
            this.f12326a.setRealPackageStartTime(r12.d().optLong("task_execute"));
        L6:
            if (Intrinsics.areEqual(r12.b(), "queryAndDownloadStart") == false) goto L9;
            this.f12326a.setRealPackageQueryStartTime(r12.d().optLong("task_execute"));
        L9:
            if (r12.e().getCode() != 0) goto L11;
        L16:
            String r2 = r12.e().getOutput().optString(MediaBrowserServiceCompat.KEY_SEARCH_RESULTS).toString();
            RunLog.INSTANCE.debug("CloudGlobalIntentAssistantSearchSession", r12.b() + " result entry:" + r2);
            this.f12327b.d().append(r12.e().getOutput().optString("query_understanding_results").toString());
            List<SearchResultEntry> r3 = null;
            r3 = (List) ZeusTransformUtils.preCheckCast(u.a().fromJson(r2, new a().getType()), List.class, "com.obric.memorydata.plugin");     // Catch: JsonParseException -> L19 JsonSyntaxException -> L21
        L24:
            if (r3 != null) goto L27;
            r3 = CollectionsKt.emptyList();
        L27:
            if (Intrinsics.areEqual(r12.b(), "memory_search") == false) goto L30;
            this.f12327b.d(r3);
        L35:
            List<SearchResultEntry> r0 = this.f12327b.b(r3);
            List<SearchResultEntry> r4 = this.f12327b.c(r3);
            String r5 = this.c.getType();
            if (Intrinsics.areEqual(r5, "app_entity") == false) goto L54;
            if ((!((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L46;
            if (c.a(this.f12327b).get(this.c.getDomain()) != null) goto L42;
            c.a(this.f12327b).put(this.c.getDomain(), (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin"));
        L42:
            List r6 = (List) ZeusTransformUtils.preCheckCast(c.a(this.f12327b).get(this.c.getDomain()), List.class, "com.obric.memorydata.plugin");
            if (r6 == null) goto L46;
            r6.addAll((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin"));
        L46:
            if ((!((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L48;
        L71:
            this.f12326a.setType("global_search_intent" + this.c.getDomain());
            this.f12327b.a(this.d, this.f12326a, r12);
            this.f12327b.e().countDown();
            return;
        L48:
            if (c.b(this.f12327b).get(this.c.getDomain()) != null) goto L50;
            c.b(this.f12327b).put(this.c.getDomain(), (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin"));
        L50:
            List r1 = (List) ZeusTransformUtils.preCheckCast(c.b(this.f12327b).get(this.c.getDomain()), List.class, "com.obric.memorydata.plugin");
            if (r1 == null) goto L71;
        L52:
            r1.addAll((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin"));
            goto L71
        L54:
            if (Intrinsics.areEqual(r5, "app_entity_content") == false) goto L71;
            if ((!((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L64;
            if (c.c(this.f12327b).get(this.c.getDomain()) != null) goto L60;
            c.c(this.f12327b).put(this.c.getDomain(), (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin"));
        L60:
            List r7 = (List) ZeusTransformUtils.preCheckCast(c.c(this.f12327b).get(this.c.getDomain()), List.class, "com.obric.memorydata.plugin");
            if (r7 == null) goto L64;
            r7.addAll((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin"));
        L64:
            if ((!((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L71;
            if (c.d(this.f12327b).get(this.c.getDomain()) != null) goto L68;
            c.d(this.f12327b).put(this.c.getDomain(), (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin"));
        L68:
            r1 = (List) ZeusTransformUtils.preCheckCast(c.d(this.f12327b).get(this.c.getDomain()), List.class, "com.obric.memorydata.plugin");
            if (r1 == null) goto L71;
        L30:
            if (Intrinsics.areEqual(r12.b(), "recommend_memory_search") == false) goto L33;
            c.a(this.f12327b, r3);
            goto L35
        L33:
            if (Intrinsics.areEqual(r12.b(), "in_app_search_schedule") == false) goto L35;
            this.f12327b.a(r12.e().getOutput().optString("entry_descriptions"));
            goto L35
        L21:
            e = e;
            IRunLog r8 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
            StringBuilder r9 = new StringBuilder();
        L23:
            IRunLog.a.b(r8, "GsonExt", r9.append("toListObj error : ").append(e).toString(), null, 4, null);
        L19:
            e = e;
            r8 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
            r9 = new StringBuilder();
            goto L23
        L11:
            if (r12.c() == TaskInfo.State.SUCCEEDED) goto L16;
            if (r12.c() != TaskInfo.State.FAILED) goto L75;
            RunLog.INSTANCE.debug("CloudGlobalIntentAssistantSearchSession", "Search task execution failed, taskResult msg:" + r12.e().getMsg() + ", taskResult code:" + r12.e().getCode() + '.');
            this.f12327b.e().countDown();
            return;
        }
    }

    static {
        d = new a(null);
    }

    public c(long r15, String r17, String r18, GlobalQUResult r19, EntitySearchRecordInfo r20, int r21) {
        Intrinsics.checkNotNullParameter(r17, "userQuery");
        Intrinsics.checkNotNullParameter(r18, "queryId");
        Intrinsics.checkNotNullParameter(r19, "quResult");
        super(r15, new Bundle(), r18, r17, r20, null, 32, null);
        this.e = r15;
        this.f = r17;
        this.g = r18;
        this.h = r19;
        this.i = r20;
        this.j = r21;
        this.k = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        this.l = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        this.m = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        this.n = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        this.o = CollectionsKt.emptyList();
        this.p = CollectionsKt.emptyList();
    }

    public static final /* synthetic */ Map a(c r0) {
        return r0.k;
    }

    public static final /* synthetic */ void a(c r2, List r3) {
        r2.p = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ Map b(c r0) {
        return r0.l;
    }

    public static final /* synthetic */ Map c(c r0) {
        return r0.m;
    }

    public static final /* synthetic */ Map d(c r0) {
        return r0.n;
    }

    @Override // com.obric.memorydata.personalcontext.search.global.a
    public com.obric.memorydata.task.scheduler.c a(RewriteQuery r8, long r9, EntitySearchRecordInfo r11) {
        Intrinsics.checkNotNullParameter(r8, "rewriteQuery");
        Intrinsics.checkNotNullParameter(r11, "entitySearchRecordInfo");
        return (com.obric.memorydata.task.scheduler.c) ZeusTransformUtils.preCheckCast(new b(r11, this, r8, r9), com.obric.memorydata.task.scheduler.c.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.personalcontext.search.global.a
    public Object a(Continuation<? super GlobalQUResult> r8) {
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
        List<RewriteQuery> r10 = this.h.getQuery_rewrite();
        if (r10 == null) goto L9;
        System.currentTimeMillis();
        TaskRequest.Builder r0 = (TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder("bert_all_in_one").setExecuteImmediately(true), TaskRequest.Builder.class, "com.obric.memorydata.plugin");
        JSONObject r2 = new JSONObject();
        r2.put("qu_request", new JSONArray(ab.a().toJson(r10)));
        r2.put("lang", ac.f13156a.a());
        r2.put(Api.KEY_REGION, RegionUtil.f13145a.a().name());
        TaskResult r11 = ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(r0.setInputParam(r2), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setPriority(10), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).execute();
        if (r11.getCode() == 0) goto L7;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CloudGlobalIntentAssistantSearchSession", "bertQuResult failed, error code: " + r11.getCode() + ", error message: " + r11.getMsg(), null, 4, null);
        goto L9
    L7:
        this.h.setSlot_result(r11.getOutput().optString("qu_response"));
    L9:
        return this.h;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [T, java.util.List] */
    /* JADX WARN: Type inference failed for: r0v18, types: [T, java.util.List] */
    /* JADX WARN: Type inference failed for: r0v22, types: [T, java.util.List] */
    /* JADX WARN: Type inference failed for: r5v10, types: [T, java.util.List] */
    /* JADX WARN: Type inference failed for: r8v4, types: [T, java.util.List] */
    public final Object d(Continuation<? super GlobalAssistantIntentSearchResponse> r24) {
        c r0 = this;
        Continuation r1 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r24, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, CloudGlobalIntentAssistantSearchSession$search$1.class) == false) goto L7;
        CloudGlobalIntentAssistantSearchSession$search$1 r3 = (CloudGlobalIntentAssistantSearchSession$search$1) ZeusTransformUtils.preCheckCast(r1, CloudGlobalIntentAssistantSearchSession$search$1.class, "com.obric.memorydata.plugin");
        if ((r3.label & Integer.MIN_VALUE) == 0) goto L7;
        r3.label -= Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r3.label;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        r0 = (c) ZeusTransformUtils.preCheckCast(r3.L$0, c.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r2);
    L17:
        GlobalAssistantSearchResponse r7 = (GlobalAssistantSearchResponse) ZeusTransformUtils.preCheckCast(r2, GlobalAssistantSearchResponse.class, "com.obric.memorydata.plugin");
        List<SearchResultEntry> r6 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        if ((!r0.k.isEmpty()) == false) goto L20;
    L21:
        r6.addAll((Collection) ZeusTransformUtils.preCheckCast(com.obric.memorydata.personalcontext.search.c.f12306a.a(r0.k, r0.l, r0.i()), Collection.class, "com.obric.memorydata.plugin"));
    L22:
        List<SearchResultEntry> r8 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        if ((!r0.m.isEmpty()) == false) goto L25;
    L26:
        r8.addAll((Collection) ZeusTransformUtils.preCheckCast(com.obric.memorydata.personalcontext.search.c.f12306a.a(r0.m, r0.n, r0.i()), Collection.class, "com.obric.memorydata.plugin"));
    L28:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L30;
        List<AppEntity> r9 = com.obric.memorydata.personalcontext.search.g.INSTANCE.loadAppEntitiesBySearchResultEntries(r6, r0.g());
    L31:
        Ref.ObjectRef r10 = new Ref.ObjectRef();
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L34;
        T r11 = com.obric.memorydata.personalcontext.search.g.INSTANCE.loadAppEntitiesBySearchResultEntries(r8, r0.g());
    L35:
        r10.element = r11;
        Ref.ObjectRef r12 = new Ref.ObjectRef();
        r12.element = com.obric.memorydata.personalcontext.search.g.INSTANCE.loadMemoryEntityBySearchResultEntry(r0.o);
        Ref.ObjectRef r13 = new Ref.ObjectRef();
        r13.element = r0.a(r0.p);
        if (r0.j <= 0) goto L70;
        int r14 = r0.i();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CloudGlobalIntentAssistantSearchSession", "here is specific limit count: " + r14, false, 4, null);
        if ((((r9.size() + ((List) ZeusTransformUtils.preCheckCast(r10.element, List.class, "com.obric.memorydata.plugin")).size()) + ((List) ZeusTransformUtils.preCheckCast(r12.element, List.class, "com.obric.memorydata.plugin")).size()) + ((List) ZeusTransformUtils.preCheckCast(r13.element, List.class, "com.obric.memorydata.plugin")).size()) > r14) goto L40;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CloudGlobalIntentAssistantSearchSession", "total result count is matched", false, 4, null);
        goto L70
    L40:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CloudGlobalIntentAssistantSearchSession", "total result count is not matched", false, 4, null);
        int r15 = r14 / 4;
        int r16 = r14 % 4;
        if (r16 < 1) goto L43;
        int r17 = 1;
    L44:
        int r18 = Math.min(r17 + r15, r9.size());
        if (r16 < 2) goto L47;
        int r19 = 1;
    L48:
        int r110 = Math.min(r19 + r15, ((List) ZeusTransformUtils.preCheckCast(r10.element, List.class, "com.obric.memorydata.plugin")).size());
        if (r16 < 3) goto L51;
        int r20 = 1;
    L52:
        int r21 = Math.min(r20 + r15, ((List) ZeusTransformUtils.preCheckCast(r12.element, List.class, "com.obric.memorydata.plugin")).size());
        int r22 = Math.min(r15, ((List) ZeusTransformUtils.preCheckCast(r13.element, List.class, "com.obric.memorydata.plugin")).size());
        int r23 = r14 - (((r18 + r110) + r21) + r22);
        if (r23 > 0) goto L55;
    L57:
        if (r23 > 0) goto L59;
    L61:
        if (r23 > 0) goto L63;
    L65:
        if (r23 > 0) goto L67;
    L69:
        r9 = CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin"), r18);
        r10.element = CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast(r10.element, Iterable.class, "com.obric.memorydata.plugin"), r110);
        r12.element = CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast(r12.element, Iterable.class, "com.obric.memorydata.plugin"), r21);
        r13.element = CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast(r13.element, Iterable.class, "com.obric.memorydata.plugin"), r22);
        goto L70
    L67:
        if (r22 >= ((List) ZeusTransformUtils.preCheckCast(r13.element, List.class, "com.obric.memorydata.plugin")).size()) goto L69;
        r22 = r22 + Math.min(r23, ((List) ZeusTransformUtils.preCheckCast(r13.element, List.class, "com.obric.memorydata.plugin")).size() - r22);
        goto L69
    L63:
        if (r21 >= ((List) ZeusTransformUtils.preCheckCast(r12.element, List.class, "com.obric.memorydata.plugin")).size()) goto L65;
        int r111 = Math.min(r23, ((List) ZeusTransformUtils.preCheckCast(r12.element, List.class, "com.obric.memorydata.plugin")).size() - r21);
        r23 = r23 - r111;
        r21 = r21 + r111;
        goto L65
    L59:
        if (r110 >= ((List) ZeusTransformUtils.preCheckCast(r10.element, List.class, "com.obric.memorydata.plugin")).size()) goto L61;
        int r112 = Math.min(r23, ((List) ZeusTransformUtils.preCheckCast(r10.element, List.class, "com.obric.memorydata.plugin")).size() - r110);
        r23 = r23 - r112;
        r110 = r110 + r112;
        goto L61
    L55:
        if (r18 >= r9.size()) goto L57;
        int r113 = Math.min(r23, r9.size() - r18);
        r23 = r23 - r113;
        r18 = r18 + r113;
        goto L57
    L51:
        r20 = 0;
        goto L52
    L47:
        r19 = 0;
        goto L48
    L43:
        r17 = 0;
    L70:
        int r25 = r7.getCode();
        String r114 = r7.getMessage();
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L73;
        SearchResponse r26 = new SearchResponse(r7.getCode(), r7.getMessage(), new SearchResult(r9, null));
    L74:
        GlobalAssistantSearchResponse r27 = GlobalAssistantSearchResponse.copy$default(r7, 0, null, null, null, null, null, null, null, 255, null);
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r10.element, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L78;
        r27.setEntityResult(new GlobalAssistantSearchEntityResult((List) ZeusTransformUtils.preCheckCast(r10.element, List.class, "com.obric.memorydata.plugin"), 0, 2, null));
    L78:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r12.element, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L80;
        r27.setMemoryResult(new GlobalAssistantSearchMemoryResult((List) ZeusTransformUtils.preCheckCast(r12.element, List.class, "com.obric.memorydata.plugin")));
    L80:
        r27.setProactiveRecommendationResult(new ProactiveRecommendationSearchResult(CollectionsKt.emptyList(), (List) ZeusTransformUtils.preCheckCast(r13.element, List.class, "com.obric.memorydata.plugin")));
        Unit r28 = Unit.INSTANCE;
        return new GlobalAssistantIntentSearchResponse(r25, r114, r26, r27);
    L73:
        r26 = null;
        goto L74
    L34:
        r11 = CollectionsKt.emptyList();
        goto L35
    L30:
        r9 = CollectionsKt.emptyList();
        goto L31
    L25:
        if ((!r0.n.isEmpty()) == false) goto L28;
    L20:
        if ((!r0.l.isEmpty()) == false) goto L22;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r2);
        r3.L$0 = r0;
        r3.label = 1;
        r2 = super.b(r3);
        if (r2 != r4) goto L17;
        return r4;
    L7:
        r3 = new CloudGlobalIntentAssistantSearchSession$search$1(r0, r1);
        goto L8
    }

    public final void d(List<SearchResultEntry> r3) {
        List<SearchResultEntry> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.o = r4;
    }

    @Override // com.obric.memorydata.personalcontext.search.global.a
    public int i() {
        int r1 = this.j;
        if (r1 <= 0) goto L6;
        if (r1 >= 50) goto L6;
        return r1;
    L6:
        return 50;
    }

    @Override // com.obric.memorydata.personalcontext.search.global.a
    public boolean j() {
        return false;
    }
}
