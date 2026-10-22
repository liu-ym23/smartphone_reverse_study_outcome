package com.bytedance.android.livesdk.chatroom.widget;

import android.graphics.Bitmap;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class z1<T> implements Consumer {
    public final /* synthetic */ PortraitQuickShotLayerWidget a;
    public final /* synthetic */ Bitmap b;

    public z1(PortraitQuickShotLayerWidget r1, Bitmap r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r2) {
        Long r3 = (Long) r2;
        Bitmap r4 = this.b;
        if (r4 == null) goto L6;
        PortraitQuickShotLayerWidget.xq(this.a, r4);
        return;
    }
}
