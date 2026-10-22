package io.reactivex.internal.util;

import io.reactivex.exceptions.CompositeException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class ExceptionHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Throwable f9683a = null;

    static final class Termination extends Throwable {
        private static final long serialVersionUID = -4649703670690200604L;

        Termination() {
            super("No further exceptions");
        }

        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            return this;
        }
    }

    static {
        f9683a = new Termination();
    }

    public static <T> boolean a(AtomicReference<Throwable> r10, Throwable r11) {
    L2:
        Throwable r12 = r10.get();
        if (r12 == f9683a) goto L4;
        if (r12 != null) goto L8;
        Throwable r13 = r11;
    L10:
        if (r10.compareAndSet(r12, r13) == false) goto L2;
        return true;
    L8:
        r13 = new CompositeException(new Throwable[]{r12, r11});
        goto L10
    L4:
        return false;
    }

    public static <T> Throwable b(AtomicReference<Throwable> r10) {
        Throwable r11 = r10.get();
        Throwable r12 = f9683a;
        if (r11 != r12) goto L5;
        return r11;
    L5:
        return r10.getAndSet(r12);
    }

    public static String c(long r10, TimeUnit r11) {
        return "The source did not signal an event for " + r10 + " " + r11.toString().toLowerCase() + " and has been terminated.";
    }

    public static RuntimeException d(Throwable r10) {
        if ((r10 instanceof Error) == true) goto L11;
        if ((r10 instanceof RuntimeException) == false) goto L9;
        return (RuntimeException) r10;
    L9:
        return new RuntimeException(r10);
    L11:
        throw ((Error) r10);
    }
}
