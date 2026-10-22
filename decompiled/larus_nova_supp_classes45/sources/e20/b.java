package e20;

import android.view.View;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewholder.OpenFeatureInteractTabItemViewHolder;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ OpenFeatureInteractTabItemViewHolder a;
    public final /* synthetic */ a20.e b;
    public final /* synthetic */ f10.f c;
    public final /* synthetic */ int d;

    public b(OpenFeatureInteractTabItemViewHolder r1, a20.e r2, f10.f r3, int r4) {
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
        IBroadcastService r8 = (IBroadcastService) k.f(IBroadcastService.class);
        if (r8 == null) goto L8;
        f10.f r0 = this.c;
        String r1 = ((ExtendedToolbarButton.c) r0).s;
        String r2 = r0.f();
        f10.f r3 = this.c;
        r8.putInteractToolsMobInfo(r1, new a00.a(r2, ((ExtendedToolbarButton.c) r3).k, "interactive_extension_homepage", r3.D.i().extra));
    L8:
        a20.e r9 = this.b;
        if (r9 == null) goto L11;
        r9.a(this.a.i, this.c, this.d, null);
    L11:
        int r11 = com.bytedance.android.live.broadcastgame.openplatform.feature_panel.business.c.a;
        f10.f r12 = this.c;
        com.bytedance.android.live.broadcastgame.openplatform.feature_panel.business.c.a(((ExtendedToolbarButton.c) r12).s, r12.u);
        OpenFeatureInteractTabItemViewHolder r13 = this.a;
        int r4 = OpenFeatureInteractTabItemViewHolder.p;
        r13.U3();
    }
}
