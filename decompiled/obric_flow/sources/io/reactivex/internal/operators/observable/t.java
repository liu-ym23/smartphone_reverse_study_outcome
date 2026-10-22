package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public final class t extends io.reactivex.internal.observers.h implements Disposable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f17963h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Callable f17964i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Disposable f17965j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Collection f17966k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Object f17967l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Object f17968m;

    public t(io.reactivex.observers.d r5, Callable r10, mt.s r11) {
        this.f17963h = 1;
        super(r5, new io.reactivex.internal.queue.a());
        this.f17964i = r10;
        this.f17967l = r11;
    }

    @Override // io.reactivex.internal.observers.h
    public final void d(io.reactivex.observers.d r5, Object r10) {
        switch(this.f17963h) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        io.reactivex.observers.d r11 = this.f17639b;
        r11.onNext((Collection) r10);
        return;
    L6:
        io.reactivex.observers.d r12 = this.f17639b;
        r12.onNext((Collection) r10);
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        switch(this.f17963h) {
            case 0: goto L11;
            default: goto L5;
        };
    L5:
        if (this.d == true) goto L16;
        this.d = true;
        ((u) this.f17968m).dispose();
        this.f17965j.dispose();
        if (i() == false) goto L17;
        this.f17640c.clear();
        return;
    L17:
        return;
    L16:
        return;
    L11:
        if (this.d == true) goto L18;
        this.d = true;
        this.f17965j.dispose();
        DisposableHelper.dispose((AtomicReference) this.f17968m);
        if (i() == false) goto L19;
        this.f17640c.clear();
        return;
    L19:
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        switch(this.f17963h) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return this.d;
    L7:
        return this.d;
    }

    @Override // mt.u
    public final void onComplete() {
        switch(this.f17963h) {
            case 0: goto L19;
            default: goto L4;
        };
    L4:
        monitor-enter(this);
        Collection r5 = this.f17966k;     // Catch: Throwable -> L9
        if (r5 != null) goto L11;
        monitor-exit(this);     // Catch: Throwable -> L9
        return;
    L11:
        this.f17966k = null;     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        this.f17640c.offer(r5);
        this.e = true;
        if (i() == false) goto L37;
        com.lynx.tasm.behavior.utils.d.k(this.f17640c, this.f17639b, this, this);
        return;
    L37:
        return;
    L9:
        th = move-exception;
        throw th;
    L19:
        monitor-enter(this);
        Collection r10 = this.f17966k;     // Catch: Throwable -> L24
        if (r10 != null) goto L26;
        monitor-exit(this);     // Catch: Throwable -> L24
        return;
    L26:
        this.f17966k = null;     // Catch: Throwable -> L24
        monitor-exit(this);     // Catch: Throwable -> L24
        this.f17640c.offer(r10);
        this.e = true;
        if (i() == false) goto L39;
        com.lynx.tasm.behavior.utils.d.k(this.f17640c, this.f17639b, this, this);
        return;
    L39:
        return;
    L24:
        th = move-exception;
        throw th;
    }

    @Override // mt.u
    public final void onError(Throwable r5) {
        switch(this.f17963h) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        dispose();
        this.f17639b.onError(r5);
        return;
    L6:
        dispose();
        this.f17639b.onError(r5);
    }

    @Override // mt.u
    public final void onNext(Object r5) {
        switch(this.f17963h) {
            case 0: goto L16;
            default: goto L4;
        };
    L4:
        monitor-enter(this);
        Collection r10 = this.f17966k;     // Catch: Throwable -> L9
        if (r10 != null) goto L11;
        monitor-exit(this);     // Catch: Throwable -> L9
        return;
    L11:
        r10.add(r5);     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    L16:
        monitor-enter(this);
        Collection r11 = this.f17966k;     // Catch: Throwable -> L21
        if (r11 != null) goto L23;
        monitor-exit(this);     // Catch: Throwable -> L21
        return;
    L23:
        r11.add(r5);     // Catch: Throwable -> L21
        monitor-exit(this);     // Catch: Throwable -> L21
        return;
    L21:
        th = move-exception;
        throw th;
    }

    @Override // mt.u
    public final void onSubscribe(Disposable r5) {
        switch(this.f17963h) {
            case 0: goto L15;
            default: goto L5;
        };
    L5:
        if (DisposableHelper.validate(this.f17965j, r5) == false) goto L34;
        this.f17965j = r5;
        Object r10 = this.f17964i.call();     // Catch: Throwable -> L11
        io.reactivex.internal.functions.e.d(r10, "The buffer supplied is null");     // Catch: Throwable -> L11
        this.f17966k = (Collection) r10;
        u r11 = new u(this, 0);
        this.f17968m = r11;
        this.f17639b.onSubscribe(this);
        if (this.d == true) goto L35;
        ((mt.s) this.f17967l).subscribe(r11);
        return;
    L35:
        return;
    L11:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.d = true;
        r5.dispose();
        EmptyDisposable.error(th, this.f17639b);
        return;
    L34:
        return;
    L15:
        if (DisposableHelper.validate(this.f17965j, r5) == false) goto L37;
        this.f17965j = r5;
        io.reactivex.observers.d r12 = this.f17639b;
        Object r13 = this.f17964i.call();     // Catch: Throwable -> L25
        io.reactivex.internal.functions.e.d(r13, "The buffer supplied is null");     // Catch: Throwable -> L25
        this.f17966k = (Collection) r13;
        Object r14 = ((Callable) this.f17967l).call();     // Catch: Throwable -> L23
        io.reactivex.internal.functions.e.d(r14, "The boundary ObservableSource supplied is null");     // Catch: Throwable -> L23
        mt.s r15 = (mt.s) r14;     // Catch: Throwable -> L23
        s r16 = new s(this);
        ((AtomicReference) this.f17968m).set(r16);
        r12.onSubscribe(this);
        if (this.d == true) goto L38;
        r15.subscribe(r16);
        return;
    L38:
        return;
    L23:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.d = true;
        r5.dispose();
        EmptyDisposable.error(th, r12);
        return;
    L25:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.d = true;
        r5.dispose();
        EmptyDisposable.error(th, r12);
        return;
    }

    public void t() {
        Object r5 = this.f17964i.call();     // Catch: Throwable -> L22
        io.reactivex.internal.functions.e.d(r5, "The buffer supplied is null");     // Catch: Throwable -> L22
        Collection r10 = (Collection) r5;     // Catch: Throwable -> L22
        Object r11 = ((Callable) this.f17967l).call();     // Catch: Throwable -> L19
        io.reactivex.internal.functions.e.d(r11, "The boundary ObservableSource supplied is null");     // Catch: Throwable -> L19
        mt.s r12 = (mt.s) r11;     // Catch: Throwable -> L19
        s r13 = new s(this);
        if (DisposableHelper.replace((AtomicReference) this.f17968m, r13) == false) goto L18;
        monitor-enter(this);
        Collection r14 = this.f17966k;     // Catch: Throwable -> L11
        if (r14 != null) goto L13;
        monitor-exit(this);     // Catch: Throwable -> L11
        return;
    L13:
        this.f17966k = r10;     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        r12.subscribe(r13);
        k(r14, this);
        return;
    L11:
        th = move-exception;
        throw th;
    L18:
        return;
    L19:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.d = true;
        this.f17965j.dispose();
        this.f17639b.onError(th);
        return;
    L22:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        dispose();
        this.f17639b.onError(th);
    }

    public t(io.reactivex.observers.d r5, Callable r10, Callable r11) {
        this.f17963h = 0;
        super(r5, new io.reactivex.internal.queue.a());
        this.f17968m = new AtomicReference();
        this.f17964i = r10;
        this.f17967l = r11;
    }
}
