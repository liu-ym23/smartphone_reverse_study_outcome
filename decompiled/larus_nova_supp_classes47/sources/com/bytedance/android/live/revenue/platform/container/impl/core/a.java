package com.bytedance.android.live.revenue.platform.container.impl.core;

import com.bytedance.android.scope.o;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class a implements j, o, dy0.c {
    public final Map<com.bytedance.android.scope.j, h> a;
    public l b;
    public final g c;

    public final void onStop() {
    }

    public final void I() {
        l r0 = this.b;
        if (r0 == null) goto L7;
        zy0.b r1 = r0.b;
        if (r1 == null) goto L7;
        r1.dispose();
    L7:
        this.b = null;
        this.c.E();
    }

    public a(g r2) {
        Intrinsics.checkNotNullParameter(r2, "centerDriverService");
        this.c = r2;
        this.a = new LinkedHashMap();
    }

    public final String E(cy0.f r2) {
        h r3 = (h) ((LinkedHashMap) this.a).get(r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return r3.getServiceVersion();
    }

    public final void K(h r4, com.bytedance.android.scope.j r5) {
        Intrinsics.checkNotNullParameter(r4, "centerServiceManager");
        Intrinsics.checkNotNullParameter(r5, "scope");
        if (Intrinsics.areEqual((h) ((LinkedHashMap) this.a).get(r5), r4) == false) goto L5;
        this.a.remove(r5);
        return;
    L5:
        jy0.b.c("NativeHostServiceImpl", "remove wrong manager", null, 4);
        this.a.remove(r5);
    }

    @Override // com.bytedance.android.live.revenue.platform.container.impl.core.j
    public final void notifyServiceCenterState(NotifyServiceCenterStateRequest r2, i57.a r3) {
        Intrinsics.checkNotNullParameter(r2, "request");
        Intrinsics.checkNotNullParameter(r3, "aioCallContext");
        com.bytedance.android.scope.j r4 = (com.bytedance.android.scope.j) r3.a(i57.e.f.b());
        if (r4 == null) goto L8;
        h r5 = (h) ((LinkedHashMap) this.a).get(r4);
        if (r5 == null) goto L9;
        r5.b(r2);
        return;
    L9:
        return;
    }
}
