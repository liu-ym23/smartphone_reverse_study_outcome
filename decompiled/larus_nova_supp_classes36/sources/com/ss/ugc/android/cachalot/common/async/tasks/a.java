package com.ss.ugc.android.cachalot.common.async.tasks;

import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.async.AsyncBindManager;
import com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.tasks.AsyncTask;
import com.ss.android.ugc.aweme.search.utils.DynamicTool;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.Field;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a<T> extends AsyncTask<T> {
    public static final Field e = null;
    public final Function0<T> b;
    public final Function0<Unit> c;
    public final Function1<Exception, Unit> d;

    /* JADX INFO: renamed from: com.ss.ugc.android.cachalot.common.async.tasks.a$a, reason: collision with other inner class name */
    public static final class C0198a {
        public static void a(Looper r3) {
            if (Intrinsics.areEqual(ThreadMethodProxy.currentThread(), ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) == false) goto L5;
            return;
        L5:
            Field r0 = a.e;
            r0.setAccessible(true);
            Object r1 = null;
            Object r2 = r0.get(null);
            if ((r2 instanceof ThreadLocal) == false) goto L9;
            r1 = r2;
        L9:
            ThreadLocal r4 = (ThreadLocal) r1;
            if (r4 == null) goto L13;
            r4.set(r3);
            return;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ a a;

        public b(a r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.c.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ a a;

        public c(a r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.c.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final void a() {
        C0198a.a(null);
        DynamicTool.b(new b(this));
    }

    static {
        e = Looper.class.getDeclaredField("sThreadLocal");
    }

    public final T d() {
        return (T) this.b.invoke();
    }

    public final void b() {
        C0198a.a(Looper.getMainLooper());
    }

    public final void c(Exception r2) {
        Intrinsics.checkNotNullParameter(r2, "e");
        Intrinsics.checkNotNullParameter(r2, "e");
        C0198a.a(null);
        this.d.invoke(r2);
        AsyncBindManager.n.getClass();
        AsyncBindManager.Companion.c(r2);
        DynamicTool.b(new c(this));
    }

    public a(Function0 r4, Function0 r5) {
        MainThreadCheckTask$2 r0 = MainThreadCheckTask$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r4, "task");
        Intrinsics.checkNotNullParameter("", "name");
        Intrinsics.checkNotNullParameter(r5, "onComplete");
        Intrinsics.checkNotNullParameter(r0, "onError");
        this.b = r4;
        this.c = r5;
        this.d = r0;
        Intrinsics.checkNotNullParameter("", "<set-?>");
        ((AsyncTask) this).a = "";
    }
}
