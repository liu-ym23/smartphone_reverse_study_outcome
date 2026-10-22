package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import androidx.lifecycle.LiveData;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewmodel.AbsOpenFeaturePanelViewModel;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class n implements View.OnClickListener {
    public final /* synthetic */ LiveOpenFeatureChooseListFragment a;

    public n(LiveOpenFeatureChooseListFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        LiveOpenFeatureChooseListFragment r7 = this.a;
        AbsOpenFeaturePanelViewModel r0 = r7.o;
        if (r0 == null) goto L12;
        LiveData<Pair<String, String>> r1 = r0.getShowFeatureDescTip();
        if (r1 == null) goto L13;
        Pair r2 = (Pair) r1.getValue();
        if (r2 == null) goto L14;
        String r3 = (String) r2.getSecond();
        if (r3 == null) goto L15;
        int r4 = h20.b.a;
        Context r8 = r7.getContext();
        Intrinsics.checkNotNull(r8);
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r3, LiveSlardarConstants.EXTRA_KEY_URL);
        com.bytedance.android.livesdk.log.u.l().b("livesdk_live_takepage_function_component_description_page_show");
        String r5 = jc1.k.n(IHostContext.class).getVersionName();
        ILiveActionHandler r9 = jc1.k.n(IRoomService.class).actionHandler();
        StringBuilder r11 = new StringBuilder("sslocal://webcast_webview?hide_nav_bar=1&trans_status_bar=1&status_bar_color=black&web_bg_color=%23ffffffff&title=小程序组件说明&url=");
        r11.append(Uri.encode(r3 + "?engine_type=old&app_version=" + r5 + "&status_bar_height=" + s1.G(s1.A()) + "&is_talent_tab=0"));
        r9.handle(r8, r11.toString());
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }
}
