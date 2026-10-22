package com.ss.android.lark.reaction.userscope;

import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import com.ss.android.lark.reaction.service.impl.ReactionOrderService2$fetchEmojiPanelData$2;
import e0c.k;
import f0c.g;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c extends c0c.b implements m2c.b {
    public final /* synthetic */ m2c.b b;
    public final v c;
    public final com.ss.android.lark.passportc.convention.b<m2c.b> d;

    @Override // m2c.b
    public final List<String> N(boolean r2) {
        return this.b.N(r2);
    }

    @Override // m2c.b
    public final void Ya(String r2, String r3, boolean r4, IGetDataCallback<Integer> r5) {
        this.b.Ya(r2, r3, r4, r5);
    }

    @Override // m2c.b
    public final void o7(boolean r2, ReactionOrderService2$fetchEmojiPanelData$2 r3) {
        this.b.o7(r2, r3);
    }

    @Override // m2c.b
    public final void q(String r2, IGetDataCallback<Integer> r3) {
        this.b.q(r2, r3);
    }

    public c(j r4, v r5) {
        UserSession r1 = r4.b();
        if (r1 != null) goto L5;
        r1 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<m2c.b> r0 = new com.ss.android.lark.passportc.convention.b(k.b(r5.c(r1), m2c.b.class), m2c.b.class);
        Intrinsics.checkNotNullParameter(r4, "passport");
        Intrinsics.checkNotNullParameter(r5, "accessor");
        Intrinsics.checkNotNullParameter(r0, "proxy");
        super(r4);
        this.b = r0.b();
        this.c = r5;
        this.d = r0;
    }

    @Override // c0c.b
    public final void pf(g r1, f0c.b r2) {
        Intrinsics.checkNotNullParameter(r2, "toState");
        v r3 = this.c;
        g r4 = r2.a();
        if (r4 == null) goto L6;
        UserSession r5 = r4.b;
        if (r5 == null) goto L6;
    L7:
        m2c.b r6 = (m2c.b) k.b(r3.c(r5), m2c.b.class);
        this.d.e(r6);
        return;
    L6:
        r5 = ContainerConstsKt.a();
        goto L7
    }
}
