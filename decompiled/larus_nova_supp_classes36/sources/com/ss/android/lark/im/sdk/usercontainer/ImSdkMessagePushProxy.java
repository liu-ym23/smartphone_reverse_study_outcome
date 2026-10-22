package com.ss.android.lark.im.sdk.usercontainer;

import com.ss.android.lark.biz.im.api.f1;
import com.ss.android.lark.biz.im.api.k0;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.service.impl.MessagePushV2;
import com.ss.android.lark.chat.service.impl.g0;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import f0c.g;
import kotlin.jvm.internal.Intrinsics;
import m6b.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ImSdkMessagePushProxy extends c0c.b implements u {
    public final /* synthetic */ u b;
    public final v c;
    public final com.ss.android.lark.passportc.convention.b<u> d;

    public static final class a {
    }

    static {
    }

    public final void I(MessageInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "preMessageInfo");
        this.b.I(r2);
    }

    public final void dispose() {
        this.b.dispose();
    }

    public final void K3(final g0 r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        this.d.a(new com.ss.android.lark.passportc.convention.b.b(g0.class, r6), new com.ss.android.lark.passportc.convention.b.c(new ImSdkMessagePushProxy$addPushPreMessageListener$1(r6), new ImSdkMessagePushProxy$addPushPreMessageListener$2(r6)));
    }

    public final void O3(k0 r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        this.d.d(new com.ss.android.lark.passportc.convention.b.b(k0.class, r4));
    }

    public final void gc(final k0 r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        this.d.a(new com.ss.android.lark.passportc.convention.b.b(k0.class, r6), new com.ss.android.lark.passportc.convention.b.c(new ImSdkMessagePushProxy$addPushMessageListener$1(r6), new ImSdkMessagePushProxy$addPushMessageListener$2(r6)));
    }

    public final void kd(g0 r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        this.d.d(new com.ss.android.lark.passportc.convention.b.b(g0.class, r4));
    }

    public final void mf(g r4) {
        Intrinsics.checkNotNullParameter(r4, "user");
        Log.i("ImSdkMessagePushProxy", "destroy user: " + r4.b.b);
        Intrinsics.checkNotNullParameter(r4, "user");
        ((u) this.d.c()).dispose();
    }

    public final void of(g r4) {
        Intrinsics.checkNotNullParameter(r4, "user");
        Log.i("ImSdkMessagePushProxy", "user onPrepared: " + r4.b.b);
        Intrinsics.checkNotNullParameter(r4, "user");
    }

    public ImSdkMessagePushProxy(j r4, v r5) {
        UserSession r1 = r4.b();
        if (r1 != null) goto L5;
        r1 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<u> r0 = new com.ss.android.lark.passportc.convention.b(k.b(r5.c(r1), u.class), u.class);
        Intrinsics.checkNotNullParameter(r4, "passport");
        Intrinsics.checkNotNullParameter(r5, "accessor");
        Intrinsics.checkNotNullParameter(r0, "instanceHolder");
        super(r4);
        this.b = (u) r0.b();
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
        Log.i("ImSdkMessagePushProxy", r0.toString());
        Object r10 = this.d.c();
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.ss.android.lark.chat.service.impl.MessagePushV2");
        MessagePushV2 r11 = (MessagePushV2) r10;
        if (Intrinsics.areEqual(r11.a, "absent_user") == false) goto L20;
        Log.w("ImSdkMessagePushProxy", "from user is ABSENT_USER, call release manually");
        r11.dispose();
    L20:
        v r12 = this.c;
        if (r5 == null) goto L24;
        UserSession r13 = r5.b;
        if (r13 == null) goto L24;
    L25:
        u r14 = (u) k.b(r12.c(r13), u.class);
        this.d.e(r14);
        return;
    L24:
        r13 = ContainerConstsKt.a();
    L8:
        r7 = "";
        goto L9
    }

    public final void Hd(String r2, Long r3, f1 r4) {
        Intrinsics.checkNotNullParameter(r2, "chatId");
        if (r4 != null) goto L5;
        return;
    L5:
        this.d.d(new com.ss.android.lark.passportc.convention.b.b(f1.class, r4));
    }

    public final void pb(final String r6, final Long r7, final f1 r8) {
        Intrinsics.checkNotNullParameter(r6, "chatId");
        if (r8 != null) goto L5;
        return;
    L5:
        this.d.a(new com.ss.android.lark.passportc.convention.b.b(f1.class, r8), new com.ss.android.lark.passportc.convention.b.c(new ImSdkMessagePushProxy$addPushAIRoundInfoListener$1(r6, r7, r8), new ImSdkMessagePushProxy$addPushAIRoundInfoListener$2(r6, r7, r8)));
    }
}
