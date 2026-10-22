package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new;

import android.net.Uri;
import com.bytedance.android.live.revenue.core.util.f;
import kotlin.jvm.internal.Intrinsics;
import vy0.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l implements k<Uri> {
    public Uri a;

    public l() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.k
    public final void clear() {
        this.a = null;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.k
    public final GiftPreloadResType a() {
        return GiftPreloadResType.ICON_ANIMATOR_URI;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.k
    public final void b(h r2) {
        Intrinsics.checkNotNullParameter(r2, "trigger");
        this.a = f.a(c.class).Q("/gift/ttlive_gift_icon_rare_effect.webp");
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.k
    public final boolean c(h r2) {
        Intrinsics.checkNotNullParameter(r2, "trigger");
        if ((r2 instanceof h.f) == false) goto L6;
        return false;
    L6:
        if (this.a != null) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.k
    public final Uri d(f r2) {
        Intrinsics.checkNotNullParameter(r2, "cacheKey");
        return this.a;
    }
}
