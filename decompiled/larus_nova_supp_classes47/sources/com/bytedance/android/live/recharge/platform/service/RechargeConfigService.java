package com.bytedance.android.live.recharge.platform.service;

import com.bytedance.android.live.recharge.platform.core.config.RechargeConfigKey;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class RechargeConfigService implements com.bytedance.android.scope.o, zv0.g {
    public bx0.f a;
    public final Lazy b;

    public final void onStop() {
    }

    public final void onStart() {
        this.a = new bx0.f();
    }

    public RechargeConfigService() {
        this.b = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new RechargeConfigService$configStore$2(this));
    }

    @Override // zv0.g
    public final <T extends zv0.h> T p1(Class<T> r3) {
        Intrinsics.checkNotNullParameter(r3, "clazz");
        bx0.e r1 = (bx0.e) this.b.getValue();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "clazz");
        Object r4 = MapsKt.getValue(r1.b, r3);
        if (r4 == null) goto L7;
        return (T) r4;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type T");
    }

    public final <V> V E1(RechargeConfigKey r3, V r4) {
        Intrinsics.checkNotNullParameter(r3, "key");
        bx0.e r1 = (bx0.e) this.b.getValue();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "key");
        Object r5 = r1.a.get(r3);
        if ((r5 instanceof Object) == true) goto L5;
        r5 = null;
    L5:
        if (r5 != null) goto L8;
        return r4;
    L8:
        return (V) r5;
    }
}
