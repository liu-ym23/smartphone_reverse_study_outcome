package l92;

import android.view.View;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ HighlightItem.d b;

    public g(boolean r1, HighlightItem.d r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        if (com.bytedance.android.livesdk.interactivity.common.utils.h.b(this.a) == false) goto L5;
        h42.c r3 = new h42.c(this.b);
        r3.d = true;
        g42.i.a(r3);
        return;
    L5:
        f2.b(2131921367, 0);
    }
}
