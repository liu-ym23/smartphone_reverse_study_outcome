package com.bytedance.android.livesdk.gift.platform.business.normal.view.v2;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ NormalGiftCombViewV2 a;

    public h(NormalGiftCombViewV2 r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        Long r2 = (Long) r1;
        com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.animation.k r3 = this.a.C;
        if (r3 == null) goto L6;
        r3.a();
        return;
    }
}
