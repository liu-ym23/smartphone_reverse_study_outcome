package com.bytedance.android.livesdk.gamecp.utils;

import com.bytedance.android.gamecp.base.network.exception.CustomApiServerException;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e<T> implements Observer<T>, SingleObserver<T> {
    public e() {
    }

    public final void onComplete() {
    }

    public final void onNext(T r1) {
    }

    public final void onSubscribe(Disposable r1) {
    }

    public final void onSuccess(T r1) {
    }

    public final void onError(Throwable r4) {
        yr.b.a("LiveEmptyObserver", r4);
        if ((r4 instanceof CustomApiServerException) == false) goto L6;
        yr.b.b(6, "LiveEmptyObserver", "ApiServerException thrown, url: " + ((CustomApiServerException) r4).getUrl());
        return;
    }
}
