package com.bytedance.android.debug;

import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.revenue.common.c0;
import com.bytedance.android.livesdk.downloader.GiftResourceManagerFactory;
import com.bytedance.android.livesdk.gift.platform.core.a0;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.reactivex.functions.Consumer;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ DebugAssetsManager a;
    public final /* synthetic */ List b;

    public d(DebugAssetsManager r1, List r10) {
        this.a = r1;
        this.b = r10;
    }

    public final void accept(Object r10) {
        Integer r11 = (Integer) r10;
        long r12 = ((Number) ay1.b.K.getValue(null, ay1.b.a[42])).longValue();
        if (((Boolean) a0.l.getValue(null, a0.a[10])).booleanValue() == false) goto L8;
        if ((System.currentTimeMillis() - r12) >= 86400000) goto L8;
        return;
    L8:
        if (r12 != 0) goto L10;
        ay1.b.w(System.currentTimeMillis());
    L10:
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e r13 = GiftResourceManagerFactory.a();
        if (r13 == null) goto L15;
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.cache.a r14 = r13.a();
        if (r14 == null) goto L15;
        String r15 = r14.a();
    L16:
        if (r15 == null) goto L56;
        PolarisFileWrapper r0 = new PolarisFileWrapper(r15);
        if (r0.exists() == true) goto L21;
        ALogger.e("AssetsManager", "delete useless resource failed: not found root path: ".concat(r15), null);
        return;
    L21:
        File[] r16 = r0.listFiles();
        int r1 = r16.length;
        int r17 = 0;
    L22:
        if (r17 >= r1) goto L40;
        File r18 = r16[r17];
        if (r18.exists() == false) goto L39;
        String r19 = r18.getName();
        Iterator r20 = this.b.iterator();
    L28:
        if (r20.hasNext() == false) goto L36;
        com.bytedance.android.live.core.resources.e r21 = (com.bytedance.android.live.core.resources.e) r20.next();
        if (gz1.a.b(r21, r19) == false) goto L28;
        c12.e r22 = this.a.e.c(r21, 0);
        if (r22 == null) goto L28;
        if (TextUtils.equals(r19, ((com.bytedance.android.livesdk.gift.platform.business.effect.assets.e) r22).k) == false) goto L28;
        boolean r23 = false;
    L37:
        if (r23 == false) goto L39;
        c0.b(r18);
        goto L39
    L36:
        r23 = true;
    L39:
        r17 = r17 + 1;
        goto L22
    L40:
        ay1.b.w(System.currentTimeMillis());
        return;
    L56:
        return;
    L15:
        r15 = null;
        goto L16
    }
}
