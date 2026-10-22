package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live.v3;

import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.adapter.v3.OpenFeatureTabPageAdapterV3;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.tab.TabSelectorView;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements TabSelectorView.a {
    public final /* synthetic */ LiveOpenFeatureChooseListFragmentV3 a;
    public final /* synthetic */ int b;
    public final /* synthetic */ c20.d c;

    @Override // com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.tab.TabSelectorView.a
    public final void a(String r6) {
        Intrinsics.checkNotNullParameter(r6, "selectValue");
        OpenFeatureTabPageAdapterV3 r0 = this.a.e;
        if (r0 == null) goto L5;
        r0.f(this.b);
    L5:
        int r1 = d20.a.a;
        String r2 = this.c.b;
        Intrinsics.checkNotNullParameter(r2, "tabName");
        Intrinsics.checkNotNullParameter(r6, "selectType");
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_function_panel_select_click", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("tab_name", r2), TuplesKt.to("select_type", r6), TuplesKt.to("show_tab", r2)}), new Object[]{Room.class});
    }

    public b(LiveOpenFeatureChooseListFragmentV3 r1, int r2, c20.d r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
