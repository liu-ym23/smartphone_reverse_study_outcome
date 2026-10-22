package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.list;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.list.banner.BannerAdapter;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements BannerAdapter.a {
    public final /* synthetic */ MiniAppChooseListFragment a;

    public c(MiniAppChooseListFragment r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.list.banner.BannerAdapter.a
    public final void a(com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.a r7) {
        Intrinsics.checkNotNullParameter(r7, "item");
        if (r7.type != 1) goto L13;
        lp0.a r0 = this.a.g;
        if (r0 == null) goto L13;
        Context r1 = r0.getContext();
        if (r1 == null) goto L13;
        int r2 = np0.d.a;
        String r8 = r7.schema;
        if (r8 != null) goto L11;
        r8 = "";
    L11:
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r8, "url");
        String r3 = jc1.k.n(IHostContext.class).getVersionName();
        ILiveActionHandler r4 = jc1.k.n(IRoomService.class).actionHandler();
        StringBuilder r5 = new StringBuilder("sslocal://webcast_webview?hide_nav_bar=1&trans_status_bar=1&status_bar_color=black&web_bg_color=%23ffffffff&url=");
        r5.append(Uri.encode(r8 + "?app_version=" + r3 + "&status_bar_height=" + s1.G(s1.A())));
        r4.handle(r1, r5.toString());
    L13:
        if (lp0.b.a(this.a.g) == null) goto L24;
        boolean r9 = lp0.b.d(this.a.g);
        com.bytedance.android.livesdk.log.g r6 = u.l();
        Pair[] r10 = new Pair[2];
        r10[0] = TuplesKt.to("_param_for_special", "micro_app");
        if (r9 == false) goto L17;
        String r11 = "in_live";
    L18:
        r10[1] = TuplesKt.to("live_status", r11);
        Map r12 = MapsKt.mutableMapOf(r10);
        Object[] r13 = new Object[1];
        if (r9 == false) goto L21;
        Class<Room> r14 = Room.class;
    L22:
        r13[0] = r14;
        r6.e("mp_live_bind_landing_page_banner_click", r12, r13);
        return;
    L21:
        r14 = null;
        goto L22
    L17:
        r11 = "before_live";
        goto L18
    }
}
