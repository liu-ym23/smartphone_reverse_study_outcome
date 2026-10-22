package zz1;

import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftGroupCardDataStore;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import oc6.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h implements v, com.bytedance.android.scope.o {
    public final GiftGroupCardDataStore a;

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
            return (oc6.g) sh6.c.b(r3);
        }
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final Observable<oc6.g> ObservableSelectGroupCard() {
        return this.a.g.map(a.a);
    }

    public h(GiftGroupCardDataStore r2) {
        Intrinsics.checkNotNullParameter(r2, "groupCardDataStore");
        this.a = r2;
    }
}
