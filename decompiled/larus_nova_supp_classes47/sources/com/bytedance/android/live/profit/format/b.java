package com.bytedance.android.live.profit.format;

import com.bytedance.android.scope.l;
import com.bytedance.android.scope.o;
import e33.k;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements o, dy0.c {
    public f a;

    public b() {
    }

    public final void onStop() {
    }

    public final void onStart() {
        cy0.e.a.getClass();
        f r0 = new f(cy0.e.a.a);
        Intrinsics.checkNotNullParameter(r0, "scope");
        Object r1 = k.a;
        l.a(r0);
        Unit r2 = Unit.INSTANCE;
        this.a = r0;
    }
}
