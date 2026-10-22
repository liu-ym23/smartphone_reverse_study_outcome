package com.bytedance.android.livesdk.chatroom.widget.landscape;

import android.graphics.Bitmap;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f implements View.OnClickListener {
    public final /* synthetic */ LandscapeQuickShotLayerWidget a;
    public final /* synthetic */ Bitmap b;

    public f(LandscapeQuickShotLayerWidget r1, Bitmap r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        LandscapeQuickShotLayerWidget.wq(this.a, this.b);
    }
}
