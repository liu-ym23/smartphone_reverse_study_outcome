package com.bytedance.android.livesdk.gift.platform.core.interceptor;

import com.bytedance.android.livesdk.gift.platform.core.h;
import com.bytedance.android.scope.o;
import cy0.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements o {
    public final GiftInterceptorNew a;
    public final AssetsInterceptorNew b;

    public static final class a {
    }

    static {
    }

    public final void onStop() {
    }

    public final void onStart() {
        if (h.i() == true) goto L5;
        return;
    L5:
        GiftInterceptorNew r0 = this.a;
        r0.getClass();
        if (h.i() == false) goto L8;
        r0.f.h(r0);
    L8:
        AssetsInterceptorNew r1 = this.b;
        r1.getClass();
        if (h.i() == true) goto L11;
        return;
    L11:
        if ((r1.k instanceof f) == false) goto L15;
        r1.g.h(r1);
        return;
    }

    public b(GiftInterceptorNew r2, AssetsInterceptorNew r3) {
        Intrinsics.checkNotNullParameter(r2, "giftInterceptorNew");
        Intrinsics.checkNotNullParameter(r3, "assetsInterceptorNew");
        this.a = r2;
        this.b = r3;
    }
}
