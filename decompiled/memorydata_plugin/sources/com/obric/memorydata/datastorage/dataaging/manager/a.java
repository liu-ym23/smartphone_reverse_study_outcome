package com.obric.memorydata.datastorage.dataaging.manager;

import android.content.Context;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.obric.cae.userAware.WifiScanStateMachine;
import com.obric.capabilitykit.common.ErrorCode;
import com.obric.memorydata.ability.k;
import com.obric.memorydata.constants.OsTeaTrackerEventId;
import com.obric.memorydata.database.aging.ScreenshotAttachmentAgingCheckpointStore;
import com.obric.memorydata.database.dao.RawObservationDao;
import com.obric.memorydata.database.dao.SemanticDeleteLifecycle;
import com.obric.memorydata.database.entity.RawObservationEntity;
import com.obric.memorydata.database.entity.ha;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.datastorage.dataaging.strategy.TableAgingExecutionMode;
import com.obric.memorydata.datastorage.dataaging.strategy.factory.AgingDatabaseScope;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.bdtracker.Tracker;
import com.obric.memorydata.middleware.api.bridge.CoreBridgeAPI;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStore;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.utils.r;
import com.obric.memorydata.utils.threadpool.ThreadPoolContainer;
import com.obric.memorydata.utils.y;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.reflect.KFunction;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.bouncycastle.jcajce.util.AnnotatedPrivateKey;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u000eH\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u001cH\u0002J\u0010\u0010 \u001a\u00020!2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\"\u001a\u00020#H\u0002J\u0016\u0010$\u001a\u00020\u00162\f\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u000eH\u0002J!\u0010'\u001a\b\u0012\u0004\u0012\u00020\b0\u000e2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u000eH\u0001¢\u0006\u0002\b(J\b\u0010)\u001a\u00020#H\u0002J\b\u0010*\u001a\u00020#H\u0002J\u0016\u0010+\u001a\u00020\u00162\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u0002J\u0010\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u0005H\u0002J\u001e\u0010/\u001a\u00020\u00162\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e2\u0006\u00100\u001a\u00020\u0005H\u0002J\u0010\u00101\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u0005H\u0002J\u0010\u00102\u001a\u00020\u00162\u0006\u0010.\u001a\u00020\u0005H\u0002J&\u00103\u001a\u00020\u00162\u0006\u00104\u001a\u0002052\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u0005072\u0006\u00108\u001a\u00020\u0005H\u0002J\b\u00109\u001a\u00020\u0016H\u0002J\u0006\u0010:\u001a\u00020\u0016J\u0006\u0010;\u001a\u00020\u0016J\u0006\u0010<\u001a\u00020\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012¨\u0006="}, d2 = {"Lcom/obric/memorydata/datastorage/dataaging/manager/DataAgingManager;", "", "<init>", "()V", "TAG", "", "PRE_TRY_DATA_AGING_TIMESTAMP", "RAW_OBSERVATION_ORPHAN_MIN_AGE_MILLIS", "", "RULE_EPISODIC_MEMORY_RETENTION_DAYS", "RULE_EPISODIC_MEMORY_MAX_COUNT", "", "RAW_OBSERVATION_MISSING_MEDIA_ERROR_CODE", "RAW_OBSERVATION_MEDIA_MISSING_STATES", "", "store", "Lcom/obric/memorydata/middleware/api/store/IStore;", "getStore", "()Lcom/obric/memorydata/middleware/api/store/IStore;", "store$delegate", "Lkotlin/Lazy;", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "getAgingStrategyList", "Lcom/obric/memorydata/datastorage/dataaging/strategy/TableAgingStrategy;", "shouldRetainScreenshotDatabaseRows", "", "createScreenshotTimeAgingCheckpoint", "Lcom/obric/memorydata/datastorage/dataaging/strategy/checkpoint/TimeAgingCheckpoint;", AILabCheckPermissionTask.KEY_SOURCE, "Lcom/obric/memorydata/database/aging/ScreenshotAttachmentAgingCheckpointStore$Source;", "createInAppTraceTimeAgingCheckpoint", "createScreenshotCountAgingCheckpoint", "Lcom/obric/memorydata/datastorage/dataaging/strategy/checkpoint/CountAgingCheckpoint;", "createRawObservationScreenshotOnlyCallback", "Lcom/obric/memorydata/datastorage/dataaging/strategy/callback/TableAgedCallback;", "closeAgedRawObservationRows", "rows", "Lcom/obric/memorydata/database/entity/RawObservationEntity;", "selectMediaMissingRowIds", "selectMediaMissingRowIds$app_obricRelease", "createScreenObservationScreenshotOnlyCallback", "createInAppTraceZipOnlyCallback", "deleteAgedInAppTraceZipFiles", "paths", "deleteAgedInAppTraceZipFile", "path", "deleteAgedScreenshotFiles", "sourceTable", "deleteAgedScreenshotFile", "deleteLocalFile", "cleanUnreferencedRawObservationFiles", "folder", "Ljava/io/File;", "referencedPaths", "", AnnotatedPrivateKey.LABEL, "subscribeScreenOff", "onScreenOff", "triggerDataAgingExecute", "executeAllAgingStrategies", "app_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9702a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<String> f9703b = null;
    private static final Lazy c = null;

    /* JADX INFO: renamed from: com.obric.memorydata.datastorage.dataaging.manager.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"com/obric/memorydata/datastorage/dataaging/manager/DataAgingManager$createInAppTraceTimeAgingCheckpoint$1", "Lcom/obric/memorydata/datastorage/dataaging/strategy/checkpoint/TimeAgingCheckpoint;", "getLastProcessedCutoff", "", "saveLastProcessedCutoff", "", "cutoff", "app_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0465a implements com.obric.memorydata.datastorage.dataaging.strategy.b.b {
        C0465a() {
        }

        @Override // com.obric.memorydata.datastorage.dataaging.strategy.b.b
        public long a() {
            return com.obric.memorydata.database.aging.a.f8839a.a();
        }

        @Override // com.obric.memorydata.datastorage.dataaging.strategy.b.b
        public void a(long r1) {
            com.obric.memorydata.database.aging.a.f8839a.a(r1);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/datastorage/dataaging/manager/DataAgingManager$createInAppTraceZipOnlyCallback$1", "Lcom/obric/memorydata/datastorage/dataaging/strategy/callback/TableAgedCallback;", "onAgingStart", "", "deletePrimaryKeyValues", "", "", "onAged", "app_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements com.obric.memorydata.datastorage.dataaging.strategy.a.a {
        b() {
        }

        @Override // com.obric.memorydata.datastorage.dataaging.strategy.a.a
        public void a() {
        }

        @Override // com.obric.memorydata.datastorage.dataaging.strategy.a.a
        public void a(List<Long> r2) {
            List<Long> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r1, "deletePrimaryKeyValues");
            List<String> r3 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getInAppTraceUploadDao().querySafeLocalPathsForAging(r1);
            a.b(a.f9702a, r3);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/datastorage/dataaging/manager/DataAgingManager$createRawObservationScreenshotOnlyCallback$1", "Lcom/obric/memorydata/datastorage/dataaging/strategy/callback/TableAgedCallback;", "onAgingStart", "", "deletePrimaryKeyValues", "", "", "onAged", "app_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c implements com.obric.memorydata.datastorage.dataaging.strategy.a.a {
        c() {
        }

        @Override // com.obric.memorydata.datastorage.dataaging.strategy.a.a
        public void a() {
        }

        @Override // com.obric.memorydata.datastorage.dataaging.strategy.a.a
        public void a(List<Long> r6) {
            List<Long> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "deletePrimaryKeyValues");
            if (r5.isEmpty() == false) goto L5;
            return;
        L5:
            List<RawObservationEntity> r7 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getRawObservationDao().queryScreenshotByIds(r5);
            a.a(a.f9702a, r7);
            a r8 = a.f9702a;
            Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin");
            ha r1 = ha.f9173a;
            Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10)), Collection.class, "com.obric.memorydata.plugin");
            Iterator r10 = r9.iterator();
        L7:
            if (r10.hasNext() == false) goto L9;
            r2.add(r1.a((RawObservationEntity) ZeusTransformUtils.preCheckCast(r10.next(), RawObservationEntity.class, "com.obric.memorydata.plugin")));
            goto L7
        L9:
            a.a(r8, (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"), "RawObservation");
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/datastorage/dataaging/manager/DataAgingManager$createScreenObservationScreenshotOnlyCallback$1", "Lcom/obric/memorydata/datastorage/dataaging/strategy/callback/TableAgedCallback;", "onAgingStart", "", "deletePrimaryKeyValues", "", "", "onAged", "app_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d implements com.obric.memorydata.datastorage.dataaging.strategy.a.a {
        d() {
        }

        @Override // com.obric.memorydata.datastorage.dataaging.strategy.a.a
        public void a() {
        }

        @Override // com.obric.memorydata.datastorage.dataaging.strategy.a.a
        public void a(List<Long> r2) {
            List<Long> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r1, "deletePrimaryKeyValues");
            List<String> r3 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getScreenObservationDao().queryScreenshotPathsByIds(r1);
            a.a(a.f9702a, r3, "ScreenObservation");
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"com/obric/memorydata/datastorage/dataaging/manager/DataAgingManager$createScreenshotCountAgingCheckpoint$1", "Lcom/obric/memorydata/datastorage/dataaging/strategy/checkpoint/CountAgingCheckpoint;", "getLastProcessedPrimaryKey", "", "saveLastProcessedPrimaryKey", "", "primaryKey", "app_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class e implements com.obric.memorydata.datastorage.dataaging.strategy.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ScreenshotAttachmentAgingCheckpointStore.Source f9704a;

        e(ScreenshotAttachmentAgingCheckpointStore.Source r1) {
            this.f9704a = r1;
        }

        @Override // com.obric.memorydata.datastorage.dataaging.strategy.b.a
        public long a() {
            return ScreenshotAttachmentAgingCheckpointStore.f8838a.b(this.f9704a);
        }

        @Override // com.obric.memorydata.datastorage.dataaging.strategy.b.a
        public void a(long r2) {
            ScreenshotAttachmentAgingCheckpointStore.f8838a.b(this.f9704a, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"com/obric/memorydata/datastorage/dataaging/manager/DataAgingManager$createScreenshotTimeAgingCheckpoint$1", "Lcom/obric/memorydata/datastorage/dataaging/strategy/checkpoint/TimeAgingCheckpoint;", "getLastProcessedCutoff", "", "saveLastProcessedCutoff", "", "cutoff", "app_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class f implements com.obric.memorydata.datastorage.dataaging.strategy.b.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ScreenshotAttachmentAgingCheckpointStore.Source f9705a;

        f(ScreenshotAttachmentAgingCheckpointStore.Source r1) {
            this.f9705a = r1;
        }

        @Override // com.obric.memorydata.datastorage.dataaging.strategy.b.b
        public long a() {
            return ScreenshotAttachmentAgingCheckpointStore.f8838a.a(this.f9705a);
        }

        @Override // com.obric.memorydata.datastorage.dataaging.strategy.b.b
        public void a(long r2) {
            ScreenshotAttachmentAgingCheckpointStore.f8838a.a(this.f9705a, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/datastorage/dataaging/manager/DataAgingManager$getAgingStrategyList$1", "Lcom/obric/memorydata/datastorage/dataaging/strategy/callback/TableAgedCallback;", "onAgingStart", "", "deletePrimaryKeyValues", "", "", "onAged", "app_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class g implements com.obric.memorydata.datastorage.dataaging.strategy.a.a {
        g() {
        }

        private static final void b() {
            File r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getFilesDir();
            List<String> r2 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getRawObservationDao().queryScreenshotPayloads();
            a r3 = a.f9702a;
            File r4 = new File(r0, "Screenshots");
            Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin");
            Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
            Iterator r7 = r5.iterator();
        L3:
            String r8 = null;
            boolean r9 = true;
            if (r7.hasNext() == false) goto L13;
            String r10 = ha.f9173a.a((String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin"));
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin")).length() > 0) goto L9;
            r9 = false;
        L9:
            if (r9 == false) goto L11;
            r8 = r10;
        L11:
            if (r8 == null) goto L3;
            r6.add(r8);
            goto L3
        L13:
            a.a(r3, r4, (Set) ZeusTransformUtils.preCheckCast(CollectionsKt.toHashSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")), Set.class, "com.obric.memorydata.plugin"), "screenshots");
            a r11 = a.f9702a;
            File r12 = new File(r0, "raw_observation_viewtree");
            Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin");
            Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
            Iterator r14 = r1.iterator();
        L15:
            if (r14.hasNext() == false) goto L25;
            String r15 = ha.f9173a.b((String) ZeusTransformUtils.preCheckCast(r14.next(), String.class, "com.obric.memorydata.plugin"));
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L19;
            boolean r16 = true;
        L20:
            if (r16 == true) goto L23;
            r15 = null;
        L23:
            if (r15 == null) goto L15;
            r13.add(r15);
            goto L15
        L19:
            r16 = false;
            goto L20
        L25:
            a.a(r11, r12, (Set) ZeusTransformUtils.preCheckCast(CollectionsKt.toHashSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")), Set.class, "com.obric.memorydata.plugin"), "viewtree");
        }

        /* JADX INFO: renamed from: lambda$xdM4YH9V1tEeKtbwsN-kBzCrBso, reason: not valid java name */
        public static /* synthetic */ void m593lambda$xdM4YH9V1tEeKtbwsNkBzCrBso() {
            b();
        }

        @Override // com.obric.memorydata.datastorage.dataaging.strategy.a.a
        public void a() {
        }

        @Override // com.obric.memorydata.datastorage.dataaging.strategy.a.a
        public void a(List<Long> r8) {
            List<Long> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, "deletePrimaryKeyValues");
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "DataAgingManager", "onAgingStart count: " + r7.size(), false, 4, null);
            Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getRawObservationDao().queryScreenshotByIds(r7), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L4:
            if (r9.hasNext() == false) goto L6;
            RawObservationEntity r1 = (RawObservationEntity) ZeusTransformUtils.preCheckCast(r9.next(), RawObservationEntity.class, "com.obric.memorydata.plugin");
            a.a(a.f9702a, ha.f9173a.a(r1));
            a.a(a.f9702a, ha.f9173a.b(r1));
            goto L4
        L6:
            ThreadPoolContainer.Companion.getInstance().execute($$Lambda$a$g$xdM4YH9V1tEeKtbwsNkBzCrBso.INSTANCE);
            Tracker r10 = Tracker.INSTANCE;
            String r0 = OsTeaTrackerEventId.RECOMMEND_DELETE_EXPIRED_DATA_EVENT.getValue();
            JSONObject r2 = new JSONObject();
            r2.put(CommonConsts.COUNT_TYPE, r7.size());
            Unit r11 = Unit.INSTANCE;
            r10.reportEvent(r0, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/datastorage/dataaging/manager/DataAgingManager$getAgingStrategyList$2", "Lcom/obric/memorydata/datastorage/dataaging/strategy/callback/TableAgedCallback;", "onAgingStart", "", "deletePrimaryKeyValues", "", "", "onAged", "app_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class h implements com.obric.memorydata.datastorage.dataaging.strategy.a.a {
        h() {
        }

        @Override // com.obric.memorydata.datastorage.dataaging.strategy.a.a
        public void a() {
        }

        @Override // com.obric.memorydata.datastorage.dataaging.strategy.a.a
        public void a(List<Long> r8) {
            List<Long> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, "deletePrimaryKeyValues");
            if (r7.isEmpty() == false) goto L5;
            return;
        L5:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "DataAgingManager", "ScreenObservation onAgingStart count: " + r7.size(), false, 4, null);
            Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getScreenObservationDao().queryScreenshotPathsByIds(r7), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L7:
            if (r9.hasNext() == false) goto L9;
            a.a(a.f9702a, (String) ZeusTransformUtils.preCheckCast(r9.next(), String.class, "com.obric.memorydata.plugin"));
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/datastorage/dataaging/manager/DataAgingManager$subscribeScreenOff$1", "Lcom/obric/memorydata/ability/IAbilityDataReceiver;", "onDataReceive", "", "data", "Lcom/obric/memorydata/ability/data/IStandardData;", "app_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class i implements k {
        i() {
        }

        @Override // com.obric.memorydata.ability.k
        public void a(com.obric.memorydata.ability.data.h r2) {
            Intrinsics.checkNotNullParameter((com.obric.memorydata.ability.data.h) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.memorydata.ability.data.h.class, "com.obric.memorydata.plugin"), "data");
            a.f9702a.b();
        }

        @Override // com.obric.memorydata.ability.k
        public String g_() {
            return k.a.a(this);
        }
    }

    static {
        f9702a = new a();
        f9703b = CollectionsKt.listOf(new String[]{RawObservationEntity.STATE_WAIT_MEDIA, "PENDING"});
        c = LazyKt.lazy($$Lambda$a$82K2T2P2Sfv0x0qauY9m5C0cCAw.INSTANCE);
    }

    private a() {
    }

    private final com.obric.memorydata.datastorage.dataaging.strategy.b.b a(ScreenshotAttachmentAgingCheckpointStore.Source r2) {
        return (com.obric.memorydata.datastorage.dataaging.strategy.b.b) ZeusTransformUtils.preCheckCast(new f(r2), com.obric.memorydata.datastorage.dataaging.strategy.b.b.class, "com.obric.memorydata.plugin");
    }

    private static final Unit a(File r7, String r8, Set r9) {
        final Set r10 = (Set) ZeusTransformUtils.wrapperContextForParams(r9, Set.class, "com.obric.memorydata.plugin");
        final Ref.IntRef r0 = new Ref.IntRef();
        final long r2 = System.currentTimeMillis() - WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_WEEK_MS;
        r7.listFiles(new $$Lambda$a$zkY61ZpfbYj1e6lvJw76CDf5L9Q(r10, r2, r0));
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "DataAgingManager", r8 + " folder cleaned, deleted: " + r0.element, false, 4, null);
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ void a(a r2, File r3, Set r4, String r5) {
        r2.a(r3, (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin"), r5);
    }

    public static final /* synthetic */ void a(a r0, String r1) {
        r0.c(r1);
    }

    public static final /* synthetic */ void a(a r2, List r3) {
        r2.b((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void a(a r2, List r3, String r4) {
        r2.a((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    private final void a(final File r2, Set<String> r3, final String r4) {
        final Set r1 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
        if (r2.exists() == true) goto L5;
        return;
    L5:
        y.a(null, new $$Lambda$a$6vlA8Et40_aOrm8bJ7XD51nqyM(r2, r4, r1), 1, null);
    }

    private final void a(List<String> r4, String r5) {
        Iterator r3 = SequencesKt.distinct(SequencesKt.filter(CollectionsKt.asSequence((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")), (Function1) ZeusTransformUtils.preCheckCast(DataAgingManager$deleteAgedScreenshotFiles$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin"))).iterator();
        int r6 = 0;
    L4:
        if (r3.hasNext() == false) goto L8;
        if (f9702a.b((String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin")) == true) goto L4;
        r6 = r6 + 1;
        goto L4
    L8:
        if (r6 > 0) goto L11;
        return;
    L11:
        throw new IllegalStateException(r5 + " screenshot aging failed, count=" + r6);
    }

    private static final boolean a(RawObservationEntity r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return f9703b.contains(r1.getState());
    }

    private final boolean a(String r10) {
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L19
        a r9 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        File r11 = new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getFilesDir(), "in_app_trace/pending").getCanonicalFile();     // Catch: Throwable -> L19
        File r12 = new File(r10).getCanonicalFile();     // Catch: Throwable -> L19
        String r13 = r11.getPath() + File.separator;     // Catch: Throwable -> L19
        String r3 = r12.getPath();     // Catch: Throwable -> L19
        Intrinsics.checkNotNullExpressionValue(r3, "getPath(...)");     // Catch: Throwable -> L19
        boolean r14 = StringsKt.startsWith$default(r3, r13, false, 2, null);     // Catch: Throwable -> L19
        boolean r4 = true;
        if (r14 == true) goto L8;
        IRunLog r5 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        String r6 = "DataAgingManager";
        String r7 = "skip In-App Trace ZIP outside managed directory";
    L6:
        IRunLog.a.a(r5, r6, r7, null, 4, null);     // Catch: Throwable -> L19
    L17:
        Object r15 = Result.m1421constructorimpl(Boolean.valueOf(r4));     // Catch: Throwable -> L19
    L21:
        Throwable r16 = Result.m1424exceptionOrNullimpl(r15);
        if (r16 == null) goto L25;
        RunLog.INSTANCE.warn("DataAgingManager", "delete aged In-App Trace ZIP failed", r16);
    L25:
        if (Result.m1427isFailureimpl(r15) == false) goto L28;
        r15 = false;
    L28:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r15, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L8:
        if (r12.exists() == false) goto L17;
        if (r12.isFile() == false) goto L16;
        String r17 = r12.getName();     // Catch: Throwable -> L19
        Intrinsics.checkNotNullExpressionValue(r17, "getName(...)");     // Catch: Throwable -> L19
        if (StringsKt.endsWith(r17, ".zip", true) == false) goto L16;
        r4 = r12.delete();     // Catch: Throwable -> L19
    L16:
        r5 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        r6 = "DataAgingManager";
        r7 = "skip invalid In-App Trace ZIP aging target";
    L19:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r15 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L21
    }

    private static final boolean a(Set r4, long r5, Ref.IntRef r7, File r8) {
        Set r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        if (r8.isFile() == true) goto L6;
        return false;
    L6:
        if (r6.contains(r8.getAbsolutePath()) == false) goto L9;
        return false;
    L9:
        if (r8.lastModified() <= r5) goto L12;
        return false;
    L12:
        if (r8.delete() == false) goto L14;
        r7.element++;
    L14:
        return false;
    }

    private static final long b(RawObservationEntity r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return r2.getId();
    }

    private final com.obric.memorydata.datastorage.dataaging.strategy.b.a b(ScreenshotAttachmentAgingCheckpointStore.Source r2) {
        return (com.obric.memorydata.datastorage.dataaging.strategy.b.a) ZeusTransformUtils.preCheckCast(new e(r2), com.obric.memorydata.datastorage.dataaging.strategy.b.a.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ void b(a r2, List r3) {
        r2.c((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    private final void b(List<RawObservationEntity> r7) {
        List<Long> r6 = a((List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin"));
        if (r6.isEmpty() == false) goto L5;
        return;
    L5:
        RawObservationDao r8 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getRawObservationDao();
        List<String> r0 = f9703b;
        r8.markClientStateForStates(r6, "PENDING", "DONE", r0);
        r8.markStateForStates(r6, r0, "DONE", 2201);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "DataAgingManager", "closeAgedRawObservationRows count=" + r6.size() + " error_code=2201", false, 4, null);
    }

    private final boolean b(String r10) {
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L16
        a r9 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        File r11 = new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getFilesDir(), "Screenshots").getCanonicalFile();     // Catch: Throwable -> L16
        File r12 = new File(r10).getCanonicalFile();     // Catch: Throwable -> L16
        String r13 = r11.getPath() + File.separator;     // Catch: Throwable -> L16
        String r3 = r12.getPath();     // Catch: Throwable -> L16
        Intrinsics.checkNotNullExpressionValue(r3, "getPath(...)");     // Catch: Throwable -> L16
        boolean r14 = StringsKt.startsWith$default(r3, r13, false, 2, null);     // Catch: Throwable -> L16
        boolean r4 = true;
        if (r14 == true) goto L8;
        IRunLog r5 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        String r6 = "DataAgingManager";
        String r7 = "skip screenshot outside managed directory";
    L6:
        IRunLog.a.a(r5, r6, r7, null, 4, null);     // Catch: Throwable -> L16
    L14:
        Object r15 = Result.m1421constructorimpl(Boolean.valueOf(r4));     // Catch: Throwable -> L16
    L18:
        Throwable r16 = Result.m1424exceptionOrNullimpl(r15);
        if (r16 == null) goto L22;
        RunLog.INSTANCE.warn("DataAgingManager", "delete aged screenshot failed", r16);
    L22:
        if (Result.m1427isFailureimpl(r15) == false) goto L25;
        r15 = false;
    L25:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r15, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L8:
        if (r12.exists() == false) goto L14;
        if (r12.isFile() == true) goto L13;
        r5 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        r6 = "DataAgingManager";
        r7 = "skip non-file screenshot aging target";
        goto L6
    L13:
        r4 = r12.delete();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r15 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L18
    }

    private final void c(final String r2) {
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        return;
    L8:
        y.a(null, new $$Lambda$a$g3s0Qmixje73t5ZnpRtJgUo2ADM(r2), 1, null);
        return;
    L5:
        r1 = false;
        goto L6
    }

    private final void c(List<String> r4) {
        Iterator r3 = SequencesKt.distinct(SequencesKt.filter(CollectionsKt.asSequence((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")), (Function1) ZeusTransformUtils.preCheckCast(DataAgingManager$deleteAgedInAppTraceZipFiles$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin"))).iterator();
        int r5 = 0;
    L4:
        if (r3.hasNext() == false) goto L8;
        if (f9702a.a((String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin")) == true) goto L4;
        r5 = r5 + 1;
        goto L4
    L8:
        if (r5 > 0) goto L11;
        return;
    L11:
        throw new IllegalStateException("In-App Trace ZIP aging failed, count=" + r5);
    }

    private static final Unit d(String r1) {
        File r0 = new File(r1);
        if (r0.exists() == false) goto L6;
        r0.delete();
    L6:
        return Unit.INSTANCE;
    }

    private final IStore e() {
        return (IStore) ZeusTransformUtils.preCheckCast(c.getValue(), IStore.class, "com.obric.memorydata.plugin");
    }

    private final List<com.obric.memorydata.datastorage.dataaging.strategy.a> f() {
        List<com.obric.memorydata.datastorage.dataaging.strategy.a> r1 = Collections.synchronizedList((List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin"));
        com.obric.memorydata.datastorage.dataaging.strategy.a r2 = com.obric.memorydata.datastorage.dataaging.strategy.factory.a.b(com.obric.memorydata.datastorage.dataaging.strategy.factory.a.f9709a, "MiddleUserProfile", 8640000000L, 10000, null, null, null, null, AgingDatabaseScope.PERSONAL, null, null, null, null, null, null, 16248, null);
        com.obric.memorydata.datastorage.dataaging.strategy.a r4 = com.obric.memorydata.datastorage.dataaging.strategy.factory.a.b(com.obric.memorydata.datastorage.dataaging.strategy.factory.a.f9709a, "ShortMemory", 2592000000L, 2000, null, null, null, null, AgingDatabaseScope.PERSONAL, TableAgingExecutionMode.DELETE_HANDLER, null, null, "productType >= 1021 AND productType <= 1024", (com.obric.memorydata.datastorage.dataaging.strategy.c.a) ZeusTransformUtils.preCheckCast(com.obric.memorydata.datastorage.dataaging.strategy.c.b.f9708a, com.obric.memorydata.datastorage.dataaging.strategy.c.a.class, "com.obric.memorydata.plugin"), null, 9848, null);
        r1.addAll((Collection) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(new com.obric.memorydata.datastorage.dataaging.strategy.a[]{com.obric.memorydata.datastorage.dataaging.strategy.factory.a.b(com.obric.memorydata.datastorage.dataaging.strategy.factory.a.f9709a, "RawAppActivity", 8640000000L, 10000, null, null, null, null, null, null, null, null, null, null, null, 16376, null), com.obric.memorydata.datastorage.dataaging.strategy.factory.a.b(com.obric.memorydata.datastorage.dataaging.strategy.factory.a.f9709a, "RawBluetoothDevice", 8640000000L, 10000, null, null, null, null, null, null, null, null, null, null, null, 16376, null), com.obric.memorydata.datastorage.dataaging.strategy.factory.a.b(com.obric.memorydata.datastorage.dataaging.strategy.factory.a.f9709a, "RawGeography", 8640000000L, 10000, null, null, null, null, null, null, null, null, null, null, null, 16376, null), com.obric.memorydata.datastorage.dataaging.strategy.factory.a.b(com.obric.memorydata.datastorage.dataaging.strategy.factory.a.f9709a, "RawLocation", 8640000000L, 10000, null, null, null, null, null, null, null, null, null, null, null, 16376, null), com.obric.memorydata.datastorage.dataaging.strategy.factory.a.b(com.obric.memorydata.datastorage.dataaging.strategy.factory.a.f9709a, "app_usage_info", 8640000000L, 10000, null, null, null, null, null, null, null, null, null, null, null, 16376, null), com.obric.memorydata.datastorage.dataaging.strategy.factory.a.b(com.obric.memorydata.datastorage.dataaging.strategy.factory.a.f9709a, Constants.KEY_NET_TYPE, 8640000000L, 10000, null, null, null, null, null, null, null, null, null, null, null, 16376, null), com.obric.memorydata.datastorage.dataaging.strategy.factory.a.b(com.obric.memorydata.datastorage.dataaging.strategy.factory.a.f9709a, "predict_app_result", 8640000000L, 10000, null, null, null, null, null, null, null, null, null, null, null, 16376, null), r2, r4, com.obric.memorydata.datastorage.dataaging.strategy.factory.a.b(com.obric.memorydata.datastorage.dataaging.strategy.factory.a.f9709a, "RawMobileCellular", 8640000000L, 10000, null, null, null, null, null, null, null, null, null, null, null, 16376, null), com.obric.memorydata.datastorage.dataaging.strategy.factory.a.b(com.obric.memorydata.datastorage.dataaging.strategy.factory.a.f9709a, "RawScreenState", 8640000000L, 10000, null, null, null, null, null, null, null, null, null, null, null, 16376, null), com.obric.memorydata.datastorage.dataaging.strategy.factory.a.b(com.obric.memorydata.datastorage.dataaging.strategy.factory.a.f9709a, "RawWifi", 8640000000L, 10000, null, null, null, null, null, null, null, null, null, null, null, 16376, null), com.obric.memorydata.datastorage.dataaging.strategy.factory.a.b(com.obric.memorydata.datastorage.dataaging.strategy.factory.a.f9709a, "RawScreenBrightness", 8640000000L, 10000, null, null, null, null, null, null, null, null, null, null, null, 16376, null), com.obric.memorydata.datastorage.dataaging.strategy.factory.a.b(com.obric.memorydata.datastorage.dataaging.strategy.factory.a.f9709a, "RawPackageEvent", 8640000000L, 10000, null, null, null, null, null, null, null, null, null, null, null, 16376, null), com.obric.memorydata.datastorage.dataaging.strategy.factory.a.b(com.obric.memorydata.datastorage.dataaging.strategy.factory.a.f9709a, "RawLanguageChangeEvent", 8640000000L, 10000, null, null, null, null, null, null, null, null, null, null, null, 16376, null), com.obric.memorydata.datastorage.dataaging.strategy.factory.a.b(com.obric.memorydata.datastorage.dataaging.strategy.factory.a.f9709a, "RawMovementState", 8640000000L, 10000, null, null, null, null, null, null, null, null, null, null, null, 16376, null), com.obric.memorydata.datastorage.dataaging.strategy.factory.a.b(com.obric.memorydata.datastorage.dataaging.strategy.factory.a.f9709a, "RawBatteryState", 8640000000L, 10000, null, null, null, null, null, null, null, null, null, null, null, 16376, null), com.obric.memorydata.datastorage.dataaging.strategy.factory.a.b(com.obric.memorydata.datastorage.dataaging.strategy.factory.a.f9709a, "RawStreamVolume", 8640000000L, 10000, null, null, null, null, null, null, null, null, null, null, null, 16376, null), com.obric.memorydata.datastorage.dataaging.strategy.factory.a.b(com.obric.memorydata.datastorage.dataaging.strategy.factory.a.f9709a, "RawOsNotification", 8640000000L, 10000, null, null, null, null, null, null, null, null, null, null, null, 16376, null), com.obric.memorydata.datastorage.dataaging.strategy.factory.a.b(com.obric.memorydata.datastorage.dataaging.strategy.factory.a.f9709a, "RawNetworkStatus", 8640000000L, 10000, null, null, null, null, null, null, null, null, null, null, null, 16376, null), com.obric.memorydata.datastorage.dataaging.strategy.factory.a.b(com.obric.memorydata.datastorage.dataaging.strategy.factory.a.f9709a, "RawLightSensor", 8640000000L, 10000, null, null, null, null, null, null, null, null, null, null, null, 16376, null), com.obric.memorydata.datastorage.dataaging.strategy.factory.a.b(com.obric.memorydata.datastorage.dataaging.strategy.factory.a.f9709a, "RawSettingsChanged", 8640000000L, 10000, null, null, null, null, null, null, null, null, null, null, null, 16376, null), com.obric.memorydata.datastorage.dataaging.strategy.factory.a.b(com.obric.memorydata.datastorage.dataaging.strategy.factory.a.f9709a, "RawDeviceBoot", 8640000000L, 10000, null, null, null, null, null, null, null, null, null, null, null, 16376, null), com.obric.memorydata.datastorage.dataaging.strategy.factory.a.b(com.obric.memorydata.datastorage.dataaging.strategy.factory.a.f9709a, "RawDeviceShutdown", 8640000000L, 10000, null, null, null, null, null, null, null, null, null, null, null, 16376, null), com.obric.memorydata.datastorage.dataaging.strategy.factory.a.b(com.obric.memorydata.datastorage.dataaging.strategy.factory.a.f9709a, "predict_sleep_result", 4320000000L, 10000, null, null, null, null, null, null, null, null, null, null, null, 16376, null), com.obric.memorydata.datastorage.dataaging.strategy.factory.a.b(com.obric.memorydata.datastorage.dataaging.strategy.factory.a.f9709a, "RawAlarm", 4320000000L, 1000, null, null, null, null, null, null, null, null, null, null, null, 16376, null), com.obric.memorydata.datastorage.dataaging.strategy.factory.a.b(com.obric.memorydata.datastorage.dataaging.strategy.factory.a.f9709a, "RawAudioPlay", WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_WEEK_MS, 1000, null, null, null, null, null, null, null, null, null, null, null, 16376, null), com.obric.memorydata.datastorage.dataaging.strategy.factory.a.b(com.obric.memorydata.datastorage.dataaging.strategy.factory.a.f9709a, "UploadData", WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_WEEK_MS, 1000, null, null, null, null, null, null, null, null, null, null, null, 16376, null), com.obric.memorydata.datastorage.dataaging.strategy.factory.a.a(com.obric.memorydata.datastorage.dataaging.strategy.factory.a.f9709a, "ElementRelationData", 31536000000L, LocationInfoConst.HALF_MINUTES, null, null, null, null, null, null, null, null, null, null, null, 16376, null), com.obric.memorydata.datastorage.dataaging.strategy.factory.a.a(com.obric.memorydata.datastorage.dataaging.strategy.factory.a.f9709a, "ElementPropertyData", 31536000000L, LocationInfoConst.HALF_MINUTES, null, null, null, null, null, null, null, null, null, null, null, 16376, null), com.obric.memorydata.datastorage.dataaging.strategy.factory.a.b(com.obric.memorydata.datastorage.dataaging.strategy.factory.a.f9709a, "ElementRelationData", 31536000000L, LocationInfoConst.HALF_MINUTES, null, null, null, null, null, null, null, null, null, null, null, 16376, null), com.obric.memorydata.datastorage.dataaging.strategy.factory.a.b(com.obric.memorydata.datastorage.dataaging.strategy.factory.a.f9709a, "ElementPropertyData", 31536000000L, LocationInfoConst.HALF_MINUTES, null, null, null, null, null, null, null, null, null, null, null, 16376, null), com.obric.memorydata.datastorage.dataaging.strategy.factory.a.b(com.obric.memorydata.datastorage.dataaging.strategy.factory.a.f9709a, "EmbeddingVectorCache", 31536000000L, 5000, null, null, null, null, null, null, null, null, null, null, null, 16376, null), com.obric.memorydata.datastorage.dataaging.strategy.factory.a.b(com.obric.memorydata.datastorage.dataaging.strategy.factory.a.f9709a, "RawWxChat", 0, 0, null, CollectionsKt.listOf(new Triple("uploadState", "1", 2592000000L)), null, null, null, null, null, null, null, null, null, 16360, null), com.obric.memorydata.datastorage.dataaging.strategy.factory.a.b(com.obric.memorydata.datastorage.dataaging.strategy.factory.a.f9709a, "BatchChat", 0, 0, null, CollectionsKt.listOf(new Triple("memoryState", "1", 2592000000L)), null, null, null, null, null, null, null, null, null, 16360, null), com.obric.memorydata.datastorage.dataaging.strategy.factory.a.b(com.obric.memorydata.datastorage.dataaging.strategy.factory.a.f9709a, "AssistantChatMessageEntity", 31536000000L, 10000, null, null, null, null, null, null, null, null, null, null, null, 16376, null), com.obric.memorydata.datastorage.dataaging.strategy.factory.a.b(com.obric.memorydata.datastorage.dataaging.strategy.factory.a.f9709a, "RawWifiInfoList", 2592000000L, 100000, null, null, null, null, null, null, null, null, null, null, null, 16376, null), com.obric.memorydata.datastorage.dataaging.strategy.factory.a.b(com.obric.memorydata.datastorage.dataaging.strategy.factory.a.f9709a, "ArriveLeaveHomeCompanyEvent", 8640000000L, 10000, null, null, null, null, null, null, null, null, null, null, null, 16376, null), com.obric.memorydata.datastorage.dataaging.strategy.factory.a.b(com.obric.memorydata.datastorage.dataaging.strategy.factory.a.f9709a, "AwarenessInfo", 2592000000L, 0, null, null, null, null, null, null, null, null, null, null, null, 16376, null), com.obric.memorydata.datastorage.dataaging.strategy.factory.a.b(com.obric.memorydata.datastorage.dataaging.strategy.factory.a.f9709a, "ProactiveMemoryProcessInfo", WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_WEEK_MS, 1000, null, null, null, null, null, null, null, null, null, null, null, 16376, null), com.obric.memorydata.datastorage.dataaging.strategy.factory.a.b(com.obric.memorydata.datastorage.dataaging.strategy.factory.a.f9709a, "har_state", WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_WEEK_MS, 1000, null, null, null, null, null, null, null, null, null, null, null, 16376, null), com.obric.memorydata.datastorage.dataaging.strategy.factory.a.b(com.obric.memorydata.datastorage.dataaging.strategy.factory.a.f9709a, "ProactiveOsNotification", 2592000000L, 10000, null, null, null, null, null, null, null, null, null, null, null, 16376, null), com.obric.memorydata.datastorage.dataaging.strategy.factory.a.b(com.obric.memorydata.datastorage.dataaging.strategy.factory.a.f9709a, "AutoMemoryProRawSource", WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_WEEK_MS, 1000, null, null, null, null, AgingDatabaseScope.PERSONAL, null, null, null, null, null, null, 16248, null), com.obric.memorydata.datastorage.dataaging.strategy.factory.a.b(com.obric.memorydata.datastorage.dataaging.strategy.factory.a.f9709a, "SpeakerEmbeddingPending", WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_WEEK_MS, 0, null, null, null, null, AgingDatabaseScope.PERSONAL, null, null, null, null, null, "created_at", ErrorCode.EventTask.START_TIME_OR_END_TIME_ERROR, null)}), Collection.class, "com.obric.memorydata.plugin"));
        r1.add(com.obric.memorydata.datastorage.dataaging.strategy.factory.a.b(com.obric.memorydata.datastorage.dataaging.strategy.factory.a.f9709a, "InAppTraceUpload", WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_WEEK_MS, 0, k(), null, null, null, null, TableAgingExecutionMode.CALLBACK_ONLY, h(), null, null, null, "created_at", 7408, null));
        if (g() == false) goto L5;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "DataAgingManager", "add screenshot-only aging", false, 4, null);
        r1.add(com.obric.memorydata.datastorage.dataaging.strategy.factory.a.b(com.obric.memorydata.datastorage.dataaging.strategy.factory.a.f9709a, "RawObservation", 259200000, AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH, i(), null, null, null, null, TableAgingExecutionMode.CALLBACK_ONLY, a(ScreenshotAttachmentAgingCheckpointStore.Source.RAW_OBSERVATION), b(ScreenshotAttachmentAgingCheckpointStore.Source.RAW_OBSERVATION), null, null, null, 14576, null));
        com.obric.memorydata.datastorage.dataaging.strategy.a r0 = com.obric.memorydata.datastorage.dataaging.strategy.factory.a.b(com.obric.memorydata.datastorage.dataaging.strategy.factory.a.f9709a, "ScreenObservation", 259200000, AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH, j(), null, null, null, null, TableAgingExecutionMode.CALLBACK_ONLY, a(ScreenshotAttachmentAgingCheckpointStore.Source.SCREEN_OBSERVATION), b(ScreenshotAttachmentAgingCheckpointStore.Source.SCREEN_OBSERVATION), null, null, null, 14576, null);
    L6:
        r1.add(r0);
        if (com.obric.memorydata.middleware.database.b.f11646a.a().c() == false) goto L9;
        r1.remove(r2);
        r1.remove(r4);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "DataAgingManager", "skip personal data aging for anonymous profile", false, 4, null);
    L9:
        Intrinsics.checkNotNull(r1);
        return r1;
    L5:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "DataAgingManager", "add raw observation aging", false, 4, null);
        r1.add(com.obric.memorydata.datastorage.dataaging.strategy.factory.a.b(com.obric.memorydata.datastorage.dataaging.strategy.factory.a.f9709a, "RawObservation", 259200000, AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH, (com.obric.memorydata.datastorage.dataaging.strategy.a.a) ZeusTransformUtils.preCheckCast(new g(), com.obric.memorydata.datastorage.dataaging.strategy.a.a.class, "com.obric.memorydata.plugin"), null, null, null, null, null, null, null, null, null, null, 16368, null));
        r0 = com.obric.memorydata.datastorage.dataaging.strategy.factory.a.b(com.obric.memorydata.datastorage.dataaging.strategy.factory.a.f9709a, "ScreenObservation", 259200000, AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH, (com.obric.memorydata.datastorage.dataaging.strategy.a.a) ZeusTransformUtils.preCheckCast(new h(), com.obric.memorydata.datastorage.dataaging.strategy.a.a.class, "com.obric.memorydata.plugin"), null, null, null, null, null, null, null, null, null, null, 16368, null);
        goto L6
    }

    private final boolean g() {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        a r9 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        Object r10 = Result.m1421constructorimpl(Boolean.valueOf(CoreBridgeAPI.INSTANCE.isUTDataCollectEnabled()));     // Catch: Throwable -> L5
    L7:
        Throwable r2 = Result.m1424exceptionOrNullimpl(r10);
        if (r2 == null) goto L11;
        RunLog.INSTANCE.warn("DataAgingManager", "query UT data collection user failed", r2);
    L11:
        if (Result.m1427isFailureimpl(r10) == false) goto L13;
        r10 = false;
    L13:
        boolean r11 = ((Boolean) ZeusTransformUtils.preCheckCast(r10, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        boolean r3 = com.obric.memorydata.database.c.b.f8850a.a();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "DataAgingManager", "screenshot aging user state: utCollect=" + r11 + ", memoryReview=" + r3, false, 4, null);
        if (r11 == true) goto L16;
        if (r3 == true) goto L16;
        return false;
    L16:
        return true;
    L5:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r10 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    private final com.obric.memorydata.datastorage.dataaging.strategy.b.b h() {
        return (com.obric.memorydata.datastorage.dataaging.strategy.b.b) ZeusTransformUtils.preCheckCast(new C0465a(), com.obric.memorydata.datastorage.dataaging.strategy.b.b.class, "com.obric.memorydata.plugin");
    }

    private final com.obric.memorydata.datastorage.dataaging.strategy.a.a i() {
        return (com.obric.memorydata.datastorage.dataaging.strategy.a.a) ZeusTransformUtils.preCheckCast(new c(), com.obric.memorydata.datastorage.dataaging.strategy.a.a.class, "com.obric.memorydata.plugin");
    }

    private final com.obric.memorydata.datastorage.dataaging.strategy.a.a j() {
        return (com.obric.memorydata.datastorage.dataaging.strategy.a.a) ZeusTransformUtils.preCheckCast(new d(), com.obric.memorydata.datastorage.dataaging.strategy.a.a.class, "com.obric.memorydata.plugin");
    }

    private final com.obric.memorydata.datastorage.dataaging.strategy.a.a k() {
        return (com.obric.memorydata.datastorage.dataaging.strategy.a.a) ZeusTransformUtils.preCheckCast(new b(), com.obric.memorydata.datastorage.dataaging.strategy.a.a.class, "com.obric.memorydata.plugin");
    }

    private final void l() {
        new com.obric.memorydata.ability.d().a(new com.obric.memorydata.ability.f(100000005, MapsKt.mapOf(TuplesKt.to("mode", com.tom_roush.pdfbox.pdmodel.a.d.f.g))), (k) ZeusTransformUtils.preCheckCast(new i(), k.class, "com.obric.memorydata.plugin"));
    }

    public static /* synthetic */ boolean lambda$5NFxwNXOYJnKsdXDNKNGDC1gYdY(RawObservationEntity r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$6vlA8Et40_aOrm8bJ7X-D51nqyM, reason: not valid java name */
    public static /* synthetic */ Unit m590lambda$6vlA8Et40_aOrm8bJ7XD51nqyM(File r0, String r1, Set r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$75eYHxd_SlxQWxhFyT1WnaXpgok() {
        return o();
    }

    public static /* synthetic */ IStore lambda$82K2T2P2Sfv0x0qauY9m5C0cCAw() {
        return m();
    }

    /* JADX INFO: renamed from: lambda$RLbYbrKABi-lWcQZQz3HDXUHiIY, reason: not valid java name */
    public static /* synthetic */ void m591lambda$RLbYbrKABilWcQZQz3HDXUHiIY() {
        n();
    }

    /* JADX INFO: renamed from: lambda$XzarkQ-Ok84ePpPewXzN3awkgUs, reason: not valid java name */
    public static /* synthetic */ long m592lambda$XzarkQOk84ePpPewXzN3awkgUs(RawObservationEntity r2) {
        return b(r2);
    }

    public static /* synthetic */ Unit lambda$g3s0Qmixje73t5ZnpRtJgUo2ADM(String r0) {
        return d(r0);
    }

    public static /* synthetic */ boolean lambda$zkY61ZpfbYj1e6lvJw76CDf5L9Q(Set r0, long r1, Ref.IntRef r3, File r4) {
        return a(r0, r1, r3, r4);
    }

    private static final IStore m() {
        return IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null);
    }

    private static final void n() {
        a r0 = f9702a;
        r0.d();
        r0.e().save("pre_try_data_aging_timestamp", System.currentTimeMillis());
    }

    private static final Unit o() {
        SemanticDeleteLifecycle.cleanupConsumedRetractions$default(SemanticDeleteLifecycle.INSTANCE, 0, 1, null);
        return Unit.INSTANCE;
    }

    public final List<Long> a(List<RawObservationEntity> r2) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "rows");
        return SequencesKt.toList(SequencesKt.map(SequencesKt.filter(CollectionsKt.asSequence((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")), $$Lambda$a$5NFxwNXOYJnKsdXDNKNGDC1gYdY.INSTANCE), $$Lambda$a$XzarkQOk84ePpPewXzN3awkgUs.INSTANCE));
    }

    public final void a() {
        l();
    }

    public final void b() {
        long r0 = IStore.a.a(e(), "pre_try_data_aging_timestamp", 0, 2, null);
        if (r.a(System.currentTimeMillis()) != r.a(r0)) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "DataAgingManager", "onScreenOff trigger only once a day. Pre timestamp: " + r0, false, 4, null);
        return;
    L6:
        c();
    }

    public final void c() {
        ThreadPoolContainer.Companion.getInstance().execute($$Lambda$a$RLbYbrKABilWcQZQz3HDXUHiIY.INSTANCE);
    }

    public final void d() {
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(f(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r0.add((KFunction) ZeusTransformUtils.preCheckCast(new DataAgingManager$executeAllAgingStrategies$1$1((com.obric.memorydata.datastorage.dataaging.strategy.a) ZeusTransformUtils.preCheckCast(r5.next(), com.obric.memorydata.datastorage.dataaging.strategy.a.class, "com.obric.memorydata.plugin")), KFunction.class, "com.obric.memorydata.plugin"));
        goto L4
    L6:
        com.obric.memorydata.datastorage.dataaging.manager.b.a((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), $$Lambda$a$75eYHxd_SlxQWxhFyT1WnaXpgok.INSTANCE);
    }
}
