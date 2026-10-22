package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.list;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ MiniAppChooseListFragment a;

    public d(MiniAppChooseListFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        lp0.a r6 = this.a.g;
        if (r6 == null) goto L10;
        Context r7 = r6.getContext();
        if (r7 == null) goto L11;
        ((IOpenPlatformAnchorService) jc1.k.n(IOpenPlatformAnchorService.class)).openCouponPage(r7, 3, null);
        if (lp0.b.a(this.a.g) == null) goto L12;
        u.l().e("mp_add_coupon_icon_click", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("_param_for_special", "micro_app")}), new Object[]{Room.class});
        return;
    L12:
        return;
    L11:
        return;
    }
}
