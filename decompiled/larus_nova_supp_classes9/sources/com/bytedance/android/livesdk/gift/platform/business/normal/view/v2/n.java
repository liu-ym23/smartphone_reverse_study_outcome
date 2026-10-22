package com.bytedance.android.livesdk.gift.platform.business.normal.view.v2;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class n<T> implements Consumer {
    public final /* synthetic */ p a;
    public final /* synthetic */ py.k b;

    public n(p r1, py.k r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r4) {
        Bitmap r5 = (Bitmap) r4;
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.isRecycled() == true) goto L9;
        this.a.setBackground(new BitmapDrawable(this.a.getResources(), r5));
        return;
    }
}
