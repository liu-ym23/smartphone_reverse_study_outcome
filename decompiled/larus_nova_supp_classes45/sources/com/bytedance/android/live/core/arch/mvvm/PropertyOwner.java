package com.bytedance.android.live.core.arch.mvvm;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class PropertyOwner<T> extends c<T> implements Observer<T> {
    public T a;
    public final Function2<T, T, T> b;
    public final PublishSubject<T> c;

    public PropertyOwner() {
        throw null;
    }

    public final void onComplete() {
        this.c.onComplete();
    }

    public final void onError(Throwable r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        this.c.onError(r2);
    }

    public final void onSubscribe(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        this.c.onSubscribe(r2);
    }

    @Override // com.bytedance.android.live.core.arch.mvvm.d
    public final T getValue() {
        return this.a;
    }

    public /* synthetic */ PropertyOwner(Object r2) {
        this(r2, AnonymousClass1.INSTANCE);
    }

    @Override // com.bytedance.android.live.core.arch.mvvm.c
    public final void a(T r3) {
        Intrinsics.checkNotNullParameter(r3, "input");
        T r4 = (T) this.b.invoke(this.a, r3);
        if (r4 == null) goto L6;
        this.a = r4;
        this.c.onNext(r4);
        return;
    }

    public final void onNext(T r2) {
        Intrinsics.checkNotNullParameter(r2, "t");
        a(r2);
    }

    public final void subscribeActual(Observer<? super T> r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        this.c.subscribe(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PropertyOwner(T r2, Function2<? super T, ? super T, ? extends T> r3) {
        Intrinsics.checkNotNullParameter(r2, "initialValue");
        Intrinsics.checkNotNullParameter(r3, "onChange");
        PublishSubject<T> r0 = PublishSubject.create();
        this.b = r3;
        this.c = r0;
        this.a = r2;
    }
}
