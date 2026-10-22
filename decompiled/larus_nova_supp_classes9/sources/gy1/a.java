package gy1;

import android.content.Context;
import com.bytedance.android.livesdk.gift.model.e0;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.platform.business.AbsBannerGiftPlugin;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends AbsBannerGiftPlugin {
    @Override // com.bytedance.android.livesdk.gift.platform.business.AbsBannerGiftPlugin
    public final boolean J(h1 r5) {
        Intrinsics.checkNotNullParameter(r5, "gift");
        String r0 = r5.getBannerScheme();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L20;
        e0 r2 = r5.getGiftBanner();
        if (r2 == null) goto L13;
        k r3 = r2.backgroundImage;
    L14:
        if (r3 == null) goto L20;
        if (r5.getType() == 11) goto L20;
        if (r5.getType() == 12) goto L20;
        return true;
    L13:
        r3 = null;
    L20:
        return false;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public a(DataCenter r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r2, r3);
    }
}
