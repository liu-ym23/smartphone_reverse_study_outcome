package com.bytedance.android.livesdk.interactivity.api.publicscreen.api;

import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a0 implements am3.c<FusionEmojiBanList> {
    public a0() {
    }

    public static FusionEmojiBanList a(am3.g r6) throws Exception {
        FusionEmojiBanList r0 = new FusionEmojiBanList();
        r0.banList = new ArrayList();
        long r1 = r6.c();
    L3:
        int r3 = r6.f();
        if (r3 == (-1)) goto L9;
        if (r3 != 1) goto L7;
        r0.banList.add(Long.valueOf(r6.j()));
        goto L3
    L7:
        am3.h.e(r6);
        goto L3
    L9:
        r6.d(r1);
        return r0;
    }

    public final Object decode(am3.g r1) throws Exception {
        return a(r1);
    }
}
