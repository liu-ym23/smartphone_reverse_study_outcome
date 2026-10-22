package qa0;

import com.bytedance.android.scope.l;
import com.bytedance.android.scope.m;
import com.bytedance.android.scope.o;
import e33.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d implements o, b {
    public f a;
    public final com.bytedance.android.live.recharge.core.b b;

    public final void onStop() {
    }

    public final void onStart() {
        f r0 = new f(this.b);
        Intrinsics.checkNotNullParameter(r0, "scope");
        Object r1 = k.a;
        this.a = r0;
        l.a(r0);
        b r2 = c.a;
        Intrinsics.checkNotNullParameter(this, "impl");
        c.a = this;
    }

    public d(com.bytedance.android.live.recharge.core.b r2) {
        Intrinsics.checkNotNullParameter(r2, "rechargeScope");
        this.b = r2;
    }

    @Override // qa0.b
    public final <T extends a> T getService(Class<T> r4) {
        Intrinsics.checkNotNullParameter(r4, "serviceCls");
        m r0 = m.e;
        f r1 = this.a;
        if (r1 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("incentiveScope");
    L6:
        return (T) r0.d(r1, r4);
    }
}
