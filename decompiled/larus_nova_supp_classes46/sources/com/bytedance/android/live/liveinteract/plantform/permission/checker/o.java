package com.bytedance.android.live.liveinteract.plantform.permission.checker;

import android.content.Context;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import com.bytedance.android.live.user.IMiddlewareUserService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class o implements qh0.a<rh0.a>, qh0.d<rh0.a> {
    public qh0.d<rh0.a> a;
    public final qh0.f.g b;
    public final qh0.a<rh0.a> c;

    @Override // qh0.a
    public final void a(qh0.d<rh0.a> r2) {
        Intrinsics.checkNotNullParameter(r2, "consumer");
        this.a = r2;
        qh0.a<rh0.a> r3 = this.c;
        if (r3 == null) goto L5;
        r3.a(this);
        return;
    L5:
        c(null);
    }

    @Override // qh0.d
    public final void b(BaseCheckException r3) {
        Intrinsics.checkNotNullParameter(r3, "exception");
        qh0.d<rh0.a> r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L5:
        r0.b(r3);
    }

    public final void c(rh0.a r4) {
        if (jc1.k.n(IMiddlewareUserService.class).user().isLogin() == false) goto L8;
        qh0.d<rh0.a> r5 = this.a;
        if (r5 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L7:
        r5.onResult(null);
        return;
    L8:
        com.bytedance.android.livesdk.user.e r6 = jc1.k.n(IMiddlewareUserService.class).user();
        Context r0 = this.b.getContext();
        com.bytedance.android.livesdk.user.l.a r1 = new com.bytedance.android.livesdk.user.l.a();
        r1.a = s1.B(2131919339);
        r1.d = "interact";
        r1.c = 0;
        r6.login(r0, new com.bytedance.android.livesdk.user.l(r1)).subscribe(new n(this));
    }

    @Override // qh0.d
    public final /* bridge */ /* synthetic */ void onResult(rh0.a r1) {
        c(r1);
    }

    public o(qh0.f.g r2, qh0.a<rh0.a> r3) {
        Intrinsics.checkNotNullParameter(r2, "createConfig");
        this.b = r2;
        this.c = r3;
    }
}
