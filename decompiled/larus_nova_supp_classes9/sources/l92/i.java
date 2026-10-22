package l92;

import android.view.View;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i implements View.OnLongClickListener {
    public final /* synthetic */ HighlightItem.d a;

    public i(HighlightItem.d r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r2) {
        g42.i.a(new h42.c(this.a));
        return true;
    }
}
