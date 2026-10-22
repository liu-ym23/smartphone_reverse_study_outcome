package dc;

import io.reactivex.Observable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.exceptions.UndeliverableException;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.Callable;
import xb.b;
import xb.e;
import xb.j;
import xb.o;
import xb.p;
import xb.q;
import xb.r;
import zb.c;
import zb.g;
import zb.h;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static volatile g<? super Throwable> f8525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static volatile h<? super Runnable, ? extends Runnable> f8526b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static volatile h<? super Callable<p>, ? extends p> f8527c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static volatile h<? super Callable<p>, ? extends p> f8528d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static volatile h<? super Callable<p>, ? extends p> f8529e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static volatile h<? super Callable<p>, ? extends p> f8530f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static volatile h<? super p, ? extends p> f8531g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static volatile h<? super p, ? extends p> f8532h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static volatile h<? super Observable, ? extends Observable> f8533i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static volatile c<? super e, ? super tc.c, ? extends tc.c> f8534j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static volatile c<? super xb.h, ? super j, ? extends j> f8535k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    static volatile c<? super Observable, ? super o, ? extends o> f8536l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    static volatile c<? super q, ? super r, ? extends r> f8537m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    static volatile c<? super xb.a, ? super b, ? extends b> f8538n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    static volatile zb.e f8539o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    static volatile boolean f8540p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    static volatile boolean f8541q;

    static <T, U, R> R a(c<T, U, R> r10, T r11, U r12) {
        return r10.apply(r11, r12);
    L4:
        th = move-exception;
        throw ExceptionHelper.d(th);
    }

    static <T, R> R b(h<T, R> r10, T r11) {
        return r10.apply(r11);
    L4:
        th = move-exception;
        throw ExceptionHelper.d(th);
    }

    static p c(h<? super Callable<p>, ? extends p> r10, Callable<p> r11) {
        return (p) io.reactivex.internal.functions.a.d(b(r10, r11), "Scheduler Callable result can't be null");
    }

    static p d(Callable<p> r10) {
        return (p) io.reactivex.internal.functions.a.d(r10.call(), "Scheduler Callable result can't be null");
    L4:
        th = move-exception;
        throw ExceptionHelper.d(th);
    }

    public static p e(Callable<p> r10) {
        io.reactivex.internal.functions.a.d(r10, "Scheduler Callable can't be null");
        h<? super Callable<p>, ? extends p> r11 = f8527c;
        if (r11 != null) goto L7;
        return d(r10);
    L7:
        return c(r11, r10);
    }

    public static p f(Callable<p> r10) {
        io.reactivex.internal.functions.a.d(r10, "Scheduler Callable can't be null");
        h<? super Callable<p>, ? extends p> r11 = f8529e;
        if (r11 != null) goto L7;
        return d(r10);
    L7:
        return c(r11, r10);
    }

    public static p g(Callable<p> r10) {
        io.reactivex.internal.functions.a.d(r10, "Scheduler Callable can't be null");
        h<? super Callable<p>, ? extends p> r11 = f8530f;
        if (r11 != null) goto L7;
        return d(r10);
    L7:
        return c(r11, r10);
    }

    public static p h(Callable<p> r10) {
        io.reactivex.internal.functions.a.d(r10, "Scheduler Callable can't be null");
        h<? super Callable<p>, ? extends p> r11 = f8528d;
        if (r11 != null) goto L7;
        return d(r10);
    L7:
        return c(r11, r10);
    }

    static boolean i(Throwable r10) {
        if ((r10 instanceof OnErrorNotImplementedException) == false) goto L6;
        return true;
    L6:
        if ((r10 instanceof MissingBackpressureException) == false) goto L9;
        return true;
    L9:
        if ((r10 instanceof IllegalStateException) == false) goto L12;
        return true;
    L12:
        if ((r10 instanceof NullPointerException) == false) goto L15;
        return true;
    L15:
        if ((r10 instanceof IllegalArgumentException) == false) goto L18;
        return true;
    L18:
        if ((r10 instanceof CompositeException) == false) goto L20;
        return true;
    L20:
        return false;
    }

    public static boolean j() {
        return f8541q;
    }

    public static <T> Observable<T> k(Observable<T> r10) {
        h<? super Observable, ? extends Observable> r11 = f8533i;
        if (r11 != null) goto L5;
        return r10;
    L5:
        return (Observable) b(r11, r10);
    }

    public static boolean l() {
        zb.e r10 = f8539o;
        if (r10 != null) goto L11;
        return false;
    L11:
        return r10.getAsBoolean();
    L6:
        th = move-exception;
        throw ExceptionHelper.d(th);
    }

    public static p m(p r10) {
        h<? super p, ? extends p> r11 = f8531g;
        if (r11 != null) goto L6;
        return r10;
    L6:
        return (p) b(r11, r10);
    }

    public static void n(Throwable r10) {
        g<? super Throwable> r11 = f8525a;
        if (r10 != null) goto L6;
        r10 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
    L8:
        if (r11 != null) goto L15;
    L13:
        r10.printStackTrace();
        w(r10);
        return;
    L15:
        r11.accept(r10);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        th.printStackTrace();
        w(th);
        goto L13
    L6:
        if (i(r10) == true) goto L8;
        r10 = new UndeliverableException(r10);
        goto L8
    }

    public static p o(p r10) {
        h<? super p, ? extends p> r11 = f8532h;
        if (r11 != null) goto L6;
        return r10;
    L6:
        return (p) b(r11, r10);
    }

    public static Runnable p(Runnable r10) {
        io.reactivex.internal.functions.a.d(r10, "run is null");
        h<? super Runnable, ? extends Runnable> r11 = f8526b;
        if (r11 != null) goto L6;
        return r10;
    L6:
        return (Runnable) b(r11, r10);
    }

    public static <T> tc.c<? super T> q(e<T> r10, tc.c<? super T> r11) {
        c<? super e, ? super tc.c, ? extends tc.c> r12 = f8534j;
        if (r12 != null) goto L5;
        return r11;
    L5:
        return (tc.c) a(r12, r10, r11);
    }

    public static b r(xb.a r10, b r11) {
        c<? super xb.a, ? super b, ? extends b> r12 = f8538n;
        if (r12 != null) goto L5;
        return r11;
    L5:
        return (b) a(r12, r10, r11);
    }

    public static <T> j<? super T> s(xb.h<T> r10, j<? super T> r11) {
        c<? super xb.h, ? super j, ? extends j> r12 = f8535k;
        if (r12 != null) goto L5;
        return r11;
    L5:
        return (j) a(r12, r10, r11);
    }

    public static <T> o<? super T> t(Observable<T> r10, o<? super T> r11) {
        c<? super Observable, ? super o, ? extends o> r12 = f8536l;
        if (r12 != null) goto L5;
        return r11;
    L5:
        return (o) a(r12, r10, r11);
    }

    public static <T> r<? super T> u(q<T> r10, r<? super T> r11) {
        c<? super q, ? super r, ? extends r> r12 = f8537m;
        if (r12 != null) goto L5;
        return r11;
    L5:
        return (r) a(r12, r10, r11);
    }

    public static void v(g<? super Throwable> r10) {
        if (f8540p == true) goto L7;
        f8525a = r10;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    static void w(Throwable r10) {
        Thread r11 = Thread.currentThread();
        r11.getUncaughtExceptionHandler().uncaughtException(r11, r10);
    }
}
