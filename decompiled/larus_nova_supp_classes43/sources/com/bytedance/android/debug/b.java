package com.bytedance.android.debug;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements com.bytedance.android.livesdk.gift.platform.business.effect.assets.f {
    public final /* synthetic */ com.bytedance.android.live.core.resources.f a;
    public final /* synthetic */ com.bytedance.android.livesdk.gift.platform.business.effect.assets.f b;

    public final void b(boolean r1) {
    }

    public final void a(long r10) {
        ALogger.i("LiveAnchorPushStreamMockManager", "downloadAssetByUrlNoCache#onCancel " + r10);
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.f r0 = this.b;
        if (r0 == null) goto L6;
        r0.a(r10);
        return;
    }

    public final void onFailed(Throwable r10) {
        Intrinsics.checkNotNullParameter(r10, "t");
        ALogger.i("GiftPreviewAutoTest", "downloadAssetByUrlNoCache#onFailed " + r10.getMessage());
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.f r0 = this.b;
        if (r0 == null) goto L6;
        r0.onFailed(r10);
        return;
    }

    public final void onProgress(int r10) {
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.f r0 = this.b;
        if (r0 == null) goto L6;
        r0.onProgress(r10);
        return;
    }

    public b(com.bytedance.android.live.core.resources.f r1, f r10) {
        this.a = r1;
        this.b = r10;
    }

    public final void c(long r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "path");
        ALogger.i("LiveAnchorPushStreamMockManager", "downloadAssetByUrlNoCache#onResult " + this.a);
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.f r0 = this.b;
        if (r0 == null) goto L5;
        r0.c(r10, r11);
    L5:
        String r12 = this.a.getMD5();
        if (r12 == null) goto L9;
        com.bytedance.android.livesdk.gift.platform.core.b.b(r12);
        return;
    }
}
