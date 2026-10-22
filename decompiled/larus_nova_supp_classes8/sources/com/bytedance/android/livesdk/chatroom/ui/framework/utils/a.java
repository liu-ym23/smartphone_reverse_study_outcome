package com.bytedance.android.livesdk.chatroom.ui.framework.utils;

import com.bytedance.android.live.livepullstream.api.apm.APMEvent;
import com.bytedance.android.livesdk.ability.AbilityCenter;
import com.bytedance.android.livesdk.utils.r2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements e {
    public final fo1.b a;

    public a(fo1.b r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.utils.e
    public final void report(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "eventName");
        com.bytedance.android.livesdk.room.b r0 = this.a.t;
        if (r0 == null) goto L7;
        AbilityCenter r1 = ((ls2.c) r0).b;
        if (r1 == null) goto L7;
        q81.b r2 = (q81.b) r1.getAbility(q81.b.class);
    L8:
        if (r2 == null) goto L15;
        APMEvent.Level r3 = APMEvent.Level.I;
        if (r2.a(r6) == false) goto L12;
        String r7 = "interaction->" + r5 + ": " + r6;
    L13:
        r2.ai(com.bytedance.android.live.livepullstream.api.apm.a.a(r3, r7));
        return;
    L12:
        r7 = "interaction->".concat(r5);
        goto L13
    L15:
        return;
    L7:
        r2 = null;
        goto L8
    }
}
