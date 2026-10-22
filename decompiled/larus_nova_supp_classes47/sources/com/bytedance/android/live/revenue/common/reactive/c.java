package com.bytedance.android.live.revenue.common.reactive;

import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c<T> implements b<T> {
    public final CopyOnWriteArrayList<f<T>> a;
    public volatile T b;

    public static final class a implements Action {
        public final /* synthetic */ c a;
        public final /* synthetic */ f b;

        public a(c r1, f r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void run() {
            this.a.a.remove(this.b);
        }
    }

    @Override // com.bytedance.android.live.revenue.common.reactive.b, com.bytedance.android.live.revenue.common.reactive.e
    public final T getValue() {
        return this.b;
    }

    public c(T r2) {
        this.a = new CopyOnWriteArrayList();
        this.b = r2;
    }

    @Override // com.bytedance.android.live.revenue.common.reactive.e
    public final Disposable a(f<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.a.add(r2);
        return Disposables.fromAction(new a(this, r2));
    }

    @Override // com.bytedance.android.live.revenue.common.reactive.b
    public final void setValue(T r3) {
        this.b = r3;
        Iterator<f<T>> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().a(r3);
        goto L4
    }
}
