package com.obric.memorydata.database.index;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.entity.EventBody;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\r\b\u0000\u0018\u0000 _2\u00020\u0001:\u000bUVWXYZ[\\]^_B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JC\u0010\u0011\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u0017H\u0000¢\u0006\u0002\b\u001aJ'\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001fH\u0000¢\u0006\u0004\b!\u0010\"J\u001f\u0010#\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010$\u001a\u00020%H\u0000¢\u0006\u0004\b&\u0010'J\u001f\u0010#\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020)2\u0006\u0010$\u001a\u00020%H\u0000¢\u0006\u0004\b&\u0010*J\u0017\u0010+\u001a\u0004\u0018\u00010)2\u0006\u0010\u001d\u001a\u00020\nH\u0000¢\u0006\u0002\b,J7\u0010#\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00172\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010$\u001a\u00020%H\u0000¢\u0006\u0004\b2\u00103J+\u00104\u001a\u0004\u0018\u0001052\u0006\u0010\u001d\u001a\u00020\n2\b\u00106\u001a\u0004\u0018\u00010%2\b\u00107\u001a\u0004\u0018\u000108H\u0000¢\u0006\u0002\b9J\u0015\u0010:\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\nH\u0000¢\u0006\u0002\b;J\u0015\u0010<\u001a\u00020\u001c2\u0006\u0010\u0012\u001a\u00020\fH\u0000¢\u0006\u0002\b=J\u0017\u0010>\u001a\u00020\u00172\b\u0010?\u001a\u0004\u0018\u00010\u0017H\u0000¢\u0006\u0002\b@J\u0010\u0010A\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\bH\u0002J\u0014\u0010B\u001a\u00020-*\u00020\b2\u0006\u0010(\u001a\u00020)H\u0002J\u001b\u0010#\u001a\u00020\u001c*\u00020\b2\u0006\u0010$\u001a\u00020%H\u0002¢\u0006\u0004\bC\u0010DJ\u0012\u0010E\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001d\u001a\u00020\nH\u0002J\u0010\u0010F\u001a\u00020\u001c2\u0006\u0010\u0012\u001a\u00020\fH\u0002J\u001f\u0010G\u001a\u00020H2\u0006\u0010(\u001a\u00020\b2\u0006\u0010I\u001a\u00020%H\u0002¢\u0006\u0004\bJ\u0010KJ)\u0010L\u001a\u00020H2\u0006\u0010(\u001a\u00020\b2\u0006\u0010M\u001a\u00020%2\b\u0010N\u001a\u0004\u0018\u00010%H\u0002¢\u0006\u0004\bO\u0010PJ\u001d\u0010Q\u001a\u0004\u0018\u00010%2\f\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00100SH\u0002¢\u0006\u0002\bTR\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\r0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006`"}, d2 = {"Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker;", "", "<init>", "()V", "lock", "contextsByIdentity", "", "Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$PendingExecutionIdentity;", "Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$PendingContext;", "contextsByToken", "Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$PendingExecutionToken;", "activeTokensByRound", "Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$EntityRoundIdentity;", "", "intervalsByRound", "", "Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$ExecutionInterval;", "beginPendingExecution", "round", "pendingId", "", "expectedTimestamp", ObricMemoryConstants.KEY_PACKAGE_NAME, "", "buildType", "indexPackageName", "beginPendingExecution$database_obricRelease", "recordExecution", "", "token", "startedAtMs", "Lcom/obric/memorydata/database/index/MonotonicTimeMs;", "finishedAtMs", "recordExecution-qKDSMvg$database_obricRelease", "(Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$PendingExecutionToken;JJ)V", "recordModelCall", "durationMs", "Lcom/obric/memorydata/database/index/DurationMs;", "recordModelCall-afxQV2E$database_obricRelease", "(Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$PendingExecutionToken;J)V", "context", "Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$ModelCallContext;", "(Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$ModelCallContext;J)V", "modelCallContext", "modelCallContext$database_obricRelease", "", "ownerDbType", "entityType", "", "rawDbId", "recordModelCall-w9uVY-E$database_obricRelease", "(Ljava/lang/String;IJLjava/lang/String;J)Z", "settlePendingExecution", "Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$SettledSamples;", "buildTypeDurationMs", "firstCompletionWaitMs", "Lcom/obric/memorydata/database/index/FirstCompletionWaitMs;", "settlePendingExecution-z7xEqvE$database_obricRelease", "discardPendingExecution", "discardPendingExecution$database_obricRelease", "discardEntityRound", "discardEntityRound$database_obricRelease", "normalizeBuildType", EventBody.KEY_VALUE, "normalizeBuildType$database_obricRelease", "addContextLocked", "matches", "recordModelCall-afxQV2E", "(Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$PendingContext;J)V", "removeContextLocked", "removeRoundContextsLocked", "diagnosticSnapshot", "Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$Snapshot;", "buildTypeDuration", "diagnosticSnapshot-afxQV2E", "(Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$PendingContext;J)Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$Snapshot;", "coreSnapshot", "waitDuration", "executionDuration", "coreSnapshot-x78XHK0", "(Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$PendingContext;JLcom/obric/memorydata/database/index/DurationMs;)Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$Snapshot;", "unionDurationMs", "intervals", "", "unionDurationMs--U2HUHs", "EntityRoundIdentity", "ModelCallContext", "PendingExecutionToken", "Snapshot", "SettledSamples", "PendingExecutionIdentity", "SnapshotKey", "PendingContext", "ExecutionInterval", "DetachedSettlement", "Companion", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ai {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9341a = null;
    private static final Set<String> g = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f9342b;
    private final Map<g, f> c;
    private final Map<h, f> d;
    private final Map<c, Set<h>> e;
    private final Map<c, List<d>> f;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0005J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eJ\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0015J\u0014\u0010\u0016\u001a\u00020\u0013*\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0013H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$Companion;", "", "<init>", "()V", "NOT_APPLICABLE", "", "UNKNOWN", "FAST", "SLOW", "BUILD_TYPE_CATALOG", "", "runModeOf", "indexPackageName", "sourceStartedAtMs", "", "sourceTimestampMs", "fallbackNowMs", "mergeSamples", "", "Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$Snapshot;", "samples", "", "mergeWith", "other", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final String a(String r1) {
            if (Intrinsics.areEqual(r1, com.obric.memorydata.database.entity.d.FAST_INDEX_TASK_NAME) == false) goto L6;
            return "FAST";
        L6:
            if (Intrinsics.areEqual(r1, com.obric.memorydata.database.entity.d.SLOW_INDEX_TASK_NAME) == false) goto L8;
            return "SLOW";
        L8:
            return "UNKNOWN";
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J%\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$DetachedSettlement;", "", "context", "Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$PendingContext;", "intervals", "", "Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$ExecutionInterval;", "<init>", "(Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$PendingContext;Ljava/util/List;)V", "getContext", "()Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$PendingContext;", "getIntervals", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final f f9343a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<d> f9344b;

        public b(f r3, List<d> r4) {
            List<d> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "context");
            this.f9343a = r3;
            this.f9344b = r5;
        }

        public final List<d> a() {
            return this.f9344b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f9343a, r6.f9343a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f9344b, r6.f9344b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final f getContext() {
            return this.f9343a;
        }

        public int hashCode() {
            int r0 = this.f9343a.hashCode() * 31;
            List<d> r1 = this.f9344b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "DetachedSettlement(context=" + this.f9343a + ", intervals=" + this.f9344b + ')';
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$EntityRoundIdentity;", "", "ownerDbType", "", "entityType", "", "rawDbId", "", "backlogRoundId", "<init>", "(Ljava/lang/String;IJJ)V", "getOwnerDbType", "()Ljava/lang/String;", "getEntityType", "()I", "getRawDbId", "()J", "getBacklogRoundId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f9345a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f9346b;
        private final long c;
        private final long d;

        public c(String r2, int r3, long r4, long r6) {
            Intrinsics.checkNotNullParameter(r2, "ownerDbType");
            this.f9345a = r2;
            this.f9346b = r3;
            this.c = r4;
            this.d = r6;
        }

        public final String a() {
            return this.f9345a;
        }

        public final int b() {
            return this.f9346b;
        }

        public final long c() {
            return this.c;
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, c.class) == true) goto L8;
            return false;
        L8:
            c r10 = (c) ZeusTransformUtils.preCheckCast(r9, c.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f9345a, r10.f9345a) == true) goto L12;
            return false;
        L12:
            if (this.f9346b == r10.f9346b) goto L15;
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
            return (((((this.f9345a.hashCode() * 31) + Integer.hashCode(this.f9346b)) * 31) + Long.hashCode(this.c)) * 31) + Long.hashCode(this.d);
        }

        public String toString() {
            return "EntityRoundIdentity(ownerDbType=" + this.f9345a + ", entityType=" + this.f9346b + ", rawDbId=" + this.c + ", backlogRoundId=" + this.d + ')';
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\f\u0010\bJ\u0010\u0010\r\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u000e\u0010\bJ$\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$ExecutionInterval;", "", "startedAtMs", "Lcom/obric/memorydata/database/index/MonotonicTimeMs;", "finishedAtMs", "<init>", "(JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getStartedAtMs-exH7jI0", "()J", "J", "getFinishedAtMs-exH7jI0", "component1", "component1-exH7jI0", "component2", "component2-exH7jI0", "copy", "copy-rOR4KmM", "(JJ)Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$ExecutionInterval;", "equals", "", "other", "hashCode", "", "toString", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f9347a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f9348b;

        private d(long r1, long r3) {
            this.f9347a = r1;
            this.f9348b = r3;
        }

        public /* synthetic */ d(long r1, long r3, DefaultConstructorMarker r5) {
            this(r1, r3);
        }

        public final long a() {
            return this.f9347a;
        }

        public final long b() {
            return this.f9348b;
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, d.class) == true) goto L8;
            return false;
        L8:
            d r10 = (d) ZeusTransformUtils.preCheckCast(r9, d.class, "com.obric.memorydata.plugin");
            if (au.a(this.f9347a, r10.f9347a) == true) goto L12;
            return false;
        L12:
            if (au.a(this.f9348b, r10.f9348b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (au.b(this.f9347a) * 31) + au.b(this.f9348b);
        }

        public String toString() {
            return "ExecutionInterval(startedAtMs=" + au.a(this.f9347a) + ", finishedAtMs=" + au.a(this.f9348b) + ')';
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$ModelCallContext;", "", "token", "Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$PendingExecutionToken;", "rawDbId", "", "entityType", "", "buildType", "", "<init>", "(Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$PendingExecutionToken;JILjava/lang/String;)V", "getToken", "()Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$PendingExecutionToken;", "getRawDbId", "()J", "getEntityType", "()I", "getBuildType", "()Ljava/lang/String;", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final h f9349a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f9350b;
        private final int c;
        private final String d;

        public e(h r2, long r3, int r5, String r6) {
            Intrinsics.checkNotNullParameter(r2, "token");
            Intrinsics.checkNotNullParameter(r6, "buildType");
            this.f9349a = r2;
            this.f9350b = r3;
            this.c = r5;
            this.d = r6;
        }

        public final h a() {
            return this.f9349a;
        }

        public final long b() {
            return this.f9350b;
        }

        public final int c() {
            return this.c;
        }

        public final String d() {
            return this.d;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003J\t\u0010\"\u001a\u00020\u000bHÆ\u0003J\t\u0010#\u001a\u00020\u000bHÆ\u0003JO\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000bHÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001a¨\u0006+"}, d2 = {"Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$PendingContext;", "", "identity", "Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$PendingExecutionIdentity;", "token", "Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$PendingExecutionToken;", ObricMemoryConstants.KEY_PACKAGE_NAME, "", "buildType", "runMode", "modelDurationSumMs", "", "modelDurationCount", "<init>", "(Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$PendingExecutionIdentity;Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$PendingExecutionToken;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJ)V", "getIdentity", "()Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$PendingExecutionIdentity;", "getToken", "()Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$PendingExecutionToken;", "getPackageName", "()Ljava/lang/String;", "getBuildType", "getRunMode", "getModelDurationSumMs", "()J", "setModelDurationSumMs", "(J)V", "getModelDurationCount", "setModelDurationCount", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final g f9351a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final h f9352b;
        private final String c;
        private final String d;
        private final String e;
        private long f;
        private long g;

        public f(g r2, h r3, String r4, String r5, String r6, long r7, long r9) {
            Intrinsics.checkNotNullParameter(r2, "identity");
            Intrinsics.checkNotNullParameter(r3, "token");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            Intrinsics.checkNotNullParameter(r5, "buildType");
            Intrinsics.checkNotNullParameter(r6, "runMode");
            this.f9351a = r2;
            this.f9352b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r9;
        }

        public /* synthetic */ f(g r14, h r15, String r16, String r17, String r18, long r19, long r21, int r23, DefaultConstructorMarker r24) {
            if ((r23 & 32) == 0) goto L5;
            long r9 = 0;
        L7:
            if ((r23 & 64) == 0) goto L9;
            long r11 = 0;
        L10:
            this(r14, r15, r16, r17, r18, r9, r11);
            return;
        L9:
            r11 = r21;
            goto L10
        L5:
            r9 = r19;
            goto L7
        }

        public final g a() {
            return this.f9351a;
        }

        public final void a(long r1) {
            this.f = r1;
        }

        public final h b() {
            return this.f9352b;
        }

        public final void b(long r1) {
            this.g = r1;
        }

        public final String c() {
            return this.c;
        }

        public final String d() {
            return this.d;
        }

        public final String e() {
            return this.e;
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, f.class) == true) goto L8;
            return false;
        L8:
            f r10 = (f) ZeusTransformUtils.preCheckCast(r9, f.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f9351a, r10.f9351a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f9352b, r10.f9352b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r10.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r10.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r10.e) == true) goto L24;
            return false;
        L24:
            if (this.f == r10.f) goto L27;
            return false;
        L27:
            if (this.g == r10.g) goto L29;
            return false;
        L29:
            return true;
        }

        public final long f() {
            return this.f;
        }

        public final long g() {
            return this.g;
        }

        public int hashCode() {
            return (((((((((((this.f9351a.hashCode() * 31) + this.f9352b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + Long.hashCode(this.f)) * 31) + Long.hashCode(this.g);
        }

        public String toString() {
            return "PendingContext(identity=" + this.f9351a + ", token=" + this.f9352b + ", packageName=" + this.c + ", buildType=" + this.d + ", runMode=" + this.e + ", modelDurationSumMs=" + this.f + ", modelDurationCount=" + this.g + ')';
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$PendingExecutionIdentity;", "", "round", "Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$EntityRoundIdentity;", "pendingId", "", "expectedTimestamp", "<init>", "(Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$EntityRoundIdentity;JJ)V", "getRound", "()Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$EntityRoundIdentity;", "getPendingId", "()J", "getExpectedTimestamp", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c f9353a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f9354b;
        private final long c;

        public g(c r2, long r3, long r5) {
            Intrinsics.checkNotNullParameter(r2, "round");
            this.f9353a = r2;
            this.f9354b = r3;
            this.c = r5;
        }

        public final c a() {
            return this.f9353a;
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, g.class) == true) goto L8;
            return false;
        L8:
            g r10 = (g) ZeusTransformUtils.preCheckCast(r9, g.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f9353a, r10.f9353a) == true) goto L12;
            return false;
        L12:
            if (this.f9354b == r10.f9354b) goto L15;
            return false;
        L15:
            if (this.c == r10.c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f9353a.hashCode() * 31) + Long.hashCode(this.f9354b)) * 31) + Long.hashCode(this.c);
        }

        public String toString() {
            return "PendingExecutionIdentity(round=" + this.f9353a + ", pendingId=" + this.f9354b + ", expectedTimestamp=" + this.c + ')';
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$PendingExecutionToken;", "", "<init>", "()V", "Companion", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f9355a = null;

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$PendingExecutionToken$Companion;", "", "<init>", "()V", "createForTracker", "Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$PendingExecutionToken;", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker r1) {
                this();
            }

            public final h a() {
                return new h(null);
            }
        }

        static {
            f9355a = new a(null);
        }

        private h() {
        }

        public /* synthetic */ h(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bJ\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$SettledSamples;", "", "diagnostic", "Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$Snapshot;", "core", "<init>", "(Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$Snapshot;Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$Snapshot;)V", "getDiagnostic", "()Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$Snapshot;", "getCore", "asList", "", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final j f9356a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final j f9357b;

        public i(j r1, j r2) {
            this.f9356a = r1;
            this.f9357b = r2;
        }

        public final j a() {
            return this.f9356a;
        }

        public final j b() {
            return this.f9357b;
        }

        public final List<j> c() {
            return CollectionsKt.listOfNotNull(new j[]{this.f9357b, this.f9356a});
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, i.class) == true) goto L8;
            return false;
        L8:
            i r6 = (i) ZeusTransformUtils.preCheckCast(r5, i.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f9356a, r6.f9356a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f9357b, r6.f9357b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            j r0 = this.f9356a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            j r4 = this.f9357b;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "SettledSamples(diagnostic=" + this.f9356a + ", core=" + this.f9357b + ')';
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\tHÆ\u0003J\t\u0010#\u001a\u00020\u000bHÆ\u0003J\t\u0010$\u001a\u00020\u000bHÆ\u0003J\t\u0010%\u001a\u00020\u000bHÆ\u0003J\t\u0010&\u001a\u00020\u000bHÆ\u0003Jc\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000bHÆ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\u0003HÖ\u0001J\t\u0010,\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0011\u0010\r\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0011\u0010\u000e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001a¨\u0006-"}, d2 = {"Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$Snapshot;", "", "entityType", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "", "buildType", "runMode", CommonConsts.COUNT_TYPE, "", "userWaitDuration", "Lcom/obric/memorydata/database/index/DurationStats;", "entityExecutionDuration", "buildTypeDuration", "modelDuration", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLcom/obric/memorydata/database/index/DurationStats;Lcom/obric/memorydata/database/index/DurationStats;Lcom/obric/memorydata/database/index/DurationStats;Lcom/obric/memorydata/database/index/DurationStats;)V", "getEntityType", "()I", "getPackageName", "()Ljava/lang/String;", "getBuildType", "getRunMode", "getCount", "()J", "getUserWaitDuration", "()Lcom/obric/memorydata/database/index/DurationStats;", "getEntityExecutionDuration", "getBuildTypeDuration", "getModelDuration", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f9358a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f9359b;
        private final String c;
        private final String d;
        private final long e;
        private final r f;
        private final r g;
        private final r h;
        private final r i;

        public j(int r2, String r3, String r4, String r5, long r6, r r8, r r9, r r10, r r11) {
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            Intrinsics.checkNotNullParameter(r4, "buildType");
            Intrinsics.checkNotNullParameter(r5, "runMode");
            Intrinsics.checkNotNullParameter(r8, "userWaitDuration");
            Intrinsics.checkNotNullParameter(r9, "entityExecutionDuration");
            Intrinsics.checkNotNullParameter(r10, "buildTypeDuration");
            Intrinsics.checkNotNullParameter(r11, "modelDuration");
            this.f9358a = r2;
            this.f9359b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r8;
            this.g = r9;
            this.h = r10;
            this.i = r11;
        }

        public final int a() {
            return this.f9358a;
        }

        public final String b() {
            return this.f9359b;
        }

        public final String c() {
            return this.c;
        }

        public final String d() {
            return this.d;
        }

        public final long e() {
            return this.e;
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, j.class) == true) goto L8;
            return false;
        L8:
            j r10 = (j) ZeusTransformUtils.preCheckCast(r9, j.class, "com.obric.memorydata.plugin");
            if (this.f9358a == r10.f9358a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f9359b, r10.f9359b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r10.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r10.d) == true) goto L21;
            return false;
        L21:
            if (this.e == r10.e) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r10.f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r10.g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.h, r10.h) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.i, r10.i) == true) goto L35;
            return false;
        L35:
            return true;
        }

        public final r f() {
            return this.f;
        }

        public final r g() {
            return this.g;
        }

        public final r h() {
            return this.h;
        }

        public int hashCode() {
            return (((((((((((((((Integer.hashCode(this.f9358a) * 31) + this.f9359b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + Long.hashCode(this.e)) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode();
        }

        public final r i() {
            return this.i;
        }

        public String toString() {
            return "Snapshot(entityType=" + this.f9358a + ", packageName=" + this.f9359b + ", buildType=" + this.c + ", runMode=" + this.d + ", count=" + this.e + ", userWaitDuration=" + this.f + ", entityExecutionDuration=" + this.g + ", buildTypeDuration=" + this.h + ", modelDuration=" + this.i + ')';
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class k<T> implements Comparator {
        public k() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((d) ZeusTransformUtils.preCheckCast(r2, d.class, "com.obric.memorydata.plugin")).a()), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.memorydata.plugin")).a()), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        f9341a = new a(null);
        g = SetsKt.setOf(new String[]{IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, WsConstants.KEY_EXTRA, "extract", "keyword", "full_content", "lazy_index_task", "content_time", "parse_ics_protocol_task", "meta_full_content", "location", "long_text", "file_entity", "image_entity", "video_entity", "video_frame", "caption", "ocr", "file_text", "word", "pdf", LocationMonitorConst.TAG, "file_content_text", "vlm_embedding_update_image_task", "vlm_embedding_update_text_task"});
    }

    public ai() {
        this.f9342b = new Object();
        this.c = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        this.d = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        this.e = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        this.f = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
    }

    private final j a(f r12, long r13, q r15) {
        int r1 = r12.a().a().b();
        String r2 = r12.c();
        String r4 = r12.e();
        r r7 = r.f9434a.a(r13);
        if (r15 == null) goto L6;
        r r11 = r.f9434a.a(r15.a());
        if (r11 == null) goto L6;
    L8:
        return new j(r1, r2, "NOT_APPLICABLE", r4, 1, r7, r11, r.f9434a.a(), r.f9434a.a());
    L6:
        r11 = r.f9434a.a();
        goto L8
    }

    private final q a(List<d> r12) {
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new k(), Comparator.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        long r1 = 0;
        Long r5 = null;
        long r3 = 0;
    L4:
        if (r11.hasNext() == false) goto L12;
        d r6 = (d) ZeusTransformUtils.preCheckCast(r11.next(), d.class, "com.obric.memorydata.plugin");
        long r7 = r6.a();
        long r9 = r6.b();
        if (r5 == null) goto L7;
        if (r7 > r1) goto L11;
        r1 = Math.max(r1, r9);
        goto L4
    L11:
        r3 = r3 + (r1 - r5.longValue());
    L7:
        r5 = Long.valueOf(r7);
        r1 = r9;
        goto L4
    L12:
        if (r5 != null) goto L14;
        return null;
    L14:
        return q.f9432a.a(r3 + (r1 - r5.longValue()));
    }

    private final void a(f r5) {
        this.c.put(r5.a(), r5);
        this.d.put(r5.b(), r5);
        Map<c, Set<h>> r4 = this.e;
        c r0 = r5.a().a();
        Set<h> r1 = r4.get(r0);
        if (r1 != null) goto L5;
        r1 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        r4.put(r0, r1);
    L5:
        ((Set) ZeusTransformUtils.preCheckCast(r1, Set.class, "com.obric.memorydata.plugin")).add(r5.b());
    }

    private final void a(f r3, long r4) {
        r3.a(r3.f() + r4);
        r3.b(r3.g() + 1);
    }

    private final boolean a(f r5, e r6) {
        if (r5.a().a().c() == r6.b()) goto L5;
    L9:
        return false;
    L5:
        if (r5.a().a().b() != r6.c()) goto L9;
        if (Intrinsics.areEqual(r5.d(), a(r6.d())) == false) goto L9;
        return true;
    }

    private final j b(f r13, long r14) {
        return new j(r13.a().a().b(), r13.c(), r13.d(), r13.e(), 1, r.f9434a.a(), r.f9434a.a(), r.f9434a.a(r14), r.f9434a.a(r13.f(), r13.g()));
    }

    private final void b(c r4) {
        Set r5 = (Set) ZeusTransformUtils.preCheckCast(this.e.remove(r4), Set.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L5;
        List r6 = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin"));
    L6:
        if (r6 != null) goto L8;
        r6 = CollectionsKt.emptyList();
    L8:
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L10:
        if (r7.hasNext() == false) goto L15;
        h r0 = (h) ZeusTransformUtils.preCheckCast(r7.next(), h.class, "com.obric.memorydata.plugin");
        f r1 = (f) ZeusTransformUtils.preCheckCast(this.d.remove(r0), f.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L10;
        this.c.remove(r1.a());
        goto L10
    L15:
        return;
    L5:
        r6 = null;
        goto L6
    }

    private final f c(h r5) {
        f r0 = (f) ZeusTransformUtils.preCheckCast(this.d.remove(r5), f.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        return null;
    L6:
        this.c.remove(r0.a());
        Set r1 = (Set) ZeusTransformUtils.preCheckCast(this.e.get(r0.a().a()), Set.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L11;
        r1.remove(r5);
        if (r1.isEmpty() == false) goto L11;
        this.e.remove(r0.a().a());
    L11:
        return r0;
    }

    public final e a(h r9) {
        Intrinsics.checkNotNullParameter(r9, "token");
        Object r0 = this.f9342b;
        monitor-enter(r0);
        f r8 = (f) ZeusTransformUtils.preCheckCast(this.d.get(r9), f.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r8 == null) goto L8;
        e r7 = new e(r9, r8.a().a().c(), r8.a().a().b(), r8.d());     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);
        return r7;
    L8:
        r7 = null;
    L11:
        th = move-exception;
        throw th;
    }

    public final h a(c r19, long r20, long r22, String r24, String r25, String r26) {
        Intrinsics.checkNotNullParameter(r19, "round");
        Intrinsics.checkNotNullParameter(r24, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Object r1 = this.f9342b;
        monitor-enter(r1);
        g r9 = new g(r19, r20, r22);     // Catch: Throwable -> L11
        if (this.c.containsKey(r9) == false) goto L7;
        h r0 = null;
    L9:
        monitor-exit(r1);
        return r0;
    L7:
        h r14 = h.f9355a.a();     // Catch: Throwable -> L11
        a(new f(r9, r14, r24, a(r25), f9341a.a(r26), 0, 0, 96, null));     // Catch: Throwable -> L11
        r0 = r14;
    L11:
        th = move-exception;
        throw th;
    }

    public final i a(h r7, q r8, x r9) {
        Intrinsics.checkNotNullParameter(r7, "token");
        Object r0 = this.f9342b;
        monitor-enter(r0);
        f r1 = (f) ZeusTransformUtils.preCheckCast(this.d.get(r7), f.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L40
        if (r1 != null) goto L7;
        b r10 = null;
    L14:
        monitor-exit(r0);
        if (r10 != null) goto L17;
        return null;
    L17:
        if (r8 == null) goto L19;
        j r11 = b(r10.getContext(), r8.a());
    L21:
        if (ZeusTransformUtils.instanceOf(r9, x.c.class) == false) goto L23;
        x.c r12 = (x.c) ZeusTransformUtils.preCheckCast(r9, x.c.class, "com.obric.memorydata.plugin");
    L24:
        if (r12 == null) goto L29;
        f r2 = r10.getContext();
        long r3 = r12.a();
        List<d> r13 = r10.a();
        if (r13 != null) goto L28;
        r13 = CollectionsKt.emptyList();
    L28:
        j r6 = a(r2, r3, a(r13));
    L30:
        i r14 = new i(r11, r6);
        if (r14.a() == null) goto L33;
    L36:
        boolean r15 = true;
    L37:
        if (r15 == true) goto L39;
        return null;
    L39:
        return r14;
    L33:
        if (r14.b() != null) goto L36;
        r15 = false;
        goto L37
    L29:
        r6 = null;
        goto L30
    L23:
        r12 = null;
        goto L24
    L19:
        r11 = null;
        goto L21
    L7:
        if (r9 != null) goto L9;
        List r4 = null;
    L10:
        if (r9 != null) goto L12;
        c(r7);     // Catch: Throwable -> L40
    L13:
        r10 = new b(r1, r4);     // Catch: Throwable -> L40
        goto L14
    L12:
        b(r1.a().a());     // Catch: Throwable -> L40
        goto L13
    L9:
        r4 = (List) ZeusTransformUtils.preCheckCast(this.f.remove(r1.a().a()), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        throw th;
    }

    public final String a(String r1) {
        if (r1 != null) goto L4;
    L8:
        return "UNKNOWN";
    L4:
        if (g.contains(r1) == true) goto L7;
        r1 = null;
    L7:
        if (r1 == null) goto L8;
        return r1;
    }

    public final void a(c r3) {
        Intrinsics.checkNotNullParameter(r3, "round");
        Object r0 = this.f9342b;
        monitor-enter(r0);
        this.f.remove(r3);     // Catch: Throwable -> L7
        b(r3);     // Catch: Throwable -> L7
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void a(e r5, long r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Object r0 = this.f9342b;
        monitor-enter(r0);
        f r1 = (f) ZeusTransformUtils.preCheckCast(this.d.get(r5.a()), f.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        if (r1 != null) goto L8;
    L10:
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r0);
        return;
    L8:
        if (a(r1, r5) == false) goto L10;
        a(r1, r6);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public final void a(h r4, long r5) {
        Intrinsics.checkNotNullParameter(r4, "token");
        Object r0 = this.f9342b;
        monitor-enter(r0);
        f r6 = (f) ZeusTransformUtils.preCheckCast(this.d.get(r4), f.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r6 == null) goto L8;
        a(r6, r5);     // Catch: Throwable -> L11
    L8:
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r0);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final void a(h r8, long r9, long r11) {
        Intrinsics.checkNotNullParameter(r8, "token");
        Object r0 = this.f9342b;
        monitor-enter(r0);
        f r10 = (f) ZeusTransformUtils.preCheckCast(this.d.get(r8), f.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        if (r10 != null) goto L8;
    L13:
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(r0);
        return;
    L8:
        if (r11 <= r9) goto L13;
        Map<c, List<d>> r12 = this.f;     // Catch: Throwable -> L16
        c r13 = r10.a().a();     // Catch: Throwable -> L16
        List<d> r1 = r12.get(r13);     // Catch: Throwable -> L16
        if (r1 != null) goto L12;
        r1 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        r12.put(r13, r1);     // Catch: Throwable -> L16
    L12:
        ((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin")).add(new d(r9, r11, null));     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    public final boolean a(String r16, int r17, long r18, String r20, long r21) {
        Intrinsics.checkNotNullParameter(r16, "ownerDbType");
        Intrinsics.checkNotNullParameter(r20, "buildType");
        Object r3 = this.f9342b;
        monitor-enter(r3);
        String r2 = a(r20);     // Catch: Throwable -> L31
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(this.d.values(), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L31
        boolean r5 = true;
        Object r7 = null;
        boolean r8 = false;
        Object r9 = null;
    L6:
        if (r4.hasNext() == false) goto L22;
        Object r10 = r4.next();     // Catch: Throwable -> L31
        f r11 = (f) ZeusTransformUtils.preCheckCast(r10, f.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L31
        c r12 = r11.a().a();     // Catch: Throwable -> L31
        if (Intrinsics.areEqual(r12.a(), r16) == false) goto L17;
        if (r12.b() != r17) goto L17;
        if (r12.c() != r18) goto L17;
        if (Intrinsics.areEqual(r11.d(), r2) == false) goto L17;
        boolean r13 = true;
    L18:
        if (r13 == false) goto L6;
        if (r8 == true) goto L25;
        r8 = true;
        r9 = r10;
    L25:
        f r1 = (f) ZeusTransformUtils.preCheckCast(r7, f.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L31
        if (r1 != null) goto L28;
        r5 = false;
    L29:
        monitor-exit(r3);
        return r5;
    L28:
        a(r1, r21);     // Catch: Throwable -> L31
    L17:
        r13 = false;
        goto L18
    L22:
        if (r8 == false) goto L25;
        r7 = r9;
    L31:
        th = move-exception;
        throw th;
    }

    public final void b(h r2) {
        Intrinsics.checkNotNullParameter(r2, "token");
        Object r0 = this.f9342b;
        monitor-enter(r0);
        c(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
