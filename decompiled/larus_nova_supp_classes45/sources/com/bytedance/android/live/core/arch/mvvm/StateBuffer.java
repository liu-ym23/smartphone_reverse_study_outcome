package com.bytedance.android.live.core.arch.mvvm;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class StateBuffer<T> extends Observable<T> implements Observer<T> {
    public static final /* synthetic */ int d = 0;
    public Function1<? super T, Unit> a;
    public final PublishSubject<T> b;
    public a<T> c;

    public static final class Companion {
        public static StateBuffer a(final Function2 r2) {
            Intrinsics.checkNotNullParameter(r2, "block");
            final StateBuffer r0 = new StateBuffer();
            Function1<T, Unit> r1 = new StateBuffer$Companion$create$1(r2, r0);
            Intrinsics.checkNotNullParameter(r1, "<set-?>");
            r0.a = r1;
            return r0;
        }
    }

    public static abstract class a<T> {

        /* JADX INFO: renamed from: com.bytedance.android.live.core.arch.mvvm.StateBuffer$a$a, reason: collision with other inner class name */
        public static final class C0137a<T> extends a<T> {
            public h80.c<T> a;

            public C0137a() {
            }

            @Override // com.bytedance.android.live.core.arch.mvvm.StateBuffer.a
            public final void a(Function1<? super T, Unit> r3) {
                Intrinsics.checkNotNullParameter(r3, "next");
                h80.c<T> r0 = this.a;
                if (r0 == null) goto L10;
                T r1 = r0.a;
                if (r1 != null) goto L8;
                r1 = null;
            L8:
                r3.invoke(r1);
                this.a = null;
                return;
            }

            @Override // com.bytedance.android.live.core.arch.mvvm.StateBuffer.a
            public final void b(T r2, Function1<? super T, Unit> r3) {
                Intrinsics.checkNotNullParameter(r3, "next");
                this.a = h80.c.c(r2);
            }
        }

        public static final class b<T> extends a<T> {
            @Override // com.bytedance.android.live.core.arch.mvvm.StateBuffer.a
            public final void a(Function1<? super T, Unit> r2) {
                Intrinsics.checkNotNullParameter(r2, "next");
            }

            public b() {
            }

            @Override // com.bytedance.android.live.core.arch.mvvm.StateBuffer.a
            public final void b(T r2, Function1<? super T, Unit> r3) {
                Intrinsics.checkNotNullParameter(r3, "next");
                r3.invoke(r2);
            }
        }

        public a() {
        }

        public abstract void a(Function1<? super T, Unit> r1);

        public abstract void b(T r1, Function1<? super T, Unit> r2);
    }

    static {
    }

    public final void onComplete() {
        this.b.onComplete();
    }

    public StateBuffer() {
        this.a = StateBuffer$onEnterState$1.INSTANCE;
        this.b = PublishSubject.create();
        this.c = new a.b();
    }

    public final void a(a<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "strategy");
        a<T> r0 = this.c;
        this.c = r2;
        r0.a(new StateBuffer$curStrategy$1(this));
    }

    public final void onError(Throwable r2) {
        Intrinsics.checkNotNullParameter(r2, "e");
        this.b.onError(r2);
    }

    public final void onNext(T r3) {
        Intrinsics.checkNotNullParameter(r3, "t");
        this.c.b(r3, new StateBuffer$sendState$1(this));
    }

    public final void onSubscribe(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "d");
        this.b.onSubscribe(r2);
    }

    public final void subscribeActual(Observer<? super T> r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        this.b.subscribe(r2);
    }
}
