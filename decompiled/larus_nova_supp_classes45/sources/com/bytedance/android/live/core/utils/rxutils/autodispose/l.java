package com.bytedance.android.live.core.utils.rxutils.autodispose;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.ProtocolViolationException;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class l {
    public static void a(Class<?> r3) {
        String r4 = r3.getName();
        RxJavaPlugins.onError(new ProtocolViolationException("It is not allowed to subscribe with a(n) " + r4 + " multiple times. Please create a fresh instance of " + r4 + " and subscribe that to the target source instead."));
    }

    public static boolean b(AtomicReference<Disposable> r3, Disposable r4, Class<?> r5) {
        q.a(r4, "next is null");
    L4:
        if (r3.compareAndSet(null, r4) == true) goto L5;
        if (r3.get() == null) goto L4;
        boolean r0 = false;
    L9:
        if (r0 == true) goto L14;
        r4.dispose();
        if (r3.get() == AutoDisposableHelper.DISPOSED) goto L13;
        a(r5);
    L13:
        return false;
    L14:
        return true;
    L5:
        r0 = true;
        goto L9
    }
}
