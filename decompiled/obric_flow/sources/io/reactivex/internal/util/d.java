package io.reactivex.internal.util;

import ai.j0;
import io.reactivex.exceptions.CompositeException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Throwable f18173a = null;

    static {
        f18173a = new ExceptionHelper$Termination();
    }

    public static boolean a(AtomicReference r5, Throwable r10) {
    L2:
        Throwable r11 = (Throwable) r5.get();
        if (r11 == f18173a) goto L4;
        if (r11 != null) goto L8;
        Throwable r12 = r10;
    L10:
        if (r5.compareAndSet(r11, r12) == true) goto L11;
        if (r5.get() == r11) goto L10;
    L11:
        return true;
    L8:
        r12 = new CompositeException(new Throwable[]{r11, r10});
        goto L10
    L4:
        return false;
    }

    public static Throwable b(AtomicReference r5) {
        Throwable r10 = (Throwable) r5.get();
        Throwable r11 = f18173a;
        if (r10 != r11) goto L5;
        return r10;
    L5:
        return (Throwable) r5.getAndSet(r11);
    }

    public static String c(long r5, TimeUnit r10) {
        StringBuilder r11 = j0.t(r5, "The source did not signal an event for ", " ");
        r11.append(r10.toString().toLowerCase());
        r11.append(" and has been terminated.");
        return r11.toString();
    }

    public static RuntimeException d(Throwable r5) {
        if ((r5 instanceof Error) == true) goto L11;
        if ((r5 instanceof RuntimeException) == false) goto L9;
        return (RuntimeException) r5;
    L9:
        return new RuntimeException(r5);
    L11:
        throw ((Error) r5);
    }
}
