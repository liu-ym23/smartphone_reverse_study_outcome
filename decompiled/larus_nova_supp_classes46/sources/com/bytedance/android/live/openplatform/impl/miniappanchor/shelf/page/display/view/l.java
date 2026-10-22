package com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.view;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfMicroAppInfo;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.view.OpenPlatformTitleBar;
import com.bytedance.android.live.openplatform.impl.miniappanchor.applog.AnchorMiniAppAppLogContextService;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l<T> implements Observer {
    public final /* synthetic */ BaseAnchorShelfDisplayDialog a;

    public l(BaseAnchorShelfDisplayDialog r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        com.bytedance.android.live.openplatform.api.model.coupon.a r5 = (com.bytedance.android.live.openplatform.api.model.coupon.a) r4;
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.b() == false) goto L19;
        ((OpenPlatformTitleBar) this.a.T90(2131388807)).setSecondRightTvText(s1.B(2131921068));
        ((OpenPlatformTitleBar) this.a.T90(2131388807)).setSecondRightTvVisibility(true);
        OpenPlatformContext r6 = this.a.ca0().a();
        if (r6 == null) goto L16;
        AnchorMiniAppAppLogContextService r7 = (AnchorMiniAppAppLogContextService) r6.getService(AnchorMiniAppAppLogContextService.class);
        if (r7 == null) goto L16;
        ShelfMicroAppInfo r1 = (ShelfMicroAppInfo) this.a.W90().getShelfMicroAppInfo().getValue();
        if (r1 == null) goto L14;
        String r2 = r1.appId;
        if (r2 == null) goto L14;
    L15:
        r7.reportCouponEntranceShow(r2, "shelf_show_page");
    L14:
        r2 = "";
    L16:
        ((OpenPlatformTitleBar) this.a.T90(2131388807)).setOnSecondRightTvClickListener(new k(this));
        return;
    }
}
