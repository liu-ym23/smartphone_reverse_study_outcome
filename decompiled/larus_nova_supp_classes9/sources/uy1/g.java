package uy1;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.gift.grouplive.component.k;
import com.bytedance.android.scope.o;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g implements o {
    public final CompositeDisposable a;
    public final k b;

    public final void onStart() {
        RxUtilKt.c(com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class).O3(new f(this)), this.a);
    }

    public final void onStop() {
        this.a.clear();
    }

    public g(k r2) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        this.b = r2;
        this.a = new CompositeDisposable();
    }
}
