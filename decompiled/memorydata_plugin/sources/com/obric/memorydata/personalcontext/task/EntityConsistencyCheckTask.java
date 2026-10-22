package com.obric.memorydata.personalcontext.task;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.UserManager;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.Ensure;
import com.obric.cae.userAware.WifiScanStateMachine;
import com.obric.capabilitykit.sync.EntityCheckHashCodeSlotData;
import com.obric.capabilitykit.sync.EntitySyncDataSupplier;
import com.obric.capabilitykit.sync.EntitySyncUtil;
import com.obric.memorydata.ability.d;
import com.obric.memorydata.ability.data.h;
import com.obric.memorydata.ability.data.p;
import com.obric.memorydata.ability.k;
import com.obric.memorydata.constants.AppInfo;
import com.obric.memorydata.database.dao.IAppEntityRawDbDao;
import com.obric.memorydata.database.index.s;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStore;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.personalcontext.EntityManager;
import com.obric.memorydata.personalcontext.api.EntityCollectorService;
import com.obric.memorydata.personalcontext.api.EvaluationService;
import com.obric.memorydata.personalcontext.api.IEntityManager;
import com.obric.memorydata.personalcontext.j;
import com.obric.memorydata.personalcontext.util.e;
import com.obric.memorydata.task.AbsTaskRequest;
import com.obric.memorydata.task.TaskRegister;
import com.obric.memorydata.task.alarm.AlarmTime;
import com.obric.memorydata.task.alarm.Type;
import com.obric.memorydata.task.condition.Condition;
import com.obric.memorydata.task.impl.NativeTask;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.task.impl.TaskResult;
import com.obric.memorydata.task.impl.g;
import com.obric.memorydata.task.scheduler.impl.ExistingTaskPolicy;
import com.obric.memorydata.utils.r;
import com.tom_roush.pdfbox.pdmodel.a.d.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/personalcontext/task/EntityConsistencyCheckTask;", "Lcom/obric/memorydata/task/impl/NativeTask;", "taskRequest", "Lcom/obric/memorydata/task/AbsTaskRequest;", "<init>", "(Lcom/obric/memorydata/task/AbsTaskRequest;)V", "run", "Lcom/obric/memorydata/task/impl/TaskResult;", "Companion", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class EntityConsistencyCheckTask extends NativeTask {
    public static final Companion Companion = null;
    public static final String DATA_CHECK = "data_check";
    private static final String DEFAULT_SLEEP_TIME_END = "06:00";
    private static final String DEFAULT_SLEEP_TIME_START = "00:00";
    private static final String DEFAULT_SLEEP_TIME_START_WITH_OFFSET = "00:10";
    public static final long HOUR_MILLION_SECONDS_20 = 72000000;
    private static final String KEY_IS_FAST_RUN_MODE = "isFastRunMode";
    private static final String KEY_IS_SYNC_AFTER_ENABLE_APP = "isSyncAfterEnableApp";
    private static final String KEY_IS_SYNC_DONATE_APP = "isSyncDonateApp";
    private static final String KEY_RECOVERY_LAST_START_TIME = "entityConsistencyRecoveryLastStartTime";
    private static final String KEY_RECOVERY_PENDING = "entityConsistencyRecoveryPending";
    private static final String KEY_RECOVERY_SYNC_DONATE_APP = "entityConsistencyRecoverySyncDonateApp";
    public static final String LAST_RUN_ENTITY_SYNC_TASK_TIME = "lastRunEntitySyncTaskTimeStamp";
    public static final String NAME = "EntityConsistencyCheckTask";
    private static final long RECOVERY_MIN_RUN_INTERVAL_MINUTES = 10;
    private static final long RECOVERY_RETRY_DELAY_MINUTES = 60;
    public static final String RECOVERY_TASK_NAME = "EntityConsistencyRecoveryTask";
    public static final int RUN_TASK_DELAY_MINUTES_AFTER_SCREEN_OFF = 10;
    public static final String SYNC_DATA_INDEXED_TYPES = "sync_data_indexed_types";
    public static final String TAG = "EntityConsistencyCheckTask";
    private static final d abilityManager = null;
    private static boolean ignoreSleepTime;
    private static AtomicBoolean isScribeScreenState;
    private static final Lazy<b> recoveryState$delegate = null;
    private static volatile boolean sIsRegisterNextTask;
    private static volatile String sNextTaskRegisterTime;

    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\"\n\u0002\b\u0002\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010(\u001a\u00020)J\u0006\u0010*\u001a\u00020)J\"\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020%2\b\b\u0002\u0010-\u001a\u00020%2\b\b\u0002\u0010.\u001a\u00020%J\b\u0010/\u001a\u00020)H\u0002J\b\u00100\u001a\u00020\fH\u0002J\u0012\u00101\u001a\u00020)2\b\b\u0002\u00102\u001a\u00020\fH\u0002J\u0010\u00103\u001a\u00020)2\u0006\u00104\u001a\u00020%H\u0002J\b\u00105\u001a\u000206H\u0002J\b\u00107\u001a\u000206H\u0002J\u0010\u00108\u001a\u00020)2\u0006\u00109\u001a\u000206H\u0002J\u0010\u0010:\u001a\u00020)2\u0006\u0010;\u001a\u000206H\u0002J\b\u0010<\u001a\u00020)H\u0002J\u0006\u0010=\u001a\u00020%J\u0010\u0010>\u001a\u00020%2\u0006\u0010?\u001a\u00020%H\u0002J\b\u0010@\u001a\u00020%H\u0002J\u000e\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00050BH\u0002J\u0006\u0010C\u001a\u00020\u0005J\u000e\u0010D\u001a\u00020\u00052\u0006\u0010E\u001a\u00020\u000eJ(\u0010F\u001a\u00020%2\u0006\u0010G\u001a\u00020%2\u0018\u0010H\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0J0IJ\u0018\u0010K\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0J0IR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b \u0010!R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006L"}, d2 = {"Lcom/obric/memorydata/personalcontext/task/EntityConsistencyCheckTask$Companion;", "", "<init>", "()V", "NAME", "", "RECOVERY_TASK_NAME", "TAG", "SYNC_DATA_INDEXED_TYPES", "DATA_CHECK", "LAST_RUN_ENTITY_SYNC_TASK_TIME", "HOUR_MILLION_SECONDS_20", "", "RUN_TASK_DELAY_MINUTES_AFTER_SCREEN_OFF", "", "RECOVERY_RETRY_DELAY_MINUTES", "RECOVERY_MIN_RUN_INTERVAL_MINUTES", "KEY_IS_FAST_RUN_MODE", "KEY_IS_SYNC_AFTER_ENABLE_APP", "KEY_IS_SYNC_DONATE_APP", "KEY_RECOVERY_PENDING", "KEY_RECOVERY_SYNC_DONATE_APP", "KEY_RECOVERY_LAST_START_TIME", "DEFAULT_SLEEP_TIME_START", "DEFAULT_SLEEP_TIME_END", "DEFAULT_SLEEP_TIME_START_WITH_OFFSET", "isScribeScreenState", "Ljava/util/concurrent/atomic/AtomicBoolean;", "abilityManager", "Lcom/obric/memorydata/ability/AbilityManager;", "recoveryState", "Lcom/obric/memorydata/personalcontext/task/EntityConsistencyRecoveryState;", "getRecoveryState", "()Lcom/obric/memorydata/personalcontext/task/EntityConsistencyRecoveryState;", "recoveryState$delegate", "Lkotlin/Lazy;", "sIsRegisterNextTask", "", "sNextTaskRegisterTime", "ignoreSleepTime", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "registerNextTask", "triggerTask", "isFastMode", EntityConsistencyCheckTask.KEY_IS_SYNC_AFTER_ENABLE_APP, EntityConsistencyCheckTask.KEY_IS_SYNC_DONATE_APP, "restorePendingRecoveryTask", "calculateRecoveryDelayMinutes", "enqueueRecoveryTask", "delayMinutes", "markRecoveryPending", "syncDonateApp", "readRecoveryDemand", "Lcom/obric/memorydata/personalcontext/task/EntityConsistencyRecoveryDemand;", "readRecoveryDemandFromStore", "persistRecoveryDemand", "demand", "completeRecovery", "recoveryDemand", "recordRecoveryStartTime", "isCredentialProtectionLocked", "checkShouldRunTask", "isRunTask", "isCurrentSleepTime", "getSleepMoments", "", "getSleepStartTimeOffsetDelayTime", "getPackageName", "entityType", "checkContactSmsEntity", "disablePrune", "package2EntityTypeMap", "", "", "generatePackage2EntityTypeMap", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {

        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/personalcontext/task/EntityConsistencyCheckTask$Companion$init$1", "Lcom/obric/memorydata/ability/IAbilityDataReceiver;", "onDataReceive", "", "data", "Lcom/obric/memorydata/ability/data/IStandardData;", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class a implements k {
            a() {
            }

            @Override // com.obric.memorydata.ability.k
            public void a(h r8) {
                h r7 = (h) ZeusTransformUtils.wrapperContextForParams(r8, h.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r7, "data");
                if (ZeusTransformUtils.instanceOf(r7, p.class) == true) goto L5;
                return;
            L5:
                if (Intrinsics.areEqual(((p) ZeusTransformUtils.preCheckCast(r7, p.class, "com.obric.memorydata.plugin")).a(), f.g) == true) goto L7;
                return;
            L7:
                if (Companion.access$checkShouldRunTask(EntityConsistencyCheckTask.Companion, false) == false) goto L10;
                Companion.triggerTask$default(EntityConsistencyCheckTask.Companion, false, false, false, 6, null);
                return;
            L10:
                if (EntityConsistencyCheckTask.access$getSIsRegisterNextTask$cp() == true) goto L13;
                EntityConsistencyCheckTask.Companion.registerNextTask();
                return;
            L13:
                if (AppContext.INSTANCE.isDebug() == false) goto L20;
                IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityConsistencyCheckTask", "nextSleepTime: " + EntityConsistencyCheckTask.access$getSNextTaskRegisterTime$cp(), false, 4, null);
                return;
            }

            @Override // com.obric.memorydata.ability.k
            public String g_() {
                return k.a.a(this);
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public static final /* synthetic */ boolean access$checkShouldRunTask(Companion r0, boolean r1) {
            return r0.checkShouldRunTask(r1);
        }

        public static final /* synthetic */ void access$completeRecovery(Companion r0, com.obric.memorydata.personalcontext.task.a r1) {
            r0.completeRecovery(r1);
        }

        public static final /* synthetic */ void access$persistRecoveryDemand(Companion r0, com.obric.memorydata.personalcontext.task.a r1) {
            r0.persistRecoveryDemand(r1);
        }

        public static final /* synthetic */ com.obric.memorydata.personalcontext.task.a access$readRecoveryDemand(Companion r0) {
            return r0.readRecoveryDemand();
        }

        public static final /* synthetic */ com.obric.memorydata.personalcontext.task.a access$readRecoveryDemandFromStore(Companion r0) {
            return r0.readRecoveryDemandFromStore();
        }

        public static final /* synthetic */ void access$recordRecoveryStartTime(Companion r0) {
            r0.recordRecoveryStartTime();
        }

        private final long calculateRecoveryDelayMinutes() {
            long r0 = System.currentTimeMillis();
            long r5 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getLong(EntityConsistencyCheckTask.KEY_RECOVERY_LAST_START_TIME, 0);
            if (r5 <= 0) goto L5;
            long r6 = r5 + 600000;
        L7:
            return ((RangesKt.coerceAtLeast(r6 - r0, 0) + 60000) - 1) / 60000;
        L5:
            r6 = 0;
            goto L7
        }

        private static final Unit checkContactSmsEntity$lambda$12(List r9, int r10) {
            List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "entityIds");
            IEntityManager.a.a((IEntityManager) ZeusTransformUtils.preCheckCast(EntityManager.INSTANCE, IEntityManager.class, "com.obric.memorydata.plugin"), r3, r10, EntityConsistencyCheckTask.Companion.getPackageName(r10), null, 8, null);
            return Unit.INSTANCE;
        }

        private static final Bundle checkContactSmsEntity$lambda$13(boolean r8, Ref.BooleanRef r9, Uri r10, String r11, Bundle r12) {
            Intrinsics.checkNotNullParameter(r10, "uri");
            Intrinsics.checkNotNullParameter(r11, "method");
            Bundle r2 = new Bundle();     // Catch: Exception -> L42
            if (Intrinsics.areEqual(r11, "syncDataCheckCountDiff") == false) goto L20;
            if (r12 == null) goto L8;
            ArrayList r13 = r12.getParcelableArrayList("syncCountTimeSlotDataList");     // Catch: Exception -> L42
        L9:
            if (r12 == null) goto L11;
            Integer r14 = Integer.valueOf(r12.getInt("syncDataEntityType", -1));     // Catch: Exception -> L42
        L12:
            if (r13 == null) goto L46;
            if (r14 != null) goto L16;
        L17:
            if (r14 == null) goto L46;
            r2.putParcelableArrayList("checkDiffResult", e.f12369a.a((List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.memorydata.plugin"), r14.intValue(), EntityConsistencyCheckTask.Companion.getPackageName(r14.intValue()), r8));     // Catch: Exception -> L42
            goto L46
        L16:
            if (r14.intValue() != (-1)) goto L17;
        L46:
            return r2;
        L11:
            r14 = null;
            goto L12
        L8:
            r13 = null;
            goto L9
        L20:
            if (Intrinsics.areEqual(r11, "syncDataCheckHashCodeDiff") == false) goto L46;
            if (r12 == null) goto L23;
            EntityCheckHashCodeSlotData r15 = (EntityCheckHashCodeSlotData) ZeusTransformUtils.preCheckCast(r12.getParcelable("syncHashCodeSlotDataList"), EntityCheckHashCodeSlotData.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L42
        L24:
            if (r12 == null) goto L26;
            Integer r16 = Integer.valueOf(r12.getInt("syncDataEntityType", -1));     // Catch: Exception -> L42
        L27:
            if (r15 == null) goto L46;
            if (r16 != null) goto L31;
        L32:
            if (r16 == null) goto L46;
            boolean r5 = true;
            e.a r17 = e.f12369a.a(r15, r16.intValue(), EntityConsistencyCheckTask.Companion.getPackageName(r16.intValue()), true);     // Catch: Exception -> L42
            r2.putStringArrayList("checkDiffResult", r17.a());     // Catch: Exception -> L42
            Collection r18 = (Collection) ZeusTransformUtils.preCheckCast(r17.b(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L42
            if (r18 != null) goto L36;
        L39:
            if (r5 == true) goto L46;
            r2.putStringArrayList("dataLazyDelete", r17.b());     // Catch: Exception -> L42
            goto L46
        L36:
            if (r18.isEmpty() == true) goto L39;
            r5 = false;
            goto L39
        L31:
            if (r16.intValue() == (-1)) goto L46;
        L26:
            r16 = null;
            goto L27
        L23:
            r15 = null;
        L42:
            e = move-exception;
            r9.element = false;
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityConsistencyCheckTask", ExceptionsKt.stackTraceToString((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")), null, 4, null);
            return null;
        }

        private final boolean checkShouldRunTask(boolean r14) {
            long r6 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getLong(EntityConsistencyCheckTask.LAST_RUN_ENTITY_SYNC_TASK_TIME, 0);
            if (Math.abs(System.currentTimeMillis() - r6) >= EntityConsistencyCheckTask.HOUR_MILLION_SECONDS_20) goto L10;
            if (r14 == false) goto L8;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityConsistencyCheckTask", "fatigue limit", false, 4, null);
            if (isCurrentSleepTime() == false) goto L8;
            EntityConsistencyCheckTask.access$setIgnoreSleepTime$cp(true);
        L8:
            return false;
        L10:
            if (Intrinsics.areEqual(com.obric.memorydata.personalcontext.d.f12081a.a("device_is_charge"), true) == true) goto L17;
            if (r14 == false) goto L15;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityConsistencyCheckTask", "device charge limit", false, 4, null);
            if (isCurrentSleepTime() == false) goto L15;
            EntityConsistencyCheckTask.access$setIgnoreSleepTime$cp(true);
        L15:
            return false;
        L17:
            if (Intrinsics.areEqual(com.obric.memorydata.personalcontext.d.f12081a.a("device_screen_state"), 0) == true) goto L24;
            if (r14 == false) goto L22;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityConsistencyCheckTask", "device_screen_state limit", false, 4, null);
            if (isCurrentSleepTime() == false) goto L22;
            EntityConsistencyCheckTask.access$setIgnoreSleepTime$cp(true);
        L22:
            return false;
        L24:
            if (IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getBoolean("is_on_avoid_data_import_switch_on", false) == false) goto L27;
            return false;
        L27:
            if (EntityConsistencyCheckTask.access$getIgnoreSleepTime$cp() == false) goto L29;
        L33:
            return true;
        L29:
            if (isCurrentSleepTime() == true) goto L33;
            if (r14 == false) goto L32;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityConsistencyCheckTask", "sleep time limit", false, 4, null);
        L32:
            return false;
        }

        private final void completeRecovery(com.obric.memorydata.personalcontext.task.a r1) {
            getRecoveryState().a(r1);
        }

        private final void enqueueRecoveryTask(long r3) {
            TaskRequest.Builder r2 = new TaskRequest.Builder(EntityConsistencyCheckTask.RECOVERY_TASK_NAME);
            if (r3 <= 0) goto L5;
            r2.setDelay(new g(r3, TimeUnit.MINUTES));
        L5:
            JSONObject r4 = new JSONObject();
            r4.put(EntityConsistencyCheckTask.KEY_IS_SYNC_AFTER_ENABLE_APP, true);
            ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(r2.setInputParam(r4), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setConditions(new Condition[]{Condition.TEMPERATURE_LOW_RANGE}), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExistingTaskPolicy(ExistingTaskPolicy.REPLACE_IN_QUEUE), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).enqueue();
        }

        static /* synthetic */ void enqueueRecoveryTask$default(Companion r0, long r1, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L5;
            r1 = 0;
        L5:
            r0.enqueueRecoveryTask(r1);
        }

        private static final Unit generatePackage2EntityTypeMap$lambda$16(Set r3, Map r4, Integer r5, com.obric.memorydata.database.index.e r6) {
            Set r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
            Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
            com.obric.memorydata.database.index.e r9 = (com.obric.memorydata.database.index.e) ZeusTransformUtils.wrapperContextForParams(r6, com.obric.memorydata.database.index.e.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "entityType");
            Intrinsics.checkNotNullParameter(r9, "entityIndex");
            if (r7.contains(r5) == false) goto L5;
            IAppEntityRawDbDao<com.obric.memorydata.database.entity.d> r10 = s.a().getRawDaoByEntityType(r5.intValue());
            if (r10 == null) goto L9;
            Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r10.getPackageNameList(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L12:
            if (r11.hasNext() == false) goto L20;
            String r12 = (String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.memorydata.plugin");
            Set r0 = (Set) ZeusTransformUtils.preCheckCast(r8.get(r12), Set.class, "com.obric.memorydata.plugin");
            if (r0 == null) goto L17;
            r0.add(r5);
            if (r0 == null) goto L17;
        L18:
            r8.put(r12, r0);
        L17:
            r0 = SetsKt.mutableSetOf(new Integer[]{r5});
            goto L18
        L20:
            return Unit.INSTANCE;
        L9:
            return Unit.INSTANCE;
        L5:
            return Unit.INSTANCE;
        }

        private static final void generatePackage2EntityTypeMap$lambda$17(Function2 r2, Object r3, Object r4) {
            ((Function2) ZeusTransformUtils.wrapperContextForParams(r2, Function2.class, "com.obric.memorydata.plugin")).invoke(r3, r4);
        }

        private final b getRecoveryState() {
            return (b) ZeusTransformUtils.preCheckCast(EntityConsistencyCheckTask.access$getRecoveryState$delegate$cp().getValue(), b.class, "com.obric.memorydata.plugin");
        }

        private final List<String> getSleepMoments() {
            return com.obric.memorydata.personalcontext.k.f12227a.a();
        }

        private final boolean isCurrentSleepTime() {
            List<String> r15 = getSleepMoments();
            Long r2 = null;
            if (r15.size() < 2) goto L22;
            String r0 = r15.get(0);
            if (ZeusTransformUtils.instanceOf(r0, String.class) == false) goto L7;
            String r1 = (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin");
        L8:
            if (r1 == null) goto L12;
            Integer r3 = r.c(r1);
            if (r3 == null) goto L12;
            Long r4 = Long.valueOf(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).intValue());
        L13:
            String r16 = r15.get(1);
            if (ZeusTransformUtils.instanceOf(r16, String.class) == false) goto L16;
            String r17 = (String) ZeusTransformUtils.preCheckCast(r16, String.class, "com.obric.memorydata.plugin");
        L17:
            if (r17 == null) goto L21;
            Integer r18 = r.c(r17);
            if (r18 == null) goto L21;
            r2 = Long.valueOf(((Number) ZeusTransformUtils.preCheckCast(r18, Number.class, "com.obric.memorydata.plugin")).intValue());
        L21:
            Long r19 = r2;
            r2 = r4;
        L23:
            if (r2 == null) goto L25;
            if (r19 == null) goto L25;
        L26:
            Long r5 = Long.valueOf(((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.memorydata.plugin")).longValue() * 60000);
            Long r110 = Long.valueOf(((Number) ZeusTransformUtils.preCheckCast(r19, Number.class, "com.obric.memorydata.plugin")).longValue() * 60000);
            if (((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin")).longValue() <= ((Number) ZeusTransformUtils.preCheckCast(r110, Number.class, "com.obric.memorydata.plugin")).longValue()) goto L29;
            r110 = Long.valueOf(((Number) ZeusTransformUtils.preCheckCast(r110, Number.class, "com.obric.memorydata.plugin")).longValue() + WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_DATE_MS);
        L29:
            long r7 = System.currentTimeMillis();
            long r9 = r.a(r7);
            long r11 = ((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin")).longValue() + r9;
            long r10 = r9 + ((Number) ZeusTransformUtils.preCheckCast(r110, Number.class, "com.obric.memorydata.plugin")).longValue();
            if (r11 <= r7) goto L32;
        L34:
            boolean r111 = false;
        L35:
            if (r111 == true) goto L46;
            long r8 = r7 + WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_DATE_MS;
            if (r11 <= r8) goto L39;
        L41:
            boolean r112 = false;
        L42:
            if (r112 == false) goto L45;
            return true;
        L45:
            return false;
        L39:
            if (r8 >= r10) goto L41;
            r112 = true;
            goto L42
        L46:
            return true;
        L32:
            if (r7 >= r10) goto L34;
            r111 = true;
        L25:
            r2 = Long.valueOf(r.b(EntityConsistencyCheckTask.DEFAULT_SLEEP_TIME_START));
            r19 = Long.valueOf(r.b(EntityConsistencyCheckTask.DEFAULT_SLEEP_TIME_END));
            goto L26
        L16:
            r17 = null;
        L12:
            r4 = null;
            goto L13
        L7:
            r1 = null;
            goto L8
        L22:
            r19 = null;
            goto L23
        }

        public static /* synthetic */ Unit lambda$A7EoTOFcucFCiFRqgtMU5Gri1nQ(Set r0, Map r1, Integer r2, com.obric.memorydata.database.index.e r3) {
            return generatePackage2EntityTypeMap$lambda$16(r0, r1, r2, r3);
        }

        public static /* synthetic */ void lambda$HEvmULBJaPEItTcuK3CgbQUxmKk(Function2 r0, Object r1, Object r2) {
            generatePackage2EntityTypeMap$lambda$17(r0, r1, r2);
        }

        /* JADX INFO: renamed from: lambda$L3uC2K3PCs-WhUl_c_RK0q0E88c, reason: not valid java name */
        public static /* synthetic */ Unit m1100lambda$L3uC2K3PCsWhUl_c_RK0q0E88c(List r0, int r1) {
            return checkContactSmsEntity$lambda$12(r0, r1);
        }

        public static /* synthetic */ Bundle lambda$PWaDu6fhhHslpM9UF8NAE8kxxns(boolean r0, Ref.BooleanRef r1, Uri r2, String r3, Bundle r4) {
            return checkContactSmsEntity$lambda$13(r0, r1, r2, r3, r4);
        }

        private final void markRecoveryPending(boolean r1) {
            getRecoveryState().a(r1);
        }

        private final void persistRecoveryDemand(com.obric.memorydata.personalcontext.task.a r5) {
            IStore r4 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null);
            r4.save(EntityConsistencyCheckTask.KEY_RECOVERY_SYNC_DONATE_APP, r5.b());
            r4.save(EntityConsistencyCheckTask.KEY_RECOVERY_PENDING, r5.a());
        }

        private final com.obric.memorydata.personalcontext.task.a readRecoveryDemand() {
            return getRecoveryState().a();
        }

        private final com.obric.memorydata.personalcontext.task.a readRecoveryDemandFromStore() {
            IStore r4 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null);
            return new com.obric.memorydata.personalcontext.task.a(r4.getBoolean(EntityConsistencyCheckTask.KEY_RECOVERY_PENDING, false), r4.getBoolean(EntityConsistencyCheckTask.KEY_RECOVERY_SYNC_DONATE_APP, false));
        }

        private final void recordRecoveryStartTime() {
            IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).save(EntityConsistencyCheckTask.KEY_RECOVERY_LAST_START_TIME, System.currentTimeMillis());
        }

        private final void restorePendingRecoveryTask() {
            if (readRecoveryDemand().a() == false) goto L6;
            enqueueRecoveryTask(calculateRecoveryDelayMinutes());
            return;
        }

        public static /* synthetic */ void triggerTask$default(Companion r0, boolean r1, boolean r2, boolean r3, int r4, Object r5) {
            if ((r4 & 2) == 0) goto L6;
            r2 = false;
        L6:
            if ((r4 & 4) == 0) goto L8;
            r3 = true;
        L8:
            r0.triggerTask(r1, r2, r3);
        }

        public final boolean checkContactSmsEntity(final boolean r11, Map<String, ? extends Set<Integer>> r12) {
            Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r10, "package2EntityTypeMap");
            if (UserSettings.INSTANCE.hasAgreePrivacy() == true) goto L6;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityConsistencyCheckTask", "syncContactSmsEntity, not agree privacy", false, 4, null);
            return false;
        L6:
            Set r13 = CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast(EntityCollectorService.INSTANCE.getDonateEntityTypeList(), Iterable.class, "com.obric.memorydata.plugin"));
            if (r13.isEmpty() == false) goto L10;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityConsistencyCheckTask", "syncContactSmsEntity, no self-collected entity type", false, 4, null);
            return true;
        L10:
            EntitySyncDataSupplier r5 = EntityCollectorService.INSTANCE.getEntitySyncDataSupplier();
            if (r5 != null) goto L13;
            return false;
        L13:
            final Ref.BooleanRef r1 = new Ref.BooleanRef();
            r1.element = true;
            Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin");
            Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10)), Collection.class, "com.obric.memorydata.plugin");
            Iterator r4 = r2.iterator();
        L15:
            if (r4.hasNext() == false) goto L17;
            int r6 = ((Number) ZeusTransformUtils.preCheckCast(r4.next(), Number.class, "com.obric.memorydata.plugin")).intValue();
            r3.add(EntityConsistencyCheckTask.Companion.getPackageName(r6));
            goto L15
        L17:
            Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
            Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
            Iterator r9 = r7.iterator();
        L19:
            if (r9.hasNext() == false) goto L24;
            Set r14 = (Set) ZeusTransformUtils.preCheckCast(r10.get((String) ZeusTransformUtils.preCheckCast(r9.next(), String.class, "com.obric.memorydata.plugin")), Set.class, "com.obric.memorydata.plugin");
            if (r14 != null) goto L23;
            r14 = SetsKt.emptySet();
        L23:
            CollectionsKt.addAll(r8, (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin"));
            goto L19
        L24:
            Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
            Collection r16 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
            Iterator r17 = r15.iterator();
        L26:
            if (r17.hasNext() == false) goto L30;
            Object r18 = r17.next();
            if (r13.contains(Integer.valueOf(((Number) ZeusTransformUtils.preCheckCast(r18, Number.class, "com.obric.memorydata.plugin")).intValue())) == false) goto L26;
            r16.add(r18);
            goto L26
        L30:
            List<Integer> r19 = CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r16, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
            EntitySyncUtil.INSTANCE.syncData(r5, null, r19, $$Lambda$EntityConsistencyCheckTask$Companion$L3uC2K3PCsWhUl_c_RK0q0E88c.INSTANCE, new $$Lambda$EntityConsistencyCheckTask$Companion$PWaDu6fhhHslpM9UF8NAE8kxxns(r11, r1));
            return r1.element;
        }

        public final Map<String, Set<Integer>> generatePackage2EntityTypeMap() {
            final Map<String, Set<Integer>> r3 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
            final Set<Integer> r0 = j.f12225a.b();
            HashMap<Integer, com.obric.memorydata.database.index.e> r1 = s.a().getEntityIndexImplMap();
            final Function2 r2 = new $$Lambda$EntityConsistencyCheckTask$Companion$A7EoTOFcucFCiFRqgtMU5Gri1nQ(r0, r3);
            r1.forEach(new $$Lambda$EntityConsistencyCheckTask$Companion$HEvmULBJaPEItTcuK3CgbQUxmKk(r2));
            return r3;
        }

        public final String getPackageName(int r3) {
            String r2 = EntityCollectorService.INSTANCE.getPackageNameByEntityType(r3);
            if (r2 == null) goto L5;
            return r2;
        L5:
            Ensure.ensureNotReachHere("sync data, unknown entity type: " + r3);
            throw new IllegalStateException("unknown entity type: " + r3);
        }

        public final String getSleepStartTimeOffsetDelayTime() {
            String r0 = com.obric.memorydata.personalcontext.k.f12227a.b();
            if (r0 != null) goto L6;
            return EntityConsistencyCheckTask.DEFAULT_SLEEP_TIME_START_WITH_OFFSET;
        L6:
            return r0;
        }

        public final void init() {
            if (EntityConsistencyCheckTask.access$isScribeScreenState$cp().compareAndSet(false, true) == true) goto L5;
            return;
        L5:
            TaskRegister.f12863a.a("EntityConsistencyCheckTask", EntityConsistencyCheckTask.class);
            TaskRegister.f12863a.a(EntityConsistencyCheckTask.RECOVERY_TASK_NAME, EntityConsistencyCheckTask.class);
            restorePendingRecoveryTask();
            EntityConsistencyCheckTask.access$getAbilityManager$cp().a(new com.obric.memorydata.ability.f(100000005, MapsKt.emptyMap()), (k) ZeusTransformUtils.preCheckCast(new a(), k.class, "com.obric.memorydata.plugin"));
        }

        public final boolean isCredentialProtectionLocked() {
            return !((UserManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService(UserManager.class), UserManager.class, "com.obric.memorydata.plugin")).isUserUnlocked();
        }

        public final void registerNextTask() {
            EntityConsistencyCheckTask.access$setSIsRegisterNextTask$cp(true);
            String r3 = getSleepStartTimeOffsetDelayTime();
            if (AppContext.INSTANCE.isDebug() == false) goto L5;
            String r15 = "nextSleepTime: " + r3;
        L6:
            EntityConsistencyCheckTask.access$setSNextTaskRegisterTime$cp(r3);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityConsistencyCheckTask", "registerNextSyncEntityTask " + r15, false, 4, null);
            ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder("EntityConsistencyCheckTask").setExistingTaskPolicy(ExistingTaskPolicy.REPLACE_IN_QUEUE), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setAlarmTimes(new AlarmTime[]{new AlarmTime(Type.ONCE, r3, null, null, 12, null)}), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).enqueue();
            return;
        L5:
            r15 = "";
            goto L6
        }

        public final void triggerTask(boolean r5, boolean r6, boolean r7) {
            if (r6 == false) goto L11;
            markRecoveryPending(r7);
            if (r5 == true) goto L6;
        L8:
            long r8 = calculateRecoveryDelayMinutes();
        L9:
            enqueueRecoveryTask(r8);
            return;
        L6:
            if (AppContext.INSTANCE.isDebug() == false) goto L8;
            r8 = 0;
            goto L9
        L11:
            TaskRequest.Builder r4 = new TaskRequest.Builder("EntityConsistencyCheckTask");
            if (r5 == true) goto L14;
        L19:
            if (r7 == true) goto L21;
            JSONObject r9 = new JSONObject();
            r9.put(EntityConsistencyCheckTask.KEY_IS_SYNC_DONATE_APP, false);
            r4.setInputParam(r9);
        L21:
            TaskRequest.Builder r10 = r4.setDelay(new g(10, TimeUnit.MINUTES));
        L22:
            TaskRequest.Builder r11 = (TaskRequest.Builder) ZeusTransformUtils.preCheckCast(r10, TaskRequest.Builder.class, "com.obric.memorydata.plugin");
            ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(r4.setExistingTaskPolicy(ExistingTaskPolicy.REPLACE_IN_QUEUE), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).enqueue();
            return;
        L14:
            if (AppContext.INSTANCE.isDebug() == false) goto L19;
            JSONObject r12 = new JSONObject();
            r12.put(EntityConsistencyCheckTask.KEY_IS_FAST_RUN_MODE, true);
            if (r7 == true) goto L18;
            r12.put(EntityConsistencyCheckTask.KEY_IS_SYNC_DONATE_APP, false);
        L18:
            r10 = r4.setInputParam(r12);
            goto L22
        }
    }

    static {
        Companion = new Companion(null);
        isScribeScreenState = new AtomicBoolean(false);
        abilityManager = new d();
        recoveryState$delegate = LazyKt.lazy($$Lambda$EntityConsistencyCheckTask$v7mknUFAjFjGFWbOof_8iZZCbQ.INSTANCE);
        sNextTaskRegisterTime = "";
    }

    public EntityConsistencyCheckTask(AbsTaskRequest r2) {
        Intrinsics.checkNotNullParameter(r2, "taskRequest");
        super(r2);
    }

    public static final /* synthetic */ d access$getAbilityManager$cp() {
        return abilityManager;
    }

    public static final /* synthetic */ boolean access$getIgnoreSleepTime$cp() {
        return ignoreSleepTime;
    }

    public static final /* synthetic */ Lazy access$getRecoveryState$delegate$cp() {
        return recoveryState$delegate;
    }

    public static final /* synthetic */ boolean access$getSIsRegisterNextTask$cp() {
        return sIsRegisterNextTask;
    }

    public static final /* synthetic */ String access$getSNextTaskRegisterTime$cp() {
        return sNextTaskRegisterTime;
    }

    public static final /* synthetic */ AtomicBoolean access$isScribeScreenState$cp() {
        return isScribeScreenState;
    }

    public static final /* synthetic */ void access$setIgnoreSleepTime$cp(boolean r0) {
        ignoreSleepTime = r0;
    }

    public static final /* synthetic */ void access$setSIsRegisterNextTask$cp(boolean r0) {
        sIsRegisterNextTask = r0;
    }

    public static final /* synthetic */ void access$setSNextTaskRegisterTime$cp(String r0) {
        sNextTaskRegisterTime = r0;
    }

    /* JADX INFO: renamed from: lambda$v7mknUFAjF-jGFWbOof_8iZZCbQ, reason: not valid java name */
    public static /* synthetic */ b m1099lambda$v7mknUFAjFjGFWbOof_8iZZCbQ() {
        return recoveryState_delegate$lambda$5();
    }

    private static final b recoveryState_delegate$lambda$5() {
        Companion r2 = Companion;
        return new b((Function0) ZeusTransformUtils.preCheckCast(new EntityConsistencyCheckTask$Companion$recoveryState$2$1(r2), Function0.class, "com.obric.memorydata.plugin"), (Function1) ZeusTransformUtils.preCheckCast(new EntityConsistencyCheckTask$Companion$recoveryState$2$2(r2), Function1.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    @Override // com.obric.memorydata.task.AbsTask
    public TaskResult run() {
        Companion r0 = Companion;
        sIsRegisterNextTask = false;
        TaskResult r10 = new TaskResult(0, null, null, null, 14, null);
        boolean r3 = Intrinsics.areEqual(getTaskRequest().getTaskParameter().getName(), RECOVERY_TASK_NAME);
        if (r3 == false) goto L5;
        a r5 = Companion.access$readRecoveryDemand(r0);
    L7:
        if (r3 == false) goto L17;
        if (r5 != null) goto L10;
    L12:
        boolean r8 = false;
    L13:
        if (r8 == true) goto L17;
        IRunLog r1 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        boolean r4 = false;
        int r6 = 4;
        Object r7 = null;
        String r2 = "EntityConsistencyCheckTask";
        String r9 = "skip stale recovery task";
    L15:
        IRunLog.a.a(r1, r2, r9, r4, r6, r7);
        return r10;
    L10:
        if (r5.a() != true) goto L12;
        r8 = true;
    L17:
        if (r3 == false) goto L19;
    L22:
        boolean r11 = true;
    L23:
        if (r11 == true) goto L30;
        if (Companion.access$checkShouldRunTask(r0, true) == true) goto L30;
        if (getTaskRequest().getTaskParameter().getInputParams().optBoolean(KEY_IS_FAST_RUN_MODE, false) == true) goto L30;
        return r10;
    L30:
        if (r0.isCredentialProtectionLocked() == false) goto L37;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityConsistencyCheckTask", "device is credential protection locked", false, 4, null);
        if (r3 == false) goto L36;
        if (r5 == null) goto L35;
        Companion.access$completeRecovery(r0, r5);
    L35:
        r10.setCode(1);
    L36:
        return r10;
    L37:
        if (r11 == true) goto L44;
        if (EvaluationService.INSTANCE.isAutoEvaluationMode() == false) goto L41;
    L42:
        r1 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r4 = false;
        r6 = 4;
        r7 = null;
        r2 = "EntityConsistencyCheckTask";
        r9 = "auto evaluation mode";
        goto L15
    L41:
        if (EvaluationService.INSTANCE.isCqcEvaluationMode() == true) goto L42;
    L44:
        if (IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getBoolean("is_disable_sync_entity_data", false) == false) goto L51;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityConsistencyCheckTask", "disable sync entity data", false, 4, null);
        if (r3 == false) goto L50;
        if (r5 == null) goto L49;
        Companion.access$completeRecovery(r0, r5);
    L49:
        r10.setCode(1);
    L50:
        return r10;
    L51:
        if (r3 == false) goto L53;
        Companion.access$recordRecoveryStartTime(r0);
    L53:
        long r13 = System.currentTimeMillis();
        if (r11 == false) goto L147;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityConsistencyCheckTask", "sync after enable app", false, 4, null);
        com.obric.memorydata.personalcontext.util.j.f12378a.b();
        e.f12369a.a(true);
    L147:
        ignoreSleepTime = false;     // Catch: Throwable -> L137
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityConsistencyCheckTask", "start sync entity data", false, 4, null);     // Catch: Throwable -> L137
        Map<String, Set<Integer>> r12 = r0.generatePackage2EntityTypeMap();     // Catch: Throwable -> L137
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityConsistencyCheckTask", "package2EntityTypeMap " + r12, false, 4, null);     // Catch: Throwable -> L137
        boolean r14 = r0.checkContactSmsEntity(false, r12);     // Catch: Exception -> L59 Throwable -> L137
    L62:
        if (r5 == null) goto L64;
        boolean r15 = r5.b();     // Catch: Throwable -> L137
    L65:
        if (r15 == false) goto L111;
        Iterator<String> r16 = EntityManager.INSTANCE.getSupportDonateEntityApps().iterator();     // Catch: Throwable -> L137
        Set r17 = CollectionsKt.toMutableSet((Iterable) ZeusTransformUtils.preCheckCast(EntityCollectorService.INSTANCE.getDonateEntityTypeList(), Iterable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L137
        if (r17.contains(301) == false) goto L70;
        r17.add(303);     // Catch: Throwable -> L137
        r17.add(302);     // Catch: Throwable -> L137
    L70:
        if (r16.hasNext() == false) goto L111;
        String r18 = (String) ZeusTransformUtils.preCheckCast(r16.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L137
        Uri r19 = com.obric.memorydata.personalcontext.util.h.f12375a.a(r18);     // Catch: Throwable -> L137
        boolean r31 = r14;
        r12 = r12;
        Set r20 = (Set) ZeusTransformUtils.preCheckCast(r12.get(r18), Set.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L137
        if (r20 != null) goto L74;
        r20 = SetsKt.emptySet();     // Catch: Throwable -> L137
    L74:
        Set r21 = SetsKt.minus(r20, (Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L137
        r17 = r17;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityConsistencyCheckTask", "start check appPackage " + r18 + ",check types=" + r21, false, 4, null);     // Catch: Throwable -> L137
        ContentResolver r22 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver();     // Catch: Throwable -> L137
        Bundle r23 = new Bundle();     // Catch: Exception -> L105 Throwable -> L137
        Iterator<String> r24 = r16;
        long r25 = r13;
        r23.putIntegerArrayList("sync_data_indexed_types", new ArrayList((Collection) ZeusTransformUtils.preCheckCast(r21, Collection.class, "com.obric.memorydata.plugin")));     // Catch: Exception -> L101 Throwable -> L137
        ContentProviderClient r26 = r22.acquireUnstableContentProviderClient(r19);     // Catch: Exception -> L101 Throwable -> L137
        if (r26 == null) goto L82;
        r26.call("data_check", null, r23);     // Catch: Throwable -> L89 Exception -> L91 DeadObjectException -> L95
        r26.close();     // Catch: Exception -> L101 Throwable -> L137
    L88:
        r14 = r31;
    L98:
        com.obric.memorydata.personalcontext.util.j.f12378a.a(r18);     // Catch: Exception -> L101 Throwable -> L137
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityConsistencyCheckTask", "end check appPackage " + r18, false, 4, null);     // Catch: Exception -> L101 Throwable -> L137
        r16 = r24;
        r13 = r25;
        goto L70
    L89:
        th = move-exception;
        r26.close();     // Catch: Exception -> L101 Throwable -> L137
        throw th;     // Catch: Exception -> L101 Throwable -> L137
    L91:
        e = move-exception;
        RunLog.INSTANCE.error("EntityConsistencyCheckTask", "provider call failed during data check, appPackage=" + r18, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L89
        Unit r27 = Unit.INSTANCE;     // Catch: Throwable -> L89
    L93:
        r26.close();     // Catch: Exception -> L101 Throwable -> L137
    L85:
        r14 = false;
    L95:
        e = move-exception;
        RunLog.INSTANCE.error("EntityConsistencyCheckTask", "unstable provider died during data check, appPackage=" + r18, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L89
        Unit r28 = Unit.INSTANCE;     // Catch: Throwable -> L89
        goto L93
    L82:
        if (Intrinsics.areEqual(r18, AppInfo.OAssistant.getPackageName()) == false) goto L84;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityConsistencyCheckTask", "failed to acquire unstable provider client, skip OAssistant data check", null, 4, null);     // Catch: Exception -> L101 Throwable -> L137
        goto L88
    L84:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityConsistencyCheckTask", "failed to acquire unstable provider client, appPackage=" + r18, null, 4, null);     // Catch: Exception -> L101 Throwable -> L137
    L101:
        e = e;
    L107:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityConsistencyCheckTask", ExceptionsKt.stackTraceToString((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")), null, 4, null);     // Catch: Throwable -> L137
        r16 = r24;
        r13 = r25;
        r14 = false;
    L105:
        e = e;
        r25 = r13;
        r24 = r16;
    L111:
        long r29 = r13;
        if (r11 == true) goto L143;
    L117:
        if (r3 == false) goto L120;
        if (r14 == false) goto L121;
        if (r15 == true) goto L120;
    L121:
        if (r14 == false) goto L128;
        if (r11 == false) goto L133;
        if (r3 == false) goto L126;
        if (r5 == null) goto L126;
        Companion.access$completeRecovery(Companion, r5);     // Catch: Throwable -> L137
    L126:
        if (r15 == false) goto L133;
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).save(EntityManager.KEY_NEED_REINDEX_AFTER_AGREE, false);     // Catch: Throwable -> L137
    L133:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityConsistencyCheckTask", "finish sync entity data, cost " + (System.currentTimeMillis() - r29), false, 4, null);     // Catch: Throwable -> L137
        if (r11 == false) goto L136;
        e.f12369a.a(false);
    L136:
        return r10;
    L128:
        if (r3 == false) goto L133;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityConsistencyCheckTask", "recovery sync failed, finish without retry", null, 4, null);     // Catch: Throwable -> L137
        if (r5 == null) goto L132;
        Companion.access$completeRecovery(Companion, r5);     // Catch: Throwable -> L137
    L132:
        r10.setCode(1);     // Catch: Throwable -> L137
    L120:
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).save(LAST_RUN_ENTITY_SYNC_TASK_TIME, System.currentTimeMillis());     // Catch: Throwable -> L137
        goto L121
    L143:
        com.obric.memorydata.personalcontext.util.j.f12378a.a();     // Catch: Exception -> L115 Throwable -> L137
    L115:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityConsistencyCheckTask", ExceptionsKt.stackTraceToString((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")), null, 4, null);     // Catch: Throwable -> L137
        r14 = false;
        goto L117
    L64:
        r15 = getTaskRequest().getTaskParameter().getInputParams().optBoolean(KEY_IS_SYNC_DONATE_APP, true);     // Catch: Throwable -> L137
        goto L65
    L59:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityConsistencyCheckTask", ExceptionsKt.stackTraceToString((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")), null, 4, null);     // Catch: Throwable -> L137
        r14 = false;
    L137:
        th = move-exception;
        if (r11 == false) goto L140;
        e.f12369a.a(false);
    L140:
        throw th;
    L19:
        if (getTaskRequest().getTaskParameter().getInputParams().optBoolean(KEY_IS_SYNC_AFTER_ENABLE_APP, false) == true) goto L22;
        r11 = false;
        goto L23
    L5:
        r5 = null;
        goto L7
    }
}
