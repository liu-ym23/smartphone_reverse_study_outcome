package com.ss.android.lark.profile.core.di;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import f0c.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c extends c0c.b implements com.ss.android.lark.profile.core.di.a {
    public final /* synthetic */ com.ss.android.lark.profile.core.di.a b;
    public final v c;
    public final com.ss.android.lark.passportc.convention.b<com.ss.android.lark.profile.core.di.a> d;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.profile.core.di.a
    public final b38.b Q4() {
        return this.b.Q4();
    }

    public c(j r4, v r5) {
        UserSession r1 = r4.b();
        if (r1 != null) goto L5;
        r1 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<com.ss.android.lark.profile.core.di.a> r0 = new com.ss.android.lark.passportc.convention.b(k.b(r5.c(r1), com.ss.android.lark.profile.core.di.a.class), com.ss.android.lark.profile.core.di.a.class);
        Intrinsics.checkNotNullParameter(r4, "passport");
        Intrinsics.checkNotNullParameter(r5, "accessor");
        Intrinsics.checkNotNullParameter(r0, "instanceHolder");
        super(r4);
        this.b = r0.b();
        this.c = r5;
        this.d = r0;
    }

    @Override // c0c.b
    public final void qf(g r2, g r3) {
        Log.i("ProfileNetClientGetterProxy", "preparing");
        v r4 = this.c;
        if (r3 == null) goto L6;
        UserSession r5 = r3.b;
        if (r5 == null) goto L6;
    L7:
        com.ss.android.lark.profile.core.di.a r6 = (com.ss.android.lark.profile.core.di.a) k.b(r4.c(r5), com.ss.android.lark.profile.core.di.a.class);
        this.d.e(r6);
        return;
    L6:
        r5 = ContainerConstsKt.a();
        goto L7
    }
}
