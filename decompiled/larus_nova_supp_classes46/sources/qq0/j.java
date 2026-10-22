package qq0;

import android.view.View;
import com.bytedance.android.live.openplatform.api.constant.MountedMiniAppSource;
import com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.view.AudienceShelfDisplayItemViewHolder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j implements View.OnClickListener {
    public final /* synthetic */ AudienceShelfDisplayItemViewHolder a;
    public final /* synthetic */ rq0.a b;
    public final /* synthetic */ boolean c;

    public j(AudienceShelfDisplayItemViewHolder r1, rq0.a r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        this.a.k.a(this.b, MountedMiniAppSource.ShelfPageCard, this.c);
    }
}
