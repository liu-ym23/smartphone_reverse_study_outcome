package com.ss.android.lark.im.sdk.usercontainer;

import com.ss.android.lark.chat.entity.thread.TopicGroup;
import com.ss.android.lark.im.sdk.service.x;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import f0c.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d extends c0c.b implements x {
    public final /* synthetic */ x b;
    public final v c;
    public final com.ss.android.lark.passportc.convention.b<x> d;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.im.sdk.service.x
    public final TopicGroup fc(String r2) {
        return this.b.fc(r2);
    }

    public d(j r4, v r5) {
        UserSession r1 = r4.b();
        if (r1 != null) goto L5;
        r1 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<x> r0 = new com.ss.android.lark.passportc.convention.b(k.b(r5.c(r1), x.class), x.class);
        Intrinsics.checkNotNullParameter(r4, "passport");
        Intrinsics.checkNotNullParameter(r5, "accessor");
        Intrinsics.checkNotNullParameter(r0, "instanceHolder");
        super(r4);
        this.b = (x) r0.b();
        this.c = r5;
        this.d = r0;
    }

    public final void qf(g r2, g r3) {
        Log.i("ImSdkChatServiceProxy", "preparing ImSdkChatService");
        v r4 = this.c;
        if (r3 == null) goto L6;
        UserSession r5 = r3.b;
        if (r5 == null) goto L6;
    L7:
        x r6 = (x) k.b(r4.c(r5), x.class);
        this.d.e(r6);
        return;
    L6:
        r5 = ContainerConstsKt.a();
        goto L7
    }
}
