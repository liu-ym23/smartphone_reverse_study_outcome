package com.bytedance.android.live.core.arch.mvvm;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b<UpType, DownType> extends d<DownType> implements Observer<UpType> {
    public final d<UpType> a;
    public final Function1<UpType, DownType> b;
    public final PublishSubject<DownType> c;

    @Override // com.bytedance.android.live.core.arch.mvvm.d
    public final DownType getValue() {
        return (DownType) this.b.invoke(this.a.getValue());
    }

    public final void onComplete() {
        this.c.onComplete();
    }

    public final void onError(Throwable r2) {
        Intrinsics.checkNotNullParameter(r2, "e");
        this.c.onError(r2);
    }

    public final void onNext(UpType r3) {
        Intrinsics.checkNotNullParameter(r3, "t");
        this.c.onNext(this.b.invoke(r3));
    }

    public final void onSubscribe(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "d");
        this.c.onSubscribe(r2);
    }

    public final void subscribeActual(Observer<? super DownType> r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        this.c.subscribe(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(d<UpType> r2, Function1<? super UpType, ? extends DownType> r3) {
        Intrinsics.checkNotNullParameter(r2, "upProperty");
        Intrinsics.checkNotNullParameter(r3, "mapAction");
        PublishSubject<DownType> r0 = PublishSubject.create();
        this.a = r2;
        this.b = r3;
        this.c = r0;
        r2.subscribe(this);
    }
}
