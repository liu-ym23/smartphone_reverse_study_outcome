package io.reactivex.internal.operators.mixed;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.h;
import io.reactivex.c;
import io.reactivex.e;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.operators.maybe.MaybeToObservable;
import io.reactivex.internal.operators.single.SingleToObservable;
import io.reactivex.o;
import io.reactivex.t;
import io.reactivex.z;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes6.dex */
final class a {
    /* JADX WARN: Multi-variable type inference failed */
    static <T> boolean a(Object r3, h<? super T, ? extends e> r4, c r5) {
        h r6 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
        c r7 = (c) ZeusTransformUtils.wrapperContextForParams(r5, c.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, Callable.class) == false) goto L15;
        e r0 = null;
        Object r8 = ((Callable) ZeusTransformUtils.preCheckCast(r3, Callable.class, "com.obric.memorydata.plugin")).call();     // Catch: Throwable -> L12
        if (r8 == null) goto L8;
        r0 = (e) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(r6.apply(r8), "The mapper returned a null CompletableSource"), e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
    L8:
        if (r0 != null) goto L10;
        EmptyDisposable.complete(r7);
    L11:
        return true;
    L10:
        r0.a(r7);
    L12:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        EmptyDisposable.error(th, r7);
        return true;
    L15:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static <T, R> boolean a(Object r3, h<? super T, ? extends o<? extends R>> r4, t<? super R> r5) {
        h r6 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
        t r7 = (t) ZeusTransformUtils.wrapperContextForParams(r5, t.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, Callable.class) == false) goto L15;
        o r0 = null;
        Object r8 = ((Callable) ZeusTransformUtils.preCheckCast(r3, Callable.class, "com.obric.memorydata.plugin")).call();     // Catch: Throwable -> L12
        if (r8 == null) goto L8;
        r0 = (o) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(r6.apply(r8), "The mapper returned a null MaybeSource"), o.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
    L8:
        if (r0 != null) goto L10;
        EmptyDisposable.complete(r7);
    L11:
        return true;
    L10:
        r0.a(MaybeToObservable.b(r7));
    L12:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        EmptyDisposable.error(th, r7);
        return true;
    L15:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static <T, R> boolean b(Object r3, h<? super T, ? extends z<? extends R>> r4, t<? super R> r5) {
        h r6 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
        t r7 = (t) ZeusTransformUtils.wrapperContextForParams(r5, t.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, Callable.class) == false) goto L15;
        z r0 = null;
        Object r8 = ((Callable) ZeusTransformUtils.preCheckCast(r3, Callable.class, "com.obric.memorydata.plugin")).call();     // Catch: Throwable -> L12
        if (r8 == null) goto L8;
        r0 = (z) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(r6.apply(r8), "The mapper returned a null SingleSource"), z.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
    L8:
        if (r0 != null) goto L10;
        EmptyDisposable.complete(r7);
    L11:
        return true;
    L10:
        r0.a(SingleToObservable.b(r7));
    L12:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        EmptyDisposable.error(th, r7);
        return true;
    L15:
        return false;
    }
}
