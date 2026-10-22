package com.bytedance.android.livesdk.feed.drawerfeed.viewholder;

import android.view.View;
import com.bytedance.android.live.base.model.ImageModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j0 implements View.OnLayoutChangeListener {
    public final /* synthetic */ ImageModel a;
    public final /* synthetic */ DrawerSmallLiveViewHolder b;

    public j0(DrawerSmallLiveViewHolder r1, ImageModel r2) {
        this.b = r1;
        this.a = r2;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        DrawerSmallLiveViewHolder r10 = this.b;
        int r11 = this.a.getWidth();
        int r12 = this.a.getHeight();
        int r13 = DrawerSmallLiveViewHolder.V;
        r10.q4(r11, r12);
    }
}
