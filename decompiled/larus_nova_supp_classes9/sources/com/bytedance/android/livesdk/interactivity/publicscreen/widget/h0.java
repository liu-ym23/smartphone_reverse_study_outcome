package com.bytedance.android.livesdk.interactivity.publicscreen.widget;

import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.Widget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h0 implements rv2.d {
    public final /* synthetic */ TextMessageWidget a;

    public final void a() {
        UIUtils.setViewVisibility(((Widget) this.a).contentView, 0);
    }

    public final void b() {
        UIUtils.setViewVisibility(((Widget) this.a).contentView, 4);
    }

    public h0(TextMessageWidget r1) {
        this.a = r1;
    }
}
