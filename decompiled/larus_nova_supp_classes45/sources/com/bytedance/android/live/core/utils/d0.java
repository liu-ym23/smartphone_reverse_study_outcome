package com.bytedance.android.live.core.utils;

import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d0 {

    public static final class a<T> implements Predicate {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final boolean test(Object r2) {
            sh6.b r3 = (sh6.b) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return r3.a();
        }
    }

    public static final class b<T, R> implements Function {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final Object apply(Object r2) {
            sh6.b r3 = (sh6.b) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return sh6.c.b(r3);
        }
    }

    public static final <T> Observable<T> c(com.bytedance.live.datacontext.n<T> r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$onValuePresent");
        return r1.a().filter(a.a).map(b.a);
    }

    public static final void a(PropertyOwner r1, com.bytedance.live.datacontext.m r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$forwardTo");
        Intrinsics.checkNotNullParameter(r2, "member");
        com.bytedance.android.live.core.arch.mvvm.f.b(r1).takeUntil(r2.a().ignoreElements().toObservable()).subscribe(new c0(r2));
    }

    public static final <T> void b(Observable<T> r1, com.bytedance.live.datacontext.k<T> r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$forwardTo");
        Intrinsics.checkNotNullParameter(r2, "member");
        r1.subscribe(r2.a());
    }
}
