package com.bytedance.android.livesdk.gift.platform.core.utils;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class w {

    public static final class a<T> implements Consumer {
        public final /* synthetic */ String a;
        public final /* synthetic */ Function1 b;

        public a(String r1, Function1 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            wy0.g r4 = (wy0.g) r3;
            if ((!Intrinsics.areEqual(r4.getName(), this.a)) == true) goto L7;
            this.b.invoke(r4);
            return;
        }
    }

    public static final Disposable a(String r2, Function1<? super wy0.g, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        Intrinsics.checkNotNullParameter(r3, "executable");
        cy0.e.a.getClass();
        cy0.j r0 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r1 = com.bytedance.android.scope.m.b(r0).a(Reflection.getOrCreateKotlinClass(vy0.b.class));
        Intrinsics.checkNotNull(r1);
        Observable r4 = ((f80.a) r1).B0(r2);
        int r5 = com.bytedance.revenue.platform.api.core.rx.p.a;
        return r4.observeOn(AndroidSchedulers.mainThread()).subscribe(new a(r2, r3));
    }
}
