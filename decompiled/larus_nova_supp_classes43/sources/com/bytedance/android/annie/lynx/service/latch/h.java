package com.bytedance.android.annie.lynx.service.latch;

import com.bytedance.android.annie.service.latch.ILatchService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class h extends hx.a {
    public final /* synthetic */ ILatchService.a a;
    public final /* synthetic */ g b;

    public h(ILatchService.a r1, g r10) {
        this.a = r1;
        this.b = r10;
    }

    public final void b(com.bytedance.android.latch.a.d r10, com.bytedance.android.latch.internal.perf.a r11) {
        Intrinsics.checkNotNullParameter(r10, "process");
        Intrinsics.checkNotNullParameter(r11, "jsbPromiseMetric");
        ILatchService.a r12 = this.a;
        this.b.getClass();
        r12.b(new ILatchService.b(r11.a, r11.b, r11.c));
    }

    public final void d(com.bytedance.android.latch.a.d r10, com.bytedance.android.latch.internal.perf.e r11) {
        Intrinsics.checkNotNullParameter(r10, "process");
        Intrinsics.checkNotNullParameter(r11, "perfMetric");
        ILatchService.a r12 = this.a;
        this.b.getClass();
        r12.a(new ILatchService.c(r11.a, r11.b, r11.c));
    }

    public final void e(com.bytedance.android.latch.a.d r10, dx.c r11) {
        Intrinsics.checkNotNullParameter(r10, "process");
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_RESULT);
        this.a.c(r11.a, r11.b, r11.c, r11.d, r11.e, r11.f, r11.g);
    }
}
