package com.obric.memorydata.recommend.settings;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.SystemClock;
import android.provider.Settings;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.constants.DevTrackerEventId;
import com.obric.memorydata.database.entity.LifelogEntity;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.memory.api.MemoryService;
import com.obric.memorydata.memory.api.MemoryTrackerOuter;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.settings.AppSettingsManager;
import com.obric.memorydata.middleware.api.settings.SettingsChangeListener;
import com.obric.memorydata.middleware.api.settings.SettingsManager;
import com.obric.memorydata.middleware.api.store.IStore;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.recommend.context.task.PendingAppTypeCheckTask;
import com.obric.memorydata.recommend.guide.ScreenObservationCategoryViewModel;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.task.scheduler.impl.ExistingTaskPolicy;
import com.obric.memorydata.utils.ah;
import com.obric.memorydata.utils.threadpool.ThreadPoolContainer;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.ae;
import kotlinx.coroutines.flow.ar;
import kotlinx.coroutines.flow.at;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000w\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u001b*\u0001;\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001rB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00050\u001dH\u0002J\b\u0010=\u001a\u00020>H\u0002J\u0006\u0010?\u001a\u00020>J\u000e\u0010@\u001a\u00020>2\u0006\u0010A\u001a\u000202J\u0006\u0010B\u001a\u00020>J\u0010\u0010C\u001a\u0002022\u0006\u0010D\u001a\u000202H\u0002J\b\u0010E\u001a\u000202H\u0002J\u000e\u0010F\u001a\u00020>2\u0006\u0010A\u001a\u000202J\u0016\u0010G\u001a\u00020>2\u0006\u0010H\u001a\u00020\u00052\u0006\u0010I\u001a\u000202J\u001c\u0010J\u001a\u00020>2\f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00050\u001d2\u0006\u0010I\u001a\u000202J\u000e\u0010K\u001a\u00020>2\u0006\u0010L\u001a\u000202J\u0006\u00107\u001a\u00020\u0013J\u000e\u0010M\u001a\u00020>2\u0006\u0010N\u001a\u00020\u0013J\f\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00050\u001dJ\u0016\u0010P\u001a\u00020>2\u0006\u0010Q\u001a\u00020\u00132\u0006\u0010R\u001a\u000202J\u0014\u0010P\u001a\u00020>2\f\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00050\u001dJ\u000e\u0010T\u001a\u00020>2\u0006\u0010U\u001a\u00020VJ\f\u0010W\u001a\b\u0012\u0004\u0012\u00020V0XJ\u0006\u0010Y\u001a\u000202J\u000e\u0010Z\u001a\u00020>2\u0006\u0010[\u001a\u000209J\u0006\u0010\\\u001a\u000209J\u0006\u0010]\u001a\u00020>J\u0006\u0010^\u001a\u000202J\u0006\u0010`\u001a\u000202J\u000e\u0010a\u001a\u00020>2\u0006\u0010I\u001a\u000202J\n\u0010b\u001a\u0004\u0018\u00010*H\u0002J\b\u0010c\u001a\u00020>H\u0002J\u000e\u0010d\u001a\b\u0012\u0004\u0012\u00020\u00050\u001dH\u0002J\u0016\u0010e\u001a\u00020>2\u0006\u0010f\u001a\u00020\u00182\u0006\u0010g\u001a\u000202J\u0010\u0010h\u001a\u00020>2\u0006\u0010H\u001a\u00020\u0005H\u0002J\u0010\u0010i\u001a\u00020>2\u0006\u0010H\u001a\u00020\u0005H\u0002J\u0010\u0010j\u001a\u00020>2\u0006\u0010H\u001a\u00020\u0005H\u0002J\u0006\u0010k\u001a\u00020>J\u0010\u0010l\u001a\u0002022\u0006\u0010H\u001a\u00020\u0005H\u0002J\u0010\u0010m\u001a\u00020>2\u0006\u0010n\u001a\u000209H\u0002J\u000e\u0010o\u001a\u0002022\u0006\u0010H\u001a\u00020\u0005J\f\u0010p\u001a\b\u0012\u0004\u0012\u00020\u00050\u001dJ\u0016\u0010q\u001a\u0002022\u0006\u0010H\u001a\u00020\u00052\u0006\u0010Q\u001a\u00020\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u001d0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u001d0\u001f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001a\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u001d0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u001d0\u001f¢\u0006\b\n\u0000\u001a\u0004\b$\u0010!R\u001a\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u001d0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u001d0\u001f¢\u0006\b\n\u0000\u001a\u0004\b'\u0010!R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00050,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00050,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00050\u001d8F¢\u0006\u0006\u001a\u0004\b/\u00100R\u0014\u00101\u001a\b\u0012\u0004\u0012\u0002020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u00103\u001a\b\u0012\u0004\u0012\u0002020\u001f¢\u0006\b\n\u0000\u001a\u0004\b4\u0010!R\u0014\u00105\u001a\b\u0012\u0004\u0012\u00020\u00130\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u00106\u001a\b\u0012\u0004\u0012\u00020\u00130\u001f¢\u0006\b\n\u0000\u001a\u0004\b7\u0010!R\u000e\u00108\u001a\u000209X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u00020;X\u0082\u0004¢\u0006\u0004\n\u0002\u0010<R\u0017\u0010_\u001a\b\u0012\u0004\u0012\u0002020\u001f8F¢\u0006\u0006\u001a\u0004\b^\u0010!¨\u0006s"}, d2 = {"Lcom/obric/memorydata/recommend/settings/ScreenObservationSettingsStore;", "", "<init>", "()V", "TAG", "", "RECOMMEND_SETTINGS_KEY", "LIFE_LOG_PACKAGENAME", "RECOMMEND_HAS_CONFIRM", "RECOMMEND_MEMORY_ENABLED", "SCREEN_OBSERVATION_CONFIGURED", "RECOMMEND_UNABLE_APPS", "RECOMMEND_ENABLE_CATEGORIES", "FUNCTION_CALL_HISTORY", "INIT_DISABLED_DOUBAO", "RESTORE_TIME", "NEW_MEMORY_SETTING", "PENDING_QUERY_APPS", "NEW_MEMORY_OPEN_ALL", "", "NEW_MEMORY_OPEN_CUSTOM", "NEW_MEMORY_OPEN_NONE", "enabledAppListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/obric/memorydata/recommend/settings/ScreenObservationSettingsStore$EnabledAppListener;", "ALIASED_PACKAGE_MAP", "", "_ignorePackages", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "ignorePackages", "Lkotlinx/coroutines/flow/StateFlow;", "getIgnorePackages", "()Lkotlinx/coroutines/flow/StateFlow;", "_blackPackages", "blackPackages", "getBlackPackages", "_allHidePackages", "allHidePackages", "getAllHidePackages", "computeAllHidePackages", "store", "Lcom/obric/memorydata/middleware/api/store/IStore;", "_unableApps", "", "_enableCategories", "enableApps", "getEnableApps", "()Ljava/util/Set;", "_screenObservationMemoryEnabled", "", "screenObservationMemoryEnabled", "getScreenObservationMemoryEnabled", "_newMemorySetting", "newMemorySetting", "getNewMemorySetting", "QUERY_APP_TYPE_INTERVAL", "", "appInstallReceiver", "com/obric/memorydata/recommend/settings/ScreenObservationSettingsStore$appInstallReceiver$1", "Lcom/obric/memorydata/recommend/settings/ScreenObservationSettingsStore$appInstallReceiver$1;", "registerAppInstallListener", "", "disableAllApp", "saveScreenObservationEnabled", "enabled", "refreshScreenObservationEnabled", "resolveEffectiveScreenObservationEnabled", "persistedEnabled", "readPersistedScreenObservationEnabled", "saveCellularEnabled", "enableApp", ObricMemoryConstants.KEY_PACKAGE_NAME, "enable", "bulkEnableApp", "saveHasConfirm", "hasConfirm", "saveNewMemorySetting", "setting", "getEnableCategories", "saveEnableCategories", "categoryCode", "isAdd", "categories", "saveFunctionCallResult", "data", "Lcom/obric/memorydata/recommend/function/FunctionCallHistoryData;", "getFunctionCallResult", "", "getExperienceEnabled", "saveRestoreTime", "timestamp", "getRestoreTime", "clearRestoreTime", "getCellularEnabled", "cellularEnabled", "getScreenObservationHasConfigured", "saveScreenObservationConfigured", "getPersonalStoreOrNull", "notifyEnabledAppsChanged", "getLauncherApps", "registerEnabledAppListener", "listener", "register", "addPendingQueryApp", "removePendingQueryApp", "processPendingSingle", "processPendingAppTypeQueries", "isAppCurrentlyInstalled", "scheduleDelayedPendingCheck", "delayMs", "isPending", "getPendingPackages", "onAppCategoryResolved", "EnabledAppListener", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t f12630a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final CopyOnWriteArrayList<a> f12631b = null;
    private static final Map<String, String> c = null;
    private static final ae<Set<String>> d = null;
    private static final ar<Set<String>> e = null;
    private static final ae<Set<String>> f = null;
    private static final ar<Set<String>> g = null;
    private static final ae<Set<String>> h = null;
    private static final ar<Set<String>> i = null;
    private static final IStore j = null;
    private static final Set<String> k = null;
    private static final Set<String> l = null;
    private static final ae<Boolean> m = null;
    private static final ar<Boolean> n = null;
    private static final ae<Integer> o = null;
    private static final ar<Integer> p = null;
    private static final b q = null;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/recommend/settings/ScreenObservationSettingsStore$EnabledAppListener;", "", "onEnabledAppsChanged", "", "enabledApps", "", "", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface a {
        void a(List<String> r1);
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/recommend/settings/ScreenObservationSettingsStore$appInstallReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends PluginBroadcastReceiver {
        b() {
        }

        private static final void a() {
            Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getLifelogDao().queryAll(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((LifelogEntity) ZeusTransformUtils.preCheckCast(r0.next(), LifelogEntity.class, "com.obric.memorydata.plugin")).delete();
            goto L4
        }

        public static /* synthetic */ void lambda$DdYmlv5hSR53zfoEZbW3z_yQyg4() {
            a();
        }

        public void onReceive(Context r21, Intent r22) {
            Intrinsics.checkNotNullParameter((Context) ZeusTransformUtils.wrapperContextForParams(r21, Context.class, "com.obric.memorydata.plugin"), "context");
            Intrinsics.checkNotNullParameter(r22, MemorySourceLinkType.INTENT);
            Uri r1 = r22.getData();
            if (r1 == null) goto L5;
            String r2 = r1.getSchemeSpecificPart();
        L6:
            boolean r4 = r22.getBooleanExtra("android.intent.extra.REPLACING", false);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationSettingsStore", "intent.action: " + r22.getAction(), false, 4, null);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationSettingsStore", "packageName: " + r2 + ", is replacing: " + r4 + ", newMemorySetting: " + ((Number) ZeusTransformUtils.preCheckCast(t.f12630a.f().c(), Number.class, "com.obric.memorydata.plugin")).intValue() + ' ', false, 4, null);
            if (r4 == false) goto L14;
            if (Intrinsics.areEqual(r22.getAction(), "android.intent.action.PACKAGE_ADDED") == false) goto L11;
            return;
        L11:
            if (Intrinsics.areEqual(r22.getAction(), "android.intent.action.PACKAGE_REMOVED") == false) goto L14;
            return;
        L14:
            if (r4 == false) goto L19;
            if (Intrinsics.areEqual(r22.getAction(), "android.intent.action.PACKAGE_REPLACED") == false) goto L19;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationSettingsStore", "ACTION_PACKAGE_REPLACED, packageName: " + r2 + " ...", false, 4, null);
            return;
        L19:
            if (Intrinsics.areEqual(r22.getAction(), "android.intent.action.PACKAGE_ADDED") == false) goto L38;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationSettingsStore", "ACTION_PACKAGE_ADDED, packageName: " + r2 + " ...", false, 4, null);
            if (r2 != null) goto L23;
            return;
        L23:
            if (com.obric.memorydata.recommend.b.f12496a.a().contains(r2) == false) goto L26;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationSettingsStore", "PACKAGE_ADDED skip: pkg=" + r2 + " reason=system_app_blocked", false, 4, null);
            return;
        L26:
            int r0 = ((Number) ZeusTransformUtils.preCheckCast(t.f12630a.f().c(), Number.class, "com.obric.memorydata.plugin")).intValue();
            if (r0 == 0) goto L35;
            if (r0 != 1) goto L30;
            long r3 = System.currentTimeMillis();
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationSettingsStore", "pending add begin: pkg=" + r2 + " ts=" + r3 + " newMemorySetting=" + ((Number) ZeusTransformUtils.preCheckCast(t.f12630a.f().c(), Number.class, "com.obric.memorydata.plugin")).intValue(), false, 4, null);
            t.a(t.f12630a, r2);
            t.a(t.f12630a, 30000);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationSettingsStore", "pending add end: pkg=" + r2 + " ts=" + r3, false, 4, null);
            return;
        L30:
            if (r0 == 2) goto L32;
            IRunLog r6 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
            StringBuilder r5 = new StringBuilder();
        L33:
            IRunLog.a.a(r6, "ScreenObservationSettingsStore", r5.append("packageName: ").append(r2).append(" disable").toString(), false, 4, null);
            t.f12630a.a(r2, false);
        L36:
            t.a(t.f12630a);
            return;
        L32:
            r6 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
            r5 = new StringBuilder();
            goto L33
        L35:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationSettingsStore", "packageName: " + r2 + " enable", false, 4, null);
            t.f12630a.a(r2, true);
            goto L36
        L38:
            if (Intrinsics.areEqual(r22.getAction(), "android.intent.action.PACKAGE_REMOVED") == false) goto L53;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationSettingsStore", "ACTION_PACKAGE_REMOVED, packageName: " + r2 + " ...", false, 4, null);
            if (r2 == null) goto L54;
            if (r4 == false) goto L43;
            return;
        L43:
            if (t.s().contains(r2) == false) goto L45;
            t.s().remove(r2);
            t.t().save("recommend_unable_apps", t.s());
        L45:
            t.b(t.f12630a, r2);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationSettingsStore", "pending cancel: pkg=" + r2 + " reason=uninstall", false, 4, null);
            if (Intrinsics.areEqual(r2, "com.obric.lifelog") == false) goto L36;
            IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).save("is_lifelog_enabled", 0);
            Settings.Global.putInt(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), "lifelog_setting_enabled", 0);
            ThreadPoolContainer.Companion.getInstance().execute($$Lambda$t$b$DdYmlv5hSR53zfoEZbW3z_yQyg4.INSTANCE);
            goto L36
        L54:
            return;
        L53:
            return;
        L5:
            r2 = null;
            goto L6
        }
    }

    static {
        t r0 = new t();
        f12630a = r0;
        f12631b = new CopyOnWriteArrayList();
        c = MapsKt.mapOf(new Pair[]{TuplesKt.to("com.obric.feedbackserviceproject", "com.obric.feedback"), TuplesKt.to("com.obric.securitymanager", "com.obric.security")});
        ae<Set<String>> r2 = at.a(CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast(AppSettingsManager.INSTANCE.getRecommendSettings().getIgnorePackages(), Iterable.class, "com.obric.memorydata.plugin")));
        d = r2;
        e = kotlinx.coroutines.flow.k.a(r2);
        ae<Set<String>> r3 = at.a(CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast(AppSettingsManager.INSTANCE.getRecommendSettings().getBlackPackages(), Iterable.class, "com.obric.memorydata.plugin")));
        f = r3;
        g = kotlinx.coroutines.flow.k.a(r3);
        ae<Set<String>> r4 = at.a(r0.x());
        h = r4;
        i = kotlinx.coroutines.flow.k.a(r4);
        IStore r5 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), "recommend_store", 0, 2, null);
        j = r5;
        k = CollectionsKt.toMutableSet((Iterable) ZeusTransformUtils.preCheckCast(r5.getStringSet("recommend_unable_apps", SetsKt.emptySet()), Iterable.class, "com.obric.memorydata.plugin"));
        l = CollectionsKt.toMutableSet((Iterable) ZeusTransformUtils.preCheckCast(r5.getStringSet("recommend_enable_categories", SetsKt.emptySet()), Iterable.class, "com.obric.memorydata.plugin"));
        ae<Boolean> r6 = at.a(Boolean.valueOf(r0.d(r0.z())));
        m = r6;
        n = kotlinx.coroutines.flow.k.a(r6);
        ae<Integer> r1 = at.a(Integer.valueOf(r5.getInt("new_memory_setting", 2)));
        o = r1;
        p = kotlinx.coroutines.flow.k.a(r1);
        q = new b();
        if (r5.getBoolean("disabled_doubao", true) == false) goto L5;
        r0.a("com.larus.nova", false);
        r0.a("com.larus.mcp", false);
        r5.save("disabled_doubao", false);
    L5:
        r0.y();
        SettingsManager.INSTANCE.registerChangeListener("recommend_settings", (SettingsChangeListener) ZeusTransformUtils.preCheckCast(new AnonymousClass1(), SettingsChangeListener.class, "com.obric.memorydata.plugin"));
    }

    private t() {
    }

    private final IStore A() {
        t r10 = (t) ZeusTransformUtils.preCheckCast(this, t.class, "com.obric.memorydata.plugin");
        int r0 = 0;
    L3:
        IStore r2 = null;
        if (r0 >= 2) goto L24;
        String r3 = AppContext.INSTANCE.getUserId();
        if (AppContext.INSTANCE.isLogin() == false) goto L24;
        Long r4 = StringsKt.toLongOrNull(r3);
        boolean r5 = true;
        if (r4 != null) goto L10;
    L15:
        r5 = false;
    L16:
        if (r5 == false) goto L24;
        r2 = StoreManager.INSTANCE.getPersonalStore();
        if (AppContext.INSTANCE.isLogin() == false) goto L23;
        if (Intrinsics.areEqual(AppContext.INSTANCE.getUserId(), r3) == true) goto L24;
    L23:
        r0 = r0 + 1;
        goto L3
    L10:
        if (((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L12;
        boolean r6 = true;
    L13:
        if (r6 != true) goto L15;
    L12:
        r6 = false;
    L24:
        return r2;
    }

    private final void B() {
        Set<String> r4 = d();
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(f12631b, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((a) ZeusTransformUtils.preCheckCast(r0.next(), a.class, "com.obric.memorydata.plugin")).a(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin")));
        goto L4
    }

    private final Set<String> C() {
        PackageManager r4 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageManager();
        Intent r1 = new Intent("android.intent.action.MAIN");
        r1.addCategory("android.intent.category.LAUNCHER");
        List<ResolveInfo> r5 = r4.queryIntentActivities(r1, 0);
        Intrinsics.checkNotNullExpressionValue(r5, "queryIntentActivities(...)");
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L7;
        r2.add(((ResolveInfo) ZeusTransformUtils.preCheckCast(r7.next(), ResolveInfo.class, "com.obric.memorydata.plugin")).activityInfo.packageName);
        goto L4
    L7:
        return CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void a(t r0) {
        r0.B();
    }

    public static final /* synthetic */ void a(t r0, long r1) {
        r0.b(r1);
    }

    public static final /* synthetic */ void a(t r0, String r1) {
        r0.a(r1);
    }

    private final void a(String r15) {
        if (com.obric.memorydata.recommend.b.f12496a.a().contains(r15) == false) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationSettingsStore", "pending skip: pkg=" + r15 + " reason=system_app_blocked", false, 4, null);
        return;
    L6:
        long r1 = System.currentTimeMillis();
        long r3 = SystemClock.elapsedRealtime();
        Set<String> r14 = CollectionsKt.toMutableSet((Iterable) ZeusTransformUtils.preCheckCast(j.getStringSet("pending_query_apps", SetsKt.emptySet()), Iterable.class, "com.obric.memorydata.plugin"));
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin");
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r6 = r5.iterator();
    L8:
        if (r6.hasNext() == false) goto L16;
        Object r8 = r6.next();
        String r10 = (String) ZeusTransformUtils.preCheckCast(r8, String.class, "com.obric.memorydata.plugin");
        boolean r12 = false;
        if (Intrinsics.areEqual(r10, r15) == false) goto L12;
    L13:
        r12 = true;
    L14:
        if (r12 == false) goto L8;
        r7.add(r8);
        goto L8
    L12:
        if (StringsKt.startsWith$default(r10, r15 + '|', false, 2, null) == false) goto L14;
    L16:
        r14.removeAll((Collection) ZeusTransformUtils.preCheckCast(CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")), Collection.class, "com.obric.memorydata.plugin"));
        r14.add(r15 + '|' + r1 + '|' + r3);
        j.save("pending_query_apps", r14);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationSettingsStore", "pending store add: pkg=" + r15 + " ts=" + r1 + " size=" + r14.size(), false, 4, null);
    }

    public static final /* synthetic */ Set b(t r0) {
        return r0.x();
    }

    private final void b(long r12) {
        int r11 = j.getStringSet("pending_query_apps", SetsKt.emptySet()).size();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationSettingsStore", "schedule delayed check: ts=" + System.currentTimeMillis() + " size=" + r11 + " delayMs=" + r12, false, 4, null);
        ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder(PendingAppTypeCheckTask.NAME).setExistingTaskPolicy(ExistingTaskPolicy.SINGLE_QUEUE), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setDelay((com.obric.memorydata.task.impl.g) ZeusTransformUtils.preCheckCast(new com.obric.memorydata.task.impl.c(r12), com.obric.memorydata.task.impl.g.class, "com.obric.memorydata.plugin")), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).enqueue();
    }

    public static final /* synthetic */ void b(t r0, String r1) {
        r0.b(r1);
    }

    private final void b(String r12) {
        Set<String> r11 = CollectionsKt.toMutableSet((Iterable) ZeusTransformUtils.preCheckCast(j.getStringSet("pending_query_apps", SetsKt.emptySet()), Iterable.class, "com.obric.memorydata.plugin"));
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r1 = r0.iterator();
    L3:
        boolean r5 = true;
        if (r1.hasNext() == false) goto L13;
        Object r4 = r1.next();
        String r6 = (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r6, r12) == false) goto L8;
    L11:
        if (r5 == false) goto L3;
        r3.add(r4);
        goto L3
    L8:
        if (StringsKt.startsWith$default(r6, r12 + '|', false, 2, null) == true) goto L11;
        r5 = false;
        goto L11
    L13:
        List r2 = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L22;
        r11.removeAll((Collection) ZeusTransformUtils.preCheckCast(CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin")), Collection.class, "com.obric.memorydata.plugin"));
        j.save("pending_query_apps", r11);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationSettingsStore", "pending store remove: pkg=" + r12 + " size=" + r11.size(), false, 4, null);
        return;
    }

    private final void c(String r27) {
        String r3 = " reason=processed";
        if (com.obric.memorydata.recommend.b.f12496a.a().contains(r27) == false) goto L52;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationSettingsStore", "process skip: pkg=" + r27 + " reason=system_app_blocked", false, 4, null);
    L5:
        b(r27);
        return;
    L52:
        long r7 = System.currentTimeMillis();     // Catch: Throwable -> L42
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationSettingsStore", "process begin: pkg=" + r27 + " preSetting=" + i() + " ts=" + r7, false, 4, null);     // Catch: Throwable -> L42
        int r5 = i();     // Catch: Throwable -> L42
        if (r5 != 0) goto L11;
        String r19 = " reason=processed";
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationSettingsStore", "packageName: " + r27 + " enable by NEW_MEMORY_OPEN_ALL", false, 4, null);     // Catch: Throwable -> L40
        boolean r4 = true;
    L29:
        a(r27, r4);     // Catch: Throwable -> L40
    L38:
        long r10 = System.currentTimeMillis();     // Catch: Throwable -> L40
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationSettingsStore", "process end: pkg=" + r27 + " ts=" + r10 + " cost=" + (r10 - r7) + "ms", false, 4, null);     // Catch: Throwable -> L40
        IRunLog r6 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = new StringBuilder().append("pending cancel: pkg=").append(r27);
        r3 = r19;
    L45:
        IRunLog.a.a(r6, "ScreenObservationSettingsStore", r0.append(r3).toString(), false, 4, null);
        b(r27);
        return;
    L11:
        if (r5 == 1) goto L17;
        if (r5 == 2) goto L15;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationSettingsStore", "packageName: " + r27 + " disable by default", false, 4, null);     // Catch: Throwable -> L42
    L14:
        a(r27, false);     // Catch: Throwable -> L42
        r19 = " reason=processed";
        goto L38
    L15:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationSettingsStore", "packageName: " + r27 + " disable by NEW_MEMORY_OPEN_NONE", false, 4, null);     // Catch: Throwable -> L42
        goto L14
    L17:
        if (d(r27) == true) goto L20;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationSettingsStore", "packageName: " + r27 + " not installed, skip", false, 4, null);     // Catch: Throwable -> L42
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationSettingsStore", "pending cancel: pkg=" + r27 + " reason=processed", false, 4, null);
        goto L5
    L20:
        long r14 = System.currentTimeMillis();     // Catch: Throwable -> L42
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationSettingsStore", "query start: pkg=" + r27 + " ts=" + r14, false, 4, null);     // Catch: Throwable -> L42
        ScreenObservationCategoryViewModel.a r8 = (ScreenObservationCategoryViewModel.a) ZeusTransformUtils.preCheckCast(CollectionsKt.first(ScreenObservationCategoryViewModel.Companion.a(CollectionsKt.listOf(r27))), ScreenObservationCategoryViewModel.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L42
        long r12 = System.currentTimeMillis();     // Catch: Throwable -> L42
        r19 = " reason=processed";
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationSettingsStore", "query end: pkg=" + r27 + " ts=" + r12 + " cost=" + (r12 - r14) + "ms category=" + r8.b(), false, 4, null);     // Catch: Throwable -> L40
        int r9 = i();     // Catch: Throwable -> L40
        if (r9 != 0) goto L25;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationSettingsStore", "packageName: " + r27 + " enable by NEW_MEMORY_OPEN_ALL(after query)", false, 4, null);     // Catch: Throwable -> L40
        r4 = true;
        goto L29
    L25:
        if (r9 == 1) goto L33;
        if (r9 == 2) goto L30;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationSettingsStore", "packageName: " + r27 + " disable by default(after query)", false, 4, null);     // Catch: Throwable -> L40
        r4 = false;
        goto L29
    L30:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationSettingsStore", "packageName: " + r27 + " disable by NEW_MEMORY_OPEN_NONE(after query)", false, 4, null);     // Catch: Throwable -> L40
        r4 = false;
        goto L29
    L33:
        if (l.contains(String.valueOf(r8.b())) == false) goto L35;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationSettingsStore", "packageName: " + r27 + " categoryCode: " + r8.b() + ", enable", false, 4, null);     // Catch: Throwable -> L40
        r4 = true;
        goto L29
    L35:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationSettingsStore", "packageName: " + r27 + " categoryCode: " + r8.b() + ", disable", false, 4, null);     // Catch: Throwable -> L40
        r4 = false;
    L40:
        th = th;
        r3 = r19;
    L53:
        RunLog.INSTANCE.warn("ScreenObservationSettingsStore", "processPendingSingle failed: " + r27, th);     // Catch: Throwable -> L47
        r6 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r0 = new StringBuilder().append("pending cancel: pkg=").append(r27);
    L47:
        th = move-exception;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationSettingsStore", "pending cancel: pkg=" + r27 + r3, false, 4, null);
        b(r27);
        throw th;
    L42:
        th = th;
        goto L53
    }

    private final boolean d(String r1) {
        return C().contains(r1);
    }

    private final boolean d(boolean r2) {
        return com.obric.memorydata.middleware.api.app.e.f11601a.a(r2, MemoryService.INSTANCE.isAILabScreenMemoryEnabled());
    }

    private static final void e(String r1) {
        f12630a.c(r1);
    }

    private static final void f(String r1) {
        f12630a.c(r1);
    }

    public static /* synthetic */ void lambda$ajKKhNbdyadQXu5QS2jmulgytPw(String r0) {
        f(r0);
    }

    /* JADX INFO: renamed from: lambda$sr-3K11cwYc9ti5KyQX2Inpf4HA, reason: not valid java name */
    public static /* synthetic */ void m1136lambda$sr3K11cwYc9ti5KyQX2Inpf4HA(String r0) {
        e(r0);
    }

    public static final /* synthetic */ Set s() {
        return k;
    }

    public static final /* synthetic */ IStore t() {
        return j;
    }

    public static final /* synthetic */ ae u() {
        return d;
    }

    public static final /* synthetic */ ae v() {
        return f;
    }

    public static final /* synthetic */ ae w() {
        return h;
    }

    private final Set<String> x() {
        return SetsKt.plus(SetsKt.plus((Set) ZeusTransformUtils.preCheckCast(d.c(), Set.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(f.c(), Iterable.class, "com.obric.memorydata.plugin")), (Iterable) ZeusTransformUtils.preCheckCast(com.obric.memorydata.recommend.b.f12496a.a(), Iterable.class, "com.obric.memorydata.plugin"));
    }

    private final void y() {
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        IntentFilter r1 = new IntentFilter();
        r1.addAction("android.intent.action.PACKAGE_ADDED");
        r1.addAction("android.intent.action.PACKAGE_REMOVED");
        r1.addDataScheme("package");
        ZeusTransformUtils.registerReceiver(r4, (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(q, PluginBroadcastReceiver.class, "com.obric.memorydata.plugin"), r1, "com.obric.memorydata.plugin");
    }

    private final boolean z() {
        return j.getBoolean("recommend_enabled", false);
    }

    public final ar<Set<String>> a() {
        return e;
    }

    public final void a(int r12) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationSettingsStore", "saveNewMemorySetting: " + r12, false, 4, null);
        o.b(Integer.valueOf(r12));
        IStore r0 = j;
        r0.save("new_memory_setting", r12);
        Set r1 = CollectionsKt.toMutableSet((Iterable) ZeusTransformUtils.preCheckCast(r0.getStringSet("pending_query_apps", SetsKt.emptySet()), Iterable.class, "com.obric.memorydata.plugin"));
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationSettingsStore", "pending on setting change: ts=" + System.currentTimeMillis() + " rawSize=" + r1.size(), false, 4, null);
        if (r1.isEmpty() == false) goto L6;
        return;
    L6:
        if (r12 == 0) goto L16;
        if (r12 != 1) goto L9;
    L15:
        q();
        return;
    L9:
        if (r12 != 2) goto L15;
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L13:
        if (r11.hasNext() == false) goto L23;
        String r13 = (String) ZeusTransformUtils.preCheckCast(CollectionsKt.first(StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin"), new String[]{"|"}, false, 0, 6, null)), String.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationSettingsStore", "setting change disable all: pkg=" + r13, false, 4, null);
        t r2 = f12630a;
        r2.a(r13, false);
        r2.b(r13);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationSettingsStore", "pending cancel: pkg=" + r13 + " reason=setting_change_disable_all", false, 4, null);
        goto L13
    L23:
        return;
    L16:
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L18:
        if (r14.hasNext() == false) goto L24;
        String r15 = (String) ZeusTransformUtils.preCheckCast(CollectionsKt.first(StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r14.next(), String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin"), new String[]{"|"}, false, 0, 6, null)), String.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationSettingsStore", "setting change enable all: pkg=" + r15, false, 4, null);
        t r3 = f12630a;
        r3.a(r15, true);
        r3.b(r15);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationSettingsStore", "pending cancel: pkg=" + r15 + " reason=setting_change_enable_all", false, 4, null);
        goto L18
    }

    public final void a(int r7, boolean r8) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationSettingsStore", "saveEnableCategories: " + r7 + ", isAdd: " + r8, false, 4, null);
        Set<String> r6 = l;
        String r9 = String.valueOf(r7);
        if (r8 == false) goto L5;
        r6.add(r9);
    L6:
        j.save("recommend_enable_categories", l);
        return;
    L5:
        r6.remove(r9);
        goto L6
    }

    public final void a(long r7) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationSettingsStore", "saveRestoreTime: " + r7, false, 4, null);
        j.save("screen_observation_restore_time", r7);
    }

    public final void a(a r2, boolean r3) {
        a r1 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "listener");
        CopyOnWriteArrayList<a> r4 = f12631b;
        if (r3 == false) goto L5;
        r4.add(r1);
        return;
    L5:
        r4.remove(r1);
    }

    public final void a(String r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, ObricMemoryConstants.KEY_PACKAGE_NAME);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationSettingsStore", "enable app " + r10 + ": " + r11, false, 4, null);
        if (r11 == false) goto L5;
        k.remove(r10);
    L6:
        IRunLog r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r12 = new StringBuilder().append("unableApps: ");
        Set<String> r13 = k;
        IRunLog.a.a(r0, "ScreenObservationSettingsStore", r12.append(r13).toString(), false, 4, null);
        j.save("recommend_unable_apps", r13);
        B();
        return;
    L5:
        k.add(r10);
        goto L6
    }

    public final void a(Set<String> r9, boolean r10) {
        Set r11 = (Set) ZeusTransformUtils.wrapperContextForParams(r9, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, ObricMemoryConstants.KEY_PACKAGE_NAME);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationSettingsStore", "bulkEnableApp, enable: " + r10 + ", appList: " + r11, false, 4, null);
        if (r10 == false) goto L5;
        k.removeAll((Collection) ZeusTransformUtils.preCheckCast(r11, Collection.class, "com.obric.memorydata.plugin"));
    L6:
        IRunLog r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r12 = new StringBuilder().append("unableApps: ");
        Set<String> r13 = k;
        IRunLog.a.a(r0, "ScreenObservationSettingsStore", r12.append(r13).toString(), false, 4, null);
        j.save("recommend_unable_apps", r13);
        B();
        return;
    L5:
        k.addAll((Collection) ZeusTransformUtils.preCheckCast(r11, Collection.class, "com.obric.memorydata.plugin"));
        goto L6
    }

    public final void a(boolean r8) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationSettingsStore", "saveScreenObservationEnabled: " + r8, false, 4, null);
        if (r8 == false) goto L8;
        if (MemoryService.INSTANCE.isAILabScreenMemoryEnabled() == true) goto L8;
        return;
    L8:
        if (z() == r8) goto L10;
        boolean r0 = true;
    L11:
        j.save("recommend_enabled", r8);
        h();
        if (r8 == false) goto L14;
        c(true);
    L14:
        if (r0 == false) goto L16;
        MemoryTrackerOuter.INSTANCE.trackScreenMemorySwitch(r8);
    L16:
        if (r8 == false) goto L18;
        DevTrackerEventId r7 = DevTrackerEventId.OPEN_AI_RECOMMEND_EVENT;
    L19:
        ah.a(r7, new JSONObject());
        return;
    L18:
        r7 = DevTrackerEventId.CLOSE_AI_RECOMMEND_EVENT;
        goto L19
    L10:
        r0 = false;
        goto L11
    }

    public final boolean a(final String r21, int r22) {
        Intrinsics.checkNotNullParameter(r21, ObricMemoryConstants.KEY_PACKAGE_NAME);
        long r3 = System.currentTimeMillis();
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.toMutableSet((Iterable) ZeusTransformUtils.preCheckCast(j.getStringSet("pending_query_apps", SetsKt.emptySet()), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L3:
        Object r9 = null;
        if (r5.hasNext() == false) goto L14;
        Object r6 = r5.next();
        String r12 = (String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r12, r21) == false) goto L8;
    L11:
        boolean r10 = true;
    L12:
        if (r10 == false) goto L3;
        r9 = r6;
        goto L14
    L8:
        if (StringsKt.startsWith$default(r12, r21 + '|', false, 2, null) == true) goto L11;
        r10 = false;
    L14:
        String r7 = (String) ZeusTransformUtils.preCheckCast(r9, String.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L17;
        return false;
    L17:
        String r8 = (String) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"), new String[]{"|"}, false, 0, 6, null), 1), String.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L22;
        Long r11 = StringsKt.toLongOrNull(r8);
        if (r11 == null) goto L22;
        long r13 = r11.longValue();
    L23:
        long r14 = RangesKt.coerceAtLeast(r3 - r13, 0);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationSettingsStore", "category resolved: pkg=" + r21 + " ts=" + r3 + " code=" + r22 + " elapsed=" + r14 + "ms", false, 4, null);
        if (r22 != 0) goto L30;
        long r2 = 30000 - r14;
        if (r2 <= 0) goto L28;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationSettingsStore", "category=0, keep pending and schedule remainMs=" + r2 + " for pkg=" + r21, false, 4, null);
        b(r2);
    L29:
        return false;
    L28:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationSettingsStore", "category=0 and due, run pending now for pkg=" + r21, false, 4, null);
        ThreadPoolContainer.Companion.getInstance().execute(new $$Lambda$t$ajKKhNbdyadQXu5QS2jmulgytPw(r21));
        goto L29
    L30:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationSettingsStore", "category==" + r22 + ", decide and cancel pending for pkg=" + r21, false, 4, null);
        IRunLog r15 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r4 = new StringBuilder().append("_enableCategories: ");
        Set<String> r16 = l;
        IRunLog.a.a(r15, "ScreenObservationSettingsStore", r4.append(r16).toString(), false, 4, null);
        int r17 = i();
        if (r17 == 0) goto L36;
        if (r17 == 1) goto L35;
    L33:
        a(r21, false);
    L37:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationSettingsStore", "pending cancel: pkg=" + r21 + " reason=category_resolved", false, 4, null);
        b(r21);
        return true;
    L35:
        if (r16.contains(String.valueOf(r22)) == false) goto L33;
    L36:
        a(r21, true);
    L22:
        r13 = 0;
        goto L23
    }

    public final ar<Set<String>> b() {
        return g;
    }

    public final void b(boolean r7) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationSettingsStore", "saveCellularEnabled: " + r7, false, 4, null);
        o.f12616a.a(r7);
    }

    public final ar<Set<String>> c() {
        return i;
    }

    public final void c(boolean r9) {
        j.save("screen_observation_configured", r9);
        IStore r8 = A();
        boolean r0 = com.obric.memorydata.middleware.api.store.a.f11639a.a(r8, "screen_observation_configured", r9);
        if (r9 == false) goto L6;
        if (r0 == false) goto L6;
        boolean r10 = com.obric.memorydata.middleware.api.store.a.f11639a.a(r8, "context_awareness_configured", true);
    L7:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationSettingsStore", "saveScreenObservationConfigured: enable=" + r9 + ", personalSaved=" + r0 + ", contextSaved=" + r10, false, 4, null);
        return;
    L6:
        r10 = false;
        goto L7
    }

    public final Set<String> d() {
        Set<String> r0 = C();
        Set<String> r5 = r();
        Set r6 = CollectionsKt.toMutableSet((Iterable) ZeusTransformUtils.preCheckCast(SetsKt.minus(SetsKt.minus(SetsKt.minus(r0, (Iterable) ZeusTransformUtils.preCheckCast(k, Iterable.class, "com.obric.memorydata.plugin")), (Iterable) ZeusTransformUtils.preCheckCast(i.c(), Iterable.class, "com.obric.memorydata.plugin")), (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"));
        Iterator<Map.Entry<String, String>> r1 = c.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.memorydata.plugin");
        String r4 = (String) ZeusTransformUtils.preCheckCast(r2.getValue(), String.class, "com.obric.memorydata.plugin");
        if (k.contains(r3) == true) goto L7;
        r6.add(r4);
        goto L4
    L7:
        r6.remove(r4);
        goto L4
    L10:
        return CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin"));
    }

    public final ar<Boolean> e() {
        return n;
    }

    public final ar<Integer> f() {
        return p;
    }

    public final void g() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationSettingsStore", "disableAllApp", false, 4, null);
        a(C(), false);
    }

    public final void h() {
        boolean r0 = z();
        boolean r10 = d(r0);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationSettingsStore", "refreshScreenObservationEnabled: persisted=" + r0 + ", effective=" + r10, false, 4, null);
        m.b(Boolean.valueOf(r10));
        Settings.System.putInt(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), "com.obric.memorydata.screen_memory_enabled", r10 ? 1 : 0);
    }

    public final int i() {
        int r7 = j.getInt("new_memory_setting", 2);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationSettingsStore", "getNewMemorySetting: " + r7, false, 4, null);
        return r7;
    }

    public final Set<String> j() {
        IRunLog r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r7 = new StringBuilder().append("getEnableCategories: ");
        Set<String> r6 = l;
        IRunLog.a.a(r0, "ScreenObservationSettingsStore", r7.append(r6).toString(), false, 4, null);
        return r6;
    }

    public final boolean k() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationSettingsStore", "getExperienceEnabled: " + ((Boolean) ZeusTransformUtils.preCheckCast(MemoryService.INSTANCE.experienceState().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), false, 4, null);
        return ((Boolean) ZeusTransformUtils.preCheckCast(MemoryService.INSTANCE.experienceState().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    public final long l() {
        return j.getLong("screen_observation_restore_time", 0);
    }

    public final void m() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationSettingsStore", "clearRestoreTime", false, 4, null);
        j.save("screen_observation_restore_time", 0);
    }

    public final boolean n() {
        return o.f12616a.b();
    }

    public final ar<Boolean> o() {
        return o.f12616a.a();
    }

    public final boolean p() {
        IStore r0 = j;
        boolean r2 = r0.getBoolean("screen_observation_configured", false);
        boolean r9 = q.f12620a.a(r2, z());
        if (r9 == false) goto L6;
        if (r2 == true) goto L6;
        r0.save("screen_observation_configured", true);
    L6:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationSettingsStore", "getScreenObservationHasConfigured: persisted=" + r2 + ", resolved=" + r9, false, 4, null);
        return r9;
    }

    public final void q() {
        long r0 = System.currentTimeMillis();
        long r2 = SystemClock.elapsedRealtime();
        Set r4 = CollectionsKt.toMutableSet((Iterable) ZeusTransformUtils.preCheckCast(j.getStringSet("pending_query_apps", SetsKt.emptySet()), Iterable.class, "com.obric.memorydata.plugin"));
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationSettingsStore", "pending check begin: ts=" + r0 + " rawSize=" + r4.size(), false, 4, null);
        if (r4.isEmpty() == false) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationSettingsStore", "pending check end: ts=" + r0 + " no items", false, 4, null);
        return;
    L6:
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r7 = r5.iterator();
    L7:
        Triple r12 = null;
        if (r7.hasNext() == false) goto L21;
        String r8 = (String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin");
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("|", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == false) goto L18;
        List r9 = StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"), new String[]{"|"}, false, 0, 6, null);
        int r10 = r9.size();
        if (r10 != 2) goto L14;
        r12 = new Triple(r9.get(0), StringsKt.toLongOrNull((String) ZeusTransformUtils.preCheckCast(r9.get(1), String.class, "com.obric.memorydata.plugin")), null);
    L19:
        if (r12 == null) goto L7;
        r6.add(r12);
        goto L7
    L14:
        if (r10 != 3) goto L19;
        r12 = new Triple(r9.get(0), StringsKt.toLongOrNull((String) ZeusTransformUtils.preCheckCast(r9.get(1), String.class, "com.obric.memorydata.plugin")), StringsKt.toLongOrNull((String) ZeusTransformUtils.preCheckCast(r9.get(2), String.class, "com.obric.memorydata.plugin")));
        goto L19
    L18:
        r12 = new Triple(r8, 0L, null);
        goto L19
    L21:
        List r11 = (List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin");
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin");
        Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r15 = r13.iterator();
    L23:
        if (r15.hasNext() == false) goto L47;
        Object r16 = r15.next();
        Triple r17 = (Triple) ZeusTransformUtils.preCheckCast(r16, Triple.class, "com.obric.memorydata.plugin");
        String r18 = (String) ZeusTransformUtils.preCheckCast(r17.component1(), String.class, "com.obric.memorydata.plugin");
        Long r19 = (Long) ZeusTransformUtils.preCheckCast(r17.component2(), Long.class, "com.obric.memorydata.plugin");
        Long r110 = (Long) ZeusTransformUtils.preCheckCast(r17.component3(), Long.class, "com.obric.memorydata.plugin");
        boolean r111 = f12630a.d(r18);
        if (r110 != null) goto L27;
    L29:
        boolean r112 = false;
    L30:
        if (r110 == null) goto L33;
        if (r112 == true) goto L33;
        long r113 = r2 - r110.longValue();
    L37:
        if (r111 == false) goto L42;
        if (r112 == true) goto L42;
        if (r113 < 30000) goto L42;
        boolean r114 = true;
    L43:
        long r24 = r2;
        RunLog.INSTANCE.debug("ScreenObservationSettingsStore", "pending item: pkg=" + r18 + " installed=" + r111 + " reboot=" + r112 + " delayMs=" + r113 + " due=" + r114);
        if (r114 == false) goto L46;
        r14.add(r16);
    L46:
        r15 = r15;
        r2 = r24;
    L42:
        r114 = false;
    L33:
        if (r19 == null) goto L35;
        long r115 = r19.longValue();
    L36:
        r113 = r0 - r115;
        goto L37
    L35:
        r115 = 0;
        goto L36
    L27:
        if (r2 >= r110.longValue()) goto L29;
        r112 = true;
        goto L30
    L47:
        long r25 = r2;
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r20 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r21 = r3.iterator();
    L49:
        if (r21.hasNext() == false) goto L51;
        r20.add((String) ZeusTransformUtils.preCheckCast(((Triple) ZeusTransformUtils.preCheckCast(r21.next(), Triple.class, "com.obric.memorydata.plugin")).getFirst(), String.class, "com.obric.memorydata.plugin"));
        goto L49
    L51:
        List r22 = (List) ZeusTransformUtils.preCheckCast(r20, List.class, "com.obric.memorydata.plugin");
        if (r22.isEmpty() == false) goto L54;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationSettingsStore", "pending check end: ts=" + r0 + " no due items", false, 4, null);
    L54:
        Iterator r23 = ((Iterable) ZeusTransformUtils.preCheckCast(r22, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L56:
        if (r23.hasNext() == false) goto L58;
        final String r26 = (String) ZeusTransformUtils.preCheckCast(r23.next(), String.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationSettingsStore", "dispatch process: pkg=" + r26 + " ts=" + r0, false, 4, null);
        ThreadPoolContainer.Companion.getInstance().execute(new $$Lambda$t$sr3K11cwYc9ti5KyQX2Inpf4HA(r26));
        goto L56
    L58:
        Iterable r27 = (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin");
        Collection r28 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r29 = r27.iterator();
    L60:
        if (r29.hasNext() == false) goto L85;
        Triple r30 = (Triple) ZeusTransformUtils.preCheckCast(r29.next(), Triple.class, "com.obric.memorydata.plugin");
        String r31 = (String) ZeusTransformUtils.preCheckCast(r30.component1(), String.class, "com.obric.memorydata.plugin");
        Long r32 = (Long) ZeusTransformUtils.preCheckCast(r30.component2(), Long.class, "com.obric.memorydata.plugin");
        Long r33 = (Long) ZeusTransformUtils.preCheckCast(r30.component3(), Long.class, "com.obric.memorydata.plugin");
        t r34 = f12630a;
        if (r34.d(r31) == true) goto L65;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationSettingsStore", "pending item not installed, remove: pkg=" + r31, false, 4, null);
        r34.b(r31);
    L64:
        Long r35 = null;
    L83:
        if (r35 == null) goto L60;
        r28.add(r35);
        goto L60
    L65:
        if (r33 != null) goto L67;
    L69:
        boolean r36 = false;
    L70:
        if (r33 == null) goto L73;
        if (r36 == true) goto L73;
        long r37 = r25 - r33.longValue();
    L77:
        if (r36 == false) goto L79;
        long r38 = 0;
        long r210 = 30000;
    L81:
        if (r210 <= r38) goto L64;
        r35 = Long.valueOf(r210);
        goto L83
    L79:
        r210 = 30000 - r37;
        r38 = 0;
    L73:
        if (r32 == null) goto L75;
        long r39 = r32.longValue();
    L76:
        r37 = r0 - r39;
        goto L77
    L75:
        r39 = 0;
        goto L76
    L67:
        if (r25 >= r33.longValue()) goto L69;
        r36 = true;
        goto L70
    L85:
        Long r40 = (Long) ZeusTransformUtils.preCheckCast(CollectionsKt.minOrNull((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r28, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")), Long.class, "com.obric.memorydata.plugin");
        if (r40 != null) goto L88;
        return;
    L88:
        if (r40.longValue() <= 0) goto L107;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationSettingsStore", "schedule next precise check: ts=" + r0 + " remainMs=" + r40, false, 4, null);
        b(r40.longValue());
        return;
    }

    public final Set<String> r() {
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(j.getStringSet("pending_query_apps", SetsKt.emptySet()), Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r13 = r12.iterator();
    L4:
        if (r13.hasNext() == false) goto L11;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r13.next(), String.class, "com.obric.memorydata.plugin");
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("|", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == false) goto L8;
        r2 = (String) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"), new String[]{"|"}, false, 0, 6, null)), String.class, "com.obric.memorydata.plugin");
    L8:
        if (r2 == null) goto L4;
        r0.add(r2);
        goto L4
    L11:
        return CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
    }
}
