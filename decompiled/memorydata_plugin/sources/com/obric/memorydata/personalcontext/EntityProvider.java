package com.obric.memorydata.personalcontext;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.bytedance.crash.Ensure;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.aikernel.sdk.autotest.AutoTestConstant;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.aiproactive.api.IProactiveService;
import com.obric.cae.userAware.NearElevator.NearElevator;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.common.intent.PCGlobalSearchParams;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.EntityType;
import com.obric.capabilitykit.sync.EntityCheckHashCodeSlotData;
import com.obric.capabilitykit.version.PersonalContextData;
import com.obric.memorydata.ability.data.AudioAppInfo;
import com.obric.memorydata.awareness.api.AwarenessManager;
import com.obric.memorydata.awareness.api.FeatureManager;
import com.obric.memorydata.awareness.api.ILocationSnapshot;
import com.obric.memorydata.awareness.api.LocationSnapshot;
import com.obric.memorydata.constants.DevTrackerEventId;
import com.obric.memorydata.database.dao.IAppEntityRawDbDao;
import com.obric.memorydata.database.dao.ProactiveOsNotificationDao;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.database.entity.EpisodicMemoryEntity;
import com.obric.memorydata.database.entity.aq;
import com.obric.memorydata.database.entity.ex;
import com.obric.memorydata.database.entity.ip;
import com.obric.memorydata.database.entity.iv;
import com.obric.memorydata.database.entity.iw;
import com.obric.memorydata.database.index.EntityIndexEngine;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.memory.api.MemoryService;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.bdtracker.Tracker;
import com.obric.memorydata.middleware.api.controller.ApiController;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStore;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.obric.memorydata.model.BaseResponse;
import com.obric.memorydata.observation.api.ObservationIngestService;
import com.obric.memorydata.personalcontext.api.EntityCollectorService;
import com.obric.memorydata.personalcontext.api.IEntityManager;
import com.obric.memorydata.sdk.MemoryResponse;
import com.obric.memorydata.sdk.entity.RecommendComplexQuery;
import com.obric.memorydata.sdk.entity.search.oauto.OAutoSearchResult;
import com.obric.memorydata.sdk.entity.search.userprofile.UserProfileMemoryResult;
import com.obric.memorydata.sdk.service.PermissionCheckResult;
import com.obric.memorydata.task.condition.Condition;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.task.scheduler.impl.ExistingTaskPolicy;
import com.obric.memorydata.utils.ab;
import com.obric.memorydata.utils.ah;
import com.obric.memorydata.utils.ak;
import com.obric.memorydata.utils.at;
import com.obric.memorydata.utils.threadpool.ThreadPoolContainer;
import com.obric.memorydata.utils.u;
import com.obric.memorydata.utils.y;
import com.volcengine.zeus.LocalBroadcastManager;
import com.volcengine.zeus.provider.PluginContentProvider;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u0000 F2\u00020\u0001:\u0001FB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016JO\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0010\u0010\u0010\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0012\u0018\u00010\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0010\u0010\u0014\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0012\u0018\u00010\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0002\u0010\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J1\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0010\u0010\u0014\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0012\u0018\u00010\u0011H\u0016¢\u0006\u0002\u0010\u001dJ;\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0010\u0010\u0014\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0012\u0018\u00010\u0011H\u0016¢\u0006\u0002\u0010\u001fJ$\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00122\b\u0010#\u001a\u0004\u0018\u00010\u00122\b\u0010$\u001a\u0004\u0018\u00010!H\u0016J\u0016\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&2\u0006\u0010(\u001a\u00020\u0012H\u0002J$\u0010)\u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00122\b\u0010#\u001a\u0004\u0018\u00010\u00122\b\u0010$\u001a\u0004\u0018\u00010!H\u0002J\u0016\u0010*\u001a\u00020\u00122\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00120,H\u0002J \u0010-\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020/H\u0002J\u0018\u00103\u001a\u0002042\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0002J\u0010\u00105\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020/H\u0002J\u001c\u00106\u001a\b\u0012\u0004\u0012\u00020\u00120,2\f\u00107\u001a\b\u0012\u0004\u0012\u0002080,H\u0002J(\u00109\u001a\n\u0012\u0004\u0012\u000208\u0018\u00010,2\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u00122\u0006\u0010=\u001a\u00020\u0012H\u0002J(\u0010>\u001a\n\u0012\u0004\u0012\u000208\u0018\u00010,2\u0006\u0010:\u001a\u00020;2\u0006\u0010?\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u0012H\u0002J \u0010@\u001a\n\u0012\u0004\u0012\u000208\u0018\u00010,2\u000e\u0010A\u001a\n\u0012\u0004\u0012\u000208\u0018\u00010,H\u0002J\u0010\u0010B\u001a\u00020\u00122\u0006\u0010C\u001a\u00020\u0012H\u0002J\u0010\u0010D\u001a\u00020\u00122\u0006\u0010E\u001a\u00020\u001cH\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006G"}, d2 = {"Lcom/obric/memorydata/personalcontext/EntityProvider;", "Landroid/content/ContentProvider;", "<init>", "()V", "storeManager", "Lcom/obric/memorydata/middleware/api/store/IStore;", "getStoreManager", "()Lcom/obric/memorydata/middleware/api/store/IStore;", "storeManager$delegate", "Lkotlin/Lazy;", "onCreate", "", ChatMessage.TYPE_QUERY, "Landroid/database/Cursor;", "uri", "Landroid/net/Uri;", "projection", "", "", "selection", "selectionArgs", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "getType", "insert", "values", "Landroid/content/ContentValues;", "delete", "", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", com.obric.memorydata.BuildConfig.CHANNEL, "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", NotificationCompat.CATEGORY_CALL, "Landroid/os/Bundle;", "method", "arg", "extras", "saveGlassesEnvironmentTimerSettings", "Lcom/obric/memorydata/sdk/MemoryResponse;", "Ljava/lang/Void;", EventBody.KEY_VALUE, "innerCall", "printStringArray", "array", "", "appendPreferenceWithinLimit", "resultJson", "Lorg/json/JSONObject;", "prefArray", "Lorg/json/JSONArray;", "prefObj", "trimPreferenceWithinLimit", "", "isUserInsightAndPreferenceWithinLimit", "mapToIdStringList", "appEntityList", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "getOnScreenEntities", "context", "Landroid/content/Context;", "productName", "pkgName", "queryPhotos", "authority", "getCompleteEntities", "origin", "getAudioMediaMsg", "audio", "getAudioTypeMsg", "audioType", "Companion", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class EntityProvider extends PluginContentProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12012a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f12013b;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b$\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/obric/memorydata/personalcontext/EntityProvider$Companion;", "", "<init>", "()V", "TAG", "", "USER_INSIGHT_AND_PREFERENCE_MAX_LENGTH", "", "METHOD_INDEX", "METHOD_DELETE", "METHOD_FETCH_SYNC_INFO", "METHOD_CHECK_SYNCED_DATA", "METHOD_GET_ENTITY_INDEX_PROGRESS", "METHOD_DATA_CLEAN", "METHOD_SYNC_DELETE", "METHOD_QUERY_PERSONAL_CONTEXT_DATA", "METHOD_REPORT_EVENT", "METHOD_GET_COMPLEX_RECOMMEND_QUERY", "METHOD_QUERY_USER_KEYWORD", "METHOD_IS_DONATE_ALLOWED_BY_LOCAL_SWITCH", "KEY_IS_DONATE_ALLOWED", "KEY_MAX_LAST_MODIFIED_TIME", "KEY_APP_ENTITY_COUNT", "KEY_INDEX_PROGRESS", "KEY_ERROR_CODE", "KEY_ERROR_MSG", "KEY_CLEAN_BEFORE_TIMESTAMP", "METHOD_SYNC_DATA_CHECK_COUNT_DIFF", "METHOD_SYNC_DATA_CHECK_HASH_CODE_DIFF", "PARAMS_SYNC_DATA_ENTITY_TYPE", "PARAMS_SYNC_COUNT_TIME_SLOT_DATA", "PARAMS_SYNC_COUNT_HASH_CODE_SLOT_DATA", "PARAMS_SYNC_DATA_LAZY_DELETE", "RESULT_DATA_CHECK_DIFF", "RESULT_DATA_LAZY_DELETE", "METHOD_GET_IMAGES_SIMILARITY_BY_TEXT_FROM_VECTOR_DB", "KEY_ENTITY_ID_LIST", "KEY_QUERY_TEXT", "METHOD_GET_ON_SCREEN_ENTITIES", "KEY_PRODUCT_NAME", "KEY_PKG_NAME", "KEY_ON_SCREEN_ENTITIES", "AUTHORITY_GR_QUERY_PHOTO", "checkSyncState", "", "entityCount", "entityType", "callPackage", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final void a(int r10, int r11, String r12) {
            Intrinsics.checkNotNullParameter(r12, "callPackage");
            int r9 = EntityManager.INSTANCE.queryCount(r11, r12);
            RunLog r2 = RunLog.INSTANCE;
            if (r10 == r9) goto L5;
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(r2, IRunLog.class, "com.obric.memorydata.plugin"), com.obric.capabilitykit.EntityProvider.TAG, "app(" + r12 + ")'s entity " + r11 + " not sync, db count: " + r9 + ", app entity count: " + r10, null, 4, null);
        L6:
            JSONObject r0 = new JSONObject();
            if (r10 != r9) goto L9;
            String r1 = "success";
        L10:
            r0.put("sync_state", r1);
            r0.put(com.obric.capabilitykit.EntityProvider.KEY_ENTITY_TYPE, r11);
            r0.put("entity_package_name", r12);
            r0.put("excepted_count", r10);
            r0.put("db_count", r9);
            ah.a(DevTrackerEventId.ENTITY_CONSISTENCY_STATE, r0);
            return;
        L9:
            r1 = "fail";
            goto L10
        L5:
            r2.debug(com.obric.capabilitykit.EntityProvider.TAG, "app(" + r12 + ")'s entity " + r11 + " sync success, count = " + r9);
            goto L6
        }
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonExtKt$toListObj$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends TypeToken<List<? extends AudioAppInfo>> {
        public b() {
        }
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonExtKt$toListObj$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c extends TypeToken<List<? extends AudioAppInfo>> {
        public c() {
        }
    }

    static {
        f12012a = new a(null);
    }

    public EntityProvider() {
        this.f12013b = LazyKt.lazy($$Lambda$EntityProvider$Npj0Z9VUUqtG6kYTYSdSsT5I4rI.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r0v114, types: [T, java.util.List] */
    /* JADX WARN: Type inference failed for: r0v125, types: [T, java.util.List] */
    /* JADX WARN: Type inference failed for: r5v56, types: [T, java.util.List] */
    private final Bundle a(String r44, String r45, final Bundle r46) {
        long r4 = System.currentTimeMillis();
        Bundle r6 = new Bundle();
        if (r46 != null) goto L5;
        return r6;
    L5:
        r46.getString("debugCallPackage", null);
        String r7 = getCallingPackage();
        if (r7 != null) goto L13;
        String[] r8 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageManager().getPackagesForUid(Binder.getCallingUid());
        if (r8 == null) goto L10;
        r7 = (String) ZeusTransformUtils.preCheckCast(ArraysKt.first(r8), String.class, "com.obric.memorydata.plugin");
    L11:
        if (r7 != null) goto L13;
        return r6;
    L10:
        r7 = null;
    L13:
        String r13 = r7;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), com.obric.capabilitykit.EntityProvider.TAG, "method: " + r44 + " , pkg: " + r13, false, 4, null);
        r46.setClassLoader(com.obric.capabilitykit.EntityProvider.class.getClassLoader());
        String r16 = "method: ";
        String r11 = "";
        String r12 = "memory_response";
        boolean r5 = true;
        switch(r44.hashCode()) {
            case -2105417452: goto L549;
            case -1933225009: goto L545;
            case -1769784186: goto L538;
            case -1754198046: goto L523;
            case -1651204128: goto L515;
            case -1556765256: goto L510;
            case -1335458389: goto L493;
            case -1246930592: goto L489;
            case -1185168970: goto L408;
            case -1176241111: goto L400;
            case -927272770: goto L396;
            case -919248509: goto L381;
            case -739116806: goto L378;
            case -270512698: goto L363;
            case -154439784: goto L359;
            case -50841734: goto L356;
            case -22895151: goto L349;
            case 100346066: goto L322;
            case 175137155: goto L316;
            case 181883724: goto L288;
            case 208027664: goto L284;
            case 258369047: goto L280;
            case 490826955: goto L276;
            case 642528722: goto L273;
            case 645171885: goto L269;
            case 735310085: goto L253;
            case 750621533: goto L240;
            case 789569013: goto L233;
            case 818086486: goto L210;
            case 938244519: goto L206;
            case 949865613: goto L202;
            case 1078313816: goto L195;
            case 1165226614: goto L192;
            case 1280190370: goto L188;
            case 1439240248: goto L168;
            case 1586809381: goto L165;
            case 1604657524: goto L158;
            case 1688685939: goto L146;
            case 1730118466: goto L141;
            case 1952403461: goto L138;
            case 2008100525: goto L18;
            default: goto L15;
        };
    L15:
        String r9 = r44;
        final Bundle r2 = r6;
        String r3 = "memory_response";
    L16:
        r16 = r16;
    L553:
        MemoryResponse r1 = new MemoryResponse(401, "unsupported api " + r9, null);
        r2.putParcelable(r3, (Parcelable) ZeusTransformUtils.preCheckCast(r1, Parcelable.class, "com.obric.memorydata.plugin"));
        ApiController.INSTANCE.log(r9, r46, r1);
    L554:
        Unit r0 = Unit.INSTANCE;
    L555:
        Log.i("MeD_EntityProvider", r16 + r9 + ", cost: " + (System.currentTimeMillis() - r4) + "ms");
        return r2;
    L138:
        r2 = r6;
        r3 = "memory_response";
        r9 = r44;
        if (r9.equals("pcCommonGlobalSearchIntent") == false) goto L16;
    L492:
        r16 = r16;
    L513:
        MemoryResponse r10 = new MemoryResponse(0, null, com.obric.memorydata.personalcontext.datausage.plugin.action.manager.f.f12087a.a(r9, r46), 3, null);
    L514:
        r2.putParcelable(r3, (Parcelable) ZeusTransformUtils.preCheckCast(r10, Parcelable.class, "com.obric.memorydata.plugin"));
        goto L554
    L141:
        r9 = r44;
        r2 = r6;
        r3 = "memory_response";
        if (r9.equals("getAppEntityByEntityType") == false) goto L16;
        final int r14 = r46.getInt("entityType");
        final int r15 = r46.getInt("limit", 1);
        Object r17 = y.a(new $$Lambda$EntityProvider$7yGAcFkuI5CuINYZjbC6xp4CTQ(r2), new $$Lambda$EntityProvider$oCO5MjrkygKpqIiVSpxXfjiSNWo(r14, r15, r2));
    L145:
        Unit r18 = (Unit) ZeusTransformUtils.preCheckCast(r17, Unit.class, "com.obric.memorydata.plugin");
    L407:
        r16 = r16;
        goto L555
    L146:
        r9 = r44;
        r2 = r6;
        r3 = "memory_response";
        if (r9.equals("getAppEntityListByEntityTypeAndEntityIdList") == false) goto L16;
        final Map r19 = MapsKt.toMutableMap(MapsKt.emptyMap());
        Set<String> r20 = r46.keySet();
        Intrinsics.checkNotNullExpressionValue(r20, "keySet(...)");
        Iterator r21 = ((Iterable) ZeusTransformUtils.preCheckCast(r20, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L151:
        if (r21.hasNext() == false) goto L157;
        String r22 = (String) ZeusTransformUtils.preCheckCast(r21.next(), String.class, "com.obric.memorydata.plugin");
        ArrayList<String> r23 = r46.getStringArrayList(r22);
        if (r23 == null) goto L155;
        List r24 = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r23, Iterable.class, "com.obric.memorydata.plugin"));
    L156:
        r19.put(r22, r24);
        goto L151
    L155:
        r24 = null;
        goto L156
    L157:
        r17 = y.a(new $$Lambda$EntityProvider$N8Q0NLRSd0jLb44K3QMTWmTYzw(r2), new $$Lambda$EntityProvider$nGbsDqBNjdhGVa_ApnAUbtgYnhc(r19, r2));
        goto L145
    L158:
        r9 = r44;
        r2 = r6;
        r3 = "memory_response";
        if (r9.equals("data_clean") == false) goto L16;
        long r25 = r46.getLong(com.obric.capabilitykit.EntityProvider.KEY_CLEAN_BEFORE_TIMESTAMP, 0);
        if (r25 <= 0) goto L164;
        EntityManager.INSTANCE.deleteAllBeforeTimestamp(r13, r25);
    L406:
        Unit r26 = Unit.INSTANCE;
        goto L407
    L164:
        EntityManager.INSTANCE.deleteAll(r13);
        goto L406
    L165:
        r9 = r44;
        r2 = r6;
        r3 = "memory_response";
        if (r9.equals("pcSearchAppEntityIntent") == true) goto L492;
    L168:
        r9 = r44;
        r2 = r6;
        r3 = "memory_response";
        if (r9.equals("receiveNotificationData") == false) goto L16;
        if (Intrinsics.areEqual(r13, "com.larus.nova") == false) goto L187;
        int r36 = r46.getInt("notificationId");
        String r27 = r46.getString("pkg");
        long r34 = r46.getLong("postTime");
        String r37 = r46.getString("appName");
        String r28 = r46.getString("title", "");
        String r39 = r46.getString("subTitle");
        String r29 = r46.getString(Params.CONTENT, "");
        String r40 = r46.getString("channel");
        int r38 = r46.getInt("flags", 0);
        if (r36 == 0) goto L184;
        if (r27 == null) goto L184;
        if (r34 == 0) goto L184;
        if (r37 == null) goto L184;
        if (p.f12240a.a(r27, r28, r29) == false) goto L185;
        ProactiveOsNotificationDao r30 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getProactiveOsNotificationDao();
        long r210 = System.currentTimeMillis();
        Intrinsics.checkNotNull(r28);
        Intrinsics.checkNotNull(r29);
        Long.valueOf(r30.insert(new ex(r210, r27, r28, r29, 0, r34, r36, r37, r38, r39, r40, 16, null)));
    L186:
        Object r31 = new MemoryResponse(0, null, "", 3, null);
    L404:
        Object r32 = ZeusTransformUtils.preCheckCast(r31, Parcelable.class, "com.obric.memorydata.plugin");
    L405:
        r2.putParcelable(r3, (Parcelable) r32);
    L185:
        Unit r33 = Unit.INSTANCE;
    L184:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), com.obric.capabilitykit.EntityProvider.TAG, "receiveNotificationData, invalid params", null, 4, null);
        goto L185
    L187:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), com.obric.capabilitykit.EntityProvider.TAG, "receiveNotificationData, callPackage error:" + r13, null, 4, null);
        r31 = new MemoryResponse(0, null, "callPackage error", 3, null);
        goto L404
    L188:
        r9 = r44;
        r2 = r6;
        r3 = "memory_response";
        if (r9.equals("query_personal_context_data") == false) goto L16;
        new PersonalContextData(EntityType.INSTANCE.getClassMap().keySet()).fillBundle(r2);
        goto L406
    L192:
        r9 = r44;
        r2 = r6;
        r3 = "memory_response";
        if (r9.equals("pcIntentGlobalSearchIntent") == true) goto L492;
    L195:
        r9 = r44;
        r2 = r6;
        r3 = "memory_response";
        if (r9.equals("rcSearchStateWhenStartQuery") == false) goto L16;
        if (UserSettings.INSTANCE.hasAgreePrivacy() == false) goto L201;
        r32 = ZeusTransformUtils.preCheckCast(new MemoryResponse(0, null, com.obric.memorydata.personalcontext.realcontext.c.f12262a.a((List) ZeusTransformUtils.preCheckCast(r46.getStringArrayList("feature_name_list"), List.class, "com.obric.memorydata.plugin"), r13), 3, null), Parcelable.class, "com.obric.memorydata.plugin");
        goto L405
    L201:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), com.obric.capabilitykit.EntityProvider.TAG, "rcSearchStateWhenStartQuery, privacy not agree", false, 4, null);
        r32 = ZeusTransformUtils.preCheckCast(new MemoryResponse(0, null, "", 3, null), Parcelable.class, "com.obric.memorydata.plugin");
        goto L405
    L202:
        r9 = r44;
        r2 = r6;
        r3 = "memory_response";
        if (r9.equals("fetch_sync_info") == false) goto L16;
        r2.putLong("max_last_modified_time", EntityManager.INSTANCE.queryLastModifiedTime(r46.getInt(com.obric.capabilitykit.EntityProvider.KEY_ENTITY_TYPE), r13));
        goto L406
    L206:
        r9 = r44;
        r2 = r6;
        r3 = "memory_response";
        if (r9.equals("preloadAssistantSearchModels") == false) goto L16;
        ThreadPoolContainer.Companion r35 = ThreadPoolContainer.Companion;
        Runnable r41 = $$Lambda$EntityProvider$0pZoE2PmrUarrazT58hdC7XW8so.INSTANCE;
    L320:
        r35.execute(r41);
    L321:
        r31 = MemoryResponse.CREATOR.a();
        goto L404
    L210:
        r9 = r44;
        r2 = r6;
        r3 = "memory_response";
        if (r9.equals("notifyDoubaoGlassesState") == false) goto L16;
        final String r42 = r46.getString("doubaoGlassesStateKey", "");
        final String r43 = r46.getString("doubaoGlassesStateValue", "");
        if (Intrinsics.areEqual(r42, "glasses_environment_timer_settings") == false) goto L218;
        Intrinsics.checkNotNull(r43);
        r2.putParcelable(r3, (Parcelable) ZeusTransformUtils.preCheckCast(a(r43), Parcelable.class, "com.obric.memorydata.plugin"));
        return r2;
    L218:
        if (Intrinsics.areEqual(r42, "glasses_product_id") == false) goto L232;
        IStore r47 = a();
        Intrinsics.checkNotNull(r43);
        Integer r48 = StringsKt.toIntOrNull(r43);
        if (r48 != null) goto L222;
    L230:
        int r49 = 0;
    L231:
        r47.save(r42, r49);
        goto L321
    L222:
        if (((Number) ZeusTransformUtils.preCheckCast(r48, Number.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L224;
        boolean r211 = true;
    L225:
        if (r211 == false) goto L227;
        Integer r50 = r48;
    L228:
        if (r50 == null) goto L230;
        r49 = r50.intValue();
        goto L231
    L227:
        r50 = null;
        goto L228
    L224:
        r211 = false;
        goto L225
    L232:
        ThreadPoolContainer.Companion.execute(new $$Lambda$EntityProvider$1cnWToGpIFH6HKtT7VP6OhYPWE(r42, r43));
        goto L321
    L233:
        r9 = r44;
        r2 = r6;
        r3 = "memory_response";
        if (r9.equals("notifyEvaluationQueryFinished") == false) goto L16;
        String r51 = r46.getString(ChatMessage.TYPE_QUERY);
        boolean r52 = r46.getBoolean("isFinished");
        if (com.obric.memorydata.personalcontext.log.a.f12229a.b() == false) goto L239;
        kotlinx.coroutines.i.a(am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new EntityProvider$innerCall$14(r51, r52, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    L239:
        r31 = new MemoryResponse(0, null, "", 3, null);
        goto L404
    L240:
        r9 = r44;
        r2 = r6;
        r3 = "memory_response";
        if (r9.equals("get_on_screen_entities") == false) goto L16;
        String r53 = r46.getString("product_name");
        if (r53 != null) goto L246;
        r53 = "";
    L246:
        String r54 = r46.getString("pkg_name");
        if (r54 != null) goto L249;
        String r110 = "";
    L250:
        List<AppEntity> r55 = a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r53, r110);
        if (r55 == null) goto L406;
        r2.putParcelableArrayList("on_screen_entities", new ArrayList((Collection) ZeusTransformUtils.preCheckCast(r55, Collection.class, "com.obric.memorydata.plugin")));
        goto L406
    L249:
        r110 = r54;
        goto L250
    L253:
        r9 = r44;
        r2 = r6;
        r3 = "memory_response";
        if (r9.equals("oAutoGlobalSearchIntent") == false) goto L16;
        JSONObject r56 = new JSONObject(r46.getString("oAutoGlobalSearchExecutorParams", ""));
        Object r57 = r56.opt("quResult");
        if (ZeusTransformUtils.instanceOf(r57, String.class) == false) goto L259;
        String r58 = (String) ZeusTransformUtils.preCheckCast(r57, String.class, "com.obric.memorydata.plugin");
    L260:
        Object r59 = r56.opt("interactionType");
        if (ZeusTransformUtils.instanceOf(r59, String.class) == false) goto L263;
        String r60 = (String) ZeusTransformUtils.preCheckCast(r59, String.class, "com.obric.memorydata.plugin");
    L264:
        IntentResult<Empty> r61 = com.obric.memorydata.personalcontext.datausage.plugin.action.manager.c.f12084a.a(new PCGlobalSearchParams(r58, r60), null);
        if (r61.getRet() != 0) goto L267;
        OAutoSearchResult r62 = new OAutoSearchResult(0, null, r61.getDetails());
    L268:
        r31 = new MemoryResponse(0, null, r62, 3, null);
        goto L404
    L267:
        r62 = new OAutoSearchResult(400, r61.getDetails(), null);
        goto L268
    L263:
        r60 = null;
        goto L264
    L259:
        r58 = null;
        goto L260
    L269:
        r9 = r44;
        r2 = r6;
        r3 = "memory_response";
        if (r9.equals("get_entity_index_progress") == false) goto L16;
        r2.putString("index_progress", ab.a().toJson(com.obric.memorydata.personalcontext.index.a.f12223a.a(r13, r46.getInt(com.obric.capabilitykit.EntityProvider.KEY_ENTITY_TYPE))));
        goto L406
    L273:
        r9 = r44;
        r2 = r6;
        r3 = "memory_response";
        if (r9.equals("pcAppFcEntitySearchIntent") == true) goto L492;
    L276:
        r9 = r44;
        r2 = r6;
        r3 = "memory_response";
        if (r9.equals("checkDependencyPermissionForSearchIntent") == false) goto L16;
        String r63 = r46.getString("pcSearchIntent", "");
        String r64 = r46.getString("quResultJson", "");
        f r65 = f.f12179a;
        Intrinsics.checkNotNull(r63);
        Intrinsics.checkNotNull(r64);
        MemoryResponse<PermissionCheckResult> r66 = r65.a(r63, r64);
        r2.putParcelable(r3, (Parcelable) ZeusTransformUtils.preCheckCast(r66, Parcelable.class, "com.obric.memorydata.plugin"));
        ApiController.INSTANCE.log(r9, r46, r66);
        goto L406
    L280:
        r9 = r44;
        r2 = r6;
        r3 = "memory_response";
        if (r9.equals("queryUserProfileMemory") == false) goto L16;
        String r67 = r46.getString("profileKey", "");
        com.obric.memorydata.personalcontext.search.a.a r68 = com.obric.memorydata.personalcontext.search.a.a.f12276a;
        Intrinsics.checkNotNull(r67);
        r31 = new MemoryResponse(0, null, new UserProfileMemoryResult(0, null, r68.a(r13, r67)), 3, null);
        goto L404
    L284:
        r9 = r44;
        r2 = r6;
        r3 = "memory_response";
        if (r9.equals("notifyUserAgreePrivacy") == false) goto L16;
        LocalBroadcastManager.getInstance((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).sendBroadcast(new Intent(UserSettings.ACTION_USER_AGREE_STATE_CHANGED));
        r2.putParcelable(r3, (Parcelable) ZeusTransformUtils.preCheckCast(MemoryResponse.CREATOR.a(), Parcelable.class, "com.obric.memorydata.plugin"));
        ApiController.INSTANCE.log(r9, "", MemoryResponse.CREATOR.a());
        goto L406
    L288:
        r9 = r44;
        r2 = r6;
        r3 = "memory_response";
        if (r9.equals("queryRealTimeAwarenessData") == false) goto L16;
        JSONObject r69 = new JSONObject();
        Object r70 = FeatureManager.INSTANCE.getFeature("device_active_audio");
        if (ZeusTransformUtils.instanceOf(r70, String.class) == true) goto L571;
    L315:
        r31 = new MemoryResponse(0, null, r69.toString(), 3, null);
        goto L404
    L571:
        List r71 = (List) ZeusTransformUtils.preCheckCast(u.a().fromJson((String) ZeusTransformUtils.preCheckCast(r70, String.class, "com.obric.memorydata.plugin"), new c().getType()), List.class, "com.obric.memorydata.plugin");     // Catch: JsonParseException -> L296 JsonSyntaxException -> L298
    L301:
        if (r71 != null) goto L303;
        r71 = CollectionsKt.emptyList();
    L303:
        JSONArray r72 = new JSONArray();
        Iterator r73 = ((Iterable) ZeusTransformUtils.preCheckCast(r71, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L305:
        if (r73.hasNext() == false) goto L314;
        AudioAppInfo r74 = (AudioAppInfo) ZeusTransformUtils.preCheckCast(r73.next(), AudioAppInfo.class, "com.obric.memorydata.plugin");
        if (r74.getActive() == false) goto L305;
        JSONObject r111 = new JSONObject();
        r111.put("audioType", b(r74.getAudioType()));
        r111.put(ObricMemoryConstants.KEY_PACKAGE_NAME, r74.getPackageName());
        r111.put("outputType", a(r74.getOutputType()));
        com.obric.memorydata.utils.c.a r75 = com.obric.memorydata.utils.c.a(com.obric.memorydata.utils.c.f13193a, r74.getPackageName(), null, 2, null);
        if (r75 == null) goto L312;
        String r76 = r75.a();
        if (r76 == null) goto L312;
    L313:
        r111.put("appName", r76);
        r72.put(r111);
    L312:
        r76 = "";
        goto L313
    L314:
        r69.put("audio", r72.toString());
        goto L315
    L298:
        e = e;
        IRunLog r212 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r77 = new StringBuilder();
    L300:
        IRunLog.a.b(r212, "GsonExt", r77.append("toListObj error : ").append(e).toString(), null, 4, null);
        r71 = null;
    L296:
        e = e;
        r212 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r77 = new StringBuilder();
        goto L300
    L316:
        r9 = r44;
        r2 = r6;
        r3 = "memory_response";
        if (r9.equals("cancelUseAssistantSearchModels") == false) goto L16;
        r35 = ThreadPoolContainer.Companion;
        r41 = $$Lambda$EntityProvider$ZiurgTEybp7FmIVoRzV8wuoIs.INSTANCE;
        goto L320
    L322:
        r9 = r44;
        r2 = r6;
        r3 = "memory_response";
        if (r9.equals("index") == false) goto L16;
        Ref.ObjectRef r78 = new Ref.ObjectRef();
        r78.element = CollectionsKt.emptyList();
        ArrayList r79 = r46.getParcelableArrayList(com.obric.capabilitykit.EntityProvider.KEY_ENTITY_LIST);
        if (r79 == null) goto L347;
        IRunLog r213 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r80 = new StringBuilder().append("index called, entityType: ");
        AppEntity r81 = (AppEntity) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull((List) ZeusTransformUtils.preCheckCast(r79, List.class, "com.obric.memorydata.plugin")), AppEntity.class, "com.obric.memorydata.plugin");
        if (r81 == null) goto L330;
        Integer r82 = Integer.valueOf(r81.getType());
    L331:
        IRunLog.a.a(r213, com.obric.capabilitykit.EntityProvider.TAG, r80.append(r82).append(" entityIds:").append(a(b((List) ZeusTransformUtils.preCheckCast(r79, List.class, "com.obric.memorydata.plugin")))).toString(), false, 4, null);
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r79, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L346;
        BaseResponse r83 = j.f12225a.a(r13, ((AppEntity) ZeusTransformUtils.preCheckCast(CollectionsKt.first((List) ZeusTransformUtils.preCheckCast(r79, List.class, "com.obric.memorydata.plugin")), AppEntity.class, "com.obric.memorydata.plugin")).getType());
        if (r83.getCode() == 0) goto L337;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), com.obric.capabilitykit.EntityProvider.TAG, "check permission denied, response: " + r83.getCode() + " : " + r83.getMsg(), null, 4, null);
        r2.putInt("error_code", r83.getCode());
        r2.putString("error_msg", r83.getMsg());
        goto L346
    L337:
        if (AppContext.INSTANCE.isDebug() == true) goto L339;
    L345:
        r78.element = EntityManager.INSTANCE.bulkIndex((List) ZeusTransformUtils.preCheckCast(r79, List.class, "com.obric.memorydata.plugin"));
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), com.obric.capabilitykit.EntityProvider.TAG, "bulkIndex result: " + a((List) ZeusTransformUtils.preCheckCast(r78.element, List.class, "com.obric.memorydata.plugin")), false, 4, null);
        goto L346
    L339:
        if (com.obric.memorydata.personalcontext.external.g.f12138a.a(((AppEntity) ZeusTransformUtils.preCheckCast(CollectionsKt.first((List) ZeusTransformUtils.preCheckCast(r79, List.class, "com.obric.memorydata.plugin")), AppEntity.class, "com.obric.memorydata.plugin")).getType(), r13) == false) goto L345;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), com.obric.capabilitykit.EntityProvider.TAG, "interruptIndex by external collector, entityType: " + ((AppEntity) ZeusTransformUtils.preCheckCast(CollectionsKt.first((List) ZeusTransformUtils.preCheckCast(r79, List.class, "com.obric.memorydata.plugin")), AppEntity.class, "com.obric.memorydata.plugin")).getType() + ", packageName = " + r13, false, 4, null);
        Iterable r84 = (Iterable) ZeusTransformUtils.preCheckCast(r79, Iterable.class, "com.obric.memorydata.plugin");
        Collection r85 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r84, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r86 = r84.iterator();
    L342:
        if (r86.hasNext() == false) goto L344;
        r85.add(((AppEntity) ZeusTransformUtils.preCheckCast(r86.next(), AppEntity.class, "com.obric.memorydata.plugin")).getId());
        goto L342
    L344:
        r78.element = (List) ZeusTransformUtils.preCheckCast(r85, List.class, "com.obric.memorydata.plugin");
    L346:
        Unit r87 = Unit.INSTANCE;
        Unit r88 = Unit.INSTANCE;
        goto L347
    L330:
        r82 = null;
    L347:
        ArrayList<String> r89 = (ArrayList) ZeusTransformUtils.preCheckCast(CollectionsKt.toCollection((Iterable) ZeusTransformUtils.preCheckCast(r78.element, Iterable.class, "com.obric.memorydata.plugin"), (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin")), ArrayList.class, "com.obric.memorydata.plugin");
        String r90 = com.obric.capabilitykit.EntityProvider.KEY_SUCCESS_IDS;
    L348:
        r2.putStringArrayList(r90, r89);
        goto L406
    L349:
        r9 = r44;
        r2 = r6;
        r3 = "memory_response";
        if (r9.equals("syncDataCheckCountDiff") == false) goto L16;
        ArrayList r91 = r46.getParcelableArrayList("syncCountTimeSlotDataList");
        int r92 = r46.getInt("syncDataEntityType", -1);
        if (r91 == null) goto L406;
        if (r92 == (-1)) goto L406;
        r2.putParcelableArrayList("checkDiffResult", com.obric.memorydata.personalcontext.util.e.f12369a.a((List) ZeusTransformUtils.preCheckCast(r91, List.class, "com.obric.memorydata.plugin"), r92, r13, false));
        goto L406
    L356:
        r9 = r44;
        r2 = r6;
        r3 = "memory_response";
        if (r9.equals("pcPersonalContextFetchIntent") == true) goto L492;
    L359:
        r9 = r44;
        r2 = r6;
        r3 = "memory_response";
        if (r9.equals("check_synced_data") == false) goto L16;
        f12012a.a(r46.getInt("app_entity_count"), r46.getInt(com.obric.capabilitykit.EntityProvider.KEY_ENTITY_TYPE), r13);
        goto L406
    L363:
        r9 = r44;
        r2 = r6;
        r3 = "memory_response";
        if (r9.equals("reportEvent") == false) goto L16;
        String r93 = r46.getString("event");
        String r94 = r46.getString(TrackerImpl.PARAMS);
        if (r94 != null) goto L369;
        r94 = "{}";
    L369:
        JSONObject r95 = new JSONObject(r94);
        CharSequence r96 = (CharSequence) ZeusTransformUtils.preCheckCast(r93, CharSequence.class, "com.obric.memorydata.plugin");
        if (r96 != null) goto L372;
    L375:
        boolean r214 = true;
    L376:
        if (r214 == true) goto L321;
        Tracker.INSTANCE.reportEvent(r93, r95);
        goto L321
    L372:
        if (r96.length() == 0) goto L375;
        r214 = false;
        goto L376
    L378:
        r9 = r44;
        r2 = r6;
        r3 = "memory_response";
        if (r9.equals("pcGlobalSearchIntent") == true) goto L492;
    L381:
        r9 = r44;
        r2 = r6;
        r3 = "memory_response";
        if (r9.equals("syncDataCheckHashCodeDiff") == false) goto L16;
        EntityCheckHashCodeSlotData r97 = (EntityCheckHashCodeSlotData) ZeusTransformUtils.preCheckCast(r46.getParcelable("syncHashCodeSlotDataList"), EntityCheckHashCodeSlotData.class, "com.obric.memorydata.plugin");
        int r98 = r46.getInt("syncDataEntityType", -1);
        boolean r99 = r46.getBoolean("syncDataLazyDelete", false);
        if (r97 == null) goto L406;
        if (r98 == (-1)) goto L406;
        com.obric.memorydata.personalcontext.util.e.a r100 = com.obric.memorydata.personalcontext.util.e.f12369a.a(r97, r98, r13, r99);
        r2.putStringArrayList("checkDiffResult", r100.a());
        Collection r101 = (Collection) ZeusTransformUtils.preCheckCast(r100.b(), Collection.class, "com.obric.memorydata.plugin");
        if (r101 != null) goto L390;
    L393:
        boolean r215 = true;
    L394:
        if (r215 == true) goto L406;
        r89 = r100.b();
        r90 = "dataLazyDelete";
        goto L348
    L390:
        if (r101.isEmpty() == true) goto L393;
        r215 = false;
        goto L394
    L396:
        r9 = r44;
        r2 = r6;
        r3 = "memory_response";
        if (r9.equals("is_donate_allowed_by_local_switch") == false) goto L16;
        r2.putBoolean("is_donate_allowed", e.f12095a.a(r46.getInt(com.obric.capabilitykit.EntityProvider.KEY_ENTITY_TYPE)));
        goto L406
    L400:
        r9 = r44;
        r2 = r6;
        r3 = "memory_response";
        if (r9.equals("getMemorySynthesisRecommendQuery") == false) goto L16;
        r31 = r.f12257a.a(r46.getInt("limit", 10));
        goto L404
    L408:
        r9 = r44;
        r2 = r6;
        r3 = "memory_response";
        if (r9.equals("queryUserKeyword") == false) goto L16;
        long r102 = System.currentTimeMillis();
        int r103 = r46.getInt("limit", 200);
        int r104 = r46.getInt("wordLimit", NearElevator.WIFI_SCAN_INTERVAL_WHEN_OUT_ELEVATOR);
        List r105 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Ref.IntRef r106 = new Ref.IntRef();
        long r112 = System.currentTimeMillis();
        if (r103 <= 0) goto L414;
        List<String> r113 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getContactRawDbDao().queryContactNameWithLimit(r103);
    L415:
        a(r105, r103, r106, r104, (Iterable) ZeusTransformUtils.preCheckCast(r113, Iterable.class, "com.obric.memorydata.plugin"));
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), com.obric.capabilitykit.EntityProvider.TAG, "queryUserKeyword stage=contact cost=" + (System.currentTimeMillis() - r112) + "ms, count=" + r113.size(), false, 4, null);
        long r114 = System.currentTimeMillis();
        Object r115 = FeatureManager.INSTANCE.getFeature("location_home_gps");
        if (r115 != null) goto L418;
    L440:
        r6 = r2;
        String r216 = r3;
        long r217 = r102;
    L441:
        int r107 = 0;
    L442:
        Object r108 = FeatureManager.INSTANCE.getFeature("location_company_gps");
        if (r108 != null) goto L445;
    L466:
        List r109 = ILocationSnapshot.a.b((ILocationSnapshot) ZeusTransformUtils.preCheckCast(LocationSnapshot.INSTANCE, ILocationSnapshot.class, "com.obric.memorydata.plugin"), 0, 1, null);
        if (r109 != null) goto L469;
    L484:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), com.obric.capabilitykit.EntityProvider.TAG, "queryUserKeyword stage=location_cache cost=" + (System.currentTimeMillis() - r114) + "ms, hitCount=" + r107, false, 4, null);
        int r116 = r103 - ((Collection) ZeusTransformUtils.preCheckCast(r105, Collection.class, "com.obric.memorydata.plugin")).size();
        long r117 = System.currentTimeMillis();
        if (r116 <= 0) goto L487;
        a(r105, r103, r106, r104, (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getUserKeywordDao().queryWithLimitAndDesc(r116), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"));
    L487:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), com.obric.capabilitykit.EntityProvider.TAG, "queryUserKeyword stage=user_keyword_db cost=" + (System.currentTimeMillis() - r117) + "ms, remainLimit=" + r116, false, 4, null);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), com.obric.capabilitykit.EntityProvider.TAG, "queryUserKeyword result, cost=" + (System.currentTimeMillis() - r217) + "ms, count=" + r105.size() + ", totalLength=" + r106.element + ", limit=" + r103 + ", tokenLimit=" + r104, false, 4, null);
        MemoryResponse r118 = new MemoryResponse(0, null, ab.a().toJson(r105), 3, null);
    L488:
        r2 = r6;
        r2.putParcelable(r216, (Parcelable) ZeusTransformUtils.preCheckCast(r118, Parcelable.class, "com.obric.memorydata.plugin"));
        Unit r119 = Unit.INSTANCE;
        r9 = r44;
        goto L407
    L469:
        if (((Collection) ZeusTransformUtils.preCheckCast(r109, Collection.class, "com.obric.memorydata.plugin")).size() != 2) goto L484;
        String r120 = AwarenessManager.INSTANCE.getCachedAddressByGps(((Number) ZeusTransformUtils.preCheckCast(r109.get(0), Number.class, "com.obric.memorydata.plugin")).doubleValue(), ((Number) ZeusTransformUtils.preCheckCast(r109.get(1), Number.class, "com.obric.memorydata.plugin")).doubleValue());
        CharSequence r121 = (CharSequence) ZeusTransformUtils.preCheckCast(r120, CharSequence.class, "com.obric.memorydata.plugin");
        if (r121 != null) goto L473;
    L476:
        boolean r122 = true;
    L477:
        if (r122 == true) goto L484;
        r107 = r107 + 1;
        String r123 = com.obric.memorydata.personalcontext.util.b.f12361a.a(r120);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r123, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L481;
        boolean r124 = true;
    L482:
        if (r124 == false) goto L484;
        a(r105, r103, r106, r104, r123);
        goto L484
    L481:
        r124 = false;
        goto L482
    L473:
        if (r121.length() == 0) goto L476;
        r122 = false;
        goto L477
    L445:
        if (ZeusTransformUtils.instanceOf(r108, List.class) == false) goto L466;
        if (((Collection) ZeusTransformUtils.preCheckCast(r108, Collection.class, "com.obric.memorydata.plugin")).size() != 2) goto L466;
        if (ZeusTransformUtils.instanceOf(((List) ZeusTransformUtils.preCheckCast(r108, List.class, "com.obric.memorydata.plugin")).get(0), Double.class) == false) goto L466;
        if (ZeusTransformUtils.instanceOf(((List) ZeusTransformUtils.preCheckCast(r108, List.class, "com.obric.memorydata.plugin")).get(1), Double.class) == false) goto L466;
        AwarenessManager r125 = AwarenessManager.INSTANCE;
        Object r126 = ((List) ZeusTransformUtils.preCheckCast(r108, List.class, "com.obric.memorydata.plugin")).get(0);
        Intrinsics.checkNotNull(r126, "null cannot be cast to non-null type kotlin.Double");
        double r127 = ((Double) ZeusTransformUtils.preCheckCast(r126, Double.class, "com.obric.memorydata.plugin")).doubleValue();
        Object r128 = ((List) ZeusTransformUtils.preCheckCast(r108, List.class, "com.obric.memorydata.plugin")).get(1);
        Intrinsics.checkNotNull(r128, "null cannot be cast to non-null type kotlin.Double");
        String r129 = r125.getCachedAddressByGps(r127, ((Double) ZeusTransformUtils.preCheckCast(r128, Double.class, "com.obric.memorydata.plugin")).doubleValue());
        CharSequence r130 = (CharSequence) ZeusTransformUtils.preCheckCast(r129, CharSequence.class, "com.obric.memorydata.plugin");
        if (r130 != null) goto L455;
    L458:
        boolean r131 = true;
    L459:
        if (r131 == true) goto L466;
        r107 = r107 + 1;
        String r132 = com.obric.memorydata.personalcontext.util.b.f12361a.a(r129);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r132, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L463;
        boolean r133 = true;
    L464:
        if (r133 == false) goto L466;
        a(r105, r103, r106, r104, r132);
        goto L466
    L463:
        r133 = false;
        goto L464
    L455:
        if (r130.length() == 0) goto L458;
        r131 = false;
        goto L459
    L418:
        if (ZeusTransformUtils.instanceOf(r115, List.class) == false) goto L440;
        if (((Collection) ZeusTransformUtils.preCheckCast(r115, Collection.class, "com.obric.memorydata.plugin")).size() != 2) goto L440;
        if (ZeusTransformUtils.instanceOf(((List) ZeusTransformUtils.preCheckCast(r115, List.class, "com.obric.memorydata.plugin")).get(0), Double.class) == false) goto L440;
        if (ZeusTransformUtils.instanceOf(((List) ZeusTransformUtils.preCheckCast(r115, List.class, "com.obric.memorydata.plugin")).get(1), Double.class) == false) goto L440;
        AwarenessManager r134 = AwarenessManager.INSTANCE;
        Object r135 = ((List) ZeusTransformUtils.preCheckCast(r115, List.class, "com.obric.memorydata.plugin")).get(0);
        Intrinsics.checkNotNull(r135, "null cannot be cast to non-null type kotlin.Double");
        r6 = r2;
        r216 = r3;
        double r136 = ((Double) ZeusTransformUtils.preCheckCast(r135, Double.class, "com.obric.memorydata.plugin")).doubleValue();
        Object r137 = ((List) ZeusTransformUtils.preCheckCast(r115, List.class, "com.obric.memorydata.plugin")).get(1);
        Intrinsics.checkNotNull(r137, "null cannot be cast to non-null type kotlin.Double");
        r217 = r102;
        String r138 = r134.getCachedAddressByGps(r136, ((Double) ZeusTransformUtils.preCheckCast(r137, Double.class, "com.obric.memorydata.plugin")).doubleValue());
        CharSequence r139 = (CharSequence) ZeusTransformUtils.preCheckCast(r138, CharSequence.class, "com.obric.memorydata.plugin");
        if (r139 != null) goto L428;
    L431:
        boolean r140 = true;
    L432:
        if (r140 == true) goto L441;
        String r141 = com.obric.memorydata.personalcontext.util.b.f12361a.a(r138);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r141, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L436;
        boolean r142 = true;
    L437:
        if (r142 == false) goto L439;
        a(r105, r103, r106, r104, r141);
    L439:
        r107 = 1;
        goto L442
    L436:
        r142 = false;
        goto L437
    L428:
        if (r139.length() == 0) goto L431;
        r140 = false;
        goto L432
    L414:
        r113 = CollectionsKt.emptyList();
        goto L415
    L489:
        r2 = r6;
        r3 = "memory_response";
        r9 = r44;
        if (r9.equals("pcPersonalContextSearchIntent") == true) goto L492;
    L493:
        r9 = r44;
        r2 = r6;
        r3 = "memory_response";
        if (r9.equals("delete") == false) goto L16;
        List<String> r143 = CollectionsKt.emptyList();
        String[] r144 = r46.getStringArray(com.obric.capabilitykit.EntityProvider.KEY_ENTITY_IDS);
        int r145 = r46.getInt(com.obric.capabilitykit.EntityProvider.KEY_ENTITY_TYPE);
        if (AppContext.INSTANCE.isDebug() == true) goto L499;
    L506:
        if (r144 == null) goto L509;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), com.obric.capabilitykit.EntityProvider.TAG, "delete called, entityType: " + r145 + " entityIds: " + a(ArraysKt.toList(r144)), false, 4, null);
        r143 = IEntityManager.a.a((IEntityManager) ZeusTransformUtils.preCheckCast(EntityManager.INSTANCE, IEntityManager.class, "com.obric.memorydata.plugin"), ArraysKt.toList(r144), r145, r13, null, 8, null);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), com.obric.capabilitykit.EntityProvider.TAG, "bulkDelete result: " + a(r143), false, 4, null);
        Unit r146 = Unit.INSTANCE;
        Unit r147 = Unit.INSTANCE;
    L509:
        r2.putStringArrayList(com.obric.capabilitykit.EntityProvider.KEY_SUCCESS_IDS, (ArrayList) ZeusTransformUtils.preCheckCast(CollectionsKt.toCollection((Iterable) ZeusTransformUtils.preCheckCast(r143, Iterable.class, "com.obric.memorydata.plugin"), (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin")), ArrayList.class, "com.obric.memorydata.plugin"));
        goto L554
    L499:
        if (com.obric.memorydata.personalcontext.external.g.f12138a.a(r145, r13) == false) goto L506;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), com.obric.capabilitykit.EntityProvider.TAG, "interruptDelete by external collector, entityType: " + r145 + ", packageName = " + r13, false, 4, null);
        if (r144 == null) goto L504;
        List<String> r148 = ArraysKt.toList(r144);
        if (r148 == null) goto L504;
    L505:
        r143 = r148;
        Unit r149 = Unit.INSTANCE;
    L504:
        r148 = CollectionsKt.emptyList();
        goto L505
    L510:
        r9 = r44;
        r2 = r6;
        r3 = "memory_response";
        r16 = r16;
        if (r9.equals("rcGlobalSearchIntent") == true) goto L513;
    L515:
        r9 = r44;
        r2 = r6;
        r3 = "memory_response";
        r16 = r16;
        if (r9.equals("getImagesSimilarityByTextFromVectorDB") == false) goto L553;
        r2.putString(r3, com.obric.memorydata.personalcontext.search.e.f12310a.a((List) ZeusTransformUtils.preCheckCast(r46.getStringArrayList("entity_id_list"), List.class, "com.obric.memorydata.plugin"), r46.getString("query_text"), r13));     // Catch: Exception -> L521
    L521:
        e = move-exception;
        Ensure.ensureNotReachHere((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        IRunLog r150 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        e.printStackTrace();
        IRunLog.a.b(r150, com.obric.capabilitykit.EntityProvider.TAG, Unit.INSTANCE.toString(), null, 4, null);
        r2.putString(r3, null);
        goto L554
    L523:
        r9 = r44;
        r2 = r6;
        r3 = "memory_response";
        r16 = r16;
        if (r9.equals("newOAutoGlobalSearchExecutorParams") == false) goto L553;
        if (UserSettings.INSTANCE.hasAgreePrivacy() == true) goto L529;
    L536:
        IRunLog r151 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        boolean r152 = false;
        int r153 = 4;
        Object r154 = null;
        String r155 = com.obric.capabilitykit.EntityProvider.TAG;
        String r156 = "NEW_KEY_O_AUTO_GLOBAL_SEARCH_EXECUTOR_PARAMS privacy not agree";
    L537:
        IRunLog.a.a(r151, r155, r156, r152, r153, r154);
        goto L554
    L529:
        if (MemoryService.INSTANCE.assistantSmartMemoryEnabled() == false) goto L536;
        String r157 = r46.getString("oAutoGlobalSearchExecutorParams");
        if (r157 == null) goto L554;
        String r158 = new JSONObject(r157).optString(ObricMemoryConstants.KEY_SESSION_ID);
        Intrinsics.checkNotNull(r158);
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r158, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L535;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), com.obric.capabilitykit.EntityProvider.TAG, "oauto raw observation skipped, empty sessionId", null, 4, null);
        goto L554
    L535:
        ObservationIngestService.INSTANCE.writeOAuto(System.currentTimeMillis(), r157, r158);
        TaskRequest.Builder r159 = new TaskRequest.Builder("memory_base_build");
        JSONObject r160 = new JSONObject();
        r160.put("trigger_source", "oauto");
        r160.put("session_id", r158);
        Unit r161 = Unit.INSTANCE;
        ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(r159.setInputParam(r160), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setConditions(new Condition[]{Condition.NETWORK_WINDOW}), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExistingTaskPolicy(ExistingTaskPolicy.KEEP_IN_QUEUE), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).enqueue();
        r151 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r152 = false;
        r153 = 4;
        r154 = null;
        r155 = com.obric.capabilitykit.EntityProvider.TAG;
        r156 = "enqueue memory_base_build for oauto raw observation";
        goto L537
    L538:
        r9 = r44;
        r2 = r6;
        r3 = "memory_response";
        r16 = r16;
        if (r9.equals("getComplexRecommendQuery") == false) goto L553;
        if (UserSettings.INSTANCE.hasAgreePrivacy() == true) goto L544;
        r10 = new MemoryResponse(0, null, CollectionsKt.emptyList(), 3, null);
        goto L514
    L544:
        Unit r162 = (Unit) ZeusTransformUtils.preCheckCast(com.obric.memorydata.sdk.d.a(new $$Lambda$EntityProvider$qEgfhvGsuA_ozu424Ph_ksKmp_Y(r46, r2)), Unit.class, "com.obric.memorydata.plugin");
        goto L555
    L545:
        r9 = r44;
        r2 = r6;
        r3 = "memory_response";
        r16 = r16;
        if (r9.equals("sync_delete") == false) goto L553;
        int r163 = r46.getInt(com.obric.capabilitykit.EntityProvider.KEY_ENTITY_TYPE);
        long r164 = r46.getLong("max_last_modified_time");
        RunLog.INSTANCE.debug(com.obric.capabilitykit.EntityProvider.TAG, "delete entities which lastModifiedTime > " + r164 + " for type " + r163);
        EntityManager.INSTANCE.syncDelete(r163, r164, r13);
        goto L554
    L549:
        r9 = r44;
        r2 = r6;
        r3 = "memory_response";
        r16 = r16;
        if (r9.equals("terminateService") == false) goto L553;
        com.obric.memorydata.utils.d.f13204a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        kotlinx.coroutines.i.a(am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new EntityProvider$innerCall$3(null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        r2.putParcelable(r3, (Parcelable) ZeusTransformUtils.preCheckCast(MemoryResponse.CREATOR.a(), Parcelable.class, "com.obric.memorydata.plugin"));
        ApiController.INSTANCE.log(r9, "", MemoryResponse.CREATOR.a());
        goto L554
    L18:
        if (r44.equals("queryUserInsightAndPreference") == false) goto L15;
        JSONObject r165 = new JSONObject(r46.getString(AutoTestConstant.PARAM, ""));     // Catch: Exception -> L35
        boolean r166 = r165.optBoolean("needInsight", true);     // Catch: Exception -> L35
        boolean r167 = r165.optBoolean("needPreference", true);     // Catch: Exception -> L33
        r5 = r165.optBoolean("needPreferenceSummary", true);     // Catch: Exception -> L31
        boolean r168 = r165.optBoolean("awarenessData", true);     // Catch: Exception -> L29
        int r169 = r165.optInt("preferenceLimit", 50);     // Catch: Exception -> L27
    L40:
        JSONObject r170 = new JSONObject();
        if (r166 == false) goto L47;
        iw r171 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getUnionUserInsightDao().getLatest();
        if (r171 == null) goto L45;
        JSONObject r172 = new JSONObject();
        r172.put("summary", r171.b());
        r170.put("insight", r172);
        goto L47
    L45:
        r170.put("insight", new JSONObject());
    L47:
        if (r167 == false) goto L97;
        JSONArray r173 = new JSONArray();
        r170.put("preference", r173);
        if (r5 == false) goto L58;
        Iterator r174 = ((Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getUnionSemanticTypeSummaryDao().getAllExcludeTypeOrderByCount("userinfo"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L52:
        if (r174.hasNext() == false) goto L57;
        Iterator r410 = r174;
        iv r175 = (iv) ZeusTransformUtils.preCheckCast(r174.next(), iv.class, "com.obric.memorydata.plugin");
        JSONObject r176 = new JSONObject();
        String r218 = r11;
        r176.put("type", r175.getType());
        r176.put("treePath", r175.b());
        r176.put("contents", new JSONArray().put(r175.c()));
        if (a(r170, r173, r176) == true) goto L56;
        JSONObject r177 = new JSONObject();
        r177.put("type", r175.getType());
        r177.put("treePath", r175.b());
        r177.put("contents", new JSONArray());
        a(r170, r173, r177);
    L56:
        r174 = r410;
        r11 = r218;
        goto L52
    L57:
        String r219 = r11;
    L98:
        r216 = "memory_response";
    L99:
        if (r168 == false) goto L123;
        JSONObject r178 = new JSONObject();
        Object r179 = FeatureManager.INSTANCE.getFeature("device_active_audio");
        if (ZeusTransformUtils.instanceOf(r179, String.class) == true) goto L569;
    L122:
        r170.put("awarenessData", r178);
        goto L123
    L569:
        List r180 = (List) ZeusTransformUtils.preCheckCast(u.a().fromJson((String) ZeusTransformUtils.preCheckCast(r179, String.class, "com.obric.memorydata.plugin"), new b().getType()), List.class, "com.obric.memorydata.plugin");     // Catch: JsonParseException -> L105 JsonSyntaxException -> L107
    L110:
        if (r180 != null) goto L112;
        r180 = CollectionsKt.emptyList();
    L112:
        Iterator r181 = ((Iterable) ZeusTransformUtils.preCheckCast(r180, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        String r182 = r219;
        int r220 = 0;
    L114:
        if (r181.hasNext() == false) goto L121;
        AudioAppInfo r183 = (AudioAppInfo) ZeusTransformUtils.preCheckCast(r181.next(), AudioAppInfo.class, "com.obric.memorydata.plugin");
        if (r183.getActive() == false) goto L114;
        int r184 = r220 + 1;
        if (r184 <= 1) goto L120;
        r182 = r182 + '\n';
    L120:
        r182 = r182 + r183.getAudioType() + ' ' + r183.getPackageName() + ' ' + a(r183.getOutputType());
        r220 = r184;
        goto L114
    L121:
        r178.put("audio", r182);
        goto L122
    L107:
        e = e;
        IRunLog r221 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r185 = new StringBuilder();
    L109:
        IRunLog.a.b(r221, "GsonExt", r185.append("toListObj error : ").append(e).toString(), null, 4, null);
        r180 = null;
    L105:
        e = e;
        r221 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r185 = new StringBuilder();
    L123:
        Object r186 = r170.opt("preference");
        if (ZeusTransformUtils.instanceOf(r186, JSONArray.class) == false) goto L126;
        JSONArray r187 = (JSONArray) ZeusTransformUtils.preCheckCast(r186, JSONArray.class, "com.obric.memorydata.plugin");
    L127:
        if (r187 == null) goto L130;
        a(r170, r187);
        Unit r188 = Unit.INSTANCE;
        Unit r189 = Unit.INSTANCE;
    L130:
        if (a(r170) == true) goto L137;
        r170.remove("awarenessData");
        Object r190 = r170.opt("preference");
        if (ZeusTransformUtils.instanceOf(r190, JSONArray.class) == false) goto L134;
        JSONArray r191 = (JSONArray) ZeusTransformUtils.preCheckCast(r190, JSONArray.class, "com.obric.memorydata.plugin");
    L135:
        if (r191 == null) goto L137;
        a(r170, r191);
        Unit r192 = Unit.INSTANCE;
        Unit r193 = Unit.INSTANCE;
        goto L137
    L134:
        r191 = null;
    L137:
        r118 = new MemoryResponse(0, null, r170.toString(), 3, null);
        goto L488
    L126:
        r187 = null;
        goto L127
    L58:
        r219 = "";
        Iterable r194 = (Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getSemanticMemoryDao().getAllOrderByUserEditAndModifyTime(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r195 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r196 = r194.iterator();
    L60:
        if (r196.hasNext() == false) goto L65;
        Object r197 = r196.next();
        int r198 = r169;
        Iterator r222 = r196;
        if (Intrinsics.areEqual(((ip) ZeusTransformUtils.preCheckCast(r197, ip.class, "com.obric.memorydata.plugin")).a(), "userinfo") == true) goto L64;
        r195.add(r197);
    L64:
        r169 = r198;
        r196 = r222;
        goto L60
    L65:
        int r199 = r169;
        List r200 = (List) ZeusTransformUtils.preCheckCast(r195, List.class, "com.obric.memorydata.plugin");
        int r201 = r200.size();
        if (r201 <= 0) goto L98;
        int r1100 = 50;
        if (r201 <= 50) goto L70;
        r1100 = r199;
    L70:
        Iterable r202 = (Iterable) ZeusTransformUtils.preCheckCast(r200, Iterable.class, "com.obric.memorydata.plugin");
        Map r203 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r204 = r202.iterator();
    L72:
        if (r204.hasNext() == false) goto L77;
        Object r1101 = r204.next();
        Iterator r411 = r204;
        ip r205 = (ip) ZeusTransformUtils.preCheckCast(r1101, ip.class, "com.obric.memorydata.plugin");
        Bundle r223 = r6;
        String r224 = r12;
        String r206 = r205.a() + '_' + r205.b();
        Object r207 = r203.get(r206);
        if (r207 != null) goto L76;
        r207 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r203.put(r206, r207);
    L76:
        ((List) ZeusTransformUtils.preCheckCast(r207, List.class, "com.obric.memorydata.plugin")).add(r1101);
        r204 = r411;
        r6 = r223;
        r12 = r224;
        goto L72
    L77:
        r6 = r6;
        r216 = r12;
        Iterator r208 = r203.values().iterator();
        int r209 = 0;
    L79:
        if (r208.hasNext() == false) goto L99;
        List r225 = (List) ZeusTransformUtils.preCheckCast(r208.next(), List.class, "com.obric.memorydata.plugin");
        if (r209 >= r1100) goto L99;
        ip r1102 = (ip) ZeusTransformUtils.preCheckCast(CollectionsKt.first(r225), ip.class, "com.obric.memorydata.plugin");
        JSONArray r1103 = new JSONArray();
        Iterator r412 = r208;
        JSONObject r226 = new JSONObject();
        int r1104 = r209;
        r226.put("type", r1102.a());
        r226.put("treePath", r1102.b());
        r226.put("contents", r1103);
        if (a(r170, r173, r226) == false) goto L99;
        Iterator r227 = ((Iterable) ZeusTransformUtils.preCheckCast(r225, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        r209 = r1104;
    L88:
        if (r227.hasNext() == false) goto L95;
        ip r228 = (ip) ZeusTransformUtils.preCheckCast(r227.next(), ip.class, "com.obric.memorydata.plugin");
        if (r209 >= r1100) goto L88;
        r1103.put(r228.c());
        if (a(r170) == true) goto L93;
        r1103.remove(r1103.length() - 1);
        goto L88
    L93:
        r209 = r209 + 1;
        goto L88
    L95:
        r208 = r412;
        goto L79
    L97:
        r219 = "";
    L27:
        e = e;
    L39:
        RunLog.INSTANCE.error(com.obric.capabilitykit.EntityProvider.TAG, "parse param error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        r169 = 50;
    L29:
        e = e;
    L38:
        r168 = false;
    L31:
        e = e;
        r5 = true;
    L33:
        e = e;
    L37:
        r167 = false;
    L35:
        e = e;
        r166 = false;
        goto L37
    }

    private final IStore a() {
        return (IStore) ZeusTransformUtils.preCheckCast(this.f12013b.getValue(), IStore.class, "com.obric.memorydata.plugin");
    }

    private final MemoryResponse<Void> a(String r6) {
        if (Intrinsics.areEqual(r6, "query_support") == true) goto L5;
        com.obric.memorydata.memory.api.a r5 = com.obric.memorydata.memory.api.a.f10058a.a(r6);
        if (r5 == null) goto L9;
        com.obric.memorydata.middleware.database.i r2 = com.obric.memorydata.middleware.database.b.f11646a.a();
        if (r2.c() == true) goto L36;
        if (Intrinsics.areEqual(r2.b(), r5.a()) == false) goto L36;
        if (AppContext.INSTANCE.isLogin() == false) goto L36;
        if (Intrinsics.areEqual(AppContext.INSTANCE.getUserId(), r5.a()) == false) goto L36;
        IStore r3 = StoreManager.INSTANCE.getPersonalStore();
        if (r3 != null) goto L24;
        return new MemoryResponse(400, "personal store not ready", null);
    L24:
        if (AppContext.INSTANCE.isLogin() == false) goto L34;
        if (Intrinsics.areEqual(AppContext.INSTANCE.getUserId(), r5.a()) == false) goto L34;
        if (Intrinsics.areEqual(r3.getString("glasses_environment_timer_settings"), r6) == true) goto L32;
        r3.save("glasses_environment_timer_settings", r6);
    L32:
        return MemoryResponse.CREATOR.a();
    L34:
        return new MemoryResponse(400, "glasses timer account changed", null);
    L36:
        return new MemoryResponse(400, "glasses timer account not ready", null);
    L9:
        return new MemoryResponse(405, "invalid glasses timer settings", null);
    L5:
        return new MemoryResponse(0, "glasses_environment_timer_settings", null);
    }

    private final String a(int r1) {
        if (r1 == 22) goto L8;
        switch(r1) {
            case 1: goto L7;
            case 2: goto L7;
            case 3: goto L8;
            case 4: goto L8;
            case 5: goto L8;
            case 6: goto L8;
            case 7: goto L6;
            case 8: goto L6;
            default: goto L5;
        };
    L5:
        return "未知";
    L6:
        return "蓝牙耳机";
    L7:
        return "扬声器";
    L8:
        return "有线耳机";
    }

    private final String a(List<String> r11) {
        return CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$EntityProvider$MyxzMbYbFtAv7uG9nHqS2BsT7gs.INSTANCE, 30, null);
    }

    private final List<AppEntity> a(Context r3, String r4, String r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r4, "Genesis-R") == true) goto L5;
    L7:
        return null;
    L5:
        if (Intrinsics.areEqual(r5, "com.miui.gallery") == false) goto L7;
        return b(r6, "com.xiaomi.aicr.aitask.availability", "gallery_photo_page_get");
    }

    private static final Unit a(int r7, int r8, Bundle r9) {
        r9.putParcelable("memory_response", (Parcelable) ZeusTransformUtils.preCheckCast(new MemoryResponse(0, null, com.obric.memorydata.personalcontext.search.b.f12278a.a(r7, r8), 3, null), Parcelable.class, "com.obric.memorydata.plugin"));
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), com.obric.capabilitykit.EntityProvider.TAG, "getAppEntityByEntityType success ", false, 4, null);
        return Unit.INSTANCE;
    }

    private static final Unit a(Bundle r26, Bundle r27) {
        int r0 = r26.getInt("limit", 10);
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getComplexRecommendQueryDao().getComplexRecommendQuery(r0), Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        Object r4 = r3.next();
        if (at.a(((aq) ZeusTransformUtils.preCheckCast(r4, aq.class, "com.obric.memorydata.plugin")).a()) == false) goto L4;
        r2.add(r4);
        goto L4
    L8:
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r7 = r5.iterator();
    L10:
        if (r7.hasNext() == false) goto L33;
        aq r8 = (aq) ZeusTransformUtils.preCheckCast(r7.next(), aq.class, "com.obric.memorydata.plugin");
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.removeSurrounding(r8.f(), (CharSequence) ZeusTransformUtils.preCheckCast("[", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("]", CharSequence.class, "com.obric.memorydata.plugin")), CharSequence.class, "com.obric.memorydata.plugin"), new String[]{","}, false, 0, 6, null), Iterable.class, "com.obric.memorydata.plugin");
        Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r11 = r9.iterator();
    L13:
        if (r11.hasNext() == false) goto L15;
        r10.add(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin")).toString());
        goto L13
    L15:
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r14 = r12.iterator();
    L17:
        if (r14.hasNext() == false) goto L24;
        Object r15 = r14.next();
        if (((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r15, String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L21;
        boolean r16 = true;
    L22:
        if (r16 == false) goto L17;
        r13.add(r15);
        goto L17
    L21:
        r16 = false;
        goto L22
    L24:
        List r17 = (List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.memorydata.plugin");
        List r18 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r19 = ((Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L26:
        if (r19.hasNext() == false) goto L32;
        long r110 = Long.parseLong((String) ZeusTransformUtils.preCheckCast(r19.next(), String.class, "com.obric.memorydata.plugin"));
        EpisodicMemoryEntity r111 = (EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getEpisodicMemoryDao().queryById(r110), EpisodicMemoryEntity.class, "com.obric.memorydata.plugin");
        if (r111 == null) goto L26;
        String r112 = r111.getFullContent();
        if (r112 == null) goto L26;
        r18.add(r112);
        goto L26
    L32:
        String r22 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r18, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("[", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("]", CharSequence.class, "com.obric.memorydata.plugin"), 0, null, $$Lambda$EntityProvider$JpIw0WryGTKfKs2J4FLpSOBW1nM.INSTANCE, 24, null);
        r6.add(new RecommendComplexQuery(r8.a(), r8.d(), r22, null, 8, null));
        goto L10
    L33:
        r27.putParcelable("memory_response", (Parcelable) ZeusTransformUtils.preCheckCast(new MemoryResponse(0, null, (List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin"), 3, null), Parcelable.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    private static final Unit a(Bundle r5, Exception r6) {
        Intrinsics.checkNotNullParameter(r6, "it");
        RunLog.INSTANCE.error(com.obric.capabilitykit.EntityProvider.TAG, "getAppEntityListByEntityTypeAndEntityIdList failed", (Throwable) ZeusTransformUtils.preCheckCast(r6, Throwable.class, "com.obric.memorydata.plugin"));
        r5.putParcelable("memory_response", (Parcelable) ZeusTransformUtils.preCheckCast(new MemoryResponse(400, r6.getMessage(), null), Parcelable.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    private static final Unit a(Map r8, Bundle r9) {
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.memorydata.plugin");
        r9.putParcelable("memory_response", (Parcelable) ZeusTransformUtils.preCheckCast(new MemoryResponse(0, null, com.obric.memorydata.personalcontext.search.b.f12278a.a(MapsKt.toMap(r10)), 3, null), Parcelable.class, "com.obric.memorydata.plugin"));
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), com.obric.capabilitykit.EntityProvider.TAG, "getAppEntityListByEntityTypeAndEntityIdList success ", false, 4, null);
        return Unit.INSTANCE;
    }

    private static final void a(String r3, String r4) {
        IProactiveService r0 = (IProactiveService) ZeusTransformUtils.preCheckCast(ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(IProactiveService.class)), IProactiveService.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r3);
        Intrinsics.checkNotNull(r4);
        r0.notifyDoubaoGlassesState(r3, r4);
        return;
    }

    private static final void a(List<String> r3, int r4, Ref.IntRef r5, int r6, Iterable<String> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Iterator r9 = ((Iterable) ZeusTransformUtils.wrapperContextForParams(r7, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r9.hasNext() == false) goto L7;
        if (a(r8, r4, r5, r6, (String) ZeusTransformUtils.preCheckCast(r9.next(), String.class, "com.obric.memorydata.plugin")) == true) goto L4;
        return;
    }

    private final void a(JSONObject r2, JSONArray r3) {
    L3:
        if (a(r2) == true) goto L7;
        if (r3.length() <= 0) goto L10;
        r3.remove(r3.length() - 1);
        goto L3
    L10:
        return;
    }

    private static final boolean a(List<String> r3, int r4, Ref.IntRef r5, int r6, String r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return true;
    L9:
        if (r8.size() < r4) goto L12;
        return false;
    L12:
        if ((r5.element + r7.length()) <= r6) goto L14;
        return false;
    L14:
        r8.add(r7);
        r5.element += r7.length();
        return true;
    L5:
        r0 = false;
        goto L6
    }

    private final boolean a(JSONObject r1) {
        if (r1.toString().length() > 2000) goto L5;
        return true;
    L5:
        return false;
    }

    private final boolean a(JSONObject r1, JSONArray r2, JSONObject r3) {
        r2.put(r3);
        if (a(r1) == false) goto L5;
        return true;
    L5:
        r2.remove(r2.length() - 1);
        return false;
    }

    private static final IStore b() {
        return IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null);
    }

    private final String b(String r1) {
        switch(r1.hashCode()) {
            case -1236583518: goto L21;
            case 2340: goto L17;
            case 92895825: goto L13;
            case 103772132: goto L10;
            case 595233003: goto L6;
            default: goto L24;
        };
    L24:
        return "音频";
    L6:
        if (r1.equals("notification") == false) goto L24;
        return "通知";
    L10:
        if (r1.equals("media") == false) goto L24;
        return "媒体";
    L13:
        if (r1.equals(NotificationCompat.CATEGORY_ALARM) == false) goto L24;
        return "闹钟";
    L17:
        if (r1.equals("IM") == false) goto L24;
        return "即时通信";
    L21:
        if (r1.equals("ringtone") == false) goto L24;
        return "电话响铃";
    }

    private final List<AppEntity> b(Context r11, String r12, String r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        if (e.f12095a.a(301) == true) goto L32;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), com.obric.capabilitykit.EntityProvider.TAG, "queryPhotos return null, local search photo is off", false, 4, null);
        return null;
    L32:
        ProviderInfo r0 = r14.getPackageManager().resolveContentProvider(r12, 131072);     // Catch: RuntimeException -> L8 SecurityException -> L10
    L13:
        if (r0 != null) goto L30;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), com.obric.capabilitykit.EntityProvider.TAG, "queryPhotos: provider " + r12 + " not found", null, 4, null);
        return null;
    L30:
        Bundle r15 = ZeusProviderTransform.call(r14.getContentResolver(), Uri.parse("content://" + r12), r13, null, null, "com.obric.memorydata.plugin");     // Catch: Exception -> L19
    L21:
        if (r15 != null) goto L24;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), com.obric.capabilitykit.EntityProvider.TAG, "queryPhotos failed: bundle is null", null, 4, null);
        return null;
    L24:
        r15.setClassLoader(AppEntity.class.getClassLoader());
        int r16 = r15.getInt("status", -1);
        if (r16 == 0) goto L29;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), com.obric.capabilitykit.EntityProvider.TAG, "queryPhotos failed, status=" + r16 + ", error=" + r15.getString("error", ""), null, 4, null);
        return null;
    L29:
        return c((List) ZeusTransformUtils.preCheckCast(r15.getParcelableArrayList("entities"), List.class, "com.obric.memorydata.plugin"));
    L19:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), com.obric.capabilitykit.EntityProvider.TAG, "queryPhotos failed: error=" + e, null, 4, null);
        r15 = null;
        goto L21
    L10:
        e = move-exception;
        Throwable r1 = (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin");
        String r4 = "queryPhotos failed: No permission to resolve provider";
    L12:
        Log.w(com.obric.capabilitykit.EntityProvider.TAG, r4, r1);
        r0 = null;
    L8:
        e = move-exception;
        r1 = (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin");
        r4 = "queryPhotos failed: not resolve provider";
        goto L12
    }

    private final List<String> b(List<? extends AppEntity> r4) {
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r6 = r3.iterator();
    L4:
        if (r6.hasNext() == false) goto L7;
        r5.add(((AppEntity) ZeusTransformUtils.preCheckCast(r6.next(), AppEntity.class, "com.obric.memorydata.plugin")).getId());
        goto L4
    L7:
        return (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin");
    }

    private static final Unit b(Bundle r5, Exception r6) {
        Intrinsics.checkNotNullParameter(r6, "it");
        RunLog.INSTANCE.error(com.obric.capabilitykit.EntityProvider.TAG, "getAppEntityByEntityType failed", (Throwable) ZeusTransformUtils.preCheckCast(r6, Throwable.class, "com.obric.memorydata.plugin"));
        r5.putParcelable("memory_response", (Parcelable) ZeusTransformUtils.preCheckCast(new MemoryResponse(400, r6.getMessage(), CollectionsKt.emptyList()), Parcelable.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    private static final CharSequence c(String r8) {
        Intrinsics.checkNotNullParameter(r8, Params.CONTENT);
        return (CharSequence) ZeusTransformUtils.preCheckCast(Typography.quote + StringsKt.replace$default(r8, "\"", "\\\"", false, 4, null) + Typography.quote, CharSequence.class, "com.obric.memorydata.plugin");
    }

    private final List<AppEntity> c(List<? extends AppEntity> r25) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r25, List.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        String r5 = null;
        if (r3 == false) goto L12;
        return null;
    L12:
        List<AppEntity> r4 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        EntityIndexEngine r6 = com.obric.memorydata.database.index.s.a();
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Map r7 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r8 = r1.iterator();
    L14:
        if (r8.hasNext() == false) goto L19;
        Object r9 = r8.next();
        Integer r10 = Integer.valueOf(((AppEntity) ZeusTransformUtils.preCheckCast(r9, AppEntity.class, "com.obric.memorydata.plugin")).getType());
        Object r11 = r7.get(r10);
        if (r11 != null) goto L18;
        r11 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r7.put(r10, r11);
    L18:
        ((List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.memorydata.plugin")).add(r9);
        goto L14
    L19:
        Iterator r12 = r7.entrySet().iterator();
    L21:
        if (r12.hasNext() == false) goto L83;
        Map.Entry r13 = (Map.Entry) ZeusTransformUtils.preCheckCast(r12.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        int r14 = ((Number) ZeusTransformUtils.preCheckCast(r13.getKey(), Number.class, "com.obric.memorydata.plugin")).intValue();
        List r15 = (List) ZeusTransformUtils.preCheckCast(r13.getValue(), List.class, "com.obric.memorydata.plugin");
        String r16 = EntityCollectorService.INSTANCE.getPackageNameByEntityType(r14);
        if (r16 != null) goto L28;
        AppEntity r17 = (AppEntity) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r15), AppEntity.class, "com.obric.memorydata.plugin");
        if (r17 == null) goto L27;
        r16 = r17.get_packageName();
        goto L28
    L27:
        r16 = r5;
    L28:
        Set r18 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        Map r19 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        IAppEntityRawDbDao<com.obric.memorydata.database.entity.d> r110 = r6.getRawDaoByEntityType(r14);
        CharSequence r111 = (CharSequence) ZeusTransformUtils.preCheckCast(r16, CharSequence.class, "com.obric.memorydata.plugin");
        if (r111 != null) goto L31;
    L34:
        boolean r112 = true;
    L36:
        if (r112 == true) goto L61;
        if (r110 == null) goto L61;
        Iterable r113 = (Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin");
        Collection r20 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r113, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r114 = r113.iterator();
    L41:
        if (r114.hasNext() == false) goto L43;
        r20.add(((AppEntity) ZeusTransformUtils.preCheckCast(r114.next(), AppEntity.class, "com.obric.memorydata.plugin")).getId());
        goto L41
    L43:
        Iterable r21 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.chunked((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r20, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), 500), Iterable.class, "com.obric.memorydata.plugin");
        Collection r22 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r23 = r21.iterator();
    L45:
        if (r23.hasNext() == false) goto L47;
        CollectionsKt.addAll(r22, (Iterable) ZeusTransformUtils.preCheckCast(r110.queryByEntityIdListAndPackageName((List) ZeusTransformUtils.preCheckCast(r23.next(), List.class, "com.obric.memorydata.plugin"), r16), Iterable.class, "com.obric.memorydata.plugin"));
        goto L45
    L47:
        Iterable r24 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r22, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Map r26 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r24, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r27 = r24.iterator();
    L49:
        if (r27.hasNext() == false) goto L51;
        Object r28 = r27.next();
        r26.put(((com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r28, com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin")).getEntityId(), r28);
        goto L49
    L51:
        Iterator r29 = ((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L53:
        if (r29.hasNext() == false) goto L70;
        AppEntity r30 = (AppEntity) ZeusTransformUtils.preCheckCast(r29.next(), AppEntity.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.database.entity.d r31 = (com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r26.get(r30.getId()), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin");
        if (r31 == null) goto L57;
        AppEntity r32 = r31.convertToAppEntity();
    L58:
        if (r32 != null) goto L59;
        String r33 = r30.getId();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), com.obric.capabilitykit.EntityProvider.TAG, "getCompleteEntities: pc not found, type=" + r14 + ",id=" + r33, null, 4, null);
        r18.add(r33);
        r19.put(r33, r30);
        goto L53
    L59:
        r4.add(r32);
        goto L53
    L57:
        r32 = null;
    L70:
        List<String> r34 = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r18, Iterable.class, "com.obric.memorydata.plugin"));
        Iterable r35 = (Iterable) ZeusTransformUtils.preCheckCast(EntityCollectorService.INSTANCE.getDataAndTriggerIndex(r34, r14), Iterable.class, "com.obric.memorydata.plugin");
        Map r36 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r35, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r37 = r35.iterator();
    L72:
        if (r37.hasNext() == false) goto L74;
        Object r38 = r37.next();
        r36.put(((AppEntity) ZeusTransformUtils.preCheckCast(r38, AppEntity.class, "com.obric.memorydata.plugin")).getId(), r38);
        goto L72
    L74:
        Iterator r39 = ((Iterable) ZeusTransformUtils.preCheckCast(r34, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L76:
        if (r39.hasNext() == false) goto L82;
        String r40 = (String) ZeusTransformUtils.preCheckCast(r39.next(), String.class, "com.obric.memorydata.plugin");
        AppEntity r41 = (AppEntity) ZeusTransformUtils.preCheckCast(r36.get(r40), AppEntity.class, "com.obric.memorydata.plugin");
        if (r41 != null) goto L80;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), com.obric.capabilitykit.EntityProvider.TAG, "getCompleteEntities: local not found, type=" + r14 + ",id=" + r40, null, 4, null);
        r41 = (AppEntity) ZeusTransformUtils.preCheckCast(r19.get(r40), AppEntity.class, "com.obric.memorydata.plugin");
    L80:
        if (r41 == null) goto L76;
        r4.add(r41);
        goto L76
    L82:
        r5 = null;
    L61:
        IRunLog r115 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r42 = new StringBuilder().append("getCompleteEntities: pc not found, type=").append(r14).append(",pkgName=").append(r16).append(",dao==null:");
        if (r110 != null) goto L64;
        boolean r43 = true;
    L65:
        IRunLog.a.a(r115, com.obric.capabilitykit.EntityProvider.TAG, r42.append(r43).toString(), null, 4, null);
        r4.addAll((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.memorydata.plugin"));
        Iterable r44 = (Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin");
        Collection r45 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r44, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r46 = r44.iterator();
    L67:
        if (r46.hasNext() == false) goto L69;
        r45.add(((AppEntity) ZeusTransformUtils.preCheckCast(r46.next(), AppEntity.class, "com.obric.memorydata.plugin")).getId());
        goto L67
    L69:
        r18.addAll((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r45, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin"));
        goto L70
    L64:
        r43 = false;
        goto L65
    L31:
        if (r111.length() == 0) goto L34;
        r112 = false;
        goto L36
    L83:
        return r4;
    L5:
        if (r2.isEmpty() == true) goto L8;
        r3 = false;
        goto L9
    }

    private static final void c() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), com.obric.capabilitykit.EntityProvider.TAG, "preloadAssistantSearchModels execute", false, 4, null);
        com.obric.memorydata.personalcontext.model.a.f12232a.c();
    }

    private static final CharSequence d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin");
    }

    private static final void d() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), com.obric.capabilitykit.EntityProvider.TAG, "cancelUseAssistantSearchModels execute", false, 4, null);
        com.obric.memorydata.personalcontext.model.a.f12232a.d();
    }

    public static /* synthetic */ void lambda$0pZoE2PmrUarrazT58hdC7XW8so() {
        c();
    }

    /* JADX INFO: renamed from: lambda$1cnWTo-GpIFH6HKtT7VP6OhYPWE, reason: not valid java name */
    public static /* synthetic */ void m1048lambda$1cnWToGpIFH6HKtT7VP6OhYPWE(String r0, String r1) {
        a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$7y-GAcFkuI5CuINYZjbC6xp4CTQ, reason: not valid java name */
    public static /* synthetic */ Unit m1049lambda$7yGAcFkuI5CuINYZjbC6xp4CTQ(Bundle r0, Exception r1) {
        return b(r0, r1);
    }

    public static /* synthetic */ CharSequence lambda$JpIw0WryGTKfKs2J4FLpSOBW1nM(String r0) {
        return c(r0);
    }

    public static /* synthetic */ CharSequence lambda$MyxzMbYbFtAv7uG9nHqS2BsT7gs(String r0) {
        return d(r0);
    }

    /* JADX INFO: renamed from: lambda$N8Q0NLRSd0jLb44K-3QMTWmTYzw, reason: not valid java name */
    public static /* synthetic */ Unit m1050lambda$N8Q0NLRSd0jLb44K3QMTWmTYzw(Bundle r0, Exception r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ IStore lambda$Npj0Z9VUUqtG6kYTYSdSsT5I4rI() {
        return b();
    }

    /* JADX INFO: renamed from: lambda$ZiurgT-Eybp7-FmIVoRzV8wuoIs, reason: not valid java name */
    public static /* synthetic */ void m1051lambda$ZiurgTEybp7FmIVoRzV8wuoIs() {
        d();
    }

    public static /* synthetic */ Unit lambda$nGbsDqBNjdhGVa_ApnAUbtgYnhc(Map r0, Bundle r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ Unit lambda$oCO5MjrkygKpqIiVSpxXfjiSNWo(int r0, int r1, Bundle r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$qEgfhvGsuA_ozu424Ph_ksKmp_Y(Bundle r0, Bundle r1) {
        return a(r0, r1);
    }

    public Bundle call(String r11, String r12, Bundle r13) {
        Intrinsics.checkNotNullParameter(r11, "method");
        if (ApiController.INSTANCE.isEnable() == true) goto L8;
        Bundle r10 = new Bundle();
        MemoryResponse r14 = new MemoryResponse(403, "api disabled", null);
    L5:
        r10.putParcelable("memory_response", (Parcelable) ZeusTransformUtils.preCheckCast(r14, Parcelable.class, "com.obric.memorydata.plugin"));
        return r10;
    L8:
        if (ak.f13164a.a() == false) goto L15;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), com.obric.capabilitykit.EntityProvider.TAG, "PermissionCheck is refuse", null, 4, null);
        r10 = new Bundle();
        r14 = new MemoryResponse(402, "no permission", null);
        goto L5
    L15:
        return a(r11, r12, r13);
    L12:
        e = move-exception;
        Ensure.ensureNotReachHere((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        IRunLog r4 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        e.printStackTrace();
        IRunLog.a.b(r4, com.obric.capabilitykit.EntityProvider.TAG, Unit.INSTANCE.toString(), null, 4, null);
        Bundle r15 = new Bundle();
        r15.putParcelable("memory_response", (Parcelable) ZeusTransformUtils.preCheckCast(new MemoryResponse(400, e.getMessage(), null), Parcelable.class, "com.obric.memorydata.plugin"));
        return r15;
    }

    public int delete(Uri r1, String r2, String[] r3) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return 0;
    }

    public String getType(Uri r1) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return null;
    }

    public Uri insert(Uri r1, ContentValues r2) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return null;
    }

    public boolean onCreate() {
        return true;
    }

    public Cursor query(Uri r1, String[] r2, String r3, String[] r4, String r5) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return null;
    }

    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return 0;
    }
}
