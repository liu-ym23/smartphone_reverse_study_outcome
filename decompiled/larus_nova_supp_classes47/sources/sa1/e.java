package sa1;

import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.q0;
import com.bytedance.android.live.search.impl.search.viewholder.LiveSearchViewHolder;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e extends q0 {
    public final /* synthetic */ LiveSearchViewHolder a;

    public e(LiveSearchViewHolder r1) {
        this.a = r1;
    }

    public final void h(k r1, int r2, int r3) {
        ViewGroup.LayoutParams r4 = this.a.c.getLayoutParams();
        r4.width = (int) (r4.height * (r2 / r3));
        this.a.c.setLayoutParams(r4);
    }
}
