package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.list;

import android.view.View;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import kotlin.Pair;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ MiniAppChooseListFragment a;

    public g(MiniAppChooseListFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        mp0.a r8 = lp0.b.a(this.a.g);
        if (r8 != null) goto L5;
    L8:
        lp0.a r9 = this.a.g;
        if (r9 == null) goto L14;
        com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.b r10 = r9.getContainer();
        if (r10 == null) goto L15;
        r10.Cx();
        return;
    L15:
        return;
    L14:
        return;
    L5:
        if (lp0.b.d(r8.d) == false) goto L7;
        u.l().sendLog("livesdk_live_function_panel_search_click", MapsKt.mutableMapOf(new Pair[]{new Pair("entrance_type", "search_bar")}), new Object[]{Room.class});
        goto L8
    L7:
        u.l().sendLog("livesdk_live_takepage_function_panel_search_click", MapsKt.mutableMapOf(new Pair[]{new Pair("entrance_type", "search_bar")}), new Object[0]);
        goto L8
    }
}
