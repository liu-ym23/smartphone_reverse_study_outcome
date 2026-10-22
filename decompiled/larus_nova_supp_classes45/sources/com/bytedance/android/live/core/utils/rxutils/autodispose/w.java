package com.bytedance.android.live.core.utils.rxutils.autodispose;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.subjects.BehaviorSubject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class w extends Observable<Lifecycle.Event> {
    public final Lifecycle a;
    public final BehaviorSubject<Lifecycle.Event> b;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Lifecycle.State.values().length];
            a = r0;
            r0[Lifecycle.State.INITIALIZED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            a[Lifecycle.State.CREATED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            a[Lifecycle.State.STARTED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            a[Lifecycle.State.RESUMED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            a[Lifecycle.State.DESTROYED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public static final class b extends qtc.a implements LifecycleObserver {
        public final Lifecycle b;
        public final Observer<? super Lifecycle.Event> c;
        public final BehaviorSubject<Lifecycle.Event> d;

        public final void b() {
            this.b.removeObserver(this);
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
        public void onStateChange(LifecycleOwner r1, Lifecycle.Event r2) {
            if (isDisposed() == false) goto L5;
            return;
        L5:
            if (r2 == Lifecycle.Event.ON_CREATE) goto L7;
        L8:
            this.d.onNext(r2);
        L9:
            this.c.onNext(r2);
            return;
        L7:
            if (this.d.getValue() == r2) goto L9;
            goto L8
        }

        public b(Lifecycle r1, Observer<? super Lifecycle.Event> r2, BehaviorSubject<Lifecycle.Event> r3) {
            this.b = r1;
            this.c = r2;
            this.d = r3;
        }
    }

    public w(Lifecycle r2) {
        this.b = BehaviorSubject.create();
        this.a = r2;
    }

    public final void subscribeActual(Observer<? super Lifecycle.Event> r4) {
        b r0 = new b(this.a, r4, this.b);
        r4.onSubscribe(r0);
        if (l80.b.a.getAsBoolean() == true) goto L7;
        r4.onError(new IllegalStateException("Lifecycles can only be bound to on the main thread!"));
        return;
    L7:
        this.a.addObserver(r0);
        if (r0.isDisposed() == false) goto L16;
        this.a.removeObserver(r0);
        return;
    L16:
        return;
    L11:
        e = move-exception;
        throw Exceptions.propagate(e);
    }
}
