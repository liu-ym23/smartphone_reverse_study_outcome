package jx0;

import com.bytedance.android.live.recharge.panel.context.e;
import com.bytedance.android.live.revenue.common.u0;
import com.bytedance.android.scope.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements o, a {
    public final e a;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public b(e r2) {
        Intrinsics.checkNotNullParameter(r2, "panelContextManager");
        this.a = r2;
    }

    @Override // jx0.a
    public final void reportEvent(c r7) {
        Intrinsics.checkNotNullParameter(r7, "request");
        if (r7.b().length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L17;
        com.bytedance.android.live.recharge.panel.context.c r1 = this.a.i();
        if (r1 == null) goto L10;
        com.bytedance.android.live.recharge.trace.session.a r2 = r1.getSession();
    L11:
        if (r2 == null) goto L15;
        String r3 = r7.a();
        String r4 = r7.b();
        u0 r5 = u0.f;
        r2.b(new com.bytedance.android.live.recharge.trace.session.b(r3, r4, new u0(r7.c())));
        return;
    L15:
        throw new IllegalStateException("no active recharge panel session".toString());
    L10:
        r2 = null;
        goto L11
    L17:
        throw new IllegalStateException("event_name cannot be empty".toString());
    L5:
        r0 = false;
        goto L6
    }
}
