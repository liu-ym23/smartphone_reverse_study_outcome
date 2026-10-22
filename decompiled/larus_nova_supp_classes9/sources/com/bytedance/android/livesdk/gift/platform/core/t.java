package com.bytedance.android.livesdk.gift.platform.core;

import androidx.lifecycle.Observer;
import com.bytedance.android.livesdk.gift.platform.business.effect.widget.BaseVideoGiftWidget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class t<T> implements Observer {
    public final /* synthetic */ GiftWidgetKt a;

    public t(GiftWidgetKt r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        gm2.g r3 = (gm2.g) r2;
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.getGiftMessage() == null) goto L11;
        BaseVideoGiftWidget r0 = this.a.e;
        if (r0 == null) goto L12;
        r0.Yq(r3);
        return;
    L12:
        return;
    }
}
