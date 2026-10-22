package com.bytedance.android.live.revenue.common.reactive;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g<T> implements ObservableOnSubscribe<T> {
    public final e<T> a;
    public final boolean b;

    public static final class a implements ttc.c {
        public final /* synthetic */ Disposable a;

        public a(Disposable r1) {
            this.a = r1;
        }

        public final void cancel() {
            this.a.dispose();
        }
    }

    public static final class b<T> implements f {
        public final /* synthetic */ ObservableEmitter a;

        public b(ObservableEmitter r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.revenue.common.reactive.f
        public final void a(T r2) {
            Intrinsics.checkNotNullParameter(r2, "newValue");
            this.a.onNext(r2);
        }
    }

    public final void subscribe(ObservableEmitter<T> r3) {
        Intrinsics.checkNotNullParameter(r3, "emitter");
        b r0 = new b(r3);
        r3.setCancellable(new a(this.a.a(r0)));
        if (this.b == false) goto L6;
        r3.onNext(this.a.getValue());
        return;
    }

    public g(e<T> r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "property");
        this.a = r2;
        this.b = r3;
    }
}
