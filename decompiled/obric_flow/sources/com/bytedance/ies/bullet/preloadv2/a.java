package com.bytedance.ies.bullet.preloadv2;

import com.bytedance.ies.bullet.service.base.a0;
import com.bytedance.ies.bullet.service.base.resourceloader.config.IXResourceLoader;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import wc.g;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends IXResourceLoader {
    public static void a(a0 r5, g r10) {
        if (c.f5880a == true) goto L6;
        r5.getClass();
        Intrinsics.checkNotNullParameter("disable by settings", "<set-?>");
        r5.f5944q = "disable by settings";
        return;
    L6:
        r10.getClass();
        String r11 = com.bytedance.apm.util.a.c(r5.f5932a.toString(), r10);
        com.bytedance.ies.bullet.base.utils.b.g("PreloadLoader " + r11);
        if (Intrinsics.areEqual(r10.f22840i, "template") == false) goto L9;
        oc.e.d.b(r11);
    L10:
        Intrinsics.checkNotNullParameter("preload mem miss", "<set-?>");
        r5.f5944q = "preload mem miss";
        return;
    L9:
        oc.b.d.b(r11);
        oc.d.d.b(r11);
        goto L10
    }

    @Override // com.bytedance.ies.bullet.service.base.resourceloader.config.IXResourceLoader
    public final void cancelLoad() {
    }

    @Override // com.bytedance.ies.bullet.service.base.resourceloader.config.IXResourceLoader
    public final void loadAsync(a0 r5, g r10, Function1 r11, Function1 r12) {
        Intrinsics.checkNotNullParameter(r5, "input");
        Intrinsics.checkNotNullParameter(r10, "config");
        Intrinsics.checkNotNullParameter(r11, "resolve");
        Intrinsics.checkNotNullParameter(r12, "reject");
        a(r5, r10);
        com.bytedance.ies.bullet.base.utils.b.g("PreloadLoader miss " + r5.f5932a);
        r12.invoke(new Throwable(r5.f5944q));
    }

    @Override // com.bytedance.ies.bullet.service.base.resourceloader.config.IXResourceLoader
    public final a0 loadSync(a0 r5, g r10) {
        Intrinsics.checkNotNullParameter(r5, "input");
        Intrinsics.checkNotNullParameter(r10, "config");
        a(r5, r10);
        com.bytedance.ies.bullet.base.utils.b.g("PreloadLoader miss " + r5.f5932a);
        return null;
    }
}
