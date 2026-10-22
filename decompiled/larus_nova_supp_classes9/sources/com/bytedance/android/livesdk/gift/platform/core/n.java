package com.bytedance.android.livesdk.gift.platform.core;

import com.bytedance.android.livesdk.gift.platform.business.effect.widget.BaseVideoGiftWidget;
import com.bytedance.android.livesdk.message.model.i6;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class n<T> implements Observer {
    public final /* synthetic */ GiftWidgetKt a;

    public n(GiftWidgetKt r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        i6 r3 = (i6) r2;
        if (r3 == null) goto L8;
        BaseVideoGiftWidget r0 = this.a.e;
        if (r0 == null) goto L9;
        r0.Tq(r3);
        return;
    L9:
        return;
    }
}
