package io.reactivex.internal.operators.mixed;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.Observable;
import io.reactivex.c;
import io.reactivex.disposables.b;
import io.reactivex.e;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.s;
import io.reactivex.t;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class CompletableAndThenObservable<R> extends Observable<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final e f16886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final s<? extends R> f16887b;

    static final class AndThenObservableObserver<R> extends AtomicReference<b> implements c, b, t<R> {
        private static final long serialVersionUID = -8948264376121066672L;
        final t<? super R> downstream;
        s<? extends R> other;

        AndThenObservableObserver(t<? super R> r3, s<? extends R> r4) {
            t<? super R> r5 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
            this.other = (s) ZeusTransformUtils.wrapperContextForParams(r4, s.class, "com.obric.memorydata.plugin");
            this.downstream = r5;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed((b) ZeusTransformUtils.preCheckCast(get(), b.class, "com.obric.memorydata.plugin"));
        }

        @Override // io.reactivex.c
        public void onComplete() {
            s<? extends R> r0 = this.other;
            if (r0 != null) goto L5;
            this.downstream.onComplete();
            return;
        L5:
            this.other = null;
            r0.subscribe(this);
        }

        @Override // io.reactivex.c
        public void onError(Throwable r1) {
            this.downstream.onError(r1);
        }

        @Override // io.reactivex.t
        public void onNext(R r1) {
            this.downstream.onNext(r1);
        }

        @Override // io.reactivex.c
        public void onSubscribe(b r3) {
            DisposableHelper.replace(this, (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin"));
        }
    }

    @Override // io.reactivex.Observable
    public void a(t<? super R> r3) {
        t r4 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
        AndThenObservableObserver r0 = new AndThenObservableObserver(r4, this.f16887b);
        r4.onSubscribe(r0);
        this.f16886a.a(r0);
    }
}
