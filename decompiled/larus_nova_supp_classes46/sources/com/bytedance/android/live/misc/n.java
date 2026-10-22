package com.bytedance.android.live.misc;

import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class n<T> implements Disposable {
    public final WeakReference<T> a;
    public final Function1<T, Unit> b;

    public final void dispose() {
        T r0 = this.a.get();
        if (r0 == null) goto L5;
        this.b.invoke(r0);
    L5:
        this.a.clear();
    }

    public final boolean isDisposed() {
        if (this.a.get() != null) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public n(T r2, Function1<? super T, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "onDispose");
        this.b = r3;
        this.a = new WeakReference(r2);
    }
}
