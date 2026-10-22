package io.reactivex.internal.operators.observable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.t;
import io.reactivex.u;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes6.dex */
public final class ObservableUnsubscribeOn<T> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final u f17014b;

    static final class UnsubscribeObserver<T> extends AtomicBoolean implements io.reactivex.disposables.b, t<T> {
        private static final long serialVersionUID = 1015244841293359600L;
        final t<? super T> downstream;
        final u scheduler;
        io.reactivex.disposables.b upstream;

        final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ UnsubscribeObserver f17015a;

            a(UnsubscribeObserver r1) {
                this.f17015a = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f17015a.upstream.dispose();
            }
        }

        UnsubscribeObserver(t<? super T> r3, u r4) {
            this.downstream = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
            this.scheduler = r4;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (compareAndSet(false, true) == false) goto L6;
            this.scheduler.a(new a(this));
            return;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get();
        }

        @Override // io.reactivex.t
        public void onComplete() {
            if (get() == true) goto L6;
            this.downstream.onComplete();
            return;
        }

        @Override // io.reactivex.t
        public void onError(Throwable r2) {
            if (get() == false) goto L6;
            io.reactivex.d.a.a(r2);
            return;
        L6:
            this.downstream.onError(r2);
        }

        @Override // io.reactivex.t
        public void onNext(T r2) {
            if (get() == true) goto L6;
            this.downstream.onNext(r2);
            return;
        }

        @Override // io.reactivex.t
        public void onSubscribe(io.reactivex.disposables.b r3) {
            io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            if (DisposableHelper.validate(this.upstream, r4) == false) goto L6;
            this.upstream = r4;
            this.downstream.onSubscribe(this);
            return;
        }
    }

    @Override // io.reactivex.Observable
    public void a(t<? super T> r3) {
        t r4 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
        this.f17034a.subscribe(new UnsubscribeObserver(r4, this.f17014b));
    }
}
