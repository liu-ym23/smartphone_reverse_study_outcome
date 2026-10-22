package com.obric.memorydata.database.index;

import androidx.exifinterface.media.ExifInterface;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0003\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0003VWXB\u009b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007\u0012&\b\u0002\u0010\u000b\u001a \u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0006\u0012\u0004\u0018\u00010\b0\f\u0012\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\u0011\u0012\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\n0\u0011\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\u0004\b\u0017\u0010\u0018J<\u0010#\u001a\u0004\u0018\u00010 2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\u00162\u0006\u0010(\u001a\u00020%2\b\u0010)\u001a\u0004\u0018\u00010%2\b\u0010*\u001a\u0004\u0018\u00010%J)\u0010+\u001a\u0002H,\"\u0004\b\u0000\u0010,2\b\u0010-\u001a\u0004\u0018\u00010 2\f\u0010.\u001a\b\u0012\u0004\u0012\u0002H,0\u0015¢\u0006\u0002\u0010/J\u001f\u00100\u001a\u0002H,\"\u0004\b\u0000\u0010,2\f\u0010.\u001a\b\u0012\u0004\u0012\u0002H,0\u0015¢\u0006\u0002\u00101J)\u00100\u001a\u0002H,\"\u0004\b\u0000\u0010,2\b\u00102\u001a\u0004\u0018\u0001032\f\u0010.\u001a\b\u0012\u0004\u0012\u0002H,0\u0015¢\u0006\u0002\u00104J?\u00100\u001a\u0002H,\"\u0004\b\u0000\u0010,2\u0006\u0010$\u001a\u00020%2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u00162\u0006\u0010)\u001a\u00020%2\f\u0010.\u001a\b\u0012\u0004\u0012\u0002H,0\u0015¢\u0006\u0002\u00108J\b\u00109\u001a\u0004\u0018\u000103J\u0018\u0010:\u001a\u00020\n2\b\u00102\u001a\u0004\u0018\u0001032\u0006\u0010;\u001a\u00020\u0016J\u0016\u0010<\u001a\u00020=2\u0006\u0010-\u001a\u00020 2\u0006\u0010>\u001a\u00020\u0016J\u0016\u0010?\u001a\u00020=2\u0006\u0010-\u001a\u00020 2\u0006\u0010>\u001a\u00020\u0016J\u000e\u0010@\u001a\u00020\n2\u0006\u0010-\u001a\u00020 J\u000e\u0010A\u001a\u00020\n2\u0006\u0010-\u001a\u00020 J\u000e\u0010B\u001a\u00020\n2\u0006\u0010-\u001a\u00020 J\u000e\u0010C\u001a\u00020\n2\u0006\u0010-\u001a\u00020 J \u0010D\u001a\u00020\n2\u0006\u0010-\u001a\u00020 2\u0006\u0010E\u001a\u00020=2\u0006\u0010F\u001a\u00020\tH\u0002J\u0018\u0010G\u001a\u00020\n2\u0006\u0010-\u001a\u00020 2\u0006\u0010F\u001a\u00020\tH\u0002J\u001a\u0010H\u001a\u0004\u0018\u00010I2\u0006\u0010-\u001a\u00020 2\u0006\u0010J\u001a\u00020KH\u0002J\u0012\u0010L\u001a\u0004\u0018\u00010I2\u0006\u0010-\u001a\u00020 H\u0002J\u0010\u0010M\u001a\u00020\n2\u0006\u0010N\u001a\u00020\u001dH\u0002J\u0018\u0010O\u001a\u00020\n2\u0006\u0010P\u001a\u00020I2\u0006\u0010Q\u001a\u00020KH\u0002J\u0018\u0010R\u001a\u00020\n2\u0006\u0010S\u001a\u00020%2\u0006\u0010T\u001a\u00020UH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0006\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\u000b\u001a \u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0006\u0012\u0004\u0018\u00010\b0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\n0\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u001d0\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\"X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006Y"}, d2 = {"Lcom/obric/memorydata/database/index/IndexPendingExecutionCoordinator;", "", "engine", "Lcom/obric/memorydata/database/index/IndexPendingLifecycleGatewayEngine;", "latencyTracker", "Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker;", "reportSamples", "Lkotlin/Function2;", "Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$SettledSamples;", "Lcom/obric/memorydata/database/index/IndexExecutionOutcome;", "", "settleSamples", "Lkotlin/Function3;", "Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$PendingExecutionToken;", "Lcom/obric/memorydata/database/index/DurationMs;", "Lcom/obric/memorydata/database/index/FirstCompletionWaitMs;", "discardPendingExecution", "Lkotlin/Function1;", "discardEntityRound", "Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$EntityRoundIdentity;", "monotonicNowMs", "Lkotlin/Function0;", "", "<init>", "(Lcom/obric/memorydata/database/index/IndexPendingLifecycleGatewayEngine;Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "lock", "observationsByIdentity", "", "Lcom/obric/memorydata/database/index/IndexPendingExecutionCoordinator$ObservationIdentity;", "Lcom/obric/memorydata/database/index/IndexPendingExecutionCoordinator$Observation;", "observationsByHandle", "Ljava/util/IdentityHashMap;", "Lcom/obric/memorydata/database/index/ExecutionHandle;", "currentExecutionToken", "Ljava/lang/ThreadLocal;", "beginIndexExecution", "ownerDbType", "", "pendingId", "expectedTimestamp", ObricMemoryConstants.KEY_PACKAGE_NAME, "buildType", "indexPackageName", "measureIndexExecution", ExifInterface.GPS_DIRECTION_TRUE, "handle", "block", "(Lcom/obric/memorydata/database/index/ExecutionHandle;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "measureModelCall", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "context", "Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$ModelCallContext;", "(Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$ModelCallContext;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "entityType", "", "rawDbId", "(Ljava/lang/String;IJLjava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "currentModelCallContext", "recordModelCall", "durationMs", "settleIndexSuccess", "Lcom/obric/memorydata/database/index/ExecutionSettlement;", "completedAtMs", "settleIndexTerminalFailure", "settleIndexRetry", "settleIndexThermalDeferred", "settleIndexLocationDeferred", "discardIndexExecution", "consumeCommittedSettlementFailOpen", "settlement", "outcome", "consumeNonTerminalFailOpen", "detachWinner", "Lcom/obric/memorydata/database/index/IndexPendingExecutionCoordinator$DetachedObservation;", "roundClosed", "", "releaseHandleIfLast", "removeObservationLocked", "observation", "discardFailOpen", "detached", "discardRound", "logTelemetryFailure", "operation", "error", "", "ObservationIdentity", "Observation", "DetachedObservation", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class an {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IndexPendingLifecycleGatewayEngine f9364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ai f9365b;
    private final Function2<ai.i, IndexExecutionOutcome, Unit> c;
    private final Function3<ai.h, q, x, ai.i> d;
    private final Function1<ai.h, Unit> e;
    private final Function1<ai.c, Unit> f;
    private final Function0<Long> g;
    private final Object h;
    private final Map<c, b> i;
    private final IdentityHashMap<u, b> j;
    private final ThreadLocal<ai.h> k;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\b\u0013J.\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\b\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/obric/memorydata/database/index/IndexPendingExecutionCoordinator$DetachedObservation;", "", "identity", "Lcom/obric/memorydata/database/index/IndexPendingExecutionCoordinator$ObservationIdentity;", "token", "Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$PendingExecutionToken;", "buildDuration", "Lcom/obric/memorydata/database/index/DurationMs;", "<init>", "(Lcom/obric/memorydata/database/index/IndexPendingExecutionCoordinator$ObservationIdentity;Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$PendingExecutionToken;Lcom/obric/memorydata/database/index/DurationMs;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getIdentity", "()Lcom/obric/memorydata/database/index/IndexPendingExecutionCoordinator$ObservationIdentity;", "getToken", "()Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$PendingExecutionToken;", "getBuildDuration-k7tNx5A", "()Lcom/obric/memorydata/database/index/DurationMs;", "component1", "component2", "component3", "component3-k7tNx5A", "copy", "copy-NvjlBDo", "equals", "", "other", "hashCode", "", "toString", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c f9366a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ai.h f9367b;
        private final q c;

        private a(c r2, ai.h r3, q r4) {
            Intrinsics.checkNotNullParameter(r2, "identity");
            Intrinsics.checkNotNullParameter(r3, "token");
            this.f9366a = r2;
            this.f9367b = r3;
            this.c = r4;
        }

        public /* synthetic */ a(c r1, ai.h r2, q r3, DefaultConstructorMarker r4) {
            this(r1, r2, r3);
        }

        public final c a() {
            return this.f9366a;
        }

        public final ai.h b() {
            return this.f9367b;
        }

        public final q c() {
            return this.c;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f9366a, r6.f9366a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f9367b, r6.f9367b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            int r0 = ((this.f9366a.hashCode() * 31) + this.f9367b.hashCode()) * 31;
            q r3 = this.c;
            if (r3 != null) goto L5;
            int r4 = 0;
        L7:
            return r0 + r4;
        L5:
            r4 = q.b(r3.a());
            goto L7
        }

        public String toString() {
            return "DetachedObservation(identity=" + this.f9366a + ", token=" + this.f9367b + ", buildDuration=" + this.c + ')';
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR7\u0010\f\u001a&\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u000e0\u000e \u000f*\u0012\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u000e0\u000e\u0018\u00010\u00100\r¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/database/index/IndexPendingExecutionCoordinator$Observation;", "", "identity", "Lcom/obric/memorydata/database/index/IndexPendingExecutionCoordinator$ObservationIdentity;", "token", "Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$PendingExecutionToken;", "<init>", "(Lcom/obric/memorydata/database/index/IndexPendingExecutionCoordinator$ObservationIdentity;Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$PendingExecutionToken;)V", "getIdentity", "()Lcom/obric/memorydata/database/index/IndexPendingExecutionCoordinator$ObservationIdentity;", "getToken", "()Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$PendingExecutionToken;", "handles", "", "Lcom/obric/memorydata/database/index/ExecutionHandle;", "kotlin.jvm.PlatformType", "", "getHandles", "()Ljava/util/Set;", "Ljava/util/Set;", "durationsByHandle", "Ljava/util/IdentityHashMap;", "Lcom/obric/memorydata/database/index/DurationMs;", "getDurationsByHandle", "()Ljava/util/IdentityHashMap;", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c f9368a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ai.h f9369b;
        private final Set<u> c;
        private final IdentityHashMap<u, q> d;

        public b(c r2, ai.h r3) {
            Intrinsics.checkNotNullParameter(r2, "identity");
            Intrinsics.checkNotNullParameter(r3, "token");
            this.f9368a = r2;
            this.f9369b = r3;
            this.c = Collections.newSetFromMap((Map) ZeusTransformUtils.preCheckCast(new IdentityHashMap(), Map.class, "com.obric.memorydata.plugin"));
            this.d = new IdentityHashMap();
        }

        public final c a() {
            return this.f9368a;
        }

        public final ai.h b() {
            return this.f9369b;
        }

        public final Set<u> c() {
            return this.c;
        }

        public final IdentityHashMap<u, q> d() {
            return this.d;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/database/index/IndexPendingExecutionCoordinator$ObservationIdentity;", "", "round", "Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$EntityRoundIdentity;", "pendingId", "", "expectedTimestamp", "<init>", "(Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$EntityRoundIdentity;JJ)V", "getRound", "()Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$EntityRoundIdentity;", "getPendingId", "()J", "getExpectedTimestamp", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ai.c f9370a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f9371b;
        private final long c;

        public c(ai.c r2, long r3, long r5) {
            Intrinsics.checkNotNullParameter(r2, "round");
            this.f9370a = r2;
            this.f9371b = r3;
            this.c = r5;
        }

        public final ai.c a() {
            return this.f9370a;
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, c.class) == true) goto L8;
            return false;
        L8:
            c r10 = (c) ZeusTransformUtils.preCheckCast(r9, c.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f9370a, r10.f9370a) == true) goto L12;
            return false;
        L12:
            if (this.f9371b == r10.f9371b) goto L15;
            return false;
        L15:
            if (this.c == r10.c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f9370a.hashCode() * 31) + Long.hashCode(this.f9371b)) * 31) + Long.hashCode(this.c);
        }

        public String toString() {
            return "ObservationIdentity(round=" + this.f9370a + ", pendingId=" + this.f9371b + ", expectedTimestamp=" + this.c + ')';
        }
    }

    public an(IndexPendingLifecycleGatewayEngine r3, ai r4, Function2<? super ai.i, ? super IndexExecutionOutcome, Unit> r5, Function3<? super ai.h, ? super q, ? super x, ai.i> r6, Function1<? super ai.h, Unit> r7, Function1<? super ai.c, Unit> r8, Function0<Long> r9) {
        Function2<ai.i, IndexExecutionOutcome, Unit> r10 = (Function2) ZeusTransformUtils.wrapperContextForParams(r5, Function2.class, "com.obric.memorydata.plugin");
        Function3<ai.h, q, x, ai.i> r11 = (Function3) ZeusTransformUtils.wrapperContextForParams(r6, Function3.class, "com.obric.memorydata.plugin");
        Function1<ai.h, Unit> r12 = (Function1) ZeusTransformUtils.wrapperContextForParams(r7, Function1.class, "com.obric.memorydata.plugin");
        Function1<ai.c, Unit> r13 = (Function1) ZeusTransformUtils.wrapperContextForParams(r8, Function1.class, "com.obric.memorydata.plugin");
        Function0<Long> r14 = (Function0) ZeusTransformUtils.wrapperContextForParams(r9, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "engine");
        Intrinsics.checkNotNullParameter(r4, "latencyTracker");
        Intrinsics.checkNotNullParameter(r10, "reportSamples");
        Intrinsics.checkNotNullParameter(r11, "settleSamples");
        Intrinsics.checkNotNullParameter(r12, "discardPendingExecution");
        Intrinsics.checkNotNullParameter(r13, "discardEntityRound");
        Intrinsics.checkNotNullParameter(r14, "monotonicNowMs");
        this.f9364a = r3;
        this.f9365b = r4;
        this.c = r10;
        this.d = r11;
        this.e = r12;
        this.f = r13;
        this.g = r14;
        this.h = new Object();
        this.i = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        this.j = new IdentityHashMap();
        this.k = new ThreadLocal();
    }

    public /* synthetic */ an(IndexPendingLifecycleGatewayEngine r9, ai r10, Function2 r11, Function3 r12, Function1 r13, Function1 r14, Function0 r15, int r16, DefaultConstructorMarker r17) {
        Function2 r0 = (Function2) ZeusTransformUtils.wrapperContextForParams(r11, Function2.class, "com.obric.memorydata.plugin");
        Function3 r2 = (Function3) ZeusTransformUtils.wrapperContextForParams(r12, Function3.class, "com.obric.memorydata.plugin");
        Function1 r3 = (Function1) ZeusTransformUtils.wrapperContextForParams(r13, Function1.class, "com.obric.memorydata.plugin");
        Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r14, Function1.class, "com.obric.memorydata.plugin");
        Function0 r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r15, Function0.class, "com.obric.memorydata.plugin");
        if ((r16 & 2) == 0) goto L5;
        ai r6 = new ai();
    L7:
        if ((r16 & 4) == 0) goto L10;
        r0 = (Function2) ZeusTransformUtils.preCheckCast(new IndexPendingExecutionCoordinator$1(ah.f9339a), Function2.class, "com.obric.memorydata.plugin");
    L10:
        if ((r16 & 8) == 0) goto L13;
        r2 = (Function3) ZeusTransformUtils.preCheckCast(new IndexPendingExecutionCoordinator$2(r6), Function3.class, "com.obric.memorydata.plugin");
    L13:
        if ((r16 & 16) == 0) goto L16;
        r3 = (Function1) ZeusTransformUtils.preCheckCast(new IndexPendingExecutionCoordinator$3(r6), Function1.class, "com.obric.memorydata.plugin");
    L16:
        if ((r16 & 32) == 0) goto L19;
        r4 = (Function1) ZeusTransformUtils.preCheckCast(new IndexPendingExecutionCoordinator$4(r6), Function1.class, "com.obric.memorydata.plugin");
    L19:
        if ((r16 & 64) == 0) goto L21;
        r5 = (Function0) ZeusTransformUtils.preCheckCast(IndexPendingExecutionCoordinator$5.INSTANCE, Function0.class, "com.obric.memorydata.plugin");
    L21:
        this(r9, r6, r0, r2, r3, r4, r5);
        return;
    L5:
        r6 = r10;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final a a(u r9, boolean r10) {
        u r11 = (u) ZeusTransformUtils.wrapperContextForParams(r9, u.class, "com.obric.memorydata.plugin");
        Object r0 = this.h;
        monitor-enter(r0);
        b r1 = (b) ZeusTransformUtils.preCheckCast(this.j.get(r11), b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        a r2 = null;
        Object[] r3 = 0;
        if (r1 == null) goto L21;
        a r4 = new a(r1.a(), r1.b(), (q) ZeusTransformUtils.preCheckCast(r1.d().get(r11), q.class, "com.obric.memorydata.plugin"), r3 == true ? 1 : 0);     // Catch: Throwable -> L23
        if (r10 == false) goto L19;
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(this.i.values(), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        Iterator r14 = r12.iterator();     // Catch: Throwable -> L23
    L11:
        if (r14.hasNext() == false) goto L15;
        Object r5 = r14.next();     // Catch: Throwable -> L23
        if (Intrinsics.areEqual(((b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin")).a().a(), r1.a().a()) == false) goto L11;
        r13.add(r5);     // Catch: Throwable -> L23
        goto L11
    L15:
        Iterator r15 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L23
    L17:
        if (r15.hasNext() == false) goto L20;
        a((b) ZeusTransformUtils.preCheckCast(r15.next(), b.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L23
    L20:
        r2 = r4;
        goto L21
    L19:
        a(r1);     // Catch: Throwable -> L23
    L21:
        monitor-exit(r0);
        return r2;
    L23:
        th = move-exception;
        throw th;
    }

    private final void a(a r3, boolean r4) {
        if (r4 == false) goto L6;
        Function1 r5 = this.f;     // Catch: Throwable -> L8
        Object r6 = r3.a().a();     // Catch: Throwable -> L8
    L5:
        r5.invoke(r6);     // Catch: Throwable -> L8
        return;
    L6:
        r5 = this.e;     // Catch: Throwable -> L8
        r6 = r3.b();     // Catch: Throwable -> L8
    L8:
        e = move-exception;
        a("discard", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    private final void a(b r5) {
        this.i.remove(r5.a());
        Set<u> r0 = r5.c();
        Intrinsics.checkNotNullExpressionValue(r0, "<get-handles>(...)");
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        IdentityHashMap<u, b> r4 = this.j;
        Iterator r2 = r1.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r4.remove((u) ZeusTransformUtils.preCheckCast(r2.next(), u.class, "com.obric.memorydata.plugin"));
        goto L4
    L6:
        r5.c().clear();
        r5.d().clear();
    }

    private final void a(u r8, IndexExecutionOutcome r9) {
        a r10 = d((u) ZeusTransformUtils.wrapperContextForParams(r8, u.class, "com.obric.memorydata.plugin"));
        if (r10 != null) goto L11;
        return;
    L11:
        ai.i r3 = (ai.i) ZeusTransformUtils.preCheckCast(this.d.invoke(r10.b(), r10.c(), null), ai.i.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        this.c.invoke(r3, r9);     // Catch: Throwable -> L8
        return;
    L8:
        e = move-exception;
        a(r10, false);
        a("non-terminal settlement", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Multi-variable type inference failed */
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
    private final void a(u r7, v r8, IndexExecutionOutcome r9) {
        u r10 = (u) ZeusTransformUtils.wrapperContextForParams(r7, u.class, "com.obric.memorydata.plugin");
        v r11 = (v) ZeusTransformUtils.wrapperContextForParams(r8, v.class, "com.obric.memorydata.plugin");
        if (r11.a() == true) goto L8;
        a r12 = d(r10);
        if (r12 == null) goto L30;
        a(r12, false);
        return;
    L30:
        return;
    L8:
        a r13 = a(r10, r11.b());
        if (r13 != null) goto L11;
        return;
    L11:
        Object r3 = null;
        if (ZeusTransformUtils.instanceOf(r11, m.class) == false) goto L14;
        m r1 = (m) ZeusTransformUtils.preCheckCast(r11, m.class, "com.obric.memorydata.plugin");
    L16:
        if (r11.b() == false) goto L28;
        if (r1 == null) goto L20;
        r3 = r1.c();
    L20:
        if (r3 == null) goto L22;
        r3 = x.f9446a.a(r1.c().a());
        goto L28
    L22:
        r3 = (x) ZeusTransformUtils.preCheckCast(x.b.f9447b, x.class, "com.obric.memorydata.plugin");
    L28:
        this.c.invoke((ai.i) ZeusTransformUtils.preCheckCast(this.d.invoke(r13.b(), r13.c(), r3), ai.i.class, "com.obric.memorydata.plugin"), r9);     // Catch: Throwable -> L25
        return;
    L25:
        e = move-exception;
        a(r13, r11.b());
        a("post-commit settlement", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return;
    L14:
        r1 = null;
        goto L16
    }

    private final void a(String r4, Throwable r5) {
        RunLog.INSTANCE.error("IndexPendingExecutionCoordinator", "telemetry " + r4 + " failed", r5);     // Catch: Throwable -> L4
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.jvm.internal.DefaultConstructorMarker] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v4 */
    private final a d(u r7) {
        u r8 = (u) ZeusTransformUtils.wrapperContextForParams(r7, u.class, "com.obric.memorydata.plugin");
        Object r0 = this.h;
        monitor-enter(r0);
        b r1 = (b) ZeusTransformUtils.preCheckCast(this.j.remove(r8), b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        a r2 = 0;
        r2 = 0;
        if (r1 == null) goto L12;
        r1.c().remove(r8);     // Catch: Throwable -> L14
        q r9 = (q) ZeusTransformUtils.preCheckCast(r1.d().remove(r8), q.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        Set<u> r3 = r1.c();     // Catch: Throwable -> L14
        Intrinsics.checkNotNullExpressionValue(r3, "<get-handles>(...)");     // Catch: Throwable -> L14
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L12;
        this.i.remove(r1.a());     // Catch: Throwable -> L14
        r2 = new a(r1.a(), r1.b(), r9, r2);     // Catch: Throwable -> L14
    L12:
        monitor-exit(r0);
        return r2;
    L14:
        th = move-exception;
        throw th;
    }

    public final ai.e a() {
        ai.h r0 = (ai.h) ZeusTransformUtils.preCheckCast(this.k.get(), ai.h.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L10;
        return null;
    L10:
        return this.f9365b.a(r0);
    L7:
        e = move-exception;
        a("model context", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return null;
    }

    public final u a(String r16, long r17, long r19, String r21, String r22, String r23) {
        Intrinsics.checkNotNullParameter(r16, "ownerDbType");
        Intrinsics.checkNotNullParameter(r21, ObricMemoryConstants.KEY_PACKAGE_NAME);
        u r0 = this.f9364a.a(r16, r17, r19);
        ai.h r11 = null;
        if (ZeusTransformUtils.instanceOf(r0, l.class) == false) goto L5;
        l r12 = (l) ZeusTransformUtils.preCheckCast(r0, l.class, "com.obric.memorydata.plugin");
    L6:
        if (r12 != null) goto L8;
        return null;
    L8:
        c r13 = new c(ap.a(r12), r12.e(), r12.f());
        Object r14 = this.h;
        monitor-enter(r14);
        b r1 = (b) ZeusTransformUtils.preCheckCast(this.i.get(r13), b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
        if (r1 == null) goto L31;
        Set<u> r2 = r1.c();     // Catch: Throwable -> L27
        Intrinsics.checkNotNullExpressionValue(r2, "<get-handles>(...)");     // Catch: Throwable -> L27
        ((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.memorydata.plugin")).add(r12);     // Catch: Throwable -> L27
        ((Map) ZeusTransformUtils.preCheckCast(this.j, Map.class, "com.obric.memorydata.plugin")).put(r12, r1);     // Catch: Throwable -> L27
        u r3 = (u) ZeusTransformUtils.preCheckCast(r12, u.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
        monitor-exit(r14);
        return r3;
    L31:
        r11 = this.f9365b.a(r13.a(), r17, r19, r21, r22, r23);     // Catch: RuntimeException -> L17 Throwable -> L27
    L19:
        if (r11 != null) goto L23;
        u r4 = (u) ZeusTransformUtils.preCheckCast(r12, u.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
        monitor-exit(r14);
        return r4;
    L23:
        b r5 = new b(r13, r11);     // Catch: Throwable -> L27
        Set<u> r6 = r5.c();     // Catch: Throwable -> L27
        Intrinsics.checkNotNullExpressionValue(r6, "<get-handles>(...)");     // Catch: Throwable -> L27
        ((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin")).add(r12);     // Catch: Throwable -> L27
        this.i.put(r13, r5);     // Catch: Throwable -> L27
        ((Map) ZeusTransformUtils.preCheckCast(this.j, Map.class, "com.obric.memorydata.plugin")).put(r12, r5);     // Catch: Throwable -> L27
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L27
        monitor-exit(r14);
        return (u) ZeusTransformUtils.preCheckCast(r12, u.class, "com.obric.memorydata.plugin");
    L17:
        e = move-exception;
        a("begin", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;
    L5:
        r12 = null;
        goto L6
    }

    public final v a(u r3, long r4) {
        u r5 = (u) ZeusTransformUtils.wrapperContextForParams(r3, u.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "handle");
        v r6 = this.f9364a.a(r5, r4);
        a(r5, r6, IndexExecutionOutcome.TERMINAL_SUCCESS);
        return r6;
    }

    public final <T> T a(u r11, Function0<? extends T> r12) {
        u r13 = (u) ZeusTransformUtils.wrapperContextForParams(r11, u.class, "com.obric.memorydata.plugin");
        Function0 r14 = (Function0) ZeusTransformUtils.wrapperContextForParams(r12, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r14, "block");
        if (r13 == null) goto L5;
        Object r0 = this.h;
        monitor-enter(r0);
        b r1 = (b) ZeusTransformUtils.preCheckCast(this.j.get(r13), b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L66
        monitor-exit(r0);
        if (r1 == null) goto L12;
        ai.h r2 = (ai.h) ZeusTransformUtils.preCheckCast(this.k.get(), ai.h.class, "com.obric.memorydata.plugin");
        au r3 = au.f9386a.a(((Number) ZeusTransformUtils.preCheckCast(this.g.invoke(), Number.class, "com.obric.memorydata.plugin")).longValue());
        this.k.set(r1.b());
        T r15 = (T) r14.invoke();
        au r4 = au.f9386a.a(((Number) ZeusTransformUtils.preCheckCast(this.g.invoke(), Number.class, "com.obric.memorydata.plugin")).longValue());
        if (r3 == null) goto L35;
        if (r4 == null) goto L35;
        this.f9365b.a(r1.b(), r3.a(), r4.a());     // Catch: RuntimeException -> L20
    L22:
        q r5 = q.f9432a.a(r4.a() - r3.a());
        if (r5 == null) goto L35;
        long r6 = r5.a();
        Object r7 = this.h;
        monitor-enter(r7);
    L32:
        th = move-exception;
        throw th;
    L27:
        if (this.j.get(r13) != r1) goto L29;
        q r8 = q.c(r6);     // Catch: Throwable -> L32
        ((Map) ZeusTransformUtils.preCheckCast(r1.d(), Map.class, "com.obric.memorydata.plugin")).put(r13, r8);     // Catch: Throwable -> L32
    L29:
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L32
        monitor-exit(r7);
    L20:
        e = move-exception;
        a("record execution", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    L35:
        ThreadLocal<ai.h> r10 = this.k;
        if (r2 != null) goto L38;
        r10.remove();
    L39:
        return r15;
    L38:
        r10.set(r2);
    L40:
        th = move-exception;
        au r9 = au.f9386a.a(((Number) ZeusTransformUtils.preCheckCast(this.g.invoke(), Number.class, "com.obric.memorydata.plugin")).longValue());
        if (r3 == null) goto L61;
        if (r9 == null) goto L61;
        this.f9365b.a(r1.b(), r3.a(), r9.a());     // Catch: RuntimeException -> L46
    L48:
        q r17 = q.f9432a.a(r9.a() - r3.a());
        if (r17 == null) goto L61;
        long r18 = r17.a();
        monitor-enter(this.h);
    L58:
        th = move-exception;
        throw th;
    L53:
        if (this.j.get(r13) != r1) goto L55;
        q r19 = q.c(r18);     // Catch: Throwable -> L58
        ((Map) ZeusTransformUtils.preCheckCast(r1.d(), Map.class, "com.obric.memorydata.plugin")).put(r13, r19);     // Catch: Throwable -> L58
    L55:
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L58
    L46:
        e = move-exception;
        a("record execution", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    L61:
        ThreadLocal<ai.h> r111 = this.k;
        if (r2 != null) goto L64;
        r111.remove();
    L65:
        throw th;
    L64:
        r111.set(r2);
        goto L65
    L12:
        return (T) r14.invoke();
    L66:
        th = move-exception;
        throw th;
    L5:
        return (T) r14.invoke();
    }

    public final <T> T a(String r15, int r16, long r17, String r19, Function0<? extends T> r20) {
        Function0 r0 = (Function0) ZeusTransformUtils.wrapperContextForParams(r20, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r15, "ownerDbType");
        Intrinsics.checkNotNullParameter(r19, "buildType");
        Intrinsics.checkNotNullParameter(r0, "block");
        long r4 = ((Number) ZeusTransformUtils.preCheckCast(this.g.invoke(), Number.class, "com.obric.memorydata.plugin")).longValue();
        T r13 = (T) r0.invoke();
        q r1 = q.f9432a.a(((Number) ZeusTransformUtils.preCheckCast(this.g.invoke(), Number.class, "com.obric.memorydata.plugin")).longValue() - r4);
        if (r1 == null) goto L11;
        long r11 = r1.a();
        Boolean.valueOf(this.f9365b.a(r15, r16, r17, r19, r11));     // Catch: RuntimeException -> L9
    L9:
        e = move-exception;
        a("record model by entity", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        Unit r2 = Unit.INSTANCE;
    L11:
        return r13;
    L12:
        th = move-exception;
        q r3 = q.f9432a.a(((Number) ZeusTransformUtils.preCheckCast(this.g.invoke(), Number.class, "com.obric.memorydata.plugin")).longValue() - r4);
        if (r3 == null) goto L27;
        long r12 = r3.a();
        Boolean.valueOf(this.f9365b.a(r15, r16, r17, r19, r12));     // Catch: RuntimeException -> L18
        throw th;
    L18:
        e = move-exception;
        a("record model by entity", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        Unit r5 = Unit.INSTANCE;
        throw th;
    L27:
        throw th;
    }

    public final <T> T a(Function0<? extends T> r9) {
        Function0 r10 = (Function0) ZeusTransformUtils.wrapperContextForParams(r9, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "block");
        ai.h r1 = (ai.h) ZeusTransformUtils.preCheckCast(this.k.get(), ai.h.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L5;
        long r3 = ((Number) ZeusTransformUtils.preCheckCast(this.g.invoke(), Number.class, "com.obric.memorydata.plugin")).longValue();
        T r11 = (T) r10.invoke();
        q r4 = q.f9432a.a(((Number) ZeusTransformUtils.preCheckCast(this.g.invoke(), Number.class, "com.obric.memorydata.plugin")).longValue() - r3);
        if (r4 == null) goto L15;
        long r5 = r4.a();
        this.f9365b.a(r1, r5);     // Catch: RuntimeException -> L13
    L13:
        e = move-exception;
        a("record model", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    L15:
        return r11;
    L16:
        th = move-exception;
        q r6 = q.f9432a.a(((Number) ZeusTransformUtils.preCheckCast(this.g.invoke(), Number.class, "com.obric.memorydata.plugin")).longValue() - r3);
        if (r6 == null) goto L24;
        long r7 = r6.a();
        this.f9365b.a(r1, r7);     // Catch: RuntimeException -> L22
    L22:
        e = move-exception;
        a("record model", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    L24:
        throw th;
    L5:
        return (T) r10.invoke();
    }

    public final void a(ai.e r2, long r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        q r4 = q.f9432a.a(r3);
        if (r4 == null) goto L14;
        long r5 = r4.a();
        this.f9365b.a(r2, r5);     // Catch: RuntimeException -> L9
        return;
    L9:
        e = move-exception;
        a("record model", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return;
    }

    public final void a(u r3) {
        u r4 = (u) ZeusTransformUtils.wrapperContextForParams(r3, u.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "handle");
        a(r4, IndexExecutionOutcome.NON_TERMINAL_RETRY);
    }

    public final v b(u r3, long r4) {
        u r5 = (u) ZeusTransformUtils.wrapperContextForParams(r3, u.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "handle");
        v r6 = this.f9364a.b(r5, r4);
        a(r5, r6, IndexExecutionOutcome.TERMINAL_FAILURE);
        return r6;
    }

    public final void b(u r3) {
        u r4 = (u) ZeusTransformUtils.wrapperContextForParams(r3, u.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "handle");
        a(r4, IndexExecutionOutcome.THERMAL_DEFERRED);
    }

    public final void c(u r3) {
        u r4 = (u) ZeusTransformUtils.wrapperContextForParams(r3, u.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "handle");
        a(r4, IndexExecutionOutcome.LOCATION_DEFERRED);
    }
}
