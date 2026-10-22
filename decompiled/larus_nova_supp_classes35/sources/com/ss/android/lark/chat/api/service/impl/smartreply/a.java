package com.ss.android.lark.chat.api.service.impl.smartreply;

import a2b.j;
import c0c.b;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import f0c.g;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a extends b implements j {
    public final /* synthetic */ j b;
    public final v c;
    public final com.ss.android.lark.passportc.convention.b<j> d;

    /* JADX INFO: renamed from: com.ss.android.lark.chat.api.service.impl.smartreply.a$a, reason: collision with other inner class name */
    public static final class C0027a {
    }

    static {
    }

    @Override // a2b.j
    public final MessageInfo u3(MessageInfo r2, Function0<? extends j.a> r3) {
        Intrinsics.checkNotNullParameter(r2, "messageInfo");
        Intrinsics.checkNotNullParameter(r3, "getSmartApplyAnswerDependencyLoader");
        return this.b.u3(r2, r3);
    }

    public a(com.ss.android.lark.passportc.api.j r4, v r5) {
        UserSession r1 = r4.b();
        if (r1 != null) goto L5;
        r1 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<j> r0 = new com.ss.android.lark.passportc.convention.b(k.b(r5.c(r1), j.class), j.class);
        Intrinsics.checkNotNullParameter(r4, "passport");
        Intrinsics.checkNotNullParameter(r5, "accessor");
        Intrinsics.checkNotNullParameter(r0, "instanceHolder");
        super(r4);
        this.b = (j) r0.b();
        this.c = r5;
        this.d = r0;
    }

    public final void qf(g r2, g r3) {
        Log.i("SmartApplyAnswerCacheServiceProxy", "preparing ISmartApplyAnswerCacheServiceRepository");
        v r4 = this.c;
        if (r3 == null) goto L6;
        UserSession r5 = r3.b;
        if (r5 == null) goto L6;
    L7:
        j r6 = (j) k.b(r4.c(r5), j.class);
        this.d.e(r6);
        return;
    L6:
        r5 = ContainerConstsKt.a();
        goto L7
    }
}
