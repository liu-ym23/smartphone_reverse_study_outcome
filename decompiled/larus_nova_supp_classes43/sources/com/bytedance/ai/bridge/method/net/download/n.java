package com.bytedance.ai.bridge.method.net.download;

import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.app.foundation.v;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import d3.a0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class n {
    public static final a a(e3.d r10) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        a0 r11 = r10.getContainerContext();
        if (r11 == null) goto L21;
        String r12 = r11.getAppletId();
        if (r12 != null) goto L7;
        return null;
    L7:
        if (r12.length() <= 0) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == true) goto L13;
        r12 = null;
    L13:
        if (r12 == null) goto L25;
        AppletAppManagerService.INSTANCE.getClass();
        AppletApplication r13 = AppletAppManagerService.a(r12);
        if (r13 == null) goto L23;
        v r14 = r13.h();
        if (r14 != null) goto L20;
        return null;
    L20:
        return (a) r14.k.getValue();
    L23:
        return null;
    L25:
        return null;
    L9:
        r1 = false;
        goto L10
    L21:
        return null;
    }
}
