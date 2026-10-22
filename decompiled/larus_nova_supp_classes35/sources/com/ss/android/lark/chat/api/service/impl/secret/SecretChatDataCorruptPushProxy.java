package com.ss.android.lark.chat.api.service.impl.secret;

import a2b.i;
import c0c.b;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import f0c.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class SecretChatDataCorruptPushProxy extends b implements i {
    public final /* synthetic */ i b;
    public final v c;
    public final com.ss.android.lark.passportc.convention.b<i> d;

    public static final class a {
    }

    static {
    }

    @Override // a2b.i
    public final void dispose() {
        this.b.dispose();
    }

    public final void lf(f0c.b r2) {
        Intrinsics.checkNotNullParameter(r2, "toState");
        Intrinsics.checkNotNullParameter(r2, "toState");
        ((i) this.d.c()).dispose();
    }

    @Override // a2b.i
    public final void u1(i.a r4) {
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.d.d(new com.ss.android.lark.passportc.convention.b.b(i.a.class, r4));
    }

    @Override // a2b.i
    public final void yc(final i.a r6) {
        Intrinsics.checkNotNullParameter(r6, "listener");
        this.d.a(new com.ss.android.lark.passportc.convention.b.b(i.a.class, r6), new com.ss.android.lark.passportc.convention.b.c(new SecretChatDataCorruptPushProxy$addListener$1(r6), new SecretChatDataCorruptPushProxy$addListener$2(r6)));
    }

    public SecretChatDataCorruptPushProxy(j r4, v r5) {
        UserSession r1 = r4.b();
        if (r1 != null) goto L5;
        r1 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<i> r0 = new com.ss.android.lark.passportc.convention.b(k.b(r5.c(r1), i.class), i.class);
        Intrinsics.checkNotNullParameter(r4, "passport");
        Intrinsics.checkNotNullParameter(r5, "accessor");
        Intrinsics.checkNotNullParameter(r0, "instanceHolder");
        super(r4);
        this.b = (i) r0.b();
        this.c = r5;
        this.d = r0;
    }

    public final void pf(g r3, f0c.b r4) {
        Intrinsics.checkNotNullParameter(r4, "toState");
        Intrinsics.checkNotNullParameter(r4, "toState");
        Object r5 = this.d.c();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.ss.android.lark.chat.api.service.impl.secret.SecretChatDataCorruptPush");
        SecretChatDataCorruptPush r6 = (SecretChatDataCorruptPush) r5;
        if (Intrinsics.areEqual(r6.a, "absent_user") == false) goto L5;
        Log.w("SChatDataCorruptPush", "from user is ABSENT_USER, call release manually");
        r6.dispose();
    L5:
        v r7 = this.c;
        g r8 = r4.a();
        if (r8 == null) goto L9;
        UserSession r9 = r8.b;
        if (r9 == null) goto L9;
    L10:
        SecretChatDataCorruptPush r10 = (SecretChatDataCorruptPush) k.b(r7.c(r9), SecretChatDataCorruptPush.class);
        this.d.e(r10);
        return;
    L9:
        r9 = ContainerConstsKt.a();
        goto L10
    }
}
