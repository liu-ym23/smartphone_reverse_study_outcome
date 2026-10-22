package com.larus.platform.service;

import android.content.Context;
import com.bytedance.router.SmartRouter;
import com.larus.utils.f;
import com.larus.utils.logger.FLogger;
import com.larus.utils.y0;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class n3 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(Context r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        if (r6 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        if (r2 == false) goto L14;
        FLogger.a.i("UrlNavigationService", "openUrl skipped: blank url");
        return;
    L14:
        if (y0.e(r6) == false) goto L16;
        FLogger.a.i("UrlNavigationService", "openUrl routeType=browser");
        q.a.e(r5, f.c(new Pair[]{TuplesKt.to("link_url", r6)}), null);
        return;
    L16:
        FLogger.a.i("UrlNavigationService", "openUrl routeType=smart_router");
        SmartRouter.buildRoute(r5, r6).d();
        return;
    L5:
        if (r6.length() == 0) goto L8;
        r2 = false;
        goto L10
    }
}
