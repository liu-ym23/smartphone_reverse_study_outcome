package pa0;

import com.bytedance.android.live.recharge.platform.service.z;
import com.bytedance.android.live.recharge.utils.RechargeFacadeUtilsKt;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class m implements Observer<e> {
    public m() {
    }

    public final void onComplete() {
    }

    public final void onSubscribe(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "d");
    }

    public final void onError(Throwable r3) {
        Intrinsics.checkNotNullParameter(r3, "e");
        jy0.b.b("Incentive/UserIncomeRepository", "updateIncomeInfo error", r3);
        RechargeFacadeUtilsKt.a().getClass();
        ww0.a r0 = z.a();
        if (r0 == null) goto L5;
        r0.E7();
        iw0.a r1 = iw0.a.a;
    L6:
        if (r1 == null) goto L9;
        r1.a(r3);
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void onNext(Object r3) {
        e r4 = (e) r3;
        Intrinsics.checkNotNullParameter(r4, "t");
        jy0.b.a("Incentive/UserIncomeRepository", "updateIncomeInfo success");
        o.a.setValue(r4);
    }
}
