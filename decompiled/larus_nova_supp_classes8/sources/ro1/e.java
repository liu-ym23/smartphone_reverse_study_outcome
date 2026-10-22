package ro1;

import android.view.View;
import com.bytedance.android.live.browser.d0;
import com.bytedance.android.livesdk.chatroom.model.BannerInRoomCollection;
import com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.base.BaseBannerWidget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e extends d0 {
    public final /* synthetic */ BaseBannerWidget a;
    public final /* synthetic */ BannerInRoomCollection.BannerInfo b;

    public final void a() {
        this.a.Cq(this.b);
    }

    public final void g(View r4) {
        Intrinsics.checkNotNullParameter(r4, "lynxView");
        Intrinsics.checkNotNullParameter(r4, "lynxView");
        BaseBannerWidget r0 = this.a;
        BannerInRoomCollection.BannerInfo r1 = this.b;
        r0.Aq(r4, r1.lynxUrl, r1);
    }

    public e(BaseBannerWidget r1, BannerInRoomCollection.BannerInfo r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void f(View r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "lynxView");
        Intrinsics.checkNotNullParameter(r3, "lynxView");
        BaseBannerWidget r0 = this.a;
        r0.b = true;
        r0.Bq(r3, this.b.lynxUrl, r4);
    }
}
