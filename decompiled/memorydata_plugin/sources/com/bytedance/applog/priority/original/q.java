package com.bytedance.applog.priority.original;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.applog.priority.PriorityCallback;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J \u0010\u001b\u001a\u00020\u00192\u000e\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001d2\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u0019H\u0016J\b\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020#H\u0016J\"\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u001eH\u0016J\b\u0010,\u001a\u00020#H\u0016J\b\u0010-\u001a\u00020.H\u0016J\u0010\u0010/\u001a\u00020.2\u0006\u0010\u001f\u001a\u00020 H\u0016J\"\u00100\u001a\u00020.2\u0006\u0010'\u001a\u00020(2\u0006\u00101\u001a\u00020*2\b\u00102\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u00103\u001a\u00020 H\u0002J\b\u00104\u001a\u00020\u0019H\u0016J\b\u00105\u001a\u00020*H\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u00066"}, d2 = {"Lcom/bytedance/applog/priority/original/RunnableGroup;", "Lcom/bytedance/applog/priority/original/GroupInterface;", "Ljava/lang/Runnable;", "group", "Lcom/bytedance/applog/priority/original/Group;", "logger", "Lcom/bytedance/applog/log/AbsLogger;", "callback", "Lcom/bytedance/applog/priority/PriorityCallback;", "(Lcom/bytedance/applog/priority/original/Group;Lcom/bytedance/applog/log/AbsLogger;Lcom/bytedance/applog/priority/PriorityCallback;)V", "getCallback", "()Lcom/bytedance/applog/priority/PriorityCallback;", "executors", "Ljava/util/concurrent/ScheduledExecutorService;", "getExecutors", "()Ljava/util/concurrent/ScheduledExecutorService;", "getGroup", "()Lcom/bytedance/applog/priority/original/Group;", "getLogger", "()Lcom/bytedance/applog/log/AbsLogger;", CommonConsts.TIMER_TYPE, "Ljava/util/concurrent/ScheduledFuture;", "getTimer", "()Ljava/util/concurrent/ScheduledFuture;", "clear", "", "destroy", "doWork", "header", "Lkotlin/Lazy;", "Lorg/json/JSONObject;", "runTimeSecs", "", ObricMemoryConstants.VALUE_IN_APP_SIGNAL_ACTION_FLUSH, "getEventCount", "", "groupId", "insertEvent", "Lcom/bytedance/applog/priority/original/Model$EventKey;", "eventType", "Lcom/bytedance/applog/priority/original/Model$EventType;", "eventName", "", "json", "interval", "isEmpty", "", "isTimeout", "match", "event", "paramJson", "minInterval", "run", "toString", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class q implements n, Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m f1848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bytedance.applog.log.a f1849b;
    private final PriorityCallback c;
    private final ScheduledExecutorService d;
    private final ScheduledFuture<?> e;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0004"}, d2 = {"com/bytedance/applog/priority/original/RunnableGroup$run$header$1", "Lcom/bytedance/applog/priority/original/ValueLoader;", "Lorg/json/JSONObject;", "load", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a implements u<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ q f1850a;

        a(q r1) {
            this.f1850a = r1;
        }

        public JSONObject a() {
            String r0 = this.f1850a.b().getHeaderJson();
            if (r0 != null) goto L5;
        L18:
            this.f1850a.a().a("RunnableGroup:run", (Function0) ZeusTransformUtils.preCheckCast(new RunnableGroup$run$header$1$load$1(this), Function0.class, "com.obric.memorydata.plugin"));
            return null;
        L5:
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L7;
            boolean r4 = true;
        L8:
            if (r4 == true) goto L18;
            return new JSONObject(r0);
        L12:
            e = move-exception;
            if (this.f1850a.b().isMonitorEnabled() == false) goto L16;
            this.f1850a.b().monitorError("priority parse header error", e.toString());
        L16:
            this.f1850a.a().a("RunnableGroup:run", null, (Function0) ZeusTransformUtils.preCheckCast(new RunnableGroup$run$header$1$load$2(this), Function0.class, "com.obric.memorydata.plugin"));
            return null;
        L7:
            r4 = false;
            goto L8
        }

        @Override // com.bytedance.applog.priority.original.u
        public /* synthetic */ JSONObject load() {
            return a();
        }
    }

    public q(m r10, com.bytedance.applog.log.a r11, PriorityCallback r12) {
        com.bytedance.applog.log.a r13 = (com.bytedance.applog.log.a) ZeusTransformUtils.wrapperContextForParams(r11, com.bytedance.applog.log.a.class, "com.obric.memorydata.plugin");
        PriorityCallback r14 = (PriorityCallback) ZeusTransformUtils.wrapperContextForParams(r12, PriorityCallback.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "group");
        Intrinsics.checkNotNullParameter(r13, "logger");
        Intrinsics.checkNotNullParameter(r14, "callback");
        this.f1848a = r10;
        this.f1849b = r13;
        this.c = r14;
        ScheduledExecutorService r2 = Executors.newSingleThreadScheduledExecutor();
        Intrinsics.checkNotNullExpressionValue(r2, "newSingleThreadScheduledExecutor()");
        this.d = r2;
        ScheduledFuture<?> r15 = r2.scheduleWithFixedDelay((Runnable) ZeusTransformUtils.preCheckCast(this, Runnable.class, "com.obric.memorydata.plugin"), 0, e(), TimeUnit.SECONDS);
        Intrinsics.checkNotNullExpressionValue(r15, "executors.scheduleWithFi…), TimeUnit.SECONDS\n    )");
        this.e = r15;
    }

    private static final void a(q r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.run();
    }

    private final long e() {
        return RangesKt.coerceAtLeast(1, this.f1848a.a().c());
    }

    /* JADX INFO: renamed from: lambda$g-4fVPKC0SR4MoeihOYmTe6Wlmc, reason: not valid java name */
    public static /* synthetic */ void m80lambda$g4fVPKC0SR4MoeihOYmTe6Wlmc(q r0) {
        a(r0);
    }

    public final com.bytedance.applog.log.a a() {
        return this.f1849b;
    }

    @Override // com.bytedance.applog.priority.original.n
    public void a(Lazy<? extends JSONObject> r3, long r4) {
        Lazy<? extends JSONObject> r5 = (Lazy) ZeusTransformUtils.wrapperContextForParams(r3, Lazy.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "header");
        this.f1848a.a(r5, r4);
    }

    @Override // com.bytedance.applog.priority.original.n
    public boolean a(long r1) {
        return false;
    }

    public final PriorityCallback b() {
        return this.c;
    }

    @Override // com.bytedance.applog.priority.original.n
    public int c() {
        return this.f1848a.c();
    }

    @Override // com.bytedance.applog.priority.original.n
    public int d() {
        return this.f1848a.d();
    }

    @Override // com.bytedance.applog.priority.original.n
    public void g() {
        this.e.cancel(false);
        this.d.shutdown();
    }

    @Override // com.bytedance.applog.priority.original.n
    public void h() {
        this.f1848a.h();
        this.d.submit(new $$Lambda$q$g4fVPKC0SR4MoeihOYmTe6Wlmc(this));
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1849b.a("RunnableGroup:run", (Function0) ZeusTransformUtils.preCheckCast(new RunnableGroup$run$1(this), Function0.class, "com.obric.memorydata.plugin"));
        if (this.c.isNetworkAvailable() == true) goto L6;
        this.f1849b.a("RunnableGroup:run", (Function0) ZeusTransformUtils.preCheckCast(new RunnableGroup$run$2(this), Function0.class, "com.obric.memorydata.plugin"));
        return;
    L6:
        a((Lazy) ZeusTransformUtils.preCheckCast(new o((u) ZeusTransformUtils.preCheckCast(new a(this), u.class, "com.obric.memorydata.plugin")), Lazy.class, "com.obric.memorydata.plugin"), System.currentTimeMillis());
    }

    public String toString() {
        return "RunnableGroup(" + this.f1848a + ')';
    }
}
