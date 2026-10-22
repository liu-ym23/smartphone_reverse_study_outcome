package com.obric.memorydata.recommend.screenshotupload.sampling.aimedia;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.awareness.impl.AwarenessManagerImpl;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.bx;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0015\u001a\u00020\tH\u0016J\b\u0010\u0016\u001a\u00020\tH\u0016J\b\u0010\u0017\u001a\u00020\tH\u0002J\b\u0010\u0018\u001a\u00020\tH\u0002J\b\u0010\u0019\u001a\u00020\tH\u0002J\u0010\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/obric/memorydata/recommend/screenshotupload/sampling/aimedia/AIMediaCodecLifecycleMonitor;", "Lcom/obric/memorydata/recommend/screenshotupload/sampling/aimedia/AIMediaLifecycleMonitor;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "gateway", "Lcom/obric/memorydata/recommend/screenshotupload/sampling/aimedia/AIMediaEventsGateway;", "consumer", "Lkotlin/Function1;", "Lcom/obric/memorydata/recommend/screenshotupload/sampling/aimedia/AIMediaCodecLifecycleEvent;", "", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Lcom/obric/memorydata/recommend/screenshotupload/sampling/aimedia/AIMediaEventsGateway;Lkotlin/jvm/functions/Function1;)V", "started", "Ljava/util/concurrent/atomic/AtomicBoolean;", "subscriptionId", "", "lastSequence", "", "resubscribeJob", "Lkotlinx/coroutines/Job;", "resubscribeAttempts", CommonConsts.APM_INNER_EVENT_COST_START, "stop", AwarenessManagerImpl.ACTION_SUBSCRIBE, "scheduleResubscribe", "queryAndDispatch", "dispatch", "result", "Lcom/obric/memorydata/recommend/screenshotupload/sampling/aimedia/AIMediaEventQueryResultDto;", "Companion", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f12566a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final al f12567b;
    private final g c;
    private final Function1<com.obric.memorydata.recommend.screenshotupload.sampling.aimedia.a, Unit> d;
    private final AtomicBoolean e;
    private int f;
    private volatile long g;
    private bx h;
    private int i;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/recommend/screenshotupload/sampling/aimedia/AIMediaCodecLifecycleMonitor$Companion;", "", "<init>", "()V", "TAG", "", "MAX_QUERY_RESULTS", "", "RESUBSCRIBE_BASE_DELAY_MS", "", "RESUBSCRIBE_MAX_DELAY_MS", "MAX_RESUBSCRIBE_ATTEMPTS", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f12566a = new a(null);
    }

    public c(al r3, g r4, Function1<? super com.obric.memorydata.recommend.screenshotupload.sampling.aimedia.a, Unit> r5) {
        al r6 = (al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin");
        g r7 = (g) ZeusTransformUtils.wrapperContextForParams(r4, g.class, "com.obric.memorydata.plugin");
        Function1<com.obric.memorydata.recommend.screenshotupload.sampling.aimedia.a, Unit> r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "scope");
        Intrinsics.checkNotNullParameter(r7, "gateway");
        Intrinsics.checkNotNullParameter(r8, "consumer");
        this.f12567b = r6;
        this.c = r7;
        this.d = r8;
        this.e = new AtomicBoolean(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ c(al r2, g r3, Function1 r4, int r5, DefaultConstructorMarker r6) {
        al r7 = (al) ZeusTransformUtils.wrapperContextForParams(r2, al.class, "com.obric.memorydata.plugin");
        g r8 = (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.memorydata.plugin");
        Function1 r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L5;
        Function0 r10 = null;
        r8 = (g) ZeusTransformUtils.preCheckCast(new j(r10, 1, 0 == true ? 1 : 0), g.class, "com.obric.memorydata.plugin");
    L5:
        this(r7, r8, r9);
    }

    private static final Unit a(c r7, int r8) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AIMediaCodecLifecycleMonitor", "subscription closed reason=" + r8, null, 4, null);
        r7.d();
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ void a(c r0) {
        r0.e();
    }

    public static final /* synthetic */ void a(c r0, f r1) {
        r0.a(r1);
    }

    private final void a(f r8) {
        RunLog.INSTANCE.debug("AIMediaCodecLifecycleMonitor", "dispatch result events=" + r8.a().size() + " next=" + r8.b() + " hasMore=" + r8.c());
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r8.a(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r9.hasNext() == false) goto L9;
        d r0 = (d) ZeusTransformUtils.preCheckCast(r9.next(), d.class, "com.obric.memorydata.plugin");
        this.g = Math.max(this.g, r0.b());
        com.obric.memorydata.recommend.screenshotupload.sampling.aimedia.a r3 = b.f12565a.a(r0);
        if (r3 == null) goto L7;
        RunLog.INSTANCE.debug("AIMediaCodecLifecycleMonitor", "codec event key=" + r3.b() + " pkg=" + r3.e() + " session=" + r3.d() + " video=" + r3.f() + " encoder=" + r3.g() + " useSurface=" + r3.h());
        this.d.invoke(r3);
        goto L4
    L7:
        c r4 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin");
        RunLog.INSTANCE.debug("AIMediaCodecLifecycleMonitor", "ignore event eventName=" + r0.a() + " seq=" + r0.b() + " fields=" + r0.e().size());
        goto L4
    }

    private static final Unit b(c r7, f r8) {
        Intrinsics.checkNotNullParameter(r8, "result");
        kotlinx.coroutines.i.a(r7.f12567b, null, null, (Function2) ZeusTransformUtils.preCheckCast(new AIMediaCodecLifecycleMonitor$subscribe$1$1$1(r7, r8, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ void b(c r0) {
        r0.c();
    }

    public static final /* synthetic */ g c(c r0) {
        return r0.c;
    }

    private final void c() {
        if (this.e.get() == true) goto L5;
        return;
    L5:
        RunLog.INSTANCE.debug("AIMediaCodecLifecycleMonitor", "subscribe startSequence=" + this.g);
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L8
        final c r3 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        Object r4 = Result.m1421constructorimpl(Integer.valueOf(r3.c.a(r3.g, new $$Lambda$c$n6CVkSXIpzhAPFRUCU2VoAPI1g(r3), new $$Lambda$c$5Un4045xG5hU4NqHZcOQL1W1K10(r3))));     // Catch: Throwable -> L8
    L11:
        if (Result.m1428isSuccessimpl(r4) == false) goto L26;
        int r5 = ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).intValue();
        if (this.e.get() == true) goto L22;
        if (r5 <= 0) goto L26;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L17
        ((c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin")).c.a(r5);     // Catch: Throwable -> L17
        Object r0 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L17
    L19:
        Throwable r1 = Result.m1424exceptionOrNullimpl(r0);
        if (r1 == null) goto L26;
        RunLog.INSTANCE.warn("AIMediaCodecLifecycleMonitor", "unsubscribe stopped subscription failed", r1);
    L17:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r0 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L19
    L22:
        this.f = r5;
        if (r5 > 0) goto L25;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AIMediaCodecLifecycleMonitor", "subscribe failed id=" + r5, null, 4, null);
        d();
        goto L26
    L25:
        this.i = 0;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AIMediaCodecLifecycleMonitor", "subscribe success id=" + r5 + " startSequence=" + this.g, false, 4, null);
    L26:
        Throwable r8 = Result.m1424exceptionOrNullimpl(r4);
        if (r8 == null) goto L34;
        RunLog.INSTANCE.warn("AIMediaCodecLifecycleMonitor", "subscribe failed", r8);
        d();
        return;
    L34:
        return;
    L8:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r4 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    private final void d() {
        if (this.e.get() == true) goto L5;
        return;
    L5:
        bx r1 = this.h;
        boolean r2 = false;
        if (r1 != null) goto L8;
    L10:
        if (r2 == false) goto L12;
        return;
    L12:
        int r3 = this.i;
        if (r3 < 8) goto L16;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AIMediaCodecLifecycleMonitor", "stop resubscribe: reached max attempts=" + this.i, null, 4, null);
        return;
    L16:
        long r4 = RangesKt.coerceAtMost(5000 << r3, 300000);
        this.i++;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AIMediaCodecLifecycleMonitor", "schedule resubscribe delayMs=" + r4 + " attempt=" + this.i, false, 4, null);
        this.h = kotlinx.coroutines.i.a(this.f12567b, null, null, (Function2) ZeusTransformUtils.preCheckCast(new AIMediaCodecLifecycleMonitor$scheduleResubscribe$1(r4, this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return;
    L8:
        if (r1.a() != true) goto L10;
        r2 = true;
        goto L10
    }

    private final void e() {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        c r2 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        Object r3 = Result.m1421constructorimpl(r2.c.a(r2.g, 100));     // Catch: Throwable -> L5
    L8:
        if (Result.m1428isSuccessimpl(r3) == false) goto L12;
        f r0 = (f) ZeusTransformUtils.preCheckCast(r3, f.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L12;
        a(r0);
    L12:
        Throwable r5 = Result.m1424exceptionOrNullimpl(r3);
        if (r5 == null) goto L18;
        RunLog.INSTANCE.warn("AIMediaCodecLifecycleMonitor", "query failed", r5);
        return;
    L18:
        return;
    L5:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r3 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public static /* synthetic */ Unit lambda$5Un4045xG5hU4NqHZcOQL1W1K10(c r0, int r1) {
        return a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$n6CVkSXIpzhAPFRUCU-2VoAPI1g, reason: not valid java name */
    public static /* synthetic */ Unit m1121lambda$n6CVkSXIpzhAPFRUCU2VoAPI1g(c r0, f r1) {
        return b(r0, r1);
    }

    @Override // com.obric.memorydata.recommend.screenshotupload.sampling.aimedia.h
    public void a() {
        if (this.e.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        this.i = 0;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AIMediaCodecLifecycleMonitor", "start monitor lastSequence=" + this.g, false, 4, null);
        kotlinx.coroutines.i.a(this.f12567b, null, null, (Function2) ZeusTransformUtils.preCheckCast(new AIMediaCodecLifecycleMonitor$start$1(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    @Override // com.obric.memorydata.recommend.screenshotupload.sampling.aimedia.h
    public void b() {
        if (this.e.compareAndSet(true, false) == true) goto L5;
        return;
    L5:
        bx r0 = this.h;
        if (r0 == null) goto L8;
        bx.a.a(r0, null, 1, null);
    L8:
        this.h = null;
        this.i = 0;
        int r1 = this.f;
        this.f = 0;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AIMediaCodecLifecycleMonitor", "stop monitor subscriptionId=" + r1 + " lastSequence=" + this.g, false, 4, null);
        this.g = 0;
        if (r1 <= 0) goto L12;
        kotlinx.coroutines.i.a(this.f12567b, null, null, (Function2) ZeusTransformUtils.preCheckCast(new AIMediaCodecLifecycleMonitor$stop$1(this, r1, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return;
    }
}
