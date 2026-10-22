package com.bytedance.android.debug;

import com.bytedance.android.livesdk.downloader.GiftResourceManagerFactory;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.multiresource.DefaultResourceSupport;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class i extends DefaultResourceSupport {
    public i() {
    }

    public final boolean a(com.bytedance.android.live.core.resources.e r10) {
        Iterator r11 = ((ArrayList) b(r10, 0)).iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r1 = (com.bytedance.android.livesdk.gift.platform.business.effect.assets.e) r11.next();
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e r12 = GiftResourceManagerFactory.a();
        if (r12 == null) goto L4;
        if (r12.e(r1) != true) goto L4;
        return true;
    L10:
        return false;
    }

    public final boolean d(com.bytedance.android.live.core.resources.e r10) {
        if (DefaultResourceSupport.h(r10) == false) goto L5;
    L8:
        return true;
    L5:
        if (DefaultResourceSupport.i(r10) == true) goto L8;
        return false;
    }

    public final List<com.bytedance.android.livesdk.gift.platform.business.effect.assets.e> b(com.bytedance.android.live.core.resources.e r10, int r11) {
        ArrayList r0 = new ArrayList();
        c12.e r1 = e(r10, r11);
        if (r1 == null) goto L5;
        r0.add(r1);
    L5:
        c12.n r12 = f(r10, r11);
        if (r12 == null) goto L8;
        r0.add(r12);
    L8:
        c12.e r13 = g(r10, r11);
        if (r13 == null) goto L11;
        r0.add(r13);
    L11:
        return r0;
    }

    public final c12.e c(com.bytedance.android.live.core.resources.e r10, int r11) {
        if (r11 != 10) goto L7;
        return e(r10, 2);
    L7:
        if (r11 != 20) goto L11;
        return f(r10, 2);
    L11:
        if (r11 == 30) goto L13;
        return null;
    L13:
        return g(r10, 2);
    }
}
