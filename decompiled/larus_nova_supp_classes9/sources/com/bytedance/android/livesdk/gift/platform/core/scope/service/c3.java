package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import io.reactivex.disposables.CompositeDisposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c3 implements com.bytedance.android.scope.o {
    public final CompositeDisposable a;
    public final t2 b;
    public final vy0.b c;

    public static final class a implements wy0.d {
        public a() {
        }

        public final Map<String, wy0.h<Object, ?>> c(y6.c r2) {
            Intrinsics.checkNotNullParameter(r2, "manager");
            return new LinkedHashMap();
        }

        public final Map<String, com.bytedance.ies.web.jsbridge2.g<Object, ?>> f(y6.c r2) {
            Intrinsics.checkNotNullParameter(r2, "manager");
            Intrinsics.checkNotNullParameter(r2, "manager");
            return MapsKt.emptyMap();
        }
    }

    public final void onStart() {
        com.bytedance.revenue.platform.api.core.rx.f.a(this.c.Sb(new a()), this.a);
        this.b.g0();
    }

    public final void onStop() {
        this.a.clear();
    }

    public c3(t2 r2, vy0.b r3) {
        Intrinsics.checkNotNullParameter(r2, "globalJsbService");
        Intrinsics.checkNotNullParameter(r3, "hybridService");
        this.b = r2;
        this.c = r3;
        this.a = new CompositeDisposable();
    }
}
