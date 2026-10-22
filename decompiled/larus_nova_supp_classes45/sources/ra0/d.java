package ra0;

import com.bytedance.android.live.incentive.balance.UpdateReason;
import com.bytedance.android.live.revenue.common.reactive.j;
import com.bytedance.android.scope.o;
import io.reactivex.Observable;
import io.reactivex.Single;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d implements o, c {
    public final sa0.c a;
    public final com.bytedance.android.live.incentive.balance.d b;

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // ra0.c
    public final Observable<b> observeExchangeInfo() {
        sa0.c r0 = this.a;
        return j.a(r0.b.a(), true).map(new sa0.a(r0));
    }

    public d(com.bytedance.android.live.incentive.balance.d r3) {
        Intrinsics.checkNotNullParameter(r3, "balanceRepository");
        this.b = r3;
        boolean r0 = va0.a.a;
        com.bytedance.android.live.revenue.common.reactive.c r1 = pa0.o.a;
        this.a = new sa0.c(r3);
    }

    @Override // ra0.c
    public final Single<b> updateExchangeInfo(f r5) {
        Intrinsics.checkNotNullParameter(r5, "request");
        sa0.c r1 = this.a;
        String r6 = r5.a();
        int r2 = r6.hashCode();
        if (r2 == (-1909625014)) goto L16;
        if (r2 == (-818431518)) goto L13;
        if (r2 == 480940326) goto L10;
    L18:
        UpdateReason r7 = UpdateReason.Unknown;
    L19:
        com.bytedance.android.live.incentive.balance.e r3 = new com.bytedance.android.live.incentive.balance.e(r7);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "request");
        return r1.b.b().map(new sa0.b(r1)).singleOrError();
    L10:
        if (r6.equals("after_exchange") == false) goto L18;
        r7 = UpdateReason.AfterExchange;
        goto L19
    L13:
        if (r6.equals("enter_room") == false) goto L18;
        r7 = UpdateReason.EnterRoom;
        goto L19
    L16:
        if (r6.equals("open_gift_panel") == false) goto L18;
        r7 = UpdateReason.OpenGiftPanel;
        goto L19
    }
}
