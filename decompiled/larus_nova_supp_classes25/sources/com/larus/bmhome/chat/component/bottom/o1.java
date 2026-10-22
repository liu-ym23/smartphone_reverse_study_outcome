package com.larus.bmhome.chat.component.bottom;

import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import s1a.d;
import t1a.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public abstract class o1<D> {
    public final b a;

    public o1(ComponentFeature r2) {
        Intrinsics.checkNotNullParameter(r2, "component");
        this.a = d.a(r2);
    }

    public static Lazy a(final o1 r2, final Class r3) {
        Intrinsics.checkNotNullParameter(r3, "clazz");
        final t1a.a r1 = null;
        return LazyKt.lazy(new m1(r2, r3, r1));
    }
}
