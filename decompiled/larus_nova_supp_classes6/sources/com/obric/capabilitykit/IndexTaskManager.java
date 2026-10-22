package com.obric.capabilitykit;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.capabilitykit.logger.Logger;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002\u001e\u001fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0012\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\bH\u0002J\r\u0010\u0014\u001a\u00020\u0015H\u0000¢\u0006\u0002\b\u0016J\u0018\u0010\u0017\u001a\u00020\u00152\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0018\u001a\u00020\u0019J\"\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0018\u001a\u00020\u0019J\u0018\u0010\u001c\u001a\u00020\u00152\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001d\u001a\u00020\u0015R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R2\u0010\r\u001a&\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u000f0\u000f \u0010*\u0012\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u000f0\u000f\u0018\u00010\u00110\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/obric/capabilitykit/IndexTaskManager;", "", "()V", "DELAY_MILLIS", "", "MSG_EXECUTE_TASK", "", "TAG", "", "currentHandlerThread", "Landroid/os/HandlerThread;", "handler", "Landroid/os/Handler;", "pendingTaskList", "", "Lcom/obric/capabilitykit/IndexTaskManager$PendingIndexTask;", "kotlin.jvm.PlatformType", "", "getFullTaskName", "taskName", "init", "", "init$capabilitykit_release", "postTask", "task", "Ljava/lang/Runnable;", "postTaskDelay", "delayTimeMs", "runTask", "scheduleRestoreHistoryProcessTask", "IndexTask", "PendingIndexTask", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class IndexTaskManager {
    private static final long DELAY_MILLIS = 60000;
    public static final IndexTaskManager INSTANCE = null;
    private static final int MSG_EXECUTE_TASK = 1;
    private static final String TAG = "IndexTaskManager";
    private static volatile HandlerThread currentHandlerThread;
    private static volatile Handler handler;
    private static final List<b> pendingTaskList = null;

    public static final class a implements Runnable {
        public final Runnable a;
        public final String b;

        public a(String r2, Runnable r3) {
            Intrinsics.checkNotNullParameter(r3, "runnable");
            this.a = r3;
            this.b = IndexTaskManager.access$getFullTaskName(IndexTaskManager.INSTANCE, r2);
        }

        public final void a() {
            Logger r0 = Logger.INSTANCE;
            r0.i(IndexTaskManager.TAG, "Task: " + this.b + ", start");
            long r4 = System.currentTimeMillis();
            this.a.run();
            r0.i(IndexTaskManager.TAG, "Task: " + this.b + " end, costTime: " + (System.currentTimeMillis() - r4));
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b {
        public final long a;
        public final String b;
        public final Runnable c;

        public b(long r2, String r4, Runnable r5) {
            Intrinsics.checkNotNullParameter(r5, "runnable");
            this.a = r2;
            this.b = r4;
            this.c = r5;
        }
    }

    public static final class c extends PthreadHandlerThreadV2 {

        public static final class a extends Handler {
            public a(Looper r1) {
                super(r1);
            }

            @Override // android.os.Handler
            public final void handleMessage(Message r2) {
                Intrinsics.checkNotNullParameter(r2, "msg");
                if (r2.what != 1) goto L6;
                p.a.b();
                return;
            }
        }

        public c() {
            super("EntityProviderThread");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void onLooperPrepared() {
            super/*android.os.HandlerThread*/.onLooperPrepared();
            IndexTaskManager r0 = IndexTaskManager.INSTANCE;
            monitor-enter(r0);
            IndexTaskManager.access$setHandler$p(new a(getLooper()));     // Catch: Throwable -> L11
            Iterator r1 = IndexTaskManager.access$getPendingTaskList$p().iterator();     // Catch: Throwable -> L11
        L6:
            if (r1.hasNext() == false) goto L8;
            b r2 = (b) r1.next();     // Catch: Throwable -> L11
            IndexTaskManager.INSTANCE.postTaskDelay(r2.a, r2.b, r2.c);     // Catch: Throwable -> L11
            goto L6
        L8:
            IndexTaskManager.access$getPendingTaskList$p().clear();     // Catch: Throwable -> L11
            monitor-exit(r0);
            return;
        L11:
            th = move-exception;
            throw th;
        }
    }

    static {
        INSTANCE = new IndexTaskManager();
        pendingTaskList = Collections.synchronizedList(new ArrayList());
    }

    private IndexTaskManager() {
    }

    public static final /* synthetic */ String access$getFullTaskName(IndexTaskManager r0, String r1) {
        return r0.getFullTaskName(r1);
    }

    public static final /* synthetic */ List access$getPendingTaskList$p() {
        return pendingTaskList;
    }

    public static final /* synthetic */ void access$setHandler$p(Handler r0) {
        handler = r0;
    }

    private final String getFullTaskName(String r4) {
        StringBuilder r0 = new StringBuilder();
        if (r4 == null) goto L6;
        String r5 = r4.concat("_");
        if (r5 == null) goto L6;
    L7:
        r0.append(r5);
        r0.append(System.currentTimeMillis());
        return r0.toString();
    L6:
        r5 = "";
        goto L7
    }

    public static /* synthetic */ void postTaskDelay$default(IndexTaskManager r0, long r1, String r3, Runnable r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L5;
        r3 = null;
    L5:
        r0.postTaskDelay(r1, r3, r4);
    }

    public final synchronized void init$capabilitykit_release() {
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L4:
        if (handler != null) goto L16;
        HandlerThread r0 = currentHandlerThread;     // Catch: Throwable -> L18
        if (r0 == null) goto L10;
        boolean r1 = true;
        if (ThreadMethodProxy.isAlive(r0) != true) goto L10;
    L11:
        if (r1 == true) goto L16;
        PthreadHandlerThreadV2 r2 = new c();     // Catch: Throwable -> L18
        currentHandlerThread = r2;     // Catch: Throwable -> L18
        ThreadMethodProxy.start(r2);     // Catch: Throwable -> L18
        Logger.INSTANCE.d(TAG, "IndexTaskManager thread start");     // Catch: Throwable -> L18
        monitor-exit(this);
        return;
    L10:
        r1 = false;
    L16:
        monitor-exit(this);
    }

    public final synchronized void postTask(String r3, Runnable r4) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r4, "task");     // Catch: Throwable -> L6
        postTaskDelay(0, r3, r4);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void postTaskDelay(long r4, String r6, Runnable r7) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r7, "task");     // Catch: Throwable -> L14
        if (handler != null) goto L9;
        Logger.INSTANCE.d(TAG, "postPending: " + r6);     // Catch: Throwable -> L14
        pendingTaskList.add(new b(r4, r6, r7));     // Catch: Throwable -> L14
        init$capabilitykit_release();     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L9:
        Logger.INSTANCE.d(TAG, "postTaskDelay: " + r6);     // Catch: Throwable -> L14
        Handler r0 = handler;     // Catch: Throwable -> L14
        if (r0 == null) goto L12;
        r0.postDelayed(new a(r6, r7), r4);     // Catch: Throwable -> L14
    L12:
        monitor-exit(this);
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public final void runTask(String r3, Runnable r4) {
        Intrinsics.checkNotNullParameter(r4, "task");
        Looper r0 = Looper.myLooper();
        if (r0 == null) goto L11;
        Handler r1 = handler;
        if (r1 == null) goto L7;
        Looper r2 = r1.getLooper();
    L9:
        if (Intrinsics.areEqual(r2, r0) == false) goto L11;
        new a(r3, r4).run();
        return;
    L7:
        r2 = null;
    L11:
        postTask(r3, r4);
    }

    public final void scheduleRestoreHistoryProcessTask() {
        Handler r0 = handler;
        if (r0 != null) goto L5;
        Logger.INSTANCE.e(TAG, "scheduleRestoreHistoryProcessTask handler is null");
        return;
    L5:
        if (r0.hasMessages(1) == false) goto L7;
        return;
    L7:
        Logger.INSTANCE.i(TAG, "scheduleRestoreHistoryProcessTask send");
        r0.sendEmptyMessageDelayed(1, DELAY_MILLIS);
    }
}
