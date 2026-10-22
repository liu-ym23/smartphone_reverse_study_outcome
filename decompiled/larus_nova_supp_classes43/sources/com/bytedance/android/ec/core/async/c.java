package com.bytedance.android.ec.core.async;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class c<T> implements Observer<T> {
    public c() {
    }

    public final void onComplete() {
    }

    public final void onError(Throwable r10) {
        Intrinsics.checkNotNullParameter(r10, "e");
    }

    public final void onNext(T r10) {
        Intrinsics.checkNotNullParameter(r10, "t");
    }

    public final void onSubscribe(Disposable r10) {
        Intrinsics.checkNotNullParameter(r10, "d");
    }
}
