package com.bytedance.android.livesdk.interactivity.api.entity;

import com.bytedance.android.live.base.model.message.x3;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class o {
    public static final void a(com.bytedance.android.livesdk.event.k r2, x3 r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "$this$createAndSetSelfSendInfo");
        Intrinsics.checkNotNullParameter(r3, "message");
        Intrinsics.checkNotNullParameter(r4, "content");
        com.bytedance.android.livesdk.event.m r0 = r2.b();
        if (r0 == null) goto L6;
        List r1 = r0.a;
        if (r1 == null) goto L6;
    L7:
        com.bytedance.android.livesdk.event.q r5 = r2.c();
        if (r5 == null) goto L11;
        List r6 = r5.a;
        if (r6 == null) goto L11;
    L13:
        if ((!r1.isEmpty()) == false) goto L15;
    L16:
        r3.setSelfFakeRichContent(new p(r4, r1, r6));
        return;
    L15:
        if ((!r6.isEmpty()) == true) goto L16;
        return;
    L11:
        r6 = new ArrayList();
    L6:
        r1 = new ArrayList();
        goto L7
    }
}
