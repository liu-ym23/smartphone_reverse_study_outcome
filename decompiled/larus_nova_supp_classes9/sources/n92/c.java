package n92;

import android.view.View;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdk.interactivity.common.utils.h;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;
import g42.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ HighlightItem.f b;

    public c(boolean r1, HighlightItem.f r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        if (h.b(this.a) == false) goto L5;
        k42.c r3 = new k42.c(this.b);
        r3.d = true;
        i.a(r3);
        return;
    L5:
        f2.b(2131921367, 0);
    }
}
