package io.reactivex.internal.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.exceptions.ProtocolViolationException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class d {
    public static String a(String r2) {
        return "It is not allowed to subscribe with a(n) " + r2 + " multiple times. Please create a fresh instance of " + r2 + " and subscribe that to the target source instead.";
    }

    public static void a(Class<?> r1) {
        io.reactivex.d.a.a(new ProtocolViolationException(a(r1.getName())));
    }

    public static boolean a(AtomicReference<io.reactivex.disposables.b> r2, io.reactivex.disposables.b r3, Class<?> r4) {
        io.reactivex.disposables.b r5 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
        io.reactivex.internal.functions.a.a(r5, "next is null");
        if (r2.compareAndSet(null, r5) == true) goto L9;
        r5.dispose();
        if (r2.get() == DisposableHelper.DISPOSED) goto L11;
        a(r4);
        return false;
    L11:
        return false;
    L9:
        return true;
    }

    public static boolean a(AtomicReference<org.a.d> r2, org.a.d r3, Class<?> r4) {
        org.a.d r5 = (org.a.d) ZeusTransformUtils.wrapperContextForParams(r3, org.a.d.class, "com.obric.memorydata.plugin");
        io.reactivex.internal.functions.a.a(r5, "next is null");
        if (r2.compareAndSet(null, r5) == true) goto L9;
        r5.cancel();
        if (r2.get() == SubscriptionHelper.CANCELLED) goto L11;
        a(r4);
        return false;
    L11:
        return false;
    L9:
        return true;
    }
}
