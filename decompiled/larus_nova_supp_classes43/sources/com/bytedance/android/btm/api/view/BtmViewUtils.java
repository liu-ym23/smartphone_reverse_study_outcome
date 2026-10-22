package com.bytedance.android.btm.api.view;

import android.view.View;
import com.bytedance.android.btm.api.BtmPageLifecycle;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.inner.ALogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class BtmViewUtils {
    public static final String a = "BtmViewUtils_show";
    public static final String b = "BtmViewUtils_hide";

    public BtmViewUtils() {
    }

    static {
        a = "BtmViewUtils_show";
        b = "BtmViewUtils_hide";
    }

    public static void a(View r10) {
        final String r0 = r10.getClass().getName();
        ALogger.m(ALogger.d, b, new BtmViewUtils$hide$1(r0));
        BtmSDK r1 = BtmSDK.INSTANCE;
        BtmPageLifecycle.a.a(r1.getPageLifecycle(), r10, null, 6);
        r1.getPageLifecycle().c(r10, BtmPageLifecycle.State.PAUSED);
    }

    public static void c(View r10) {
        final String r0 = r10.getClass().getName();
        ALogger.m(ALogger.d, a, new BtmViewUtils$show$1(r0));
        BtmSDK r1 = BtmSDK.INSTANCE;
        r1.getPageLifecycle().g(r10, null, null);
        r1.getPageLifecycle().c(r10, BtmPageLifecycle.State.RESUMED);
    }

    public static void b(View r10, final boolean r11) {
        final String r0 = r10.getClass().getName();
        ALogger.m(ALogger.d, b, new BtmViewUtils$hide$2(r0, r11));
        BtmSDK r1 = BtmSDK.INSTANCE;
        BtmPageLifecycle.a.a(r1.getPageLifecycle(), r10, Boolean.valueOf(r11), 4);
        r1.getPageLifecycle().c(r10, BtmPageLifecycle.State.PAUSED);
    }
}
