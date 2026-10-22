package com.ss.android.lark.chat.service.impl;

import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.dto.draft.Draft;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.entity.UserSession;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class s extends c0c.b implements m6b.g {
    public final /* synthetic */ m6b.g b;
    public final com.ss.android.lark.passportc.internal.v c;
    public final com.ss.android.lark.passportc.convention.b<m6b.g> d;

    public static final class a {
    }

    static {
    }

    @Override // m6b.g
    public final Draft Ea(String r2) {
        return this.b.Ea(r2);
    }

    @Override // m6b.g
    public final void M8(String r2, int r3) {
        this.b.M8(r2, r3);
    }

    @Override // m6b.g
    public final void Mb(String r2, String r3) {
        this.b.Mb(r2, BuildConfig.FLAVOR);
    }

    @Override // m6b.g
    public final Draft Na(String r2) {
        return this.b.Na(r2);
    }

    @Override // m6b.g
    public final Draft Pc(String r2) {
        return this.b.Pc(r2);
    }

    @Override // m6b.g
    public final void a8(String r2) {
        this.b.a8(r2);
    }

    @Override // m6b.g
    public final Draft b6(String r2) {
        return this.b.b6(r2);
    }

    @Override // m6b.g
    public final Draft b8(String r2) {
        return this.b.b8(r2);
    }

    @Override // m6b.g
    public final Executor getExecutor() {
        return this.b.getExecutor();
    }

    @Override // m6b.g
    public final void o5(b2.a r2, String r3, String r4, r.a r5) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        this.b.o5(r2, r3, r4, r5);
    }

    @Override // m6b.g
    public final Map<String, Draft> se(List<String> r2) {
        return this.b.se(r2);
    }

    @Override // m6b.g
    public final void tc(String r2, Draft r3, boolean r4, String r5) {
        this.b.tc(r2, r3, r4, r5);
    }

    @Override // m6b.g
    public final String x8(Chat r2, Draft r3, boolean r4) {
        return this.b.x8(r2, r3, r4);
    }

    public s(com.ss.android.lark.passportc.api.j r4, com.ss.android.lark.passportc.internal.v r5) {
        UserSession r1 = r4.b();
        if (r1 != null) goto L5;
        r1 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<m6b.g> r0 = new com.ss.android.lark.passportc.convention.b(e0c.k.b(r5.c(r1), m6b.g.class), m6b.g.class);
        Intrinsics.checkNotNullParameter(r4, "passport");
        Intrinsics.checkNotNullParameter(r5, "accessor");
        Intrinsics.checkNotNullParameter(r0, "instanceHolder");
        super(r4);
        this.b = (m6b.g) r0.b();
        this.c = r5;
        this.d = r0;
    }

    public final void qf(f0c.g r2, f0c.g r3) {
        Log.i("DraftServiceProxy", "preparing IDraftService");
        com.ss.android.lark.passportc.internal.v r4 = this.c;
        if (r3 == null) goto L6;
        UserSession r5 = r3.b;
        if (r5 == null) goto L6;
    L7:
        m6b.g r6 = (m6b.g) e0c.k.b(r4.c(r5), m6b.g.class);
        this.d.e(r6);
        return;
    L6:
        r5 = ContainerConstsKt.a();
        goto L7
    }
}
