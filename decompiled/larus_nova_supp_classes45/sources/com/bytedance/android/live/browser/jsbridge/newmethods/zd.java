package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.live.core.log.ALogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class zd {
    public vlc.d a;
    public final com.bytedance.ies.web.jsbridge2.d0 b;
    public final IHybridComponent c;

    public static final void a(zd r3) {
        r3.getClass();
        StringBuilder r0 = new StringBuilder("release message: ");
        vlc.d r1 = r3.a;
        if (r1 == null) goto L5;
        Integer r2 = Integer.valueOf(r1.hashCode());
    L6:
        r0.append(r2);
        b(r0.toString());
        vlc.d r4 = r3.a;
        if (r4 == null) goto L9;
        r4.release();
    L9:
        r3.a = null;
        return;
    L5:
        r2 = null;
        goto L6
    }

    public static void b(String r1) {
        ALogger.i("VenueMessageMethods", r1);
    }

    public zd(com.bytedance.ies.web.jsbridge2.d0 r1, IHybridComponent r2) {
        this.b = r1;
        this.c = r2;
    }
}
