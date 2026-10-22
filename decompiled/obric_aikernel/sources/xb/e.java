package xb;

import io.reactivex.internal.subscribers.StrictSubscriber;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e<T> implements tc.b<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final int f13578c = 0;

    static {
        f13578c = Math.max(1, Integer.getInteger("rx2.buffer-size", 128).intValue());
    }

    public e() {
    }

    public static int a() {
        return f13578c;
    }

    public final void b(g<? super T> r10) {
        io.reactivex.internal.functions.a.d(r10, "s is null");
        tc.c<? super T> r11 = dc.a.q(this, r10);     // Catch: Throwable -> L5 NullPointerException -> L8
        io.reactivex.internal.functions.a.d(r11, "The RxJavaPlugins.onSubscribe hook returned a null FlowableSubscriber. Please check the handler provided to RxJavaPlugins.setOnFlowableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");     // Catch: Throwable -> L5 NullPointerException -> L8
        c(r11);     // Catch: Throwable -> L5 NullPointerException -> L8
        return;
    L8:
        e = move-exception;
        throw e;
    L5:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        dc.a.n(th);
        NullPointerException r12 = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
        r12.initCause(th);
        throw r12;
    }

    protected abstract void c(tc.c<? super T> r10);

    @Override // tc.b
    public final void subscribe(tc.c<? super T> r10) {
        if ((r10 instanceof g) == false) goto L5;
        b((g) r10);
        return;
    L5:
        io.reactivex.internal.functions.a.d(r10, "s is null");
        b(new StrictSubscriber(r10));
    }
}
