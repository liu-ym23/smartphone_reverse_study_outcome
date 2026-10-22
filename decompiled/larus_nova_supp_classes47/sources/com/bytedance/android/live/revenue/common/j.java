package com.bytedance.android.live.revenue.common;

import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class j implements Disposable {
    public final AtomicBoolean a;

    public abstract void d();

    public final void dispose() {
        if (this.a.getAndSet(true) == false) goto L5;
        return;
    L5:
        d();
    }

    public final boolean isDisposed() {
        return this.a.get();
    }

    public j() {
        this.a = new AtomicBoolean(false);
    }
}
