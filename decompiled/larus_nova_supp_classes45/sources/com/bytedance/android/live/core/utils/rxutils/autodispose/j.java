package com.bytedance.android.live.core.utils.rxutils.autodispose;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.TestObserver;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class j implements SingleSubscribeProxy<Object> {
    public final /* synthetic */ Single a;
    public final /* synthetic */ AutoDispose.a b;

    @Override // com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy
    public final Disposable subscribe() {
        return new p(this.a, this.b.a).subscribe();
    }

    @Override // com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy
    public final TestObserver<Object> test() {
        TestObserver<Object> r0 = new TestObserver();
        subscribe(r0);
        return r0;
    }

    @Override // com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy
    public final Disposable subscribe(Consumer<? super Object> r4) {
        return new p(this.a, this.b.a).subscribe(r4);
    }

    @Override // com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy
    public final <E extends SingleObserver<Object>> E subscribeWith(E r4) {
        return (E) new p(this.a, this.b.a).subscribeWith(r4);
    }

    @Override // com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy
    public final TestObserver<Object> test(boolean r2) {
        TestObserver<Object> r0 = new TestObserver();
        if (r2 == false) goto L5;
        r0.dispose();
    L5:
        subscribe(r0);
        return r0;
    }

    @Override // com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy
    public final Disposable subscribe(ttc.a<? super Object, ? super Throwable> r4) {
        return new p(this.a, this.b.a).subscribe(r4);
    }

    @Override // com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy
    public final void subscribe(SingleObserver<? super Object> r4) {
        new p(this.a, this.b.a).subscribe(r4);
    }

    public j(AutoDispose.a r1, Single r2) {
        this.b = r1;
        this.a = r2;
    }

    @Override // com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy
    public final Disposable subscribe(Consumer<? super Object> r4, Consumer<? super Throwable> r5) {
        return new p(this.a, this.b.a).subscribe(r4, r5);
    }
}
