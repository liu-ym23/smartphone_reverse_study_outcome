package com.bytedance.android.live.core.utils.rxutils.autodispose;

import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g implements v<Object> {
    public final /* synthetic */ Flowable a;
    public final /* synthetic */ AutoDispose.a b;

    @Override // com.bytedance.android.live.core.utils.rxutils.autodispose.v
    public final Disposable subscribe(Consumer<? super Object> r4) {
        return new m(this.a, this.b.a).subscribe(r4);
    }

    public g(AutoDispose.a r1, Flowable r2) {
        this.b = r1;
        this.a = r2;
    }
}
