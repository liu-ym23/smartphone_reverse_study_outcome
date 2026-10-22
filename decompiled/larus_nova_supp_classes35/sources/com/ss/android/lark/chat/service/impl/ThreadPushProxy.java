package com.ss.android.lark.chat.service.impl;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.entity.UserSession;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ThreadPushProxy extends c0c.b implements m6b.q {
    public final /* synthetic */ m6b.q b;
    public final com.ss.android.lark.passportc.internal.v c;
    public final com.ss.android.lark.passportc.convention.b<m6b.q> d;

    public static final class a {
    }

    static {
    }

    @Override // m6b.q
    public final void G1(final k2.b r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        this.d.a(new com.ss.android.lark.passportc.convention.b.b(k2.b.class, r6), new com.ss.android.lark.passportc.convention.b.c(new ThreadPushProxy$addPushThreadListener$1(r6), new ThreadPushProxy$addPushThreadListener$2(r6)));
    }

    @Override // m6b.q
    public final void Ia(k2.b r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        this.d.d(new com.ss.android.lark.passportc.convention.b.b(k2.b.class, r4));
    }

    @Override // m6b.q
    public final void be(k2.a r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        this.d.d(new com.ss.android.lark.passportc.convention.b.b(k2.a.class, r4));
    }

    @Override // m6b.q
    public final void je(final k2.a r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        this.d.a(new com.ss.android.lark.passportc.convention.b.b(k2.a.class, r6), new com.ss.android.lark.passportc.convention.b.c(new ThreadPushProxy$addPushMyThreadReplyPromptListener$1(r6), new ThreadPushProxy$addPushMyThreadReplyPromptListener$2(r6)));
    }

    public final void mf(f0c.g r4) {
        Intrinsics.checkNotNullParameter(r4, "user");
        Log.i("ThreadPushProxy", "destroy user: " + r4.b.b);
        Intrinsics.checkNotNullParameter(r4, "user");
        Object r5 = this.d.c();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.ss.android.lark.chat.service.impl.ThreadPush");
        k2 r6 = (k2) r5;
        r6.c.d();
        r6.c.a();
    }

    public final void of(f0c.g r4) {
        Intrinsics.checkNotNullParameter(r4, "user");
        Log.i("ThreadPushProxy", "user onPrepared: " + r4.b.b);
        Intrinsics.checkNotNullParameter(r4, "user");
    }

    public ThreadPushProxy(com.ss.android.lark.passportc.api.j r4, com.ss.android.lark.passportc.internal.v r5) {
        UserSession r1 = r4.b();
        if (r1 != null) goto L5;
        r1 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<m6b.q> r0 = new com.ss.android.lark.passportc.convention.b(e0c.k.b(r5.c(r1), m6b.q.class), m6b.q.class);
        Intrinsics.checkNotNullParameter(r4, "passport");
        Intrinsics.checkNotNullParameter(r5, "accessor");
        Intrinsics.checkNotNullParameter(r0, "instanceHolder");
        super(r4);
        this.b = (m6b.q) r0.b();
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
        Log.i("ThreadPushProxy", r0.toString());
        Object r10 = this.d.c();
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.ss.android.lark.chat.service.impl.ThreadPush");
        k2 r11 = (k2) r10;
        m6b.r r2 = r11.c;
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.ss.android.lark.chat.service.impl.ThreadPushRepositoryV2");
        if (Intrinsics.areEqual(((l2) r2).a, "absent_user") == false) goto L20;
        Log.w("ThreadPushProxy", "from user is ABSENT_USER, call release manually");
        r11.c.d();
        r11.c.a();
    L20:
        com.ss.android.lark.passportc.internal.v r12 = this.c;
        if (r5 == null) goto L24;
        UserSession r13 = r5.b;
        if (r13 == null) goto L24;
    L25:
        m6b.q r14 = (m6b.q) e0c.k.b(r12.c(r13), m6b.q.class);
        this.d.e(r14);
        return;
    L24:
        r13 = ContainerConstsKt.a();
    L8:
        r7 = BuildConfig.FLAVOR;
        goto L9
    }
}
