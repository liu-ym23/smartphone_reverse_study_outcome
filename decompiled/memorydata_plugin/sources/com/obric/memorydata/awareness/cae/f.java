package com.obric.memorydata.awareness.cae;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.provider.Settings;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapterFactory;
import com.obric.cae.libs.location.geofence.StarGeofence;
import com.obric.cae.libs.useraware.WifiStandardData;
import com.obric.cae.userAware.datacollection.AwareStateListener;
import com.obric.cae.userAware.utils.UserAwareUtil;
import com.obric.memorydata.awareness.api.AwarenessManager;
import com.obric.memorydata.awareness.api.FeatureManager;
import com.obric.memorydata.awareness.api.LocationSnapshot;
import com.obric.memorydata.database.dao.WifiListDao;
import com.obric.memorydata.database.entity.ConnectWifiInfo;
import com.obric.memorydata.database.entity.ConnectWifiInfoSummary;
import com.obric.memorydata.database.entity.ScanWIfiInfo;
import com.obric.memorydata.database.entity.cl;
import com.obric.memorydata.database.entity.je;
import com.obric.memorydata.database.entity.jk;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.intelligence.api.ProfileLabel;
import com.obric.memorydata.intelligence.api.UserProfileGpsPoint;
import com.obric.memorydata.intelligence.api.UserProfileLabel;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.bdtracker.Tracker;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStore;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.obric.memorydata.sdk.awareness.EventNames;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.task.impl.TaskResult;
import com.obric.memorydata.utils.at;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.flow.ae;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u008c\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t*\u0002<I\u0018\u0000 \u00ad\u00012\u00020\u0001:\f\u00ad\u0001®\u0001¯\u0001°\u0001±\u0001²\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\"H\u0000¢\u0006\u0002\bEJ\f\u0010K\u001a\u00020\u001f*\u00020LH\u0002J\f\u0010M\u001a\u00020\n*\u00020LH\u0002J\u0006\u0010N\u001a\u00020CJ\b\u0010O\u001a\u00020CH\u0002J\b\u0010P\u001a\u00020CH\u0002J\b\u0010Q\u001a\u00020CH\u0002J\b\u0010R\u001a\u00020CH\u0002J\b\u0010S\u001a\u00020CH\u0002J$\u0010T\u001a\u00020C2\u0006\u0010U\u001a\u00020\"2\b\u0010V\u001a\u0004\u0018\u00010\u00012\b\u0010W\u001a\u0004\u0018\u00010\u0001H\u0002J$\u0010X\u001a\u00020C2\u0006\u0010U\u001a\u00020\"2\b\u0010V\u001a\u0004\u0018\u00010\u00012\b\u0010W\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010Y\u001a\u00020CH\u0002J\b\u0010Z\u001a\u00020CH\u0002J\b\u0010[\u001a\u00020CH\u0002J\b\u0010\\\u001a\u00020CH\u0002J\b\u0010]\u001a\u00020CH\u0002J\u0010\u0010^\u001a\u00020C2\u0006\u0010_\u001a\u00020\"H\u0002J\b\u0010`\u001a\u00020$H\u0002J\b\u0010a\u001a\u00020CH\u0002J\b\u0010b\u001a\u00020CH\u0002J\b\u0010c\u001a\u00020CH\u0002J\u0010\u0010d\u001a\u00020C2\u0006\u0010e\u001a\u000201H\u0002J\u0010\u0010f\u001a\u00020C2\u0006\u0010e\u001a\u000201H\u0002J\u0012\u0010g\u001a\u0004\u0018\u00010h2\u0006\u0010i\u001a\u00020\"H\u0002J\u0014\u0010j\u001a\u00020C2\n\b\u0002\u0010k\u001a\u0004\u0018\u00010lH\u0002J\u0014\u0010m\u001a\u0004\u0018\u00010l2\b\u0010k\u001a\u0004\u0018\u00010lH\u0002J\b\u0010n\u001a\u00020$H\u0002J\b\u0010o\u001a\u00020$H\u0002J!\u0010p\u001a\u00020C2\u0006\u0010_\u001a\u00020\"2\u000e\b\u0004\u0010q\u001a\b\u0012\u0004\u0012\u00020C0rH\u0082\bJ\u0014\u0010s\u001a\u0010\u0012\u0004\u0012\u00020t\u0012\u0004\u0012\u00020t\u0018\u00010\fJ\n\u0010u\u001a\u0004\u0018\u00010\"H\u0002J\u001e\u0010v\u001a\u0010\u0012\u0004\u0012\u00020t\u0012\u0004\u0012\u00020t\u0018\u00010\f2\u0006\u0010w\u001a\u00020\"H\u0002J\b\u0010x\u001a\u00020CH\u0002J\u0018\u0010y\u001a\u00020C2\u0006\u0010z\u001a\u00020$2\u0006\u0010D\u001a\u00020\"H\u0002J\"\u0010{\u001a\u00020C2\u0006\u0010z\u001a\u00020$2\u0006\u0010D\u001a\u00020\"2\b\u0010|\u001a\u0004\u0018\u00010}H\u0002J$\u0010~\u001a\u00020\u007f2\u0006\u0010z\u001a\u00020$2\u0006\u0010D\u001a\u00020\"2\n\b\u0002\u0010|\u001a\u0004\u0018\u00010}H\u0002J\u0019\u0010\u0080\u0001\u001a\u00020C2\u0006\u0010z\u001a\u00020$2\u0006\u0010D\u001a\u00020\"H\u0002J\u0007\u0010\u0081\u0001\u001a\u00020CJ\t\u0010\u0082\u0001\u001a\u00020CH\u0002J\t\u0010\u0083\u0001\u001a\u00020CH\u0002J\t\u0010\u0084\u0001\u001a\u00020CH\u0002J\t\u0010\u0085\u0001\u001a\u00020CH\u0002J\t\u0010\u0086\u0001\u001a\u00020CH\u0002J\"\u0010\u0087\u0001\u001a\u00020$2\u0017\b\u0002\u0010\u0088\u0001\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0005\u0012\u00030\u008a\u00010\u0089\u0001H\u0002J\u0010\u0010\u008b\u0001\u001a\t\u0012\u0005\u0012\u00030\u008a\u00010\u000eH\u0002J\u000f\u0010\u008c\u0001\u001a\b\u0012\u0004\u0012\u00020l0\u000eH\u0002J\n\u0010\u008d\u0001\u001a\u00030\u008e\u0001H\u0002J\u0019\u0010\u008f\u0001\u001a\u00020$2\u000e\u0010\u0090\u0001\u001a\t\u0012\u0004\u0012\u00020\"0\u0091\u0001H\u0002J\u001b\u0010\u0092\u0001\u001a\u00020\"*\u0010\u0012\u0004\u0012\u00020\"\u0012\u0005\u0012\u00030\u008a\u00010\u0089\u0001H\u0002J\u0011\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u008a\u0001*\u00030\u0094\u0001H\u0002J\u001b\u0010\u0095\u0001\u001a\u00030\u008e\u00012\t\u0010\u0096\u0001\u001a\u0004\u0018\u00010tH\u0002¢\u0006\u0003\u0010\u0097\u0001J\r\u0010D\u001a\u00020\"*\u00030\u008a\u0001H\u0002J\r\u0010\u0098\u0001\u001a\u00020\r*\u00020tH\u0002J\t\u0010\u0099\u0001\u001a\u00020CH\u0002J\u0013\u0010\u009a\u0001\u001a\u00030\u009b\u00012\u0007\u0010\u009c\u0001\u001a\u00020\u007fH\u0002J\u000b\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u007fH\u0002J\u0016\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u009f\u00012\b\u0010D\u001a\u0004\u0018\u00010\"H\u0002J\u001c\u0010 \u0001\u001a\u00020C2\u0007\u0010\u009c\u0001\u001a\u00020\u007f2\b\u0010¡\u0001\u001a\u00030\u009f\u0001H\u0002J\u001b\u0010¢\u0001\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u000e2\b\u0010D\u001a\u0004\u0018\u00010\"H\u0002J\r\u0010£\u0001\u001a\u00020\"*\u00020\"H\u0002J&\u0010¤\u0001\u001a\u00020C2\u0007\u0010\u009c\u0001\u001a\u00020\u007f2\b\u0010D\u001a\u0004\u0018\u00010\"2\b\u0010|\u001a\u0004\u0018\u00010}H\u0002J\u0015\u0010¥\u0001\u001a\u0004\u0018\u00010}2\b\u0010D\u001a\u0004\u0018\u00010\"H\u0002J!\u0010¦\u0001\u001a\b\u0012\u0004\u0012\u00020\"0\u000e2\u0007\u0010§\u0001\u001a\u00020t2\u0007\u0010¨\u0001\u001a\u00020tH\u0002J4\u0010©\u0001\u001a\t\u0012\u0005\u0012\u00030ª\u00010\u000e2\u0007\u0010«\u0001\u001a\u00020\r2\u0007\u0010¬\u0001\u001a\u00020\r2\u0007\u0010§\u0001\u001a\u00020t2\u0007\u0010¨\u0001\u001a\u00020tH\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00020\r\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001a\u001a\n \u001c*\u0004\u0018\u00010\u001b0\u001bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001dR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0004\n\u0002\u0010%R\u000e\u0010&\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010)\u001a\b\u0012\u0004\u0012\u00020$0*¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0017\u0010-\u001a\b\u0012\u0004\u0012\u00020$0*¢\u0006\b\n\u0000\u001a\u0004\b.\u0010,R\u0014\u0010/\u001a\b\u0012\u0004\u0012\u00020$0*X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u00020<X\u0082\u0004¢\u0006\u0004\n\u0002\u0010=R\u0014\u0010>\u001a\u00020?X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u0014\u0010F\u001a\u00020?X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010AR\u0010\u0010H\u001a\u00020IX\u0082\u0004¢\u0006\u0004\n\u0002\u0010J¨\u0006³\u0001"}, d2 = {"Lcom/obric/memorydata/awareness/cae/HomeCompanyStatePredict;", "", "<init>", "()V", "caeAwareClient", "Lcom/obric/memorydata/awareness/cae/CAEAwareClient;", "getCaeAwareClient", "()Lcom/obric/memorydata/awareness/cae/CAEAwareClient;", "wifiConnectInfoCache", "Lcom/obric/memorydata/awareness/cae/HomeCompanyStatePredict$FixedSizeList;", "Lcom/obric/memorydata/database/entity/ConnectWifiInfo;", "wifiScanInfoCache", "Lkotlin/Pair;", "", "", "Lcom/obric/memorydata/database/entity/ScanWIfiInfo;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "store", "Lcom/obric/memorydata/middleware/api/store/IStore;", "workerHandler", "Landroid/os/Handler;", "getWorkerHandler", "()Landroid/os/Handler;", "workerHandler$delegate", "Lkotlin/Lazy;", "gson", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "Lcom/google/gson/Gson;", "cachedConnectWifiInfo", "Lcom/obric/memorydata/database/entity/ConnectWifiInfoSummary;", "historyConnectBssidSet", "", "", "wifiNetworkAvailable", "", "Ljava/lang/Boolean;", "hasInit", "learningTask", "Lcom/obric/memorydata/task/impl/TaskRequest;", "homeLocationAvailable", "Lkotlinx/coroutines/flow/MutableStateFlow;", "getHomeLocationAvailable", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "companyLocationAvailable", "getCompanyLocationAvailable", "homeGpsFenceListAvailable", "homeCompanyStateChangeListener", "Lcom/obric/memorydata/awareness/api/EventListener;", "homeGpsFenceListObserverRegistered", "lastHomeGpsFenceListProfileValue", "lastHomeGpsFenceListFenceSignature", "predictEnabled", "aoiCompanyNeedWifiScan", "companyNativeFenceInsideNotified", "homeCompanyStateListener", "waitGeofenceReadyJob", "Lkotlinx/coroutines/Job;", "predictDailyCallback", "com/obric/memorydata/awareness/cae/HomeCompanyStatePredict$predictDailyCallback$1", "Lcom/obric/memorydata/awareness/cae/HomeCompanyStatePredict$predictDailyCallback$1;", "homeCompanyFenceChangeListener", "Lcom/obric/memorydata/awareness/cae/GeoFenceListener;", "getHomeCompanyFenceChangeListener$awareness_obricRelease", "()Lcom/obric/memorydata/awareness/cae/GeoFenceListener;", "onInitialGeofenceStateChanged", "", "fenceId", "onInitialGeofenceStateChanged$awareness_obricRelease", "aoiFenceChangeListener", "getAoiFenceChangeListener$awareness_obricRelease", "wifiInfoChangeCallback", "com/obric/memorydata/awareness/cae/HomeCompanyStatePredict$wifiInfoChangeCallback$1", "Lcom/obric/memorydata/awareness/cae/HomeCompanyStatePredict$wifiInfoChangeCallback$1;", "toConnectInfoSummary", "Lcom/obric/cae/libs/useraware/WifiStandardData;", "toConnectInfo", CommonConsts.APM_INNER_EVENT_COST_INIT, "restoreHomeGpsFenceListFeature", "registerLeavingHomeOrCompanyCallback", "observeLocationChange", "notifyLocationChangeToPackage", "observerHomeAndCompanyLocation", "handleHomeCompanyFeatureChanged", "feature", "oldValue", "newValue", "handleHomeCompanyFeatureEvent", "registerHomeCompanyStateChangeTracker", "unregisterHomeCompanyStateChangeTracker", "enablePredictAsNeeded", "enablePredict", "disablePredict", "updateRealtimeWifiPredictionRegistration", InfoRequestQPSOptTraceLogger.REASON, "canRunRealtimePrediction", "clearPendingWifiPredictionData", "observerHomeCompanyStateChange", "unregisterObserverHomeCompanyStateChange", "registerHomeCompanyContextEvents", "listener", "unregisterHomeCompanyContextEvents", "resolveHomeCompanyContextEvent", "Lcom/obric/memorydata/awareness/cae/HomeCompanyStatePredict$HomeCompanyContextEvent;", "eventName", "updateCurrentFence", "transportHubCompanyFence", "Lcom/obric/cae/libs/location/geofence/StarGeofence;", "getCurrentFence", "shouldSkipWifiPredictForAoiCompany", "isCurrentAoiCompanyFence", "runOnWorker", "block", "Lkotlin/Function0;", "resolveAtHomeEventLocation", "", "getInsideHomeFenceId", "getGpsFeatureLocation", "featureName", "observeHomeGpsFenceList", "notifyPredict", "enter", "notifyAoiPredict", "aoiCompanyInfo", "Lcom/obric/memorydata/awareness/cae/CaeLocationAware$AoiCompanyInfo;", "createFencePredictArgs", "Lorg/json/JSONObject;", "notifyGeofenceChanged", "registerFenceIfNeed", "registerFenceIfNeedInternal", "registerHomeFenceIfNeeded", "registerCompanyFenceIfNeeded", "refreshHomeGpsFenceListFences", "updateHomeGpsFenceListAvailable", "syncHomeGpsFenceListFences", "desiredFences", "", "Lcom/obric/memorydata/awareness/cae/HomeCompanyStatePredict$HomeGpsFenceListPoint;", "loadHomeGpsFenceListPoints", "getHomeGpsFenceListGeofences", "removeHomeGpsFenceListGeofences", "", "areHomeGpsFenceListFencesRegistered", "desiredFenceIds", "", "toFenceSignature", "toHomeGpsFenceListPoint", "Lcom/obric/memorydata/intelligence/api/UserProfileGpsPoint;", "resolveFenceRadius", "radiusMeters", "(Ljava/lang/Double;)I", "toFenceIdPart", "addHomeCompanyWifiBssids", "runPredict", "Lcom/obric/memorydata/awareness/cae/HomeCompanyStatePredict$PredictExecutionResult;", "args", "createPredictArgs", "createFenceWifiContext", "Lcom/obric/memorydata/awareness/cae/HomeCompanyStatePredict$FenceWifiContext;", "addFenceWifiContext", "fenceWifiContext", "getBssidsForFence", "toPredictFenceId", "addAoiCompanyInfoIfNeeded", "getAoiCompanyInfo", "getNearBssid", "longitude", "latitude", "loadNearLocationRawData", "Lcom/obric/memorydata/database/entity/LocationEntity;", "startTimestamp", "endTimestamp", "Companion", "HomeCompanyContextEvent", "PredictExecutionResult", "FenceWifiContext", "FixedSizeList", "HomeGpsFenceListPoint", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f {
    private static final Map<String, d> D = null;
    private static volatile StarGeofence E;
    private static final ae<String> F = null;
    private static final f G = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8574a = null;
    private final com.obric.memorydata.awareness.cae.d A;
    private final com.obric.memorydata.awareness.cae.d B;
    private final p C;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.memorydata.awareness.cae.a f8575b;
    private final c<ConnectWifiInfo> c;
    private Pair<Long, ? extends List<ScanWIfiInfo>> d;
    private final al e;
    private final IStore f;
    private final Lazy g;
    private final Gson h;
    private ConnectWifiInfoSummary i;
    private Set<String> j;
    private Boolean k;
    private boolean l;
    private TaskRequest m;
    private final ae<Boolean> n;
    private final ae<Boolean> o;
    private final ae<Boolean> p;
    private com.obric.memorydata.awareness.api.a q;
    private boolean r;
    private String s;
    private String t;
    private volatile boolean u;
    private volatile boolean v;
    private volatile boolean w;
    private com.obric.memorydata.awareness.api.a x;
    private bx y;
    private final l z;

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001f0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00050(¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010+\u001a\u00020,¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.¨\u0006/"}, d2 = {"Lcom/obric/memorydata/awareness/cae/HomeCompanyStatePredict$Companion;", "", "<init>", "()V", "TAG", "", "HOME_GPS_FENCE_ID", "COMPANY_GPS_FENCE_ID", "USER_LOCATION_STATE", "USER_LOCATION_STATE_CHANGE", "CAE_USER_AWARE_ENABLE_WIFI_SCAN_FUNCTION", "SAVE_HOME_BSSID", "SAVE_COMPANY_BSSID", "AOI_INFO", "AOI_INFO_TYPE", "AOI_INFO_RADIUS", "NEED_WIFI_SCAN", "WAIT_GEOFENCE_READY_TIMEOUT_MS", "", "HOME_GPS_FENCE_LIST_FENCE_PREFIX", "DEFAULT_HOME_COMPANY_FENCE_RADIUS_METERS", "", "HOME_GPS_FENCE_COORDINATE_SCALE", "LOCATION_STATE_AT_HOME", "LOCATION_STATE_OUT_HOME", "LOCATION_STATE_AT_COMPANY", "LOCATION_STATE_OUT_COMPANY", "LOCATION_STATE_CHANGE_INTO_HOME", "LOCATION_STATE_CHANGE_INTO_COMPANY", "HOME_COMPANY_CONTEXT_EVENTS", "", "Lcom/obric/memorydata/awareness/cae/HomeCompanyStatePredict$HomeCompanyContextEvent;", "debugFenceTime", "getDebugFenceTime", "()J", "setDebugFenceTime", "(J)V", "currentFence", "Lcom/obric/cae/libs/location/geofence/StarGeofence;", "predictState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "getPredictState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "instance", "Lcom/obric/memorydata/awareness/cae/HomeCompanyStatePredict;", "getInstance", "()Lcom/obric/memorydata/awareness/cae/HomeCompanyStatePredict;", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final f a() {
            return f.g();
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J)\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/awareness/cae/HomeCompanyStatePredict$FenceWifiContext;", "", "bssids", "", "", "bssidHashes", "", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getBssids", "()Ljava/util/List;", "getBssidHashes", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<String> f8576a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<Integer> f8577b;

        public b(List<String> r3, List<Integer> r4) {
            List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            List<Integer> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "bssids");
            Intrinsics.checkNotNullParameter(r6, "bssidHashes");
            this.f8576a = r5;
            this.f8577b = r6;
        }

        public final List<String> a() {
            return this.f8576a;
        }

        public final List<Integer> b() {
            return this.f8577b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f8576a, r6.f8576a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f8577b, r6.f8577b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f8576a.hashCode() * 31) + this.f8577b.hashCode();
        }

        public String toString() {
            return "FenceWifiContext(bssids=" + this.f8576a + ", bssidHashes=" + this.f8577b + ')';
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0000¢\u0006\u0002\u0010\fJ\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eJ\u0006\u0010\u000f\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/awareness/cae/HomeCompanyStatePredict$FixedSizeList;", ExifInterface.GPS_DIRECTION_TRUE, "", "maxSize", "", "<init>", "(I)V", "deque", "Lkotlin/collections/ArrayDeque;", "add", "", "item", "(Ljava/lang/Object;)V", "getList", "", "clear", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f8578a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ArrayDeque<T> f8579b;

        public c(int r1) {
            this.f8578a = r1;
            this.f8579b = new ArrayDeque();
        }

        public final List<T> a() {
            return CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(this.f8579b, Iterable.class, "com.obric.memorydata.plugin"));
        }

        public final void a(T r3) {
            if (this.f8579b.size() < this.f8578a) goto L5;
            this.f8579b.removeFirst();
        L5:
            this.f8579b.addLast(r3);
        }

        public final void b() {
            this.f8579b.clear();
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/awareness/cae/HomeCompanyStatePredict$HomeCompanyContextEvent;", "", "locationState", "", "stateChange", "isEnter", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getLocationState", "()Ljava/lang/String;", "getStateChange", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f8580a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f8581b;
        private final boolean c;

        public d(String r2, String r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r2, "locationState");
            Intrinsics.checkNotNullParameter(r3, "stateChange");
            this.f8580a = r2;
            this.f8581b = r3;
            this.c = r4;
        }

        public final String a() {
            return this.f8580a;
        }

        public final String b() {
            return this.f8581b;
        }

        public final boolean c() {
            return this.c;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
            return false;
        L8:
            d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f8580a, r6.f8580a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f8581b, r6.f8581b) == true) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f8580a.hashCode() * 31) + this.f8581b.hashCode()) * 31) + Boolean.hashCode(this.c);
        }

        public String toString() {
            return "HomeCompanyContextEvent(locationState=" + this.f8580a + ", stateChange=" + this.f8581b + ", isEnter=" + this.c + ')';
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/obric/memorydata/awareness/cae/HomeCompanyStatePredict$HomeGpsFenceListPoint;", "", "longitude", "", "latitude", "radius", "", "isOfficialHome", "", "<init>", "(DDIZ)V", "getLongitude", "()D", "getLatitude", "getRadius", "()I", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final double f8582a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final double f8583b;
        private final int c;
        private final boolean d;

        public e(double r1, double r3, int r5, boolean r6) {
            this.f8582a = r1;
            this.f8583b = r3;
            this.c = r5;
            this.d = r6;
        }

        public final double a() {
            return this.f8582a;
        }

        public final double b() {
            return this.f8583b;
        }

        public final int c() {
            return this.c;
        }

        public final boolean d() {
            return this.d;
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, e.class) == true) goto L8;
            return false;
        L8:
            e r10 = (e) ZeusTransformUtils.preCheckCast(r9, e.class, "com.obric.memorydata.plugin");
            if (Double.compare(this.f8582a, r10.f8582a) == 0) goto L12;
            return false;
        L12:
            if (Double.compare(this.f8583b, r10.f8583b) == 0) goto L15;
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

        public int hashCode() {
            return (((((Double.hashCode(this.f8582a) * 31) + Double.hashCode(this.f8583b)) * 31) + Integer.hashCode(this.c)) * 31) + Boolean.hashCode(this.d);
        }

        public String toString() {
            return "HomeGpsFenceListPoint(longitude=" + this.f8582a + ", latitude=" + this.f8583b + ", radius=" + this.c + ", isOfficialHome=" + this.d + ')';
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.awareness.cae.f$f, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001a\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/awareness/cae/HomeCompanyStatePredict$PredictExecutionResult;", "", "needWifiScan", "", "<init>", "(Ljava/lang/Boolean;)V", "getNeedWifiScan", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "copy", "(Ljava/lang/Boolean;)Lcom/obric/memorydata/awareness/cae/HomeCompanyStatePredict$PredictExecutionResult;", "equals", "other", "hashCode", "", "toString", "", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class C0433f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Boolean f8584a;

        public C0433f(Boolean r1) {
            this.f8584a = r1;
        }

        public final Boolean a() {
            return this.f8584a;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0433f.class) == true) goto L8;
            return false;
        L8:
            C0433f r6 = (C0433f) ZeusTransformUtils.preCheckCast(r5, C0433f.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f8584a, r6.f8584a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            Boolean r0 = this.f8584a;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public String toString() {
            return "PredictExecutionResult(needWifiScan=" + this.f8584a + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/obric/memorydata/awareness/cae/HomeCompanyStatePredict$aoiFenceChangeListener$1", "Lcom/obric/memorydata/awareness/cae/GeoFenceListener;", "onGeoFenceEntered", "", "fenceId", "", "onGeoFenceExited", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class g implements com.obric.memorydata.awareness.cae.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f8585a;

        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f8586a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ f f8587b;
            final /* synthetic */ String c;
            final /* synthetic */ StarGeofence d;
            final /* synthetic */ com.obric.memorydata.awareness.cae.b.a e;

            public a(String r1, f r2, String r3, StarGeofence r4, com.obric.memorydata.awareness.cae.b.a r5) {
                this.f8586a = r1;
                this.f8587b = r2;
                this.c = r3;
                this.d = r4;
                this.e = r5;
            }

            @Override // java.lang.Runnable
            public final void run() {
            L11:
                th = move-exception;
                RunLog.INSTANCE.warn("HomeCompanyStatePredict", "run worker task failed reason=" + this.f8586a, th);
                return;
            L4:
                if (f.d(this.f8587b) == true) goto L7;
                IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HomeCompanyStatePredict", "ignore aoi company enter: predict disabled", false, 4, null);     // Catch: Throwable -> L11
                com.obric.memorydata.awareness.cae.b.f8563a.a("aoi company enter ignored: predict disabled");     // Catch: Throwable -> L11
            L14:
                return;
            L7:
                if (com.obric.memorydata.awareness.cae.b.f8563a.b() == true) goto L9;
                IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HomeCompanyStatePredict", "位置基线尚未完成，忽略 HC AOI 公司进入预测", false, 4, null);     // Catch: Throwable -> L11
                goto L14
            L9:
                IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HomeCompanyStatePredict", "enter aoi company geofence: " + this.c, false, 4, null);     // Catch: Throwable -> L11
                f.a(this.f8587b, this.d);     // Catch: Throwable -> L11
                f.a(this.f8587b, true, this.c, this.e);     // Catch: Throwable -> L11
                goto L14
            }
        }

        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        public static final class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f8588a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ f f8589b;
            final /* synthetic */ String c;
            final /* synthetic */ StarGeofence d;
            final /* synthetic */ com.obric.memorydata.awareness.cae.b.a e;

            public b(String r1, f r2, String r3, StarGeofence r4, com.obric.memorydata.awareness.cae.b.a r5) {
                this.f8588a = r1;
                this.f8589b = r2;
                this.c = r3;
                this.d = r4;
                this.e = r5;
            }

            @Override // java.lang.Runnable
            public final void run() {
            L11:
                th = move-exception;
                RunLog.INSTANCE.warn("HomeCompanyStatePredict", "run worker task failed reason=" + this.f8588a, th);
                return;
            L4:
                if (f.d(this.f8589b) == true) goto L7;
                IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HomeCompanyStatePredict", "ignore aoi company exit: predict disabled", false, 4, null);     // Catch: Throwable -> L11
                com.obric.memorydata.awareness.cae.b.f8563a.a("aoi company exit ignored: predict disabled");     // Catch: Throwable -> L11
            L14:
                return;
            L7:
                if (com.obric.memorydata.awareness.cae.b.f8563a.b() == true) goto L9;
                IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HomeCompanyStatePredict", "位置基线尚未完成，忽略 HC AOI 公司离开预测", false, 4, null);     // Catch: Throwable -> L11
                goto L14
            L9:
                IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HomeCompanyStatePredict", "exit aoi company geofence: " + this.c, false, 4, null);     // Catch: Throwable -> L11
                f.a(this.f8589b, this.d);     // Catch: Throwable -> L11
                f.a(this.f8589b, false, this.c, this.e);     // Catch: Throwable -> L11
                goto L14
            }
        }

        g(f r1) {
            this.f8585a = r1;
        }

        @Override // com.obric.memorydata.awareness.cae.d
        public void a(String r15) {
            Intrinsics.checkNotNullParameter(r15, "fenceId");
            if (Intrinsics.areEqual(r15, "company_fence") == true) goto L6;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HomeCompanyStatePredict", "ignore aoi company enter fenceId=" + r15, null, 4, null);
            return;
        L6:
            StarGeofence r6 = com.obric.memorydata.awareness.cae.b.f8563a.f();
            com.obric.memorydata.awareness.cae.b.a r7 = com.obric.memorydata.awareness.cae.b.f8563a.g();
            f r4 = this.f8585a;
            if (Intrinsics.areEqual(Thread.currentThread(), f.a(r4).getLooper().getThread()) == true) goto L9;
            f.a(r4).post((Runnable) ZeusTransformUtils.preCheckCast(new a("aoi company enter", r4, r15, r6, r7), Runnable.class, "com.obric.memorydata.plugin"));
            return;
        L9:
            if (f.d(r4) == true) goto L12;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HomeCompanyStatePredict", "ignore aoi company enter: predict disabled", false, 4, null);
            com.obric.memorydata.awareness.cae.b.f8563a.a("aoi company enter ignored: predict disabled");
            return;
        L12:
            if (com.obric.memorydata.awareness.cae.b.f8563a.b() == true) goto L14;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HomeCompanyStatePredict", "位置基线尚未完成，忽略 HC AOI 公司进入预测", false, 4, null);
            return;
        L14:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HomeCompanyStatePredict", "enter aoi company geofence: " + r15, false, 4, null);
            f.a(r4, r6);
            f.a(r4, true, r15, r7);
        }

        @Override // com.obric.memorydata.awareness.cae.d
        public void b(String r15) {
            Intrinsics.checkNotNullParameter(r15, "fenceId");
            if (Intrinsics.areEqual(r15, "company_fence") == true) goto L6;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HomeCompanyStatePredict", "ignore aoi company exit fenceId=" + r15, null, 4, null);
            return;
        L6:
            StarGeofence r6 = com.obric.memorydata.awareness.cae.b.f8563a.f();
            com.obric.memorydata.awareness.cae.b.a r7 = com.obric.memorydata.awareness.cae.b.f8563a.g();
            f r4 = this.f8585a;
            if (Intrinsics.areEqual(Thread.currentThread(), f.a(r4).getLooper().getThread()) == true) goto L9;
            f.a(r4).post((Runnable) ZeusTransformUtils.preCheckCast(new b("aoi company exit", r4, r15, r6, r7), Runnable.class, "com.obric.memorydata.plugin"));
            return;
        L9:
            if (f.d(r4) == true) goto L12;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HomeCompanyStatePredict", "ignore aoi company exit: predict disabled", false, 4, null);
            com.obric.memorydata.awareness.cae.b.f8563a.a("aoi company exit ignored: predict disabled");
            return;
        L12:
            if (com.obric.memorydata.awareness.cae.b.f8563a.b() == true) goto L14;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HomeCompanyStatePredict", "位置基线尚未完成，忽略 HC AOI 公司离开预测", false, 4, null);
            return;
        L14:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HomeCompanyStatePredict", "exit aoi company geofence: " + r15, false, 4, null);
            f.a(r4, r6);
            f.a(r4, false, r15, r7);
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/obric/memorydata/awareness/cae/HomeCompanyStatePredict$homeCompanyFenceChangeListener$1", "Lcom/obric/memorydata/awareness/cae/GeoFenceListener;", "onGeoFenceEntered", "", "fenceId", "", "onGeoFenceExited", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class h implements com.obric.memorydata.awareness.cae.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f8590a;

        h(f r1) {
            this.f8590a = r1;
        }

        @Override // com.obric.memorydata.awareness.cae.d
        public void a(String r9) {
            Intrinsics.checkNotNullParameter(r9, "fenceId");
            if (f.f(this.f8590a) == true) goto L6;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HomeCompanyStatePredict", "位置基线尚未完成，忽略 HC 实时进入预测，fenceId=" + r9, false, 4, null);
            return;
        L6:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HomeCompanyStatePredict", "enter geofence: " + r9 + ", registerWifiInfoCallback", false, 4, null);
            String r10 = f.c(this.f8590a, r9);
            f.a(this.f8590a, null, 1, null);
            this.f8590a.a().a((com.obric.memorydata.awareness.cae.j) ZeusTransformUtils.preCheckCast(f.g(this.f8590a), com.obric.memorydata.awareness.cae.j.class, "com.obric.memorydata.plugin"), true);
            f.a(this.f8590a, true, r10);
            f.b(this.f8590a, true, r10);
        }

        @Override // com.obric.memorydata.awareness.cae.d
        public void b(String r10) {
            Intrinsics.checkNotNullParameter(r10, "fenceId");
            if (f.f(this.f8590a) == true) goto L6;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HomeCompanyStatePredict", "位置基线尚未完成，忽略 HC 实时离开预测，fenceId=" + r10, false, 4, null);
            return;
        L6:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HomeCompanyStatePredict", "exit geofence " + r10, false, 4, null);
            String r11 = f.c(this.f8590a, r10);
            f.a(this.f8590a, null, 1, null);
            if (f.h() != null) goto L9;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HomeCompanyStatePredict", "unregisterWifiInfoCallback", false, 4, null);
            this.f8590a.a().a((com.obric.memorydata.awareness.cae.j) ZeusTransformUtils.preCheckCast(f.g(this.f8590a), com.obric.memorydata.awareness.cae.j.class, "com.obric.memorydata.plugin"), false);
        L9:
            f.a(this.f8590a, false, r11);
            f.b(this.f8590a, false, r11);
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007H\u0016J<\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\b2\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007H\u0016¨\u0006\r"}, d2 = {"com/obric/memorydata/awareness/cae/HomeCompanyStatePredict$observeHomeGpsFenceList$2$1", "Lcom/obric/memorydata/awareness/api/EventListener;", "onEvent", "", "eventName", "", WsConstants.KEY_EXTRA, "", "", "onFeatureChanged", "feature", "oldValue", "newValue", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class i implements com.obric.memorydata.awareness.api.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f8591a;

        i(f r1) {
            this.f8591a = r1;
        }

        private static final void a(Object r6, Object r7, f r8) {
            String r0 = null;
            if (r6 == null) goto L5;
            String r9 = r6.toString();
        L6:
            if (r7 == null) goto L9;
            r0 = r7.toString();
        L9:
            if (Intrinsics.areEqual(r9, r0) == false) goto L12;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HomeCompanyStatePredict", "home gps fence list feature unchanged, skip refresh", false, 4, null);
            return;
        L12:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HomeCompanyStatePredict", "home gps fence list feature changed", false, 4, null);
            f.e(r8);
            return;
        L5:
            r9 = null;
            goto L6
        }

        public static /* synthetic */ void lambda$XpnajctYl1vvL989LTJNpzxPVTI(Object r0, Object r1, f r2) {
            a(r0, r1, r2);
        }

        @Override // com.obric.memorydata.awareness.api.a
        public void a(String r3, final Object r4, final Object r5, Map<String, ? extends Object> r6) {
            Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "feature");
            Handler r8 = f.a(this.f8591a);
            final f r2 = this.f8591a;
            r8.post(new $$Lambda$f$i$XpnajctYl1vvL989LTJNpzxPVTI(r4, r5, r2));
        }

        @Override // com.obric.memorydata.awareness.api.a
        public void a(String r2, Map<String, ? extends Object> r3) {
            Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r2, "eventName");
        }

        @Override // com.obric.memorydata.awareness.api.a
        public boolean a() {
            return com.obric.memorydata.awareness.api.a.C0430a.a(this);
        }

        @Override // com.obric.memorydata.awareness.api.a
        public void b(String r3, Object r4, Object r5, Map<String, ? extends Object> r6) {
            com.obric.memorydata.awareness.api.a.C0430a.a(this, r3, r4, r5, (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007H\u0016J<\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\b2\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007H\u0016J<\u0010\r\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\b2\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007H\u0016¨\u0006\u000e"}, d2 = {"com/obric/memorydata/awareness/cae/HomeCompanyStatePredict$observerHomeAndCompanyLocation$featureEventListener$1", "Lcom/obric/memorydata/awareness/api/EventListener;", "onEvent", "", "eventName", "", WsConstants.KEY_EXTRA, "", "", "onFeatureChanged", "feature", "oldValue", "newValue", "onFeatureEvent", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class j implements com.obric.memorydata.awareness.api.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f8592a;

        j(f r1) {
            this.f8592a = r1;
        }

        @Override // com.obric.memorydata.awareness.api.a
        public void a(String r3, Object r4, Object r5, Map<String, ? extends Object> r6) {
            Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "feature");
            f.a(this.f8592a, r3, r4, r5);
        }

        @Override // com.obric.memorydata.awareness.api.a
        public void a(String r2, Map<String, ? extends Object> r3) {
            Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r2, "eventName");
        }

        @Override // com.obric.memorydata.awareness.api.a
        public boolean a() {
            return com.obric.memorydata.awareness.api.a.C0430a.a(this);
        }

        @Override // com.obric.memorydata.awareness.api.a
        public void b(String r3, Object r4, Object r5, Map<String, ? extends Object> r6) {
            Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "feature");
            f.b(this.f8592a, r3, r4, r5);
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007H\u0016J<\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\b2\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007H\u0016¨\u0006\r"}, d2 = {"com/obric/memorydata/awareness/cae/HomeCompanyStatePredict$observerHomeCompanyStateChange$listener$1", "Lcom/obric/memorydata/awareness/api/EventListener;", "onEvent", "", "eventName", "", WsConstants.KEY_EXTRA, "", "", "onFeatureChanged", "feature", "oldValue", "newValue", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class k implements com.obric.memorydata.awareness.api.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f8593a;

        k(f r1) {
            this.f8593a = r1;
        }

        @Override // com.obric.memorydata.awareness.api.a
        public void a(String r1, Object r2, Object r3, Map<String, ? extends Object> r4) {
            Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r1, "feature");
        }

        @Override // com.obric.memorydata.awareness.api.a
        public void a(String r9, Map<String, ? extends Object> r10) {
            Map r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r9, "eventName");
            d r12 = f.a(this.f8593a, r9);
            if (r12 != null) goto L5;
            return;
        L5:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HomeCompanyStatePredict", "handle home company context event: " + r9, false, 4, null);
            Settings.Global.putString(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_USER_LOCATION_STATE, r12.a());
            Settings.Global.putString(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_USER_LOCATION_CHANGE, r12.b());
            com.obric.memorydata.awareness.cae.a r8 = this.f8593a.a();
            if (r12.c() == false) goto L8;
            int r13 = 1;
        L9:
            r8.b(r13);
            return;
        L8:
            r13 = 2;
            goto L9
        }

        @Override // com.obric.memorydata.awareness.api.a
        public boolean a() {
            return com.obric.memorydata.awareness.api.a.C0430a.a(this);
        }

        @Override // com.obric.memorydata.awareness.api.a
        public void b(String r3, Object r4, Object r5, Map<String, ? extends Object> r6) {
            com.obric.memorydata.awareness.api.a.C0430a.a(this, r3, r4, r5, (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/obric/memorydata/awareness/cae/HomeCompanyStatePredict$predictDailyCallback$1", "Lcom/obric/memorydata/middleware/api/bdtracker/DailyReportCallback;", "onDailyReport", "", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class l implements com.obric.memorydata.middleware.api.bdtracker.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f8594a;

        l(f r1) {
            this.f8594a = r1;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // com.obric.memorydata.middleware.api.bdtracker.a
        public void a() {
            JSONObject r0 = new JSONObject();
            r0.put("state", f.d(this.f8594a) ? 1 : 0);
            Tracker.INSTANCE.reportEvent("predict_home_company_enable", r0);
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007H\u0016J<\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\b2\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007H\u0016¨\u0006\r"}, d2 = {"com/obric/memorydata/awareness/cae/HomeCompanyStatePredict$registerHomeCompanyStateChangeTracker$listener$1", "Lcom/obric/memorydata/awareness/api/EventListener;", "onEvent", "", "eventName", "", WsConstants.KEY_EXTRA, "", "", "onFeatureChanged", "feature", "oldValue", "newValue", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class m implements com.obric.memorydata.awareness.api.a {
        m() {
        }

        @Override // com.obric.memorydata.awareness.api.a
        public void a(String r1, Object r2, Object r3, Map<String, ? extends Object> r4) {
            Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r1, "feature");
        }

        @Override // com.obric.memorydata.awareness.api.a
        public void a(String r2, Map<String, ? extends Object> r3) {
            Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r2, "eventName");
            JSONObject r4 = new JSONObject();
            r4.put("event_name", r2);
            if (r1 == null) goto L5;
            r4.put(TrackerImpl.PARAMS, new JSONObject(r1).toString());
        L5:
            Tracker.INSTANCE.reportEvent("hc_feature_change", r4);
        }

        @Override // com.obric.memorydata.awareness.api.a
        public boolean a() {
            return com.obric.memorydata.awareness.api.a.C0430a.a(this);
        }

        @Override // com.obric.memorydata.awareness.api.a
        public void b(String r3, Object r4, Object r5, Map<String, ? extends Object> r6) {
            com.obric.memorydata.awareness.api.a.C0430a.a(this, r3, r4, r5, (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007H\u0016J<\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\b2\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007H\u0016¨\u0006\r"}, d2 = {"com/obric/memorydata/awareness/cae/HomeCompanyStatePredict$registerLeavingHomeOrCompanyCallback$listener$1", "Lcom/obric/memorydata/awareness/api/EventListener;", "onEvent", "", "eventName", "", WsConstants.KEY_EXTRA, "", "", "onFeatureChanged", "feature", "oldValue", "newValue", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class n implements com.obric.memorydata.awareness.api.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f8595a;

        n(f r1) {
            this.f8595a = r1;
        }

        private static final void b() {
            LocationSnapshot.INSTANCE.getLocation(0);
        }

        public static /* synthetic */ void lambda$RSIAzIOr8Py38bEzGfND5MH9Wu8() {
            b();
        }

        @Override // com.obric.memorydata.awareness.api.a
        public void a(String r1, Object r2, Object r3, Map<String, ? extends Object> r4) {
            Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r1, "feature");
        }

        @Override // com.obric.memorydata.awareness.api.a
        public void a(String r7, Map<String, ? extends Object> r8) {
            Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, "eventName");
            d r10 = f.a(this.f8595a, r7);
            if (r10 != null) goto L6;
            return;
        L6:
            if (r10.c() == false) goto L8;
            return;
        L8:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HomeCompanyStatePredict", "receive leaving home or company context event: " + r7, false, 4, null);
            f.a(this.f8595a).postDelayed($$Lambda$f$n$RSIAzIOr8Py38bEzGfND5MH9Wu8.INSTANCE, 60000);
        }

        @Override // com.obric.memorydata.awareness.api.a
        public boolean a() {
            return com.obric.memorydata.awareness.api.a.C0430a.a(this);
        }

        @Override // com.obric.memorydata.awareness.api.a
        public void b(String r3, Object r4, Object r5, Map<String, ? extends Object> r6) {
            com.obric.memorydata.awareness.api.a.C0430a.a(this, r3, r4, r5, (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class o<T> implements Comparator {
        public o() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r2, Map.Entry.class, "com.obric.memorydata.plugin")).getKey(), String.class, "com.obric.memorydata.plugin"), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.memorydata.plugin")).getKey(), String.class, "com.obric.memorydata.plugin"), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u0018\u0010\t\u001a\u00020\u00032\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¨\u0006\u0011"}, d2 = {"com/obric/memorydata/awareness/cae/HomeCompanyStatePredict$wifiInfoChangeCallback$1", "Lcom/obric/memorydata/awareness/cae/WifiInfoChangeCallback;", "onWifiScanInfoChanged", "", "results", "", "Lcom/obric/cae/libs/useraware/WifiStandardData;", "onWifiConnectInfoChanged", "info", "onWifiRomingChanged", "aps", "onWifiNetworkAvailable", "available", "", "onWifiSignalSuddenChangeEvent", "event", "", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class p implements com.obric.memorydata.awareness.cae.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f8596a;

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
        public static final class a<T> implements Comparator {
            public a() {
            }

            @Override // java.util.Comparator
            public final int compare(T r3, T r4) {
                WifiStandardData r2 = (WifiStandardData) ZeusTransformUtils.preCheckCast(r4, WifiStandardData.class, "com.obric.memorydata.plugin");
                Integer r5 = null;
                if (r2 == null) goto L5;
                Integer r6 = Integer.valueOf(r2.getRssi());
            L6:
                Comparable r7 = (Comparable) ZeusTransformUtils.preCheckCast(r6, Comparable.class, "com.obric.memorydata.plugin");
                WifiStandardData r8 = (WifiStandardData) ZeusTransformUtils.preCheckCast(r3, WifiStandardData.class, "com.obric.memorydata.plugin");
                if (r8 == null) goto L10;
                r5 = Integer.valueOf(r8.getRssi());
            L10:
                return ComparisonsKt.compareValues(r7, (Comparable) ZeusTransformUtils.preCheckCast(r5, Comparable.class, "com.obric.memorydata.plugin"));
            L5:
                r6 = null;
                goto L6
            }
        }

        p(f r1) {
            this.f8596a = r1;
        }

        private static final void a(f r12, p r13, WifiStandardData r14) {
            if (f.f(r12) == true) goto L6;
            f.m(r12);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HomeCompanyStatePredict", "位置基线尚未完成，忽略 HC Wi-Fi 连接变化", false, 4, null);
            return;
        L6:
            ConnectWifiInfoSummary r15 = f.n(r12);
            if (r15 != null) goto L9;
        L23:
            f.a(r12, f.a(r12, r14));
        L24:
            f.o(r12).a(f.b(r12, r14));
            Set r16 = f.h(r12);
            String r17 = r14.getBssid();
            if (r17 != null) goto L27;
            r17 = "";
        L27:
            r16.add(r17);
            return;
        L9:
            if (Intrinsics.areEqual(r15.getBssid(), r14.getBssid()) == true) goto L11;
        L21:
            RunLog.INSTANCE.debug("HomeCompanyStatePredict", "wifi changed: " + r15);
            WifiListDao r0 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getWifiListDao();
            long r5 = r15.getLastTimestamp();
            String r8 = f.i(r12).toJson(r15);
            Intrinsics.checkNotNullExpressionValue(r8, "toJson(...)");
            jk r11 = new jk(0, r5, 2, r8, 1, null);
        L22:
            r0.insert(r11);
            goto L23
        L11:
            if (Intrinsics.areEqual(r15.getSsid(), r14.getSsid()) == false) goto L21;
            long r2 = r14.getTimestamp();
            if ((r14.getUseTime() - r15.getUseTime()) <= TimeUnit.SECONDS.toMillis(60)) goto L15;
        L20:
            r0 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getWifiListDao();
            long r6 = r15.getLastTimestamp();
            String r9 = f.i(r12).toJson(r15);
            Intrinsics.checkNotNullExpressionValue(r9, "toJson(...)");
            r11 = new jk(0, r6, 2, r9, 1, null);
            goto L22
        L15:
            if ((r2 - r15.getLastTimestamp()) > 1100) goto L17;
        L19:
            r15.setRssi(ArraysKt.plus(r15.getRssi(), r14.getRssi()));
            r15.setLastTimestamp(r14.getTimestamp());
            goto L24
        L17:
            if (r15.getLastTimestamp() == 0) goto L19;
            goto L19
        }

        private static final void a(f r18, List r19) {
            List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.memorydata.plugin");
            if (f.f(r18) == true) goto L6;
            f.a(r18, null);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HomeCompanyStatePredict", "位置基线尚未完成，忽略 HC Wi-Fi 扫描预测", false, 4, null);
            return;
        L6:
            List r3 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
            Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin");
            Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
            Iterator r7 = r5.iterator();
        L8:
            if (r7.hasNext() == false) goto L19;
            Object r8 = r7.next();
            WifiStandardData r9 = (WifiStandardData) ZeusTransformUtils.preCheckCast(r8, WifiStandardData.class, "com.obric.memorydata.plugin");
            boolean r10 = true;
            if (r9 == null) goto L16;
            String r11 = r9.getSsid();
            if (r11 == null) goto L16;
            if (at.a(r11) != true) goto L16;
        L17:
            if (r10 == false) goto L8;
            r6.add(r8);
        L16:
            r10 = false;
            goto L17
        L19:
            Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new a(), Comparator.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L21:
            if (r12.hasNext() == false) goto L36;
            WifiStandardData r13 = (WifiStandardData) ZeusTransformUtils.preCheckCast(r12.next(), WifiStandardData.class, "com.obric.memorydata.plugin");
            if (r13 == null) goto L21;
            String r14 = r13.getBssid();
            if (r14 == null) goto L21;
            String r15 = r13.getSsid();
            if (r15 != null) goto L30;
            r15 = "";
        L30:
            ScanWIfiInfo r16 = new ScanWIfiInfo(r15, r14, r13.getRssi(), r13.getFrequency(), r13.getApStandard());
            if (f.h(r18).contains(r14) == true) goto L32;
            if (r3.size() >= 30) goto L21;
        L32:
            r3.add(r16);
            goto L21
        L36:
            WifiStandardData r2 = (WifiStandardData) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r1), WifiStandardData.class, "com.obric.memorydata.plugin");
            if (r2 == null) goto L39;
            long r17 = r2.getTimestamp();
        L40:
            long r110 = r17;
            f.a(r18, new Pair(Long.valueOf(r110), r3));
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HomeCompanyStatePredict", "onWifiScanInfoChanged wifInfo", false, 4, null);
            WifiListDao r4 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getWifiListDao();
            String r111 = f.i(r18).toJson(r3);
            Intrinsics.checkNotNullExpressionValue(r111, "toJson(...)");
            r4.insert(new jk(0, r110, 1, r111, 1, null));
            if (f.j(r18) == false) goto L44;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HomeCompanyStatePredict", "skip wifi predict for aoi company, needWifiScan=" + f.k(r18), false, 4, null);
        L43:
            f.a(r18, null);
            return;
        L44:
            JSONObject r20 = f.l(r18);
            if (r20 == null) goto L63;
            f.a(r18, r20);
            goto L43
        L63:
            return;
        L39:
            r17 = System.currentTimeMillis();
            goto L40
        }

        private static final void a(f r12, boolean r13) {
            if (f.f(r12) == true) goto L6;
            f.m(r12);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HomeCompanyStatePredict", "位置基线尚未完成，忽略 HC Wi-Fi 网络变化", false, 4, null);
            return;
        L6:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HomeCompanyStatePredict", "onWifiNetworkAvailable " + r13, false, 4, null);
            if (Intrinsics.areEqual(f.p(r12), Boolean.valueOf(r13)) == true) goto L18;
            if (r13 == true) goto L12;
            ConnectWifiInfoSummary r0 = f.n(r12);
            if (r0 == null) goto L12;
            RunLog.INSTANCE.debug("HomeCompanyStatePredict", "insert wifiInfo onWifiNetworkAvailable " + r0);
            WifiListDao r1 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getWifiListDao();
            long r5 = r0.getLastTimestamp();
            String r8 = f.i(r12).toJson(r0);
            Intrinsics.checkNotNullExpressionValue(r8, "toJson(...)");
            r1.insert(new jk(0, r5, 2, r8, 1, null));
        L12:
            WifiListDao r2 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getWifiListDao();
            long r4 = System.currentTimeMillis();
            if (r13 == false) goto L15;
            int r3 = 2;
        L16:
            r2.insert(new jk(0, r4, r3, "", 1, null));
            f.a(r12, Boolean.valueOf(r13));
            f.a(r12, null);
            f.o(r12).b();
            return;
        L15:
            r3 = 3;
            goto L16
        }

        public static /* synthetic */ void lambda$2ZTnFYV3nspEF7_P6hXKTuc1A6s(f r0, p r1, WifiStandardData r2) {
            a(r0, r1, r2);
        }

        /* JADX INFO: renamed from: lambda$AjdwsuWcB3RYZPYZc0Y-vtv_w5g, reason: not valid java name */
        public static /* synthetic */ void m496lambda$AjdwsuWcB3RYZPYZc0Yvtv_w5g(f r0, boolean r1) {
            a(r0, r1);
        }

        public static /* synthetic */ void lambda$K1_P8Qt73QP0C6eOXWdtxBcBtsw(f r0, List r1) {
            a(r0, r1);
        }

        @Override // com.obric.memorydata.awareness.cae.j
        public void a(final WifiStandardData r4) {
            Intrinsics.checkNotNullParameter(r4, "info");
            Handler r0 = f.a(this.f8596a);
            final f r1 = this.f8596a;
            r0.post(new $$Lambda$f$p$2ZTnFYV3nspEF7_P6hXKTuc1A6s(r1, this, r4));
        }

        @Override // com.obric.memorydata.awareness.cae.j
        public void a(List<? extends WifiStandardData> r3) {
            final List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "results");
            Handler r0 = f.a(this.f8596a);
            final f r2 = this.f8596a;
            r0.post(new $$Lambda$f$p$K1_P8Qt73QP0C6eOXWdtxBcBtsw(r2, r4));
        }

        @Override // com.obric.memorydata.awareness.cae.j
        public void a(final boolean r3) {
            Handler r0 = f.a(this.f8596a);
            final f r2 = this.f8596a;
            r0.post(new $$Lambda$f$p$AjdwsuWcB3RYZPYZc0Yvtv_w5g(r2, r3));
        }
    }

    static {
        f8574a = new a(null);
        D = MapsKt.mapOf(new Pair[]{TuplesKt.to(EventNames.ARRIVE_HOME, new d("at_home", UserAwareUtil.CHANGE_INTO_HOME, true)), TuplesKt.to(EventNames.LEAVE_HOME, new d(UserAwareUtil.CHANGE_OUT_HOME, UserAwareUtil.CHANGE_OUT_HOME, false)), TuplesKt.to(EventNames.ARRIVE_COMPANY, new d("at_company", UserAwareUtil.CHANGE_INTO_COMPANY, true)), TuplesKt.to(EventNames.LEAVE_COMPANY, new d(UserAwareUtil.CHANGE_OUT_COMPANY, UserAwareUtil.CHANGE_OUT_COMPANY, false))});
        F = kotlinx.coroutines.flow.at.a("");
        G = new f();
    }

    public f() {
        this.f8575b = com.obric.memorydata.awareness.cae.a.f8559a.a();
        this.c = new c(20);
        this.e = am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"));
        this.f = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null);
        this.g = LazyKt.lazy($$Lambda$f$TK33NHHXsTGqVDHs4XrYlM8NXUY.INSTANCE);
        this.h = new GsonBuilder().registerTypeAdapterFactory((TypeAdapterFactory) ZeusTransformUtils.preCheckCast(new WIfiTypeAdapterFactory(), TypeAdapterFactory.class, "com.obric.memorydata.plugin")).create();
        this.j = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        this.n = kotlinx.coroutines.flow.at.a(false);
        this.o = kotlinx.coroutines.flow.at.a(false);
        this.p = kotlinx.coroutines.flow.at.a(false);
        this.v = true;
        this.z = new l(this);
        this.A = (com.obric.memorydata.awareness.cae.d) ZeusTransformUtils.preCheckCast(new h(this), com.obric.memorydata.awareness.cae.d.class, "com.obric.memorydata.plugin");
        this.B = (com.obric.memorydata.awareness.cae.d) ZeusTransformUtils.preCheckCast(new g(this), com.obric.memorydata.awareness.cae.d.class, "com.obric.memorydata.plugin");
        this.C = new p(this);
    }

    private final void A() {
        if (this.r == false) goto L5;
        return;
    L5:
        this.r = true;
        i().post(new $$Lambda$f$ytR87sjy4u42XznmKAAvUNBJmI(this));
        com.obric.memorydata.utils.j.a(new $$Lambda$f$4LGjLyIWfbA_9nuVJ2DPraQxl7I(this));
    }

    private final void B() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HomeCompanyStatePredict", "registerFenceIfNeed", false, 4, null);
        if (this.u == true) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HomeCompanyStatePredict", "registerFenceIfNeed skipped: predict disabled", false, 4, null);
        return;
    L6:
        boolean r1 = true;
        if (((Boolean) ZeusTransformUtils.preCheckCast(com.obric.memorydata.awareness.cae.b.f8563a.d().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L19;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HomeCompanyStatePredict", "registerFenceIfNeed skipped: geofence service not ready", false, 4, null);
        if (this.u == false) goto L21;
        bx r0 = this.y;
        if (r0 != null) goto L13;
    L15:
        r1 = false;
    L16:
        if (r1 == true) goto L22;
        this.y = kotlinx.coroutines.i.a(this.e, null, null, (Function2) ZeusTransformUtils.preCheckCast(new HomeCompanyStatePredict$registerFenceIfNeedInternal$1(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return;
    L22:
        return;
    L13:
        if (r0.a() != true) goto L15;
    L21:
        return;
    L19:
        this.y = null;
        C();
        D();
        J();
        a(this, null, 1, null);
    }

    private final void C() {
        boolean r2 = true;
        if (a(this, null, 1, null) == false) goto L5;
        return;
    L5:
        I();
        UserProfileGpsPoint r1 = UserProfileLabel.INSTANCE.queryGpsPointOf(ProfileLabel.HOME_GPS);
        IRunLog r6 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r3 = new StringBuilder().append("家围栏位置是否有效：");
        if (r1 != null) goto L9;
        r2 = false;
    L9:
        IRunLog.a.a(r6, "HomeCompanyStatePredict", r3.append(r2).toString(), false, 4, null);
        if (r1 != null) goto L18;
        com.obric.memorydata.awareness.cae.b.f8563a.c("home_fence");
        return;
    L18:
        com.obric.memorydata.awareness.cae.b.a(com.obric.memorydata.awareness.cae.b.f8563a, "home_fence", r1.getLongitude(), r1.getLatitude(), a(r1.getRadiusM()), 0, this.A, 16, null);     // Catch: UnsupportedOperationException -> L15
        return;
    L15:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HomeCompanyStatePredict", "注册家围栏监听失败：" + e, null, 4, null);
        com.bytedance.services.apm.api.a.a("addGeofence UnsupportedOperationException");
    }

    private final void D() {
        UserProfileGpsPoint r0 = UserProfileLabel.INSTANCE.queryGpsPointOf(ProfileLabel.COMPANY_GPS);
        IRunLog r4 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r1 = new StringBuilder().append("公司围栏位置是否有效：");
        if (r0 == null) goto L5;
        boolean r2 = true;
    L6:
        IRunLog.a.a(r4, "HomeCompanyStatePredict", r1.append(r2).toString(), false, 4, null);
        if (r0 != null) goto L15;
        com.obric.memorydata.awareness.cae.b.f8563a.c("company_fence");
        return;
    L15:
        com.obric.memorydata.awareness.cae.b.a(com.obric.memorydata.awareness.cae.b.f8563a, "company_fence", r0.getLongitude(), r0.getLatitude(), a(r0.getRadiusM()), 0, this.A, 16, null);     // Catch: UnsupportedOperationException -> L12
        return;
    L12:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HomeCompanyStatePredict", "注册公司围栏监听失败：" + e, null, 4, null);
        com.bytedance.services.apm.api.a.a("addGeofence UnsupportedOperationException");
        return;
    L5:
        r2 = false;
        goto L6
    }

    private final void E() {
        F();
        f();
    }

    private final void F() {
        int r0 = G().size();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HomeCompanyStatePredict", "updateHomeGpsFenceListAvailable count=" + r0, false, 4, null);
        ae<Boolean> r10 = this.p;
    L3:
        Boolean r1 = r10.c();
        ((Boolean) ZeusTransformUtils.preCheckCast(r1, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        if (r0 <= 0) goto L6;
        boolean r2 = true;
    L8:
        if (r10.a(r1, Boolean.valueOf(r2)) == false) goto L3;
        return;
    L6:
        r2 = false;
        goto L8
    }

    private final List<e> G() {
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(UserProfileLabel.INSTANCE.queryHomeGpsFenceList(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        e r3 = a((UserProfileGpsPoint) ZeusTransformUtils.preCheckCast(r2.next(), UserProfileGpsPoint.class, "com.obric.memorydata.plugin"));
        if (r3 == null) goto L4;
        r1.add(r3);
        goto L4
    L8:
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        HashSet r5 = new HashSet();
        ArrayList r6 = new ArrayList();
        Iterator r7 = r4.iterator();
    L10:
        if (r7.hasNext() == false) goto L15;
        Object r8 = r7.next();
        if (r5.add(a((e) ZeusTransformUtils.preCheckCast(r8, e.class, "com.obric.memorydata.plugin"))) == false) goto L10;
        r6.add(r8);
        goto L10
    L15:
        return (List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin");
    }

    private final List<StarGeofence> H() {
        return com.obric.memorydata.awareness.cae.b.f8563a.d("home_fence_");
    }

    private final int I() {
        this.t = null;
        return com.obric.memorydata.awareness.cae.b.f8563a.e("home_fence_");
    }

    private final void J() {
        List<String> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        String r1 = this.f.getString("save_home_bssid", "");
        RunLog.INSTANCE.debug("HomeCompanyStatePredict", "homeBssid: " + r1);
        boolean r5 = true;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L8;
        r0.add(r1);
    L8:
        String r2 = this.f.getString("save_company_bssid", "");
        RunLog.INSTANCE.debug("HomeCompanyStatePredict", "companyBssid: " + r2);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).length() > 0) goto L12;
        r5 = false;
    L12:
        if (r5 == false) goto L14;
        r0.add(r2);
    L14:
        r0.addAll((Collection) ZeusTransformUtils.preCheckCast(UserProfileLabel.INSTANCE.queryHomeBssid(), Collection.class, "com.obric.memorydata.plugin"));
        r0.addAll((Collection) ZeusTransformUtils.preCheckCast(UserProfileLabel.INSTANCE.queryCompanyBssid(), Collection.class, "com.obric.memorydata.plugin"));
        this.f8575b.b(r0);
        return;
    L5:
        r3 = false;
        goto L6
    }

    private final JSONObject K() {
        IRunLog r3 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = new StringBuilder().append("createPredictArgs currentFence: ");
        StarGeofence r1 = E;
        List r9 = null;
        if (r1 == null) goto L5;
        String r2 = r1.getGeofenceId();
    L6:
        IRunLog.a.a(r3, "HomeCompanyStatePredict", r0.append(r2).toString(), false, 4, null);
        StarGeofence r4 = E;
        if (r4 == null) goto L11;
        String r5 = r4.getGeofenceId();
        if (r5 == null) goto L11;
        String r6 = g(r5);
    L12:
        if (r4 == null) goto L30;
        if (r6 == null) goto L30;
        b r7 = e(r6);
        if (r7 != null) goto L18;
        return null;
    L18:
        JSONObject r8 = new JSONObject();
        Pair<Long, ? extends List<ScanWIfiInfo>> r10 = this.d;
        if (r10 == null) goto L21;
        long r11 = ((Number) ZeusTransformUtils.preCheckCast(r10.getFirst(), Number.class, "com.obric.memorydata.plugin")).longValue();
    L22:
        r8.put("scan_wifi_list_time", r11);
        Gson r12 = this.h;
        Pair<Long, ? extends List<ScanWIfiInfo>> r13 = this.d;
        if (r13 == null) goto L25;
        r9 = (List) ZeusTransformUtils.preCheckCast(r13.getSecond(), List.class, "com.obric.memorydata.plugin");
    L25:
        String r14 = r12.toJson(r9);
        if (r14 != null) goto L28;
        r14 = "";
    L28:
        r8.put(LocationMonitorConst.SCAN_WIFI_LIST, r14);
        r8.put("fence_id", r6);
        r8.put("fence_time", r4.getEventTimestamp());
        r8.put("mode", "predict_model");
        a(r8, r7);
        return r8;
    L21:
        r11 = 0;
    L30:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HomeCompanyStatePredict", "createPredictArgs inFence is null", null, 4, null);
        return null;
    L11:
        r6 = null;
        goto L12
    L5:
        r2 = null;
        goto L6
    }

    private static final Handler L() {
        HandlerThread r0 = new HandlerThread("home_company_state_predict");
        r0.start();
        return new Handler(r0.getLooper());
    }

    private final int a(Double r1) {
        if (r1 != null) goto L6;
        return ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION;
    L6:
        return MathKt.roundToInt(r1.doubleValue());
    }

    private final long a(double r3) {
        return MathKt.roundToLong(r3 * ((double) 10000));
    }

    public static final /* synthetic */ Handler a(f r0) {
        return r0.i();
    }

    public static final /* synthetic */ d a(f r0, String r1) {
        return r0.c(r1);
    }

    private final e a(UserProfileGpsPoint r9) {
        return new e(r9.getLongitude(), r9.getLatitude(), a(r9.getRadiusM()), r9.isOfficialHome());
    }

    public static final /* synthetic */ C0433f a(f r0, JSONObject r1) {
        return r0.a(r1);
    }

    private final C0433f a(JSONObject r11) {
        Boolean r0 = null;
        if (t() == true) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HomeCompanyStatePredict", "位置基线尚未完成，拦截 HC 实时预测任务", false, 4, null);
        return new C0433f(null);
    L6:
        TaskResult r10 = ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder("home_company").setInputParam(r11), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).execute();
        if (r10.getCode() != 0) goto L36;
        JSONObject r12 = r10.getOutput().optJSONObject("predictResult");
        if (r12 == null) goto L11;
        String r2 = r12.optString("state_change");
    L12:
        if (r12 == null) goto L14;
        String r13 = r12.optString("state");
    L16:
        if (r10.getOutput().has("need_wifi_scan") == true) goto L18;
    L20:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HomeCompanyStatePredict", "predictResult  stateChange: " + r2 + "  state: " + r13 + " needWifiScan: " + r0, false, 4, null);
        String r14 = r10.getOutput().optString(AwareStateListener.SETTINGS_GLOBAL_USER_LEARNING_PROGRESS, "");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HomeCompanyStatePredict", "predict progress: " + r14, false, 4, null);
        Intrinsics.checkNotNull(r14);
        int r4 = 0;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L23;
        boolean r3 = true;
    L24:
        if (r3 == false) goto L26;
        Settings.Global.putString(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_USER_LEARNING_PROGRESS, r14);
    L26:
        ArrayList r15 = new ArrayList();
        JSONArray r5 = r10.getOutput().optJSONArray("indoor_ap_list");
        RunLog.INSTANCE.debug("HomeCompanyStatePredict", "indoorList is " + r5);
        if (r5 == null) goto L37;
        int r6 = r5.length();
    L29:
        if (r4 >= r6) goto L35;
        r15.add(r5.getString(r4));     // Catch: JSONException -> L32
    L34:
        r4 = r4 + 1;
    L32:
        e = move-exception;
        RunLog.INSTANCE.error("HomeCompanyStatePredict", "indoorList getString error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        goto L34
    L35:
        G.f8575b.a((List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.memorydata.plugin"));
    L37:
        ae<String> r16 = F;
    L38:
        String r7 = r16.c();
        String r8 = (String) ZeusTransformUtils.preCheckCast(r7, String.class, "com.obric.memorydata.plugin");
        if (r16.a(r7, com.obric.memorydata.utils.b.c(r10.getOutput())) == false) goto L38;
        return new C0433f(r0);
    L23:
        r3 = false;
        goto L24
    L18:
        if (r10.getOutput().isNull("need_wifi_scan") == true) goto L20;
        r0 = Boolean.valueOf(r10.getOutput().optBoolean("need_wifi_scan"));
        goto L20
    L14:
        r13 = null;
        goto L16
    L11:
        r2 = null;
        goto L12
    L36:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HomeCompanyStatePredict", "[code=home_company_predict_failed] predict failed, resultCode=" + r10.getCode(), null, 4, null);
        goto L37
    }

    private final ConnectWifiInfoSummary a(WifiStandardData r13) {
        String r0 = r13.getSsid();
        if (r0 != null) goto L5;
        String r2 = "";
    L6:
        String r1 = r13.getBssid();
        if (r1 != null) goto L9;
        String r3 = "";
    L10:
        boolean r5 = false;
        int[] r4 = {r13.getRssi()};
        int r6 = r13.getFrequency();
        if (r13.getApType() != 1) goto L14;
        r5 = true;
    L14:
        return new ConnectWifiInfoSummary(r2, r3, r4, r6, r5, r13.getUseTime(), r13.getApStandard(), r13.getTimestamp());
    L9:
        r3 = r1;
        goto L10
    L5:
        r2 = r0;
        goto L6
    }

    public static final /* synthetic */ ConnectWifiInfoSummary a(f r0, WifiStandardData r1) {
        return r0.a(r1);
    }

    private static final CharSequence a(Map.Entry r5) {
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r5, Map.Entry.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<destruct>");
        String r0 = (String) ZeusTransformUtils.preCheckCast(r6.getKey(), String.class, "com.obric.memorydata.plugin");
        e r7 = (e) ZeusTransformUtils.preCheckCast(r6.getValue(), e.class, "com.obric.memorydata.plugin");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r0 + ':' + r7.a() + ':' + r7.b() + ':' + r7.c() + ':' + r7.d(), CharSequence.class, "com.obric.memorydata.plugin");
    }

    private final String a(e r4) {
        if (r4.d() == false) goto L6;
        return "home_fence";
    L6:
        return "home_fence_" + a(r4.a()) + '_' + a(r4.b());
    }

    private static final Unit a(LiveData r2, final f r3) {
        r2.observeForever((Observer) ZeusTransformUtils.preCheckCast(new HomeCompanyStatePredict$sam$androidx_lifecycle_Observer$0(new $$Lambda$f$wMMe7vJivE1Xk8qOei2B3HvVGuE(r3)), Observer.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    private static final Unit a(final f r1, cl r2) {
        if (r2 == null) goto L5;
        r1.i().post(new $$Lambda$f$bPkkG8JZqx5AT6jkJhC0nUq_FY4(r1));
    L5:
        return Unit.INSTANCE;
    }

    private static final Unit a(final f r2, final je r3) {
        r2.i().post(new $$Lambda$f$OZZugCOQn80aR71cUcRY6aViM4I(r3, r2));
        return Unit.INSTANCE;
    }

    static /* synthetic */ JSONObject a(f r0, boolean r1, String r2, com.obric.memorydata.awareness.cae.b.a r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = r0.h(r2);
    L6:
        return r0.b(r1, r2, r3);
    }

    private final void a(StarGeofence r7) {
        E = b(r7);
        IRunLog r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r6 = new StringBuilder().append("currentFence = ");
        StarGeofence r8 = E;
        if (r8 == null) goto L5;
        String r9 = r8.getGeofenceId();
    L6:
        IRunLog.a.a(r0, "HomeCompanyStatePredict", r6.append(r9).toString(), false, 4, null);
        return;
    L5:
        r9 = null;
        goto L6
    }

    private final void a(com.obric.memorydata.awareness.api.a r4) {
        com.obric.memorydata.awareness.api.a r3 = (com.obric.memorydata.awareness.api.a) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.memorydata.awareness.api.a.class, "com.obric.memorydata.plugin");
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(D.keySet(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.memorydata.plugin");
        AwarenessManager.INSTANCE.registerAwarenessEvent(r1, r3);
        goto L4
    }

    public static final /* synthetic */ void a(f r0, StarGeofence r1) {
        r0.a(r1);
    }

    static /* synthetic */ void a(f r0, StarGeofence r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = com.obric.memorydata.awareness.cae.b.f8563a.f();
    L5:
        r0.a(r1);
    }

    public static final /* synthetic */ void a(f r0, ConnectWifiInfoSummary r1) {
        r0.i = r1;
    }

    public static final /* synthetic */ void a(f r0, Boolean r1) {
        r0.k = r1;
    }

    public static final /* synthetic */ void a(f r0, String r1, Object r2, Object r3) {
        r0.a(r1, r2, r3);
    }

    private static final void a(f r12, String r13, boolean r14) {
        if (r12.t() == true) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HomeCompanyStatePredict", "位置基线尚未完成，取消 HC 围栏预测，fenceId=" + r13, false, 4, null);
        return;
    L6:
        JSONObject r0 = a(r12, r14, r13, null, 4, null);
        if (r14 == true) goto L11;
        b r2 = r12.e(r13);
        if (r2 == null) goto L11;
        r12.a(r0, r2);
    L11:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HomeCompanyStatePredict", "notifyPredict enter is: " + r14 + ", fenceId: " + r13, false, 4, null);
        r12.a(r0);
    }

    public static final /* synthetic */ void a(f r0, Pair r1) {
        r0.d = r1;
    }

    public static final /* synthetic */ void a(f r2, bx r3) {
        r2.y = (bx) ZeusTransformUtils.wrapperContextForParams(r3, bx.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ void a(f r0, boolean r1, String r2) {
        r0.b(r1, r2);
    }

    public static final /* synthetic */ void a(f r0, boolean r1, String r2, com.obric.memorydata.awareness.cae.b.a r3) {
        r0.a(r1, r2, r3);
    }

    private static final void a(je r7, f r8) {
        if (r7 == null) goto L4;
        String r9 = r7.b();
    L6:
        if (Intrinsics.areEqual(r8.s, r9) == false) goto L9;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HomeCompanyStatePredict", "home gps fence list profile unchanged, skip refresh", false, 4, null);
        return;
    L9:
        r8.s = r9;
        IRunLog r1 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = new StringBuilder().append("home gps fence list profile changed, hasValue=");
        if (r9 == null) goto L12;
        boolean r10 = true;
    L13:
        IRunLog.a.a(r1, "HomeCompanyStatePredict", r0.append(r10).toString(), false, 4, null);
        r8.E();
        return;
    L12:
        r10 = false;
        goto L13
    L4:
        r9 = null;
        goto L6
    }

    private final void a(String r7, Object r8, Object r9) {
        if (Intrinsics.areEqual(r8, r9) == true) goto L5;
        return;
    L5:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HomeCompanyStatePredict", "家公司围栏参数变化，重新注册围栏，feature=" + r7, false, 4, null);
        f();
    }

    private final void a(JSONObject r3, b r4) {
        r3.put("connect_list", this.h.toJson(this.c.a()));
        r3.put("bssid", this.h.toJson(r4.a()));
        r3.put("bssid_hash", this.h.toJson(r4.b()));
    }

    private final void a(JSONObject r2, String r3, com.obric.memorydata.awareness.cae.b.a r4) {
        if (Intrinsics.areEqual(r3, "company_fence") == true) goto L5;
        return;
    L5:
        if (r4 != null) goto L7;
        return;
    L7:
        JSONObject r1 = new JSONObject();
        r1.put("type", r4.getType());
        r1.put("radius", r4.a());
        Unit r5 = Unit.INSTANCE;
        r2.put("aoi_info", r1);
    }

    private final void a(final boolean r3, final String r4) {
        i().post(new $$Lambda$f$HwTJb8AgSLquT65AQNWoeBwUJUg(this, r4, r3));
    }

    private final void a(boolean r10, String r11, com.obric.memorydata.awareness.cae.b.a r12) {
        if (t() == true) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HomeCompanyStatePredict", "位置基线尚未完成，取消 HC AOI 围栏预测，fenceId=" + r11, false, 4, null);
        return;
    L6:
        JSONObject r13 = b(r10, r11, r12);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HomeCompanyStatePredict", "notifyAoiPredict enter is: " + r10 + ", fenceId: " + r11, false, 4, null);
        if (r10 == false) goto L9;
        this.v = true;
    L9:
        C0433f r14 = a(r13);
        if (r10 == true) goto L12;
        this.v = true;
        if (E != null) goto L21;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HomeCompanyStatePredict", "unregisterWifiInfoCallback", false, 4, null);
        this.f8575b.a((com.obric.memorydata.awareness.cae.j) ZeusTransformUtils.preCheckCast(this.C, com.obric.memorydata.awareness.cae.j.class, "com.obric.memorydata.plugin"), false);
    L21:
        if (this.w == false) goto L23;
        b(false, r11);
        return;
    L23:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HomeCompanyStatePredict", "skip aoi company native exit: enter not notified", false, 4, null);
        return;
    L12:
        if (Intrinsics.areEqual(r14.a(), false) == false) goto L16;
        this.v = false;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HomeCompanyStatePredict", "aoi predict no need wifi scan", false, 4, null);
        if (y() == false) goto L25;
        this.f8575b.a((com.obric.memorydata.awareness.cae.j) ZeusTransformUtils.preCheckCast(this.C, com.obric.memorydata.awareness.cae.j.class, "com.obric.memorydata.plugin"), false);
        return;
    L25:
        return;
    L16:
        this.v = true;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HomeCompanyStatePredict", "aoi predict keep wifi scan, needWifiScan=" + r14.a(), false, 4, null);
        this.f8575b.a((com.obric.memorydata.awareness.cae.j) ZeusTransformUtils.preCheckCast(this.C, com.obric.memorydata.awareness.cae.j.class, "com.obric.memorydata.plugin"), true);
        b(true, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ boolean a(f r2, Map r3, int r4, Object r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        if ((r4 & 1) == 0) goto L10;
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r2.G(), Iterable.class, "com.obric.memorydata.plugin");
        Map r8 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r7, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r9 = r7.iterator();
    L6:
        if (r9.hasNext() == false) goto L8;
        Object r10 = r9.next();
        r8.put(r2.a((e) ZeusTransformUtils.preCheckCast(r10, e.class, "com.obric.memorydata.plugin")), r10);
        goto L6
    L8:
        r6 = r8;
    L10:
        return r2.a(r6);
    }

    private final synchronized boolean a(Map<String, e> r24) {
        monitor-enter(this);
        Map<String, e> r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r24, Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L53
        boolean r4 = false;
        if (r0.isEmpty() == false) goto L9;
        this.t = null;     // Catch: Throwable -> L53
        monitor-exit(this);
        return false;
    L9:
        Set<String> r2 = r0.keySet();     // Catch: Throwable -> L53
        String r5 = b(r0);     // Catch: Throwable -> L53
        if (Intrinsics.areEqual(this.t, r5) == false) goto L17;
        if (a(r2) == false) goto L17;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HomeCompanyStatePredict", "syncHomeGpsFenceListFences skipped: unchanged desired=" + r0.size(), false, 4, null);     // Catch: Throwable -> L53
        monitor-exit(this);
        return true;
    L17:
        if (r2.contains("home_fence") == true) goto L19;
        boolean r6 = true;
    L20:
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(H(), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L53
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L53
        Iterator r10 = r8.iterator();     // Catch: Throwable -> L53
    L22:
        if (r10.hasNext() == false) goto L26;
        Object r11 = r10.next();     // Catch: Throwable -> L53
        if (r2.contains(((StarGeofence) ZeusTransformUtils.preCheckCast(r11, StarGeofence.class, "com.obric.memorydata.plugin")).getGeofenceId()) == true) goto L22;
        r9.add(r11);     // Catch: Throwable -> L53
        goto L22
    L26:
        List r3 = (List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L53
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HomeCompanyStatePredict", "syncHomeGpsFenceListFences desired=" + r0.size() + ", obsolete=" + r3.size() + ", removeHomeFence=" + r6, false, 4, null);     // Catch: Throwable -> L53
        Iterator<Map.Entry<String, e>> r12 = r0.entrySet().iterator();     // Catch: Throwable -> L53
        int r13 = 0;
    L28:
        if (r12.hasNext() == false) goto L33;
        Map.Entry r14 = (Map.Entry) ZeusTransformUtils.preCheckCast(r12.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L53
        String r15 = (String) ZeusTransformUtils.preCheckCast(r14.getKey(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L53
        e r16 = (e) ZeusTransformUtils.preCheckCast(r14.getValue(), e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L53
        if (com.obric.memorydata.awareness.cae.b.a(com.obric.memorydata.awareness.cae.b.f8563a, r15, r16.a(), r16.b(), r16.c(), 0, this.A, 16, null) == false) goto L31;
        r13 = r13 + 1;     // Catch: Throwable -> L53
        goto L28
    L31:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HomeCompanyStatePredict", "add home gps fence list geofence failed: " + r15, null, 4, null);     // Catch: Throwable -> L53
        goto L28
    L33:
        if (r6 == true) goto L35;
    L37:
        int r7 = 0;
    L38:
        Iterator r17 = ((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L53
    L40:
        if (r17.hasNext() == false) goto L44;
        StarGeofence r18 = (StarGeofence) ZeusTransformUtils.preCheckCast(r17.next(), StarGeofence.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L53
        com.obric.memorydata.awareness.cae.b r19 = com.obric.memorydata.awareness.cae.b.f8563a;     // Catch: Throwable -> L53
        String r20 = r18.getGeofenceId();     // Catch: Throwable -> L53
        Intrinsics.checkNotNullExpressionValue(r20, "getGeofenceId(...)");     // Catch: Throwable -> L53
        if (r19.c(r20) == false) goto L40;
        r7 = r7 + 1;     // Catch: Throwable -> L53
        goto L40
    L44:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HomeCompanyStatePredict", "syncHomeGpsFenceListFences removed obsolete=" + r7, false, 4, null);     // Catch: Throwable -> L53
        if (r13 != r0.size()) goto L47;
        this.t = r5;     // Catch: Throwable -> L53
    L48:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HomeCompanyStatePredict", "syncHomeGpsFenceListFences success=" + r13, false, 4, null);     // Catch: Throwable -> L53
        if (r13 <= 0) goto L51;
        r4 = true;
    L51:
        monitor-exit(this);
        return r4;
    L47:
        this.t = null;     // Catch: Throwable -> L53
        goto L48
    L35:
        if (com.obric.memorydata.awareness.cae.b.f8563a.c("home_fence") == false) goto L37;
        r7 = 1;
        goto L38
    L19:
        r6 = false;
    L53:
        th = move-exception;
        throw th;
    }

    private final boolean a(Set<String> r6) {
        Set r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r6, Set.class, "com.obric.memorydata.plugin");
        Set r0 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        if (com.obric.memorydata.awareness.cae.b.f8563a.f("home_fence") == null) goto L5;
        r0.add("home_fence");
    L5:
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(H(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r8 = r5.iterator();
    L7:
        if (r8.hasNext() == false) goto L9;
        r2.add(((StarGeofence) ZeusTransformUtils.preCheckCast(r8.next(), StarGeofence.class, "com.obric.memorydata.plugin")).getGeofenceId());
        goto L7
    L9:
        r0.addAll((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin"));
        return Intrinsics.areEqual(r0, r7);
    }

    private final StarGeofence b(StarGeofence r15) {
        StarGeofence r3 = com.obric.memorydata.awareness.cae.b.f8563a.f("home_fence");
        IRunLog r4 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = new StringBuilder().append("homeFence status = ");
        StarGeofence.GeoState r1 = null;
        if (r3 == null) goto L5;
        StarGeofence.GeoState r5 = r3.getGeoState();
    L6:
        IRunLog.a.a(r4, "HomeCompanyStatePredict", r0.append(r5).toString(), false, 4, null);
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(H(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L8:
        if (r14.hasNext() == false) goto L15;
        Object r2 = r14.next();
        if (((StarGeofence) ZeusTransformUtils.preCheckCast(r2, StarGeofence.class, "com.obric.memorydata.plugin")).getGeoState() != StarGeofence.GeoState.INSIDE) goto L12;
        boolean r6 = true;
    L13:
        if (r6 == false) goto L8;
    L16:
        StarGeofence r16 = (StarGeofence) ZeusTransformUtils.preCheckCast(r2, StarGeofence.class, "com.obric.memorydata.plugin");
        IRunLog r7 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r8 = new StringBuilder().append("extraHomeFence status = ");
        if (r16 == null) goto L19;
        StarGeofence.GeoState r9 = r16.getGeoState();
    L20:
        IRunLog.a.a(r7, "HomeCompanyStatePredict", r8.append(r9).toString(), false, 4, null);
        StarGeofence r10 = com.obric.memorydata.awareness.cae.b.f8563a.f("company_fence");
        IRunLog r11 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r12 = new StringBuilder().append("companyFence status = ");
        if (r10 == null) goto L23;
        StarGeofence.GeoState r13 = r10.getGeoState();
    L24:
        IRunLog.a.a(r11, "HomeCompanyStatePredict", r12.append(r13).toString(), false, 4, null);
        IRunLog r17 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r18 = new StringBuilder().append("transportHubCompanyFence status = ");
        if (r15 == null) goto L27;
        r1 = r15.getGeoState();
    L27:
        IRunLog.a.a(r17, "HomeCompanyStatePredict", r18.append(r1).toString(), false, 4, null);
        if (com.obric.memorydata.awareness.cae.b.f8563a.h() == true) goto L32;
        if (r15 != null) goto L32;
        boolean r19 = false;
    L33:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HomeCompanyStatePredict", "companyFenceHandledByTransportHubAoi = " + r19, false, 4, null);
        return com.obric.memorydata.awareness.cae.e.f8573a.a(r3, r16, r10, r15, r19);
    L32:
        r19 = true;
        goto L33
    L23:
        r13 = null;
        goto L24
    L19:
        r9 = null;
        goto L20
    L12:
        r6 = false;
        goto L13
    L15:
        r2 = null;
        goto L16
    L5:
        r5 = null;
        goto L6
    }

    private final ConnectWifiInfo b(WifiStandardData r10) {
        String r0 = r10.getSsid();
        if (r0 != null) goto L5;
        String r2 = "";
    L6:
        String r1 = r10.getBssid();
        if (r1 != null) goto L9;
        String r3 = "";
    L10:
        int r4 = r10.getRssi();
        int r5 = r10.getFrequency();
        long r6 = r10.getTimestamp();
        if (r10.getApType() != 1) goto L13;
        boolean r8 = true;
    L15:
        return new ConnectWifiInfo(r2, r3, r4, r5, r6, r8, r10.getApStandard());
    L13:
        r8 = false;
        goto L15
    L9:
        r3 = r1;
        goto L10
    L5:
        r2 = r0;
        goto L6
    }

    public static final /* synthetic */ ConnectWifiInfo b(f r0, WifiStandardData r1) {
        return r0.b(r1);
    }

    private final String b(Map<String, e> r11) {
        return CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast(((Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.memorydata.plugin")).entrySet(), Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new o(), Comparator.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("|", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$f$liF4v4mXBCgGon1b_KrLhCedWXk.INSTANCE, 30, null);
    }

    private final JSONObject b(boolean r4, String r5, com.obric.memorydata.awareness.cae.b.a r6) {
        JSONObject r0 = new JSONObject();
        if (r4 == false) goto L5;
        String r1 = "into_fence";
    L6:
        r0.put("mode", r1);
        r0.put("fence_id", r5);
        if (r4 == false) goto L9;
        a(r0, r5, r6);
    L9:
        return r0;
    L5:
        r1 = "out_fence";
        goto L6
    }

    private final void b(com.obric.memorydata.awareness.api.a r4) {
        com.obric.memorydata.awareness.api.a r3 = (com.obric.memorydata.awareness.api.a) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.memorydata.awareness.api.a.class, "com.obric.memorydata.plugin");
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(D.keySet(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.memorydata.plugin");
        AwarenessManager.INSTANCE.unregisterAwarenessEvent(r1, r3);
        goto L4
    }

    public static final /* synthetic */ void b(f r0) {
        r0.r();
    }

    public static final /* synthetic */ void b(f r0, String r1) {
        r0.b(r1);
    }

    public static final /* synthetic */ void b(f r0, String r1, Object r2, Object r3) {
        r0.b(r1, r2, r3);
    }

    public static final /* synthetic */ void b(f r0, boolean r1, String r2) {
        r0.a(r1, r2);
    }

    private final void b(final String r3) {
        i().post(new $$Lambda$f$cQpQmdrBbww4T1MOms5nRBtNsg0(this, r3));
    }

    private final void b(String r9, Object r10, Object r11) {
        if (Intrinsics.areEqual(r10, r11) == false) goto L5;
        return;
    L5:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HomeCompanyStatePredict", "家公司位置变化，更新状态并刷新围栏，feature=" + r9, false, 4, null);
        if (r11 != null) goto L8;
    L12:
        boolean r12 = false;
    L14:
        if (Intrinsics.areEqual(r9, "location_home_gps") == false) goto L17;
        this.n.b(Boolean.valueOf(r12));
    L22:
        f();
        return;
    L17:
        if (Intrinsics.areEqual(r9, "location_company_gps") == false) goto L22;
        this.o.b(Boolean.valueOf(r12));
        com.obric.memorydata.awareness.cae.b.f8563a.a("company location changed");
        f();
        if (r12 == false) goto L24;
        com.obric.memorydata.awareness.cae.b.f8563a.b("company location changed");
        return;
    L24:
        return;
    L8:
        if (ZeusTransformUtils.instanceOf(r11, List.class) == false) goto L12;
        if (((List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.memorydata.plugin")).size() != 2) goto L12;
        r12 = true;
        goto L14
    }

    private final void b(boolean r7, String r8) {
        if (t() == true) goto L7;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HomeCompanyStatePredict", "位置基线尚未完成，不通知 CAE 实时围栏变化，fenceId=" + r8, false, 4, null);
        return;
    L7:
        if (r7 == false) goto L15;
        if (Intrinsics.areEqual(r8, "home_fence") == false) goto L12;
        this.f8575b.a(1);
        return;
    L12:
        if (Intrinsics.areEqual(r8, "company_fence") == false) goto L22;
        this.f8575b.a(3);
        this.w = true;
        return;
    L22:
        return;
    L15:
        if (Intrinsics.areEqual(r8, "home_fence") == false) goto L18;
        this.f8575b.a(2);
        return;
    L18:
        if (Intrinsics.areEqual(r8, "company_fence") == false) goto L25;
        this.f8575b.a(4);
        this.w = false;
        return;
    }

    private final d c(String r2) {
        return (d) ZeusTransformUtils.preCheckCast(D.get(r2), d.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ String c(f r0, String r1) {
        return r0.g(r1);
    }

    public static final /* synthetic */ void c(f r0) {
        r0.s();
    }

    private final Pair<Double, Double> d(String r5) {
        Object r4 = FeatureManager.INSTANCE.getFeature(r5);
        if (ZeusTransformUtils.instanceOf(r4, List.class) == false) goto L5;
        List r6 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin");
    L6:
        if (r6 != null) goto L9;
        return null;
    L9:
        if (r6.size() == 2) goto L11;
        return null;
    L11:
        Object r7 = r6.get(0);
        if (ZeusTransformUtils.instanceOf(r7, Number.class) == false) goto L14;
        Number r8 = (Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.memorydata.plugin");
    L15:
        if (r8 == null) goto L23;
        double r2 = r8.doubleValue();
        Object r9 = r6.get(1);
        if (ZeusTransformUtils.instanceOf(r9, Number.class) == false) goto L19;
        Number r10 = (Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.memorydata.plugin");
    L20:
        if (r10 == null) goto L23;
        return TuplesKt.to(Double.valueOf(r2), Double.valueOf(r10.doubleValue()));
    L19:
        r10 = null;
    L23:
        return null;
    L14:
        r8 = null;
        goto L15
    L5:
        r6 = null;
        goto L6
    }

    private static final void d(f r7, String r8) {
        if (r7.t() == true) goto L6;
        r7.u();
        r7.f8575b.a((com.obric.memorydata.awareness.cae.j) ZeusTransformUtils.preCheckCast(r7.C, com.obric.memorydata.awareness.cae.j.class, "com.obric.memorydata.plugin"), false);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HomeCompanyStatePredict", "HC Wi-Fi 预测保持停止，reason=" + r8, false, 4, null);
        return;
    L6:
        String r0 = null;
        a(r7, null, 1, null);
        if (E != null) goto L11;
        r7.f8575b.a((com.obric.memorydata.awareness.cae.j) ZeusTransformUtils.preCheckCast(r7.C, com.obric.memorydata.awareness.cae.j.class, "com.obric.memorydata.plugin"), false);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HomeCompanyStatePredict", "当前不在家司围栏内，不启动 HC Wi-Fi 预测，reason=" + r8, false, 4, null);
        return;
    L11:
        if (r7.y() == false) goto L14;
        r7.f8575b.a((com.obric.memorydata.awareness.cae.j) ZeusTransformUtils.preCheckCast(r7.C, com.obric.memorydata.awareness.cae.j.class, "com.obric.memorydata.plugin"), false);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HomeCompanyStatePredict", "AOI 公司由位置基线直接确认，不启动 HC Wi-Fi 预测", false, 4, null);
        return;
    L14:
        r7.f8575b.a((com.obric.memorydata.awareness.cae.j) ZeusTransformUtils.preCheckCast(r7.C, com.obric.memorydata.awareness.cae.j.class, "com.obric.memorydata.plugin"), true);
        IRunLog r1 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r9 = new StringBuilder().append("位置基线已完成，启动 HC Wi-Fi 预测，fenceId=");
        StarGeofence r2 = E;
        if (r2 == null) goto L17;
        r0 = r2.getGeofenceId();
    L17:
        IRunLog.a.a(r1, "HomeCompanyStatePredict", r9.append(r0).append("，reason=").append(r8).toString(), false, 4, null);
    }

    public static final /* synthetic */ boolean d(f r0) {
        return r0.u;
    }

    private final b e(String r11) {
        List<String> r12 = f(r11);
        Integer r0 = null;
        if (r12 != null) goto L5;
        return null;
    L5:
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r2 = r1.iterator();
    L7:
        if (r2.hasNext() == false) goto L9;
        r3.add(Integer.valueOf(((String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin")).hashCode()));
        goto L7
    L9:
        List r4 = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin");
        IRunLog r5 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r6 = new StringBuilder().append("wifi cache size: ");
        Pair<Long, ? extends List<ScanWIfiInfo>> r10 = this.d;
        if (r10 == null) goto L14;
        List r13 = (List) ZeusTransformUtils.preCheckCast(r10.getSecond(), List.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L14;
        r0 = Integer.valueOf(r13.size());
    L14:
        IRunLog.a.a(r5, "HomeCompanyStatePredict", r6.append(r0).toString(), false, 4, null);
        return new b(r12, r4);
    }

    public static final /* synthetic */ void e(f r0) {
        r0.E();
    }

    private final List<String> f(String r15) {
        if (Intrinsics.areEqual(r15, "home_fence") == false) goto L6;
        List<String> r1 = UserProfileLabel.INSTANCE.queryHomeBssid();
    L9:
        if (r1.isEmpty() == true) goto L11;
        return r1;
    L11:
        if (Intrinsics.areEqual(r15, "home_fence") == false) goto L25;
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(this.f.getString("save_home_bssid", ""), CharSequence.class, "com.obric.memorydata.plugin"), new String[]{","}, false, 0, 6, null), Iterable.class, "com.obric.memorydata.plugin");
        Collection r16 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r17 = r14.iterator();
    L14:
        if (r17.hasNext() == false) goto L21;
        Object r0 = r17.next();
        if (((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L18;
        boolean r2 = true;
    L19:
        if (r2 == false) goto L14;
        r16.add(r0);
        goto L14
    L18:
        r2 = false;
        goto L19
    L21:
        List<String> r18 = (List) ZeusTransformUtils.preCheckCast(r16, List.class, "com.obric.memorydata.plugin");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r18, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L52;
        return r1;
    L52:
        return r18;
    L25:
        if (Intrinsics.areEqual(r15, "company_fence") == false) goto L53;
        Iterable r19 = (Iterable) ZeusTransformUtils.preCheckCast(StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(this.f.getString("save_company_bssid", ""), CharSequence.class, "com.obric.memorydata.plugin"), new String[]{","}, false, 0, 6, null), Iterable.class, "com.obric.memorydata.plugin");
        Collection r110 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r111 = r19.iterator();
    L28:
        if (r111.hasNext() == false) goto L35;
        Object r3 = r111.next();
        if (((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L32;
        boolean r4 = true;
    L33:
        if (r4 == false) goto L28;
        r110.add(r3);
        goto L28
    L32:
        r4 = false;
        goto L33
    L35:
        r18 = (List) ZeusTransformUtils.preCheckCast(r110, List.class, "com.obric.memorydata.plugin");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r18, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L52;
        return r1;
    L53:
        return r1;
    L6:
        if (Intrinsics.areEqual(r15, "company_fence") == false) goto L39;
        r1 = UserProfileLabel.INSTANCE.queryCompanyBssid();
        goto L9
    L39:
        return null;
    }

    public static final /* synthetic */ boolean f(f r0) {
        return r0.t();
    }

    public static final /* synthetic */ p g(f r0) {
        return r0.C;
    }

    public static final /* synthetic */ f g() {
        return G;
    }

    private final String g(String r4) {
        if (StringsKt.startsWith$default(r4, "home_fence_", false, 2, null) == false) goto L6;
        return "home_fence";
    L6:
        return r4;
    }

    public static final /* synthetic */ StarGeofence h() {
        return E;
    }

    private final com.obric.memorydata.awareness.cae.b.a h(String r1) {
        if (Intrinsics.areEqual(r1, "company_fence") == true) goto L7;
        return null;
    L7:
        return com.obric.memorydata.awareness.cae.b.f8563a.g();
    }

    public static final /* synthetic */ Set h(f r0) {
        return r0.j;
    }

    private final Handler i() {
        return (Handler) ZeusTransformUtils.preCheckCast(this.g.getValue(), Handler.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ Gson i(f r0) {
        return r0.h;
    }

    private final void j() {
        Object r8 = FeatureManager.INSTANCE.getFeature("HOME_GPS_FENCE_LIST");
        if (r8 != null) goto L5;
        return;
    L5:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HomeCompanyStatePredict", "restore HOME_GPS_FENCE_LIST feature", false, 4, null);
        FeatureManager.INSTANCE.setFeature("HOME_GPS_FENCE_LIST", r8, null);
    }

    public static final /* synthetic */ boolean j(f r0) {
        return r0.x();
    }

    private final void k() {
        n r0 = new n(this);
        Iterator<Map.Entry<String, d>> r5 = D.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.memorydata.plugin");
        if (((d) ZeusTransformUtils.preCheckCast(r1.getValue(), d.class, "com.obric.memorydata.plugin")).c() == true) goto L4;
        AwarenessManager.INSTANCE.registerAwarenessEvent(r2, (com.obric.memorydata.awareness.api.a) ZeusTransformUtils.preCheckCast(r0, com.obric.memorydata.awareness.api.a.class, "com.obric.memorydata.plugin"));
        goto L4
    }

    public static final /* synthetic */ boolean k(f r0) {
        return r0.v;
    }

    public static final /* synthetic */ JSONObject l(f r0) {
        return r0.K();
    }

    private final void l() {
        final LiveData<cl> r0 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getLocationDao().queryLastRecordLiveData();
        com.obric.memorydata.utils.j.a(new $$Lambda$f$jMtOwbU09POIDD9wVzrq9SADqk(r0, this));
    }

    public static /* synthetic */ Unit lambda$4LGjLyIWfbA_9nuVJ2DPraQxl7I(f r0) {
        return s(r0);
    }

    public static /* synthetic */ Unit lambda$7vBg7Uf_o7EEuX23iM9a2WCuY5c(f r0, je r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ void lambda$HwTJb8AgSLquT65AQNWoeBwUJUg(f r0, String r1, boolean r2) {
        a(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$OZZugCOQn80aR71cUcRY6aViM4I(je r0, f r1) {
        a(r0, r1);
    }

    public static /* synthetic */ Handler lambda$TK33NHHXsTGqVDHs4XrYlM8NXUY() {
        return L();
    }

    public static /* synthetic */ void lambda$bPkkG8JZqx5AT6jkJhC0nUq_FY4(f r0) {
        q(r0);
    }

    public static /* synthetic */ void lambda$cQpQmdrBbww4T1MOms5nRBtNsg0(f r0, String r1) {
        d(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$jMtOwbU09P-OIDD9wVzrq9SADqk, reason: not valid java name */
    public static /* synthetic */ Unit m494lambda$jMtOwbU09POIDD9wVzrq9SADqk(LiveData r0, f r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ CharSequence lambda$liF4v4mXBCgGon1b_KrLhCedWXk(Map.Entry r0) {
        return a(r0);
    }

    public static /* synthetic */ Unit lambda$wMMe7vJivE1Xk8qOei2B3HvVGuE(f r0, cl r1) {
        return a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$ytR87s-jy4u42XznmKAAvUNBJmI, reason: not valid java name */
    public static /* synthetic */ void m495lambda$ytR87sjy4u42XznmKAAvUNBJmI(f r0) {
        r(r0);
    }

    private final void m() {
        Object r11 = FeatureManager.INSTANCE.getFeature("location_home_gps");
        Object r0 = FeatureManager.INSTANCE.getFeature("location_company_gps");
        boolean r1 = true;
        if (r11 != null) goto L5;
    L9:
        boolean r12 = false;
    L10:
        if (r0 != null) goto L12;
    L16:
        r1 = false;
    L17:
        if (r12 == false) goto L22;
        if (r1 == false) goto L22;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HomeCompanyStatePredict", "notifyLocationChangeToPackage: trigger calculate", false, 4, null);
        JSONObject r13 = new JSONObject();
        r13.put("trigger_source", "location_change");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HomeCompanyStatePredict", "notifyLocationChangeToPackage: task result: " + ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder("commute_track_and_check").setInputParam(r13), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).execute(), false, 4, null);
        return;
    L22:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HomeCompanyStatePredict", "notifyLocationChangeToPackage: home or company location not available", false, 4, null);
        return;
    L12:
        if (ZeusTransformUtils.instanceOf(r0, List.class) == false) goto L16;
        if (((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin")).size() != 2) goto L16;
    L5:
        if (ZeusTransformUtils.instanceOf(r11, List.class) == false) goto L9;
        if (((List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.memorydata.plugin")).size() != 2) goto L9;
        r12 = true;
        goto L10
    }

    public static final /* synthetic */ void m(f r0) {
        r0.u();
    }

    public static final /* synthetic */ ConnectWifiInfoSummary n(f r0) {
        return r0.i;
    }

    private final void n() {
        Object r0 = FeatureManager.INSTANCE.getFeature("location_home_gps");
        boolean r2 = true;
        if (r0 == null) goto L11;
        ae<Boolean> r6 = this.n;
        if (ZeusTransformUtils.instanceOf(r0, List.class) == true) goto L7;
    L9:
        boolean r1 = false;
    L10:
        r6.b(Boolean.valueOf(r1));
        goto L11
    L7:
        if (((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin")).size() != 2) goto L9;
        r1 = true;
    L11:
        Object r3 = FeatureManager.INSTANCE.getFeature("location_company_gps");
        if (r3 == null) goto L20;
        ae<Boolean> r7 = this.o;
        if (ZeusTransformUtils.instanceOf(r3, List.class) == true) goto L16;
    L18:
        r2 = false;
    L19:
        r7.b(Boolean.valueOf(r2));
        goto L20
    L16:
        if (((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin")).size() != 2) goto L18;
    L20:
        j r4 = new j(this);
        AwarenessManager.INSTANCE.registerAwarenessEvent("location_home_gps", (com.obric.memorydata.awareness.api.a) ZeusTransformUtils.preCheckCast(r4, com.obric.memorydata.awareness.api.a.class, "com.obric.memorydata.plugin"));
        AwarenessManager.INSTANCE.registerAwarenessEvent("location_company_gps", (com.obric.memorydata.awareness.api.a) ZeusTransformUtils.preCheckCast(r4, com.obric.memorydata.awareness.api.a.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ c o(f r0) {
        return r0.c;
    }

    private final void o() {
        if (this.x == null) goto L5;
        return;
    L5:
        m r0 = new m();
        a((com.obric.memorydata.awareness.api.a) ZeusTransformUtils.preCheckCast(r0, com.obric.memorydata.awareness.api.a.class, "com.obric.memorydata.plugin"));
        this.x = (com.obric.memorydata.awareness.api.a) ZeusTransformUtils.preCheckCast(r0, com.obric.memorydata.awareness.api.a.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ Boolean p(f r0) {
        return r0.k;
    }

    private final void p() {
        com.obric.memorydata.awareness.api.a r0 = this.x;
        if (r0 != null) goto L5;
        return;
    L5:
        b(r0);
        this.x = null;
    }

    private final void q() {
        kotlinx.coroutines.flow.i r0 = kotlinx.coroutines.flow.k.b((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(this.f8575b.b(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(com.obric.memorydata.awareness.cae.b.f8563a.d(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), (Function3) ZeusTransformUtils.preCheckCast(new HomeCompanyStatePredict$enablePredictAsNeeded$serviceState$1(null), Function3.class, "com.obric.memorydata.plugin"));
        kotlinx.coroutines.flow.k.b(kotlinx.coroutines.flow.k.f(r0, (Function2) ZeusTransformUtils.preCheckCast(new HomeCompanyStatePredict$enablePredictAsNeeded$1(this, null), Function2.class, "com.obric.memorydata.plugin")), this.e);
        kotlinx.coroutines.flow.k.b(kotlinx.coroutines.flow.k.f((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(com.obric.memorydata.awareness.cae.b.f8563a.a(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new HomeCompanyStatePredict$enablePredictAsNeeded$2(this, null), Function2.class, "com.obric.memorydata.plugin")), this.e);
        kotlinx.coroutines.flow.k.b(kotlinx.coroutines.flow.k.f(kotlinx.coroutines.flow.k.b(kotlinx.coroutines.flow.k.b(r0, kotlinx.coroutines.flow.k.b(kotlinx.coroutines.flow.k.b((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(this.n, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(this.o, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), (Function3) ZeusTransformUtils.preCheckCast(new HomeCompanyStatePredict$enablePredictAsNeeded$homeCompanyLocation$1(null), Function3.class, "com.obric.memorydata.plugin")), (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(this.p, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), (Function3) ZeusTransformUtils.preCheckCast(new HomeCompanyStatePredict$enablePredictAsNeeded$homeCompanyLocation$2(null), Function3.class, "com.obric.memorydata.plugin")), (Function3) ZeusTransformUtils.preCheckCast(new HomeCompanyStatePredict$enablePredictAsNeeded$3(null), Function3.class, "com.obric.memorydata.plugin"))), (Function2) ZeusTransformUtils.preCheckCast(new HomeCompanyStatePredict$enablePredictAsNeeded$4(this, null), Function2.class, "com.obric.memorydata.plugin")), this.e);
    }

    private static final void q(f r0) {
        r0.m();
    }

    private final void r() {
        if (this.u == false) goto L5;
        return;
    L5:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HomeCompanyStatePredict", "enablePredict", false, 4, null);
        this.u = true;
        Settings.Global.putInt(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_ENABLE_WIFI_SCAN_FUNCTION, 1);
        f();
        o();
        v();
        b("HC 预测功能已开启");
    }

    private static final void r(f r0) {
        r0.E();
    }

    private static final Unit s(final f r4) {
        AwarenessManager.INSTANCE.registerAwarenessEvent("HOME_GPS_FENCE_LIST", (com.obric.memorydata.awareness.api.a) ZeusTransformUtils.preCheckCast(new i(r4), com.obric.memorydata.awareness.api.a.class, "com.obric.memorydata.plugin"));
        MemoryDbEngine.INSTANCE.getPersonalDbEngine().getUserProfileDao().queryOneRecord(ProfileLabel.HOME_GPS_FENCE_LIST.toString()).observeForever((Observer) ZeusTransformUtils.preCheckCast(new HomeCompanyStatePredict$sam$androidx_lifecycle_Observer$0(new $$Lambda$f$7vBg7Uf_o7EEuX23iM9a2WCuY5c(r4)), Observer.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    private final void s() {
        if (this.u == true) goto L5;
        return;
    L5:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HomeCompanyStatePredict", "disablePredict", false, 4, null);
        this.u = false;
        u();
        this.f8575b.a((com.obric.memorydata.awareness.cae.j) ZeusTransformUtils.preCheckCast(this.C, com.obric.memorydata.awareness.cae.j.class, "com.obric.memorydata.plugin"), false);
        bx r1 = this.y;
        if (r1 == null) goto L8;
        bx.a.a(r1, null, 1, null);
    L8:
        this.y = null;
        Settings.Global.putInt(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_ENABLE_WIFI_SCAN_FUNCTION, 0);
        TaskRequest r0 = this.m;
        if (r0 == null) goto L11;
        r0.cancel();
    L11:
        this.t = null;
        com.obric.memorydata.awareness.cae.b.f8563a.c("home_fence");
        com.obric.memorydata.awareness.cae.b.f8563a.c("company_fence");
        I();
        p();
        w();
    }

    private final boolean t() {
        if (this.u == true) goto L5;
    L7:
        return false;
    L5:
        if (com.obric.memorydata.awareness.cae.b.f8563a.b() == false) goto L7;
        return true;
    }

    private final void u() {
        this.d = null;
        this.c.b();
        this.i = null;
        this.k = null;
    }

    private final void v() {
        if (this.q == null) goto L5;
        return;
    L5:
        k r0 = new k(this);
        a((com.obric.memorydata.awareness.api.a) ZeusTransformUtils.preCheckCast(r0, com.obric.memorydata.awareness.api.a.class, "com.obric.memorydata.plugin"));
        this.q = (com.obric.memorydata.awareness.api.a) ZeusTransformUtils.preCheckCast(r0, com.obric.memorydata.awareness.api.a.class, "com.obric.memorydata.plugin");
    }

    private final void w() {
        com.obric.memorydata.awareness.api.a r0 = this.q;
        if (r0 != null) goto L5;
        return;
    L5:
        b(r0);
        this.q = null;
    }

    private final boolean x() {
        if (y() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.v == true) goto L7;
        return true;
    }

    private final boolean y() {
        StarGeofence r1 = E;
        if (r1 == null) goto L5;
        String r2 = r1.getGeofenceId();
    L7:
        if (Intrinsics.areEqual(r2, "company_fence") == true) goto L11;
        return false;
    L11:
        return com.obric.memorydata.awareness.cae.b.f8563a.h();
    L5:
        r2 = null;
        goto L7
    }

    private final String z() {
        StarGeofence r0 = com.obric.memorydata.awareness.cae.b.f8563a.f("home_fence");
        if (r0 == null) goto L5;
        StarGeofence.GeoState r1 = r0.getGeoState();
    L7:
        if (r1 != StarGeofence.GeoState.INSIDE) goto L9;
        return "home_fence";
    L9:
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(H(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L11:
        if (r5.hasNext() == false) goto L18;
        Object r2 = r5.next();
        if (((StarGeofence) ZeusTransformUtils.preCheckCast(r2, StarGeofence.class, "com.obric.memorydata.plugin")).getGeoState() != StarGeofence.GeoState.INSIDE) goto L15;
        boolean r3 = true;
    L16:
        if (r3 == false) goto L11;
    L19:
        StarGeofence r6 = (StarGeofence) ZeusTransformUtils.preCheckCast(r2, StarGeofence.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L22;
        return null;
    L22:
        return r6.getGeofenceId();
    L15:
        r3 = false;
        goto L16
    L18:
        r2 = null;
        goto L19
    L5:
        r1 = null;
        goto L7
    }

    public final com.obric.memorydata.awareness.cae.a a() {
        return this.f8575b;
    }

    public final void a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "fenceId");
        b("家司围栏首次状态已建立，fenceId=" + r3);
    }

    public final com.obric.memorydata.awareness.cae.d b() {
        return this.A;
    }

    public final com.obric.memorydata.awareness.cae.d c() {
        return this.B;
    }

    public final void d() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HomeCompanyStatePredict", "init hasInit: " + this.l, false, 4, null);
        if (this.l == false) goto L5;
        return;
    L5:
        this.l = true;
        n();
        A();
        j();
        com.obric.memorydata.awareness.cae.b.f8563a.i();
        q();
        Tracker.INSTANCE.registerDailyReportCallback((com.obric.memorydata.middleware.api.bdtracker.a) ZeusTransformUtils.preCheckCast(this.z, com.obric.memorydata.middleware.api.bdtracker.a.class, "com.obric.memorydata.plugin"));
        l();
        k();
    }

    public final Pair<Double, Double> e() {
        String r0 = z();
        Pair<Double, Double> r1 = null;
        if (r0 == null) goto L20;
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(G(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L6:
        if (r3.hasNext() == false) goto L10;
        Object r4 = r3.next();
        if (Intrinsics.areEqual(a((e) ZeusTransformUtils.preCheckCast(r4, e.class, "com.obric.memorydata.plugin")), r0) == false) goto L6;
    L11:
        e r5 = (e) ZeusTransformUtils.preCheckCast(r4, e.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L18;
        Pair<Double, Double> r6 = TuplesKt.to(Double.valueOf(r5.a()), Double.valueOf(r5.b()));
        if (r6 == null) goto L18;
        r1 = r6;
    L18:
        if (Intrinsics.areEqual(r0, "home_fence") == false) goto L20;
        r1 = d("location_home_gps");
        goto L20
    L10:
        r4 = null;
    L20:
        IRunLog r2 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r8 = new StringBuilder().append("resolveAtHomeEventLocation fenceId=").append(r0).append(", hasLocation=");
        if (r1 == null) goto L23;
        boolean r7 = true;
    L24:
        IRunLog.a.a(r2, "HomeCompanyStatePredict", r8.append(r7).toString(), false, 4, null);
        return r1;
    L23:
        r7 = false;
        goto L24
    }

    public final void f() {
        B();
    }
}
