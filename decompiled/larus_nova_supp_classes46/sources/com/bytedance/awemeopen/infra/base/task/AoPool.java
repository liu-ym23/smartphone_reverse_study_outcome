package com.bytedance.awemeopen.infra.base.task;

import android.os.Looper;
import com.bytedance.awemeopen.servicesapi.thread.AoThreadService;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\u0006"}, d2 = {"Lcom/bytedance/awemeopen/infra/base/task/AoPool;", "", "", "isOnMain", "<init>", "()V", "ao_base_core_release"}, k = 1, mv = {1, 7, 1})
public final class AoPool {
    public static final AoPool a = null;
    public static final Lazy b = null;

    public static final class a implements Runnable {
        public final /* synthetic */ Function0<Unit> a;

        @Override // java.lang.Runnable
        public final void run() {
            this.a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(Function0<Unit> r1) {
            this.a = r1;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ Function0<Unit> a;

        @Override // java.lang.Runnable
        public final void run() {
            this.a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(Function0<Unit> r1) {
            this.a = r1;
        }
    }

    public AoPool() {
    }

    static {
        a = new AoPool();
        b = LazyKt.lazy(AoPool$service$2.INSTANCE);
    }

    public static AoThreadService c() {
        return (AoThreadService) b.getValue();
    }

    @JvmStatic
    public static final boolean isOnMain() {
        return Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper());
    }

    @JvmStatic
    public static final void a(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "task");
        a.getClass();
        c().executeIO(new a(r2));
    }

    @JvmStatic
    public static final void b(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "task");
        a.getClass();
        c().executeLogic(new b(r2));
    }

    @JvmStatic
    public static final void f(final Function0 r1) {
        Intrinsics.checkNotNullParameter(r1, "r");
        Intrinsics.checkNotNullParameter(r1, "r");
        if (isOnMain() == false) goto L5;
        a(new AoPool$runOnAsyncIfMain$1(r1));
        return;
    L5:
        r1.invoke();
    }

    @JvmStatic
    public static final void g(final Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "task");
        a.getClass();
        c().c(new com.bytedance.awemeopen.infra.base.task.a(r2));
    }

    @JvmStatic
    public static final void d(Runnable r1, long r2) {
        Intrinsics.checkNotNullParameter(r1, "task");
        a.getClass();
        c().F(r1, r2);
    }

    @JvmStatic
    public static final void e(final Function0<Unit> r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "task");
        a.getClass();
        c().F(new com.bytedance.awemeopen.infra.base.task.b(r2), r3);
    }
}
