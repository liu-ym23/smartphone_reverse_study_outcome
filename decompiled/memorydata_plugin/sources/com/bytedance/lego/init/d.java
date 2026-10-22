package com.bytedance.lego.init;

import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import com.bytedance.lego.init.model.BaseIdleTask;
import com.bytedance.lego.init.tasks.IdleTaskProxy;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Q\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u001a\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\u0006\u0010\u0007\u001a\u00020\u001fJ\u000e\u0010 \u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\fJ\b\u0010!\u001a\u00020\bH\u0002J\b\u0010\"\u001a\u00020\bH\u0002J\b\u0010#\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R!\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001bR!\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016¨\u0006$"}, d2 = {"Lcom/bytedance/lego/init/IdleTaskDispatcher;", "", "()V", "TAG", "", "allTaskSize", "", "bootFinish", "", "completedTaskCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "idleTaskConfig", "Lcom/bytedance/lego/init/IdleTaskConfig;", "getIdleTaskConfig", "()Lcom/bytedance/lego/init/IdleTaskConfig;", "setIdleTaskConfig", "(Lcom/bytedance/lego/init/IdleTaskConfig;)V", "nonUiTaskList", "Ljava/util/ArrayList;", "Lcom/bytedance/lego/init/model/IdleTaskInfo;", "Lkotlin/collections/ArrayList;", "getNonUiTaskList", "()Ljava/util/ArrayList;", "timeoutHandler", "Landroid/os/Handler;", "uiIdleTaskHandler", "com/bytedance/lego/init/IdleTaskDispatcher$uiIdleTaskHandler$1", "Lcom/bytedance/lego/init/IdleTaskDispatcher$uiIdleTaskHandler$1;", "uiTaskList", "getUiTaskList", "asyncSendMonitorData", "", "config", "peekIdleTaskExecute", "peekNonUITaskExecute", "peekUITaskExecute", "initscheduler_release"}, k = 1, mv = {1, 1, 13})
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f2763a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static IdleTaskConfig f2764b;
    private static final ArrayList<com.bytedance.lego.init.model.a> c = null;
    private static final ArrayList<com.bytedance.lego.init.model.a> d = null;
    private static volatile AtomicInteger e;
    private static int f;
    private static final Handler g = null;
    private static volatile boolean h;
    private static final b i = null;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 13})
    static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f2765a = null;

        static {
            f2765a = new a();
        }

        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            InitScheduler.startDispatchIdleTask();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/bytedance/lego/init/IdleTaskDispatcher$uiIdleTaskHandler$1", "Landroid/os/MessageQueue$IdleHandler;", "queueIdle", "", "initscheduler_release"}, k = 1, mv = {1, 1, 13})
    public static final class b implements MessageQueue.IdleHandler {
        b() {
        }

        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            if (d.b(d.f2763a) == true) goto L5;
            return true;
        L5:
            d.c(d.f2763a);
            if ((!((Collection) ZeusTransformUtils.preCheckCast(d.f2763a.b(), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L8;
            return true;
        L8:
            if ((!((Collection) ZeusTransformUtils.preCheckCast(d.f2763a.a(), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L13;
            return false;
        L13:
            return true;
        }
    }

    static {
        f2763a = new d();
        f2764b = IdleTaskConfig.Companion.a();
        c = new ArrayList();
        d = new ArrayList();
        e = new AtomicInteger(0);
        g = new Handler(Looper.getMainLooper());
        i = new b();
    }

    private d() {
    }

    public static final /* synthetic */ void a(d r0) {
        r0.g();
    }

    public static final /* synthetic */ boolean b(d r0) {
        return h;
    }

    public static final /* synthetic */ boolean c(d r0) {
        return r0.d();
    }

    private final boolean d() {
        boolean r0 = e();
        if (r0 == false) goto L5;
        return r0;
    L5:
        return f();
    }

    private final boolean e() {
        int r9 = Math.min(c.size(), f2764b.getUiThreadTaskNum());
        int r2 = 0;
        boolean r3 = false;
    L3:
        if (r2 >= r9) goto L5;
        com.bytedance.lego.init.model.a r4 = c.remove(0);
        Intrinsics.checkExpressionValueIsNotNull(r4, "uiTaskList.removeAt(0)");
        com.bytedance.lego.init.model.a r5 = (com.bytedance.lego.init.model.a) ZeusTransformUtils.preCheckCast(r4, com.bytedance.lego.init.model.a.class, "com.obric.memorydata.plugin");
        BaseIdleTask r6 = r5.d;
        Intrinsics.checkExpressionValueIsNotNull(r6, "task.task");
        String r7 = r5.f2781a;
        Intrinsics.checkExpressionValueIsNotNull(r7, "task.taskId");
        new IdleTaskProxy(r6, r7, true, (Function0) ZeusTransformUtils.preCheckCast(IdleTaskDispatcher$peekUITaskExecute$1.INSTANCE, Function0.class, "com.obric.memorydata.plugin")).run();
        r2 = r2 + 1;
        r3 = true;
        goto L3
    L5:
        return r3;
    }

    private final boolean f() {
        int r5 = Math.min(d.size(), f2764b.getNonUIThreadTaskNum());
        int r1 = 0;
        boolean r2 = false;
    L3:
        if (r1 >= r5) goto L5;
        com.bytedance.lego.init.model.a r3 = d.remove(0);
        Intrinsics.checkExpressionValueIsNotNull(r3, "nonUiTaskList.removeAt(0)");
        final com.bytedance.lego.init.model.a r4 = (com.bytedance.lego.init.model.a) ZeusTransformUtils.preCheckCast(r3, com.bytedance.lego.init.model.a.class, "com.obric.memorydata.plugin");
        f.a((Function0) ZeusTransformUtils.preCheckCast(new IdleTaskDispatcher$peekNonUITaskExecute$1(r4), Function0.class, "com.obric.memorydata.plugin"));
        r1 = r1 + 1;
        r2 = true;
        goto L3
    L5:
        return r2;
    }

    private final void g() {
        if (e.incrementAndGet() == f) goto L5;
        return;
    L5:
        f.a((Function0) ZeusTransformUtils.preCheckCast(IdleTaskDispatcher$asyncSendMonitorData$1.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
    }

    public final ArrayList<com.bytedance.lego.init.model.a> a() {
        return c;
    }

    public final void a(IdleTaskConfig r3) {
        Intrinsics.checkParameterIsNotNull(r3, "config");
        if (InitScheduler.INSTANCE.getConfig$initscheduler_release().isMainProcess() == true) goto L5;
        return;
    L5:
        h = false;
        f2764b = r3;
        if (r3.getAutoIdleTask() == false) goto L9;
        g.postDelayed((Runnable) ZeusTransformUtils.preCheckCast(a.f2765a, Runnable.class, "com.obric.memorydata.plugin"), f2764b.getBootFinishTimeOut());
        return;
    }

    public final ArrayList<com.bytedance.lego.init.model.a> b() {
        return d;
    }

    public final void c() {
        if (InitScheduler.INSTANCE.getConfig$initscheduler_release().isMainProcess() == true) goto L6;
        return;
    L6:
        if (h == false) goto L8;
        return;
    L8:
        h = true;
        ArrayList<com.bytedance.lego.init.model.a> r4 = c;
        r4.addAll((Collection) ZeusTransformUtils.preCheckCast(m.k(), Collection.class, "com.obric.memorydata.plugin"));
        ArrayList<com.bytedance.lego.init.model.a> r0 = d;
        r0.addAll((Collection) ZeusTransformUtils.preCheckCast(m.j(), Collection.class, "com.obric.memorydata.plugin"));
        int r5 = r4.size() + r0.size();
        f = r5;
        if (r5 != 0) goto L11;
        return;
    L11:
        Looper.myQueue().addIdleHandler((MessageQueue.IdleHandler) ZeusTransformUtils.preCheckCast(i, MessageQueue.IdleHandler.class, "com.obric.memorydata.plugin"));
    }
}
