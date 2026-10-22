package io.reactivex.internal.schedulers;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.processors.UnicastProcessor;
import io.reactivex.u;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public class SchedulerWhen extends u implements io.reactivex.disposables.b {
    static final io.reactivex.disposables.b c = null;
    static final io.reactivex.disposables.b d = null;
    private final u e;
    private final io.reactivex.processors.a<io.reactivex.g<io.reactivex.a>> f;
    private io.reactivex.disposables.b g;

    static class DelayedAction extends ScheduledAction {
        private final Runnable action;
        private final long delayTime;
        private final TimeUnit unit;

        DelayedAction(Runnable r3, long r4, TimeUnit r6) {
            this.action = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
            this.delayTime = r4;
            this.unit = r6;
        }

        @Override // io.reactivex.internal.schedulers.SchedulerWhen.ScheduledAction
        public io.reactivex.disposables.b callActual(u.c r4, io.reactivex.c r5) {
            io.reactivex.c r6 = (io.reactivex.c) ZeusTransformUtils.wrapperContextForParams(r5, io.reactivex.c.class, "com.obric.memorydata.plugin");
            return r4.a(new b(this.action, r6), this.delayTime, this.unit);
        }
    }

    static class ImmediateAction extends ScheduledAction {
        private final Runnable action;

        ImmediateAction(Runnable r3) {
            this.action = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        }

        @Override // io.reactivex.internal.schedulers.SchedulerWhen.ScheduledAction
        public io.reactivex.disposables.b callActual(u.c r3, io.reactivex.c r4) {
            io.reactivex.c r5 = (io.reactivex.c) ZeusTransformUtils.wrapperContextForParams(r4, io.reactivex.c.class, "com.obric.memorydata.plugin");
            return r3.a(new b(this.action, r5));
        }
    }

    static abstract class ScheduledAction extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b {
        ScheduledAction() {
            super(SchedulerWhen.c);
        }

        void call(u.c r4, io.reactivex.c r5) {
            io.reactivex.c r6 = (io.reactivex.c) ZeusTransformUtils.wrapperContextForParams(r5, io.reactivex.c.class, "com.obric.memorydata.plugin");
            io.reactivex.disposables.b r0 = (io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(get(), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            if (r0 != SchedulerWhen.d) goto L6;
            return;
        L6:
            if (r0 == SchedulerWhen.c) goto L8;
            return;
        L8:
            io.reactivex.disposables.b r7 = callActual(r4, r6);
            if (compareAndSet(SchedulerWhen.c, r7) == true) goto L12;
            r7.dispose();
            return;
        }

        public abstract io.reactivex.disposables.b callActual(u.c r1, io.reactivex.c r2);

        @Override // io.reactivex.disposables.b
        public void dispose() {
            io.reactivex.disposables.b r0 = SchedulerWhen.d;
        L3:
            io.reactivex.disposables.b r1 = (io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(get(), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            if (r1 == SchedulerWhen.d) goto L5;
            if (compareAndSet(r1, r0) == false) goto L3;
            if (r1 == SchedulerWhen.c) goto L15;
            r1.dispose();
            return;
        L15:
            return;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return ((io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(get(), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin")).isDisposed();
        }
    }

    static final class a implements io.reactivex.b.h<ScheduledAction, io.reactivex.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final u.c f17115a;

        /* JADX INFO: renamed from: io.reactivex.internal.schedulers.SchedulerWhen$a$a, reason: collision with other inner class name */
        final class C0875a extends io.reactivex.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final ScheduledAction f17116a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ a f17117b;

            C0875a(a r1, ScheduledAction r2) {
                this.f17117b = r1;
                this.f17116a = r2;
            }

            @Override // io.reactivex.a
            public void b(io.reactivex.c r3) {
                io.reactivex.c r4 = (io.reactivex.c) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.c.class, "com.obric.memorydata.plugin");
                r4.onSubscribe(this.f17116a);
                this.f17116a.call(this.f17117b.f17115a, r4);
            }
        }

        a(u.c r1) {
            this.f17115a = r1;
        }

        public io.reactivex.a a(ScheduledAction r2) {
            return new C0875a(this, r2);
        }

        @Override // io.reactivex.b.h
        public /* synthetic */ io.reactivex.a apply(ScheduledAction r3) {
            return a((ScheduledAction) ZeusTransformUtils.preCheckCast(r3, ScheduledAction.class, "com.obric.memorydata.plugin"));
        }
    }

    static class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final io.reactivex.c f17118a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Runnable f17119b;

        b(Runnable r3, io.reactivex.c r4) {
            Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
            io.reactivex.c r6 = (io.reactivex.c) ZeusTransformUtils.wrapperContextForParams(r4, io.reactivex.c.class, "com.obric.memorydata.plugin");
            this.f17119b = r5;
            this.f17118a = r6;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f17119b.run();     // Catch: Throwable -> L5
            this.f17118a.onComplete();
            return;
        L5:
            th = move-exception;
            this.f17118a.onComplete();
            throw th;
        }
    }

    static final class c extends u.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AtomicBoolean f17120a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final io.reactivex.processors.a<ScheduledAction> f17121b;
        private final u.c c;

        c(io.reactivex.processors.a<ScheduledAction> r1, u.c r2) {
            this.f17121b = r1;
            this.c = r2;
            this.f17120a = new AtomicBoolean();
        }

        @Override // io.reactivex.u.c
        public io.reactivex.disposables.b a(Runnable r3) {
            ImmediateAction r0 = new ImmediateAction((Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin"));
            this.f17121b.onNext(r0);
            return r0;
        }

        @Override // io.reactivex.u.c
        public io.reactivex.disposables.b a(Runnable r3, long r4, TimeUnit r6) {
            DelayedAction r0 = new DelayedAction((Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin"), r4, r6);
            this.f17121b.onNext(r0);
            return r0;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.f17120a.compareAndSet(false, true) == false) goto L6;
            this.f17121b.onComplete();
            this.c.dispose();
            return;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f17120a.get();
        }
    }

    static final class d implements io.reactivex.disposables.b {
        d() {
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
        c = new d();
        d = io.reactivex.disposables.c.a();
    }

    @Override // io.reactivex.u
    public u.c a() {
        u.c r0 = this.e.a();
        io.reactivex.processors.a<T> r1 = UnicastProcessor.c().b();
        io.reactivex.g<io.reactivex.a> r2 = r1.a(new a(r0));
        c r3 = new c(r1, r0);
        this.f.onNext(r2);
        return r3;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        this.g.dispose();
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.g.isDisposed();
    }
}
