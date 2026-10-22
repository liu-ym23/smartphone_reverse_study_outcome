package com.ss.android.lark.chat.service.impl;

import androidx.lifecycle.LiveData;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.entity.UserSession;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class i1 extends c0c.b implements m6b.j {
    public final /* synthetic */ m6b.j b;
    public final com.ss.android.lark.passportc.internal.v c;
    public final com.ss.android.lark.passportc.convention.b<m6b.j> d;

    public static final class a {
    }

    static {
    }

    @Override // m6b.j
    public final LiveData<MessageTenantConfService.c> getConfig() {
        return this.b.getConfig();
    }

    @Override // m6b.j
    public final void jd(boolean r2) {
        this.b.jd(r2);
    }

    public i1(com.ss.android.lark.passportc.api.j r4, com.ss.android.lark.passportc.internal.v r5) {
        UserSession r1 = r4.b();
        if (r1 != null) goto L5;
        r1 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<m6b.j> r0 = new com.ss.android.lark.passportc.convention.b(e0c.k.b(r5.c(r1), m6b.j.class), m6b.j.class);
        Intrinsics.checkNotNullParameter(r4, "passport");
        Intrinsics.checkNotNullParameter(r5, "accessor");
        Intrinsics.checkNotNullParameter(r0, "instanceHolder");
        super(r4);
        this.b = (m6b.j) r0.b();
        this.c = r5;
        this.d = r0;
    }

    public final void qf(f0c.g r2, f0c.g r3) {
        Log.i("MessageTenantConfServiceProxy", "preparing IMessageTenantConfService");
        com.ss.android.lark.passportc.internal.v r4 = this.c;
        if (r3 == null) goto L6;
        UserSession r5 = r3.b;
        if (r5 == null) goto L6;
    L7:
        m6b.j r6 = (m6b.j) e0c.k.b(r4.c(r5), m6b.j.class);
        this.d.e(r6);
        return;
    L6:
        r5 = ContainerConstsKt.a();
        goto L7
    }
}
