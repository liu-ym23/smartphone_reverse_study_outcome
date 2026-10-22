package io.reactivex.internal.operators.single;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.Observable;
import io.reactivex.b.h;
import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.t;
import io.reactivex.x;
import io.reactivex.z;
import java.util.Iterator;

/* JADX INFO: loaded from: classes6.dex */
public final class SingleFlatMapIterableObservable<T, R> extends Observable<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final z<T> f17073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h<? super T, ? extends Iterable<? extends R>> f17074b;

    static final class FlatMapIterableObserver<T, R> extends BasicIntQueueDisposable<R> implements x<T> {
        private static final long serialVersionUID = -8938804753851907758L;
        volatile boolean cancelled;
        final t<? super R> downstream;
        volatile Iterator<? extends R> it;
        final h<? super T, ? extends Iterable<? extends R>> mapper;
        boolean outputFused;
        b upstream;

        FlatMapIterableObserver(t<? super R> r3, h<? super T, ? extends Iterable<? extends R>> r4) {
            t<? super R> r5 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
            h<? super T, ? extends Iterable<? extends R>> r6 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
            this.downstream = r5;
            this.mapper = r6;
        }

        @Override // io.reactivex.internal.a.f
        public void clear() {
            this.it = null;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.cancelled = true;
            this.upstream.dispose();
            this.upstream = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.internal.a.f
        public boolean isEmpty() {
            if (this.it != null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // io.reactivex.x
        public void onError(Throwable r2) {
            this.upstream = DisposableHelper.DISPOSED;
            this.downstream.onError(r2);
        }

        @Override // io.reactivex.x
        public void onSubscribe(b r3) {
            b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
            if (DisposableHelper.validate(this.upstream, r4) == false) goto L6;
            this.upstream = r4;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.x
        public void onSuccess(T r4) {
            t<? super R> r0 = this.downstream;
            Iterator<? extends R> r5 = ((Iterable) ZeusTransformUtils.preCheckCast(this.mapper.apply(r4), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L28
            if (r5.hasNext() == true) goto L8;
            r0.onComplete();
            return;
        L8:
            if (this.outputFused == false) goto L12;
            this.it = r5;
            r0.onNext(null);
            r0.onComplete();
            return;
        L12:
            if (this.cancelled == true) goto L13;
            r0.onNext(r5.next());
            if (this.cancelled == true) goto L17;
            if (r5.hasNext() == true) goto L12;
            r0.onComplete();
            return;
        L22:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            r0.onError(th);
            return;
        L17:
            return;
        L25:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            r0.onError(th);
            return;
        L13:
            return;
        L28:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.downstream.onError(th);
        }

        @Override // io.reactivex.internal.a.f
        public R poll() {
            Iterator<? extends R> r0 = this.it;
            if (r0 == null) goto L8;
            R r2 = (R) io.reactivex.internal.functions.a.a(r0.next(), "The iterator returned a null value");
            if (r0.hasNext() == true) goto L7;
            this.it = null;
        L7:
            return r2;
        L8:
            return null;
        }

        @Override // io.reactivex.internal.a.c
        public int requestFusion(int r2) {
            if ((r2 & 2) == 0) goto L6;
            this.outputFused = true;
            return 2;
        L6:
            return 0;
        }
    }

    @Override // io.reactivex.Observable
    public void a(t<? super R> r3) {
        t r4 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
        this.f17073a.a(new FlatMapIterableObserver(r4, this.f17074b));
    }
}
