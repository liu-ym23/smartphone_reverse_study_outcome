package pw0;

import com.bytedance.android.live.recharge.jsbridge.RevenueRequestDiamondCouponInfoResultModel;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ f a;
    public final /* synthetic */ Integer b;
    public final /* synthetic */ Long c;

    public d(f r1, Integer r2, Long r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r8) {
        f r0 = this.a;
        RevenueRequestDiamondCouponInfoResultModel r1 = new RevenueRequestDiamondCouponInfoResultModel();
        r1.a(RevenueRequestDiamondCouponInfoResultModel.Code.Success);
        RevenueRequestDiamondCouponInfoResultModel.b r2 = new RevenueRequestDiamondCouponInfoResultModel.b();
        r2.b(this.b);
        r2.c(this.c);
        List r9 = (List) r8;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator<T> r10 = r9.iterator();
    L4:
        if (r10.hasNext() == false) goto L9;
        com.bytedance.android.live.recharge.platform.business.model.diamond.d r4 = (com.bytedance.android.live.recharge.platform.business.model.diamond.d) r10.next();
        RevenueRequestDiamondCouponInfoResultModel.a r5 = new RevenueRequestDiamondCouponInfoResultModel.a();
        String r6 = r4.getCouponId();
        if (r6 != null) goto L8;
        r6 = "";
    L8:
        r5.a(r6);
        r5.e(r4.getExpiredTime());
        r5.h(r4.getTitle());
        r5.g(r4.getSubTitle());
        r5.b(r4.getDiscountAmount());
        r5.c(r4.getConditionTitle());
        r5.d(Boolean.valueOf(!r4.isDisable()));
        r5.f(Boolean.valueOf(r4.isSelected()));
        r3.add(r5);
        goto L4
    L9:
        r2.a(r3);
        Unit r12 = Unit.INSTANCE;
        r1.b(r2);
        r0.finishWithResult(r1);
    }
}
