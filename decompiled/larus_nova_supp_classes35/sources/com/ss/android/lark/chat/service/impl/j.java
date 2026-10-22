package com.ss.android.lark.chat.service.impl;

import com.bytedance.lark.pb.im.v1.SubscribeChatEventRequest;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.entity.UserSession;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class j extends c0c.b implements m6b.d {
    public final /* synthetic */ m6b.d b;
    public final com.ss.android.lark.passportc.internal.v c;
    public final com.ss.android.lark.passportc.convention.b<m6b.d> d;

    public static final class a {
    }

    static {
    }

    @Override // m6b.d
    public final void K6(String r2, SubscribeChatEventRequest.SubscriptionKey r3) {
        this.b.K6(r2, r3);
    }

    @Override // m6b.d
    public final void V(Object r2, String r3) {
        this.b.V(r2, r3);
    }

    @Override // m6b.d
    public final void W1(Object r2, String r3, aqb.a r4) {
        this.b.W1(r2, r3, r4);
    }

    @Override // m6b.d
    public final void registerPushChatRelation(Object r2, String r3, SubscribeChatEventRequest.SubscriptionKey r4, m6b.o r5) {
        this.b.registerPushChatRelation(r2, r3, r4, r5);
    }

    @Override // m6b.d
    public final void unregisterPushChatRelation(Object r2, String r3, SubscribeChatEventRequest.SubscriptionKey r4) {
        this.b.unregisterPushChatRelation(r2, r3, r4);
    }

    @Override // m6b.d
    public final void z9(String r2, SubscribeChatEventRequest.SubscriptionKey r3) {
        this.b.z9(r2, r3);
    }

    public j(com.ss.android.lark.passportc.api.j r4, com.ss.android.lark.passportc.internal.v r5) {
        UserSession r1 = r4.b();
        if (r1 != null) goto L5;
        r1 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<m6b.d> r0 = new com.ss.android.lark.passportc.convention.b(e0c.k.b(r5.c(r1), m6b.d.class), m6b.d.class);
        Intrinsics.checkNotNullParameter(r4, "passport");
        Intrinsics.checkNotNullParameter(r5, "accessor");
        Intrinsics.checkNotNullParameter(r0, "instanceHolder");
        super(r4);
        this.b = (m6b.d) r0.b();
        this.c = r5;
        this.d = r0;
    }

    public final void qf(f0c.g r2, f0c.g r3) {
        Log.i("ChatSubscribeServiceProxy", "preparing IChatSubscribeService");
        com.ss.android.lark.passportc.internal.v r4 = this.c;
        if (r3 == null) goto L6;
        UserSession r5 = r3.b;
        if (r5 == null) goto L6;
    L7:
        m6b.d r6 = (m6b.d) e0c.k.b(r4.c(r5), m6b.d.class);
        this.d.e(r6);
        return;
    L6:
        r5 = ContainerConstsKt.a();
        goto L7
    }
}
