package com.ss.android.lark.chat.chatwindow.chat.v2.push;

import com.ss.android.lark.chat.entity.message.AIRecommendQuestions;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.entity.UserSession;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class p0 extends c0c.b implements z {
    public final /* synthetic */ z b;
    public final com.ss.android.lark.passportc.internal.v c;
    public final com.ss.android.lark.passportc.convention.b<z> d;

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.z
    public final AIRecommendQuestions kf(long r2) {
        return this.b.kf(r2);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.z
    public void update(long r2, AIRecommendQuestions r4) {
        Intrinsics.checkNotNullParameter(r4, "aIRecommendQuestions");
        this.b.update(r2, r4);
    }

    public p0(com.ss.android.lark.passportc.api.j r4, com.ss.android.lark.passportc.internal.v r5) {
        UserSession r1 = r4.b();
        if (r1 != null) goto L5;
        r1 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<z> r0 = new com.ss.android.lark.passportc.convention.b(e0c.k.b(r5.c(r1), z.class), z.class);
        Intrinsics.checkNotNullParameter(r4, "passport");
        Intrinsics.checkNotNullParameter(r5, "accessor");
        Intrinsics.checkNotNullParameter(r0, "holder");
        super(r4);
        this.b = (z) r0.b();
        this.c = r5;
        this.d = r0;
    }

    public final void qf(f0c.g r1, f0c.g r2) {
        com.ss.android.lark.passportc.internal.v r3 = this.c;
        if (r2 == null) goto L6;
        UserSession r4 = r2.b;
        if (r4 == null) goto L6;
    L7:
        z r5 = (z) e0c.k.b(r3.c(r4), z.class);
        this.d.e(r5);
        return;
    L6:
        r4 = ContainerConstsKt.a();
        goto L7
    }
}
