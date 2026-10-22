package g20;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewholder.delegate.v3.OpenFeatureFunctionItemViewHolderV3;
import com.ss.android.ugc.aweme.debug.LocalTestManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ OpenFeatureFunctionItemViewHolderV3 a;
    public final /* synthetic */ f10.f b;

    public b(OpenFeatureFunctionItemViewHolderV3 r1, f10.f r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        if (this.a.e != null) goto L5;
        LocalTestManager.a(new Class[]{wy.a.class});
    L5:
        OpenFeatureFunctionItemViewHolderV3 r6 = this.a;
        a20.e r0 = r6.e;
        if (r0 == null) goto L9;
        r0.a(((RecyclerView.ViewHolder) r6).itemView, this.b, r6.getPosition(), null);
        return;
    }
}
