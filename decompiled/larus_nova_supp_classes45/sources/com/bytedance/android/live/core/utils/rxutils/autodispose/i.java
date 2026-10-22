package com.bytedance.android.live.core.utils.rxutils.autodispose;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.TestObserver;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i implements ObservableSubscribeProxy<Object> {
    public final /* synthetic */ Observable a;
    public final /* synthetic */ AutoDispose.a b;

    @Override // com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy
    public final Disposable subscribe() {
        return new o(this.a, this.b.a).subscribe();
    }

    @Override // com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy
    public final TestObserver<Object> test() {
        TestObserver<Object> r0 = new TestObserver();
        subscribe(r0);
        return r0;
    }

    @Override // com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy
    public final Disposable subscribe(Consumer<? super Object> r4) {
        return new o(this.a, this.b.a).subscribe(r4);
    }

    @Override // com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy
    public final <E extends Observer<Object>> E subscribeWith(E r4) {
        return (E) new o(this.a, this.b.a).subscribeWith(r4);
    }

    @Override // com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy
    public final TestObserver<Object> test(boolean r2) {
        TestObserver<Object> r0 = new TestObserver();
        if (r2 == false) goto L5;
        r0.dispose();
    L5:
        subscribe(r0);
        return r0;
    }

    @Override // com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy
    public final void subscribe(Observer<? super Object> r4) {
        new o(this.a, this.b.a).subscribe(r4);
    }

    public i(AutoDispose.a r1, Observable r2) {
        this.b = r1;
        this.a = r2;
    }

    @Override // com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy
    public final Disposable subscribe(Consumer<? super Object> r4, Consumer<? super Throwable> r5) {
        return new o(this.a, this.b.a).subscribe(r4, r5);
    }

    @Override // com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy
    public final Disposable subscribe(Consumer<? super Object> r4, Consumer<? super Throwable> r5, Action r6) {
        return new o(this.a, this.b.a).subscribe(r4, r5, r6);
    }

    @Override // com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy
    public final Disposable subscribe(Consumer<? super Object> r4, Consumer<? super Throwable> r5, Action r6, Consumer<? super Disposable> r7) {
        return new o(this.a, this.b.a).subscribe(r4, r5, r6, r7);
    }
}
