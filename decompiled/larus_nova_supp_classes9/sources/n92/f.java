package n92;

import android.view.View;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;
import g42.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f implements View.OnLongClickListener {
    public final /* synthetic */ HighlightItem.f a;

    public f(HighlightItem.f r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r2) {
        i.a(new k42.c(this.a));
        return true;
    }
}
