package com.obric.memorydata.datatransport.manager;

import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.cu;
import kotlinx.coroutines.flow.ae;
import kotlinx.coroutines.flow.ar;
import kotlinx.coroutines.flow.at;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0011\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010%\u001a\u00020&J\u0006\u0010'\u001a\u00020(J\b\u0010)\u001a\u00020(H\u0002J\b\u0010*\u001a\u00020(H\u0002J\u0006\u0010+\u001a\u00020&J\u000e\u0010,\u001a\u00020&H\u0086@¢\u0006\u0002\u0010-J\u000e\u0010.\u001a\u00020(H\u0086@¢\u0006\u0002\u0010-J\u0018\u0010/\u001a\u00020(2\u0006\u00100\u001a\u00020\u00052\u0006\u00101\u001a\u00020&H\u0016J\u0010\u00102\u001a\u00020(2\u0006\u00103\u001a\u000204H\u0016J(\u00105\u001a\u00020(2\u0006\u00106\u001a\u00020\u001e2\u0006\u00107\u001a\u00020\u00052\u0006\u00108\u001a\u00020\u00072\u0006\u00109\u001a\u00020\tH\u0002J\u0010\u0010:\u001a\u00020(2\u0006\u0010;\u001a\u00020\u001cH\u0002J \u0010<\u001a\u00020(2\u0006\u0010;\u001a\u00020\u001c2\u0006\u0010=\u001a\u00020\t2\u0006\u00106\u001a\u00020\u001eH\u0002J\u0018\u0010>\u001a\u00020(2\u0006\u0010;\u001a\u00020\u001c2\u0006\u00106\u001a\u00020\u001eH\u0002J\b\u0010?\u001a\u00020(H\u0002J \u0010@\u001a\u00020(2\u0006\u00107\u001a\u00020\u00052\u0006\u0010A\u001a\u00020\u001c2\u0006\u00106\u001a\u00020\u001eH\u0002J\u0018\u0010B\u001a\u00020(2\u0006\u0010;\u001a\u00020\u001c2\u0006\u0010C\u001a\u00020&H\u0002J)\u0010D\u001a\u00020\u00052\u0006\u0010E\u001a\u00020\u00072\u0012\u0010F\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0G\"\u00020\u000fH\u0002¢\u0006\u0002\u0010HR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\"\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010#R\u000e\u0010$\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lcom/obric/memorydata/datatransport/manager/DataExportTaskController;", "Lcom/obric/memorydata/datatransport/manager/ExportDataManager$ProgressCallback;", "<init>", "()V", "TAG", "", "MAX_AUTOMATIC_RETRY_COUNT", "", "PROGRESS_PERSIST_INTERVAL_MS", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "manager", "Lcom/obric/memorydata/datatransport/manager/ExportDataManager;", "stateLock", "", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/obric/memorydata/datatransport/manager/DataExportTaskState;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "activeJob", "Lkotlinx/coroutines/Job;", "identityRecoveryJob", "recoveryRetryJob", "currentSnapshot", "Lcom/obric/memorydata/datatransport/manager/DataExportTaskSnapshot;", "currentStore", "Lcom/obric/memorydata/datatransport/manager/DataExportTaskStore;", "lastPersistedAt", "lastPersistedPhase", "Lcom/obric/memorydata/datatransport/manager/DataExportPhase;", "lastPersistedPercent", "Ljava/lang/Integer;", "lastPersistedFailureCount", "isExporting", "", "recoverIfNeeded", "", "scheduleIdentityRecovery", "scheduleRecoveryRetry", "startExport", "cleanOldData", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "importToDb", "onProgress", "message", "exporting", "onExportProgress", "progress", "Lcom/obric/memorydata/datatransport/manager/ExportProgress;", "startExportLocked", "taskStore", "taskId", "retryCount", "startedAt", "showInterrupted", "snapshot", "persistProgressIfNeeded", "now", "persist", "resetPersistMarkers", "discardTaskIfCurrent", "fallbackSnapshot", "deleteSnapshotFiles", "includeFinalFile", TypedValues.Custom.S_STRING, "resId", "args", "", "(I[Ljava/lang/Object;)Ljava/lang/String;", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c implements l.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f9761a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final al f9762b = null;
    private static final l c = null;
    private static final Object d = null;
    private static final ae<f> e = null;
    private static final ar<f> f = null;
    private static volatile bx g;
    private static bx h;
    private static bx i;
    private static d j;
    private static h k;
    private static long l;
    private static DataExportPhase m;
    private static Integer n;
    private static long o;

    static {
        c r0 = new c();
        f9761a = r0;
        f9762b = am.a(cu.a(null, 1, null).plus((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")));
        l r1 = new l();
        r1.a((l.b) ZeusTransformUtils.preCheckCast(r0, l.b.class, "com.obric.memorydata.plugin"));
        c = r1;
        d = new Object();
        ae<f> r2 = at.a(f.b.f9769a);
        e = r2;
        f = kotlinx.coroutines.flow.k.a(r2);
    }

    private c() {
    }

    private final String a(int r3, Object... r4) {
        String r2 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(r3, Arrays.copyOf(r4, r4.length));
        Intrinsics.checkNotNullExpressionValue(r2, "getString(...)");
        return r2;
    }

    public static final /* synthetic */ String a(c r0, int r1, Object... r2) {
        return r0.a(r1, r2);
    }

    public static final /* synthetic */ void a(c r2, d r3, h r4) {
        r2.a(r3, (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void a(c r2, String r3, d r4, h r5) {
        r2.a(r3, r4, (h) ZeusTransformUtils.wrapperContextForParams(r5, h.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void a(d r0) {
        j = r0;
    }

    private final void a(d r14, long r15, h r17) {
        h r0 = (h) ZeusTransformUtils.wrapperContextForParams(r17, h.class, "com.obric.memorydata.plugin");
        boolean r4 = true;
        if (r14.c() == m) goto L5;
        boolean r2 = true;
    L7:
        if (r14.e() != null) goto L10;
    L8:
        boolean r3 = false;
    L15:
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r14.k().a(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        long r9 = 0;
    L17:
        if (r6.hasNext() == false) goto L19;
        r9 = r9 + ((k) ZeusTransformUtils.preCheckCast(r6.next(), k.class, "com.obric.memorydata.plugin")).d();
        goto L17
    L19:
        long r11 = o;
        if (r11 != 0) goto L24;
        if (r9 <= 0) goto L24;
    L27:
        if (r2 == true) goto L32;
        if (r3 == true) goto L32;
        if (r4 == true) goto L32;
        if ((r15 - l) >= 2000) goto L32;
        return;
    L32:
        a(r14, r0);
        return;
    L24:
        if ((r9 - r11) >= 100) goto L27;
        r4 = false;
        goto L27
    L10:
        if (n != null) goto L12;
    L11:
        r3 = true;
        goto L15
    L12:
        int r5 = r14.e().intValue();
        Integer r7 = n;
        Intrinsics.checkNotNull(r7);
        if (Math.abs(r5 - r7.intValue()) < 5) goto L8;
    L5:
        r2 = false;
        goto L7
    }

    private final void a(d r4, h r5) {
        ((h) ZeusTransformUtils.wrapperContextForParams(r5, h.class, "com.obric.memorydata.plugin")).a(r4);
        l = r4.h();
        m = r4.c();
        n = r4.e();
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r4.k().a(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        long r6 = 0;
    L4:
        if (r3.hasNext() == false) goto L6;
        r6 = r6 + ((k) ZeusTransformUtils.preCheckCast(r3.next(), k.class, "com.obric.memorydata.plugin")).d();
        goto L4
    L6:
        o = r6;
    }

    private final void a(d r4, boolean r5) {
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r4.i(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r3.hasNext() == false) goto L10;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin");
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L8
        Result.m1421constructorimpl(Boolean.valueOf(new File(r0).delete()));     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L4
    L10:
        if (r5 == false) goto L29;
        w r7 = r4.j();
        if (r7 == null) goto L30;
        String r8 = r7.a();
        if (r8 == null) goto L31;
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L17
        Object r10 = Result.m1421constructorimpl(Boolean.valueOf(new File(r8).delete()));     // Catch: Throwable -> L17
    L19:
        Result.m1420boximpl(r10);
        return;
    L17:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r10 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L19
    L31:
        return;
    L30:
        return;
    }

    public static final /* synthetic */ void a(h r2) {
        k = (h) ZeusTransformUtils.wrapperContextForParams(r2, h.class, "com.obric.memorydata.plugin");
    }

    private final void a(h r25, String r26, int r27, long r28) {
        h r13 = (h) ZeusTransformUtils.wrapperContextForParams(r25, h.class, "com.obric.memorydata.plugin");
        bx r1 = g;
        if (r1 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L10;
        return;
    L10:
        m r3 = m.f9783a.a(com.obric.memorydata.datatransport.api.d.f9726a.c(), r26, !AppContext.INSTANCE.isDebug());
        d r12 = new d(r26, AppContext.INSTANCE.getUserId(), DataExportPhase.PREPARING, a(ZeusTransformUtils.mapRes(R.string.data_transport_data_export_starting, TypedValues.Custom.S_STRING, "data_transport_data_export_starting"), new Object[0]), null, r27, r28, System.currentTimeMillis(), r3.d(), null, null, 1552, null);
        j = r12;
        k = r13;
        k();
        a(r12, r13);
        e.b(new f.d(r12));
        n.f9785a.a();
        bx r0 = kotlinx.coroutines.i.a(f9762b, null, CoroutineStart.LAZY, (Function2) ZeusTransformUtils.preCheckCast(new DataExportTaskController$startExportLocked$job$1(r26, r12, r13, null), Function2.class, "com.obric.memorydata.plugin"), 1, null);
        g = r0;
        r0.s_();
        return;
    L5:
        if (r1.a() != true) goto L7;
        r2 = true;
        goto L8
    }

    private final void a(String r4, d r5, h r6) {
        h r7 = (h) ZeusTransformUtils.wrapperContextForParams(r6, h.class, "com.obric.memorydata.plugin");
        d r0 = j;
        if (r0 != null) goto L5;
    L11:
        a(r5, true);
        r7.b();
        d r3 = j;
        if (r3 == null) goto L14;
        String r8 = r3.a();
    L16:
        if (Intrinsics.areEqual(r8, r4) == false) goto L19;
        j = null;
        k = null;
        e.b(f.b.f9769a);
        return;
    L19:
        return;
    L14:
        r8 = null;
        goto L16
    L5:
        if (Intrinsics.areEqual(r0.a(), r4) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L11;
        r5 = r0;
        goto L11
    }

    public static final /* synthetic */ void a(bx r2) {
        g = (bx) ZeusTransformUtils.wrapperContextForParams(r2, bx.class, "com.obric.memorydata.plugin");
    }

    private final void b(d r19) {
        a(r19, false);
        d r1 = d.a(r19, null, null, DataExportPhase.INTERRUPTED, a(ZeusTransformUtils.mapRes(R.string.data_transport_data_export_interrupted, TypedValues.Custom.S_STRING, "data_transport_data_export_interrupted"), new Object[0]), null, 0, 0, System.currentTimeMillis(), CollectionsKt.emptyList(), null, null, 1651, null);
        j = r1;
        h r2 = k;
        if (r2 != null) goto L5;
        return;
    L5:
        a(r1, r2);
        e.b(new f.c(r1, r1.d()));
    }

    public static final /* synthetic */ l e() {
        return c;
    }

    public static final /* synthetic */ Object f() {
        return d;
    }

    public static final /* synthetic */ ae g() {
        return e;
    }

    public static final /* synthetic */ d h() {
        return j;
    }

    private final void i() {
        bx r7 = h;
        boolean r0 = true;
        if (r7 != null) goto L5;
    L7:
        r0 = false;
    L8:
        if (r0 == false) goto L10;
        return;
    L10:
        h = kotlinx.coroutines.i.a(f9762b, null, null, (Function2) ZeusTransformUtils.preCheckCast(new DataExportTaskController$scheduleIdentityRecovery$1(null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return;
    L5:
        if (r7.a() != true) goto L7;
        goto L7
    }

    private final void j() {
        bx r7 = i;
        boolean r0 = true;
        if (r7 != null) goto L5;
    L7:
        r0 = false;
    L8:
        if (r0 == false) goto L10;
        return;
    L10:
        i = kotlinx.coroutines.i.a(f9762b, null, null, (Function2) ZeusTransformUtils.preCheckCast(new DataExportTaskController$scheduleRecoveryRetry$1(null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return;
    L5:
        if (r7.a() != true) goto L7;
        goto L7
    }

    private final void k() {
        l = 0;
        m = null;
        n = null;
        o = 0;
    }

    public final Object a(Continuation<? super Boolean> r12) {
        Continuation r13 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r13, DataExportTaskController$cleanOldData$1.class) == false) goto L7;
        DataExportTaskController$cleanOldData$1 r0 = (DataExportTaskController$cleanOldData$1) ZeusTransformUtils.preCheckCast(r13, DataExportTaskController$cleanOldData$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        h r11 = (h) ZeusTransformUtils.preCheckCast(r0.L$0, h.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r14);
    L34:
        boolean r15 = ((Boolean) ZeusTransformUtils.preCheckCast(r14, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        if (r15 == false) goto L46;
        Object r3 = d;
        monitor-enter(r3);
        j = null;     // Catch: Throwable -> L42
        k = null;     // Catch: Throwable -> L42
        r11.b();     // Catch: Throwable -> L42
        e.b(f.b.f9769a);     // Catch: Throwable -> L42
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L42
        monitor-exit(r3);
    L42:
        th = move-exception;
        throw th;
    L46:
        return Boxing.boxBoolean(r15);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        if (b() == true) goto L17;
        Object r17 = d;
        monitor-enter(r17);
        h r4 = k;     // Catch: Throwable -> L47
        if (r4 != null) goto L28;
        i r5 = j.a(j.f9778a, AppContext.INSTANCE.getUserId(), AppContext.INSTANCE.isLogin(), null, 4, null);     // Catch: Throwable -> L47
        if (ZeusTransformUtils.instanceOf(r5, i.a.class) == false) goto L25;
        h r18 = ((i.a) ZeusTransformUtils.preCheckCast(r5, i.a.class, "com.obric.memorydata.plugin")).a();     // Catch: Throwable -> L47
    L29:
        monitor-exit(r17);
        l r19 = c;
        r0.L$0 = r18;
        r0.label = 1;
        Object r110 = r19.b(r0);
        if (r110 != r1) goto L33;
        return r1;
    L33:
        h r10 = r18;
        r14 = r110;
        r11 = r10;
        goto L34
    L25:
        Boolean r111 = Boxing.boxBoolean(false);     // Catch: Throwable -> L47
        monitor-exit(r17);
        return r111;
    L28:
        r18 = r4;
    L47:
        th = move-exception;
        throw th;
    L17:
        return Boxing.boxBoolean(false);
    L7:
        r0 = new DataExportTaskController$cleanOldData$1(this, r13);
        goto L8
    }

    public final ar<f> a() {
        return f;
    }

    @Override // com.obric.memorydata.datatransport.manager.l.b
    public void a(o r22) {
        Intrinsics.checkNotNullParameter(r22, "progress");
        Object r2 = d;
        monitor-enter(r2);
        d r3 = j;     // Catch: Throwable -> L16
        if (r3 != null) goto L8;
        monitor-exit(r2);
        return;
    L8:
        long r14 = System.currentTimeMillis();     // Catch: Throwable -> L16
        DataExportPhase r6 = r22.a();     // Catch: Throwable -> L16
        String r7 = r22.b();     // Catch: Throwable -> L16
        Integer r8 = r22.c();     // Catch: Throwable -> L16
        q r1 = r22.d();     // Catch: Throwable -> L16
        if (r1 != null) goto L11;
        r1 = r3.k();     // Catch: Throwable -> L16
    L11:
        d r0 = d.a(r3, null, null, r6, r7, r8, 0, 0, r14, null, null, r1, 867, null);     // Catch: Throwable -> L16
        c r4 = f9761a;     // Catch: Throwable -> L16
        j = r0;     // Catch: Throwable -> L16
        e.b(new f.d(r0));     // Catch: Throwable -> L16
        h r5 = k;     // Catch: Throwable -> L16
        if (r5 == null) goto L14;
        r4.a(r0, r14, r5);     // Catch: Throwable -> L16
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L16
    L14:
        monitor-exit(r2);
        return;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.memorydata.datatransport.manager.l.b
    public void a(String r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "message");
    }

    public final Object b(Continuation<? super Unit> r2) {
        Continuation<? super Unit> r1 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r2, Continuation.class, "com.obric.memorydata.plugin");
        Object r3 = c.a(r1);
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r3;
    L6:
        return Unit.INSTANCE;
    }

    public final boolean b() {
        bx r2 = g;
        if (r2 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == false) goto L10;
        return true;
    L10:
        if (c.a() == false) goto L13;
        return true;
    L13:
        return false;
    L5:
        if (r2.a() != true) goto L7;
        r3 = true;
        goto L8
    }

    public final void c() {
        Object r13 = d;
        monitor-enter(r13);
        String r0 = AppContext.INSTANCE.getUserId();     // Catch: Throwable -> L94
        i r1 = j.a(j.f9778a, r0, AppContext.INSTANCE.isLogin(), null, 4, null);     // Catch: Throwable -> L94
        if (Intrinsics.areEqual(r1, i.b.f9776a) == false) goto L8;
        f9761a.i();     // Catch: Throwable -> L94
    L89:
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L94
        monitor-exit(r13);
        return;
    L8:
        if (Intrinsics.areEqual(r1, i.c.f9777a) == false) goto L11;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "DataExportTask", "personal store is unavailable; defer export recovery", null, 4, null);     // Catch: Throwable -> L94
        f9761a.j();     // Catch: Throwable -> L94
        goto L89
    L11:
        if (ZeusTransformUtils.instanceOf(r1, i.a.class) == false) goto L93;
        h r3 = ((i.a) ZeusTransformUtils.preCheckCast(r1, i.a.class, "com.obric.memorydata.plugin")).a();     // Catch: Throwable -> L94
        d r4 = j;     // Catch: Throwable -> L94
        boolean r5 = false;
        if (r4 != null) goto L15;
    L32:
        d r6 = r3.a();     // Catch: Throwable -> L94
        if (r6 == null) goto L89;
        c r7 = f9761a;     // Catch: Throwable -> L94
        k = r3;     // Catch: Throwable -> L94
        w r8 = r6.j();     // Catch: Throwable -> L94
        if (r8 == null) goto L47;
        String r9 = r8.a();     // Catch: Throwable -> L94
        if (r9 == null) goto L47;
        File r10 = new File(r9);     // Catch: Throwable -> L94
        if (r10.isFile() == true) goto L42;
    L44:
        boolean r11 = false;
    L45:
        if (r11 != true) goto L47;
        boolean r12 = true;
    L48:
        b r14 = b.f9759a;     // Catch: Throwable -> L94
        bx r15 = g;     // Catch: Throwable -> L94
        if (r15 != null) goto L51;
    L53:
        boolean r16 = false;
    L54:
        a r17 = r14.a(r6, r0, r12, r16);     // Catch: Throwable -> L94
        if (Intrinsics.areEqual(r17, a.g.f9758a) == false) goto L58;
        r7.i();     // Catch: Throwable -> L94
        goto L89
    L58:
        if (Intrinsics.areEqual(r17, a.b.f9753a) == true) goto L89;
        if (Intrinsics.areEqual(r17, a.e.f9756a) == false) goto L68;
        w r18 = r6.j();     // Catch: Throwable -> L94
        if (r18 == null) goto L89;
        s r19 = r18.b();     // Catch: Throwable -> L94
        if (r19 == null) goto L89;
        j = r6;     // Catch: Throwable -> L94
        e.b(new f.e(r6, r19));     // Catch: Throwable -> L94
        goto L89
    L68:
        if (Intrinsics.areEqual(r17, a.d.f9755a) == false) goto L71;
        j = r6;     // Catch: Throwable -> L94
        e.b(new f.a(r6, r6.d()));     // Catch: Throwable -> L94
        goto L89
    L71:
        if (Intrinsics.areEqual(r17, a.f.f9757a) == false) goto L74;
        r7.b(r6);     // Catch: Throwable -> L94
        goto L89
    L74:
        if (Intrinsics.areEqual(r17, a.C0473a.f9752a) == false) goto L85;
        if (Intrinsics.areEqual(r6.b(), r0) == true) goto L81;
        bx r20 = g;     // Catch: Throwable -> L94
        if (r20 == null) goto L81;
        r20.a(new CancellationException("data export account changed"));     // Catch: Throwable -> L94
    L81:
        if (Intrinsics.areEqual(r6.b(), r0) == true) goto L83;
        r5 = true;
    L83:
        r7.a(r6, r5);     // Catch: Throwable -> L94
        j = null;     // Catch: Throwable -> L94
        k = null;     // Catch: Throwable -> L94
        r3.b();     // Catch: Throwable -> L94
        e.b(f.b.f9769a);     // Catch: Throwable -> L94
        goto L89
    L85:
        if (ZeusTransformUtils.instanceOf(r17, a.c.class) == false) goto L88;
        r7.a(r6, false);     // Catch: Throwable -> L94
        r7.a(r3, r6.a(), RangesKt.coerceAtMost(((a.c) ZeusTransformUtils.preCheckCast(r17, a.c.class, "com.obric.memorydata.plugin")).a(), 1), r6.g());     // Catch: Throwable -> L94
        goto L89
    L88:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L94
    L51:
        if (r15.a() != true) goto L53;
        r16 = true;
        goto L54
    L42:
        if (r10.length() <= 0) goto L44;
        r11 = true;
    L47:
        r12 = false;
        goto L48
    L15:
        if (Intrinsics.areEqual(r4.b(), r0) == true) goto L32;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "DataExportTask", "discard in-memory export after account changed: taskId=" + r4.a(), null, 4, null);     // Catch: Throwable -> L94
        bx r21 = g;     // Catch: Throwable -> L94
        if (r21 == null) goto L19;
        r21.a(new CancellationException("data export account changed"));     // Catch: Throwable -> L94
    L19:
        c r22 = f9761a;     // Catch: Throwable -> L94
        r22.a(r4, true);     // Catch: Throwable -> L94
        h r23 = k;     // Catch: Throwable -> L94
        if (r23 == null) goto L22;
        r23.b();     // Catch: Throwable -> L94
    L22:
        j = null;     // Catch: Throwable -> L94
        k = null;     // Catch: Throwable -> L94
        e.b(f.b.f9769a);     // Catch: Throwable -> L94
        bx r24 = g;     // Catch: Throwable -> L94
        if (r24 != null) goto L25;
    L27:
        boolean r25 = false;
    L28:
        if (r25 == false) goto L30;
    L31:
        r22.j();     // Catch: Throwable -> L94
        goto L89
    L30:
        if (c.a() == false) goto L32;
    L25:
        if (r24.a() != true) goto L27;
        r25 = true;
        goto L28
    L93:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L94
    L94:
        th = move-exception;
        throw th;
    }

    public final boolean d() {
        Object r9 = d;
        monitor-enter(r9);
        c r0 = f9761a;     // Catch: Throwable -> L13
        boolean r2 = false;
        if (r0.b() == true) goto L11;
        i r1 = j.a(j.f9778a, AppContext.INSTANCE.getUserId(), AppContext.INSTANCE.isLogin(), null, 4, null);     // Catch: Throwable -> L13
        if (ZeusTransformUtils.instanceOf(r1, i.a.class) == false) goto L11;
        r0.a(((i.a) ZeusTransformUtils.preCheckCast(r1, i.a.class, "com.obric.memorydata.plugin")).a(), String.valueOf(System.currentTimeMillis()), 0, System.currentTimeMillis());     // Catch: Throwable -> L13
        r2 = true;
    L11:
        monitor-exit(r9);
        return r2;
    L13:
        th = move-exception;
        throw th;
    }
}
