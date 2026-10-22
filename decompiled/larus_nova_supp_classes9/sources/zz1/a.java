package zz1;

import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.u;
import io.reactivex.Observable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements oc6.i, com.bytedance.android.scope.o {
    public final u a;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final Observable<oc6.e> observeExchangeInfo() {
        return this.a.k;
    }

    public a(u r2) {
        Intrinsics.checkNotNullParameter(r2, "rechargeDataStore");
        this.a = r2;
    }
}
