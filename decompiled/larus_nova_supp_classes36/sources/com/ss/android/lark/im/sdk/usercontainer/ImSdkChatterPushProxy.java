package com.ss.android.lark.im.sdk.usercontainer;

import com.ss.android.lark.biz.im.api.h0;
import com.ss.android.lark.biz.im.api.i0;
import com.ss.android.lark.biz.im.api.l0;
import com.ss.android.lark.chat.service.impl.ImSdkChatterPushImplV2;
import com.ss.android.lark.chat.service.impl.w;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import f0c.g;
import kotlin.jvm.internal.Intrinsics;
import m6b.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ImSdkChatterPushProxy extends c0c.b implements t {
    public final /* synthetic */ t b;
    public final v c;
    public final com.ss.android.lark.passportc.convention.b<t> d;

    public static final class a {
    }

    static {
    }

    public final void A5(l0 r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        this.d.d(new com.ss.android.lark.passportc.convention.b.b(l0.class, r4));
    }

    public final void J1(final h0 r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        this.d.a(new com.ss.android.lark.passportc.convention.b.b(h0.class, r6), new com.ss.android.lark.passportc.convention.b.c(new ImSdkChatterPushProxy$addPushChatterListener$1(r6), new ImSdkChatterPushProxy$addPushChatterListener$2(r6)));
    }

    public final void h5(w r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        this.d.d(new com.ss.android.lark.passportc.convention.b.b(w.class, r4));
    }

    public final void la(final i0 r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        this.d.a(new com.ss.android.lark.passportc.convention.b.b(i0.class, r6), new com.ss.android.lark.passportc.convention.b.c(new ImSdkChatterPushProxy$addPushChattersListener$1(r6), new ImSdkChatterPushProxy$addPushChattersListener$2(r6)));
    }

    public final void mf(g r4) {
        Intrinsics.checkNotNullParameter(r4, "user");
        Log.i("ImSdkChatterPushProxy", "destroy user: " + r4.b.b);
        Intrinsics.checkNotNullParameter(r4, "user");
        Object r5 = this.d.c();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.ss.android.lark.chat.service.impl.ImSdkChatterPushImplV2");
        ImSdkChatterPushImplV2 r6 = (ImSdkChatterPushImplV2) r5;
        r6.getClass();
        Log.i("ImSdkChatterPushImplV2", "release for user " + r6.a);
        r6.c.dispose();
    }

    public final void of(g r4) {
        Intrinsics.checkNotNullParameter(r4, "user");
        Log.i("ImSdkChatterPushProxy", "user onPrepared: " + r4.b.b);
        Intrinsics.checkNotNullParameter(r4, "user");
    }

    public final void r8(final l0 r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        this.d.a(new com.ss.android.lark.passportc.convention.b.b(l0.class, r6), new com.ss.android.lark.passportc.convention.b.c(new ImSdkChatterPushProxy$addPushMineChatterChangedListener$1(r6), new ImSdkChatterPushProxy$addPushMineChatterChangedListener$2(r6)));
    }

    public final void te(h0 r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        this.d.d(new com.ss.android.lark.passportc.convention.b.b(h0.class, r4));
    }

    public final void w8(i0 r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        this.d.d(new com.ss.android.lark.passportc.convention.b.b(i0.class, r4));
    }

    public final void x5(final w r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        this.d.a(new com.ss.android.lark.passportc.convention.b.b(w.class, r6), new com.ss.android.lark.passportc.convention.b.c(new ImSdkChatterPushProxy$addPushChannelNicknameListener$1(r6), new ImSdkChatterPushProxy$addPushChannelNicknameListener$2(r6)));
    }

    public ImSdkChatterPushProxy(j r4, v r5) {
        UserSession r1 = r4.b();
        if (r1 != null) goto L5;
        r1 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<t> r0 = new com.ss.android.lark.passportc.convention.b(k.b(r5.c(r1), t.class), t.class);
        Intrinsics.checkNotNullParameter(r4, "passport");
        Intrinsics.checkNotNullParameter(r5, "accessor");
        Intrinsics.checkNotNullParameter(r0, "instanceHolder");
        super(r4);
        this.b = (t) r0.b();
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
        Log.i("ImSdkChatterPushProxy", r0.toString());
        Object r10 = this.d.c();
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.ss.android.lark.chat.service.impl.ImSdkChatterPushImplV2");
        ImSdkChatterPushImplV2 r11 = (ImSdkChatterPushImplV2) r10;
        if (Intrinsics.areEqual(r11.a, "absent_user") == false) goto L20;
        Log.w("ImSdkChatterPushProxy", "from user is ABSENT_USER, call release manually");
        Log.i("ImSdkChatterPushImplV2", "release for user " + r11.a);
        r11.c.dispose();
    L20:
        v r12 = this.c;
        if (r5 == null) goto L24;
        UserSession r13 = r5.b;
        if (r13 == null) goto L24;
    L25:
        this.d.e((t) k.b(r12.c(r13), t.class));
        return;
    L24:
        r13 = ContainerConstsKt.a();
    L8:
        r7 = "";
        goto L9
    }
}
