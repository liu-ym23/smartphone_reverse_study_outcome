package kotlinx.coroutines.sync;

import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.d2;
import kotlinx.coroutines.i;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.internal.y;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class MutexImpl$a implements i<Unit>, d2 {
    public final j<Unit> a;
    public final Object b;
    public final /* synthetic */ MutexImpl c;

    public final boolean cancel(Throwable r2) {
        return this.a.cancel(r2);
    }

    public final void d(Object r2) {
        this.a.d(r2);
    }

    public final void e(y<?> r2, int r3) {
        this.a.e(r2, r3);
    }

    public CoroutineContext getContext() {
        return this.a.getContext();
    }

    public final void i(Function1<? super Throwable, Unit> r2) {
        this.a.i(r2);
    }

    public final boolean isActive() {
        return this.a.isActive();
    }

    public final boolean isCancelled() {
        return this.a.isCancelled();
    }

    public final boolean isCompleted() {
        return this.a.isCompleted();
    }

    public final b0 m(Throwable r2) {
        return this.a.m(r2);
    }

    public final void resumeWith(Object r2) {
        this.a.resumeWith(r2);
    }

    public final b0 b(Object r3, Function1 r4) {
        final MutexImpl r5 = this.c;
        j<Unit> r0 = this.a;
        b0 r6 = r0.N((Unit) r3, null, new MutexImpl$CancellableContinuationWithOwner$tryResume$token$1(r5, this));
        if (r6 == null) goto L5;
        MutexImpl r7 = this.c;
        MutexImpl.h.set(r7, this.b);
    L5:
        return r6;
    }

    public final void f(CoroutineDispatcher r2, Object r3) {
        j<Unit> r0 = this.a;
        r0.f(r2, (Unit) r3);
    }

    public final void h(Object r3, Function1 r4) {
        MutexImpl r5 = this.c;
        MutexImpl.h.set(r5, this.b);
        j<Unit> r6 = this.a;
        r6.h((Unit) r3, new MutexImpl.CancellableContinuationWithOwner.resume.2(this.c, this));
    }

    public final b0 l(Object r3, Object r4) {
        j<Unit> r0 = this.a;
        return r0.N((Unit) r3, r4, null);
    }

    public MutexImpl$a(MutexImpl r1, j<? super Unit> r2, Object r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }
}
