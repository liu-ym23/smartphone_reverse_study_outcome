package io.reactivex.internal.operators.observable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.t;
import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes6.dex */
public final class ObservableTakeLast<T> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f17001b;

    static final class TakeLastObserver<T> extends ArrayDeque<T> implements io.reactivex.disposables.b, t<T> {
        private static final long serialVersionUID = 7240042530241604978L;
        volatile boolean cancelled;
        final int count;
        final t<? super T> downstream;
        io.reactivex.disposables.b upstream;

        TakeLastObserver(t<? super T> r3, int r4) {
            this.downstream = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
            this.count = r4;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.cancelled == true) goto L6;
            this.cancelled = true;
            this.upstream.dispose();
            return;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.t
        public void onComplete() {
            t<? super T> r0 = this.downstream;
        L4:
            if (this.cancelled == true) goto L5;
            T r1 = poll();
            if (r1 == null) goto L9;
            r0.onNext(r1);
            goto L4
        L9:
            if (this.cancelled == true) goto L15;
            r0.onComplete();
            return;
        L15:
            return;
        }

        @Override // io.reactivex.t
        public void onError(Throwable r1) {
            this.downstream.onError(r1);
        }

        @Override // io.reactivex.t
        public void onNext(T r3) {
            if (this.count != size()) goto L5;
            poll();
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
        this.f17034a.subscribe(new TakeLastObserver(r4, this.f17001b));
    }
}
