package zz1;

import com.bytedance.android.livesdk.gift.model.x1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftMVICarnivalDataStore;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import oc6.f0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e implements oc6.m, com.bytedance.android.scope.o {
    public final GiftMVICarnivalDataStore a;

    public static final class a<T, R> implements Function {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final Object apply(Object r2) {
            sh6.b r3 = (sh6.b) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            f0 r0 = new f0();
            r0.a((x1) sh6.c.b(r3));
            return r0;
        }
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final Observable<f0> observeGiftPanelTopBar() {
        return this.a.e.map(a.a);
    }

    public e(GiftMVICarnivalDataStore r2) {
        Intrinsics.checkNotNullParameter(r2, "carnivalDataStore");
        this.a = r2;
    }
}
