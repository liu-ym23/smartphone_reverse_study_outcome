package com.ss.android.lark.chat.api.service.impl;

import com.ss.android.lark.chat.api.service.PrivateDescriptionSource;
import com.ss.android.lark.chat.api.service.Strategy;
import com.ss.android.lark.chat.entity.chatter.UserPrivateDescription;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.entity.UserSession;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g1 extends c0c.b implements a2b.h {
    public final /* synthetic */ a2b.h b;
    public final com.ss.android.lark.passportc.internal.v c;
    public final com.ss.android.lark.passportc.convention.b<a2b.h> d;

    public static final class a {
    }

    static {
    }

    @Override // a2b.h
    public final Object S0(List<String> r2, PrivateDescriptionSource r3, Strategy r4, Continuation<? super Result<? extends Map<String, UserPrivateDescription>>> r5) {
        Object r6 = this.b.S0(r2, r3, r4, r5);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return r6;
    }

    public g1(com.ss.android.lark.passportc.api.j r4, com.ss.android.lark.passportc.internal.v r5) {
        UserSession r1 = r4.b();
        if (r1 != null) goto L5;
        r1 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<a2b.h> r0 = new com.ss.android.lark.passportc.convention.b(e0c.k.b(r5.c(r1), a2b.h.class), a2b.h.class);
        Intrinsics.checkNotNullParameter(r4, "passport");
        Intrinsics.checkNotNullParameter(r5, "accessor");
        Intrinsics.checkNotNullParameter(r0, "instanceHolder");
        super(r4);
        this.b = (a2b.h) r0.b();
        this.c = r5;
        this.d = r0;
    }

    public final void qf(f0c.g r2, f0c.g r3) {
        Log.i("PrivateDescriptionServiceProxy", "preparing IPrivateDescriptionService");
        com.ss.android.lark.passportc.internal.v r4 = this.c;
        if (r3 == null) goto L6;
        UserSession r5 = r3.b;
        if (r5 == null) goto L6;
    L7:
        a2b.h r6 = (a2b.h) e0c.k.b(r4.c(r5), a2b.h.class);
        this.d.e(r6);
        return;
    L6:
        r5 = ContainerConstsKt.a();
        goto L7
    }
}
