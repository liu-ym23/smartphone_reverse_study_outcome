package io.reactivex.internal.operators.observable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.e;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.t;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class ObservableMergeWithCompletable<T> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final e f16957b;

    static final class MergeWithObserver<T> extends AtomicInteger implements io.reactivex.disposables.b, t<T> {
        private static final long serialVersionUID = -4592979584110982903L;
        final t<? super T> downstream;
        final AtomicThrowable error;
        final AtomicReference<io.reactivex.disposables.b> mainDisposable;
        volatile boolean mainDone;
        volatile boolean otherDone;
        final OtherObserver otherObserver;

        static final class OtherObserver extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.c {
            private static final long serialVersionUID = -2935427570954647017L;
            final MergeWithObserver<?> parent;

            OtherObserver(MergeWithObserver<?> r1) {
                this.parent = r1;
            }

            @Override // io.reactivex.c
            public void onComplete() {
                this.parent.otherComplete();
            }

            @Override // io.reactivex.c
            public void onError(Throwable r1) {
                this.parent.otherError(r1);
            }

            @Override // io.reactivex.c
            public void onSubscribe(io.reactivex.disposables.b r3) {
                DisposableHelper.setOnce(this, (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
            }
        }

        MergeWithObserver(t<? super T> r3) {
            this.downstream = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
            this.mainDisposable = new AtomicReference();
            this.otherObserver = new OtherObserver(this);
            this.error = new AtomicThrowable();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this.mainDisposable);
            DisposableHelper.dispose(this.otherObserver);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed((io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(this.mainDisposable.get(), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
        }

        @Override // io.reactivex.t
        public void onComplete() {
            this.mainDone = true;
            if (this.otherDone == false) goto L6;
            io.reactivex.internal.util.e.a(this.downstream, this, this.error);
            return;
        }

        @Override // io.reactivex.t
        public void onError(Throwable r3) {
            DisposableHelper.dispose(this.otherObserver);
            io.reactivex.internal.util.e.a(this.downstream, r3, this, this.error);
        }

        @Override // io.reactivex.t
        public void onNext(T r3) {
            io.reactivex.internal.util.e.a(this.downstream, r3, this, this.error);
        }

        @Override // io.reactivex.t
        public void onSubscribe(io.reactivex.disposables.b r3) {
            io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            DisposableHelper.setOnce(this.mainDisposable, r4);
        }

        void otherComplete() {
            this.otherDone = true;
            if (this.mainDone == false) goto L6;
            io.reactivex.internal.util.e.a(this.downstream, this, this.error);
            return;
        }

        void otherError(Throwable r3) {
            DisposableHelper.dispose(this.mainDisposable);
            io.reactivex.internal.util.e.a(this.downstream, r3, this, this.error);
        }
    }

    @Override // io.reactivex.Observable
    public void a(t<? super T> r3) {
        t r4 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
        MergeWithObserver r0 = new MergeWithObserver(r4);
        r4.onSubscribe(r0);
        this.f17034a.subscribe(r0);
        this.f16957b.a(r0.otherObserver);
    }
}
