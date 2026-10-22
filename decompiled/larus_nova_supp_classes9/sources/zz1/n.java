package zz1;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftDialogStateDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftTabDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.GiftPanelBizBoostUtils;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import oc6.h0;
import oc6.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class n implements t, com.bytedance.android.scope.o {
    public final CompositeDisposable a;
    public boolean b;
    public final GiftTabDataStore c;
    public final GiftDialogStateDataStore d;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ n a;

        public a(n r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            vz1.j r4 = (vz1.j) r3;
            if (this.a.b == true) goto L5;
        L9:
            this.a.d.L(r4.b, r4.a);
            return;
        L5:
            if (com.bytedance.android.livesdk.gift.platform.business.b.f().j() == true) goto L9;
            this.a.b = false;
            GiftPanelBizBoostUtils.E.getClass();
            if (GiftPanelBizBoostUtils.d().P2() == false) goto L9;
        }
    }

    public final Observable<h0> observeTabList() {
        return this.c.e;
    }

    public final void onStart() {
        RxUtilKt.c(this.c.i.subscribe(new a(this)), this.a);
    }

    public final void onStop() {
        this.a.clear();
    }

    public n(GiftTabDataStore r2, GiftDialogStateDataStore r3) {
        Intrinsics.checkNotNullParameter(r2, "giftTabDataStore");
        Intrinsics.checkNotNullParameter(r3, "giftDialogStateDataStore");
        this.c = r2;
        this.d = r3;
        this.a = new CompositeDisposable();
        this.b = true;
    }
}
