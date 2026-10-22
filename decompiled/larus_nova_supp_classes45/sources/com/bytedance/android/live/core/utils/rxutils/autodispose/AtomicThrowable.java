package com.bytedance.android.live.core.utils.rxutils.autodispose;

import io.reactivex.exceptions.CompositeException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
final class AtomicThrowable extends AtomicReference<Throwable> {
    private static final long serialVersionUID = 3949248817947090603L;

    public Throwable terminate() {
        Throwable r0 = ExceptionHelper.a;
        Throwable r1 = get();
        Throwable r2 = ExceptionHelper.a;
        if (r1 != r2) goto L5;
        return r1;
    L5:
        return getAndSet(r2);
    }

    public AtomicThrowable() {
    }

    public boolean addThrowable(Throwable r6) {
        Throwable r0 = ExceptionHelper.a;
    L3:
        Throwable r1 = get();
        boolean r2 = false;
        if (r1 == ExceptionHelper.a) goto L26;
        if (r1 != null) goto L9;
        Throwable r3 = r6;
    L11:
        if (compareAndSet(r1, r3) == true) goto L12;
        if (get() == r1) goto L11;
    L15:
        if (r2 == false) goto L3;
        return true;
    L12:
        r2 = true;
        goto L15
    L9:
        r3 = new CompositeException(new Throwable[]{r1, r6});
        goto L11
    L26:
        return false;
    }
}
