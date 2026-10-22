package com.obric.memorydata.memory.review.provider;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.capabilitykit.common.Ext;
import com.obric.memorydata.database.dao.MemoryTraceReportDao;
import com.obric.memorydata.database.entity.dh;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0000\u0018\u0000 ;2\u00020\u0001:\u0001;B{\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u0016\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018J\u000e\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0018J\u0016\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018J\u0016\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018J\u0006\u0010\u001d\u001a\u00020\u001eJ\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002J\u001c\u0010#\u001a\u00020$*\u00020%2\u0006\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020(H\u0002J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020$H\u0002J\f\u0010,\u001a\u00020\u000e*\u00020$H\u0002J\u0016\u0010-\u001a\b\u0012\u0004\u0012\u00020%0.2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J&\u0010/\u001a\b\u0012\u0004\u0012\u00020%0.2\u0006\u00100\u001a\u00020\n2\u0006\u00101\u001a\u00020\n2\u0006\u00102\u001a\u00020\u000eH\u0002J\u0018\u00103\u001a\b\u0012\u0004\u0012\u00020%0.*\b\u0012\u0004\u0012\u00020%0.H\u0002J\u0010\u00104\u001a\u0002052\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u00106\u001a\u00020 H\u0002J\u0010\u00107\u001a\u00020 2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0018\u00108\u001a\u00020 2\u0006\u00109\u001a\u00020\u00182\u0006\u0010:\u001a\u00020\u0018H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/obric/memorydata/memory/review/provider/MemoryTraceReportRepository;", "", "localDataSource", "Lcom/obric/memorydata/memory/review/provider/MemoryTraceReportLocalDataSource;", "remoteDataSource", "Lcom/obric/memorydata/memory/review/provider/MemoryTraceReportRemoteDataSource;", "taskScheduler", "Lcom/obric/memorydata/memory/review/provider/MemoryTraceReportTaskScheduler;", "clock", "Lkotlin/Function0;", "", "pendingDelayMillis", "retryIntervalMillis", "batchSize", "", "maxReportDataBytes", "maxRequestBodyBytes", "maxRetryCount", "viewTreeFileStore", "Lcom/obric/memorydata/memory/review/trace/MemoryTraceReportViewTreeFileStore;", "<init>", "(Lcom/obric/memorydata/memory/review/provider/MemoryTraceReportLocalDataSource;Lcom/obric/memorydata/memory/review/provider/MemoryTraceReportRemoteDataSource;Lcom/obric/memorydata/memory/review/provider/MemoryTraceReportTaskScheduler;Lkotlin/jvm/functions/Function0;JJIIIILcom/obric/memorydata/memory/review/trace/MemoryTraceReportViewTreeFileStore;)V", "insertTraceReport", "logId", "", "reportData", "triggerTraceReport", "insertAndTriggerDebounced", "upsertAndTriggerDebounced", "reportTriggeredPending", "Lcom/obric/memorydata/memory/review/provider/MemoryTraceReportRunResult;", "releaseTraceAttachments", "", "result", "Lcom/obric/memorydata/memory/inapptrace/InAppTraceReportAttachmentStore$ResolveResult$Ready;", "toRequest", "Lcom/obric/memorydata/memory/review/provider/MemoryTraceReportRequest;", "Lcom/obric/memorydata/database/entity/MemoryTraceReportEntity;", "now", WsConstants.KEY_EXTRA, "Lorg/json/JSONObject;", "prepareRequestForUpload", "Lcom/obric/memorydata/memory/review/provider/PreparedTraceRequest;", Ext.KEY_REQUEST, "serializedBodyBytes", "queryUnfinishedByLogIdSafely", "", "queryTriggeredPendingSafely", "pendingBeforeTime", "retryBeforeTime", "limit", "filterUsableRows", "isReportDataOversized", "", "cleanupOversizedRows", "cleanupOversizedByLogId", "logInfo", LocationMonitorConst.TAG, "message", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class aq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10421a = null;
    private static final Object m = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ao f10422b;
    private final ap c;
    private final au d;
    private final Function0<Long> e;
    private final long f;
    private final long g;
    private final int h;
    private final int i;
    private final int j;
    private final int k;
    private final com.obric.memorydata.memory.review.trace.k l;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/memory/review/provider/MemoryTraceReportRepository$Companion;", "", "<init>", "()V", "upsertLock", "DEFAULT_PENDING_DELAY_MILLIS", "", "DEFAULT_RETRY_INTERVAL_MILLIS", "DEFAULT_BATCH_SIZE", "", "DEFAULT_MAX_REPORT_DATA_BYTES", "DEFAULT_MAX_REQUEST_BODY_BYTES", "DEFAULT_MAX_RETRY_COUNT", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f10421a = new a(null);
        m = new Object();
    }

    public aq() {
        this(null, null, null, null, 0, 0, 0, 0, 0, 0, null, 2047, null);
    }

    public aq(ao r3, ap r4, au r5, Function0<Long> r6, long r7, long r9, int r11, int r12, int r13, int r14, com.obric.memorydata.memory.review.trace.k r15) {
        ao r8 = (ao) ZeusTransformUtils.wrapperContextForParams(r3, ao.class, "com.obric.memorydata.plugin");
        ap r10 = (ap) ZeusTransformUtils.wrapperContextForParams(r4, ap.class, "com.obric.memorydata.plugin");
        au r16 = (au) ZeusTransformUtils.wrapperContextForParams(r5, au.class, "com.obric.memorydata.plugin");
        Function0<Long> r17 = (Function0) ZeusTransformUtils.wrapperContextForParams(r6, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "localDataSource");
        Intrinsics.checkNotNullParameter(r10, "remoteDataSource");
        Intrinsics.checkNotNullParameter(r16, "taskScheduler");
        Intrinsics.checkNotNullParameter(r17, "clock");
        Intrinsics.checkNotNullParameter(r15, "viewTreeFileStore");
        this.f10422b = r8;
        this.c = r10;
        this.d = r16;
        this.e = r17;
        this.f = r7;
        this.g = r9;
        this.h = r11;
        this.i = r12;
        this.j = r13;
        this.k = r14;
        this.l = r15;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ aq(ao r14, ap r15, au r16, Function0 r17, long r18, long r20, int r22, int r23, int r24, int r25, com.obric.memorydata.memory.review.trace.k r26, int r27, DefaultConstructorMarker r28) {
        ao r1 = (ao) ZeusTransformUtils.wrapperContextForParams(r14, ao.class, "com.obric.memorydata.plugin");
        ap r3 = (ap) ZeusTransformUtils.wrapperContextForParams(r15, ap.class, "com.obric.memorydata.plugin");
        au r4 = (au) ZeusTransformUtils.wrapperContextForParams(r16, au.class, "com.obric.memorydata.plugin");
        Function0 r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r17, Function0.class, "com.obric.memorydata.plugin");
        int r7 = 1;
        MemoryTraceReportDao r8 = null;
        Object[] r9 = 0;
        Object[] r10 = 0;
        Object[] r11 = 0;
        if ((r27 & 1) == 0) goto L6;
        r1 = (ao) ZeusTransformUtils.preCheckCast(new u(r8, r7, r11 == true ? 1 : 0), ao.class, "com.obric.memorydata.plugin");
    L6:
        if ((r27 & 2) == 0) goto L9;
        r3 = (ap) ZeusTransformUtils.preCheckCast(new av(r10 == true ? 1 : 0, r7, r9 == true ? 1 : 0), ap.class, "com.obric.memorydata.plugin");
    L9:
        if ((r27 & 4) == 0) goto L12;
        r4 = (au) ZeusTransformUtils.preCheckCast(bb.f10440a, au.class, "com.obric.memorydata.plugin");
    L12:
        if ((r27 & 8) == 0) goto L15;
        r5 = $$Lambda$aq$aWccKjYTk9iMinCaxD9QH0s8sA.INSTANCE;
    L15:
        if ((r27 & 16) == 0) goto L17;
        long r6 = 10000;
    L19:
        if ((r27 & 32) == 0) goto L21;
        long r12 = 600000;
    L23:
        if ((r27 & 64) == 0) goto L25;
        int r2 = 20;
    L26:
        int r13 = 3900000;
        if ((r27 & 128) == 0) goto L29;
        int r19 = 3900000;
    L31:
        if ((r27 & 256) != 0) goto L35;
        r13 = r24;
    L35:
        if ((r27 & 512) == 0) goto L37;
        int r110 = 50;
    L39:
        if ((r27 & 1024) == 0) goto L41;
        com.obric.memorydata.memory.review.trace.k r0 = com.obric.memorydata.memory.review.trace.k.f10498a.a();
    L42:
        this(r1, r3, r4, r5, r6, r12, r2, r19, r13, r110, r0);
        return;
    L41:
        r0 = r26;
        goto L42
    L37:
        r110 = r25;
        goto L39
    L29:
        r19 = r23;
        goto L31
    L25:
        r2 = r22;
        goto L26
    L21:
        r12 = r20;
        goto L23
    L17:
        r6 = r18;
        goto L19
    }

    private final ar a(dh r5, long r6, JSONObject r8) {
        return new ar("memory_trace_" + r5.b() + '_' + r5.a() + '_' + r6, r5.b(), r8);
    }

    private final ax a(ar r12) {
        int r3 = b(r12);
        if (r3 <= this.j) goto L5;
        JSONArray r0 = r12.a().optJSONArray("viewTrees");
        if (r0 == null) goto L25;
        int r4 = r0.length();
        int r5 = 0;
        int r6 = 0;
    L9:
        if (r5 >= r4) goto L24;
        Object r7 = r0.opt(r5);
        if (r7 != null) goto L13;
    L16:
        String r8 = "";
    L18:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L20;
        boolean r9 = true;
    L21:
        if (r9 == false) goto L23;
        r0.put(r5, "");
        r6 = r6 + 1;
    L23:
        r5 = r5 + 1;
        goto L9
    L20:
        r9 = false;
        goto L21
    L13:
        if (Intrinsics.areEqual(r7, JSONObject.NULL) == true) goto L16;
        r8 = r7.toString();
        goto L18
    L24:
        int r10 = r6;
    L26:
        int r11 = b(r12);
        if (r11 > this.j) goto L29;
        boolean r13 = true;
    L31:
        return new ax(r12, r3, r11, r10, r13);
    L29:
        r13 = false;
        goto L31
    L25:
        r10 = 0;
        goto L26
    L5:
        return new ax(r12, r3, r3, 0, true);
    }

    private final List<dh> a(long r10, long r12, int r14) {
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L5
        Object r3 = Result.m1421constructorimpl(((aq) ZeusTransformUtils.preCheckCast(this, aq.class, "com.obric.memorydata.plugin")).f10422b.a(r10, r12, r14));     // Catch: Throwable -> L5
    L7:
        Throwable r4 = Result.m1424exceptionOrNullimpl(r3);
        if (r4 == null) goto L20;
        b("MemoryTraceReportRepository", "trace report query pending failed, try cleanup oversized rows, error=" + r4.getMessage());
        b();
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L13
        Object r9 = Result.m1421constructorimpl(((aq) ZeusTransformUtils.preCheckCast(this, aq.class, "com.obric.memorydata.plugin")).f10422b.a(r10, r12, r14));     // Catch: Throwable -> L13
    L15:
        List r11 = CollectionsKt.emptyList();
        if (Result.m1427isFailureimpl(r9) == false) goto L18;
        r9 = r11;
    L18:
        r3 = (List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin");
    L13:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r9 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L20:
        return (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin");
    L5:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r3 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    private final List<dh> a(String r6) {
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L5
        Object r3 = Result.m1421constructorimpl(((aq) ZeusTransformUtils.preCheckCast(this, aq.class, "com.obric.memorydata.plugin")).f10422b.a(r6));     // Catch: Throwable -> L5
    L7:
        Throwable r4 = Result.m1424exceptionOrNullimpl(r3);
        if (r4 == null) goto L20;
        b("MemoryTraceReportRepository", "trace report query by logId failed, try cleanup oversized rows, logId=" + r6 + ", error=" + r4.getMessage());
        c(r6);
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L13
        Object r7 = Result.m1421constructorimpl(((aq) ZeusTransformUtils.preCheckCast(this, aq.class, "com.obric.memorydata.plugin")).f10422b.a(r6));     // Catch: Throwable -> L13
    L15:
        List r8 = CollectionsKt.emptyList();
        if (Result.m1427isFailureimpl(r7) == false) goto L18;
        r7 = r8;
    L18:
        r3 = (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin");
    L13:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r7 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L20:
        return (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin");
    L5:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r3 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    private final List<dh> a(List<dh> r13) {
        List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        Object r3 = r1.next();
        if (b(((dh) ZeusTransformUtils.preCheckCast(r3, dh.class, "com.obric.memorydata.plugin")).c()) == false) goto L4;
        r2.add(r3);
        goto L4
    L8:
        List r4 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L19;
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L12:
        if (r5.hasNext() == false) goto L14;
        dh r6 = (dh) ZeusTransformUtils.preCheckCast(r5.next(), dh.class, "com.obric.memorydata.plugin");
        b("MemoryTraceReportRepository", "trace report ignored, reason=oversized_data, logId=" + r6.b() + ", id=" + r6.a());
        this.l.a(r6.c());
        goto L12
    L14:
        ao r12 = this.f10422b;
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r9 = r7.iterator();
    L16:
        if (r9.hasNext() == false) goto L18;
        r8.add(Long.valueOf(((dh) ZeusTransformUtils.preCheckCast(r9.next(), dh.class, "com.obric.memorydata.plugin")).a()));
        goto L16
    L18:
        r12.a((List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin"));
    L19:
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin");
        Collection r16 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r17 = r15.iterator();
    L21:
        if (r17.hasNext() == false) goto L39;
        Object r10 = r17.next();
        dh r11 = (dh) ZeusTransformUtils.preCheckCast(r10, dh.class, "com.obric.memorydata.plugin");
        Iterable r18 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin");
        boolean r19 = false;
        if (ZeusTransformUtils.instanceOf(r18, Collection.class) == true) goto L25;
    L27:
        Iterator r20 = r18.iterator();
    L29:
        if (r20.hasNext() == false) goto L36;
        if (((dh) ZeusTransformUtils.preCheckCast(r20.next(), dh.class, "com.obric.memorydata.plugin")).a() != r11.a()) goto L33;
        boolean r21 = true;
    L34:
        if (r21 == false) goto L29;
        r19 = true;
        goto L36
    L33:
        r21 = false;
    L36:
        if (r19 == true) goto L21;
        r16.add(r10);
        goto L21
    L25:
        if (((Collection) ZeusTransformUtils.preCheckCast(r18, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L27;
    L39:
        return (List) ZeusTransformUtils.preCheckCast(r16, List.class, "com.obric.memorydata.plugin");
    }

    private final void a(com.obric.memorydata.memory.inapptrace.f.a.C0499a r2) {
        com.obric.memorydata.memory.inapptrace.f.f10168a.a(r2.b(), r2.c());
    }

    private final int b(ar r1) {
        String r0 = r1.b().toString();
        Intrinsics.checkNotNullExpressionValue(r0, "toString(...)");
        byte[] r2 = r0.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(r2, "getBytes(...)");
        return r2.length;
    }

    private final void b() {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        Object r2 = Result.m1421constructorimpl(Integer.valueOf(((aq) ZeusTransformUtils.preCheckCast(this, aq.class, "com.obric.memorydata.plugin")).f10422b.a(1800000)));     // Catch: Throwable -> L5
    L8:
        if (Result.m1427isFailureimpl(r2) == false) goto L10;
        r2 = 0;
    L10:
        int r0 = ((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.memorydata.plugin")).intValue();
        if (r0 <= 0) goto L16;
        b("MemoryTraceReportRepository", "trace report oversized rows cleaned, count=" + r0);
        return;
    L16:
        return;
    L5:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r2 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    private final void b(String r7, String r8) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        aq r6 = (aq) ZeusTransformUtils.preCheckCast(this, aq.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), r7, r8, false, 4, null);     // Catch: Throwable -> L5
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    }

    private final boolean b(String r2) {
        byte[] r3 = r2.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(r3, "getBytes(...)");
        if (r3.length <= this.i) goto L5;
        return true;
    L5:
        return false;
    }

    private static final long c() {
        return System.currentTimeMillis();
    }

    private final void c(String r5) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        Object r2 = Result.m1421constructorimpl(Integer.valueOf(((aq) ZeusTransformUtils.preCheckCast(this, aq.class, "com.obric.memorydata.plugin")).f10422b.a(r5, 1800000)));     // Catch: Throwable -> L5
    L8:
        if (Result.m1427isFailureimpl(r2) == false) goto L10;
        r2 = 0;
    L10:
        int r0 = ((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.memorydata.plugin")).intValue();
        if (r0 <= 0) goto L16;
        b("MemoryTraceReportRepository", "trace report oversized rows cleaned, logId=" + r5 + ", count=" + r0);
        return;
    L16:
        return;
    L5:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r2 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    /* JADX INFO: renamed from: lambda$aWccKjYT-k9iMinCaxD9QH0s8sA, reason: not valid java name */
    public static /* synthetic */ long m750lambda$aWccKjYTk9iMinCaxD9QH0s8sA() {
        return c();
    }

    public final long a(String r20, String r21) {
        Intrinsics.checkNotNullParameter(r20, "logId");
        Intrinsics.checkNotNullParameter(r21, "reportData");
        if (b(r21) == false) goto L6;
        b("MemoryTraceReportRepository", "trace report skipped, reason=oversized_new_data, logId=" + r20);
        return 0;
    L6:
        Object r15 = m;
        monitor-enter(r15);
        long r7 = ((Number) ZeusTransformUtils.preCheckCast(this.e.invoke(), Number.class, "com.obric.memorydata.plugin")).longValue();     // Catch: Throwable -> L33
        List<dh> r1 = a(a(r20));     // Catch: Throwable -> L33
        if (r1.isEmpty() == false) goto L11;
        long r2 = this.f10422b.insert(new dh(0, r20, r21, r7, true, MemoryTraceReportStatus.PENDING.getKey(), null, 1, null));     // Catch: Throwable -> L33
    L26:
        monitor-exit(r15);
        if (r2 <= 0) goto L30;
        this.d.a(this.f);
    L30:
        return r2;
    L11:
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L33
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10)), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L33
        Iterator r5 = r3.iterator();     // Catch: Throwable -> L33
    L13:
        if (r5.hasNext() == false) goto L15;
        r4.add(((dh) ZeusTransformUtils.preCheckCast(r5.next(), dh.class, "com.obric.memorydata.plugin")).c());     // Catch: Throwable -> L33
        goto L13
    L15:
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L33
        if (r6.hasNext() == false) goto L32;
        Object r8 = r6.next();     // Catch: Throwable -> L33
    L19:
        if (r6.hasNext() == false) goto L21;
        String r9 = (String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L33
        r8 = com.obric.memorydata.memory.review.trace.j.f10497a.b((String) ZeusTransformUtils.preCheckCast(r8, String.class, "com.obric.memorydata.plugin"), r9);     // Catch: Throwable -> L33
        goto L19
    L21:
        String r10 = com.obric.memorydata.memory.review.trace.j.f10497a.b((String) ZeusTransformUtils.preCheckCast(r8, String.class, "com.obric.memorydata.plugin"), r21);     // Catch: Throwable -> L33
        dh r11 = (dh) ZeusTransformUtils.preCheckCast(CollectionsKt.first(r1), dh.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L33
        this.f10422b.a(r11.a(), r10, MemoryTraceReportStatus.PENDING.getKey(), r7);     // Catch: Throwable -> L33
        ao r12 = this.f10422b;     // Catch: Throwable -> L33
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.drop((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin"), 1), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L33
        Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10)), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L33
        Iterator r16 = r13.iterator();     // Catch: Throwable -> L33
    L23:
        if (r16.hasNext() == false) goto L25;
        r14.add(Long.valueOf(((dh) ZeusTransformUtils.preCheckCast(r16.next(), dh.class, "com.obric.memorydata.plugin")).a()));     // Catch: Throwable -> L33
        goto L23
    L25:
        r12.a((List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L33
        r2 = r11.a();     // Catch: Throwable -> L33
        goto L26
    L32:
        throw new UnsupportedOperationException("Empty collection can't be reduced.");     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        throw th;
    }

    public final at a() {
        long r9 = ((Number) ZeusTransformUtils.preCheckCast(this.e.invoke(), Number.class, "com.obric.memorydata.plugin")).longValue();
        List<dh> r0 = a(r9 - this.f, r9 - this.g, this.h);
        List<dh> r1 = a(r0);
        int r2 = r0.size() - r1.size();
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r4 = 0;
        int r5 = r2;
    L4:
        if (r3.hasNext() == false) goto L69;
        dh r6 = (dh) ZeusTransformUtils.preCheckCast(r3.next(), dh.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.memory.inapptrace.f r7 = com.obric.memorydata.memory.inapptrace.f.f10168a;
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L8
        aq r10 = (aq) ZeusTransformUtils.preCheckCast(this, aq.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        Object r11 = Result.m1421constructorimpl(new JSONObject(r6.c()));     // Catch: Throwable -> L8
    L10:
        JSONObject r12 = new JSONObject();
        if (Result.m1427isFailureimpl(r11) == false) goto L13;
        r11 = r12;
    L13:
        com.obric.memorydata.memory.inapptrace.f.a r13 = r7.a((JSONObject) ZeusTransformUtils.preCheckCast(r11, JSONObject.class, "com.obric.memorydata.plugin"));
        if (ZeusTransformUtils.instanceOf(r13, com.obric.memorydata.memory.inapptrace.f.a.b.class) == true) goto L15;
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type com.obric.memorydata.memory.inapptrace.InAppTraceReportAttachmentStore.ResolveResult.Ready");
        com.obric.memorydata.memory.inapptrace.f.a.C0499a r14 = (com.obric.memorydata.memory.inapptrace.f.a.C0499a) ZeusTransformUtils.preCheckCast(r13, com.obric.memorydata.memory.inapptrace.f.a.C0499a.class, "com.obric.memorydata.plugin");
        long r17 = ((Number) ZeusTransformUtils.preCheckCast(this.e.invoke(), Number.class, "com.obric.memorydata.plugin")).longValue();
        Object r15 = m;
        monitor-enter(r15);
        boolean r16 = this.f10422b.a(r6.a(), r6.f(), r6.d(), r17);     // Catch: Throwable -> L65
        monitor-exit(r15);
        if (r16 == false) goto L21;
        com.obric.memorydata.memory.review.trace.k r18 = this.l;
        String r19 = r14.a().toString();
        Intrinsics.checkNotNullExpressionValue(r19, "toString(...)");
        com.obric.memorydata.memory.review.trace.k.b r20 = r18.a(r19, this.j);
        if (ZeusTransformUtils.instanceOf(r20, com.obric.memorydata.memory.review.trace.k.b.a.class) == true) goto L24;
        if (ZeusTransformUtils.instanceOf(r20, com.obric.memorydata.memory.review.trace.k.b.C0515b.class) == true) goto L27;
        if (ZeusTransformUtils.instanceOf(r20, com.obric.memorydata.memory.review.trace.k.b.c.class) == false) goto L64;
        com.obric.memorydata.memory.review.trace.k.b.c r21 = (com.obric.memorydata.memory.review.trace.k.b.c) ZeusTransformUtils.preCheckCast(r20, com.obric.memorydata.memory.review.trace.k.b.c.class, "com.obric.memorydata.plugin");
        if (r21.b() <= 0) goto L38;
        b("MemoryTraceReportRepository", "trace report viewTree files skipped, reason=read_budget, logId=" + r6.b() + ", id=" + r6.a() + ", count=" + r21.b() + ", bytes=" + r21.c() + ", budget=" + this.j);
    L38:
        ax r22 = a(a(r6, r9, r21.a()));
        if (r22.e() == false) goto L40;
        if (r22.d() <= 0) goto L74;
        b("MemoryTraceReportRepository", "trace report viewTrees removed, reason=request_body_budget, logId=" + r6.b() + ", id=" + r6.a() + ", count=" + r22.d() + ", originalBytes=" + r22.b() + ", finalBytes=" + r22.c() + ", maxBytes=" + this.j);
    L74:
        Result.Companion r23 = Result.Companion;     // Catch: Throwable -> L46
        Object r24 = Result.m1421constructorimpl(((aq) ZeusTransformUtils.preCheckCast(this, aq.class, "com.obric.memorydata.plugin")).c.a(r22.a()));     // Catch: Throwable -> L46
    L48:
        Throwable r25 = Result.m1424exceptionOrNullimpl(r24);
        if (r25 == null) goto L55;
        String r26 = r25.getMessage();
        if (r26 != null) goto L54;
        r26 = "memory trace report failed";
    L54:
        r24 = new am(false, r26, 0, null, null, 28, null);
    L55:
        am r27 = (am) ZeusTransformUtils.preCheckCast(r24, am.class, "com.obric.memorydata.plugin");
        if (r27.a() == true) goto L57;
        String r28 = as.f10425a.a(r6.g(), r27.b());
        int r29 = as.f10425a.a(r28);
        if (r29 >= this.k) goto L61;
        r4 = r4 + 1;
        this.f10422b.b(r6.a(), MemoryTraceReportStatus.FAILED.getKey(), r28, ((Number) ZeusTransformUtils.preCheckCast(this.e.invoke(), Number.class, "com.obric.memorydata.plugin")).longValue());
        goto L4
    L61:
        r5 = r5 + 1;
        b("MemoryTraceReportRepository", "trace report ignored, retry exhausted, logId=" + r6.b() + ", id=" + r6.a() + ", count=" + r29);
    L58:
        this.f10422b.a(r6.a());
        this.l.a(r6.c());
    L31:
        a(r14);
        goto L4
    L57:
        r5 = r5 + 1;
    L46:
        th = move-exception;
        Result.Companion r30 = Result.Companion;
        r24 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L48
    L40:
        r5 = r5 + 1;
        b("MemoryTraceReportRepository", "trace report ignored, reason=request_body_oversized, logId=" + r6.b() + ", id=" + r6.a() + ", originalBytes=" + r22.b() + ", finalBytes=" + r22.c() + ", maxBytes=" + this.j + ", droppedViewTreeCount=" + r22.d());
        goto L58
    L64:
        throw new NoWhenBranchMatchedException();
    L27:
        String r31 = as.f10425a.a(r6.g(), "ViewTree file " + ((com.obric.memorydata.memory.review.trace.k.b.C0515b) ZeusTransformUtils.preCheckCast(r20, com.obric.memorydata.memory.review.trace.k.b.C0515b.class, "com.obric.memorydata.plugin")).c() + " failed: path=" + ((com.obric.memorydata.memory.review.trace.k.b.C0515b) ZeusTransformUtils.preCheckCast(r20, com.obric.memorydata.memory.review.trace.k.b.C0515b.class, "com.obric.memorydata.plugin")).b() + ", type=" + ((com.obric.memorydata.memory.review.trace.k.b.C0515b) ZeusTransformUtils.preCheckCast(r20, com.obric.memorydata.memory.review.trace.k.b.C0515b.class, "com.obric.memorydata.plugin")).d() + ", message=" + ((com.obric.memorydata.memory.review.trace.k.b.C0515b) ZeusTransformUtils.preCheckCast(r20, com.obric.memorydata.memory.review.trace.k.b.C0515b.class, "com.obric.memorydata.plugin")).e());
        int r110 = as.f10425a.a(r31);
        if (r110 >= this.k) goto L29;
        r4 = r4 + 1;
        this.f10422b.b(r6.a(), MemoryTraceReportStatus.FAILED.getKey(), r31, ((Number) ZeusTransformUtils.preCheckCast(this.e.invoke(), Number.class, "com.obric.memorydata.plugin")).longValue());
        goto L4
    L29:
        r5 = r5 + 1;
        b("MemoryTraceReportRepository", "trace report ignored, reason=viewTree_file_retry_exhausted, logId=" + r6.b() + ", id=" + r6.a() + ", count=" + r110 + ", operation=" + ((com.obric.memorydata.memory.review.trace.k.b.C0515b) ZeusTransformUtils.preCheckCast(r20, com.obric.memorydata.memory.review.trace.k.b.C0515b.class, "com.obric.memorydata.plugin")).c() + ", path=" + ((com.obric.memorydata.memory.review.trace.k.b.C0515b) ZeusTransformUtils.preCheckCast(r20, com.obric.memorydata.memory.review.trace.k.b.C0515b.class, "com.obric.memorydata.plugin")).b() + ", type=" + ((com.obric.memorydata.memory.review.trace.k.b.C0515b) ZeusTransformUtils.preCheckCast(r20, com.obric.memorydata.memory.review.trace.k.b.C0515b.class, "com.obric.memorydata.plugin")).d());
        this.f10422b.a(r6.a());
        com.obric.memorydata.memory.review.trace.k r32 = this.l;
        List<String> r33 = ((com.obric.memorydata.memory.review.trace.k.b.C0515b) ZeusTransformUtils.preCheckCast(r20, com.obric.memorydata.memory.review.trace.k.b.C0515b.class, "com.obric.memorydata.plugin")).a();
    L30:
        r32.a(r33);
        goto L31
    L24:
        r5 = r5 + 1;
        b("MemoryTraceReportRepository", "trace report ignored, viewTree file missing, logId=" + r6.b() + ", id=" + r6.a());
        this.f10422b.a(r6.a());
        r32 = this.l;
        r33 = ((com.obric.memorydata.memory.review.trace.k.b.a) ZeusTransformUtils.preCheckCast(r20, com.obric.memorydata.memory.review.trace.k.b.a.class, "com.obric.memorydata.plugin")).a();
        goto L30
    L21:
        b("MemoryTraceReportRepository", "trace report skipped, reason=claim_lost, logId=" + r6.b() + ", id=" + r6.a());
    L65:
        th = move-exception;
        throw th;
    L15:
        b("MemoryTraceReportRepository", "trace report deferred, reason=in_app_trace_tos_pending, logId=" + r6.b() + ", observationIds=" + ((com.obric.memorydata.memory.inapptrace.f.a.b) ZeusTransformUtils.preCheckCast(r13, com.obric.memorydata.memory.inapptrace.f.a.b.class, "com.obric.memorydata.plugin")).a() + ", traceRowIds=" + ((com.obric.memorydata.memory.inapptrace.f.a.b) ZeusTransformUtils.preCheckCast(r13, com.obric.memorydata.memory.inapptrace.f.a.b.class, "com.obric.memorydata.plugin")).b());
        this.d.a(((com.obric.memorydata.memory.inapptrace.f.a.b) ZeusTransformUtils.preCheckCast(r13, com.obric.memorydata.memory.inapptrace.f.a.b.class, "com.obric.memorydata.plugin")).c());
    L8:
        th = move-exception;
        Result.Companion r34 = Result.Companion;
        r11 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L10
    L69:
        return new at(r5 + r4, r5, r4);
    }
}
