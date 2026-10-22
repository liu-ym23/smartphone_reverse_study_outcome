package com.bytedance.android.live.core.utils.rxutils;

import android.animation.Animator;
import android.os.CountDownTimer;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.concurrent.Callable;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class RxUtilKt {

    public static final class a implements Action {
        public final /* synthetic */ Animator a;
        public final /* synthetic */ boolean b;

        public a(Animator r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void run() {
            if (this.b == false) goto L5;
            this.a.cancel();
            return;
        L5:
            this.a.end();
        }
    }

    public static final class b<T> implements ObservableOnSubscribe {
        public final /* synthetic */ long a;
        public final /* synthetic */ long b;

        public static final class a implements ttc.c {
            public final /* synthetic */ CountDownTimerC0172b a;

            public a(CountDownTimerC0172b r1) {
                this.a = r1;
            }

            public final void cancel() {
                this.a.cancel();
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.core.utils.rxutils.RxUtilKt$b$b, reason: collision with other inner class name */
        public static final class CountDownTimerC0172b extends CountDownTimer {
            public final /* synthetic */ ObservableEmitter a;

            @Override // android.os.CountDownTimer
            public final void onFinish() {
                this.a.onNext(0L);
                this.a.onComplete();
            }

            @Override // android.os.CountDownTimer
            public final void onTick(long r2) {
                this.a.onNext(Long.valueOf(r2));
            }

            public CountDownTimerC0172b(ObservableEmitter r1, long r2, long r4) {
                this.a = r1;
                super(r2, r4);
            }
        }

        public b(long r1, long r3) {
            this.a = r1;
            this.b = r3;
        }

        public final void subscribe(ObservableEmitter<Long> r8) {
            Intrinsics.checkNotNullParameter(r8, "emitter");
            CountDownTimerC0172b r0 = new CountDownTimerC0172b(r8, this.a, this.b);
            r8.setCancellable(new a(r0));
            r0.start();
        }
    }

    public static final class c<V> implements Callable {
        public final /* synthetic */ Observable a;

        public static final class a<T, R> implements Function {
            public final /* synthetic */ Ref.ObjectRef a;

            public a(Ref.ObjectRef r1) {
                this.a = r1;
            }

            public final Object apply(Object r3) {
                Pair r0 = TuplesKt.to(this.a.element, r3);
                this.a.element = r3;
                return r0;
            }
        }

        public c(Observable r1) {
            this.a = r1;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }

        @Override // java.util.concurrent.Callable
        public final ObservableSource<? extends Pair<T, T>> call() {
            Ref.ObjectRef r0 = new Ref.ObjectRef();
            r0.element = null;
            return this.a.map(new a(r0));
        }
    }

    public static final class d<T> implements ObservableOnSubscribe {
        public final /* synthetic */ View a;
        public final /* synthetic */ boolean b;

        public static final class a implements ttc.c {
            public final /* synthetic */ Disposable a;
            public final /* synthetic */ Ref.ObjectRef b;
            public final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener c;

            public a(Disposable r1, Ref.ObjectRef r2, c r3) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            public final void cancel() {
                this.a.dispose();
                ViewTreeObserver r0 = (ViewTreeObserver) this.b.element;
                if (r0 == null) goto L6;
                r0.removeOnGlobalLayoutListener(this.c);
                return;
            }
        }

        public static final class b<T> implements Consumer {
            public final /* synthetic */ d a;
            public final /* synthetic */ Ref.ObjectRef b;
            public final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener c;
            public final /* synthetic */ ObservableEmitter d;

            public b(d r1, Ref.ObjectRef r2, c r3, ObservableEmitter r4) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
            }

            public final void accept(Object r3) {
                Ref.ObjectRef r0 = this.b;
                if (((Boolean) r3).booleanValue() == false) goto L5;
                ViewTreeObserver r4 = this.a.a.getViewTreeObserver();
                r4.addOnGlobalLayoutListener(this.c);
            L12:
                r0.element = r4;
                return;
            L5:
                ViewTreeObserver r5 = (ViewTreeObserver) this.b.element;
                if (r5 == null) goto L9;
                r5.removeOnGlobalLayoutListener(this.c);
            L9:
                if (this.a.b == false) goto L11;
                this.d.onComplete();
            L11:
                r4 = null;
                goto L12
            }
        }

        public static final class c implements ViewTreeObserver.OnGlobalLayoutListener {
            public final /* synthetic */ ObservableEmitter a;

            public c(ObservableEmitter r1) {
                this.a = r1;
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                this.a.onNext(Unit.INSTANCE);
            }
        }

        public d(View r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void subscribe(ObservableEmitter<Unit> r5) {
            Intrinsics.checkNotNullParameter(r5, "emitter");
            c r0 = new c(r5);
            Ref.ObjectRef r1 = new Ref.ObjectRef();
            r1.element = null;
            View r2 = this.a;
            Intrinsics.checkNotNullParameter(r2, "$this$getOnAttachStateChangeObservable");
            r5.setCancellable(new a(Observable.create(new s(r2)).subscribe(new b(this, r1, r0, r5)), r1, r0));
        }
    }

    public final class e implements Action {
        public final /* synthetic */ Function0 a;

        public e(Function0 r1) {
            this.a = r1;
        }

        public final /* synthetic */ void run() {
            this.a.invoke();
        }
    }

    public static final <T> Observable<Pair<T, T>> e(Observable<T> r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$diff");
        return Observable.defer(new c(r1));
    }

    public static final Function1<Throwable, Unit> f(final String r1) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        return new RxUtilKt$getOnErrorTrace$1(r1);
    }

    public static final <T> Observable<T> h(Observable<T> r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$observeOnUi");
        return r1.observeOn(AndroidSchedulers.mainThread());
    }

    public static final <T> Single<T> i(Single<T> r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$observeOnUi");
        return r1.observeOn(AndroidSchedulers.mainThread());
    }

    public static final t j(final TextView r1) {
        Intrinsics.checkNotNullParameter(r1, "view");
        Function1<CharSequence, Unit> r0 = new RxUtilKt$observerOf$3(r1);
        Intrinsics.checkNotNullParameter(r0, "f");
        return new t(r0);
    }

    public static void s(Completable r3) {
        RxUtilKt$subscribeOnErrorTrace$4 r0 = RxUtilKt$subscribeOnErrorTrace$4.INSTANCE;
        Intrinsics.checkNotNullParameter(r3, "$this$subscribeOnErrorTrace");
        Intrinsics.checkNotNullParameter("StreamCaptureService", "tag");
        Intrinsics.checkNotNullParameter(r0, "onComplete");
        r3.subscribe(new e(r0), new u(f("StreamCaptureService")));
    }

    public static final <T extends Animator> Disposable a(T r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$asDisposable");
        return Disposables.fromAction(new a(r1, r2));
    }

    public static final void c(Disposable r1, CompositeDisposable r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$bind");
        if (r2 == null) goto L6;
        r2.add(r1);
        return;
    }

    public static final Observable<Long> d(long r1, long r3) {
        return Observable.create(new b(r1, r3));
    }

    public static final Observable<Unit> g(View r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$getOnGlobalLayoutObservable");
        return Observable.create(new d(r1, r2));
    }

    public static final void l(SingleEmitter r1, com.bytedance.android.live.profit.player.s r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$safeOnSuccess");
        Intrinsics.checkNotNullParameter(r2, "t");
        if (r1.isDisposed() == true) goto L6;
        r1.onSuccess(r2);
        return;
    }

    public static final Disposable m(Completable r2, Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$subscribeOnErrorNoOp");
        Intrinsics.checkNotNullParameter(r3, "onComplete");
        e r0 = new e(r3);
        Consumer r4 = RxUtilKt$getOnErrorNoOp$1.INSTANCE;
        if (r4 == null) goto L6;
        r4 = new u(r4);
    L6:
        return r2.subscribe(r0, r4);
    }

    public static final <T> Disposable n(Observable<T> r2, Function1<? super T, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$subscribeOnErrorNoOp");
        Intrinsics.checkNotNullParameter(r3, "onNext");
        u r0 = new u(r3);
        Consumer r4 = RxUtilKt$getOnErrorNoOp$1.INSTANCE;
        if (r4 == null) goto L6;
        r4 = new u(r4);
    L6:
        return r2.subscribe(r0, r4);
    }

    public static final <T> Disposable o(Single<T> r2, Function1<? super T, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$subscribeOnErrorNoOp");
        Intrinsics.checkNotNullParameter(r3, "onNext");
        u r0 = new u(r3);
        Consumer r4 = RxUtilKt$getOnErrorNoOp$1.INSTANCE;
        if (r4 == null) goto L6;
        r4 = new u(r4);
    L6:
        return r2.subscribe(r0, r4);
    }

    public static /* synthetic */ Disposable r(Single r1, String r2) {
        return q(r1, r2, RxUtilKt$subscribeOnErrorTrace$2.INSTANCE);
    }

    public static final <T> Observable<T> b(DataCenter r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "$this$asObservable");
        Intrinsics.checkNotNullParameter(r3, "key");
        return Observable.create(new r(r2, RxUtilKt$asObservable$1.INSTANCE, r3, r4));
    }

    public static final Disposable k(Observable r2, t r3, Function1 r4) {
        Intrinsics.checkNotNullParameter(r2, "source");
        Intrinsics.checkNotNullParameter(r3, "target");
        Intrinsics.checkNotNullParameter(r4, "transformer");
        return r2.map(new v(r4)).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserverDelegate(r3, null, 2, null));
    }

    public static final <T> Disposable p(Observable<T> r1, String r2, Function1<? super T, Unit> r3) {
        Intrinsics.checkNotNullParameter(r1, "$this$subscribeOnErrorTrace");
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "onNext");
        return r1.subscribe(new u(r3), new u(f(r2)));
    }

    public static final <T> Disposable q(Single<T> r1, String r2, Function1<? super T, Unit> r3) {
        Intrinsics.checkNotNullParameter(r1, "$this$subscribeOnErrorTrace");
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "onNext");
        return r1.subscribe(new u(r3), new u(f(r2)));
    }
}
