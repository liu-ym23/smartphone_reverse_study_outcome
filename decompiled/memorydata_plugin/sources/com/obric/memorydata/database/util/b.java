package com.obric.memorydata.database.util;

import android.util.Log;
import androidx.room.util.TableInfo;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.database.entity.hb;
import com.obric.memorydata.database.index.EntityIndexRecordInfo;
import com.obric.memorydata.database.index.ah;
import com.obric.memorydata.database.index.ak;
import com.obric.memorydata.database.model.EntitySearchRecordInfo;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.bdtracker.Tracker;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.utils.threadpool.ThreadPoolContainer;
import com.obric.memorydata.utils.u;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b=\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010 \n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020\u00052\u0006\u0010L\u001a\u00020\u00052\u0006\u0010M\u001a\u00020\u00052\u0006\u0010N\u001a\u00020CJ\u0010\u0010O\u001a\u00020J2\b\u0010P\u001a\u0004\u0018\u00010QJ\u0006\u0010S\u001a\u00020TJ\u0006\u0010U\u001a\u00020JJ\u0018\u0010V\u001a\u00020J2\b\u0010P\u001a\u0004\u0018\u00010W2\u0006\u0010X\u001a\u00020YJ\"\u0010Z\u001a\u00020J2\b\u0010[\u001a\u0004\u0018\u00010\\2\u0006\u0010]\u001a\u00020\u00052\b\b\u0002\u0010^\u001a\u00020\u0005J\u0016\u0010_\u001a\u00020J2\u0006\u0010`\u001a\u00020\u00052\u0006\u0010a\u001a\u00020bJ\u0010\u0010c\u001a\u0004\u0018\u00010W2\u0006\u0010X\u001a\u00020YJ \u0010c\u001a\u0004\u0018\u00010W2\u0006\u0010L\u001a\u00020b2\u0006\u0010d\u001a\u00020\u00052\u0006\u0010e\u001a\u00020\u0005J\u0010\u0010f\u001a\u00020J2\b\u0010P\u001a\u0004\u0018\u00010WJ\u001e\u0010g\u001a\u00020J2\u0006\u0010e\u001a\u00020\u00052\u0006\u0010L\u001a\u00020\u00052\u0006\u0010d\u001a\u00020\u0005J\u000e\u0010h\u001a\u00020J2\u0006\u0010`\u001a\u00020\u0005J\u000e\u0010i\u001a\u00020J2\u0006\u0010`\u001a\u00020\u0005J\b\u0010j\u001a\u00020JH\u0002J\u0010\u0010k\u001a\u00020C2\b\u0010`\u001a\u0004\u0018\u00010\u0005J\u0006\u0010l\u001a\u00020JJ\u0010\u0010m\u001a\u00020J2\u0006\u0010n\u001a\u00020\u0005H\u0002J \u0010o\u001a\u00020\u00052\u0006\u0010e\u001a\u00020\u00052\u0006\u0010d\u001a\u00020\u00052\u0006\u0010L\u001a\u00020\u0005H\u0002J \u0010p\u001a\u00020J2\u0006\u0010q\u001a\u00020\u00052\u0006\u0010r\u001a\u00020\\2\u0006\u0010s\u001a\u00020\\H\u0016J\u001e\u0010t\u001a\b\u0012\u0004\u0012\u00020\\0u2\u0006\u0010q\u001a\u00020\u00052\u0006\u0010s\u001a\u00020\\H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0012\u0010B\u001a\u0004\u0018\u00010CX\u0082\u000e¢\u0006\u0004\n\u0002\u0010DR\u0012\u0010E\u001a\u0004\u0018\u00010CX\u0082\u000e¢\u0006\u0004\n\u0002\u0010DR\u0012\u0010F\u001a\u0004\u0018\u00010CX\u0082\u000e¢\u0006\u0004\n\u0002\u0010DR\u000e\u0010G\u001a\u00020HX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006v"}, d2 = {"Lcom/obric/memorydata/database/util/EntityTeaEventTracker;", "Lcom/obric/memorydata/middleware/api/bdtracker/ReportEventRejectedHandler;", "<init>", "()V", "TAG", "", "ENTITY_INDEX_EVENT_ID", "ENTITY_SEARCH_EVENT_ID", "REACT_SEARCH_EVENT_ID", "COMMON_GLOBAL_SEARCH_EVENT_ID", "INSERT_COPILOT_TEXT_FAILED_EVENT_ID", "ENTITY_INDEX_FAILED_EVENT_ID", "TEXT_EMBEDDING_INDEX_ID", "ENTITY_INDEX_TASK_COST", "TEXT_EMBEDDING_INDEX_COST", "IMAGE_EMBEDDING_INDEX_ID", "IMAGE_EMBEDDING_INDEX_COST", "VIDEO_EMBEDDING_INDEX_ID", "VIDEO_EMBEDDING_INDEX_COST", "VIDEO_FRAME_EMBEDDING_INDEX_ID", "VIDEO_FRAME_EMBEDDING_INDEX_COST", "CAPTION_INDEX_ID", "CAPTION_INDEX_COST", "OCR_INDEX_ID", "OCR_INDEX_COST", "REACT_SEARCH_BUSINESS_FOR_MEMORY", "REACT_SEARCH_BUSINESS_FOR_USER_PROFILE", "REACT_SEARCH_BUSINESS_FOR_DOUBAO_PC", "REACT_SEARCH_BUSINESS_FOR_PROACTIVE_REC", "QUERY_PACKAGE_NAME", "QUERY_TYPE", "QUERY_TASK_UUID", "QUERY_STAGE_QUERY_UNDERSTANDING_COST", "QUERY_STAGE_SEARCH_PARAM_PREPARE_COST", "QUERY_STAGE_TASK_EXECUTE_COST", "QUERY_STAGE_RESULT_HANDLE_COST", "QUERY_QU_COST", "QUERY_SQL_COST", "QUERY_KEYWORD_INDEX_COST", "QUERY_TEXT_EMBEDDING_COST", "QUERY_IMAGE_EMBEDDING_COST", "QUERY_PACKAGE_EXECUTE_COST", "QUERY_PACKAGE_PURE_EXECUTE_COST", "QUERY_PACKAGE_QUERY_EXECUTE_COST", "QUERY_PACKAGE_FINISH_EXECUTE_COST", "QUERY_RANKING_COST", "QUERY_TASK_EXECUTE_COST", "QUERY_LOAD_RESULT_COST", "KG_QUERY_COST", "QUERY_TOTAL_COST", "CALL_TYPE", "IS_IN_APP_OPTIMIZED_SEARCH", "FIRST_BATCH_RESULT_COST", "GRAPH_EXECUTE_COST", "BUILD_GRAPH_COST", "SORT_AND_FILTER_COST", "NOTIFY_SEARCH_RESULT_COST", "INDEX_PACKAGE_NAME", "INDEX_ENTITY_COUNT", "INDEX_ENTITY_ID", "INDEX_ENTITY_TYPE", "INDEX_PHOTO_ASSIST_TYPE", "INDEX_PERF_EVENT_VERSION", "FAST_INDEX_TASK_RUNNING_DURATION_KEY", "SLOW_INDEX_TASK_RUNNING_DURATION_KEY", "SUM_INDEX_TASK_RUNNING_DURATION_KEY", "fastIndexTaskStartTimeStamp", "", "Ljava/lang/Long;", "slowIndexTaskStartTimeStamp", "sumIndexTaskStartTimeStamp", "indexTaskDurationLock", "", "trackEmbedding", "", "eventID", "entityType", "key", "cost", "trackQuery", "recordInfo", "Lcom/obric/memorydata/database/model/EntitySearchRecordInfo;", "KEY_AUTO_EVALUATION_PREPARED", "isAutoEvaluationMode", "", "registerReportEventRejectedHandler", "trackIndex", "Lcom/obric/memorydata/database/index/EntityIndexRecordInfo;", "appEntity", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", "trackReAct", "perJson", "Lorg/json/JSONObject;", "searchBusiness", "meta", "trackCommonGlobalSearch", "taskName", "code", "", "restoreIndexRecordInfo", "entityId", ObricMemoryConstants.KEY_PACKAGE_NAME, "storeIndexRecordInfo", "clearIndexRecordInfo", "onIndexTaskStart", "onIndexTaskFinish", "updateSumIndexTaskDuration", "getCurrentIndexTaskDuration", "clearIndexTaskDuration", "logEvent", Params.CONTENT, "getIndexStoreKey", "onEventRejected", "eventName", "eventParams", "mergeJson", "onEventReport", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b implements com.obric.memorydata.middleware.api.bdtracker.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f9624a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile Long f9625b;
    private static volatile Long c;
    private static volatile Long d;
    private static Object e;

    static {
        f9624a = new b();
        e = new Object();
    }

    private b() {
    }

    public static /* synthetic */ void a(b r0, JSONObject r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = "";
    L5:
        r0.a(r1, r2, r3);
    }

    private final String b(String r2, String r3, String r4) {
        return TableInfo.Index.DEFAULT_PREFIX + r2 + '_' + r4 + '_' + r3;
    }

    private static final void b(EntitySearchRecordInfo r4) {
        if (r4 == null) goto L7;
        JSONObject r0 = new JSONObject();
        r0.put("queryTaskUUID", r4.getTaskUUID());
        r0.put(ObricMemoryConstants.KEY_PACKAGE_NAME, r4.getPackageName());
        r0.put("queryType", r4.getType());
        r0.put("stageQueryUnderstandingCost", r4.getStageQueryUnderstandingCost());
        r0.put("stageSearchParamPrepareCost", r4.getStageSearchParamPrepareCost());
        r0.put("stageTaskExecuteCost", r4.getStageTaskExecuteCost());
        r0.put("stageResultHandleCost", r4.getStageResultHandleCost());
        r0.put("queryUnderstandingCost", r4.getQueryUnderstandingCost());
        r0.put("sqlQueryCost", r4.getSqlQueryCost());
        r0.put("keywordQueryCost", r4.getKeywordQueryCost());
        r0.put("textVectorQueryCost", r4.getTextVectorQueryCost());
        r0.put("imageVectorQueryCost", r4.getImageVectorQueryCost());
        r0.put("queryPackageCost", r4.getPackageExecuteCost());
        r0.put("queryPurePackageCost", r4.getPackagePureExecuteCost());
        r0.put("queryPackageQueryCost", r4.getPackageQueryExecuteCost());
        r0.put("queryPackageFinishCost", r4.getPackageExecuteFinishCost());
        r0.put("taskExecuteCost", r4.getTaskExecuteCost());
        r0.put("rankingCost", r4.getRankingCost());
        r0.put("loadResultCost", r4.getLoadResultCost());
        r0.put("kgQueryCost", r4.getKgQueryCost());
        r0.put("callType", r4.getSearchCallType());
        r0.put("graphExecuteCost", r4.getGraphExecuteCost());
        r0.put("buildGraphCost", r4.getBuildGraphCost());
        r0.put("sortAndFilterCost", r4.getSortAndFilterCost());
        r0.put("notifySearchResultCost", r4.getNotifySearchResultCost());
        r0.put("isInAppOptimizedSearch", r4.isInAppOptimizedSearch());
        r0.put("firstBatchResultCost", r4.getFirstBatchResultCost());
        r0.put("queryTotalCost", r4.getQueryTotalCost());
        b r5 = f9624a;
        String r1 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r1, "toString(...)");
        r5.d(r1);
        if (r5.a() == true) goto L8;
        Tracker.INSTANCE.reportEvent("entity_search_perf_event", r0);
        return;
    L8:
        return;
    }

    private final void d() {
        Object r12 = e;
        monitor-enter(r12);
        Long r0 = d;     // Catch: Throwable -> L10
        if (r0 == null) goto L7;
        long r2 = ((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.memorydata.plugin")).longValue();     // Catch: Throwable -> L10
        long r4 = Math.max(0, System.currentTimeMillis() - r2);     // Catch: Throwable -> L10
        long r6 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getLong("sum_index_task_running_duration", 0) + r4;     // Catch: Throwable -> L10
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).save("sum_index_task_running_duration", r6);     // Catch: Throwable -> L10
        RunLog.INSTANCE.debug("EntitySearchTracker", "sumIndexTaskStartTimeStamp: " + r2 + ", costTime: " + r4 + ", newDuration: " + r6);     // Catch: Throwable -> L10
    L7:
        d = null;     // Catch: Throwable -> L10
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r12);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private final void d(String r3) {
        String r2 = com.bytedance.common.utility.b.c.a("persist.memory.test");
        if (r2 != null) goto L5;
    L7:
        RunLog.INSTANCE.debug("EntitySearchTracker", r3);
        return;
    L5:
        if (Intrinsics.areEqual(r2, "test") == false) goto L7;
        Log.i("EntitySearchTracker", r3);
        goto L7
    }

    /* JADX INFO: renamed from: lambda$gdmWQ-pGGgmy9q9_tH2mQ4Eujrc, reason: not valid java name */
    public static /* synthetic */ void m574lambda$gdmWQpGGgmy9q9_tH2mQ4Eujrc(EntitySearchRecordInfo r0) {
        b(r0);
    }

    public final EntityIndexRecordInfo a(com.obric.memorydata.database.entity.d r12) {
        Intrinsics.checkNotNullParameter(r12, "appEntity");
        Object r4 = null;
        String r11 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getString(b(r12.getPackageName(), r12.getEntityId(), String.valueOf(r12.getType())));
        r4 = u.a().fromJson(r11, EntityIndexRecordInfo.class);     // Catch: Exception -> L5
    L8:
        return (EntityIndexRecordInfo) ZeusTransformUtils.preCheckCast(r4, EntityIndexRecordInfo.class, "com.obric.memorydata.plugin");
    L5:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GsonExt", "convert content: " + r11 + " toObj error : " + e, null, 4, null);
        goto L8
    }

    @Override // com.obric.memorydata.middleware.api.bdtracker.b
    public List<JSONObject> a(String r18, JSONObject r19) {
        JSONObject r1 = r19;
        Intrinsics.checkNotNullParameter(r18, "eventName");
        Intrinsics.checkNotNullParameter(r1, "mergeJson");
        if (Intrinsics.areEqual(r18, "entity_index_dashboard_latency") == false) goto L7;
        return ah.f9339a.a(r1);
    L7:
        if (Intrinsics.areEqual(r18, "entity_index_perf_event") == false) goto L30;
        String r3 = "com.obric.memorydata.plugin";
        List<JSONObject> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator<String> r2 = r19.keys();
    L10:
        if (r2.hasNext() == false) goto L28;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, r3);
        JSONObject r5 = r1.optJSONObject(r4);
        if (r5 == null) goto L10;
        Iterator<String> r6 = r5.keys();
    L16:
        if (r6.hasNext() == false) goto L27;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, r3);
        JSONObject r8 = r5.optJSONObject(r7);
        if (r8 == null) goto L16;
        long r12 = r8.optLong(CommonConsts.COUNT_TYPE, 0);
        if (r12 <= 0) goto L16;
        long r15 = r8.optLong(EntityIndexRecordInfo.TOTAL_INDEX_COST_KEY, 0);
        Iterator<String> r110 = r2;
        String r17 = r3;
        long r10 = r8.optLong(EntityIndexRecordInfo.ACTUAL_TOTAL_INDEX_COST_KEY, 0) / r12;
        JSONObject r9 = new JSONObject();
        r9.put(ObricMemoryConstants.KEY_PACKAGE_NAME, r7);
        r9.put("entityType", r4);
        r9.put(CommonConsts.COUNT_TYPE, r12);
        r9.put(EntityIndexRecordInfo.TOTAL_INDEX_COST_KEY, r15 / r12);
        r9.put(EntityIndexRecordInfo.ACTUAL_TOTAL_INDEX_COST_KEY, r10);
        r9.put("entity_index_perf_event_version", 2);
        if (Intrinsics.areEqual(r4, "301_VIDEO") == false) goto L26;
        r9.put("assetType", "VIDEO");
        r9.put("entityType", "301");
    L26:
        r0.add(r9);
        r3 = r17;
        r2 = r110;
        goto L16
    L27:
        r1 = r19;
        goto L10
    L28:
        return r0;
    L30:
        return CollectionsKt.emptyList();
    }

    public final void a(EntityIndexRecordInfo r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        String r5 = b(r6.getPackageName(), r6.getEntityId(), r6.getEntityType());
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).save(r5, u.a(r6));
    }

    public final void a(EntityIndexRecordInfo r4, com.obric.memorydata.database.entity.d r5) {
        Intrinsics.checkNotNullParameter(r5, "appEntity");
        if (r4 == null) goto L16;
        b r3 = f9624a;
        r3.a(r4.getPackageName(), r4.getEntityType(), r4.getEntityId());
        JSONObject r0 = new JSONObject();
        r0.put(ObricMemoryConstants.KEY_PACKAGE_NAME, r4.getPackageName());
        r0.put("entityId", r4.getEntityId());
        r0.put("entityType", r4.getEntityType());
        r0.put("entity_index_perf_event_version", 2);
        if (r4.fillTotalIndexCost(r0) == true) goto L8;
        return;
    L8:
        if (ZeusTransformUtils.instanceOf(r5, hb.class) == true) goto L10;
    L12:
        RunLog.INSTANCE.debug("EntitySearchTracker", "trackIndex: " + r0);
        if (r3.a() == true) goto L17;
        Tracker.INSTANCE.reportEvent("entity_index_perf_event", r0);
        return;
    L17:
        return;
    L10:
        if (Intrinsics.areEqual(((hb) ZeusTransformUtils.preCheckCast(r5, hb.class, "com.obric.memorydata.plugin")).b(), "VIDEO") == false) goto L12;
        r0.put("assetType", "VIDEO");
        goto L12
    }

    public final void a(final EntitySearchRecordInfo r2) {
        ThreadPoolContainer.Companion.execute(new $$Lambda$b$gdmWQpGGgmy9q9_tH2mQ4Eujrc(r2));
    }

    public final void a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "taskName");
        ak.f9361a.c();
        Object r3 = e;
        monitor-enter(r3);
        long r0 = System.currentTimeMillis();     // Catch: Throwable -> L18
        if (Intrinsics.areEqual(r4, com.obric.memorydata.database.entity.d.SLOW_INDEX_TASK_NAME) == false) goto L11;
        c = Long.valueOf(r0);     // Catch: Throwable -> L18
        if (d != null) goto L15;
        Long r5 = Long.valueOf(r0);     // Catch: Throwable -> L18
    L9:
        d = r5;     // Catch: Throwable -> L18
    L15:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(r3);
        return;
    L11:
        if (Intrinsics.areEqual(r4, com.obric.memorydata.database.entity.d.FAST_INDEX_TASK_NAME) == false) goto L15;
        f9625b = Long.valueOf(r0);     // Catch: Throwable -> L18
        if (d != null) goto L15;
        r5 = Long.valueOf(r0);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    public final void a(String r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "taskName");
        JSONObject r1 = new JSONObject();
        r1.put("code", r5);
        r1.put("taskName", r4);
        String r6 = r1.toString();
        Intrinsics.checkNotNullExpressionValue(r6, "toString(...)");
        d(r6);
        if (a() == true) goto L6;
        Tracker.INSTANCE.reportEvent("common_global_search_perf_event", r1);
        return;
    }

    public final void a(String r6, String r7, String r8) {
        Intrinsics.checkNotNullParameter(r6, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r7, "entityType");
        Intrinsics.checkNotNullParameter(r8, "entityId");
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).remove(new String[]{b(r6, r8, r7)});
    }

    public final void a(String r3, String r4, String r5, long r6) {
        Intrinsics.checkNotNullParameter(r3, "eventID");
        Intrinsics.checkNotNullParameter(r4, "entityType");
        Intrinsics.checkNotNullParameter(r5, "key");
        JSONObject r1 = new JSONObject();
        r1.put(r5, r6);
        r1.put("entityType", r4);
        d(r3 + '_' + r1);
        Tracker.INSTANCE.reportEvent(r3, r1);
    }

    @Override // com.obric.memorydata.middleware.api.bdtracker.b
    public void a(String r9, JSONObject r10, JSONObject r11) {
        Intrinsics.checkNotNullParameter(r9, "eventName");
        Intrinsics.checkNotNullParameter(r10, "eventParams");
        Intrinsics.checkNotNullParameter(r11, "mergeJson");
        if (Intrinsics.areEqual(r9, "entity_index_dashboard_latency") == false) goto L6;
        ah.f9339a.a(r10, r11);
        return;
    L6:
        if (Intrinsics.areEqual(r9, "entity_index_perf_event") == false) goto L19;
        boolean r8 = Intrinsics.areEqual(r10.optString("assetType", ""), "VIDEO");
        String r0 = r10.optString("entityType", "0");
        if (r8 == false) goto L10;
        r0 = "301_VIDEO";
    L10:
        String r12 = r10.optString(ObricMemoryConstants.KEY_PACKAGE_NAME, "");
        JSONObject r13 = r11.optJSONObject(r0);
        if (r13 != null) goto L13;
        r13 = new JSONObject();
        r11.put(r0, r13);
    L13:
        JSONObject r14 = r13.optJSONObject(r12);
        if (r14 != null) goto L16;
        r14 = new JSONObject();
        r13.put(r12, r14);
    L16:
        r14.put(CommonConsts.COUNT_TYPE, r14.optLong(CommonConsts.COUNT_TYPE, 0) + 1);
        long r2 = r14.optLong(EntityIndexRecordInfo.TOTAL_INDEX_COST_KEY, 0);
        long r4 = r14.optLong(EntityIndexRecordInfo.ACTUAL_TOTAL_INDEX_COST_KEY, 0);
        long r6 = r10.optLong(EntityIndexRecordInfo.TOTAL_INDEX_COST_KEY, 0);
        long r5 = r4 + r10.optLong(EntityIndexRecordInfo.ACTUAL_TOTAL_INDEX_COST_KEY, 0);
        r14.put(EntityIndexRecordInfo.TOTAL_INDEX_COST_KEY, r2 + r6);
        r14.put(EntityIndexRecordInfo.ACTUAL_TOTAL_INDEX_COST_KEY, r5);
        return;
    }

    public final void a(JSONObject r12, String r13, String r14) {
        Intrinsics.checkNotNullParameter(r13, "searchBusiness");
        Intrinsics.checkNotNullParameter(r14, "meta");
        IRunLog r5 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r2 = new StringBuilder().append("perJson is null ");
        if (r12 != null) goto L5;
        boolean r3 = true;
    L6:
        IRunLog.a.a(r5, "EntitySearchTracker", r2.append(r3).toString(), false, 4, null);
        if (r12 != null) goto L9;
        return;
    L9:
        r12.put("searchBusiness", r13);
        r12.put("meta", r14);
        String r15 = r12.toString();
        Intrinsics.checkNotNullExpressionValue(r15, "toString(...)");
        d(r15);
        if (a() == true) goto L13;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntitySearchTracker", "trackReAct " + r12, false, 4, null);
        Tracker.INSTANCE.reportEvent("react_perf_event", r12);
        return;
    L13:
        return;
    L5:
        r3 = false;
        goto L6
    }

    public final boolean a() {
        if (AppContext.INSTANCE.isDebug() == true) goto L5;
        return false;
    L5:
        return IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getBoolean("is_personal_context_evaluation_prepared", false);
    }

    public final void b() {
        Tracker.INSTANCE.registerReportEventRejectedHandler("entity_index_perf_event", (com.obric.memorydata.middleware.api.bdtracker.b) ZeusTransformUtils.preCheckCast(this, com.obric.memorydata.middleware.api.bdtracker.b.class, "com.obric.memorydata.plugin"));
        ah.f9339a.a((com.obric.memorydata.middleware.api.bdtracker.b) ZeusTransformUtils.preCheckCast(this, com.obric.memorydata.middleware.api.bdtracker.b.class, "com.obric.memorydata.plugin"));
        ak.f9361a.b();
    }

    public final void b(String r14) {
        Intrinsics.checkNotNullParameter(r14, "taskName");
        Object r13 = e;
        monitor-enter(r13);
    L23:
        th = move-exception;
        throw th;
    L5:
        if (Intrinsics.areEqual(r14, com.obric.memorydata.database.entity.d.SLOW_INDEX_TASK_NAME) == false) goto L13;
        Long r15 = c;     // Catch: Throwable -> L23
        if (r15 == null) goto L9;
        long r6 = ((Number) ZeusTransformUtils.preCheckCast(r15, Number.class, "com.obric.memorydata.plugin")).longValue();     // Catch: Throwable -> L23
        long r8 = Math.max(0, System.currentTimeMillis() - r6);     // Catch: Throwable -> L23
        long r10 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getLong("slow_index_task_running_duration", 0) + r8;     // Catch: Throwable -> L23
        long r3 = Math.max(0, r10);     // Catch: Throwable -> L23
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).save("slow_index_task_running_duration", r10);     // Catch: Throwable -> L23
        RunLog.INSTANCE.debug("EntitySearchTracker", "slowIndexTaskStartTimeStamp: " + r6 + ", duration: " + r8 + ", newDuration: " + r3);     // Catch: Throwable -> L23
    L9:
        b r16 = f9624a;     // Catch: Throwable -> L23
        c = null;     // Catch: Throwable -> L23
        if (f9625b != null) goto L20;
    L11:
        r16.d();     // Catch: Throwable -> L23
    L20:
        Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L23
        monitor-exit(r13);
        return;
    L13:
        if (Intrinsics.areEqual(r14, com.obric.memorydata.database.entity.d.FAST_INDEX_TASK_NAME) == false) goto L20;
        Long r18 = f9625b;     // Catch: Throwable -> L23
        if (r18 == null) goto L17;
        long r7 = ((Number) ZeusTransformUtils.preCheckCast(r18, Number.class, "com.obric.memorydata.plugin")).longValue();     // Catch: Throwable -> L23
        long r9 = Math.max(0, System.currentTimeMillis() - r7);     // Catch: Throwable -> L23
        long r11 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getLong("fast_index_task_running_duration", 0) + r9;     // Catch: Throwable -> L23
        long r4 = Math.max(0, r11);     // Catch: Throwable -> L23
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).save("fast_index_task_running_duration", r11);     // Catch: Throwable -> L23
        RunLog.INSTANCE.debug("EntitySearchTracker", "fastIndexTaskStartTimeStamp: " + r7 + ", duration: " + r9 + ", newDuration: " + r4);     // Catch: Throwable -> L23
    L17:
        r16 = f9624a;     // Catch: Throwable -> L23
        f9625b = null;     // Catch: Throwable -> L23
        if (c != null) goto L20;
        goto L20
    }

    public final long c(String r9) {
        Object r8 = e;
        monitor-enter(r8);
        long r4 = 0;
        if (Intrinsics.areEqual(r9, com.obric.memorydata.database.entity.d.SLOW_INDEX_TASK_NAME) == false) goto L14;
        long r0 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getLong("slow_index_task_running_duration", 0);     // Catch: Throwable -> L22
        Long r10 = c;     // Catch: Throwable -> L22
        if (r10 == null) goto L10;
        long r2 = ((Number) ZeusTransformUtils.preCheckCast(r10, Number.class, "com.obric.memorydata.plugin")).longValue();     // Catch: Throwable -> L22
        long r6 = System.currentTimeMillis();     // Catch: Throwable -> L22
    L9:
        r4 = Math.max(0, r6 - r2);     // Catch: Throwable -> L22
    L10:
        long r1 = r0 + r4;
        monitor-exit(r8);
        return r1;
    L14:
        if (Intrinsics.areEqual(r9, com.obric.memorydata.database.entity.d.FAST_INDEX_TASK_NAME) == false) goto L18;
        r0 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getLong("fast_index_task_running_duration", 0);     // Catch: Throwable -> L22
        Long r11 = f9625b;     // Catch: Throwable -> L22
        if (r11 == null) goto L10;
        r2 = ((Number) ZeusTransformUtils.preCheckCast(r11, Number.class, "com.obric.memorydata.plugin")).longValue();     // Catch: Throwable -> L22
        r6 = System.currentTimeMillis();     // Catch: Throwable -> L22
        goto L9
    L18:
        r0 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getLong("sum_index_task_running_duration", 0);     // Catch: Throwable -> L22
        Long r12 = d;     // Catch: Throwable -> L22
        if (r12 == null) goto L10;
        r2 = ((Number) ZeusTransformUtils.preCheckCast(r12, Number.class, "com.obric.memorydata.plugin")).longValue();     // Catch: Throwable -> L22
        r6 = System.currentTimeMillis();     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }

    public final void c() {
        Object r6 = e;
        monitor-enter(r6);
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).remove(new String[]{"fast_index_task_running_duration"});     // Catch: Throwable -> L7
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).remove(new String[]{"slow_index_task_running_duration"});     // Catch: Throwable -> L7
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).remove(new String[]{"sum_index_task_running_duration"});     // Catch: Throwable -> L7
        monitor-exit(r6);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
