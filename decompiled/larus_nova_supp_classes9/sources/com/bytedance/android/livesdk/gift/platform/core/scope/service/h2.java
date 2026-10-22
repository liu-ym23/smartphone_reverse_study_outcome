package com.bytedance.android.livesdk.gift.platform.core.scope.service;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h2 implements m97.b {
    public final /* synthetic */ GiftResourceFileCacheService a;

    public h2(GiftResourceFileCacheService r1) {
        this.a = r1;
    }

    public final void onEvent(int r3, String r4) {
        int r5 = r3 & 4095;
        if (r5 != 512) goto L14;
        if (r4 != null) goto L6;
    L9:
        boolean r1 = true;
    L10:
        if (r1 == true) goto L15;
        if (r5 != 512) goto L16;
        this.a.c.remove(r4);
        return;
    L16:
        return;
    L15:
        return;
    L6:
        if (r4.length() == 0) goto L9;
        r1 = false;
        goto L10
    }
}
