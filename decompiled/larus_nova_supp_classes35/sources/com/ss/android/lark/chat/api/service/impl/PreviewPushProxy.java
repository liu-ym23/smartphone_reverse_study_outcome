package com.ss.android.lark.chat.api.service.impl;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.entity.UserSession;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class PreviewPushProxy extends c0c.b implements a2b.c {
    public final /* synthetic */ a2b.c b;
    public final com.ss.android.lark.passportc.internal.v c;
    public final com.ss.android.lark.passportc.convention.b<a2b.c> d;

    public static final class a {
    }

    static {
    }

    @Override // a2b.c
    public final void N4(tya.a r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        this.d.d(new com.ss.android.lark.passportc.convention.b.b(tya.a.class, r4));
    }

    public final void mf(f0c.g r4) {
        Intrinsics.checkNotNullParameter(r4, "user");
        Log.i("PreviewPushProxy", "destroy user: " + r4.b.b);
        Intrinsics.checkNotNullParameter(r4, "user");
        Object r5 = this.d.c();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.ss.android.lark.chat.api.service.impl.PreviewPush");
        ((PreviewPush) r5).a.a();
    }

    public final void of(f0c.g r4) {
        Intrinsics.checkNotNullParameter(r4, "user");
        Log.i("PreviewPushProxy", "user onPrepared: " + r4.b.b);
        Intrinsics.checkNotNullParameter(r4, "user");
    }

    @Override // a2b.c
    public final void v9(final tya.a r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        this.d.a(new com.ss.android.lark.passportc.convention.b.b(tya.a.class, r6), new com.ss.android.lark.passportc.convention.b.c(new PreviewPushProxy$startPush$1(r6), new PreviewPushProxy$startPush$2(r6)));
    }

    public PreviewPushProxy(com.ss.android.lark.passportc.api.j r4, com.ss.android.lark.passportc.internal.v r5) {
        UserSession r1 = r4.b();
        if (r1 != null) goto L5;
        r1 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<a2b.c> r0 = new com.ss.android.lark.passportc.convention.b(e0c.k.b(r5.c(r1), a2b.c.class), a2b.c.class);
        Intrinsics.checkNotNullParameter(r4, "passport");
        Intrinsics.checkNotNullParameter(r5, "accessor");
        Intrinsics.checkNotNullParameter(r0, "instanceHolder");
        super(r4);
        this.b = (a2b.c) r0.b();
        this.c = r5;
        this.d = r0;
    }

    public final void qf(f0c.g r4, f0c.g r5) {
        StringBuilder r0 = new StringBuilder("preparing, fromUser: ");
        String r1 = BuildConfig.FLAVOR;
        if (r4 == null) goto L8;
        UserSession r6 = r4.b;
        if (r6 == null) goto L8;
        String r7 = r6.b;
        if (r7 == null) goto L8;
    L9:
        r0.append(r7);
        r0.append(", toUser: ");
        if (r5 == null) goto L17;
        UserSession r8 = r5.b;
        if (r8 == null) goto L17;
        String r9 = r8.b;
        if (r9 == null) goto L17;
        r1 = r9;
    L17:
        r0.append(r1);
        Log.i("PreviewPushProxy", r0.toString());
        Object r10 = this.d.c();
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.ss.android.lark.chat.api.service.impl.PreviewPush");
        PreviewPush r11 = (PreviewPush) r10;
        a2b.d r2 = r11.a;
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.ss.android.lark.chat.api.service.impl.PreviewPushRepositoryV2");
        if (Intrinsics.areEqual(((PreviewPushRepositoryV2) r2).a, "absent_user") == false) goto L20;
        Log.w("PreviewPushProxy", "from user is ABSENT_USER, call release manually");
        r11.a.a();
    L20:
        com.ss.android.lark.passportc.internal.v r12 = this.c;
        if (r5 == null) goto L24;
        UserSession r13 = r5.b;
        if (r13 == null) goto L24;
    L25:
        a2b.c r14 = (a2b.c) e0c.k.b(r12.c(r13), a2b.c.class);
        this.d.e(r14);
        return;
    L24:
        r13 = ContainerConstsKt.a();
    L8:
        r7 = BuildConfig.FLAVOR;
        goto L9
    }
}
