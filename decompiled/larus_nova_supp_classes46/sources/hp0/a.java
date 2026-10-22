package hp0;

import android.view.View;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.list.banner.SimpleCarouselIndicator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ SimpleCarouselIndicator a;
    public final /* synthetic */ int b;
    public final /* synthetic */ SimpleCarouselIndicator.a c;

    public a(SimpleCarouselIndicator r1, int r2, SimpleCarouselIndicator.d r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        if (this.a.getDotsClickable() == true) goto L5;
        return;
    L5:
        if (this.b >= this.c.getCount()) goto L9;
        this.c.a(this.b);
        return;
    }
}
