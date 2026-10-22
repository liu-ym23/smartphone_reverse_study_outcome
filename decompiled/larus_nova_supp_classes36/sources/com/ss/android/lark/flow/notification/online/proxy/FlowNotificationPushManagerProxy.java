package com.ss.android.lark.flow.notification.online.proxy;

import c0c.b;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import f0c.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowNotificationPushManagerProxy extends b implements zsb.a {
    public final /* synthetic */ zsb.a b;
    public final v c;
    public final com.ss.android.lark.passportc.convention.b<zsb.a> d;

    public static final class a {
    }

    static {
    }

    public final void mf(g r3) {
        Intrinsics.checkNotNullParameter(r3, "user");
        Intrinsics.checkNotNullParameter(r3, "user");
        thb.a.b("FlowNotificationPushManagerProxy", "destroy, sessionKey = " + r3.b.a);
    }

    @Override // zsb.a
    public final void n9(ctb.a r4) {
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.d.d(new com.ss.android.lark.passportc.convention.b.b(ctb.a.class, r4));
    }

    public final void of(g r3) {
        Intrinsics.checkNotNullParameter(r3, "user");
        Intrinsics.checkNotNullParameter(r3, "user");
        thb.a.b("FlowNotificationPushManagerProxy", "onPrepared, sessionKey = " + r3.b.a);
    }

    @Override // zsb.a
    public final void t4(final ctb.a r6) {
        Intrinsics.checkNotNullParameter(r6, "listener");
        this.d.a(new com.ss.android.lark.passportc.convention.b.b(ctb.a.class, r6), new com.ss.android.lark.passportc.convention.b.c(new FlowNotificationPushManagerProxy$addPushNotificationListener$1(r6), new FlowNotificationPushManagerProxy$addPushNotificationListener$2(r6)));
    }

    public FlowNotificationPushManagerProxy(j r4, v r5) {
        UserSession r1 = r4.b();
        if (r1 != null) goto L5;
        r1 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<zsb.a> r0 = new com.ss.android.lark.passportc.convention.b(k.b(r5.c(r1), zsb.a.class), zsb.a.class);
        Intrinsics.checkNotNullParameter(r4, "passport");
        Intrinsics.checkNotNullParameter(r5, "accessor");
        Intrinsics.checkNotNullParameter(r0, "proxy");
        super(r4);
        this.b = (zsb.a) r0.b();
        this.c = r5;
        this.d = r0;
    }

    public final void qf(g r2, g r3) {
        v r4 = this.c;
        if (r3 == null) goto L6;
        UserSession r5 = r3.b;
        if (r5 == null) goto L6;
    L7:
        zsb.a r6 = (zsb.a) k.b(r4.c(r5), zsb.a.class);
        this.d.e(r6);
        thb.a.b("FlowNotificationPushManagerProxy", "preparing, updateInstance hashCode: " + r6.hashCode());
        return;
    L6:
        r5 = ContainerConstsKt.a();
        goto L7
    }
}
