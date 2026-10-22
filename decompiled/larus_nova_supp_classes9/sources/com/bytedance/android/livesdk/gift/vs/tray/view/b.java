package com.bytedance.android.livesdk.gift.vs.tray.view;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bytedance.android.live.revenue.common.RevBitmapTranslateUtils;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ VSGiftTrayAnimationView a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ ImageView c;

    public b(VSGiftTrayAnimationView r1, ImageView r2) {
        this.a = r1;
        this.b = true;
        this.c = r2;
    }

    public final void accept(Object r2) {
        Bitmap r3 = (Bitmap) r2;
        if (r3 != null) goto L6;
        return;
    L6:
        if (this.b == false) goto L8;
        Bitmap r4 = RevBitmapTranslateUtils.b(r3);
    L9:
        if (r4 != null) goto L11;
        return;
    L11:
        if (r4.isRecycled() == true) goto L20;
        ImageView r0 = this.c;
        if (r0 == null) goto L16;
        r0.setImageBitmap(r4);
    L16:
        this.a.invalidate();
        return;
    L20:
        return;
    L8:
        r4 = RevBitmapTranslateUtils.a(r3);
        goto L9
    }
}
