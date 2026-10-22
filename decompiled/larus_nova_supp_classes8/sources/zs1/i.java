package zs1;

import android.net.Uri;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.bytedance.android.livesdk.user.l;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i implements e.a {
    public final /* synthetic */ g a;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ i a;

        public a(i r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            IBaseUser r2 = (IBaseUser) r1;
            this.a.a.e();
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r3) {
            ALogger.e("UgBalanceCouponController", "coupon login fail: " + ((Throwable) r3));
        }
    }

    @Override // zs1.e.a
    public final void onClose() {
        this.a.l();
        g.k(this.a, "close");
    }

    public i(g r1) {
        this.a = r1;
    }

    @Override // zs1.e.a
    public final void a(com.bytedance.android.livesdk.coupon.balancecoupon.model.a r3) {
        Intrinsics.checkNotNullParameter(r3, "data");
        String r4 = this.a.i;
        if (r4 != null) goto L5;
    L10:
        Uri r5 = UriProtector.parse("sslocal://webcast_webview?web_bg_color=%23FFFFFF&status_bar_color=black&status_font_dark=1").buildUpon().appendQueryParameter("url", this.a.i).build();
        ILiveActionHandler r0 = k.f(ILiveActionHandler.class);
        if (r0 == null) goto L13;
        r0.handle(this.a.c.getContext(), r5);
    L13:
        g.k(this.a, "rule_url");
        return;
    L5:
        if (r4.length() != 0) goto L7;
        boolean r6 = true;
    L8:
        if (r6 != true) goto L10;
        return;
    L7:
        r6 = false;
        goto L8
    }

    @Override // zs1.e.a
    public final void b(com.bytedance.android.livesdk.coupon.balancecoupon.model.a r3) {
        Intrinsics.checkNotNullParameter(r3, "data");
        IUserService r4 = k.f(IUserService.class);
        if (r4 == null) goto L5;
        com.bytedance.android.livesdk.user.f r5 = r4.user();
    L6:
        if (r5 != null) goto L8;
    L10:
        l.a r0 = new l.a();
        r0.d = "balance_to_coupon_popup";
        r0.c = -1;
        l r1 = new l(r0);
        if (r5 == null) goto L15;
        Observable r6 = r5.login(this.a.c.getContext(), r1);
        if (r6 == null) goto L15;
        r6.subscribe(new a(this), b.a);
    L15:
        g.k(this.a, "exchange");
        return;
    L8:
        if (r5.isLogin() != true) goto L10;
        this.a.e();
        goto L15
    L5:
        r5 = null;
        goto L6
    }
}
