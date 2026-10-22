package com.ss.android.lark.forwardv3.forward.mediaforward;

import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d extends c0c.b implements f {
    public final /* synthetic */ f b;
    public final v c;
    public final com.ss.android.lark.passportc.convention.b<f> d;

    public d(j r4, v r5) {
        UserSession r0 = r4.b();
        if (r0 != null) goto L5;
        r0 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<f> r2 = new com.ss.android.lark.passportc.convention.b(k.b(r5.c(r0), f.class), f.class);
        Intrinsics.checkNotNullParameter(r4, "passport");
        Intrinsics.checkNotNullParameter(r5, "accessor");
        Intrinsics.checkNotNullParameter(r2, "proxy");
        super(r4);
        this.b = (f) r2.b();
        this.c = r5;
        this.d = r2;
    }

    public final void qf(f0c.g r1, f0c.g r2) {
        if (r2 == null) goto L5;
        UserSession r3 = r2.b;
        if (r3 == null) goto L5;
    L6:
        f r4 = (f) k.b(this.c.c(r3), f.class);
        this.d.e(r4);
        return;
    L5:
        r3 = ContainerConstsKt.a();
        goto L6
    }
}
