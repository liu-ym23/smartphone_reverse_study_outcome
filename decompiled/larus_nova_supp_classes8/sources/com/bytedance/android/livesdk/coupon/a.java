package com.bytedance.android.livesdk.coupon;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.coupon.api.CouponApi;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.Logger;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public abstract class a<T> {
    public static final /* synthetic */ int f = 0;
    public final CompositeDisposable a;
    public T b;
    public final at1.a c;
    public final int d;
    public final int e;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.coupon.a$a, reason: collision with other inner class name */
    public static final class C0113a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ a a;

        public b(a r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            com.bytedance.android.live.network.response.e r3 = (com.bytedance.android.live.network.response.e) r2;
            if (r3 == null) goto L5;
            com.bytedance.android.livesdk.coupon.balancecoupon.model.c r0 = (com.bytedance.android.livesdk.coupon.balancecoupon.model.c) ((ExtraResponse) r3).data;
        L6:
            if (r0 != null) goto L8;
            Logger.d("AbsCouponController", "query data is null");
            return;
        L8:
            this.a.h((com.bytedance.android.livesdk.coupon.balancecoupon.model.c) ((ExtraResponse) r3).data);
            return;
        L5:
            r0 = null;
            goto L6
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ a a;

        public c(a r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            this.a.getClass();
            ALogger.e("AbsCouponController", "query error, " + ((Throwable) r3));
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ a a;

        public d(a r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            com.bytedance.android.live.network.response.e r3 = (com.bytedance.android.live.network.response.e) r2;
            if (r3 == null) goto L5;
            com.bytedance.android.livesdk.coupon.balancecoupon.model.b r0 = (com.bytedance.android.livesdk.coupon.balancecoupon.model.b) ((ExtraResponse) r3).data;
        L6:
            if (r0 != null) goto L8;
            Logger.d("AbsCouponController", "obtain data is null");
            return;
        L8:
            this.a.g((com.bytedance.android.livesdk.coupon.balancecoupon.model.b) ((ExtraResponse) r3).data);
            return;
        L5:
            r0 = null;
            goto L6
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ a a;

        public e(a r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            a r0 = this.a;
            r0.f((Throwable) r2);
        }
    }

    static {
    }

    public abstract Map<String, Object> b();

    public final boolean c() {
        T r1 = i(this.c);     // Catch: Throwable -> L11
        this.b = r1;     // Catch: Throwable -> L11
        if (r1 != null) goto L6;
        return false;
    L6:
        Room r0 = (Room) this.c.b.get("data_room", null);
        if (r0 == null) goto L16;
        this.a.add(((CouponApi) com.bytedance.android.live.network.c.b().e(CouponApi.class)).queryBenefitCoupon(r0.getRoomId(), r0.getAnchorId(), this.d, b()).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(this), new c(this)));
        return true;
    L16:
        return true;
    L11:
        th = move-exception;
        ALogger.e("AbsCouponController", "coupon parseSchema error, " + th);
        return false;
    }

    public abstract boolean d();

    public abstract void f(Throwable r1);

    public abstract void g(com.bytedance.android.livesdk.coupon.balancecoupon.model.b r1);

    public abstract void h(com.bytedance.android.livesdk.coupon.balancecoupon.model.c r1);

    public abstract T i(at1.a r1);

    public Map<String, Object> a() {
        return new LinkedHashMap();
    }

    public final void e() {
        Room r0 = (Room) this.c.b.get("data_room", null);
        if (r0 != null) goto L5;
        return;
    L5:
        if (d() == false) goto L8;
        Logger.d("AbsCouponController", "coupon interceptObtain");
        return;
    L8:
        this.a.add(((CouponApi) com.bytedance.android.live.network.c.b().e(CouponApi.class)).exchangeBenefitCoupon(r0.getRoomId(), r0.getAnchorId(), a()).compose(RxUtil.rxSchedulerHelper()).subscribe(new d(this), new e(this)));
    }

    public void j() {
        this.a.dispose();
    }

    public a(at1.a r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "couponContext");
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.a = new CompositeDisposable();
    }
}
