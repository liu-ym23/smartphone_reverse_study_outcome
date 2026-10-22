package com.bytedance.android.api;

import android.content.Context;
import com.bytedance.android.ec.hybrid.ECHybridExtensionsKt;
import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class PluginExp {
    public static volatile boolean a;
    public static final Lazy b = null;

    public static boolean a() {
        return ((Boolean) b.getValue()).booleanValue();
    }

    static {
        b = LazyKt.lazy(PluginExp$enabled$2.INSTANCE);
    }

    public static void b(String r1) {
        a();
        if (a == false) goto L6;
        return;
    L6:
        if (a() == false) goto L19;
        HybridAppInfoService r10 = HybridAppInfoService.p;
        if (r10.isDebug() == false) goto L11;
    L13:
        final Context r11 = r10.getApplicationContext();
        if (r11 == null) goto L21;
        ECHybridExtensionsKt.f(new PluginExp$showABToast$1(r11));
        return;
    L21:
        return;
    L11:
        if (r10.isLocalTest() == true) goto L13;
        return;
    }
}
