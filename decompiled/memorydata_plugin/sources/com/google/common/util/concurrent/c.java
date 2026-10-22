package com.google.common.util.concurrent;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
abstract class c<I, O, F, T> extends g.a<O> implements Runnable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    l<? extends I> f4856b;
    F c;

    private static final class a<I, O> extends c<I, O, com.google.common.base.g<? super I, ? extends O>, O> {
        a(l<? extends I> r3, com.google.common.base.g<? super I, ? extends O> r4) {
            super((l) ZeusTransformUtils.wrapperContextForParams(r3, l.class, "com.obric.memorydata.plugin"), (com.google.common.base.g) ZeusTransformUtils.wrapperContextForParams(r4, com.google.common.base.g.class, "com.obric.memorydata.plugin"));
        }

        O a(com.google.common.base.g<? super I, ? extends O> r2, I r3) {
            return (O) ((com.google.common.base.g) ZeusTransformUtils.wrapperContextForParams(r2, com.google.common.base.g.class, "com.obric.memorydata.plugin")).apply(r3);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.util.concurrent.c
        /* synthetic */ Object a(Object r3, Object r4) {
            return a((com.google.common.base.g) ZeusTransformUtils.preCheckCast(r3, com.google.common.base.g.class, "com.obric.memorydata.plugin"), r4);
        }

        @Override // com.google.common.util.concurrent.c
        void setResult(O r1) {
            a(r1);
        }
    }

    c(l<? extends I> r3, F r4) {
        this.f4856b = (l) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a((l) ZeusTransformUtils.wrapperContextForParams(r3, l.class, "com.obric.memorydata.plugin")), l.class, "com.obric.memorydata.plugin");
        this.c = (F) com.google.common.base.n.a(r4);
    }

    static <I, O> l<O> a(l<I> r2, com.google.common.base.g<? super I, ? extends O> r3, Executor r4) {
        l r5 = (l) ZeusTransformUtils.wrapperContextForParams(r2, l.class, "com.obric.memorydata.plugin");
        com.google.common.base.g r6 = (com.google.common.base.g) ZeusTransformUtils.wrapperContextForParams(r3, com.google.common.base.g.class, "com.obric.memorydata.plugin");
        Executor r7 = (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r6);
        a r0 = new a(r5, r6);
        r5.addListener(r0, s.a(r7, r0));
        return r0;
    }

    abstract T a(F r1, I r2);

    @Override // com.google.common.util.concurrent.a
    public final void c() {
        a(this.f4856b);
        this.f4856b = null;
        this.c = null;
    }

    @Override // com.google.common.util.concurrent.a
    public String e() {
        l<? extends I> r0 = this.f4856b;
        F r1 = this.c;
        String r4 = super.e();
        if (r0 == null) goto L5;
        String r2 = "inputFuture=[" + r0 + "], ";
    L6:
        if (r1 == null) goto L10;
        StringBuilder r5 = new StringBuilder().append(r2).append("function=[").append(r1).append("]");
    L9:
        return r5.toString();
    L10:
        if (r4 == null) goto L12;
        r5 = new StringBuilder().append(r2).append(r4);
        goto L9
    L12:
        return null;
    L5:
        r2 = "";
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        l<? extends I> r0 = this.f4856b;
        F r1 = this.c;
        boolean r2 = isCancelled();
        boolean r3 = true;
        if (r0 != null) goto L5;
        boolean r5 = true;
    L6:
        boolean r4 = r2 | r5;
        if (r1 == null) goto L11;
        r3 = false;
    L11:
        if ((r4 | r3) == false) goto L13;
        return;
    L13:
        this.f4856b = null;
        if (r0.isCancelled() == false) goto L43;
        a(r0);
        return;
    L43:
        Object r6 = a(r1, h.a(r0));     // Catch: Throwable -> L21
        this.c = null;
        setResult(r6);
        return;
    L21:
        th = move-exception;
        v.a(th);     // Catch: Throwable -> L25
        a(th);     // Catch: Throwable -> L25
        this.c = null;
        return;
    L25:
        th = move-exception;
        this.c = null;
        throw th;
    L28:
        e = move-exception;
        a(e);
        return;
    L37:
        cancel(false);
        return;
    L31:
        e = move-exception;
        a(e);
        return;
    L34:
        e = move-exception;
        a(e.getCause());
        return;
    L5:
        r5 = false;
        goto L6
    }

    abstract void setResult(T r1);
}
