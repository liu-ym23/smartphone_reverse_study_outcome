package g20;

import a20.m;
import android.view.View;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.base.OpenFeatureIconCallbackType;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewholder.delegate.v3.OpenFeatureTabListItemViewHolderV3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i implements View.OnClickListener {
    public final /* synthetic */ OpenFeatureTabListItemViewHolderV3 a;
    public final /* synthetic */ a20.e b;
    public final /* synthetic */ f10.f c;
    public final /* synthetic */ int d;

    public i(OpenFeatureTabListItemViewHolderV3 r1, a20.e r2, f10.f r3, int r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        if (this.b != null) goto L5;
        LocalTestManager.a(new Class[]{wy.a.class});
    L5:
        OpenFeatureTabListItemViewHolderV3 r8 = this.a;
        f10.f r0 = this.c;
        int r1 = OpenFeatureTabListItemViewHolderV3.m;
        r8.getClass();
        if (OpenFeatureTabListItemViewHolderV3.V3(r0) == false) goto L10;
        IBroadcastService r9 = (IBroadcastService) k.f(IBroadcastService.class);
        if (r9 == null) goto L10;
        f10.f r2 = this.c;
        String r3 = ((ExtendedToolbarButton.c) r2).s;
        String r4 = r2.f();
        f10.f r5 = this.c;
        r9.putInteractToolsMobInfo(r3, new a00.a(r4, ((ExtendedToolbarButton.c) r5).k, "interactive_extension_homepage", r5.D.i().extra));
    L10:
        a20.e r11 = this.b;
        if (r11 == null) goto L13;
        OpenFeatureTabListItemViewHolderV3 r6 = this.a;
        r11.a(r6.h, this.c, this.d, new m(r6.l, OpenFeatureIconCallbackType.START_BUTTON));
    L13:
        OpenFeatureTabListItemViewHolderV3 r12 = this.a;
        f10.f r13 = this.c;
        r12.getClass();
        if (OpenFeatureTabListItemViewHolderV3.V3(r13) == false) goto L17;
        int r14 = com.bytedance.android.live.broadcastgame.openplatform.feature_panel.business.c.a;
        f10.f r15 = this.c;
        com.bytedance.android.live.broadcastgame.openplatform.feature_panel.business.c.a(((ExtendedToolbarButton.c) r15).s, r15.u);
        return;
    }
}
