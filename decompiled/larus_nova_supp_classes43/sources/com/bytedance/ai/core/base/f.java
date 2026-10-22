package com.bytedance.ai.core.base;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class f {
    public final AtomicInteger a;
    public Function1<? super Integer, Unit> b;

    public void h(int r1) {
    }

    public void j(int r1) {
    }

    public final void f() {
        int r0 = this.a.decrementAndGet();
        Function1<? super Integer, Unit> r1 = this.b;
        if (r1 == null) goto L5;
        r1.invoke(Integer.valueOf(r0));
    L5:
        h(r0);
    }

    public final void g() {
        int r0 = this.a.incrementAndGet();
        Function1<? super Integer, Unit> r1 = this.b;
        if (r1 == null) goto L5;
        r1.invoke(Integer.valueOf(r0));
    L5:
        j(r0);
    }

    public f() {
        this.a = new AtomicInteger(0);
    }
}
