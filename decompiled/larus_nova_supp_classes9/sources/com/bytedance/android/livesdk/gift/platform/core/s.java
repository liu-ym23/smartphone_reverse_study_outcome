package com.bytedance.android.livesdk.gift.platform.core;

import com.bytedance.android.livesdk.gift.platform.business.effect.widget.BaseVideoGiftWidget;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class s<T> implements Observer {
    public final /* synthetic */ GiftWidgetKt a;

    public s(GiftWidgetKt r1) {
        this.a = r1;
    }

    public final void onChanged(Object r5) {
        Long r6 = (Long) r5;
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.longValue() <= 0) goto L11;
        BaseVideoGiftWidget r7 = this.a.e;
        if (r7 == null) goto L12;
        r7.Eq();
        return;
    L12:
        return;
    }
}
