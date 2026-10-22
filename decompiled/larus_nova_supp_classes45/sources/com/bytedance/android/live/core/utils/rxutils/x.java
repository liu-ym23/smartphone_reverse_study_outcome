package com.bytedance.android.live.core.utils.rxutils;

import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class x implements Disposable {
    public Disposable a;

    public final void dispose() {
        Disposable r0 = this.a;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    public final boolean isDisposed() {
        Disposable r0 = this.a;
        if (r0 != null) goto L5;
    L8:
        return true;
    L5:
        if (r0.isDisposed() == true) goto L8;
        return false;
    }

    public x() {
        this.a = null;
    }

    public final void b(Disposable r2) {
        Disposable r0 = this.a;
        if (r0 != null) goto L5;
    L9:
        this.a = r2;
        return;
    L5:
        if (r0.isDisposed() == true) goto L9;
        Disposable r1 = this.a;
        if (r1 == null) goto L9;
        r1.dispose();
        goto L9
    }
}
