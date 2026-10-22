package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.h;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.ScalarSubscription;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes6.dex */
public final class d {
    /* JADX WARN: Multi-variable type inference failed */
    public static <T, R> boolean a(org.a.b<T> r3, org.a.c<? super R> r4, h<? super T, ? extends org.a.b<? extends R>> r5) {
        org.a.b r6 = (org.a.b) ZeusTransformUtils.wrapperContextForParams(r3, org.a.b.class, "com.obric.memorydata.plugin");
        org.a.c<? super T> r7 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r4, org.a.c.class, "com.obric.memorydata.plugin");
        h r8 = (h) ZeusTransformUtils.wrapperContextForParams(r5, h.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, Callable.class) == true) goto L24;
        return false;
    L24:
        Object r9 = ((Callable) ZeusTransformUtils.preCheckCast(r6, Callable.class, "com.obric.memorydata.plugin")).call();     // Catch: Throwable -> L17
        if (r9 != null) goto L9;
        EmptySubscription.complete(r7);
        return true;
    L9:
        org.a.b r10 = (org.a.b) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(r8.apply(r9), "The mapper returned a null Publisher"), org.a.b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        if (ZeusTransformUtils.instanceOf(r10, Callable.class) == false) goto L20;
        Object r11 = ((Callable) ZeusTransformUtils.preCheckCast(r10, Callable.class, "com.obric.memorydata.plugin")).call();     // Catch: Throwable -> L17
        if (r11 != null) goto L16;
        EmptySubscription.complete(r7);
        return true;
    L16:
        r7.onSubscribe(new ScalarSubscription(r7, r11));
    L21:
        return true;
    L20:
        r10.subscribe(r7);
    L17:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        EmptySubscription.error(th, r7);
        return true;
    }
}
