package com.obric.aiproactive.impl.all;

import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.obric.aiproactive.api.ProactiveAllPageSnapshot;
import com.obric.memorydata.memory.island.gr.IslandSession;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.ttnet.org.chromium.net.impl.URLDispatch;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.al;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.channels.i;
import kotlinx.coroutines.channels.l;
import kotlinx.coroutines.channels.m;
import kotlinx.coroutines.channels.z;
import kotlinx.coroutines.da;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\t\b\u0000\u0018\u0000 O2\u00020\u0001:\u0003OPQBç\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\"\u0010\u0007\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b\u0012.\u0010\u000b\u001a*\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\f\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0005\u0012\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0010\u0012\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\u0012\u0012\u001a\b\u0002\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\r0\b¢\u0006\u0004\b\u0019\u0010\u001aJ\u000e\u0010(\u001a\u00020\r2\u0006\u0010)\u001a\u00020!J\u000e\u0010*\u001a\u00020\r2\u0006\u0010)\u001a\u00020!J\u000e\u0010+\u001a\u00020\r2\u0006\u0010,\u001a\u00020\u0006J\u0016\u0010-\u001a\u00020\r2\u0006\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\nJ\u0006\u00100\u001a\u00020\rJ\u0010\u00101\u001a\u00020\r2\u0006\u0010.\u001a\u00020\u0006H\u0002J\b\u00102\u001a\u00020\rH\u0002J\b\u00103\u001a\u00020\rH\u0002J,\u00104\u001a\u00020\r2\u0006\u00105\u001a\u00020\u00102\u0006\u0010.\u001a\u00020\u00062\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u000607H\u0082@¢\u0006\u0002\u00108J4\u00109\u001a\u00020\r2\u0006\u00105\u001a\u00020\u00102\u0006\u0010.\u001a\u00020\u00062\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u0006072\u0006\u0010:\u001a\u00020;H\u0082@¢\u0006\u0002\u0010<J.\u0010=\u001a\u00020\r2\u0006\u00105\u001a\u00020\u00102\u0006\u0010.\u001a\u00020\u00062\u0006\u0010>\u001a\u00020\u00102\u0006\u0010:\u001a\u00020;H\u0082@¢\u0006\u0002\u0010?J&\u0010@\u001a\u0004\u0018\u00010\u00062\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u0006072\u0006\u0010:\u001a\u00020;H\u0082@¢\u0006\u0002\u0010AJ \u0010B\u001a\u0004\u0018\u00010\u000e2\u0006\u00105\u001a\u00020\u00102\u0006\u0010.\u001a\u00020\u0006H\u0082@¢\u0006\u0002\u0010CJ\u001a\u0010D\u001a\u00020\r2\b\u0010E\u001a\u0004\u0018\u00010\u000e2\u0006\u00105\u001a\u00020\u0010H\u0002J\u0010\u0010F\u001a\u00020\u00102\u0006\u0010G\u001a\u00020\u0010H\u0002J&\u0010H\u001a\u00020I2\u0006\u00105\u001a\u00020\u00102\u0006\u0010.\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u0006H\u0082@¢\u0006\u0002\u0010JJ\u0018\u0010K\u001a\u00020I2\u0006\u00105\u001a\u00020\u00102\u0006\u0010.\u001a\u00020\u0006H\u0002J\u0018\u0010L\u001a\u00020I2\u0006\u00105\u001a\u00020\u00102\u0006\u0010.\u001a\u00020\u0006H\u0002J\u0018\u0010M\u001a\u00020\r2\u0006\u0010)\u001a\u00020!2\u0006\u0010N\u001a\u00020\nH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\u0007\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001bR8\u0010\u000b\u001a*\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001cR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\r0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020!0 j\b\u0012\u0004\u0012\u00020!`\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006R"}, d2 = {"Lcom/obric/aiproactive/impl/all/AllRecommendationsRefreshCoordinator;", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "currentUid", "Lkotlin/Function0;", "", "loadFull", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "Lcom/obric/aiproactive/api/ProactiveAllPageSnapshot;", "bindInvalidation", "Lkotlin/Function3;", "", "Lcom/obric/aiproactive/impl/all/AllRecommendationsInvalidationRegistration;", "clockMillis", "", "nextDayBoundaryDelayMs", "Lkotlin/Function1;", "mergeWindowMs", "initialRetryDelayMs", "maxRetryDelayMs", "logInfo", "logError", "", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;JJJLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function3;", "lock", "dispatchLock", "listeners", "Ljava/util/LinkedHashSet;", "Lcom/obric/aiproactive/impl/all/AllRecommendationsSnapshotListener;", "Lkotlin/collections/LinkedHashSet;", "accountUid", "accountEpoch", "worker", "Lcom/obric/aiproactive/impl/all/AllRecommendationsRefreshCoordinator$Worker;", "cachedSnapshot", "register", "listener", "unregister", "requestRefresh", InfoRequestQPSOptTraceLogger.REASON, "switchAccount", "uid", "emptySnapshot", IslandSession.REOPEN_VALUE_CLOSE, "alignAccountLocked", "startWorkerLocked", "stopWorkerLocked", "runWorker", URLDispatch.KEY_EPOCH, "signals", "Lkotlinx/coroutines/channels/Channel;", "(JLjava/lang/String;Lkotlinx/coroutines/channels/Channel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runWorkerLoop", "state", "Lcom/obric/aiproactive/impl/all/AllRecommendationsRefreshCoordinator$WorkerState;", "(JLjava/lang/String;Lkotlinx/coroutines/channels/Channel;Lcom/obric/aiproactive/impl/all/AllRecommendationsRefreshCoordinator$WorkerState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateBindingIfDue", "now", "(JLjava/lang/String;JLcom/obric/aiproactive/impl/all/AllRecommendationsRefreshCoordinator$WorkerState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitSignal", "(Lkotlinx/coroutines/channels/Channel;Lcom/obric/aiproactive/impl/all/AllRecommendationsRefreshCoordinator$WorkerState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryBindInvalidation", "(JLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "closeRegistration", "registration", "nextRetryDelay", "current", "refreshFull", "", "(JLjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isCurrent", "isCurrentLocked", "dispatchTo", "snapshot", "Companion", "Worker", "WorkerState", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6383a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final al f6384b;
    private final Function0<String> c;
    private final Function2<String, Continuation<? super ProactiveAllPageSnapshot>, Object> d;
    private final Function3<String, Function0<Unit>, Continuation<? super com.obric.aiproactive.impl.all.a>, Object> e;
    private final Function0<Long> f;
    private final Function1<Long, Long> g;
    private final long h;
    private final long i;
    private final long j;
    private final Function1<String, Unit> k;
    private final Function2<String, Throwable, Unit> l;
    private final Object m;
    private final Object n;
    private final LinkedHashSet<d> o;
    private String p;
    private long q;
    private C0282b r;
    private ProactiveAllPageSnapshot s;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/aiproactive/impl/all/AllRecommendationsRefreshCoordinator$Companion;", "", "<init>", "()V", "TAG", "", "DEFAULT_MERGE_WINDOW_MS", "", "DEFAULT_INITIAL_RETRY_DELAY_MS", "DEFAULT_MAX_RETRY_DELAY_MS", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.impl.all.b$b, reason: collision with other inner class name */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J7\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/obric/aiproactive/impl/all/AllRecommendationsRefreshCoordinator$Worker;", "", URLDispatch.KEY_EPOCH, "", "uid", "", "signals", "Lkotlinx/coroutines/channels/Channel;", "job", "Lkotlinx/coroutines/Job;", "<init>", "(JLjava/lang/String;Lkotlinx/coroutines/channels/Channel;Lkotlinx/coroutines/Job;)V", "getEpoch", "()J", "getUid", "()Ljava/lang/String;", "getSignals", "()Lkotlinx/coroutines/channels/Channel;", "getJob", "()Lkotlinx/coroutines/Job;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class C0282b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f6385a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f6386b;
        private final i<String> c;
        private final bx d;

        public C0282b(long r3, String r5, i<String> r6, bx r7) {
            i<String> r8 = (i) ZeusTransformUtils.wrapperContextForParams(r6, i.class, "com.obric.memorydata.plugin");
            bx r9 = (bx) ZeusTransformUtils.wrapperContextForParams(r7, bx.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "uid");
            Intrinsics.checkNotNullParameter(r8, "signals");
            Intrinsics.checkNotNullParameter(r9, "job");
            this.f6385a = r3;
            this.f6386b = r5;
            this.c = r8;
            this.d = r9;
        }

        public final long a() {
            return this.f6385a;
        }

        public final String b() {
            return this.f6386b;
        }

        public final i<String> c() {
            return this.c;
        }

        public final bx d() {
            return this.d;
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, C0282b.class) == true) goto L8;
            return false;
        L8:
            C0282b r10 = (C0282b) ZeusTransformUtils.preCheckCast(r9, C0282b.class, "com.obric.memorydata.plugin");
            if (this.f6385a == r10.f6385a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f6386b, r10.f6386b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r10.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r10.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((Long.hashCode(this.f6385a) * 31) + this.f6386b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
        }

        public String toString() {
            return "Worker(epoch=" + this.f6385a + ", uid=" + this.f6386b + ", signals=" + this.c + ", job=" + this.d + ')';
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b)\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\t\u0010+\u001a\u00020\bHÆ\u0003J\t\u0010,\u001a\u00020\nHÆ\u0003J\t\u0010-\u001a\u00020\u0005HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J[\u00100\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u0005HÆ\u0001J\u0013\u00101\u001a\u00020\b2\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u000204HÖ\u0001J\t\u00105\u001a\u00020\nHÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\u000b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010\u0017R\u001a\u0010\f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0015\"\u0004\b%\u0010\u0017R\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0015\"\u0004\b'\u0010\u0017¨\u00066"}, d2 = {"Lcom/obric/aiproactive/impl/all/AllRecommendationsRefreshCoordinator$WorkerState;", "", "registration", "Lcom/obric/aiproactive/impl/all/AllRecommendationsInvalidationRegistration;", "bindRetryAt", "", "bindRetryDelay", "refreshPending", "", "refreshReason", "", "refreshAt", "refreshRetryDelay", "dayBoundaryAt", "<init>", "(Lcom/obric/aiproactive/impl/all/AllRecommendationsInvalidationRegistration;JJZLjava/lang/String;JJJ)V", "getRegistration", "()Lcom/obric/aiproactive/impl/all/AllRecommendationsInvalidationRegistration;", "setRegistration", "(Lcom/obric/aiproactive/impl/all/AllRecommendationsInvalidationRegistration;)V", "getBindRetryAt", "()J", "setBindRetryAt", "(J)V", "getBindRetryDelay", "setBindRetryDelay", "getRefreshPending", "()Z", "setRefreshPending", "(Z)V", "getRefreshReason", "()Ljava/lang/String;", "setRefreshReason", "(Ljava/lang/String;)V", "getRefreshAt", "setRefreshAt", "getRefreshRetryDelay", "setRefreshRetryDelay", "getDayBoundaryAt", "setDayBoundaryAt", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "", "toString", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.obric.aiproactive.impl.all.a f6387a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f6388b;
        private long c;
        private boolean d;
        private String e;
        private long f;
        private long g;
        private long h;

        public c(com.obric.aiproactive.impl.all.a r2, long r3, long r5, boolean r7, String r8, long r9, long r11, long r13) {
            Intrinsics.checkNotNullParameter(r8, "refreshReason");
            this.f6387a = r2;
            this.f6388b = r3;
            this.c = r5;
            this.d = r7;
            this.e = r8;
            this.f = r9;
            this.g = r11;
            this.h = r13;
        }

        public /* synthetic */ c(com.obric.aiproactive.impl.all.a r16, long r17, long r19, boolean r21, String r22, long r23, long r25, long r27, int r29, DefaultConstructorMarker r30) {
            if ((r29 & 1) == 0) goto L5;
            com.obric.aiproactive.impl.all.a r2 = null;
        L7:
            if ((r29 & 8) == 0) goto L9;
            boolean r7 = true;
        L11:
            if ((r29 & 16) == 0) goto L13;
            String r8 = "initial";
        L14:
            this(r2, r17, r19, r7, r8, r23, r25, r27);
            return;
        L13:
            r8 = r22;
            goto L14
        L9:
            r7 = r21;
            goto L11
        L5:
            r2 = r16;
            goto L7
        }

        public final com.obric.aiproactive.impl.all.a a() {
            return this.f6387a;
        }

        public final void a(long r1) {
            this.f6388b = r1;
        }

        public final void a(com.obric.aiproactive.impl.all.a r1) {
            this.f6387a = r1;
        }

        public final void a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.e = r2;
        }

        public final void a(boolean r1) {
            this.d = r1;
        }

        public final long b() {
            return this.f6388b;
        }

        public final void b(long r1) {
            this.c = r1;
        }

        public final long c() {
            return this.c;
        }

        public final void c(long r1) {
            this.f = r1;
        }

        public final void d(long r1) {
            this.g = r1;
        }

        public final boolean d() {
            return this.d;
        }

        public final String e() {
            return this.e;
        }

        public final void e(long r1) {
            this.h = r1;
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, c.class) == true) goto L8;
            return false;
        L8:
            c r10 = (c) ZeusTransformUtils.preCheckCast(r9, c.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f6387a, r10.f6387a) == true) goto L12;
            return false;
        L12:
            if (this.f6388b == r10.f6388b) goto L15;
            return false;
        L15:
            if (this.c == r10.c) goto L18;
            return false;
        L18:
            if (this.d == r10.d) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r10.e) == true) goto L24;
            return false;
        L24:
            if (this.f == r10.f) goto L27;
            return false;
        L27:
            if (this.g == r10.g) goto L30;
            return false;
        L30:
            if (this.h == r10.h) goto L32;
            return false;
        L32:
            return true;
        }

        public final long f() {
            return this.f;
        }

        public final long g() {
            return this.g;
        }

        public final long h() {
            return this.h;
        }

        public int hashCode() {
            com.obric.aiproactive.impl.all.a r0 = this.f6387a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return (((((((((((((r1 * 31) + Long.hashCode(this.f6388b)) * 31) + Long.hashCode(this.c)) * 31) + Boolean.hashCode(this.d)) * 31) + this.e.hashCode()) * 31) + Long.hashCode(this.f)) * 31) + Long.hashCode(this.g)) * 31) + Long.hashCode(this.h);
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        public String toString() {
            return "WorkerState(registration=" + this.f6387a + ", bindRetryAt=" + this.f6388b + ", bindRetryDelay=" + this.c + ", refreshPending=" + this.d + ", refreshReason=" + this.e + ", refreshAt=" + this.f + ", refreshRetryDelay=" + this.g + ", dayBoundaryAt=" + this.h + ')';
        }
    }

    static {
        f6383a = new a(null);
    }

    public b(al r12, Function0<String> r13, Function2<? super String, ? super Continuation<? super ProactiveAllPageSnapshot>, ? extends Object> r14, Function3<? super String, ? super Function0<Unit>, ? super Continuation<? super com.obric.aiproactive.impl.all.a>, ? extends Object> r15, Function0<Long> r16, Function1<? super Long, Long> r17, long r18, long r20, long r22, Function1<? super String, Unit> r24, Function2<? super String, ? super Throwable, Unit> r25) {
        al r1 = (al) ZeusTransformUtils.wrapperContextForParams(r12, al.class, "com.obric.memorydata.plugin");
        Function0<String> r3 = (Function0) ZeusTransformUtils.wrapperContextForParams(r13, Function0.class, "com.obric.memorydata.plugin");
        Function2<String, Continuation<? super ProactiveAllPageSnapshot>, Object> r4 = (Function2) ZeusTransformUtils.wrapperContextForParams(r14, Function2.class, "com.obric.memorydata.plugin");
        Function3<String, Function0<Unit>, Continuation<? super com.obric.aiproactive.impl.all.a>, Object> r5 = (Function3) ZeusTransformUtils.wrapperContextForParams(r15, Function3.class, "com.obric.memorydata.plugin");
        Function0<Long> r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r16, Function0.class, "com.obric.memorydata.plugin");
        Function1<Long, Long> r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r17, Function1.class, "com.obric.memorydata.plugin");
        Function1<String, Unit> r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r24, Function1.class, "com.obric.memorydata.plugin");
        Function2<String, Throwable, Unit> r2 = (Function2) ZeusTransformUtils.wrapperContextForParams(r25, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "scope");
        Intrinsics.checkNotNullParameter(r3, "currentUid");
        Intrinsics.checkNotNullParameter(r4, "loadFull");
        Intrinsics.checkNotNullParameter(r5, "bindInvalidation");
        Intrinsics.checkNotNullParameter(r6, "clockMillis");
        Intrinsics.checkNotNullParameter(r7, "nextDayBoundaryDelayMs");
        Intrinsics.checkNotNullParameter(r8, "logInfo");
        Intrinsics.checkNotNullParameter(r2, "logError");
        this.f6384b = r1;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r18;
        this.i = r20;
        this.j = r22;
        this.k = r8;
        this.l = r2;
        this.m = new Object();
        this.n = new Object();
        this.o = new LinkedHashSet();
    }

    public /* synthetic */ b(al r17, Function0 r18, Function2 r19, Function3 r20, Function0 r21, Function1 r22, long r23, long r25, long r27, Function1 r29, Function2 r30, int r31, DefaultConstructorMarker r32) {
        al r1 = (al) ZeusTransformUtils.wrapperContextForParams(r17, al.class, "com.obric.memorydata.plugin");
        Function0 r3 = (Function0) ZeusTransformUtils.wrapperContextForParams(r18, Function0.class, "com.obric.memorydata.plugin");
        Function2 r4 = (Function2) ZeusTransformUtils.wrapperContextForParams(r19, Function2.class, "com.obric.memorydata.plugin");
        Function3 r5 = (Function3) ZeusTransformUtils.wrapperContextForParams(r20, Function3.class, "com.obric.memorydata.plugin");
        Function0 r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r21, Function0.class, "com.obric.memorydata.plugin");
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r22, Function1.class, "com.obric.memorydata.plugin");
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r29, Function1.class, "com.obric.memorydata.plugin");
        Function2 r9 = (Function2) ZeusTransformUtils.wrapperContextForParams(r30, Function2.class, "com.obric.memorydata.plugin");
        if ((r31 & 16) == 0) goto L6;
        r6 = (Function0) ZeusTransformUtils.preCheckCast(AllRecommendationsRefreshCoordinator$1.INSTANCE, Function0.class, "com.obric.memorydata.plugin");
    L6:
        if ((r31 & 32) == 0) goto L8;
        Function1 r2 = (Function1) ZeusTransformUtils.preCheckCast(AllRecommendationsRefreshCoordinator$2.INSTANCE, Function1.class, "com.obric.memorydata.plugin");
    L10:
        if ((r31 & 64) == 0) goto L12;
        long r10 = 100;
    L14:
        if ((r31 & 128) == 0) goto L16;
        long r12 = 1000;
    L18:
        if ((r31 & 256) == 0) goto L20;
        long r14 = 30000;
    L22:
        if ((r31 & 512) == 0) goto L24;
        Function1 r11 = $$Lambda$b$B9fzA3J6PqrPnRDbi2oOjtQ1Fs.INSTANCE;
    L26:
        if ((r31 & 1024) == 0) goto L28;
        Function2 r0 = $$Lambda$b$3lv5ZVO5Ua6Q7nvu5iDgpAwflo.INSTANCE;
    L29:
        this(r1, r3, r4, r5, r6, r2, r10, r12, r14, r11, r0);
        return;
    L28:
        r0 = r9;
        goto L29
    L24:
        r11 = r8;
        goto L26
    L20:
        r14 = r27;
        goto L22
    L16:
        r12 = r25;
        goto L18
    L12:
        r10 = r23;
        goto L14
    L8:
        r2 = r7;
        goto L10
    }

    private final long a(long r5) {
        return RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r5, 1) * 2, RangesKt.coerceAtLeast(this.j, 1));
    }

    private final Object a(long r9, String r11, long r12, c r14, Continuation<? super Unit> r15) {
        Continuation r16 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r15, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r16, AllRecommendationsRefreshCoordinator$updateBindingIfDue$1.class) == false) goto L7;
        AllRecommendationsRefreshCoordinator$updateBindingIfDue$1 r0 = (AllRecommendationsRefreshCoordinator$updateBindingIfDue$1) ZeusTransformUtils.preCheckCast(r16, AllRecommendationsRefreshCoordinator$updateBindingIfDue$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r17 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r12 = r0.J$0;
        r14 = (c) ZeusTransformUtils.preCheckCast(r0.L$2, c.class, "com.obric.memorydata.plugin");
        c r8 = (c) ZeusTransformUtils.preCheckCast(r0.L$1, c.class, "com.obric.memorydata.plugin");
        b r10 = (b) ZeusTransformUtils.preCheckCast(r0.L$0, b.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r17);
        c r13 = r8;
        b this = r10;
    L23:
        r14.a((com.obric.aiproactive.impl.all.a) ZeusTransformUtils.preCheckCast(r17, com.obric.aiproactive.impl.all.a.class, "com.obric.memorydata.plugin"));
        if (r13.a() != null) goto L26;
        r13.a(r12 + r13.c());
        r13.b(this.a(r13.c()));
    L28:
        return Unit.INSTANCE;
    L26:
        r13.b(this.i);
        r13.a(true);
        r13.a("binding_ready");
        r13.c(r12);
        goto L28
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r17);
        if (r14.a() != null) goto L30;
        if (r12 < r14.b()) goto L30;
        r0.L$0 = this;
        r0.L$1 = r14;
        r0.L$2 = r14;
        r0.J$0 = r12;
        r0.label = 1;
        r17 = a(r9, r11, r0);
        if (r17 != r2) goto L22;
        return r2;
    L22:
        r13 = r14;
    L30:
        return Unit.INSTANCE;
    L7:
        r0 = new AllRecommendationsRefreshCoordinator$updateBindingIfDue$1(this, r16);
        goto L8
    }

    private final Object a(long r10, String r12, String r13, Continuation<? super Boolean> r14) {
        Continuation r15 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r14, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r15, AllRecommendationsRefreshCoordinator$refreshFull$1.class) == false) goto L7;
        AllRecommendationsRefreshCoordinator$refreshFull$1 r0 = (AllRecommendationsRefreshCoordinator$refreshFull$1) ZeusTransformUtils.preCheckCast(r15, AllRecommendationsRefreshCoordinator$refreshFull$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r16 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L18;
        if (r2 != 1) goto L17;
        long r9 = r0.J$1;
        long r11 = r0.J$0;
        r13 = (String) ZeusTransformUtils.preCheckCast(r0.L$2, String.class, "com.obric.memorydata.plugin");
        String r3 = (String) ZeusTransformUtils.preCheckCast(r0.L$1, String.class, "com.obric.memorydata.plugin");
        b r4 = (b) ZeusTransformUtils.preCheckCast(r0.L$0, b.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r16);     // Catch: Exception -> L14 CancellationException -> L55
        long r5 = r9;
        r10 = r11;
        b this = r4;
        r12 = r3;
    L22:
        ProactiveAllPageSnapshot r17 = (ProactiveAllPageSnapshot) ZeusTransformUtils.preCheckCast(r16, ProactiveAllPageSnapshot.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L51 CancellationException -> L55
        Object r6 = this.n;     // Catch: Exception -> L51 CancellationException -> L55
        monitor-enter(r6);     // Catch: Exception -> L51 CancellationException -> L55
        Object r7 = this.m;     // Catch: Throwable -> L48
        monitor-enter(r7);     // Catch: Throwable -> L48
    L45:
        th = move-exception;
        throw th;     // Catch: Throwable -> L48
    L27:
        if (this.b(r10, r12) == true) goto L33;
        Boolean r18 = Boxing.boxBoolean(false);     // Catch: Throwable -> L45
        monitor-exit(r7);     // Catch: Throwable -> L48
        monitor-exit(r6);     // Catch: Exception -> L51 CancellationException -> L55
        return r18;
    L33:
        if (Intrinsics.areEqual(this.s, r17) == false) goto L35;
        List r19 = CollectionsKt.emptyList();     // Catch: Throwable -> L45
    L36:
        monitor-exit(r7);     // Catch: Throwable -> L48
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r19, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L48
    L39:
        if (r8.hasNext() == false) goto L42;
        this.a((d) ZeusTransformUtils.preCheckCast(r8.next(), d.class, "com.obric.memorydata.plugin"), r17);     // Catch: Throwable -> L48
        goto L39
    L42:
        monitor-exit(r6);     // Catch: Exception -> L51 CancellationException -> L55
        this.k.invoke("[Runtime] fullLoad reason=" + r13 + " epoch=" + r10 + " listeners=" + r19.size() + " durationMs=" + (((Number) ZeusTransformUtils.preCheckCast(this.f.invoke(), Number.class, "com.obric.memorydata.plugin")).longValue() - r5));     // Catch: Exception -> L51 CancellationException -> L55
        return Boxing.boxBoolean(true);
    L35:
        this.s = r17;     // Catch: Throwable -> L45
        r19 = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(this.o, Iterable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L45
    L48:
        th = move-exception;
        throw th;     // Catch: Exception -> L51 CancellationException -> L55
    L14:
        Exception e = e;
        r10 = r11;
    L53:
        r4.l.invoke("[code=full_load_failed] ALL 完整刷新失败 epoch=" + r10 + " reason=" + r13, e);
        return Boxing.boxBoolean(false);
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r16);
        r5 = ((Number) ZeusTransformUtils.preCheckCast(this.f.invoke(), Number.class, "com.obric.memorydata.plugin")).longValue();
        Function2<String, Continuation<? super ProactiveAllPageSnapshot>, Object> r110 = this.d;     // Catch: Exception -> L51 CancellationException -> L55
        r0.L$0 = this;     // Catch: Exception -> L51 CancellationException -> L55
        r0.L$1 = r12;     // Catch: Exception -> L51 CancellationException -> L55
        r0.L$2 = r13;     // Catch: Exception -> L51 CancellationException -> L55
        r0.J$0 = r10;     // Catch: Exception -> L51 CancellationException -> L55
        r0.J$1 = r5;     // Catch: Exception -> L51 CancellationException -> L55
        r0.label = 1;     // Catch: Exception -> L51 CancellationException -> L55
        r16 = r110.invoke(r12, r0);     // Catch: Exception -> L51 CancellationException -> L55
        if (r16 != r1) goto L22;
        return r1;
    L51:
        e = move-exception;
        r4 = this;
        e = e;
    L55:
        e = move-exception;
        throw e;
    L7:
        r0 = new AllRecommendationsRefreshCoordinator$refreshFull$1(this, r15);
        goto L8
    }

    private final Object a(long r7, String r9, Continuation<? super com.obric.aiproactive.impl.all.a> r10) {
        Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r11, AllRecommendationsRefreshCoordinator$tryBindInvalidation$1.class) == false) goto L7;
        AllRecommendationsRefreshCoordinator$tryBindInvalidation$1 r0 = (AllRecommendationsRefreshCoordinator$tryBindInvalidation$1) ZeusTransformUtils.preCheckCast(r11, AllRecommendationsRefreshCoordinator$tryBindInvalidation$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 != 1) goto L15;
        r7 = r0.J$0;
        final b this = (b) ZeusTransformUtils.preCheckCast(r0.L$0, b.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r12);     // Catch: Exception -> L26 CancellationException -> L29
    L20:
        com.obric.aiproactive.impl.all.a r13 = (com.obric.aiproactive.impl.all.a) ZeusTransformUtils.preCheckCast(r12, com.obric.aiproactive.impl.all.a.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L26 CancellationException -> L29
    L22:
        if (r13.a() == false) goto L24;
        return r13;
    L24:
        this.a(r13, r7);
        this.k.invoke("[Runtime] ALL 数据库失效监听未完整绑定 epoch=" + r7);
        return null;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r12);
        Function3<String, Function0<Unit>, Continuation<? super com.obric.aiproactive.impl.all.a>, Object> r14 = this.e;     // Catch: Exception -> L26 CancellationException -> L29
        Function0<Unit> r4 = new $$Lambda$b$NIsrsWeNFu6VVxGqwqCgmHPL90(this);     // Catch: Exception -> L26 CancellationException -> L29
        r0.L$0 = this;     // Catch: Exception -> L26 CancellationException -> L29
        r0.J$0 = r7;     // Catch: Exception -> L26 CancellationException -> L29
        r0.label = 1;     // Catch: Exception -> L26 CancellationException -> L29
        r12 = r14.invoke(r9, r4, r0);     // Catch: Exception -> L26 CancellationException -> L29
        if (r12 != r2) goto L20;
        return r2;
    L29:
        e = move-exception;
        throw e;
    L26:
        e = move-exception;
        this.l.invoke("[code=invalidation_bind_failed] ALL 数据库失效监听绑定失败 epoch=" + r7, e);
        return null;
    L7:
        r0 = new AllRecommendationsRefreshCoordinator$tryBindInvalidation$1(this, r11);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x01e6 -> B:45:0x01ec). Please report as a decompilation issue!!! */
    private final Object a(long r27, String r29, i<String> r30, c r31, Continuation<? super Unit> r32) {
        i<String> r1 = (i) ZeusTransformUtils.wrapperContextForParams(r30, i.class, "com.obric.memorydata.plugin");
        Continuation r3 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r32, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, AllRecommendationsRefreshCoordinator$runWorkerLoop$1.class) == false) goto L7;
        AllRecommendationsRefreshCoordinator$runWorkerLoop$1 r4 = (AllRecommendationsRefreshCoordinator$runWorkerLoop$1) ZeusTransformUtils.preCheckCast(r3, AllRecommendationsRefreshCoordinator$runWorkerLoop$1.class, "com.obric.memorydata.plugin");
        if ((r4.label & Integer.MIN_VALUE) == 0) goto L7;
        r4.label -= Integer.MIN_VALUE;
        b r5 = this;
    L8:
        Object r6 = r4.result;
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r8 = r4.label;
        if (r8 == 0) goto L18;
        if (r8 == 1) goto L17;
        if (r8 == 2) goto L16;
        if (r8 != 3) goto L15;
        long r11 = r4.J$0;
        c r2 = (c) ZeusTransformUtils.preCheckCast(r4.L$3, c.class, "com.obric.memorydata.plugin");
        i<String> r9 = (i) ZeusTransformUtils.preCheckCast(r4.L$2, i.class, "com.obric.memorydata.plugin");
        String r10 = (String) ZeusTransformUtils.preCheckCast(r4.L$1, String.class, "com.obric.memorydata.plugin");
        b r0 = (b) ZeusTransformUtils.preCheckCast(r4.L$0, b.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r6);
        r5 = r0;
        AllRecommendationsRefreshCoordinator$runWorkerLoop$1 r24 = r4;
        c r12 = r2;
        long r13 = r11;
        AllRecommendationsRefreshCoordinator$runWorkerLoop$1 r14 = r24;
        Object r15 = r7;
        i<String> r16 = r9;
        Object r17 = r6;
        char r18 = 2;
    L45:
        String r19 = (String) ZeusTransformUtils.preCheckCast(r17, String.class, "com.obric.memorydata.plugin");
        if (r19 == null) goto L50;
        long r110 = ((Number) ZeusTransformUtils.preCheckCast(r5.f.invoke(), Number.class, "com.obric.memorydata.plugin")).longValue();
        r12.a(true);
        r12.a(r19);
        r12.c(r5.h + r110);
        if (r12.a() != null) goto L50;
        r12.a(r110);
    L50:
        String r20 = r10;
        AllRecommendationsRefreshCoordinator$runWorkerLoop$1 r21 = r14;
        Object r111 = r15;
    L20:
        if (r5.a(r13, r20) == false) goto L52;
        long r112 = ((Number) ZeusTransformUtils.preCheckCast(r5.f.invoke(), Number.class, "com.obric.memorydata.plugin")).longValue();
        r21.L$0 = r5;
        r21.L$1 = r20;
        r21.L$2 = r16;
        r21.L$3 = r12;
        r21.J$0 = r13;
        r21.J$1 = r112;
        r21.label = 1;
        if (r5.a(r13, r20, r112, r12, r21) != r111) goto L24;
        return r111;
    L24:
        AllRecommendationsRefreshCoordinator$runWorkerLoop$1 r23 = r21;
        r10 = r20;
        long r25 = r13;
        c r22 = r12;
        b r26 = r5;
        i<String> r28 = r16;
        r4 = r23;
        r7 = r111;
        long r113 = r112;
        long r114 = r25;
    L26:
        if (r113 < r22.h()) goto L29;
        r22.a(true);
        r22.a("day_boundary");
        r22.c(r113);
        r22.e(r113 + ((Number) ZeusTransformUtils.preCheckCast(r26.g.invoke(Boxing.boxLong(r113)), Number.class, "com.obric.memorydata.plugin")).longValue());
    L29:
        if (r22.d() == true) goto L31;
    L40:
        r18 = 2;
    L41:
        r4.L$0 = r26;
        r4.L$1 = r10;
        r4.L$2 = r28;
        r4.L$3 = r22;
        r4.J$0 = r114;
        r4.label = 3;
        r17 = r26.a(r28, r22, r4);
        if (r17 != r7) goto L44;
        return r7;
    L44:
        r14 = r4;
        r15 = r7;
        r12 = r22;
        r16 = r28;
        r5 = r26;
        r13 = r114;
        goto L45
    L31:
        if (r113 < r22.f()) goto L40;
        String r33 = r22.e();
        r4.L$0 = r26;
        r4.L$1 = r10;
        r4.L$2 = r28;
        r4.L$3 = r22;
        r4.J$0 = r114;
        r4.J$1 = r113;
        r18 = 2;
        r4.label = 2;
        Object r34 = r26.a(r114, r10, r33, r4);
        if (r34 != r7) goto L36;
        return r7;
    L36:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r34, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L38;
        r22.a(false);
        long r35 = r26.i;
    L39:
        r22.d(r35);
        goto L41
    L38:
        r22.c(r113 + r22.g());
        r35 = r26.a(r22.g());
        goto L39
    L52:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r113 = r4.J$1;
        r114 = r4.J$0;
        r22 = (c) ZeusTransformUtils.preCheckCast(r4.L$3, c.class, "com.obric.memorydata.plugin");
        r28 = (i) ZeusTransformUtils.preCheckCast(r4.L$2, i.class, "com.obric.memorydata.plugin");
        r10 = (String) ZeusTransformUtils.preCheckCast(r4.L$1, String.class, "com.obric.memorydata.plugin");
        r26 = (b) ZeusTransformUtils.preCheckCast(r4.L$0, b.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r6);
        r34 = r6;
        r18 = 2;
        goto L36
    L17:
        r113 = r4.J$1;
        r114 = r4.J$0;
        r22 = (c) ZeusTransformUtils.preCheckCast(r4.L$3, c.class, "com.obric.memorydata.plugin");
        r28 = (i) ZeusTransformUtils.preCheckCast(r4.L$2, i.class, "com.obric.memorydata.plugin");
        r10 = (String) ZeusTransformUtils.preCheckCast(r4.L$1, String.class, "com.obric.memorydata.plugin");
        r26 = (b) ZeusTransformUtils.preCheckCast(r4.L$0, b.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r6);
        goto L26
    L18:
        ResultKt.throwOnFailure(r6);
        r20 = r29;
        r21 = r4;
        r111 = r7;
        r12 = r31;
        r16 = r1;
        r13 = r27;
    L7:
        r5 = this;
        r4 = new AllRecommendationsRefreshCoordinator$runWorkerLoop$1(r5, r3);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v12, types: [com.obric.aiproactive.impl.all.b$c] */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v3 */
    private final Object a(long r27, String r29, i<String> r30, Continuation<? super Unit> r31) {
        b r8 = this;
        i r5 = (i) ZeusTransformUtils.wrapperContextForParams(r30, i.class, "com.obric.memorydata.plugin");
        Continuation r0 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r31, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, AllRecommendationsRefreshCoordinator$runWorker$1.class) == false) goto L7;
        AllRecommendationsRefreshCoordinator$runWorker$1 r2 = (AllRecommendationsRefreshCoordinator$runWorker$1) ZeusTransformUtils.preCheckCast(r0, AllRecommendationsRefreshCoordinator$runWorker$1.class, "com.obric.memorydata.plugin");
        c r4 = -2147483648(0xffffffff80000000, float:-0.0);
        if ((r2.label & Integer.MIN_VALUE) == 0) goto L7;
        r2.label -= Integer.MIN_VALUE;
    L8:
        AllRecommendationsRefreshCoordinator$runWorker$1 r7 = r2;
        Object r1 = r7.result;
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r7.label;
        if (r3 == 0) goto L22;
        if (r3 != 1) goto L21;
        long r6 = r7.J$0;
        r4 = (c) ZeusTransformUtils.preCheckCast(r7.L$1, c.class, "com.obric.memorydata.plugin");
        b r10 = (b) ZeusTransformUtils.preCheckCast(r7.L$0, b.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r1);     // Catch: Throwable -> L14 Exception -> L16 CancellationException -> L18
        long r11 = r6;
        c r12 = r4;
    L31:
        r10.a(r12.a(), r11);
    L55:
        return Unit.INSTANCE;
    L18:
        e = move-exception;
        throw e;     // Catch: Throwable -> L61
    L16:
        e = e;
        r8 = r10;
        r11 = r6;
        c r13 = r4;
    L52:
        r8.l.invoke("[code=worker_failed] ALL 刷新 worker 异常 epoch=" + r11, e);     // Catch: Throwable -> L61
        r8.a(r13.a(), r11);
    L14:
        th = th;
        r8 = r10;
        r11 = r6;
    L62:
        r8.a(r4.a(), r11);
        throw th;
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L22:
        ResultKt.throwOnFailure(r1);
        long r18 = ((Number) ZeusTransformUtils.preCheckCast(r8.f.invoke(), Number.class, "com.obric.memorydata.plugin")).longValue();
        long r14 = r8.i;
        c r15 = new c(null, r18, r14, false, null, r18, r14, r18 + ((Number) ZeusTransformUtils.preCheckCast(r8.g.invoke(Boxing.boxLong(r18)), Number.class, "com.obric.memorydata.plugin")).longValue(), 25, null);
        r7.L$0 = r8;     // Catch: Throwable -> L44 Exception -> L48 CancellationException -> L56
        r7.L$1 = r15;     // Catch: Throwable -> L44 Exception -> L48 CancellationException -> L56
        r11 = r27;
        r7.J$0 = r11;     // Catch: Throwable -> L38 Exception -> L40 CancellationException -> L42
        r7.label = 1;     // Catch: Throwable -> L38 Exception -> L40 CancellationException -> L42
        c r16 = r15;
        if (a(r27, r29, r5, r15, r7) != r9) goto L30;
        return r9;
    L30:
        r10 = r8;
        r12 = r16;
        goto L31
    L36:
        e = e;
    L60:
        throw e;     // Catch: Throwable -> L61
    L34:
        e = e;
    L51:
        r13 = r16;
    L32:
        th = th;
    L47:
        r4 = r16;
        goto L62
    L42:
        e = e;
    L58:
        r16 = r15;
    L40:
        e = e;
    L50:
        r16 = r15;
    L38:
        th = th;
    L46:
        r16 = r15;
        goto L47
    L56:
        e = e;
    L48:
        e = e;
        r11 = r27;
    L44:
        th = th;
        r11 = r27;
    L61:
        th = th;
    L7:
        r2 = new AllRecommendationsRefreshCoordinator$runWorker$1(r8, r0);
        goto L8
    }

    public static final /* synthetic */ Object a(b r8, long r9, String r11, long r12, c r14, Continuation r15) {
        return r8.a(r9, r11, r12, r14, (Continuation) ZeusTransformUtils.wrapperContextForParams(r15, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ Object a(b r6, long r7, String r9, String r10, Continuation r11) {
        return r6.a(r7, r9, r10, (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ Object a(b r2, long r3, String r5, Continuation r6) {
        return r2.a(r3, r5, (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ Object a(b r9, long r10, String r12, i r13, c r14, Continuation r15) {
        return r9.a(r10, r12, (i) ZeusTransformUtils.wrapperContextForParams(r13, i.class, "com.obric.memorydata.plugin"), r14, (Continuation) ZeusTransformUtils.wrapperContextForParams(r15, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ Object a(b r8, long r9, String r11, i r12, Continuation r13) {
        return r8.a(r9, r11, (i) ZeusTransformUtils.wrapperContextForParams(r12, i.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private final Object a(i<String> r9, c r10, Continuation<? super String> r11) {
        i r12 = (i) ZeusTransformUtils.wrapperContextForParams(r9, i.class, "com.obric.memorydata.plugin");
        Continuation r13 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        long r2 = Long.MAX_VALUE;
        if (r10.a() != null) goto L5;
        long r4 = r10.b();
    L7:
        if (r10.d() == false) goto L10;
        r2 = r10.f();
    L10:
        return da.b(RangesKt.coerceAtLeast(Math.min(r4, Math.min(r2, r10.h())) - ((Number) ZeusTransformUtils.preCheckCast(this.f.invoke(), Number.class, "com.obric.memorydata.plugin")).longValue(), 1), (Function2) ZeusTransformUtils.preCheckCast(new AllRecommendationsRefreshCoordinator$awaitSignal$2(r12, null), Function2.class, "com.obric.memorydata.plugin"), r13);
    L5:
        r4 = Long.MAX_VALUE;
        goto L7
    }

    private static final Unit a(b r1) {
        r1.a("room");
        return Unit.INSTANCE;
    }

    private static final Unit a(b r2, bx r3, Throwable r4) {
        bx r5 = (bx) ZeusTransformUtils.wrapperContextForParams(r3, bx.class, "com.obric.memorydata.plugin");
        Object r6 = r2.m;
        monitor-enter(r6);
        C0282b r0 = r2.r;     // Catch: Throwable -> L14
        if (r0 == null) goto L7;
        bx r1 = r0.d();     // Catch: Throwable -> L14
    L8:
        if (r1 != r5) goto L10;
        r2.r = null;     // Catch: Throwable -> L14
    L10:
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r6);
        return Unit.INSTANCE;
    L7:
        r1 = null;
    L14:
        th = move-exception;
        throw th;
    }

    private static final Unit a(String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "error");
        RunLog.INSTANCE.error("AllRecommendationsCoordinator", r2, r3);
        return Unit.INSTANCE;
    }

    private final void a(com.obric.aiproactive.impl.all.a r3, long r4) {
        if (r3 == null) goto L10;
        r3.b();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        this.l.invoke("[code=invalidation_unbind_failed] ALL 数据库失效监听解绑失败 epoch=" + r4, e);
        return;
    }

    private final void a(d r3, ProactiveAllPageSnapshot r4) {
        ((d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin")).onChanged(r4);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        this.l.invoke("[code=callback_failed] ALL listener 回调失败", e);
    }

    private final boolean a(long r2, String r4) {
        Object r0 = this.m;
        monitor-enter(r0);
        boolean r1 = b(r2, r4);     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private final void b() {
        if (this.o.isEmpty() == false) goto L5;
        return;
    L5:
        if (this.r != null) goto L13;
        String r0 = this.p;
        if (r0 != null) goto L10;
        String r1 = this.c.invoke();
        this.p = (String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.memorydata.plugin");
        r0 = (String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.memorydata.plugin");
    L10:
        String r9 = r0;
        long r10 = this.q;
        i r12 = l.a(-1, null, null, 6, null);
        final bx r2 = kotlinx.coroutines.i.a(this.f6384b, null, CoroutineStart.LAZY, (Function2) ZeusTransformUtils.preCheckCast(new AllRecommendationsRefreshCoordinator$startWorkerLocked$job$1(this, r10, r9, r12, null), Function2.class, "com.obric.memorydata.plugin"), 1, null);
        this.r = new C0282b(r10, r9, r12, r2);
        r2.a(new $$Lambda$b$ft3asBbAL5ciHpH6dCoZinAViJU(this, r2));
        r2.s_();
        return;
    }

    private final void b(String r5) {
        if (Intrinsics.areEqual(this.p, r5) == false) goto L5;
        return;
    L5:
        c();
        this.p = r5;
        this.q++;
        this.s = null;
    }

    private final boolean b(long r6, String r8) {
        C0282b r0 = this.r;
        if (r0 != null) goto L5;
    L7:
        boolean r7 = false;
    L8:
        if (r7 == false) goto L17;
        if (Intrinsics.areEqual(r0.b(), r8) == false) goto L17;
        if (Intrinsics.areEqual(this.p, r8) == false) goto L17;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this.o, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L17;
        return true;
    L17:
        return false;
    L5:
        if (r0.a() != r6) goto L7;
        r7 = true;
        goto L8
    }

    private static final Unit c(String r7) {
        Intrinsics.checkNotNullParameter(r7, "message");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AllRecommendationsCoordinator", r7, false, 4, null);
        return Unit.INSTANCE;
    }

    private final void c() {
        C0282b r0 = this.r;
        if (r0 == null) goto L7;
        i<String> r1 = r0.c();
        if (r1 == null) goto L7;
        z.a.a((z) ZeusTransformUtils.preCheckCast(r1, z.class, "com.obric.memorydata.plugin"), null, 1, null);
    L7:
        C0282b r2 = this.r;
        if (r2 == null) goto L12;
        bx r3 = r2.d();
        if (r3 == null) goto L12;
        bx.a.a(r3, null, 1, null);
    L12:
        this.r = null;
    }

    /* JADX INFO: renamed from: lambda$3lv5ZVO5Ua6Q7nvu5iDgpA-wflo, reason: not valid java name */
    public static /* synthetic */ Unit m218lambda$3lv5ZVO5Ua6Q7nvu5iDgpAwflo(String r0, Throwable r1) {
        return a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$B9fzA3J6PqrPnRDbi-2oOjtQ1Fs, reason: not valid java name */
    public static /* synthetic */ Unit m219lambda$B9fzA3J6PqrPnRDbi2oOjtQ1Fs(String r0) {
        return c(r0);
    }

    /* JADX INFO: renamed from: lambda$NIsrsWe-NFu6VVxGqwqCgmHPL90, reason: not valid java name */
    public static /* synthetic */ Unit m220lambda$NIsrsWeNFu6VVxGqwqCgmHPL90(b r0) {
        return a(r0);
    }

    public static /* synthetic */ Unit lambda$ft3asBbAL5ciHpH6dCoZinAViJU(b r0, bx r1, Throwable r2) {
        return a(r0, r1, r2);
    }

    public final void a() {
        Object r0 = this.m;
        monitor-enter(r0);
        this.o.clear();     // Catch: Throwable -> L7
        c();     // Catch: Throwable -> L7
        this.s = null;     // Catch: Throwable -> L7
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void a(d r6) {
        d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r6, d.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "listener");
        Object r0 = this.n;
        monitor-enter(r0);
        Object r1 = this.m;     // Catch: Throwable -> L32
        monitor-enter(r1);     // Catch: Throwable -> L32
        b((String) ZeusTransformUtils.preCheckCast(this.c.invoke(), String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L29
        if (this.o.add(r7) == false) goto L10;
        ProactiveAllPageSnapshot r2 = this.s;     // Catch: Throwable -> L29
    L11:
        monitor-exit(r1);     // Catch: Throwable -> L32
        if (r2 == null) goto L14;
        a(r7, r2);     // Catch: Throwable -> L32
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L32
    L14:
        monitor-exit(r0);
        Object r9 = this.m;
        monitor-enter(r9);
        C0282b r3 = this.r;     // Catch: Throwable -> L26
        if (r3 != null) goto L20;
        b();     // Catch: Throwable -> L26
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L26
    L24:
        monitor-exit(r9);
        return;
    L20:
        if (r3 == null) goto L24;
        i<String> r10 = r3.c();     // Catch: Throwable -> L26
        if (r10 == null) goto L24;
        m.i(r10.mo54trySendJP2dKIU("subscription"));     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    L10:
        r2 = null;
    L29:
        th = move-exception;
        throw th;     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        throw th;
    }

    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, InfoRequestQPSOptTraceLogger.REASON);
        Object r0 = this.m;
        monitor-enter(r0);
        C0282b r1 = this.r;     // Catch: Throwable -> L11
        if (r1 == null) goto L9;
        i<String> r3 = r1.c();     // Catch: Throwable -> L11
        if (r3 == null) goto L9;
        m.i(r3.mo54trySendJP2dKIU(r2));     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final void a(String r8, ProactiveAllPageSnapshot r9) {
        Intrinsics.checkNotNullParameter(r8, "uid");
        Intrinsics.checkNotNullParameter(r9, "emptySnapshot");
        Object r0 = this.n;
        monitor-enter(r0);
        Object r1 = this.m;     // Catch: Throwable -> L30
        monitor-enter(r1);     // Catch: Throwable -> L30
        c();     // Catch: Throwable -> L27
        this.p = r8;     // Catch: Throwable -> L27
        long r2 = this.q + 1;     // Catch: Throwable -> L27
        this.q = r2;     // Catch: Throwable -> L27
        this.s = null;     // Catch: Throwable -> L27
        List r4 = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(this.o, Iterable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L27
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L27
        monitor-exit(r1);     // Catch: Throwable -> L30
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L30
    L10:
        if (r3.hasNext() == false) goto L12;
        a((d) ZeusTransformUtils.preCheckCast(r3.next(), d.class, "com.obric.memorydata.plugin"), r9);     // Catch: Throwable -> L30
        goto L10
    L12:
        Object r10 = this.m;     // Catch: Throwable -> L30
        monitor-enter(r10);     // Catch: Throwable -> L30
    L24:
        th = move-exception;
        throw th;     // Catch: Throwable -> L30
    L15:
        if (this.q == r2) goto L17;
    L19:
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L24
        monitor-exit(r10);     // Catch: Throwable -> L30
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L30
        monitor-exit(r0);
        return;
    L17:
        if (Intrinsics.areEqual(this.p, r8) == false) goto L19;
        b();     // Catch: Throwable -> L24
        goto L19
    L27:
        th = move-exception;
        throw th;     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        throw th;
    }

    public final void b(d r5) {
        d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "listener");
        Object r0 = this.m;
        monitor-enter(r0);
        ((Collection) ZeusTransformUtils.preCheckCast(this.o, Collection.class, "com.obric.memorydata.plugin")).remove(r6);     // Catch: Throwable -> L10
        if (this.o.isEmpty() == false) goto L7;
        c();     // Catch: Throwable -> L10
    L7:
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r0);
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
