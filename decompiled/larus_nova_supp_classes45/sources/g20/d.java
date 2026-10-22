package g20;

import a20.m;
import android.view.View;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.base.OpenFeatureIconCallbackType;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewholder.delegate.v3.OpenFeatureTabListItemDebugModeViewHolder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ OpenFeatureTabListItemDebugModeViewHolder a;
    public final /* synthetic */ a20.e b;
    public final /* synthetic */ f10.f c;
    public final /* synthetic */ int d;

    public d(OpenFeatureTabListItemDebugModeViewHolder r1, a20.e r2, f10.f r3, int r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        a20.e r0 = this.b;
        if (r0 == null) goto L6;
        r0.a(r7, this.c, this.d, new m(this.a.l, OpenFeatureIconCallbackType.DEBUG_BUTTON));
        return;
    }
}
