package com.obric.memorydata.memory.memoryentity;

import com.bytedance.bdinstall.Api;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.EntityType;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.memory.CommonTextMemoryEntity;
import com.obric.capabilitykit.entity.memory.InfoCommonMemoryEntity;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.memorydata.database.dao.SemanticDeleteLifecycle;
import com.obric.memorydata.database.dao.SemanticMemoryDao;
import com.obric.memorydata.database.dao.SemanticRetractionReason;
import com.obric.memorydata.database.entity.EpisodicMemoryEntity;
import com.obric.memorydata.database.entity.RawMemoryEntity;
import com.obric.memorydata.database.entity.es;
import com.obric.memorydata.database.entity.fa;
import com.obric.memorydata.database.entity.fb;
import com.obric.memorydata.database.entity.ij;
import com.obric.memorydata.database.entity.ip;
import com.obric.memorydata.database.entity.iq;
import com.obric.memorydata.database.entity.memoryindex.g;
import com.obric.memorydata.database.entity.memoryindex.m;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.database.manager.PersonalMemoryFrameDb;
import com.obric.memorydata.memory.api.IMemoryEntityManagerApi;
import com.obric.memorydata.memory.tracker.MemoryEventTracker;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.bridge.CoreBridgeAPI;
import com.obric.memorydata.middleware.api.device.DeviceInfoState;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.api.EntityManager;
import com.obric.memorydata.task.AbsTaskRequest;
import com.obric.memorydata.task.condition.Condition;
import com.obric.memorydata.task.impl.TaskInfo;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.task.scheduler.impl.ExistingTaskPolicy;
import com.obric.memorydata.union.build.s;
import com.obric.memorydata.union.build.storage.k;
import com.obric.memorydata.utils.ac;
import com.ss.bduploader.BDAbstractUpload;
import com.ss.bduploader.BDNetworkSpeedTest;
import com.ss.bduploader.BDVideoUploaderBase;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.cu;
import kotlinx.coroutines.da;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n;
import kotlinx.coroutines.o;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001GB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u0000H\u0007J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0017J \u0010\u0011\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0016\u001a\u00020\u0015J \u0010\u0017\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001bJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0010\u001a\u00020\u000fH\u0007J\u0018\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0005J)\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010!\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010 ¢\u0006\u0002\u0010#J$\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u00152\b\u0010&\u001a\u0004\u0018\u00010\u00052\b\u0010!\u001a\u0004\u0018\u00010\u0005H\u0002J\u001f\u0010'\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u000f2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010 ¢\u0006\u0002\u0010(J$\u0010)\u001a\u00020\u00152\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020 0+2\b\u0010!\u001a\u0004\u0018\u00010\u0005J\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0002J\u0016\u00100\u001a\u00020\u001d2\f\u00101\u001a\b\u0012\u0004\u0012\u00020-02H\u0002J\u000e\u00103\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u000fJ\u0010\u00104\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0016\u00105\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000fJ\u001a\u00106\u001a\u00020\u00152\u0006\u00107\u001a\u00020\u00132\b\b\u0002\u00108\u001a\u00020\bH\u0002J\b\u00109\u001a\u00020\u001dH\u0002J\u0010\u0010:\u001a\u00020\u001d2\u0006\u0010;\u001a\u00020\u0013H\u0002J\u0018\u0010<\u001a\u00020\u001d2\u0006\u0010;\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u000e\u0010=\u001a\u00020\u001dH\u0082@¢\u0006\u0002\u0010>J\u0016\u0010?\u001a\u00020\u001d2\u0006\u0010;\u001a\u00020\u0013H\u0082@¢\u0006\u0002\u0010@J\u0016\u0010A\u001a\u00020\u001d2\u0006\u0010\u0010\u001a\u00020\u000fH\u0082@¢\u0006\u0002\u0010BJ,\u0010A\u001a\u00020\u001d2\u0006\u0010C\u001a\u00020\u00052\b\b\u0002\u0010D\u001a\u00020\b2\u0012\b\u0002\u0010E\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0018\u00010FR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Lcom/obric/memorydata/memory/memoryentity/MemoryEntityManager;", "Lcom/obric/memorydata/memory/api/IMemoryEntityManagerApi;", "<init>", "()V", "TAG", "", "TASK_MEMORY_CORRELATION", "CORRELATION_TASK_STRATEGY_DEFAULT", "", "CORRELATION_TASK_STRATEGY_INCREMENTAL", "TASK_BUILD_ENTITY_FULL_CONTENT", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getInst", "index", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "memoryEntity", "saveToDb", "Lkotlin/Pair;", "Lcom/obric/memorydata/database/entity/RawMemoryEntity;", "indexDirectly", "", "needPostTasks", "updateIndex", "oldMemoryEntity", "newMemoryEntity", "generateMethod", "Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$GenerateMethod;", "indexWhenImport", "", "deleteDirectly", "memoryRawDbId", "", "deleteMethod", "expectedChangeSeq", "(Lcom/obric/capabilitykit/entity/memory/MemoryEntity;Ljava/lang/String;Ljava/lang/Long;)Z", "trackDeleteMemoryIfNeeded", "isDeleted", Api.KEY_UUID, "deleteSemanticMemory", "(Lcom/obric/capabilitykit/entity/memory/MemoryEntity;Ljava/lang/Long;)Z", "deleteSemanticMemories", "expectedVersions", "", "semanticDeletionSnapshot", "Lcom/obric/memorydata/memory/memoryentity/MemoryEntityManager$SemanticDeletionSnapshot;", "entity", "Lcom/obric/memorydata/database/entity/UnionSemanticMemoryEntity;", "completeSemanticDeletion", "snapshots", "", "deleteEpisodicMemory", "deleteRawMemoryEntity", "updateMemoryEntity", "newIndex", "newRawEntity", "evidenceCount", "postIndexTask", "postWholeTasksWhenImport", "rawMemoryEntity", "postTasks", "executeIndexTask", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeFullContentBuildTask", "(Lcom/obric/memorydata/database/entity/RawMemoryEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeCorrelationMemoryBuild", "(Lcom/obric/capabilitykit/entity/memory/MemoryEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "entityId", "strategy", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "SemanticDeletionSnapshot", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemoryEntityManager implements IMemoryEntityManagerApi {
    public static final int CORRELATION_TASK_STRATEGY_DEFAULT = 0;
    public static final int CORRELATION_TASK_STRATEGY_INCREMENTAL = 1;
    public static final MemoryEntityManager INSTANCE = null;
    private static final String TAG = "MemoryEntityManager";
    private static final String TASK_BUILD_ENTITY_FULL_CONTENT = "build_entity_full_content";
    private static final String TASK_MEMORY_CORRELATION = "memory_correlation";
    private static final al scope = null;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/memory/memoryentity/MemoryEntityManager$SemanticDeletionSnapshot;", "", "entity", "Lcom/obric/memorydata/database/entity/UnionSemanticMemoryEntity;", "screenshot", "", "<init>", "(Lcom/obric/memorydata/database/entity/UnionSemanticMemoryEntity;Ljava/lang/String;)V", "getEntity", "()Lcom/obric/memorydata/database/entity/UnionSemanticMemoryEntity;", "getScreenshot", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ip f10300a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f10301b;

        public a(ip r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "entity");
            this.f10300a = r2;
            this.f10301b = r3;
        }

        public final ip a() {
            return this.f10300a;
        }

        public final String b() {
            return this.f10301b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f10300a, r6.f10300a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f10301b, r6.f10301b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            int r0 = this.f10300a.hashCode() * 31;
            String r1 = this.f10301b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "SemanticDeletionSnapshot(entity=" + this.f10300a + ", screenshot=" + this.f10301b + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/memory/memoryentity/MemoryEntityManager$executeCorrelationMemoryBuild$5", "Lcom/obric/memorydata/task/scheduler/OnTaskInfoCallBack;", "onChanged", "", "taskInfo", "Lcom/obric/memorydata/task/impl/TaskInfo;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements com.obric.memorydata.task.scheduler.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.obric.memorydata.memory.tracker.b f10302a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f10303b;
        final /* synthetic */ n<Unit> c;

        b(com.obric.memorydata.memory.tracker.b r3, long r4, n<? super Unit> r6) {
            n<Unit> r7 = (n) ZeusTransformUtils.wrapperContextForParams(r6, n.class, "com.obric.memorydata.plugin");
            this.f10302a = r3;
            this.f10303b = r4;
            this.c = r7;
        }

        @Override // com.obric.memorydata.task.scheduler.c
        public void a(TaskInfo r8) {
            Intrinsics.checkNotNullParameter(r8, "taskInfo");
            if (r8.c() != TaskInfo.State.RUNNING) goto L6;
            this.f10302a.a();
            return;
        L6:
            if (r8.c().isFinished() == false) goto L17;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), MemoryEntityManager.TAG, "execute task: memory_correlation end, result: " + r8.c() + ", cost: " + (System.currentTimeMillis() - this.f10303b) + "ms", false, 4, null);
            this.f10302a.b();
            n<Unit> r9 = this.c;
            boolean r0 = true;
            if (r9 != null) goto L10;
        L12:
            r0 = false;
        L13:
            if (r0 == false) goto L18;
            this.c.a(Unit.INSTANCE, null);
            return;
        L18:
            return;
        L10:
            if (r9.a() != true) goto L12;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.memoryentity.MemoryEntityManager$executeCorrelationMemoryBuild$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.memoryentity.MemoryEntityManager", f = "MemoryEntityManager.kt", i = {0}, l = {562}, m = "executeCorrelationMemoryBuild", n = {"this"}, s = {"L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ MemoryEntityManager this$0;

        AnonymousClass1(MemoryEntityManager r3, Continuation<? super AnonymousClass1> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return MemoryEntityManager.access$executeCorrelationMemoryBuild(this.this$0, null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.memoryentity.MemoryEntityManager$executeCorrelationMemoryBuild$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.memoryentity.MemoryEntityManager$executeCorrelationMemoryBuild$2", f = "MemoryEntityManager.kt", i = {}, l = {617}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ MemoryEntity $memoryEntity;
        Object L$0;
        int label;

        AnonymousClass2(MemoryEntity r3, Continuation<? super AnonymousClass2> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.$memoryEntity = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.$memoryEntity, r4), Continuation.class, "com.obric.memorydata.plugin");
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
        public final Object invokeSuspend(Object r12) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            MemoryEntity r11 = (MemoryEntity) ZeusTransformUtils.preCheckCast(this.L$0, MemoryEntity.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r12);
        L13:
            return r12;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r12);
            MemoryEntity r13 = this.$memoryEntity;
            this.L$0 = r13;
            this.label = 1;
            o r4 = new o(IntrinsicsKt.intercepted((Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin")), 1);
            r4.e();
            n r8 = (n) ZeusTransformUtils.preCheckCast(r4, n.class, "com.obric.memorydata.plugin");
            MemoryEntityManager.executeCorrelationMemoryBuild$default(MemoryEntityManager.INSTANCE, r13.getId(), 0, r8, 2, null);
            r12 = r4.h();
            if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L11;
            DebugProbesKt.probeCoroutineSuspended((Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        L11:
            if (r12 != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.memoryentity.MemoryEntityManager$executeFullContentBuildTask$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.memoryentity.MemoryEntityManager", f = "MemoryEntityManager.kt", i = {0}, l = {523}, m = "executeFullContentBuildTask", n = {"this"}, s = {"L$0"})
    static final class C11061 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ MemoryEntityManager this$0;

        C11061(MemoryEntityManager r3, Continuation<? super C11061> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return MemoryEntityManager.access$executeFullContentBuildTask(this.this$0, null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.memoryentity.MemoryEntityManager$executeFullContentBuildTask$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.memoryentity.MemoryEntityManager$executeFullContentBuildTask$2", f = "MemoryEntityManager.kt", i = {}, l = {617}, m = "invokeSuspend", n = {}, s = {})
    static final class C11072 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $beginTs;
        final /* synthetic */ RawMemoryEntity $rawMemoryEntity;
        long J$0;
        Object L$0;
        int label;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.memoryentity.MemoryEntityManager$executeFullContentBuildTask$2$a */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/memory/memoryentity/MemoryEntityManager$executeFullContentBuildTask$2$1$2", "Lcom/obric/memorydata/task/scheduler/OnTaskInfoCallBack;", "onChanged", "", "taskInfo", "Lcom/obric/memorydata/task/impl/TaskInfo;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class a implements com.obric.memorydata.task.scheduler.c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ long f10304a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ n<Unit> f10305b;

            a(long r3, n<? super Unit> r5) {
                n<Unit> r6 = (n) ZeusTransformUtils.wrapperContextForParams(r5, n.class, "com.obric.memorydata.plugin");
                this.f10304a = r3;
                this.f10305b = r6;
            }

            @Override // com.obric.memorydata.task.scheduler.c
            public void a(TaskInfo r8) {
                Intrinsics.checkNotNullParameter(r8, "taskInfo");
                if (r8.c().isFinished() == false) goto L8;
                IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), MemoryEntityManager.TAG, "execute task: build_entity_full_content end, result: " + r8.c() + ", cost: " + (System.currentTimeMillis() - this.f10304a) + "ms", false, 4, null);
                if (this.f10305b.a() == false) goto L9;
                this.f10305b.a(Unit.INSTANCE, null);
                return;
            L9:
                return;
            }
        }

        C11072(RawMemoryEntity r3, long r4, Continuation<? super C11072> r6) {
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            this.$rawMemoryEntity = r3;
            this.$beginTs = r4;
            super(2, r7);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11072(this.$rawMemoryEntity, this.$beginTs, r7), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C11072) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11072.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r12) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            RawMemoryEntity r11 = (RawMemoryEntity) ZeusTransformUtils.preCheckCast(this.L$0, RawMemoryEntity.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r12);
        L16:
            return r12;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r12);
            RawMemoryEntity r13 = this.$rawMemoryEntity;
            long r4 = this.$beginTs;
            this.L$0 = r13;
            this.J$0 = r4;
            this.label = 1;
            o r6 = new o(IntrinsicsKt.intercepted((Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin")), 1);
            r6.e();
            n r2 = (n) ZeusTransformUtils.preCheckCast(r6, n.class, "com.obric.memorydata.plugin");
            TaskRequest.Builder r3 = (TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder(MemoryEntityManager.TASK_BUILD_ENTITY_FULL_CONTENT).setExecuteImmediately(true), TaskRequest.Builder.class, "com.obric.memorydata.plugin");
            JSONObject r7 = new JSONObject();
            r7.put("rawDbId", r13.getId());
            r7.put("entityType", r13.getType());
            if (r13.getType() != (-303)) goto L11;
            r7.put("memoryType", r13.getMemoryType());
        L11:
            r7.put("lang", ac.f13156a.a());
            ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(r3.setInputParam(r7), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExistingTaskPolicy(ExistingTaskPolicy.SINGLE_QUEUE), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setTaskInfoCallback((com.obric.memorydata.task.scheduler.c) ZeusTransformUtils.preCheckCast(new a(r4, r2), com.obric.memorydata.task.scheduler.c.class, "com.obric.memorydata.plugin")), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).enqueue();
            r12 = r6.h();
            if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L14;
            DebugProbesKt.probeCoroutineSuspended((Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        L14:
            if (r12 != r0) goto L16;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.memoryentity.MemoryEntityManager$executeIndexTask$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.memoryentity.MemoryEntityManager", f = "MemoryEntityManager.kt", i = {0}, l = {459}, m = "executeIndexTask", n = {"this"}, s = {"L$0"})
    static final class C11081 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ MemoryEntityManager this$0;

        C11081(MemoryEntityManager r3, Continuation<? super C11081> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return MemoryEntityManager.access$executeIndexTask(this.this$0, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.memoryentity.MemoryEntityManager$executeIndexTask$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.memoryentity.MemoryEntityManager$executeIndexTask$2", f = "MemoryEntityManager.kt", i = {}, l = {617}, m = "invokeSuspend", n = {}, s = {})
    static final class C11092 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $beginTs;
        long J$0;
        int label;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.memoryentity.MemoryEntityManager$executeIndexTask$2$a */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/memory/memoryentity/MemoryEntityManager$executeIndexTask$2$1$task$1", "Lcom/obric/memorydata/task/scheduler/OnTaskInfoCallBack;", "onChanged", "", "taskInfo", "Lcom/obric/memorydata/task/impl/TaskInfo;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class a implements com.obric.memorydata.task.scheduler.c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ long f10306a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ n<Unit> f10307b;

            a(long r3, n<? super Unit> r5) {
                n<Unit> r6 = (n) ZeusTransformUtils.wrapperContextForParams(r5, n.class, "com.obric.memorydata.plugin");
                this.f10306a = r3;
                this.f10307b = r6;
            }

            @Override // com.obric.memorydata.task.scheduler.c
            public void a(TaskInfo r8) {
                Intrinsics.checkNotNullParameter(r8, "taskInfo");
                if (r8.c().isFinished() == false) goto L8;
                IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), MemoryEntityManager.TAG, "execute task: fast_entity_index end, result: " + r8.c() + ", cost: " + (System.currentTimeMillis() - this.f10306a) + "ms", false, 4, null);
                if (this.f10307b.a() == false) goto L9;
                this.f10307b.a(Unit.INSTANCE, null);
                return;
            L9:
                return;
            }
        }

        C11092(long r3, Continuation<? super C11092> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.$beginTs = r3;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11092(this.$beginTs, r6), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C11092) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11092.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r13) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r13);
        L17:
            return r13;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r13);
            long r3 = this.$beginTs;
            this.J$0 = r3;
            this.label = 1;
            o r5 = new o(IntrinsicsKt.intercepted((Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin")), 1);
            r5.e();
            n r14 = (n) ZeusTransformUtils.preCheckCast(r5, n.class, "com.obric.memorydata.plugin");
            TaskRequest r2 = (TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder(com.obric.memorydata.database.entity.d.FAST_INDEX_TASK_NAME).setConditions(new Condition[]{Condition.LIGHT_POWER_CONTROL}), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExecuteImmediately(true), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExistingTaskPolicy(ExistingTaskPolicy.REPLACE_IN_QUEUE), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setTaskInfoCallback((com.obric.memorydata.task.scheduler.c) ZeusTransformUtils.preCheckCast(new a(r3, r14), com.obric.memorydata.task.scheduler.c.class, "com.obric.memorydata.plugin")), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin");
            if (com.obric.memorydata.task.scheduler.impl.c.f12961a.d().c((AbsTaskRequest) ZeusTransformUtils.preCheckCast(r2, AbsTaskRequest.class, "com.obric.memorydata.plugin")) == false) goto L11;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), MemoryEntityManager.TAG, "execute task: fast_entity_index cancel, cause duplicated", false, 4, null);
            r14.a(Unit.INSTANCE, null);
        L12:
            r13 = r5.h();
            if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L15;
            DebugProbesKt.probeCoroutineSuspended((Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        L15:
            if (r13 != r0) goto L17;
            return r0;
        L11:
            r2.enqueue();
            goto L12
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.memoryentity.MemoryEntityManager$postIndexTask$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.memoryentity.MemoryEntityManager$postIndexTask$1", f = "MemoryEntityManager.kt", i = {}, l = {422}, m = "invokeSuspend", n = {}, s = {})
    static final class C11101 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;

        C11101(Continuation<? super C11101> r3) {
            super(2, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11101((Continuation) ZeusTransformUtils.wrapperContextForParams(r2, Continuation.class, "com.obric.memorydata.plugin")), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C11101) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11101.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            MemoryEntityManager r6 = MemoryEntityManager.INSTANCE;
            Continuation r2 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (MemoryEntityManager.access$executeIndexTask(r6, r2) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.memoryentity.MemoryEntityManager$postTasks$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.memoryentity.MemoryEntityManager$postTasks$1", f = "MemoryEntityManager.kt", i = {}, l = {444, BDVideoUploaderBase.KeyIsDynamicSliceForceConfig, BDVideoUploaderBase.KeyIsDynamicSliceHighSize}, m = "invokeSuspend", n = {}, s = {})
    static final class C11111 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ MemoryEntity $memoryEntity;
        final /* synthetic */ RawMemoryEntity $rawMemoryEntity;
        int label;

        C11111(MemoryEntity r3, RawMemoryEntity r4, Continuation<? super C11111> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.$memoryEntity = r3;
            this.$rawMemoryEntity = r4;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11111(this.$memoryEntity, this.$rawMemoryEntity, r5), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C11111) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11111.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L10;
            if (r1 != 3) goto L9;
            ResultKt.throwOnFailure(r8);
        L26:
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r8);
        L21:
            if (ZeusTransformUtils.instanceOf(this.$memoryEntity, CommonTextMemoryEntity.class) == false) goto L26;
            MemoryEntityManager r9 = MemoryEntityManager.INSTANCE;
            MemoryEntity r2 = this.$memoryEntity;
            Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 3;
            if (MemoryEntityManager.access$executeCorrelationMemoryBuild(r9, r2, r3) != r0) goto L26;
            return r0;
        L11:
            ResultKt.throwOnFailure(r8);
        L17:
            MemoryEntityManager r10 = MemoryEntityManager.INSTANCE;
            Continuation r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 2;
            if (MemoryEntityManager.access$executeIndexTask(r10, r4) != r0) goto L21;
            return r0;
        L12:
            ResultKt.throwOnFailure(r8);
            if (ZeusTransformUtils.instanceOf(this.$memoryEntity, CommonTextMemoryEntity.class) == false) goto L17;
            MemoryEntityManager r11 = MemoryEntityManager.INSTANCE;
            RawMemoryEntity r5 = this.$rawMemoryEntity;
            Continuation r6 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (MemoryEntityManager.access$executeFullContentBuildTask(r11, r5, r6) != r0) goto L17;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.memoryentity.MemoryEntityManager$postWholeTasksWhenImport$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.memoryentity.MemoryEntityManager$postWholeTasksWhenImport$1", f = "MemoryEntityManager.kt", i = {}, l = {BDNetworkSpeedTest.KeyIsEnableIntelligentSpeedTest, BDAbstractUpload.KeyIsRetryStatesDir}, m = "invokeSuspend", n = {}, s = {})
    static final class C11121 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ RawMemoryEntity $rawMemoryEntity;
        int label;

        C11121(RawMemoryEntity r3, Continuation<? super C11121> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.$rawMemoryEntity = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11121(this.$rawMemoryEntity, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C11121) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11121.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r7);
        L17:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r7);
        L13:
            MemoryEntityManager r8 = MemoryEntityManager.INSTANCE;
            Continuation r2 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 2;
            if (MemoryEntityManager.access$executeIndexTask(r8, r2) != r0) goto L17;
            return r0;
        L10:
            ResultKt.throwOnFailure(r7);
            MemoryEntityManager r9 = MemoryEntityManager.INSTANCE;
            RawMemoryEntity r3 = this.$rawMemoryEntity;
            Continuation r5 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (MemoryEntityManager.access$executeFullContentBuildTask(r9, r3, r5) != r0) goto L13;
            return r0;
        }
    }

    static {
        INSTANCE = new MemoryEntityManager();
        scope = am.a(cu.a(null, 1, null).plus((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")));
    }

    private MemoryEntityManager() {
    }

    public static final /* synthetic */ Object access$executeCorrelationMemoryBuild(MemoryEntityManager r2, MemoryEntity r3, Continuation r4) {
        return r2.executeCorrelationMemoryBuild(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ Object access$executeFullContentBuildTask(MemoryEntityManager r2, RawMemoryEntity r3, Continuation r4) {
        return r2.executeFullContentBuildTask(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ Object access$executeIndexTask(MemoryEntityManager r2, Continuation r3) {
        return r2.executeIndexTask((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private final void completeSemanticDeletion(List<a> r7) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        s r8 = s.f13110a;
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r2.add(((a) ZeusTransformUtils.preCheckCast(r3.next(), a.class, "com.obric.memorydata.plugin")).a());
        goto L4
    L6:
        r8.a((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"));
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L8:
        if (r9.hasNext() == false) goto L12;
        FileEntity r4 = com.obric.memorydata.personalcontext.util.f.c(((a) ZeusTransformUtils.preCheckCast(r9.next(), a.class, "com.obric.memorydata.plugin")).b());
        if (r4 == null) goto L8;
        com.obric.memorydata.memory.memoryentity.a.a.f10310a.a(r4);
        goto L8
    L12:
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r12 = r10.iterator();
    L14:
        if (r12.hasNext() == false) goto L16;
        r11.add(((a) ZeusTransformUtils.preCheckCast(r12.next(), a.class, "com.obric.memorydata.plugin")).a().getEntityId());
        goto L14
    L16:
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.chunked((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), 400), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L18:
        if (r13.hasNext() == false) goto L20;
        List<String> r14 = (List) ZeusTransformUtils.preCheckCast(r13.next(), List.class, "com.obric.memorydata.plugin");
        MemoryDbEngine.INSTANCE.getPersonalDbEngine().getMemorySourceImageRelationDao().deleteSemanticRelationsByMemoryIds(r14);
        goto L18
    }

    public static /* synthetic */ boolean deleteDirectly$default(MemoryEntityManager r0, MemoryEntity r1, String r2, Long r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = null;
    L6:
        return r0.deleteDirectly(r1, r2, r3);
    }

    private final boolean deleteRawMemoryEntity(MemoryEntity r9) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "deleteDirectly type: " + r9.getType() + " id: " + r9.getId(), false, 4, null);
        RunLog.INSTANCE.debug(TAG, "deleteMemoryEntity detail: " + EntityExtKt.toJson((AppEntity) ZeusTransformUtils.preCheckCast(r9, AppEntity.class, "com.obric.memorydata.plugin")));
        RawMemoryEntity r8 = (RawMemoryEntity) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getRawMemoryEntityDao().queryByEntityId(r9.getId(), r9.get_packageName())), RawMemoryEntity.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "deleteRawMemoryEntity not found, skip delete! type: " + r9.getType() + " id: " + r9.getId() + ", productType: " + r9.getProductType(), null, 4, null);
        return false;
    L6:
        FileEntity r10 = r9.getScreenshot();
        if (r10 == null) goto L10;
        com.obric.memorydata.memory.memoryentity.a.a.f10310a.a(r10);
    L10:
        return r8.delete();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final List deleteSemanticMemories$lambda$8(PersonalMemoryFrameDb r13, Map r14) {
        Map r15 = (Map) ZeusTransformUtils.wrapperContextForParams(r14, Map.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r13.getSemanticStateDao().queryText("restore_phase"), "running") == false) goto L5;
        return null;
    L5:
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.chunked((Iterable) ZeusTransformUtils.preCheckCast(r15.keySet(), Iterable.class, "com.obric.memorydata.plugin"), 400), Iterable.class, "com.obric.memorydata.plugin");
        SemanticMemoryDao r4 = r13.getSemanticMemoryDao();
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        CollectionsKt.addAll(r5, (Iterable) ZeusTransformUtils.preCheckCast(r4.queryByEntityIds((List) ZeusTransformUtils.preCheckCast(r1.next(), List.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"));
        goto L7
    L9:
        List r2 = (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin");
        if (r2.size() != r15.size()) goto L60;
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, Collection.class) == true) goto L14;
    L16:
        Iterator r7 = r6.iterator();
    L18:
        if (r7.hasNext() == false) goto L15;
        ip r8 = (ip) ZeusTransformUtils.preCheckCast(r7.next(), ip.class, "com.obric.memorydata.plugin");
        if (r8.l() != 4.0f) goto L22;
        boolean r9 = true;
    L23:
        if (r9 == false) goto L31;
        Long r10 = (Long) ZeusTransformUtils.preCheckCast(r15.get(r8.getEntityId()), Long.class, "com.obric.memorydata.plugin");
        long r11 = r8.r();
        if (r10 == null) goto L31;
        if (r10.longValue() != r11) goto L31;
        boolean r12 = false;
    L32:
        if (r12 == false) goto L18;
        boolean r16 = true;
    L34:
        if (r16 == true) goto L60;
        Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin");
        MemoryEntityManager r3 = INSTANCE;
        Collection r18 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r19 = r17.iterator();
    L38:
        if (r19.hasNext() == false) goto L40;
        r18.add(r3.semanticDeletionSnapshot((ip) ZeusTransformUtils.preCheckCast(r19.next(), ip.class, "com.obric.memorydata.plugin")));
        goto L38
    L40:
        List r110 = (List) ZeusTransformUtils.preCheckCast(r18, List.class, "com.obric.memorydata.plugin");
        Iterator r20 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.chunked((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin"), 400), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L42:
        if (r20.hasNext() == false) goto L59;
        List r21 = (List) ZeusTransformUtils.preCheckCast(r20.next(), List.class, "com.obric.memorydata.plugin");
        SemanticMemoryDao r22 = r13.getSemanticMemoryDao();
        Iterable r23 = (Iterable) ZeusTransformUtils.preCheckCast(r21, Iterable.class, "com.obric.memorydata.plugin");
        Collection r24 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r23, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r25 = r23.iterator();
    L45:
        if (r25.hasNext() == false) goto L47;
        r24.add(((ip) ZeusTransformUtils.preCheckCast(r25.next(), ip.class, "com.obric.memorydata.plugin")).getEntityId());
        goto L45
    L47:
        Iterable r26 = (Iterable) ZeusTransformUtils.preCheckCast(r22.queryByEntityIds((List) ZeusTransformUtils.preCheckCast(r24, List.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin");
        Map r27 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r26, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r28 = r26.iterator();
    L49:
        if (r28.hasNext() == false) goto L52;
        ip r29 = (ip) ZeusTransformUtils.preCheckCast(r28.next(), ip.class, "com.obric.memorydata.plugin");
        Pair r30 = TuplesKt.to(r29.getEntityId(), Long.valueOf(r29.r()));
        r27.put(r30.getFirst(), r30.getSecond());
        goto L49
    L52:
        if (SemanticDeleteLifecycle.INSTANCE.deleteExpected(r27, SemanticRetractionReason.USER_DELETE, false).getDeleted() != r21.size()) goto L54;
        boolean r31 = true;
    L55:
        if (r31 == true) goto L42;
        throw new IllegalStateException("formal semantic delete count mismatch".toString());
    L54:
        r31 = false;
        goto L55
    L59:
        return r110;
    L31:
        r12 = true;
        goto L32
    L22:
        r9 = false;
    L15:
        r16 = false;
        goto L34
    L14:
        if (((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L16;
    L60:
        return null;
    }

    public static /* synthetic */ boolean deleteSemanticMemory$default(MemoryEntityManager r0, MemoryEntity r1, Long r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return r0.deleteSemanticMemory(r1, r2);
    }

    private final Object executeCorrelationMemoryBuild(MemoryEntity r9, Continuation<? super Unit> r10) {
        Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r11, AnonymousClass1.class) == false) goto L7;
        AnonymousClass1 r1 = (AnonymousClass1) ZeusTransformUtils.preCheckCast(r11, AnonymousClass1.class, "com.obric.memorydata.plugin");
        if ((r1.label & Integer.MIN_VALUE) == 0) goto L7;
        r1.label -= Integer.MIN_VALUE;
    L8:
        Object r12 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        MemoryEntityManager this = (MemoryEntityManager) ZeusTransformUtils.preCheckCast(r1.L$0, MemoryEntityManager.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r12);
    L18:
        if (((Unit) ZeusTransformUtils.preCheckCast(r12, Unit.class, "com.obric.memorydata.plugin")) != null) goto L21;
        MemoryEntityManager r8 = (MemoryEntityManager) ZeusTransformUtils.preCheckCast(this, MemoryEntityManager.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "execute task: memory_correlation timeout", null, 4, null);
    L21:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        Function2 r13 = (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r9, null), Function2.class, "com.obric.memorydata.plugin");
        r1.L$0 = this;
        r1.label = 1;
        r12 = da.b(60000, r13, r1);
        if (r12 != r3) goto L18;
        return r3;
    L7:
        r1 = new AnonymousClass1(this, r11);
        goto L8
    }

    public static /* synthetic */ void executeCorrelationMemoryBuild$default(MemoryEntityManager r1, String r2, int r3, n r4, int r5, Object r6) {
        n<? super Unit> r7 = (n) ZeusTransformUtils.wrapperContextForParams(r4, n.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = 0;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r7 = null;
    L8:
        r1.executeCorrelationMemoryBuild(r2, r3, r7);
    }

    private final Object executeFullContentBuildTask(RawMemoryEntity r17, Continuation<? super Unit> r18) {
        MemoryEntityManager r0 = this;
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r18, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, C11061.class) == false) goto L7;
        C11061 r4 = (C11061) ZeusTransformUtils.preCheckCast(r2, C11061.class, "com.obric.memorydata.plugin");
        if ((r4.label & Integer.MIN_VALUE) == 0) goto L7;
        r4.label -= Integer.MIN_VALUE;
    L8:
        Object r3 = r4.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r4.label;
        if (r6 == 0) goto L14;
        if (r6 != 1) goto L13;
        r0 = (MemoryEntityManager) ZeusTransformUtils.preCheckCast(r4.L$0, MemoryEntityManager.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
    L24:
        if (((Unit) ZeusTransformUtils.preCheckCast(r3, Unit.class, "com.obric.memorydata.plugin")) != null) goto L27;
        MemoryEntityManager r1 = (MemoryEntityManager) ZeusTransformUtils.preCheckCast(r0, MemoryEntityManager.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "execute task: build_entity_full_content timeout", null, 4, null);
    L27:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r3);
        int r7 = CoreBridgeAPI.INSTANCE.getTemperatureState();
        RunLog.INSTANCE.debug(TAG, "TemperatureState=" + r7);
        if (r7 < 3) goto L18;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "execute task: build_entity_full_content refuse, state=" + r7, null, 4, null);
        return Unit.INSTANCE;
    L18:
        long r8 = System.currentTimeMillis();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "execute task: build_entity_full_content begin, lang=" + ac.f13156a.a(), false, 4, null);
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == false) goto L27;
        Function2 r9 = (Function2) ZeusTransformUtils.preCheckCast(new C11072(r17, r8, null), Function2.class, "com.obric.memorydata.plugin");
        r4.L$0 = r0;
        r4.label = 1;
        r3 = da.b(60000, r9, r4);
        if (r3 != r5) goto L24;
        return r5;
    L7:
        r4 = new C11061(r0, r2);
        goto L8
    }

    private final Object executeIndexTask(Continuation<? super Unit> r15) {
        Continuation r16 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r15, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r16, C11081.class) == false) goto L7;
        C11081 r1 = (C11081) ZeusTransformUtils.preCheckCast(r16, C11081.class, "com.obric.memorydata.plugin");
        if ((r1.label & Integer.MIN_VALUE) == 0) goto L7;
        r1.label -= Integer.MIN_VALUE;
    L8:
        Object r17 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        MemoryEntityManager this = (MemoryEntityManager) ZeusTransformUtils.preCheckCast(r1.L$0, MemoryEntityManager.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r17);
    L18:
        if (((Unit) ZeusTransformUtils.preCheckCast(r17, Unit.class, "com.obric.memorydata.plugin")) != null) goto L21;
        MemoryEntityManager r14 = (MemoryEntityManager) ZeusTransformUtils.preCheckCast(this, MemoryEntityManager.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "execute task: fast_entity_index timeout", null, 4, null);
    L21:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r17);
        long r6 = System.currentTimeMillis();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "execute task: fast_entity_index begin", false, 4, null);
        Function2 r18 = (Function2) ZeusTransformUtils.preCheckCast(new C11092(r6, null), Function2.class, "com.obric.memorydata.plugin");
        r1.L$0 = this;
        r1.label = 1;
        r17 = da.b(60000, r18, r1);
        if (r17 != r3) goto L18;
        return r3;
    L7:
        r1 = new C11081(this, r16);
        goto L8
    }

    @JvmStatic
    public static final MemoryEntityManager getInst() {
        return INSTANCE;
    }

    public static /* synthetic */ boolean indexDirectly$default(MemoryEntityManager r0, MemoryEntity r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = true;
    L6:
        return r0.indexDirectly(r1, r2);
    }

    /* JADX INFO: renamed from: lambda$doSzVyv_e-y02fbeQbokNDBI9tI, reason: not valid java name */
    public static /* synthetic */ List m738lambda$doSzVyv_ey02fbeQbokNDBI9tI(PersonalMemoryFrameDb r0, Map r1) {
        return deleteSemanticMemories$lambda$8(r0, r1);
    }

    private final boolean newIndex(RawMemoryEntity r4, int r5) {
        if (r4.getMemoryType() != 10105) goto L10;
        ip r3 = iq.a(r4, r5);
        if (r3 == null) goto L11;
        boolean r1 = ij.a(r3, null, false, 3, null);
        fa r6 = fb.a(r4);
        if (r6 == null) goto L12;
        r6.j();
        com.obric.memorydata.database.c.f.f8859a.a(r6);
        return r1;
    L12:
        return r1;
    L11:
        return false;
    L10:
        return com.obric.memorydata.database.a.C0451a.a((com.obric.memorydata.database.a) ZeusTransformUtils.preCheckCast(r4, com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin"), false, 1, null);
    }

    static /* synthetic */ boolean newIndex$default(MemoryEntityManager r0, RawMemoryEntity r1, int r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = 1;
    L6:
        return r0.newIndex(r1, r2);
    }

    private final void postIndexTask() {
        i.a(scope, null, null, (Function2) ZeusTransformUtils.preCheckCast(new C11101(null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private final void postTasks(RawMemoryEntity r7, MemoryEntity r8) {
        i.a(scope, null, null, (Function2) ZeusTransformUtils.preCheckCast(new C11111(r8, r7, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private final void postWholeTasksWhenImport(RawMemoryEntity r7) {
        i.a(scope, null, null, (Function2) ZeusTransformUtils.preCheckCast(new C11121(r7, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private final Pair<MemoryEntity, RawMemoryEntity> saveToDb(MemoryEntity r11) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "indexMemoryEntity type: " + r11.getType() + " id: " + r11.getId(), false, 4, null);
        RunLog.INSTANCE.debug(TAG, "indexMemoryEntity detail: " + EntityExtKt.toJson((AppEntity) ZeusTransformUtils.preCheckCast(r11, AppEntity.class, "com.obric.memorydata.plugin")));
        g r0 = m.a();
        MemoryEntity r3 = null;
        if (r0.isMemoryValid(r11) == true) goto L7;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "memoryEntity is not valid, skip index", null, 4, null);
        return null;
    L7:
        if (ZeusTransformUtils.instanceOf(r11, InfoCommonMemoryEntity.class) == false) goto L11;
        ip r1 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getSemanticMemoryDao().getSameMemory(((InfoCommonMemoryEntity) ZeusTransformUtils.preCheckCast(r11, InfoCommonMemoryEntity.class, "com.obric.memorydata.plugin")).getInfoKey(), ((InfoCommonMemoryEntity) ZeusTransformUtils.preCheckCast(r11, InfoCommonMemoryEntity.class, "com.obric.memorydata.plugin")).getInfoValue());
        if (r1 == null) goto L12;
        r3 = iq.a(r1);
    L12:
        if (r3 == null) goto L14;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "findSameMemoryEntity, will update and index", false, 4, null);
        RawMemoryEntity r10 = updateMemoryEntity(r3, r11);
    L19:
        return new Pair(r3, r10);
    L14:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "find no same memoryEntity, will index", false, 4, null);
        RawMemoryEntity r2 = r0.toRawMemoryEntity(r11);
        List<String> r4 = com.obric.memorydata.memory.memoryentity.a.b.f10311a.a(r11);
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L17;
        r2.setLocations(r4.toString());
    L17:
        newIndex(r2, r11.getEvidenceCount());
        r10 = r2;
        goto L19
    L11:
        r3 = r0.findSameMemoryEntity(r11);
        goto L12
    }

    private final a semanticDeletionSnapshot(ip r3) {
        fa r2 = (fa) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getProactiveSemanticRelevantDataDao().queryByMemoryId(r3.getEntityId())), fa.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L5;
        String r4 = r2.e();
    L7:
        return new a(r3, r4);
    L5:
        r4 = null;
        goto L7
    }

    private final void trackDeleteMemoryIfNeeded(boolean r1, String r2, String r3) {
        if (r1 == false) goto L15;
        if (r3 == null) goto L16;
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L7;
    L10:
        boolean r4 = true;
    L11:
        if (r4 == true) goto L17;
        MemoryEventTracker.f10515a.a(CollectionsKt.listOf(r2), r3);
        return;
    L17:
        return;
    L7:
        if (StringsKt.isBlank(r0) == true) goto L10;
        r4 = false;
        goto L11
    L16:
        return;
    }

    public final boolean deleteDirectly(long r10, String r12) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "deleteDirectly memoryRawDbId: " + r10, false, 4, null);
        RawMemoryEntity r0 = (RawMemoryEntity) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getRawMemoryEntityDao().queryById(r10), RawMemoryEntity.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "deleteMemoryEntity not found, skip delete! rawDbId: " + r10, null, 4, null);
        return false;
    L6:
        FileEntity r11 = com.obric.memorydata.personalcontext.util.f.c(r0.getScreenshot());
        if (r11 == null) goto L9;
        com.obric.memorydata.memory.memoryentity.a.a.f10310a.a(r11);
    L9:
        boolean r13 = r0.delete();
        trackDeleteMemoryIfNeeded(r13, r0.getUuid(), r12);
        return r13;
    }

    public final boolean deleteDirectly(MemoryEntity r2, String r3, Long r4) {
        Intrinsics.checkNotNullParameter(r2, "memoryEntity");
        if (ZeusTransformUtils.instanceOf(r2, InfoCommonMemoryEntity.class) == false) goto L6;
        boolean r5 = deleteSemanticMemory(r2, r4);
    L9:
        trackDeleteMemoryIfNeeded(r5, r2.getUuid(), r3);
        return r5;
    L6:
        if (ZeusTransformUtils.instanceOf(r2, CommonTextMemoryEntity.class) == false) goto L8;
        r5 = deleteEpisodicMemory(r2);
        goto L9
    L8:
        r5 = deleteRawMemoryEntity(r2);
        goto L9
    }

    public final boolean deleteEpisodicMemory(MemoryEntity r8) {
        Intrinsics.checkNotNullParameter(r8, "memoryEntity");
        if (r8.getType() != 10401) goto L16;
        EpisodicMemoryEntity r7 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getEpisodicMemoryDao().queryByEntityId(r8.getId());
        if (r7 == null) goto L15;
        es r9 = (es) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getProactiveEpisodicRelevantDataDao().queryByEpisodicId(r7.getEntityId()), 0), es.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L11;
        FileEntity r10 = com.obric.memorydata.personalcontext.util.f.c(r9.g());
        if (r10 == null) goto L11;
        com.obric.memorydata.memory.memoryentity.a.a.f10310a.a(r10);
    L11:
        boolean r11 = r7.delete();
        if (r11 == false) goto L14;
        MemoryDbEngine.INSTANCE.getPersonalDbEngine().getMemorySourceImageRelationDao().deleteEpisodicRelationsByMemoryIds(CollectionsKt.listOf(r7.getEntityId()));
    L14:
        return r11;
    L15:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "deleteEpisodicMemory not found, skip delete! type: " + r8.getType() + " id: " + r8.getId() + ", productType: " + r8.getProductType(), null, 4, null);
    L16:
        return false;
    }

    public final boolean deleteSemanticMemories(Map<String, Long> r10, String r11) {
        final Map r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "expectedVersions");
        if (r12.isEmpty() == true) goto L43;
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r12.values(), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, Collection.class) == true) goto L7;
    L9:
        Iterator r1 = r0.iterator();
    L11:
        if (r1.hasNext() == false) goto L8;
        if (((Number) ZeusTransformUtils.preCheckCast(r1.next(), Number.class, "com.obric.memorydata.plugin")).longValue() >= 0) goto L15;
        boolean r3 = true;
    L16:
        if (r3 == false) goto L11;
        boolean r2 = true;
    L18:
        if (r2 == true) goto L43;
        final PersonalMemoryFrameDb r4 = MemoryDbEngine.INSTANCE.getPersonalDbEngine();
        List<a> r13 = (List) ZeusTransformUtils.preCheckCast(r4.runInTransaction(new $$Lambda$MemoryEntityManager$doSzVyv_ey02fbeQbokNDBI9tI(r4, r12)), List.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L41
        if (r13 != null) goto L24;
        return false;
    L24:
        EntityManager.INSTANCE.launchIndexTask();
        completeSemanticDeletion(r13);
        if (r11 == null) goto L40;
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin");
        Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r15 = r9.iterator();
    L28:
        if (r15.hasNext() == false) goto L37;
        String r5 = ((a) ZeusTransformUtils.preCheckCast(r15.next(), a.class, "com.obric.memorydata.plugin")).a().getUuid();
        if (r5 != null) goto L32;
    L34:
        r5 = null;
    L35:
        if (r5 == null) goto L28;
        r14.add(r5);
        goto L28
    L32:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L34;
    L37:
        List<String> r16 = (List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.memorydata.plugin");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r16, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L40;
        MemoryEventTracker.f10515a.a(r16, r11);
    L40:
        return true;
    L41:
        e = move-exception;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "semantic batch delete failed error_class=" + e.getClass().getSimpleName(), null, 4, null);
        goto L43
    L15:
        r3 = false;
    L8:
        r2 = false;
        goto L18
    L7:
        if (((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L9;
    L43:
        return false;
    }

    public final boolean deleteSemanticMemory(MemoryEntity r9, Long r10) {
        Intrinsics.checkNotNullParameter(r9, "memoryEntity");
        if (r9.getType() != 10105) goto L16;
        ip r0 = (ip) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getSemanticMemoryDao().queryByEntityId(r9.getId(), AppContext.INSTANCE.getPackageName()), 0), ip.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L15;
        a r11 = semanticDeletionSnapshot(r0);
        k r2 = k.f13128a;
        String r3 = r0.getEntityId();
        if (r10 == null) goto L9;
        long r4 = r10.longValue();
    L11:
        if (r2.a(r3, r4).getSuccess() == true) goto L13;
        return false;
    L13:
        completeSemanticDeletion(CollectionsKt.listOf(r11));
        return true;
    L9:
        r4 = r0.r();
        goto L11
    L15:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "deleteSemanticMemory not found, skip delete! type: " + r9.getType() + " id: " + r9.getId() + ", productType: " + r9.getProductType(), null, 4, null);
    L16:
        return false;
    }

    public final void executeCorrelationMemoryBuild(String r11, int r12, n<? super Unit> r13) {
        n r10 = (n) ZeusTransformUtils.wrapperContextForParams(r13, n.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "entityId");
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == true) goto L8;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "execute task: memory_correlation refuse, AiKernel not available", null, 4, null);
        if (r10 == null) goto L10;
        r10.a(Unit.INSTANCE, null);
        return;
    L10:
        return;
    L8:
        long r1 = System.currentTimeMillis();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "execute task: memory_correlation begin", false, 4, null);
        com.obric.memorydata.memory.tracker.b r3 = com.obric.memorydata.memory.tracker.b.f10531a.a(EntityType.MEMORY_COMMON_TEXT, r12);
        TaskRequest.Builder r4 = (TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder(TASK_MEMORY_CORRELATION).setExecuteImmediately(true), TaskRequest.Builder.class, "com.obric.memorydata.plugin");
        JSONObject r5 = new JSONObject();
        r5.put("entityId", r11);
        r5.put("strategy", r12);
        ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(r4.setInputParam(r5), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExistingTaskPolicy(ExistingTaskPolicy.SINGLE_QUEUE), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setTaskInfoCallback((com.obric.memorydata.task.scheduler.c) ZeusTransformUtils.preCheckCast(new b(r3, r1, r10), com.obric.memorydata.task.scheduler.c.class, "com.obric.memorydata.plugin")), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).enqueue();
    }

    @Override // com.obric.memorydata.memory.api.IMemoryEntityManagerApi
    public MemoryEntity index(MemoryEntity r12) {
        Intrinsics.checkNotNullParameter(r12, "memoryEntity");
        Pair<MemoryEntity, RawMemoryEntity> r0 = saveToDb(r12);
        Float r1 = null;
        if (r0 != null) goto L5;
        return null;
    L5:
        MemoryEntity r2 = (MemoryEntity) ZeusTransformUtils.preCheckCast(r0.component1(), MemoryEntity.class, "com.obric.memorydata.plugin");
        RawMemoryEntity r7 = (RawMemoryEntity) ZeusTransformUtils.preCheckCast(r0.component2(), RawMemoryEntity.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L8;
        MemoryEventTracker.GenerateMethod r3 = MemoryEventTracker.GenerateMethod.UPDATE;
    L9:
        MemoryEventTracker r5 = MemoryEventTracker.f10515a;
        String r8 = r3.getValue();
        if (ZeusTransformUtils.instanceOf(r2, InfoCommonMemoryEntity.class) == false) goto L12;
        InfoCommonMemoryEntity r4 = (InfoCommonMemoryEntity) ZeusTransformUtils.preCheckCast(r2, InfoCommonMemoryEntity.class, "com.obric.memorydata.plugin");
    L13:
        if (r4 == null) goto L15;
        r1 = Float.valueOf(r4.getConfidence());
    L15:
        r5.a(r12, r7, r8, false, r1);
        postIndexTask();
        return r2;
    L12:
        r4 = null;
        goto L13
    L8:
        r3 = MemoryEventTracker.GenerateMethod.ADD_NEW;
        goto L9
    }

    public final boolean indexDirectly(MemoryEntity r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "memoryEntity");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "indexDirectly type: " + r10.getType() + " id: " + r10.getId(), false, 4, null);
        RunLog.INSTANCE.debug(TAG, "indexMemoryEntity detail: " + EntityExtKt.toJson((AppEntity) ZeusTransformUtils.preCheckCast(r10, AppEntity.class, "com.obric.memorydata.plugin")));
        g r0 = m.a();
        if (r0.isMemoryValid(r10) == true) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "memoryEntity is not valid, skip index", null, 4, null);
        return false;
    L6:
        RawMemoryEntity r1 = r0.toRawMemoryEntity(r10);
        boolean r2 = newIndex(r1, r10.getEvidenceCount());
        if (r11 == false) goto L9;
        postTasks(r1, r10);
    L9:
        return r2;
    }

    public final void indexWhenImport(MemoryEntity r4) {
        Intrinsics.checkNotNullParameter(r4, "memoryEntity");
        Pair<MemoryEntity, RawMemoryEntity> r5 = saveToDb(r4);
        if (r5 != null) goto L5;
        return;
    L5:
        MemoryEntity r0 = (MemoryEntity) ZeusTransformUtils.preCheckCast(r5.component1(), MemoryEntity.class, "com.obric.memorydata.plugin");
        postWholeTasksWhenImport((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r5.component2(), RawMemoryEntity.class, "com.obric.memorydata.plugin"));
    }

    public final MemoryEntity updateIndex(MemoryEntity r9, MemoryEntity r10, MemoryEventTracker.GenerateMethod r11) {
        Intrinsics.checkNotNullParameter(r9, "oldMemoryEntity");
        Intrinsics.checkNotNullParameter(r10, "newMemoryEntity");
        Intrinsics.checkNotNullParameter(r11, "generateMethod");
        Float r1 = null;
        if (ZeusTransformUtils.instanceOf(r9, InfoCommonMemoryEntity.class) == false) goto L5;
        InfoCommonMemoryEntity r0 = (InfoCommonMemoryEntity) ZeusTransformUtils.preCheckCast(r9, InfoCommonMemoryEntity.class, "com.obric.memorydata.plugin");
    L6:
        if (r0 == null) goto L8;
        r1 = Float.valueOf(r0.getConfidence());
    L8:
        Float r7 = r1;
        RawMemoryEntity r4 = updateMemoryEntity(r9, r10);
        postIndexTask();
        MemoryEntity r8 = m.a().toMemoryEntity(r4);
        if (r8 == null) goto L11;
        MemoryEventTracker.f10515a.a(r8, r4, r11.getValue(), false, r7);
    L11:
        return r8;
    L5:
        r0 = null;
        goto L6
    }

    public final RawMemoryEntity updateMemoryEntity(MemoryEntity r5, MemoryEntity r6) {
        Intrinsics.checkNotNullParameter(r5, "oldMemoryEntity");
        Intrinsics.checkNotNullParameter(r6, "newMemoryEntity");
        if (r5.getType() != r6.getType()) goto L10;
        r6.setId(r5.getId());
        r6.setUuid(r5.getUuid());
        g r0 = m.a();
        RawMemoryEntity r1 = r0.toRawMemoryEntity(r5);
        RawMemoryEntity r2 = r0.toRawMemoryEntity(r6);
        List<String> r7 = com.obric.memorydata.memory.memoryentity.a.b.f10311a.a(r6);
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L7;
        r2.setLocations(r7.toString());
    L7:
        r2.setEntityId(r1.getEntityId());
        r2.setCreateTime(r1.getCreateTime());
        newIndex(r2, r5.getEvidenceCount());
        return r2;
    L10:
        throw new IllegalArgumentException("MemoryEntity.type is not same");
    }
}
