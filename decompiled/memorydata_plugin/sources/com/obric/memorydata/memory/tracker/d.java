package com.obric.memorydata.memory.tracker;

import com.bytedance.bdinstall.dtrait.constant.DTraitConstant;
import com.obric.memorydata.middleware.api.bdtracker.Tracker;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u0000 \u00042\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/memory/tracker/MemoryLLMExtractTracker;", "", "<init>", "()V", "Companion", "TrackingEvent", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10537a = null;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b#\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/obric/memorydata/memory/tracker/MemoryLLMExtractTracker$Companion;", "", "<init>", "()V", "TAG", "", "lastFinishInputTs", "", "getLastFinishInputTs", "()J", "setLastFinishInputTs", "(J)V", "KEY_ERROR_CODE", "KEY_ERROR_MSG", "TASK_REAL_ERROR_CODE_KEY", "TASK_REAL_ERROR_MSG_KEY", "CODE_RET_SUCCESS", "", "ERROR_NETWORK", "ERROR_INVALID_RESPONSE", "ERROR_JSON_PARSE_ERROR", "ERROR_CRONET_IO_EXCEPTION", "ERROR_INVALID_REQUEST", "ERROR_IO_EXCEPTION", "ERROR_CONTENT_FILTER", "ERROR_STREAM_CANCELLED", "ERROR_FORNAX", "CODE_INPUT_ERROR", "CODE_IMAGE_UPLOAD_ERROR", "CODE_LLM_CONTENT_ERROR", "CODE_LLM_CONTENT_MEMORY_ERROR", "CODE_LLM_CONTENT_EXCEPTION_ERROR", "CODE_NETWORK_UNAVAILABLE_ERROR", "CODE_TASK_TIMEOUT_ERROR", "CODE_MEMORY_TIMEOUT_ERROR", "CODE_UNKNOWN_ERROR", "CODE_CLASSIFY_ERROR", "CODE_UPDATE_BUT_INTENT_NOT_SUPPORT", "CODE_UPDATE_BUT_RECALL_EMPTY", "CODE_UPDATE_BUT_RESULT_CREATE", "KEY_TOTAL_TIME", "KEY_MEMORY_TIME", "KEY_LINK_COST_TIME", "KEY_APP_NAME", "KEY_HAS_SCREENSHOT", "KEY_PRODUCT_TYPE", "KEY_IS_RETRY", "KEY_TOS_COST_TIME", "KEY_CLASSIFY_COST_TIME", "KEY_RETRIEVE_COST_TIME", "KEY_EXTRACT_COST_TIME", "KEY_MEMORY_TYPE", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\tJ&\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00032\u0016\b\u0002\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cJ\u001a\u0010\u001e\u001a\u00020\u00172\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u0007J\t\u0010!\u001a\u00020\u0003HÂ\u0003J\t\u0010\"\u001a\u00020\u0005HÂ\u0003J\t\u0010#\u001a\u00020\u0007HÂ\u0003J\t\u0010$\u001a\u00020\tHÂ\u0003J\t\u0010%\u001a\u00020\u0005HÂ\u0003J;\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u0005HÆ\u0001J\u0013\u0010'\u001a\u00020\u00052\b\u0010(\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010)\u001a\u00020\u0003HÖ\u0001J\t\u0010*\u001a\u00020\u0007HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/obric/memorydata/memory/tracker/MemoryLLMExtractTracker$TrackingEvent;", "Lcom/obric/memorydata/memory/strategy/MemoryTrackingEvent;", "productType", "", "hasScreenshot", "", "appName", "", "realBeginTs", "", "isRetry", "<init>", "(IZLjava/lang/String;JZ)V", "memoryType", "beginTs", "endMemoryTs", "endTs", "tosCostTime", "classifyCostTime", "retrieveCostTime", "extractCostTime", "consumed", "begin", "", "ts", "endMemory", "type", "extraMap", "", "", "end", "errorCode", DTraitConstant.ERROR, "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements com.obric.memorydata.memory.e.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f10538a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f10539b;
        private final String c;
        private final long d;
        private final boolean e;
        private int f;
        private long g;
        private long h;
        private long i;
        private long j;
        private long k;
        private long l;
        private long m;
        private boolean n;

        public static /* synthetic */ void a(b r0, int r1, String r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = 0;
        L6:
            if ((r3 & 2) == 0) goto L8;
            r2 = "";
        L8:
            r0.a(r1, r2);
        }

        public final synchronized void a(int r18, String r19) {
            monitor-enter(this);
            Intrinsics.checkNotNullParameter(r19, DTraitConstant.ERROR);     // Catch: Throwable -> L32
            RunLog.INSTANCE.debug("MemoryLLMExtractTracker", "End Extract, consumed: " + this.n);     // Catch: Throwable -> L32
            if (this.n == false) goto L8;
            monitor-exit(this);
            return;
        L8:
            int r2 = 1;
            this.n = true;     // Catch: Throwable -> L32
            long r3 = System.currentTimeMillis();     // Catch: Throwable -> L32
            this.i = r3;     // Catch: Throwable -> L32
            long r5 = this.g;     // Catch: Throwable -> L32
            long r4 = r3 - r5;     // Catch: Throwable -> L32
            long r7 = 0;
            if (r4 > 0) goto L14;
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryLLMExtractTracker", "totalTime <=0, beginTs: " + this.g + ", endTs: " + this.i, null, 4, null);     // Catch: Throwable -> L32
            monitor-exit(this);
            return;
        L14:
            long r9 = this.h - r5;     // Catch: Throwable -> L32
            if (r9 > 0) goto L17;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryLLMExtractTracker", "memoryTime <=0, beginTs: " + this.g + ", endMemoryTs: " + this.h, null, 4, null);     // Catch: Throwable -> L32
            r9 = 0;
        L17:
            long r6 = this.g - this.d;     // Catch: Throwable -> L32
            if (r6 > 0) goto L20;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryLLMExtractTracker", "linkCostTime <=0, beginTs: " + this.g + ", realBeginTs: " + this.d, null, 4, null);     // Catch: Throwable -> L32
        L21:
            JSONObject r8 = new JSONObject();     // Catch: Throwable -> L32
            r8.put("totalTime", r4);     // Catch: Throwable -> L32
            r8.put("memoryTime", r9);     // Catch: Throwable -> L32
            r8.put("linkCostTime", r7);     // Catch: Throwable -> L32
            r8.put("tosCostTime", this.j);     // Catch: Throwable -> L32
            r8.put("classifyCostTime", this.k);     // Catch: Throwable -> L32
            r8.put("retrieveCostTime", this.l);     // Catch: Throwable -> L32
            r8.put("extractCostTime", this.m);     // Catch: Throwable -> L32
            r8.put("appName", this.c);     // Catch: Throwable -> L32
            if (this.f10539b == false) goto L24;
            int r10 = 1;
        L25:
            r8.put("hasScreenshot", r10);     // Catch: Throwable -> L32
            r8.put("productType", this.f10538a);     // Catch: Throwable -> L32
            r8.put("memoryType", this.f);     // Catch: Throwable -> L32
            if (this.e == true) goto L29;
            r2 = 0;
        L29:
            r8.put("isRetry", r2);     // Catch: Throwable -> L32
            r8.put("errorCode", r18);     // Catch: Throwable -> L32
            r8.put(DTraitConstant.ERROR, r19);     // Catch: Throwable -> L32
            RunLog.INSTANCE.debug("MemoryLLMExtractTracker", "reportEvent, event: " + r8);     // Catch: Throwable -> L32
            Tracker.INSTANCE.reportEvent("memory_llm_extract", r8);     // Catch: Throwable -> L32
            monitor-exit(this);
            return;
        L24:
            r10 = 0;
            goto L25
        L20:
            r7 = r6;
        L32:
            th = move-exception;
            throw th;
        }

        public final synchronized void a(int r6, Map<String, ? extends Object> r7) {
            monitor-enter(this);
            Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L52
            RunLog.INSTANCE.debug("MemoryLLMExtractTracker", "endMemory Extract");     // Catch: Throwable -> L52
            this.h = System.currentTimeMillis();     // Catch: Throwable -> L52
            this.f = r6;     // Catch: Throwable -> L52
            Long r9 = null;
            if (r8 == null) goto L6;
            Object r0 = r8.get("tos_cost");     // Catch: Throwable -> L52
        L8:
            if (ZeusTransformUtils.instanceOf(r0, Long.class) == false) goto L10;
            Long r1 = (Long) ZeusTransformUtils.preCheckCast(r0, Long.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L52
        L12:
            if (r1 == null) goto L14;
            long r3 = r1.longValue();     // Catch: Throwable -> L52
        L15:
            this.j = r3;     // Catch: Throwable -> L52
            if (r8 == null) goto L18;
            Object r2 = r8.get("classify_cost");     // Catch: Throwable -> L52
        L20:
            if (ZeusTransformUtils.instanceOf(r2, Long.class) == false) goto L22;
            Long r4 = (Long) ZeusTransformUtils.preCheckCast(r2, Long.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L52
        L23:
            if (r4 == null) goto L25;
            long r5 = r4.longValue();     // Catch: Throwable -> L52
        L26:
            this.k = r5;     // Catch: Throwable -> L52
            if (r8 == null) goto L29;
            Object r10 = r8.get("retrieve_cost");     // Catch: Throwable -> L52
        L31:
            if (ZeusTransformUtils.instanceOf(r10, Long.class) == false) goto L33;
            Long r11 = (Long) ZeusTransformUtils.preCheckCast(r10, Long.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L52
        L34:
            if (r11 == null) goto L36;
            long r12 = r11.longValue();     // Catch: Throwable -> L52
        L37:
            this.l = r12;     // Catch: Throwable -> L52
            if (r8 == null) goto L40;
            Object r13 = r8.get("extract_cost");     // Catch: Throwable -> L52
        L42:
            if (ZeusTransformUtils.instanceOf(r13, Long.class) == false) goto L44;
            r9 = (Long) ZeusTransformUtils.preCheckCast(r13, Long.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L52
        L44:
            if (r9 == null) goto L46;
            long r14 = r9.longValue();     // Catch: Throwable -> L52
        L47:
            this.m = r14;     // Catch: Throwable -> L52
            if (this.j <= 0) goto L50;
            this.f10539b = true;     // Catch: Throwable -> L52
        L50:
            monitor-exit(this);
            return;
        L46:
            r14 = 0;
            goto L47
        L40:
            r13 = null;
            goto L42
        L36:
            r12 = 0;
            goto L37
        L33:
            r11 = null;
            goto L34
        L29:
            r10 = null;
            goto L31
        L25:
            r5 = 0;
            goto L26
        L22:
            r4 = null;
            goto L23
        L18:
            r2 = null;
            goto L20
        L14:
            r3 = 0;
            goto L15
        L10:
            r1 = null;
            goto L12
        L6:
            r0 = null;
        L52:
            th = move-exception;
            throw th;
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, b.class) == true) goto L8;
            return false;
        L8:
            b r10 = (b) ZeusTransformUtils.preCheckCast(r9, b.class, "com.obric.memorydata.plugin");
            if (this.f10538a == r10.f10538a) goto L12;
            return false;
        L12:
            if (this.f10539b == r10.f10539b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r10.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r10.d) goto L21;
            return false;
        L21:
            if (this.e == r10.e) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            return (((((((Integer.hashCode(this.f10538a) * 31) + Boolean.hashCode(this.f10539b)) * 31) + this.c.hashCode()) * 31) + Long.hashCode(this.d)) * 31) + Boolean.hashCode(this.e);
        }

        public String toString() {
            return "TrackingEvent(productType=" + this.f10538a + ", hasScreenshot=" + this.f10539b + ", appName=" + this.c + ", realBeginTs=" + this.d + ", isRetry=" + this.e + ')';
        }
    }

    static {
        f10537a = new a(null);
    }
}
