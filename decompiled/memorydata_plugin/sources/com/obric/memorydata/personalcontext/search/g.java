package com.obric.memorydata.personalcontext.search;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.Ensure;
import com.bytedance.crash.entity.EventBody;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.common.Ext;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.EntityType;
import com.obric.capabilitykit.entity.app.PhotoEntity;
import com.obric.capabilitykit.entity.app.RecordingEntity;
import com.obric.capabilitykit.entity.app.ScheduleEntity;
import com.obric.capabilitykit.entity.app.VideoFrame;
import com.obric.capabilitykit.entity.enums.AssetTypeEnum;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.capabilitykit.entity.search.InAppSearchEntity;
import com.obric.capabilitykit.entity.search.InAppSearchEntityParam;
import com.obric.capabilitykit.entity.search.InAppSearchResult;
import com.obric.capabilitykit.entity.search.InAppSearchResultWithoutEntity;
import com.obric.capabilitykit.entity.search.InAppSearchSimpleData;
import com.obric.capabilitykit.search.IAppSearchCallback;
import com.obric.capabilitykit.search.global.IGlobalSearchCallback;
import com.obric.memorydata.constants.AppInfo;
import com.obric.memorydata.database.dao.IAppEntityRawDbDao;
import com.obric.memorydata.database.dao.MemoryEntityRawDbDao;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.database.entity.RawMemoryEntity;
import com.obric.memorydata.database.entity.gu;
import com.obric.memorydata.database.entity.gw;
import com.obric.memorydata.database.entity.hb;
import com.obric.memorydata.database.entity.hr;
import com.obric.memorydata.database.index.s;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.database.model.EntitySearchRecordInfo;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.device.DeviceInfoState;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.personalcontext.api.EvaluationService;
import com.obric.memorydata.personalcontext.log.EvaluationResult;
import com.obric.memorydata.personalcontext.q;
import com.obric.memorydata.personalcontext.search.entity.CallMode;
import com.obric.memorydata.personalcontext.search.entity.SearchRequest;
import com.obric.memorydata.personalcontext.search.entity.SearchResultEntry;
import com.obric.memorydata.personalcontext.util.EmbeddingState;
import com.obric.memorydata.sdk.entity.search.AssistantQuResult;
import com.obric.memorydata.sdk.entity.search.SearchResponse;
import com.obric.memorydata.task.impl.TaskResult;
import com.obric.memorydata.utils.ab;
import com.obric.memorydata.utils.handler.GlobalHandlerUtil;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.i;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000î\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001yB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0005J0\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u00052\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\rJZ\u0010'\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020)2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00050+2\u0006\u0010,\u001a\u00020-2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/2\b\b\u0002\u00100\u001a\u0002012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00103\u001a\u0004\u0018\u000104H\u0086@¢\u0006\u0002\u00105J8\u00106\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020)2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u0005072\u0006\u0010,\u001a\u0002082\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/H\u0086@¢\u0006\u0002\u00109J\u000e\u0010:\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u0005J\u000e\u0010<\u001a\u00020!H\u0082@¢\u0006\u0002\u0010=J\u001e\u0010>\u001a\u0004\u0018\u00010\u00052\b\u0010\"\u001a\u0004\u0018\u00010\u00052\b\u00102\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010?\u001a\u00020!H\u0002J\u0012\u0010@\u001a\u00020\u00052\b\u0010\"\u001a\u0004\u0018\u00010\u0005H\u0002J6\u0010A\u001a\b\u0012\u0004\u0012\u00020B0\u001b2\u0006\u0010(\u001a\u00020)2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0002J6\u0010D\u001a\b\u0012\u0004\u0012\u00020E0\u001b2\u0006\u0010(\u001a\u00020)2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0002J^\u0010F\u001a\b\u0012\u0004\u0012\u00020G0\u001b2\u0006\u0010(\u001a\u00020)2\n\b\u0002\u0010H\u001a\u0004\u0018\u00010I2\n\b\u0002\u0010J\u001a\u0004\u0018\u00010K2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/2\b\b\u0002\u00100\u001a\u0002012\b\b\u0002\u0010L\u001a\u00020\u00052\b\b\u0002\u0010M\u001a\u00020!H\u0086@¢\u0006\u0002\u0010NJ2\u0010O\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020G0P0\u001b2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u0005J&\u0010R\u001a\b\u0012\u0004\u0012\u00020G0\u001b2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u0005JF\u0010S\u001a\u0004\u0018\u00010G2\u0006\u0010T\u001a\u00020U2\f\u0010V\u001a\b\u0012\u0004\u0012\u00020U0W2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0016\b\u0002\u0010X\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020Y\u0018\u00010\rH\u0002J8\u0010Z\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020Y\u0018\u00010\r2\u0006\u0010[\u001a\u00020\u000e2\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020U0\u001b2\n\b\u0002\u0010]\u001a\u0004\u0018\u00010YH\u0002J \u0010^\u001a\n\u0012\u0004\u0012\u00020_\u0018\u00010\u001b2\u0006\u0010`\u001a\u00020a2\u0006\u0010b\u001a\u00020\u001cH\u0002J\u001c\u0010c\u001a\b\u0012\u0004\u0012\u00020d0\u001b2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0002J\u001a\u0010e\u001a\b\u0012\u0004\u0012\u00020f0\u001b2\f\u0010b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bJ:\u0010g\u001a\u00020\u001d2\b\u0010.\u001a\u0004\u0018\u00010/2\u0006\u0010h\u001a\u00020i2\u0006\u0010j\u001a\u00020i2\u0006\u0010k\u001a\u00020i2\u0006\u0010l\u001a\u00020m2\b\b\u0002\u0010n\u001a\u00020!J\u0010\u0010o\u001a\u0004\u0018\u00010\u00052\u0006\u0010p\u001a\u00020\u0005J\u0018\u0010q\u001a\b\u0012\u0004\u0012\u00020\u00050\u001b2\b\u0010r\u001a\u0004\u0018\u00010\u0001H\u0002J\u0018\u0010s\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\r*\u00020YH\u0002J\u001e\u0010t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\r2\b\u0010r\u001a\u0004\u0018\u00010\u0001H\u0002J\u0012\u0010u\u001a\b\u0012\u0004\u0012\u00020\u00010\u001b*\u00020vH\u0002J\u0014\u0010w\u001a\u0004\u0018\u00010\u00012\b\u0010r\u001a\u0004\u0018\u00010\u0001H\u0002J\u0006\u0010x\u001a\u00020YR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00050\r¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u001d\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00050\r¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0016X\u0082\u0004¢\u0006\u0002\n\u0000RA\u0010\u0018\u001a2\u0012\u0004\u0012\u00020\u0005\u0012(\u0012&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\r\u0012\u0004\u0012\u00020\u001d0\u001a0\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006z"}, d2 = {"Lcom/obric/memorydata/personalcontext/search/EntitySearchUtils;", "", "<init>", "()V", "TAG", "", "IN_APP_SEARCH_PHOTO_TASK_NAME", "KEY_SEARCH_PARAMS", "KEY_SEARCH_TYPE", "KEY_SEARCH_RESULTS", "KEY_PACKAGE_TOTAL_TIME_COST_LOG", "KEY_AUDIO_MEMORY_CONFIGURED", "taskNameToEntityTypeMap", "", "", "getTaskNameToEntityTypeMap", "()Ljava/util/Map;", "entityTypeToTaskNameMap", "getEntityTypeToTaskNameMap", "entityTypeToPackageNameMap", "getEntityTypeToPackageNameMap", "defaultModelsInAppSearch", "", "defaultVLMLoraInAppSearch", "searchOptResultCallback", "Ljava/util/concurrent/ConcurrentHashMap;", "Lkotlin/Function2;", "", "Lcom/obric/memorydata/personalcontext/search/entity/SearchResultEntry;", "", "getSearchOptResultCallback", "()Ljava/util/concurrent/ConcurrentHashMap;", "enablePresetQUResult", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "onReceiveSearchOptResult", "taskId", "result", "extraMap", "sendInAppSearchRequest", Ext.KEY_REQUEST, "Lcom/obric/memorydata/personalcontext/search/entity/SearchRequest;", "taskIds", "Ljava/util/concurrent/CopyOnWriteArrayList;", "callback", "Lcom/obric/capabilitykit/search/IAppSearchCallback;", "entitySearchRecordInfo", "Lcom/obric/memorydata/database/model/EntitySearchRecordInfo;", "callMode", "Lcom/obric/memorydata/personalcontext/search/entity/CallMode;", "businessName", "isBusinessCancelled", "Lcom/obric/memorydata/personalcontext/search/IsBusinessCancelled;", "(Lcom/obric/memorydata/personalcontext/search/entity/SearchRequest;Ljava/util/concurrent/CopyOnWriteArrayList;Lcom/obric/capabilitykit/search/IAppSearchCallback;Lcom/obric/memorydata/database/model/EntitySearchRecordInfo;Lcom/obric/memorydata/personalcontext/search/entity/CallMode;Ljava/lang/String;Lcom/obric/memorydata/personalcontext/search/IsBusinessCancelled;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendGlobalSearchRequest", "", "Lcom/obric/capabilitykit/search/global/IGlobalSearchCallback;", "(Lcom/obric/memorydata/personalcontext/search/entity/SearchRequest;Ljava/util/List;Lcom/obric/capabilitykit/search/global/IGlobalSearchCallback;Lcom/obric/memorydata/database/model/EntitySearchRecordInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDomainNameByTaskName", "inAppSearchTaskName", "checkModelIsReady", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTaskName", "isAudioMemoryConfiguredForCurrentUser", "getSearchControlPrams", "constructInAppSearchResponse", "Lcom/obric/capabilitykit/entity/search/InAppSearchEntity;", "searchResultEntries", "constructInAppSearchResponseWithoutEntity", "Lcom/obric/capabilitykit/entity/search/InAppSearchSimpleData;", "sendSearchRequest", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "quResult", "Lcom/obric/memorydata/sdk/entity/search/AssistantQuResult;", ChatMessage.TYPE_RESPONSE, "Lcom/obric/memorydata/sdk/entity/search/SearchResponse;", "inputType", "isAppFunc", "(Lcom/obric/memorydata/personalcontext/search/entity/SearchRequest;Lcom/obric/memorydata/sdk/entity/search/AssistantQuResult;Lcom/obric/memorydata/sdk/entity/search/SearchResponse;Lcom/obric/memorydata/database/model/EntitySearchRecordInfo;Lcom/obric/memorydata/personalcontext/search/entity/CallMode;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadAppEntityPairBySearchResultEntries", "Lkotlin/Pair;", "scheduleTimeDescriptionMapJson", "loadAppEntitiesBySearchResultEntries", "convertAndProcessRecalledEntities", "sourceRawEntity", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", "entityRawDbDao", "Lcom/obric/memorydata/database/dao/IAppEntityRawDbDao;", "appEntityExtraDataMap", "Lorg/json/JSONObject;", "buildAppEntityExtraDataMap", "type", "rawEntities", "scheduleTimeDescriptionJsonObject", "loadPhotoEntityVideoFrames", "Lcom/obric/capabilitykit/entity/app/VideoFrame;", "rawPhotoEntity", "Lcom/obric/memorydata/database/entity/RawPhotoEntity;", "searchResultEntry", "loadSimpleSearchResultBy", "Lcom/obric/memorydata/personalcontext/search/EntitySearchUtils$SimpleAppEntityData;", "loadMemoryEntityBySearchResultEntry", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "trackSearchPerfInfo", "taskStartTime", "", "taskFinishTimeStamp", "taskExecuteCost", "searchResult", "Lcom/obric/memorydata/task/impl/TaskResult;", "isInAppOptimizedSearch", "getActionNameByDomain", "domain", "parseValueToTextList", EventBody.KEY_VALUE, "toSearchExtraMap", "parseSearchExtraMap", "toSearchExtraList", "Lorg/json/JSONArray;", "parseSearchExtraValue", "getEntitySwitchStatus", "SimpleAppEntityData", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class g {
    public static final g INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, Integer> f12313a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<Integer, String> f12314b = null;
    private static final Map<Integer, String> c = null;
    private static final Set<String> d = null;
    private static final Set<String> e = null;
    private static final ConcurrentHashMap<String, Function2<List<SearchResultEntry>, Map<String, ? extends Object>, Unit>> f = null;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\bHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/personalcontext/search/EntitySearchUtils$SimpleAppEntityData;", "", OaidModel.KEY_ID, "", "createTime", "", "lastModifiedTime", "type", "", "<init>", "(Ljava/lang/String;JJI)V", "getId", "()Ljava/lang/String;", "getCreateTime", "()J", "getLastModifiedTime", "getType", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f12315a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f12316b;
        private final long c;
        private final int d;

        public a(String r2, long r3, long r5, int r7) {
            Intrinsics.checkNotNullParameter(r2, OaidModel.KEY_ID);
            this.f12315a = r2;
            this.f12316b = r3;
            this.c = r5;
            this.d = r7;
        }

        public final String a() {
            return this.f12315a;
        }

        public final long b() {
            return this.f12316b;
        }

        public final long c() {
            return this.c;
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, a.class) == true) goto L8;
            return false;
        L8:
            a r10 = (a) ZeusTransformUtils.preCheckCast(r9, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f12315a, r10.f12315a) == true) goto L12;
            return false;
        L12:
            if (this.f12316b == r10.f12316b) goto L15;
            return false;
        L15:
            if (this.c == r10.c) goto L18;
            return false;
        L18:
            if (this.d == r10.d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int getType() {
            return this.d;
        }

        public int hashCode() {
            return (((((this.f12315a.hashCode() * 31) + Long.hashCode(this.f12316b)) * 31) + Long.hashCode(this.c)) * 31) + Integer.hashCode(this.d);
        }

        public String toString() {
            return "SimpleAppEntityData(id=" + this.f12315a + ", createTime=" + this.f12316b + ", lastModifiedTime=" + this.c + ", type=" + this.d + ')';
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class b<T> implements Comparator {
        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast((Integer) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r2, Pair.class, "com.obric.memorydata.plugin")).getFirst(), Integer.class, "com.obric.memorydata.plugin"), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast((Integer) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r3, Pair.class, "com.obric.memorydata.plugin")).getFirst(), Integer.class, "com.obric.memorydata.plugin"), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class c<T> implements Comparator {
        public c() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast((Integer) ZeusTransformUtils.preCheckCast(((Triple) ZeusTransformUtils.preCheckCast(r2, Triple.class, "com.obric.memorydata.plugin")).getFirst(), Integer.class, "com.obric.memorydata.plugin"), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast((Integer) ZeusTransformUtils.preCheckCast(((Triple) ZeusTransformUtils.preCheckCast(r3, Triple.class, "com.obric.memorydata.plugin")).getFirst(), Integer.class, "com.obric.memorydata.plugin"), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class d<T> implements Comparator {
        public d() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast((Integer) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r2, Pair.class, "com.obric.memorydata.plugin")).getFirst(), Integer.class, "com.obric.memorydata.plugin"), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast((Integer) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r3, Pair.class, "com.obric.memorydata.plugin")).getFirst(), Integer.class, "com.obric.memorydata.plugin"), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class e<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Map f12317a;

        public e(Map r3) {
            this.f12317a = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.Comparator
        public final int compare(T r7, T r8) {
            com.obric.memorydata.database.entity.d r9 = (com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r7, com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin");
            Integer r10 = (Integer) ZeusTransformUtils.preCheckCast(this.f12317a.get(new StringBuilder().append(r9.getType()).append('_').append(r9.getId()).toString()), Integer.class, "com.obric.memorydata.plugin");
            int r0 = Integer.MAX_VALUE;
            if (r10 == null) goto L5;
            int r11 = r10.intValue();
        L6:
            Comparable r12 = (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(r11), Comparable.class, "com.obric.memorydata.plugin");
            com.obric.memorydata.database.entity.d r13 = (com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r8, com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin");
            Integer r6 = (Integer) ZeusTransformUtils.preCheckCast(this.f12317a.get(new StringBuilder().append(r13.getType()).append('_').append(r13.getId()).toString()), Integer.class, "com.obric.memorydata.plugin");
            if (r6 == null) goto L10;
            r0 = r6.intValue();
        L10:
            return ComparisonsKt.compareValues(r12, (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(r0), Comparable.class, "com.obric.memorydata.plugin"));
        L5:
            r11 = Integer.MAX_VALUE;
            goto L6
        }
    }

    static {
        INSTANCE = new g();
        Integer r7 = Integer.valueOf(EntityType.FILE);
        f12313a = MapsKt.mapOf(new Pair[]{TuplesKt.to("in_app_search_photo", 301), TuplesKt.to("in_app_search_album", 302), TuplesKt.to("in_app_search_file", r7)});
        f12314b = MapsKt.mapOf(new Pair[]{TuplesKt.to(301, "in_app_search_photo"), TuplesKt.to(302, "in_app_search_album"), TuplesKt.to(r7, "in_app_search_file")});
        c = MapsKt.mapOf(new Pair[]{TuplesKt.to(301, AppInfo.Gallery.getPackageName()), TuplesKt.to(302, AppInfo.Gallery.getPackageName()), TuplesKt.to(r7, AppInfo.FileManager.getPackageName())});
        d = SetsKt.setOf(new String[]{"memory_text_embedding_v2", "clip_text_embedding_v2_edge"});
        e = SetsKt.setOf("embedding");
        com.obric.memorydata.infra.a.a.f9875a.a("in_app_search_photo");
        f = new ConcurrentHashMap();
    }

    private g() {
    }

    private final AppEntity a(com.obric.memorydata.database.entity.d r11, IAppEntityRawDbDao<com.obric.memorydata.database.entity.d> r12, List<SearchResultEntry> r13, Map<String, ? extends JSONObject> r14) {
        IAppEntityRawDbDao r10 = (IAppEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r12, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin");
        List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        Map r16 = (Map) ZeusTransformUtils.wrapperContextForParams(r14, Map.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.database.entity.d r17 = com.obric.memorydata.personalcontext.poison.g.f12254a.b(r11, r10);
        Long r18 = null;
        if (r17 != null) goto L5;
        return null;
    L5:
        boolean r2 = false;
        if (ZeusTransformUtils.instanceOf(r17, com.obric.memorydata.database.entity.e.class) == false) goto L48;
        Iterator r19 = ((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L9:
        if (r19.hasNext() == false) goto L18;
        Object r4 = r19.next();
        SearchResultEntry r5 = (SearchResultEntry) ZeusTransformUtils.preCheckCast(r4, SearchResultEntry.class, "com.obric.memorydata.plugin");
        if (r5.getId() == ((com.obric.memorydata.database.entity.e) ZeusTransformUtils.preCheckCast(r17, com.obric.memorydata.database.entity.e.class, "com.obric.memorydata.plugin")).getId()) goto L13;
    L15:
        boolean r6 = false;
    L16:
        if (r6 == false) goto L9;
    L19:
        SearchResultEntry r110 = (SearchResultEntry) ZeusTransformUtils.preCheckCast(r4, SearchResultEntry.class, "com.obric.memorydata.plugin");
        if (r110 == null) goto L45;
        List<InAppSearchEntityParam> r111 = r110.getInAppSearchParams();
        if (r111 == null) goto L45;
        Iterable r112 = (Iterable) ZeusTransformUtils.preCheckCast(r111, Iterable.class, "com.obric.memorydata.plugin");
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r113 = r112.iterator();
    L25:
        if (r113.hasNext() == false) goto L44;
        InAppSearchEntityParam r8 = (InAppSearchEntityParam) ZeusTransformUtils.preCheckCast(r113.next(), InAppSearchEntityParam.class, "com.obric.memorydata.plugin");
        if (StringsKt.endsWith(r8.getField(), "CommonPhotoEntity_file", true) == false) goto L33;
        String r9 = r8.getFieldArrayUniqueKey();
        if (r9 == null) goto L31;
        String r20 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getCommonPhotoRawDbDao().queryCaptionById(r9);
    L35:
        List<String> r21 = CollectionsKt.listOfNotNull(r20);
    L43:
        CollectionsKt.addAll(r7, (Iterable) ZeusTransformUtils.preCheckCast(r21, Iterable.class, "com.obric.memorydata.plugin"));
        goto L25
    L31:
        r20 = null;
        goto L35
    L33:
        if (StringsKt.endsWith(r8.getField(), "CommonPhotoEntity_caption", true) == false) goto L37;
    L34:
        r20 = r8.getValue();
        goto L35
    L37:
        if (StringsKt.endsWith(r8.getField(), "Text_content", true) == true) goto L34;
        if (StringsKt.endsWith(r8.getField(), "FileEntity_fullContent", true) == false) goto L42;
        r21 = INSTANCE.a(r8.getValue());
        goto L43
    L42:
        r21 = CollectionsKt.emptyList();
        goto L43
    L44:
        List<String> r114 = (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin");
    L46:
        ((com.obric.memorydata.database.entity.e) ZeusTransformUtils.preCheckCast(r17, com.obric.memorydata.database.entity.e.class, "com.obric.memorydata.plugin")).a(r114);
    L45:
        r114 = CollectionsKt.emptyList();
        goto L46
    L13:
        if (r5.getType() != ((com.obric.memorydata.database.entity.e) ZeusTransformUtils.preCheckCast(r17, com.obric.memorydata.database.entity.e.class, "com.obric.memorydata.plugin")).getType()) goto L15;
        r6 = true;
        goto L16
    L18:
        r4 = null;
    L48:
        if (ZeusTransformUtils.instanceOf(r17, gu.class) == false) goto L101;
        gu r115 = (gu) ZeusTransformUtils.preCheckCast(r17, gu.class, "com.obric.memorydata.plugin");
        Iterator r116 = ((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L51:
        if (r116.hasNext() == false) goto L58;
        Object r22 = r116.next();
        if (((SearchResultEntry) ZeusTransformUtils.preCheckCast(r22, SearchResultEntry.class, "com.obric.memorydata.plugin")).getId() != r115.getId()) goto L55;
        boolean r23 = true;
    L56:
        if (r23 == false) goto L51;
    L59:
        SearchResultEntry r117 = (SearchResultEntry) ZeusTransformUtils.preCheckCast(r22, SearchResultEntry.class, "com.obric.memorydata.plugin");
        Map r24 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        if (r117 == null) goto L79;
        List<InAppSearchEntityParam> r118 = r117.getInAppSearchParams();
        if (r118 == null) goto L79;
        Iterator r119 = ((Iterable) ZeusTransformUtils.preCheckCast(r118, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L65:
        if (r119.hasNext() == false) goto L79;
        InAppSearchEntityParam r25 = (InAppSearchEntityParam) ZeusTransformUtils.preCheckCast(r119.next(), InAppSearchEntityParam.class, "com.obric.memorydata.plugin");
        if (StringsKt.endsWith(r25.getField(), "Text_content", true) == false) goto L65;
        if (r25.getValue() == null) goto L65;
        String r26 = r25.getFieldArrayUniqueKey();
        if (r26 == null) goto L65;
        String r27 = r25.getValue();
        if (r27 == null) goto L65;
        Object r28 = r24.get(r26);
        if (r28 != null) goto L78;
        r28 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r24.put(r26, r28);
    L78:
        ((List) ZeusTransformUtils.preCheckCast(r28, List.class, "com.obric.memorydata.plugin")).add(r27);
    L79:
        List<RecordingEntity> r120 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        if ((!r24.isEmpty()) == false) goto L99;
        IAppEntityRawDbDao<com.obric.memorydata.database.entity.d> r1 = s.a().getRawDaoByEntityType(-307);
        if (r1 == null) goto L98;
        Iterable r29 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r24.keySet(), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin");
        Collection r30 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r29, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r31 = r29.iterator();
    L85:
        if (r31.hasNext() == false) goto L87;
        r30.add((String) ZeusTransformUtils.preCheckCast(r31.next(), String.class, "com.obric.memorydata.plugin"));
        goto L85
    L87:
        Iterator r32 = ((Iterable) ZeusTransformUtils.preCheckCast(r1.queryByEntityIdList((List) ZeusTransformUtils.preCheckCast(r30, List.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L89:
        if (r32.hasNext() == false) goto L98;
        com.obric.memorydata.database.entity.d r33 = (com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r32.next(), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r33, gw.class) == false) goto L89;
        List r34 = (List) ZeusTransformUtils.preCheckCast(r24.get(((gw) ZeusTransformUtils.preCheckCast(r33, gw.class, "com.obric.memorydata.plugin")).getEntityId()), List.class, "com.obric.memorydata.plugin");
        if (r34 != null) goto L95;
        r34 = CollectionsKt.emptyList();
    L95:
        ((gw) ZeusTransformUtils.preCheckCast(r33, gw.class, "com.obric.memorydata.plugin")).a(CollectionsKt.toMutableList((Collection) ZeusTransformUtils.preCheckCast(r34, Collection.class, "com.obric.memorydata.plugin")));
        AppEntity r35 = com.obric.memorydata.personalcontext.poison.g.f12254a.a(r33, r1);
        if (r35 == null) goto L89;
        r120.add((RecordingEntity) ZeusTransformUtils.preCheckCast(r35, RecordingEntity.class, "com.obric.memorydata.plugin"));
    L98:
        AppEntity r121 = r115.a(r120);
    L122:
        if (ZeusTransformUtils.instanceOf(r121, ScheduleEntity.class) == false) goto L171;
        if (r16 == null) goto L171;
        ScheduleEntity r122 = (ScheduleEntity) ZeusTransformUtils.preCheckCast(r121, ScheduleEntity.class, "com.obric.memorydata.plugin");
        JSONObject r3 = (JSONObject) ZeusTransformUtils.preCheckCast(r16.get(r17.getEntityId()), JSONObject.class, "com.obric.memorydata.plugin");
        String r36 = "";
        if (r3 == null) goto L128;
        String r37 = r3.optString("timeDescription");
        if (r37 == null) goto L128;
    L129:
        r122.setTimeDescription(r37);
        ScheduleEntity r123 = (ScheduleEntity) ZeusTransformUtils.preCheckCast(r121, ScheduleEntity.class, "com.obric.memorydata.plugin");
        JSONObject r38 = (JSONObject) ZeusTransformUtils.preCheckCast(r16.get(r17.getEntityId()), JSONObject.class, "com.obric.memorydata.plugin");
        if (r38 == null) goto L133;
        String r39 = r38.optString("rruleDescription");
        if (r39 == null) goto L133;
    L134:
        r123.setRruleDescription(r39);
        JSONObject r124 = (JSONObject) ZeusTransformUtils.preCheckCast(r16.get(r17.getEntityId()), JSONObject.class, "com.obric.memorydata.plugin");
        if (r124 == null) goto L137;
        Long r125 = Long.valueOf(r124.optLong("jumpCalendarPageStartTimeStamp"));
    L139:
        if (r125 != null) goto L141;
    L143:
        ((ScheduleEntity) ZeusTransformUtils.preCheckCast(r121, ScheduleEntity.class, "com.obric.memorydata.plugin")).setJumpCalendarPageStartTimeStamp(r125);
        JSONObject r126 = (JSONObject) ZeusTransformUtils.preCheckCast(r16.get(r17.getEntityId()), JSONObject.class, "com.obric.memorydata.plugin");
        if (r126 == null) goto L146;
        Long r127 = Long.valueOf(r126.optLong("startTimestamp"));
    L147:
        if (r127 != null) goto L149;
    L151:
        ((ScheduleEntity) ZeusTransformUtils.preCheckCast(r121, ScheduleEntity.class, "com.obric.memorydata.plugin")).setStartTimestamp(r127);
        JSONObject r128 = (JSONObject) ZeusTransformUtils.preCheckCast(r16.get(r17.getEntityId()), JSONObject.class, "com.obric.memorydata.plugin");
        if (r128 == null) goto L154;
        Long r129 = Long.valueOf(r128.optLong("endTimestamp"));
    L155:
        if (r129 != null) goto L157;
    L159:
        r18 = r129;
    L160:
        ((ScheduleEntity) ZeusTransformUtils.preCheckCast(r121, ScheduleEntity.class, "com.obric.memorydata.plugin")).setEndTimestamp(r18);
        JSONObject r130 = (JSONObject) ZeusTransformUtils.preCheckCast(r16.get(r17.getEntityId()), JSONObject.class, "com.obric.memorydata.plugin");
        if (r130 == null) goto L167;
        String r131 = r130.optString(WsConstants.KEY_EXTRA);
        if (r131 == null) goto L167;
        r36 = r131;
    L167:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r36, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L169;
        r2 = true;
    L169:
        if (r2 == false) goto L171;
        ((ScheduleEntity) ZeusTransformUtils.preCheckCast(r121, ScheduleEntity.class, "com.obric.memorydata.plugin")).setExtraData(r36);
        goto L171
    L157:
        if (r129.longValue() > 0) goto L159;
    L154:
        r129 = null;
        goto L155
    L149:
        if (r127.longValue() > 0) goto L151;
        r127 = null;
        goto L151
    L146:
        r127 = null;
        goto L147
    L141:
        if (r125.longValue() > 0) goto L143;
        r125 = null;
        goto L143
    L137:
        r125 = null;
    L133:
        r39 = "";
    L128:
        r37 = "";
    L171:
        return r121;
    L99:
        r121 = r115.convertToAppEntity();
        goto L122
    L55:
        r23 = false;
        goto L56
    L58:
        r22 = null;
        goto L59
    L101:
        if (ZeusTransformUtils.instanceOf(r17, hb.class) == false) goto L120;
        AppEntity r132 = r17.convertToAppEntity();
        if (ZeusTransformUtils.instanceOf(r132, PhotoEntity.class) == true) goto L105;
    L119:
        r121 = r132;
        goto L122
    L105:
        if (((PhotoEntity) ZeusTransformUtils.preCheckCast(r132, PhotoEntity.class, "com.obric.memorydata.plugin")).getAssetType() != AssetTypeEnum.VIDEO) goto L119;
        Iterator r133 = ((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L108:
        if (r133.hasNext() == false) goto L115;
        Object r40 = r133.next();
        if (((SearchResultEntry) ZeusTransformUtils.preCheckCast(r40, SearchResultEntry.class, "com.obric.memorydata.plugin")).getId() != ((hb) ZeusTransformUtils.preCheckCast(r17, hb.class, "com.obric.memorydata.plugin")).getId()) goto L112;
        boolean r41 = true;
    L113:
        if (r41 == false) goto L108;
    L116:
        SearchResultEntry r134 = (SearchResultEntry) ZeusTransformUtils.preCheckCast(r40, SearchResultEntry.class, "com.obric.memorydata.plugin");
        if (r134 == null) goto L119;
        ((PhotoEntity) ZeusTransformUtils.preCheckCast(r132, PhotoEntity.class, "com.obric.memorydata.plugin")).setSearchFrames(INSTANCE.a((hb) ZeusTransformUtils.preCheckCast(r17, hb.class, "com.obric.memorydata.plugin"), r134));
        goto L119
    L112:
        r41 = false;
        goto L113
    L115:
        r40 = null;
        goto L116
    L120:
        r121 = r17.convertToAppEntity();
        goto L122
    }

    private final Object a(Continuation<? super Boolean> r9) {
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        if (com.obric.memorydata.personalcontext.util.c.f12363a.b() != EmbeddingState.USE_VLM) goto L5;
        boolean r8 = true;
    L7:
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == false) goto L18;
        if (r8 == true) goto L10;
    L12:
        com.obric.memorydata.aikernelcore.a r1 = com.obric.memorydata.aikernelcore.a.INSTANCE;
        if (r8 == true) goto L17;
        return com.obric.memorydata.aikernelcore.a.a(r1, (Collection) ZeusTransformUtils.preCheckCast(d, Collection.class, "com.obric.memorydata.plugin"), null, r4, 2, null);
    L17:
        return com.obric.memorydata.aikernelcore.a.b(r1, (Collection) ZeusTransformUtils.preCheckCast(e, Collection.class, "com.obric.memorydata.plugin"), null, r4, 2, null);
    L10:
        if (DeviceInfoState.INSTANCE.isSupportVLM() == true) goto L12;
    L18:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntitySearchUtils", "checkModelIsReady called when AIKernel not available", null, 4, null);
        return Boxing.boxBoolean(false);
    L5:
        r8 = false;
        goto L7
    }

    private final String a(String r7) {
        JSONObject r6 = new JSONObject();
        String r0 = com.obric.memorydata.personalcontext.util.c.f12363a.c();
        String r1 = EvaluationService.INSTANCE.getSearchControlParams();
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
    L8:
        boolean r3 = true;
    L10:
        if (r3 == true) goto L21;
    L17:
        th = move-exception;
        new JSONObject();
        throw th;
    L12:
        if (r1 != null) goto L14;
        r1 = "{}";
    L14:
        r6 = new JSONObject(r1);     // Catch: Throwable -> L17
    L15:
        r6.put("embedding_type", r0);
        String r8 = r6.toString();
        Intrinsics.checkNotNullExpressionValue(r8, "toString(...)");
        return r8;
    L21:
        if (com.obric.memorydata.utils.d.f13204a.a(r7) == false) goto L15;
        r6.put("getInAppSearchParams", false);
        goto L15
    L5:
        if (r2.length() == 0) goto L8;
        r3 = false;
        goto L10
    }

    private final String a(String r3, String r4) {
        if (Intrinsics.areEqual(r4, "search_all_memory_entity") == false) goto L9;
        if (Intrinsics.areEqual(r3, AppContext.INSTANCE.getPackageName()) == false) goto L9;
        return "in_app_search_all_memory";
    L9:
        if (com.obric.memorydata.utils.d.f13204a.a(r3) == false) goto L13;
        if (r4 != null) goto L12;
        return null;
    L12:
        return (String) ZeusTransformUtils.preCheckCast(com.obric.memorydata.personalcontext.search.d.f12308a.d().get(r4), String.class, "com.obric.memorydata.plugin");
    L13:
        if (r3 != null) goto L15;
        return null;
    L15:
        return (String) ZeusTransformUtils.preCheckCast(com.obric.memorydata.personalcontext.search.d.f12308a.a().get(r3), String.class, "com.obric.memorydata.plugin");
    }

    private final List<VideoFrame> a(hb r10, SearchResultEntry r11) {
        List r9 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(r11.getInAppSearchParams(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r12.hasNext() == false) goto L15;
        InAppSearchEntityParam r0 = (InAppSearchEntityParam) ZeusTransformUtils.preCheckCast(r12.next(), InAppSearchEntityParam.class, "com.obric.memorydata.plugin");
        if (StringsKt.startsWith$default(r0.getField(), "PhotoEntity_VideoFrame", false, 2, null) == false) goto L4;
        String r1 = r0.getFieldArrayUniqueKey();
        if (r1 == null) goto L4;
        long r2 = Long.parseLong(r1);     // Catch: NumberFormatException -> L13
        if (r9.contains(Long.valueOf(r2)) == true) goto L4;
        r9.add(Long.valueOf(r2));     // Catch: NumberFormatException -> L13
    L13:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntitySearchUtils", "Invalid frame time: " + r1, null, 4, null);
        goto L4
    L15:
        if (r9.isEmpty() == false) goto L17;
        return null;
    L17:
        List<VideoFrame> r13 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getVideoFrameRawDbDao().queryByPhotoEntityDbId(r10.getId()), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L19:
        if (r14.hasNext() == false) goto L23;
        hr r3 = (hr) ZeusTransformUtils.preCheckCast(r14.next(), hr.class, "com.obric.memorydata.plugin");
        if (r9.contains(Long.valueOf(r3.c())) == false) goto L19;
        r13.add(r3.k());
        goto L19
    L23:
        return r13;
    }

    private final List<InAppSearchEntity> a(SearchRequest r8, List<SearchResultEntry> r9, IAppSearchCallback r10, EntitySearchRecordInfo r11) {
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        IAppSearchCallback r13 = (IAppSearchCallback) ZeusTransformUtils.wrapperContextForParams(r10, IAppSearchCallback.class, "com.obric.memorydata.plugin");
        if (r12.isEmpty() == false) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntitySearchUtils", "Search results are empty", false, 4, null);
        r13.onSearchResult(new InAppSearchResult(CollectionsKt.emptyList()));
        r13.onCompleted();
        return CollectionsKt.emptyList();
    L6:
        long r1 = System.currentTimeMillis();
        List r7 = loadAppEntitiesBySearchResultEntries$default(this, r12, null, 2, null);
        EvaluationResult r14 = com.obric.memorydata.personalcontext.log.a.f12229a.a();
        if (r14 == null) goto L9;
        r14.addResultEntitiesList(CollectionsKt.toMutableList((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin")));
    L9:
        if (r11 == null) goto L11;
        r11.setLoadResultCost(System.currentTimeMillis() - r1);
    L11:
        RunLog.INSTANCE.debug("EntitySearchUtils", "load app entities cost: " + (System.currentTimeMillis() - r1));
        if (r7.isEmpty() == false) goto L16;
        RunLog.INSTANCE.debug("EntitySearchUtils", "Fail to load app entities by search result entries.");
        r13.onError(1, "Fail to load app entities by search result entries.");
        return CollectionsKt.emptyList();
    L16:
        if (r12.size() == r7.size()) goto L18;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntitySearchUtils", "The size of search result entries does not match the size of app entities.", null, 4, null);
    L18:
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.zip((Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin");
        Collection r16 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r17 = r15.iterator();
    L20:
        if (r17.hasNext() == false) goto L23;
        Pair r18 = (Pair) ZeusTransformUtils.preCheckCast(r17.next(), Pair.class, "com.obric.memorydata.plugin");
        r16.add(new InAppSearchEntity((AppEntity) ZeusTransformUtils.preCheckCast(r18.component2(), AppEntity.class, "com.obric.memorydata.plugin"), ((SearchResultEntry) ZeusTransformUtils.preCheckCast(r18.component1(), SearchResultEntry.class, "com.obric.memorydata.plugin")).getInAppSearchParams()));
        goto L20
    L23:
        return (List) ZeusTransformUtils.preCheckCast(r16, List.class, "com.obric.memorydata.plugin");
    }

    private final List<String> a(Object r5) {
        if (r5 != null) goto L5;
    L62:
        return CollectionsKt.emptyList();
    L5:
        if (ZeusTransformUtils.instanceOf(r5, String.class) == false) goto L18;
        JSONArray r4 = new JSONArray((String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin"));     // Catch: JSONException -> L39
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(RangesKt.until(0, r4.length()), Iterable.class, "com.obric.memorydata.plugin");     // Catch: JSONException -> L39
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: JSONException -> L39
        Iterator r7 = r6.iterator();     // Catch: JSONException -> L39
    L8:
        if (r7.hasNext() == false) goto L15;
        String r2 = r4.optString(((IntIterator) ZeusTransformUtils.preCheckCast(r7, IntIterator.class, "com.obric.memorydata.plugin")).nextInt());     // Catch: JSONException -> L39
        Intrinsics.checkNotNull(r2);     // Catch: JSONException -> L39
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L13;
        r2 = null;
    L13:
        if (r2 == null) goto L8;
        r1.add(r2);     // Catch: JSONException -> L39
        goto L8
    L15:
        return (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");
    L18:
        if (ZeusTransformUtils.instanceOf(r5, List.class) == false) goto L31;
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin");
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r8.iterator();
    L21:
        if (r10.hasNext() == false) goto L25;
        Object r3 = r10.next();
        if (ZeusTransformUtils.instanceOf(r3, String.class) == false) goto L21;
        r9.add(r3);
        goto L21
    L25:
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r12 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r13 = r11.iterator();
    L27:
        if (r13.hasNext() == false) goto L38;
        Object r14 = r13.next();
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r14, String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L27;
        r12.add(r14);
    L38:
        return (List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.memorydata.plugin");
    L31:
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(r5.toString()), Iterable.class, "com.obric.memorydata.plugin");
        r12 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r16 = r15.iterator();
    L33:
        if (r16.hasNext() == false) goto L38;
        Object r17 = r16.next();
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r17, String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L33;
        r12.add(r17);
        goto L33
    }

    private final List<a> a(List<SearchResultEntry> r20) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.memorydata.plugin");
        Iterable r2 = CollectionsKt.withIndex((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin"));
        Map r3 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L9;
        Object r5 = r4.next();
        Integer r6 = Integer.valueOf(((SearchResultEntry) ZeusTransformUtils.preCheckCast(((IndexedValue) ZeusTransformUtils.preCheckCast(r5, IndexedValue.class, "com.obric.memorydata.plugin")).getValue(), SearchResultEntry.class, "com.obric.memorydata.plugin")).getType());
        Object r7 = r3.get(r6);
        if (r7 != null) goto L8;
        r7 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r3.put(r6, r7);
    L8:
        ((List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin")).add(r5);
        goto L4
    L9:
        List r8 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        List r9 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r10 = r3.entrySet().iterator();
    L11:
        if (r10.hasNext() == false) goto L38;
        Map.Entry r11 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        int r12 = ((Number) ZeusTransformUtils.preCheckCast(r11.getKey(), Number.class, "com.obric.memorydata.plugin")).intValue();
        List r13 = (List) ZeusTransformUtils.preCheckCast(r11.getValue(), List.class, "com.obric.memorydata.plugin");
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin");
        Collection r15 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r16 = r14.iterator();
    L14:
        if (r16.hasNext() == false) goto L16;
        r15.add(Long.valueOf(((SearchResultEntry) ZeusTransformUtils.preCheckCast(((IndexedValue) ZeusTransformUtils.preCheckCast(r16.next(), IndexedValue.class, "com.obric.memorydata.plugin")).getValue(), SearchResultEntry.class, "com.obric.memorydata.plugin")).getId()));
        goto L14
    L16:
        List<Long> r17 = (List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.memorydata.plugin");
        IAppEntityRawDbDao<com.obric.memorydata.database.entity.d> r18 = s.a().getRawDaoByEntityType(r12);
        if (r18 == null) goto L11;
        List<com.obric.memorydata.database.entity.d> r19 = r18.queryByIds(r17);
        r9.addAll((Collection) ZeusTransformUtils.preCheckCast(r19, Collection.class, "com.obric.memorydata.plugin"));
        Iterator r21 = ((Iterable) ZeusTransformUtils.preCheckCast(r19, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L21:
        if (r21.hasNext() == false) goto L11;
        com.obric.memorydata.database.entity.d r110 = (com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r21.next(), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin");
        a r111 = new a(r110.getEntityId(), r110.getCreateTime(), r110.getModifyTime(), r110.getType());
        Iterator r112 = ((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L24:
        if (r112.hasNext() == false) goto L31;
        Object r113 = r112.next();
        if (((SearchResultEntry) ZeusTransformUtils.preCheckCast(((IndexedValue) ZeusTransformUtils.preCheckCast(r113, IndexedValue.class, "com.obric.memorydata.plugin")).getValue(), SearchResultEntry.class, "com.obric.memorydata.plugin")).getId() != r110.getId()) goto L28;
        boolean r114 = true;
    L29:
        if (r114 == false) goto L24;
    L32:
        IndexedValue r115 = (IndexedValue) ZeusTransformUtils.preCheckCast(r113, IndexedValue.class, "com.obric.memorydata.plugin");
        if (r115 == null) goto L35;
        Integer r116 = Integer.valueOf(r115.getIndex());
    L36:
        if (r116 == null) goto L21;
        r8.add(TuplesKt.to(Integer.valueOf(((Number) ZeusTransformUtils.preCheckCast(r116, Number.class, "com.obric.memorydata.plugin")).intValue()), r111));
        goto L21
    L35:
        r116 = null;
        goto L36
    L28:
        r114 = false;
        goto L29
    L31:
        r113 = null;
        goto L32
    L38:
        Iterable r22 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new d(), Comparator.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin");
        Collection r23 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r22, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r24 = r22.iterator();
    L40:
        if (r24.hasNext() == false) goto L42;
        r23.add((a) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r24.next(), Pair.class, "com.obric.memorydata.plugin")).getSecond(), a.class, "com.obric.memorydata.plugin"));
        goto L40
    L42:
        List<a> r25 = (List) ZeusTransformUtils.preCheckCast(r23, List.class, "com.obric.memorydata.plugin");
        EvaluationResult r26 = com.obric.memorydata.personalcontext.log.a.f12229a.a();
        if (r26 == null) goto L64;
        Map r27 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r28 = 0;
    L46:
        if (r1.hasNext() == false) goto L52;
        Object r29 = r1.next();
        int r117 = r28 + 1;
        if (r28 >= 0) goto L50;
        CollectionsKt.throwIndexOverflow();
    L50:
        SearchResultEntry r30 = (SearchResultEntry) ZeusTransformUtils.preCheckCast(r29, SearchResultEntry.class, "com.obric.memorydata.plugin");
        r27.put(new StringBuilder().append(r30.getType()).append('_').append(r30.getId()).toString(), Integer.valueOf(r28));
        r28 = r117;
        goto L46
    L52:
        if (r9.size() <= 1) goto L54;
        CollectionsKt.sortWith(r9, (Comparator) ZeusTransformUtils.preCheckCast(new e(r27), Comparator.class, "com.obric.memorydata.plugin"));
    L54:
        List<? extends AppEntity> r31 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r32 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L56:
        if (r32.hasNext() == false) goto L63;
        com.obric.memorydata.database.entity.d r33 = (com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r32.next(), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin");
        IAppEntityRawDbDao<com.obric.memorydata.database.entity.d> r34 = s.a().getRawDaoByEntityType(r33.getType());
        if (r34 == null) goto L60;
        AppEntity r35 = com.obric.memorydata.personalcontext.poison.g.f12254a.a(r33, r34);
    L61:
        if (r35 == null) goto L56;
        r31.add(r35);
        goto L56
    L60:
        r35 = null;
        goto L61
    L63:
        r26.addResultEntitiesList(r31);
    L64:
        return r25;
    }

    private final List<Object> a(JSONArray r5) {
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(RangesKt.until(0, r5.length()), Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r6 = r4.iterator();
    L4:
        if (r6.hasNext() == false) goto L9;
        int r2 = ((IntIterator) ZeusTransformUtils.preCheckCast(r6, IntIterator.class, "com.obric.memorydata.plugin")).nextInt();
        Object r3 = INSTANCE.c(r5.opt(r2));
        if (r3 == null) goto L4;
        r0.add(r3);
        goto L4
    L9:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
    }

    private final Map<String, JSONObject> a(int r4, List<? extends com.obric.memorydata.database.entity.d> r5, JSONObject r6) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if (r4 != 401) goto L12;
        if (r6 == null) goto L19;
        Map<String, JSONObject> r7 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L7:
        if (r8.hasNext() == false) goto L11;
        com.obric.memorydata.database.entity.d r9 = (com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r8.next(), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin");
        JSONObject r1 = r6.optJSONObject(String.valueOf(r9.getId()));
        if (r1 == null) goto L7;
        r7.put(r9.getEntityId(), r1);
        goto L7
    L11:
        return r7;
    L19:
        return null;
    L12:
        return null;
    }

    private final Map<String, Object> a(JSONObject r6) {
        Map<String, Object> r0 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator<String> r1 = r6.keys();
    L4:
        if (r1.hasNext() == false) goto L8;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");
        Object r4 = c(r6.opt(r3));
        if (r4 == null) goto L4;
        r0.put(r3, r4);
        goto L4
    L8:
        return r0;
    }

    private static final void a(String r3, List r4, Map r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        Function2 r0 = (Function2) ZeusTransformUtils.preCheckCast(f.get(r3), Function2.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        r0.invoke(r6, r7);
    L5:
        com.obric.memorydata.personalcontext.search.bridge.a.a.f12280a.a(r3).c().b();
    }

    private final boolean a() {
        Long r6 = StringsKt.toLongOrNull(AppContext.INSTANCE.getUserId());
        if (AppContext.INSTANCE.isLogin() == false) goto L10;
        if (r6 == null) goto L10;
        if (r6.longValue() <= 0) goto L10;
        return com.obric.memorydata.middleware.api.store.a.f11639a.a(StoreManager.INSTANCE.getPersonalStore(), IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null), "audio_memory_configured", false);
    L10:
        return false;
    }

    public static final /* synthetic */ Object access$checkModelIsReady(g r2, Continuation r3) {
        return r2.a((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ List access$constructInAppSearchResponse(g r2, SearchRequest r3, List r4, IAppSearchCallback r5, EntitySearchRecordInfo r6) {
        return r2.a(r3, (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin"), (IAppSearchCallback) ZeusTransformUtils.wrapperContextForParams(r5, IAppSearchCallback.class, "com.obric.memorydata.plugin"), r6);
    }

    public static final /* synthetic */ List access$constructInAppSearchResponseWithoutEntity(g r2, SearchRequest r3, List r4, IAppSearchCallback r5, EntitySearchRecordInfo r6) {
        return r2.b(r3, (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin"), (IAppSearchCallback) ZeusTransformUtils.wrapperContextForParams(r5, IAppSearchCallback.class, "com.obric.memorydata.plugin"), r6);
    }

    public static final /* synthetic */ String access$getSearchControlPrams(g r0, String r1) {
        return r0.a(r1);
    }

    public static final /* synthetic */ String access$getTaskName(g r0, String r1, String r2) {
        return r0.a(r1, r2);
    }

    public static final /* synthetic */ boolean access$isAudioMemoryConfiguredForCurrentUser(g r0) {
        return r0.a();
    }

    public static final /* synthetic */ Map access$parseSearchExtraMap(g r0, Object r1) {
        return r0.b(r1);
    }

    private final List<InAppSearchSimpleData> b(SearchRequest r10, List<SearchResultEntry> r11, IAppSearchCallback r12, EntitySearchRecordInfo r13) {
        List<SearchResultEntry> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        IAppSearchCallback r15 = (IAppSearchCallback) ZeusTransformUtils.wrapperContextForParams(r12, IAppSearchCallback.class, "com.obric.memorydata.plugin");
        if (r14.isEmpty() == false) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntitySearchUtils", "Search results are empty", false, 4, null);
        r15.onSearchResultWithoutEntity(new InAppSearchResultWithoutEntity(CollectionsKt.emptyList(), null, 2, null));
        r15.onCompleted();
        return CollectionsKt.emptyList();
    L6:
        long r3 = System.currentTimeMillis();
        List<a> r9 = a(r14);
        if (r13 == null) goto L9;
        r13.setLoadResultCost(System.currentTimeMillis() - r3);
    L9:
        RunLog.INSTANCE.debug("EntitySearchUtils", "load simple entity data cost: " + (System.currentTimeMillis() - r3));
        if (r9.isEmpty() == false) goto L14;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntitySearchUtils", "Fail to load simple entity data by search result entries.", null, 4, null);
        Ensure.ensureNotReachHere("Fail to load simple entity data by search result entries.");
        r15.onSearchResultWithoutEntity(new InAppSearchResultWithoutEntity(CollectionsKt.emptyList(), null, 2, null));
        r15.onCompleted();
        return CollectionsKt.emptyList();
    L14:
        if (r14.size() == r9.size()) goto L16;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntitySearchUtils", "The size of search result entries does not match the size of app entities.", null, 4, null);
    L16:
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.zip((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin");
        Collection r17 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r18 = r16.iterator();
    L18:
        if (r18.hasNext() == false) goto L21;
        Pair r19 = (Pair) ZeusTransformUtils.preCheckCast(r18.next(), Pair.class, "com.obric.memorydata.plugin");
        SearchResultEntry r110 = (SearchResultEntry) ZeusTransformUtils.preCheckCast(r19.component1(), SearchResultEntry.class, "com.obric.memorydata.plugin");
        a r111 = (a) ZeusTransformUtils.preCheckCast(r19.component2(), a.class, "com.obric.memorydata.plugin");
        r17.add(new InAppSearchSimpleData(r111.a(), r111.b(), r111.c(), r111.getType(), r110.getInAppSearchParams()));
        goto L18
    L21:
        return (List) ZeusTransformUtils.preCheckCast(r17, List.class, "com.obric.memorydata.plugin");
    }

    private final Map<String, Object> b(Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, JSONObject.class) == false) goto L6;
        return a((JSONObject) ZeusTransformUtils.preCheckCast(r5, JSONObject.class, "com.obric.memorydata.plugin"));
    L6:
        if (ZeusTransformUtils.instanceOf(r5, Map.class) == false) goto L21;
        Map r4 = (Map) ZeusTransformUtils.preCheckCast(r5, Map.class, "com.obric.memorydata.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r7 = r4.entrySet().iterator();
    L9:
        if (r7.hasNext() == false) goto L35;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Object r2 = r0.getKey();
        Object r1 = r0.getValue();
        Object r3 = INSTANCE.c(r1);
        Pair r8 = null;
        if (r3 == null) goto L17;
        if (r2 == null) goto L17;
        String r9 = r2.toString();
        if (r9 == null) goto L17;
        r8 = TuplesKt.to(r9, r3);
    L17:
        if (r8 == null) goto L9;
        r6.add(r8);
        goto L9
    L35:
        return MapsKt.toMap((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
    L21:
        if (ZeusTransformUtils.instanceOf(r5, String.class) == false) goto L25;
        return a(new JSONObject((String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin")));
    L25:
        return MapsKt.emptyMap();
    }

    private final Object c(Object r3) {
        if (r3 != null) goto L4;
    L12:
        return null;
    L4:
        if (Intrinsics.areEqual(r3, JSONObject.NULL) == true) goto L12;
        if (ZeusTransformUtils.instanceOf(r3, JSONObject.class) == false) goto L10;
        return a((JSONObject) ZeusTransformUtils.preCheckCast(r3, JSONObject.class, "com.obric.memorydata.plugin"));
    L10:
        if (ZeusTransformUtils.instanceOf(r3, JSONArray.class) == true) goto L16;
        return r3;
    L16:
        return a((JSONArray) ZeusTransformUtils.preCheckCast(r3, JSONArray.class, "com.obric.memorydata.plugin"));
    }

    public static /* synthetic */ void lambda$JPBGgqiDEwEuVK5KHnIln5lVRn4(String r0, List r1, Map r2) {
        a(r0, r1, r2);
    }

    public static /* synthetic */ List loadAppEntitiesBySearchResultEntries$default(g r1, List r2, String r3, int r4, Object r5) {
        List<SearchResultEntry> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L6;
        r3 = null;
    L6:
        return r1.loadAppEntitiesBySearchResultEntries(r6, r3);
    }

    public static /* synthetic */ List loadAppEntityPairBySearchResultEntries$default(g r1, List r2, String r3, int r4, Object r5) {
        List<SearchResultEntry> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L6;
        r3 = null;
    L6:
        return r1.loadAppEntityPairBySearchResultEntries(r6, r3);
    }

    public static /* synthetic */ Object sendGlobalSearchRequest$default(g r7, SearchRequest r8, List r9, IGlobalSearchCallback r10, EntitySearchRecordInfo r11, Continuation r12, int r13, Object r14) {
        List<String> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        IGlobalSearchCallback r4 = (IGlobalSearchCallback) ZeusTransformUtils.wrapperContextForParams(r10, IGlobalSearchCallback.class, "com.obric.memorydata.plugin");
        Continuation<? super Unit> r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        if ((r13 & 8) == 0) goto L6;
        r11 = null;
    L6:
        return r7.sendGlobalSearchRequest(r8, r3, r4, r11, r6);
    }

    public static /* synthetic */ Object sendInAppSearchRequest$default(g r11, SearchRequest r12, CopyOnWriteArrayList r13, IAppSearchCallback r14, EntitySearchRecordInfo r15, CallMode r16, String r17, h r18, Continuation r19, int r20, Object r21) {
        IAppSearchCallback r5 = (IAppSearchCallback) ZeusTransformUtils.wrapperContextForParams(r14, IAppSearchCallback.class, "com.obric.memorydata.plugin");
        h r0 = (h) ZeusTransformUtils.wrapperContextForParams(r18, h.class, "com.obric.memorydata.plugin");
        Continuation<? super Unit> r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r19, Continuation.class, "com.obric.memorydata.plugin");
        if ((r20 & 8) == 0) goto L5;
        EntitySearchRecordInfo r6 = null;
    L7:
        if ((r20 & 16) == 0) goto L9;
        CallMode r7 = CallMode.UNKNOWN;
    L11:
        if ((r20 & 32) == 0) goto L13;
        String r8 = null;
    L15:
        if ((r20 & 64) == 0) goto L17;
        h r9 = null;
    L19:
        return r11.sendInAppSearchRequest(r12, r13, r5, r6, r7, r8, r9, r10);
    L17:
        r9 = r0;
        goto L19
    L13:
        r8 = r17;
        goto L15
    L9:
        r7 = r16;
        goto L11
    L5:
        r6 = r15;
        goto L7
    }

    public static /* synthetic */ Object sendSearchRequest$default(g r10, SearchRequest r11, AssistantQuResult r12, SearchResponse r13, EntitySearchRecordInfo r14, CallMode r15, String r16, boolean r17, Continuation r18, int r19, Object r20) {
        Continuation<? super List<? extends AppEntity>> r0 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r18, Continuation.class, "com.obric.memorydata.plugin");
        EntitySearchRecordInfo r2 = null;
        if ((r19 & 2) == 0) goto L5;
        AssistantQuResult r1 = null;
    L7:
        if ((r19 & 4) == 0) goto L9;
        SearchResponse r3 = new SearchResponse(0, "success", null, 4, null);
    L11:
        if ((r19 & 8) != 0) goto L15;
        r2 = r14;
    L15:
        if ((r19 & 16) == 0) goto L17;
        CallMode r4 = CallMode.UNKNOWN;
    L19:
        if ((r19 & 32) == 0) goto L21;
        String r5 = "";
    L23:
        if ((r19 & 64) == 0) goto L25;
        boolean r6 = false;
    L27:
        return r10.sendSearchRequest(r11, r1, r3, r2, r4, r5, r6, r0);
    L25:
        r6 = r17;
        goto L27
    L21:
        r5 = r16;
        goto L23
    L17:
        r4 = r15;
        goto L19
    L9:
        r3 = r13;
        goto L11
    L5:
        r1 = r12;
        goto L7
    }

    public static /* synthetic */ void trackSearchPerfInfo$default(g r11, EntitySearchRecordInfo r12, double r13, double r15, double r17, TaskResult r19, boolean r20, int r21, Object r22) {
        if ((r21 & 32) == 0) goto L5;
        boolean r10 = false;
    L6:
        r11.trackSearchPerfInfo(r12, r13, r15, r17, r19, r10);
        return;
    L5:
        r10 = r20;
        goto L6
    }

    public final boolean enablePresetQUResult(String r1) {
        Intrinsics.checkNotNullParameter(r1, ObricMemoryConstants.KEY_PACKAGE_NAME);
        if (com.obric.memorydata.utils.d.f13204a.a(r1) == false) goto L5;
    L10:
        return true;
    L5:
        if (Intrinsics.areEqual(r1, "com.obric.aiagent.executionengine") == true) goto L10;
        if (Intrinsics.areEqual(r1, AppContext.INSTANCE.getPackageName()) == true) goto L10;
        return false;
    }

    public final String getActionNameByDomain(String r2) {
        Intrinsics.checkNotNullParameter(r2, "domain");
        return (String) ZeusTransformUtils.preCheckCast(q.f12255a.j().get(r2), String.class, "com.obric.memorydata.plugin");
    }

    public final String getDomainNameByTaskName(String r7) {
        Intrinsics.checkNotNullParameter(r7, "inAppSearchTaskName");
        String r0 = (String) ZeusTransformUtils.preCheckCast(com.obric.memorydata.personalcontext.search.d.f12308a.e().get(r7), String.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        g r6 = (g) ZeusTransformUtils.preCheckCast(this, g.class, "com.obric.memorydata.plugin");
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntitySearchUtils", "Unknown task name: " + r7, null, 4, null);
        return "";
    L6:
        return r0;
    }

    public final JSONObject getEntitySwitchStatus() {
        JSONObject r5 = new JSONObject();
        Iterator<Map.Entry<Integer, Boolean>> r0 = com.obric.memorydata.personalcontext.search.a.f12274a.c().entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r5.put(String.valueOf(((Number) ZeusTransformUtils.preCheckCast(r1.getKey(), Number.class, "com.obric.memorydata.plugin")).intValue()), ((Boolean) ZeusTransformUtils.preCheckCast(r1.getValue(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
        goto L4
    L6:
        return r5;
    }

    public final Map<Integer, String> getEntityTypeToPackageNameMap() {
        return c;
    }

    public final Map<Integer, String> getEntityTypeToTaskNameMap() {
        return f12314b;
    }

    public final ConcurrentHashMap<String, Function2<List<SearchResultEntry>, Map<String, ? extends Object>, Unit>> getSearchOptResultCallback() {
        return f;
    }

    public final Map<String, Integer> getTaskNameToEntityTypeMap() {
        return f12313a;
    }

    public final List<AppEntity> loadAppEntitiesBySearchResultEntries(List<SearchResultEntry> r22, String r23) {
        List<SearchResultEntry> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "searchResultEntries");
        Iterable r0 = CollectionsKt.withIndex((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin"));
        Map r4 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        Object r5 = r1.next();
        Integer r6 = Integer.valueOf(((SearchResultEntry) ZeusTransformUtils.preCheckCast(((IndexedValue) ZeusTransformUtils.preCheckCast(r5, IndexedValue.class, "com.obric.memorydata.plugin")).getValue(), SearchResultEntry.class, "com.obric.memorydata.plugin")).getType());
        Object r7 = r4.get(r6);
        if (r7 != null) goto L8;
        r7 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r4.put(r6, r7);
    L8:
        ((List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin")).add(r5);
        goto L4
    L9:
        List r8 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        List r9 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r23, CharSequence.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L12;
    L15:
        boolean r10 = true;
    L17:
        if (r10 == false) goto L64;
    L22:
        JSONObject r11 = null;
    L23:
        Iterator r12 = r4.entrySet().iterator();
    L25:
        if (r12.hasNext() == false) goto L58;
        Map.Entry r13 = (Map.Entry) ZeusTransformUtils.preCheckCast(r12.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        int r14 = ((Number) ZeusTransformUtils.preCheckCast(r13.getKey(), Number.class, "com.obric.memorydata.plugin")).intValue();
        List r15 = (List) ZeusTransformUtils.preCheckCast(r13.getValue(), List.class, "com.obric.memorydata.plugin");
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin");
        Collection r17 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r18 = r16.iterator();
    L28:
        if (r18.hasNext() == false) goto L30;
        r17.add(Long.valueOf(((SearchResultEntry) ZeusTransformUtils.preCheckCast(((IndexedValue) ZeusTransformUtils.preCheckCast(r18.next(), IndexedValue.class, "com.obric.memorydata.plugin")).getValue(), SearchResultEntry.class, "com.obric.memorydata.plugin")).getId()));
        goto L28
    L30:
        List<Long> r19 = (List) ZeusTransformUtils.preCheckCast(r17, List.class, "com.obric.memorydata.plugin");
        IAppEntityRawDbDao<com.obric.memorydata.database.entity.d> r110 = s.a().getRawDaoByEntityType(r14);
        if (r110 == null) goto L57;
        List<com.obric.memorydata.database.entity.d> r111 = r110.queryByIds(r19);
        r9.addAll((Collection) ZeusTransformUtils.preCheckCast(r111, Collection.class, "com.obric.memorydata.plugin"));
        Map<String, JSONObject> r112 = INSTANCE.a(r14, r111, r11);
        Iterator r113 = ((Iterable) ZeusTransformUtils.preCheckCast(r111, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L35:
        if (r113.hasNext() == false) goto L57;
        com.obric.memorydata.database.entity.d r114 = (com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r113.next(), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin");
        AppEntity r115 = INSTANCE.a(r114, r110, r3, r112);
        if (r115 == null) goto L55;
        Iterator r20 = ((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L40:
        if (r20.hasNext() == false) goto L48;
        Object r21 = r20.next();
        JSONObject r24 = r11;
        if (((SearchResultEntry) ZeusTransformUtils.preCheckCast(((IndexedValue) ZeusTransformUtils.preCheckCast(r21, IndexedValue.class, "com.obric.memorydata.plugin")).getValue(), SearchResultEntry.class, "com.obric.memorydata.plugin")).getId() != r114.getId()) goto L44;
        boolean r25 = true;
    L45:
        if (r25 == true) goto L49;
        r11 = r24;
    L49:
        IndexedValue r26 = (IndexedValue) ZeusTransformUtils.preCheckCast(r21, IndexedValue.class, "com.obric.memorydata.plugin");
        if (r26 == null) goto L52;
        Integer r27 = Integer.valueOf(r26.getIndex());
    L53:
        if (r27 == null) goto L56;
        r8.add(TuplesKt.to(Integer.valueOf(((Number) ZeusTransformUtils.preCheckCast(r27, Number.class, "com.obric.memorydata.plugin")).intValue()), r115));
    L56:
        r11 = r24;
        goto L35
    L52:
        r27 = null;
        goto L53
    L44:
        r25 = false;
        goto L45
    L48:
        r24 = r11;
        r21 = null;
        goto L49
    L55:
        r24 = r11;
    L57:
        r11 = r11;
        goto L25
    L58:
        Iterable r28 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new b(), Comparator.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin");
        Collection r29 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r28, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r30 = r28.iterator();
    L60:
        if (r30.hasNext() == false) goto L62;
        r29.add((AppEntity) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r30.next(), Pair.class, "com.obric.memorydata.plugin")).getSecond(), AppEntity.class, "com.obric.memorydata.plugin"));
        goto L60
    L62:
        List<AppEntity> r31 = (List) ZeusTransformUtils.preCheckCast(r29, List.class, "com.obric.memorydata.plugin");
        RunLog.INSTANCE.debugLocalTest("EntitySearchUtils", "load app entity success: ", r31);
        return r31;
    L64:
        r11 = new JSONObject(r23);     // Catch: JSONException -> L20
    L20:
        e = move-exception;
        RunLog.INSTANCE.error("EntitySearchUtils", "load scheduleTimeDescriptionJsonObject failed, json: " + r23, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        goto L22
    L12:
        if (r2.length() == 0) goto L15;
        r10 = false;
        goto L17
    }

    public final List<Pair<SearchResultEntry, AppEntity>> loadAppEntityPairBySearchResultEntries(List<SearchResultEntry> r22, String r23) {
        List<SearchResultEntry> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "searchResultEntries");
        Iterable r0 = CollectionsKt.withIndex((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin"));
        Map r4 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        Object r5 = r1.next();
        Integer r6 = Integer.valueOf(((SearchResultEntry) ZeusTransformUtils.preCheckCast(((IndexedValue) ZeusTransformUtils.preCheckCast(r5, IndexedValue.class, "com.obric.memorydata.plugin")).getValue(), SearchResultEntry.class, "com.obric.memorydata.plugin")).getType());
        Object r7 = r4.get(r6);
        if (r7 != null) goto L8;
        r7 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r4.put(r6, r7);
    L8:
        ((List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin")).add(r5);
        goto L4
    L9:
        List r8 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        List r9 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r23, CharSequence.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L12;
    L15:
        boolean r10 = true;
    L17:
        if (r10 == false) goto L61;
    L22:
        JSONObject r11 = null;
    L23:
        Iterator r12 = r4.entrySet().iterator();
    L25:
        if (r12.hasNext() == false) goto L55;
        Map.Entry r13 = (Map.Entry) ZeusTransformUtils.preCheckCast(r12.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        int r14 = ((Number) ZeusTransformUtils.preCheckCast(r13.getKey(), Number.class, "com.obric.memorydata.plugin")).intValue();
        List r15 = (List) ZeusTransformUtils.preCheckCast(r13.getValue(), List.class, "com.obric.memorydata.plugin");
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin");
        Collection r17 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r18 = r16.iterator();
    L28:
        if (r18.hasNext() == false) goto L30;
        r17.add(Long.valueOf(((SearchResultEntry) ZeusTransformUtils.preCheckCast(((IndexedValue) ZeusTransformUtils.preCheckCast(r18.next(), IndexedValue.class, "com.obric.memorydata.plugin")).getValue(), SearchResultEntry.class, "com.obric.memorydata.plugin")).getId()));
        goto L28
    L30:
        List<Long> r19 = (List) ZeusTransformUtils.preCheckCast(r17, List.class, "com.obric.memorydata.plugin");
        IAppEntityRawDbDao<com.obric.memorydata.database.entity.d> r110 = s.a().getRawDaoByEntityType(r14);
        if (r110 == null) goto L54;
        List<com.obric.memorydata.database.entity.d> r111 = r110.queryByIds(r19);
        r9.addAll((Collection) ZeusTransformUtils.preCheckCast(r111, Collection.class, "com.obric.memorydata.plugin"));
        Map<String, JSONObject> r112 = INSTANCE.a(r14, r111, r11);
        Iterator r113 = ((Iterable) ZeusTransformUtils.preCheckCast(r111, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L35:
        if (r113.hasNext() == false) goto L54;
        com.obric.memorydata.database.entity.d r114 = (com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r113.next(), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin");
        AppEntity r115 = INSTANCE.a(r114, r110, r3, r112);
        if (r115 == null) goto L52;
        Iterator r20 = ((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L40:
        if (r20.hasNext() == false) goto L48;
        Object r21 = r20.next();
        JSONObject r24 = r11;
        if (((SearchResultEntry) ZeusTransformUtils.preCheckCast(((IndexedValue) ZeusTransformUtils.preCheckCast(r21, IndexedValue.class, "com.obric.memorydata.plugin")).getValue(), SearchResultEntry.class, "com.obric.memorydata.plugin")).getId() != r114.getId()) goto L44;
        boolean r25 = true;
    L45:
        if (r25 == true) goto L49;
        r11 = r24;
    L49:
        IndexedValue r26 = (IndexedValue) ZeusTransformUtils.preCheckCast(r21, IndexedValue.class, "com.obric.memorydata.plugin");
        if (r26 == null) goto L53;
        r8.add(new Triple(Integer.valueOf(r26.getIndex()), r26.getValue(), r115));
    L53:
        r11 = r24;
        goto L35
    L44:
        r25 = false;
        goto L45
    L48:
        r24 = r11;
        r21 = null;
        goto L49
    L52:
        r24 = r11;
    L54:
        r11 = r11;
        goto L25
    L55:
        Iterable r27 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new c(), Comparator.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin");
        Collection r28 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r27, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r29 = r27.iterator();
    L57:
        if (r29.hasNext() == false) goto L59;
        Triple r30 = (Triple) ZeusTransformUtils.preCheckCast(r29.next(), Triple.class, "com.obric.memorydata.plugin");
        r28.add(TuplesKt.to(r30.getSecond(), r30.getThird()));
        goto L57
    L59:
        List<Pair<SearchResultEntry, AppEntity>> r31 = (List) ZeusTransformUtils.preCheckCast(r28, List.class, "com.obric.memorydata.plugin");
        RunLog.INSTANCE.debugLocalTest("EntitySearchUtils", "load app entity success: ", r31);
        return r31;
    L61:
        r11 = new JSONObject(r23);     // Catch: JSONException -> L20
    L20:
        e = move-exception;
        RunLog.INSTANCE.error("EntitySearchUtils", "load scheduleTimeDescriptionJsonObject failed, json: " + r23, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        goto L22
    L12:
        if (r2.length() == 0) goto L15;
        r10 = false;
        goto L17
    }

    public final List<MemoryEntity> loadMemoryEntityBySearchResultEntry(List<SearchResultEntry> r6) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "searchResultEntry");
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r9 = r7.iterator();
    L4:
        if (r9.hasNext() == false) goto L6;
        r8.add(Long.valueOf(((SearchResultEntry) ZeusTransformUtils.preCheckCast(r9.next(), SearchResultEntry.class, "com.obric.memorydata.plugin")).getId()));
        goto L4
    L6:
        List<Long> r10 = (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin");
        MemoryEntityRawDbDao r11 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getRawMemoryEntityDao();
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r11.queryByIds(r10), Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r13 = r12.iterator();
    L8:
        if (r13.hasNext() == false) goto L17;
        RawMemoryEntity r2 = (RawMemoryEntity) ZeusTransformUtils.preCheckCast(r13.next(), RawMemoryEntity.class, "com.obric.memorydata.plugin");
        MemoryEntity r3 = (MemoryEntity) ZeusTransformUtils.preCheckCast(com.obric.memorydata.personalcontext.poison.g.f12254a.a((com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r2, com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin"), (IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r11, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin")), MemoryEntity.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L12;
        r3.setSourceLink(null);
    L12:
        if (r3 == null) goto L14;
        r3.setSourceLinkType(null);
    L14:
        if (r3 == null) goto L8;
        r1.add(r3);
        goto L8
    L17:
        return (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");
    }

    public final void onReceiveSearchOptResult(final String r4, List<SearchResultEntry> r5, Map<String, ? extends Object> r6) {
        final List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        final Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "taskId");
        Intrinsics.checkNotNullParameter(r3, "result");
        Intrinsics.checkNotNullParameter(r7, "extraMap");
        if (com.obric.memorydata.personalcontext.search.bridge.a.a.f12280a.a(r4).f() == false) goto L5;
        return;
    L5:
        com.obric.memorydata.personalcontext.search.bridge.a.a.f12280a.a(r4).c().a();
        GlobalHandlerUtil.Companion.getInstance().postDelay(0, new $$Lambda$g$JPBGgqiDEwEuVK5KHnIln5lVRn4(r4, r3, r7));
    }

    public final Object sendGlobalSearchRequest(SearchRequest r8, List<String> r9, IGlobalSearchCallback r10, EntitySearchRecordInfo r11, Continuation<? super Unit> r12) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        IGlobalSearchCallback r2 = (IGlobalSearchCallback) ZeusTransformUtils.wrapperContextForParams(r10, IGlobalSearchCallback.class, "com.obric.memorydata.plugin");
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        Object r13 = i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.a(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new EntitySearchUtils$sendGlobalSearchRequest$2(r2, r8, r4, r11, null), Function2.class, "com.obric.memorydata.plugin"), r7);
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r13;
    L6:
        return Unit.INSTANCE;
    }

    public final Object sendInAppSearchRequest(SearchRequest r13, CopyOnWriteArrayList<String> r14, IAppSearchCallback r15, EntitySearchRecordInfo r16, CallMode r17, String r18, h r19, Continuation<? super Unit> r20) {
        IAppSearchCallback r4 = (IAppSearchCallback) ZeusTransformUtils.wrapperContextForParams(r15, IAppSearchCallback.class, "com.obric.memorydata.plugin");
        h r8 = (h) ZeusTransformUtils.wrapperContextForParams(r19, h.class, "com.obric.memorydata.plugin");
        Continuation r0 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r20, Continuation.class, "com.obric.memorydata.plugin");
        Object r1 = i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new EntitySearchUtils$sendInAppSearchRequest$2(r13, r4, r18, r16, r14, r8, null), Function2.class, "com.obric.memorydata.plugin"), r0);
        if (r1 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r1;
    L6:
        return Unit.INSTANCE;
    }

    public final Object sendSearchRequest(SearchRequest r14, AssistantQuResult r15, SearchResponse r16, EntitySearchRecordInfo r17, CallMode r18, String r19, boolean r20, Continuation<? super List<? extends AppEntity>> r21) {
        Continuation r0 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r21, Continuation.class, "com.obric.memorydata.plugin");
        return i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new EntitySearchUtils$sendSearchRequest$2(r14, r16, r17, r20, r15, r18, r19, null), Function2.class, "com.obric.memorydata.plugin"), r0);
    }

    public final void trackSearchPerfInfo(EntitySearchRecordInfo r12, double r13, double r15, double r17, TaskResult r19, boolean r20) {
        Intrinsics.checkNotNullParameter(r19, "searchResult");
        if (r12 != null) goto L10;
        return;
    L10:
        String r4 = r19.getOutput().get("report_params").toString();     // Catch: Exception -> L7
        RunLog.INSTANCE.debug("EntitySearchUtils", "search app entity report params:" + r4);     // Catch: Exception -> L7
        Object r5 = ab.a().fromJson(r4, EntitySearchRecordInfo.class);     // Catch: Exception -> L7
        Intrinsics.checkNotNullExpressionValue(r5, "fromJson(...)");     // Catch: Exception -> L7
        EntitySearchRecordInfo r6 = (EntitySearchRecordInfo) ZeusTransformUtils.preCheckCast(r5, EntitySearchRecordInfo.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L7
        r12.setFirstBatchResultCost(r6.getFirstBatchResultCost());     // Catch: Exception -> L7
        r12.setGraphExecuteCost(r6.getGraphExecuteCost());     // Catch: Exception -> L7
        r12.setBuildGraphCost(r6.getBuildGraphCost());     // Catch: Exception -> L7
        r12.setSortAndFilterCost(r6.getSortAndFilterCost());     // Catch: Exception -> L7
        r12.setNotifySearchResultCost(r6.getNotifySearchResultCost());     // Catch: Exception -> L7
        r12.setSqlQueryCost(r6.getSqlQueryCost());     // Catch: Exception -> L7
        r12.setKeywordQueryCost(r6.getKeywordQueryCost());     // Catch: Exception -> L7
        r12.setImageVectorQueryCost(r6.getImageVectorQueryCost());     // Catch: Exception -> L7
        r12.setTextVectorQueryCost(r6.getTextVectorQueryCost());     // Catch: Exception -> L7
        r12.setRankingCost(r6.getRankingCost());     // Catch: Exception -> L7
        r12.setInAppOptimizedSearch(r20);     // Catch: Exception -> L7
        r12.setPackageExecuteFinishCost(r15 - r19.getOutput().optLong("packageExecuteFinishTimestamp", -1));     // Catch: Exception -> L7
        r12.setTaskExecuteCost(r17);     // Catch: Exception -> L7
        r12.setPackageExecuteCost(r19.getOutput().optLong("packageExecuteTimestamp", -1) - r13);     // Catch: Exception -> L7
        r12.setPackagePureExecuteCost(r19.getOutput().optLong("packageExecuteTimestamp", -1) - r12.getRealPackageStartTime());     // Catch: Exception -> L7
        r12.setPackageQueryExecuteCost(r12.getRealPackageQueryStartTime() - r13);     // Catch: Exception -> L7
        r12.setStageResultHandleCost(System.currentTimeMillis() - r15);     // Catch: Exception -> L7
        r12.setQueryTotalCost(System.currentTimeMillis() - r12.getStartTime());     // Catch: Exception -> L7
        com.obric.memorydata.database.util.b.f9624a.a(r12);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        RunLog.INSTANCE.debug("EntitySearchUtils", "trackQuery fail: " + e.getMessage());
        Ensure.ensureNotReachHere((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("trackQuery fail " + e.getMessage()), Throwable.class, "com.obric.memorydata.plugin"));
    }
}
