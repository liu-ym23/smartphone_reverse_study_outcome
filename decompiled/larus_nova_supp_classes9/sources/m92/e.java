package m92;

import android.view.View;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdk.interactivity.common.utils.h;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;
import g42.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ HighlightItem.e b;

    public e(boolean r1, HighlightItem.e r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        if (h.b(this.a) == false) goto L5;
        i42.d r3 = new i42.d(this.b);
        r3.d = true;
        i.a(r3);
        return;
    L5:
        f2.b(2131921367, 0);
    }
}
