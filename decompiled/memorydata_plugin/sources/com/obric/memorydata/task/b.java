package com.obric.memorydata.task;

import android.os.SystemClock;
import android.security.obric.guard.ObricSecurityGuardStub;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.memorydata.task.impl.TaskInfo;
import com.obric.memorydata.task.impl.f;
import com.obric.memorydata.task.impl.g;
import com.obric.memorydata.utils.handler.GlobalHandlerUtil;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001!B)\b\u0002\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0015\u001a\u00020\u0016J\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000f0\u0018J\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000f0\u0018J\u0006\u0010\u001a\u001a\u00020\u001bJ\b\u0010\u001c\u001a\u00020\u001bH\u0002J\u0006\u0010\u001d\u001a\u00020\u001bJ\b\u0010\u001e\u001a\u00020\u001bH\u0002J\u0010\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u000fH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/obric/memorydata/task/BatchTaskRequest;", "Lcom/obric/memorydata/task/scheduler/OnTaskInfoCallBack;", "tasks", "", "Lcom/obric/memorydata/task/AbsTaskRequest;", LocationMonitorConst.TIMEOUT, "Lcom/obric/memorydata/task/impl/TaskTimeUnit;", "callback", "Lcom/obric/memorydata/task/BatchTaskCallBack;", "<init>", "(Ljava/util/List;Lcom/obric/memorydata/task/impl/TaskTimeUnit;Lcom/obric/memorydata/task/BatchTaskCallBack;)V", "TAG", "", "taskResults", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/obric/memorydata/task/impl/TaskInfo;", "taskCallbacks", "countDownLatch", "Ljava/util/concurrent/CountDownLatch;", "msgId", "", "isFinished", "", "getTaskResults", "", "execute", "enqueue", "", "scheduleTimeout", ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "makeUnFinishedTasksTimeout", "onChanged", "taskInfo", "Builder", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b implements com.obric.memorydata.task.scheduler.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<AbsTaskRequest> f12866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g f12867b;
    private final com.obric.memorydata.task.a c;
    private final String d;
    private final ConcurrentHashMap<String, TaskInfo> e;
    private final ConcurrentHashMap<String, com.obric.memorydata.task.scheduler.c> f;
    private CountDownLatch g;
    private final int h;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\f\"\u00020\u0006¢\u0006\u0002\u0010\rJ\u0014\u0010\u000b\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u0010\u001a\u00020\u0011R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/task/BatchTaskRequest$Builder;", "", "<init>", "()V", "tasks", "", "Lcom/obric/memorydata/task/AbsTaskRequest;", LocationMonitorConst.TIMEOUT, "Lcom/obric/memorydata/task/impl/TaskTimeUnit;", "callback", "Lcom/obric/memorydata/task/BatchTaskCallBack;", "setTasks", "", "([Lcom/obric/memorydata/task/AbsTaskRequest;)Lcom/obric/memorydata/task/BatchTaskRequest$Builder;", "setTimeout", "setTaskCallback", "build", "Lcom/obric/memorydata/task/BatchTaskRequest;", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private List<? extends AbsTaskRequest> f12868a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private g f12869b;
        private com.obric.memorydata.task.a c;

        public a() {
            this.f12868a = CollectionsKt.emptyList();
            this.f12869b = (g) ZeusTransformUtils.preCheckCast(new f(0), g.class, "com.obric.memorydata.plugin");
        }

        public final a a(g r2) {
            Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TIMEOUT);
            this.f12869b = r2;
            return this;
        }

        public final a a(List<? extends AbsTaskRequest> r3) {
            List<? extends AbsTaskRequest> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "tasks");
            this.f12868a = r4;
            return this;
        }

        public final b a() {
            return new b(this.f12868a, this.f12869b, this.c, null);
        }
    }

    private b(List<? extends AbsTaskRequest> r5, g r6, com.obric.memorydata.task.a r7) {
        List<AbsTaskRequest> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.task.a r9 = (com.obric.memorydata.task.a) ZeusTransformUtils.wrapperContextForParams(r7, com.obric.memorydata.task.a.class, "com.obric.memorydata.plugin");
        this.f12866a = r8;
        this.f12867b = r6;
        this.c = r9;
        this.d = "BatchTaskRequest";
        this.e = new ConcurrentHashMap();
        this.f = new ConcurrentHashMap();
        this.h = (int) SystemClock.elapsedRealtime();
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r10.hasNext() == false) goto L20;
        AbsTaskRequest r11 = (AbsTaskRequest) ZeusTransformUtils.preCheckCast(r10.next(), AbsTaskRequest.class, "com.obric.memorydata.plugin");
        if (r11.getTaskInfo().c() != TaskInfo.State.IDLE) goto L19;
        com.obric.memorydata.task.scheduler.c r12 = r11.getTaskParameter().getOnTaskInfoCallBack();
        if (r12 == null) goto L17;
        ConcurrentHashMap<String, com.obric.memorydata.task.scheduler.c> r0 = this.f;
        monitor-enter(r0);
        ((Map) ZeusTransformUtils.preCheckCast(this.f, Map.class, "com.obric.memorydata.plugin")).put(r11.getTaskParameter().getUuid().toString(), r12);     // Catch: Throwable -> L14
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r0);
    L14:
        th = move-exception;
        throw th;
    L17:
        r11.getTaskParameter().setOnTaskInfoCallBack((com.obric.memorydata.task.scheduler.c) ZeusTransformUtils.preCheckCast(this, com.obric.memorydata.task.scheduler.c.class, "com.obric.memorydata.plugin"));
        goto L4
    L19:
        throw new IllegalArgumentException("Task " + r11.getTaskParameter().getUuid() + " is already started");
    }

    public /* synthetic */ b(List r2, g r3, com.obric.memorydata.task.a r4, DefaultConstructorMarker r5) {
        this((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin"), r3, (com.obric.memorydata.task.a) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.memorydata.task.a.class, "com.obric.memorydata.plugin"));
    }

    private static final void a(b r0) {
        r0.e();
    }

    private final void d() {
        if (this.f12867b.c() <= 0) goto L6;
        GlobalHandlerUtil.Companion.getInstance().sendMsgDelay(this.h, this.f12867b.c(), new $$Lambda$b$ELVOkOUhoMDXzq7BjU5BJ1spUS8(this));
        return;
    }

    private final void e() {
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(this.f12866a, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L8;
        Object r2 = r6.next();
        if ((true ^ ((AbsTaskRequest) ZeusTransformUtils.preCheckCast(r2, AbsTaskRequest.class, "com.obric.memorydata.plugin")).getTaskInfo().c().isFinished()) == false) goto L4;
        r0.add(r2);
        goto L4
    L8:
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L10:
        if (r7.hasNext() == false) goto L12;
        AbsTaskRequest.setTimeout$default((AbsTaskRequest) ZeusTransformUtils.preCheckCast(r7.next(), AbsTaskRequest.class, "com.obric.memorydata.plugin"), null, 1, null);
        goto L10
    }

    public static /* synthetic */ void lambda$ELVOkOUhoMDXzq7BjU5BJ1spUS8(b r0) {
        a(r0);
    }

    public final Map<String, TaskInfo> a() {
        return (Map) ZeusTransformUtils.preCheckCast(this.e, Map.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.task.scheduler.c
    public void a(TaskInfo r5) {
        Intrinsics.checkNotNullParameter(r5, "taskInfo");
        com.obric.memorydata.task.scheduler.c r0 = (com.obric.memorydata.task.scheduler.c) ZeusTransformUtils.preCheckCast(this.f.get(r5.a().toString()), com.obric.memorydata.task.scheduler.c.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L6;
        r0.a(r5);
    L6:
        if (r5.c().isFinished() == false) goto L26;
        com.obric.memorydata.task.a r1 = this.c;
        if (r1 == null) goto L10;
        r1.a(r5);
    L10:
        ConcurrentHashMap<String, TaskInfo> r2 = this.e;
        monitor-enter(r2);
        ((Map) ZeusTransformUtils.preCheckCast(this.e, Map.class, "com.obric.memorydata.plugin")).put(r5.a().toString(), r5);     // Catch: Throwable -> L23
        if (this.e.size() != this.f12866a.size()) goto L20;
        com.obric.memorydata.task.a r6 = this.c;     // Catch: Throwable -> L23
        if (r6 == null) goto L17;
        r6.a((Map) ZeusTransformUtils.preCheckCast(this.e, Map.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L23
    L17:
        GlobalHandlerUtil.Companion.getInstance().removeMsgId(this.h);     // Catch: Throwable -> L23
        CountDownLatch r4 = this.g;     // Catch: Throwable -> L23
        if (r4 == null) goto L20;
        r4.countDown();     // Catch: Throwable -> L23
    L20:
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L23
        monitor-exit(r2);
        return;
    L23:
        th = move-exception;
        throw th;
    }

    public final Map<String, TaskInfo> b() {
        this.g = new CountDownLatch(1);
        c();
        CountDownLatch r0 = this.g;
        if (r0 == null) goto L6;
        r0.await();
    L6:
        return a();
    }

    public final void c() {
        d();
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f12866a, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((AbsTaskRequest) ZeusTransformUtils.preCheckCast(r3.next(), AbsTaskRequest.class, "com.obric.memorydata.plugin")).enqueue();
        goto L4
    }
}
