package com.bytedance.lego.init.tasks;

import android.util.Log;
import com.bytedance.lego.init.InitScheduler;
import com.bytedance.lego.init.model.BaseIdleTask;
import com.bytedance.lego.init.monitor.InitMonitor;
import com.bytedance.lego.init.monitor.c;
import com.bytedance.lego.init.util.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\b\u0010\u0011\u001a\u00020\tH\u0016R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/bytedance/lego/init/tasks/IdleTaskProxy;", "Lcom/bytedance/lego/init/model/BaseIdleTask;", "origin", "taskId", "", "uiThread", "", "executeFinish", "Lkotlin/Function0;", "", "(Lcom/bytedance/lego/init/model/BaseIdleTask;Ljava/lang/String;ZLkotlin/jvm/functions/Function0;)V", "getExecuteFinish", "()Lkotlin/jvm/functions/Function0;", "getTaskId", "()Ljava/lang/String;", "getUiThread", "()Z", "run", "initscheduler_release"}, k = 1, mv = {1, 1, 13})
public final class IdleTaskProxy extends BaseIdleTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BaseIdleTask f2795a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f2796b;
    private final boolean c;
    private final Function0<Unit> d;

    public IdleTaskProxy(BaseIdleTask r3, String r4, boolean r5, Function0<Unit> r6) {
        Function0<Unit> r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r6, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r3, "origin");
        Intrinsics.checkParameterIsNotNull(r4, "taskId");
        Intrinsics.checkParameterIsNotNull(r7, "executeFinish");
        this.f2795a = r3;
        this.f2796b = r4;
        this.c = r5;
        this.d = r7;
    }

    @Override // java.lang.Runnable
    public void run() {
        long r1 = System.currentTimeMillis();     // Catch: Throwable -> L5
        c.f2794b.a(this.f2796b, this.c);     // Catch: Throwable -> L5
        this.f2795a.run();     // Catch: Throwable -> L5
        long r3 = System.currentTimeMillis();     // Catch: Throwable -> L5
        c.f2794b.b(this.f2796b, this.c);     // Catch: Throwable -> L5
        long r4 = r3 - r1;     // Catch: Throwable -> L5
        c.f2794b.a(this.f2796b, r4, this.c);     // Catch: Throwable -> L5
        d.f2800a.b("IdleTaskDispatcher", this.f2796b + " end. cos " + r4 + " ms.");     // Catch: Throwable -> L5
    L9:
        this.d.invoke();
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
        d.f2800a.c("IdleTaskDispatcher", "\nerror!error!error!  " + this.f2796b + " run error.\n");
        d r2 = d.f2800a;
        String r5 = Log.getStackTraceString(th);
        Intrinsics.checkExpressionValueIsNotNull(r5, "Log.getStackTraceString(e)");
        r2.c("IdleTaskDispatcher", r5);
        if (InitScheduler.INSTANCE.getConfig$initscheduler_release().getCatchException() == false) goto L11;
        InitMonitor.INSTANCE.ensureNotReachHere(th, "RUN_IDLE_TASK_EXCEPTION:" + this.f2796b);
        goto L9
    L11:
        throw th;
    }
}
