package com.bytedance.android.livesdk.chatroom.viewmodule;

import com.bytedance.ies.sdk.widgets.Widget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class z2 implements com.bytedance.ies.web.jsbridge2.f.b {
    public final /* synthetic */ TopRightBannerWidget a;

    public z2(TopRightBannerWidget r1) {
        this.a = r1;
    }

    public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
        return new wo1.c(((Widget) this.a).contentView, "长触");
    }
}
