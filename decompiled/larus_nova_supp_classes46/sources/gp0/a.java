package gp0;

import android.view.View;
import com.bytedance.android.live.broadcastgame.api.model.response.MiniAppEntrancePermissionResponse;
import com.bytedance.android.live.openplatform.api.model.datacontext.AnchorMiniAppDataContext;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.b;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.intro.MiniAppChooseIntroFragment;
import com.bytedance.android.livesdk.log.g;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.live.datacontext.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ MiniAppChooseIntroFragment a;

    public a(MiniAppChooseIntroFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        g r6 = u.l();
        MiniAppChooseIntroFragment r0 = this.a;
        int r1 = MiniAppChooseIntroFragment.i;
        r6.sendLog("livesdk_live_introduce_panel_click", r0.T90(), new Object[0]);
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r7 = AnchorMiniAppDataContext.a.a();
        if (r7 == null) goto L9;
        n<MiniAppEntrancePermissionResponse> r8 = r7.getEntranceInfo();
        if (r8 == null) goto L9;
        MiniAppEntrancePermissionResponse r9 = (MiniAppEntrancePermissionResponse) r8.getValue();
        if (r9 == null) goto L9;
        r9.setShowIntroPanel(false);
    L9:
        lp0.a r10 = this.a.e;
        if (r10 == null) goto L15;
        b r11 = r10.getContainer();
        if (r11 == null) goto L16;
        r11.Eq();
        return;
    L16:
        return;
    }
}
