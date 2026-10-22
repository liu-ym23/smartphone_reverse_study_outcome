package io.reactivex.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.Observable;
import io.reactivex.b.c;
import io.reactivex.b.e;
import io.reactivex.b.g;
import io.reactivex.b.h;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.exceptions.UndeliverableException;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.k;
import io.reactivex.m;
import io.reactivex.t;
import io.reactivex.u;
import io.reactivex.v;
import io.reactivex.x;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes6.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static volatile g<? super Throwable> f16699a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static volatile h<? super Runnable, ? extends Runnable> f16700b;
    static volatile h<? super Callable<u>, ? extends u> c;
    static volatile h<? super Callable<u>, ? extends u> d;
    static volatile h<? super Callable<u>, ? extends u> e;
    static volatile h<? super Callable<u>, ? extends u> f;
    static volatile h<? super u, ? extends u> g;
    static volatile h<? super io.reactivex.g, ? extends io.reactivex.g> h;
    static volatile c<? super io.reactivex.g, ? super org.a.c, ? extends org.a.c> i;
    static volatile c<? super k, ? super m, ? extends m> j;
    static volatile c<? super Observable, ? super t, ? extends t> k;
    static volatile c<? super v, ? super x, ? extends x> l;
    static volatile c<? super io.reactivex.a, ? super io.reactivex.c, ? extends io.reactivex.c> m;
    static volatile e n;
    static volatile boolean o;

    public static io.reactivex.c a(io.reactivex.a r2, io.reactivex.c r3) {
        io.reactivex.c r4 = (io.reactivex.c) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.c.class, "com.obric.memorydata.plugin");
        c<? super io.reactivex.a, ? super io.reactivex.c, ? extends io.reactivex.c> r0 = m;
        if (r0 != null) goto L5;
        return r4;
    L5:
        return (io.reactivex.c) ZeusTransformUtils.preCheckCast(a(r0, r2, r4), io.reactivex.c.class, "com.obric.memorydata.plugin");
    }

    public static <T> io.reactivex.g<T> a(io.reactivex.g<T> r2) {
        h<? super io.reactivex.g, ? extends io.reactivex.g> r0 = h;
        if (r0 != null) goto L5;
        return r2;
    L5:
        return (io.reactivex.g) ZeusTransformUtils.preCheckCast(a(r0, r2), io.reactivex.g.class, "com.obric.memorydata.plugin");
    }

    public static <T> m<? super T> a(k<T> r2, m<? super T> r3) {
        m<? super T> r4 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.memorydata.plugin");
        c<? super k, ? super m, ? extends m> r0 = j;
        if (r0 != null) goto L5;
        return r4;
    L5:
        return (m) ZeusTransformUtils.preCheckCast(a(r0, r2, r4), m.class, "com.obric.memorydata.plugin");
    }

    public static <T> t<? super T> a(Observable<T> r2, t<? super T> r3) {
        t<? super T> r4 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
        c<? super Observable, ? super t, ? extends t> r0 = k;
        if (r0 != null) goto L5;
        return r4;
    L5:
        return (t) ZeusTransformUtils.preCheckCast(a(r0, r2, r4), t.class, "com.obric.memorydata.plugin");
    }

    static u a(h<? super Callable<u>, ? extends u> r2, Callable<u> r3) {
        return (u) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(a((h) ZeusTransformUtils.wrapperContextForParams(r2, h.class, "com.obric.memorydata.plugin"), (Callable) ZeusTransformUtils.wrapperContextForParams(r3, Callable.class, "com.obric.memorydata.plugin")), "Scheduler Callable result can't be null"), u.class, "com.obric.memorydata.plugin");
    }

    public static u a(u r2) {
        h<? super u, ? extends u> r0 = g;
        if (r0 != null) goto L6;
        return r2;
    L6:
        return (u) ZeusTransformUtils.preCheckCast(a(r0, r2), u.class, "com.obric.memorydata.plugin");
    }

    public static u a(Callable<u> r2) {
        Callable r3 = (Callable) ZeusTransformUtils.wrapperContextForParams(r2, Callable.class, "com.obric.memorydata.plugin");
        io.reactivex.internal.functions.a.a(r3, "Scheduler Callable can't be null");
        h<? super Callable<u>, ? extends u> r0 = c;
        if (r0 != null) goto L7;
        return e(r3);
    L7:
        return a(r0, r3);
    }

    public static <T> x<? super T> a(v<T> r2, x<? super T> r3) {
        x<? super T> r4 = (x) ZeusTransformUtils.wrapperContextForParams(r3, x.class, "com.obric.memorydata.plugin");
        c<? super v, ? super x, ? extends x> r0 = l;
        if (r0 != null) goto L5;
        return r4;
    L5:
        return (x) ZeusTransformUtils.preCheckCast(a(r0, r2, r4), x.class, "com.obric.memorydata.plugin");
    }

    static <T, U, R> R a(c<T, U, R> r2, T r3, U r4) {
        return (R) ((c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin")).apply(r3, r4);
    L5:
        th = move-exception;
        throw ExceptionHelper.a(th);
    }

    static <T, R> R a(h<T, R> r2, T r3) {
        return (R) ((h) ZeusTransformUtils.wrapperContextForParams(r2, h.class, "com.obric.memorydata.plugin")).apply(r3);
    L5:
        th = move-exception;
        throw ExceptionHelper.a(th);
    }

    public static Runnable a(Runnable r2) {
        Runnable r3 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin");
        io.reactivex.internal.functions.a.a(r3, "run is null");
        h<? super Runnable, ? extends Runnable> r0 = f16700b;
        if (r0 != null) goto L6;
        return r3;
    L6:
        return (Runnable) ZeusTransformUtils.preCheckCast(a(r0, r3), Runnable.class, "com.obric.memorydata.plugin");
    }

    public static <T> org.a.c<? super T> a(io.reactivex.g<T> r2, org.a.c<? super T> r3) {
        org.a.c<? super T> r4 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
        c<? super io.reactivex.g, ? super org.a.c, ? extends org.a.c> r0 = i;
        if (r0 != null) goto L5;
        return r4;
    L5:
        return (org.a.c) ZeusTransformUtils.preCheckCast(a(r0, r2, r4), org.a.c.class, "com.obric.memorydata.plugin");
    }

    public static void a(Throwable r2) {
        g<? super Throwable> r0 = f16699a;
        if (r2 != null) goto L6;
        r2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
    L8:
        if (r0 != null) goto L15;
    L13:
        r2.printStackTrace();
        c(r2);
        return;
    L15:
        r0.accept(r2);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        th.printStackTrace();
        c(th);
        goto L13
    L6:
        if (b(r2) == true) goto L8;
        r2 = new UndeliverableException(r2);
        goto L8
    }

    public static boolean a() {
        return o;
    }

    public static u b(Callable<u> r2) {
        Callable r3 = (Callable) ZeusTransformUtils.wrapperContextForParams(r2, Callable.class, "com.obric.memorydata.plugin");
        io.reactivex.internal.functions.a.a(r3, "Scheduler Callable can't be null");
        h<? super Callable<u>, ? extends u> r0 = e;
        if (r0 != null) goto L7;
        return e(r3);
    L7:
        return a(r0, r3);
    }

    public static boolean b() {
        e r0 = n;
        if (r0 != null) goto L11;
        return false;
    L11:
        return r0.getAsBoolean();
    L6:
        th = move-exception;
        throw ExceptionHelper.a(th);
    }

    static boolean b(Throwable r2) {
        if (ZeusTransformUtils.instanceOf(r2, OnErrorNotImplementedException.class) == false) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r2, MissingBackpressureException.class) == false) goto L9;
        return true;
    L9:
        if (ZeusTransformUtils.instanceOf(r2, IllegalStateException.class) == false) goto L12;
        return true;
    L12:
        if (ZeusTransformUtils.instanceOf(r2, NullPointerException.class) == false) goto L15;
        return true;
    L15:
        if (ZeusTransformUtils.instanceOf(r2, IllegalArgumentException.class) == false) goto L18;
        return true;
    L18:
        if (ZeusTransformUtils.instanceOf(r2, CompositeException.class) == false) goto L20;
        return true;
    L20:
        return false;
    }

    public static u c(Callable<u> r2) {
        Callable r3 = (Callable) ZeusTransformUtils.wrapperContextForParams(r2, Callable.class, "com.obric.memorydata.plugin");
        io.reactivex.internal.functions.a.a(r3, "Scheduler Callable can't be null");
        h<? super Callable<u>, ? extends u> r0 = f;
        if (r0 != null) goto L7;
        return e(r3);
    L7:
        return a(r0, r3);
    }

    static void c(Throwable r2) {
        Thread r0 = Thread.currentThread();
        r0.getUncaughtExceptionHandler().uncaughtException(r0, r2);
    }

    public static u d(Callable<u> r2) {
        Callable r3 = (Callable) ZeusTransformUtils.wrapperContextForParams(r2, Callable.class, "com.obric.memorydata.plugin");
        io.reactivex.internal.functions.a.a(r3, "Scheduler Callable can't be null");
        h<? super Callable<u>, ? extends u> r0 = d;
        if (r0 != null) goto L7;
        return e(r3);
    L7:
        return a(r0, r3);
    }

    static u e(Callable<u> r2) {
        return (u) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(((Callable) ZeusTransformUtils.wrapperContextForParams(r2, Callable.class, "com.obric.memorydata.plugin")).call(), "Scheduler Callable result can't be null"), u.class, "com.obric.memorydata.plugin");
    L5:
        th = move-exception;
        throw ExceptionHelper.a(th);
    }
}
