package zs1;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ e.a a;
    public final /* synthetic */ com.bytedance.android.livesdk.coupon.balancecoupon.model.a b;

    public b(i r1, com.bytedance.android.livesdk.coupon.balancecoupon.model.a r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        this.a.a(this.b);
    }
}
