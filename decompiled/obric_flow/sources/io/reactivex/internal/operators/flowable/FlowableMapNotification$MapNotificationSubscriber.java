package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableMapNotification$MapNotificationSubscriber<T, R> extends SinglePostCompleteSubscriber<T, R> {
    private static final long serialVersionUID = 2757120512858778108L;
    final Callable<? extends R> onCompleteSupplier;
    final pt.o onErrorMapper;
    final pt.o onNextMapper;

    public FlowableMapNotification$MapNotificationSubscriber(zu.c r5, pt.o r10, pt.o r11, Callable<? extends R> r12) {
        super(r5);
        this.onNextMapper = r10;
        this.onErrorMapper = r11;
        this.onCompleteSupplier = r12;
    }

    @Override // io.reactivex.internal.subscribers.SinglePostCompleteSubscriber, zu.c
    public void onComplete() {
        R r5 = this.onCompleteSupplier.call();     // Catch: Throwable -> L5
        io.reactivex.internal.functions.e.d(r5, "The onComplete publisher returned is null");     // Catch: Throwable -> L5
        complete(r5);
        return;
    L5:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.downstream.onError(th);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.internal.subscribers.SinglePostCompleteSubscriber, zu.c
    public void onError(Throwable r5) {
        Object r10 = this.onErrorMapper.apply(r5);     // Catch: Throwable -> L5
        io.reactivex.internal.functions.e.d(r10, "The onError publisher returned is null");     // Catch: Throwable -> L5
        complete(r10);
        return;
    L5:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.downstream.onError(new CompositeException(new Throwable[]{r5, th}));
    }

    @Override // io.reactivex.internal.subscribers.SinglePostCompleteSubscriber, zu.c
    public void onNext(T r5) {
        Object r10 = this.onNextMapper.apply(r5);     // Catch: Throwable -> L5
        io.reactivex.internal.functions.e.d(r10, "The onNext publisher returned is null");     // Catch: Throwable -> L5
        this.produced++;
        this.downstream.onNext(r10);
        return;
    L5:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.downstream.onError(th);
    }
}
