package ro1;

import com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.base.BaseBannerWidget;
import com.bytedance.ies.sdk.widgets.Widget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d implements com.bytedance.ies.web.jsbridge2.f.b {
    public final /* synthetic */ BaseBannerWidget a;

    public d(BaseBannerWidget r1) {
        this.a = r1;
    }

    public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
        return new wo1.c(((Widget) this.a).contentView, "活动入口");
    }
}
