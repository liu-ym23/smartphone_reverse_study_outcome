package com.bytedance.lego.init;

import ai.j0;
import android.util.Log;
import com.bytedance.lego.init.model.FeedShowTaskInfo;
import com.bytedance.lego.init.monitor.InitMonitor;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArrayList f6731a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f6732b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e f6733c = null;

    static {
        f6733c = new e();
        new AtomicInteger(0);
        f6731a = new ArrayList();
    }

    public static final void a(FeedShowTaskInfo r5, boolean r10) {
        System.currentTimeMillis();     // Catch: Exception -> L5
        com.bytedance.lego.init.monitor.b.a(r5, r10);     // Catch: Exception -> L5
        com.bytedance.lego.init.util.b.a("FeedShowTaskDispatcher", r5.taskId + " start. isUIThread: " + r10);     // Catch: Exception -> L5
        throw null;     // Catch: Exception -> L5
    L5:
        e = move-exception;
        e.printStackTrace();
        Log.e("#inittask#", "FeedShowTaskDispatcher " + j0.q(new StringBuilder("\nerror!error!error!  "), r5.taskId, " run error.\n"));
        Log.e("#inittask#", "FeedShowTaskDispatcher " + Log.getStackTraceString(e));
        if (InitScheduler.INSTANCE.getConfig$initscheduler_release().getCatchException() == false) goto L10;
        InitMonitor.INSTANCE.ensureNotReachHere(e, "RUN_FEED_SHOW_TASK_EXCEPTION:" + r5.taskId);
        return;
    L10:
        throw e;
    }
}
