package com.ss.android.lark.officesdk.chameleon.assembly.doubao.common.deps;

import android.os.Handler;
import android.os.Looper;
import com.larus.init.task.f0;
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ThreadDependency implements ntb.w {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;

    @Override // ntb.w
    public final ExecutorService S() {
        return (ExecutorService) this.b.getValue();
    }

    @Override // ntb.w
    public final ExecutorService a0() {
        return (ExecutorService) this.a.getValue();
    }

    @Override // ntb.w
    public final ExecutorService w() {
        return (ExecutorService) this.c.getValue();
    }

    public ThreadDependency() {
        this.a = LazyKt.lazy(ThreadDependency$_fixedThreadPool$2.INSTANCE);
        this.b = LazyKt.lazy(ThreadDependency$_cachedThreadPool$2.INSTANCE);
        this.c = LazyKt.lazy(ThreadDependency$_ioThreadPool$2.INSTANCE);
        this.d = LazyKt.lazy(ThreadDependency$_cpuThreadPool$2.INSTANCE);
        this.e = LazyKt.lazy(ThreadDependency$_mainHandler$2.INSTANCE);
    }

    @Override // ntb.w
    public final boolean I() {
        return Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper());
    }

    @Override // ntb.w
    public final void E(Runnable r2) {
        Intrinsics.checkNotNullParameter(r2, "runnable");
        ((ExecutorService) this.b.getValue()).execute(r2);
    }

    @Override // ntb.w
    public final void c(Runnable r2) {
        Intrinsics.checkNotNullParameter(r2, "runnable");
        if (I() == false) goto L5;
        r2.run();
        return;
    L5:
        ((Handler) this.e.getValue()).post(r2);
    }

    @Override // ntb.w
    public final void u(f0 r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "runnable");
        ((Handler) this.e.getValue()).postDelayed(r2, r3);
    }
}
