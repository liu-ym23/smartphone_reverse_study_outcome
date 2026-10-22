package io.reactivex.internal.schedulers;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import xb.p;

/* JADX INFO: loaded from: classes2.dex */
public class SchedulerWhen extends p implements io.reactivex.disposables.b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final io.reactivex.disposables.b f9610g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final io.reactivex.disposables.b f9611h = null;

    static class DelayedAction extends ScheduledAction {
        private final Runnable action;
        private final long delayTime;
        private final TimeUnit unit;

        DelayedAction(Runnable r10, long r11, TimeUnit r12) {
            this.action = r10;
            this.delayTime = r11;
            this.unit = r12;
        }

        @Override // io.reactivex.internal.schedulers.SchedulerWhen.ScheduledAction
        protected io.reactivex.disposables.b callActual(p.c r10, xb.b r11) {
            return r10.c(new a(this.action, r11), this.delayTime, this.unit);
        }
    }

    static class ImmediateAction extends ScheduledAction {
        private final Runnable action;

        ImmediateAction(Runnable r10) {
            this.action = r10;
        }

        @Override // io.reactivex.internal.schedulers.SchedulerWhen.ScheduledAction
        protected io.reactivex.disposables.b callActual(p.c r10, xb.b r11) {
            return r10.b(new a(this.action, r11));
        }
    }

    static abstract class ScheduledAction extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b {
        ScheduledAction() {
            super(SchedulerWhen.f9610g);
        }

        void call(p.c r10, xb.b r11) {
            io.reactivex.disposables.b r12 = get();
            if (r12 != SchedulerWhen.f9611h) goto L5;
            return;
        L5:
            io.reactivex.disposables.b r13 = SchedulerWhen.f9610g;
            if (r12 == r13) goto L8;
            return;
        L8:
            io.reactivex.disposables.b r14 = callActual(r10, r11);
            if (compareAndSet(r13, r14) == true) goto L12;
            r14.dispose();
            return;
        }

        protected abstract io.reactivex.disposables.b callActual(p.c r10, xb.b r11);

        @Override // io.reactivex.disposables.b
        public void dispose() {
            io.reactivex.disposables.b r10 = SchedulerWhen.f9611h;
        L3:
            io.reactivex.disposables.b r11 = get();
            if (r11 == SchedulerWhen.f9611h) goto L5;
            if (compareAndSet(r11, r10) == false) goto L3;
            if (r11 == SchedulerWhen.f9610g) goto L15;
            r11.dispose();
            return;
        L15:
            return;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get().isDisposed();
        }
    }

    static class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final xb.b f9612c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final Runnable f9613g;

        a(Runnable r10, xb.b r11) {
            this.f9613g = r10;
            this.f9612c = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f9613g.run();     // Catch: Throwable -> L5
            this.f9612c.onComplete();
            return;
        L5:
            th = move-exception;
            this.f9612c.onComplete();
            throw th;
        }
    }

    static final class b implements io.reactivex.disposables.b {
        b() {
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return false;
        }
    }

    static {
        f9610g = new b();
        f9611h = io.reactivex.disposables.c.a();
    }
}
