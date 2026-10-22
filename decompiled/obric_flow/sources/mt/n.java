package mt;

import ai.j0;
import com.lynx.tasm.behavior.x0;
import io.reactivex.BackpressureStrategy;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.observers.ForEachWhileObserver;
import io.reactivex.internal.observers.LambdaObserver;
import io.reactivex.internal.operators.observable.a2;
import io.reactivex.internal.operators.observable.a3;
import io.reactivex.internal.operators.observable.a4;
import io.reactivex.internal.operators.observable.b1;
import io.reactivex.internal.operators.observable.b2;
import io.reactivex.internal.operators.observable.b3;
import io.reactivex.internal.operators.observable.c2;
import io.reactivex.internal.operators.observable.c3;
import io.reactivex.internal.operators.observable.c4;
import io.reactivex.internal.operators.observable.d0;
import io.reactivex.internal.operators.observable.d1;
import io.reactivex.internal.operators.observable.d2;
import io.reactivex.internal.operators.observable.d4;
import io.reactivex.internal.operators.observable.e0;
import io.reactivex.internal.operators.observable.e1;
import io.reactivex.internal.operators.observable.e2;
import io.reactivex.internal.operators.observable.e3;
import io.reactivex.internal.operators.observable.e4;
import io.reactivex.internal.operators.observable.f0;
import io.reactivex.internal.operators.observable.f1;
import io.reactivex.internal.operators.observable.f2;
import io.reactivex.internal.operators.observable.g0;
import io.reactivex.internal.operators.observable.g1;
import io.reactivex.internal.operators.observable.g3;
import io.reactivex.internal.operators.observable.h0;
import io.reactivex.internal.operators.observable.h1;
import io.reactivex.internal.operators.observable.h2;
import io.reactivex.internal.operators.observable.i2;
import io.reactivex.internal.operators.observable.i3;
import io.reactivex.internal.operators.observable.i4;
import io.reactivex.internal.operators.observable.j4;
import io.reactivex.internal.operators.observable.k0;
import io.reactivex.internal.operators.observable.k1;
import io.reactivex.internal.operators.observable.k2;
import io.reactivex.internal.operators.observable.k3;
import io.reactivex.internal.operators.observable.l0;
import io.reactivex.internal.operators.observable.l2;
import io.reactivex.internal.operators.observable.l3;
import io.reactivex.internal.operators.observable.l4;
import io.reactivex.internal.operators.observable.m2;
import io.reactivex.internal.operators.observable.m3;
import io.reactivex.internal.operators.observable.m4;
import io.reactivex.internal.operators.observable.n2;
import io.reactivex.internal.operators.observable.n3;
import io.reactivex.internal.operators.observable.o1;
import io.reactivex.internal.operators.observable.o2;
import io.reactivex.internal.operators.observable.o4;
import io.reactivex.internal.operators.observable.p0;
import io.reactivex.internal.operators.observable.p1;
import io.reactivex.internal.operators.observable.q1;
import io.reactivex.internal.operators.observable.r2;
import io.reactivex.internal.operators.observable.s1;
import io.reactivex.internal.operators.observable.s2;
import io.reactivex.internal.operators.observable.t1;
import io.reactivex.internal.operators.observable.t2;
import io.reactivex.internal.operators.observable.t3;
import io.reactivex.internal.operators.observable.u1;
import io.reactivex.internal.operators.observable.u3;
import io.reactivex.internal.operators.observable.v1;
import io.reactivex.internal.operators.observable.v2;
import io.reactivex.internal.operators.observable.v3;
import io.reactivex.internal.operators.observable.w1;
import io.reactivex.internal.operators.observable.w2;
import io.reactivex.internal.operators.observable.x1;
import io.reactivex.internal.operators.observable.x2;
import io.reactivex.internal.operators.observable.y1;
import io.reactivex.internal.operators.observable.y2;
import io.reactivex.internal.operators.observable.y3;
import io.reactivex.internal.operators.observable.y4;
import io.reactivex.internal.operators.observable.z1;
import io.reactivex.internal.operators.observable.z2;
import io.reactivex.internal.operators.observable.z4;
import io.reactivex.internal.util.ArrayListSupplier;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.HashMapSupplier;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public abstract class n<T> implements s {
    public n() {
    }

    public static <T> n<T> amb(Iterable<? extends s> r5) {
        io.reactivex.internal.functions.e.d(r5, "sources is null");
        int r10 = 0;
        return new io.reactivex.internal.operators.observable.o(r10, null, r5);
    }

    public static <T> n<T> ambArray(s... r5) {
        io.reactivex.internal.functions.e.d(r5, "sources is null");
        int r10 = r5.length;
        if (r10 != 0) goto L7;
        return empty();
    L7:
        if (r10 == 1) goto L9;
        int r11 = 0;
        return new io.reactivex.internal.operators.observable.o(r11, r5, null);
    L9:
        return wrap(r5[0]);
    }

    public static int bufferSize() {
        return e.f20168a;
    }

    public static <T, R> n<R> combineLatest(pt.o r5, int r10, s... r11) {
        return combineLatest(r11, r5, r10);
    }

    public static <T, R> n<R> combineLatestDelayError(s[] r5, pt.o r10) {
        return combineLatestDelayError(r5, r10, bufferSize());
    }

    public static <T> n<T> concat(Iterable<? extends s> r5) {
        io.reactivex.internal.functions.e.d(r5, "sources is null");
        return fromIterable(r5).concatMapDelayError(io.reactivex.internal.functions.e.f17617a, bufferSize(), false);
    }

    public static <T> n<T> concatArray(s... r5) {
        if (r5.length != 0) goto L7;
        return empty();
    L7:
        if (r5.length != 1) goto L11;
        return wrap(r5[0]);
    L11:
        return new f0(fromArray(r5), io.reactivex.internal.functions.e.f17617a, bufferSize(), ErrorMode.BOUNDARY);
    }

    public static <T> n<T> concatArrayDelayError(s... r5) {
        if (r5.length != 0) goto L7;
        return empty();
    L7:
        if (r5.length != 1) goto L11;
        return wrap(r5[0]);
    L11:
        return concatDelayError(fromArray(r5));
    }

    public static <T> n<T> concatArrayEager(s... r5) {
        return concatArrayEager(bufferSize(), bufferSize(), r5);
    }

    public static <T> n<T> concatArrayEagerDelayError(s... r5) {
        return concatArrayEagerDelayError(bufferSize(), bufferSize(), r5);
    }

    public static <T> n<T> concatDelayError(Iterable<? extends s> r5) {
        io.reactivex.internal.functions.e.d(r5, "sources is null");
        return concatDelayError(fromIterable(r5));
    }

    public static <T> n<T> concatEager(s r5) {
        return concatEager(r5, bufferSize(), bufferSize());
    }

    public static <T> n<T> create(q r5) {
        io.reactivex.internal.functions.e.d(r5, "source is null");
        return new l0(r5, 0);
    }

    public static <T> n<T> defer(Callable<? extends s> r5) {
        io.reactivex.internal.functions.e.d(r5, "supplier is null");
        return new p0(r5, 0);
    }

    public static <T> n<T> empty() {
        return e1.f17766a;
    }

    public static <T> n<T> error(Callable<? extends Throwable> r5) {
        io.reactivex.internal.functions.e.d(r5, "errorSupplier is null");
        return new p0(r5, 1);
    }

    public static <T> n<T> fromArray(T... r5) {
        io.reactivex.internal.functions.e.d(r5, "items is null");
        if (r5.length != 0) goto L7;
        return empty();
    L7:
        if (r5.length != 1) goto L11;
        return just(r5[0]);
    L11:
        return new l0(r5, 1);
    }

    public static <T> n<T> fromCallable(Callable<? extends T> r5) {
        io.reactivex.internal.functions.e.d(r5, "supplier is null");
        return new k1(r5);
    }

    public static <T> n<T> fromFuture(Future<? extends T> r5) {
        io.reactivex.internal.functions.e.d(r5, "future is null");
        return new j4(r5, 0, null);
    }

    public static <T> n<T> fromIterable(Iterable<? extends T> r5) {
        io.reactivex.internal.functions.e.d(r5, "source is null");
        return new l0(r5, 2);
    }

    public static <T> n<T> fromPublisher(zu.b r5) {
        io.reactivex.internal.functions.e.d(r5, "publisher is null");
        return new l0(r5, 3);
    }

    public static <T> n<T> generate(pt.g r5) {
        io.reactivex.internal.functions.e.d(r5, "generator is null");
        return generate(io.reactivex.internal.functions.e.f17620h, new b2(r5, 1), io.reactivex.internal.functions.e.d);
    }

    public static n<Long> interval(long r10, long r11, TimeUnit r12) {
        return interval(r10, r11, r12, ut.e.f22461a);
    }

    public static n<Long> intervalRange(long r10, long r12, long r14, long r16, TimeUnit r18) {
        return intervalRange(r10, r12, r14, r16, r18, ut.e.f22461a);
    }

    public static <T> n<T> just(T r5) {
        io.reactivex.internal.functions.e.d(r5, "item is null");
        return new f2(r5);
    }

    public static <T> n<T> merge(Iterable<? extends s> r5, int r10, int r11) {
        return fromIterable(r5).flatMap(io.reactivex.internal.functions.e.f17617a, false, r10, r11);
    }

    public static <T> n<T> mergeArray(int r5, int r10, s... r11) {
        return fromArray(r11).flatMap(io.reactivex.internal.functions.e.f17617a, false, r5, r10);
    }

    public static <T> n<T> mergeArrayDelayError(int r5, int r10, s... r11) {
        return fromArray(r11).flatMap(io.reactivex.internal.functions.e.f17617a, true, r5, r10);
    }

    public static <T> n<T> mergeDelayError(Iterable<? extends s> r5) {
        return fromIterable(r5).flatMap(io.reactivex.internal.functions.e.f17617a, true);
    }

    public static <T> n<T> never() {
        return n2.f17879a;
    }

    public static n<Integer> range(int r5, int r10) {
        if (r10 < 0) goto L17;
        if (r10 != 0) goto L7;
        return empty();
    L7:
        if (r10 != 1) goto L11;
        return just(Integer.valueOf(r5));
    L11:
        if ((((long) r5) + ((long) (r10 - 1))) > 2147483647L) goto L15;
        return new w2(r5, r10);
    L15:
        throw new IllegalArgumentException("Integer overflow");
    L17:
        throw new IllegalArgumentException(j0.g(r10, "count >= 0 required but it was "));
    }

    public static n<Long> rangeLong(long r5, long r10) {
        if (r10 < 0) goto L21;
        if (r10 != 0) goto L8;
        return empty();
    L8:
        if (r10 == 1) goto L10;
        long r11 = (r10 - 1) + r5;
        if (r5 <= 0) goto L19;
        if (r11 >= 0) goto L19;
        throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
    L19:
        return new x2(r5, r10);
    L10:
        return just(Long.valueOf(r5));
    L21:
        throw new IllegalArgumentException(androidx.constraintlayout.motion.widget.a.j(r10, "count >= 0 required but it was "));
    }

    public static <T> a0 sequenceEqual(s r5, s r10) {
        return sequenceEqual(r5, r10, io.reactivex.internal.functions.e.f17622j, bufferSize());
    }

    public static <T> n<T> switchOnNext(s r5, int r10) {
        io.reactivex.internal.functions.e.d(r5, "sources is null");
        io.reactivex.internal.functions.e.e(r10, "bufferSize");
        return new o2(r5, io.reactivex.internal.functions.e.f17617a, r10, false);
    }

    public static <T> n<T> switchOnNextDelayError(s r5) {
        return switchOnNextDelayError(r5, bufferSize());
    }

    public static n<Long> timer(long r5, TimeUnit r10) {
        return timer(r5, r10, ut.e.f22461a);
    }

    public static <T> n<T> unsafeCreate(s r5) {
        io.reactivex.internal.functions.e.d(r5, "onSubscribe is null");
        if ((r5 instanceof n) == true) goto L7;
        return new l0(r5, 4);
    L7:
        throw new IllegalArgumentException("unsafeCreate(Observable) should be upgraded");
    }

    public static <T, D> n<T> using(Callable<? extends D> r5, pt.o r10, pt.g r11) {
        return using(r5, r10, r11, true);
    }

    public static <T> n<T> wrap(s r5) {
        io.reactivex.internal.functions.e.d(r5, "source is null");
        if ((r5 instanceof n) == false) goto L7;
        return (n) r5;
    L7:
        return new l0(r5, 4);
    }

    public static <T, R> n<R> zip(Iterable<? extends s> r10, pt.o r11) {
        io.reactivex.internal.functions.e.d(r11, "zipper is null");
        io.reactivex.internal.functions.e.d(r10, "sources is null");
        s[] r5 = null;
        return new e0(r5, r10, r11, bufferSize(), false, 1);
    }

    public static <T, R> n<R> zipArray(pt.o r10, boolean r11, int r12, s... r13) {
        if (r13.length == 0) goto L5;
        io.reactivex.internal.functions.e.d(r10, "zipper is null");
        io.reactivex.internal.functions.e.e(r12, "bufferSize");
        return new e0(r13, null, r10, r12, r11, 1);
    L5:
        return empty();
    }

    public static <T, R> n<R> zipIterable(Iterable<? extends s> r10, pt.o r11, boolean r12, int r13) {
        io.reactivex.internal.functions.e.d(r11, "zipper is null");
        io.reactivex.internal.functions.e.d(r10, "sources is null");
        io.reactivex.internal.functions.e.e(r13, "bufferSize");
        return new e0(null, r10, r11, r13, r12, 1);
    }

    public final a0 all(pt.p r5) {
        io.reactivex.internal.functions.e.d(r5, "predicate is null");
        return new io.reactivex.internal.operators.observable.m(this, r5, 0);
    }

    public final n<T> ambWith(s r5) {
        io.reactivex.internal.functions.e.d(r5, "other is null");
        return ambArray(new s[]{this, r5});
    }

    public final a0 any(pt.p r5) {
        io.reactivex.internal.functions.e.d(r5, "predicate is null");
        return new io.reactivex.internal.operators.observable.m(this, r5, 1);
    }

    public final <R> R as(o r5) {
        io.reactivex.internal.functions.e.d(r5, "converter is null");
        throw new ClassCastException();
    }

    public final s1 b(pt.g r10, pt.g r11, pt.a r12, pt.a r13) {
        io.reactivex.internal.functions.e.d(r10, "onNext is null");
        io.reactivex.internal.functions.e.d(r11, "onError is null");
        io.reactivex.internal.functions.e.d(r12, "onComplete is null");
        io.reactivex.internal.functions.e.d(r13, "onAfterTerminate is null");
        return new s1(this, r10, r11, r12, r13, 2);
    }

    public final T blockingFirst() {
        io.reactivex.internal.observers.c r5 = new io.reactivex.internal.observers.c(1, 0);
        subscribe(r5);
        T r10 = (T) r5.a();
        if (r10 == null) goto L6;
        return r10;
    L6:
        throw new NoSuchElementException();
    }

    public final void blockingForEach(pt.g r5) {
        Iterator<T> r10 = blockingIterable().iterator();
    L4:
        if (r10.hasNext() == false) goto L10;
        r5.accept(r10.next());     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        ((Disposable) r10).dispose();
        throw io.reactivex.internal.util.d.d(th);
    }

    public final Iterable<T> blockingIterable() {
        return blockingIterable(bufferSize());
    }

    public final T blockingLast() {
        io.reactivex.internal.observers.c r5 = new io.reactivex.internal.observers.c(1, 1);
        subscribe(r5);
        T r10 = (T) r5.a();
        if (r10 == null) goto L6;
        return r10;
    L6:
        throw new NoSuchElementException();
    }

    public final Iterable<T> blockingLatest() {
        return new io.reactivex.internal.operators.observable.d(this, 0);
    }

    public final Iterable<T> blockingMostRecent(T r5) {
        return new io.reactivex.internal.operators.observable.g(this, r5);
    }

    public final Iterable<T> blockingNext() {
        return new io.reactivex.internal.operators.observable.d(this, 1);
    }

    public final T blockingSingle() {
        h r5 = singleElement();
        r5.getClass();
        io.reactivex.internal.observers.d r10 = new io.reactivex.internal.observers.d(1);
        r5.b(r10);
        T r11 = (T) r10.a();
        if (r11 == null) goto L6;
        return r11;
    L6:
        throw new NoSuchElementException();
    }

    public final void blockingSubscribe() {
        io.reactivex.internal.util.c r5 = new io.reactivex.internal.util.c(1);
        wc.f r10 = io.reactivex.internal.functions.e.d;
        LambdaObserver r11 = new LambdaObserver(r10, r5, r5, r10);
        subscribe(r11);
        if (r5.getCount() != 0) goto L14;
    L6:
        Throwable r12 = r5.f18172a;
        if (r12 != null) goto L10;
        return;
    L10:
        throw io.reactivex.internal.util.d.d(r12);
    L14:
        r5.await();     // Catch: InterruptedException -> L11
    L11:
        e = move-exception;
        r11.dispose();
        Thread.currentThread().interrupt();
        throw new IllegalStateException("Interrupted while waiting for subscription to complete.", e);
    }

    public final n<List<T>> buffer(long r10, long r11, TimeUnit r13) {
        return (n<List<T>>) buffer(r10, r11, r13, ut.e.f22461a, ArrayListSupplier.asCallable());
    }

    public final i4 c(long r10, TimeUnit r11, z r12, s r13) {
        io.reactivex.internal.functions.e.d(r11, "timeUnit is null");
        io.reactivex.internal.functions.e.d(r12, "scheduler is null");
        return new i4(this, r10, r11, r12, r13);
    }

    public final n<T> cache() {
        return cacheWithInitialCapacity(16);
    }

    public final n<T> cacheWithInitialCapacity(int r5) {
        io.reactivex.internal.functions.e.e(r5, "initialCapacity");
        return new io.reactivex.internal.operators.observable.b0(this, r5);
    }

    public final <U> n<U> cast(Class<U> r5) {
        io.reactivex.internal.functions.e.d(r5, "clazz is null");
        return (n<U>) map(new zm.c(r5, 8));
    }

    public final <U> a0 collect(Callable<? extends U> r5, pt.b r10) {
        io.reactivex.internal.functions.e.d(r5, "initialValueSupplier is null");
        io.reactivex.internal.functions.e.d(r10, "collector is null");
        return new d0(this, r5, r10);
    }

    public final <U> a0 collectInto(U r5, pt.b r10) {
        io.reactivex.internal.functions.e.d(r5, "initialValue is null");
        return collect(new com.airbnb.lottie.m(r5, 10), r10);
    }

    public final <R> n<R> compose(t r5) {
        io.reactivex.internal.functions.e.d(r5, "composer is null");
        throw new ClassCastException();
    }

    public final <R> n<R> concatMap(pt.o r5) {
        return concatMap(r5, 2);
    }

    public final a concatMapCompletable(pt.o r5) {
        return concatMapCompletable(r5, 2);
    }

    public final a concatMapCompletableDelayError(pt.o r5) {
        return concatMapCompletableDelayError(r5, true, 2);
    }

    public final <R> n<R> concatMapDelayError(pt.o r5) {
        return concatMapDelayError(r5, bufferSize(), true);
    }

    public final <R> n<R> concatMapEager(pt.o r5) {
        return concatMapEager(r5, Integer.MAX_VALUE, bufferSize());
    }

    public final <R> n<R> concatMapEagerDelayError(pt.o r5, boolean r10) {
        return concatMapEagerDelayError(r5, Integer.MAX_VALUE, bufferSize(), r10);
    }

    public final <U> n<U> concatMapIterable(pt.o r5) {
        io.reactivex.internal.functions.e.d(r5, "mapper is null");
        return new v2(this, r5, 3);
    }

    public final <R> n<R> concatMapMaybe(pt.o r5) {
        return concatMapMaybe(r5, 2);
    }

    public final <R> n<R> concatMapMaybeDelayError(pt.o r5) {
        return concatMapMaybeDelayError(r5, true, 2);
    }

    public final <R> n<R> concatMapSingle(pt.o r5) {
        return concatMapSingle(r5, 2);
    }

    public final <R> n<R> concatMapSingleDelayError(pt.o r5) {
        return concatMapSingleDelayError(r5, true, 2);
    }

    public final n<T> concatWith(s r5) {
        io.reactivex.internal.functions.e.d(r5, "other is null");
        return concat(this, r5);
    }

    public final a0 contains(Object r5) {
        io.reactivex.internal.functions.e.d(r5, "element is null");
        return any(new x0(r5));
    }

    public final a0 count() {
        return new k0(this);
    }

    public final n<T> debounce(long r5, TimeUnit r10) {
        return debounce(r5, r10, ut.e.f22461a);
    }

    public final n<T> defaultIfEmpty(T r5) {
        io.reactivex.internal.functions.e.d(r5, "defaultItem is null");
        return switchIfEmpty(just(r5));
    }

    public final n<T> delay(long r10, TimeUnit r11) {
        return delay(r10, r11, ut.e.f22461a, false);
    }

    public final n<T> delaySubscription(long r5, TimeUnit r10) {
        return delaySubscription(r5, r10, ut.e.f22461a);
    }

    @Deprecated
    public final <T2> n<T2> dematerialize() {
        return new v2(this, io.reactivex.internal.functions.e.f17617a, 2);
    }

    public final n<T> distinct() {
        return distinct(io.reactivex.internal.functions.e.f17617a, io.reactivex.internal.functions.e.a());
    }

    public final n<T> distinctUntilChanged() {
        return distinctUntilChanged(io.reactivex.internal.functions.e.f17617a);
    }

    public final n<T> doAfterNext(pt.g r5) {
        io.reactivex.internal.functions.e.d(r5, "onAfterNext is null");
        return new h0(this, r5, 6);
    }

    public final n<T> doAfterTerminate(pt.a r5) {
        io.reactivex.internal.functions.e.d(r5, "onFinally is null");
        wc.f r10 = io.reactivex.internal.functions.e.d;
        return b(r10, r10, io.reactivex.internal.functions.e.f17619c, r5);
    }

    public final n<T> doFinally(pt.a r5) {
        io.reactivex.internal.functions.e.d(r5, "onFinally is null");
        return new h0(this, r5, 3);
    }

    public final n<T> doOnComplete(pt.a r5) {
        wc.f r10 = io.reactivex.internal.functions.e.d;
        return b(r10, r10, r5, io.reactivex.internal.functions.e.f17619c);
    }

    public final n<T> doOnDispose(pt.a r5) {
        return doOnLifecycle(io.reactivex.internal.functions.e.d, r5);
    }

    public final n<T> doOnEach(pt.g r5) {
        io.reactivex.internal.functions.e.d(r5, "onNotification is null");
        return b(new jg.k(r5, 9), new g8.g(r5, 9), new io.reactivex.internal.functions.c(r5), io.reactivex.internal.functions.e.f17619c);
    }

    public final n<T> doOnError(pt.g r5) {
        wc.f r10 = io.reactivex.internal.functions.e.d;
        io.reactivex.internal.functions.b r11 = io.reactivex.internal.functions.e.f17619c;
        return b(r10, r5, r11, r11);
    }

    public final n<T> doOnLifecycle(pt.g r5, pt.a r10) {
        io.reactivex.internal.functions.e.d(r5, "onSubscribe is null");
        io.reactivex.internal.functions.e.d(r10, "onDispose is null");
        return new z4(this, r5, r10, 6);
    }

    public final n<T> doOnNext(pt.g r5) {
        wc.f r10 = io.reactivex.internal.functions.e.d;
        io.reactivex.internal.functions.b r11 = io.reactivex.internal.functions.e.f17619c;
        return b(r5, r10, r11, r11);
    }

    public final n<T> doOnSubscribe(pt.g r5) {
        return doOnLifecycle(r5, io.reactivex.internal.functions.e.f17619c);
    }

    public final n<T> doOnTerminate(pt.a r5) {
        io.reactivex.internal.functions.e.d(r5, "onTerminate is null");
        return b(io.reactivex.internal.functions.e.d, new ym.d(r5), r5, io.reactivex.internal.functions.e.f17619c);
    }

    public final h elementAt(long r5) {
        if (r5 < 0) goto L7;
        return new b1(this, r5);
    L7:
        throw new IndexOutOfBoundsException(androidx.constraintlayout.motion.widget.a.j(r5, "index >= 0 required but it was "));
    }

    public final a0 elementAtOrError(long r5) {
        if (r5 < 0) goto L7;
        return new d1(this, r5, null);
    L7:
        throw new IndexOutOfBoundsException(androidx.constraintlayout.motion.widget.a.j(r5, "index >= 0 required but it was "));
    }

    public final n<T> filter(pt.p r5) {
        io.reactivex.internal.functions.e.d(r5, "predicate is null");
        return new io.reactivex.internal.operators.observable.k(this, r5, 2);
    }

    public final a0 first(T r5) {
        return elementAt(0, r5);
    }

    public final h firstElement() {
        return elementAt(0);
    }

    public final a0 firstOrError() {
        return elementAtOrError(0);
    }

    public final <R> n<R> flatMap(pt.o r5) {
        return flatMap(r5, false);
    }

    public final a flatMapCompletable(pt.o r5) {
        return flatMapCompletable(r5, false);
    }

    public final <U> n<U> flatMapIterable(pt.o r5) {
        io.reactivex.internal.functions.e.d(r5, "mapper is null");
        return new v2(this, r5, 3);
    }

    public final <R> n<R> flatMapMaybe(pt.o r5) {
        return flatMapMaybe(r5, false);
    }

    public final <R> n<R> flatMapSingle(pt.o r5) {
        return flatMapSingle(r5, false);
    }

    public final Disposable forEach(pt.g r5) {
        return subscribe(r5);
    }

    public final Disposable forEachWhile(pt.p r5) {
        return forEachWhile(r5, io.reactivex.internal.functions.e.e, io.reactivex.internal.functions.e.f17619c);
    }

    public final <K> n<p1> groupBy(pt.o r5) {
        return groupBy(r5, io.reactivex.internal.functions.e.f17617a, false, bufferSize());
    }

    public final <TRight, TLeftEnd, TRightEnd, R> n<R> groupJoin(s r10, pt.o r11, pt.o r12, pt.c r13) {
        io.reactivex.internal.functions.e.d(r10, "other is null");
        io.reactivex.internal.functions.e.d(r11, "leftEnd is null");
        io.reactivex.internal.functions.e.d(r12, "rightEnd is null");
        io.reactivex.internal.functions.e.d(r13, "resultSelector is null");
        return new s1(this, r10, r11, r12, r13, 0);
    }

    public final n<T> hide() {
        return new io.reactivex.internal.operators.observable.j0(this, 2);
    }

    public final a ignoreElements() {
        return new t1(this);
    }

    public final a0 isEmpty() {
        return all(io.reactivex.internal.functions.e.g);
    }

    public final <TRight, TLeftEnd, TRightEnd, R> n<R> join(s r10, pt.o r11, pt.o r12, pt.c r13) {
        io.reactivex.internal.functions.e.d(r10, "other is null");
        io.reactivex.internal.functions.e.d(r11, "leftEnd is null");
        io.reactivex.internal.functions.e.d(r12, "rightEnd is null");
        io.reactivex.internal.functions.e.d(r13, "resultSelector is null");
        return new s1(this, r10, r11, r12, r13, 1);
    }

    public final a0 last(T r5) {
        io.reactivex.internal.functions.e.d(r5, "defaultItem is null");
        return new i2(0, this, r5);
    }

    public final h lastElement() {
        return new h2(this, 0);
    }

    public final a0 lastOrError() {
        int r5 = 0;
        return new i2(r5, this, null);
    }

    public final <R> n<R> lift(r r5) {
        io.reactivex.internal.functions.e.d(r5, "lifter is null");
        return new io.reactivex.internal.operators.observable.j0(this, 4);
    }

    public final <R> n<R> map(pt.o r5) {
        io.reactivex.internal.functions.e.d(r5, "mapper is null");
        return new v2(this, r5, 4);
    }

    public final n<l> materialize() {
        return new io.reactivex.internal.operators.observable.j0(this, 5);
    }

    public final n<T> mergeWith(s r5) {
        io.reactivex.internal.functions.e.d(r5, "other is null");
        return merge(this, r5);
    }

    public final n<T> observeOn(z r5) {
        return observeOn(r5, false, bufferSize());
    }

    public final <U> n<U> ofType(Class<U> r5) {
        io.reactivex.internal.functions.e.d(r5, "clazz is null");
        return filter(new zm.z(r5)).cast(r5);
    }

    public final n<T> onErrorResumeNext(pt.o r5) {
        io.reactivex.internal.functions.e.d(r5, "resumeFunction is null");
        return new g1(this, r5, false, 3);
    }

    public final n<T> onErrorReturn(pt.o r5) {
        io.reactivex.internal.functions.e.d(r5, "valueSupplier is null");
        return new v2(this, r5, 5);
    }

    public final n<T> onErrorReturnItem(T r5) {
        io.reactivex.internal.functions.e.d(r5, "item is null");
        return onErrorReturn(new com.airbnb.lottie.m(r5, 10));
    }

    public final n<T> onExceptionResumeNext(s r5) {
        io.reactivex.internal.functions.e.d(r5, "next is null");
        return new g1(this, new com.airbnb.lottie.m(r5, 10), true, 3);
    }

    public final n<T> onTerminateDetach() {
        return new io.reactivex.internal.operators.observable.j0(this, 1);
    }

    public final st.a publish() {
        AtomicReference r5 = new AtomicReference();
        return new s2(new r2(r5), this, r5);
    }

    public final h reduce(pt.c r5) {
        io.reactivex.internal.functions.e.d(r5, "reducer is null");
        return new y2(this, r5);
    }

    public final <R> a0 reduceWith(Callable<R> r5, pt.c r10) {
        io.reactivex.internal.functions.e.d(r5, "seedSupplier is null");
        io.reactivex.internal.functions.e.d(r10, "reducer is null");
        return new z2(this, r5, r10, 1);
    }

    public final n<T> repeat() {
        return repeat(Long.MAX_VALUE);
    }

    public final n<T> repeatUntil(pt.e r5) {
        io.reactivex.internal.functions.e.d(r5, "stop is null");
        return new h0(this, r5, 4);
    }

    public final n<T> repeatWhen(pt.o r5) {
        io.reactivex.internal.functions.e.d(r5, "handler is null");
        return new c3(this, r5);
    }

    public final st.a replay() {
        return k3.e(this, k3.e);
    }

    public final n<T> retry() {
        return retry(Long.MAX_VALUE, io.reactivex.internal.functions.e.f);
    }

    public final n<T> retryUntil(pt.e r5) {
        io.reactivex.internal.functions.e.d(r5, "stop is null");
        return retry(Long.MAX_VALUE, new ym.o(r5, 8));
    }

    public final n<T> retryWhen(pt.o r5) {
        io.reactivex.internal.functions.e.d(r5, "handler is null");
        return new m3(this, r5);
    }

    public final void safeSubscribe(u r5) {
        io.reactivex.internal.functions.e.d(r5, "observer is null");
        if ((r5 instanceof io.reactivex.observers.c) == false) goto L5;
        subscribe(r5);
        return;
    L5:
        subscribe(new io.reactivex.observers.c(r5));
    }

    public final n<T> sample(long r5, TimeUnit r10) {
        return sample(r5, r10, ut.e.f22461a);
    }

    public final n<T> scan(pt.c r5) {
        io.reactivex.internal.functions.e.d(r5, "accumulator is null");
        return new h0(this, r5, 7);
    }

    public final <R> n<R> scanWith(Callable<R> r10, pt.c r11) {
        io.reactivex.internal.functions.e.d(r10, "seedSupplier is null");
        io.reactivex.internal.functions.e.d(r11, "accumulator is null");
        return new z4(this, r10, r11, 7, false);
    }

    public final n<T> serialize() {
        return new io.reactivex.internal.operators.observable.j0(this, 6);
    }

    public final n<T> share() {
        st.a r5 = publish();
        r5.getClass();
        if ((r5 instanceof s2) == false) goto L6;
        r5 = new t2(((s2) r5).f17955a);
    L6:
        return new a3(r5);
    }

    public final a0 single(T r5) {
        io.reactivex.internal.functions.e.d(r5, "defaultItem is null");
        return new i2(1, this, r5);
    }

    public final h singleElement() {
        return new h2(this, 1);
    }

    public final a0 singleOrError() {
        int r5 = 1;
        return new i2(r5, this, null);
    }

    public final n<T> skip(long r5) {
        if (r5 > 0) goto L6;
        return this;
    L6:
        return new b3(this, r5, 1);
    }

    public final n<T> skipLast(long r10, TimeUnit r11) {
        return skipLast(r10, r11, ut.e.f22463c, false, bufferSize());
    }

    public final <U> n<T> skipUntil(s r5) {
        io.reactivex.internal.functions.e.d(r5, "other is null");
        return new y3(this, r5, 0);
    }

    public final n<T> skipWhile(pt.p r5) {
        io.reactivex.internal.functions.e.d(r5, "predicate is null");
        return new io.reactivex.internal.operators.observable.k(this, r5, 3);
    }

    public final n<T> sorted() {
        c0 r5 = toList();
        r5.getClass();
        if ((r5 instanceof rt.b) == false) goto L5;
        n r10 = ((rt.b) r5).a();
    L7:
        return r10.map(new com.lynx.tasm.behavior.ui.utils.n(io.reactivex.internal.functions.e.c())).flatMapIterable(io.reactivex.internal.functions.e.f17617a);
    L5:
        r10 = new io.reactivex.internal.operators.single.c(r5);
        goto L7
    }

    public final n<T> startWith(Iterable<? extends T> r5) {
        return concatArray(new s[]{fromIterable(r5), this});
    }

    public final n<T> startWithArray(T... r5) {
        n r10 = fromArray(r5);
        if (r10 != empty()) goto L6;
        return this;
    L6:
        return concatArray(new s[]{r10, this});
    }

    public final Disposable subscribe() {
        wc.f r5 = io.reactivex.internal.functions.e.d;
        return subscribe(r5, io.reactivex.internal.functions.e.e, io.reactivex.internal.functions.e.f17619c, r5);
    }

    public abstract void subscribeActual(u r5);

    public final n<T> subscribeOn(z r5) {
        io.reactivex.internal.functions.e.d(r5, "scheduler is null");
        return new a4(this, r5, 0);
    }

    public final <E extends u> E subscribeWith(E r5) {
        subscribe(r5);
        return r5;
    }

    public final n<T> switchIfEmpty(s r5) {
        io.reactivex.internal.functions.e.d(r5, "other is null");
        return new y3(this, r5, 1);
    }

    public final <R> n<R> switchMap(pt.o r5) {
        return switchMap(r5, bufferSize());
    }

    public final a switchMapCompletable(pt.o r5) {
        io.reactivex.internal.functions.e.d(r5, "mapper is null");
        return new io.reactivex.internal.operators.mixed.e(this, r5, false);
    }

    public final a switchMapCompletableDelayError(pt.o r5) {
        io.reactivex.internal.functions.e.d(r5, "mapper is null");
        return new io.reactivex.internal.operators.mixed.e(this, r5, true);
    }

    public final <R> n<R> switchMapDelayError(pt.o r5) {
        return switchMapDelayError(r5, bufferSize());
    }

    public final <R> n<R> switchMapMaybe(pt.o r5) {
        io.reactivex.internal.functions.e.d(r5, "mapper is null");
        return new io.reactivex.internal.operators.mixed.f(this, r5, false, 0);
    }

    public final <R> n<R> switchMapMaybeDelayError(pt.o r5) {
        io.reactivex.internal.functions.e.d(r5, "mapper is null");
        return new io.reactivex.internal.operators.mixed.f(this, r5, true, 0);
    }

    public final <R> n<R> switchMapSingle(pt.o r5) {
        io.reactivex.internal.functions.e.d(r5, "mapper is null");
        return new io.reactivex.internal.operators.mixed.f(this, r5, false, 1);
    }

    public final <R> n<R> switchMapSingleDelayError(pt.o r5) {
        io.reactivex.internal.functions.e.d(r5, "mapper is null");
        return new io.reactivex.internal.operators.mixed.f(this, r5, true, 1);
    }

    public final n<T> take(long r5) {
        if (r5 < 0) goto L7;
        return new b3(this, r5, 2);
    L7:
        throw new IllegalArgumentException(androidx.constraintlayout.motion.widget.a.j(r5, "count >= 0 required but it was "));
    }

    public final n<T> takeLast(long r10, long r12, TimeUnit r14) {
        return takeLast(r10, r12, r14, ut.e.f22463c, false, bufferSize());
    }

    public final <U> n<T> takeUntil(s r5) {
        io.reactivex.internal.functions.e.d(r5, "other is null");
        return new d4(this, r5);
    }

    public final n<T> takeWhile(pt.p r5) {
        io.reactivex.internal.functions.e.d(r5, "predicate is null");
        return new io.reactivex.internal.operators.observable.k(this, r5, 5);
    }

    public final io.reactivex.observers.e test() {
        io.reactivex.observers.e r5 = new io.reactivex.observers.e();
        subscribe(r5);
        return r5;
    }

    public final n<T> throttleFirst(long r5, TimeUnit r10) {
        return throttleFirst(r5, r10, ut.e.f22461a);
    }

    public final n<T> throttleLast(long r5, TimeUnit r10) {
        return sample(r5, r10);
    }

    public final n<T> throttleLatest(long r10, TimeUnit r11) {
        return throttleLatest(r10, r11, ut.e.f22461a, false);
    }

    public final n<T> throttleWithTimeout(long r5, TimeUnit r10) {
        return debounce(r5, r10);
    }

    public final n<ut.f> timeInterval(TimeUnit r5) {
        return timeInterval(r5, ut.e.f22461a);
    }

    public final n<T> timeout(long r10, TimeUnit r11) {
        return c(r10, r11, ut.e.f22461a, null);
    }

    public final n<ut.f> timestamp(TimeUnit r5) {
        return timestamp(r5, ut.e.f22461a);
    }

    public final <R> R to(pt.o r5) {
        io.reactivex.internal.functions.e.d(r5, "converter is null");     // Catch: Throwable -> L4
        return (R) r5.apply(this);
    L4:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        throw io.reactivex.internal.util.d.d(th);
    }

    public final e toFlowable(BackpressureStrategy r5) {
        io.reactivex.internal.operators.flowable.i r10 = new io.reactivex.internal.operators.flowable.i(this);
        int r11 = m.f20171a[r5.ordinal()];
        if (r11 == 1) goto L18;
        if (r11 == 2) goto L16;
        if (r11 != 3) goto L9;
        return r10;
    L9:
        if (r11 == 4) goto L13;
        int r12 = e.f20168a;
        io.reactivex.internal.functions.e.e(r12, "capacity");
        return new io.reactivex.internal.operators.flowable.l(r10, r12);
    L13:
        return new io.reactivex.internal.operators.flowable.o(r10, 0);
    L16:
        return new io.reactivex.internal.operators.flowable.o(r10, 1);
    L18:
        return new io.reactivex.internal.operators.flowable.n(r10);
    }

    public final Future<T> toFuture() {
        return (Future) subscribeWith(new io.reactivex.internal.observers.f());
    }

    public final a0 toList() {
        return toList(16);
    }

    public final <K> a0 toMap(pt.o r5) {
        io.reactivex.internal.functions.e.d(r5, "keySelector is null");
        return collect(HashMapSupplier.asCallable(), new k6.a(r5));
    }

    public final <K> a0 toMultimap(pt.o r5) {
        return toMultimap(r5, io.reactivex.internal.functions.e.f17617a, HashMapSupplier.asCallable(), ArrayListSupplier.asFunction());
    }

    public final a0 toSortedList() {
        return toSortedList(io.reactivex.internal.functions.e.f17621i);
    }

    public final n<T> unsubscribeOn(z r5) {
        io.reactivex.internal.functions.e.d(r5, "scheduler is null");
        return new a4(this, r5, 1);
    }

    public final n<n<T>> window(long r10, long r11, TimeUnit r13) {
        return window(r10, r11, r13, ut.e.f22461a, bufferSize());
    }

    public final <U, R> n<R> withLatestFrom(s r5, pt.c r10) {
        io.reactivex.internal.functions.e.d(r5, "other is null");
        io.reactivex.internal.functions.e.d(r10, "combiner is null");
        return new z4(this, r10, r5, 0);
    }

    public final <U, R> n<R> zipWith(Iterable<U> r5, pt.c r10) {
        io.reactivex.internal.functions.e.d(r5, "other is null");
        io.reactivex.internal.functions.e.d(r10, "zipper is null");
        return new o1(this, r5, r10);
    }

    public static <T, R> n<R> combineLatest(Iterable<? extends s> r5, pt.o r10) {
        return combineLatest(r5, r10, bufferSize());
    }

    public static <T, R> n<R> combineLatestDelayError(pt.o r5, int r10, s... r11) {
        return combineLatestDelayError(r11, r5, r10);
    }

    public static <T> n<T> concatArrayEager(int r5, int r10, s... r11) {
        return fromArray(r11).concatMapEagerDelayError(io.reactivex.internal.functions.e.f17617a, r5, r10, false);
    }

    public static <T> n<T> concatArrayEagerDelayError(int r5, int r10, s... r11) {
        return fromArray(r11).concatMapEagerDelayError(io.reactivex.internal.functions.e.f17617a, r5, r10, true);
    }

    public static <T> n<T> concatEager(s r5, int r10, int r11) {
        return wrap(r5).concatMapEager(io.reactivex.internal.functions.e.f17617a, r10, r11);
    }

    public static <T> n<T> merge(Iterable<? extends s> r5) {
        return fromIterable(r5).flatMap(io.reactivex.internal.functions.e.f17617a);
    }

    public static <T> n<T> mergeArray(s... r5) {
        return fromArray(r5).flatMap(io.reactivex.internal.functions.e.f17617a, r5.length);
    }

    public static <T> n<T> mergeArrayDelayError(s... r5) {
        return fromArray(r5).flatMap(io.reactivex.internal.functions.e.f17617a, true, r5.length);
    }

    public static <T> n<T> mergeDelayError(Iterable<? extends s> r5, int r10, int r11) {
        return fromIterable(r5).flatMap(io.reactivex.internal.functions.e.f17617a, true, r10, r11);
    }

    public static <T> a0 sequenceEqual(s r5, s r10, pt.d r11) {
        return sequenceEqual(r5, r10, r11, bufferSize());
    }

    public static <T> n<T> switchOnNextDelayError(s r5, int r10) {
        io.reactivex.internal.functions.e.d(r5, "sources is null");
        io.reactivex.internal.functions.e.e(r10, "prefetch");
        return new o2(r5, io.reactivex.internal.functions.e.f17617a, r10, true);
    }

    public static <T, D> n<T> using(Callable<? extends D> r5, pt.o r10, pt.g r11, boolean r12) {
        io.reactivex.internal.functions.e.d(r5, "resourceSupplier is null");
        io.reactivex.internal.functions.e.d(r10, "sourceSupplier is null");
        io.reactivex.internal.functions.e.d(r11, "disposer is null");
        return new l4(r5, r10, r11, r12);
    }

    public final Iterable<T> blockingIterable(int r5) {
        io.reactivex.internal.functions.e.e(r5, "bufferSize");
        return new io.reactivex.internal.operators.observable.b(this, r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> n<R> concatMap(pt.o r5, int r10) {
        io.reactivex.internal.functions.e.d(r5, "mapper is null");
        io.reactivex.internal.functions.e.e(r10, "prefetch");
        if ((this instanceof rt.f) == false) goto L11;
        Object r11 = ((rt.f) this).call();
        if (r11 != null) goto L9;
        return empty();
    L9:
        return new io.reactivex.internal.operators.observable.o(3, r11, r5);
    L11:
        return new f0(this, r5, r10, ErrorMode.IMMEDIATE);
    }

    public final a concatMapCompletable(pt.o r5, int r10) {
        io.reactivex.internal.functions.e.d(r5, "mapper is null");
        io.reactivex.internal.functions.e.e(r10, "capacityHint");
        return new io.reactivex.internal.operators.mixed.b(this, r5, ErrorMode.IMMEDIATE, r10);
    }

    public final a concatMapCompletableDelayError(pt.o r5, boolean r10) {
        return concatMapCompletableDelayError(r5, r10, 2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> n<R> concatMapDelayError(pt.o r5, int r10, boolean r11) {
        io.reactivex.internal.functions.e.d(r5, "mapper is null");
        io.reactivex.internal.functions.e.e(r10, "prefetch");
        if ((this instanceof rt.f) == false) goto L11;
        Object r12 = ((rt.f) this).call();
        if (r12 != null) goto L9;
        return empty();
    L9:
        return new io.reactivex.internal.operators.observable.o(3, r12, r5);
    L11:
        if (r11 == false) goto L13;
        ErrorMode r13 = ErrorMode.END;
    L15:
        return new f0(this, r5, r10, r13);
    L13:
        r13 = ErrorMode.BOUNDARY;
        goto L15
    }

    public final <R> n<R> concatMapEager(pt.o r10, int r11, int r12) {
        io.reactivex.internal.functions.e.d(r10, "mapper is null");
        io.reactivex.internal.functions.e.e(r11, "maxConcurrency");
        io.reactivex.internal.functions.e.e(r12, "prefetch");
        return new g0(this, r10, ErrorMode.IMMEDIATE, r11, r12);
    }

    public final <R> n<R> concatMapEagerDelayError(pt.o r10, int r11, int r12, boolean r13) {
        io.reactivex.internal.functions.e.d(r10, "mapper is null");
        io.reactivex.internal.functions.e.e(r11, "maxConcurrency");
        io.reactivex.internal.functions.e.e(r12, "prefetch");
        if (r13 == false) goto L6;
        ErrorMode r14 = ErrorMode.END;
    L8:
        return new g0(this, r10, r14, r11, r12);
    L6:
        r14 = ErrorMode.BOUNDARY;
        goto L8
    }

    public final <R> n<R> concatMapMaybe(pt.o r10, int r11) {
        io.reactivex.internal.functions.e.d(r10, "mapper is null");
        io.reactivex.internal.functions.e.e(r11, "prefetch");
        return new io.reactivex.internal.operators.mixed.c(this, r10, ErrorMode.IMMEDIATE, r11, 0);
    }

    public final <R> n<R> concatMapMaybeDelayError(pt.o r5, boolean r10) {
        return concatMapMaybeDelayError(r5, r10, 2);
    }

    public final <R> n<R> concatMapSingle(pt.o r10, int r11) {
        io.reactivex.internal.functions.e.d(r10, "mapper is null");
        io.reactivex.internal.functions.e.e(r11, "prefetch");
        return new io.reactivex.internal.operators.mixed.c(this, r10, ErrorMode.IMMEDIATE, r11, 1);
    }

    public final <R> n<R> concatMapSingleDelayError(pt.o r5, boolean r10) {
        return concatMapSingleDelayError(r5, r10, 2);
    }

    public final <R> n<R> dematerialize(pt.o r5) {
        io.reactivex.internal.functions.e.d(r5, "selector is null");
        return new v2(this, r5, 2);
    }

    public final <K> n<T> distinct(pt.o r5) {
        return distinct(r5, io.reactivex.internal.functions.e.a());
    }

    public final <K> n<T> distinctUntilChanged(pt.o r5) {
        io.reactivex.internal.functions.e.d(r5, "keySelector is null");
        return new z4(this, r5, io.reactivex.internal.functions.e.f17622j, 5);
    }

    public final <R> n<R> flatMap(pt.o r5, boolean r10) {
        return flatMap(r5, r10, Integer.MAX_VALUE);
    }

    public final a flatMapCompletable(pt.o r5, boolean r10) {
        io.reactivex.internal.functions.e.d(r5, "mapper is null");
        return new h1(this, r5, r10);
    }

    public final <R> n<R> flatMapMaybe(pt.o r5, boolean r10) {
        io.reactivex.internal.functions.e.d(r5, "mapper is null");
        return new g1(this, r5, r10, 1);
    }

    public final <R> n<R> flatMapSingle(pt.o r5, boolean r10) {
        io.reactivex.internal.functions.e.d(r5, "mapper is null");
        return new g1(this, r5, r10, 2);
    }

    public final Disposable forEachWhile(pt.p r5, pt.g r10) {
        return forEachWhile(r5, r10, io.reactivex.internal.functions.e.f17619c);
    }

    public final <K> n<p1> groupBy(pt.o r5, boolean r10) {
        return groupBy(r5, io.reactivex.internal.functions.e.f17617a, r10, bufferSize());
    }

    public final n<T> observeOn(z r5, boolean r10) {
        return observeOn(r5, r10, bufferSize());
    }

    public final n<T> repeat(long r5) {
        if (r5 < 0) goto L10;
        if (r5 != 0) goto L8;
        return empty();
    L8:
        return new b3(this, r5, 0);
    L10:
        throw new IllegalArgumentException(androidx.constraintlayout.motion.widget.a.j(r5, "times >= 0 required but it was "));
    }

    public final <R> n<R> replay(pt.o r10, int r11, long r12, TimeUnit r13) {
        return replay(r10, r11, r12, r13, ut.e.f22461a);
    }

    public final n<T> retry(pt.d r5) {
        io.reactivex.internal.functions.e.d(r5, "predicate is null");
        return new h0(this, r5, 5);
    }

    public final n<T> skip(long r5, TimeUnit r10) {
        return skipUntil(timer(r5, r10));
    }

    public final n<T> startWith(s r5) {
        io.reactivex.internal.functions.e.d(r5, "other is null");
        return concatArray(new s[]{r5, this});
    }

    public final Disposable subscribe(pt.g r5) {
        return subscribe(r5, io.reactivex.internal.functions.e.e, io.reactivex.internal.functions.e.f17619c, io.reactivex.internal.functions.e.d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> n<R> switchMap(pt.o r5, int r10) {
        io.reactivex.internal.functions.e.d(r5, "mapper is null");
        io.reactivex.internal.functions.e.e(r10, "bufferSize");
        if ((this instanceof rt.f) == false) goto L11;
        Object r11 = ((rt.f) this).call();
        if (r11 != null) goto L9;
        return empty();
    L9:
        return new io.reactivex.internal.operators.observable.o(3, r11, r5);
    L11:
        return new o2(this, r5, r10, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> n<R> switchMapDelayError(pt.o r5, int r10) {
        io.reactivex.internal.functions.e.d(r5, "mapper is null");
        io.reactivex.internal.functions.e.e(r10, "bufferSize");
        if ((this instanceof rt.f) == false) goto L11;
        Object r11 = ((rt.f) this).call();
        if (r11 != null) goto L9;
        return empty();
    L9:
        return new io.reactivex.internal.operators.observable.o(3, r11, r5);
    L11:
        return new o2(this, r5, r10, true);
    }

    public final n<T> throttleLast(long r5, TimeUnit r10, z r11) {
        return sample(r5, r10, r11);
    }

    public final n<T> throttleWithTimeout(long r5, TimeUnit r10, z r11) {
        return debounce(r5, r10, r11);
    }

    public final a0 toList(int r5) {
        io.reactivex.internal.functions.e.e(r5, "capacityHint");
        return new io.reactivex.internal.operators.observable.m(this, r5);
    }

    public final a0 toSortedList(Comparator<? super T> r5) {
        io.reactivex.internal.functions.e.d(r5, "comparator is null");
        a0 r10 = toList();
        com.lynx.tasm.behavior.ui.utils.n r11 = new com.lynx.tasm.behavior.ui.utils.n(r5);
        r10.getClass();
        return new i2(2, r10, r11);
    }

    public static <T, R> n<R> combineLatest(Iterable<? extends s> r10, pt.o r11, int r12) {
        io.reactivex.internal.functions.e.d(r10, "sources is null");
        io.reactivex.internal.functions.e.d(r11, "combiner is null");
        io.reactivex.internal.functions.e.e(r12, "bufferSize");
        s[] r5 = null;
        return new e0(r5, r10, r11, r12 << 1, false, 0);
    }

    public static <T, R> n<R> combineLatestDelayError(s[] r10, pt.o r11, int r12) {
        io.reactivex.internal.functions.e.e(r12, "bufferSize");
        io.reactivex.internal.functions.e.d(r11, "combiner is null");
        if (r10.length == 0) goto L5;
        Iterable r5 = null;
        return new e0(r10, r5, r11, r12 << 1, true, 0);
    L5:
        return empty();
    }

    public static <T> n<T> concat(s r5) {
        return concat(r5, bufferSize());
    }

    public static <T> n<T> concatDelayError(s r5) {
        return concatDelayError(r5, bufferSize(), true);
    }

    public static <T> n<T> concatEager(Iterable<? extends s> r5) {
        return concatEager(r5, bufferSize(), bufferSize());
    }

    public static <T> n<T> error(Throwable r5) {
        io.reactivex.internal.functions.e.d(r5, "exception is null");
        return error(new com.airbnb.lottie.m(r5, 10));
    }

    public static <T> n<T> fromFuture(Future<? extends T> r5, long r10, TimeUnit r11) {
        io.reactivex.internal.functions.e.d(r5, "future is null");
        io.reactivex.internal.functions.e.d(r11, "unit is null");
        return new j4(r5, r10, r11);
    }

    public static n<Long> interval(long r10, TimeUnit r11) {
        return interval(r10, r10, r11, ut.e.f22461a);
    }

    public static n<Long> intervalRange(long r16, long r18, long r20, long r22, TimeUnit r24, z r25) {
        if (r18 < 0) goto L17;
        if (r18 == 0) goto L6;
        long r10 = (r18 - 1) + r16;
        if (r16 > 0) goto L10;
    L14:
        io.reactivex.internal.functions.e.d(r24, "unit is null");
        io.reactivex.internal.functions.e.d(r25, "scheduler is null");
        return new e2(r16, r10, Math.max(0, r20), Math.max(0, r22), r24, r25);
    L10:
        if (r10 >= 0) goto L14;
        throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
    L6:
        return empty().delay(r20, r24, r25);
    L17:
        throw new IllegalArgumentException(androidx.constraintlayout.motion.widget.a.j(r18, "count >= 0 required but it was "));
    }

    public static <T> n<T> just(T r5, T r10) {
        io.reactivex.internal.functions.e.d(r5, "item1 is null");
        io.reactivex.internal.functions.e.d(r10, "item2 is null");
        return fromArray(new Object[]{r5, r10});
    }

    public static <T> n<T> merge(Iterable<? extends s> r5, int r10) {
        return fromIterable(r5).flatMap(io.reactivex.internal.functions.e.f17617a, r10);
    }

    public static <T> n<T> mergeDelayError(Iterable<? extends s> r5, int r10) {
        return fromIterable(r5).flatMap(io.reactivex.internal.functions.e.f17617a, true, r10);
    }

    public static <T> a0 sequenceEqual(s r5, s r10, pt.d r11, int r12) {
        io.reactivex.internal.functions.e.d(r5, "source1 is null");
        io.reactivex.internal.functions.e.d(r10, "source2 is null");
        io.reactivex.internal.functions.e.d(r11, "isEqual is null");
        io.reactivex.internal.functions.e.e(r12, "bufferSize");
        return new t3(r5, r10, r11, r12);
    }

    public static n<Long> timer(long r5, TimeUnit r10, z r11) {
        io.reactivex.internal.functions.e.d(r10, "unit is null");
        io.reactivex.internal.functions.e.d(r11, "scheduler is null");
        return new j4(Math.max(r5, 0), r10, r11);
    }

    public final n<List<T>> buffer(long r10, TimeUnit r11) {
        return buffer(r10, r11, ut.e.f22461a, Integer.MAX_VALUE);
    }

    public final a concatMapCompletableDelayError(pt.o r5, boolean r10, int r11) {
        io.reactivex.internal.functions.e.d(r5, "mapper is null");
        io.reactivex.internal.functions.e.e(r11, "prefetch");
        if (r10 == false) goto L5;
        ErrorMode r12 = ErrorMode.END;
    L7:
        return new io.reactivex.internal.operators.mixed.b(this, r5, r12, r11);
    L5:
        r12 = ErrorMode.BOUNDARY;
        goto L7
    }

    public final <U> n<U> concatMapIterable(pt.o r5, int r10) {
        io.reactivex.internal.functions.e.d(r5, "mapper is null");
        io.reactivex.internal.functions.e.e(r10, "prefetch");
        return (n<U>) concatMap(new w1(r5, 0), r10);
    }

    public final <R> n<R> concatMapMaybeDelayError(pt.o r10, boolean r11, int r12) {
        io.reactivex.internal.functions.e.d(r10, "mapper is null");
        io.reactivex.internal.functions.e.e(r12, "prefetch");
        if (r11 == false) goto L6;
        ErrorMode r13 = ErrorMode.END;
    L8:
        return new io.reactivex.internal.operators.mixed.c(this, r10, r13, r12, 0);
    L6:
        r13 = ErrorMode.BOUNDARY;
        goto L8
    }

    public final <R> n<R> concatMapSingleDelayError(pt.o r10, boolean r11, int r12) {
        io.reactivex.internal.functions.e.d(r10, "mapper is null");
        io.reactivex.internal.functions.e.e(r12, "prefetch");
        if (r11 == false) goto L6;
        ErrorMode r13 = ErrorMode.END;
    L8:
        return new io.reactivex.internal.operators.mixed.c(this, r10, r13, r12, 1);
    L6:
        r13 = ErrorMode.BOUNDARY;
        goto L8
    }

    public final n<T> concatWith(c0 r5) {
        io.reactivex.internal.functions.e.d(r5, "other is null");
        return new h0(this, r5, 2);
    }

    public final <U> n<T> debounce(pt.o r5) {
        io.reactivex.internal.functions.e.d(r5, "debounceSelector is null");
        return new v2(this, r5, 1);
    }

    public final n<T> delay(long r10, TimeUnit r11, boolean r12) {
        return delay(r10, r11, ut.e.f22461a, r12);
    }

    public final <U> n<T> delaySubscription(s r5) {
        io.reactivex.internal.functions.e.d(r5, "other is null");
        return new io.reactivex.internal.operators.observable.o(1, this, r5);
    }

    public final <K> n<T> distinct(pt.o r5, Callable<? extends Collection<? super K>> r10) {
        io.reactivex.internal.functions.e.d(r5, "keySelector is null");
        io.reactivex.internal.functions.e.d(r10, "collectionSupplier is null");
        return new z4(this, r5, r10, 4);
    }

    public final <R> n<R> flatMap(pt.o r5, boolean r10, int r11) {
        return flatMap(r5, r10, r11, bufferSize());
    }

    public final <U, V> n<V> flatMapIterable(pt.o r10, pt.c r11) {
        io.reactivex.internal.functions.e.d(r10, "mapper is null");
        io.reactivex.internal.functions.e.d(r11, "resultSelector is null");
        return (n<V>) flatMap(new w1(r10, 0), r11, false, bufferSize(), bufferSize());
    }

    public final Disposable forEachWhile(pt.p r5, pt.g r10, pt.a r11) {
        io.reactivex.internal.functions.e.d(r5, "onNext is null");
        io.reactivex.internal.functions.e.d(r10, "onError is null");
        io.reactivex.internal.functions.e.d(r11, "onComplete is null");
        ForEachWhileObserver r12 = new ForEachWhileObserver(r5, r10, r11);
        subscribe(r12);
        return r12;
    }

    public final <K, V> n<p1> groupBy(pt.o r5, pt.o r10) {
        return groupBy(r5, r10, false, bufferSize());
    }

    public final n<T> mergeWith(c0 r5) {
        io.reactivex.internal.functions.e.d(r5, "other is null");
        return new m2(this, r5);
    }

    public final n<T> observeOn(z r5, boolean r10, int r11) {
        io.reactivex.internal.functions.e.d(r5, "scheduler is null");
        io.reactivex.internal.functions.e.e(r11, "bufferSize");
        return new o2(this, r5, r10, r11);
    }

    public final n<T> onErrorResumeNext(s r5) {
        io.reactivex.internal.functions.e.d(r5, "next is null");
        return onErrorResumeNext(new com.airbnb.lottie.m(r5, 10));
    }

    public final <R> a0 reduce(R r5, pt.c r10) {
        io.reactivex.internal.functions.e.d(r5, "seed is null");
        io.reactivex.internal.functions.e.d(r10, "reducer is null");
        return new z2(this, r5, r10, 0);
    }

    public final n<T> sample(long r10, TimeUnit r11, boolean r12) {
        return sample(r10, r11, ut.e.f22461a, r12);
    }

    public final <R> n<R> scan(R r5, pt.c r10) {
        io.reactivex.internal.functions.e.d(r5, "initialValue is null");
        return scanWith(new com.airbnb.lottie.m(r5, 10), r10);
    }

    public final n<T> skip(long r5, TimeUnit r10, z r11) {
        return skipUntil(timer(r5, r10, r11));
    }

    public final n<T> skipLast(long r10, TimeUnit r11, boolean r12) {
        return skipLast(r10, r11, ut.e.f22463c, r12, bufferSize());
    }

    public final Disposable subscribe(pt.g r5, pt.g r10) {
        return subscribe(r5, r10, io.reactivex.internal.functions.e.f17619c, io.reactivex.internal.functions.e.d);
    }

    public final n<T> takeLast(long r10, TimeUnit r11) {
        return takeLast(r10, r11, ut.e.f22463c, false, bufferSize());
    }

    public final n<T> takeUntil(pt.p r5) {
        io.reactivex.internal.functions.e.d(r5, "stopPredicate is null");
        return new io.reactivex.internal.operators.observable.k(this, r5, 4);
    }

    public final io.reactivex.observers.e test(boolean r5) {
        io.reactivex.observers.e r10 = new io.reactivex.observers.e();
        if (r5 == false) goto L5;
        r10.dispose();
    L5:
        subscribe(r10);
        return r10;
    }

    public final n<T> throttleFirst(long r10, TimeUnit r11, z r12) {
        io.reactivex.internal.functions.e.d(r11, "unit is null");
        io.reactivex.internal.functions.e.d(r12, "scheduler is null");
        return new e4(0, r10, r11, this, r12);
    }

    public final n<T> throttleLatest(long r10, TimeUnit r11, boolean r12) {
        return throttleLatest(r10, r11, ut.e.f22461a, r12);
    }

    public final n<ut.f> timeInterval() {
        return timeInterval(TimeUnit.MILLISECONDS, ut.e.f22461a);
    }

    public final <V> n<T> timeout(pt.o r10, s r11) {
        io.reactivex.internal.functions.e.d(r11, "other is null");
        io.reactivex.internal.functions.e.d(r10, "itemTimeoutIndicator is null");
        return new io.reactivex.internal.operators.observable.r(this, null, r10, r11, 1);
    }

    public final n<ut.f> timestamp() {
        return timestamp(TimeUnit.MILLISECONDS, ut.e.f22461a);
    }

    public final n<n<T>> window(long r10, TimeUnit r11) {
        return window(r10, r11, ut.e.f22461a, Long.MAX_VALUE, false);
    }

    public static <T> n<T> concat(s r5, int r10) {
        io.reactivex.internal.functions.e.d(r5, "sources is null");
        io.reactivex.internal.functions.e.e(r10, "prefetch");
        return new f0(r5, io.reactivex.internal.functions.e.f17617a, r10, ErrorMode.IMMEDIATE);
    }

    public static <T> n<T> concatDelayError(s r5, int r10, boolean r11) {
        io.reactivex.internal.functions.e.d(r5, "sources is null");
        io.reactivex.internal.functions.e.e(r10, "prefetch is null");
        com.bytedance.ies.bullet.service.base.c r12 = io.reactivex.internal.functions.e.f17617a;
        if (r11 == false) goto L5;
        ErrorMode r13 = ErrorMode.END;
    L7:
        return new f0(r5, r12, r10, r13);
    L5:
        r13 = ErrorMode.BOUNDARY;
        goto L7
    }

    public static <T> n<T> concatEager(Iterable<? extends s> r5, int r10, int r11) {
        return fromIterable(r5).concatMapEagerDelayError(io.reactivex.internal.functions.e.f17617a, r10, r11, false);
    }

    public static <T> n<T> merge(s r10) {
        io.reactivex.internal.functions.e.d(r10, "sources is null");
        return new f1(r10, io.reactivex.internal.functions.e.f17617a, false, Integer.MAX_VALUE, bufferSize());
    }

    public static <T> n<T> mergeDelayError(s r10) {
        io.reactivex.internal.functions.e.d(r10, "sources is null");
        return new f1(r10, io.reactivex.internal.functions.e.f17617a, true, Integer.MAX_VALUE, bufferSize());
    }

    public static <T> n<T> switchOnNext(s r5) {
        return switchOnNext(r5, bufferSize());
    }

    public static <T, R> n<R> zip(s r5, pt.o r10) {
        io.reactivex.internal.functions.e.d(r10, "zipper is null");
        io.reactivex.internal.functions.e.d(r5, "sources is null");
        return new h0(r5).flatMap(new w1(r10, 2));
    }

    public final n<T> distinctUntilChanged(pt.d r5) {
        io.reactivex.internal.functions.e.d(r5, "comparer is null");
        return new z4(this, io.reactivex.internal.functions.e.f17617a, r5, 5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> n<R> flatMap(pt.o r10, boolean r11, int r12, int r13) {
        io.reactivex.internal.functions.e.d(r10, "mapper is null");
        io.reactivex.internal.functions.e.e(r12, "maxConcurrency");
        io.reactivex.internal.functions.e.e(r13, "bufferSize");
        if ((this instanceof rt.f) == false) goto L11;
        Object r14 = ((rt.f) this).call();
        if (r14 != null) goto L9;
        return empty();
    L9:
        return new io.reactivex.internal.operators.observable.o(3, r14, r10);
    L11:
        return new f1(this, r10, r11, r12, r13);
    }

    public final <K, V> n<p1> groupBy(pt.o r5, pt.o r10, boolean r11) {
        return groupBy(r5, r10, r11, bufferSize());
    }

    public final <R> n<R> publish(pt.o r5) {
        io.reactivex.internal.functions.e.d(r5, "selector is null");
        return new v2(this, r5, 0);
    }

    public final <R> n<R> replay(pt.o r10, long r11, TimeUnit r12) {
        return replay(r10, r11, r12, ut.e.f22461a);
    }

    public final n<T> retry(long r5) {
        return retry(r5, io.reactivex.internal.functions.e.f);
    }

    public final n<T> startWith(T r5) {
        io.reactivex.internal.functions.e.d(r5, "item is null");
        return concatArray(new s[]{just(r5), this});
    }

    public final Disposable subscribe(pt.g r5, pt.g r10, pt.a r11) {
        return subscribe(r5, r10, r11, io.reactivex.internal.functions.e.d);
    }

    public final <U extends Collection<? super T>> a0 toList(Callable<U> r5) {
        io.reactivex.internal.functions.e.d(r5, "collectionSupplier is null");
        return new io.reactivex.internal.operators.observable.m(this, r5, 2);
    }

    public final <T1, T2, R> n<R> withLatestFrom(s r5, s r10, pt.h r11) {
        io.reactivex.internal.functions.e.d(r5, "o1 is null");
        io.reactivex.internal.functions.e.d(r10, "o2 is null");
        io.reactivex.internal.functions.e.d(r11, "combiner is null");
        io.reactivex.internal.functions.e.d(null, "f is null");
        throw null;
    }

    public final <U, R> n<R> zipWith(s r5, pt.c r10) {
        io.reactivex.internal.functions.e.d(r5, "other is null");
        return zip(this, r5, r10);
    }

    public static n<Long> interval(long r10, long r11, TimeUnit r12, z r13) {
        io.reactivex.internal.functions.e.d(r12, "unit is null");
        io.reactivex.internal.functions.e.d(r13, "scheduler is null");
        return new d2(Math.max(0, r10), Math.max(0, r11), r12, r13);
    }

    public final n<List<T>> buffer(long r10, TimeUnit r11, int r12) {
        return buffer(r10, r11, ut.e.f22461a, r12);
    }

    public final n<T> concatWith(k r5) {
        io.reactivex.internal.functions.e.d(r5, "other is null");
        return new h0(this, r5, 1);
    }

    public final n<T> debounce(long r10, TimeUnit r11, z r12) {
        io.reactivex.internal.functions.e.d(r11, "unit is null");
        io.reactivex.internal.functions.e.d(r12, "scheduler is null");
        return new e4(1, r10, r11, this, r12);
    }

    public final <U> n<T> delay(pt.o r5) {
        io.reactivex.internal.functions.e.d(r5, "itemDelay is null");
        return (n<T>) flatMap(new w1(r5, 1));
    }

    public final n<T> delaySubscription(long r5, TimeUnit r10, z r11) {
        return delaySubscription(timer(r5, r10, r11));
    }

    public final <K, V> n<p1> groupBy(pt.o r10, pt.o r11, boolean r12, int r13) {
        io.reactivex.internal.functions.e.d(r10, "keySelector is null");
        io.reactivex.internal.functions.e.d(r11, "valueSelector is null");
        io.reactivex.internal.functions.e.e(r13, "bufferSize");
        return new q1(this, r10, r11, r13, r12);
    }

    public final n<T> mergeWith(k r5) {
        io.reactivex.internal.functions.e.d(r5, "other is null");
        return new l2(this, r5);
    }

    public final n<T> retry(long r5, pt.p r10) {
        if (r5 < 0) goto L7;
        io.reactivex.internal.functions.e.d(r10, "predicate is null");
        return new l3(this, r5, r10);
    L7:
        throw new IllegalArgumentException(androidx.constraintlayout.motion.widget.a.j(r5, "times >= 0 required but it was "));
    }

    public final n<T> sample(long r10, TimeUnit r12, z r13) {
        io.reactivex.internal.functions.e.d(r12, "unit is null");
        io.reactivex.internal.functions.e.d(r13, "scheduler is null");
        int r5 = 0;
        return new n3(r5, r10, r12, this, r13, false);
    }

    public final n<T> skipLast(int r5) {
        if (r5 < 0) goto L8;
        if (r5 != 0) goto L6;
        return this;
    L6:
        return new u3(this, r5, 0);
    L8:
        throw new IndexOutOfBoundsException(j0.g(r5, "count >= 0 required but it was "));
    }

    public final Disposable subscribe(pt.g r5, pt.g r10, pt.a r11, pt.g r12) {
        io.reactivex.internal.functions.e.d(r5, "onNext is null");
        io.reactivex.internal.functions.e.d(r10, "onError is null");
        io.reactivex.internal.functions.e.d(r11, "onComplete is null");
        io.reactivex.internal.functions.e.d(r12, "onSubscribe is null");
        LambdaObserver r13 = new LambdaObserver(r5, r10, r11, r12);
        subscribe(r13);
        return r13;
    }

    public final n<T> takeLast(long r10, TimeUnit r11, boolean r12) {
        return takeLast(r10, r11, ut.e.f22463c, r12, bufferSize());
    }

    public final n<T> throttleLatest(long r10, TimeUnit r11, z r12) {
        return throttleLatest(r10, r11, r12, false);
    }

    public final <K, V> a0 toMap(pt.o r5, pt.o r10) {
        io.reactivex.internal.functions.e.d(r5, "keySelector is null");
        io.reactivex.internal.functions.e.d(r10, "valueSelector is null");
        return collect(HashMapSupplier.asCallable(), new ai.p(10, r10, r5));
    }

    public final <K, V> a0 toMultimap(pt.o r5, pt.o r10) {
        return toMultimap(r5, r10, HashMapSupplier.asCallable(), ArrayListSupplier.asFunction());
    }

    public final n<n<T>> window(long r10, TimeUnit r11, long r12) {
        return window(r10, r11, ut.e.f22461a, r12, false);
    }

    public static <T> n<T> fromFuture(Future<? extends T> r5, long r10, TimeUnit r11, z r12) {
        io.reactivex.internal.functions.e.d(r12, "scheduler is null");
        return fromFuture(r5, r10, r11).subscribeOn(r12);
    }

    public static <T, S> n<T> generate(Callable<S> r5, pt.b r10) {
        io.reactivex.internal.functions.e.d(r10, "generator is null");
        return generate(r5, new b2(r10, 0), io.reactivex.internal.functions.e.d);
    }

    public static <T> n<T> just(T r5, T r10, T r11) {
        io.reactivex.internal.functions.e.d(r5, "item1 is null");
        io.reactivex.internal.functions.e.d(r10, "item2 is null");
        io.reactivex.internal.functions.e.d(r11, "item3 is null");
        return fromArray(new Object[]{r5, r10, r11});
    }

    public static <T> n<T> merge(s r10, int r11) {
        io.reactivex.internal.functions.e.d(r10, "sources is null");
        io.reactivex.internal.functions.e.e(r11, "maxConcurrency");
        return new f1(r10, io.reactivex.internal.functions.e.f17617a, false, r11, bufferSize());
    }

    public static <T> n<T> mergeDelayError(s r10, int r11) {
        io.reactivex.internal.functions.e.d(r10, "sources is null");
        io.reactivex.internal.functions.e.e(r11, "maxConcurrency");
        return new f1(r10, io.reactivex.internal.functions.e.f17617a, true, r11, bufferSize());
    }

    public final T blockingFirst(T r5) {
        io.reactivex.internal.observers.c r10 = new io.reactivex.internal.observers.c(1, 0);
        subscribe(r10);
        T r11 = (T) r10.a();
        if (r11 != null) goto L5;
        return r5;
    L5:
        return r11;
    }

    public final T blockingLast(T r5) {
        io.reactivex.internal.observers.c r10 = new io.reactivex.internal.observers.c(1, 1);
        subscribe(r10);
        T r11 = (T) r10.a();
        if (r11 != null) goto L5;
        return r5;
    L5:
        return r11;
    }

    public final st.a replay(int r10, long r11, TimeUnit r12) {
        return replay(r10, r11, r12, ut.e.f22461a);
    }

    public final n<T> throttleLatest(long r10, TimeUnit r12, z r13, boolean r14) {
        io.reactivex.internal.functions.e.d(r12, "unit is null");
        io.reactivex.internal.functions.e.d(r13, "scheduler is null");
        return new n3(1, r10, r12, this, r13, r14);
    }

    public final n<ut.f> timeInterval(z r5) {
        return timeInterval(TimeUnit.MILLISECONDS, r5);
    }

    public final n<T> timeout(long r10, TimeUnit r11, s r12) {
        io.reactivex.internal.functions.e.d(r12, "other is null");
        return c(r10, r11, ut.e.f22461a, r12);
    }

    public final n<ut.f> timestamp(z r5) {
        return timestamp(TimeUnit.MILLISECONDS, r5);
    }

    public final <U, R> n<R> zipWith(s r5, pt.c r10, boolean r11) {
        return zip(this, r5, r10, r11);
    }

    public static <T, R> n<R> combineLatest(s[] r5, pt.o r10) {
        return combineLatest(r5, r10, bufferSize());
    }

    public static <T> n<T> concat(s r5, s r10) {
        io.reactivex.internal.functions.e.d(r5, "source1 is null");
        io.reactivex.internal.functions.e.d(r10, "source2 is null");
        return concatArray(new s[]{r5, r10});
    }

    public final T blockingSingle(T r5) {
        a0 r10 = single(r5);
        r10.getClass();
        io.reactivex.internal.observers.d r11 = new io.reactivex.internal.observers.d(1);
        r10.b(r11);
        return (T) r11.a();
    }

    public final n<List<T>> buffer(int r5) {
        return buffer(r5, r5);
    }

    public final n<T> concatWith(c r5) {
        io.reactivex.internal.functions.e.d(r5, "other is null");
        return new h0(this, r5, 0);
    }

    public final n<T> doOnEach(u r5) {
        io.reactivex.internal.functions.e.d(r5, "observer is null");
        return b(new z1(r5, 1), new z1(r5, 0), new y1(r5), io.reactivex.internal.functions.e.f17619c);
    }

    public final n<T> mergeWith(c r5) {
        io.reactivex.internal.functions.e.d(r5, "other is null");
        return new k2(this, r5);
    }

    public final n<T> takeLast(int r5) {
        if (r5 < 0) goto L13;
        if (r5 != 0) goto L7;
        return new io.reactivex.internal.operators.observable.j0(this, 3);
    L7:
        if (r5 != 1) goto L11;
        return new io.reactivex.internal.operators.observable.j0(this, 7);
    L11:
        return new u3(this, r5, 1);
    L13:
        throw new IndexOutOfBoundsException(j0.g(r5, "count >= 0 required but it was "));
    }

    public final n<ut.f> timeInterval(TimeUnit r10, z r11) {
        io.reactivex.internal.functions.e.d(r10, "unit is null");
        io.reactivex.internal.functions.e.d(r11, "scheduler is null");
        return new z4(this, r10, r11, 8, false);
    }

    public final n<ut.f> timestamp(TimeUnit r5, z r10) {
        io.reactivex.internal.functions.e.d(r5, "unit is null");
        io.reactivex.internal.functions.e.d(r10, "scheduler is null");
        return map(new ym.p(9, r5, r10));
    }

    public final a0 toSortedList(Comparator<? super T> r5, int r10) {
        io.reactivex.internal.functions.e.d(r5, "comparator is null");
        a0 r11 = toList(r10);
        com.lynx.tasm.behavior.ui.utils.n r12 = new com.lynx.tasm.behavior.ui.utils.n(r5);
        r11.getClass();
        return new i2(2, r11, r12);
    }

    public final n<n<T>> window(long r10, TimeUnit r11, long r12, boolean r14) {
        return window(r10, r11, ut.e.f22461a, r12, r14);
    }

    public final <U, R> n<R> zipWith(s r5, pt.c r10, boolean r11, int r12) {
        return zip(this, r5, r10, r11, r12);
    }

    public static <T, R> n<R> combineLatest(s[] r10, pt.o r11, int r12) {
        io.reactivex.internal.functions.e.d(r10, "sources is null");
        if (r10.length == 0) goto L5;
        io.reactivex.internal.functions.e.d(r11, "combiner is null");
        io.reactivex.internal.functions.e.e(r12, "bufferSize");
        Iterable r5 = null;
        return new e0(r10, r5, r11, r12 << 1, false, 0);
    L5:
        return empty();
    }

    public static <T, R> n<R> combineLatestDelayError(Iterable<? extends s> r5, pt.o r10) {
        return combineLatestDelayError(r5, r10, bufferSize());
    }

    public static n<Long> interval(long r10, TimeUnit r11, z r12) {
        return interval(r10, r10, r11, r12);
    }

    public static <T> a0 sequenceEqual(s r5, s r10, int r11) {
        return sequenceEqual(r5, r10, io.reactivex.internal.functions.e.f17622j, r11);
    }

    public final n<List<T>> buffer(int r5, int r10) {
        return (n<List<T>>) buffer(r5, r10, ArrayListSupplier.asCallable());
    }

    public final n<T> delay(long r10, TimeUnit r11, z r12) {
        return delay(r10, r11, r12, false);
    }

    public final st.a replay(long r5, TimeUnit r10) {
        return replay(r5, r10, ut.e.f22461a);
    }

    public final n<T> sample(long r10, TimeUnit r12, z r13, boolean r14) {
        io.reactivex.internal.functions.e.d(r12, "unit is null");
        io.reactivex.internal.functions.e.d(r13, "scheduler is null");
        return new n3(0, r10, r12, this, r13, r14);
    }

    public final n<T> sorted(Comparator<? super T> r5) {
        io.reactivex.internal.functions.e.d(r5, "sortFunction is null");
        c0 r10 = toList();
        r10.getClass();
        if ((r10 instanceof rt.b) == false) goto L5;
        n r11 = ((rt.b) r10).a();
    L7:
        return r11.map(new com.lynx.tasm.behavior.ui.utils.n(r5)).flatMapIterable(io.reactivex.internal.functions.e.f17617a);
    L5:
        r11 = new io.reactivex.internal.operators.single.c(r10);
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <K, V> a0 toMultimap(pt.o r5, pt.o r10, Callable<? extends Map<K, Collection<V>>> r11, pt.o r12) {
        io.reactivex.internal.functions.e.d(r5, "keySelector is null");
        io.reactivex.internal.functions.e.d(r10, "valueSelector is null");
        io.reactivex.internal.functions.e.d(r11, "mapSupplier is null");
        io.reactivex.internal.functions.e.d(r12, "collectionFactory is null");
        return collect(r11, new i4.a(r12, 4, r10, r5));
    }

    public final <T1, T2, T3, R> n<R> withLatestFrom(s r5, s r10, s r11, pt.i r12) {
        io.reactivex.internal.functions.e.d(r5, "o1 is null");
        io.reactivex.internal.functions.e.d(r10, "o2 is null");
        io.reactivex.internal.functions.e.d(r11, "o3 is null");
        io.reactivex.internal.functions.e.d(r12, "combiner is null");
        io.reactivex.internal.functions.e.d(null, "f is null");
        throw null;
    }

    public static <T, R> n<R> combineLatestDelayError(Iterable<? extends s> r10, pt.o r11, int r12) {
        io.reactivex.internal.functions.e.d(r10, "sources is null");
        io.reactivex.internal.functions.e.d(r11, "combiner is null");
        io.reactivex.internal.functions.e.e(r12, "bufferSize");
        s[] r5 = null;
        return new e0(r5, r10, r11, r12 << 1, true, 0);
    }

    public static <T> n<T> fromFuture(Future<? extends T> r5, z r10) {
        io.reactivex.internal.functions.e.d(r10, "scheduler is null");
        return fromFuture(r5).subscribeOn(r10);
    }

    public static <T, S> n<T> generate(Callable<S> r5, pt.b r10, pt.g r11) {
        io.reactivex.internal.functions.e.d(r10, "generator is null");
        return generate(r5, new b2(r10, 0), r11);
    }

    public static <T> n<T> merge(s r5, s r10) {
        io.reactivex.internal.functions.e.d(r5, "source1 is null");
        io.reactivex.internal.functions.e.d(r10, "source2 is null");
        return fromArray(new s[]{r5, r10}).flatMap(io.reactivex.internal.functions.e.f17617a, false, 2);
    }

    public static <T> n<T> mergeDelayError(s r5, s r10) {
        io.reactivex.internal.functions.e.d(r5, "source1 is null");
        io.reactivex.internal.functions.e.d(r10, "source2 is null");
        return fromArray(new s[]{r5, r10}).flatMap(io.reactivex.internal.functions.e.f17617a, true, 2);
    }

    public static <T1, T2, R> n<R> zip(s r5, s r10, pt.c r11) {
        io.reactivex.internal.functions.e.d(r5, "source1 is null");
        io.reactivex.internal.functions.e.d(r10, "source2 is null");
        io.reactivex.internal.functions.e.d(r11, "f is null");
        return zipArray(new ym.j(r11), false, bufferSize(), new s[]{r5, r10});
    }

    public final <U extends Collection<? super T>> n<U> buffer(int r5, int r10, Callable<U> r11) {
        io.reactivex.internal.functions.e.e(r5, "count");
        io.reactivex.internal.functions.e.e(r10, "skip");
        io.reactivex.internal.functions.e.d(r11, "bufferSupplier is null");
        return new io.reactivex.internal.operators.observable.q(this, r5, r10, r11);
    }

    public final n<T> delay(long r10, TimeUnit r12, z r13, boolean r14) {
        io.reactivex.internal.functions.e.d(r12, "unit is null");
        io.reactivex.internal.functions.e.d(r13, "scheduler is null");
        return new n3(2, r10, r12, this, r13, r14);
    }

    public final a0 elementAt(long r5, T r10) {
        if (r5 < 0) goto L7;
        io.reactivex.internal.functions.e.d(r10, "defaultItem is null");
        return new d1(this, r5, r10);
    L7:
        throw new IndexOutOfBoundsException(androidx.constraintlayout.motion.widget.a.j(r5, "index >= 0 required but it was "));
    }

    public final n<T> take(long r5, TimeUnit r10) {
        return takeUntil(timer(r5, r10));
    }

    public final n<T> timeout(long r5, TimeUnit r10, z r11, s r12) {
        io.reactivex.internal.functions.e.d(r12, "other is null");
        return c(r5, r10, r11, r12);
    }

    public final n<n<T>> window(long r10) {
        return window(r10, r10, bufferSize());
    }

    public static <T> n<T> concat(s r5, s r10, s r11) {
        io.reactivex.internal.functions.e.d(r5, "source1 is null");
        io.reactivex.internal.functions.e.d(r10, "source2 is null");
        io.reactivex.internal.functions.e.d(r11, "source3 is null");
        return concatArray(new s[]{r5, r10, r11});
    }

    public static <T> n<T> just(T r5, T r10, T r11, T r12) {
        io.reactivex.internal.functions.e.d(r5, "item1 is null");
        io.reactivex.internal.functions.e.d(r10, "item2 is null");
        io.reactivex.internal.functions.e.d(r11, "item3 is null");
        io.reactivex.internal.functions.e.d(r12, "item4 is null");
        return fromArray(new Object[]{r5, r10, r11, r12});
    }

    public final <R> n<R> replay(pt.o r5) {
        io.reactivex.internal.functions.e.d(r5, "selector is null");
        int r10 = 2;
        return new io.reactivex.internal.operators.observable.o(r10, new a2(this), r5);
    }

    public final n<T> take(long r5, TimeUnit r10, z r11) {
        return takeUntil(timer(r5, r10, r11));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <K, V> a0 toMap(pt.o r5, pt.o r10, Callable<? extends Map<K, V>> r11) {
        io.reactivex.internal.functions.e.d(r5, "keySelector is null");
        io.reactivex.internal.functions.e.d(r10, "valueSelector is null");
        io.reactivex.internal.functions.e.d(r11, "mapSupplier is null");
        return collect(r11, new ai.p(10, r10, r5));
    }

    public final n<n<T>> window(long r10, long r11) {
        return window(r10, r11, bufferSize());
    }

    public final <U> n<T> sample(s r5) {
        io.reactivex.internal.functions.e.d(r5, "sampler is null");
        return new g1(this, r5, false, 4);
    }

    @Override // mt.s
    public final void subscribe(u r5) {
        io.reactivex.internal.functions.e.d(r5, "observer is null");
        subscribeActual(r5);     // Catch: Throwable -> L5 NullPointerException -> L8
        return;
    L8:
        e = move-exception;
        throw e;
    L5:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        wn.f.k(th);
        NullPointerException r10 = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
        r10.initCause(th);
        throw r10;
    }

    public final n<T> timeout(long r10, TimeUnit r11, z r12) {
        return c(r10, r11, r12, null);
    }

    public final n<n<T>> window(long r10, long r11, int r13) {
        io.reactivex.internal.functions.e.f(r10, "count");
        io.reactivex.internal.functions.e.f(r11, "skip");
        io.reactivex.internal.functions.e.e(r13, "bufferSize");
        return new m4(this, r10, r11, r13);
    }

    public static <T, S> n<T> generate(Callable<S> r5, pt.c r10) {
        return generate(r5, r10, io.reactivex.internal.functions.e.d);
    }

    public static <T> n<T> merge(s r5, s r10, s r11) {
        io.reactivex.internal.functions.e.d(r5, "source1 is null");
        io.reactivex.internal.functions.e.d(r10, "source2 is null");
        io.reactivex.internal.functions.e.d(r11, "source3 is null");
        return fromArray(new s[]{r5, r10, r11}).flatMap(io.reactivex.internal.functions.e.f17617a, false, 3);
    }

    public static <T> n<T> mergeDelayError(s r5, s r10, s r11) {
        io.reactivex.internal.functions.e.d(r5, "source1 is null");
        io.reactivex.internal.functions.e.d(r10, "source2 is null");
        io.reactivex.internal.functions.e.d(r11, "source3 is null");
        return fromArray(new s[]{r5, r10, r11}).flatMap(io.reactivex.internal.functions.e.f17617a, true, 3);
    }

    public final <U, V> n<T> delay(s r5, pt.o r10) {
        return delaySubscription(r5).delay(r10);
    }

    public final <R> n<R> flatMap(pt.o r5, pt.o r10, Callable<? extends s> r11) {
        io.reactivex.internal.functions.e.d(r5, "onNextMapper is null");
        io.reactivex.internal.functions.e.d(r10, "onErrorMapper is null");
        io.reactivex.internal.functions.e.d(r11, "onCompleteSupplier is null");
        return merge(new io.reactivex.internal.operators.observable.r(this, r5, r10, r11));
    }

    public final <U, V> n<T> timeout(s r10, pt.o r11) {
        io.reactivex.internal.functions.e.d(r10, "firstTimeoutIndicator is null");
        io.reactivex.internal.functions.e.d(r11, "itemTimeoutIndicator is null");
        return new io.reactivex.internal.operators.observable.r(this, r10, r11, null, 1);
    }

    public final a0 toSortedList(int r5) {
        return toSortedList(io.reactivex.internal.functions.e.f17621i, r5);
    }

    public static <T, S> n<T> generate(Callable<S> r5, pt.c r10, pt.g r11) {
        io.reactivex.internal.functions.e.d(r5, "initialState is null");
        io.reactivex.internal.functions.e.d(r10, "generator is null");
        io.reactivex.internal.functions.e.d(r11, "disposeState is null");
        return new o1(r5, r10, r11);
    }

    public final void blockingSubscribe(pt.g r5) {
        com.lynx.tasm.base.a.o(this, r5, io.reactivex.internal.functions.e.e, io.reactivex.internal.functions.e.f17619c);
    }

    public final <U extends Collection<? super T>> n<U> buffer(int r5, Callable<U> r10) {
        return buffer(r5, r5, r10);
    }

    public final <R> n<R> replay(pt.o r5, int r10) {
        io.reactivex.internal.functions.e.d(r5, "selector is null");
        io.reactivex.internal.functions.e.e(r10, "bufferSize");
        u1 r11 = new u1(this, r10);
        return new io.reactivex.internal.operators.observable.o(2, r11, r5);
    }

    public final <U> n<T> sample(s r5, boolean r10) {
        io.reactivex.internal.functions.e.d(r5, "sampler is null");
        return new g1(this, r5, r10, 4);
    }

    public final n<T> skipLast(long r10, TimeUnit r11, z r12) {
        return skipLast(r10, r11, r12, false, bufferSize());
    }

    public final <T1, T2, T3, T4, R> n<R> withLatestFrom(s r5, s r10, s r11, s r12, pt.j r13) {
        io.reactivex.internal.functions.e.d(r5, "o1 is null");
        io.reactivex.internal.functions.e.d(r10, "o2 is null");
        io.reactivex.internal.functions.e.d(r11, "o3 is null");
        io.reactivex.internal.functions.e.d(r12, "o4 is null");
        io.reactivex.internal.functions.e.d(r13, "combiner is null");
        io.reactivex.internal.functions.e.d(null, "f is null");
        throw null;
    }

    public static <T1, T2, R> n<R> combineLatest(s r5, s r10, pt.c r11) {
        io.reactivex.internal.functions.e.d(r5, "source1 is null");
        io.reactivex.internal.functions.e.d(r10, "source2 is null");
        io.reactivex.internal.functions.e.d(r11, "f is null");
        return combineLatest(new ym.j(r11), bufferSize(), new s[]{r5, r10});
    }

    public static <T> n<T> concat(s r5, s r10, s r11, s r12) {
        io.reactivex.internal.functions.e.d(r5, "source1 is null");
        io.reactivex.internal.functions.e.d(r10, "source2 is null");
        io.reactivex.internal.functions.e.d(r11, "source3 is null");
        io.reactivex.internal.functions.e.d(r12, "source4 is null");
        return concatArray(new s[]{r5, r10, r11, r12});
    }

    public static <T1, T2, R> n<R> zip(s r5, s r10, pt.c r11, boolean r12) {
        io.reactivex.internal.functions.e.d(r5, "source1 is null");
        io.reactivex.internal.functions.e.d(r10, "source2 is null");
        io.reactivex.internal.functions.e.d(r11, "f is null");
        return zipArray(new ym.j(r11), r12, bufferSize(), new s[]{r5, r10});
    }

    public final void blockingSubscribe(pt.g r5, pt.g r10) {
        com.lynx.tasm.base.a.o(this, r5, r10, io.reactivex.internal.functions.e.f17619c);
    }

    public final n<List<T>> buffer(long r10, long r11, TimeUnit r13, z r14) {
        return (n<List<T>>) buffer(r10, r11, r13, r14, ArrayListSupplier.asCallable());
    }

    public final n<T> retry(pt.p r5) {
        return retry(Long.MAX_VALUE, r5);
    }

    public final n<T> skipLast(long r10, TimeUnit r11, z r12, boolean r13) {
        return skipLast(r10, r11, r12, r13, bufferSize());
    }

    public final <K, V> a0 toMultimap(pt.o r5, pt.o r10, Callable<Map<K, Collection<V>>> r11) {
        return toMultimap(r5, r10, r11, ArrayListSupplier.asFunction());
    }

    public static <T> n<T> just(T r5, T r10, T r11, T r12, T r13) {
        io.reactivex.internal.functions.e.d(r5, "item1 is null");
        io.reactivex.internal.functions.e.d(r10, "item2 is null");
        io.reactivex.internal.functions.e.d(r11, "item3 is null");
        io.reactivex.internal.functions.e.d(r12, "item4 is null");
        io.reactivex.internal.functions.e.d(r13, "item5 is null");
        return fromArray(new Object[]{r5, r10, r11, r12, r13});
    }

    public final void blockingSubscribe(pt.g r5, pt.g r10, pt.a r11) {
        com.lynx.tasm.base.a.o(this, r5, r10, r11);
    }

    public final <U extends Collection<? super T>> n<U> buffer(long r13, long r15, TimeUnit r17, z r18, Callable<U> r19) {
        io.reactivex.internal.functions.e.d(r17, "unit is null");
        io.reactivex.internal.functions.e.d(r18, "scheduler is null");
        io.reactivex.internal.functions.e.d(r19, "bufferSupplier is null");
        return new io.reactivex.internal.operators.observable.z(this, r13, r15, r17, r18, r19, Integer.MAX_VALUE, false);
    }

    public final n<T> skipLast(long r10, TimeUnit r12, z r13, boolean r14, int r15) {
        io.reactivex.internal.functions.e.d(r12, "unit is null");
        io.reactivex.internal.functions.e.d(r13, "scheduler is null");
        io.reactivex.internal.functions.e.e(r15, "bufferSize");
        return new v3(r15 << 1, r10, r12, this, r13, r14);
    }

    public final <U, V> n<T> timeout(s r10, pt.o r11, s r12) {
        io.reactivex.internal.functions.e.d(r10, "firstTimeoutIndicator is null");
        io.reactivex.internal.functions.e.d(r12, "other is null");
        io.reactivex.internal.functions.e.d(r11, "itemTimeoutIndicator is null");
        return new io.reactivex.internal.operators.observable.r(this, r10, r11, r12, 1);
    }

    public final n<n<T>> window(long r10, long r11, TimeUnit r13, z r14) {
        return window(r10, r11, r13, r14, bufferSize());
    }

    public static <T> n<T> merge(s r5, s r10, s r11, s r12) {
        io.reactivex.internal.functions.e.d(r5, "source1 is null");
        io.reactivex.internal.functions.e.d(r10, "source2 is null");
        io.reactivex.internal.functions.e.d(r11, "source3 is null");
        io.reactivex.internal.functions.e.d(r12, "source4 is null");
        return fromArray(new s[]{r5, r10, r11, r12}).flatMap(io.reactivex.internal.functions.e.f17617a, false, 4);
    }

    public static <T> n<T> mergeDelayError(s r5, s r10, s r11, s r12) {
        io.reactivex.internal.functions.e.d(r5, "source1 is null");
        io.reactivex.internal.functions.e.d(r10, "source2 is null");
        io.reactivex.internal.functions.e.d(r11, "source3 is null");
        io.reactivex.internal.functions.e.d(r12, "source4 is null");
        return fromArray(new s[]{r5, r10, r11, r12}).flatMap(io.reactivex.internal.functions.e.f17617a, true, 4);
    }

    public final void blockingSubscribe(u r5) {
        com.lynx.tasm.base.a.n(this, r5);
    }

    public final <R> n<R> flatMap(pt.o r5, pt.o r10, Callable<? extends s> r11, int r12) {
        io.reactivex.internal.functions.e.d(r5, "onNextMapper is null");
        io.reactivex.internal.functions.e.d(r10, "onErrorMapper is null");
        io.reactivex.internal.functions.e.d(r11, "onCompleteSupplier is null");
        return merge(new io.reactivex.internal.operators.observable.r(this, r5, r10, r11), r12);
    }

    public final n<n<T>> window(long r14, long r16, TimeUnit r18, z r19, int r20) {
        io.reactivex.internal.functions.e.f(r14, "timespan");
        io.reactivex.internal.functions.e.f(r16, "timeskip");
        io.reactivex.internal.functions.e.e(r20, "bufferSize");
        io.reactivex.internal.functions.e.d(r19, "scheduler is null");
        io.reactivex.internal.functions.e.d(r18, "unit is null");
        return new y4(this, r14, r16, r18, r19, Long.MAX_VALUE, r20, false);
    }

    public final <R> n<R> replay(pt.o r10, int r11, long r12, TimeUnit r13, z r14) {
        io.reactivex.internal.functions.e.d(r10, "selector is null");
        io.reactivex.internal.functions.e.e(r11, "bufferSize");
        io.reactivex.internal.functions.e.d(r13, "unit is null");
        io.reactivex.internal.functions.e.d(r14, "scheduler is null");
        v1 r5 = new v1(r11, r12, r13, this, r14);
        return new io.reactivex.internal.operators.observable.o(2, r5, r10);
    }

    public static <T1, T2, T3, R> n<R> combineLatest(s r5, s r10, s r11, pt.h r12) {
        io.reactivex.internal.functions.e.d(r5, "source1 is null");
        io.reactivex.internal.functions.e.d(r10, "source2 is null");
        io.reactivex.internal.functions.e.d(r11, "source3 is null");
        io.reactivex.internal.functions.e.d(null, "f is null");
        throw null;
    }

    public static <T1, T2, R> n<R> zip(s r5, s r10, pt.c r11, boolean r12, int r13) {
        io.reactivex.internal.functions.e.d(r5, "source1 is null");
        io.reactivex.internal.functions.e.d(r10, "source2 is null");
        io.reactivex.internal.functions.e.d(r11, "f is null");
        return zipArray(new ym.j(r11), r12, r13, new s[]{r5, r10});
    }

    public final n<List<T>> buffer(long r10, TimeUnit r11, z r12, int r13) {
        return (n<List<T>>) buffer(r10, r11, r12, r13, ArrayListSupplier.asCallable(), false);
    }

    public final n<T> takeLast(long r10, long r12, TimeUnit r14, z r15) {
        return takeLast(r10, r12, r14, r15, false, bufferSize());
    }

    public final <V> n<T> timeout(pt.o r10) {
        io.reactivex.internal.functions.e.d(r10, "itemTimeoutIndicator is null");
        s r5 = null;
        return new io.reactivex.internal.operators.observable.r(this, r5, r10, r5, 1);
    }

    public final <R> n<R> withLatestFrom(s[] r5, pt.o r10) {
        io.reactivex.internal.functions.e.d(r5, "others is null");
        io.reactivex.internal.functions.e.d(r10, "combiner is null");
        return new io.reactivex.internal.operators.observable.r(this, r5, r10);
    }

    public final <U extends Collection<? super T>> n<U> buffer(long r13, TimeUnit r15, z r16, int r17, Callable<U> r18, boolean r19) {
        io.reactivex.internal.functions.e.d(r15, "unit is null");
        io.reactivex.internal.functions.e.d(r16, "scheduler is null");
        io.reactivex.internal.functions.e.d(r18, "bufferSupplier is null");
        io.reactivex.internal.functions.e.e(r17, "count");
        return new io.reactivex.internal.operators.observable.z(this, r13, r13, r15, r16, r18, r17, r19);
    }

    public final <R> n<R> flatMap(pt.o r5, int r10) {
        return flatMap(r5, false, r10, bufferSize());
    }

    public final n<T> takeLast(long r12, long r14, TimeUnit r16, z r17, boolean r18, int r19) {
        io.reactivex.internal.functions.e.d(r16, "unit is null");
        io.reactivex.internal.functions.e.d(r17, "scheduler is null");
        io.reactivex.internal.functions.e.e(r19, "bufferSize");
        if (r12 < 0) goto L7;
        return new c4(this, r12, r14, r16, r17, r19, r18);
    L7:
        throw new IndexOutOfBoundsException(androidx.constraintlayout.motion.widget.a.j(r12, "count >= 0 required but it was "));
    }

    public static <T> n<T> just(T r5, T r10, T r11, T r12, T r13, T r14) {
        io.reactivex.internal.functions.e.d(r5, "item1 is null");
        io.reactivex.internal.functions.e.d(r10, "item2 is null");
        io.reactivex.internal.functions.e.d(r11, "item3 is null");
        io.reactivex.internal.functions.e.d(r12, "item4 is null");
        io.reactivex.internal.functions.e.d(r13, "item5 is null");
        io.reactivex.internal.functions.e.d(r14, "item6 is null");
        return fromArray(new Object[]{r5, r10, r11, r12, r13, r14});
    }

    public final <U, R> n<R> flatMap(pt.o r10, pt.c r11) {
        return flatMap(r10, r11, false, bufferSize(), bufferSize());
    }

    public final <U, R> n<R> flatMap(pt.o r10, pt.c r11, boolean r12) {
        return flatMap(r10, r11, r12, bufferSize(), bufferSize());
    }

    public final n<n<T>> window(long r10, TimeUnit r11, z r12) {
        return window(r10, r11, r12, Long.MAX_VALUE, false);
    }

    public final <R> n<R> withLatestFrom(Iterable<? extends s> r5, pt.o r10) {
        io.reactivex.internal.functions.e.d(r5, "others is null");
        io.reactivex.internal.functions.e.d(r10, "combiner is null");
        return new io.reactivex.internal.operators.observable.r(this, r5, r10);
    }

    public static <T1, T2, T3, T4, R> n<R> combineLatest(s r5, s r10, s r11, s r12, pt.i r13) {
        io.reactivex.internal.functions.e.d(r5, "source1 is null");
        io.reactivex.internal.functions.e.d(r10, "source2 is null");
        io.reactivex.internal.functions.e.d(r11, "source3 is null");
        io.reactivex.internal.functions.e.d(r12, "source4 is null");
        io.reactivex.internal.functions.e.d(null, "f is null");
        throw null;
    }

    public final <U, R> n<R> flatMap(pt.o r10, pt.c r11, boolean r12, int r13) {
        return flatMap(r10, r11, r12, r13, bufferSize());
    }

    public final <R> n<R> replay(pt.o r5, int r10, z r11) {
        io.reactivex.internal.functions.e.d(r5, "selector is null");
        io.reactivex.internal.functions.e.d(r11, "scheduler is null");
        io.reactivex.internal.functions.e.e(r10, "bufferSize");
        u1 r12 = new u1(this, r10);
        x1 r13 = new x1(2, r5, r11);
        return new io.reactivex.internal.operators.observable.o(2, r12, r13);
    }

    public final n<n<T>> window(long r10, TimeUnit r11, z r12, long r13) {
        return window(r10, r11, r12, r13, false);
    }

    public static <T1, T2, T3, R> n<R> zip(s r5, s r10, s r11, pt.h r12) {
        io.reactivex.internal.functions.e.d(r5, "source1 is null");
        io.reactivex.internal.functions.e.d(r10, "source2 is null");
        io.reactivex.internal.functions.e.d(r11, "source3 is null");
        io.reactivex.internal.functions.e.d(null, "f is null");
        throw null;
    }

    public final <U, R> n<R> flatMap(pt.o r5, pt.c r10, boolean r11, int r12, int r13) {
        io.reactivex.internal.functions.e.d(r5, "mapper is null");
        io.reactivex.internal.functions.e.d(r10, "combiner is null");
        return flatMap(new x1(1, r10, r5), r11, r12, r13);
    }

    public final n<n<T>> window(long r10, TimeUnit r12, z r13, long r14, boolean r16) {
        return window(r10, r12, r13, r14, r16, bufferSize());
    }

    public final n<List<T>> buffer(long r10, TimeUnit r11, z r12) {
        return (n<List<T>>) buffer(r10, r11, r12, Integer.MAX_VALUE, ArrayListSupplier.asCallable(), false);
    }

    public final n<n<T>> window(long r14, TimeUnit r16, z r17, long r18, boolean r20, int r21) {
        io.reactivex.internal.functions.e.e(r21, "bufferSize");
        io.reactivex.internal.functions.e.d(r17, "scheduler is null");
        io.reactivex.internal.functions.e.d(r16, "unit is null");
        io.reactivex.internal.functions.e.f(r18, "count");
        return new y4(this, r14, r14, r16, r17, r18, r21, r20);
    }

    public final <TOpening, TClosing> n<List<T>> buffer(s r5, pt.o r10) {
        return (n<List<T>>) buffer(r5, r10, ArrayListSupplier.asCallable());
    }

    public final <TOpening, TClosing, U extends Collection<? super T>> n<U> buffer(s r10, pt.o r11, Callable<U> r12) {
        io.reactivex.internal.functions.e.d(r10, "openingIndicator is null");
        io.reactivex.internal.functions.e.d(r11, "closingIndicator is null");
        io.reactivex.internal.functions.e.d(r12, "bufferSupplier is null");
        return new io.reactivex.internal.operators.observable.r(this, r10, r11, r12, 0);
    }

    public static <T1, T2, T3, T4, T5, R> n<R> combineLatest(s r5, s r10, s r11, s r12, s r13, pt.j r14) {
        io.reactivex.internal.functions.e.d(r5, "source1 is null");
        io.reactivex.internal.functions.e.d(r10, "source2 is null");
        io.reactivex.internal.functions.e.d(r11, "source3 is null");
        io.reactivex.internal.functions.e.d(r12, "source4 is null");
        io.reactivex.internal.functions.e.d(r13, "source5 is null");
        io.reactivex.internal.functions.e.d(null, "f is null");
        throw null;
    }

    public static <T> n<T> just(T r5, T r10, T r11, T r12, T r13, T r14, T r15) {
        io.reactivex.internal.functions.e.d(r5, "item1 is null");
        io.reactivex.internal.functions.e.d(r10, "item2 is null");
        io.reactivex.internal.functions.e.d(r11, "item3 is null");
        io.reactivex.internal.functions.e.d(r12, "item4 is null");
        io.reactivex.internal.functions.e.d(r13, "item5 is null");
        io.reactivex.internal.functions.e.d(r14, "item6 is null");
        io.reactivex.internal.functions.e.d(r15, "item7 is null");
        return fromArray(new Object[]{r5, r10, r11, r12, r13, r14, r15});
    }

    public static <T1, T2, T3, T4, R> n<R> zip(s r5, s r10, s r11, s r12, pt.i r13) {
        io.reactivex.internal.functions.e.d(r5, "source1 is null");
        io.reactivex.internal.functions.e.d(r10, "source2 is null");
        io.reactivex.internal.functions.e.d(r11, "source3 is null");
        io.reactivex.internal.functions.e.d(r12, "source4 is null");
        io.reactivex.internal.functions.e.d(null, "f is null");
        throw null;
    }

    public final <U, R> n<R> flatMap(pt.o r10, pt.c r11, int r12) {
        return flatMap(r10, r11, false, r12, bufferSize());
    }

    public final <R> n<R> replay(pt.o r10, long r11, TimeUnit r12, z r13) {
        io.reactivex.internal.functions.e.d(r10, "selector is null");
        io.reactivex.internal.functions.e.d(r12, "unit is null");
        io.reactivex.internal.functions.e.d(r13, "scheduler is null");
        c2 r5 = new c2(this, r11, r12, r13);
        return new io.reactivex.internal.operators.observable.o(2, r5, r10);
    }

    public final <B> n<n<T>> window(s r5) {
        return window(r5, bufferSize());
    }

    public final <B> n<List<T>> buffer(s r5) {
        return (n<List<T>>) buffer(r5, ArrayListSupplier.asCallable());
    }

    public final n<T> takeLast(long r10, TimeUnit r11, z r12) {
        return takeLast(r10, r11, r12, false, bufferSize());
    }

    public final <B> n<n<T>> window(s r5, int r10) {
        io.reactivex.internal.functions.e.d(r5, "boundary is null");
        io.reactivex.internal.functions.e.e(r10, "bufferSize");
        return new o4(this, r5, r10, 0);
    }

    public final <B> n<List<T>> buffer(s r5, int r10) {
        io.reactivex.internal.functions.e.e(r10, "initialCapacity");
        return (n<List<T>>) buffer(r5, new io.reactivex.internal.functions.a(r10));
    }

    public final n<T> takeLast(long r10, TimeUnit r11, z r12, boolean r13) {
        return takeLast(r10, r11, r12, r13, bufferSize());
    }

    public static <T1, T2, T3, T4, T5, R> n<R> zip(s r5, s r10, s r11, s r12, s r13, pt.j r14) {
        io.reactivex.internal.functions.e.d(r5, "source1 is null");
        io.reactivex.internal.functions.e.d(r10, "source2 is null");
        io.reactivex.internal.functions.e.d(r11, "source3 is null");
        io.reactivex.internal.functions.e.d(r12, "source4 is null");
        io.reactivex.internal.functions.e.d(r13, "source5 is null");
        io.reactivex.internal.functions.e.d(null, "f is null");
        throw null;
    }

    public final n<T> takeLast(long r10, TimeUnit r12, z r13, boolean r14, int r15) {
        return takeLast(Long.MAX_VALUE, r10, r12, r13, r14, r15);
    }

    public static <T1, T2, T3, T4, T5, T6, R> n<R> combineLatest(s r5, s r10, s r11, s r12, s r13, s r14, pt.k r15) {
        io.reactivex.internal.functions.e.d(r5, "source1 is null");
        io.reactivex.internal.functions.e.d(r10, "source2 is null");
        io.reactivex.internal.functions.e.d(r11, "source3 is null");
        io.reactivex.internal.functions.e.d(r12, "source4 is null");
        io.reactivex.internal.functions.e.d(r13, "source5 is null");
        io.reactivex.internal.functions.e.d(r14, "source6 is null");
        io.reactivex.internal.functions.e.d(null, "f is null");
        throw null;
    }

    public final <R> n<R> replay(pt.o r5, z r10) {
        io.reactivex.internal.functions.e.d(r5, "selector is null");
        io.reactivex.internal.functions.e.d(r10, "scheduler is null");
        a2 r11 = new a2(this);
        x1 r12 = new x1(2, r5, r10);
        return new io.reactivex.internal.operators.observable.o(2, r11, r12);
    }

    public final <U, V> n<n<T>> window(s r5, pt.o r10) {
        return window(r5, r10, bufferSize());
    }

    public final <B, U extends Collection<? super T>> n<U> buffer(s r10, Callable<U> r11) {
        io.reactivex.internal.functions.e.d(r10, "boundary is null");
        io.reactivex.internal.functions.e.d(r11, "bufferSupplier is null");
        return new z4(this, r10, r11, 2, false);
    }

    public final <U, V> n<n<T>> window(s r5, pt.o r10, int r11) {
        io.reactivex.internal.functions.e.d(r5, "openingIndicator is null");
        io.reactivex.internal.functions.e.d(r10, "closingIndicator is null");
        io.reactivex.internal.functions.e.e(r11, "bufferSize");
        return new f0(this, r5, r10, r11);
    }

    public static <T> n<T> just(T r5, T r10, T r11, T r12, T r13, T r14, T r15, T r16) {
        io.reactivex.internal.functions.e.d(r5, "item1 is null");
        io.reactivex.internal.functions.e.d(r10, "item2 is null");
        io.reactivex.internal.functions.e.d(r11, "item3 is null");
        io.reactivex.internal.functions.e.d(r12, "item4 is null");
        io.reactivex.internal.functions.e.d(r13, "item5 is null");
        io.reactivex.internal.functions.e.d(r14, "item6 is null");
        io.reactivex.internal.functions.e.d(r15, "item7 is null");
        io.reactivex.internal.functions.e.d(r16, "item8 is null");
        return fromArray(new Object[]{r5, r10, r11, r12, r13, r14, r15, r16});
    }

    public final <B> n<List<T>> buffer(Callable<? extends s> r5) {
        return (n<List<T>>) buffer(r5, ArrayListSupplier.asCallable());
    }

    public static <T1, T2, T3, T4, T5, T6, R> n<R> zip(s r5, s r10, s r11, s r12, s r13, s r14, pt.k r15) {
        io.reactivex.internal.functions.e.d(r5, "source1 is null");
        io.reactivex.internal.functions.e.d(r10, "source2 is null");
        io.reactivex.internal.functions.e.d(r11, "source3 is null");
        io.reactivex.internal.functions.e.d(r12, "source4 is null");
        io.reactivex.internal.functions.e.d(r13, "source5 is null");
        io.reactivex.internal.functions.e.d(r14, "source6 is null");
        io.reactivex.internal.functions.e.d(null, "f is null");
        throw null;
    }

    public final <B, U extends Collection<? super T>> n<U> buffer(Callable<? extends s> r5, Callable<U> r10) {
        io.reactivex.internal.functions.e.d(r5, "boundarySupplier is null");
        io.reactivex.internal.functions.e.d(r10, "bufferSupplier is null");
        return new z4(this, r5, r10, 1);
    }

    public final st.a replay(int r5) {
        io.reactivex.internal.functions.e.e(r5, "bufferSize");
        if (r5 != Integer.MAX_VALUE) goto L6;
        return k3.e(this, k3.e);
    L6:
        return k3.e(this, new g3(r5));
    }

    public final <B> n<n<T>> window(Callable<? extends s> r5) {
        return window(r5, bufferSize());
    }

    public final <B> n<n<T>> window(Callable<? extends s> r5, int r10) {
        io.reactivex.internal.functions.e.d(r5, "boundary is null");
        io.reactivex.internal.functions.e.e(r10, "bufferSize");
        return new o4(this, r5, r10, 1);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> n<R> combineLatest(s r5, s r10, s r11, s r12, s r13, s r14, s r15, pt.l r16) {
        io.reactivex.internal.functions.e.d(r5, "source1 is null");
        io.reactivex.internal.functions.e.d(r10, "source2 is null");
        io.reactivex.internal.functions.e.d(r11, "source3 is null");
        io.reactivex.internal.functions.e.d(r12, "source4 is null");
        io.reactivex.internal.functions.e.d(r13, "source5 is null");
        io.reactivex.internal.functions.e.d(r14, "source6 is null");
        io.reactivex.internal.functions.e.d(r15, "source7 is null");
        io.reactivex.internal.functions.e.d(null, "f is null");
        throw null;
    }

    public final st.a replay(int r10, long r11, TimeUnit r12, z r13) {
        io.reactivex.internal.functions.e.e(r10, "bufferSize");
        io.reactivex.internal.functions.e.d(r12, "unit is null");
        io.reactivex.internal.functions.e.d(r13, "scheduler is null");
        return k3.e(this, new i3(r10, r11, r12, r13));
    }

    public static <T> n<T> just(T r5, T r10, T r11, T r12, T r13, T r14, T r15, T r16, T r17) {
        io.reactivex.internal.functions.e.d(r5, "item1 is null");
        io.reactivex.internal.functions.e.d(r10, "item2 is null");
        io.reactivex.internal.functions.e.d(r11, "item3 is null");
        io.reactivex.internal.functions.e.d(r12, "item4 is null");
        io.reactivex.internal.functions.e.d(r13, "item5 is null");
        io.reactivex.internal.functions.e.d(r14, "item6 is null");
        io.reactivex.internal.functions.e.d(r15, "item7 is null");
        io.reactivex.internal.functions.e.d(r16, "item8 is null");
        io.reactivex.internal.functions.e.d(r17, "item9 is null");
        return fromArray(new Object[]{r5, r10, r11, r12, r13, r14, r15, r16, r17});
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> n<R> zip(s r5, s r10, s r11, s r12, s r13, s r14, s r15, pt.l r16) {
        io.reactivex.internal.functions.e.d(r5, "source1 is null");
        io.reactivex.internal.functions.e.d(r10, "source2 is null");
        io.reactivex.internal.functions.e.d(r11, "source3 is null");
        io.reactivex.internal.functions.e.d(r12, "source4 is null");
        io.reactivex.internal.functions.e.d(r13, "source5 is null");
        io.reactivex.internal.functions.e.d(r14, "source6 is null");
        io.reactivex.internal.functions.e.d(r15, "source7 is null");
        io.reactivex.internal.functions.e.d(null, "f is null");
        throw null;
    }

    public final st.a replay(int r5, z r10) {
        io.reactivex.internal.functions.e.e(r5, "bufferSize");
        st.a r11 = replay(r5);
        return new e3(r11, r11.observeOn(r10));
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> n<R> combineLatest(s r5, s r10, s r11, s r12, s r13, s r14, s r15, s r16, pt.m r17) {
        io.reactivex.internal.functions.e.d(r5, "source1 is null");
        io.reactivex.internal.functions.e.d(r10, "source2 is null");
        io.reactivex.internal.functions.e.d(r11, "source3 is null");
        io.reactivex.internal.functions.e.d(r12, "source4 is null");
        io.reactivex.internal.functions.e.d(r13, "source5 is null");
        io.reactivex.internal.functions.e.d(r14, "source6 is null");
        io.reactivex.internal.functions.e.d(r15, "source7 is null");
        io.reactivex.internal.functions.e.d(r16, "source8 is null");
        io.reactivex.internal.functions.e.d(null, "f is null");
        throw null;
    }

    public final st.a replay(long r10, TimeUnit r11, z r12) {
        io.reactivex.internal.functions.e.d(r11, "unit is null");
        io.reactivex.internal.functions.e.d(r12, "scheduler is null");
        return k3.e(this, new i3(Integer.MAX_VALUE, r10, r11, r12));
    }

    public final st.a replay(z r5) {
        io.reactivex.internal.functions.e.d(r5, "scheduler is null");
        st.a r10 = replay();
        return new e3(r10, r10.observeOn(r5));
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> n<R> zip(s r5, s r10, s r11, s r12, s r13, s r14, s r15, s r16, pt.m r17) {
        io.reactivex.internal.functions.e.d(r5, "source1 is null");
        io.reactivex.internal.functions.e.d(r10, "source2 is null");
        io.reactivex.internal.functions.e.d(r11, "source3 is null");
        io.reactivex.internal.functions.e.d(r12, "source4 is null");
        io.reactivex.internal.functions.e.d(r13, "source5 is null");
        io.reactivex.internal.functions.e.d(r14, "source6 is null");
        io.reactivex.internal.functions.e.d(r15, "source7 is null");
        io.reactivex.internal.functions.e.d(r16, "source8 is null");
        io.reactivex.internal.functions.e.d(null, "f is null");
        throw null;
    }

    public static <T> n<T> just(T r5, T r10, T r11, T r12, T r13, T r14, T r15, T r16, T r17, T r18) {
        io.reactivex.internal.functions.e.d(r5, "item1 is null");
        io.reactivex.internal.functions.e.d(r10, "item2 is null");
        io.reactivex.internal.functions.e.d(r11, "item3 is null");
        io.reactivex.internal.functions.e.d(r12, "item4 is null");
        io.reactivex.internal.functions.e.d(r13, "item5 is null");
        io.reactivex.internal.functions.e.d(r14, "item6 is null");
        io.reactivex.internal.functions.e.d(r15, "item7 is null");
        io.reactivex.internal.functions.e.d(r16, "item8 is null");
        io.reactivex.internal.functions.e.d(r17, "item9 is null");
        io.reactivex.internal.functions.e.d(r18, "item10 is null");
        return fromArray(new Object[]{r5, r10, r11, r12, r13, r14, r15, r16, r17, r18});
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> n<R> combineLatest(s r5, s r10, s r11, s r12, s r13, s r14, s r15, s r16, s r17, pt.n r18) {
        io.reactivex.internal.functions.e.d(r5, "source1 is null");
        io.reactivex.internal.functions.e.d(r10, "source2 is null");
        io.reactivex.internal.functions.e.d(r11, "source3 is null");
        io.reactivex.internal.functions.e.d(r12, "source4 is null");
        io.reactivex.internal.functions.e.d(r13, "source5 is null");
        io.reactivex.internal.functions.e.d(r14, "source6 is null");
        io.reactivex.internal.functions.e.d(r15, "source7 is null");
        io.reactivex.internal.functions.e.d(r16, "source8 is null");
        io.reactivex.internal.functions.e.d(r17, "source9 is null");
        io.reactivex.internal.functions.e.d(null, "f is null");
        throw null;
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> n<R> zip(s r5, s r10, s r11, s r12, s r13, s r14, s r15, s r16, s r17, pt.n r18) {
        io.reactivex.internal.functions.e.d(r5, "source1 is null");
        io.reactivex.internal.functions.e.d(r10, "source2 is null");
        io.reactivex.internal.functions.e.d(r11, "source3 is null");
        io.reactivex.internal.functions.e.d(r12, "source4 is null");
        io.reactivex.internal.functions.e.d(r13, "source5 is null");
        io.reactivex.internal.functions.e.d(r14, "source6 is null");
        io.reactivex.internal.functions.e.d(r15, "source7 is null");
        io.reactivex.internal.functions.e.d(r16, "source8 is null");
        io.reactivex.internal.functions.e.d(r17, "source9 is null");
        io.reactivex.internal.functions.e.d(null, "f is null");
        throw null;
    }
}
