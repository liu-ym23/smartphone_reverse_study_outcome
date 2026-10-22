package com.bytedance.android.livesdk.gift.platform.core;

import com.bytedance.android.livesdk.gift.platform.business.tray.GiftTrayWidget;
import com.bytedance.android.livesdk.message.model.o7;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class p<T> implements Observer {
    public final /* synthetic */ GiftWidgetKt a;

    public p(GiftWidgetKt r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        o7 r3 = (o7) r2;
        if (r3 == null) goto L8;
        GiftTrayWidget r0 = this.a.g;
        if (r0 == null) goto L9;
        r0.gm(r3);
        return;
    L9:
        return;
    }
}
