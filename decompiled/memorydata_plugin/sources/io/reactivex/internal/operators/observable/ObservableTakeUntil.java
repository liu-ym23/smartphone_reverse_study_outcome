package io.reactivex.internal.operators.observable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.e;
import io.reactivex.s;
import io.reactivex.t;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class ObservableTakeUntil<T, U> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final s<? extends U> f17003b;

    static final class TakeUntilMainObserver<T, U> extends AtomicInteger implements io.reactivex.disposables.b, t<T> {
        private static final long serialVersionUID = 1418547743690811973L;
        final t<? super T> downstream;
        final AtomicThrowable error;
        final TakeUntilMainObserver<T, U>.OtherObserver otherObserver;
        final AtomicReference<io.reactivex.disposables.b> upstream;

        final class OtherObserver extends AtomicReference<io.reactivex.disposables.b> implements t<U> {
            private static final long serialVersionUID = -8693423678067375039L;
            final /* synthetic */ TakeUntilMainObserver this$0;

            OtherObserver(TakeUntilMainObserver r1) {
                this.this$0 = r1;
            }

            @Override // io.reactivex.t
            public void onComplete() {
                this.this$0.otherComplete();
            }

            @Override // io.reactivex.t
            public void onError(Throwable r1) {
                this.this$0.otherError(r1);
            }

            @Override // io.reactivex.t
            public void onNext(U r1) {
                DisposableHelper.dispose(this);
                this.this$0.otherComplete();
            }

            @Override // io.reactivex.t
            public void onSubscribe(io.reactivex.disposables.b r3) {
                DisposableHelper.setOnce(this, (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
            }
        }

        TakeUntilMainObserver(t<? super T> r3) {
            this.downstream = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
            this.upstream = new AtomicReference();
            this.otherObserver = new OtherObserver(this);
            this.error = new AtomicThrowable();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            DisposableHelper.dispose(this.otherObserver);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed((io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(this.upstream.get(), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
        }

        @Override // io.reactivex.t
        public void onComplete() {
            DisposableHelper.dispose(this.otherObserver);
            e.a(this.downstream, this, this.error);
        }

        @Override // io.reactivex.t
        public void onError(Throwable r3) {
            DisposableHelper.dispose(this.otherObserver);
            e.a(this.downstream, r3, this, this.error);
        }

        @Override // io.reactivex.t
        public void onNext(T r3) {
            e.a(this.downstream, r3, this, this.error);
        }

        @Override // io.reactivex.t
        public void onSubscribe(io.reactivex.disposables.b r3) {
            io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            DisposableHelper.setOnce(this.upstream, r4);
        }

        void otherComplete() {
            DisposableHelper.dispose(this.upstream);
            e.a(this.downstream, this, this.error);
        }

        void otherError(Throwable r3) {
            DisposableHelper.dispose(this.upstream);
            e.a(this.downstream, r3, this, this.error);
        }
    }

    @Override // io.reactivex.Observable
    public void a(t<? super T> r3) {
        t r4 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
        TakeUntilMainObserver r0 = new TakeUntilMainObserver(r4);
        r4.onSubscribe(r0);
        this.f17003b.subscribe(r0.otherObserver);
        this.f17034a.subscribe(r0);
    }
}
