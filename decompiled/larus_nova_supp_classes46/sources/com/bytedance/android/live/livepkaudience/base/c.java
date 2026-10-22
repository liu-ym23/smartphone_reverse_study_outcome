package com.bytedance.android.live.livepkaudience.base;

import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements qh0.d<rh0.a> {
    public final /* synthetic */ BasePkInteractGuestWidget a;

    public c(BasePkInteractGuestWidget r1) {
        this.a = r1;
    }

    @Override // qh0.d
    public final void b(BaseCheckException r2) {
        Intrinsics.checkNotNullParameter(r2, "exception");
        dl0.m.a.getClass();
        dl0.m.v(r2);
    }

    @Override // qh0.d
    public final void onResult(rh0.a r2) {
        q r3 = this.a.b;
        if (r3 == null) goto L5;
        r3.c();
    L5:
        dl0.m.B(dl0.m.a, "check_link_permission_success");
    }
}
