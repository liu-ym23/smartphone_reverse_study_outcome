package sa1;

import android.view.View;
import com.bytedance.android.live.search.impl.search.viewholder.LiveSearchSugViewHolder;
import ra1.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ LiveSearchSugViewHolder a;
    public final /* synthetic */ g b;

    public c(LiveSearchSugViewHolder r1, g r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        qa1.c r3 = this.a.f;
        if (r3 == null) goto L6;
        r3.Dw(this.b);
        return;
    }
}
