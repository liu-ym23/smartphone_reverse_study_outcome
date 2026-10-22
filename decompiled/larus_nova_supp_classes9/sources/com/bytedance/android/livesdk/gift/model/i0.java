package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.bdlocation.BuildConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@IgnoreProtoFieldCheck
public final class i0 extends GiftMsgBoard {
    public i0() {
        this.promptText = BuildConfig.FLAVOR;
    }

    public i0(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L12;
        if (r2 != 1) goto L8;
        this.forMsgBoard = am3.h.a(r5);
        goto L3
    L8:
        if (r2 != 2) goto L9;
        this.promptText = am3.h.c(r5);
        goto L3
    L9:
        am3.h.e(r5);
        goto L3
    L12:
        r5.d(r0);
        if (this.promptText != null) goto L25;
        this.promptText = BuildConfig.FLAVOR;
        return;
    }
}
