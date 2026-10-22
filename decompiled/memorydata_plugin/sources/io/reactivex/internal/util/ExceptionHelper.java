package io.reactivex.internal.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.exceptions.CompositeException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class ExceptionHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Throwable f17150a = null;

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
        f17150a = new Termination();
    }

    public static RuntimeException a(Throwable r2) {
        if (ZeusTransformUtils.instanceOf(r2, Error.class) == true) goto L11;
        if (ZeusTransformUtils.instanceOf(r2, RuntimeException.class) == false) goto L9;
        return (RuntimeException) ZeusTransformUtils.preCheckCast(r2, RuntimeException.class, "com.obric.memorydata.plugin");
    L9:
        return new RuntimeException(r2);
    L11:
        throw ((Error) ZeusTransformUtils.preCheckCast(r2, Error.class, "com.obric.memorydata.plugin"));
    }

    public static String a(long r2, TimeUnit r4) {
        return "The source did not signal an event for " + r2 + " " + r4.toString().toLowerCase() + " and has been terminated.";
    }

    public static <T> Throwable a(AtomicReference<Throwable> r3) {
        Throwable r0 = (Throwable) ZeusTransformUtils.preCheckCast(r3.get(), Throwable.class, "com.obric.memorydata.plugin");
        Throwable r1 = f17150a;
        if (r0 != r1) goto L5;
        return r0;
    L5:
        return (Throwable) ZeusTransformUtils.preCheckCast(r3.getAndSet(r1), Throwable.class, "com.obric.memorydata.plugin");
    }

    public static <T> boolean a(AtomicReference<Throwable> r5, Throwable r6) {
    L2:
        Throwable r0 = (Throwable) ZeusTransformUtils.preCheckCast(r5.get(), Throwable.class, "com.obric.memorydata.plugin");
        if (r0 == f17150a) goto L4;
        if (r0 != null) goto L8;
        Throwable r3 = r6;
    L10:
        if (r5.compareAndSet(r0, r3) == false) goto L2;
        return true;
    L8:
        r3 = new CompositeException(new Throwable[]{r0, r6});
        goto L10
    L4:
        return false;
    }
}
