package com.bytedance.lego.init;

import ai.j0;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.core.view.PointerIconCompat;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.lego.init.model.DelayTaskInfo;
import com.bytedance.lego.init.monitor.InitMonitor;
import java.util.LinkedHashMap;
import java.util.PriorityQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LinkedHashMap f6725a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f6726b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f6727c;
    public static long d;
    public static final Handler e = null;
    public static final c f = null;

    static {
        f = new c();
        f6725a = new LinkedHashMap();
        new AtomicInteger(0);
        d = -1;
        e = new Handler(Looper.getMainLooper(), b.f6724a);
    }

    public static final void a(PriorityQueue r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.isEmpty() == true) goto L8;
        mh.e.t(new DelayTaskDispatcher$dispatchTask$1((DelayTaskInfo) r5.poll()));
        goto L4
    }

    public static final void b(DelayTaskInfo r10, boolean r11) {
        long r5 = System.currentTimeMillis();     // Catch: Exception -> L5
        com.bytedance.lego.init.monitor.a.b(r10, r11);     // Catch: Exception -> L5
        com.bytedance.lego.init.util.b.a("DelayTaskDispatcher", r10.taskId + " start. startTimeFromOnCreateEnd: " + (r5 - d));     // Catch: Exception -> L5
        com.bytedance.lego.init.util.b.a("DelayTaskDispatcher", r10.taskId + " run. isUIThread: " + r11);     // Catch: Exception -> L5
        throw null;     // Catch: Exception -> L5
    L5:
        e = move-exception;
        Log.e("#inittask#", "DelayTaskDispatcher " + j0.q(new StringBuilder("\nerror!error!error!  "), r10.taskId, " run error.\n"));
        Log.e("#inittask#", "DelayTaskDispatcher " + Log.getStackTraceString(e));
        if (InitScheduler.INSTANCE.getConfig$initscheduler_release().getCatchException() == false) goto L10;
        InitMonitor.INSTANCE.ensureNotReachHere(e, "RUN_DELAY_TASK_EXCEPTION:" + r10.taskId);
        return;
    L10:
        throw e;
    }

    public final synchronized void c() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (f6726b == false) goto L9;
        monitor-exit(this);
        return;
    L9:
        f6726b = true;     // Catch: Throwable -> L12
        d = System.currentTimeMillis();     // Catch: Throwable -> L12
        com.bytedance.lego.init.util.b.a("DelayTaskDispatcher", "start, curTime: " + d);     // Catch: Throwable -> L12
        CopyOnWriteArrayList r5 = com.bytedance.lego.init.monitor.a.f6757a;     // Catch: Throwable -> L12
        com.bytedance.lego.init.monitor.a.f6758b = d;     // Catch: Throwable -> L12
        Handler r10 = e;     // Catch: Throwable -> L12
        r10.sendEmptyMessageDelayed(1000, WsConstants.EXIT_DELAY_TIME);     // Catch: Throwable -> L12
        r10.sendEmptyMessageDelayed(1001, 5000);     // Catch: Throwable -> L12
        r10.sendEmptyMessageDelayed(PointerIconCompat.TYPE_HAND, 8000);     // Catch: Throwable -> L12
        r10.sendEmptyMessageDelayed(PointerIconCompat.TYPE_HELP, 15000);     // Catch: Throwable -> L12
        r10.sendEmptyMessageDelayed(PointerIconCompat.TYPE_WAIT, 30000);     // Catch: Throwable -> L12
        r10.sendEmptyMessageDelayed(WebSocketProtocol.CLOSE_NO_STATUS_CODE, 60000);     // Catch: Throwable -> L12
        r10.sendEmptyMessageDelayed(PointerIconCompat.TYPE_CELL, 120000);     // Catch: Throwable -> L12
        r10.sendEmptyMessageDelayed(PointerIconCompat.TYPE_CROSSHAIR, 300000);     // Catch: Throwable -> L12
        r10.sendEmptyMessageDelayed(PointerIconCompat.TYPE_TEXT, 600000);     // Catch: Throwable -> L12
        r10.sendEmptyMessageDelayed(PointerIconCompat.TYPE_VERTICAL_TEXT, 900000);     // Catch: Throwable -> L12
        monitor-exit(this);
    }
}
