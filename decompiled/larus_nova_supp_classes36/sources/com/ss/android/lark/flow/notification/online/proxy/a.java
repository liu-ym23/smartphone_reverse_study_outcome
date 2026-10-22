package com.ss.android.lark.flow.notification.online.proxy;

import c0c.b;
import com.ss.android.lark.notification.export.entity.CurrentProcess;
import com.ss.android.lark.notification.export.entity.Notice;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import f0c.g;
import kotlin.jvm.internal.Intrinsics;
import zsb.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends b implements c {
    public final /* synthetic */ c b;
    public final v c;
    public final com.ss.android.lark.passportc.convention.b<c> d;

    /* JADX INFO: renamed from: com.ss.android.lark.flow.notification.online.proxy.a$a, reason: collision with other inner class name */
    public static final class C0054a {
    }

    static {
    }

    public final void mf(g r3) {
        Intrinsics.checkNotNullParameter(r3, "user");
        Intrinsics.checkNotNullParameter(r3, "user");
        thb.a.b("NotificationPushManagerProxy", "destroy, sessionKey = " + r3.b.a);
    }

    public final void of(g r3) {
        Intrinsics.checkNotNullParameter(r3, "user");
        Intrinsics.checkNotNullParameter(r3, "user");
        thb.a.b("NotificationPushManagerProxy", "onPrepared, sessionKey = " + r3.b.a);
    }

    public a(j r4, v r5) {
        UserSession r1 = r4.b();
        if (r1 != null) goto L5;
        r1 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<c> r0 = new com.ss.android.lark.passportc.convention.b(k.b(r5.c(r1), c.class), c.class);
        Intrinsics.checkNotNullParameter(r4, "passport");
        Intrinsics.checkNotNullParameter(r5, "accessor");
        Intrinsics.checkNotNullParameter(r0, "proxy");
        super(r4);
        this.b = (c) r0.b();
        this.c = r5;
        this.d = r0;
    }

    @Override // zsb.c
    public final void R2(Notice r2, CurrentProcess r3) {
        ((c) this.d.b()).R2(r2, r3);
    }

    public final void qf(g r2, g r3) {
        v r4 = this.c;
        if (r3 == null) goto L6;
        UserSession r5 = r3.b;
        if (r5 == null) goto L6;
    L7:
        c r6 = (c) k.b(r4.c(r5), c.class);
        this.d.e(r6);
        thb.a.b("NotificationPushManagerProxy", "preparing, updateInstance hashCode: " + r6.hashCode());
        return;
    L6:
        r5 = ContainerConstsKt.a();
        goto L7
    }
}
