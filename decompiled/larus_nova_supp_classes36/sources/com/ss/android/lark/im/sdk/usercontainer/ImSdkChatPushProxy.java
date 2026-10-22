package com.ss.android.lark.im.sdk.usercontainer;

import aqb.e;
import aqb.f;
import com.ss.android.lark.chat.service.impl.ImSdkChatPushImplV2;
import com.ss.android.lark.chat.service.impl.a0;
import com.ss.android.lark.chat.service.impl.b0;
import com.ss.android.lark.chat.service.impl.e0;
import com.ss.android.lark.chat.service.impl.f0;
import com.ss.android.lark.chat.service.impl.h;
import com.ss.android.lark.chat.service.impl.x;
import com.ss.android.lark.chat.service.impl.y;
import com.ss.android.lark.chat.service.impl.z;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import f0c.g;
import kotlin.jvm.internal.Intrinsics;
import m6b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ImSdkChatPushProxy extends c0c.b implements s {
    public final /* synthetic */ s b;
    public final v c;
    public final com.ss.android.lark.passportc.convention.b<s> d;

    public static final class a {
    }

    static {
    }

    public final void Nd(h.f r2) {
        this.b.Nd(r2);
    }

    public final void V2(h.g r2) {
        this.b.V2(r2);
    }

    public final void W6(h.g r2) {
        this.b.W6(r2);
    }

    public final void k5(h.f r2) {
        this.b.k5(r2);
    }

    public final void Cc(x r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        this.d.d(new com.ss.android.lark.passportc.convention.b.b(x.class, r4));
    }

    public final void Ce(final f0 r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        this.d.a(new com.ss.android.lark.passportc.convention.b.b(f0.class, r6), new com.ss.android.lark.passportc.convention.b.c(new ImSdkChatPushProxy$addPushPreUpdateChatListener$1(r6), new ImSdkChatPushProxy$addPushPreUpdateChatListener$2(r6)));
    }

    public final void Gb(a0 r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        this.d.d(new com.ss.android.lark.passportc.convention.b.b(a0.class, r4));
    }

    public final void Ge(final b0 r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        this.d.a(new com.ss.android.lark.passportc.convention.b.b(b0.class, r6), new com.ss.android.lark.passportc.convention.b.c(new ImSdkChatPushProxy$addPushDepartmentListener$1(r6), new ImSdkChatPushProxy$addPushDepartmentListener$2(r6)));
    }

    public final void Hc(b0 r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        this.d.d(new com.ss.android.lark.passportc.convention.b.b(b0.class, r4));
    }

    public final void O1(final x r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        this.d.a(new com.ss.android.lark.passportc.convention.b.b(x.class, r6), new com.ss.android.lark.passportc.convention.b.c(new ImSdkChatPushProxy$addPushChatAddUsersListener$1(r6), new ImSdkChatPushProxy$addPushChatAddUsersListener$2(r6)));
    }

    public final void O5(y r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        this.d.d(new com.ss.android.lark.passportc.convention.b.b(e0.class, r4));
    }

    public final void Qa(final z r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        this.d.a(new com.ss.android.lark.passportc.convention.b.b(z.class, r6), new com.ss.android.lark.passportc.convention.b.c(new ImSdkChatPushProxy$addPushChatRemoveUsersListener$1(r6), new ImSdkChatPushProxy$addPushChatRemoveUsersListener$2(r6)));
    }

    public final void Se(f r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        this.d.d(new com.ss.android.lark.passportc.convention.b.b(f.class, r4));
    }

    public final void Z4(z r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        this.d.d(new com.ss.android.lark.passportc.convention.b.b(z.class, r4));
    }

    public final void b3(y r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        this.d.d(new com.ss.android.lark.passportc.convention.b.b(y.class, r4));
    }

    public final void c1(final y r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        this.d.a(new com.ss.android.lark.passportc.convention.b.b(e0.class, r6), new com.ss.android.lark.passportc.convention.b.c(new ImSdkChatPushProxy$addPushOfflineChatListener$1(r6), new ImSdkChatPushProxy$addPushOfflineChatListener$2(r6)));
    }

    public final void d1(e r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        this.d.d(new com.ss.android.lark.passportc.convention.b.b(e.class, r4));
    }

    public final void f8(final e r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        this.d.a(new com.ss.android.lark.passportc.convention.b.b(e.class, r6), new com.ss.android.lark.passportc.convention.b.c(new ImSdkChatPushProxy$addPushChatTimeTipNotifyListener$1(r6), new ImSdkChatPushProxy$addPushChatTimeTipNotifyListener$2(r6)));
    }

    public final void gd(final f r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        this.d.a(new com.ss.android.lark.passportc.convention.b.b(f.class, r6), new com.ss.android.lark.passportc.convention.b.c(new ImSdkChatPushProxy$addPushPinReadStateListener$1(r6), new ImSdkChatPushProxy$addPushPinReadStateListener$2(r6)));
    }

    public final void ha(final a0 r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        this.d.a(new com.ss.android.lark.passportc.convention.b.b(a0.class, r6), new com.ss.android.lark.passportc.convention.b.c(new ImSdkChatPushProxy$addPushChatUpdateUsersListener$1(r6), new ImSdkChatPushProxy$addPushChatUpdateUsersListener$2(r6)));
    }

    public final void ke(final y r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        this.d.a(new com.ss.android.lark.passportc.convention.b.b(y.class, r6), new com.ss.android.lark.passportc.convention.b.c(new ImSdkChatPushProxy$addPushChatListener$1(r6), new ImSdkChatPushProxy$addPushChatListener$2(r6)));
    }

    public final void mf(g r4) {
        Intrinsics.checkNotNullParameter(r4, "user");
        Log.i("ImSdkChatPushProxy", "destroy user: " + r4.b.b);
        Intrinsics.checkNotNullParameter(r4, "user");
        Object r5 = this.d.c();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.ss.android.lark.chat.service.impl.ImSdkChatPushImplV2");
        ImSdkChatPushImplV2 r6 = (ImSdkChatPushImplV2) r5;
        r6.getClass();
        Log.i("ImSdkChatPushImplV2", "release for user " + r6.a);
        r6.c.dispose();
    }

    public final void of(g r4) {
        Intrinsics.checkNotNullParameter(r4, "user");
        Log.i("ImSdkChatPushProxy", "user onPrepared: " + r4.b.b);
        Intrinsics.checkNotNullParameter(r4, "user");
    }

    public final void vd(f0 r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        this.d.d(new com.ss.android.lark.passportc.convention.b.b(f0.class, r4));
    }

    public ImSdkChatPushProxy(j r4, v r5) {
        UserSession r1 = r4.b();
        if (r1 != null) goto L5;
        r1 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<s> r0 = new com.ss.android.lark.passportc.convention.b(k.b(r5.c(r1), s.class), s.class);
        Intrinsics.checkNotNullParameter(r4, "passport");
        Intrinsics.checkNotNullParameter(r5, "accessor");
        Intrinsics.checkNotNullParameter(r0, "instanceHolder");
        super(r4);
        this.b = (s) r0.b();
        this.c = r5;
        this.d = r0;
    }

    public final void qf(g r4, g r5) {
        StringBuilder r0 = new StringBuilder("preparing, fromUser: ");
        String r1 = "";
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
        Log.i("ImSdkChatPushProxy", r0.toString());
        Object r10 = this.d.c();
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.ss.android.lark.chat.service.impl.ImSdkChatPushImplV2");
        ImSdkChatPushImplV2 r11 = (ImSdkChatPushImplV2) r10;
        if (Intrinsics.areEqual(r11.a, "absent_user") == false) goto L20;
        Log.w("ImSdkChatPushProxy", "from user is ABSENT_USER, call release manually");
        Log.i("ImSdkChatPushImplV2", "release for user " + r11.a);
        r11.c.dispose();
    L20:
        v r12 = this.c;
        if (r5 == null) goto L24;
        UserSession r13 = r5.b;
        if (r13 == null) goto L24;
    L25:
        this.d.e((s) k.b(r12.c(r13), s.class));
        return;
    L24:
        r13 = ContainerConstsKt.a();
    L8:
        r7 = "";
        goto L9
    }
}
