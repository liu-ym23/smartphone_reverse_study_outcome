package com.obric.memorydata.personalcontext.bridge;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.aikernel.phx.sdk.AIKernelManager;
import com.obric.aikernel.phx.sdk.IAIKernelManager;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.data.PackageResource;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.cae.userAware.WifiScanStateMachine;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.EntityClassData;
import com.obric.capabilitykit.entity.app.EntityType;
import com.obric.capabilitykit.entity.app.ScheduleEntity;
import com.obric.memorydata.aikernelcore.AIKernelRunModelException;
import com.obric.memorydata.aikernelcore.utils.DataConvert;
import com.obric.memorydata.annotation.ChunkType;
import com.obric.memorydata.database.account_split.v;
import com.obric.memorydata.database.dao.IAppEntityContentTimeDao;
import com.obric.memorydata.database.dao.IAppEntityRawDbDao;
import com.obric.memorydata.database.dao.IAppEntityVectorCopilotDao;
import com.obric.memorydata.database.dao.IndexPendingDao;
import com.obric.memorydata.database.dao.MetaFullContentKeywordCopilotDao;
import com.obric.memorydata.database.dao.SemanticTextCopilotDao;
import com.obric.memorydata.database.dao.VideoFrameRawDbDao;
import com.obric.memorydata.database.entity.cd;
import com.obric.memorydata.database.entity.dl;
import com.obric.memorydata.database.entity.hb;
import com.obric.memorydata.database.entity.hr;
import com.obric.memorydata.database.entity.il;
import com.obric.memorydata.database.index.EntityIndexEngine;
import com.obric.memorydata.database.index.EntityIndexRecordInfo;
import com.obric.memorydata.database.index.IndexTaskCostInfo;
import com.obric.memorydata.database.index.ao;
import com.obric.memorydata.database.index.ax;
import com.obric.memorydata.database.index.s;
import com.obric.memorydata.database.index.t;
import com.obric.memorydata.database.index.u;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.database.manager.PersonalMemoryFrameDb;
import com.obric.memorydata.database.model.CommonTextSearchDocument;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.bdtracker.Tracker;
import com.obric.memorydata.middleware.api.bridge.IAppEntityIndexBridgeAPI;
import com.obric.memorydata.middleware.api.bridge.MatchType;
import com.obric.memorydata.middleware.api.device.DeviceInfoState;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.EntityManager;
import com.obric.memorydata.personalcontext.api.EvaluationService;
import com.obric.memorydata.personalcontext.api.IEntityManager;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.personalcontext.api.PersonalContextAPI;
import com.obric.memorydata.personalcontext.l;
import com.obric.memorydata.personalcontext.q;
import com.obric.memorydata.personalcontext.storage.z;
import com.obric.memorydata.personalcontext.util.EmbeddingState;
import com.obric.memorydata.utils.y;
import com.obric.search.api.schema.impl.FullTextSearchSchema;
import com.ttnet.org.chromium.net.NetError;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.i;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0002\u0010\u0015J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0000H\u0007J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u0005H\u0002J\u0018\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J}\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00172\u0006\u0010\u001b\u001a\u00020\u00052\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001e0\u00172\b\u0010!\u001a\u0004\u0018\u00010\u00052M\u0010\"\u001aI\u0012\u0013\u0012\u00110$¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0013\u0012\u00110(¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b()\u0012\u0015\u0012\u0013\u0018\u00010*¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\u00110#H\u0002J \u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020(2\u0006\u0010\u001b\u001a\u00020\u0005H\u0002J\u001c\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00172\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001e0\u0017H\u0016J&\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00172\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001e0\u00172\b\u0010!\u001a\u0004\u0018\u00010\u0005H\u0016J4\u00100\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u0017012\u0018\u00102\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001701H\u0016J>\u00100\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u0017012\u0018\u00102\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u0017012\b\u0010!\u001a\u0004\u0018\u00010\u0005H\u0016J4\u00103\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u0017012\u0018\u00102\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001701H\u0002J\u0010\u00104\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u0005H\u0002JB\u00105\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00172\u0006\u0010\u0014\u001a\u00020\u00072\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u00050\u00172\u0006\u00107\u001a\u00020\u00052\u0006\u00108\u001a\u00020\u001e2\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0017H\u0016Jz\u0010:\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00172\u0006\u0010\u0014\u001a\u00020\u00072\u0018\u0010;\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0017012\u0018\u0010<\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0017012\u0018\u0010=\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0017012\u0006\u00108\u001a\u00020\u001e2\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0017H\u0016J¬\u0001\u0010>\u001a2\u0012\u0004\u0012\u00020?\u0012(\u0012&\u0012\u0004\u0012\u00020\u0005\u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0017010\u001701012\u0006\u0010\u0014\u001a\u00020\u00072\u0018\u0010;\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0017012\u0018\u0010<\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0017012\u0018\u0010=\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0017012\u0006\u00108\u001a\u00020\u001e2\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00172\u0006\u0010@\u001a\u00020\u0011H\u0016J \u0010A\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010B\u001a\u00020\u001e2\u0006\u0010C\u001a\u00020\u0005H\u0016J\u001e\u0010D\u001a\u00020-2\u0006\u0010\u0014\u001a\u00020\u00072\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0017H\u0016JM\u0010F\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020G010\u00172\b\u0010\u0014\u001a\u0004\u0018\u00010\u00072\f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00070\u00172\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00050\u00172\u0006\u00108\u001a\u00020\u001eH\u0016¢\u0006\u0002\u0010JJ[\u0010K\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020G010\u00172\b\u0010\u0014\u001a\u0004\u0018\u00010\u00072\f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00070\u00172\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00050\u00172\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00172\u0006\u00108\u001a\u00020\u001eH\u0016¢\u0006\u0002\u0010MJ(\u0010N\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010B\u001a\u00020\u001e2\u0006\u0010O\u001a\u00020\u00052\u0006\u0010P\u001a\u00020\u0005H\u0016J \u0010Q\u001a\u00020-2\u0006\u0010B\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010R\u001a\u00020\u0005H\u0017J\u0018\u0010S\u001a\u00020-2\u0006\u0010B\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u0007H\u0016J,\u0010T\u001a\u00020-2\u0006\u0010B\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u00072\b\u0010O\u001a\u0004\u0018\u00010\u00052\b\u0010U\u001a\u0004\u0018\u00010\u0005H\u0002J \u0010S\u001a\u00020-2\u0006\u0010B\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010V\u001a\u00020\u0011H\u0002J\u0012\u0010W\u001a\u0004\u0018\u00010\u000f2\u0006\u0010X\u001a\u00020\u0005H\u0016J\u0010\u0010Y\u001a\u00020-2\u0006\u0010Z\u001a\u00020\u0011H\u0017J\u0010\u0010[\u001a\u00020\u00112\u0006\u0010\\\u001a\u00020\u0005H\u0016J&\u0010]\u001a\u00020-2\f\u0010^\u001a\b\u0012\u0004\u0012\u00020\u00050\u00172\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010_\u001a\u00020\u0005H\u0016J\b\u0010`\u001a\u00020\u0007H\u0002J\u0010\u0010a\u001a\u00020\u00112\u0006\u0010B\u001a\u00020\u001eH\u0002J\u0010\u0010b\u001a\u00020-2\u0006\u0010'\u001a\u00020cH\u0002J\u0006\u0010d\u001a\u00020\u0011J\b\u0010e\u001a\u00020\u0011H\u0016J\u001c\u0010f\u001a\u00020\u00112\u0006\u0010g\u001a\u00020\u00052\n\b\u0002\u0010h\u001a\u0004\u0018\u00010\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006i"}, d2 = {"Lcom/obric/memorydata/personalcontext/bridge/AppEntityIndexBridgeAPIImpl;", "Lcom/obric/memorydata/middleware/api/bridge/IAppEntityIndexBridgeAPI;", "<init>", "()V", "TAG", "", "MAX_FAIL_COUNT", "", "MAX_BM25_SEARCH_KEYS", "LOCATION_BUILD_TASK", "LOCATION_RETRY_DELAYS_MS", "", "failPendingIdMap", "Ljava/util/concurrent/ConcurrentHashMap;", "trackEntityLock", "", "allSlowEntityIndexModelReady", "", "allIndexModelReady", "uidOf", "entityType", "(Ljava/lang/Integer;)Ljava/lang/String;", "visibleMetaFullContentUids", "", "getInst", "getIndexPendingDao", "Lcom/obric/memorydata/database/dao/IndexPendingDao;", "dbType", "failPendingKey", "pendingId", "", "basePowerIndex", "pendingIdList", "indexPackageName", "codeBlock", "Lkotlin/Function3;", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "entity", "Lcom/obric/memorydata/database/entity/IndexPendingEntity;", "pendingEntity", "Lcom/obric/memorydata/database/index/ExecutionHandle;", "executionHandle", "scheduleLocationRetry", "", "indexPendingDao", "executeIndexTask", "executeIndexTaskByDbType", "", "pendingIdsByDbType", "normalizePendingIdsByDbType", "isIndexConsumable", "queryByKeywordIndex", "columns", "keyword", "limit", "targetIds", "queryByKeywordIndexForMultiKeywords", "keywordToColumns", "keywordToSynonymColumns", "keywordToHomonymColumns", "queryMatchedColumns", "Lcom/obric/memorydata/middleware/api/bridge/MatchType;", "isFullMatch", "insertMetaFullContentKeyword", "rawDbId", "fullContent", "deleteMetaFullContentKeyword", "rawDbIdList", "queryMetaInfoFullContentByKeyword", "", "matchTypes", "keywords", "(Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;J)Ljava/util/List;", "queryMetaInfoFullContentByKeywordWithKeys", "keys", "(Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/util/List;J)Ljava/util/List;", "insertCopilotText", "columnName", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "trackEntityIndex", "type", "trackEntityIndexV2", "trackIndexFailed", "buildType", "enableBlockTrack", "getFeature", "featureName", "trackSlowEntityIndexMatchCondition", "isChargingAndScreenOff", "indexEntity", "entityDataJson", "deleteIndex", "entityIds", ObricMemoryConstants.KEY_PACKAGE_NAME, "reconcileSemanticIndex", "onTrackVideoTypePhotoEntity", "onTrackVideoFrameEntity", "Lcom/obric/memorydata/database/entity/RawVideoFrameEntity;", "isIndexModelReady", "isSlowEntityIndexModelReady", "checkAIkernelModel", "bizName", Params.LORA_TYPE, "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AppEntityIndexBridgeAPIImpl implements IAppEntityIndexBridgeAPI {
    public static final AppEntityIndexBridgeAPIImpl INSTANCE = null;
    private static final String LOCATION_BUILD_TASK = "location";
    private static final long[] LOCATION_RETRY_DELAYS_MS = null;
    private static final int MAX_BM25_SEARCH_KEYS = 1000;
    private static final int MAX_FAIL_COUNT = 5;
    private static final String TAG = "AppEntityIndexBridgeAPIImpl";
    private static boolean allIndexModelReady;
    private static boolean allSlowEntityIndexModelReady;
    private static final ConcurrentHashMap<String, Integer> failPendingIdMap = null;
    private static final Object trackEntityLock = null;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12040a = null;

        static {
            int[] r0 = new int[EmbeddingState.values().length];
            r0[EmbeddingState.USE_VLM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[EmbeddingState.USE_LITTLE_MODEL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f12040a = r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.personalcontext.bridge.AppEntityIndexBridgeAPIImpl$checkAIkernelModel$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.personalcontext.bridge.AppEntityIndexBridgeAPIImpl$checkAIkernelModel$1", f = "AppEntityIndexBridgeAPIImpl.kt", i = {}, l = {1413, 1415}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Boolean>, Object> {
        final /* synthetic */ String $bizName;
        final /* synthetic */ String $loraType;
        int label;

        AnonymousClass1(String r3, String r4, Continuation<? super AnonymousClass1> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.$loraType = r3;
            this.$bizName = r4;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.$loraType, this.$bizName, r5), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Boolean> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Boolean> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r13) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            boolean r3 = true;
            if (r1 == 0) goto L9;
            if (r1 == 1) goto L6;
            if (r1 == 2) goto L6;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L6:
            ResultKt.throwOnFailure(r13);
            Object r14 = ((Result) ZeusTransformUtils.preCheckCast(r13, Result.class, "com.obric.memorydata.plugin")).m1430unboximpl();
        L18:
            if (Result.m1427isFailureimpl(r14) == false) goto L21;
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), AppEntityIndexBridgeAPIImpl.TAG, "checkAIkernelModel " + this.$bizName + ' ' + this.$loraType + " Failed: " + Result.m1424exceptionOrNullimpl(r14) + '\n', null, 4, null);
        L20:
            r3 = false;
        L24:
            return Boxing.boxBoolean(r3);
        L21:
            ResultKt.throwOnFailure(r14);
            PackageResource r15 = (PackageResource) ZeusTransformUtils.preCheckCast(r14, PackageResource.class, "com.obric.memorydata.plugin");
            boolean r2 = r15.isAvailable();
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), AppEntityIndexBridgeAPIImpl.TAG, "checkAIkernelModel " + this.$bizName + ' ' + this.$loraType + " available = " + r2 + ", pkg version = " + r15.getVersion(), false, 4, null);
            if (r2 == false) goto L20;
        L9:
            ResultKt.throwOnFailure(r13);
            if (this.$loraType == null) goto L14;
            JSONObject r16 = new JSONObject();
            r16.put(Params.LORA_TYPE, this.$loraType);
            RequestParams r4 = new RequestParams(DataConvert.INSTANCE.jobj2Bundle(r16), null, 2, null);
            AIKernelManager r17 = AIKernelManager.INSTANCE;
            String r5 = this.$bizName;
            Continuation<? super Result<PackageResource>> r6 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r14 = r17.mo188getPackage0E7RQCE(r5, r4, r6);
            if (r14 != r0) goto L18;
            return r0;
        L14:
            IAIKernelManager r7 = (IAIKernelManager) ZeusTransformUtils.preCheckCast(AIKernelManager.INSTANCE, IAIKernelManager.class, "com.obric.memorydata.plugin");
            String r8 = this.$bizName;
            Continuation r9 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 2;
            r14 = IAIKernelManager.DefaultImpls.m190getPackage0E7RQCE$default(r7, r8, null, r9, 2, null);
            if (r14 != r0) goto L18;
            return r0;
        }
    }

    static {
        INSTANCE = new AppEntityIndexBridgeAPIImpl();
        LOCATION_RETRY_DELAYS_MS = new long[]{60000, 300000, 1800000, 7200000, 43200000, WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_DATE_MS};
        failPendingIdMap = new ConcurrentHashMap();
        trackEntityLock = new Object();
    }

    private AppEntityIndexBridgeAPIImpl() {
    }

    private final List<Long> basePowerIndex(String r46, List<Long> r47, String r48, Function3<? super com.obric.memorydata.database.entity.d, ? super cd, ? super u, Boolean> r49) {
        List<Long> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r47, List.class, "com.obric.memorydata.plugin");
        Function3 r13 = (Function3) ZeusTransformUtils.wrapperContextForParams(r49, Function3.class, "com.obric.memorydata.plugin");
        IndexPendingDao r14 = getIndexPendingDao(r46);
        if (r14 == null) goto L5;
        EntityIndexEngine r15 = s.a();
        List<Long> r9 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        List<cd> r8 = r14.queryWithId(r12);
        List r7 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Set r5 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        Set r6 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        Map r3 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L7:
        com.obric.memorydata.database.entity.d r19 = null;
        List<Long> r410 = r12;
        Function3 r411 = r13;
        if (r16.hasNext() == false) goto L98;
        cd r0 = (cd) ZeusTransformUtils.preCheckCast(r16.next(), cd.class, "com.obric.memorydata.plugin");
        IAppEntityRawDbDao<com.obric.memorydata.database.entity.d> r17 = r15.getRawDaoByEntityType(r0.c());
        Map r21 = r3;
        if (r17 == null) goto L14;
        Object r24 = "vlm_embedding_update_image_task";
        Set r23 = r5;
        List<T> r2 = r17.queryByIdAndTimestamp(r0.b(), r0.d());
        if (r2 == 0) goto L15;
        com.obric.memorydata.database.entity.d r4 = (com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r2), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin");
    L16:
        if (r4 != null) goto L19;
        r7.add(r0);
    L18:
        List r33 = r7;
        List<cd> r34 = r8;
        List<Long> r10 = r9;
        IndexPendingDao r11 = r14;
        EntityIndexEngine r22 = r15;
        Map r18 = r21;
        Set r25 = r23;
        Set r20 = r6;
    L97:
        r12 = r410;
        r13 = r411;
        r6 = r20;
        r14 = r11;
        r3 = r18;
        r5 = r25;
        r15 = r22;
        r8 = r34;
        r9 = r10;
        r7 = r33;
        goto L7
    L19:
        cd r110 = r14.queryByIdAndTimestamp(r0.a(), r0.d());
        if (r110 != null) goto L22;
        r6.add(Long.valueOf(r0.a()));
        goto L18
    L22:
        IAppEntityRawDbDao<com.obric.memorydata.database.entity.d> r1 = r15.getRawDaoByEntityType(r110.c());
        if (r1 == null) goto L27;
        List<T> r26 = r1.queryByIdAndTimestamp(r110.b(), r110.d());
        if (r26 == 0) goto L27;
        r19 = (com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r26), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin");
    L27:
        com.obric.memorydata.database.entity.d r27 = r19;
        if (r27 != null) goto L31;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "rawDb not have rawDbId: " + r110.b() + ", type: " + r110.c() + ", dbType: " + r46 + " time: " + r110.d() + ", skip it", false, 4, null);
        r7.add(r110);
        goto L18
    L31:
        if (AppContext.INSTANCE.isDebug() == true) goto L33;
    L35:
        r22 = r15;
        r18 = r21;
        Object r31 = r24;
        Set r32 = r6;
        IndexPendingDao r28 = r14;
        r33 = r7;
        r34 = r8;
        List<Long> r35 = r9;
        u r29 = ao.f9372a.a(r46, r110.a(), r110.d(), r27.getPackageName(), r110.i(), r48);
        if (r29 == null) goto L211;
        r18.put(Long.valueOf(r110.a()), r29);
    L211:
        boolean r30 = ((Boolean) ZeusTransformUtils.preCheckCast(r411.invoke(r27, r110, r29), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();     // Catch: AIKernelRunModelException -> L41
        Set r36 = r23;
        long r210 = 0;
    L45:
        b r37 = b.f12041a;
        r11 = r28;
        if (r11.queryByIdAndTimestamp(r110.a(), r110.d()) == null) goto L48;
        boolean r38 = true;
    L49:
        IAppEntityRawDbDao<com.obric.memorydata.database.entity.d> r39 = r22.getRawDaoByEntityType(r110.c());
        if (r39 == null) goto L56;
        r411 = r411;
        r25 = r36;
        Collection r40 = r39.queryByIdAndTimestamp(r110.b(), r110.d());
        if (r40 != null) goto L54;
    L57:
        boolean r41 = false;
    L59:
        if (r37.a(r38, r41) == true) goto L65;
        u r42 = (u) ZeusTransformUtils.preCheckCast(r18.remove(Long.valueOf(r110.a())), u.class, "com.obric.memorydata.plugin");
        if (r42 == null) goto L63;
        ao.f9372a.a(r42);
        Unit r43 = Unit.INSTANCE;
        Unit r44 = Unit.INSTANCE;
    L63:
        r20 = r32;
        r20.add(Long.valueOf(r110.a()));
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "index snapshot superseded during execution, rawDbId: " + r110.b() + ", type: " + r110.c() + ", dbType: " + r46 + ", timestamp: " + r110.d(), false, 4, null);
    L64:
        r10 = r35;
        goto L97
    L65:
        r20 = r32;
        if (r30 == false) goto L90;
        if (r29 == null) goto L69;
        boolean r45 = ao.f9372a.a(r29, System.currentTimeMillis()).a();
        String r111 = TAG;
    L73:
        r18.remove(Long.valueOf(r110.a()));
        if (r45 == false) goto L76;
    L78:
        boolean r50 = false;
    L80:
        if (c.f12042a.a(r45, r50) == true) goto L82;
        RunLog.INSTANCE.debug(r111, "index success skipped because pending still exists, pendingId: " + r110.a() + ", timestamp: " + r110.d() + ", dbType: " + r46);
        goto L64
    L82:
        if (r45 == true) goto L84;
        RunLog.INSTANCE.debug(r111, "index success settled after pending already disappeared, pendingId: " + r110.a() + ", timestamp: " + r110.d() + ", dbType: " + r46);
    L84:
        com.obric.memorydata.personalcontext.b.f12038a.b(r110);
        r10 = r35;
        r10.add(Long.valueOf(r110.a()));
        failPendingIdMap.remove(INSTANCE.failPendingKey(r46, r110.a()));
        if (Intrinsics.areEqual(r110.h(), "vlm_embedding_update_text_task") == false) goto L87;
    L88:
        t.f9438a.a(true);
    L89:
        String r51 = r111;
    L92:
        if (r210 <= 0) goto L97;
        Thread.sleep(r210);     // Catch: InterruptedException -> L95
    L95:
        e = move-exception;
        RunLog.INSTANCE.error(r51, "AIKernelRunModelException sleep interrupted", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        goto L97
    L87:
        if (Intrinsics.areEqual(r110.h(), r31) == false) goto L89;
    L76:
        if (r11.queryByIdAndTimestamp(r110.a(), r110.d()) == null) goto L78;
        r50 = true;
        goto L80
    L69:
        ao r52 = ao.f9372a;
        List r53 = CollectionsKt.listOf(new ax.e(r110.a(), r110.d(), r110.c()));
        r111 = TAG;
        if (((Number) ZeusTransformUtils.preCheckCast(ao.a(r52, r46, r53, null, 4, null).a(), Number.class, "com.obric.memorydata.plugin")).intValue() != 1) goto L72;
        r45 = true;
        goto L73
    L72:
        r45 = false;
        goto L73
    L90:
        r51 = TAG;
        r10 = r35;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "Index failed, rawDbId: " + r110.b() + ", type: " + r110.c() + ", dbType: " + r46, null, 4, null);
        goto L92
    L54:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r40, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) != true) goto L57;
        r41 = true;
        goto L59
    L56:
        r411 = r411;
        r25 = r36;
        goto L57
    L48:
        r38 = false;
    L41:
        e = move-exception;
        if (r29 == null) goto L44;
        ao.f9372a.b(r29);
        Unit r54 = Unit.INSTANCE;
        Unit r55 = Unit.INSTANCE;
    L44:
        r18.remove(Long.valueOf(r110.a()));
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "catch ThermalStatusException, rawDbId: " + r110.b() + ", type: " + r110.c() + ", dbType: " + r46, false, 4, null);
        r36 = r23;
        r36.add(Long.valueOf(r110.a()));
        r210 = e.getDelayTime();
        r30 = false;
        goto L45
    L33:
        if (EvaluationService.INSTANCE.isFreezeIndexTask() == false) goto L35;
        EvaluationService.INSTANCE.sleepUntilFreezeIndexTaskEnd();
    L15:
        r4 = null;
        goto L16
    L14:
        r24 = "vlm_embedding_update_image_task";
        r23 = r5;
        goto L15
    L98:
        Map r112 = r3;
        Set r211 = r5;
        List r310 = r7;
        List<cd> r311 = r8;
        List<Long> r56 = r9;
        IndexPendingDao r57 = r14;
        String r113 = ", type: ";
        Set r58 = r6;
        Object r59 = "vlm_embedding_update_text_task";
        Iterator r60 = ((Iterable) ZeusTransformUtils.preCheckCast(r310, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L99:
        String r61 = "delete invalid pending entity, rawDbId: ";
        if (r60.hasNext() == false) goto L107;
        cd r114 = (cd) ZeusTransformUtils.preCheckCast(r60.next(), cd.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "delete invalid pending entity, rawDbId: " + r114.b() + r113 + r114.c() + ", dbType: " + r46, false, 4, null);
        String r212 = r113;
        Object r115 = r59;
        ao.a(ao.f9372a, r46, CollectionsKt.listOf(new ax.e(r114.a(), r114.d(), r114.c())), null, 4, null);
        if (Intrinsics.areEqual(r114.i(), r115) == false) goto L104;
    L105:
        t.f9438a.a(true);
    L106:
        r59 = r115;
        r113 = r212;
        goto L99
    L104:
        if (Intrinsics.areEqual(r114.i(), "vlm_embedding_update_image_task") == false) goto L106;
    L107:
        String r213 = r113;
        Object r116 = r59;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "index success id list: " + r56 + ", dbType: " + r46, false, 4, null);
        Iterator r62 = ((Iterable) ZeusTransformUtils.preCheckCast(r410, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L109:
        if (r62.hasNext() == false) goto L208;
        long r63 = ((Number) ZeusTransformUtils.preCheckCast(r62.next(), Number.class, "com.obric.memorydata.plugin")).longValue();
        if (r58.contains(Long.valueOf(r63)) == true) goto L205;
        List<cd> r64 = r311;
        Iterable r65 = (Iterable) ZeusTransformUtils.preCheckCast(r64, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r65, Collection.class) == true) goto L115;
    L117:
        Iterator r66 = r65.iterator();
    L119:
        if (r66.hasNext() == false) goto L116;
        Iterator r412 = r62;
        if (((cd) ZeusTransformUtils.preCheckCast(r66.next(), cd.class, "com.obric.memorydata.plugin")).a() != r63) goto L123;
        boolean r67 = true;
    L124:
        if (r67 == true) goto L125;
        r62 = r412;
        goto L119
    L125:
        boolean r68 = false;
    L127:
        if (r68 == false) goto L130;
        List<cd> r214 = r64;
    L206:
        failPendingIdMap.remove(INSTANCE.failPendingKey(r46, r63));
    L207:
        r62 = r412;
        r213 = r213;
        r57 = r57;
        r311 = r214;
        r112 = r112;
        r58 = r58;
        r61 = r61;
        goto L109
    L130:
        if (r56.contains(Long.valueOf(r63)) == true) goto L204;
        Set r69 = r211;
        if (r69.contains(Long.valueOf(r63)) == true) goto L203;
        String r70 = INSTANCE.failPendingKey(r46, r63);
        Iterator r71 = ((Iterable) ZeusTransformUtils.preCheckCast(r64, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L134:
        r211 = r69;
        if (r71.hasNext() == false) goto L143;
        Object r72 = r71.next();
        Iterator r413 = r71;
        if (((cd) ZeusTransformUtils.preCheckCast(r72, cd.class, "com.obric.memorydata.plugin")).a() != r63) goto L139;
        boolean r73 = true;
    L140:
        if (r73 == true) goto L144;
        r71 = r413;
        r69 = r211;
    L144:
        cd r74 = (cd) ZeusTransformUtils.preCheckCast(r72, cd.class, "com.obric.memorydata.plugin");
        String r414 = r61;
        u r75 = (u) ZeusTransformUtils.preCheckCast(r112.remove(Long.valueOf(r63)), u.class, "com.obric.memorydata.plugin");
        if (r74 == null) goto L147;
        String r76 = r74.i();
    L149:
        if (Intrinsics.areEqual(r76, "location") == false) goto L154;
        if (r75 == null) goto L152;
        ao.f9372a.c(r75);
        Unit r77 = Unit.INSTANCE;
        Unit r78 = Unit.INSTANCE;
    L152:
        failPendingIdMap.remove(r70);
        INSTANCE.scheduleLocationRetry(r57, r74, r46);
        r61 = r414;
        r58 = r58;
        r57 = r57;
        r112 = r112;
        r214 = r64;
        goto L207
    L154:
        ConcurrentHashMap<String, Integer> r79 = failPendingIdMap;
        r58 = r58;
        r57 = r57;
        ((Map) ZeusTransformUtils.preCheckCast(r79, Map.class, "com.obric.memorydata.plugin")).put(r70, Integer.valueOf(((Number) ZeusTransformUtils.preCheckCast(r79.getOrDefault(r70, 0), Number.class, "com.obric.memorydata.plugin")).intValue() + 1));
        Integer r80 = r79.get(r70);
        Intrinsics.checkNotNull(r80);
        if (((Number) ZeusTransformUtils.preCheckCast(r80, Number.class, "com.obric.memorydata.plugin")).intValue() < 5) goto L198;
        if (r74 == null) goto L158;
        Integer r81 = Integer.valueOf(r74.c());
    L159:
        if (r74 == null) goto L161;
        Long r82 = Long.valueOf(r74.b());
    L162:
        if (r74 == null) goto L164;
        long r215 = r74.d();
    L165:
        if (r74 == null) goto L167;
        String r312 = r74.h();
    L168:
        if (r74 == null) goto L170;
        String r83 = r74.i();
    L171:
        if (r82 == null) goto L197;
        if (r81 == null) goto L197;
        if (r75 == null) goto L175;
        String r216 = r83;
        String r415 = r414;
        cd r416 = r74;
        boolean r84 = ao.f9372a.b(r75, System.currentTimeMillis()).a();
        r112 = r112;
        String r417 = r216;
        r214 = r64;
        ConcurrentHashMap<String, Integer> r117 = r79;
    L179:
        if (r84 == false) goto L196;
        cd r85 = r416;
        if (r85 == null) goto L183;
        com.obric.memorydata.personalcontext.b.f12038a.a(r85);
        Unit r86 = Unit.INSTANCE;
        Unit r87 = Unit.INSTANCE;
    L183:
        r61 = r415;
        r213 = r213;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, r61 + r82 + r213 + r81 + ", dbType: " + r46, false, 4, null);
        String r88 = r417;
        if (Intrinsics.areEqual(r88, r116) == false) goto L186;
    L189:
        t.f9438a.a(true);
    L190:
        r117.remove(r70);
        INSTANCE.trackIndexFailed(r82.longValue(), r81.intValue(), r312, r88);
        IAppEntityRawDbDao<com.obric.memorydata.database.entity.d> r89 = s.a().getRawDaoByEntityType(r81.intValue());
        if (r89 == null) goto L202;
        com.obric.memorydata.database.entity.d r90 = (com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r89.queryById(r82.longValue()), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin");
        if (r90 == null) goto L195;
        com.obric.memorydata.database.util.b.f9624a.a(r90.getPackageName(), String.valueOf(r90.getType()), r90.getEntityId());
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "clear failed index record info, packageName: " + r90.getPackageName() + ", entityType: " + r90.getType() + ", entityId: " + r90.getEntityId(), false, 4, null);
        Unit r91 = Unit.INSTANCE;
        Unit r92 = Unit.INSTANCE;
    L195:
        Unit r93 = Unit.INSTANCE;
    L201:
        Unit r94 = Unit.INSTANCE;
    L202:
        Unit r95 = Unit.INSTANCE;
        goto L207
    L186:
        if (Intrinsics.areEqual(r88, "vlm_embedding_update_image_task") == false) goto L190;
    L196:
        r61 = r415;
        goto L207
    L175:
        r416 = r74;
        r415 = r414;
        r417 = r83;
        r112 = r112;
        r214 = r64;
        r117 = r79;
        if (((Number) ZeusTransformUtils.preCheckCast(ao.a(ao.f9372a, r46, CollectionsKt.listOf(new ax.e(r63, r215, r81.intValue())), null, 4, null).a(), Number.class, "com.obric.memorydata.plugin")).intValue() != 1) goto L178;
        r84 = true;
        goto L179
    L178:
        r84 = false;
    L197:
        r61 = r414;
        r112 = r112;
        r213 = r213;
        r214 = r64;
        goto L202
    L170:
        r83 = null;
        goto L171
    L167:
        r312 = null;
        goto L168
    L164:
        r215 = 0;
        goto L165
    L161:
        r82 = null;
        goto L162
    L158:
        r81 = null;
        goto L159
    L198:
        r61 = r414;
        r112 = r112;
        r213 = r213;
        r214 = r64;
        if (r75 == null) goto L207;
        ao.f9372a.a(r75);
        goto L201
    L147:
        r76 = null;
        goto L149
    L139:
        r73 = false;
        goto L140
    L143:
        r72 = null;
        goto L144
    L203:
        r211 = r69;
    L204:
        r61 = r61;
        r214 = r64;
        r58 = r58;
        r57 = r57;
        r112 = r112;
        goto L207
    L123:
        r67 = false;
    L116:
        r412 = r62;
        r68 = true;
        goto L127
    L115:
        if (((Collection) ZeusTransformUtils.preCheckCast(r65, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L117;
    L205:
        r412 = r62;
        r214 = r311;
        goto L206
    L208:
        return r56;
    L5:
        return CollectionsKt.emptyList();
    }

    private final boolean checkAIkernelModel(String r2, String r3) {
        return ((Boolean) ZeusTransformUtils.preCheckCast(i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3, r2, null), Function2.class, "com.obric.memorydata.plugin"), 1, null), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    static /* synthetic */ boolean checkAIkernelModel$default(AppEntityIndexBridgeAPIImpl r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return r0.checkAIkernelModel(r1, r2);
    }

    private static final int executeIndexTaskByDbType$lambda$14(Exception r3) {
        Intrinsics.checkNotNullParameter(r3, "error");
        RunLog.INSTANCE.error(TAG, "semantic index reconciliation failed", (Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.memorydata.plugin"));
        return 0;
    }

    private static final int executeIndexTaskByDbType$lambda$15() {
        return INSTANCE.reconcileSemanticIndex();
    }

    private static final boolean executeIndexTaskByDbType$lambda$21$lambda$20(final String r9, IndexPendingDao r10, final EntityIndexEngine r11, final com.obric.memorydata.database.entity.d r12, final cd r13, u r14) {
        final IndexPendingDao r7 = (IndexPendingDao) ZeusTransformUtils.wrapperContextForParams(r10, IndexPendingDao.class, "com.obric.memorydata.plugin");
        final u r4 = (u) ZeusTransformUtils.wrapperContextForParams(r14, u.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "entity");
        Intrinsics.checkNotNullParameter(r13, "pendingEntity");
        Boolean r15 = (Boolean) ZeusTransformUtils.preCheckCast(y.a(new $$Lambda$AppEntityIndexBridgeAPIImpl$aeW4umGVkvCkR6NzDjy1566ESac(r12, r9), new $$Lambda$AppEntityIndexBridgeAPIImpl$8o90LMCzFmoJKeFlKgIae63qTHc(r13, r4, r12, r9, r7, r11)), Boolean.class, "com.obric.memorydata.plugin");
        if (r15 != null) goto L7;
        return false;
    L7:
        return r15.booleanValue();
    }

    private static final boolean executeIndexTaskByDbType$lambda$21$lambda$20$lambda$16(com.obric.memorydata.database.entity.d r8, String r9, Exception r10) {
        Intrinsics.checkNotNullParameter(r10, "e");
        RunLog.INSTANCE.error(TAG, "executeIndexTask error, rawDbId: " + r8.getEntityId() + ", type: " + r8.getType() + ", dbType: " + r9, (Throwable) ZeusTransformUtils.preCheckCast(r10, Throwable.class, "com.obric.memorydata.plugin"));
        if (ZeusTransformUtils.instanceOf(r10, AIKernelRunModelException.class) == true) goto L6;
        return false;
    L6:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "throw AIKernelRunModelException, delayTime: " + ((AIKernelRunModelException) ZeusTransformUtils.preCheckCast(r10, AIKernelRunModelException.class, "com.obric.memorydata.plugin")).getDelayTime(), false, 4, null);
        throw r10;
    }

    private static final boolean executeIndexTaskByDbType$lambda$21$lambda$20$lambda$19(final cd r7, u r8, final com.obric.memorydata.database.entity.d r9, String r10, IndexPendingDao r11, final EntityIndexEngine r12) {
        u r13 = (u) ZeusTransformUtils.wrapperContextForParams(r8, u.class, "com.obric.memorydata.plugin");
        IndexPendingDao r14 = (IndexPendingDao) ZeusTransformUtils.wrapperContextForParams(r11, IndexPendingDao.class, "com.obric.memorydata.plugin");
        final String r0 = r7.h();
        boolean r15 = ((Boolean) ZeusTransformUtils.preCheckCast(ao.f9372a.a(r13, new $$Lambda$AppEntityIndexBridgeAPIImpl$73CUrjXgbH4GYXMbQ6MjODQhyY(r0, r7, r12, r9)), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "executeIndexTask result: " + r15 + " entityId: " + r9.getEntityId() + " entityType: " + r9.getType() + " entityPackage: " + r9.getPackageName() + " dbType: " + r10 + " updateField: " + r0 + " buildType: " + r7.i(), false, 4, null);
        if (AppContext.INSTANCE.isDebug() == false) goto L5;
        RunLog.INSTANCE.info(TAG, "hasPending tasks: dbType=" + r10 + " count=" + r14.queryAllCount(), true);
    L5:
        return r15;
    }

    private static final boolean executeIndexTaskByDbType$lambda$21$lambda$20$lambda$19$lambda$18(String r5, cd r6, EntityIndexEngine r7, com.obric.memorydata.database.entity.d r8) {
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L26;
        int r1 = r5.hashCode();
        if (r1 == (-784590319)) goto L23;
        if (r1 == 946424445) goto L19;
        if (r1 != 2104770671) goto L47;
        if (r5.equals("vlm_embedding_update_image_task") == false) goto L47;
        return com.obric.memorydata.personalcontext.s.f12268a.a(r6.c(), r6.b());
    L47:
        return r7.executeIndexPendingTask(r8, r5);
    L19:
        if (r5.equals("lazy_index_task") == false) goto L47;
        return l.f12228a.a(r6);
    L23:
        if (r5.equals("vlm_embedding_update_text_task") == false) goto L47;
        return com.obric.memorydata.personalcontext.s.f12268a.b(r6.c(), r6.b());
    L26:
        Set<String> r9 = r7.getAllColumns(r8);
        if ((!((Collection) ZeusTransformUtils.preCheckCast(CollectionsKt.intersect((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(s.a().getKeywordColumnMap(r8).keySet(), Iterable.class, "com.obric.memorydata.plugin")), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L29;
        r9.add("insert_keyword_task");
    L29:
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L30:
        boolean r11 = true;
    L32:
        if (r10.hasNext() == false) goto L40;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.memorydata.plugin");
        if (r11 == false) goto L38;
        if (r7.executeIndexPendingTask(r8, r2) == true) goto L30;
    L38:
        r11 = false;
        goto L32
    L40:
        return r11;
    L5:
        r0 = false;
        goto L6
    }

    private final String failPendingKey(String r1, long r2) {
        return r1 + ':' + r2;
    }

    private final IndexPendingDao getIndexPendingDao(String r7) {
        if (com.obric.memorydata.database.manager.c.f9561a.a().contains(r7) == true) goto L7;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "unknown dbType: " + r7, null, 4, null);
        return null;
    L7:
        return com.obric.memorydata.database.manager.c.f9561a.a(r7);
    }

    @JvmStatic
    public static final AppEntityIndexBridgeAPIImpl getInst() {
        return INSTANCE;
    }

    private static final Boolean indexEntity$lambda$44(String r3, Exception r4) {
        Intrinsics.checkNotNullParameter(r4, "it");
        RunLog.INSTANCE.error(TAG, "indexEntity failed", (Throwable) ZeusTransformUtils.preCheckCast(r4, Throwable.class, "com.obric.memorydata.plugin"));
        RunLog.INSTANCE.debug(TAG, "indexEntity failed, entityDataJson: " + r3);
        return false;
    }

    private static final Boolean indexEntity$lambda$45(String r7) {
        JsonObject r0 = (JsonObject) ZeusTransformUtils.preCheckCast(EntityExtKt.getEntityKeepTimeStampGson().fromJson(r7, JsonObject.class), JsonObject.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L7;
        JsonElement r3 = r0.get("type");
        if (r3 == null) goto L7;
        Integer r4 = Integer.valueOf(r3.getAsInt());
    L8:
        EntityClassData r5 = (EntityClassData) ZeusTransformUtils.preCheckCast(EntityType.INSTANCE.getClassMap().get(r4), EntityClassData.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L26;
        Class r6 = r5.getClazz();
        if (r6 == null) goto L26;
        AppEntity r8 = (AppEntity) ZeusTransformUtils.preCheckCast(EntityExtKt.getEntityKeepTimeStampGson().fromJson(r7, r6), AppEntity.class, "com.obric.memorydata.plugin");
        if (r8.getType() == 401) goto L15;
    L22:
        boolean r9 = !((Collection) ZeusTransformUtils.preCheckCast(EntityManager.INSTANCE.bulkIndex(CollectionsKt.listOf(r8)), Collection.class, "com.obric.memorydata.plugin")).isEmpty();
    L24:
        return Boolean.valueOf(r9);
    L15:
        if (ZeusTransformUtils.instanceOf(r8, ScheduleEntity.class) == false) goto L22;
        com.obric.memorydata.personalcontext.storage.a r10 = q.a(q.f12255a, 401, false, 2, null);
        if (ZeusTransformUtils.instanceOf(r10, z.class) == false) goto L19;
        z r11 = (z) ZeusTransformUtils.preCheckCast(r10, z.class, "com.obric.memorydata.plugin");
    L20:
        if (r11 == null) goto L27;
        ScheduleEntity r12 = (ScheduleEntity) ZeusTransformUtils.preCheckCast(r8, ScheduleEntity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r0);
        r9 = r11.a(r12, r0);
        goto L24
    L27:
        return null;
    L19:
        r11 = null;
    L26:
        throw new IllegalArgumentException("Unknown entity type: " + r4);
    L7:
        r4 = null;
        goto L8
    }

    private static final boolean insertCopilotText$lambda$36(IAppEntityVectorCopilotDao r2, long r3) {
        IAppEntityVectorCopilotDao r4 = (IAppEntityVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin");
        return PersonalContextAPI.INSTANCE.deleteVectorCopilotItem(r4.getTableName(), r3);
    }

    private static final Unit insertCopilotText$lambda$38(IAppEntityVectorCopilotDao r2, long r3) {
        IAppEntityVectorCopilotDao r4 = (IAppEntityVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.database.entity.i r5 = (com.obric.memorydata.database.entity.i) ZeusTransformUtils.preCheckCast(r4.queryById(r3), com.obric.memorydata.database.entity.i.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L6;
        r4.delete(r5);
    L6:
        return Unit.INSTANCE;
    }

    private final boolean isIndexConsumable(String r8) {
        if (Intrinsics.areEqual(r8, "PUBLIC") == false) goto L6;
        return true;
    L6:
        if (Intrinsics.areEqual(r8, "USER") == true) goto L8;
        return false;
    L8:
        if (AppContext.INSTANCE.isLogin() == true) goto L10;
        return false;
    L10:
        if (com.obric.memorydata.database.account_split.a.f8813a.a(AppContext.INSTANCE.getUserId()) == false) goto L17;
        boolean r0 = v.f8832a.b();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "get current profile migration state for index, migrationDone=" + r0, false, 4, null);
        return r0;
    L17:
        return false;
    }

    public static /* synthetic */ Boolean lambda$1ZYN6WXmPLPO3PFHH7UwGrErYqM(String r0, Exception r1) {
        return indexEntity$lambda$44(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$73CUrjXgbH4GY-XMbQ6MjODQhyY, reason: not valid java name */
    public static /* synthetic */ boolean m1056lambda$73CUrjXgbH4GYXMbQ6MjODQhyY(String r0, cd r1, EntityIndexEngine r2, com.obric.memorydata.database.entity.d r3) {
        return executeIndexTaskByDbType$lambda$21$lambda$20$lambda$19$lambda$18(r0, r1, r2, r3);
    }

    public static /* synthetic */ int lambda$7sSceWNGdeBfi1MGRrkvjbe8dSw(Exception r0) {
        return executeIndexTaskByDbType$lambda$14(r0);
    }

    public static /* synthetic */ boolean lambda$8o90LMCzFmoJKeFlKgIae63qTHc(cd r0, u r1, com.obric.memorydata.database.entity.d r2, String r3, IndexPendingDao r4, EntityIndexEngine r5) {
        return executeIndexTaskByDbType$lambda$21$lambda$20$lambda$19(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ Boolean lambda$FHpgwaxo8v6TxtwdRcIWtehOZKQ(String r0) {
        return indexEntity$lambda$45(r0);
    }

    public static /* synthetic */ boolean lambda$I7unDPtfyVjPQT0JawBdY8mGhFQ(IAppEntityVectorCopilotDao r0, long r1) {
        return insertCopilotText$lambda$36(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$W_CznVILhiZ-RfbU13Q_APSQplQ, reason: not valid java name */
    public static /* synthetic */ boolean m1057lambda$W_CznVILhiZRfbU13Q_APSQplQ(SemanticTextCopilotDao r0, long r1) {
        return reconcileSemanticIndex$lambda$52(r0, r1);
    }

    public static /* synthetic */ boolean lambda$aeW4umGVkvCkR6NzDjy1566ESac(com.obric.memorydata.database.entity.d r0, String r1, Exception r2) {
        return executeIndexTaskByDbType$lambda$21$lambda$20$lambda$16(r0, r1, r2);
    }

    public static /* synthetic */ boolean lambda$kmaMvoWASW96UdJ3VuV3vckN5sQ(String r0, IndexPendingDao r1, EntityIndexEngine r2, com.obric.memorydata.database.entity.d r3, cd r4, u r5) {
        return executeIndexTaskByDbType$lambda$21$lambda$20(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ Unit lambda$q61Tpo7YbzaxrcswtWSO3oOfyc0(IAppEntityVectorCopilotDao r0, long r1) {
        return insertCopilotText$lambda$38(r0, r1);
    }

    public static /* synthetic */ Unit lambda$t72K4QmSYn4j_x7ZnhA44WkHnj8(SemanticTextCopilotDao r0, int r1, List r2) {
        return reconcileSemanticIndex$lambda$53(r0, r1, r2);
    }

    public static /* synthetic */ int lambda$tgcBX4v6uqiega2cH8eMozaZvNk() {
        return executeIndexTaskByDbType$lambda$15();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Map<String, List<Long>> normalizePendingIdsByDbType(Map<String, ? extends List<Long>> r8) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.memorydata.plugin");
        Map<String, List<Long>> r9 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(MapsKt.mapCapacity(r7.size())), Map.class, "com.obric.memorydata.plugin");
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r7.entrySet(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r10.hasNext() == false) goto L17;
        Object r1 = r10.next();
        Object r2 = ((Map.Entry) ZeusTransformUtils.preCheckCast(r1, Map.Entry.class, "com.obric.memorydata.plugin")).getKey();
        List r3 = (List) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r1, Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlin.collections.List<*>");
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r6 = r4.iterator();
    L7:
        if (r6.hasNext() == false) goto L16;
        Object r11 = r6.next();
        Long r12 = null;
        if (ZeusTransformUtils.instanceOf(r11, Number.class) == false) goto L11;
        Number r13 = (Number) ZeusTransformUtils.preCheckCast(r11, Number.class, "com.obric.memorydata.plugin");
    L12:
        if (r13 == null) goto L14;
        r12 = Long.valueOf(r13.longValue());
    L14:
        if (r12 == null) goto L7;
        r5.add(r12);
        goto L7
    L11:
        r13 = null;
        goto L12
    L16:
        r9.put(r2, (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin"));
        goto L4
    L17:
        return r9;
    }

    private final void onTrackVideoFrameEntity(hr r9) {
        long r0 = r9.f();
        IAppEntityRawDbDao<com.obric.memorydata.database.entity.d> r2 = s.a().getRawDaoByEntityType(-304);
        if (ZeusTransformUtils.instanceOf(r2, VideoFrameRawDbDao.class) == false) goto L5;
        VideoFrameRawDbDao r3 = (VideoFrameRawDbDao) ZeusTransformUtils.preCheckCast(r2, VideoFrameRawDbDao.class, "com.obric.memorydata.plugin");
    L6:
        if (r3 == null) goto L20;
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(r3.queryByPhotoEntityDbId(r0), Iterable.class, "com.obric.memorydata.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r6 = r4.iterator();
    L9:
        if (r6.hasNext() == false) goto L11;
        r5.add(Long.valueOf(((hr) ZeusTransformUtils.preCheckCast(r6.next(), hr.class, "com.obric.memorydata.plugin")).getId()));
        goto L9
    L11:
        List<Long> r7 = (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L14;
        long r8 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getIndexPendingDao().queryCountWithRawDbIds(r7, r9.getType());
    L16:
        if (r8 != 0) goto L21;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "trackEntityIndexV2, video frame finish, rawDbId: " + r0, false, 4, null);
        trackEntityIndexV2(r0, 301, false);
        return;
    L21:
        return;
    L14:
        r8 = 0;
        goto L16
    L20:
        return;
    L5:
        r3 = null;
        goto L6
    }

    private final boolean onTrackVideoTypePhotoEntity(long r5) {
        IAppEntityRawDbDao<com.obric.memorydata.database.entity.d> r4 = s.a().getRawDaoByEntityType(-304);
        if (ZeusTransformUtils.instanceOf(r4, VideoFrameRawDbDao.class) == false) goto L5;
        VideoFrameRawDbDao r6 = (VideoFrameRawDbDao) ZeusTransformUtils.preCheckCast(r4, VideoFrameRawDbDao.class, "com.obric.memorydata.plugin");
    L6:
        if (r6 == null) goto L14;
        Iterator<hr> r7 = r6.queryByPhotoEntityDbId(r5).iterator();
    L9:
        if (r7.hasNext() == false) goto L19;
        hr r8 = (hr) ZeusTransformUtils.preCheckCast(r7.next(), hr.class, "com.obric.memorydata.plugin");
        if (MemoryDbEngine.INSTANCE.getGlobalDbEngine().getIndexPendingDao().queryCountWithRawDb(r8.getId(), r8.getType()) <= 0) goto L9;
        return true;
    L19:
        return false;
    L14:
        return false;
    L5:
        r6 = null;
        goto L6
    }

    private final int reconcileSemanticIndex() {
        PersonalMemoryFrameDb r0 = MemoryDbEngine.INSTANCE.getPersonalDbEngine();
        final SemanticTextCopilotDao r1 = r0.getSemanticTextCopilotDao();
        MetaFullContentKeywordCopilotDao r2 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getMetaFullContentKeywordCopilotDao();
        List r3 = CollectionsKt.createListBuilder();
        r3.addAll((Collection) ZeusTransformUtils.preCheckCast(r1.queryAllRawDbIds(), Collection.class, "com.obric.memorydata.plugin"));
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(INSTANCE.visibleMetaFullContentUids(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L3:
        boolean r5 = r4.hasNext();
        final int r7 = NetError.ERR_CACHE_READ_FAILURE;
        if (r5 == false) goto L6;
        r3.addAll((Collection) ZeusTransformUtils.preCheckCast(r2.queryRawDbIdsByEntityTypeAndUid(NetError.ERR_CACHE_READ_FAILURE, (String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.memorydata.plugin")), Collection.class, "com.obric.memorydata.plugin"));
        goto L3
    L6:
        List<Long> r6 = com.obric.memorydata.personalcontext.bridge.a.a(CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast(r0.getSemanticMemoryDao().queryAllRawDbIds(), Iterable.class, "com.obric.memorydata.plugin")), CollectionsKt.build(r3));
        if (r6.isEmpty() == false) goto L9;
        return 0;
    L9:
        EntityIndexEngine r8 = s.a();
        FullTextSearchSchema r9 = r8.getKeywordSchema(NetError.ERR_CACHE_READ_FAILURE);
        if (r9 != null) goto L12;
    L15:
        deleteMetaFullContentKeyword(NetError.ERR_CACHE_READ_FAILURE, r6);
        IAppEntityContentTimeDao<com.obric.memorydata.database.entity.b> r10 = r8.getContentTimeDao(NetError.ERR_CACHE_READ_FAILURE);
        if (r10 == null) goto L18;
        r10.deleteByRawDbIds(r6);
    L18:
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r1.queryByRawDbIds(r6), Iterable.class, "com.obric.memorydata.plugin");
        Map r12 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r13 = r11.iterator();
    L20:
        if (r13.hasNext() == false) goto L25;
        Object r14 = r13.next();
        Long r15 = Long.valueOf(((il) ZeusTransformUtils.preCheckCast(r14, il.class, "com.obric.memorydata.plugin")).b());
        Object r16 = r12.get(r15);
        if (r16 != null) goto L24;
        r16 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r12.put(r15, r16);
    L24:
        ((List) ZeusTransformUtils.preCheckCast(r16, List.class, "com.obric.memorydata.plugin")).add(Long.valueOf(((il) ZeusTransformUtils.preCheckCast(r14, il.class, "com.obric.memorydata.plugin")).a()));
        goto L20
    L25:
        Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");
        LinkedHashMap r18 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r17, 10)), 16));
        Iterator r19 = r17.iterator();
    L27:
        if (r19.hasNext() == false) goto L32;
        Object r20 = r19.next();
        Map r21 = (Map) ZeusTransformUtils.preCheckCast(r18, Map.class, "com.obric.memorydata.plugin");
        List r22 = (List) ZeusTransformUtils.preCheckCast(r12.get(Long.valueOf(((Number) ZeusTransformUtils.preCheckCast(r20, Number.class, "com.obric.memorydata.plugin")).longValue())), List.class, "com.obric.memorydata.plugin");
        if (r22 != null) goto L31;
        r22 = CollectionsKt.emptyList();
    L31:
        r21.put(r20, r22);
        goto L27
    L32:
        int r110 = com.obric.memorydata.personalcontext.bridge.a.a((Map) ZeusTransformUtils.preCheckCast(r18, Map.class, "com.obric.memorydata.plugin"), new $$Lambda$AppEntityIndexBridgeAPIImpl$W_CznVILhiZRfbU13Q_APSQplQ(r1), new $$Lambda$AppEntityIndexBridgeAPIImpl$t72K4QmSYn4j_x7ZnhA44WkHnj8(r1, r7));
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "semantic index reconciliation removed=" + r110 + " deferred=" + (r6.size() - r110), false, 4, null);
        return r110;
    L12:
        if (t.f9438a.a(r9, r6) == true) goto L15;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "semantic keyword index reconciliation deferred rawCount=" + r6.size(), null, 4, null);
        return 0;
    }

    private static final boolean reconcileSemanticIndex$lambda$52(SemanticTextCopilotDao r2, long r3) {
        SemanticTextCopilotDao r4 = (SemanticTextCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, SemanticTextCopilotDao.class, "com.obric.memorydata.plugin");
        return PersonalContextAPI.INSTANCE.deleteVectorCopilotItem(r4.getTableName(), r3);
    }

    private static final Unit reconcileSemanticIndex$lambda$53(SemanticTextCopilotDao r2, int r3, List r4) {
        SemanticTextCopilotDao r5 = (SemanticTextCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, SemanticTextCopilotDao.class, "com.obric.memorydata.plugin");
        List<Long> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "rawDbIds");
        r5.deleteByRawDbIds(r6);
        com.obric.memorydata.database.manager.c.f9561a.b(r3).deleteAllByRawDbIds(r6, r3);
        return Unit.INSTANCE;
    }

    private final void scheduleLocationRetry(IndexPendingDao r10, cd r11, String r12) {
        IndexPendingDao r1 = (IndexPendingDao) ZeusTransformUtils.wrapperContextForParams(r10, IndexPendingDao.class, "com.obric.memorydata.plugin");
        int r13 = Integer.MAX_VALUE;
        if (r11.n() == Integer.MAX_VALUE) goto L6;
        r13 = r11.n() + 1;
    L6:
        long[] r3 = LOCATION_RETRY_DELAYS_MS;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "schedule location retry, dbType=" + r12 + " retryCount=" + r13 + " updated=" + r1.updateRetrySchedule(r11.a(), r11.d(), r13, System.currentTimeMillis() + r3[RangesKt.coerceIn(r13 - 1, 0, ArraysKt.getLastIndex(r3))]), false, 4, null);
    }

    private final void trackEntityIndexV2(long r12, int r14, boolean r15) {
        Object r11 = trackEntityLock;
        monitor-enter(r11);
        RunLog.INSTANCE.debug(TAG, "trackEntityIndex called, rawDbId: " + r12 + ", entityType: " + r14);     // Catch: Throwable -> L37
        IAppEntityRawDbDao<com.obric.memorydata.database.entity.d> r16 = s.a().getRawDaoByEntityType(r14);     // Catch: Throwable -> L37
        if (r16 == null) goto L35;
        com.obric.memorydata.database.entity.d r17 = (com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r16.queryById(r12), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L37
        if (r17 == null) goto L35;
        EntityIndexRecordInfo r0 = com.obric.memorydata.database.util.b.f9624a.a(r17);     // Catch: Throwable -> L37
        if (r15 == true) goto L11;
    L26:
        if (r0 == null) goto L28;
        r0.setTotalIndexCost(new IndexTaskCostInfo(com.obric.memorydata.database.util.b.f9624a.c(null), 0, System.currentTimeMillis(), false, 8, null));     // Catch: Throwable -> L37
        com.obric.memorydata.database.util.b.f9624a.a(r0, r17);     // Catch: Throwable -> L37
    L28:
        int r13 = 0;
        Iterator r18 = ((Iterable) ZeusTransformUtils.preCheckCast(com.obric.memorydata.database.manager.c.f9561a.a(), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L37
    L30:
        if (r18.hasNext() == false) goto L32;
        r13 = r13 + com.obric.memorydata.database.manager.c.f9561a.a((String) ZeusTransformUtils.preCheckCast(r18.next(), String.class, "com.obric.memorydata.plugin")).queryAllCount();     // Catch: Throwable -> L37
        goto L30
    L32:
        if (r13 != 0) goto L34;
        com.obric.memorydata.database.util.b.f9624a.c();     // Catch: Throwable -> L37
    L34:
        Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L37
        goto L35
    L11:
        if (r17.getType() != 301) goto L22;
        if (ZeusTransformUtils.instanceOf(r17, hb.class) == false) goto L22;
        if (Intrinsics.areEqual(((hb) ZeusTransformUtils.preCheckCast(r17, hb.class, "com.obric.memorydata.plugin")).b(), "VIDEO") == false) goto L22;
        if (INSTANCE.onTrackVideoTypePhotoEntity(((hb) ZeusTransformUtils.preCheckCast(r17, hb.class, "com.obric.memorydata.plugin")).getId()) == false) goto L26;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "trackEntityIndexV2, rawDbId: " + r12 + ", video frame not finish, return", false, 4, null);     // Catch: Throwable -> L37
        monitor-exit(r11);
        return;
    L22:
        if (r17.getType() != (-304)) goto L26;
        if (ZeusTransformUtils.instanceOf(r17, hr.class) == false) goto L26;
        INSTANCE.onTrackVideoFrameEntity((hr) ZeusTransformUtils.preCheckCast(r17, hr.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L37
    L35:
        monitor-exit(r11);
        return;
    L37:
        th = move-exception;
        throw th;
    }

    private final void trackIndexFailed(long r2, int r4, String r5, String r6) {
        JSONObject r1 = new JSONObject();
        r1.put("rawDbId", r2);
        r1.put("entityType", r4);
        if (com.obric.memorydata.database.util.b.f9624a.a() == false) goto L5;
        r1.put("isEvaluationMode", com.obric.memorydata.database.util.b.f9624a.a());
    L5:
        if (r6 == null) goto L7;
        r1.put("buildType", r6);
    L7:
        if (r5 == null) goto L9;
        r1.put("columnName", r5);
    L9:
        Tracker.INSTANCE.reportEvent("entity_index_failed_event", r1);
    }

    private final String uidOf(Integer r10) {
        if (r10 != null) goto L5;
        return "";
    L5:
        if (r10.intValue() != 0) goto L8;
        return "";
    L8:
        if (Intrinsics.areEqual(com.obric.memorydata.database.manager.c.f9561a.a(r10.intValue()), "USER") == false) goto L24;
        String r0 = AppContext.INSTANCE.getUserId();
        boolean r3 = true;
        if (AppContext.INSTANCE.isLogin() == true) goto L12;
    L16:
        r3 = false;
    L17:
        if (r3 == true) goto L20;
        r0 = null;
    L20:
        if (r0 != null) goto L25;
        AppEntityIndexBridgeAPIImpl r9 = (AppEntityIndexBridgeAPIImpl) ZeusTransformUtils.preCheckCast(this, AppEntityIndexBridgeAPIImpl.class, "com.obric.memorydata.plugin");
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "uidOf failed, user entityType=" + r10 + " but user is not login", null, 4, null);
        return null;
    L25:
        return r0;
    L12:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L16;
        if (Intrinsics.areEqual(r0, "0") == true) goto L16;
    L24:
        return "";
    }

    private final List<String> visibleMetaFullContentUids() {
        List r3 = CollectionsKt.createListBuilder();
        r3.add("");
        String r0 = AppContext.INSTANCE.getUserId();
        if (AppContext.INSTANCE.isLogin() == false) goto L10;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L10;
        if (Intrinsics.areEqual(r0, "0") == true) goto L10;
        r3.add(r0);
    L10:
        return CollectionsKt.build(r3);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAppEntityIndexBridgeAPI
    public void deleteIndex(List<String> r9, int r10, String r11) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "entityIds");
        Intrinsics.checkNotNullParameter(r11, ObricMemoryConstants.KEY_PACKAGE_NAME);
        IEntityManager.a.a((IEntityManager) ZeusTransformUtils.preCheckCast(EntityManager.INSTANCE, IEntityManager.class, "com.obric.memorydata.plugin"), r2, r10, r11, null, 8, null);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAppEntityIndexBridgeAPI
    public void deleteMetaFullContentKeyword(int r23, List<Long> r24) {
        List<Long> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r24, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "rawDbIdList");
        FullTextSearchSchema r3 = com.obric.memorydata.database.util.c.f9626a.c();
        MetaFullContentKeywordCopilotDao r4 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getMetaFullContentKeywordCopilotDao();
        String r5 = uidOf(Integer.valueOf(r23));
        if (r5 != null) goto L5;
        return;
    L5:
        int r7 = 0;
    L7:
        if (r7 >= 5) goto L52;
        List r8 = CollectionsKt.createListBuilder();
        r8.addAll((Collection) ZeusTransformUtils.preCheckCast(r4.queryByRawDbIdsAndEntityTypeAndUid(r1, r23, r5), Collection.class, "com.obric.memorydata.plugin"));
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L11;
        boolean r9 = true;
    L13:
        if (r9 == false) goto L15;
        r8.addAll((Collection) ZeusTransformUtils.preCheckCast(r4.queryByRawDbIdsAndEntityTypeAndUid(r1, r23, ""), Collection.class, "com.obric.memorydata.plugin"));
    L15:
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.build(r8), Iterable.class, "com.obric.memorydata.plugin");
        HashSet r11 = new HashSet();
        ArrayList r12 = new ArrayList();
        Iterator r13 = r10.iterator();
    L17:
        if (r13.hasNext() == false) goto L21;
        Object r14 = r13.next();
        if (r11.add(Long.valueOf(((dl) ZeusTransformUtils.preCheckCast(r14, dl.class, "com.obric.memorydata.plugin")).a())) == false) goto L17;
        r12.add(r14);
        goto L17
    L21:
        List r15 = (List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.memorydata.plugin");
        if (r7 <= 0) goto L24;
        String r16 = ", retry: " + r7;
    L25:
        r7 = r7 + 1;
        RunLog.INSTANCE.debug(TAG, "deleteMetaFullContentKeyword called, entityType: " + r23 + ", rawDbIdList: " + r1 + ", copilotEntityList size: " + r15.size() + ' ' + r16);
        if (r15.isEmpty() == true) goto L27;
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin");
        Collection r17 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r18 = r6.iterator();
    L30:
        if (r18.hasNext() == false) goto L32;
        r17.add(Long.valueOf(((dl) ZeusTransformUtils.preCheckCast(r18.next(), dl.class, "com.obric.memorydata.plugin")).a()));
        goto L30
    L32:
        List<Long> r19 = (List) ZeusTransformUtils.preCheckCast(r17, List.class, "com.obric.memorydata.plugin");
        if (t.f9438a.a(r3, r19) == true) goto L35;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "deleteMetaFullContentKeyword failed, entityType: " + r23 + ", rawDbIdList: " + r1 + ", keywordIds: " + r19 + ' ' + r16, null, 4, null);
        goto L7
    L35:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "deleteMetaFullContentKeyword success, entityType: " + r23 + ", rawDbIdList: " + r1 + ", keywordIds: " + r19 + ' ' + r16, false, 4, null);
        r4.deleteByRawDbIdsAndUid(r1, r23, r5);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L38;
        boolean r20 = true;
    L39:
        if (r20 == false) goto L51;
        r4.deleteByRawDbIdsAndUid(r1, r23, "");
        return;
    L51:
        return;
    L38:
        r20 = false;
        goto L39
    L27:
        return;
    L24:
        r16 = "";
        goto L25
    L11:
        r9 = false;
        goto L13
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAppEntityIndexBridgeAPI
    public List<Long> executeIndexTask(List<Long> r3) {
        List<Long> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "pendingIdList");
        return executeIndexTask(r4, null);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAppEntityIndexBridgeAPI
    public List<Long> executeIndexTask(List<Long> r7, String r8) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "pendingIdList");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "executeIndexTask legacy api called, ignore pendingIds size: " + r6.size(), null, 4, null);
        return CollectionsKt.emptyList();
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAppEntityIndexBridgeAPI
    public Map<String, List<Long>> executeIndexTaskByDbType(Map<String, ? extends List<Long>> r3) {
        Map<String, ? extends List<Long>> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "pendingIdsByDbType");
        return executeIndexTaskByDbType(r4, null);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAppEntityIndexBridgeAPI
    public Map<String, List<Long>> executeIndexTaskByDbType(Map<String, ? extends List<Long>> r11, String r12) {
        Map<String, ? extends List<Long>> r13 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r13, "pendingIdsByDbType");
        y.a($$Lambda$AppEntityIndexBridgeAPIImpl$7sSceWNGdeBfi1MGRrkvjbe8dSw.INSTANCE, $$Lambda$AppEntityIndexBridgeAPIImpl$tgcBX4v6uqiega2cH8eMozaZvNk.INSTANCE);
        Map<String, List<Long>> r10 = normalizePendingIdsByDbType(r13);
        RunLog.INSTANCE.debug(TAG, "executeIndexTask called, pendingIdsByDbType: " + r10);
        final EntityIndexEngine r14 = s.a();
        Map<String, List<Long>> r0 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator<Map.Entry<String, List<Long>>> r15 = r10.entrySet().iterator();
    L4:
        if (r15.hasNext() == false) goto L16;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r15.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        final String r3 = (String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.memorydata.plugin");
        List<Long> r4 = (List) ZeusTransformUtils.preCheckCast(r2.getValue(), List.class, "com.obric.memorydata.plugin");
        if (r4.isEmpty() == false) goto L9;
    L7:
        List<Long> r5 = CollectionsKt.emptyList();
    L8:
        r0.put(r3, r5);
        goto L4
    L9:
        AppEntityIndexBridgeAPIImpl r6 = INSTANCE;
        if (r6.isIndexConsumable(r3) == true) goto L12;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "index is not consumable, dbType=" + r3, null, 4, null);
        goto L7
    L12:
        final IndexPendingDao r7 = r6.getIndexPendingDao(r3);
        if (r7 == null) goto L7;
        r5 = r6.basePowerIndex(r3, r4, r12, new $$Lambda$AppEntityIndexBridgeAPIImpl$kmaMvoWASW96UdJ3VuV3vckN5sQ(r3, r7, r14));
        goto L8
    L16:
        return r0;
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAppEntityIndexBridgeAPI
    public Object getFeature(String r1) {
        Intrinsics.checkNotNullParameter(r1, "featureName");
        return com.obric.memorydata.personalcontext.d.f12081a.a(r1);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAppEntityIndexBridgeAPI
    public boolean indexEntity(final String r2) {
        Intrinsics.checkNotNullParameter(r2, "entityDataJson");
        Boolean r1 = (Boolean) ZeusTransformUtils.preCheckCast(y.a(new $$Lambda$AppEntityIndexBridgeAPIImpl$1ZYN6WXmPLPO3PFHH7UwGrErYqM(r2), new $$Lambda$AppEntityIndexBridgeAPIImpl$FHpgwaxo8v6TxtwdRcIWtehOZKQ(r2)), Boolean.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L7;
        return false;
    L7:
        return r1.booleanValue();
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAppEntityIndexBridgeAPI
    public boolean insertCopilotText(int r37, long r38, String r40, String r41) {
        String r12 = "columnName";
        Intrinsics.checkNotNullParameter(r40, "columnName");
        Intrinsics.checkNotNullParameter(r41, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        EntityIndexEngine r1 = s.a();
        IAppEntityRawDbDao<com.obric.memorydata.database.entity.d> r2 = r1.getRawDaoByEntityType(r37);
        if (r2 == null) goto L5;
        com.obric.memorydata.database.entity.d r15 = (com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r2.queryById(r38), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin");
    L6:
        IAppEntityVectorCopilotDao<com.obric.memorydata.database.entity.i> r7 = r1.getTextVectorCopilotDao(r37);
        boolean r6 = true;
        if (r37 == 701) goto L9;
    L11:
        boolean r16 = false;
    L12:
        if (r16 == false) goto L23;
        if (r7 == null) goto L21;
        Collection r3 = r7.queryByRawDbIdAndColumns(r38, SetsKt.setOf("fullContent"));
        if (r3 == null) goto L21;
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r8 = r4.iterator();
    L18:
        if (r8.hasNext() == false) goto L20;
        r5.add(Long.valueOf(((com.obric.memorydata.database.entity.i) ZeusTransformUtils.preCheckCast(r8.next(), com.obric.memorydata.database.entity.i.class, "com.obric.memorydata.plugin")).a()));
        goto L18
    L20:
        List r9 = (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin");
    L22:
        if (r9 == null) goto L23;
    L24:
        List r10 = r9;
        List r11 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L124;
        ArrayList r13 = new ArrayList();
        if (r37 != (-306)) goto L29;
        r13 = r13;
        r11 = r11;
        r10 = r10;
        boolean r17 = false;
        r12 = "columnName";
        r13.addAll((Collection) ZeusTransformUtils.preCheckCast(t.a.a(t.f9438a, r41, 0, ChunkType.DEFAULT.toString(), 2, null), Collection.class, "com.obric.memorydata.plugin"));
    L47:
        EmbeddingState r19 = com.obric.memorydata.personalcontext.util.c.f12363a.b();
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        boolean r18 = r17;
    L49:
        if (r14.hasNext() == false) goto L123;
        String r20 = (String) ZeusTransformUtils.preCheckCast(r14.next(), String.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.database.entity.i r0 = r15.convertToTextVectorCopilotEntity(r40, r20);
        String r21 = TAG;
        RunLog.INSTANCE.debug(TAG, "insertCopilotText called, entityType: " + r37 + ", rawDbId: " + r38 + ", columnName: " + r40 + ", text: " + r20);
        if (r0 == null) goto L121;
        if (r7 == null) goto L121;
        long r22 = r7.insert(r0);
        if (r16 == false) goto L56;
        List r23 = r11;
        r23.add(Long.valueOf(r22));
    L57:
        RunLog.INSTANCE.debug(TAG, "insertCopilotText id: " + r22);
        int r24 = 1;
        boolean r110 = true;
    L58:
        float[] r25 = null;
        float[] r30 = null;
    L59:
        if (r24 <= 0) goto L90;
        int r26 = r24 - 1;
        int r27 = a.f12040a[r19.ordinal()];     // Catch: AIKernelRunModelException -> L74
        if (r27 != 1) goto L64;
        List r32 = r23;
        String r35 = r21;
        long r33 = r22;
        String r28 = r20;
        IAppEntityVectorCopilotDao<com.obric.memorydata.database.entity.i> r42 = r7;
        r25 = t.f9438a.a(r37, r38, r28, true, true);     // Catch: AIKernelRunModelException -> L72
    L71:
        r7 = r42;
        r24 = r26;
        r20 = r28;
        r23 = r32;
        r22 = r33;
        r21 = r35;
        goto L59
    L64:
        if (r27 == 2) goto L69;
        r32 = r23;
        r33 = r22;
        r35 = r21;
        r28 = r20;
        r42 = r7;
        r25 = t.f9438a.a(r37, r38, r20, true, true);     // Catch: AIKernelRunModelException -> L72
        t.a r29 = t.f9438a;     // Catch: AIKernelRunModelException -> L72
    L68:
        r30 = r29.a(r37, r38, r28, true, false);     // Catch: AIKernelRunModelException -> L72
    L72:
        e = e;
    L76:
        AIKernelRunModelException r31 = e;
        String r34 = r35;
        RunLog.INSTANCE.error(r34, "insertCopilotText AIKernelRunModelException", (Throwable) ZeusTransformUtils.preCheckCast(r31, Throwable.class, "com.obric.memorydata.plugin"));
        if (r31.getDelayTime() > 0) goto L133;
    L83:
        if (r110 == false) goto L85;
        r24 = 5;
        r110 = r17;
        String r36 = r12;
    L89:
        r7 = r42;
        r12 = r36;
        r21 = r34;
        r20 = r28;
        r23 = r32;
        r22 = r33;
        goto L58
    L85:
        if (r26 != 0) goto L87;
        JSONObject r39 = new JSONObject();
        r39.put("entityType", r37);
        r39.put("rawDbId", r38);
        r36 = r12;
        r39.put(r36, r40);
        Tracker.INSTANCE.reportEvent("insert_copilot_text_failed_event", r39);
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "insertCopilotText failed after 5 retries", null, 4, null);
    L88:
        r24 = r26;
        goto L89
    L87:
        r36 = r12;
        goto L88
    L133:
        Thread.sleep(r31.getDelayTime());     // Catch: InterruptedException -> L80
    L82:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "insertCopilotText AIKernelRunModelException delayTime: " + r31.getDelayTime() + " finish", false, 4, null);
    L80:
        e = move-exception;
        RunLog.INSTANCE.error(r34, "insertCopilotText InterruptedException", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        goto L82
    L69:
        r32 = r23;
        r35 = r21;
        r33 = r22;
        r28 = r20;
        r42 = r7;
        r29 = t.f9438a;     // Catch: AIKernelRunModelException -> L72
    L74:
        e = e;
        r32 = r23;
        r35 = r21;
        r33 = r22;
        r28 = r20;
        r42 = r7;
        goto L76
    L90:
        List r310 = r23;
        long r311 = r22;
        IAppEntityVectorCopilotDao<com.obric.memorydata.database.entity.i> r43 = r7;
        String r44 = r12;
        String r45 = r21;
        int r46 = a.f12040a[r19.ordinal()];
        boolean r47 = true;
        if (r46 == 1) goto L114;
        if (r46 == 2) goto L106;
        if (r30 == null) goto L102;
        if (r25 == null) goto L102;
        boolean r48 = t.f9438a.a(r43.getTableName(), r311, r30, false);
        RunLog.INSTANCE.debug(r45, "insertCopilotText(model) result: " + r48);
        boolean r49 = t.f9438a.a(r43.getTableName(), r311, r25, true);
        RunLog.INSTANCE.debug(r45, "insertCopilotText(vlm) result: " + r49);
        if (r49 == false) goto L100;
        if (r48 == false) goto L100;
        boolean r50 = true;
    L101:
        RunLog r51 = RunLog.INSTANCE;
        StringBuilder r52 = new StringBuilder().append("insertCopilotText(vlm&model) result: ");
    L108:
        r51.debug(r45, r52.append(r50).toString());
        r18 = r50;
    L122:
        r7 = r43;
        r12 = r44;
        r6 = r47;
        r11 = r310;
    L100:
        r50 = r17;
    L102:
        IRunLog r210 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        Throwable r211 = null;
        int r312 = 4;
        Object r313 = null;
        String r212 = TAG;
        if (r110 == false) goto L105;
        String r213 = "insertCopilotText failed";
    L120:
        IRunLog.a.b(r210, r212, r213, r211, r312, r313);
        r18 = r17;
        goto L122
    L105:
        r213 = "insertCopilotText failed after 5 retries";
        goto L120
    L106:
        if (r30 == null) goto L109;
        r50 = t.f9438a.a(r43.getTableName(), r311, r30, false);
        r51 = RunLog.INSTANCE;
        r52 = new StringBuilder().append("insertCopilotText(model) result: ");
        goto L108
    L109:
        r210 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r211 = null;
        r312 = 4;
        r313 = null;
        r212 = TAG;
        if (r110 == false) goto L112;
        r213 = "insertCopilotText(model) failed";
        goto L120
    L112:
        r213 = "insertCopilotText(model) failed after 5 retries";
        goto L120
    L114:
        if (r25 == null) goto L116;
        r18 = t.f9438a.a(r43.getTableName(), r311, r25, true);
        RunLog.INSTANCE.debug(r45, "insertCopilotText(vlm) result: " + r18);
        goto L122
    L116:
        r210 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r211 = null;
        r312 = 4;
        r313 = null;
        r212 = TAG;
        if (r110 == false) goto L119;
        r213 = "insertCopilotText(vlm) failed";
        goto L120
    L119:
        r213 = "insertCopilotText(vlm) failed after 5 retries";
        goto L120
    L56:
        r23 = r11;
    L121:
        r43 = r7;
        r47 = r6;
        r44 = r12;
        r310 = r11;
        goto L122
    L123:
        IAppEntityVectorCopilotDao<com.obric.memorydata.database.entity.i> r410 = r7;
        List r314 = r11;
    L125:
        if (r16 == false) goto L132;
        final IAppEntityVectorCopilotDao<com.obric.memorydata.database.entity.i> r53 = r410;
        if (r53 == null) goto L132;
        List<Long> r54 = com.obric.memorydata.personalcontext.bridge.a.a(r18, r10, r314);
        boolean r55 = com.obric.memorydata.personalcontext.bridge.a.a(r54, new $$Lambda$AppEntityIndexBridgeAPIImpl$I7unDPtfyVjPQT0JawBdY8mGhFQ(r53), new $$Lambda$AppEntityIndexBridgeAPIImpl$q61Tpo7YbzaxrcswtWSO3oOfyc0(r53));
        if (r55 == true) goto L131;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "replace alarm fullContent vector cleanup failed, rawDbId=" + r38, null, 4, null);
        r18 = r17;
    L131:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "replace alarm fullContent vectors, rawDbId=" + r38 + ", success=" + r18 + ", cleanupSucceeded=" + r55 + ", deleteCount=" + CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast(r54, Iterable.class, "com.obric.memorydata.plugin")).size(), false, 4, null);
    L132:
        return r18;
    L29:
        if (r37 == 201) goto L32;
    L30:
        r13.add(r41);
        r17 = false;
        goto L47
    L32:
        List r56 = StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r41, CharSequence.class, "com.obric.memorydata.plugin"), new String[]{"&&&&&"}, false, 0, 6, null);
        if (r56.size() != 2) goto L30;
        List r57 = StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r56.get(1), CharSequence.class, "com.obric.memorydata.plugin"), new String[]{","}, false, 0, 6, null);
        boolean r58 = false;
        r13.add(r56.get(0));
        Iterator r59 = ((Iterable) ZeusTransformUtils.preCheckCast(r57, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L37:
        if (r59.hasNext() == false) goto L45;
        String r60 = (String) ZeusTransformUtils.preCheckCast(r59.next(), String.class, "com.obric.memorydata.plugin");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r60, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L41;
        boolean r61 = true;
    L42:
        if (r61 == false) goto L44;
        r13.add(r60);
    L44:
        r58 = false;
        goto L37
    L41:
        r61 = false;
        goto L42
    L45:
        r17 = r58;
        goto L47
    L124:
        r314 = r11;
        r10 = r10;
        r410 = r7;
        r17 = false;
        r18 = false;
    L21:
        r9 = null;
    L23:
        r9 = CollectionsKt.emptyList();
        goto L24
    L9:
        if (Intrinsics.areEqual(r40, "fullContent") == false) goto L11;
        r16 = true;
        goto L12
    L5:
        r15 = null;
        goto L6
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAppEntityIndexBridgeAPI
    public boolean insertMetaFullContentKeyword(int r28, long r29, String r31) {
        long r10 = r29;
        Intrinsics.checkNotNullParameter(r31, "fullContent");
        FullTextSearchSchema r13 = com.obric.memorydata.database.util.c.f9626a.c();
        MetaFullContentKeywordCopilotDao r14 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getMetaFullContentKeywordCopilotDao();
        String r15 = uidOf(Integer.valueOf(r28));
        if (r15 != null) goto L5;
        return false;
    L5:
        List r0 = CollectionsKt.createListBuilder();
        r0.addAll((Collection) ZeusTransformUtils.preCheckCast(r14.queryByRawDbIdAndEntityTypeAndUid(r10, r28, r15), Collection.class, "com.obric.memorydata.plugin"));
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L8;
        boolean r1 = true;
    L9:
        String r2 = "";
        if (r1 == false) goto L12;
        r0.addAll((Collection) ZeusTransformUtils.preCheckCast(r14.queryByRawDbIdAndEntityTypeAndUid(r10, r28, ""), Collection.class, "com.obric.memorydata.plugin"));
    L12:
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.build(r0), Iterable.class, "com.obric.memorydata.plugin");
        HashSet r4 = new HashSet();
        ArrayList r5 = new ArrayList();
        Iterator r6 = r3.iterator();
    L14:
        if (r6.hasNext() == false) goto L18;
        Object r7 = r6.next();
        if (r4.add(Long.valueOf(((dl) ZeusTransformUtils.preCheckCast(r7, dl.class, "com.obric.memorydata.plugin")).a())) == false) goto L14;
        r5.add(r7);
        goto L14
    L18:
        List r8 = (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin");
        if (AppContext.INSTANCE.isDebug() == false) goto L21;
        r2 = "fullContent: " + r31;
    L21:
        RunLog.INSTANCE.debug(TAG, "insertMetaFullContentKeyword called, entityType: " + r28 + ", rawDbId: " + r10 + ' ' + r2);
        String r9 = "insertMetaFullContentKeyword fullContent is empty, entityType: ";
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L24;
        FullTextSearchSchema r24 = r13;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r31, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L48;
        boolean r11 = true;
    L49:
        if (r11 == false) goto L52;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "insertMetaFullContentKeyword fullContent is empty, entityType: " + r28 + ", rawDbId: " + r10, false, 4, null);
        return true;
    L52:
        long r12 = r14.insert(new dl(0, r28, r29, r15, 1, null));
    L54:
        if (r12 != (-1)) goto L57;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "insertMetaFullContentKeyword failed, entityType: " + r28 + ", rawDbId: " + r10, null, 4, null);
        return false;
    L57:
        boolean r16 = com.obric.memorydata.database.util.d.insert(r24, CollectionsKt.listOf(new CommonTextSearchDocument(r12, r24.a(), t.f9438a.a(MapsKt.mapOf(new Pair[]{TuplesKt.to("common1", new StringBuilder().append('|').append(r28).append('|').toString()), TuplesKt.to("common2", r31), TuplesKt.to("common3", com.obric.memorydata.database.util.d.a(r15))})))));
        if (r16 == false) goto L60;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, r8), TAG, "insertMetaFullContentKeyword success, entityType: " + r28 + ", rawDbId: " + r10 + ", keywordId: " + r12, false, 4, null);
    L61:
        return r16;
    L60:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, r8), TAG, "insertMetaFullContentKeyword failed, entityType: " + r28 + ", rawDbId: " + r10 + ", keywordId: " + r12, null, 4, null);
        goto L61
    L48:
        r11 = false;
        goto L49
    L24:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r31, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L26;
        int r17 = 1;
    L27:
        int r18 = r17 ^ 1;
        int r19 = r8.size();
    L28:
        if (r18 >= r19) goto L34;
        dl r20 = (dl) ZeusTransformUtils.preCheckCast(r8.get(r18), dl.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "insertMetaFullContentKeyword delete copilotEntity, rawDbId: " + r20.b() + ", copilotEntityId: " + r20.a() + ", entityType: " + r20.getType(), false, 4, null);
        if (t.f9438a.a(r13, CollectionsKt.listOf(Long.valueOf(r20.a()))) == false) goto L32;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "insertMetaFullContentKeyword delete old copilotEntity success, rawDbId: " + r20.b() + ", copilotEntityId: " + r20.a() + ", entityType: " + r20.getType(), false, 4, null);
        r14.delete(r20);
    L33:
        r18 = r18 + 1;
        r9 = r9;
        r19 = r19;
        r13 = r13;
        r14 = r14;
        goto L28
    L32:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "insertMetaFullContentKeyword delete old copilotEntity failed, rawDbId: " + r20.b() + ", copilotEntityId: " + r20.a() + ", entityType: " + r20.getType(), null, 4, null);
        goto L33
    L34:
        String r27 = r9;
        r24 = r13;
        MetaFullContentKeywordCopilotDao r25 = r14;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r31, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L37;
        boolean r21 = true;
    L38:
        if (r21 == false) goto L41;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, r27 + r28 + ", rawDbId: " + r29, false, 4, null);
        return true;
    L41:
        r10 = r29;
        r12 = ((dl) ZeusTransformUtils.preCheckCast(CollectionsKt.first(r8), dl.class, "com.obric.memorydata.plugin")).a();
        if (Intrinsics.areEqual(((dl) ZeusTransformUtils.preCheckCast(CollectionsKt.first(r8), dl.class, "com.obric.memorydata.plugin")).c(), r15) == true) goto L54;
        r25.updateUidByIds(CollectionsKt.listOf(Long.valueOf(r12)), r15);
        goto L54
    L37:
        r21 = false;
        goto L38
    L26:
        r17 = 0;
        goto L27
    L8:
        r1 = false;
        goto L9
    }

    public final boolean isIndexModelReady() {
        boolean r1 = true;
        if (allIndexModelReady == false) goto L7;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "allIndexModelReady is cache", false, 4, null);
        return true;
    L7:
        if (DeviceInfoState.INSTANCE.isSupportVLMEmbedding() == false) goto L9;
    L12:
        boolean r0 = true;
    L13:
        boolean r3 = checkAIkernelModel$default(this, "ocr_service", null, 2, null);
        boolean r8 = isSlowEntityIndexModelReady();
        if (r0 == false) goto L18;
        if (r3 == false) goto L18;
        if (r8 == false) goto L18;
    L19:
        allIndexModelReady = r1;
        return r1;
    L18:
        r1 = false;
        goto L19
    L9:
        if (checkAIkernelModel$default(this, "memory_text_embedding_v2", null, 2, null) == true) goto L12;
        r0 = false;
        goto L13
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAppEntityIndexBridgeAPI
    public boolean isSlowEntityIndexModelReady() {
        boolean r1 = true;
        if (allSlowEntityIndexModelReady == false) goto L7;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "allSlowEntityIndexModelReady is cache", false, 4, null);
        return true;
    L7:
        if (DeviceInfoState.INSTANCE.isSupportVLMEmbedding() == false) goto L9;
    L12:
        boolean r0 = true;
    L14:
        if (DeviceInfoState.INSTANCE.isSupportVLMEmbedding() == false) goto L16;
    L19:
        boolean r5 = true;
    L21:
        if (DeviceInfoState.INSTANCE.isSupportVLM() == true) goto L24;
    L22:
        boolean r8 = true;
    L37:
        if (r0 == false) goto L41;
        if (r5 == false) goto L41;
        if (r8 == false) goto L41;
    L42:
        allSlowEntityIndexModelReady = r1;
        return r1;
    L41:
        r1 = false;
        goto L42
    L24:
        if (checkAIkernelModel$default(this, "vlm_local", null, 2, null) == true) goto L26;
    L36:
        r8 = false;
        goto L37
    L26:
        if (checkAIkernelModel("vlm_local", "caption") == false) goto L36;
        if (checkAIkernelModel("vlm_local", LocationMonitorConst.TAG) == false) goto L36;
        if (checkAIkernelModel("vlm_local", "knowledge_graph") == false) goto L36;
        if (DeviceInfoState.INSTANCE.isSupportVLMEmbedding() == false) goto L22;
        if (checkAIkernelModel("vlm_local", "embedding") == false) goto L36;
    L16:
        if (checkAIkernelModel$default(this, "video_clip", null, 2, null) == true) goto L19;
        r5 = false;
        goto L21
    L9:
        if (checkAIkernelModel$default(this, "clip_image_embedding_v2_edge", null, 2, null) == true) goto L12;
        r0 = false;
        goto L14
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAppEntityIndexBridgeAPI
    public List<Long> queryByKeywordIndex(int r8, List<String> r9, String r10, long r11, List<Long> r13) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "columns");
        Intrinsics.checkNotNullParameter(r10, "keyword");
        Intrinsics.checkNotNullParameter(r6, "targetIds");
        RunLog.INSTANCE.debug(TAG, "queryByKeywordIndex called, entityType: " + r8 + ", keyword: " + r10);
        FullTextSearchSchema r1 = s.a().getKeywordSchema(r8);
        if (r1 != null) goto L7;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "IndexEngine getKeywordSchema return null, entityType: " + r8, null, 4, null);
        return CollectionsKt.emptyList();
    L7:
        return com.obric.memorydata.database.util.d.a(r1, r10, r3, r11, r6);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAppEntityIndexBridgeAPI
    public List<Long> queryByKeywordIndexForMultiKeywords(int r9, Map<String, ? extends List<String>> r10, Map<String, ? extends List<String>> r11, Map<String, ? extends List<String>> r12, long r13, List<Long> r15) {
        Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.memorydata.plugin");
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.memorydata.plugin");
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.memorydata.plugin");
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "keywordToColumns");
        Intrinsics.checkNotNullParameter(r3, "keywordToSynonymColumns");
        Intrinsics.checkNotNullParameter(r4, "keywordToHomonymColumns");
        Intrinsics.checkNotNullParameter(r7, "targetIds");
        RunLog.INSTANCE.debug(TAG, "queryByKeywordIndexForMultiKeywords called, entityType: " + r9);
        FullTextSearchSchema r1 = s.a().getKeywordSchema(r9);
        if (r1 != null) goto L7;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "IndexEngine getKeywordSchema return null, entityType: " + r9, null, 4, null);
        return CollectionsKt.emptyList();
    L7:
        return com.obric.memorydata.database.util.d.a(r1, r2, r3, r4, r13, r7);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAppEntityIndexBridgeAPI
    public Map<MatchType, Map<String, List<Map<Long, List<String>>>>> queryMatchedColumns(int r17, Map<String, ? extends List<String>> r18, Map<String, ? extends List<String>> r19, Map<String, ? extends List<String>> r20, long r21, List<Long> r23, boolean r24) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r18, Map.class, "com.obric.memorydata.plugin");
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r19, Map.class, "com.obric.memorydata.plugin");
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r20, Map.class, "com.obric.memorydata.plugin");
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r23, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "keywordToColumns");
        Intrinsics.checkNotNullParameter(r5, "keywordToSynonymColumns");
        Intrinsics.checkNotNullParameter(r6, "keywordToHomonymColumns");
        Intrinsics.checkNotNullParameter(r9, "targetIds");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "queryMatchedColumns called, entityType: " + r17, false, 4, null);
        FullTextSearchSchema r3 = s.a().getKeywordSchema(r17);
        if (r3 != null) goto L7;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "IndexEngine getKeywordSchema return null, entityType: " + r17, null, 4, null);
        return MapsKt.emptyMap();
    L7:
        return com.obric.memorydata.database.util.d.a(r3, r4, r5, r6, r21, r9, r24);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAppEntityIndexBridgeAPI
    public List<Map<Long, Double>> queryMetaInfoFullContentByKeyword(Integer r13, List<Integer> r14, List<String> r15, long r16) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "matchTypes");
        Intrinsics.checkNotNullParameter(r5, "keywords");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "queryMetaInfoFullContentByKeyword called, entityType: " + r13 + ", matchTypes: " + r4, false, 4, null);
        return com.obric.memorydata.database.util.d.a(com.obric.memorydata.database.util.c.f9626a.c(), r13, r4, r5, r16, visibleMetaFullContentUids());
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAppEntityIndexBridgeAPI
    public List<Map<Long, Double>> queryMetaInfoFullContentByKeywordWithKeys(Integer r15, List<Integer> r16, List<String> r17, List<Long> r18, long r19) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.memorydata.plugin");
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.memorydata.plugin");
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "matchTypes");
        Intrinsics.checkNotNullParameter(r3, "keywords");
        Intrinsics.checkNotNullParameter(r0, "keys");
        List r7 = CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin"));
        if (r7.isEmpty() == true) goto L14;
        if (r19 <= 0) goto L14;
        if (r7.size() <= 1000) goto L11;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "queryMetaInfoFullContentByKeywordWithKeys rejected: keyCount=" + r7.size() + ", maxKeyCount=1000", null, 4, null);
        return CollectionsKt.emptyList();
    L11:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "queryMetaInfoFullContentByKeywordWithKeys called, entityType: " + r15 + ", matchTypes: " + r2 + ", keyCount: " + r7.size() + ", limit: " + r19, false, 4, null);
        return com.obric.memorydata.database.util.d.a(com.obric.memorydata.database.util.c.f9626a.c(), r15, r2, r3, r19, visibleMetaFullContentUids(), r7);
    L14:
        return CollectionsKt.emptyList();
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAppEntityIndexBridgeAPI
    @Deprecated(message = "not used")
    public void trackEntityIndex(long r1, int r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "type");
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAppEntityIndexBridgeAPI
    public void trackEntityIndexV2(long r2, int r4) {
        trackEntityIndexV2(r2, r4, true);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAppEntityIndexBridgeAPI
    @Deprecated(message = "not used")
    public void trackSlowEntityIndexMatchCondition(boolean r1) {
    }
}
