package com.bytedance.android.livesdk.gift.vs.tray.view;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revenue.common.RevBitmapTranslateUtils;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ VSGiftTrayAnimationView a;

    public a(VSGiftTrayAnimationView r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Bitmap r4 = (Bitmap) r3;
        int r0 = (int) s1.e(40.0f);
        if (r4 != null) goto L5;
        Bitmap r5 = VSGiftTrayAnimationView.c(BitmapFactory.decodeResource(this.a.getResources(), 2131250964), r0, r0);
    L9:
        if (r5 != null) goto L11;
        return;
    L11:
        if (r5.isRecycled() == true) goto L16;
        VSGiftTrayAnimationView.b(this.a).a(r5);
        return;
    L16:
        return;
    L5:
        Bitmap r6 = RevBitmapTranslateUtils.a(r4);
        if (r6 == null) goto L8;
        this.a.getClass();
        r5 = VSGiftTrayAnimationView.c(r6, r0, r0);
        goto L9
    L8:
        r5 = null;
        goto L9
    }
}
