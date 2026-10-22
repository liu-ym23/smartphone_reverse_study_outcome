package com.obric.memorydata.init.tasks;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import android.provider.Settings;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.lego.init.model.IInitTask;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.common.ICapabilityFeedbackReceiver;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.ability.data.p;
import com.obric.memorydata.ability.k;
import com.obric.memorydata.awareness.api.FeatureManager;
import com.obric.memorydata.database.account_split.LegacyBackupUserRestorer;
import com.obric.memorydata.database.account_split.v;
import com.obric.memorydata.database.dao.IAppEntityRawDbDao;
import com.obric.memorydata.database.entity.LifelogEntity;
import com.obric.memorydata.database.entity.cd;
import com.obric.memorydata.database.entity.gd;
import com.obric.memorydata.database.entity.ip;
import com.obric.memorydata.database.entity.ir;
import com.obric.memorydata.database.index.EntityIndexEngine;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.database.ose_split.PersonalOseDbMigrator;
import com.obric.memorydata.memory.inapptrace.InAppTraceUploadTask;
import com.obric.memorydata.memory.island.IslandRouter;
import com.obric.memorydata.memory.review.provider.MemoryTraceReportTask;
import com.obric.memorydata.memory.tracker.MemorySettingsSnapshotReporter;
import com.obric.memorydata.memory.ui.list.bd;
import com.obric.memorydata.memory.ui.settings.l;
import com.obric.memorydata.memory.utils.LocaleRegionRefreshManager;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.bdtracker.Tracker;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStore;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.middleware.database.DatabaseIsolationTracker;
import com.obric.memorydata.personalcontext.api.EntityManager;
import com.obric.memorydata.personalcontext.api.PersonalContextAPI;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.recommend.RecommendApi;
import com.obric.memorydata.sdk.assistant.QueryContext;
import com.obric.memorydata.sdk.server.AssistantStateTag;
import com.obric.memorydata.task.TaskRegister;
import com.obric.memorydata.task.condition.Condition;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.task.scheduler.impl.ExistingTaskPolicy;
import com.obric.memorydata.ui.IdentityController;
import com.obric.memorydata.union.build.s;
import com.obric.memorydata.utils.handler.GlobalMainHandler;
import com.obric.memorydata.utils.q;
import com.obric.memorydata.utils.threadpool.ThreadPoolContainer;
import com.ss.bduploader.BDVideoUploaderBase;
import com.volcengine.zeus.Zeus;
import com.volcengine.zeus.ZeusPluginStateListener;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.au;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.cu;
import kotlinx.coroutines.i;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000}\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\f*\u0003\t\f\u0013\b\u0007\u0018\u0000 =2\u00020\u0001:\u0001=B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0016\u0010\u0017\u001a\u00020\u00162\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0016H\u0002J\b\u0010\u001b\u001a\u00020\u0016H\u0016J\b\u0010\u001c\u001a\u00020\u0016H\u0002J\b\u0010\u001d\u001a\u00020\u0016H\u0002J\u0010\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010!\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020 H\u0002J>\u0010\"\u001a\u00020#\"\b\b\u0000\u0010$*\u00020%2\u0006\u0010&\u001a\u00020\u00112\f\u0010'\u001a\b\u0012\u0004\u0012\u0002H$0(2\u0014\b\u0002\u0010)\u001a\u000e\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u00020\u00160*H\u0002J.\u0010+\u001a\b\u0012\u0004\u0012\u0002H$0,\"\b\b\u0000\u0010$*\u00020%2\f\u0010'\u001a\b\u0012\u0004\u0012\u0002H$0(2\u0006\u0010-\u001a\u00020.H\u0002J\u0010\u0010/\u001a\u00020#2\u0006\u00100\u001a\u00020%H\u0002J\u0016\u00101\u001a\b\u0012\u0004\u0012\u00020\u0011022\u0006\u00100\u001a\u00020%H\u0002J\b\u00103\u001a\u00020\u0016H\u0002J\b\u00104\u001a\u00020\u0016H\u0002J\b\u00105\u001a\u00020\u0016H\u0002J\b\u00106\u001a\u00020\u0016H\u0002J\b\u00107\u001a\u00020\u0016H\u0002J\b\u00108\u001a\u00020\u0016H\u0002J\b\u00109\u001a\u00020\u0016H\u0002J\b\u0010:\u001a\u00020\u0016H\u0002J\b\u0010;\u001a\u00020\u0016H\u0002J\b\u0010<\u001a\u00020\u0016H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u0010\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014¨\u0006>"}, d2 = {"Lcom/obric/memorydata/init/tasks/MemoryInitTask;", "Lcom/bytedance/lego/init/model/IInitTask;", "<init>", "()V", "abilityManager", "Lcom/obric/memorydata/ability/AbilityManager;", "abilityParams", "Lcom/obric/memorydata/ability/AbilityParams;", "dailyReportCallback", "com/obric/memorydata/init/tasks/MemoryInitTask$dailyReportCallback$1", "Lcom/obric/memorydata/init/tasks/MemoryInitTask$dailyReportCallback$1;", "abilityDataReceiver", "com/obric/memorydata/init/tasks/MemoryInitTask$abilityDataReceiver$1", "Lcom/obric/memorydata/init/tasks/MemoryInitTask$abilityDataReceiver$1;", "isSettingEnabled", "", "key", "", "appInstallReceiver", "com/obric/memorydata/init/tasks/MemoryInitTask$appInstallReceiver$1", "Lcom/obric/memorydata/init/tasks/MemoryInitTask$appInstallReceiver$1;", "registerAppInstallListener", "", "runOnMainAfterAiAgentInstalled", "action", "Lkotlin/Function0;", "scheduleTracePeriodicReportIfEnabled", "run", "runPostPersonalDbSplitIndexBackfillIfNeeded", "runPostPersonalDbSplitIndexBackfillBlocking", "backfillLifelogIndexPendingIfNeeded", "store", "Lcom/obric/memorydata/middleware/api/store/IStore;", "backfillSemanticIndexPendingIfNeeded", "backfillPersonalRawIndexPending", "", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", ActivityLifecycle.NAME, "dao", "Lcom/obric/memorydata/database/dao/IAppEntityRawDbDao;", "beforeInsertPending", "Lkotlin/Function1;", "queryRawEntityPage", "", "minId", "", "insertMissingIndexPendingColumns", "entity", "getAllIndexPendingColumns", "", "restoreLegacyBackupForCurrentUserAfterPersonalDbSplit", "migratePersonalVectorDbFilesAtStartup", "migratePersonalOseDbAtStartup", "cleanOrphanedAutoMemoryProData", "ioThreadMemoryInitTask", "migrateRuleRequirementsIfNeeded", "rebuildRuleRequirementsFromCurrentRules", "updateClientModelConfig", "enqueueRuleSettingsUpgradeIfNeeded", "initOUILogger", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemoryInitTask extends IInitTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9899a = null;
    private static final AtomicBoolean g = null;
    private static final al h = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.memorydata.ability.d f9900b;
    private final com.obric.memorydata.ability.f c;
    private final d d;
    private final b e;
    private final c f;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/init/tasks/MemoryInitTask$Companion;", "", "<init>", "()V", "TAG", "", "DB_ISO_TAG", "TRACE_PERIODIC_REPORT_INIT_DELAY_MILLIS", "", "POST_SPLIT_INDEX_BACKFILL_PAGE_SIZE", "", "POST_SPLIT_INDEX_BACKFILL_TIMEOUT_MS", "KEY_POST_SPLIT_LIFELOG_INDEX_BACKFILL_DONE", "KEY_POST_SPLIT_SEMANTIC_INDEX_BACKFILL_DONE", "tracePeriodicReportCheckScheduled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "postSplitIndexBackfillScope", "Lkotlinx/coroutines/CoroutineScope;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/init/tasks/MemoryInitTask$abilityDataReceiver$1", "Lcom/obric/memorydata/ability/IAbilityDataReceiver;", "onDataReceive", "", "data", "Lcom/obric/memorydata/ability/data/IStandardData;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements k {
        b() {
        }

        @Override // com.obric.memorydata.ability.k
        public void a(com.obric.memorydata.ability.data.h r6) {
            com.obric.memorydata.ability.data.h r5 = (com.obric.memorydata.ability.data.h) ZeusTransformUtils.wrapperContextForParams(r6, com.obric.memorydata.ability.data.h.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "data");
            if (ZeusTransformUtils.instanceOf(r5, p.class) == false) goto L23;
            RunLog.INSTANCE.debug("MemoryInitTask", "screen state: " + ((p) ZeusTransformUtils.preCheckCast(r5, p.class, "com.obric.memorydata.plugin")).a());
            String r7 = ((p) ZeusTransformUtils.preCheckCast(r5, p.class, "com.obric.memorydata.plugin")).a();
            int r8 = r7.hashCode();
            if (r8 == (-840442044)) goto L19;
            if (r8 == 3551) goto L16;
            if (r8 == 109935) goto L12;
            return;
        L12:
            if (r7.equals(com.tom_roush.pdfbox.pdmodel.a.d.f.g) == false) goto L27;
            IdentityController.f12979a.a("screen_off");
            return;
        L27:
            return;
        L16:
            if (r7.equals(com.tom_roush.pdfbox.pdmodel.a.d.f.f) == false) goto L25;
            com.obric.memorydata.memory.tracker.f.f10542a.b();
            MemorySettingsSnapshotReporter.f10517a.c();
        L21:
            com.obric.memorydata.init.tasks.e.a(com.obric.memorydata.init.tasks.e.f9922a, 0, 1, null);
            return;
        L25:
            return;
        L19:
            if (r7.equals("unlock") == true) goto L21;
            return;
        }

        @Override // com.obric.memorydata.ability.k
        public String g_() {
            return k.a.a(this);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/init/tasks/MemoryInitTask$appInstallReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c extends PluginBroadcastReceiver {
        c() {
        }

        public void onReceive(Context r8, Intent r9) {
            Intrinsics.checkNotNullParameter((Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin"), "context");
            Intrinsics.checkNotNullParameter(r9, MemorySourceLinkType.INTENT);
            Uri r7 = r9.getData();
            if (r7 == null) goto L5;
            String r10 = r7.getSchemeSpecificPart();
        L6:
            boolean r11 = r9.getBooleanExtra("android.intent.extra.REPLACING", false);
            RunLog.INSTANCE.debug("MemoryInitTask", "intent.action: " + r9.getAction());
            RunLog.INSTANCE.debug("MemoryInitTask", "packageName: " + r10 + ", is replacing: " + r11 + ' ');
            if (r11 == false) goto L14;
            if (Intrinsics.areEqual(r9.getAction(), "android.intent.action.PACKAGE_ADDED") == false) goto L11;
            return;
        L11:
            if (Intrinsics.areEqual(r9.getAction(), "android.intent.action.PACKAGE_REMOVED") == false) goto L14;
            return;
        L14:
            if (r11 == false) goto L19;
            if (Intrinsics.areEqual(r9.getAction(), "android.intent.action.PACKAGE_REPLACED") == false) goto L19;
            RunLog r12 = RunLog.INSTANCE;
            StringBuilder r13 = new StringBuilder();
            String r0 = "ACTION_PACKAGE_REPLACED, packageName: ";
        L21:
            r12.debug("MemoryInitTask", r13.append(r0).append(r10).append(" ...").toString());
            return;
        L19:
            if (Intrinsics.areEqual(r9.getAction(), "android.intent.action.PACKAGE_ADDED") == false) goto L23;
            r12 = RunLog.INSTANCE;
            r13 = new StringBuilder();
            r0 = "ACTION_PACKAGE_ADDED, packageName: ";
            goto L21
        L23:
            if (Intrinsics.areEqual(r9.getAction(), "android.intent.action.PACKAGE_REMOVED") == false) goto L35;
            RunLog.INSTANCE.debug("MemoryInitTask", "ACTION_PACKAGE_REMOVED, packageName: " + r10 + " ...");
            com.obric.memorydata.utils.c.f13193a.c(r10);
            if (Intrinsics.areEqual(r10, "com.obric.recorder") == false) goto L29;
            if (r11 == true) goto L29;
            l.f11479a.a().h(false);
            l.f11479a.a().g(false);
        L29:
            if (Intrinsics.areEqual(r10, l.f11479a.a().e().c()) == false) goto L36;
            if (r11 == true) goto L37;
            l.f11479a.a().a("");
            return;
        L37:
            return;
        L36:
            return;
        L35:
            return;
        L5:
            r10 = null;
            goto L6
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/obric/memorydata/init/tasks/MemoryInitTask$dailyReportCallback$1", "Lcom/obric/memorydata/middleware/api/bdtracker/DailyReportCallback;", "onDailyReport", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d implements com.obric.memorydata.middleware.api.bdtracker.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MemoryInitTask f9901a;

        d(MemoryInitTask r1) {
            this.f9901a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v11 */
        /* JADX WARN: Type inference failed for: r6v12 */
        /* JADX WARN: Type inference failed for: r6v13 */
        /* JADX WARN: Type inference failed for: r6v17 */
        /* JADX WARN: Type inference failed for: r6v3 */
        /* JADX WARN: Type inference failed for: r6v4 */
        /* JADX WARN: Type inference failed for: r8v12 */
        /* JADX WARN: Type inference failed for: r8v2 */
        /* JADX WARN: Type inference failed for: r8v3 */
        /* JADX WARN: Type inference failed for: r8v6 */
        /* JADX WARN: Type inference failed for: r8v7 */
        /* JADX WARN: Type inference failed for: r8v8 */
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
            int r3 = 0;
            boolean r0 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getBoolean("auto_learn_common_address", false);
            boolean r1 = ((Boolean) ZeusTransformUtils.preCheckCast(RecommendApi.INSTANCE.screenObservationEnabled().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
            Object r6 = FeatureManager.INSTANCE.getFeature("location_home_gps");
            if (r6 != null) goto L5;
        L12:
            ?? r7 = false;
        L13:
            Object r8 = FeatureManager.INSTANCE.getFeature("location_company_gps");
            if (r8 != null) goto L16;
        L23:
            ?? r9 = false;
        L24:
            if (r7 == false) goto L27;
            if (r9 == false) goto L27;
            r3 = 4;
        L33:
            boolean r4 = MemoryInitTask.a(this.f9901a, ObricMemoryConstants.SETTINGS_KEY_SHORTCUT_KEY_ENABLED);
            boolean r12 = MemoryInitTask.a(this.f9901a, ObricMemoryConstants.SETTINGS_KEY_SHORTCUT_GESTURE_ENABLED);
            Tracker r10 = Tracker.INSTANCE;
            JSONObject r11 = new JSONObject();
            r11.put("state", r0 ? 1 : 0);
            Unit r2 = Unit.INSTANCE;
            r10.reportEvent("enable_location_learning", r11);
            Tracker r5 = Tracker.INSTANCE;
            JSONObject r13 = new JSONObject();
            r13.put("state", r1 ? 1 : 0);
            Unit r14 = Unit.INSTANCE;
            r5.reportEvent("enable_screen_observation", r13);
            Tracker r15 = Tracker.INSTANCE;
            JSONObject r16 = new JSONObject();
            r16.put("state", r4 ? 1 : 0);
            Unit r17 = Unit.INSTANCE;
            r15.reportEvent("enable_key_shortcut_memory", r16);
            Tracker r18 = Tracker.INSTANCE;
            JSONObject r19 = new JSONObject();
            r19.put("state", r12 ? 1 : 0);
            Unit r110 = Unit.INSTANCE;
            r18.reportEvent("enable_gesture_shortcut_memory", r19);
            Tracker r111 = Tracker.INSTANCE;
            JSONObject r20 = new JSONObject();
            r20.put("state", r3);
            Unit r21 = Unit.INSTANCE;
            r111.reportEvent("has_location_info", r20);
            i.a(am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new MemoryInitTask$dailyReportCallback$1$onDailyReport$6(null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
            i.a(am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new MemoryInitTask$dailyReportCallback$1$onDailyReport$7(null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
            return;
        L27:
            if (r7 == false) goto L30;
            if (r9 == true) goto L30;
            r3 = 1;
        L30:
            if (r7 == true) goto L33;
            if (r9 == false) goto L33;
            r3 = 2;
            goto L33
        L16:
            if (ZeusTransformUtils.instanceOf(r8, List.class) == true) goto L18;
        L20:
            ?? r22 = false;
        L21:
            if (r22 != true) goto L23;
            r9 = true;
            goto L24
        L18:
            if (((List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin")).size() != 2) goto L20;
            r22 = true;
            goto L21
        L5:
            if (ZeusTransformUtils.instanceOf(r6, List.class) == true) goto L7;
        L9:
            ?? r23 = false;
        L10:
            if (r23 != true) goto L12;
            r7 = true;
            goto L13
        L7:
            if (((List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin")).size() != 2) goto L9;
            r23 = true;
            goto L10
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\"\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u000b"}, d2 = {"com/obric/memorydata/init/tasks/MemoryInitTask$initOUILogger$1", "Lcom/obric/oui/common/util/OUILog;", "d", "", LocationMonitorConst.TAG, "", NotificationCompat.CATEGORY_MESSAGE, "e", "throwable", "", "i", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class e implements com.obric.oui.common.util.e {
        e() {
        }

        @Override // com.obric.oui.common.util.e
        public void a(String r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TAG);
            Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
            RunLog.INSTANCE.debug(r1, r2);
        }

        @Override // com.obric.oui.common.util.e
        public void a(String r1, String r2, Throwable r3) {
            Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TAG);
            Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
            RunLog.INSTANCE.error(r1, r2, r3);
        }

        @Override // com.obric.oui.common.util.e
        public void b(String r7, String r8) {
            Intrinsics.checkNotNullParameter(r7, LocationMonitorConst.TAG);
            Intrinsics.checkNotNullParameter(r8, NotificationCompat.CATEGORY_MESSAGE);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), r7, r8, false, 4, null);
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/init/tasks/MemoryInitTask$run$11", "Lcom/obric/memorydata/middleware/api/app/LoginStateListener;", "onLogin", "", "userId", "", "onLogout", "lastUserId", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class f implements com.obric.memorydata.middleware.api.app.d {
        f() {
        }

        @Override // com.obric.memorydata.middleware.api.app.d
        public void a(String r7) {
            Intrinsics.checkNotNullParameter(r7, "userId");
            MemorySettingsSnapshotReporter.f10517a.b();
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_MemoryInitTask", "UserSettings login, loginUserId: " + q.f13259a.b(r7), false, 4, null);
            com.obric.memorydata.memory.c.a.f10081a.a("account_login", r7);
            l.f11479a.a().C();
        }

        @Override // com.obric.memorydata.middleware.api.app.d
        public void b(String r7) {
            Intrinsics.checkNotNullParameter(r7, "lastUserId");
            MemorySettingsSnapshotReporter.f10517a.b();
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_MemoryInitTask", "UserSettings logout, logoutUserId: " + q.f13259a.b(r7), false, 4, null);
            com.obric.memorydata.memory.c.a.f10081a.a("account_logout", r7);
            l.f11479a.a().C();
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/obric/memorydata/init/tasks/MemoryInitTask$run$7", "Lcom/obric/memorydata/sdk/server/assistant/AssistantStateListener;", "onActive", "", "onQuery", "queryContext", "Lcom/obric/memorydata/sdk/assistant/QueryContext;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class g implements com.obric.memorydata.sdk.server.assistant.b {
        g() {
        }

        @Override // com.obric.memorydata.sdk.server.assistant.b
        public void a() {
        }

        @Override // com.obric.memorydata.sdk.server.assistant.b
        public void a(QueryContext r3) {
            Intrinsics.checkNotNullParameter(r3, "queryContext");
            com.obric.memorydata.memory.tracker.e.f10540a.a(System.currentTimeMillis());
        }
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J7\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0016\u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n0\t\"\u0004\u0018\u00010\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"com/obric/memorydata/init/tasks/MemoryInitTask$runOnMainAfterAiAgentInstalled$1", "Lcom/volcengine/zeus/ZeusPluginStateListener;", "onStateChangeOnCurThread", "", "pluginPkg", "", "event", "", "objects", "", "", "(Ljava/lang/String;I[Ljava/lang/Object;)V", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class h extends ZeusPluginStateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f9902a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f9903b;

        h(String r3, Function0<Unit> r4) {
            Function0<Unit> r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
            this.f9902a = r3;
            this.f9903b = r5;
        }

        private static final void a(Function0 r2) {
            ((Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin")).invoke();
        }

        public static /* synthetic */ void lambda$W1Kc959h7vqotRErVSV1Cs6nW5s(Function0 r0) {
            a(r0);
        }

        public void onStateChangeOnCurThread(String r2, int r3, Object... r4) {
            Intrinsics.checkNotNullParameter(r4, "objects");
            if (Intrinsics.areEqual(r2, this.f9902a) == true) goto L5;
            return;
        L5:
            if (r3 != 6) goto L9;
            Handler r5 = GlobalMainHandler.Companion.getInstance();
            final Function0<Unit> r6 = this.f9903b;
            r5.post(new $$Lambda$MemoryInitTask$h$W1Kc959h7vqotRErVSV1Cs6nW5s(r6));
            Zeus.unregisterPluginStateListener((ZeusPluginStateListener) ZeusTransformUtils.preCheckCast(this, ZeusPluginStateListener.class, "com.obric.memorydata.plugin"));
            return;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.init.tasks.MemoryInitTask$run$8, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.init.tasks.MemoryInitTask$run$8", f = "MemoryInitTask.kt", i = {}, l = {BDVideoUploaderBase.KeyIsDynamicSliceHighSize}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass8 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass8(Continuation<? super AnonymousClass8> r3) {
            super(2, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass8((Continuation) ZeusTransformUtils.wrapperContextForParams(r2, Continuation.class, "com.obric.memorydata.plugin")), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass8) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass8.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L11:
            s.f13110a.a();
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            Continuation r7 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (au.a(5000, r7) != r0) goto L11;
            return r0;
        }
    }

    static {
        f9899a = new a(null);
        g = new AtomicBoolean(false);
        h = am.a(cu.a(null, 1, null).plus((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")));
    }

    public MemoryInitTask() {
        this.f9900b = new com.obric.memorydata.ability.d();
        this.c = new com.obric.memorydata.ability.f(100000005, MapsKt.emptyMap());
        this.d = new d(this);
        this.e = new b();
        this.f = new c();
    }

    private final int a(com.obric.memorydata.database.entity.d r11) {
        Set<String> r10 = b(r11);
        if (r10.isEmpty() == false) goto L5;
        return 0;
    L5:
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(com.obric.memorydata.database.manager.c.f9561a.b(r11.getType()).queryWithRawDb(r11.getId(), r11.getType()), Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        r2.add(((cd) ZeusTransformUtils.preCheckCast(r1.next(), cd.class, "com.obric.memorydata.plugin")).h());
        goto L7
    L9:
        Set r3 = CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r13 = r12.iterator();
    L11:
        if (r13.hasNext() == false) goto L15;
        Object r5 = r13.next();
        if (r3.contains((String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin")) == true) goto L11;
        r4.add(r5);
        goto L11
    L15:
        Set<String> r14 = CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        if (r14.isEmpty() == false) goto L19;
        return 0;
    L19:
        if (r11.insertPendingColumns(r14) == true) goto L21;
        String r15 = "insert missing index pending columns failed, rawDbId=" + r11.getId() + ", type=" + r11.getType() + ", columns=" + r14;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_MemoryInitTask", r15, null, 4, null);
        throw new IllegalStateException(r15);
    L21:
        return r14.size();
    }

    private final <T extends com.obric.memorydata.database.entity.d> int a(String r22, IAppEntityRawDbDao<T> r23, Function1<? super T, Unit> r24) {
        IAppEntityRawDbDao r1 = (IAppEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r23, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin");
        Function1 r3 = (Function1) ZeusTransformUtils.wrapperContextForParams(r24, Function1.class, "com.obric.memorydata.plugin");
        long r4 = System.currentTimeMillis();
        long r8 = SystemClock.elapsedRealtime() + 300000;
        long r11 = 0;
        int r10 = 0;
    L4:
        if (SystemClock.elapsedRealtime() >= r8) goto L21;
        List r13 = a(r1, r11);
        if (r13.isEmpty() == true) goto L7;
        Iterator r15 = ((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L11:
        if (r15.hasNext() == false) goto L13;
        IAppEntityRawDbDao r16 = r1;
        com.obric.memorydata.database.entity.d r2 = (com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r15.next(), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin");
        r3.invoke(r2);
        r10 = r10 + a(r2);
        r1 = r16;
        goto L11
    L13:
        IAppEntityRawDbDao r17 = r1;
        long r0 = ((com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(CollectionsKt.last(r13), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin")).getId();
        if (r0 <= r11) goto L16;
        boolean r6 = true;
    L17:
        if (r6 == false) goto L20;
        r11 = r0;
        r1 = r17;
        goto L4
    L20:
        throw new IllegalStateException(("post split " + r22 + " index pending backfill made no progress, minId=" + r11 + ", nextMinId=" + r0).toString());
    L16:
        r6 = false;
        goto L17
    L7:
        long r5 = System.currentTimeMillis() - r4;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_MemoryInitTask", "post split " + r22 + " index pending backfill scanned until id=" + r11 + ", insertedPending=" + r10 + ", cost=" + r5, false, 4, null);
        DatabaseIsolationTracker.a(DatabaseIsolationTracker.f11642a, "success", r10, r5, null, r22, 8, null);
        return r10;
    L21:
        DatabaseIsolationTracker.f11642a.a(LocationMonitorConst.TIMEOUT, r10, System.currentTimeMillis() - r4, LocationMonitorConst.TIMEOUT, r22);
        throw new IllegalStateException("post split " + r22 + " index pending backfill timeout");
    }

    private final <T extends com.obric.memorydata.database.entity.d> List<T> a(IAppEntityRawDbDao<T> r4, long r5) {
        IAppEntityRawDbDao r3 = (IAppEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin");
        return (List<T>) r3.rawQuery((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT * FROM " + r3.getTableName() + " WHERE id > ? ORDER BY id ASC LIMIT ?", new Object[]{Long.valueOf(r5), 200}), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
    }

    private static final Unit a(int r5) {
        com.obric.capability.schedulekit.a.a(new com.obric.capability.schedulekit.a.b((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getApplication(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin"), (ICapabilityFeedbackReceiver) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.impl.playground.k.f11837a, ICapabilityFeedbackReceiver.class, "com.obric.memorydata.plugin"), r5));
        return Unit.INSTANCE;
    }

    private static final Unit a(MemoryInitTask r0, boolean r1, int r2) {
        if (r1 == false) goto L5;
        r0.e();
    L5:
        return Unit.INSTANCE;
    }

    private static final Unit a(String r7, MemoryInitTask r8, boolean r9) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_MemoryInitTask", "restore legacy backup after personal db split finished, restored=" + r9 + ", userId=" + q.f13259a.b(r7), false, 4, null);
        if (r9 == false) goto L8;
        com.obric.memorydata.database.manager.d.f9563a.a(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getOpenHelper().getWritableDatabase());
        if (com.obric.memorydata.init.tasks.c.a(r9, MemoryDbEngine.INSTANCE.getPersonalDbEngine().getMemoryBaseRequirementDao().queryAllCount()) == false) goto L8;
        r8.k();
    L8:
        return Unit.INSTANCE;
    }

    private static final Unit a(Ref.IntRef r4, LifelogEntity r5) {
        Intrinsics.checkNotNullParameter(r5, "entity");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5.getEntityId(), CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        r5.setEntityId(gd.f9146a.a());
        r5.setTimestamp(r5.getLifelog().getTimestamp());
        r5.setCreateTime(r5.getLifelog().getTimestamp());
        r5.setModifyTime(r5.getLifelog().getTimestamp());
        r5.setPackageName(AppContext.INSTANCE.getPackageName());
        r5.setUuid(UUID.randomUUID().toString());
        r5.setFullContent(r5.getLifelog().getFinalContent());
        MemoryDbEngine.INSTANCE.getPersonalDbEngine().getLifelogDao().update(r5);
        r4.element++;
    L9:
        return Unit.INSTANCE;
    L5:
        r0 = false;
        goto L6
    }

    private static final Unit a(Ref.IntRef r9, ip r10) {
        Intrinsics.checkNotNullParameter(r10, "entity");
        if (MemoryDbEngine.INSTANCE.getPersonalDbEngine().getUnionSemanticMemoryExtDao().queryByMemoryId(r10.getEntityId()) != null) goto L6;
        MemoryDbEngine.INSTANCE.getPersonalDbEngine().getUnionSemanticMemoryExtDao().insertOrReplace(new ir(0, r10.getEntityId(), false, 1, null));
        r9.element++;
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit a(boolean r0, boolean r1) {
        if (r0 == true) goto L6;
        if (r1 == false) goto L6;
        com.obric.memorydata.memory.review.a.f10372a.a("entry_gate_enabled");
        com.obric.memorydata.memory.review.b.f10376a.a();
    L6:
        return Unit.INSTANCE;
    }

    private final void a() {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        IntentFilter r2 = new IntentFilter();
        r2.addAction("android.intent.action.PACKAGE_ADDED");
        r2.addAction("android.intent.action.PACKAGE_REMOVED");
        r2.addDataScheme("package");
        ZeusTransformUtils.registerReceiver(r0, (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(this.f, PluginBroadcastReceiver.class, "com.obric.memorydata.plugin"), r2, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ void a(MemoryInitTask r0) {
        r0.d();
    }

    private static final void a(LocaleRegionRefreshManager.b r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        l.f11479a.a().g((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
    }

    private final void a(Function0<Unit> r3) {
        Function0 r2 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        if (Zeus.isPluginInstalled("com.obric.aiagent.plugin") == false) goto L5;
        r2.invoke();
        return;
    L5:
        Zeus.registerPluginStateListener((ZeusPluginStateListener) ZeusTransformUtils.preCheckCast(new h("com.obric.aiagent.plugin", r2), ZeusPluginStateListener.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ boolean a(MemoryInitTask r0, String r1) {
        return r0.a(r1);
    }

    private final boolean a(IStore r12) {
        IStore r13 = (IStore) ZeusTransformUtils.wrapperContextForParams(r12, IStore.class, "com.obric.memorydata.plugin");
        if (r13.getBoolean("post_personal_db_split_lifelog_index_backfill_done", false) == false) goto L5;
        return false;
    L5:
        final Ref.IntRef r3 = new Ref.IntRef();
        int r11 = a("lifelog", (IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getLifelogDao(), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), new $$Lambda$MemoryInitTask$FC0CAV7kd9DmbFRNseZzV4bM4rY(r3));
        r13.save("post_personal_db_split_lifelog_index_backfill_done", true);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_MemoryInitTask", "post split lifelog index backfill finished, updated=" + r3.element + ", insertedPending=" + r11, false, 4, null);
        if (r11 > 0) goto L8;
        return false;
    L8:
        return true;
    }

    private final boolean a(String r3) {
        if (Settings.System.getInt(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), r3, 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private final Set<String> b(com.obric.memorydata.database.entity.d r6) {
        EntityIndexEngine r5 = com.obric.memorydata.database.index.s.a();
        Set<String> r0 = CollectionsKt.toMutableSet((Iterable) ZeusTransformUtils.preCheckCast(r5.getAllColumns(r6), Iterable.class, "com.obric.memorydata.plugin"));
        if ((!((Collection) ZeusTransformUtils.preCheckCast(CollectionsKt.intersect((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r5.getKeywordColumnMap(r6).keySet(), Iterable.class, "com.obric.memorydata.plugin")), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L6;
        r0.add("insert_keyword_task");
    L6:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(CollectionsKt.intersect((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r5.getContentTimeColumns(r6).keySet(), Iterable.class, "com.obric.memorydata.plugin")), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L8;
        r0.add("insert_content_time_task");
    L8:
        return r0;
    }

    private static final Unit b(boolean r0, boolean r1) {
        if (r0 == true) goto L6;
        if (r1 == false) goto L6;
        com.obric.memorydata.memory.review.d.f10379a.a();
    L6:
        return Unit.INSTANCE;
    }

    private final void b() {
        if (g.compareAndSet(false, true) == true) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryInitTask", "memory trace periodic report check skipped, reason=already_scheduled", false, 4, null);
        return;
    L6:
        i.a(am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new MemoryInitTask$scheduleTracePeriodicReportIfEnabled$1(null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    public static final /* synthetic */ void b(MemoryInitTask r0) {
        r0.h();
    }

    private final boolean b(IStore r13) {
        IStore r14 = (IStore) ZeusTransformUtils.wrapperContextForParams(r13, IStore.class, "com.obric.memorydata.plugin");
        if (r14.getBoolean("post_personal_db_split_semantic_index_backfill_done", false) == false) goto L5;
        return false;
    L5:
        final Ref.IntRef r3 = new Ref.IntRef();
        int r12 = a("semantic", (IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getSemanticMemoryDao(), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), new $$Lambda$MemoryInitTask$FKIzpOsiS7e397nKRg2v6BuJORc(r3));
        if (r3.element <= 0) goto L8;
        ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder("semantic_memory_extract").setPriority(5), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setConditions(new Condition[]{Condition.NETWORK_AVAILABLE}), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExistingTaskPolicy(ExistingTaskPolicy.KEEP_IN_QUEUE), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).enqueue();
    L8:
        r14.save("post_personal_db_split_semantic_index_backfill_done", true);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_MemoryInitTask", "post split semantic index backfill finished, insertedExt=" + r3.element + ", insertedPending=" + r12, false, 4, null);
        if (r12 > 0) goto L11;
        return false;
    L11:
        return true;
    }

    private final void c() {
        i.a(h, null, null, (Function2) ZeusTransformUtils.preCheckCast(new MemoryInitTask$runPostPersonalDbSplitIndexBackfillIfNeeded$1(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    public static final /* synthetic */ void c(MemoryInitTask r0) {
        r0.m();
    }

    private final void d() {
    L12:
        th = move-exception;
        RunLog.INSTANCE.error("db_iso_MemoryInitTask", "post personal db split index backfill failed", th);
        return;
    L4:
        if (v.f8832a.b() == true) goto L7;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_MemoryInitTask", "skip post personal db split index backfill, split migration not done", false, 4, null);     // Catch: Throwable -> L12
        return;
    L7:
        IStore r0 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null);     // Catch: Throwable -> L12
        boolean r1 = a(r0);     // Catch: Throwable -> L12
        boolean r6 = b(r0);     // Catch: Throwable -> L12
        if (r1 == true) goto L10;
        if (r6 == true) goto L10;
        return;
    L10:
        EntityManager.INSTANCE.launchIndexTask();     // Catch: Throwable -> L12
    }

    public static final /* synthetic */ void d(MemoryInitTask r0) {
        r0.j();
    }

    private final void e() {
        com.obric.memorydata.sdk.d.a(new $$Lambda$MemoryInitTask$O1jQy3XCpDOcsevN0c3Yb4RSnQw(this));
    }

    public static final /* synthetic */ void e(MemoryInitTask r0) {
        r0.l();
    }

    private final void f() {
        com.obric.memorydata.sdk.d.a($$Lambda$MemoryInitTask$8YMDtxhasgkf1jx2sH5OXP_B3i8.INSTANCE);
    }

    private static final void f(MemoryInitTask r1) {
        com.obric.memorydata.sdk.d.a($$Lambda$MemoryInitTask$OQHi0TuWKglKhilfZr6PpxHeeCM.INSTANCE);
        r1.i();
    }

    private static final Unit g(final MemoryInitTask r8) {
        final String r0 = UserSettings.INSTANCE.getUserId();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_MemoryInitTask", "restore legacy backup after personal db split, userId=" + q.f13259a.b(r0), false, 4, null);
        LegacyBackupUserRestorer.f8803a.a(r0, new $$Lambda$MemoryInitTask$2cxiexqF2sqvlZFjUOcDkvTMbN8(r0, r8));
        return Unit.INSTANCE;
    }

    private final void g() {
        ThreadPoolContainer.Companion.getInstance().execute($$Lambda$MemoryInitTask$NrOE9BcqdJF1Eed8jDgLCM19_Y.INSTANCE);
    }

    private static final Unit h(MemoryInitTask r5) {
        IStore r0 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null);
        if (r0.getBoolean("rule_requirement_migrated_v1", false) == true) goto L5;
        r5.k();
        r0.save("rule_requirement_migrated_v1", true);
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }

    private final void h() {
        com.obric.memorydata.sdk.d.a($$Lambda$MemoryInitTask$kpHa9ciqeqAv0ckzTy7J7TP3_T0.INSTANCE);
    }

    private final void i() {
        i.a(am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new MemoryInitTask$ioThreadMemoryInitTask$1(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private final void j() {
        com.obric.memorydata.sdk.d.a(new $$Lambda$MemoryInitTask$JunnnWVD6BDmt5rson6WUS048(this));
    }

    private final void k() {
        com.obric.memorydata.memory.ui.automemory.requirement.b.f10717a.a(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getMemoryRuleDao().queryAll());
    }

    private final void l() {
        com.obric.memorydata.sdk.d.a($$Lambda$MemoryInitTask$tiFWiUq5B8D8jxPiLtsmLQsAQ8.INSTANCE);
    }

    public static /* synthetic */ Unit lambda$2cxiexqF2sqvlZFjUOcDkvTMbN8(String r0, MemoryInitTask r1, boolean r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ Drawable lambda$7FYGX5c21FAJYr9wsxTb5I2PByc() {
        return q();
    }

    public static /* synthetic */ Unit lambda$8YMDtxhasgkf1jx2sH5OXP_B3i8() {
        return s();
    }

    public static /* synthetic */ Unit lambda$FC0CAV7kd9DmbFRNseZzV4bM4rY(Ref.IntRef r0, LifelogEntity r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ Unit lambda$FKIzpOsiS7e397nKRg2v6BuJORc(Ref.IntRef r0, ip r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ Unit lambda$JZELdEjYzvfjwplwvPnTN1YnMu4() {
        return t();
    }

    /* JADX INFO: renamed from: lambda$Jun-nnWVD6BD-mt5rson6WUS048, reason: not valid java name */
    public static /* synthetic */ Unit m665lambda$JunnnWVD6BDmt5rson6WUS048(MemoryInitTask r0) {
        return h(r0);
    }

    /* JADX INFO: renamed from: lambda$NrOE9Bcqd-JF1Eed8jDgLCM19_Y, reason: not valid java name */
    public static /* synthetic */ void m666lambda$NrOE9BcqdJF1Eed8jDgLCM19_Y() {
        u();
    }

    public static /* synthetic */ Unit lambda$O1jQy3XCpDOcsevN0c3Yb4RSnQw(MemoryInitTask r0) {
        return g(r0);
    }

    public static /* synthetic */ Unit lambda$OQHi0TuWKglKhilfZr6PpxHeeCM() {
        return r();
    }

    public static /* synthetic */ Unit lambda$OXvf5w0RVL91WeWo1bpL3f5Ci4c(MemoryInitTask r0, boolean r1, int r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$PrEIVnbG4y3YC_q0a1PSqtv1df0() {
        return x();
    }

    public static /* synthetic */ void lambda$S11XJRGeK5leqR1PZcqIv7CPeLg(MemoryInitTask r0) {
        f(r0);
    }

    public static /* synthetic */ void lambda$hxfSjR5fnswFq1mKZBQr6TFnHzM() {
        p();
    }

    public static /* synthetic */ Unit lambda$k13mldFFHCHQBYIjafpRD2eFri8(boolean r0, boolean r1) {
        return b(r0, r1);
    }

    public static /* synthetic */ Unit lambda$kpHa9ciqeqAv0ckzTy7J7TP3_T0() {
        return v();
    }

    /* JADX INFO: renamed from: lambda$kuEj-tKwRBw0ECaKbyztBO9JqdM, reason: not valid java name */
    public static /* synthetic */ Unit m667lambda$kuEjtKwRBw0ECaKbyztBO9JqdM(int r0) {
        return a(r0);
    }

    public static /* synthetic */ Unit lambda$nFlQttKG_BCty66jk7cJhEQhLBk() {
        return o();
    }

    /* JADX INFO: renamed from: lambda$pbNjHzeQXA-N_9AJAyu4s9YrXbU, reason: not valid java name */
    public static /* synthetic */ void m668lambda$pbNjHzeQXAN_9AJAyu4s9YrXbU(LocaleRegionRefreshManager.b r0) {
        a(r0);
    }

    /* JADX INFO: renamed from: lambda$tiFW-iUq5B8D8jxPiLtsmLQsAQ8, reason: not valid java name */
    public static /* synthetic */ Unit m669lambda$tiFWiUq5B8D8jxPiLtsmLQsAQ8() {
        return w();
    }

    /* JADX INFO: renamed from: lambda$zY-EjBrAmm_06UFqyqxVQUc96Sw, reason: not valid java name */
    public static /* synthetic */ Unit m670lambda$zYEjBrAmm_06UFqyqxVQUc96Sw(boolean r0, boolean r1) {
        return a(r0, r1);
    }

    private final void m() {
        com.obric.memorydata.sdk.d.a($$Lambda$MemoryInitTask$PrEIVnbG4y3YC_q0a1PSqtv1df0.INSTANCE);
    }

    private final void n() {
        com.obric.oui.common.util.f.f13501a.a((com.obric.oui.common.util.e) ZeusTransformUtils.preCheckCast(new e(), com.obric.oui.common.util.e.class, "com.obric.memorydata.plugin"));
    }

    private static final Unit o() {
        PersonalContextAPI.INSTANCE.migrateMetaFullContentUidIfNeeded();
        return Unit.INSTANCE;
    }

    private static final void p() {
        com.obric.memorydata.sdk.d.a($$Lambda$MemoryInitTask$nFlQttKG_BCty66jk7cJhEQhLBk.INSTANCE);
    }

    private static final Drawable q() {
        return com.obric.memorydata.memory.ui.list.e.f11304a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
    }

    private static final Unit r() {
        com.obric.memorydata.memory.permission.b.f10340a.b();
        com.obric.memorydata.memory.address.a.f10048a.b();
        com.obric.memorydata.utils.e.a.f13206a.b();
        return Unit.INSTANCE;
    }

    private static final Unit s() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_MemoryInitTask", "personal vector db file migration startup result=" + PersonalContextAPI.INSTANCE.migratePersonalVectorDbFilesIfNeededBlocking(), false, 4, null);
        return Unit.INSTANCE;
    }

    private static final Unit t() {
        PersonalOseDbMigrator.a r0 = PersonalOseDbMigrator.f9612a.a();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_MemoryInitTask", "personal ose db migration startup result=" + r0.a() + ", migrated=" + r0.b(), false, 4, null);
        return Unit.INSTANCE;
    }

    private static final void u() {
        com.obric.memorydata.sdk.d.a($$Lambda$MemoryInitTask$JZELdEjYzvfjwplwvPnTN1YnMu4.INSTANCE);
    }

    private static final Unit v() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryInitTask", "start cleanOrphanedAutoMemoryProData", false, 4, null);
        Set r0 = CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getMemoryRuleDao().queryAllIds(), Iterable.class, "com.obric.memorydata.plugin"));
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getAutoMemoryProDao().queryAllRuleIds(), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        long r3 = ((Number) ZeusTransformUtils.preCheckCast(r1.next(), Number.class, "com.obric.memorydata.plugin")).longValue();
        if (r0.contains(Long.valueOf(r3)) == true) goto L4;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryInitTask", "autoMemoryProDao id：" + r3 + " is useless, delete data", null, 4, null);
        com.obric.memorydata.memory.b.b.f10079a.a(r3);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryInitTask", "autoMemoryProDao id：" + r3 + " is useless, delete success", false, 4, null);
        goto L4
    L9:
        return Unit.INSTANCE;
    }

    private static final Unit w() {
        if (AppContext.INSTANCE.isDebug() == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == true) goto L11;
        MemoryDbEngine.INSTANCE.getPersonalDbEngine().getMemoryRuleDao().updateUseClientModel(false);
        return Unit.INSTANCE;
    L11:
        return Unit.INSTANCE;
    L5:
        if (l.f11479a.a().u() == true) goto L8;
        r0 = false;
        goto L9
    }

    private static final Unit x() {
        if (MemoryDbEngine.INSTANCE.getPersonalDbEngine().getMemoryRuleDao().hasPendingRuleSettingsUpgrade() == false) goto L6;
        ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder("auto_memory_pro_memory_info_generator").setConditions(new Condition[]{Condition.NETWORK_AVAILABLE, Condition.SCREEN_ON_OR_CHARGE}), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExistingTaskPolicy(ExistingTaskPolicy.KEEP_IN_QUEUE), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).enqueue();
    L6:
        return Unit.INSTANCE;
    }

    @Override // java.lang.Runnable
    public void run() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryInitTask", "run", false, 4, null);
        com.obric.memorydata.memory.ui.settings.contextawareness.k.f11460a.a();
        TaskRegister.f12863a.a(MemoryTraceReportTask.NAME, MemoryTraceReportTask.class);
        TaskRegister.f12863a.a(MemoryTraceReportTask.DEBOUNCE_NAME, MemoryTraceReportTask.class);
        TaskRegister.f12863a.a(InAppTraceUploadTask.NAME, InAppTraceUploadTask.class);
        com.obric.memorydata.memory.inapptrace.k.f10179a.b();
        com.obric.memorydata.database.c.b.f8850a.a($$Lambda$MemoryInitTask$zYEjBrAmm_06UFqyqxVQUc96Sw.INSTANCE);
        com.obric.memorydata.database.c.b.f8850a.a($$Lambda$MemoryInitTask$k13mldFFHCHQBYIjafpRD2eFri8.INSTANCE);
        com.obric.memorydata.memory.review.d.a(com.obric.memorydata.memory.review.d.f10379a, null, 1, null);
        b();
        n();
        f();
        g();
        v.f8832a.a(new $$Lambda$MemoryInitTask$OXvf5w0RVL91WeWo1bpL3f5Ci4c(this));
        if (v.f8832a.b() == false) goto L5;
        ThreadPoolContainer.Companion.getInstance().execute($$Lambda$MemoryInitTask$hxfSjR5fnswFq1mKZBQr6TFnHzM.INSTANCE);
        c();
    L6:
        final int r0 = 32;
        a(new $$Lambda$MemoryInitTask$kuEjtKwRBw0ECaKbyztBO9JqdM(r0));
        com.obric.capability.schedulekit.a.a(new com.obric.capability.schedulekit.a.b((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getApplication(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin"), (ICapabilityFeedbackReceiver) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.impl.playground.k.f11837a, ICapabilityFeedbackReceiver.class, "com.obric.memorydata.plugin"), 32));
        com.obric.memorydata.memory.a.a.f10046a.a();
        com.obric.memorydata.memory.b.f10076a.a();
        com.obric.memorydata.memory.ui.detail.e.f10853a.a();
        IslandRouter.f10185a.a((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getApplication(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin"));
        com.obric.memorydata.memory.v.f11572a.a();
        com.obric.memorydata.dc.b.f9848a.b();
        com.obric.memorydata.memory.k.f10230a.a();
        com.obric.assistant.appintent.a.f6932a.a();
        bd.f11226a.a();
        com.obric.memorydata.utils.icon.b.f13229a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        com.obric.memorydata.utils.icon.b.f13229a.a(ZeusTransformUtils.mapRes(R.drawable.ic_rectangle_memorydata, "drawable", "ic_rectangle_memorydata"));
        com.obric.memorydata.utils.icon.b.f13229a.a(new com.obric.memorydata.utils.icon.a[]{new com.obric.memorydata.memory.ui.list.l()});
        com.obric.memorydata.utils.icon.b.f13229a.a("com.obric.appletapp", $$Lambda$MemoryInitTask$7FYGX5c21FAJYr9wsxTb5I2PByc.INSTANCE);
        a();
        IdentityController.f12979a.b();
        MemorySettingsSnapshotReporter.f10517a.a();
        Tracker.INSTANCE.registerDailyReportCallback((com.obric.memorydata.middleware.api.bdtracker.a) ZeusTransformUtils.preCheckCast(this.d, com.obric.memorydata.middleware.api.bdtracker.a.class, "com.obric.memorydata.plugin"));
        com.obric.memorydata.sdk.server.assistant.a.f12858a.a(AssistantStateTag.MEMORY, (com.obric.memorydata.sdk.server.assistant.b) ZeusTransformUtils.preCheckCast(new g(), com.obric.memorydata.sdk.server.assistant.b.class, "com.obric.memorydata.plugin"));
        this.f9900b.a(this.c, (k) ZeusTransformUtils.preCheckCast(this.e, k.class, "com.obric.memorydata.plugin"));
        this.f9900b.query(this.c, (k) ZeusTransformUtils.preCheckCast(this.e, k.class, "com.obric.memorydata.plugin"));
        i.a(am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass8(null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        LocaleRegionRefreshManager.f11524a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        LocaleRegionRefreshManager.f11524a.a("memory_pinned_shortcuts", $$Lambda$MemoryInitTask$pbNjHzeQXAN_9AJAyu4s9YrXbU.INSTANCE);
        LocaleRegionRefreshManager.a(LocaleRegionRefreshManager.f11524a, null, 1, null);
        ThreadPoolContainer.Companion.getInstance().execute(new $$Lambda$MemoryInitTask$S11XJRGeK5leqR1PZcqIv7CPeLg(this));
        UserSettings.INSTANCE.registerLoginStateListener((com.obric.memorydata.middleware.api.app.d) ZeusTransformUtils.preCheckCast(new f(), com.obric.memorydata.middleware.api.app.d.class, "com.obric.memorydata.plugin"));
        com.obric.memorydata.memory.glasses.c.f10140a.a();
        com.obric.memorydata.memory.auditory.c.f10069a.a();
        return;
    L5:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_MemoryInitTask", "skip post personal db split index backfill in current startup", false, 4, null);
        goto L6
    }
}
