package com.larus.platform.api;

import android.view.View;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class k3$a implements k3 {
    public static final /* synthetic */ k3$a b = null;
    public static final Lazy<k3> c = null;

    public k3$a() {
    }

    static {
        b = new k3$a();
        c = LazyKt.lazy(new j3());
    }

    public final String l() {
        k3 r0 = (k3) c.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.l();
    }

    public final String m() {
        k3 r0 = (k3) c.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.m();
    }

    public final void k(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        k3 r0 = (k3) c.getValue();
        if (r0 == null) goto L6;
        r0.k(r2);
        return;
    }
}
