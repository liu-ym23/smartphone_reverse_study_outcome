package com.bytedance.android.live.recharge.panel;

import com.bytedance.live.datacontext.n;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e<T> implements com.bytedance.android.live.revenue.common.reactive.b<T> {
    public final n<T> a;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ com.bytedance.android.live.revenue.common.reactive.f a;

        public a(com.bytedance.android.live.revenue.common.reactive.f r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void accept(Object r2) {
            this.a.a(sh6.c.b((sh6.b) r2));
        }
    }

    @Override // com.bytedance.android.live.revenue.common.reactive.b, com.bytedance.android.live.revenue.common.reactive.e
    public final T getValue() {
        return (T) this.a.getValue();
    }

    public e(n<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "target");
        this.a = r2;
    }

    @Override // com.bytedance.android.live.revenue.common.reactive.e
    public final Disposable a(com.bytedance.android.live.revenue.common.reactive.f<T> r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        return this.a.a().subscribe(new a(r3));
    }

    @Override // com.bytedance.android.live.revenue.common.reactive.b
    public final void setValue(T r2) {
        this.a.setValue(r2);
    }
}
