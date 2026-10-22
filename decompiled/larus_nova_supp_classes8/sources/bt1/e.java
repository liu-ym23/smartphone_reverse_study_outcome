package bt1;

import com.bytedance.android.live.core.utils.LiveResUtil;
import com.bytedance.android.live.core.utils.f2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e implements h {
    public final /* synthetic */ b a;
    public final /* synthetic */ com.bytedance.android.livesdk.coupon.expandcoupon.model.e b;

    @Override // bt1.h
    public final void onFail() {
        com.bytedance.android.livesdk.coupon.util.a r1 = com.bytedance.android.livesdk.coupon.util.a.a;
        long r2 = this.b.d();
        r1.getClass();
        f2.c(LiveResUtil.getString(2131916515, new Object[]{com.bytedance.android.livesdk.coupon.util.a.a(r2)}), 0);
    }

    @Override // bt1.h
    public final void onSuccess() {
        this.a.t();
    }

    public e(b r1, com.bytedance.android.livesdk.coupon.expandcoupon.model.e r2) {
        this.a = r1;
        this.b = r2;
    }
}
