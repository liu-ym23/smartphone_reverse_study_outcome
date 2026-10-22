package com.bytedance.android.live.pushstream;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;
import uf2.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ LiveStream4 a;

    public h(LiveStream4 r1) {
        this.a = r1;
    }

    public final void accept(Object r8) {
        Bitmap r0 = (Bitmap) r8;
        if (r0 != null) goto L5;
    L10:
        ALogger.e("LiveStream", "addPauseBackground bitmap error!");
        return;
    L5:
        if (r0.isRecycled() == true) goto L10;
        Matrix r5 = new Matrix();
        r5.setScale(1.0f, -1.0f);
        Bitmap.createBitmap(r0, 0, 0, r0.getWidth(), r0.getHeight(), r5, true);
        d0 r9 = this.a.h;
        if (r9 == null) goto L12;
        r9.M();
        return;
    }
}
