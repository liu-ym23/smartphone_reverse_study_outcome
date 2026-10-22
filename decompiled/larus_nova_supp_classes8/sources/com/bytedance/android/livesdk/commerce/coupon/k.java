package com.bytedance.android.livesdk.commerce.coupon;

import com.bytedance.android.live.GsonHelper;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class k<T> implements Consumer {
    public final /* synthetic */ LiveCouponPresenter a;

    public k(LiveCouponPresenter r1) {
        this.a = r1;
    }

    public final void accept(Object r11) {
        g r12 = (g) r11;
        boolean r1 = false;
        LiveCouponPresenter.d0(this.a, "ttlive_live_coupon_getcurrent", 0, new String[]{"room_id", String.valueOf(this.a.b)});
        if (r12.f() == 0) goto L8;
        LiveCouponPresenter.b r13 = (LiveCouponPresenter.b) ((q46.b) this.a).a;
        if (r13 == null) goto L45;
        r13.Z80();
        return;
    L45:
        return;
    L8:
        if (r12.c() == null) goto L47;
        long r6 = 0;
        if ((r12.d() - r12.e()) >= 0) goto L12;
    L14:
        boolean r0 = false;
    L15:
        if (r0 == false) goto L48;
        LiveCouponPresenter r2 = this.a;
        r2.m = true;
        d r3 = r12.c();
        b r4 = null;
        if (r3 == null) goto L19;
        String r5 = r3.couponMetaId;
    L20:
        r2.j = r5;
        LiveCouponPresenter r7 = this.a;
        d r8 = r12.c();
        if (r8 == null) goto L23;
        r6 = r8.type;
    L23:
        r7.n = r6;
        LiveCouponPresenter r9 = this.a;
        String r14 = r12.a();
        if (r14 != null) goto L26;
    L36:
        r9.d = r4;
        LiveCouponPresenter r15 = this.a;
        b r10 = r15.d;
        if (r10 != null) goto L39;
    L41:
        r15.g0(5);
        return;
    L39:
        if (r10.activityType != 1) goto L41;
        r15.g0(6);
        return;
    L26:
        if (r14.length() <= 0) goto L28;
        r1 = true;
    L28:
        if (r1 == true) goto L31;
        r14 = null;
    L31:
        if (r14 == null) goto L36;
        r4 = (b) GsonHelper.get().fromJson(r14, b.class);     // Catch: Exception -> L34
    L34:
        e = move-exception;
        e.printStackTrace();
        goto L36
    L19:
        r5 = null;
        goto L20
    L48:
        return;
    L12:
        if ((r12.d() - r12.e()) >= r12.b()) goto L14;
        r0 = true;
        goto L15
    }
}
