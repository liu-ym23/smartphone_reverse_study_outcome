package com.bytedance.applog.priority.original;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.applog.priority.PriorityCallback;
import com.bytedance.applog.priority.PriorityHttpResponse;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.cae.userAware.WifiScanStateMachine;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlinx.coroutines.al;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 ,2\u00060\u0001j\u0002`\u0002:\u0001,B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\u0006\u0010\u001d\u001a\u00020\u001eJ\b\u0010\u001f\u001a\u00020\u001eH\u0002J\b\u0010 \u001a\u00020\u001eH\u0016J1\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u00182\u000e\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010%0$2\u0006\u0010&\u001a\u00020\u001aH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010'J\u0014\u0010(\u001a\u00020\u001e2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\b\u0010)\u001a\u00020\u001eH\u0002J\b\u0010*\u001a\u00020+H\u0016R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR#\u0010\u0011\u001a\n \u0013*\u0004\u0018\u00010\u00120\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006-"}, d2 = {"Lcom/bytedance/applog/priority/original/Worker;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "priorityName", "Lcom/bytedance/applog/priority/original/Model$PriorityName;", "priorityContext", "Lcom/bytedance/applog/priority/original/Model$PriorityInnerContext;", "sourceGroups", "", "Lcom/bytedance/applog/priority/original/Group;", "(Lcom/bytedance/applog/priority/original/Model$PriorityName;Lcom/bytedance/applog/priority/original/Model$PriorityInnerContext;Ljava/util/List;)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "coroutineScope$delegate", "Lkotlin/Lazy;", "globalSchedulerExecutor", "Ljava/util/concurrent/ScheduledExecutorService;", "kotlin.jvm.PlatformType", "getGlobalSchedulerExecutor", "()Ljava/util/concurrent/ScheduledExecutorService;", "globalSchedulerExecutor$delegate", "groups", "Lcom/bytedance/applog/priority/original/GroupInterface;", "interval", "", CommonConsts.TIMER_TYPE, "Lcom/bytedance/applog/priority/original/Timer;", ObricMemoryConstants.VALUE_IN_APP_SIGNAL_ACTION_FLUSH, "", "handleMissedGroups", "run", "runGroup", com.loc.o.f, "header", "Lkotlin/Lazy;", "Lorg/json/JSONObject;", "runTimeSecs", "(Lcom/bytedance/applog/priority/original/GroupInterface;Lkotlin/Lazy;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setGroups", "startWorkerTimer", "toString", "", "Companion", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class v implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f1857a = null;
    private static boolean i;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Model.PriorityName f1858b;
    private final Model.f c;
    private final Lazy d;
    private long e;
    private final t f;
    private List<? extends n> g;
    private final Lazy h;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/applog/priority/original/Worker$Companion;", "", "()V", "newThreadEveryGroup", "", "getNewThreadEveryGroup", "()Z", "setNewThreadEveryGroup", "(Z)V", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0004"}, d2 = {"com/bytedance/applog/priority/original/Worker$run$header$1", "Lcom/bytedance/applog/priority/original/ValueLoader;", "Lorg/json/JSONObject;", "load", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b implements u<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ v f1859a;

        b(v r1) {
            this.f1859a = r1;
        }

        public JSONObject a() {
            String r0 = v.a(this.f1859a).getContext().a().f().getHeaderJson();
            if (r0 != null) goto L5;
        L18:
            v.a(this.f1859a).getContext().b().a("Worker:run", (Function0) ZeusTransformUtils.preCheckCast(new Worker$run$header$1$load$1(this), Function0.class, "com.obric.memorydata.plugin"));
            return null;
        L5:
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L7;
            boolean r4 = true;
        L8:
            if (r4 == true) goto L18;
            return new JSONObject(r0);
        L12:
            e = move-exception;
            if (v.a(this.f1859a).getContext().a().f().isMonitorEnabled() == false) goto L16;
            v.a(this.f1859a).getContext().a().f().monitorError("priority parse header error", e.toString());
        L16:
            v.a(this.f1859a).getContext().b().a("Worker:run", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new Worker$run$header$1$load$2(this), Function0.class, "com.obric.memorydata.plugin"));
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

    static {
        f1857a = new a(null);
    }

    public v(Model.PriorityName r5, Model.f r6, List<m> r7) {
        List<m> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "priorityName");
        Intrinsics.checkNotNullParameter(r6, "priorityContext");
        Intrinsics.checkNotNullParameter(r8, "sourceGroups");
        this.f1858b = r5;
        this.c = r6;
        this.d = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new Worker$globalSchedulerExecutor$2(this), Function0.class, "com.obric.memorydata.plugin"));
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");
        Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r11 = r9.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r10.add(Long.valueOf(((m) ZeusTransformUtils.preCheckCast(r11.next(), m.class, "com.obric.memorydata.plugin")).a().c()));
        goto L4
    L6:
        this.e = e.a(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")));
        if (i == false) goto L9;
        t r12 = (t) ZeusTransformUtils.preCheckCast(new p(), t.class, "com.obric.memorydata.plugin");
    L10:
        this.f = r12;
        this.g = CollectionsKt.emptyList();
        this.h = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new Worker$coroutineScope$2(this), Function0.class, "com.obric.memorydata.plugin"));
        a(r8);
        return;
    L9:
        r12 = new t(b(), (Runnable) ZeusTransformUtils.preCheckCast(this, Runnable.class, "com.obric.memorydata.plugin"), this.e);
        goto L10
    }

    public static final /* synthetic */ Model.f a(v r0) {
        return r0.c;
    }

    private final Object a(n r2, Lazy<? extends JSONObject> r3, long r4, Continuation<? super Unit> r6) {
        n r1 = (n) ZeusTransformUtils.wrapperContextForParams(r2, n.class, "com.obric.memorydata.plugin");
        Lazy<? extends JSONObject> r5 = (Lazy) ZeusTransformUtils.wrapperContextForParams(r3, Lazy.class, "com.obric.memorydata.plugin");
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        r1.a(r5, r4);
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ Object a(v r8, n r9, Lazy r10, long r11, Continuation r13) {
        return r8.a((n) ZeusTransformUtils.wrapperContextForParams(r9, n.class, "com.obric.memorydata.plugin"), (Lazy) ZeusTransformUtils.wrapperContextForParams(r10, Lazy.class, "com.obric.memorydata.plugin"), r11, (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private static final void a(g r11, final int r12, final v r13) {
        final g r14 = (g) ZeusTransformUtils.wrapperContextForParams(r11, g.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r14, "$db");
        Intrinsics.checkNotNullParameter(r13, "this$0");
        Pair<HashMap<Model.a, JSONObject>, Boolean> r0 = r14.a(r12, 3145728, 2000, WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_WEEK_MS, (Function1) ZeusTransformUtils.preCheckCast(new Worker$handleMissedGroups$3$1(r13), Function1.class, "com.obric.memorydata.plugin"));
        final HashMap r2 = (HashMap) ZeusTransformUtils.preCheckCast(r0.component1(), HashMap.class, "com.obric.memorydata.plugin");
        boolean r1 = ((Boolean) ZeusTransformUtils.preCheckCast(r0.component2(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        r13.c.getContext().b().a("Worker:handleMissedGroups", (Function0) ZeusTransformUtils.preCheckCast(new Worker$handleMissedGroups$3$2(r13, r12, r2), Function0.class, "com.obric.memorydata.plugin"));
        if (r2.isEmpty() == false) goto L5;
        return;
    L5:
        JSONObject r3 = new JSONObject();
        r3.put("header", e.a(r13.c.getContext().a().f(), 10));
        e.a(r3, (Map) ZeusTransformUtils.preCheckCast(r2, Map.class, "com.obric.memorydata.plugin"), r13.c.getContext().b());
        e.a(r3);
        if (r13.c.getContext().a().d() == false) goto L8;
        Pair<String, String> r4 = e.a(r3, r13.c.getContext().a().e());
    L9:
        r13.c.getContext().a().f().monitorIncreaseStats("REPORT_REQUEST_COUNT", 1);
        r13.c.getContext().a().f().monitorIncreaseStats("REPORT_REQUEST_MISS_GROUP_COUNT", 1);
        String r7 = e.a(r12, r13.c.getContext().d(), r13.c.getContext().e());
        PriorityCallback r8 = r13.c.getContext().a().f();
        String r5 = r3.toString();
        Intrinsics.checkNotNullExpressionValue(r5, "packJson.toString()");
        byte[] r6 = r5.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(r6, "this as java.lang.String).getBytes(charset)");
        final PriorityHttpResponse r9 = r8.doHttpPost(r7, r6, r4);
        int r10 = r9.getCode();
        if (200 <= r10) goto L12;
    L14:
        boolean r15 = false;
    L15:
        if (r15 == false) goto L19;
        r13.c.getContext().b().a("Worker:handleMissedGroups", (Function0) ZeusTransformUtils.preCheckCast(new Worker$handleMissedGroups$3$3(r13, r12, r2, r14), Function0.class, "com.obric.memorydata.plugin"));
        Set r16 = r2.keySet();
        Intrinsics.checkNotNullExpressionValue(r16, "events.keys");
        r14.a((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"));
        e.a(r13.c.getContext().a().f(), "3F", (Map) ZeusTransformUtils.preCheckCast(r2, Map.class, "com.obric.memorydata.plugin"), Model.PriorityName.P2, r12);
        e.a(r13.c.getContext().a().f(), r12, (Map) ZeusTransformUtils.preCheckCast(r2, Map.class, "com.obric.memorydata.plugin"));
        r13.c.getContext().a().f().monitorIncreaseStats("priority_request_success_cnt", 1);
        if (r1 == true) goto L21;
        r14.b();
        return;
    L21:
        return;
    L19:
        r13.c.getContext().b().a("Worker:handleMissedGroups", null, (Function0) ZeusTransformUtils.preCheckCast(new Worker$handleMissedGroups$3$4(r13, r14, r2, r9), Function0.class, "com.obric.memorydata.plugin"));
        e.a(r13.c.getContext().a().f(), "3B", (Map) ZeusTransformUtils.preCheckCast(r2, Map.class, "com.obric.memorydata.plugin"), Model.PriorityName.P2, 0);
        r13.c.getContext().a().f().monitorIncreaseStats("priority_request_failed_cnt", 1);
        return;
    L12:
        if (r10 >= 300) goto L14;
        r15 = true;
        goto L15
    L8:
        r4 = null;
        goto L9
    }

    private final ScheduledExecutorService b() {
        return (ScheduledExecutorService) ZeusTransformUtils.preCheckCast(this.d.getValue(), ScheduledExecutorService.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ al b(v r0) {
        return r0.c();
    }

    private final al c() {
        return (al) ZeusTransformUtils.preCheckCast(this.h.getValue(), al.class, "com.obric.memorydata.plugin");
    }

    private final void d() {
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(this.g, Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add(Long.valueOf(((n) ZeusTransformUtils.preCheckCast(r2.next(), n.class, "com.obric.memorydata.plugin")).c()));
        goto L4
    L6:
        long r3 = e.a(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")));
        this.e = r3;
        this.f.a(r3);
        if (this.g.isEmpty() == false) goto L11;
        this.c.getContext().b().a("Worker:startWorkerTimer", null, (Function0) ZeusTransformUtils.preCheckCast(new Worker$startWorkerTimer$1(this), Function0.class, "com.obric.memorydata.plugin"));
        return;
    }

    private final void e() {
        Set<Integer> r0 = this.c.a().a(this.f1858b).a();
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(this.g, Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r2.add(Integer.valueOf(((n) ZeusTransformUtils.preCheckCast(r3.next(), n.class, "com.obric.memorydata.plugin")).d()));
        goto L4
    L6:
        Set r4 = CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r7 = r5.iterator();
    L8:
        if (r7.hasNext() == false) goto L12;
        Object r8 = r7.next();
        if ((!r4.contains(Integer.valueOf(((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.memorydata.plugin")).intValue()))) == false) goto L8;
        r6.add(r8);
        goto L8
    L12:
        final Set r9 = CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        if (r9.isEmpty() == false) goto L16;
        this.c.getContext().b().a("Worker:handleMissedGroups", (Function0) ZeusTransformUtils.preCheckCast(new Worker$handleMissedGroups$1(this), Function0.class, "com.obric.memorydata.plugin"));
        return;
    L16:
        this.c.getContext().b().a("Worker:handleMissedGroups", (Function0) ZeusTransformUtils.preCheckCast(new Worker$handleMissedGroups$2(r9), Function0.class, "com.obric.memorydata.plugin"));
        ExecutorService r10 = Executors.newFixedThreadPool(RangesKt.coerceAtMost(r9.size(), 3));
        Iterator r11 = r9.iterator();
    L18:
        if (r11.hasNext() == false) goto L20;
        final int r12 = ((Number) ZeusTransformUtils.preCheckCast(r11.next(), Number.class, "com.obric.memorydata.plugin")).intValue();
        final g r13 = this.c.a().a(this.f1858b);
        r10.submit(new $$Lambda$v$E7Me4pXGiHH5CD_2N83ezUegVwY(r13, r12, this));
        goto L18
    }

    public static /* synthetic */ void lambda$E7Me4pXGiHH5CD_2N83ezUegVwY(g r0, int r1, v r2) {
        a(r0, r1, r2);
    }

    public final void a() {
        this.c.getContext().b().a("Worker:flush", (Function0) ZeusTransformUtils.preCheckCast(new Worker$flush$1(this), Function0.class, "com.obric.memorydata.plugin"));
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(this.g, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((n) ZeusTransformUtils.preCheckCast(r0.next(), n.class, "com.obric.memorydata.plugin")).h();
        goto L4
    L6:
        this.f.a();
    }

    public final void a(List<m> r8) {
        final List<? extends n> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "sourceGroups");
        this.c.getContext().b().a("Worker:setGroups", (Function0) ZeusTransformUtils.preCheckCast(new Worker$setGroups$1(this, r9), Function0.class, "com.obric.memorydata.plugin"));
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(this.g, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((n) ZeusTransformUtils.preCheckCast(r0.next(), n.class, "com.obric.memorydata.plugin")).g();
        goto L4
    L6:
        this.c.getContext().b().a("Worker:setGroups", (Function0) ZeusTransformUtils.preCheckCast(new Worker$setGroups$3(this), Function0.class, "com.obric.memorydata.plugin"));
        if (i == false) goto L13;
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r11 = r10.iterator();
    L10:
        if (r11.hasNext() == false) goto L12;
        r1.add(new q((m) ZeusTransformUtils.preCheckCast(r11.next(), m.class, "com.obric.memorydata.plugin"), this.c.getContext().b(), this.c.getContext().a().f()));
        goto L10
    L12:
        this.g = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
    L14:
        e();
        this.c.getContext().b().a("Worker:setGroups", (Function0) ZeusTransformUtils.preCheckCast(new Worker$setGroups$5(this), Function0.class, "com.obric.memorydata.plugin"));
        return;
    L13:
        this.g = r9;
        d();
        goto L14
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.getContext().b().a("Worker:run", (Function0) ZeusTransformUtils.preCheckCast(new Worker$run$1(this), Function0.class, "com.obric.memorydata.plugin"));
        long r10 = System.currentTimeMillis() / ((long) 1000);
        if (this.c.getContext().a().f().isNetworkAvailable() == true) goto L6;
        this.c.getContext().b().a("Worker:run", (Function0) ZeusTransformUtils.preCheckCast(new Worker$run$2(this), Function0.class, "com.obric.memorydata.plugin"));
        return;
    L6:
        o r9 = new o((u) ZeusTransformUtils.preCheckCast(new b(this), u.class, "com.obric.memorydata.plugin"));
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(this.g, Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r2 = r0.iterator();
    L8:
        if (r2.hasNext() == false) goto L12;
        Object r4 = r2.next();
        if (((n) ZeusTransformUtils.preCheckCast(r4, n.class, "com.obric.memorydata.plugin")).a(r10) == false) goto L8;
        r1.add(r4);
        goto L8
    L12:
        final List r8 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");
        this.c.getContext().b().a("Worker:run", (Function0) ZeusTransformUtils.preCheckCast(new Worker$run$3(this, r8), Function0.class, "com.obric.memorydata.plugin"));
        kotlinx.coroutines.i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new Worker$run$4(this, r8, r9, r10, null), Function2.class, "com.obric.memorydata.plugin"), 1, null);
    }

    public String toString() {
        return "Worker-" + this.f1858b.name();
    }
}
