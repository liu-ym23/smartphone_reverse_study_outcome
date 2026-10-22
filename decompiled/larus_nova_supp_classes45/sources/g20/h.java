package g20;

import a20.m;
import android.view.View;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.base.OpenFeatureIconCallbackType;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewholder.delegate.v3.OpenFeatureTabListItemViewHolderV3;
import com.ss.android.ugc.aweme.debug.LocalTestManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h implements View.OnClickListener {
    public final /* synthetic */ OpenFeatureTabListItemViewHolderV3 a;
    public final /* synthetic */ a20.e b;
    public final /* synthetic */ View c;
    public final /* synthetic */ f10.f d;
    public final /* synthetic */ int e;

    public h(OpenFeatureTabListItemViewHolderV3 r1, a20.e r2, View r3, f10.f r4, int r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        if (this.b != null) goto L5;
        LocalTestManager.a(new Class[]{wy.a.class});
    L5:
        a20.e r8 = this.b;
        if (r8 == null) goto L9;
        r8.a(this.c, this.d, this.e, new m(this.a.l, OpenFeatureIconCallbackType.ITEM_CONTENT));
        return;
    }
}
