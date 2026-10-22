package com.bytedance.lego.init;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import com.bytedance.lego.init.tasks.IdleTaskProxy;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"CI_ByteDanceKotlinRules_Static_Names"})
public final class IdleTaskDispatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static IdleTaskConfig f2039a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ArrayList<m3.f> f2040b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ArrayList<m3.f> f2041c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile AtomicInteger f2042d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f2043e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Handler f2044f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static volatile boolean f2045g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final b f2046h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final IdleTaskDispatcher f2047i = null;

    static final class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f2048c = null;

        static {
            f2048c = new a();
        }

        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            InitScheduler.startDispatchIdleTask();
        }
    }

    public static final class b implements MessageQueue.IdleHandler {
        b() {
        }

        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            IdleTaskDispatcher r10 = IdleTaskDispatcher.f2047i;
            if (IdleTaskDispatcher.b(r10) == true) goto L5;
            return true;
        L5:
            IdleTaskDispatcher.c(r10);
            if ((!r10.g().isEmpty()) == false) goto L8;
            return true;
        L8:
            if ((!r10.h().isEmpty()) == true) goto L13;
            return false;
        L13:
            return true;
        }
    }

    static {
        f2047i = new IdleTaskDispatcher();
        f2039a = IdleTaskConfig.Companion.a();
        f2040b = new ArrayList();
        f2041c = new ArrayList();
        f2042d = new AtomicInteger(0);
        f2044f = new Handler(Looper.getMainLooper());
        f2046h = new b();
    }

    private IdleTaskDispatcher() {
    }

    public static final /* synthetic */ void a(IdleTaskDispatcher r10) {
        r10.d();
    }

    public static final /* synthetic */ boolean b(IdleTaskDispatcher r10) {
        return f2045g;
    }

    public static final /* synthetic */ boolean c(IdleTaskDispatcher r10) {
        return r10.i();
    }

    private final void d() {
        if (f2042d.incrementAndGet() == f2043e) goto L5;
        return;
    L5:
        g.a(IdleTaskDispatcher$asyncSendMonitorData$1.INSTANCE);
    }

    private final boolean i() {
        boolean r10 = k();
        if (r10 == false) goto L5;
        return r10;
    L5:
        return j();
    }

    private final boolean j() {
        int r10 = Math.min(f2041c.size(), f2039a.getNonUIThreadTaskNum());
        int r11 = 0;
        boolean r12 = false;
    L3:
        if (r11 >= r10) goto L5;
        m3.f r13 = f2041c.remove(0);
        Intrinsics.checkExpressionValueIsNotNull(r13, "nonUiTaskList.removeAt(0)");
        final m3.f r14 = r13;
        g.a(new IdleTaskDispatcher$peekNonUITaskExecute$1(r14));
        r11 = r11 + 1;
        r12 = true;
        goto L3
    L5:
        return r12;
    }

    private final boolean k() {
        int r10 = Math.min(f2040b.size(), f2039a.getUiThreadTaskNum());
        int r11 = 0;
        boolean r12 = false;
    L3:
        if (r11 >= r10) goto L5;
        m3.f r13 = f2040b.remove(0);
        Intrinsics.checkExpressionValueIsNotNull(r13, "uiTaskList.removeAt(0)");
        m3.f r14 = r13;
        m3.b r15 = r14.f11027i;
        Intrinsics.checkExpressionValueIsNotNull(r15, "task.task");
        String r16 = r14.f11024c;
        Intrinsics.checkExpressionValueIsNotNull(r16, "task.taskId");
        new IdleTaskProxy(r15, r16, true, IdleTaskDispatcher$peekUITaskExecute$1.INSTANCE).run();
        r11 = r11 + 1;
        r12 = true;
        goto L3
    L5:
        return r12;
    }

    public final void e() {
        if (InitScheduler.INSTANCE.getConfig$initscheduler_release().isMainProcess() == true) goto L6;
        return;
    L6:
        if (f2045g == false) goto L8;
        return;
    L8:
        f2045g = true;
        ArrayList<m3.f> r10 = f2040b;
        r10.addAll(k.i());
        ArrayList<m3.f> r11 = f2041c;
        r11.addAll(k.h());
        int r12 = r10.size() + r11.size();
        f2043e = r12;
        if (r12 != 0) goto L11;
        return;
    L11:
        Looper.myQueue().addIdleHandler(f2046h);
    }

    public final void f(IdleTaskConfig r10) {
        Intrinsics.checkParameterIsNotNull(r10, "config");
        if (InitScheduler.INSTANCE.getConfig$initscheduler_release().isMainProcess() == true) goto L5;
        return;
    L5:
        f2045g = false;
        f2039a = r10;
        if (r10.getAutoIdleTask() == false) goto L9;
        f2044f.postDelayed(a.f2048c, f2039a.getBootFinishTimeOut());
        return;
    }

    public final ArrayList<m3.f> g() {
        return f2041c;
    }

    public final ArrayList<m3.f> h() {
        return f2040b;
    }
}
