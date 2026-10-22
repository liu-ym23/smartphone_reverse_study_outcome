package com.obric.capabilitykit;

import android.app.assist.AssistContent;
import android.content.BroadcastReceiver;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Parcel;
import android.os.UserManager;
import androidx.core.content.ContextCompat;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.google.gson.JsonSyntaxException;
import com.obric.capabilitykit.apphost.AppHost;
import com.obric.capabilitykit.common.UtilsKt;
import com.obric.capabilitykit.entity.EntityContextHolder;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.EntityInitParam;
import com.obric.capabilitykit.entity.IndexProgress;
import com.obric.capabilitykit.entity.ResultCallback;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.EntityClassData;
import com.obric.capabilitykit.entity.app.EntityType;
import com.obric.capabilitykit.entity.memory.MemoryServiceStatus;
import com.obric.capabilitykit.entity.utils.IndexResult;
import com.obric.capabilitykit.logger.Logger;
import com.obric.capabilitykit.sync.EntitySyncDataSupplier;
import com.obric.capabilitykit.sync.EntitySyncUtil;
import com.obric.capabilitykit.version.EntityUpdateVersionParams;
import com.obric.capabilitykit.version.EntityVersionData;
import com.obric.capabilitykit.version.PersonalContextData;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import f06.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import me.ele.lancet.base.annotations.Skip;
import wia.b0;
import wia.e;
import wia.f;
import wia.g;
import wia.h;
import wia.i;
import wia.j;
import wia.k;
import wia.l;
import wia.r;
import wia.v;
import wia.w;
import yia.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000·\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005*\u00011\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002\u008d\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010E\u001a\u00020F2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00040H2\u0006\u0010I\u001a\u00020\u0006H\u0007J(\u0010J\u001a\u00020F2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020L0H2\u0010\b\u0002\u0010M\u001a\n\u0012\u0004\u0012\u00020F\u0018\u00010NH\u0007J-\u0010O\u001a\u00020F2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020L0H2\u0010\b\u0002\u0010M\u001a\n\u0012\u0004\u0012\u00020F\u0018\u00010NH\u0001¢\u0006\u0002\bPJ\b\u0010Q\u001a\u00020FH\u0002J\u0018\u0010R\u001a\u00020F2\u0006\u0010I\u001a\u00020\u00062\u0006\u0010S\u001a\u00020\u0006H\u0002J\u0018\u0010T\u001a\u00020F2\u0006\u0010U\u001a\u00020\u00042\u0006\u0010I\u001a\u00020\u0006H\u0007J\u0006\u0010V\u001a\u00020FJ,\u0010W\u001a\u00020F2\u0006\u0010X\u001a\u00020Y2\u001a\u0010K\u001a\u0016\u0012\u0004\u0012\u00020L\u0018\u00010Zj\n\u0012\u0004\u0012\u00020L\u0018\u0001`[H\u0007J\u001c\u0010\\\u001a\b\u0012\u0004\u0012\u00020L0H2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020L0HH\u0002J\u001e\u0010]\u001a\u00020F2\u0006\u0010I\u001a\u00020\u00062\f\u0010M\u001a\b\u0012\u0004\u0012\u00020^0NH\u0007J\u0012\u0010_\u001a\u0004\u0018\u00010^2\u0006\u0010I\u001a\u00020\u0006H\u0003J \u0010`\u001a\n\u0012\u0004\u0012\u00020L\u0018\u00010H2\u0006\u0010a\u001a\u00020\u00042\u0006\u0010b\u001a\u00020\u0004H\u0007J\"\u0010c\u001a\u00020F2\u0006\u0010d\u001a\u00020L2\u0010\b\u0002\u0010M\u001a\n\u0012\u0004\u0012\u00020F\u0018\u00010NH\u0007J\u0015\u0010e\u001a\u00020F2\u0006\u0010f\u001a\u00020gH\u0000¢\u0006\u0002\bhJ\u001e\u0010i\u001a\u00020F2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00040H2\u0006\u0010I\u001a\u00020\u0006H\u0002J(\u0010j\u001a\u00020k2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020L0H2\u0010\b\u0002\u0010M\u001a\n\u0012\u0004\u0012\u00020F\u0018\u00010NH\u0002J0\u0010l\u001a\u0004\u0018\u00010m2\u0006\u0010n\u001a\u00020\t2\u0006\u0010o\u001a\u00020\u00042\b\u0010p\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010q\u001a\u0004\u0018\u00010mH\u0002J\b\u0010r\u001a\u00020<H\u0002J\u0010\u0010s\u001a\u00020<2\u0006\u0010I\u001a\u00020\u0006H\u0007J\b\u0010t\u001a\u00020<H\u0002J\u000f\u0010u\u001a\u0004\u0018\u00010mH\u0000¢\u0006\u0002\bvJ\u0017\u0010w\u001a\u00020<2\b\u0010x\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0002\byJ\r\u0010z\u001a\u00020FH\u0000¢\u0006\u0002\b{J\"\u0010|\u001a\u00020F2\b\u0010}\u001a\u0004\u0018\u00010m2\u0006\u0010I\u001a\u00020\u00062\u0006\u0010~\u001a\u00020\u007fH\u0002J!\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020L0H2\u0007\u0010\u0081\u0001\u001a\u0002042\u0007\u0010\u0082\u0001\u001a\u00020\u0004H\u0002J\u0016\u0010\u0083\u0001\u001a\u00020F2\r\u0010\u0084\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060HJ\u001a\u0010\u0085\u0001\u001a\u00020F2\u0006\u0010I\u001a\u00020\u00062\u0007\u0010\u0086\u0001\u001a\u00020\u000eH\u0002J\u0019\u0010\u0087\u0001\u001a\u00020F2\u000e\u0010\u0088\u0001\u001a\t\u0012\u0005\u0012\u00030\u0089\u00010HH\u0002J \u0010\u0087\u0001\u001a\u00020F2\r\u0010\u008a\u0001\u001a\b\u0012\u0004\u0012\u00020L0H2\u0006\u0010~\u001a\u00020\u007fH\u0002J'\u0010\u0087\u0001\u001a\u00020F2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00040H2\u0006\u0010I\u001a\u00020\u00062\u0006\u0010~\u001a\u00020\u007fH\u0002J\u0010\u0010\u008b\u0001\u001a\u00020F2\u0007\u0010\u008c\u0001\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001b\u0010*\u001a\u00020+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b,\u0010-R\u0012\u00100\u001a\u0002018\u0002X\u0083\u0004¢\u0006\u0004\n\u0002\u00102R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010=\u001a\u00020<2\u0006\u0010;\u001a\u00020<@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u001e\u0010?\u001a\u00020@8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010D¨\u0006\u008e\u0001"}, d2 = {"Lcom/obric/capabilitykit/EntityProvider;", "", "()V", "ENTITY_FIRST_FLAG", "", "ENTITY_LIST_CHUNK_SIZE", "", "ENTITY_REPO", "ENTITY_URI", "Landroid/net/Uri;", "kotlin.jvm.PlatformType", "getENTITY_URI$capabilitykit_release", "()Landroid/net/Uri;", "INIT_TASK_DELAY_TIME", "", "INSERT_ENTITY_RETRY_TIMES", "KEY_APP_ENTITY_COUNT", "KEY_CLEAN_BEFORE_TIMESTAMP", "KEY_ENTITY_IDS", "KEY_ENTITY_LIST", "KEY_ENTITY_TYPE", "KEY_ERROR_CODE", "KEY_ERROR_MSG", "KEY_INDEX_PROGRESS", "KEY_IS_DONATE_ALLOWED", "KEY_MAX_LAST_MODIFIED_TIME", "KEY_ON_SCREEN_ENTITIES", "KEY_PKG_NAME", "KEY_PRODUCT_NAME", "KEY_SUCCESS_IDS", "MAX_TRANSACTION_SIZE_BYTES", "METHOD_CHECK_SYNCED_DATA", "METHOD_DATA_CLEAN", "METHOD_DELETE", "METHOD_FETCH_SYNC_INFO", "METHOD_GET_ENTITY_INDEX_PROGRESS", "METHOD_GET_ON_SCREEN_ENTITIES", "METHOD_INDEX", "METHOD_IS_DONATE_ALLOWED_BY_LOCAL_SWITCH", "METHOD_QUERY_PERSONAL_CONTEXT_DATA", "METHOD_SYNC_DELETE", "TAG", "dbHelper", "Lcom/obric/capabilitykit/entity/EntityDBHelper;", "getDbHelper", "()Lcom/obric/capabilitykit/entity/EntityDBHelper;", "dbHelper$delegate", "Lkotlin/Lazy;", "deviceUnlockedReceiver", "com/obric/capabilitykit/EntityProvider$deviceUnlockedReceiver$1", "Lcom/obric/capabilitykit/EntityProvider$deviceUnlockedReceiver$1;", "entitySupplier", "Lcom/obric/capabilitykit/EntitySupplier;", "entitySyncDataSupplier", "Lcom/obric/capabilitykit/sync/EntitySyncDataSupplier;", "featureRunProcessName", "firstRunCleanBeforeTimestamp", "initialCountDownLatch", "Ljava/util/concurrent/CountDownLatch;", "<set-?>", "", "isInitialized", "()Z", "sContext", "Landroid/content/Context;", "getSContext", "()Landroid/content/Context;", "setSContext", "(Landroid/content/Context;)V", "bulkDelete", "", "entityIds", "", "entityType", "bulkIndex", "entities", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "callback", "Lcom/obric/capabilitykit/entity/ResultCallback;", "bulkIndexInner", "bulkIndexInner$capabilitykit_release", "checkIfFirstRunOrDataClean", "checkSyncedData", "entityCount", EntityProvider.METHOD_DELETE, "entityId", "deleteAllEntityData", "donateOnScreenData", "outContent", "Landroid/app/assist/AssistContent;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "filterLastUniqueEntities", "getIndexProgress", "Lcom/obric/capabilitykit/entity/IndexProgress;", "getIndexProgressInternal", "getOnScreenData", "productName", "pkgName", EntityProvider.METHOD_INDEX, "entity", "init", "entityInitParam", "Lcom/obric/capabilitykit/entity/EntityInitParam;", "init$capabilitykit_release", "innerBulkDelete", "innerBulkIndex", "Lcom/obric/capabilitykit/entity/utils/IndexResult;", "innerCall", "Landroid/os/Bundle;", "uri", "method", "arg", DBDefinition.EXTRA, "isCredentialProtectionLocked", "isDonateAllowed", "isNotInFeatureProcess", "queryPersonalContextData", "queryPersonalContextData$capabilitykit_release", "reDonateCheck", "paramString", "reDonateCheck$capabilitykit_release", "reindexEntityData", "reindexEntityData$capabilitykit_release", "removeProcessedEntityFromDB", "result", "action", "Lcom/obric/capabilitykit/entity/ActionType;", "safeProvideAllEntities", "supplier", "source", "syncData", "indexedEntityTypes", "syncDelete", "lastModifiedTime", "tryInsertBulkEntityHistory", "entityDaoList", "Lcom/obric/capabilitykit/entity/EntityHistoryDao;", "entityList", "waitEntityProviderInit", "timeOutMs", "EntitySyncBackedSupplier", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EntityProvider {
    private static final String ENTITY_FIRST_FLAG = "first_run_flag";
    private static final int ENTITY_LIST_CHUNK_SIZE = 100;
    private static final String ENTITY_REPO = "entity_repo";
    private static final Uri ENTITY_URI = null;
    private static final long INIT_TASK_DELAY_TIME = 10000;
    private static final int INSERT_ENTITY_RETRY_TIMES = 3;
    public static final EntityProvider INSTANCE = null;
    private static final String KEY_APP_ENTITY_COUNT = "app_entity_count";
    public static final String KEY_CLEAN_BEFORE_TIMESTAMP = "clean_before_timestamp";
    public static final String KEY_ENTITY_IDS = "entity_ids";
    public static final String KEY_ENTITY_LIST = "entity_list";
    public static final String KEY_ENTITY_TYPE = "entity_type";
    private static final String KEY_ERROR_CODE = "error_code";
    private static final String KEY_ERROR_MSG = "error_msg";
    private static final String KEY_INDEX_PROGRESS = "index_progress";
    private static final String KEY_IS_DONATE_ALLOWED = "is_donate_allowed";
    private static final String KEY_MAX_LAST_MODIFIED_TIME = "max_last_modified_time";
    private static final String KEY_ON_SCREEN_ENTITIES = "on_screen_entities";
    private static final String KEY_PKG_NAME = "pkg_name";
    private static final String KEY_PRODUCT_NAME = "product_name";
    public static final String KEY_SUCCESS_IDS = "success_ids";
    private static final int MAX_TRANSACTION_SIZE_BYTES = 921600;
    private static final String METHOD_CHECK_SYNCED_DATA = "check_synced_data";
    private static final String METHOD_DATA_CLEAN = "data_clean";
    private static final String METHOD_DELETE = "delete";
    private static final String METHOD_FETCH_SYNC_INFO = "fetch_sync_info";
    private static final String METHOD_GET_ENTITY_INDEX_PROGRESS = "get_entity_index_progress";
    private static final String METHOD_GET_ON_SCREEN_ENTITIES = "get_on_screen_entities";
    private static final String METHOD_INDEX = "index";
    private static final String METHOD_IS_DONATE_ALLOWED_BY_LOCAL_SWITCH = "is_donate_allowed_by_local_switch";
    private static final String METHOD_QUERY_PERSONAL_CONTEXT_DATA = "query_personal_context_data";
    private static final String METHOD_SYNC_DELETE = "sync_delete";
    public static final String TAG = "EntityProvider";
    private static final Lazy dbHelper$delegate = null;
    private static final EntityProvider$deviceUnlockedReceiver$1 deviceUnlockedReceiver = null;
    private static EntitySupplier entitySupplier;
    private static EntitySyncDataSupplier entitySyncDataSupplier;
    private static String featureRunProcessName;
    private static long firstRunCleanBeforeTimestamp;
    private static CountDownLatch initialCountDownLatch;
    private static volatile boolean isInitialized;
    public static Context sContext;

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/obric/capabilitykit/entity/EntityDBHelper;", "invoke", "()Lcom/obric/capabilitykit/entity/EntityDBHelper;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class b extends Lambda implements Function0<v> {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
            super(0);
        }

        public final v a() {
            return v.b.a(EntityProvider.INSTANCE.getSContext());
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            return a();
        }
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.obric.capabilitykit.EntityProvider$deviceUnlockedReceiver$1] */
    static {
        INSTANCE = new EntityProvider();
        ENTITY_URI = UriProtector.parse("content://com.obric.memorydata.personalcontext.EntityProvider");
        dbHelper$delegate = LazyKt.lazy(b.a);
        initialCountDownLatch = new CountDownLatch(1);
        deviceUnlockedReceiver = new EntityProvider$deviceUnlockedReceiver$1();
    }

    private EntityProvider() {
    }

    public static /* synthetic */ void a() {
        deleteAllEntityData$lambda$16();
    }

    public static final /* synthetic */ void access$checkIfFirstRunOrDataClean(EntityProvider r0) {
        r0.checkIfFirstRunOrDataClean();
    }

    public static final /* synthetic */ Bundle access$innerCall(EntityProvider r0, Uri r1, String r2, String r3, Bundle r4) {
        return r0.innerCall(r1, r2, r3, r4);
    }

    public static /* synthetic */ void b(CountDownLatch r0, Set r1) {
        reDonateCheck$lambda$46(r0, r1);
    }

    private static final void bulkDelete$lambda$15(List r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "$entityIds");
        Iterator r0 = r3.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        String r1 = (String) r0.next();
        INSTANCE.getDbHelper().b(r1, r4);
        goto L4
    L6:
        EntityProvider r2 = INSTANCE;
        r2.tryInsertBulkEntityHistory(r3, r4, m.d);
        r2.innerBulkDelete(r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void bulkIndex$default(EntityProvider r0, List r1, ResultCallback r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.bulkIndex(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void bulkIndexInner$capabilitykit_release$default(EntityProvider r0, List r1, ResultCallback r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.bulkIndexInner$capabilitykit_release(r1, r2);
    }

    public static /* synthetic */ void c(List r0, int r1) {
        bulkDelete$lambda$15(r0, r1);
    }

    private final void checkSyncedData(int r3, int r4) {
        Bundle r0 = new Bundle();
        r0.putInt(KEY_ENTITY_TYPE, r3);
        r0.putInt(KEY_APP_ENTITY_COUNT, r4);
        innerCall(ENTITY_URI, METHOD_CHECK_SYNCED_DATA, null, r0);
    }

    public static /* synthetic */ void d(List r0, ResultCallback r1) {
        bulkIndexInner$lambda$13(r0, r1);
    }

    private static final void deleteAllEntityData$lambda$16() {
        innerCall$default(INSTANCE, ENTITY_URI, METHOD_DATA_CLEAN, null, null, 8, null);
    }

    public static /* synthetic */ void e(List r0, CountDownLatch r1) {
        syncData$lambda$47(r0, r1);
    }

    public static /* synthetic */ void f() {
        init$lambda$2();
    }

    private final List<AppEntity> filterLastUniqueEntities(List<? extends AppEntity> r5) {
        LinkedHashSet r0 = new LinkedHashSet();
        ArrayList r1 = new ArrayList();
        Iterator r6 = CollectionsKt.asReversed(r5).iterator();
    L4:
        if (r6.hasNext() == false) goto L9;
        AppEntity r2 = (AppEntity) r6.next();
        if (r0.contains(r2.getId()) == true) goto L4;
        r1.add(r2);
        r0.add(r2.getId());
        goto L4
    L9:
        return CollectionsKt.asReversedMutable(r1);
    }

    public static /* synthetic */ void g(int r0, ResultCallback r1) {
        getIndexProgress$lambda$5(r0, r1);
    }

    private final v getDbHelper() {
        return (v) dbHelper$delegate.getValue();
    }

    private static final void getIndexProgress$lambda$5(int r7, ResultCallback r8) {
        Intrinsics.checkNotNullParameter(r8, "$callback");
        IndexProgress r9 = INSTANCE.getIndexProgressInternal(r7);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new c(r9, r8, null), 3, null);
    }

    private final IndexProgress getIndexProgressInternal(int r4) {
        Bundle r0 = new Bundle();
        r0.putInt(KEY_ENTITY_TYPE, r4);
        Object r2 = null;
        Bundle r5 = innerCall(ENTITY_URI, METHOD_GET_ENTITY_INDEX_PROGRESS, null, r0);
        if (r5 == null) goto L14;
        String r6 = r5.getString(KEY_INDEX_PROGRESS);
        if (r6 != null) goto L7;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == true) goto L14;
        r2 = GsonProtectorUtils.fromJson(UtilsKt.a(), r6, IndexProgress.class);
        goto L14
    L7:
        if (r6.length() == 0) goto L10;
        r1 = false;
    L14:
        return (IndexProgress) r2;
    }

    public static /* synthetic */ void h(CountDownLatch r0) {
        reindexEntityData$lambda$49(r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void index$default(EntityProvider r0, AppEntity r1, ResultCallback r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.index(r1, r2);
    }

    private static final void init$lambda$2() {
        INSTANCE.checkIfFirstRunOrDataClean();
    }

    private final void innerBulkDelete(List<String> r8, int r9) {
        if (isCredentialProtectionLocked() == false) goto L6;
        Logger.INSTANCE.w(TAG, "device is locked, delete entity will retry when user unlocked device");
        return;
    L6:
        Iterator r0 = CollectionsKt.chunked(r8, 100).iterator();
    L8:
        if (r0.hasNext() == false) goto L14;
        List r2 = (List) r0.next();
        Logger.INSTANCE.i(TAG, "innerBulkDelete ids: " + q.b(r8));
        Bundle r3 = new Bundle();
        Object[] r4 = r2.toArray(new String[0]);
        if (r4 == null) goto L13;
        r3.putStringArray(KEY_ENTITY_IDS, (String[]) r4);
        r3.putInt(KEY_ENTITY_TYPE, r9);
        EntityProvider r5 = INSTANCE;
        r5.removeProcessedEntityFromDB(r5.innerCall(ENTITY_URI, METHOD_DELETE, null, r3), r9, m.d);
        goto L8
    L13:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IndexResult innerBulkIndex$default(EntityProvider r0, List r1, ResultCallback r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return r0.innerBulkIndex(r1, r2);
    }

    private final Bundle innerCall(Uri r9, String r10, String r11, Bundle r12) {
        int r6 = a.a;     // Catch: Exception -> L25
        if (a.a(getSContext()) == MemoryServiceStatus.AVAILABLE) goto L7;
        Logger.INSTANCE.w(TAG, "EntityProvider is not available, skip call " + r10);     // Catch: Exception -> L25
        return null;
    L7:
        ContentProviderClient r13 = com_obric_capabilitykit_EntityProvider_android_content_ContentResolver_acquireUnstableContentProviderClient(getSContext().getContentResolver(), r9);     // Catch: Exception -> L25
        if (r13 != null) goto L30;
        Logger.INSTANCE.w(TAG, "failed to acquire unstable provider client, skip call " + r10);     // Catch: Exception -> L25
        return null;
    L30:
        Bundle r14 = r13.call(r10, r11, r12);     // Catch: Throwable -> L13 Exception -> L15 DeadObjectException -> L17
    L21:
        r13.close();     // Catch: Exception -> L25
        return r14;
    L17:
        e = e;
        Logger r15 = Logger.INSTANCE;     // Catch: Throwable -> L13
        String r16 = "unstable provider died during call " + r10;     // Catch: Throwable -> L13
    L19:
        r15.e(TAG, r16, e);     // Catch: Throwable -> L13
        r14 = null;
    L15:
        e = e;
        r15 = Logger.INSTANCE;     // Catch: Throwable -> L13
        r16 = "provider call failed " + r10;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        r13.close();     // Catch: Exception -> L25
        throw th;     // Catch: Exception -> L25
    L25:
        e = move-exception;
        Logger.INSTANCE.e(TAG, ExceptionsKt.stackTraceToString(e));
        return null;
    }

    public static /* synthetic */ Bundle innerCall$default(EntityProvider r0, Uri r1, String r2, String r3, Bundle r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L6;
        r4 = new Bundle();
    L6:
        return r0.innerCall(r1, r2, r3, r4);
    }

    private final boolean isCredentialProtectionLocked() {
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        return false;
    L5:
        return !((UserManager) getSContext().getSystemService(UserManager.class)).isUserUnlocked();
    }

    private static final void reDonateCheck$lambda$46(CountDownLatch r6, Set r7) {
        Intrinsics.checkNotNullParameter(r6, "$finishDonateCountDownLatch");
        Intrinsics.checkNotNullParameter(r7, "$needDonateVersions");
        EntitySupplier r0 = entitySupplier;
        if (r0 == null) goto L5;
        List<AppEntity> r1 = INSTANCE.safeProvideAllEntities(r0, "reDonateCheck");
    L6:
        if (r1 != null) goto L9;
        r6.countDown();
        return;
    L9:
        LinkedHashMap r2 = new LinkedHashMap();
        Iterator<T> r3 = r1.iterator();
    L11:
        if (r3.hasNext() == false) goto L16;
        Object r4 = r3.next();
        Integer r5 = Integer.valueOf(((AppEntity) r4).getType());
        Object r8 = r2.get(r5);
        if (r8 != null) goto L15;
        r8 = new ArrayList();
        r2.put(r5, r8);
    L15:
        ((List) r8).add(r4);
        goto L11
    L16:
        Iterator r9 = r2.entrySet().iterator();
    L18:
        if (r9.hasNext() == false) goto L22;
        Map.Entry r10 = (Map.Entry) r9.next();
        if (r7.contains(r10.getKey()) == false) goto L18;
        Logger.INSTANCE.i(TAG, "reDonateCheck, reDonate type: " + ((Number) r10.getKey()).intValue());
        bulkIndexInner$capabilitykit_release$default(INSTANCE, (List) r10.getValue(), null, 2, null);
        goto L18
    L22:
        r6.countDown();
        return;
    L5:
        r1 = null;
        goto L6
    }

    private static final void reindexEntityData$lambda$49(CountDownLatch r4) {
        Intrinsics.checkNotNullParameter(r4, "$finishDonateCountDownLatch");
        EntitySupplier r0 = entitySupplier;     // Catch: Throwable -> L7 Exception -> L9
        if (r0 == null) goto L6;
        EntityProvider r1 = INSTANCE;     // Catch: Throwable -> L7 Exception -> L9
        bulkIndex$default(r1, r1.safeProvideAllEntities(r0, "reindexEntityData"), null, 2, null);     // Catch: Throwable -> L7 Exception -> L9
    L6:
        r4.countDown();
        return;
    L9:
        e = move-exception;
        Logger.INSTANCE.e(TAG, "reindexEntityDataInner error", e);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        r4.countDown();
        throw th;
    }

    private final List<AppEntity> safeProvideAllEntities(EntitySupplier r3, String r4) {
        return r3.provideAllEntities();
    L4:
        th = move-exception;
        Logger.INSTANCE.e(TAG, r4 + " provideAllEntities failed, return partial result", th);
        return CollectionsKt.emptyList();
    }

    private static final void syncData$lambda$47(List r7, CountDownLatch r8) {
        Intrinsics.checkNotNullParameter(r7, "$indexedEntityTypes");
        Intrinsics.checkNotNullParameter(r8, "$finishSyncDataCountDownLatch");
        EntitySyncUtil.INSTANCE.syncData(entitySyncDataSupplier, entitySupplier, r7, null, d.a);     // Catch: Throwable -> L5
    L7:
        r8.countDown();
        return;
    L5:
        th = move-exception;
        Logger.INSTANCE.e(TAG, "syncData error", th);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        r8.countDown();
        throw th;
    }

    private final void syncDelete(int r4, long r5) {
        Logger.INSTANCE.d(TAG, "to delete entities which lastModifiedTime > " + r5 + " for type " + r4);
        Bundle r0 = new Bundle();
        r0.putInt(KEY_ENTITY_TYPE, r4);
        r0.putLong(KEY_MAX_LAST_MODIFIED_TIME, r5);
        innerCall(ENTITY_URI, METHOD_SYNC_DELETE, null, r0);
    }

    private final void tryInsertBulkEntityHistory(List<String> r5, int r6, m r7) {
        ArrayList r0 = new ArrayList();
        Iterator<T> r8 = r5.iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        r0.add(new w((String) r8.next(), "", r6, r7));
        goto L4
    L6:
        tryInsertBulkEntityHistory(r0);
    }

    private final void tryInsertBulkEntityHistory(List<? extends AppEntity> r6, m r7) {
        ArrayList r0 = new ArrayList();
        Iterator<T> r8 = r6.iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        AppEntity r1 = (AppEntity) r8.next();
        r0.add(new w(r1.getId(), EntityExtKt.toJsonKeepTimeStamp(r1), r1.getType(), r7));
        goto L4
    L6:
        tryInsertBulkEntityHistory(r0);
    }

    public final void bulkDelete(List<String> r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "entityIds");
        int r0 = a.a;
        if (a.a(getSContext()) == MemoryServiceStatus.AVAILABLE) goto L7;
        Logger.INSTANCE.w(TAG, "EntityProvider is not available, skip delete");
        return;
    L7:
        if (r4.isEmpty() == false) goto L9;
        return;
    L9:
        IndexTaskManager.INSTANCE.runTask("bulkDelete(size:" + r4.size() + ')', new g(r4, r5));
    }

    public final void delete(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "entityId");
        bulkDelete(CollectionsKt.listOf(r2), r3);
    }

    public final void deleteAllEntityData() {
        int r0 = a.a;
        if (a.a(getSContext()) == MemoryServiceStatus.AVAILABLE) goto L6;
        Logger.INSTANCE.w(TAG, "EntityProvider is not available, skip deleteAllEntityData");
        return;
    L6:
        IndexTaskManager.INSTANCE.runTask("deleteAllEntityData", new k());
    }

    public final void donateOnScreenData(AssistContent r9, ArrayList<AppEntity> r10) {
        Intrinsics.checkNotNullParameter(r9, "outContent");
        int r0 = a.a;
        if (a.a(getSContext()) == MemoryServiceStatus.AVAILABLE) goto L6;
        Logger.INSTANCE.w(TAG, "EntityProvider is not available, skip donateOnScreenData");
        return;
    L6:
        Logger r1 = Logger.INSTANCE;
        StringBuilder r2 = new StringBuilder("donateOnScreenData entity list: ");
        if (r10 == null) goto L12;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator<T> r4 = r10.iterator();
    L10:
        if (r4.hasNext() == false) goto L13;
        AppEntity r5 = (AppEntity) r4.next();
        r3.add(r5.getId() + " - " + r5.getType());
    L13:
        r2.append(r3);
        r1.d(TAG, r2.toString());
        if (r10 != null) goto L16;
        return;
    L16:
        r9.getExtras().putParcelableArrayList("entities", r10);
        return;
    L12:
        r3 = null;
        goto L13
    }

    public final Uri getENTITY_URI$capabilitykit_release() {
        return ENTITY_URI;
    }

    public final List<AppEntity> getOnScreenData(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "productName");
        Intrinsics.checkNotNullParameter(r4, "pkgName");
        Bundle r0 = new Bundle();
        r0.putString(KEY_PRODUCT_NAME, r3);
        r0.putString(KEY_PKG_NAME, r4);
        Bundle r5 = innerCall(ENTITY_URI, METHOD_GET_ON_SCREEN_ENTITIES, null, r0);
        if (r5 == null) goto L6;
        r5.setClassLoader(AppEntity.class.getClassLoader());
        return r5.getParcelableArrayList(KEY_ON_SCREEN_ENTITIES);
    L6:
        return null;
    }

    public final Context getSContext() {
        Context r0 = sContext;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("sContext");
        return null;
    }

    public final void index(AppEntity r2, ResultCallback<Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "entity");
        bulkIndex(CollectionsKt.listOf(r2), r3);
    }

    public final synchronized void init$capabilitykit_release(EntityInitParam r9) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r9, "entityInitParam");     // Catch: Throwable -> L56
        if (isInitialized == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        setSContext(AppHost.Companion.getApplication().getApplicationContext());     // Catch: Throwable -> L56
        String r2 = r9.getRunProcessName();     // Catch: Throwable -> L56
        boolean r3 = false;
        a r4 = null;
        if (r2 != null) goto L11;
        r2 = null;
    L14:
        featureRunProcessName = r2;     // Catch: Throwable -> L56
        firstRunCleanBeforeTimestamp = System.currentTimeMillis();     // Catch: Throwable -> L56
        String r5 = featureRunProcessName;     // Catch: Throwable -> L56
        if (r5 != null) goto L17;
    L22:
        boolean r6 = false;
    L23:
        if (r6 == false) goto L25;
        featureRunProcessName = null;     // Catch: Throwable -> L56
    L25:
        Logger r7 = Logger.INSTANCE;     // Catch: Throwable -> L56
        StringBuilder r8 = new StringBuilder("init, supplier==null:");     // Catch: Throwable -> L56
        if (r9.getSupplier() != null) goto L28;
        boolean r1 = true;
    L29:
        r8.append(r1);     // Catch: Throwable -> L56
        r8.append(", syncSupplier==null:");     // Catch: Throwable -> L56
        if (r9.getEntitySyncDataSupplier() != null) goto L32;
        r3 = true;
    L32:
        r8.append(r3);     // Catch: Throwable -> L56
        r7.i(TAG, r8.toString());     // Catch: Throwable -> L56
        entitySyncDataSupplier = r9.getEntitySyncDataSupplier();     // Catch: Throwable -> L56
        a r10 = r9.getSupplier();     // Catch: Throwable -> L56
        if (r10 != null) goto L37;
        EntitySyncDataSupplier r11 = entitySyncDataSupplier;     // Catch: Throwable -> L56
        if (r11 == null) goto L38;
        r7.i(TAG, "init with entitySyncDataSupplier-backed entitySupplier");     // Catch: Throwable -> L56
        r4 = new a(r11);     // Catch: Throwable -> L56
    L38:
        entitySupplier = r4;     // Catch: Throwable -> L56
        EntityContextHolder.INSTANCE.init(getSContext());     // Catch: Throwable -> L56
        isInitialized = true;     // Catch: Throwable -> L56
        initialCountDownLatch.countDown();     // Catch: Throwable -> L56
        if (isNotInFeatureProcess() == false) goto L47;
        StringBuilder r12 = new StringBuilder("initTask, featureProcess: ");     // Catch: Throwable -> L56
        String r0 = featureRunProcessName;     // Catch: Throwable -> L56
        if (r0 != null) goto L43;
        r0 = "MainProcess";
    L43:
        r12.append(r0);     // Catch: Throwable -> L56
        r12.append(", currentProcess: ");     // Catch: Throwable -> L56
        String r13 = r.a;     // Catch: Throwable -> L56
        r12.append(r.a(getSContext()));     // Catch: Throwable -> L56
        r7.w(TAG, r12.toString());     // Catch: Throwable -> L56
        monitor-exit(this);
        return;
    L47:
        if (entitySupplier != null) goto L51;
        monitor-exit(this);
        return;
    L51:
        if (isCredentialProtectionLocked() == false) goto L53;
        r7.d(TAG, "device locked, wait user unlock");     // Catch: Throwable -> L56
        INVOKEVIRTUAL_com_obric_capabilitykit_EntityProvider_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(getSContext(), deviceUnlockedReceiver, new IntentFilter("android.intent.action.USER_UNLOCKED"));     // Catch: Throwable -> L56
    L54:
        monitor-exit(this);
        return;
    L53:
        IndexTaskManager.INSTANCE.postTaskDelay(INIT_TASK_DELAY_TIME, "checkIfFirstRunOrDataClean", new j());     // Catch: Throwable -> L56
        goto L54
    L37:
        r4 = r10;
        goto L38
    L28:
        r1 = false;
        goto L29
    L17:
        if (r5.length() != 0) goto L19;
        boolean r14 = true;
    L20:
        if (r14 != true) goto L22;
        r6 = true;
        goto L23
    L19:
        r14 = false;
        goto L20
    L11:
        if (StringsKt.startsWith$default(r2, ":", false, 2, null) == false) goto L14;
        r2 = INSTANCE.getSContext().getPackageName() + r2;     // Catch: Throwable -> L56
    L56:
        th = move-exception;
        throw th;
    }

    public final boolean isDonateAllowed(int r6) {
        Bundle r0 = new Bundle();
        r0.putInt(KEY_ENTITY_TYPE, r6);
        Boolean r3 = null;
        Bundle r1 = innerCall(ENTITY_URI, METHOD_IS_DONATE_ALLOWED_BY_LOCAL_SWITCH, null, r0);
        if (r1 == null) goto L5;
        r1.setClassLoader(AppEntity.class.getClassLoader());
    L7:
        if (r1 == null) goto L9;
        r3 = Boolean.valueOf(r1.getBoolean(KEY_IS_DONATE_ALLOWED, false));
    L9:
        Logger.INSTANCE.i(TAG, "isDonateAllowed:type=" + r6 + ",value=" + r3);
        if (r3 != null) goto L12;
        return false;
    L12:
        return r3.booleanValue();
    L5:
        r1 = null;
        goto L7
    }

    public final boolean isInitialized() {
        return isInitialized;
    }

    public final Bundle queryPersonalContextData$capabilitykit_release() {
        return innerCall$default(this, ENTITY_URI, METHOD_QUERY_PERSONAL_CONTEXT_DATA, null, null, 8, null);
    }

    public final boolean reDonateCheck$capabilitykit_release(String r10) {
        int r0 = a.a;
        if (a.a(getSContext()) == MemoryServiceStatus.AVAILABLE) goto L6;
        Logger.INSTANCE.i(TAG, "EntityProvider is not available, skip reDonateCheck");
        return false;
    L6:
        if (r10 != null) goto L29;
        return false;
    L29:
        EntityUpdateVersionParams r1 = (EntityUpdateVersionParams) GsonProtectorUtils.fromJson(UtilsKt.a(), r10, EntityUpdateVersionParams.class);     // Catch: JsonSyntaxException -> L26
        LinkedHashSet r11 = new LinkedHashSet();
        Iterator r2 = r1.getOldEntityVersions().entrySet().iterator();
    L11:
        if (r2.hasNext() == false) goto L21;
        Map.Entry r3 = (Map.Entry) r2.next();
        EntityVersionData r4 = (EntityVersionData) r3.getValue();
        EntityClassData r5 = (EntityClassData) EntityType.INSTANCE.getClassMap().get(r3.getKey());
        if (r5 == null) goto L15;
        int r6 = r5.getVersion();
    L16:
        EntityVersionData r7 = new EntityVersionData(r6, AppEntity.CREATOR.getVersion());
        Logger.INSTANCE.i(TAG, "reDonateCheck, type: " + ((Number) r3.getKey()).intValue() + " sdkVersion: " + r7 + " personalContextVersion: " + r4);
        if (r7.getSelfVersion() == (-1)) goto L11;
        if (r7.compareTo(r4) <= 0) goto L11;
        r11.add(r3.getKey());
        goto L11
    L15:
        r6 = -1;
        goto L16
    L21:
        Logger r8 = Logger.INSTANCE;
        r8.i(TAG, "reDonateCheck, needDonateVersions" + r11);
        if (r11.isEmpty() == false) goto L24;
        return true;
    L24:
        CountDownLatch r9 = new CountDownLatch(1);
        IndexTaskManager.INSTANCE.runTask("reDonateTask", new h(r9, r11));
        r9.await();
        r8.i(TAG, "reDonateCheck, reDonate finish");
        return true;
    L26:
        e = move-exception;
        Logger.INSTANCE.e(TAG, "reDonateCheck parse json error, jsonString: ".concat(r10), e);
        return false;
    }

    public final void reindexEntityData$capabilitykit_release() {
        int r0 = a.a;
        if (a.a(getSContext()) == MemoryServiceStatus.AVAILABLE) goto L13;
        Logger.INSTANCE.i(TAG, "EntityProvider is not available, skip reindexEntityData");
        return;
    L13:
        CountDownLatch r1 = new CountDownLatch(1);     // Catch: Exception -> L10
        IndexTaskManager r2 = IndexTaskManager.INSTANCE;     // Catch: Exception -> L10
        r2.runTask("reindexEntityData", new e(r1));     // Catch: Exception -> L10
        r1.await();     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        Logger.INSTANCE.e(TAG, "reindexEntityData error", e);
    }

    public final void setSContext(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        sContext = r2;
    }

    public final void syncData(List<Integer> r4) {
        Intrinsics.checkNotNullParameter(r4, "indexedEntityTypes");
        int r0 = a.a;
        if (a.a(getSContext()) == MemoryServiceStatus.AVAILABLE) goto L7;
        Logger.INSTANCE.w(TAG, "EntityProvider is not available, skip syncData");
        return;
    L7:
        if (isCredentialProtectionLocked() == false) goto L10;
        Logger.INSTANCE.w(TAG, "syncData, credentialProtectionLocked");
        return;
    L10:
        CountDownLatch r1 = new CountDownLatch(1);
        IndexTaskManager.INSTANCE.runTask("syncData", new i(r4, r1));
        r1.await();
    }

    public final void waitEntityProviderInit(long r3) {
        initialCountDownLatch.await(r3, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Logger.INSTANCE.e(TAG, "waitEntityProviderInit throwable", th);
    }

    private final void checkIfFirstRunOrDataClean() {
        PersonalContextData r0 = b0.a;
        if (b0.a != null) goto L7;
        Bundle r1 = INSTANCE.queryPersonalContextData$capabilitykit_release();
        if (r1 == null) goto L7;
        b0.a = PersonalContextData.Companion.createFromBundle(r1);
    L7:
        SharedPreferences r2 = getSContext().getSharedPreferences(ENTITY_REPO, 0);
        if ((!r2.getBoolean(ENTITY_FIRST_FLAG, false)) == false) goto L13;
        SharedPreferences.Editor r3 = r2.edit();
        r3.putBoolean(ENTITY_FIRST_FLAG, true);
        r3.apply();
        if (Intrinsics.areEqual("com.android.gallery3d", getSContext().getPackageName()) == true) goto L12;
        Logger.INSTANCE.i(TAG, "app's data may cleared, need to clean relative entity data, firstRunTimeStamp=" + firstRunCleanBeforeTimestamp);
        Bundle r4 = new Bundle();
        r4.putLong(KEY_CLEAN_BEFORE_TIMESTAMP, firstRunCleanBeforeTimestamp);
        innerCall(ENTITY_URI, METHOD_DATA_CLEAN, null, r4);
    L12:
        EntitySupplier r5 = entitySupplier;
        Intrinsics.checkNotNull(r5);
        bulkIndex$default(this, safeProvideAllEntities(r5, "checkIfFirstRunOrDataClean"), null, 2, null);
        return;
    L13:
        p.a.b();
    }

    private final boolean isNotInFeatureProcess() {
        if (isInitialized == true) goto L5;
        return true;
    L5:
        String r0 = featureRunProcessName;
        if (r0 == null) goto L8;
        String r2 = r.a;
        return true ^ Intrinsics.areEqual(r.a(INSTANCE.getSContext()), r0);
    L8:
        String r1 = r.a;
        Context r3 = getSContext();
        Intrinsics.checkNotNullParameter(r3, "context");
        String r4 = r.a(r3);
        if (r4 != null) goto L11;
    L13:
        if (r4 != null) goto L15;
    L17:
        boolean r5 = false;
    L18:
        if (r5 == false) goto L23;
        return false;
    L23:
        return true;
    L15:
        if (Intrinsics.areEqual(r4, r3.getPackageName()) == false) goto L17;
        r5 = true;
        goto L18
    L11:
        if (StringsKt.contains$default(r4, ":", false, 2, null) == false) goto L13;
        goto L13
    }

    private final void tryInsertBulkEntityHistory(List<w> r13) {
        ArrayList r0 = new ArrayList();
        ArrayList r1 = new ArrayList();
        r1.addAll(r13);
        int r2 = 0;
    L4:
        if (r2 >= 3) goto L32;
        v r3 = INSTANCE.getDbHelper();
        r3.getClass();
        Intrinsics.checkNotNullParameter(r1, "daoList");
        ArrayList r4 = new ArrayList();
        r3.a.beginTransaction();
        Iterator r5 = r1.iterator();     // Catch: Throwable -> L29
    L8:
        if (r5.hasNext() == false) goto L20;
        w r6 = (w) r5.next();     // Catch: Throwable -> L29
        ContentValues r7 = new ContentValues();     // Catch: Throwable -> L29
        r7.put("entity_id", r6.b);     // Catch: Throwable -> L29
        r7.put("entity_data", r6.c);     // Catch: Throwable -> L29
        r7.put(KEY_ENTITY_TYPE, Integer.valueOf(r6.d));     // Catch: Throwable -> L29
        r7.put("entity_action", r6.e.b());     // Catch: Throwable -> L29
        if (r3.a.insert("EntityHistory", null, r7) == (-1)) goto L8;
        r4.add(r6);     // Catch: Throwable -> L29
        goto L8
    L20:
        r3.a.setTransactionSuccessful();     // Catch: Throwable -> L29
        r3.a.endTransaction();
        Pair r8 = new Pair(Boolean.valueOf(!r4.isEmpty()), r4);
        r0.addAll((Collection) r8.getSecond());
        Iterator r9 = ((Iterable) r8.getSecond()).iterator();
    L23:
        if (r9.hasNext() == false) goto L26;
        r1.remove((w) r9.next());
        goto L23
    L26:
        if (r0.size() == r13.size()) goto L27;
        r2 = r2 + 1;
        goto L4
    L27:
        return;
    L29:
        th = move-exception;
        r3.a.endTransaction();
        throw th;
    }

    private static final void bulkIndexInner$lambda$13(List r7, ResultCallback r8) {
        Intrinsics.checkNotNullParameter(r7, "$entities");
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator r9 = r7.iterator();
    L4:
        if (r9.hasNext() == false) goto L9;
        Object r1 = r9.next();
        Integer r2 = Integer.valueOf(((AppEntity) r1).getType());
        Object r3 = r0.get(r2);
        if (r3 != null) goto L8;
        r3 = new ArrayList();
        r0.put(r2, r3);
    L8:
        ((List) r3).add(r1);
        goto L4
    L9:
        LinkedHashMap r10 = new LinkedHashMap();
        Iterator r4 = r0.entrySet().iterator();
    L11:
        if (r4.hasNext() == false) goto L19;
        Map.Entry r5 = (Map.Entry) r4.next();
        List<? extends AppEntity> r6 = INSTANCE.filterLastUniqueEntities((List) r5.getValue());
        Iterator<T> r11 = r6.iterator();
    L14:
        if (r11.hasNext() == false) goto L16;
        AppEntity r12 = (AppEntity) r11.next();
        INSTANCE.getDbHelper().b(r12.getId(), r12.getType());
        goto L14
    L16:
        EntityProvider r13 = INSTANCE;
        r13.tryInsertBulkEntityHistory(r6, m.c);
        IndexResult r14 = r13.innerBulkIndex(r6, r8);
        if (r14.getCode() == 0) goto L11;
        r10.put(r5.getKey(), r14);
        goto L11
    L19:
        boolean r15 = false;
        if ((!r10.isEmpty()) == false) goto L42;
        Logger.INSTANCE.w(TAG, "bulkIndexInner failed, failedMessageMap: " + r10);
        Collection r16 = r10.values();
        ArrayList r17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
        Iterator r18 = r16.iterator();
    L23:
        if (r18.hasNext() == false) goto L25;
        r17.add(Integer.valueOf(((IndexResult) r18.next()).getCode()));
        goto L23
    L25:
        Set r19 = CollectionsKt.toSet(r17);
        if (r19.size() != r10.size()) goto L29;
        r15 = true;
    L29:
        if (r19.size() != 1) goto L33;
        IndexResult r20 = (IndexResult) CollectionsKt.first(r10.values());
        if (r8 == null) goto L56;
        r8.onResult(r20.getCode(), r20.getMessage(), null);
        return;
    L56:
        return;
    L33:
        if (r15 == false) goto L35;
        String r21 = "all ";
    L36:
        String r22 = r21.concat(" entity type index failed:");
        Iterator r23 = r10.entrySet().iterator();
    L38:
        if (r23.hasNext() == false) goto L40;
        Map.Entry r24 = (Map.Entry) r23.next();
        r22 = r22 + "\n entity type " + ((Number) r24.getKey()).intValue() + " reason: " + ((IndexResult) r24.getValue()).getMessage();
        goto L38
    L40:
        if (r8 == null) goto L58;
        r8.onResult(304, r22, null);
        return;
    L58:
        return;
    L35:
        r21 = "some ";
        goto L36
    L42:
        if (r8 == null) goto L60;
        r8.onResult(0, "success", null);
        return;
    }

    private static ContentProviderClient com_obric_capabilitykit_EntityProvider_android_content_ContentResolver_acquireUnstableContentProviderClient(ContentResolver r18, Uri r19) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19};
        f06.b r11 = new f06.b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(240008);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        d r4 = r7.preInvoke(240008, "android/content/ContentResolver", "acquireUnstableContentProviderClient", r18, r1, "android.content.ContentProviderClient", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return (ContentProviderClient) r4.b;
    L21:
        return r18.acquireUnstableContentProviderClient(r19);
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    private final IndexResult innerBulkIndex(List<? extends AppEntity> r12, ResultCallback<Unit> r13) {
        if (isCredentialProtectionLocked() == true) goto L5;
        PersonalContextData r0 = b0.a;
        PersonalContextData r1 = b0.a;
        Parcel r2 = null;
        Integer r3 = null;
        if (r1 != null) goto L12;
        Bundle r4 = INSTANCE.queryPersonalContextData$capabilitykit_release();
        if (r4 == null) goto L11;
        r1 = PersonalContextData.Companion.createFromBundle(r4);
        b0.a = r1;
        goto L12
    L11:
        r1 = null;
    L12:
        if (r1 == null) goto L14;
        Set r5 = r1.getSupportEntityTypes();
    L16:
        if (r5 != null) goto L19;
        Logger.INSTANCE.w(TAG, "innerBulkIndex get PersonalContextData failed");
        IndexTaskManager.INSTANCE.scheduleRestoreHistoryProcessTask();
        return new IndexResult(303, "donate failed temporarily, personal context will retry internally");
    L19:
        ArrayList r6 = new ArrayList();
        ArrayList r7 = new ArrayList();
        Iterator<T> r8 = r12.iterator();
    L21:
        if (r8.hasNext() == false) goto L27;
        AppEntity r9 = (AppEntity) r8.next();
        if (r5.contains(Integer.valueOf(r9.getType())) == true) goto L24;
        r6.add(r9);
        goto L21
    L24:
        r7.add(r9);
        goto L21
    L27:
        if ((!r6.isEmpty()) == false) goto L33;
        Logger.INSTANCE.i(TAG, "innerBulkIndex, unsupported ids: " + q.b(q.a(r6)));
        Iterator r10 = r6.iterator();
    L30:
        if (r10.hasNext() == false) goto L33;
        AppEntity r11 = (AppEntity) r10.next();
        INSTANCE.getDbHelper().c(r11.getId(), r11.getType(), m.c.b());
    L33:
        if (r7.isEmpty() == false) goto L39;
        Logger r14 = Logger.INSTANCE;
        StringBuilder r15 = new StringBuilder("innerBulkIndex, no supporting entity type ");
        AppEntity r16 = (AppEntity) CollectionsKt.firstOrNull(r12);
        if (r16 == null) goto L37;
        r3 = Integer.valueOf(r16.getType());
    L37:
        r15.append(r3);
        r14.w(TAG, r15.toString());
        return new IndexResult(302, "unsupported entity type");
    L39:
        ArrayList r17 = new ArrayList();
        if (r7.size() >= 3) goto L46;
        Iterator r18 = r7.iterator();
    L43:
        if (r18.hasNext() == false) goto L45;
        ((AppEntity) r18.next()).countHashCode();
        goto L43
    L45:
        r17.add(r7);
    L81:
        Iterator r19 = r17.iterator();
    L83:
        if (r19.hasNext() == false) goto L106;
        List r20 = (List) r19.next();
        Logger r21 = Logger.INSTANCE;
        r21.i(TAG, "innerBulkIndex ids: " + q.b(q.a(r20)));
        Bundle r22 = new Bundle();
        r22.putParcelableArrayList(KEY_ENTITY_LIST, new ArrayList(r20));
        EntityProvider r23 = INSTANCE;
        Bundle r24 = r23.innerCall(ENTITY_URI, METHOD_INDEX, null, r22);
        String r25 = "internal error";
        if (r24 == null) goto L87;
        int r26 = r24.getInt(KEY_ERROR_CODE);
        String r27 = r24.getString(KEY_ERROR_MSG);
        if (r27 == null) goto L95;
        r25 = r27;
    L95:
        if (r26 != 0) goto L97;
        r23.removeProcessedEntityFromDB(r24, ((AppEntity) ListProtector.get(r20, 0)).getType(), m.c);
        goto L83
    L97:
        r21.w(TAG, "innerBulkIndex failed, errorCode: " + r26 + ", errorMsg: " + r25);
        if (r26 != 111) goto L104;
        Iterator r110 = r20.iterator();
    L101:
        if (r110.hasNext() == false) goto L104;
        AppEntity r111 = (AppEntity) r110.next();
        INSTANCE.getDbHelper().b(r111.getId(), r111.getType());
    L104:
        return new IndexResult(r26, r25);
    L87:
        if (r13 == null) goto L90;
        r13.onResult(501, "internal error", null);
    L90:
        return new IndexResult(501, "internal error");
    L106:
        return new IndexResult(0, "success");
    L46:
        ArrayList r28 = new ArrayList();
        Iterator r29 = r7.iterator();
        int r30 = 0;
    L48:
        if (r29.hasNext() == false) goto L79;
        AppEntity r31 = (AppEntity) r29.next();
        r31.countHashCode();
        Parcel r32 = Parcel.obtain();     // Catch: Throwable -> L57 Exception -> L59
        r32.writeParcelable(r31, 0);     // Catch: Throwable -> L53 Exception -> L55
        int r33 = r32.dataSize();     // Catch: Throwable -> L53 Exception -> L55
        r32.recycle();
    L68:
        if ((!r28.isEmpty()) == false) goto L74;
        if ((r30 + r33) <= MAX_TRANSACTION_SIZE_BYTES) goto L72;
    L73:
        r17.add(r28);
        r28 = new ArrayList();
        r30 = 0;
        goto L74
    L72:
        if (r28.size() >= 100) goto L73;
    L74:
        r28.add(r31);
        r30 = r30 + r33;
        goto L48
    L55:
        e = e;
    L63:
        Logger.INSTANCE.e(TAG, "calculate parcel size error", e);     // Catch: Throwable -> L53
        if (r32 == null) goto L66;
        r32.recycle();
    L66:
        r33 = 1024;
    L53:
        th = th;
        r2 = r32;
    L75:
        if (r2 == null) goto L77;
        r2.recycle();
    L77:
        throw th;
    L59:
        e = e;
        r32 = null;
    L57:
        th = th;
        goto L75
    L79:
        if ((!r28.isEmpty()) == false) goto L81;
        r17.add(r28);
        goto L81
    L14:
        r5 = null;
        goto L16
    L5:
        return new IndexResult(305, "device is locked, donate will try when user unlocked device");
    }

    public final void bulkIndex(List<? extends AppEntity> r3, ResultCallback<Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "entities");
        if (r3.isEmpty() == false) goto L7;
        if (r4 == null) goto L9;
        r4.onResult(301, "entity list is empty", null);
        return;
    L9:
        return;
    L7:
        bulkIndexInner$capabilitykit_release(r3, r4);
    }

    public final void bulkIndexInner$capabilitykit_release(List<? extends AppEntity> r4, ResultCallback<Unit> r5) {
        Intrinsics.checkNotNullParameter(r4, "entities");
        int r0 = a.a;
        if (a.a(getSContext()) == MemoryServiceStatus.AVAILABLE) goto L8;
        if (r5 == null) goto L14;
        r5.onResult(306, "EntityProvider is disabled", null);
        return;
    L14:
        return;
    L8:
        if (isCredentialProtectionLocked() == false) goto L12;
        if (r5 == null) goto L15;
        r5.onResult(305, "device is locked, retry donate when user unlocked device", null);
        return;
    L15:
        return;
    L12:
        IndexTaskManager.INSTANCE.runTask("bulkIndexInner(size:" + r4.size() + ')', new f(r4, r5));
    }

    public final void getIndexProgress(int r3, ResultCallback<IndexProgress> r4) {
        Intrinsics.checkNotNullParameter(r4, "callback");
        int r0 = a.a;
        if (a.a(getSContext()) == MemoryServiceStatus.AVAILABLE) goto L6;
        r4.onResult(306, "Memory service is not available", null);
        return;
    L6:
        IndexTaskManager.INSTANCE.runTask("getIndexProgress", new l(r3, r4));
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_obric_capabilitykit_EntityProvider_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r8, BroadcastReceiver r9, IntentFilter r10) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L42;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L42:
    L36:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L40;
        throw e;
    L40:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r9, r10);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (r10 == null) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r10) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r0 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r9, r10, 0, null, null, 2, r8);     // Catch: Exception -> L36
        int r1 = r0.result;     // Catch: Exception -> L36
        if (r1 == 1) goto L23;
        if (r1 == 2) goto L21;
        if (r1 == 3) goto L19;
        return r8.registerReceiver(r9, r10);
    L19:
        return r0.intent;
    L21:
        return new Intent();
    L23:
        return r8.registerReceiver(r9, r10);
    L25:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L29;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L36
        return r8.registerReceiver(r9, r10, null, ReceiverRegisterLancet.sReceiverHandler);
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L35;
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r10) == false) goto L35;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L36
        return ContextCompat.registerReceiver(r8, r9, r10, null, ReceiverRegisterLancet.sProxyHandler, 2);
    L35:
        return r8.registerReceiver(r9, r10);
    }

    private final void removeProcessedEntityFromDB(Bundle r5, int r6, m r7) {
        if (r5 == null) goto L11;
        ArrayList<String> r8 = r5.getStringArrayList(KEY_SUCCESS_IDS);
        if (r8 == null) goto L11;
        Logger.INSTANCE.i(TAG, "callback successIds: " + q.b(r8) + " entityType: " + r6 + " type: " + r7.b());
        Iterator<T> r9 = r8.iterator();
    L7:
        if (r9.hasNext() == false) goto L11;
        String r0 = (String) r9.next();
        INSTANCE.getDbHelper().c(r0, r6, r7.b());
        p r1 = p.a;
        String r2 = r7.b();
        Intrinsics.checkNotNullParameter(r0, "entityId");
        Intrinsics.checkNotNullParameter(r2, "actionType");
        ConcurrentHashMap r3 = p.b;
        if (r3 == null) goto L7;
        Integer r4 = (Integer) r3.remove(r0 + '_' + r6 + '_' + r2);
    L11:
        IndexTaskManager.INSTANCE.scheduleRestoreHistoryProcessTask();
    }
}
