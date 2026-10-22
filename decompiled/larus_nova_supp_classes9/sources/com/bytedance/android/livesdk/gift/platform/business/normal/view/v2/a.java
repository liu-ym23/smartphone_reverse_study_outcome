package com.bytedance.android.livesdk.gift.platform.business.normal.view.v2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revenue.common.RevBitmapTranslateUtils;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ GamePlatformGiftCombView a;

    public a(GamePlatformGiftCombView r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Bitmap r5 = (Bitmap) r4;
        int r0 = (int) s1.e(24.0f);
        if (r5 != null) goto L5;
    L8:
        GamePlatformGiftCombView r6 = this.a;
        Bitmap r7 = r6.q(BitmapFactory.decodeResource(r6.getResources(), 2131250964), r0, r0);
    L9:
        if (r7 != null) goto L11;
        return;
    L11:
        if (r7.isRecycled() == true) goto L19;
        GiftIconMaskView r1 = (GiftIconMaskView) this.a.o(2131373725);
        if (r1 == null) goto L18;
        r1.a(r7);
        return;
    L18:
        return;
    L19:
        return;
    L5:
        if (r5.isRecycled() == true) goto L8;
        r7 = this.a.q(RevBitmapTranslateUtils.a(r5), r0, r0);
        goto L9
    }
}
