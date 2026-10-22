package com.bytedance.android.anya.internal;

import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d<E> {
    public final ArrayDeque<E> a;
    public final Set<Function1<E, Boolean>> b;

    public static final class a implements Runnable {
        public final /* synthetic */ d a;
        public final /* synthetic */ Function1 b;

        public a(d r1, Function1 r10) {
            this.a = r1;
            this.b = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Iterator<E> r0 = this.a.a.iterator();     // Catch: Throwable -> L10
        L4:
            if (r0.hasNext() == false) goto L8;
            E r1 = r0.next();     // Catch: Throwable -> L10
            if (((Boolean) this.b.invoke(r1)).booleanValue() == false) goto L4;
            r0.remove();     // Catch: Throwable -> L10
            goto L4
        L8:
            this.a.b.add(this.b);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L14;
            return;
        L14:
            throw th;
        }
    }

    public static final class b implements Action {
        public final /* synthetic */ d a;
        public final /* synthetic */ Function1 b;

        public static final class a implements Runnable {
            public final /* synthetic */ b a;

            public a(b r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                b r0 = this.a;     // Catch: Throwable -> L4
                r0.a.b.remove(r0.b);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public b(d r1, Function1 r10) {
            this.a = r1;
            this.b = r10;
        }

        public final void run() {
            if ((!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) == false) goto L5;
            v.a.post(new a(this));
            return;
        L5:
            this.a.b.remove(this.b);
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ d a;
        public final /* synthetic */ Object b;

        public c(d r1, Object r10) {
            this.a = r1;
            this.b = r10;
        }

        public final void a() {
            Set<Function1<E, Boolean>> r0 = this.a.b;
            boolean r10 = true;
            if ((r0 instanceof Collection) == true) goto L5;
        L7:
            Iterator<T> r1 = r0.iterator();
        L9:
            if (r1.hasNext() == false) goto L13;
            if (((Boolean) ((Function1) r1.next()).invoke(this.b)).booleanValue() == false) goto L9;
            r10 = false;
        L13:
            if (r10 == false) goto L19;
            this.a.a.push((E) this.b);
            return;
        L19:
            return;
        L5:
            if (r0.isEmpty() == false) goto L7;
            goto L7
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public d() {
        this.a = new ArrayDeque();
        this.b = new LinkedHashSet();
    }

    public final Disposable a(Function1<? super E, Boolean> r10) {
        if ((!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) == false) goto L5;
        v.a.post(new a(this, r10));
    L13:
        return Disposables.fromAction(new b(this, r10));
    L5:
        Iterator<E> r0 = this.a.iterator();
    L7:
        if (r0.hasNext() == false) goto L11;
        if (((Boolean) r10.invoke(r0.next())).booleanValue() == false) goto L7;
        r0.remove();
        goto L7
    L11:
        this.b.add(r10);
        goto L13
    }

    public final void b(E r10) {
        boolean r1 = true;
        if ((!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) == false) goto L5;
        v.a.post(new c(this, r10));
        return;
    L5:
        Set<Function1<E, Boolean>> r0 = this.b;
        if ((r0 instanceof Collection) == true) goto L8;
    L10:
        Iterator<T> r11 = r0.iterator();
    L12:
        if (r11.hasNext() == false) goto L16;
        if (((Boolean) ((Function1) r11.next()).invoke(r10)).booleanValue() == false) goto L12;
        r1 = false;
    L16:
        if (r1 == false) goto L23;
        this.a.push(r10);
        return;
    L23:
        return;
    L8:
        if (r0.isEmpty() == false) goto L10;
        goto L10
    }
}
