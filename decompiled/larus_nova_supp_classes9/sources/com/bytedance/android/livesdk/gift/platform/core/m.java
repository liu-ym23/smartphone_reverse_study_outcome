package com.bytedance.android.livesdk.gift.platform.core;

import com.bytedance.android.livesdk.gift.platform.business.effect.widget.BaseVideoGiftWidget;
import com.bytedance.android.livesdk.message.model.k6;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m<T> implements Observer {
    public final /* synthetic */ GiftWidgetKt a;

    public m(GiftWidgetKt r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        k6 r3 = (k6) r2;
        if (r3 == null) goto L8;
        BaseVideoGiftWidget r0 = this.a.e;
        if (r0 == null) goto L9;
        r0.Sq(r3);
        return;
    L9:
        return;
    }
}
