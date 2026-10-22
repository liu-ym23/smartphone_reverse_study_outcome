package com.bytedance.lego.init.tasks;

import android.util.Log;
import com.bytedance.lego.init.InitScheduler;
import com.bytedance.lego.init.monitor.IdleTaskMonitor;
import com.bytedance.lego.init.monitor.InitMonitor;
import com.bytedance.lego.init.util.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import m3.b;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/lego/init/tasks/IdleTaskProxy;", "Lm3/b;", "origin", "", "taskId", "", "uiThread", "Lkotlin/Function0;", "", "executeFinish", "<init>", "(Lm3/b;Ljava/lang/String;ZLkotlin/jvm/functions/Function0;)V", "initscheduler_release"}, k = 1, mv = {1, 4, 0})
public final class IdleTaskProxy extends b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b f2116c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f2117g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f2118h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Function0<Unit> f2119i;

    public IdleTaskProxy(b r10, String r11, boolean r12, Function0<Unit> r13) {
        Intrinsics.checkParameterIsNotNull(r10, "origin");
        Intrinsics.checkParameterIsNotNull(r11, "taskId");
        Intrinsics.checkParameterIsNotNull(r13, "executeFinish");
        this.f2116c = r10;
        this.f2117g = r11;
        this.f2118h = r12;
        this.f2119i = r13;
    }

    @Override // java.lang.Runnable
    public void run() {
        long r10 = System.currentTimeMillis();     // Catch: Throwable -> L5
        IdleTaskMonitor r11 = IdleTaskMonitor.f2107e;     // Catch: Throwable -> L5
        r11.i(this.f2117g, this.f2118h);     // Catch: Throwable -> L5
        this.f2116c.run();     // Catch: Throwable -> L5
        long r12 = System.currentTimeMillis();     // Catch: Throwable -> L5
        r11.h(this.f2117g, this.f2118h);     // Catch: Throwable -> L5
        long r13 = r12 - r10;     // Catch: Throwable -> L5
        r11.g(this.f2117g, r13, this.f2118h);     // Catch: Throwable -> L5
        c.f2121a.a("IdleTaskDispatcher", this.f2117g + " end. cos " + r13 + " ms.");     // Catch: Throwable -> L5
    L9:
        this.f2119i.invoke();
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
        c r14 = c.f2121a;
        r14.c("IdleTaskDispatcher", "\nerror!error!error!  " + this.f2117g + " run error.\n");
        String r15 = Log.getStackTraceString(th);
        Intrinsics.checkExpressionValueIsNotNull(r15, "Log.getStackTraceString(e)");
        r14.c("IdleTaskDispatcher", r15);
        if (InitScheduler.INSTANCE.getConfig$initscheduler_release().getCatchException() == false) goto L11;
        InitMonitor.INSTANCE.ensureNotReachHere(th, "RUN_IDLE_TASK_EXCEPTION:" + this.f2117g);
        goto L9
    L11:
        throw th;
    }
}
