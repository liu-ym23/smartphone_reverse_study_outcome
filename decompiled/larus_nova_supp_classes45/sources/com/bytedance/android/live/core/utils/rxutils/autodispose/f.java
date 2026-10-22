package com.bytedance.android.live.core.utils.rxutils.autodispose;

import io.reactivex.Completable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f implements u {
    public final /* synthetic */ Completable a;
    public final /* synthetic */ AutoDispose.a b;

    @Override // com.bytedance.android.live.core.utils.rxutils.autodispose.u
    public final Disposable a(Action r4) {
        return new k(this.a, this.b.a).subscribe(r4);
    }

    public f(AutoDispose.a r1, Completable r2) {
        this.b = r1;
        this.a = r2;
    }
}
