package com.bytedance.android.live.revenue.common.reactive;

import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h<T> implements e<T> {
    public final com.bytedance.android.live.core.arch.mvvm.d<T> a;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ f a;

        public a(f r1) {
            this.a = r1;
        }

        public final void accept(T r2) {
            this.a.a(r2);
        }
    }

    @Override // com.bytedance.android.live.revenue.common.reactive.e
    public final T getValue() {
        return (T) this.a.getValue();
    }

    public h(PropertyOwner r2) {
        Intrinsics.checkNotNullParameter(r2, "original");
        this.a = r2;
    }

    @Override // com.bytedance.android.live.revenue.common.reactive.e
    public final Disposable a(f<T> r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        return this.a.subscribe(new a(r3));
    }
}
