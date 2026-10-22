package com.bytedance.android.livesdk.gift.platform.business.normal.utils;

import com.bytedance.android.live.profit.dress.config.h;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.livesdk.gift.model.o0;
import com.bytedance.android.livesdk.gift.model.w3;
import com.bytedance.android.livesdk.gift.platform.business.normal.model.NormalGiftMessage;
import com.bytedance.android.livesdk.message.model.o7;
import com.google.gson.Gson;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import l01.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c {
    static {
    }

    @JvmStatic
    public static final void a(NormalGiftMessage r3) {
        String r0 = null;
        if (r3 == null) goto L5;
        String r1 = r3.getFromUserId();
    L7:
        if (Intrinsics.areEqual(r1, f.a(d.class).getCurrentUserId()) == false) goto L9;
        return;
    L9:
        if (r3 == null) goto L36;
        o7 r2 = r3.r();
        if (r2 == null) goto L37;
        o0 r4 = r2.getTrayInfo();
        if (r4 == null) goto L38;
        w3 r5 = r4.getTrayPreEffect();
        if (r5 == null) goto L39;
        String r6 = r5.getExtra();
        if (r6 != null) goto L19;
        return;
    L19:
        if (r6.length() <= 0) goto L21;
        boolean r7 = true;
    L22:
        if (r7 == false) goto L24;
        r0 = r6;
    L24:
        if (r0 == null) goto L41;
        Gson r8 = com.bytedance.android.annie.api.data.subscribe.d.a;     // Catch: Exception -> L31
        h r9 = (h) com.bytedance.android.annie.api.data.subscribe.d.a(r0, h.class);     // Catch: Exception -> L31
        if (r9.getEnablePreview() == false) goto L42;
        com.bytedance.android.live.profit.player.d r10 = yt0.c.h();     // Catch: Exception -> L31
        if (r10 == null) goto L43;
        r10.no(new uu0.b.b(r9, r3));     // Catch: Exception -> L31
        return;
    L43:
        return;
    L42:
        return;
    L31:
        e = move-exception;
        e.printStackTrace();
        return;
    L41:
        return;
    L21:
        r7 = false;
        goto L22
    L39:
        return;
    L38:
        return;
    L37:
        return;
    L36:
        return;
    L5:
        r1 = null;
        goto L7
    }
}
