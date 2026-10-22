package com.bytedance.android.live.liveinteract.revenue.game.layer;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import com.bytedance.android.live.core.widget.HSImageView;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b extends BaseControllerListener<ImageInfo> {
    public final /* synthetic */ a a;

    public b(a r1) {
        this.a = r1;
    }

    public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
        ImageInfo r4 = (ImageInfo) r2;
        HSImageView r5 = this.a.h;
        if (r5 == null) goto L8;
        Drawable r6 = r5.getBackground();
        if (r6 == null) goto L9;
        r6.setAlpha(0);
        return;
    L9:
        return;
    }
}
