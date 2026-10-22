package com.bytedance.android.live.room.discovery;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.Widget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class r0 implements View.OnTouchListener {
    public final /* synthetic */ TopLeftActivityBannerWidget a;
    public final /* synthetic */ String b;

    public r0(TopLeftActivityBannerWidget r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r3, MotionEvent r4) {
        TopLeftActivityBannerWidget r5 = this.a;
        String r0 = this.b;
        int r1 = TopLeftActivityBannerWidget.f;
        r5.wq(r0, "live_banner_click");
        if (r4.getAction() != 0) goto L7;
        UIUtils.setViewVisibility(((Widget) this.a).contentView.findViewById(2131367549), 8);
        return false;
    L7:
        return false;
    }
}
