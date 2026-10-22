package com.bytedance.android.ec.core.imagex.common;

import android.os.Looper;
import android.os.Process;
import com.bytedance.android.ec.core.imagex.ImageExperiments;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AsyncWorker {
    public static final Executor a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final AsyncWorker d = null;

    public static final class a implements Runnable {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ Function0 b;

        public a(boolean r1, Function0 r10) {
            this.a = r1;
            this.b = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Executor r0 = AsyncWorker.a;     // Catch: Throwable -> L13
            Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
            if (this.a == false) goto L6;
            Process.setThreadPriority(-4);     // Catch: Throwable -> L9
        L7:
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L9
        L11:
            this.b.invoke();     // Catch: Throwable -> L13
            return;
        L6:
            Process.setThreadPriority(0);     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L13
            Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L17;
            return;
        L17:
            throw th;
        }
    }

    public AsyncWorker() {
    }

    static {
        d = new AsyncWorker();
        ImageExperiments.G.getClass();
        if (((Boolean) ImageExperiments.j.getValue()).booleanValue() == false) goto L5;
        b r0 = new b("AsyncWorker");
    L6:
        a = r0;
        b = LazyKt.lazy(AsyncWorker$workerDispatcher$2.INSTANCE);
        c = LazyKt.lazy(AsyncWorker$highPriorityDispatcher$2.INSTANCE);
        return;
    L5:
        r0 = new PThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("n/AsyncWorker"));
        goto L6
    }

    public static boolean a() {
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()) == true) goto L5;
    L7:
        return false;
    L5:
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L7;
        return true;
    }

    public final void b(boolean r10, boolean r11, Function0<Unit> r12) {
        Intrinsics.checkNotNullParameter(r12, "block");
        if (r10 == true) goto L5;
    L7:
        Executor r13 = a;
        if (r11 == false) goto L10;
        int r1 = -4;
    L11:
        r13.execute(new v.a(Integer.valueOf(r1), new a(r11, r12)));
        return;
    L10:
        r1 = 0;
        goto L11
    L5:
        if (a() == true) goto L7;
        r12.invoke();
    }
}
