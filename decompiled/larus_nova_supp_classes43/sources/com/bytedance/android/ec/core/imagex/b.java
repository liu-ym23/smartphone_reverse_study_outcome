package com.bytedance.android.ec.core.imagex;

import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements Disposable {
    public Disposable a;

    public final void dispose() {
        Disposable r0 = this.a;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    public final boolean isDisposed() {
        Disposable r0 = this.a;
        if (r0 != null) goto L7;
        return true;
    L7:
        return r0.isDisposed();
    }

    public b(int r1) {
        this.a = null;
    }

    public final void b(Disposable r10) {
        Intrinsics.checkNotNullParameter(r10, "inner");
        if (Intrinsics.areEqual(r10, this) == false) goto L5;
        return;
    L5:
        this.a = r10;
    }
}
