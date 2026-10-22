package com.bytedance.android.livesdk.chatroom.widget;

import android.graphics.Bitmap;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class y1 implements View.OnClickListener {
    public final /* synthetic */ Bitmap a;
    public final /* synthetic */ PortraitQuickShotLayerWidget b;

    public y1(Bitmap r1, PortraitQuickShotLayerWidget r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        PortraitQuickShotLayerWidget.xq(this.b, this.a);
    }
}
