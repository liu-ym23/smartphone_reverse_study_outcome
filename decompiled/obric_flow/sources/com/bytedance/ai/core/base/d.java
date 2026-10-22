package com.bytedance.ai.core.base;

import com.bytedance.ai.model.AppletRuntime;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f2091a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f2092b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final kotlinx.coroutines.internal.c f2093c;
    public final AtomicBoolean d;
    public Job e;

    public d(kotlinx.coroutines.internal.c r5) {
        Intrinsics.checkNotNullParameter(r5, "coroutineScope");
        this.f2091a = new AtomicInteger(0);
        this.f2093c = r5;
        this.d = new AtomicBoolean(false);
        this.f2092b = new c(this);
    }

    public final void h() {
        int r5 = this.f2091a.decrementAndGet();
        c r10 = this.f2092b;
        if (r10 == null) goto L5;
        r10.invoke(Integer.valueOf(r5));
    L5:
        String r11 = ((AppletRuntime) this).f2197h.F + " refCount -1 ==> " + r5;
        Intrinsics.checkNotNullParameter("WorkerRuntime", "tag");
        t0.d r12 = com.bytedance.ai.utils.c.f2846a;
        if (r12 == null) goto L9;
        r12.i("WorkerRuntime", r11);
        return;
    }

    public final void i() {
        int r5 = this.f2091a.incrementAndGet();
        c r10 = this.f2092b;
        if (r10 == null) goto L5;
        r10.invoke(Integer.valueOf(r5));
    L5:
        String r11 = ((AppletRuntime) this).f2197h.F + " refCount +1 ==> " + r5;
        Intrinsics.checkNotNullParameter("WorkerRuntime", "tag");
        t0.d r12 = com.bytedance.ai.utils.c.f2846a;
        if (r12 == null) goto L9;
        r12.i("WorkerRuntime", r11);
        return;
    }

    public abstract void j();
}
