package io.reactivex.internal.util;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public final class AtomicThrowable extends AtomicReference<Throwable> {
    private static final long serialVersionUID = 3949248817947090603L;

    public AtomicThrowable() {
    }

    public boolean addThrowable(Throwable r5) {
        return d.a(this, r5);
    }

    public boolean isTerminated() {
        if (get() != d.f18173a) goto L5;
        return true;
    L5:
        return false;
    }

    public Throwable terminate() {
        return d.b(this);
    }
}
