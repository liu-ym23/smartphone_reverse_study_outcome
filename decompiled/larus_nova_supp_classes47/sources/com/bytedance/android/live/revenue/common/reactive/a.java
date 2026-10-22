package com.bytedance.android.live.revenue.common.reactive;

import io.reactivex.disposables.Disposable;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a<T, R> implements e<R> {
    public final e<T> a;
    public final Function1<T, R> b;

    /* JADX INFO: renamed from: com.bytedance.android.live.revenue.common.reactive.a$a, reason: collision with other inner class name */
    public static final class C0084a<T, R> implements f<T> {
        public final f<R> a;
        public final Function1<T, R> b;

        @Override // com.bytedance.android.live.revenue.common.reactive.f
        public final void a(T r3) {
            this.a.a((R) this.b.invoke(r3));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C0084a(f<R> r2, Function1<? super T, ? extends R> r3) {
            Intrinsics.checkNotNullParameter(r2, "original");
            Intrinsics.checkNotNullParameter(r3, "mapper");
            this.a = r2;
            this.b = r3;
        }
    }

    @Override // com.bytedance.android.live.revenue.common.reactive.e
    public final R getValue() {
        return (R) this.b.invoke(this.a.getValue());
    }

    @Override // com.bytedance.android.live.revenue.common.reactive.e
    public final Disposable a(f<R> r4) {
        Intrinsics.checkNotNullParameter(r4, "listener");
        return this.a.a(new C0084a(r4, this.b));
    }

    public a(c r2, Function1 r3) {
        Intrinsics.checkNotNullParameter(r2, "original");
        Intrinsics.checkNotNullParameter(r3, "mapper");
        this.a = r2;
        this.b = r3;
    }
}
