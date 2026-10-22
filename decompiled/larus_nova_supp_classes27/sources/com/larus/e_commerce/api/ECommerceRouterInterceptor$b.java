package com.larus.e_commerce.api;

import android.content.Context;
import android.net.Uri;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class ECommerceRouterInterceptor$b implements h {
    public final /* synthetic */ com.bytedance.router.c a;
    public final /* synthetic */ ECommerceRouterInterceptor b;
    public final /* synthetic */ Context c;

    @Override // com.larus.e_commerce.api.h
    public final void a() {
        Intrinsics.checkNotNullParameter("ecommerce plugin init failed", "reason");
    }

    @Override // com.larus.e_commerce.api.h
    public final void onInitSuccess() {
        Uri r0 = this.a.d;
        if (Intrinsics.areEqual(r0.getAuthority(), "webcast_webview") == false) goto L11;
        IECommerceService r1 = this.b.f();
        boolean r2 = false;
        if (r1 == null) goto L9;
        Context r3 = this.c;
        Intrinsics.checkNotNull(r0);
        if (r1.n(r3, r0) != true) goto L9;
        r2 = true;
    L9:
        if (r2 == false) goto L11;
        return;
    L11:
        IECommerceService r4 = this.b.f();
        if (r4 == null) goto L15;
        r4.c(this.c, this.a.d);
        return;
    }

    public ECommerceRouterInterceptor$b(com.bytedance.router.c r1, ECommerceRouterInterceptor r2, Context r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
