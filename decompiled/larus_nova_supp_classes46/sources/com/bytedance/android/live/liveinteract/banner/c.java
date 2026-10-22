package com.bytedance.android.live.liveinteract.banner;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.ies.sdk.widgets.Widget;
import java.util.Arrays;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c extends ka0.a {
    public final /* synthetic */ BannerWidget c;

    public final void a(HybridCard r4, String r5) {
        StringCompanionObject r6 = StringCompanionObject.INSTANCE;
        ALogger.e("BannerWidget", String.format("initBannerView, onLoadFailed failed, bannerId: %s, errMsg: %s", Arrays.copyOf(new Object[]{Long.valueOf(this.c.f), r5}, 2)));
        ViewGroup r7 = ((Widget) this.c).containerView;
        if (r7 == null) goto L5;
        r7.setVisibility(8);
    L5:
        View r8 = this.c.g;
        if (r8 == null) goto L9;
        r8.setVisibility(8);
        return;
    }

    public final void b(HybridCard r3, View r4, int r5) {
        StringCompanionObject r6 = StringCompanionObject.INSTANCE;
        ALogger.i("BannerWidget", String.format("initBannerView, onViewCreated success, bannerId: %s", Arrays.copyOf(new Object[]{Long.valueOf(this.c.f)}, 1)));
        ViewGroup r7 = ((Widget) this.c).containerView;
        if (r7 == null) goto L5;
        r7.removeAllViews();
    L5:
        ViewGroup r8 = ((Widget) this.c).containerView;
        if (r8 == null) goto L8;
        r8.addView(r3);
    L8:
        ViewGroup r9 = ((Widget) this.c).containerView;
        if (r9 == null) goto L11;
        r9.setVisibility(0);
    L11:
        View r10 = this.c.g;
        if (r10 == null) goto L14;
        r10.setVisibility(0);
    L14:
        this.c.xq();
    }

    public c(BannerWidget r1, Context r2, Uri r3, int r4) {
        this.c = r1;
        super(r2, r3, r4);
    }
}
