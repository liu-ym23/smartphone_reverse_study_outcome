package com.larus.e_commerce.impl.order;

import com.larus.utils.t0;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class k implements com.larus.e_commerce.api.h {
    public final /* synthetic */ Function0<Unit> a;
    public final /* synthetic */ Function1<String, Unit> b;

    @Override // com.larus.e_commerce.api.h
    public final void a() {
        Intrinsics.checkNotNullParameter("ecommerce plugin init failed", "reason");
        final Function1<String, Unit> r0 = this.b;
        t0.e(new j(r0));
    }

    @Override // com.larus.e_commerce.api.h
    public final void onInitSuccess() {
        final Function0<Unit> r0 = this.a;
        t0.e(new i(r0));
    }

    public k(g r1, h r2) {
        this.a = r1;
        this.b = r2;
    }
}
