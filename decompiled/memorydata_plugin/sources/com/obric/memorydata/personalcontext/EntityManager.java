package com.obric.memorydata.personalcontext;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.IndexTaskManager;
import com.obric.capabilitykit.entity.EntityContentProvider;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.CallHistoryEntity;
import com.obric.capabilitykit.entity.app.MessageEntity;
import com.obric.memorydata.constants.AppInfo;
import com.obric.memorydata.database.backup.appentity.AbstractFakeAppEntity;
import com.obric.memorydata.database.dao.IAppEntityRawDbDao;
import com.obric.memorydata.database.entity.cd;
import com.obric.memorydata.database.entity.ew;
import com.obric.memorydata.database.entity.ip;
import com.obric.memorydata.database.index.EntityIndexEngine;
import com.obric.memorydata.database.index.ao;
import com.obric.memorydata.database.index.bc;
import com.obric.memorydata.database.index.t;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.database.manager.MemoryFrameDb;
import com.obric.memorydata.memory.api.MemoryService;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.bdtracker.Tracker;
import com.obric.memorydata.middleware.api.device.DeviceInfoState;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.personalcontext.api.EntityCollectorService;
import com.obric.memorydata.personalcontext.api.EvaluationService;
import com.obric.memorydata.personalcontext.api.IEntityCollectorService;
import com.obric.memorydata.personalcontext.api.IEntityManager;
import com.obric.memorydata.personalcontext.task.EntityConsistencyCheckTask;
import com.obric.memorydata.task.condition.Condition;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.task.scheduler.impl.ExistingTaskPolicy;
import com.obric.memorydata.utils.at;
import com.obric.memorydata.utils.threadpool.ThreadPoolContainer;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.au;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bp;
import kotlinx.coroutines.w;
import kotlinx.coroutines.y;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b!\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0019\u001a\u00020\u0000H\u0007J\u0006\u0010\u0017\u001a\u00020\u0018J\u0010\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001cH\u0017J\u0018\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0005H\u0016J\"\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0005H\u0016J \u0010#\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0005H\u0016J&\u0010%\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00052\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014H\u0016J\u0018\u0010'\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010(\u001a\u00020)H\u0016J \u0010*\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010(\u001a\u00020)H\u0016J\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00050\u00142\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0014H\u0017J*\u0010-\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00052\b\b\u0002\u0010/\u001a\u00020\u0018H\u0007J;\u00100\u001a\b\u0012\u0004\u0012\u00020\u00050\u00142\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00050\u00142\u0006\u0010.\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00052\b\u0010/\u001a\u0004\u0018\u00010\u0018H\u0017¢\u0006\u0002\u00101J\u0018\u00102\u001a\u00020$2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u0018H\u0016J\u0010\u00106\u001a\u00020$2\u0006\u00105\u001a\u00020\u0018H\u0003J\u0010\u00107\u001a\u00020$2\u0006\u00105\u001a\u00020\u0018H\u0003J\u0016\u00108\u001a\u00020$2\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014H\u0017J\u0016\u0010:\u001a\u00020)2\u0006\u0010.\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0005J\u0016\u0010;\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0005J\u001e\u0010<\u001a\u00020$2\u0006\u0010.\u001a\u00020\u00072\u0006\u0010=\u001a\u00020)2\u0006\u0010\u001f\u001a\u00020\u0005J\u0010\u0010>\u001a\u00020$2\u0006\u0010\u001f\u001a\u00020\u0005H\u0017J\u0018\u0010?\u001a\u00020$2\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010@\u001a\u00020)H\u0007J\u0010\u0010A\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u0007H\u0017J\b\u0010B\u001a\u00020\u0018H\u0016J\u0018\u0010C\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0005H\u0016J\u000e\u0010D\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u0007J \u0010E\u001a\u00020\u00052\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00050\u00142\b\b\u0002\u0010F\u001a\u00020\u0007H\u0002J\b\u0010G\u001a\u00020\u0007H\u0016J\b\u0010>\u001a\u00020\u0007H\u0007J\b\u0010H\u001a\u00020$H\u0017J\u0010\u0010H\u001a\u00020$2\u0006\u00105\u001a\u00020\u0018H\u0007J\b\u0010I\u001a\u00020$H\u0007J\b\u0010J\u001a\u00020$H\u0007J\u001a\u0010K\u001a\u00020$2\u0006\u0010\u001f\u001a\u00020\u00052\b\b\u0002\u00105\u001a\u00020\u0018H\u0007J\u001e\u0010L\u001a\u00020$2\b\u0010M\u001a\u0004\u0018\u00010\u00052\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0014J\u0006\u0010N\u001a\u00020$J\u000e\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014H\u0007J\b\u0010P\u001a\u00020$H\u0016J\u000e\u0010Q\u001a\u00020$H\u0082@¢\u0006\u0002\u0010RJ\u000e\u0010S\u001a\u00020$H\u0082@¢\u0006\u0002\u0010RJ\b\u0010T\u001a\u00020$H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006U"}, d2 = {"Lcom/obric/memorydata/personalcontext/EntityManager;", "Lcom/obric/memorydata/personalcontext/api/IEntityManager;", "<init>", "()V", "TAG", "", "DELETE_BATCH_SIZE", "", "FILE_DELETE_BATCH_SIZE", "CLEAN_QUERY_PAGE_SIZE", "reIndexedPackageSet", "", "KEY_ALL_APP_ENTITY_DONATED", "KEY_NEED_REINDEX_AFTER_AGREE", "KEY_APP_ENTITY_DONATED_VERSION", "CURRENT_ENTITY_DONATED_VERSION", "registeredAgreePrivacyListener", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isCheckAllAppEntityDonated", "DEFAULT_SUPPORT_DONATE_APPS", "", "getDEFAULT_SUPPORT_DONATE_APPS", "()Ljava/util/List;", "isInLaunchFirstMinute", "", "getInst", "index", "appEntity", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "isLazyIndexEntity", "type", ObricMemoryConstants.KEY_PACKAGE_NAME, "getLazyIndexHistoryEntity", "", "entityId", "deleteLazyIndexHistoryEntity", "", "deleteLazyIndexHistoryEntityList", "entityIds", "removeLazyIndexHistoryEntity", "dbId", "", "resumeLazyIndexPendingTask", "bulkIndex", "entities", "delete", "entityType", "isBackUp", "bulkDelete", "(Ljava/util/List;ILjava/lang/String;Ljava/lang/Boolean;)Ljava/util/List;", "reindexAllData", "finishRunnable", "Ljava/lang/Runnable;", "noNeedDelete", "indexAllMediaFileData", "indexAllPhotoData", "reIndexCertainApps", "packageList", "queryLastModifiedTime", "queryCount", "syncDelete", "lastModifiedTime", "deleteAll", "deleteAllBeforeTimestamp", "cleanBeforeTimestamp", "deleteAllByEntityType", "isAllEntityDonated", "deleteByTypeAndPackageName", "getDeleteBatchSize", "getBulkDeleteLogSummary", "sampleSize", "getEntityDonatedVersion", "indexAllContactCallSmsEntity", "indexAllContactCallEntity", "indexAllMessageEntity", "notifyAppReindex", "bulkIndexThreadSafely", "taskName", "checkIfReDonateEntityWhenLaunch", "getSupportDonateEntityApps", "launchIndexTask", "checkIfReDonateEntityWhenLaunchInner", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createPhotoContentTimeIndexTaskForExistingData", "reportSyncAfterEnableAppEvent", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class EntityManager implements IEntityManager {
    private static final int CLEAN_QUERY_PAGE_SIZE = 500;
    private static final int CURRENT_ENTITY_DONATED_VERSION = 11;
    private static final List<String> DEFAULT_SUPPORT_DONATE_APPS = null;
    public static final int DELETE_BATCH_SIZE = 100;
    private static final int FILE_DELETE_BATCH_SIZE = 900;
    public static final EntityManager INSTANCE = null;
    private static final String KEY_ALL_APP_ENTITY_DONATED = "contact_sms_entity_donated";
    private static final String KEY_APP_ENTITY_DONATED_VERSION = "all_entity_donated_version";
    public static final String KEY_NEED_REINDEX_AFTER_AGREE = "need_reindex_after_agree";
    private static final String TAG = "EntityManager";
    private static final AtomicBoolean isCheckAllAppEntityDonated = null;
    private static volatile boolean isInLaunchFirstMinute;
    private static final Set<String> reIndexedPackageSet = null;
    private static AtomicBoolean registeredAgreePrivacyListener;

    /* JADX INFO: renamed from: com.obric.memorydata.personalcontext.EntityManager$checkIfReDonateEntityWhenLaunch$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.personalcontext.EntityManager$checkIfReDonateEntityWhenLaunch$2", f = "EntityManager.kt", i = {0}, l = {676, 680}, m = "invokeSuspend", n = {"startUserPrivacyState"}, s = {"Z$0"})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        boolean Z$0;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> r3) {
            super(2, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass2((Continuation) ZeusTransformUtils.wrapperContextForParams(r2, Continuation.class, "com.obric.memorydata.plugin")), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r7);
        L20:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            boolean r2 = this.Z$0;
            ResultKt.throwOnFailure(r7);
        L14:
            if (UserSettings.INSTANCE.hasAgreePrivacy() == false) goto L20;
            if (r2 == true) goto L20;
            EntityManager r8 = EntityManager.INSTANCE;
            Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 2;
            if (EntityManager.access$checkIfReDonateEntityWhenLaunchInner(r8, r3) != r0) goto L20;
            return r0;
        L10:
            ResultKt.throwOnFailure(r7);
            r2 = UserSettings.INSTANCE.hasAgreePrivacy();
            EntityManager r9 = EntityManager.INSTANCE;
            Continuation r5 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.Z$0 = r2;
            this.label = 1;
            if (EntityManager.access$checkIfReDonateEntityWhenLaunchInner(r9, r5) != r0) goto L14;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.personalcontext.EntityManager$checkIfReDonateEntityWhenLaunchInner$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.personalcontext.EntityManager", f = "EntityManager.kt", i = {0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 4}, l = {745, 747, 750, 778, 932}, m = "checkIfReDonateEntityWhenLaunchInner", n = {"this", "allEntityDonatedVersion", "this", "allEntityDonatedVersion", "this", "allEntityDonatedVersion", "this", "currentVersion", "this", "currentVersion", "isReindexAllData"}, s = {"L$0", "I$0", "L$0", "I$0", "L$0", "I$0", "L$0", "I$0", "L$0", "I$0", "I$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ EntityManager this$0;

        AnonymousClass1(EntityManager r3, Continuation<? super AnonymousClass1> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return EntityManager.access$checkIfReDonateEntityWhenLaunchInner(this.this$0, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        INSTANCE = new EntityManager();
        reIndexedPackageSet = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        registeredAgreePrivacyListener = new AtomicBoolean(false);
        isCheckAllAppEntityDonated = new AtomicBoolean(false);
        DEFAULT_SUPPORT_DONATE_APPS = CollectionsKt.listOf(new String[]{AppInfo.Recorder.getPackageName(), AppInfo.Gallery.getPackageName(), AppInfo.Alarm.getPackageName(), AppInfo.Note.getPackageName(), AppInfo.OAssistant.getPackageName(), AppInfo.AppletApp.getPackageName()});
        isInLaunchFirstMinute = true;
    }

    private EntityManager() {
    }

    public static final /* synthetic */ Object access$checkIfReDonateEntityWhenLaunchInner(EntityManager r2, Continuation r3) {
        return r2.checkIfReDonateEntityWhenLaunchInner((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ Object access$createPhotoContentTimeIndexTaskForExistingData(EntityManager r2, Continuation r3) {
        return r2.createPhotoContentTimeIndexTaskForExistingData((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private static final void bulkIndexThreadSafely$lambda$31(List r3, CountDownLatch r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        com.obric.capabilitykit.EntityProvider.bulkIndex$default(com.obric.capabilitykit.EntityProvider.INSTANCE, r5, null, 2, null);     // Catch: Throwable -> L6
        r4.countDown();
        return;
    L6:
        th = move-exception;
        r4.countDown();
        throw th;
    }

    private static final void checkIfReDonateEntityWhenLaunch$lambda$32(Set r8) {
        Set<String> r9 = (Set) ZeusTransformUtils.wrapperContextForParams(r8, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "packageNames");
        if (a.f12029a.a(r9) == false) goto L6;
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(bp.f17245a, al.class, "com.obric.memorydata.plugin"), (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new EntityManager$checkIfReDonateEntityWhenLaunch$1$1(null), Function2.class, "com.obric.memorydata.plugin"), 2, null);
        return;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:111:0x041a -> B:112:0x041b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x01a8 -> B:60:0x01a9). Please report as a decompilation issue!!! */
    private final Object checkIfReDonateEntityWhenLaunchInner(Continuation<? super Unit> r26) {
        EntityManager r0 = this;
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r26, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, AnonymousClass1.class) == false) goto L7;
        AnonymousClass1 r4 = (AnonymousClass1) ZeusTransformUtils.preCheckCast(r2, AnonymousClass1.class, "com.obric.memorydata.plugin");
        if ((r4.label & Integer.MIN_VALUE) == 0) goto L7;
        r4.label -= Integer.MIN_VALUE;
    L8:
        Object r3 = r4.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r4.label;
        if (r6 == 0) goto L22;
        if (r6 == 1) goto L21;
        if (r6 == 2) goto L20;
        if (r6 == 3) goto L19;
        if (r6 == 4) goto L18;
        if (r6 != 5) goto L17;
        int r1 = r4.I$1;
        int r7 = r4.I$0;
        EntityManager r8 = (EntityManager) ZeusTransformUtils.preCheckCast(r4.L$0, EntityManager.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
        AnonymousClass1 r24 = r4;
        EntityManager r9 = r8;
        int r10 = r7;
        Object r11 = r5;
        AnonymousClass1 r12 = r24;
    L60:
        int r13 = r1;
        int r14 = r10;
    L112:
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).save(KEY_APP_ENTITY_DONATED_VERSION, r14);
    L51:
        if (r14 >= 11) goto L113;
        r10 = r14 + 1;
        switch(r10) {
            case 1: goto L106;
            case 2: goto L103;
            case 3: goto L99;
            case 4: goto L80;
            case 5: goto L78;
            case 6: goto L72;
            case 7: goto L69;
            case 8: goto L66;
            case 9: goto L63;
            case 10: goto L55;
            default: goto L111;
        };
    L55:
        if (r13 != 0) goto L111;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "create photo content time index task for existing data", false, 4, null);
        r12.L$0 = r9;
        r12.I$0 = r10;
        r12.I$1 = r13;
        r12.label = 5;
        if (r9.createPhotoContentTimeIndexTaskForExistingData(r12) != r11) goto L59;
        return r11;
    L59:
        r1 = r13;
        goto L60
    L72:
        r9.deleteByTypeAndPackageName(401, AppInfo.Calendar.getPackageName());
        Uri r17 = com.obric.memorydata.personalcontext.util.h.f12375a.a(AppInfo.OAssistant.getPackageName());     // Catch: Exception -> L75
        ContentResolver r16 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver();     // Catch: Exception -> L75
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "notify OAssistant reindex start", false, 4, null);     // Catch: Exception -> L75
        ZeusProviderTransform.call(r16, r17, EntityContentProvider.d, null, null, "com.obric.memorydata.plugin");     // Catch: Exception -> L75
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "notify OAssistant reindex end", false, 4, null);     // Catch: Exception -> L75
    L75:
        e = move-exception;
        RunLog.INSTANCE.error(TAG, "notify OAssistant reindex error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        goto L111
    L80:
        IRunLog r18 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        if (r13 == 0) goto L83;
        IRunLog.a.a(r18, TAG, "no need reindex CallHistoryEntity entity", false, 4, null);
        goto L111
    L83:
        IRunLog.a.a(r18, TAG, "will index CallHistoryEntity entity, transcriptTitle is not empty", false, 4, null);
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(EntityCollectorService.INSTANCE.getAllCallHistoryData(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r19 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r20 = r15.iterator();
    L85:
        if (r20.hasNext() == false) goto L95;
        Object r110 = r20.next();
        AppEntity r111 = (AppEntity) ZeusTransformUtils.preCheckCast(r110, AppEntity.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r111, CallHistoryEntity.class) == true) goto L89;
    L91:
        boolean r112 = false;
    L92:
        if (r112 == false) goto L85;
        r19.add(r110);
        goto L85
    L89:
        if (at.a(((CallHistoryEntity) ZeusTransformUtils.preCheckCast(r111, CallHistoryEntity.class, "com.obric.memorydata.plugin")).getTranscriptTitle()) == false) goto L91;
        r112 = true;
        goto L92
    L95:
        final List r21 = (List) ZeusTransformUtils.preCheckCast(r19, List.class, "com.obric.memorydata.plugin");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r21, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L98;
        final CountDownLatch r22 = new CountDownLatch(1);
        IndexTaskManager.INSTANCE.runTask("indexCallHistoryTranscriptTitle", new $$Lambda$EntityManager$dP_AK3mC9DllMNmHc0PrVQ3tgVc(r21, r22));
        r22.await();
    L98:
        IRunLog r113 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        boolean r23 = false;
        int r25 = 4;
        Object r27 = null;
        String r114 = TAG;
        String r28 = "index CallHistoryEntity entity, finish";
    L105:
        IRunLog.a.a(r113, r114, r28, r23, r25, r27);
        goto L111
    L99:
        r113 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r23 = false;
        r25 = 4;
        r27 = null;
        r114 = TAG;
        if (r13 == 0) goto L102;
        r28 = "no need index file entity";
        goto L105
    L102:
        IRunLog.a.a(r113, TAG, "will index media file entity", false, 4, null);
        r9.indexAllMediaFileData(false);
        goto L111
    L103:
        if (r13 == 0) goto L111;
        r113 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r23 = false;
        r25 = 4;
        r27 = null;
        r114 = TAG;
        r28 = "no need index calendar entity";
        goto L105
    L106:
        final w r29 = y.a(null, 1, null);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "donate all entity task start", false, 4, null);
        r9.reindexAllData(new $$Lambda$EntityManager$8u3RWuFDJpN8yGDXLyhf3WIbs0(r29), true);
        r12.L$0 = r9;
        r12.I$0 = r10;
        r12.label = 4;
        if (r29.a(r12) != r11) goto L109;
        return r11;
    L109:
        r14 = r10;
        r13 = 1;
    L111:
        r14 = r10;
        goto L112
    L63:
        if (r13 != 0) goto L111;
        com.obric.memorydata.personalcontext.storage.h.f12345a.a();
        goto L111
    L66:
        if (r13 != 0) goto L111;
        boolean r115 = false;
        int r210 = 4;
        Object r211 = null;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "RawICSProtocolEntity reindex by appletapp start", false, 4, null);
        r9.deleteByTypeAndPackageName(402, AppInfo.OAssistant.getPackageName());
        r9.notifyAppReindex(AppInfo.AppletApp.getPackageName(), true);
        IRunLog r116 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        String r117 = TAG;
        String r118 = "RawICSProtocolEntity reindex by appletapp end";
    L71:
        IRunLog.a.a(r116, r117, r118, r115, r210, r211);
        goto L111
    L69:
        if (r13 != 0) goto L111;
        r115 = false;
        r210 = 4;
        r211 = null;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "insertExistingDataMetaInfoFullContentTask start", false, 4, null);
        t.f9438a.g();
        r116 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r117 = TAG;
        r118 = "insertExistingDataMetaInfoFullContentTask end";
        goto L71
    L78:
        if (r13 != 0) goto L111;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "indexCommonPhotoEntity start", false, 4, null);
        final CountDownLatch r30 = new CountDownLatch(1);
        IndexTaskManager.INSTANCE.runTask("indexCommonPhotoEntity", new $$Lambda$EntityManager$ucPdJadso_xPQsZbmW6sioPemJ8(r30));
        r30.await();
        goto L111
    L113:
        t.f9438a.e();
        if (UserSettings.INSTANCE.hasAgreePrivacy() == true) goto L116;
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).save(KEY_NEED_REINDEX_AFTER_AGREE, true);
    L123:
        return Unit.INSTANCE;
    L116:
        if (IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getBoolean(KEY_NEED_REINDEX_AFTER_AGREE, false) == false) goto L123;
        RunLog r31 = RunLog.INSTANCE;
        if (r13 != 0) goto L120;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(r31, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "donate all entity task after agree privacy", false, 4, null);
        r9.reportSyncAfterEnableAppEvent();
        EntityConsistencyCheckTask.Companion.triggerTask(false, true, true);
        goto L123
    L120:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(r31, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "donate all entity task after agree privacy, but no need index", false, 4, null);
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).save(KEY_NEED_REINDEX_AFTER_AGREE, false);
        goto L123
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        r14 = r4.I$0;
        EntityManager r32 = (EntityManager) ZeusTransformUtils.preCheckCast(r4.L$0, EntityManager.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
        r11 = r5;
        r12 = r4;
        r9 = r32;
        r13 = 1;
        goto L112
    L19:
        r14 = r4.I$0;
        EntityManager r33 = (EntityManager) ZeusTransformUtils.preCheckCast(r4.L$0, EntityManager.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
        Object r34 = r3;
        EntityManager r35 = r33;
    L42:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r34, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L45;
        r35.launchIndexTask();
    L45:
        if (EvaluationService.INSTANCE.isAutoEvaluationMode() == false) goto L47;
    L124:
        if (r14 <= 0) goto L127;
        t.f9438a.e();
    L127:
        return Unit.INSTANCE;
    L47:
        if (EvaluationService.INSTANCE.isCqcEvaluationMode() == true) goto L124;
        r11 = r5;
        r12 = r4;
        r9 = r35;
        r13 = 0;
        goto L51
    L20:
        r14 = r4.I$0;
        EntityManager r36 = (EntityManager) ZeusTransformUtils.preCheckCast(r4.L$0, EntityManager.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
        Object r37 = r3;
        r35 = r36;
    L36:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r37, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L38;
        r35.launchIndexTask();
    L38:
        CallHistorySourceNumberBackfillManager r38 = CallHistorySourceNumberBackfillManager.f12002a;
        r4.L$0 = r35;
        r4.I$0 = r14;
        r4.label = 3;
        r34 = r38.a(r4);
        if (r34 != r5) goto L42;
        return r5;
    L21:
        int r39 = r4.I$0;
        EntityManager r40 = (EntityManager) ZeusTransformUtils.preCheckCast(r4.L$0, EntityManager.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
        int r41 = r39;
        r0 = r40;
    L31:
        isInLaunchFirstMinute = false;
        b r42 = b.f12038a;
        r4.L$0 = r0;
        r4.I$0 = r41;
        r4.label = 2;
        r37 = r42.a(r4);
        if (r37 != r5) goto L34;
        return r5;
    L34:
        int r212 = r41;
        r35 = r0;
        r14 = r212;
        goto L36
    L22:
        ResultKt.throwOnFailure(r3);
        boolean r43 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getBoolean(KEY_ALL_APP_ENTITY_DONATED, false);
        r41 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getInt(KEY_APP_ENTITY_DONATED_VERSION, 1);
        if (r43 == true) goto L25;
        r41 = 0;
    L25:
        RunLog.INSTANCE.debug(TAG, "checkIfReDonateEntityWhenLaunch, allEntityDonatedVersion: " + r41);
        if (r41 != 0) goto L28;
        t.f9438a.d();
    L28:
        r4.L$0 = r0;
        r4.I$0 = r41;
        r4.label = 1;
        if (au.a(60000, r4) != r5) goto L31;
        return r5;
    L7:
        r4 = new AnonymousClass1(r0, r2);
        goto L8
    }

    private static final void checkIfReDonateEntityWhenLaunchInner$lambda$33(w r5) {
        w r6 = (w) ZeusTransformUtils.wrapperContextForParams(r5, w.class, "com.obric.memorydata.plugin");
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).save(KEY_ALL_APP_ENTITY_DONATED, true);
        r6.a(Unit.INSTANCE);
    }

    private static final void checkIfReDonateEntityWhenLaunchInner$lambda$35(List r3, CountDownLatch r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        com.obric.capabilitykit.EntityProvider.bulkIndex$default(com.obric.capabilitykit.EntityProvider.INSTANCE, r5, null, 2, null);     // Catch: Throwable -> L6
        r4.countDown();
        return;
    L6:
        th = move-exception;
        r4.countDown();
        throw th;
    }

    private static final void checkIfReDonateEntityWhenLaunchInner$lambda$37(CountDownLatch r11) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "CommonPhotoEntity build, will index MessageEntity", false, 4, null);     // Catch: Throwable -> L29
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(EntityCollectorService.INSTANCE.getAllSmsData(), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
        Iterator r3 = r1.iterator();     // Catch: Throwable -> L29
    L5:
        if (r3.hasNext() == false) goto L20;
        Object r4 = r3.next();     // Catch: Throwable -> L29
        AppEntity r5 = (AppEntity) ZeusTransformUtils.preCheckCast(r4, AppEntity.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
        boolean r6 = true;
        if (ZeusTransformUtils.instanceOf(r5, MessageEntity.class) == false) goto L17;
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(((MessageEntity) ZeusTransformUtils.preCheckCast(r5, MessageEntity.class, "com.obric.memorydata.plugin")).getFiles(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
        if (r7 != null) goto L11;
    L14:
        boolean r8 = true;
    L15:
        if (r8 == true) goto L17;
    L18:
        if (r6 == false) goto L5;
        r2.add(r4);     // Catch: Throwable -> L29
        goto L5
    L11:
        if (r7.isEmpty() == true) goto L14;
        r8 = false;
    L17:
        r6 = false;
        goto L18
    L20:
        com.obric.capabilitykit.EntityProvider.bulkIndex$default(com.obric.capabilitykit.EntityProvider.INSTANCE, (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"), null, 2, null);     // Catch: Throwable -> L29
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "CommonPhotoEntity build, index MessageEntity finish", false, 4, null);     // Catch: Throwable -> L29
        if (INSTANCE.getSupportDonateEntityApps().contains(AppInfo.Note.getPackageName()) == true) goto L34;
    L26:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "CommonPhotoEntity build, index MessageEntity and NoteEntity, finish", false, 4, null);     // Catch: Throwable -> L29
        r11.countDown();
        return;
    L34:
        Uri r9 = com.obric.memorydata.personalcontext.util.h.f12375a.a(AppInfo.Note.getPackageName());     // Catch: Exception -> L24 Throwable -> L29
        ContentResolver r10 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver();     // Catch: Exception -> L24 Throwable -> L29
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "CommonPhotoEntity build, NoteEntity reindex start", false, 4, null);     // Catch: Exception -> L24 Throwable -> L29
        ZeusProviderTransform.call(r10, r9, EntityContentProvider.d, null, null, "com.obric.memorydata.plugin");     // Catch: Exception -> L24 Throwable -> L29
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "CommonPhotoEntity build, NoteEntity reindex end", false, 4, null);     // Catch: Exception -> L24 Throwable -> L29
    L24:
        e = move-exception;
        RunLog.INSTANCE.error(TAG, "CommonPhotoEntity build, NoteEntity reindex error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        r11.countDown();
        throw th;
    }

    private final Object createPhotoContentTimeIndexTaskForExistingData(Continuation<? super Unit> r38) {
        Continuation r0 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r38, Continuation.class, "com.obric.memorydata.plugin");
        MemoryFrameDb r1 = MemoryDbEngine.INSTANCE.getGlobalDbEngine();     // Catch: Exception -> L57
        List r2 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L57
        int r3 = 100;
        Closeable r4 = (Closeable) ZeusTransformUtils.preCheckCast(r1.getPhotoRawDbDao().queryOldDataForContentTimeIndexPending(), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L57
        Cursor r5 = (Cursor) ZeusTransformUtils.preCheckCast(r4, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L50
        Integer r6 = Boxing.boxInt(r5.getColumnIndex(OaidModel.KEY_ID));     // Catch: Throwable -> L50
        boolean r8 = false;
        if (((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.memorydata.plugin")).intValue() < 0) goto L7;
        boolean r7 = true;
    L9:
        if (r7 == true) goto L12;
        r6 = null;
    L12:
        if (r6 == null) goto L43;
        int r9 = r6.intValue();     // Catch: Throwable -> L50
        Integer r10 = Boxing.boxInt(r5.getColumnIndex("timestamp"));     // Catch: Throwable -> L50
        if (((Number) ZeusTransformUtils.preCheckCast(r10, Number.class, "com.obric.memorydata.plugin")).intValue() < 0) goto L16;
        boolean r11 = true;
    L17:
        if (r11 == true) goto L20;
        r10 = null;
    L20:
        if (r10 == null) goto L43;
        int r12 = r10.intValue();     // Catch: Throwable -> L50
        Integer r13 = Boxing.boxInt(r5.getColumnIndex("createTime"));     // Catch: Throwable -> L50
        if (((Number) ZeusTransformUtils.preCheckCast(r13, Number.class, "com.obric.memorydata.plugin")).intValue() < 0) goto L24;
        r8 = true;
    L24:
        if (r8 == true) goto L27;
        r13 = null;
    L27:
        if (r13 == null) goto L43;
        int r14 = r13.intValue();     // Catch: Throwable -> L50
    L30:
        if (r5.moveToNext() == false) goto L40;
        long r15 = r5.getLong(r9);     // Catch: Throwable -> L50
        long r18 = r5.getLong(r12);     // Catch: Throwable -> L50
        long r20 = r5.getLong(r14);     // Catch: Throwable -> L50
        if (r1.getRawPhotoContentTimeDao().queryByRawDbId(r15) != null) goto L30;
        if (r1.getIndexPendingDao().queryByColumnContent(r15, 301, "insert_content_time_task").isEmpty() == false) goto L30;
        r2.add(new cd(0, r15, 301, r18, r20, 0, 0, "insert_content_time_task", "content_time", 0, 0, null, true, 0, 0, 28257, null));     // Catch: Throwable -> L50
        if (r2.size() < r3) goto L30;
        Closeable r39 = r4;
        ao.a(ao.f9372a, "PUBLIC", CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin")), (bc) ZeusTransformUtils.preCheckCast(new bc.a(System.currentTimeMillis()), bc.class, "com.obric.memorydata.plugin"), null, 8, null);     // Catch: Throwable -> L48
        r2.clear();     // Catch: Throwable -> L48
        r4 = r39;
        r3 = 100;
    L48:
        th = th;
        r4 = r39;
    L51:
        Throwable r16 = th;
        throw r16;     // Catch: Throwable -> L53
    L53:
        th = move-exception;
        CloseableKt.closeFinally(r4, r16);     // Catch: Exception -> L57
        throw th;     // Catch: Exception -> L57
    L40:
        r39 = r4;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L44;
        ao.a(ao.f9372a, "PUBLIC", CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin")), (bc) ZeusTransformUtils.preCheckCast(new bc.a(System.currentTimeMillis()), bc.class, "com.obric.memorydata.plugin"), null, 8, null);     // Catch: Throwable -> L48
    L44:
        Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L48
        CloseableKt.closeFinally(r39, null);     // Catch: Exception -> L57
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "createPhotoContentTimeIndexTaskForExistingData completed", false, 4, null);     // Catch: Exception -> L57
    L60:
        return Unit.INSTANCE;
    L16:
        r11 = false;
    L43:
        r39 = r4;
        goto L44
    L7:
        r7 = false;
    L50:
        th = th;
    L57:
        e = move-exception;
        RunLog.INSTANCE.error(TAG, "createPhotoContentTimeIndexTaskForExistingData error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        goto L60
    }

    public static /* synthetic */ boolean delete$default(EntityManager r0, String r1, int r2, String r3, boolean r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L6;
        r4 = false;
    L6:
        return r0.delete(r1, r2, r3, r4);
    }

    private final String getBulkDeleteLogSummary(List<String> r3, int r4) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        return "count=" + r2.size() + ", sample=" + CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin"), r4);
    }

    static /* synthetic */ String getBulkDeleteLogSummary$default(EntityManager r1, List r2, int r3, int r4, Object r5) {
        List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L6;
        r3 = 3;
    L6:
        return r1.getBulkDeleteLogSummary(r6, r3);
    }

    @JvmStatic
    public static final EntityManager getInst() {
        return INSTANCE;
    }

    private final void indexAllMediaFileData(boolean r7) {
        if (EntityCollectorService.INSTANCE.hasPermission(IEntityCollectorService.FILE_TAG) == true) goto L7;
        IRunLog r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        String r1 = TAG;
        String r2 = "indexAllMediaFileData, file permission not granted";
    L5:
        IRunLog.a.a(r0, r1, r2, false, 4, null);
        return;
    L7:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "indexAllMediaFileData BEGIN", false, 4, null);
        Set<String> r6 = reIndexedPackageSet;
        monitor-enter(r6);
    L17:
        th = move-exception;
        throw th;
    L10:
        if (r6.contains(IEntityCollectorService.FILE_TAG) == false) goto L14;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "notifyAppIndex mediaFile has been indexed", false, 4, null);     // Catch: Throwable -> L17
        monitor-exit(r6);
        return;
    L14:
        r6.add(IEntityCollectorService.FILE_TAG);     // Catch: Throwable -> L17
        monitor-exit(r6);
        EntityCollectorService.INSTANCE.reIndexData(IEntityCollectorService.FILE_TAG, r7);
        r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r1 = TAG;
        r2 = "indexAllMediaFileData END";
        goto L5
    }

    private final void indexAllPhotoData(boolean r7) {
        if (DeviceInfoState.INSTANCE.getSelfCollectionEntitySupport().a(301) == true) goto L7;
        RunLog.INSTANCE.debug(TAG, "indexAllPhotoData, photo collector not supported");
        return;
    L7:
        if (EntityCollectorService.INSTANCE.hasPermission(IEntityCollectorService.PHOTO_TAG) == true) goto L10;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "indexAllPhotoData, photo permission not granted", false, 4, null);
        return;
    L10:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "indexAllPhotoData BEGIN", false, 4, null);
        Set<String> r6 = reIndexedPackageSet;
        monitor-enter(r6);
    L21:
        th = move-exception;
        throw th;
    L13:
        if (r6.contains(IEntityCollectorService.PHOTO_TAG) == false) goto L17;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "notifyAppIndex photo has been indexed", false, 4, null);     // Catch: Throwable -> L21
        monitor-exit(r6);
        return;
    L17:
        r6.add(IEntityCollectorService.PHOTO_TAG);     // Catch: Throwable -> L21
        monitor-exit(r6);
        EntityCollectorService.INSTANCE.reIndexData(IEntityCollectorService.PHOTO_TAG, r7);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "indexAllPhotoData END", false, 4, null);
    }

    /* JADX INFO: renamed from: lambda$8u-3RWuFDJpN8yGDXLyhf3WIbs0, reason: not valid java name */
    public static /* synthetic */ void m1043lambda$8u3RWuFDJpN8yGDXLyhf3WIbs0(w r0) {
        checkIfReDonateEntityWhenLaunchInner$lambda$33(r0);
    }

    /* JADX INFO: renamed from: lambda$_zWs720NT3-Z5qVpaQo2MXWXsPg, reason: not valid java name */
    public static /* synthetic */ void m1044lambda$_zWs720NT3Z5qVpaQo2MXWXsPg(boolean r0, Runnable r1) {
        reindexAllData$lambda$8(r0, r1);
    }

    public static /* synthetic */ void lambda$dP_AK3mC9DllMNmHc0PrVQ3tgVc(List r0, CountDownLatch r1) {
        checkIfReDonateEntityWhenLaunchInner$lambda$35(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$e6p0JCUYuZh82SD-nFprAR8VfXs, reason: not valid java name */
    public static /* synthetic */ void m1045lambda$e6p0JCUYuZh82SDnFprAR8VfXs(List r0, CountDownLatch r1) {
        bulkIndexThreadSafely$lambda$31(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$hZgea-vl71U7UNb2-sM67fBe0Kc, reason: not valid java name */
    public static /* synthetic */ Unit m1046lambda$hZgeavl71U7UNb2sM67fBe0Kc(String r0) {
        return notifyAppReindex$lambda$29(r0);
    }

    /* JADX INFO: renamed from: lambda$iiM-PBTAai7kYYurtMc8B3TGfO8, reason: not valid java name */
    public static /* synthetic */ void m1047lambda$iiMPBTAai7kYYurtMc8B3TGfO8(Set r0) {
        checkIfReDonateEntityWhenLaunch$lambda$32(r0);
    }

    public static /* synthetic */ void lambda$ucPdJadso_xPQsZbmW6sioPemJ8(CountDownLatch r0) {
        checkIfReDonateEntityWhenLaunchInner$lambda$37(r0);
    }

    public static /* synthetic */ void notifyAppReindex$default(EntityManager r0, String r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        r0.notifyAppReindex(r1, r2);
    }

    private static final Unit notifyAppReindex$lambda$29(String r7) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "device is credential protection locked, packageName: " + r7, null, 4, null);
        return Unit.INSTANCE;
    }

    private static final void reindexAllData$lambda$8(boolean r6, Runnable r7) {
        Runnable r8 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r7, Runnable.class, "com.obric.memorydata.plugin");
        EntityManager r0 = INSTANCE;
        r0.indexAllContactCallSmsEntity(r6);
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r0.getSupportDonateEntityApps(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");
        INSTANCE.notifyAppReindex(r2, r6);
        goto L4
    L6:
        EntityManager r3 = INSTANCE;
        r3.indexAllMediaFileData(r6);
        r3.indexAllPhotoData(r6);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "indexAllPackage end", false, 4, null);
        r8.run();
    }

    private final void reportSyncAfterEnableAppEvent() {
        Tracker r4 = Tracker.INSTANCE;
        JSONObject r0 = new JSONObject();
        r0.put("syncTimeStamp", System.currentTimeMillis());
        Unit r1 = Unit.INSTANCE;
        r4.reportEvent("sync_after_enable_app", r0);
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityManager
    public List<String> bulkDelete(List<String> r19, int r20, String r21, Boolean r22) {
        List<String> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "entityIds");
        Intrinsics.checkNotNullParameter(r21, ObricMemoryConstants.KEY_PACKAGE_NAME);
        int r6 = 2;
        Object r5 = null;
        String r4 = ", entityType: ";
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, new StringBuilder().append("bulkDelete ").append(getBulkDeleteLogSummary$default(this, r2, 0, 2, null)).append(", entityType: ").append(r20).append(", packageName: ").append(r21).toString(), false, 4, null);
        if (r20 != (-303)) goto L5;
        int r9 = -306;
    L7:
        if (Intrinsics.areEqual(r22, true) == true) goto L12;
        if (r9 != (-401)) goto L10;
        List<ip> r3 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getSemanticMemoryDao().queryByEntityIds(r2);
    L11:
        com.obric.memorydata.personalcontext.external.a.b.f12100a.a(r2, r9, r21);
    L13:
        if (r20 != (-401)) goto L27;
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L17;
    L20:
        boolean r1 = true;
    L21:
        if (r1 == true) goto L27;
        MemoryService r7 = MemoryService.INSTANCE;
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin");
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r8.iterator();
    L24:
        if (r10.hasNext() == false) goto L26;
        r11.add(Long.valueOf(((ip) ZeusTransformUtils.preCheckCast(r10.next(), ip.class, "com.obric.memorydata.plugin")).getId()));
        goto L24
    L26:
        r7.onSemanticMemoryDeleted((List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.memorydata.plugin"));
        goto L27
    L17:
        if (r0.isEmpty() == true) goto L20;
        r1 = false;
    L27:
        q r12 = q.f12255a;
        if (r22 == null) goto L30;
        boolean r13 = r22.booleanValue();
    L31:
        com.obric.memorydata.personalcontext.storage.a r14 = r12.a(r9, r13);
        if (r14 != null) goto L34;
    L36:
        boolean r15 = false;
    L37:
        if (r15 == false) goto L39;
        List<String> r16 = r14.a(r2, r9, r21);
        String r17 = ", entityType: ";
        int r18 = 2;
    L47:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "bulkDelete success " + getBulkDeleteLogSummary$default(INSTANCE, r16, 0, r18, null) + r17 + r9, false, 4, null);
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r16, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L50;
        List<ew> r23 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getProactiveMemorySyncPendingDao().queryByTypeAndEntityIds(r16);
        MemoryDbEngine.INSTANCE.getGlobalDbEngine().getProactiveMemorySyncPendingDao().updateAll(r23);
        RunLog.INSTANCE.debug(TAG, "pendingEntities: " + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r23, Iterable.class, "com.obric.memorydata.plugin"), null, null, null, 0, null, null, 63, null));
    L50:
        return r16;
    L39:
        List<String> r110 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r111 = ((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L41:
        if (r111.hasNext() == false) goto L46;
        String r112 = (String) ZeusTransformUtils.preCheckCast(r111.next(), String.class, "com.obric.memorydata.plugin");
        String r113 = r4;
        int r114 = r6;
        if (delete$default(INSTANCE, r112, r9, r21, false, 8, null) == false) goto L45;
        r110.add(r112);
    L45:
        r4 = r113;
        r6 = r114;
        r5 = null;
        goto L41
    L46:
        r17 = r4;
        r18 = r6;
        r16 = r110;
        goto L47
    L34:
        if (r14.a() != true) goto L36;
        r15 = true;
        goto L37
    L30:
        r13 = false;
        goto L31
    L10:
        r3 = null;
        goto L11
    L12:
        r3 = null;
        goto L13
    L5:
        r9 = r20;
        goto L7
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityManager
    public List<String> bulkIndex(List<? extends AppEntity> r11) {
        List<? extends AppEntity> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "entities");
        com.obric.memorydata.personalcontext.external.a.b.f12100a.a(r12);
        Set<Pair<String, Integer>> r0 = l.f12228a.a(r12);
        List<String> r2 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L17;
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r5 = r3.iterator();
    L6:
        if (r5.hasNext() == false) goto L10;
        Object r6 = r5.next();
        AppEntity r7 = (AppEntity) ZeusTransformUtils.preCheckCast(r6, AppEntity.class, "com.obric.memorydata.plugin");
        if ((!r0.contains(new Pair(r7.getId(), Integer.valueOf(r7.getType())))) == false) goto L6;
        r4.add(r6);
        goto L6
    L10:
        List<? extends AppEntity> r8 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin");
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin");
        Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r13 = r9.iterator();
    L12:
        if (r13.hasNext() == false) goto L16;
        Object r14 = r13.next();
        AppEntity r15 = (AppEntity) ZeusTransformUtils.preCheckCast(r14, AppEntity.class, "com.obric.memorydata.plugin");
        if (r0.contains(new Pair(r15.getId(), Integer.valueOf(r15.getType()))) == false) goto L12;
        r10.add(r14);
        goto L12
    L16:
        r2.addAll((Collection) ZeusTransformUtils.preCheckCast(l.f12228a.b((List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.memorydata.plugin")), Collection.class, "com.obric.memorydata.plugin"));
    L18:
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L20:
        if (r1.hasNext() == false) goto L24;
        AppEntity r16 = (AppEntity) ZeusTransformUtils.preCheckCast(r1.next(), AppEntity.class, "com.obric.memorydata.plugin");
        if (INSTANCE.index(r16) == false) goto L20;
        r2.add(r16.getId());
        goto L20
    L24:
        launchIndexTask();
        com.obric.memorydata.personalcontext.external.a.b.f12100a.a(r12, r2);
        return r2;
    L17:
        r8 = r12;
        goto L18
    }

    public final void bulkIndexThreadSafely(String r3, List<? extends AppEntity> r4) {
        final List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "entities");
        final CountDownLatch r5 = new CountDownLatch(1);
        IndexTaskManager.INSTANCE.runTask(r3, new $$Lambda$EntityManager$e6p0JCUYuZh82SDnFprAR8VfXs(r2, r5));
        r5.await(60000, TimeUnit.MILLISECONDS);
    }

    public final void checkIfReDonateEntityWhenLaunch() {
        if (isCheckAllAppEntityDonated.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        com.obric.memorydata.aikernelcore.h.f8481a.a($$Lambda$EntityManager$iiMPBTAai7kYYurtMc8B3TGfO8.INSTANCE);
        i r9 = new i();
        com.obric.memorydata.personalcontext.state.b.f12338a.a((com.obric.memorydata.personalcontext.state.a) ZeusTransformUtils.preCheckCast(r9, com.obric.memorydata.personalcontext.state.a.class, "com.obric.memorydata.plugin"));
        com.obric.memorydata.personalcontext.state.b.f12338a.b((com.obric.memorydata.personalcontext.state.a) ZeusTransformUtils.preCheckCast(r9, com.obric.memorydata.personalcontext.state.a.class, "com.obric.memorydata.plugin"));
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(bp.f17245a, al.class, "com.obric.memorydata.plugin"), (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass2(null), Function2.class, "com.obric.memorydata.plugin"), 2, null);
    }

    public final boolean delete(String r7, int r8, String r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r7, "entityId");
        Intrinsics.checkNotNullParameter(r9, ObricMemoryConstants.KEY_PACKAGE_NAME);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "delete entityType: " + r8 + " entity: " + r7 + ", packageName: " + r9, false, 4, null);
        com.obric.memorydata.personalcontext.storage.a r6 = q.f12255a.a(r8, r10);
        if (r6 != null) goto L7;
        return false;
    L7:
        return r6.delete(r7, r9);
    }

    public final int deleteAll() {
        RunLog.INSTANCE.debug(TAG, "delete all entities");
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(com.obric.memorydata.database.index.s.a().getAllRawDao(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r0 = -1;
    L4:
        if (r11.hasNext() == false) goto L12;
        IAppEntityRawDbDao r1 = (IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r11.next(), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin");
        Collection r2 = r1.queryAll();
        r1.bulkDelete(r2);
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L7:
        if (r3.hasNext() == false) goto L11;
        com.obric.memorydata.database.entity.d r4 = (com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r3.next(), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin");
        if (r4.delete() == true) goto L7;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "delete failed entity: " + r4, null, 4, null);
        goto L7
    L11:
        r0 = r1.deleteAll();
        goto L4
    L12:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "delete all entities success, status: " + r0, false, 4, null);
        return r0;
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityManager
    public void deleteAll(String r19) {
        Intrinsics.checkNotNullParameter(r19, ObricMemoryConstants.KEY_PACKAGE_NAME);
        if (Intrinsics.areEqual(r19, AppContext.INSTANCE.getPackageName()) == false) goto L5;
    L33:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "delete all entities from self package: " + r19 + ", not supported", false, 4, null);
        return;
    L5:
        if (Intrinsics.areEqual(r19, com.obric.memorydata.BuildConfig.LIBRARY_PACKAGE_NAME) == true) goto L33;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "delete all entities from package: " + r19, false, 4, null);
        EntityIndexEngine r10 = com.obric.memorydata.database.index.s.a();
        boolean r11 = true;
        if (Intrinsics.areEqual(r19, AppInfo.AppletApp.getPackageName()) == false) goto L21;
        IAppEntityRawDbDao<com.obric.memorydata.database.entity.d> r0 = r10.getRawDaoByEntityType(402);
        if (r0 == null) goto L12;
        List r1 = r0.queryByPackageName(r19);
    L13:
        if (r1 == null) goto L21;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "delete all entities from package: " + r19 + ", entityType: 402, entityCount: " + r1.size() + ", bulkDelete", false, 4, null);
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r4 = r2.iterator();
    L16:
        if (r4.hasNext() == false) goto L18;
        r3.add(((com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r4.next(), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin")).getEntityId());
        goto L16
    L18:
        List r5 = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L21;
        IEntityManager.a.a((IEntityManager) ZeusTransformUtils.preCheckCast(this, IEntityManager.class, "com.obric.memorydata.plugin"), r5, 402, r19, null, 8, null);
        goto L21
    L12:
        r1 = null;
    L21:
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r10.getAllRawDao(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L23:
        if (r6.hasNext() == false) goto L30;
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r6.next(), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin")).queryByPackageName(r19), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L26:
        if (r7.hasNext() == false) goto L23;
        com.obric.memorydata.database.entity.d r8 = (com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r7.next(), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin");
        if (r8.delete() == true) goto L26;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "delete failed entity: " + r8, null, 4, null);
        r11 = false;
        goto L26
    L30:
        if (r11 == false) goto L42;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "delete all entities from package: " + r19 + " success", false, 4, null);
        return;
    }

    public final void deleteAllBeforeTimestamp(String r25, long r26) {
        Intrinsics.checkNotNullParameter(r25, ObricMemoryConstants.KEY_PACKAGE_NAME);
        if (Intrinsics.areEqual(r25, AppContext.INSTANCE.getPackageName()) == false) goto L5;
    L50:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "delete all entities from self package before timestamp: " + r25 + ", not supported", false, 4, null);
        return;
    L5:
        if (Intrinsics.areEqual(r25, com.obric.memorydata.BuildConfig.LIBRARY_PACKAGE_NAME) == true) goto L50;
        if (r26 > 0) goto L11;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "delete all entities from package: " + r25 + " before invalid timestamp: " + r26, null, 4, null);
        return;
    L11:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "delete all entities from package: " + r25 + " before timestamp: " + r26, false, 4, null);
        int r1 = 0;
        Iterator r15 = ((Iterable) ZeusTransformUtils.preCheckCast(com.obric.memorydata.database.index.s.a().getAllRawDao(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L13:
        if (r15.hasNext() == false) goto L48;
        IAppEntityRawDbDao r16 = (IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r15.next(), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin");
        int r17 = r1;
        long r5 = 0;
    L15:
        List r0 = r16.queryByPackageNameBeforeTimestampWithLimit(r25, r26, 500, r5);
        if (r0.isEmpty() == true) goto L17;
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        if (r2.hasNext() == false) goto L47;
        long r3 = ((com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r2.next(), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin")).getId();
    L21:
        long r18 = r3;
    L23:
        if (r2.hasNext() == false) goto L27;
        r3 = ((com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r2.next(), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin")).getId();
        if (r18 >= r3) goto L23;
    L27:
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Map r6 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r7 = r4.iterator();
    L29:
        if (r7.hasNext() == false) goto L34;
        Object r8 = r7.next();
        Integer r9 = Integer.valueOf(((com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r8, com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin")).getType());
        Object r10 = r6.get(r9);
        if (r10 != null) goto L33;
        r10 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r6.put(r9, r10);
    L33:
        ((List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.memorydata.plugin")).add(r8);
        goto L29
    L34:
        Iterator r20 = r6.entrySet().iterator();
    L36:
        if (r20.hasNext() == false) goto L45;
        Map.Entry r11 = (Map.Entry) ZeusTransformUtils.preCheckCast(r20.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        int r12 = ((Number) ZeusTransformUtils.preCheckCast(r11.getKey(), Number.class, "com.obric.memorydata.plugin")).intValue();
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r11.getValue(), List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r19 = r13.iterator();
    L39:
        if (r19.hasNext() == false) goto L41;
        r14.add(((com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r19.next(), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin")).getEntityId());
        goto L39
    L41:
        Iterator r21 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.chunked((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), INSTANCE.getDeleteBatchSize(r12)), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L43:
        if (r21.hasNext() == false) goto L36;
        r17 = r17 + IEntityManager.a.a((IEntityManager) ZeusTransformUtils.preCheckCast(INSTANCE, IEntityManager.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.preCheckCast(r21.next(), List.class, "com.obric.memorydata.plugin"), r12, r25, null, 8, null).size();
        r12 = r12;
        goto L43
    L45:
        r5 = r18;
        goto L15
    L47:
        throw new NoSuchElementException();
    L17:
        r1 = r17;
        goto L13
    L48:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "delete all entities from package: " + r25 + " before timestamp: " + r26 + " success, count: " + r1, false, 4, null);
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityManager
    public boolean deleteAllByEntityType(int r13) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "delete all entities by type: " + r13, false, 4, null);
        IAppEntityRawDbDao<com.obric.memorydata.database.entity.d> r12 = com.obric.memorydata.database.index.s.a().getRawDaoByEntityType(r13);
        if (r12 != null) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "delete failed, rawDao is null, type: " + r13, null, 4, null);
        return false;
    L6:
        List<com.obric.memorydata.database.entity.d> r14 = r12.queryAll();
        if (r14 == null) goto L14;
        Iterator r15 = ((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        boolean r4 = true;
    L10:
        if (r15.hasNext() == false) goto L15;
        com.obric.memorydata.database.entity.d r5 = (com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r15.next(), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin");
        if (r5.delete() == true) goto L10;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "delete failed entity: " + r5, null, 4, null);
        r4 = false;
    L15:
        if (r4 == false) goto L17;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "delete all entities by type: " + r13 + " success", false, 4, null);
    L17:
        return true;
    L14:
        r4 = true;
        goto L15
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityManager
    public void deleteByTypeAndPackageName(int r11, String r12) {
        Intrinsics.checkNotNullParameter(r12, ObricMemoryConstants.KEY_PACKAGE_NAME);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "delete all entities from package: " + r12 + ", type: " + r11, false, 4, null);
        IAppEntityRawDbDao<com.obric.memorydata.database.entity.d> r10 = com.obric.memorydata.database.index.s.a().getRawDaoByEntityType(r11);
        if (r10 == null) goto L12;
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r10.queryByPackageName(r12), Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r14 = r13.iterator();
    L6:
        if (r14.hasNext() == false) goto L8;
        r2.add(((com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r14.next(), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin")).getEntityId());
        goto L6
    L8:
        Iterator r15 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.chunked((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), INSTANCE.getDeleteBatchSize(r11)), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L10:
        if (r15.hasNext() == false) goto L12;
        IEntityManager.a.a((IEntityManager) ZeusTransformUtils.preCheckCast(INSTANCE, IEntityManager.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.preCheckCast(r15.next(), List.class, "com.obric.memorydata.plugin"), r11, r12, null, 8, null);
    L12:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "delete all entities from package: " + r12 + " finish", false, 4, null);
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityManager
    public void deleteLazyIndexHistoryEntity(int r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r3, "entityId");
        l.f12228a.a(r1, r2, r3);
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityManager
    public void deleteLazyIndexHistoryEntityList(int r2, String r3, List<String> r4) {
        List<String> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r1, "entityIds");
        l.f12228a.a(r2, r3, r1);
    }

    public final List<String> getDEFAULT_SUPPORT_DONATE_APPS() {
        return DEFAULT_SUPPORT_DONATE_APPS;
    }

    public final int getDeleteBatchSize(int r1) {
        if (r1 != 801) goto L5;
        return 900;
    L5:
        return 100;
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityManager
    public int getEntityDonatedVersion() {
        boolean r7 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getBoolean(KEY_ALL_APP_ENTITY_DONATED, false);
        int r0 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getInt(KEY_APP_ENTITY_DONATED_VERSION, 1);
        if (r7 == true) goto L6;
        return 0;
    L6:
        return r0;
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityManager
    public Object getLazyIndexHistoryEntity(int r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r3, "entityId");
        return l.f12228a.b(r1, r2, r3);
    }

    public final List<String> getSupportDonateEntityApps() {
        if (AppContext.INSTANCE.isSsFlavor() == false) goto L7;
        return CollectionsKt.emptyList();
    L7:
        if (UserSettings.INSTANCE.hasAgreePrivacy() == true) goto L11;
        RunLog r8 = RunLog.INSTANCE;
        StringBuilder r1 = new StringBuilder().append("getSupportDonateEntityApps (privacy not agreed): ");
        List<String> r2 = DEFAULT_SUPPORT_DONATE_APPS;
    L9:
        r8.debug(TAG, r1.append(r2).toString());
        return r2;
    L11:
        List<ApplicationInfo> r9 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageManager().getInstalledApplications(PackageManager.ApplicationInfoFlags.of(128));
        Intrinsics.checkNotNullExpressionValue(r9, "getInstalledApplications(...)");
        r2 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator<ApplicationInfo> r10 = r9.iterator();
    L13:
        if (r10.hasNext() == false) goto L22;
        ApplicationInfo r3 = (ApplicationInfo) ZeusTransformUtils.preCheckCast(r10.next(), ApplicationInfo.class, "com.obric.memorydata.plugin");
        Bundle r4 = r3.metaData;
        boolean r5 = true;
        if (r4 != null) goto L17;
    L19:
        r5 = false;
    L20:
        if (r5 == false) goto L13;
        String r6 = r3.packageName;
        Intrinsics.checkNotNullExpressionValue(r6, ObricMemoryConstants.KEY_PACKAGE_NAME);
        r2.add(r6);
        goto L13
    L17:
        if (r4.getBoolean("com.obric.memorydata.EntityDonate", false) != true) goto L19;
    L22:
        r8 = RunLog.INSTANCE;
        r1 = new StringBuilder().append("getSupportDonateEntityApps: ");
        goto L9
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityManager
    public boolean index(AppEntity r9) {
        Intrinsics.checkNotNullParameter(r9, "appEntity");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "index entity type: " + r9.getType() + " id: " + r9.getId() + " packageName: " + r9.getPackageName(), false, 4, null);
        RunLog r8 = RunLog.INSTANCE;
        StringBuilder r0 = new StringBuilder().append("index entity detail: ");
        if (ZeusTransformUtils.instanceOf(r9, AbstractFakeAppEntity.class) == false) goto L5;
        AbstractFakeAppEntity r1 = (AbstractFakeAppEntity) ZeusTransformUtils.preCheckCast(r9, AbstractFakeAppEntity.class, "com.obric.memorydata.plugin");
    L6:
        if (r1 == null) goto L9;
        String r2 = r1.toExtraJsonString();
        if (r2 == null) goto L9;
    L10:
        r8.debug(TAG, r0.append(r2).toString());
        if (EvaluationService.INSTANCE.handleIndexEntity(r9) == false) goto L14;
        return true;
    L14:
        com.obric.memorydata.personalcontext.storage.a r10 = q.f12255a.a(r9.getType(), ZeusTransformUtils.instanceOf(r9, AbstractFakeAppEntity.class));
        if (r10 != null) goto L19;
        return false;
    L19:
        return r10.a(r9);
    L9:
        r2 = EntityExtKt.toJson(r9);
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    public final void indexAllContactCallEntity() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "indexAllContactAndCallEntity start", false, 4, null);
        deleteAll(AppInfo.Contact.getPackageName());
        bulkIndex(EntityCollectorService.INSTANCE.getAllContactAndCallHistoryData());
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityManager
    public void indexAllContactCallSmsEntity() {
        indexAllContactCallSmsEntity(false);
    }

    public final void indexAllContactCallSmsEntity(boolean r7) {
        if (EntityCollectorService.INSTANCE.hasPermission(IEntityCollectorService.SMS_TAG) == true) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "indexAllContactCallSmsEntity, sms permission not granted", false, 4, null);
        return;
    L6:
        Set<String> r6 = reIndexedPackageSet;
        monitor-enter(r6);
    L17:
        th = move-exception;
        throw th;
    L9:
        if (r6.contains(IEntityCollectorService.SMS_TAG) == false) goto L13;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "notifyAppIndex sms has been indexed", false, 4, null);     // Catch: Throwable -> L17
        monitor-exit(r6);
        return;
    L13:
        r6.add(IEntityCollectorService.SMS_TAG);     // Catch: Throwable -> L17
        monitor-exit(r6);
        EntityCollectorService.INSTANCE.reIndexData(IEntityCollectorService.SMS_TAG, r7);
    }

    public final void indexAllMessageEntity() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "indexAllMessageEntity start", false, 4, null);
        deleteAll(AppInfo.Message.getPackageName());
        bulkIndex(EntityCollectorService.INSTANCE.getAllSmsData());
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityManager
    public boolean isAllEntityDonated() {
        boolean r7 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getBoolean(KEY_ALL_APP_ENTITY_DONATED, false);
        int r0 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getInt(KEY_APP_ENTITY_DONATED_VERSION, 1);
        if (r7 == true) goto L5;
        r0 = 0;
    L5:
        if (r0 > 0) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean isInLaunchFirstMinute() {
        return isInLaunchFirstMinute;
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityManager
    public boolean isLazyIndexEntity(int r7, String r8) {
        Intrinsics.checkNotNullParameter(r8, ObricMemoryConstants.KEY_PACKAGE_NAME);
        return l.a(l.f12228a, r7, r8, false, 4, null);
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityManager
    public void launchIndexTask() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "launch app_entity_index task", false, 4, null);
        ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder(com.obric.memorydata.database.entity.d.FAST_INDEX_TASK_NAME).setConditions(new Condition[]{Condition.LIGHT_POWER_CONTROL}), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExecuteImmediately(true), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExistingTaskPolicy(ExistingTaskPolicy.REPLACE_IN_QUEUE), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).enqueue();
    }

    public final void notifyAppReindex(final String r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, ObricMemoryConstants.KEY_PACKAGE_NAME);
        if (Intrinsics.areEqual(r10, AppContext.INSTANCE.getPackageName()) == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "notifyAppReindex start, packageName: " + r10 + ", isSelfPkg: " + r0, false, 4, null);
        if (EntityConsistencyCheckTask.Companion.isCredentialProtectionLocked() == false) goto L13;
        com.obric.memorydata.utils.y.a(null, new $$Lambda$EntityManager$hZgeavl71U7UNb2sM67fBe0Kc(r10), 1, null);
        return;
    L13:
        Set<String> r1 = reIndexedPackageSet;
        monitor-enter(r1);
    L31:
        th = move-exception;
        throw th;
    L16:
        if (r1.contains(r10) == false) goto L20;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "notifyAppIndex packageName: " + r10 + " has been indexed", false, 4, null);     // Catch: Throwable -> L31
        monitor-exit(r1);
        return;
    L20:
        r1.add(r10);     // Catch: Throwable -> L31
        monitor-exit(r1);
        if (r11 == true) goto L34;
        if (r0 == true) goto L34;
        deleteAll(r10);
    L34:
        ZeusProviderTransform.call(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), com.obric.memorydata.personalcontext.util.h.f12375a.a(r10), "data_check", null, null, "com.obric.memorydata.plugin");     // Catch: Exception -> L27
    L29:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "notifyAppIndex " + r10 + " end", false, 4, null);
        return;
    L27:
        e = move-exception;
        RunLog.INSTANCE.error(TAG, "notifyAppIndex " + r10 + " error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        goto L29
    L5:
        if (Intrinsics.areEqual(r10, com.obric.memorydata.BuildConfig.LIBRARY_PACKAGE_NAME) == true) goto L8;
        r0 = false;
        goto L9
    }

    public final int queryCount(int r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
        IAppEntityRawDbDao<com.obric.memorydata.database.entity.d> r0 = com.obric.memorydata.database.index.s.a().getRawDaoByEntityType(r1);
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getCountByPackageName(r2);
    }

    public final long queryLastModifiedTime(int r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
        IAppEntityRawDbDao<com.obric.memorydata.database.entity.d> r0 = com.obric.memorydata.database.index.s.a().getRawDaoByEntityType(r1);
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getLastModifyTimeByPackageName(r2);
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityManager
    public void reIndexCertainApps(List<String> r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "packageList");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "reIndexCertainApps begin, packages: " + r10, false, 4, null);
        if (r10.contains(AppInfo.Contact.getPackageName()) == false) goto L6;
        indexAllContactCallEntity();
    L6:
        if (r10.contains(AppInfo.Message.getPackageName()) == false) goto L8;
        indexAllMessageEntity();
    L8:
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(getSupportDonateEntityApps(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L10:
        if (r8.hasNext() == false) goto L14;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.memorydata.plugin");
        if (r10.contains(r0) == false) goto L10;
        notifyAppReindex$default(INSTANCE, r0, false, 2, null);
        goto L10
    L14:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "reIndexCertainApps end", false, 4, null);
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityManager
    public void reindexAllData(Runnable r2, final boolean r3) {
        final Runnable r1 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "finishRunnable");
        ThreadPoolContainer.Companion.execute(new $$Lambda$EntityManager$_zWs720NT3Z5qVpaQo2MXWXsPg(r3, r1));
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityManager
    public void removeLazyIndexHistoryEntity(int r1, long r2) {
        l.f12228a.a(r1, r2);
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityManager
    public void resumeLazyIndexPendingTask(int r1, String r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
        l.f12228a.a(r1, r2, r3);
    }

    public final void syncDelete(int r7, long r8, String r10) {
        Intrinsics.checkNotNullParameter(r10, ObricMemoryConstants.KEY_PACKAGE_NAME);
        IAppEntityRawDbDao<com.obric.memorydata.database.entity.d> r6 = com.obric.memorydata.database.index.s.a().getRawDaoByEntityType(r7);
        if (r6 == null) goto L5;
        Object r9 = r6.queryRecentByPackageName(r10, r8);
    L7:
        if (r9 == null) goto L12;
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L10:
        if (r11.hasNext() == false) goto L12;
        ((com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r11.next(), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin")).delete();
    L12:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "syncDelete entityType: " + r7 + " from package: " + r10 + " later than modifyTime: " + r8 + " success", false, 4, null);
        return;
    L5:
        r9 = null;
        goto L7
    }
}
