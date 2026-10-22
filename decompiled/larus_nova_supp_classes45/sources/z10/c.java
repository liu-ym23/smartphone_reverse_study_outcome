package z10;

import a20.e;
import a20.m;
import android.view.View;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.base.OpenFeatureIconCallbackFrom;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.base.OpenFeatureIconCallbackType;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import f10.f;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ e a;
    public final /* synthetic */ f b;
    public final /* synthetic */ View c;
    public final /* synthetic */ int d;

    public c(e r1, f r2, View r3, int r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        if (this.a != null) goto L6;
        LocalTestManager.a(new Class[]{wy.a.class});
    L6:
        if (h20.a.a(((ExtendedToolbarButton.c) this.b).k) == false) goto L10;
        IBroadcastService r8 = (IBroadcastService) k.f(IBroadcastService.class);
        if (r8 == null) goto L10;
        f r0 = this.b;
        String r1 = ((ExtendedToolbarButton.c) r0).s;
        String r2 = r0.f();
        f r3 = this.b;
        r8.putInteractToolsMobInfo(r1, new a00.a(r2, ((ExtendedToolbarButton.c) r3).k, "interactive_extension_detailpage", r3.D.i().extra));
    L10:
        e r9 = this.a;
        if (r9 == null) goto L14;
        r9.a(this.c, this.b, this.d, new m(OpenFeatureIconCallbackFrom.RECENT_USE, OpenFeatureIconCallbackType.ITEM_CONTENT));
        return;
    }
}
