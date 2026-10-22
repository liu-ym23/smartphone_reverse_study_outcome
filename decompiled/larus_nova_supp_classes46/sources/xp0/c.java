package xp0;

import android.view.View;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.view.banner.AnchorShelfDisplayBannerItemViewHolder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ AnchorShelfDisplayBannerItemViewHolder a;

    public c(AnchorShelfDisplayBannerItemViewHolder r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        this.a.d.onClose();
    }
}
