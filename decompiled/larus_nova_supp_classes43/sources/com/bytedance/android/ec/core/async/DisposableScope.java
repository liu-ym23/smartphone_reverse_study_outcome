package com.bytedance.android.ec.core.async;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class DisposableScope implements b {
    public final Lazy a;

    public final CompositeDisposable a() {
        return (CompositeDisposable) this.a.getValue();
    }

    public DisposableScope() {
        this.a = LazyKt.lazy(AnonymousClass2.INSTANCE);
    }

    @Override // com.bytedance.android.ec.core.async.b
    public final void clearDisposable() {
        a().clear();
    }

    @Override // com.bytedance.android.ec.core.async.b
    public final CompositeDisposable compositeDisposable() {
        return a();
    }

    @Override // com.bytedance.android.ec.core.async.b
    public final Disposable add(Disposable r10) {
        Intrinsics.checkNotNullParameter(r10, "disposable");
        a().add(r10);
        return r10;
    }

    @Override // com.bytedance.android.ec.core.async.b
    public final void remove(Disposable r10) {
        Intrinsics.checkNotNullParameter(r10, "disposable");
        a().remove(r10);
    }
}
