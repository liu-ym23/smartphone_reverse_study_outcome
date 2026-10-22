package com.bytedance.ies.bullet.web.pia;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f6221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f6222b;

    public c(k r5) {
        this.f6221a = r5;
        this.f6222b = LazyKt.lazy(PiaCustomContext$preloader$2.f6213a);
    }

    public final Object a(Class r5) {
        Intrinsics.checkNotNullParameter(r5, "type");
        if (Intrinsics.areEqual(r5, dh.c.class) == false) goto L9;
        a r10 = (a) this.f6222b.getValue();
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10;
    L9:
        if (Intrinsics.areEqual(r5, k.class) == false) goto L14;
        k r11 = this.f6221a;
        if (r11 != null) goto L13;
        return null;
    L13:
        return r11;
    L14:
        return null;
    }
}
