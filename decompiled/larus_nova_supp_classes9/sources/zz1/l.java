package zz1;

import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.u;
import io.reactivex.Observable;
import kotlin.jvm.internal.Intrinsics;
import oc6.a0;
import oc6.m0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l implements a0, com.bytedance.android.scope.o {
    public final u a;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final Observable<m0> observeRechargeIconInfo() {
        return this.a.h;
    }

    public l(u r2) {
        Intrinsics.checkNotNullParameter(r2, "giftRechargeDataStore");
        this.a = r2;
    }
}
