package com.ss.android.lark.reaction.userscope;

import com.ss.android.lark.newemoji.emoji_panel.DefaultEmojiPanelData;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import f0c.g;
import java.util.List;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ReactionOrderServiceProxy extends c0c.b implements m2c.a {
    public final /* synthetic */ m2c.a b;
    public final v c;
    public final com.ss.android.lark.passportc.convention.b<m2c.a> d;

    @Override // m2c.a
    @Deprecated(message = "Deprecated in Java")
    public final void I2() {
        this.b.I2();
    }

    @Override // m2c.a
    public final List<String> N(boolean r2) {
        return this.b.N(r2);
    }

    @Override // m2c.a
    public final List<String> U2() {
        return this.b.U2();
    }

    @Override // m2c.a
    public final void Wc(String r2, String r3) {
        this.b.Wc(r2, r3);
    }

    @Override // m2c.a
    public final DefaultEmojiPanelData a() {
        return this.b.a();
    }

    @Override // m2c.a
    @Deprecated(message = "Deprecated in Java")
    public final List<String> f() {
        return this.b.f();
    }

    @Override // m2c.a
    public final void fetchData() {
        this.b.fetchData();
    }

    @Override // m2c.a
    public final List<String> h() {
        return this.b.h();
    }

    @Override // m2c.a
    public final boolean j5(String r2) {
        return this.b.j5(r2);
    }

    @Override // m2c.a
    public final void md(boolean r2) {
        this.b.md(true);
    }

    @Override // m2c.a
    @Deprecated(message = "Deprecated in Java")
    public final List<String> o() {
        return this.b.o();
    }

    @Override // m2c.a
    public final void q8(m2c.c r4) {
        if (r4 == null) goto L5;
        this.d.d(new com.ss.android.lark.passportc.convention.b.C0095b(m2c.c.class, r4));
        return;
    }

    @Override // m2c.a
    public final void v2(final m2c.c r6) {
        if (r6 == null) goto L5;
        this.d.a(new com.ss.android.lark.passportc.convention.b.C0095b(m2c.c.class, r6), new com.ss.android.lark.passportc.convention.b.c(new ReactionOrderServiceProxy$addOnEmojiPanelUpdateListener$1$1(r6), new ReactionOrderServiceProxy$addOnEmojiPanelUpdateListener$1$2(r6)));
        return;
    }

    public ReactionOrderServiceProxy(j r4, v r5) {
        UserSession r1 = r4.b();
        if (r1 != null) goto L5;
        r1 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<m2c.a> r0 = new com.ss.android.lark.passportc.convention.b(k.b(r5.c(r1), m2c.a.class), m2c.a.class);
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
        m2c.a r6 = (m2c.a) k.b(r3.c(r5), m2c.a.class);
        this.d.e(r6);
        return;
    L6:
        r5 = ContainerConstsKt.a();
        goto L7
    }
}
