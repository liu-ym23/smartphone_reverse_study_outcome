package com.obric.memorydata.personalcontext;

import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.obric.aikernel.sdk.data.PackageResource;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.CallHistoryEntity;
import com.obric.capabilitykit.entity.app.EntityClassData;
import com.obric.capabilitykit.entity.app.EntityType;
import com.obric.capabilitykit.sync.EntitySyncDataSupplier;
import com.obric.memorydata.aikernelcore.MemoryScriptEngineEnv;
import com.obric.memorydata.database.entity.fq;
import com.obric.memorydata.database.index.t;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.database.manager.MemoryFrameDb;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.personalcontext.api.EntityCollectorService;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0015\bÀ\u0002\u0018\u00002\u00020\u0001:\u0010[\\]^_`abcdefghijB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0012\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010\u0014J\u0018\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0080@¢\u0006\u0004\b\u0018\u0010\u0019J8\u0010\u0015\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!H\u0080@¢\u0006\u0004\b\u0018\u0010\"J\u0015\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0005H\u0000¢\u0006\u0002\b&J\u0016\u0010'\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0082@¢\u0006\u0002\u0010\u0019J\u0016\u0010(\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0082@¢\u0006\u0002\u0010\u0019J\u0016\u0010)\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0082@¢\u0006\u0002\u0010\u0019J\u0016\u0010*\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0082@¢\u0006\u0002\u0010\u0019J$\u0010+\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-H\u0082@¢\u0006\u0002\u0010/J$\u00100\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-H\u0082@¢\u0006\u0002\u0010/J\u001e\u00101\u001a\u0002022\u0006\u0010\u0016\u001a\u00020\u00172\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00050-H\u0002J2\u00104\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-2\f\u00105\u001a\b\u0012\u0004\u0012\u0002060-H\u0082@¢\u0006\u0002\u00107J.\u00108\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u00109\u001a\u00020.2\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\tH\u0082@¢\u0006\u0002\u0010=J\"\u0010>\u001a\u0004\u0018\u00010?2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u00109\u001a\u00020.2\u0006\u0010:\u001a\u00020;H\u0002J&\u0010@\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u00109\u001a\u00020.2\u0006\u0010<\u001a\u00020\tH\u0082@¢\u0006\u0002\u0010AJ\u001e\u0010B\u001a\u00020C2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010D\u001a\u00020?H\u0082@¢\u0006\u0002\u0010EJ\"\u0010F\u001a\u00020C2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010D\u001a\u00020?2\b\u0010G\u001a\u0004\u0018\u00010HH\u0002J(\u0010I\u001a\u00020C2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u00109\u001a\u00020.2\b\u0010G\u001a\u0004\u0018\u00010HH\u0082@¢\u0006\u0002\u0010JJ4\u0010K\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u00109\u001a\u00020L2\u0006\u0010<\u001a\u00020\t2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020O0NH\u0082@¢\u0006\u0002\u0010PJ\u001e\u0010Q\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010G\u001a\u00020HH\u0082@¢\u0006\u0002\u0010RJ\u0018\u0010S\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010G\u001a\u00020HH\u0002J\u0018\u0010T\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010G\u001a\u00020HH\u0002J\f\u0010U\u001a\u00020V*\u00020.H\u0002J\f\u0010U\u001a\u00020V*\u00020HH\u0002J\f\u0010W\u001a\u00020;*\u00020HH\u0002J\u0014\u0010X\u001a\u00020\u0013*\u00020H2\u0006\u00109\u001a\u00020.H\u0002J\u0014\u0010X\u001a\u00020\u0013*\u00020H2\u0006\u00109\u001a\u00020LH\u0002J\u0018\u0010Y\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010Z\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006k"}, d2 = {"Lcom/obric/memorydata/personalcontext/CallHistorySourceNumberBackfillManager;", "", "<init>", "()V", "TAG", "", "MIGRATION_ID", "DONE_VALUE", "TARGET_ENTITY_VERSION", "", "PAGE_SIZE", "SOURCE_BATCH_SIZE", "MAX_TOKEN_RETRY_COUNT", "FULL_CONTENT_COLUMN", "BUILD_ENTITY_FULL_CONTENT_PACKAGE", "BUILD_META_FULL_CONTENT_PACKAGE", "runMutex", "Lkotlinx/coroutines/sync/Mutex;", "checkIfNeeded", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkIfNeededForDebug", "runtime", "Lcom/obric/memorydata/personalcontext/CallHistorySourceNumberBackfillManager$BackfillRuntime;", "checkIfNeededForDebug$personal_context_obricRelease", "(Lcom/obric/memorydata/personalcontext/CallHistorySourceNumberBackfillManager$BackfillRuntime;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sourceOverride", "Lcom/obric/memorydata/personalcontext/CallHistorySourceNumberBackfillManager$DebugSourceOverride;", "failPoint", "Lcom/obric/memorydata/personalcontext/CallHistorySourceNumberBackfillManager$DebugFailPoint;", "concurrentAction", "Lcom/obric/memorydata/personalcontext/CallHistorySourceNumberBackfillManager$DebugConcurrentAction;", "trace", "Lcom/obric/memorydata/personalcontext/CallHistorySourceNumberBackfillManager$DebugRunTrace;", "(Lcom/obric/memorydata/personalcontext/CallHistorySourceNumberBackfillManager$DebugSourceOverride;Lcom/obric/memorydata/personalcontext/CallHistorySourceNumberBackfillManager$DebugFailPoint;Lcom/obric/memorydata/personalcontext/CallHistorySourceNumberBackfillManager$DebugConcurrentAction;Lcom/obric/memorydata/personalcontext/CallHistorySourceNumberBackfillManager$DebugRunTrace;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "inspectDebugFixture", "Lcom/obric/memorydata/personalcontext/CallHistorySourceNumberBackfillManager$DebugFixtureInspection;", "fixtureEntityId", "inspectDebugFixture$personal_context_obricRelease", "checkIfNeededInternal", "runBackfill", "runPhaseA", "runPhaseB", "processPage", "candidates", "", "Lcom/obric/memorydata/database/model/CallHistorySourceNumberBackfillCandidate;", "(Lcom/obric/memorydata/personalcontext/CallHistorySourceNumberBackfillManager$BackfillRuntime;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processSourceBatch", "fetchSourceEntities", "Lcom/obric/memorydata/personalcontext/CallHistorySourceNumberBackfillManager$FetchResult;", "ids", "processReturnedEntities", "entities", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "(Lcom/obric/memorydata/personalcontext/CallHistorySourceNumberBackfillManager$BackfillRuntime;Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processSourceEntity", "candidate", "entity", "Lcom/obric/capabilitykit/entity/app/CallHistoryEntity;", "attemptCount", "(Lcom/obric/memorydata/personalcontext/CallHistorySourceNumberBackfillManager$BackfillRuntime;Lcom/obric/memorydata/database/model/CallHistorySourceNumberBackfillCandidate;Lcom/obric/capabilitykit/entity/app/CallHistoryEntity;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prepareBackfillUpdate", "Lcom/obric/memorydata/personalcontext/CallHistorySourceNumberBackfillManager$BackfillUpdate;", "retryCandidate", "(Lcom/obric/memorydata/personalcontext/CallHistorySourceNumberBackfillManager$BackfillRuntime;Lcom/obric/memorydata/database/model/CallHistorySourceNumberBackfillCandidate;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAndClassify", "Lcom/obric/memorydata/personalcontext/CallHistorySourceNumberBackfillManager$CandidateResult;", com.obric.memorydata.BuildConfig.CHANNEL, "(Lcom/obric/memorydata/personalcontext/CallHistorySourceNumberBackfillManager$BackfillRuntime;Lcom/obric/memorydata/personalcontext/CallHistorySourceNumberBackfillManager$BackfillUpdate;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "classifyCasHit", "raw", "Lcom/obric/memorydata/database/entity/RawCallHistoryEntity;", "classifyCasMiss", "(Lcom/obric/memorydata/personalcontext/CallHistorySourceNumberBackfillManager$BackfillRuntime;Lcom/obric/memorydata/database/model/CallHistorySourceNumberBackfillCandidate;Lcom/obric/memorydata/database/entity/RawCallHistoryEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reconcileContentCandidate", "Lcom/obric/memorydata/database/model/CallHistorySourceNumberContentCandidate;", "onRetry", "Lkotlin/Function0;", "", "(Lcom/obric/memorydata/personalcontext/CallHistorySourceNumberBackfillManager$BackfillRuntime;Lcom/obric/memorydata/database/model/CallHistorySourceNumberContentCandidate;ILkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rebuildContent", "(Lcom/obric/memorydata/personalcontext/CallHistorySourceNumberBackfillManager$BackfillRuntime;Lcom/obric/memorydata/database/entity/RawCallHistoryEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rebuildFullContent", "rebuildMetaFullContent", "toDebugRawFacts", "Lcom/obric/memorydata/personalcontext/CallHistorySourceNumberBackfillManager$DebugRawFacts;", "toSyntheticSourceEntity", "hasSameIdentity", "fail", InfoRequestQPSOptTraceLogger.REASON, "BackfillUpdate", "BackfillRuntime", "DebugSourceOverride", "DebugFixtureInspection", "DebugDoneMarkerState", "DebugRawFacts", "DebugContentOutcome", "DebugRunTrace", "DebugFailPoint", "DebugConcurrentAction", "DebugBackfillRuntime", "RealBackfillRuntime", "SourceUnavailableException", "DebugSourceException", "FetchResult", "CandidateResult", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CallHistorySourceNumberBackfillManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CallHistorySourceNumberBackfillManager f12002a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final kotlinx.coroutines.sync.a f12003b = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/personalcontext/CallHistorySourceNumberBackfillManager$DebugConcurrentAction;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "POST_CAS_NORMAL_DONATION", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum DebugConcurrentAction extends Enum<DebugConcurrentAction> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ DebugConcurrentAction[] $VALUES = null;
        public static final DebugConcurrentAction NONE = null;
        public static final DebugConcurrentAction POST_CAS_NORMAL_DONATION = null;

        private static final /* synthetic */ DebugConcurrentAction[] $values() {
            return new DebugConcurrentAction[]{NONE, POST_CAS_NORMAL_DONATION};
        }

        static {
            NONE = new DebugConcurrentAction("NONE", 0);
            POST_CAS_NORMAL_DONATION = new DebugConcurrentAction("POST_CAS_NORMAL_DONATION", 1);
            DebugConcurrentAction[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private DebugConcurrentAction(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumEntries<DebugConcurrentAction> getEntries() {
            return $ENTRIES;
        }

        public static DebugConcurrentAction valueOf(String r2) {
            return (DebugConcurrentAction) ZeusTransformUtils.preCheckCast(Enum.valueOf(DebugConcurrentAction.class, r2), DebugConcurrentAction.class, "com.obric.memorydata.plugin");
        }

        public static DebugConcurrentAction[] values() {
            return (DebugConcurrentAction[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), DebugConcurrentAction[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/personalcontext/CallHistorySourceNumberBackfillManager$DebugDoneMarkerState;", "", "<init>", "(Ljava/lang/String;I)V", "ABSENT", "DONE", "INVALID", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum DebugDoneMarkerState extends Enum<DebugDoneMarkerState> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ DebugDoneMarkerState[] $VALUES = null;
        public static final DebugDoneMarkerState ABSENT = null;
        public static final DebugDoneMarkerState DONE = null;
        public static final DebugDoneMarkerState INVALID = null;

        private static final /* synthetic */ DebugDoneMarkerState[] $values() {
            return new DebugDoneMarkerState[]{ABSENT, DONE, INVALID};
        }

        static {
            ABSENT = new DebugDoneMarkerState("ABSENT", 0);
            DONE = new DebugDoneMarkerState("DONE", 1);
            INVALID = new DebugDoneMarkerState("INVALID", 2);
            DebugDoneMarkerState[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private DebugDoneMarkerState(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumEntries<DebugDoneMarkerState> getEntries() {
            return $ENTRIES;
        }

        public static DebugDoneMarkerState valueOf(String r2) {
            return (DebugDoneMarkerState) ZeusTransformUtils.preCheckCast(Enum.valueOf(DebugDoneMarkerState.class, r2), DebugDoneMarkerState.class, "com.obric.memorydata.plugin");
        }

        public static DebugDoneMarkerState[] values() {
            return (DebugDoneMarkerState[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), DebugDoneMarkerState[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/personalcontext/CallHistorySourceNumberBackfillManager$DebugFailPoint;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "AFTER_PHASE_A_CAS_BEFORE_PHASE_B", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum DebugFailPoint extends Enum<DebugFailPoint> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ DebugFailPoint[] $VALUES = null;
        public static final DebugFailPoint AFTER_PHASE_A_CAS_BEFORE_PHASE_B = null;
        public static final DebugFailPoint NONE = null;

        private static final /* synthetic */ DebugFailPoint[] $values() {
            return new DebugFailPoint[]{NONE, AFTER_PHASE_A_CAS_BEFORE_PHASE_B};
        }

        static {
            NONE = new DebugFailPoint("NONE", 0);
            AFTER_PHASE_A_CAS_BEFORE_PHASE_B = new DebugFailPoint("AFTER_PHASE_A_CAS_BEFORE_PHASE_B", 1);
            DebugFailPoint[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private DebugFailPoint(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumEntries<DebugFailPoint> getEntries() {
            return $ENTRIES;
        }

        public static DebugFailPoint valueOf(String r2) {
            return (DebugFailPoint) ZeusTransformUtils.preCheckCast(Enum.valueOf(DebugFailPoint.class, r2), DebugFailPoint.class, "com.obric.memorydata.plugin");
        }

        public static DebugFailPoint[] values() {
            return (DebugFailPoint[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), DebugFailPoint[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/personalcontext/CallHistorySourceNumberBackfillManager$DebugSourceException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "message", "", "<init>", "(Ljava/lang/String;)V", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class DebugSourceException extends RuntimeException {
        public DebugSourceException(String r2) {
            Intrinsics.checkNotNullParameter(r2, "message");
            super(r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/memorydata/personalcontext/CallHistorySourceNumberBackfillManager$SourceUnavailableException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "<init>", "()V", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class SourceUnavailableException extends RuntimeException {
        public SourceUnavailableException() {
        }
    }

    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\f\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&J\u000e\u0010\u0007\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\bJ\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H&J\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H&J\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\n2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\nH&J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0017H&J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u0003H\u0016J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\rH&J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001bH&J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001bH&J\b\u0010 \u001a\u00020\u0003H&J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0014H\u0016J\u0018\u0010$\u001a\u00020\"2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\u0006H\u0016J\"\u0010&\u001a\u00020\"2\u0006\u0010'\u001a\u00020\u00142\u0006\u0010(\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001bH\u0016J2\u0010)\u001a\u00020\"2\u0006\u0010(\u001a\u00020\u00102\u0006\u0010*\u001a\u00020\u001b2\b\u0010+\u001a\u0004\u0018\u00010\u001b2\u0006\u0010,\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u0003H\u0016¨\u0006."}, d2 = {"Lcom/obric/memorydata/personalcontext/CallHistorySourceNumberBackfillManager$BackfillRuntime;", "", "hasPrivacyConsent", "", "isDone", "currentEntityVersion", "", "areContentRebuildPackagesAvailable", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryCandidates", "", "Lcom/obric/memorydata/database/model/CallHistorySourceNumberBackfillCandidate;", "lastRawDbId", "", "pageSize", "queryContentCandidates", "Lcom/obric/memorydata/database/model/CallHistorySourceNumberContentCandidate;", "fetchSourceEntities", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "ids", "", "updateRawRow", com.obric.memorydata.BuildConfig.CHANNEL, "Lcom/obric/memorydata/personalcontext/CallHistorySourceNumberBackfillManager$BackfillUpdate;", "afterCasAffectedOne", "afterPhaseAComplete", "queryRaw", "Lcom/obric/memorydata/database/entity/RawCallHistoryEntity;", "rawDbId", "rebuildFullContent", "raw", "rebuildMetaFullContent", "saveDone", "recordFailureReason", "", InfoRequestQPSOptTraceLogger.REASON, "recordCasAffected", "affected", "recordCasClassification", "classification", "candidate", "recordContentOutcome", "rawBefore", "rawAfter", "fullSuccess", "metaSuccess", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface a {

        /* JADX INFO: renamed from: com.obric.memorydata.personalcontext.CallHistorySourceNumberBackfillManager$a$a, reason: collision with other inner class name */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        public static final class C0650a {
            public static void a(a r0, com.obric.memorydata.database.model.b r1, fq r2, fq r3, boolean r4, boolean r5) {
                a r6 = (a) ZeusTransformUtils.wrapperContextForParams(r0, a.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r1, "candidate");
                Intrinsics.checkNotNullParameter(r2, "rawBefore");
            }

            public static void a(a r1, b r2, int r3) {
                a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r1, a.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r2, com.obric.memorydata.BuildConfig.CHANNEL);
            }

            public static void a(a r2, String r3) {
                a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r3, InfoRequestQPSOptTraceLogger.REASON);
            }

            public static void a(a r1, String r2, com.obric.memorydata.database.model.a r3, fq r4) {
                a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r1, a.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r2, "classification");
                Intrinsics.checkNotNullParameter(r3, "candidate");
            }

            public static boolean a(a r2) {
                a r3 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
                return true;
            }

            public static boolean a(a r2, b r3) {
                a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r3, com.obric.memorydata.BuildConfig.CHANNEL);
                return true;
            }
        }

        int a(b r1);

        fq a(long r1);

        Object a(Continuation<? super Boolean> r1);

        List<com.obric.memorydata.database.model.a> a(long r1, int r3);

        List<AppEntity> a(List<String> r1);

        void a(com.obric.memorydata.database.model.b r1, fq r2, fq r3, boolean r4, boolean r5);

        void a(b r1, int r2);

        void a(String r1);

        void a(String r1, com.obric.memorydata.database.model.a r2, fq r3);

        boolean a();

        boolean a(fq r1);

        List<com.obric.memorydata.database.model.b> b(long r1, int r3);

        boolean b();

        boolean b(fq r1);

        boolean b(b r1);

        int c();

        boolean d();

        boolean e();
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J3\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\tHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/obric/memorydata/personalcontext/CallHistorySourceNumberBackfillManager$BackfillUpdate;", "", "candidate", "Lcom/obric/memorydata/database/model/CallHistorySourceNumberBackfillCandidate;", "entity", "Lcom/obric/capabilitykit/entity/app/CallHistoryEntity;", "sourceNumber", "", "newHash", "", "<init>", "(Lcom/obric/memorydata/database/model/CallHistorySourceNumberBackfillCandidate;Lcom/obric/capabilitykit/entity/app/CallHistoryEntity;Ljava/lang/String;I)V", "getCandidate", "()Lcom/obric/memorydata/database/model/CallHistorySourceNumberBackfillCandidate;", "getEntity", "()Lcom/obric/capabilitykit/entity/app/CallHistoryEntity;", "getSourceNumber", "()Ljava/lang/String;", "getNewHash", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.obric.memorydata.database.model.a f12004a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final CallHistoryEntity f12005b;
        private final String c;
        private final int d;

        public b(com.obric.memorydata.database.model.a r2, CallHistoryEntity r3, String r4, int r5) {
            Intrinsics.checkNotNullParameter(r2, "candidate");
            Intrinsics.checkNotNullParameter(r3, "entity");
            this.f12004a = r2;
            this.f12005b = r3;
            this.c = r4;
            this.d = r5;
        }

        public final com.obric.memorydata.database.model.a a() {
            return this.f12004a;
        }

        public final String b() {
            return this.c;
        }

        public final int c() {
            return this.d;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f12004a, r6.f12004a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f12005b, r6.f12005b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            int r0 = ((this.f12004a.hashCode() * 31) + this.f12005b.hashCode()) * 31;
            String r1 = this.c;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return ((r0 + r2) * 31) + Integer.hashCode(this.d);
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "BackfillUpdate(candidate=" + this.f12004a + ", entity=" + this.f12005b + ", sourceNumber=" + this.c + ", newHash=" + this.d + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/personalcontext/CallHistorySourceNumberBackfillManager$CandidateResult;", "", "<init>", "()V", "Success", "RetryWithCandidate", "Failure", "Lcom/obric/memorydata/personalcontext/CallHistorySourceNumberBackfillManager$CandidateResult$Failure;", "Lcom/obric/memorydata/personalcontext/CallHistorySourceNumberBackfillManager$CandidateResult$RetryWithCandidate;", "Lcom/obric/memorydata/personalcontext/CallHistorySourceNumberBackfillManager$CandidateResult$Success;", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static abstract class c {

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/personalcontext/CallHistorySourceNumberBackfillManager$CandidateResult$Failure;", "Lcom/obric/memorydata/personalcontext/CallHistorySourceNumberBackfillManager$CandidateResult;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class a extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f12006a = null;

            static {
                f12006a = new a();
            }

            private a() {
                super(null);
            }

            public boolean equals(Object r3) {
                if (this != r3) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r3, a.class) == true) goto L9;
                return false;
            L9:
                a r2 = (a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.memorydata.plugin");
                return true;
            }

            public int hashCode() {
                return 1720320023;
            }

            public String toString() {
                return "Failure";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/personalcontext/CallHistorySourceNumberBackfillManager$CandidateResult$RetryWithCandidate;", "Lcom/obric/memorydata/personalcontext/CallHistorySourceNumberBackfillManager$CandidateResult;", "candidate", "Lcom/obric/memorydata/database/model/CallHistorySourceNumberBackfillCandidate;", "<init>", "(Lcom/obric/memorydata/database/model/CallHistorySourceNumberBackfillCandidate;)V", "getCandidate", "()Lcom/obric/memorydata/database/model/CallHistorySourceNumberBackfillCandidate;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class b extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final com.obric.memorydata.database.model.a f12007a;

            public b(com.obric.memorydata.database.model.a r2) {
                Intrinsics.checkNotNullParameter(r2, "candidate");
                super(null);
                this.f12007a = r2;
            }

            public final com.obric.memorydata.database.model.a a() {
                return this.f12007a;
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
                return false;
            L8:
                b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
                if (Intrinsics.areEqual(this.f12007a, r6.f12007a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                return this.f12007a.hashCode();
            }

            public String toString() {
                return "RetryWithCandidate(candidate=" + this.f12007a + ')';
            }
        }

        /* JADX INFO: renamed from: com.obric.memorydata.personalcontext.CallHistorySourceNumberBackfillManager$c$c, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/personalcontext/CallHistorySourceNumberBackfillManager$CandidateResult$Success;", "Lcom/obric/memorydata/personalcontext/CallHistorySourceNumberBackfillManager$CandidateResult;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class C0651c extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0651c f12008a = null;

            static {
                f12008a = new C0651c();
            }

            private C0651c() {
                super(null);
            }

            public boolean equals(Object r3) {
                if (this != r3) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r3, C0651c.class) == true) goto L9;
                return false;
            L9:
                C0651c r2 = (C0651c) ZeusTransformUtils.preCheckCast(r3, C0651c.class, "com.obric.memorydata.plugin");
                return true;
            }

            public int hashCode() {
                return 939724432;
            }

            public String toString() {
                return "Success";
            }
        }

        private c() {
        }

        public /* synthetic */ c(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/personalcontext/CallHistorySourceNumberBackfillManager$FetchResult;", "", "<init>", "()V", "Success", "Failure", "Lcom/obric/memorydata/personalcontext/CallHistorySourceNumberBackfillManager$FetchResult$Failure;", "Lcom/obric/memorydata/personalcontext/CallHistorySourceNumberBackfillManager$FetchResult$Success;", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static abstract class d {

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/personalcontext/CallHistorySourceNumberBackfillManager$FetchResult$Failure;", "Lcom/obric/memorydata/personalcontext/CallHistorySourceNumberBackfillManager$FetchResult;", "errorName", "", "<init>", "(Ljava/lang/String;)V", "getErrorName", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class a extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final String f12009a;

            public a(String r2) {
                Intrinsics.checkNotNullParameter(r2, "errorName");
                super(null);
                this.f12009a = r2;
            }

            public final String a() {
                return this.f12009a;
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
                return false;
            L8:
                a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
                if (Intrinsics.areEqual(this.f12009a, r6.f12009a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                return this.f12009a.hashCode();
            }

            public String toString() {
                return "Failure(errorName=" + this.f12009a + ')';
            }
        }

        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/personalcontext/CallHistorySourceNumberBackfillManager$FetchResult$Success;", "Lcom/obric/memorydata/personalcontext/CallHistorySourceNumberBackfillManager$FetchResult;", "entities", "", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "<init>", "(Ljava/util/List;)V", "getEntities", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class b extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final List<AppEntity> f12010a;

            public b(List<? extends AppEntity> r3) {
                List<AppEntity> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r4, "entities");
                super(null);
                this.f12010a = r4;
            }

            public final List<AppEntity> a() {
                return this.f12010a;
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
                return false;
            L8:
                b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
                if (Intrinsics.areEqual(this.f12010a, r6.f12010a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                return this.f12010a.hashCode();
            }

            public String toString() {
                return "Success(entities=" + this.f12010a + ')';
            }
        }

        private d() {
        }

        public /* synthetic */ d(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0006\u0010\u0007\u001a\u00020\bJ\b\u0010\t\u001a\u00020\nH\u0016J\u000e\u0010\u000b\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010\fJ\u001e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016J\u001e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016J\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u000e2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u000eH\u0016J\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u0011H\u0016J\u0010\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001dH\u0016J\u0010\u0010!\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001dH\u0016J\b\u0010\"\u001a\u00020\u0005H\u0016J\u0010\u0010#\u001a\u0004\u0018\u00010\u001d2\u0006\u0010$\u001a\u00020\u0018J\u000e\u0010%\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u001b¨\u0006&"}, d2 = {"Lcom/obric/memorydata/personalcontext/CallHistorySourceNumberBackfillManager$RealBackfillRuntime;", "Lcom/obric/memorydata/personalcontext/CallHistorySourceNumberBackfillManager$BackfillRuntime;", "<init>", "()V", "hasPrivacyConsent", "", "isDone", "debugDoneMarkerState", "Lcom/obric/memorydata/personalcontext/CallHistorySourceNumberBackfillManager$DebugDoneMarkerState;", "currentEntityVersion", "", "areContentRebuildPackagesAvailable", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryCandidates", "", "Lcom/obric/memorydata/database/model/CallHistorySourceNumberBackfillCandidate;", "lastRawDbId", "", "pageSize", "queryContentCandidates", "Lcom/obric/memorydata/database/model/CallHistorySourceNumberContentCandidate;", "fetchSourceEntities", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "ids", "", "updateRawRow", com.obric.memorydata.BuildConfig.CHANNEL, "Lcom/obric/memorydata/personalcontext/CallHistorySourceNumberBackfillManager$BackfillUpdate;", "queryRaw", "Lcom/obric/memorydata/database/entity/RawCallHistoryEntity;", "rawDbId", "rebuildFullContent", "raw", "rebuildMetaFullContent", "saveDone", "queryFixtureRaw", "fixtureEntityId", "simulatePostCasNormalDonation", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class e implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f12011a = null;

        static {
            f12011a = new e();
        }

        private e() {
        }

        private static final void a(Ref.IntRef r12, MemoryFrameDb r13, b r14) {
            r12.element = r13.getCallHistoryRawDbDao().updateSourceNumberForBackfill(r14.a().a(), r14.a().b(), r14.a().c(), r14.b(), r14.c(), r14.a().d(), r14.a().e(), r14.a().f());
        }

        public static /* synthetic */ void lambda$9hY_yWXdO24fuHzrMxtK__ESFe4(Ref.IntRef r0, MemoryFrameDb r1, b r2) {
            a(r0, r1, r2);
        }

        @Override // com.obric.memorydata.personalcontext.CallHistorySourceNumberBackfillManager.a
        public int a(final b r10) {
            Intrinsics.checkNotNullParameter(r10, com.obric.memorydata.BuildConfig.CHANNEL);
            final MemoryFrameDb r1 = MemoryDbEngine.INSTANCE.getGlobalDbEngine();
            final Ref.IntRef r3 = new Ref.IntRef();     // Catch: RuntimeException -> L5 IllegalStateException -> L7 CancellationException -> L11
            r1.runInTransaction(new $$Lambda$CallHistorySourceNumberBackfillManager$e$9hY_yWXdO24fuHzrMxtK__ESFe4(r3, r1, r10));     // Catch: RuntimeException -> L5 IllegalStateException -> L7 CancellationException -> L11
        L15:
            return r3.element;
        L11:
            e = move-exception;
            throw e;
        L7:
            e = e;
            IRunLog r4 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
            StringBuilder r0 = new StringBuilder();
        L9:
            IRunLog.a.a(r4, "CallHistorySourceBackfill", r0.append("raw update failed, error=").append(e.getClass().getSimpleName()).toString(), null, 4, null);
            return -1;
        L5:
            e = e;
            r4 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
            r0 = new StringBuilder();
            goto L9
        }

        @Override // com.obric.memorydata.personalcontext.CallHistorySourceNumberBackfillManager.a
        public fq a(long r1) {
            return MemoryDbEngine.INSTANCE.getGlobalDbEngine().getCallHistoryRawDbDao().queryByRawDbId(r1);
        }

        @Override // com.obric.memorydata.personalcontext.CallHistorySourceNumberBackfillManager.a
        public Object a(Continuation<? super Boolean> r7) {
            Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r8, CallHistorySourceNumberBackfillManager$RealBackfillRuntime$areContentRebuildPackagesAvailable$1.class) == false) goto L7;
            CallHistorySourceNumberBackfillManager$RealBackfillRuntime$areContentRebuildPackagesAvailable$1 r0 = (CallHistorySourceNumberBackfillManager$RealBackfillRuntime$areContentRebuildPackagesAvailable$1) ZeusTransformUtils.preCheckCast(r8, CallHistorySourceNumberBackfillManager$RealBackfillRuntime$areContentRebuildPackagesAvailable$1.class, "com.obric.memorydata.plugin");
            if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
            r0.label -= Integer.MIN_VALUE;
        L8:
            Object r6 = r0.result;
            Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = r0.label;
            boolean r4 = false;
            if (r2 == 0) goto L16;
            if (r2 == 1) goto L15;
            if (r2 != 2) goto L14;
            ResultKt.throwOnFailure(r6);
        L29:
            PackageResource r10 = (PackageResource) ZeusTransformUtils.preCheckCast(r6, PackageResource.class, "com.obric.memorydata.plugin");
            if (r10 != null) goto L32;
        L34:
            boolean r11 = false;
        L35:
            if (r11 == false) goto L38;
            r4 = true;
        L38:
            return Boxing.boxBoolean(r4);
        L32:
            if (r10.isAvailable() != true) goto L34;
            r11 = true;
            goto L35
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L15:
            ResultKt.throwOnFailure(r6);
        L19:
            PackageResource r12 = (PackageResource) ZeusTransformUtils.preCheckCast(r6, PackageResource.class, "com.obric.memorydata.plugin");
            if (r12 != null) goto L22;
        L24:
            boolean r13 = false;
        L25:
            if (r13 == false) goto L38;
            MemoryScriptEngineEnv r14 = MemoryScriptEngineEnv.INSTANCE;
            r0.label = 2;
            r6 = r14.getPackage("build_meta_full_content", r0);
            if (r6 != r9) goto L29;
            return r9;
        L22:
            if (r12.isAvailable() != true) goto L24;
            r13 = true;
            goto L25
        L16:
            ResultKt.throwOnFailure(r6);
            MemoryScriptEngineEnv r15 = MemoryScriptEngineEnv.INSTANCE;
            r0.label = 1;
            r6 = r15.getPackage("build_entity_full_content", r0);
            if (r6 != r9) goto L19;
            return r9;
        L7:
            r0 = new CallHistorySourceNumberBackfillManager$RealBackfillRuntime$areContentRebuildPackagesAvailable$1(this, r8);
            goto L8
        }

        @Override // com.obric.memorydata.personalcontext.CallHistorySourceNumberBackfillManager.a
        public List<com.obric.memorydata.database.model.a> a(long r1, int r3) {
            return MemoryDbEngine.INSTANCE.getGlobalDbEngine().getCallHistoryRawDbDao().querySourceNumberBackfillCandidates(r1, r3);
        }

        @Override // com.obric.memorydata.personalcontext.CallHistorySourceNumberBackfillManager.a
        public List<AppEntity> a(List<String> r2) {
            List<String> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r1, "ids");
            EntitySyncDataSupplier r3 = EntityCollectorService.INSTANCE.getEntitySyncDataSupplier();
            if (r3 == null) goto L7;
            return r3.getWholeEntities(r1, 202);
        L7:
            throw new SourceUnavailableException();
        }

        @Override // com.obric.memorydata.personalcontext.CallHistorySourceNumberBackfillManager.a
        public void a(com.obric.memorydata.database.model.b r1, fq r2, fq r3, boolean r4, boolean r5) {
            a.C0650a.a(this, r1, r2, r3, r4, r5);
        }

        @Override // com.obric.memorydata.personalcontext.CallHistorySourceNumberBackfillManager.a
        public void a(b r1, int r2) {
            a.C0650a.a(this, r1, r2);
        }

        @Override // com.obric.memorydata.personalcontext.CallHistorySourceNumberBackfillManager.a
        public void a(String r1) {
            a.C0650a.a(this, r1);
        }

        @Override // com.obric.memorydata.personalcontext.CallHistorySourceNumberBackfillManager.a
        public void a(String r1, com.obric.memorydata.database.model.a r2, fq r3) {
            a.C0650a.a(this, r1, r2, r3);
        }

        @Override // com.obric.memorydata.personalcontext.CallHistorySourceNumberBackfillManager.a
        public boolean a() {
            return UserSettings.INSTANCE.hasAgreePrivacy();
        }

        @Override // com.obric.memorydata.personalcontext.CallHistorySourceNumberBackfillManager.a
        public boolean a(fq r10) {
            Intrinsics.checkNotNullParameter(r10, "raw");
            com.obric.memorydata.database.index.e r9 = (com.obric.memorydata.database.index.e) ZeusTransformUtils.preCheckCast(com.obric.memorydata.database.index.s.a().getEntityIndexImplMap().get(Integer.valueOf(r10.getType())), com.obric.memorydata.database.index.e.class, "com.obric.memorydata.plugin");
            if (r9 == null) goto L8;
            t<? extends com.obric.memorydata.database.entity.d, ? extends com.obric.memorydata.database.entity.i, ? extends com.obric.memorydata.database.entity.b> r2 = r9.getEntityIndexHelperInstance();
            if (r2 != null) goto L7;
            return false;
        L7:
            return t.b(r2, (com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r10, com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin"), "fullContent", r10.k(), null, 8, null);
        L8:
            return false;
        }

        @Override // com.obric.memorydata.personalcontext.CallHistorySourceNumberBackfillManager.a
        public List<com.obric.memorydata.database.model.b> b(long r1, int r3) {
            return MemoryDbEngine.INSTANCE.getGlobalDbEngine().getCallHistoryRawDbDao().querySourceNumberContentCandidates(r1, r3);
        }

        @Override // com.obric.memorydata.personalcontext.CallHistorySourceNumberBackfillManager.a
        public boolean b() {
            return Intrinsics.areEqual(IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getString("call_history_source_number_v1", null), "DONE");
        }

        @Override // com.obric.memorydata.personalcontext.CallHistorySourceNumberBackfillManager.a
        public boolean b(fq r3) {
            Intrinsics.checkNotNullParameter(r3, "raw");
            return t.f9438a.b((com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.obric.memorydata.personalcontext.CallHistorySourceNumberBackfillManager.a
        public boolean b(b r1) {
            return a.C0650a.a(this, r1);
        }

        @Override // com.obric.memorydata.personalcontext.CallHistorySourceNumberBackfillManager.a
        public int c() {
            EntityClassData r2 = (EntityClassData) ZeusTransformUtils.preCheckCast(EntityType.INSTANCE.getClassMap().get(202), EntityClassData.class, "com.obric.memorydata.plugin");
            if (r2 != null) goto L7;
            return 0;
        L7:
            return r2.getVersion();
        }

        @Override // com.obric.memorydata.personalcontext.CallHistorySourceNumberBackfillManager.a
        public boolean d() {
            return a.C0650a.a(this);
        }

        @Override // com.obric.memorydata.personalcontext.CallHistorySourceNumberBackfillManager.a
        public boolean e() {
            return IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).syncSave("call_history_source_number_v1", "DONE");
        }
    }

    static {
        f12002a = new CallHistorySourceNumberBackfillManager();
        f12003b = kotlinx.coroutines.sync.c.a(false, 1, null);
    }

    private CallHistorySourceNumberBackfillManager() {
    }

    private final b a(a r10, com.obric.memorydata.database.model.a r11, CallHistoryEntity r12) {
        a r9 = (a) ZeusTransformUtils.wrapperContextForParams(r10, a.class, "com.obric.memorydata.plugin");
        if (r12.getLastModifiedTime() == r11.d()) goto L6;
    L4:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CallHistorySourceBackfill", "source result rejected, reason=SOURCE_AHEAD_OF_RAW", null, 4, null);
        r9.a("SOURCE_AHEAD_OF_RAW");
        return null;
    L6:
        String r13 = r12.getSourceNumber();
        r12.setSourceNumber(null);     // Catch: Throwable -> L13
        r12.countHashCode();     // Catch: Throwable -> L13
        int r3 = r12.getHashCodeValue();     // Catch: Throwable -> L13
        r12.setSourceNumber(r13);
        if (r3 != r11.e()) goto L4;
        r12.countHashCode();
        return new b(r11, r12, r13, r12.getHashCodeValue());
    L13:
        th = move-exception;
        r12.setSourceNumber(r13);
        throw th;
    }

    private final c a(a r16, b r17, fq r18) {
        a r1 = (a) ZeusTransformUtils.wrapperContextForParams(r16, a.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.database.model.a r3 = r17.a();
        if (r18 != null) goto L5;
    L28:
        String r4 = "AFFECTED_ONE_DELETED_OR_REPLACED";
    L16:
        r1.a(r4, r3, r18);
        Object r0 = c.C0651c.f12008a;
    L18:
        return (c) ZeusTransformUtils.preCheckCast(r0, c.class, "com.obric.memorydata.plugin");
    L5:
        if (a(r18, r3) == false) goto L28;
        if (r18.getTimestamp() != r3.f()) goto L20;
        if (r18.getModifyTime() != r3.d()) goto L20;
        if (Intrinsics.areEqual(r18.o(), r17.b()) == false) goto L20;
        if (r18.getHashCodeValue() != r17.c()) goto L20;
        r4 = "AFFECTED_ONE_EXACT";
    L20:
        if (r18.getTimestamp() != r3.f()) goto L22;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CallHistorySourceBackfill", "raw update failed, reason=AFFECTED_ONE_UNCLASSIFIED", null, 4, null);
        r1.a("AFFECTED_ONE_UNCLASSIFIED", r3, r18);
        r1.a("AFFECTED_ONE_UNCLASSIFIED");
        r0 = c.a.f12006a;
        goto L18
    L22:
        if (r18.o() == null) goto L24;
        r1.a("AFFECTED_ONE_POST_CAS_DONATION", r3, r18);
        Object r2 = ZeusTransformUtils.preCheckCast(c.C0651c.f12008a, c.class, "com.obric.memorydata.plugin");
    L26:
        return (c) r2;
    L24:
        r1.a("AFFECTED_ONE_TOKEN_CHANGED_RETRY", r3, r18);
        r2 = ZeusTransformUtils.preCheckCast(new c.b(com.obric.memorydata.database.model.a.a(r3, 0, null, null, r18.getModifyTime(), r18.getHashCodeValue(), r18.getTimestamp(), 7, null)), c.class, "com.obric.memorydata.plugin");
        goto L26
    }

    private final d a(a r3, List<String> r4) {
    L15:
        return (d) ZeusTransformUtils.preCheckCast(new d.b(((a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin")).a((List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin"))), d.class, "com.obric.memorydata.plugin");
    L7:
        e = move-exception;
        String r5 = e.getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(r5, "getSimpleName(...)");
        d.a r6 = new d.a(r5);
    L10:
        return (d) ZeusTransformUtils.preCheckCast(r6, d.class, "com.obric.memorydata.plugin");
    L11:
        e = move-exception;
        throw e;
    L5:
        e = move-exception;
        String r7 = e.getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(r7, "getSimpleName(...)");
        r6 = new d.a(r7);
        goto L10
    }

    private final Object a(a r9, com.obric.memorydata.database.model.a r10, int r11, Continuation<? super Boolean> r12) {
        a r3 = (a) ZeusTransformUtils.wrapperContextForParams(r9, a.class, "com.obric.memorydata.plugin");
        Continuation<? super Boolean> r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        d r13 = a(r3, CollectionsKt.listOf(r10.b()));
        if (ZeusTransformUtils.instanceOf(r13, d.a.class) == false) goto L7;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CallHistorySourceBackfill", "source query failed, error=" + ((d.a) ZeusTransformUtils.preCheckCast(r13, d.a.class, "com.obric.memorydata.plugin")).a(), null, 4, null);
        return Boxing.boxBoolean(false);
    L7:
        if (ZeusTransformUtils.instanceOf(r13, d.b.class) == false) goto L26;
        Object r14 = CollectionsKt.singleOrNull(((d.b) ZeusTransformUtils.preCheckCast(r13, d.b.class, "com.obric.memorydata.plugin")).a());
        if (ZeusTransformUtils.instanceOf(r14, CallHistoryEntity.class) == false) goto L11;
        CallHistoryEntity r15 = (CallHistoryEntity) ZeusTransformUtils.preCheckCast(r14, CallHistoryEntity.class, "com.obric.memorydata.plugin");
    L12:
        CallHistoryEntity r5 = r15;
        if (r5 != null) goto L17;
        return Boxing.boxBoolean(((d.b) ZeusTransformUtils.preCheckCast(r13, d.b.class, "com.obric.memorydata.plugin")).a().isEmpty());
    L17:
        if (Intrinsics.areEqual(r5.getId(), r10.b()) == false) goto L24;
        if (Intrinsics.areEqual(r5.get_packageName(), r10.c()) == false) goto L24;
        return a(r3, r10, r5, r11, r7);
    L24:
        return Boxing.boxBoolean(a(r3, "retry_identity_mismatch"));
    L11:
        r15 = null;
        goto L12
    L26:
        throw new NoWhenBranchMatchedException();
    }

    private final Object a(a r13, com.obric.memorydata.database.model.a r14, CallHistoryEntity r15, int r16, Continuation<? super Boolean> r17) {
        CallHistorySourceNumberBackfillManager r0 = this;
        a r1 = (a) ZeusTransformUtils.wrapperContextForParams(r13, a.class, "com.obric.memorydata.plugin");
        Continuation r3 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r17, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, CallHistorySourceNumberBackfillManager$processSourceEntity$1.class) == false) goto L7;
        CallHistorySourceNumberBackfillManager$processSourceEntity$1 r4 = (CallHistorySourceNumberBackfillManager$processSourceEntity$1) ZeusTransformUtils.preCheckCast(r3, CallHistorySourceNumberBackfillManager$processSourceEntity$1.class, "com.obric.memorydata.plugin");
        if ((r4.label & Integer.MIN_VALUE) == 0) goto L7;
        r4.label -= Integer.MIN_VALUE;
    L8:
        Object r5 = r4.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r4.label;
        boolean r8 = false;
        if (r7 == 0) goto L16;
        if (r7 == 1) goto L15;
        if (r7 != 2) goto L14;
        ResultKt.throwOnFailure(r5);
    L35:
        return r5;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        int r2 = r4.I$0;
        r1 = (a) ZeusTransformUtils.preCheckCast(r4.L$1, a.class, "com.obric.memorydata.plugin");
        CallHistorySourceNumberBackfillManager r9 = (CallHistorySourceNumberBackfillManager) ZeusTransformUtils.preCheckCast(r4.L$0, CallHistorySourceNumberBackfillManager.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r5);
        int r10 = r2;
        r0 = r9;
    L23:
        c r11 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r11, c.C0651c.f12008a) == false) goto L27;
        r8 = true;
    L39:
        return Boxing.boxBoolean(r8);
    L27:
        if (ZeusTransformUtils.instanceOf(r11, c.b.class) == false) goto L37;
        if (r10 < 3) goto L32;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CallHistorySourceBackfill", "raw update contention exceeded retry limit", null, 4, null);
        r1.a("TOKEN_CONTENTION");
        return Boxing.boxBoolean(false);
    L32:
        r4.L$0 = null;
        r4.L$1 = null;
        r4.label = 2;
        r5 = r0.a(r1, ((c.b) ZeusTransformUtils.preCheckCast(r11, c.b.class, "com.obric.memorydata.plugin")).a(), r10 + 1, r4);
        if (r5 != r6) goto L35;
        return r6;
    L37:
        if (Intrinsics.areEqual(r11, c.a.f12006a) == true) goto L39;
        throw new NoWhenBranchMatchedException();
    L16:
        ResultKt.throwOnFailure(r5);
        b r12 = a(r1, r14, r15);
        if (r12 == null) goto L19;
        r4.L$0 = r0;
        r4.L$1 = r1;
        r10 = r16;
        r4.I$0 = r10;
        r4.label = 1;
        r5 = a(r1, r12, r4);
        if (r5 != r6) goto L23;
        return r6;
    L19:
        return Boxing.boxBoolean(false);
    L7:
        r4 = new CallHistorySourceNumberBackfillManager$processSourceEntity$1(this, r3);
        goto L8
    }

    private final Object a(a r15, com.obric.memorydata.database.model.a r16, fq r17, Continuation<? super c> r18) {
        a r2 = (a) ZeusTransformUtils.wrapperContextForParams(r15, a.class, "com.obric.memorydata.plugin");
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r18, Continuation.class, "com.obric.memorydata.plugin");
        if (r17 != null) goto L5;
    L22:
        r2.a("AFFECTED_ZERO_DELETED_OR_REPLACED", r16, r17);
        return c.C0651c.f12008a;
    L5:
        if (a(r17, r16) == false) goto L22;
        if (r17.o() == null) goto L12;
        r2.a("AFFECTED_ZERO_CURRENT_NON_NULL", r16, r17);
        return c.C0651c.f12008a;
    L12:
        if (r17.getTimestamp() == r16.f()) goto L14;
    L20:
        r2.a("AFFECTED_ZERO_TOKEN_CHANGED_RETRY", r16, r17);
        return new c.b(com.obric.memorydata.database.model.a.a(r16, 0, null, null, r17.getModifyTime(), r17.getHashCodeValue(), r17.getTimestamp(), 7, null));
    L14:
        if (r17.getModifyTime() != r16.d()) goto L20;
        if (r17.getHashCodeValue() != r16.e()) goto L20;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CallHistorySourceBackfill", "raw update failed, reason=affected_zero_without_token_change", null, 4, null);
        r2.a("AFFECTED_ZERO_UNCLASSIFIED", r16, r17);
        return c.a.f12006a;
    }

    private final Object a(a r19, com.obric.memorydata.database.model.b r20, int r21, Function0<Unit> r22, Continuation<? super Boolean> r23) {
        a r10 = (a) ZeusTransformUtils.wrapperContextForParams(r19, a.class, "com.obric.memorydata.plugin");
        Function0<Unit> r11 = (Function0) ZeusTransformUtils.wrapperContextForParams(r22, Function0.class, "com.obric.memorydata.plugin");
        Continuation<? super Boolean> r12 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r23, Continuation.class, "com.obric.memorydata.plugin");
        fq r3 = r10.a(r20.a());
        if (r3 == null) goto L29;
        if (a(r3, r20) == false) goto L29;
        long r14 = r3.getTimestamp();
        boolean r16 = a(r10, r3);
        boolean r17 = b(r10, r3);
        fq r6 = r10.a(r20.a());
        r10.a(r20, r3, r6, r16, r17);
        if (r6 == null) goto L27;
        if (a(r6, r20) == false) goto L27;
        if (r6.getTimestamp() != r14) goto L21;
        if (r16 == false) goto L18;
        if (r17 == false) goto L18;
        return Boxing.boxBoolean(true);
    L18:
        r10.a("PHASE_B_CONTENT_FAILED");
        return Boxing.boxBoolean(false);
    L21:
        if (r21 < 3) goto L24;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CallHistorySourceBackfill", "phase_b token contention exceeded retry limit", null, 4, null);
        r10.a("PHASE_B_TOKEN_CONTENTION");
        return Boxing.boxBoolean(false);
    L24:
        r11.invoke();
        return a(r10, r20, r21 + 1, r11, r12);
    L27:
        return Boxing.boxBoolean(true);
    L29:
        return Boxing.boxBoolean(true);
    }

    private final Object a(a r7, b r8, Continuation<? super c> r9) {
        a r10 = (a) ZeusTransformUtils.wrapperContextForParams(r7, a.class, "com.obric.memorydata.plugin");
        Continuation<? super c> r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        int r0 = r10.a(r8);
        r10.a(r8, r0);
        if (r0 >= 0) goto L7;
        return c.a.f12006a;
    L7:
        if (r0 <= 1) goto L10;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CallHistorySourceBackfill", "raw update failed, reason=affected_gt_one", null, 4, null);
        return c.a.f12006a;
    L10:
        if (r0 == 1) goto L12;
    L15:
        fq r1 = r10.a(r8.a().a());
        if (r0 != 1) goto L20;
        return a(r10, r8, r1);
    L20:
        return a(r10, r8.a(), r1, r11);
    L12:
        if (r10.b(r8) == true) goto L15;
        return c.a.f12006a;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x0216 -> B:59:0x0219). Please report as a decompilation issue!!! */
    private final Object a(a r16, List<com.obric.memorydata.database.model.a> r17, List<? extends AppEntity> r18, Continuation<? super Boolean> r19) {
        a r0 = (a) ZeusTransformUtils.wrapperContextForParams(r16, a.class, "com.obric.memorydata.plugin");
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.memorydata.plugin");
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.memorydata.plugin");
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r19, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, CallHistorySourceNumberBackfillManager$processReturnedEntities$1.class) == false) goto L7;
        CallHistorySourceNumberBackfillManager$processReturnedEntities$1 r5 = (CallHistorySourceNumberBackfillManager$processReturnedEntities$1) ZeusTransformUtils.preCheckCast(r4, CallHistorySourceNumberBackfillManager$processReturnedEntities$1.class, "com.obric.memorydata.plugin");
        if ((r5.label & Integer.MIN_VALUE) == 0) goto L7;
        r5.label -= Integer.MIN_VALUE;
    L8:
        Object r6 = r5.result;
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r8 = r5.label;
        if (r8 == 0) goto L14;
        if (r8 != 1) goto L13;
        Iterator r1 = (Iterator) ZeusTransformUtils.preCheckCast(r5.L$3, Iterator.class, "com.obric.memorydata.plugin");
        Set r9 = (Set) ZeusTransformUtils.preCheckCast(r5.L$2, Set.class, "com.obric.memorydata.plugin");
        Map r10 = (Map) ZeusTransformUtils.preCheckCast(r5.L$1, Map.class, "com.obric.memorydata.plugin");
        a r11 = (a) ZeusTransformUtils.preCheckCast(r5.L$0, a.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r6);
        Set r12 = r9;
        Map r13 = r10;
        CallHistorySourceNumberBackfillManager$processReturnedEntities$1 r14 = r5;
        Object r15 = r7;
        a r110 = r11;
    L60:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r6, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L62;
    L35:
        if (r1.hasNext() == false) goto L64;
        AppEntity r20 = (AppEntity) ZeusTransformUtils.preCheckCast(r1.next(), AppEntity.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r20, CallHistoryEntity.class) == false) goto L39;
        CallHistoryEntity r21 = (CallHistoryEntity) ZeusTransformUtils.preCheckCast(r20, CallHistoryEntity.class, "com.obric.memorydata.plugin");
    L40:
        CallHistoryEntity r22 = r21;
        if (r22 == null) goto L43;
        com.obric.memorydata.database.model.a r23 = (com.obric.memorydata.database.model.a) ZeusTransformUtils.preCheckCast(r13.get(r22.getId()), com.obric.memorydata.database.model.a.class, "com.obric.memorydata.plugin");
        if (r23 != null) goto L49;
        return Boxing.boxBoolean(f12002a.a(r110, "unexpected_id"));
    L49:
        if (Intrinsics.areEqual(r22.get_packageName(), r23.c()) == true) goto L53;
        return Boxing.boxBoolean(f12002a.a(r110, "package_mismatch"));
    L53:
        if (r12.add(r22.getId()) == false) goto L55;
        CallHistorySourceNumberBackfillManager r24 = f12002a;
        r14.L$0 = r110;
        r14.L$1 = r13;
        r14.L$2 = r12;
        r14.L$3 = r1;
        r14.label = 1;
        r6 = r24.a(r110, r23, r22, 1, r14);
        if (r6 != r15) goto L60;
        return r15;
    L55:
        return Boxing.boxBoolean(f12002a.a(r110, "duplicate_return"));
    L43:
        return Boxing.boxBoolean(f12002a.a(r110, "unexpected_type"));
    L39:
        r21 = null;
        goto L40
    L64:
        return Boxing.boxBoolean(true);
    L62:
        return Boxing.boxBoolean(false);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r6);
        if (r3.isEmpty() == true) goto L17;
        Iterable r25 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin");
        Collection r26 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r25, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r27 = r25.iterator();
    L20:
        if (r27.hasNext() == false) goto L22;
        r26.add(((com.obric.memorydata.database.model.a) ZeusTransformUtils.preCheckCast(r27.next(), com.obric.memorydata.database.model.a.class, "com.obric.memorydata.plugin")).b());
        goto L20
    L22:
        List r28 = (List) ZeusTransformUtils.preCheckCast(r26, List.class, "com.obric.memorydata.plugin");
        if (r28.size() == CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast(r28, Iterable.class, "com.obric.memorydata.plugin")).size()) goto L25;
        boolean r29 = true;
    L26:
        if (r29 == false) goto L29;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CallHistorySourceBackfill", "source result rejected, reason=duplicate_candidate", null, 4, null);
        return Boxing.boxBoolean(false);
    L29:
        Iterable r30 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin");
        Map r31 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r30, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r32 = r30.iterator();
    L31:
        if (r32.hasNext() == false) goto L33;
        Object r33 = r32.next();
        r31.put(((com.obric.memorydata.database.model.a) ZeusTransformUtils.preCheckCast(r33, com.obric.memorydata.database.model.a.class, "com.obric.memorydata.plugin")).b(), r33);
        goto L31
    L33:
        r110 = r0;
        r12 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        r13 = r31;
        r14 = r5;
        r15 = r7;
        goto L35
    L25:
        r29 = false;
        goto L26
    L17:
        return Boxing.boxBoolean(true);
    L7:
        r5 = new CallHistorySourceNumberBackfillManager$processReturnedEntities$1(this, r4);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x00aa -> B:21:0x00ad). Please report as a decompilation issue!!! */
    private final Object a(a r6, List<com.obric.memorydata.database.model.a> r7, Continuation<? super Boolean> r8) {
        a r9 = (a) ZeusTransformUtils.wrapperContextForParams(r6, a.class, "com.obric.memorydata.plugin");
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r11, CallHistorySourceNumberBackfillManager$processPage$1.class) == false) goto L7;
        CallHistorySourceNumberBackfillManager$processPage$1 r0 = (CallHistorySourceNumberBackfillManager$processPage$1) ZeusTransformUtils.preCheckCast(r11, CallHistorySourceNumberBackfillManager$processPage$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r5 = r0.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        Iterator r13 = (Iterator) ZeusTransformUtils.preCheckCast(r0.L$1, Iterator.class, "com.obric.memorydata.plugin");
        a r14 = (a) ZeusTransformUtils.preCheckCast(r0.L$0, a.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r5);
    L22:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r5, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L24;
        a r15 = r14;
    L16:
        if (r13.hasNext() == false) goto L27;
        List<com.obric.memorydata.database.model.a> r16 = (List) ZeusTransformUtils.preCheckCast(r13.next(), List.class, "com.obric.memorydata.plugin");
        CallHistorySourceNumberBackfillManager r3 = f12002a;
        r0.L$0 = r15;
        r0.L$1 = r13;
        r0.label = 1;
        Object r17 = r3.b(r15, r16, r0);
        if (r17 != r12) goto L20;
        return r12;
    L20:
        r14 = r15;
        r5 = r17;
        goto L22
    L27:
        return Boxing.boxBoolean(true);
    L24:
        return Boxing.boxBoolean(false);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r5);
        r13 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.chunked((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin"), 50), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        r15 = r9;
    L7:
        r0 = new CallHistorySourceNumberBackfillManager$processPage$1(this, r11);
        goto L8
    }

    private final Object a(a r17, Continuation<? super Boolean> r18) {
        a r0 = (a) ZeusTransformUtils.wrapperContextForParams(r17, a.class, "com.obric.memorydata.plugin");
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r18, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, CallHistorySourceNumberBackfillManager$checkIfNeededInternal$1.class) == false) goto L7;
        CallHistorySourceNumberBackfillManager$checkIfNeededInternal$1 r3 = (CallHistorySourceNumberBackfillManager$checkIfNeededInternal$1) ZeusTransformUtils.preCheckCast(r2, CallHistorySourceNumberBackfillManager$checkIfNeededInternal$1.class, "com.obric.memorydata.plugin");
        if ((r3.label & Integer.MIN_VALUE) == 0) goto L7;
        r3.label -= Integer.MIN_VALUE;
    L8:
        Object r4 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        boolean r8 = true;
        if (r6 == 0) goto L20;
        if (r6 == 1) goto L19;
        if (r6 != 2) goto L18;
        kotlinx.coroutines.sync.a r7 = (kotlinx.coroutines.sync.a) ZeusTransformUtils.preCheckCast(r3.L$1, kotlinx.coroutines.sync.a.class, "com.obric.memorydata.plugin");
        r0 = (a) ZeusTransformUtils.preCheckCast(r3.L$0, a.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);     // Catch: Throwable -> L15
    L41:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L44;
    L30:
        r8 = false;
    L47:
        Boolean r1 = Boxing.boxBoolean(r8);     // Catch: Throwable -> L15
        r7.b(null);
        return r1;
    L44:
        if (r0.e() == true) goto L46;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CallHistorySourceBackfill", "migration done marker save failed", null, 4, null);     // Catch: Throwable -> L15
        goto L30
    L46:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CallHistorySourceBackfill", "migration completed", false, 4, null);     // Catch: Throwable -> L15
    L15:
        th = th;
    L52:
        r7.b(null);
        throw th;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        kotlinx.coroutines.sync.a r9 = (kotlinx.coroutines.sync.a) ZeusTransformUtils.preCheckCast(r3.L$1, kotlinx.coroutines.sync.a.class, "com.obric.memorydata.plugin");
        a r10 = (a) ZeusTransformUtils.preCheckCast(r3.L$0, a.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);
        kotlinx.coroutines.sync.a r11 = r9;
        r0 = r10;
    L56:
    L50:
        th = th;
        r7 = r11;
        goto L52
    L28:
        if (r0.a() == true) goto L32;
    L29:
        r7 = r11;
        goto L30
    L32:
        if (r0.b() == true) goto L29;
        if (r0.c() < 5) goto L29;
        CallHistorySourceNumberBackfillManager r12 = f12002a;     // Catch: Throwable -> L50
        r3.L$0 = r0;     // Catch: Throwable -> L50
        r3.L$1 = r11;     // Catch: Throwable -> L50
        r3.label = 2;     // Catch: Throwable -> L50
        Object r13 = r12.b(r0, r3);     // Catch: Throwable -> L50
        if (r13 != r5) goto L39;
        return r5;
    L39:
        r7 = r11;
        r4 = r13;
        goto L41
    L20:
        ResultKt.throwOnFailure(r4);
        if (r0.a() == false) goto L23;
        r11 = f12003b;
        r3.L$0 = r0;
        r3.L$1 = r11;
        r3.label = 1;
        if (r11.a(null, r3) != r5) goto L56;
        return r5;
    L23:
        return Boxing.boxBoolean(false);
    L7:
        r3 = new CallHistorySourceNumberBackfillManager$checkIfNeededInternal$1(this, r2);
        goto L8
    }

    public static final /* synthetic */ Object a(CallHistorySourceNumberBackfillManager r8, a r9, com.obric.memorydata.database.model.a r10, CallHistoryEntity r11, int r12, Continuation r13) {
        return r8.a((a) ZeusTransformUtils.wrapperContextForParams(r9, a.class, "com.obric.memorydata.plugin"), r10, r11, r12, (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ Object a(CallHistorySourceNumberBackfillManager r2, a r3, List r4, List r5, Continuation r6) {
        return r2.a((a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ Object a(CallHistorySourceNumberBackfillManager r2, a r3, List r4, Continuation r5) {
        return r2.a((a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ Object a(CallHistorySourceNumberBackfillManager r2, a r3, Continuation r4) {
        return r2.a((a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private static final Unit a(Ref.IntRef r1) {
        r1.element++;
        return Unit.INSTANCE;
    }

    private final boolean a(fq r5, com.obric.memorydata.database.model.a r6) {
        if (r5.getId() == r6.a()) goto L5;
    L9:
        return false;
    L5:
        if (Intrinsics.areEqual(r5.getEntityId(), r6.b()) == false) goto L9;
        if (Intrinsics.areEqual(r5.getPackageName(), r6.c()) == false) goto L9;
        return true;
    }

    private final boolean a(fq r5, com.obric.memorydata.database.model.b r6) {
        if (r5.getId() == r6.a()) goto L5;
    L9:
        return false;
    L5:
        if (Intrinsics.areEqual(r5.getEntityId(), r6.b()) == false) goto L9;
        if (Intrinsics.areEqual(r5.getPackageName(), r6.c()) == false) goto L9;
        return true;
    }

    private final boolean a(a r2, fq r3) {
        return ((a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin")).a(r3);
    }

    private final boolean a(a r7, String r8) {
        a r6 = (a) ZeusTransformUtils.wrapperContextForParams(r7, a.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CallHistorySourceBackfill", "source result rejected, reason=" + r8, null, 4, null);
        r6.a(r8);
        return false;
    }

    private final Object b(a r12, List<com.obric.memorydata.database.model.a> r13, Continuation<? super Boolean> r14) {
        a r15 = (a) ZeusTransformUtils.wrapperContextForParams(r12, a.class, "com.obric.memorydata.plugin");
        List<com.obric.memorydata.database.model.a> r16 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        Continuation<? super Boolean> r17 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r14, Continuation.class, "com.obric.memorydata.plugin");
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r2.add(((com.obric.memorydata.database.model.a) ZeusTransformUtils.preCheckCast(r1.next(), com.obric.memorydata.database.model.a.class, "com.obric.memorydata.plugin")).b());
        goto L4
    L6:
        List<String> r3 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin");
        if (r3.size() == CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin")).size()) goto L10;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CallHistorySourceBackfill", "source query skipped, duplicate candidate ids", null, 4, null);
        return Boxing.boxBoolean(false);
    L10:
        d r4 = a(r15, r3);
        if (ZeusTransformUtils.instanceOf(r4, d.a.class) == false) goto L15;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CallHistorySourceBackfill", "source query failed, error=" + ((d.a) ZeusTransformUtils.preCheckCast(r4, d.a.class, "com.obric.memorydata.plugin")).a(), null, 4, null);
        return Boxing.boxBoolean(false);
    L15:
        if (ZeusTransformUtils.instanceOf(r4, d.b.class) == false) goto L19;
        return a(r15, r16, ((d.b) ZeusTransformUtils.preCheckCast(r4, d.b.class, "com.obric.memorydata.plugin")).a(), r17);
    L19:
        throw new NoWhenBranchMatchedException();
    }

    private final Object b(a r7, Continuation<? super Boolean> r8) {
        a r9 = (a) ZeusTransformUtils.wrapperContextForParams(r7, a.class, "com.obric.memorydata.plugin");
        Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r10, CallHistorySourceNumberBackfillManager$runBackfill$1.class) == false) goto L7;
        CallHistorySourceNumberBackfillManager$runBackfill$1 r0 = (CallHistorySourceNumberBackfillManager$runBackfill$1) ZeusTransformUtils.preCheckCast(r10, CallHistorySourceNumberBackfillManager$runBackfill$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r11);
    L26:
        return r11;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r9 = (a) ZeusTransformUtils.preCheckCast(r0.L$1, a.class, "com.obric.memorydata.plugin");
        CallHistorySourceNumberBackfillManager this = (CallHistorySourceNumberBackfillManager) ZeusTransformUtils.preCheckCast(r0.L$0, CallHistorySourceNumberBackfillManager.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r11);
    L20:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r11, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L28;
        if (r9.d() == false) goto L28;
        r0.L$0 = null;
        r0.L$1 = null;
        r0.label = 2;
        r11 = this.d(r9, r0);
        if (r11 != r2) goto L26;
        return r2;
    L28:
        return Boxing.boxBoolean(false);
    L16:
        ResultKt.throwOnFailure(r11);
        r0.L$0 = this;
        r0.L$1 = r9;
        r0.label = 1;
        r11 = c(r9, r0);
        if (r11 != r2) goto L20;
        return r2;
    L7:
        r0 = new CallHistorySourceNumberBackfillManager$runBackfill$1(this, r10);
        goto L8
    }

    public static final /* synthetic */ Object b(CallHistorySourceNumberBackfillManager r2, a r3, Continuation r4) {
        return r2.b((a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private final boolean b(a r2, fq r3) {
        return ((a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin")).b(r3);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x00f2 -> B:23:0x00f9). Please report as a decompilation issue!!! */
    private final Object c(a r20, Continuation<? super Boolean> r21) {
        a r0 = (a) ZeusTransformUtils.wrapperContextForParams(r20, a.class, "com.obric.memorydata.plugin");
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r21, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, CallHistorySourceNumberBackfillManager$runPhaseA$1.class) == false) goto L7;
        CallHistorySourceNumberBackfillManager$runPhaseA$1 r3 = (CallHistorySourceNumberBackfillManager$runPhaseA$1) ZeusTransformUtils.preCheckCast(r2, CallHistorySourceNumberBackfillManager$runPhaseA$1.class, "com.obric.memorydata.plugin");
        if ((r3.label & Integer.MIN_VALUE) == 0) goto L7;
        r3.label -= Integer.MIN_VALUE;
        CallHistorySourceNumberBackfillManager r4 = this;
    L8:
        Object r5 = r3.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r3.label;
        if (r7 == 0) goto L14;
        if (r7 != 1) goto L13;
        int r1 = r3.I$2;
        int r8 = r3.I$1;
        int r9 = r3.I$0;
        List<com.obric.memorydata.database.model.a> r10 = (List) ZeusTransformUtils.preCheckCast(r3.L$2, List.class, "com.obric.memorydata.plugin");
        a r11 = (a) ZeusTransformUtils.preCheckCast(r3.L$1, a.class, "com.obric.memorydata.plugin");
        CallHistorySourceNumberBackfillManager r12 = (CallHistorySourceNumberBackfillManager) ZeusTransformUtils.preCheckCast(r3.L$0, CallHistorySourceNumberBackfillManager.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r5);
        int r13 = r8;
        r4 = r12;
    L24:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r5, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L27;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CallHistorySourceBackfill", "backfill stopped, failedPageSize=" + r10.size(), null, 4, null);
        return Boxing.boxBoolean(false);
    L27:
        int r14 = r10.size() + r1;
        r0 = r11;
        long r15 = ((com.obric.memorydata.database.model.a) ZeusTransformUtils.preCheckCast(CollectionsKt.last(r10), com.obric.memorydata.database.model.a.class, "com.obric.memorydata.plugin")).a();
    L15:
        r10 = r0.a(r15, 200);
        if (r10.isEmpty() == false) goto L19;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CallHistorySourceBackfill", "phase_a finished, pageCount=" + r9 + ", candidateCount=" + r13 + ", processedCandidateCount=" + r14, false, 4, null);
        return Boxing.boxBoolean(true);
    L19:
        r9 = r9 + 1;
        int r16 = r10.size() + r13;
        r3.L$0 = r4;
        r3.L$1 = r0;
        r3.L$2 = r10;
        r3.I$0 = r9;
        r3.I$1 = r16;
        r3.I$2 = r14;
        r3.label = 1;
        Object r17 = r4.a(r0, r10, r3);
        if (r17 != r6) goto L22;
        return r6;
    L22:
        r11 = r0;
        r1 = r14;
        r5 = r17;
        r13 = r16;
        goto L24
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r5);
        r15 = 0;
        r14 = 0;
        r9 = 0;
        r13 = 0;
    L7:
        r4 = this;
        r3 = new CallHistorySourceNumberBackfillManager$runPhaseA$1(r4, r2);
        goto L8
    }

    public static final /* synthetic */ Object c(CallHistorySourceNumberBackfillManager r2, a r3, Continuation r4) {
        return r2.c((a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v1, types: [int] */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x01c1 -> B:38:0x01ca). Please report as a decompilation issue!!! */
    private final Object d(a r23, Continuation<? super Boolean> r24) {
        a r0 = (a) ZeusTransformUtils.wrapperContextForParams(r23, a.class, "com.obric.memorydata.plugin");
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r24, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, CallHistorySourceNumberBackfillManager$runPhaseB$1.class) == false) goto L7;
        CallHistorySourceNumberBackfillManager$runPhaseB$1 r3 = (CallHistorySourceNumberBackfillManager$runPhaseB$1) ZeusTransformUtils.preCheckCast(r2, CallHistorySourceNumberBackfillManager$runPhaseB$1.class, "com.obric.memorydata.plugin");
        if ((r3.label & Integer.MIN_VALUE) == 0) goto L7;
        r3.label -= Integer.MIN_VALUE;
    L8:
        Object r4 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        boolean r7 = true;
        ?? r8 = 1;
        if (r6 == 0) goto L16;
        if (r6 == 1) goto L15;
        if (r6 != 2) goto L14;
        int r1 = r3.I$3;
        int r9 = r3.I$2;
        int r10 = r3.I$1;
        int r11 = r3.I$0;
        Iterator r12 = (Iterator) ZeusTransformUtils.preCheckCast(r3.L$3, Iterator.class, "com.obric.memorydata.plugin");
        List<com.obric.memorydata.database.model.b> r13 = (List) ZeusTransformUtils.preCheckCast(r3.L$2, List.class, "com.obric.memorydata.plugin");
        Ref.IntRef r14 = (Ref.IntRef) ZeusTransformUtils.preCheckCast(r3.L$1, Ref.IntRef.class, "com.obric.memorydata.plugin");
        a r15 = (a) ZeusTransformUtils.preCheckCast(r3.L$0, a.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);
        int r16 = r9;
        int r17 = r10;
        final Ref.IntRef r18 = r14;
    L39:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L43;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CallHistorySourceBackfill", "phase_b stopped, failedPageSize=" + r13.size(), null, 4, null);
        return Boxing.boxBoolean(false);
    L43:
        if (r18.element < r1) goto L45;
        int r19 = r11;
        r0 = r15;
        int r110 = r16;
    L33:
        if (r12.hasNext() == false) goto L47;
        com.obric.memorydata.database.model.b r111 = (com.obric.memorydata.database.model.b) ZeusTransformUtils.preCheckCast(r12.next(), com.obric.memorydata.database.model.b.class, "com.obric.memorydata.plugin");
        int r112 = r18.element;
        CallHistorySourceNumberBackfillManager r113 = f12002a;
        Function0<Unit> r20 = new $$Lambda$CallHistorySourceNumberBackfillManager$nvTt3E4e6nZZJ33_b4KOKAy39I0(r18);
        r3.L$0 = r0;
        r3.L$1 = r18;
        r3.L$2 = r13;
        r3.L$3 = r12;
        r3.I$0 = r19;
        r3.I$1 = r17;
        r3.I$2 = r110;
        r3.I$3 = r112;
        r3.label = 2;
        Object r21 = r113.a(r0, r111, 1, r20, r3);
        if (r21 != r5) goto L37;
        return r5;
    L37:
        r15 = r0;
        r1 = r112;
        int r22 = r110;
        r11 = r19;
        r4 = r21;
        r16 = r22 == true ? 1 : 0;
        goto L39
    L47:
        long r114 = ((com.obric.memorydata.database.model.b) ZeusTransformUtils.preCheckCast(CollectionsKt.last(r13), com.obric.memorydata.database.model.b.class, "com.obric.memorydata.plugin")).a();
        r7 = true;
        Ref.IntRef r115 = r18;
        int r116 = r110;
        long r25 = r114;
    L17:
        List<com.obric.memorydata.database.model.b> r117 = r0.b(r25, 200);
        if (r117.isEmpty() == false) goto L21;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CallHistorySourceBackfill", "phase_b finished, pageCount=" + r19 + ", candidateCount=" + r17 + ", retryCount=" + r115.element, false, 4, null);
        return Boxing.boxBoolean(r7);
    L21:
        if (r116 != 0) goto L31;
        r3.L$0 = r0;
        r3.L$1 = r115;
        r3.L$2 = r117;
        r3.L$3 = null;
        r3.I$0 = r19;
        r3.I$1 = r17;
        r3.I$2 = r7 ? 1 : 0;
        r3.label = r7 ? 1 : 0;
        Object r26 = r0.a(r3);
        if (r26 != r5) goto L25;
        return r5;
    L25:
        a r118 = r0;
        int r27 = r7 ? 1 : 0;
        int r28 = r19;
        r4 = r26;
        r8 = r7;
    L27:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L30;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CallHistorySourceBackfill", "skip migration, content rebuild packages unavailable", false, 4, null);
        r118.a("CONTENT_PACKAGES_UNAVAILABLE");
        return Boxing.boxBoolean(false);
    L30:
        a r29 = r118;
        int r119 = r27;
        r0 = r29;
    L31:
        r19 = r28 + r8;
        r17 = r17 + r117.size();
        Ref.IntRef r210 = r115;
        r12 = ((Iterable) ZeusTransformUtils.preCheckCast(r117, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        r18 = r210;
        r13 = r117;
        r110 = r119 == true ? 1 : 0;
        goto L33
    L48:
        r19 = r19 + (r7 ? 1 : 0);
        r17 = r17 + r117.size();
        Ref.IntRef r211 = r115;
        r12 = ((Iterable) ZeusTransformUtils.preCheckCast(r117, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        r18 = r211;
        int r212 = r116;
        r13 = r117;
        r110 = r212 == true ? 1 : 0;
        goto L33
    L45:
        return Boxing.boxBoolean(false);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r27 = r3.I$2;
        r17 = r3.I$1;
        r28 = r3.I$0;
        r117 = (List) ZeusTransformUtils.preCheckCast(r3.L$2, List.class, "com.obric.memorydata.plugin");
        r115 = (Ref.IntRef) ZeusTransformUtils.preCheckCast(r3.L$1, Ref.IntRef.class, "com.obric.memorydata.plugin");
        r118 = (a) ZeusTransformUtils.preCheckCast(r3.L$0, a.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);
        goto L27
    L16:
        ResultKt.throwOnFailure(r4);
        r25 = 0;
        r115 = new Ref.IntRef();
        r19 = 0;
        r17 = 0;
        r116 = 0;
    L7:
        r3 = new CallHistorySourceNumberBackfillManager$runPhaseB$1(this, r2);
        goto L8
    }

    public static final /* synthetic */ Object d(CallHistorySourceNumberBackfillManager r2, a r3, Continuation r4) {
        return r2.d((a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static /* synthetic */ Unit lambda$nvTt3E4e6nZZJ33_b4KOKAy39I0(Ref.IntRef r0) {
        return a(r0);
    }

    public final Object a(Continuation<? super Boolean> r7) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r8, CallHistorySourceNumberBackfillManager$checkIfNeeded$1.class) == false) goto L7;
        CallHistorySourceNumberBackfillManager$checkIfNeeded$1 r0 = (CallHistorySourceNumberBackfillManager$checkIfNeeded$1) ZeusTransformUtils.preCheckCast(r8, CallHistorySourceNumberBackfillManager$checkIfNeeded$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L19;
        if (r3 != 1) goto L18;
        ResultKt.throwOnFailure(r9);     // Catch: RuntimeException -> L13 CancellationException -> L15
    L23:
    L25:
        return Boxing.boxBoolean(((Boolean) ZeusTransformUtils.preCheckCast(r9, Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        ResultKt.throwOnFailure(r9);
        a r10 = (a) ZeusTransformUtils.preCheckCast(e.f12011a, a.class, "com.obric.memorydata.plugin");     // Catch: RuntimeException -> L13 CancellationException -> L15
        r0.label = 1;     // Catch: RuntimeException -> L13 CancellationException -> L15
        r9 = a(r10, r0);     // Catch: RuntimeException -> L13 CancellationException -> L15
        if (r9 != r2) goto L23;
        return r2;
    L15:
        e = move-exception;
        throw e;
    L13:
        e = move-exception;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CallHistorySourceBackfill", "migration boundary failed, error=" + e.getClass().getSimpleName(), null, 4, null);
        return Boxing.boxBoolean(false);
    L7:
        r0 = new CallHistorySourceNumberBackfillManager$checkIfNeeded$1(this, r8);
        goto L8
    }
}
