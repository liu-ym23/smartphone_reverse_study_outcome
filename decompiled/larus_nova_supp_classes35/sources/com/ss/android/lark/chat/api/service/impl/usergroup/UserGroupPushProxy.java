package com.ss.android.lark.chat.api.service.impl.usergroup;

import a2b.n;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import e0c.k;
import f0c.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class UserGroupPushProxy extends c0c.b implements n {
    public final /* synthetic */ n b;
    public final v c;
    public final com.ss.android.lark.passportc.convention.b<n> d;

    public static final class a {
    }

    static {
    }

    @Override // a2b.n
    public final void C3(final com.ss.android.lark.biz.im.api.usergroup.a r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        this.d.a(new com.ss.android.lark.passportc.convention.b.b(com.ss.android.lark.biz.im.api.usergroup.a.class, r6), new com.ss.android.lark.passportc.convention.b.c(new UserGroupPushProxy$startPush$1(r6), new UserGroupPushProxy$startPush$2(r6)));
    }

    public final void mf(g r4) {
        Intrinsics.checkNotNullParameter(r4, "user");
        Log.i("UserGroupPushProxy", "destroy user: " + r4.b.b);
        Intrinsics.checkNotNullParameter(r4, "user");
        Object r5 = this.d.c();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.ss.android.lark.chat.api.service.impl.usergroup.UserGroupPush");
        ((UserGroupPush) r5).a.b();
    }

    public final void of(g r4) {
        Intrinsics.checkNotNullParameter(r4, "user");
        Log.i("UserGroupPushProxy", "user onPrepared: " + r4.b.b);
        Intrinsics.checkNotNullParameter(r4, "user");
    }

    @Override // a2b.n
    public final void vc(com.ss.android.lark.biz.im.api.usergroup.a r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        this.d.d(new com.ss.android.lark.passportc.convention.b.b(com.ss.android.lark.biz.im.api.usergroup.a.class, r4));
    }

    public UserGroupPushProxy(j r4, v r5) {
        UserSession r1 = r4.b();
        if (r1 != null) goto L5;
        r1 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<n> r0 = new com.ss.android.lark.passportc.convention.b(k.b(r5.c(r1), n.class), n.class);
        Intrinsics.checkNotNullParameter(r4, "passport");
        Intrinsics.checkNotNullParameter(r5, "accessor");
        Intrinsics.checkNotNullParameter(r0, "instanceHolder");
        super(r4);
        this.b = (n) r0.b();
        this.c = r5;
        this.d = r0;
    }

    public final void qf(g r4, g r5) {
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
        Log.i("UserGroupPushProxy", r0.toString());
        Object r10 = this.d.c();
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.ss.android.lark.chat.api.service.impl.usergroup.UserGroupPush");
        UserGroupPush r11 = (UserGroupPush) r10;
        b r2 = r11.a;
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.ss.android.lark.chat.api.service.impl.usergroup.UserGroupPushRepository");
        if (Intrinsics.areEqual(((UserGroupPushRepository) r2).a, "absent_user") == false) goto L20;
        Log.w("UserGroupPushProxy", "from user is ABSENT_USER, call release manually");
        r11.a.b();
    L20:
        v r12 = this.c;
        if (r5 == null) goto L24;
        UserSession r13 = r5.b;
        if (r13 == null) goto L24;
    L25:
        n r14 = (n) k.b(r12.c(r13), n.class);
        this.d.e(r14);
        return;
    L24:
        r13 = ContainerConstsKt.a();
    L8:
        r7 = BuildConfig.FLAVOR;
        goto L9
    }
}
