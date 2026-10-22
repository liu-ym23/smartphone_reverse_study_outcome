package io.reactivex.internal.operators.observable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.t;
import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes6.dex */
public final class ObservableSkipLast<T> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f16995b;

    static final class SkipLastObserver<T> extends ArrayDeque<T> implements io.reactivex.disposables.b, t<T> {
        private static final long serialVersionUID = -3807491841935125653L;
        final t<? super T> downstream;
        final int skip;
        io.reactivex.disposables.b upstream;

        SkipLastObserver(t<? super T> r3, int r4) {
            t<? super T> r5 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
            super(r4);
            this.downstream = r5;
            this.skip = r4;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.upstream.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.t
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.t
        public void onError(Throwable r1) {
            this.downstream.onError(r1);
        }

        @Override // io.reactivex.t
        public void onNext(T r3) {
            if (this.skip != size()) goto L5;
            this.downstream.onNext(poll());
        L5:
            offer(r3);
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
        this.f17034a.subscribe(new SkipLastObserver(r4, this.f16995b));
    }
}
