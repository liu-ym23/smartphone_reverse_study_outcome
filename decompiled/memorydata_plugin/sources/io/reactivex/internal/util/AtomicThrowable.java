package io.reactivex.internal.util;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class AtomicThrowable extends AtomicReference<Throwable> {
    private static final long serialVersionUID = 3949248817947090603L;

    public AtomicThrowable() {
    }

    public boolean addThrowable(Throwable r1) {
        return ExceptionHelper.a(this, r1);
    }

    public boolean isTerminated() {
        if (get() != ExceptionHelper.f17150a) goto L5;
        return true;
    L5:
        return false;
    }

    public Throwable terminate() {
        return ExceptionHelper.a(this);
    }
}
