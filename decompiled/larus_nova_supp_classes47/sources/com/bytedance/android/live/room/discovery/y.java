package com.bytedance.android.live.room.discovery;

import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.Widget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class y implements rv2.d {
    public final /* synthetic */ LiveHashtagWidget a;

    public final void a() {
        UIUtils.setViewVisibility(((Widget) this.a).contentView, 0);
    }

    public final void b() {
        UIUtils.setViewVisibility(((Widget) this.a).contentView, 4);
    }

    public y(LiveHashtagWidget r1) {
        this.a = r1;
    }
}
