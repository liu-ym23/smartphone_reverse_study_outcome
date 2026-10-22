package com.bytedance.android.livesdk.gift.lynxbanner;

import android.content.Context;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.platform.business.AbsBannerGiftPlugin;
import com.bytedance.android.livesdk.gift.platform.business.dialog.topview.NewLynxGiftBannerView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.topview.a;
import com.bytedance.android.livesdk.gift.platform.business.dialog.topview.c;
import com.bytedance.android.livesdk.gift.platform.business.dialog.topview.i;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class LynxBannerGiftPlugin extends AbsBannerGiftPlugin {
    public static final /* synthetic */ int i = 0;

    @Override // com.bytedance.android.livesdk.gift.platform.business.AbsBannerGiftPlugin, com.bytedance.android.livesdk.gift.platform.business.l, com.bytedance.android.livesdk.gift.platform.business.h
    public final i<Boolean> E() {
        return new i(this.g, new LynxBannerGiftPlugin$provideTopViewController$1(this));
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.AbsBannerGiftPlugin
    public final boolean J(h1 r2) {
        Intrinsics.checkNotNullParameter(r2, "gift");
        String r3 = r2.getBannerScheme();
        if (r3 != null) goto L5;
    L8:
        boolean r4 = true;
    L10:
        return !r4;
    L5:
        if (r3.length() == 0) goto L8;
        r4 = false;
        goto L10
    }

    public LynxBannerGiftPlugin(DataCenter r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r2, r3);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.AbsBannerGiftPlugin
    public final a L(Context r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        if (r3 == null) goto L20;
        h1 r1 = this.e;
        if (r1 == null) goto L7;
        String r2 = r1.getBannerScheme();
    L8:
        if (r2 != null) goto L10;
    L13:
        boolean r5 = true;
    L14:
        if (r5 == true) goto L20;
        NewLynxGiftBannerView r6 = c.a;
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        if (c.a != null) goto L18;
        c.a = new NewLynxGiftBannerView(r3, r4);
    L18:
        NewLynxGiftBannerView r7 = c.a;
        Intrinsics.checkNotNull(r7);
        return r7;
    L10:
        if (r2.length() == 0) goto L13;
        r5 = false;
        goto L14
    L7:
        r2 = null;
    L20:
        return super.L(r3, r4);
    }
}
