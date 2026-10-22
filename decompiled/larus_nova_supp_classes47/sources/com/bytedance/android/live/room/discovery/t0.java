package com.bytedance.android.live.room.discovery;

import android.view.View;
import com.bytedance.android.livesdk.gift.model.b1;
import com.bytedance.android.livesdkapi.banner.IBannerManager;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.Widget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class t0 implements View.OnClickListener {
    public final /* synthetic */ b1 a;
    public final /* synthetic */ TopLeftActivityBannerWidget b;

    public t0(b1 r1, TopLeftActivityBannerWidget r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        IBannerManager r4 = (IBannerManager) ((Widget) this.b).dataCenter.get("data_in_room_banner_manager", null);
        if (r4 == null) goto L5;
        r4.bannerClick(((Widget) this.b).context, this.a);
    L5:
        TopLeftActivityBannerWidget r5 = this.b;
        String r0 = String.valueOf(this.a.getId());
        int r1 = TopLeftActivityBannerWidget.f;
        r5.wq(r0, "live_banner_click");
        UIUtils.setViewVisibility(((Widget) this.b).contentView.findViewById(2131367549), 8);
    }
}
