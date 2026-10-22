package com.bytedance.ies.bullet.preloadv2;

import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements ComponentCallbacks {
    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r5) {
        Intrinsics.checkNotNullParameter(r5, "newConfig");
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
        boolean r5 = c.f5880a;
        Intrinsics.checkNotNullParameter("onLowMemory", "reason");
        com.bytedance.ies.bullet.base.utils.logger.a.g("XPreload", "clearCache because of onLowMemory", null, 12);
        oc.e.d.c(c.f5881b);
        oc.d.d.c(c.f5882c);
        oc.b.d.c(c.f5882c);
    }
}
