package com.bytedance.android.livesdk.gift.platform.core;

import com.bytedance.android.livesdk.gift.configmodel.x1;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.k3;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.m3;
import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class w<T> implements Consumer {
    public static final w a = null;

    static {
        a = new w();
    }

    public w() {
    }

    public final void accept(Object r9) {
        Long r10 = (Long) r9;
        m3 r11 = (m3) com.bytedance.android.live.revenue.core.util.f.a(m3.class);
        x1 r0 = (x1) com.bytedance.android.livesdk.gift.platform.business.b.L.getValue(null, com.bytedance.android.livesdk.gift.platform.business.b.a[36]);
        if (r0.b() == false) goto L13;
        List<String> r1 = r0.a();
        if (r1 == null) goto L11;
        long r2 = System.currentTimeMillis();
        long r4 = IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW;
        if (((r2 / r4) - r11.a) <= r0.d()) goto L12;
        r11.a = System.currentTimeMillis() / r4;
        com.bytedance.android.livesdk.revenue.service.effect.c r3 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.effect.c.class);
        r3.U9(r1, new k3(r3, r11));
        return;
    L12:
        return;
    L11:
        return;
    }
}
