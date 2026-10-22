package com.ss.android.lark.chat.service.impl;

import com.ss.android.lark.chat.video.InnerVideoPreviewFragment$playVideo$1;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.entity.UserSession;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class x1 extends c0c.b implements m6b.n {
    public final /* synthetic */ m6b.n b;
    public final com.ss.android.lark.passportc.internal.v c;
    public final com.ss.android.lark.passportc.convention.b<m6b.n> d;

    public static final class a {
    }

    static {
    }

    @Override // m6b.n
    public final void Z2(String r2, boolean r3, InnerVideoPreviewFragment$playVideo$1 r4) {
        Intrinsics.checkNotNullParameter(r2, "url");
        Intrinsics.checkNotNullParameter(r4, "callback");
        this.b.Z2(r2, r3, r4);
    }

    public x1(com.ss.android.lark.passportc.api.j r4, com.ss.android.lark.passportc.internal.v r5) {
        UserSession r1 = r4.b();
        if (r1 != null) goto L5;
        r1 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<m6b.n> r0 = new com.ss.android.lark.passportc.convention.b(e0c.k.b(r5.c(r1), m6b.n.class), m6b.n.class);
        Intrinsics.checkNotNullParameter(r4, "passport");
        Intrinsics.checkNotNullParameter(r5, "accessor");
        Intrinsics.checkNotNullParameter(r0, "instanceHolder");
        super(r4);
        this.b = (m6b.n) r0.b();
        this.c = r5;
        this.d = r0;
    }

    public final void qf(f0c.g r2, f0c.g r3) {
        Log.i("PreviewVideoServiceProxy", "preparing IPreviewVideoService");
        com.ss.android.lark.passportc.internal.v r4 = this.c;
        if (r3 == null) goto L6;
        UserSession r5 = r3.b;
        if (r5 == null) goto L6;
    L7:
        m6b.n r6 = (m6b.n) e0c.k.b(r4.c(r5), m6b.n.class);
        this.d.e(r6);
        return;
    L6:
        r5 = ContainerConstsKt.a();
        goto L7
    }
}
