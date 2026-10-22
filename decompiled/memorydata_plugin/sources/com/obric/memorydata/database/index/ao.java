package com.obric.memorydata.database.index;

import android.security.obric.guard.ObricSecurityGuardStub;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.RoomDatabase;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.database.entity.cd;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.task.impl.TaskInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J:\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u00152\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00162\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001fJ0\u0010 \u001a\u00020!2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00172\b\b\u0002\u0010\u001c\u001a\u00020\u001dJ-\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00152\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0000¢\u0006\u0002\b'Ja\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u00152\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\f\u0010*\u001a\b\u0012\u0004\u0012\u00020$0+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00190+2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00162\u0006\u0010\u001c\u001a\u00020\u001dH\u0000¢\u0006\u0002\b.JH\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u00152\u0006\u0010\u0018\u001a\u00020\u00192\f\u00100\u001a\b\u0012\u0004\u0012\u0002010\u00162\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00162\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001fJ,\u00102\u001a\b\u0012\u0004\u0012\u00020$0\u00152\u0006\u0010\u0018\u001a\u00020\u00192\f\u00100\u001a\b\u0012\u0004\u0012\u0002010\u00162\b\b\u0002\u0010\u001e\u001a\u00020\u001fJ:\u00103\u001a\b\u0012\u0004\u0012\u00020$0\u00152\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\f\u0010*\u001a\b\u0012\u0004\u0012\u00020$0+2\b\b\u0002\u0010\u001e\u001a\u00020\u001fJ'\u00104\u001a\u0002H5\"\u0004\b\u0000\u001052\u0006\u0010\u0018\u001a\u00020\u00192\f\u00106\u001a\b\u0012\u0004\u0012\u0002H507¢\u0006\u0002\u00108J \u00109\u001a\u0004\u0018\u00010:2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010;\u001a\u00020\u00172\u0006\u0010<\u001a\u00020\u0017J<\u0010=\u001a\u0004\u0018\u00010:2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010;\u001a\u00020\u00172\u0006\u0010<\u001a\u00020\u00172\u0006\u0010>\u001a\u00020\u00192\b\u0010?\u001a\u0004\u0018\u00010\u00192\b\u0010@\u001a\u0004\u0018\u00010\u0019J)\u0010A\u001a\u0002H5\"\u0004\b\u0000\u001052\b\u0010B\u001a\u0004\u0018\u00010:2\f\u0010C\u001a\b\u0012\u0004\u0012\u0002H507¢\u0006\u0002\u0010DJ\u001f\u0010E\u001a\u0002H5\"\u0004\b\u0000\u001052\f\u0010C\u001a\b\u0012\u0004\u0012\u0002H507¢\u0006\u0002\u0010FJ-\u0010E\u001a\u0002H5\"\u0004\b\u0000\u001052\b\u0010G\u001a\u0004\u0018\u00010H2\f\u0010C\u001a\b\u0012\u0004\u0012\u0002H507H\u0000¢\u0006\u0004\bI\u0010JJ\u000f\u0010K\u001a\u0004\u0018\u00010HH\u0000¢\u0006\u0002\bLJ\u0017\u0010M\u001a\u00020N2\b\u0010G\u001a\u0004\u0018\u00010HH\u0000¢\u0006\u0002\bOJ7\u0010E\u001a\u0002H5\"\u0004\b\u0000\u001052\u0006\u0010#\u001a\u00020$2\u0006\u0010\"\u001a\u00020\u00172\u0006\u0010?\u001a\u00020\u00192\f\u0010C\u001a\b\u0012\u0004\u0012\u0002H507¢\u0006\u0002\u0010PJ\u0016\u0010Q\u001a\u00020R2\u0006\u0010B\u001a\u00020:2\u0006\u0010S\u001a\u00020\u0017J\u0016\u0010T\u001a\u00020R2\u0006\u0010B\u001a\u00020:2\u0006\u0010S\u001a\u00020\u0017J\u000e\u0010U\u001a\u00020V2\u0006\u0010B\u001a\u00020:J\u000e\u0010W\u001a\u00020V2\u0006\u0010B\u001a\u00020:J\u000e\u0010X\u001a\u00020V2\u0006\u0010B\u001a\u00020:J\u000e\u0010Y\u001a\u00020V2\u0006\u0010B\u001a\u00020:J\u0016\u0010Z\u001a\u00020R2\u0006\u0010B\u001a\u00020:2\u0006\u0010S\u001a\u00020\u0017J\u0016\u0010[\u001a\u00020R2\u0006\u0010B\u001a\u00020:2\u0006\u0010S\u001a\u00020\u0017J\u000e\u0010\\\u001a\u00020!2\u0006\u0010]\u001a\u00020^R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0011\u0010\u0012¨\u0006_"}, d2 = {"Lcom/obric/memorydata/database/index/IndexPendingLifecycleGateway;", "", "<init>", "()V", "latencyTracker", "Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker;", "getLatencyTracker", "()Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker;", "latencyTracker$delegate", "Lkotlin/Lazy;", "engine", "Lcom/obric/memorydata/database/index/IndexPendingLifecycleGatewayEngine;", "getEngine", "()Lcom/obric/memorydata/database/index/IndexPendingLifecycleGatewayEngine;", "engine$delegate", "executionCoordinator", "Lcom/obric/memorydata/database/index/IndexPendingExecutionCoordinator;", "getExecutionCoordinator", "()Lcom/obric/memorydata/database/index/IndexPendingExecutionCoordinator;", "executionCoordinator$delegate", "insertAll", "Lcom/obric/memorydata/database/index/PendingMutationResult;", "", "", "ownerDbType", "", "pending", "Lcom/obric/memorydata/database/entity/IndexPendingEntity;", "startEvidence", "Lcom/obric/memorydata/database/index/StartEvidence;", "transactionMode", "Lcom/obric/memorydata/database/index/GatewayTransactionMode;", "recordCoverageRoundWithoutPending", "", "rawDbId", "entityType", "", "sourceTimestamp", "insertIfColumnAbsent", "insertIfColumnAbsent$database_obricRelease", "replaceLegacyBuildTypeForOwner", "rawDbIds", "entityTypes", "", "buildTypes", "replacement", "replaceLegacyBuildTypeForOwner$database_obricRelease", "replace", "deletes", "Lcom/obric/memorydata/database/index/PendingDeleteSpec;", ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "rawDelete", "runPendingOnlyReplayTransaction", ExifInterface.GPS_DIRECTION_TRUE, "replayBody", "Lkotlin/Function0;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "acquireExecutionLease", "Lcom/obric/memorydata/database/index/ExecutionHandle;", "pendingId", "expectedTimestamp", "beginIndexExecution", ObricMemoryConstants.KEY_PACKAGE_NAME, "buildType", "indexPackageName", "measureIndexExecution", "handle", "block", "(Lcom/obric/memorydata/database/index/ExecutionHandle;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "measureModelCall", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "context", "Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$ModelCallContext;", "measureModelCall$database_obricRelease", "(Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$ModelCallContext;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "currentModelCallContext", "currentModelCallContext$database_obricRelease", "modelTaskInfoCallback", "Lcom/obric/memorydata/task/scheduler/OnTaskInfoCallBack;", "modelTaskInfoCallback$database_obricRelease", "(IJLjava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "settleIndexSuccess", "Lcom/obric/memorydata/database/index/ExecutionSettlement;", "completedAtMs", "settleIndexTerminalFailure", "settleIndexRetry", "", "settleIndexThermalDeferred", "settleIndexLocationDeferred", "discardIndexExecution", "settleSuccess", "settleTerminalFailure", "finalizePendingOnlyReplay", "receipt", "Lcom/obric/memorydata/database/index/PendingOnlyReplayReceipt;", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ao {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ao f9372a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f9373b = null;
    private static final Lazy c = null;
    private static final Lazy d = null;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/database/index/IndexPendingLifecycleGateway$modelTaskInfoCallback$1", "Lcom/obric/memorydata/task/scheduler/OnTaskInfoCallBack;", "onChanged", "", "taskInfo", "Lcom/obric/memorydata/task/impl/TaskInfo;", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements com.obric.memorydata.task.scheduler.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ai.e f9374a;

        a(ai.e r1) {
            this.f9374a = r1;
        }

        @Override // com.obric.memorydata.task.scheduler.c
        public void a(TaskInfo r5) {
            Intrinsics.checkNotNullParameter(r5, "taskInfo");
            if (r5.c().isFinished() == true) goto L6;
            return;
        L6:
            if (r5.i() <= 0) goto L9;
            long r0 = r5.i();
        L11:
            ao.a(ao.f9372a).a(this.f9374a, r0);
            return;
        L9:
            if (r5.h() <= 0) goto L13;
            r0 = r5.h();
            goto L11
        }
    }

    static {
        f9372a = new ao();
        f9373b = LazyKt.lazy($$Lambda$ao$invm0nQo1ilyFhKa2uzF_ZJ8EuU.INSTANCE);
        c = LazyKt.lazy($$Lambda$ao$lnAwNwLnRsRT0NIMumJSuVtkBlg.INSTANCE);
        d = LazyKt.lazy($$Lambda$ao$32Dfq9VKGGfPq0sfR_QpD34Ol2g.INSTANCE);
    }

    private ao() {
    }

    public static final /* synthetic */ an a(ao r0) {
        return r0.d();
    }

    private static final av a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "ownerDbType");
        if (Intrinsics.areEqual(r3, "PUBLIC") == false) goto L6;
        return new av((RoomDatabase) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine(), RoomDatabase.class, "com.obric.memorydata.plugin"), MemoryDbEngine.INSTANCE.getGlobalDbEngine().getIndexPendingDao(), MemoryDbEngine.INSTANCE.getGlobalDbEngine().getEntityIndexLifecycleDao());
    L6:
        if (Intrinsics.areEqual(r3, "USER") == false) goto L10;
        return new av((RoomDatabase) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getPersonalDbEngine(), RoomDatabase.class, "com.obric.memorydata.plugin"), MemoryDbEngine.INSTANCE.getPersonalDbEngine().getIndexPendingDao(), MemoryDbEngine.INSTANCE.getPersonalDbEngine().getEntityIndexLifecycleDao());
    L10:
        throw new IllegalStateException(("unknown index pending dbType: " + r3).toString());
    }

    public static /* synthetic */ az a(ao r1, String r2, List r3, GatewayTransactionMode r4, int r5, Object r6) {
        List<? extends ax> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if ((r5 & 4) == 0) goto L6;
        r4 = GatewayTransactionMode.OWNED;
    L6:
        return r1.a(r2, r7, r4);
    }

    public static /* synthetic */ az a(ao r1, String r2, List r3, bc r4, GatewayTransactionMode r5, int r6, Object r7) {
        List<cd> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        bc r9 = (bc) ZeusTransformUtils.wrapperContextForParams(r4, bc.class, "com.obric.memorydata.plugin");
        if ((r6 & 8) == 0) goto L6;
        r5 = GatewayTransactionMode.OWNED;
    L6:
        return r1.a(r2, r8, r9, r5);
    }

    public static /* synthetic */ az a(ao r7, String r8, List r9, List r10, bc r11, GatewayTransactionMode r12, int r13, Object r14) {
        List<? extends ax> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        List<cd> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        bc r5 = (bc) ZeusTransformUtils.wrapperContextForParams(r11, bc.class, "com.obric.memorydata.plugin");
        if ((r13 & 16) == 0) goto L6;
        r12 = GatewayTransactionMode.OWNED;
    L6:
        return r7.a(r8, r3, r4, r5, r12);
    }

    public static /* synthetic */ az a(ao r1, String r2, List r3, Set r4, GatewayTransactionMode r5, int r6, Object r7) {
        List<Long> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Set<Integer> r9 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        if ((r6 & 8) == 0) goto L6;
        r5 = GatewayTransactionMode.OWNED;
    L6:
        return r1.a(r2, r8, r9, r5);
    }

    private static final Unit a(Set r4) {
        Set r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "rounds");
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin");
        ai r0 = f9372a.b();
        Iterator r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L7;
        r0.a((ai.c) ZeusTransformUtils.preCheckCast(r7.next(), ai.c.class, "com.obric.memorydata.plugin"));
        goto L4
    L7:
        return Unit.INSTANCE;
    }

    private final ai b() {
        return (ai) ZeusTransformUtils.preCheckCast(f9373b.getValue(), ai.class, "com.obric.memorydata.plugin");
    }

    private final IndexPendingLifecycleGatewayEngine c() {
        return (IndexPendingLifecycleGatewayEngine) ZeusTransformUtils.preCheckCast(c.getValue(), IndexPendingLifecycleGatewayEngine.class, "com.obric.memorydata.plugin");
    }

    private final an d() {
        return (an) ZeusTransformUtils.preCheckCast(d.getValue(), an.class, "com.obric.memorydata.plugin");
    }

    private static final ai e() {
        return new ai();
    }

    private static final IndexPendingLifecycleGatewayEngine f() {
        Function1 r2 = null;
        return new IndexPendingLifecycleGatewayEngine($$Lambda$ao$ddfTyz8Nc_ZpJYwu9udelmC6tQ.INSTANCE, r2, $$Lambda$ao$jHrpKqin43gj46cWILDtcS_UYEk.INSTANCE, 2, null);
    }

    private static final an g() {
        ao r0 = f9372a;
        return new an(r0.c(), r0.b(), null, null, null, null, null, 124, null);
    }

    public static /* synthetic */ an lambda$32Dfq9VKGGfPq0sfR_QpD34Ol2g() {
        return g();
    }

    /* JADX INFO: renamed from: lambda$ddfTyz8-Nc_ZpJYwu9udelmC6tQ, reason: not valid java name */
    public static /* synthetic */ Unit m564lambda$ddfTyz8Nc_ZpJYwu9udelmC6tQ(Set r0) {
        return a(r0);
    }

    public static /* synthetic */ ai lambda$invm0nQo1ilyFhKa2uzF_ZJ8EuU() {
        return e();
    }

    public static /* synthetic */ av lambda$jHrpKqin43gj46cWILDtcS_UYEk(String r0) {
        return a(r0);
    }

    public static /* synthetic */ IndexPendingLifecycleGatewayEngine lambda$lnAwNwLnRsRT0NIMumJSuVtkBlg() {
        return f();
    }

    public final ai.e a() {
        return d().a();
    }

    public final az<Long> a(String r3, cd r4, bc r5) {
        bc r6 = (bc) ZeusTransformUtils.wrapperContextForParams(r5, bc.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "ownerDbType");
        Intrinsics.checkNotNullParameter(r4, "pending");
        Intrinsics.checkNotNullParameter(r6, "startEvidence");
        return c().a(r3, r4, r6);
    }

    public final az<Integer> a(String r3, List<? extends ax> r4, GatewayTransactionMode r5) {
        List<? extends ax> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "ownerDbType");
        Intrinsics.checkNotNullParameter(r6, "deletes");
        Intrinsics.checkNotNullParameter(r5, "transactionMode");
        return c().a(r3, r6, r5);
    }

    public final az<List<Long>> a(String r3, List<cd> r4, bc r5, GatewayTransactionMode r6) {
        List<cd> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        bc r8 = (bc) ZeusTransformUtils.wrapperContextForParams(r5, bc.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "ownerDbType");
        Intrinsics.checkNotNullParameter(r7, "pending");
        Intrinsics.checkNotNullParameter(r8, "startEvidence");
        Intrinsics.checkNotNullParameter(r6, "transactionMode");
        return c().a(r3, r7, r8, r6);
    }

    public final az<List<Long>> a(String r9, List<? extends ax> r10, List<cd> r11, bc r12, GatewayTransactionMode r13) {
        List<? extends ax> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        List<cd> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        bc r6 = (bc) ZeusTransformUtils.wrapperContextForParams(r12, bc.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "ownerDbType");
        Intrinsics.checkNotNullParameter(r4, "deletes");
        Intrinsics.checkNotNullParameter(r5, "replacement");
        Intrinsics.checkNotNullParameter(r6, "startEvidence");
        Intrinsics.checkNotNullParameter(r13, "transactionMode");
        return c().a(r9, r4, r5, r6, r13);
    }

    public final az<Integer> a(String r3, List<Long> r4, Set<Integer> r5, GatewayTransactionMode r6) {
        List<Long> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Set<Integer> r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "ownerDbType");
        Intrinsics.checkNotNullParameter(r7, "rawDbIds");
        Intrinsics.checkNotNullParameter(r8, "entityTypes");
        Intrinsics.checkNotNullParameter(r6, "transactionMode");
        return c().a(r3, r7, r8, r6);
    }

    public final /* synthetic */ az a(String r10, List r11, Set r12, Set r13, List r14, bc r15) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        Set r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r12, Set.class, "com.obric.memorydata.plugin");
        Set r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r13, Set.class, "com.obric.memorydata.plugin");
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
        bc r8 = (bc) ZeusTransformUtils.wrapperContextForParams(r15, bc.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "ownerDbType");
        Intrinsics.checkNotNullParameter(r4, "rawDbIds");
        Intrinsics.checkNotNullParameter(r5, "entityTypes");
        Intrinsics.checkNotNullParameter(r6, "buildTypes");
        Intrinsics.checkNotNullParameter(r7, "replacement");
        Intrinsics.checkNotNullParameter(r8, "startEvidence");
        return c().a(r10, r4, r5, r6, r7, r8);
    }

    public final u a(String r11, long r12, long r14, String r16, String r17, String r18) {
        Intrinsics.checkNotNullParameter(r11, "ownerDbType");
        Intrinsics.checkNotNullParameter(r16, ObricMemoryConstants.KEY_PACKAGE_NAME);
        return d().a(r11, r12, r14, r16, r17, r18);
    }

    public final v a(u r3, long r4) {
        u r5 = (u) ZeusTransformUtils.wrapperContextForParams(r3, u.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "handle");
        return d().a(r5, r4);
    }

    public final com.obric.memorydata.task.scheduler.c a(ai.e r2) {
        return (com.obric.memorydata.task.scheduler.c) ZeusTransformUtils.preCheckCast(new a(r2), com.obric.memorydata.task.scheduler.c.class, "com.obric.memorydata.plugin");
    }

    public final <T> T a(int r8, long r9, String r11, Function0<? extends T> r12) {
        Function0<? extends T> r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r12, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "buildType");
        Intrinsics.checkNotNullParameter(r6, "block");
        return (T) d().a(com.obric.memorydata.database.manager.c.f9561a.a(r8), r8, r9, r11, r6);
    }

    public final <T> T a(u r3, Function0<? extends T> r4) {
        u r5 = (u) ZeusTransformUtils.wrapperContextForParams(r3, u.class, "com.obric.memorydata.plugin");
        Function0<? extends T> r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "block");
        return (T) d().a(r5, r6);
    }

    public final <T> T a(String r3, Function0<? extends T> r4) {
        Function0<? extends T> r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "ownerDbType");
        Intrinsics.checkNotNullParameter(r5, "replayBody");
        return (T) c().a(r3, r5);
    }

    public final <T> T a(Function0<? extends T> r3) {
        Function0<? extends T> r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "block");
        return (T) d().a(r4);
    }

    public final void a(u r3) {
        u r4 = (u) ZeusTransformUtils.wrapperContextForParams(r3, u.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "handle");
        d().a(r4);
    }

    public final boolean a(ba r3) {
        ba r4 = (ba) ZeusTransformUtils.wrapperContextForParams(r3, ba.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "receipt");
        return c().a(r4);
    }

    public final boolean a(String r9, long r10, int r12, long r13, bc r15) {
        bc r7 = (bc) ZeusTransformUtils.wrapperContextForParams(r15, bc.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "ownerDbType");
        Intrinsics.checkNotNullParameter(r7, "startEvidence");
        return c().a(r9, r10, r12, r13, r7);
    }

    public final v b(u r3, long r4) {
        u r5 = (u) ZeusTransformUtils.wrapperContextForParams(r3, u.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "handle");
        return d().b(r5, r4);
    }

    public final void b(u r3) {
        u r4 = (u) ZeusTransformUtils.wrapperContextForParams(r3, u.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "handle");
        d().b(r4);
    }

    public final void c(u r3) {
        u r4 = (u) ZeusTransformUtils.wrapperContextForParams(r3, u.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "handle");
        d().c(r4);
    }
}
