package com.bytedance.android.livesdk.chatroom.widget.landscape;

import android.graphics.Bitmap;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ LandscapeQuickShotLayerWidget a;
    public final /* synthetic */ Bitmap b;

    public g(LandscapeQuickShotLayerWidget r1, Bitmap r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r2) {
        Long r3 = (Long) r2;
        LandscapeQuickShotLayerWidget.wq(this.a, this.b);
    }
}
