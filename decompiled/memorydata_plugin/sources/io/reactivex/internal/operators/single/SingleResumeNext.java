package io.reactivex.internal.operators.single;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.h;
import io.reactivex.disposables.b;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.c;
import io.reactivex.v;
import io.reactivex.x;
import io.reactivex.z;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class SingleResumeNext<T> extends v<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final z<? extends T> f17082a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h<? super Throwable, ? extends z<? extends T>> f17083b;

    static final class ResumeMainSingleObserver<T> extends AtomicReference<b> implements b, x<T> {
        private static final long serialVersionUID = -5314538511045349925L;
        final x<? super T> downstream;
        final h<? super Throwable, ? extends z<? extends T>> nextFunction;

        ResumeMainSingleObserver(x<? super T> r3, h<? super Throwable, ? extends z<? extends T>> r4) {
            x<? super T> r5 = (x) ZeusTransformUtils.wrapperContextForParams(r3, x.class, "com.obric.memorydata.plugin");
            h<? super Throwable, ? extends z<? extends T>> r6 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
            this.downstream = r5;
            this.nextFunction = r6;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed((b) ZeusTransformUtils.preCheckCast(get(), b.class, "com.obric.memorydata.plugin"));
        }

        @Override // io.reactivex.x
        public void onError(Throwable r5) {
            ((z) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.nextFunction.apply(r5), "The nextFunction returned a null SingleSource."), z.class, "com.obric.memorydata.plugin")).a(new c(this, this.downstream));
            return;
        L5:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.downstream.onError(new CompositeException(new Throwable[]{r5, th}));
        }

        @Override // io.reactivex.x
        public void onSubscribe(b r3) {
            if (DisposableHelper.setOnce(this, (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin")) == false) goto L6;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.x
        public void onSuccess(T r1) {
            this.downstream.onSuccess(r1);
        }
    }

    @Override // io.reactivex.v
    public void b(x<? super T> r3) {
        x r4 = (x) ZeusTransformUtils.wrapperContextForParams(r3, x.class, "com.obric.memorydata.plugin");
        this.f17082a.a(new ResumeMainSingleObserver(r4, this.f17083b));
    }
}
