package xv0;

import android.view.View;
import com.bytedance.android.live.recharge.adapter.CustomRecommendPriceAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ long a;
    public final /* synthetic */ CustomRecommendPriceAdapter b;

    public a(long r1, CustomRecommendPriceAdapter r3) {
        this.a = r1;
        this.b = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        CustomRecommendPriceAdapter.a r4 = this.b.b;
        if (r4 == null) goto L6;
        r4.Yq(this.a);
        return;
    }
}
