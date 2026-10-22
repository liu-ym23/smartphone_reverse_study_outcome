package com.bytedance.ies.bullet.base;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements ComponentCallbacks2 {
    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r5) {
        Intrinsics.checkNotNullParameter(r5, "newConfig");
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int r5) {
        Long r10 = (Long) dd.c.e().get("mem_java_used");
        if (r10 == null) goto L5;
        long r11 = r10.longValue();
    L6:
        dd.c.f16639a = r11;
        boolean r12 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.a(2, "memory_warning  onTrimMemory mem: " + dd.c.f16639a, "CpuMemoryPerfMetric");
        com.bytedance.ies.bullet.service.base.b.a(2, "MEMORY_WARNING  onTrimMemory level:" + r5, "CpuMemoryPerfMetric");
        if (r5 != 5) goto L9;
        gd.a.a();
        return;
    L9:
        if (r5 != 10) goto L11;
        gd.a.a();
        return;
    L11:
        if (r5 == 15) goto L13;
        return;
    L13:
        gd.a.a();
        return;
    L5:
        r11 = -1;
        goto L6
    }
}
