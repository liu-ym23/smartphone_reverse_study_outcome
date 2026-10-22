package com.bytedance.android.livesdk.interactivity.seek.v2;

import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c<T> implements h80.d {
    public final /* synthetic */ b a;

    public c(b r1) {
        this.a = r1;
    }

    public final Object get() {
        b r0 = this.a;
        if (r0.v == false) goto L6;
        long r1 = com.bytedance.android.livesdk.interactivity.common.utils.f.b(r0.r);
        long r2 = IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW;
        long r3 = (r1 / r2) * r2;
        return String.valueOf(r3) + "_" + (r3 + r2);
    L6:
        return r0.i;
    }
}
