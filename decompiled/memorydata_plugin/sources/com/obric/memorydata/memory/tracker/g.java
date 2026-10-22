package com.obric.memorydata.memory.tracker;

import android.app.ActivityManager;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdinstall.dtrait.constant.DTraitConstant;
import com.obric.memorydata.middleware.api.bdtracker.Tracker;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u0000 \u00042\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/memory/tracker/MobileMemBuildTracker;", "", "<init>", "()V", "Companion", "Event", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10544a = null;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/memory/tracker/MobileMemBuildTracker$Companion;", "", "<init>", "()V", "TAG", "", "EVENT_NAME", "TASK_REAL_ERROR_CODE_KEY", "TASK_REAL_ERROR_MSG_KEY", "CODE_SUCCESS", "", "CODE_INPUT_ERROR", "CODE_LLM_CALL_RESPONSE_NULL", "CODE_LLM_CALL_EXCEPTION", "CODE_LLM_CALL_CONTENT_FILTER", "CODE_LLM_CALL_RESULT_SUCCESS_BUT_NO_EFFECTIVE_TOOL_AND_NONE_ASSISTANT_SCENE", "CODE_LLM_CALL_RESULT_CALL_USER_BUT_NONE_ASSISTANT_SCENE", "CODE_MEMORY_POISON_FILTER", "CODE_NETWORK_UNAVAILABLE", "CODE_TASK_TIMEOUT", "CODE_CANCELLED", "CODE_UNKNOWN_ERROR", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0007J\u0006\u0010\u0015\u001a\u00020\u0013J\u0006\u0010\u0016\u001a\u00020\u0013J$\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\u0018\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\t\u0010\u001f\u001a\u00020\u0003HÂ\u0003J\t\u0010 \u001a\u00020\u0005HÂ\u0003J\t\u0010!\u001a\u00020\u0007HÂ\u0003J'\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010#\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\u0003HÖ\u0001J\t\u0010'\u001a\u00020\u001aHÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u0006("}, d2 = {"Lcom/obric/memorydata/memory/tracker/MobileMemBuildTracker$Event;", "Lcom/obric/memorydata/memory/strategy/MemoryTrackingEvent;", "productType", "", "isRetry", "", "realBeginTs", "", "<init>", "(IZJ)V", "beginTs", "memoryTs", "snapshotTs", "consumed", "isMonkeySession", "()Z", "isMonkeySession$delegate", "Lkotlin/Lazy;", "begin", "", "ts", "onStageMemory", "onStageSnapshot", "end", "errorCode", DTraitConstant.ERROR, "", "metrics", "Lorg/json/JSONObject;", "mergeMetrics", TypedValues.AttributesType.S_TARGET, "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements com.obric.memorydata.memory.e.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f10545a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f10546b;
        private final long c;
        private long d;
        private long e;
        private long f;
        private boolean g;
        private final Lazy h;

        public b(int r1, boolean r2, long r3) {
            this.f10545a = r1;
            this.f10546b = r2;
            this.c = r3;
            this.h = LazyKt.lazy($$Lambda$g$b$Zq5x3FbOHRkaWPHYx_QWAjaRG1Y.INSTANCE);
        }

        public static /* synthetic */ void a(b r0, int r1, String r2, JSONObject r3, int r4, Object r5) {
            if ((r4 & 2) == 0) goto L6;
            r2 = "";
        L6:
            if ((r4 & 4) == 0) goto L8;
            r3 = null;
        L8:
            r0.a(r1, r2, r3);
        }

        public static /* synthetic */ void a(b r0, long r1, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L5;
            r1 = System.currentTimeMillis();
        L5:
            r0.a(r1);
        }

        private final void a(JSONObject r4, JSONObject r5) {
            Iterator<String> r3 = r5.keys();
        L4:
            if (r3.hasNext() == false) goto L6;
            String r0 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin");
            r4.put(r0, r5.get(r0));
            goto L4
        }

        private final boolean c() {
            return ((Boolean) ZeusTransformUtils.preCheckCast(this.h.getValue(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        }

        private static final boolean d() {
            return ActivityManager.isUserAMonkey();
        }

        public static /* synthetic */ boolean lambda$Zq5x3FbOHRkaWPHYx_QWAjaRG1Y() {
            return d();
        }

        public final synchronized void a() {
            monitor-enter(this);
        L8:
            th = move-exception;
            throw th;
        L4:
            if (this.e != 0) goto L6;
            this.e = System.currentTimeMillis();     // Catch: Throwable -> L8
            RunLog.INSTANCE.debug("MobileMemBuildTracker", "onStageMemory, delta=" + (this.e - this.d));     // Catch: Throwable -> L8
        L6:
            monitor-exit(this);
        }

        public final synchronized void a(int r12, String r13, JSONObject r14) {
            monitor-enter(this);
            Intrinsics.checkNotNullParameter(r13, DTraitConstant.ERROR);     // Catch: Throwable -> L36
            if (this.g == false) goto L8;
            RunLog.INSTANCE.debug("MobileMemBuildTracker", "end: already consumed, ignore");     // Catch: Throwable -> L36
            monitor-exit(this);
            return;
        L8:
            int r0 = 1;
            this.g = true;     // Catch: Throwable -> L36
            long r1 = System.currentTimeMillis();     // Catch: Throwable -> L36
            if (this.d != 0) goto L17;
            long r3 = this.c;     // Catch: Throwable -> L36
            if (r3 > 0) goto L15;
            r3 = r1;
        L15:
            this.d = r3;     // Catch: Throwable -> L36
        L17:
            if (this.e != 0) goto L19;
            this.e = r1;     // Catch: Throwable -> L36
        L19:
            long r2 = this.e;     // Catch: Throwable -> L36
            long r4 = this.d;     // Catch: Throwable -> L36
            long r5 = r2 - r4;     // Catch: Throwable -> L36
            long r7 = this.f;     // Catch: Throwable -> L36
            if (r7 != 0) goto L22;
            long r8 = r5;
        L23:
            long r6 = RangesKt.coerceAtLeast(r4 - this.c, 0);     // Catch: Throwable -> L36
            JSONObject r9 = new JSONObject();     // Catch: Throwable -> L36
            r9.put("e2e_cost_memory_total", RangesKt.coerceAtLeast(r5, 0));     // Catch: Throwable -> L36
            r9.put("e2e_cost_memory_snapshot", RangesKt.coerceAtLeast(r8, 0));     // Catch: Throwable -> L36
            r9.put("e2e_cost_link", r6);     // Catch: Throwable -> L36
            r9.put("e2e_param_product", this.f10545a);     // Catch: Throwable -> L36
            if (this.f10546b == true) goto L27;
            r0 = 0;
        L27:
            r9.put("e2e_param_retry", r0);     // Catch: Throwable -> L36
            r9.put("e2e_result_code", r12);     // Catch: Throwable -> L36
            r9.put("e2e_result_error_msg", r13);     // Catch: Throwable -> L36
            if (r14 == null) goto L31;
            a(r9, r14);     // Catch: Throwable -> L36
        L31:
            if (c() == false) goto L33;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MobileMemBuildTracker", "monkey is jumping, ignore", null, 4, null);     // Catch: Throwable -> L36
        L34:
            monitor-exit(this);
            return;
        L33:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MobileMemBuildTracker", "reportEvent mobile_mem_build: " + r9, false, 4, null);     // Catch: Throwable -> L36
            Tracker.INSTANCE.reportEvent("mobile_mem_build", r9);     // Catch: Throwable -> L36
            goto L34
        L22:
            r8 = r7 - r4;     // Catch: Throwable -> L36
        L36:
            th = move-exception;
            throw th;
        }

        public final synchronized void a(long r4) {
            monitor-enter(this);
            RunLog.INSTANCE.debug("MobileMemBuildTracker", "begin");     // Catch: Throwable -> L6
            this.d = r4;     // Catch: Throwable -> L6
            c();     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public final synchronized void b() {
            monitor-enter(this);
        L8:
            th = move-exception;
            throw th;
        L4:
            if (this.f != 0) goto L6;
            this.f = System.currentTimeMillis();     // Catch: Throwable -> L8
            RunLog.INSTANCE.debug("MobileMemBuildTracker", "onStageSnapshot, delta=" + (this.f - this.d));     // Catch: Throwable -> L8
        L6:
            monitor-exit(this);
        }

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, b.class) == true) goto L8;
            return false;
        L8:
            b r8 = (b) ZeusTransformUtils.preCheckCast(r7, b.class, "com.obric.memorydata.plugin");
            if (this.f10545a == r8.f10545a) goto L12;
            return false;
        L12:
            if (this.f10546b == r8.f10546b) goto L15;
            return false;
        L15:
            if (this.c == r8.c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.f10545a) * 31) + Boolean.hashCode(this.f10546b)) * 31) + Long.hashCode(this.c);
        }

        public String toString() {
            return "Event(productType=" + this.f10545a + ", isRetry=" + this.f10546b + ", realBeginTs=" + this.c + ')';
        }
    }

    static {
        f10544a = new a(null);
    }
}
