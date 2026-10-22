package com.bytedance.android.livesdk.gift.platform.core;

import com.bytedance.android.livesdk.gift.platform.business.effect.widget.BaseVideoGiftWidget;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import zg1.h2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class u<T> implements Observer {
    public final /* synthetic */ GiftWidgetKt a;

    public u(GiftWidgetKt r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        h2 r3 = (h2) r2;
        BaseVideoGiftWidget r0 = this.a.e;
        if (r0 == null) goto L6;
        r0.Rq(r3);
        return;
    }
}
