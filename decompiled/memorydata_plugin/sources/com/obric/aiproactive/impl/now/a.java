package com.obric.aiproactive.impl.now;

import android.content.Context;
import com.obric.aiproactive.api.ProactiveNowPageSnapshot;
import com.obric.aiproactive.api.ProactiveRecommendationEnabledStore;
import com.obric.aiproactive.api.ae;
import com.obric.aiproactive.impl.trigger.e;
import com.obric.memorydata.database.dao.ProactiveInspirationRecommendationRow;
import com.obric.memorydata.database.manager.proactive.ProactiveRecommendationDb;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.task.impl.TaskResult;
import com.ttnet.org.chromium.net.impl.URLDispatch;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
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
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.cu;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u00017B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u000eJ\u000e\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u000eJ\b\u0010\u001f\u001a\u0004\u0018\u00010\u0005J\r\u0010 \u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u0010!J\u0010\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\u0011H\u0002J\u0014\u0010$\u001a\u00020\u001b2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00160&J&\u0010'\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00162\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00160&H\u0002J\u0010\u0010,\u001a\u00020\u00162\u0006\u0010*\u001a\u00020\u0016H\u0002J\u0010\u0010-\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020/H\u0002J\u0018\u00100\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020/H\u0002J\u001e\u00101\u001a\u00020\u00112\u0006\u0010*\u001a\u00020\u00162\u0006\u00102\u001a\u000203H\u0082@¢\u0006\u0002\u00104J\n\u00105\u001a\u0004\u0018\u00010)H\u0002J\u0010\u00106\u001a\u00020/2\u0006\u0010*\u001a\u00020\u0016H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/obric/aiproactive/impl/now/NowRecommendationsHub;", "", "<init>", "()V", "TAG", "", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "currentEpoch", "Ljava/util/concurrent/atomic/AtomicLong;", "listeners", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lcom/obric/aiproactive/impl/now/NowSnapshotListener;", "lock", "enabled", "", "latestSnapshot", "Lcom/obric/aiproactive/impl/now/NowRecommendationsHub$CachedSnapshot;", "latestCandidateSetKey", "latestTopInspirationRowId", "", "Ljava/lang/Long;", "enabledListener", "Lcom/obric/aiproactive/api/ProactiveRecommendationEnabledListener;", "ensureInitialized", "", "registerListener", "listener", "unregisterListener", "currentCandidateSetKey", "currentTopInspirationRowId", "()Ljava/lang/Long;", "onEnabledChanged", "nextEnabled", "refreshNowInspirations", "inspirationRowIds", "", "handleRefreshRows", "db", "Lcom/obric/memorydata/database/manager/proactive/ProactiveRecommendationDb;", URLDispatch.KEY_EPOCH, "requestedRowIds", "nextBatchIdLocked", "dispatchAll", "snapshot", "Lcom/obric/aiproactive/api/ProactiveNowPageSnapshot;", "dispatchSingle", "refreshNowCandidatesWithRetry", "retryCount", "", "(JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "proactiveDb", "emptySnapshot", "CachedSnapshot", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6490a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f6491b = null;
    private static final al c = null;
    private static final AtomicLong d = null;
    private static final CopyOnWriteArraySet<c> e = null;
    private static final Object f = null;
    private static volatile boolean g;
    private static volatile C0285a h;
    private static volatile String i;
    private static volatile Long j;
    private static final ae k = null;

    /* JADX INFO: renamed from: com.obric.aiproactive.impl.now.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/obric/aiproactive/impl/now/NowRecommendationsHub$CachedSnapshot;", "", "snapshot", "Lcom/obric/aiproactive/api/ProactiveNowPageSnapshot;", URLDispatch.KEY_EPOCH, "", "contentSignature", "<init>", "(Lcom/obric/aiproactive/api/ProactiveNowPageSnapshot;JJ)V", "getSnapshot", "()Lcom/obric/aiproactive/api/ProactiveNowPageSnapshot;", "getEpoch", "()J", "getContentSignature", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class C0285a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProactiveNowPageSnapshot f6492a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f6493b;
        private final long c;

        public C0285a(ProactiveNowPageSnapshot r2, long r3, long r5) {
            Intrinsics.checkNotNullParameter(r2, "snapshot");
            this.f6492a = r2;
            this.f6493b = r3;
            this.c = r5;
        }

        public final ProactiveNowPageSnapshot a() {
            return this.f6492a;
        }

        public final long b() {
            return this.f6493b;
        }

        public final long c() {
            return this.c;
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, C0285a.class) == true) goto L8;
            return false;
        L8:
            C0285a r10 = (C0285a) ZeusTransformUtils.preCheckCast(r9, C0285a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f6492a, r10.f6492a) == true) goto L12;
            return false;
        L12:
            if (this.f6493b == r10.f6493b) goto L15;
            return false;
        L15:
            if (this.c == r10.c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f6492a.hashCode() * 31) + Long.hashCode(this.f6493b)) * 31) + Long.hashCode(this.c);
        }

        public String toString() {
            return "CachedSnapshot(snapshot=" + this.f6492a + ", epoch=" + this.f6493b + ", contentSignature=" + this.c + ')';
        }
    }

    static {
        f6490a = new a();
        f6491b = new AtomicBoolean(false);
        c = am.a(cu.a(null, 1, null).plus((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")));
        d = new AtomicLong(0);
        e = new CopyOnWriteArraySet();
        f = new Object();
        i = "";
        k = $$Lambda$a$Yw_q5TndtDvLYMQmjDIkomTFhA.INSTANCE;
    }

    private a() {
    }

    private final long a(long r5) {
        long r4 = Math.max(1, (r5 & 2147483647L) << 32);
        C0285a r6 = h;
        if (r6 == null) goto L7;
        ProactiveNowPageSnapshot r7 = r6.a();
        if (r7 == null) goto L7;
        long r2 = r7.getBatchId();
    L9:
        return Math.max(r4, r2 + 1);
    L7:
        r2 = r4 - 1;
        goto L9
    }

    public static final /* synthetic */ ProactiveNowPageSnapshot a(a r0, long r1) {
        return r0.b(r1);
    }

    public static final /* synthetic */ ProactiveRecommendationDb a(a r0) {
        return r0.g();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0087 -> B:24:0x0090). Please report as a decompilation issue!!! */
    private final Object a(long r24, int r26, Continuation<? super Boolean> r27) {
        Continuation r0 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r27, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, NowRecommendationsHub$refreshNowCandidatesWithRetry$1.class) == false) goto L7;
        NowRecommendationsHub$refreshNowCandidatesWithRetry$1 r2 = (NowRecommendationsHub$refreshNowCandidatesWithRetry$1) ZeusTransformUtils.preCheckCast(r0, NowRecommendationsHub$refreshNowCandidatesWithRetry$1.class, "com.obric.memorydata.plugin");
        if ((r2.label & Integer.MIN_VALUE) == 0) goto L7;
        r2.label -= Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r2.label;
        int r5 = 1;
        if (r4 == 0) goto L18;
        if (r4 != 1) goto L17;
        int r6 = r2.I$2;
        int r7 = r2.I$1;
        int r8 = r2.I$0;
        long r9 = r2.J$0;
        Ref.BooleanRef r10 = (Ref.BooleanRef) ZeusTransformUtils.preCheckCast(r2.L$0, Ref.BooleanRef.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r1);     // Catch: Throwable -> L14
    L24:
        Object r11 = Result.m1421constructorimpl((TaskResult) ZeusTransformUtils.preCheckCast(r1, TaskResult.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L14
    L29:
        long r21 = r9;
        NowRecommendationsHub$refreshNowCandidatesWithRetry$1 r12 = r2;
        Object r13 = r3;
        long r14 = r21;
        Throwable r15 = Result.m1424exceptionOrNullimpl(r11);
        if (r15 == null) goto L33;
        RunLog.INSTANCE.error("NowRecommendationsHub", "refreshNowInspirationCandidates failed epoch=" + r14 + " attempt=" + (r6 + 1) + '/' + r8, r15);
    L33:
        if (Result.m1427isFailureimpl(r11) == false) goto L35;
        r11 = null;
    L35:
        TaskResult r16 = (TaskResult) ZeusTransformUtils.preCheckCast(r11, TaskResult.class, "com.obric.memorydata.plugin");
        if (b.a(r16) == false) goto L42;
        IRunLog r17 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r18 = new StringBuilder().append("refreshNowInspirationCandidates success epoch=").append(r14).append(" attempt=").append(r6 + 1).append('/').append(r8).append(" code=");
        if (r16 == null) goto L40;
        Object r19 = Boxing.boxInt(r16.getCode());
    L41:
        IRunLog.a.a(r17, "NowRecommendationsHub", r18.append(r19).toString(), false, 4, null);
        int r20 = 1;
        r10.element = true;
    L51:
        int r22 = r7 + 1;
        r5 = r20;
        int r23 = r8;
        NowRecommendationsHub$refreshNowCandidatesWithRetry$1 r25 = r12;
        Object r28 = r13;
        int r29 = r22;
    L19:
        if (r29 >= r23) goto L53;
        Result.Companion r30 = Result.Companion;     // Catch: Throwable -> L26
        e r31 = e.f6532a;     // Catch: Throwable -> L26
        r25.L$0 = r10;     // Catch: Throwable -> L26
        r25.J$0 = r14;     // Catch: Throwable -> L26
        r25.I$0 = r23;     // Catch: Throwable -> L26
        r25.I$1 = r29;     // Catch: Throwable -> L26
        r25.I$2 = r29;     // Catch: Throwable -> L26
        r25.label = r5;     // Catch: Throwable -> L26
        r1 = r31.b(r25);     // Catch: Throwable -> L26
        if (r1 != r28) goto L23;
        return r28;
    L23:
        Object r210 = r28;
        r8 = r23;
        r6 = r29;
        r9 = r14;
        r2 = r25;
        r3 = r210;
        r7 = r6;
    L26:
        th = move-exception;
        Object r211 = r28;
        r8 = r23;
        r6 = r29;
        r9 = r14;
        r2 = r25;
        r3 = r211;
        r7 = r6;
        Result.Companion r110 = Result.Companion;
        r11 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L29
    L53:
        return Boxing.boxBoolean((r10.element ? 1 : 0) ^ r5);
    L40:
        r19 = null;
        goto L41
    L42:
        IRunLog r111 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r32 = new StringBuilder().append("refreshNowInspirationCandidates retry epoch=").append(r14).append(" attempt=").append(r6 + 1).append('/').append(r8).append(" code=");
        if (r16 == null) goto L45;
        Object r33 = Boxing.boxInt(r16.getCode());
    L46:
        StringBuilder r34 = r32.append(r33).append(" msg=");
        if (r16 == null) goto L49;
        String r112 = r16.getMsg();
    L50:
        IRunLog.a.a(r111, "NowRecommendationsHub", r34.append(r112).toString(), null, 4, null);
        r20 = 1;
        goto L51
    L49:
        r112 = null;
        goto L50
    L45:
        r33 = null;
    L14:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r11 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L29
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r1);
        r10 = new Ref.BooleanRef();
        r25 = r2;
        r28 = r3;
        r29 = 0;
        r14 = r24;
        r23 = r26;
    L7:
        r2 = new NowRecommendationsHub$refreshNowCandidatesWithRetry$1(this, r0);
        goto L8
    }

    public static final /* synthetic */ Object a(a r2, long r3, int r5, Continuation r6) {
        return r2.a(r3, r5, (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private final void a(ProactiveNowPageSnapshot r4) {
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(e, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        c r0 = (c) ZeusTransformUtils.preCheckCast(r3.next(), c.class, "com.obric.memorydata.plugin");
        a r2 = f6490a;
        Intrinsics.checkNotNull(r0);
        r2.a(r0, r4);
        goto L4
    }

    public static final /* synthetic */ void a(C0285a r0) {
        h = r0;
    }

    public static final /* synthetic */ void a(a r0, ProactiveNowPageSnapshot r1) {
        r0.a(r1);
    }

    public static final /* synthetic */ void a(a r2, ProactiveRecommendationDb r3, long r4, List r6) {
        r2.a(r3, r4, (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin"));
    }

    private final void a(c r4, ProactiveNowPageSnapshot r5) {
        c r6 = (c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.memorydata.plugin");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        a r3 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        r6.onSnapshot(r5);     // Catch: Throwable -> L5
        Object r7 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r8 = Result.m1424exceptionOrNullimpl(r7);
        if (r8 == null) goto L13;
        RunLog.INSTANCE.warn("NowRecommendationsHub", "dispatchSingle failed batchId=" + r5.getBatchId(), r8);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r7 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    private final void a(ProactiveRecommendationDb r18, long r19, List<Long> r21) {
        List<Long> r0 = (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.memorydata.plugin");
        RunLog.INSTANCE.debug("NowRecommendationsHub", "handleRefreshRows start epoch=" + r19 + " requested=" + r0.size());
        List<ProactiveInspirationRecommendationRow> r9 = b.a(r0, r18.proactiveInspirationDao().listJoinedRowsByIds(r0));
        List<ProactiveInspirationRecommendationRow> r10 = b.a(r9, System.currentTimeMillis());
        Long r1 = b.a(r10);
        IRunLog r11 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r2 = new StringBuilder().append("handleRefreshRows resolved epoch=").append(r19).append(" requestedIds=").append(CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin"), 5)).append(" resolvedRowIds=");
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r5.add(Long.valueOf(((ProactiveInspirationRecommendationRow) ZeusTransformUtils.preCheckCast(r4.next(), ProactiveInspirationRecommendationRow.class, "com.obric.memorydata.plugin")).getInspirationRowId()));
        goto L4
    L6:
        StringBuilder r6 = r2.append(CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), 5)).append(" activeRowIds=");
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r12 = r7.iterator();
    L8:
        if (r12.hasNext() == false) goto L10;
        r8.add(Long.valueOf(((ProactiveInspirationRecommendationRow) ZeusTransformUtils.preCheckCast(r12.next(), ProactiveInspirationRecommendationRow.class, "com.obric.memorydata.plugin")).getInspirationRowId()));
        goto L8
    L10:
        StringBuilder r13 = r6.append(CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), 5)).append(" recommendIds=");
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin");
        Collection r15 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r16 = r14.iterator();
    L12:
        if (r16.hasNext() == false) goto L14;
        r15.add(((ProactiveInspirationRecommendationRow) ZeusTransformUtils.preCheckCast(r16.next(), ProactiveInspirationRecommendationRow.class, "com.obric.memorydata.plugin")).getRecommendId());
        goto L12
    L14:
        StringBuilder r17 = r13.append(CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), 5)).append(" inspirationIds=");
        Iterable r20 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin");
        Collection r22 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r20, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r23 = r20.iterator();
    L16:
        if (r23.hasNext() == false) goto L18;
        r22.add(((ProactiveInspirationRecommendationRow) ZeusTransformUtils.preCheckCast(r23.next(), ProactiveInspirationRecommendationRow.class, "com.obric.memorydata.plugin")).getInspirationId());
        goto L16
    L18:
        IRunLog.a.a(r11, "NowRecommendationsHub", r17.append(CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r22, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), 5)).toString(), false, 4, null);
        if (r9.size() == r0.size()) goto L21;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "NowRecommendationsHub", "handleRefreshRows missingRows epoch=" + r19 + " requested=" + r0.size() + " resolved=" + r9.size(), null, 4, null);
    L21:
        Object r110 = f;
        monitor-enter(r110);
    L54:
        th = move-exception;
        throw th;
    L24:
        if (g == true) goto L26;
    L51:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "NowRecommendationsHub", "handleRefreshRows dropStale epoch=" + r19 + " currentEpoch=" + d.get() + " enabled=" + g, false, 4, null);     // Catch: Throwable -> L54
        monitor-exit(r110);
        return;
    L26:
        if (d.get() != r19) goto L51;
        a r24 = f6490a;     // Catch: Throwable -> L54
        j = r1;     // Catch: Throwable -> L54
        long r111 = b.c(r10);     // Catch: Throwable -> L54
        C0285a r25 = h;     // Catch: Throwable -> L54
        if (r25 != null) goto L31;
    L43:
        long r26 = r24.a(r19);     // Catch: Throwable -> L54
        Iterable r27 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L54
        Collection r28 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r27, 10)), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L54
        Iterator r29 = r27.iterator();     // Catch: Throwable -> L54
    L45:
        if (r29.hasNext() == false) goto L47;
        r28.add(b.a((ProactiveInspirationRecommendationRow) ZeusTransformUtils.preCheckCast(r29.next(), ProactiveInspirationRecommendationRow.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L54
        goto L45
    L47:
        ProactiveNowPageSnapshot r112 = new ProactiveNowPageSnapshot(r26, false, (List) ZeusTransformUtils.preCheckCast(r28, List.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L54
        h = new C0285a(r112, r19, r111);     // Catch: Throwable -> L54
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "NowRecommendationsHub", "handleRefreshRows dispatch epoch=" + r19 + " batchId=" + r112.getBatchId() + " requested=" + r0.size() + " resolved=" + r9.size() + " active=" + r10.size(), false, 4, null);     // Catch: Throwable -> L54
        monitor-exit(r110);
        a(r112);
        return;
    L31:
        if (r25.b() == r19) goto L33;
    L35:
        boolean r30 = false;
    L36:
        if (r30 == true) goto L39;
        r25 = null;
    L39:
        if (r25 == null) goto L43;
        RunLog.INSTANCE.debug("NowRecommendationsHub", "handleRefreshRows skipSameContent epoch=" + r19 + " batchId=" + r25.a().getBatchId());     // Catch: Throwable -> L54
        monitor-exit(r110);
        return;
    L33:
        if (r25.c() != r111) goto L35;
        r30 = true;
        goto L36
    }

    private final void a(boolean r13) {
        Object r12 = f;
        monitor-enter(r12);
    L24:
        th = move-exception;
        throw th;
    L5:
        if (g != r13) goto L11;
        AtomicLong r0 = d;     // Catch: Throwable -> L24
        if (r0.get() <= 0) goto L11;
        RunLog.INSTANCE.debug("NowRecommendationsHub", "onEnabledChanged ignored enabled=" + g + " epoch=" + r0.get());     // Catch: Throwable -> L24
        monitor-exit(r12);
        return;
    L11:
        a r1 = f6490a;     // Catch: Throwable -> L24
        g = r13;     // Catch: Throwable -> L24
        long r4 = d.incrementAndGet();     // Catch: Throwable -> L24
        h = null;     // Catch: Throwable -> L24
        if (r13 == true) goto L16;
        i = "";     // Catch: Throwable -> L24
        j = null;     // Catch: Throwable -> L24
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "NowRecommendationsHub", "onEnabledChanged disabled epoch=" + r4 + " listenerSize=" + e.size(), false, 4, null);     // Catch: Throwable -> L24
        r1.a(r1.b(r4));     // Catch: Throwable -> L24
        monitor-exit(r12);
        return;
    L16:
        List r14 = b.a();     // Catch: Throwable -> L24
        i = b.b(r14);     // Catch: Throwable -> L24
        j = (Long) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r14), Long.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "NowRecommendationsHub", "onEnabledChanged enabled epoch=" + r4 + " restoredSize=" + r14.size(), false, 4, null);     // Catch: Throwable -> L24
        if (r14.isEmpty() == false) goto L21;
        ProactiveNowPageSnapshot r15 = r1.b(r4);     // Catch: Throwable -> L24
        h = new C0285a(r15, r4, 0);     // Catch: Throwable -> L24
        r1.a(r15);     // Catch: Throwable -> L24
        monitor-exit(r12);
        return;
    L21:
        i.a(c, null, null, (Function2) ZeusTransformUtils.preCheckCast(new NowRecommendationsHub$onEnabledChanged$1$1(r4, r14, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);     // Catch: Throwable -> L24
        monitor-exit(r12);
    }

    private final ProactiveNowPageSnapshot b(long r3) {
        return new ProactiveNowPageSnapshot(Math.max(1, (r3 & 2147483647L) << 32), false, CollectionsKt.emptyList());
    }

    public static final /* synthetic */ Object b() {
        return f;
    }

    private static final void b(boolean r1) {
        f6490a.a(r1);
    }

    public static final /* synthetic */ boolean c() {
        return g;
    }

    public static final /* synthetic */ AtomicLong d() {
        return d;
    }

    public static final /* synthetic */ CopyOnWriteArraySet e() {
        return e;
    }

    public static final /* synthetic */ C0285a f() {
        return h;
    }

    private final ProactiveRecommendationDb g() {
        return com.obric.memorydata.database.manager.proactive.a.f9590a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: lambda$Yw_q5Tn-dtDvLYMQmjDIkomTFhA, reason: not valid java name */
    public static /* synthetic */ void m238lambda$Yw_q5TndtDvLYMQmjDIkomTFhA(boolean r0) {
        b(r0);
    }

    public final void a() {
        if (f6491b.compareAndSet(false, true) == true) goto L6;
        RunLog.INSTANCE.debug("NowRecommendationsHub", "ensureInitialized ignored alreadyInitialized=true");
        return;
    L6:
        ProactiveRecommendationEnabledStore.INSTANCE.registerListener(k, true);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "NowRecommendationsHub", "ensureInitialized done", false, 4, null);
    }

    public final void a(c r24) {
        c r0 = (c) ZeusTransformUtils.wrapperContextForParams(r24, c.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r0, "listener");
        a();
        CopyOnWriteArraySet<c> r1 = e;
        r1.add(r0);
        IRunLog r3 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r2 = new StringBuilder().append("registerListener size=").append(r1.size()).append(" enabled=").append(g).append(" hasCache=");
        boolean r9 = true;
        if (h == null) goto L5;
        boolean r4 = true;
    L6:
        IRunLog.a.a(r3, "NowRecommendationsHub", r2.append(r4).toString(), false, 4, null);
        Object r5 = f;
        monitor-enter(r5);
    L26:
        th = move-exception;
        throw th;
    L9:
        if (g == true) goto L13;
        IRunLog r6 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L26
        StringBuilder r7 = new StringBuilder().append("registerListener dispatchDisabledEmpty epoch=");     // Catch: Throwable -> L26
        AtomicLong r11 = d;     // Catch: Throwable -> L26
        IRunLog.a.a(r6, "NowRecommendationsHub", r7.append(RangesKt.coerceAtLeast(r11.get(), 1)).toString(), false, 4, null);     // Catch: Throwable -> L26
        a r8 = f6490a;     // Catch: Throwable -> L26
        r8.a(r0, r8.b(RangesKt.coerceAtLeast(r11.get(), 1)));     // Catch: Throwable -> L26
        monitor-exit(r5);
        return;
    L13:
        long r10 = RangesKt.coerceAtLeast(d.get(), 1);     // Catch: Throwable -> L26
        C0285a r12 = h;     // Catch: Throwable -> L26
        if (r12 == null) goto L16;
        ProactiveNowPageSnapshot r13 = r12.a();     // Catch: Throwable -> L26
    L17:
        if (r13 == null) goto L19;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "NowRecommendationsHub", "registerListener dispatchCurrentCache batchId=" + r13.getBatchId(), false, 4, null);     // Catch: Throwable -> L26
        f6490a.a(r0, r13);     // Catch: Throwable -> L26
    L19:
        IRunLog r14 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L26
        StringBuilder r15 = new StringBuilder().append("registerListener skipInitialCache hasCache=");     // Catch: Throwable -> L26
        if (h != null) goto L23;
        r9 = false;
    L23:
        IRunLog.a.a(r14, "NowRecommendationsHub", r15.append(r9).append(" epoch=").append(r10).append(" waitingForFreshRefresh=true").toString(), false, 4, null);     // Catch: Throwable -> L26
        i.a(c, null, null, (Function2) ZeusTransformUtils.preCheckCast(new NowRecommendationsHub$registerListener$1$1(r10, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);     // Catch: Throwable -> L26
        monitor-exit(r5);
        return;
    L16:
        r13 = null;
        goto L17
    L5:
        r4 = false;
        goto L6
    }

    public final void b(c r7) {
        c r6 = (c) ZeusTransformUtils.wrapperContextForParams(r7, c.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "listener");
        CopyOnWriteArraySet<c> r8 = e;
        r8.remove(r6);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "NowRecommendationsHub", "unregisterListener size=" + r8.size(), false, 4, null);
    }
}
