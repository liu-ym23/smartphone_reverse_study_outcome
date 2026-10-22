package com.bytedance.ai.model;

import android.os.Looper;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.bytedance.ai.monitor.bridge.BridgeType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class h0 {
    public h0() {
    }

    public abstract String a();

    public abstract WebView b();

    public abstract void c(String r1);

    @JavascriptInterface
    public final void appletPostMessage(String r10) {
        l5.w r0 = l5.w.b;
        String r1 = a();
        BridgeType r11 = BridgeType.V1;
        Intrinsics.checkNotNullParameter("appletPostMessageWebView", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        Intrinsics.checkNotNullParameter(r11, "type");
        com.bytedance.ai.monitor.b.b("applet_old_bridge", new l5.y("appletPostMessageWebView", r11, r1, null));
        c(r10);
    }

    public final void d(final String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_MSG);
        Runnable r0 = new f0(this, r10);
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r0.run();
        return;
    L5:
        p2.c.d(r0);
    }
}
