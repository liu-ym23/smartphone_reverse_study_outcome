package vw0;

import android.content.Context;
import com.bytedance.android.live.recharge.panel.RechargeAgreementUtilsKt;
import com.bytedance.android.live.recharge.panel.aio.IPanelProperties;
import com.bytedance.android.scope.o;
import com.bytedance.revenue.platform.api.core.rx.q;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements vw0.a, o, com.bytedance.android.live.recharge.core.c {
    public final com.bytedance.android.live.recharge.panel.context.e a;

    public static final class a<T, R> implements Function {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final Object apply(Object r2) {
            Boolean r3 = (Boolean) r2;
            Intrinsics.checkNotNullParameter(r3, "isAccepted");
            IPanelProperties r0 = f.a();
            r0.setRechargeAgreementAccepted(r3);
            return r0;
        }
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // vw0.a
    public final Single<IPanelProperties> ensureRechargeAgreementAccepted() {
        com.bytedance.android.live.recharge.panel.context.c r0 = this.a.i();
        if (r0 == null) goto L11;
        Context r1 = r0.i();
        if (r1 != null) goto L8;
        int r2 = q.a;
        return Single.error(new IllegalStateException("current context is null!"));
    L8:
        Intrinsics.checkNotNullParameter(r0, "$this$ensureRechargeAgreementAccepted");
        Intrinsics.checkNotNullParameter(r1, "androidContext");
        return RechargeAgreementUtilsKt.a(r0, r1).map(a.a);
    L11:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // vw0.a
    public final Observable observePanelProperties() {
        com.bytedance.android.live.recharge.panel.context.c r0 = this.a.i();
        if (r0 == null) goto L7;
        return new com.bytedance.revenue.platform.api.core.rx.b(r0.b().h);
    L7:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public b(com.bytedance.android.live.recharge.panel.context.e r2) {
        Intrinsics.checkNotNullParameter(r2, "panelContextManager");
        this.a = r2;
    }

    @Override // vw0.a
    public final void updatePanelProperties(IPanelProperties r2) {
        Intrinsics.checkNotNullParameter(r2, "props");
        com.bytedance.android.live.recharge.panel.context.c r0 = this.a.i();
        if (r0 == null) goto L7;
        e.a(r0.b(), r2);
        return;
    L7:
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
