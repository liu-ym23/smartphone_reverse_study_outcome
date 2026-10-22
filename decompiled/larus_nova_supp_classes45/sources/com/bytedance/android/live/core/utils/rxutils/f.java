package com.bytedance.android.live.core.utils.rxutils;

import com.bytedance.android.livesdkapi.util.JavaCalls;
import io.reactivex.Observable;
import io.reactivex.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f<T> extends Observable<T> {
    public final Observable<T> a;

    public f(Observable<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "impl");
        this.a = r2;
    }

    public final void subscribeActual(Observer<? super T> r4) {
        JavaCalls.callMethodOrThrow(this.a, "subscribeActual", new Object[]{r4});
    }
}
