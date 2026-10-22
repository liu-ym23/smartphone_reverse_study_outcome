package io.reactivex.internal.util;

import io.reactivex.exceptions.ProtocolViolationException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class d {
    public static String a(String r10) {
        return "It is not allowed to subscribe with a(n) " + r10 + " multiple times. Please create a fresh instance of " + r10 + " and subscribe that to the target source instead.";
    }

    public static void b(Class<?> r10) {
        dc.a.n(new ProtocolViolationException(a(r10.getName())));
    }

    public static boolean c(AtomicReference<io.reactivex.disposables.b> r10, io.reactivex.disposables.b r11, Class<?> r12) {
        io.reactivex.internal.functions.a.d(r11, "next is null");
        if (r10.compareAndSet(null, r11) == true) goto L9;
        r11.dispose();
        if (r10.get() == DisposableHelper.DISPOSED) goto L11;
        b(r12);
        return false;
    L11:
        return false;
    L9:
        return true;
    }

    public static boolean d(AtomicReference<tc.d> r10, tc.d r11, Class<?> r12) {
        io.reactivex.internal.functions.a.d(r11, "next is null");
        if (r10.compareAndSet(null, r11) == true) goto L9;
        r11.cancel();
        if (r10.get() == SubscriptionHelper.CANCELLED) goto L11;
        b(r12);
        return false;
    L11:
        return false;
    L9:
        return true;
    }
}
