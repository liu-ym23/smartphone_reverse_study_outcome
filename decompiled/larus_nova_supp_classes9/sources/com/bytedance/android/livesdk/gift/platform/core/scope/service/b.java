package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.android.livesdk.gift.platform.business.effect.assets.CleanDataSource;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ AssetsDeleteGlobalService a;

    public b(AssetsDeleteGlobalService r1) {
        this.a = r1;
    }

    public final void accept(Object r8) {
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator r9 = ((Map) r8).entrySet().iterator();
    L4:
        if (r9.hasNext() == false) goto L13;
        Map.Entry r1 = (Map.Entry) r9.next();
        long r2 = ((Number) r1.getKey()).longValue();
        com.bytedance.android.live.core.resources.e r3 = (com.bytedance.android.live.core.resources.e) r1.getValue();
        Long r4 = Long.valueOf(r2);
        String r5 = r3.getMD5();
        com.bytedance.android.live.core.resources.j r6 = r3.getH265ResourceModel();
        String r7 = null;
        if (r6 == null) goto L8;
        String r10 = r6.getMd5();
    L9:
        com.bytedance.android.live.core.resources.k r11 = r3.getH265SuperResourceModel();
        if (r11 == null) goto L12;
        r7 = r11.getMd5();
    L12:
        r0.put(r4, new com.bytedance.android.livesdk.gift.platform.business.effect.assets.a(r5, r10, r7));
        goto L4
    L8:
        r10 = null;
        goto L9
    L13:
        this.a.a(r0, CleanDataSource.NET);
    }
}
