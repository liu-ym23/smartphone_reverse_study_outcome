package io.reactivex.internal.operators.completable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.a;
import io.reactivex.c;
import io.reactivex.disposables.b;
import io.reactivex.e;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class CompletableTakeUntilCompletable extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final a f16748a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final e f16749b;

    static final class TakeUntilMainObserver extends AtomicReference<b> implements c, b {
        private static final long serialVersionUID = 3533011714830024923L;
        final c downstream;
        final AtomicBoolean once;
        final OtherObserver other;

        static final class OtherObserver extends AtomicReference<b> implements c {
            private static final long serialVersionUID = 5176264485428790318L;
            final TakeUntilMainObserver parent;

            OtherObserver(TakeUntilMainObserver r1) {
                this.parent = r1;
            }

            @Override // io.reactivex.c
            public void onComplete() {
                this.parent.innerComplete();
            }

            @Override // io.reactivex.c
            public void onError(Throwable r1) {
                this.parent.innerError(r1);
            }

            @Override // io.reactivex.c
            public void onSubscribe(b r3) {
                DisposableHelper.setOnce(this, (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin"));
            }
        }

        TakeUntilMainObserver(c r3) {
            this.downstream = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
            this.other = new OtherObserver(this);
            this.once = new AtomicBoolean();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.once.compareAndSet(false, true) == false) goto L6;
            DisposableHelper.dispose(this);
            DisposableHelper.dispose(this.other);
            return;
        }

        void innerComplete() {
            if (this.once.compareAndSet(false, true) == false) goto L6;
            DisposableHelper.dispose(this);
            this.downstream.onComplete();
            return;
        }

        void innerError(Throwable r4) {
            if (this.once.compareAndSet(false, true) == false) goto L5;
            DisposableHelper.dispose(this);
            this.downstream.onError(r4);
            return;
        L5:
            io.reactivex.d.a.a(r4);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.once.get();
        }

        @Override // io.reactivex.c
        public void onComplete() {
            if (this.once.compareAndSet(false, true) == false) goto L6;
            DisposableHelper.dispose(this.other);
            this.downstream.onComplete();
            return;
        }

        @Override // io.reactivex.c
        public void onError(Throwable r4) {
            if (this.once.compareAndSet(false, true) == false) goto L5;
            DisposableHelper.dispose(this.other);
            this.downstream.onError(r4);
            return;
        L5:
            io.reactivex.d.a.a(r4);
        }

        @Override // io.reactivex.c
        public void onSubscribe(b r3) {
            DisposableHelper.setOnce(this, (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin"));
        }
    }

    @Override // io.reactivex.a
    public void b(c r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
        TakeUntilMainObserver r0 = new TakeUntilMainObserver(r4);
        r4.onSubscribe(r0);
        this.f16749b.a(r0.other);
        this.f16748a.a(r0);
    }
}
