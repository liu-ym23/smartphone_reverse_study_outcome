package sa1;

import android.view.View;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.search.impl.search.viewholder.LiveSearchViewHolder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d implements View.OnLayoutChangeListener {
    public final /* synthetic */ LiveSearchViewHolder a;
    public final /* synthetic */ ImageModel b;

    public d(LiveSearchViewHolder r1, ImageModel r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        LiveSearchViewHolder r10 = this.a;
        ImageModel r12 = this.b;
        int r13 = r12.width;
        int r14 = r12.height;
        int r15 = LiveSearchViewHolder.t;
        r10.U3(r13, r14);
    }
}
