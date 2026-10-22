package m92;

import android.view.View;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;
import g42.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements View.OnLongClickListener {
    public final /* synthetic */ HighlightItem.e a;

    public c(HighlightItem.e r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r2) {
        i.a(new i42.d(this.a));
        return true;
    }
}
