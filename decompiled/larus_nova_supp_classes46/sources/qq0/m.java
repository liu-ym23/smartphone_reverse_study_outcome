package qq0;

import android.view.View;
import com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.view.PrivateMsgEntranceItemViewHolder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class m implements View.OnClickListener {
    public final /* synthetic */ PrivateMsgEntranceItemViewHolder a;
    public final /* synthetic */ lo0.a b;

    public m(PrivateMsgEntranceItemViewHolder r1, lo0.a r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        this.a.f.b(this.b);
    }
}
