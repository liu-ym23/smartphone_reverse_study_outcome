package com.bytedance.android.livesdk.gift.platform.business.sendGift;

import com.bytedance.bdlocation.BuildConfig;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k<T> implements Consumer {
    public final /* synthetic */ GiftTransaction a;
    public final /* synthetic */ String b;
    public final /* synthetic */ int c;

    public k(GiftTransaction r1, String r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r7) {
        Disposable r8 = (Disposable) r7;
        if (com.bytedance.android.livesdk.gift.platform.core.f.a().J4() == false) goto L6;
        com.bytedance.android.livesdk.gift.platform.core.utils.h.R(this.b, this.a.x, this.c, BuildConfig.FLAVOR, "1", -1);
        return;
    }
}
