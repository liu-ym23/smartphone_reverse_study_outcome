package com.ss.android.lark.passportc.internal;

import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.entity.UserSession;
import dagger.hilt.dwarf.lifecycle.LifecycleComponentManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class x extends LifecycleComponentManager<UserSession, e0c.l, f0> {
    public final b0 a;
    public final com.ss.android.lark.log.c b;

    public x(b0 r2, com.ss.android.lark.log.c r3) {
        Intrinsics.checkNotNullParameter(r2, "componentProviders");
        Intrinsics.checkNotNullParameter(r3, "logger");
        this.a = r2;
        this.b = r3;
    }

    public final Object createComponent(Object r3, Object r4) {
        UserSession r5 = (UserSession) r3;
        f0 r6 = (f0) r4;
        Intrinsics.checkNotNullParameter(r5, "key");
        Intrinsics.checkNotNullParameter(r6, "payload");
        e0c.l r7 = this.a.a().userSession(r5).a(r6).b(r6.getUser().userId).build();
        com.ss.android.lark.log.c r8 = this.b;
        StringBuilder r0 = new StringBuilder("createUserComponent, uid=");
        a r1 = a.a;
        r0.append(ContainerConstsKt.a().b);
        m0c.b.b(r8, r0.toString());
        return r7;
    }
}
