package com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder;

import android.graphics.drawable.Animatable;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f extends BaseControllerListener<ImageInfo> {
    public final /* synthetic */ MultiLinkPaidViewBinder.ItemViewHolder a;
    public final /* synthetic */ ILinkPlayerInfoBridge b;

    public f(MultiLinkPaidViewBinder.ItemViewHolder r1, ILinkPlayerInfoBridge r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onFinalImageSet(String r2, Object r3, Animatable r4) {
        ImageInfo r5 = (ImageInfo) r3;
        MultiLinkPaidViewBinder.ItemViewHolder r6 = this.a;
        int r7 = MultiLinkPaidViewBinder.ItemViewHolder.h;
        boolean r0 = true;
        if (r6.g == true) goto L10;
        HSImageView r8 = r6.d;
        if (r8 != null) goto L7;
    L9:
        r0 = false;
        goto L10
    L7:
        if (r8.isAnimating() != true) goto L9;
    L10:
        if (r0 == false) goto L13;
        return;
    L13:
        if ((r4 instanceof AnimatedDrawable2) == false) goto L16;
        je0.b.a((AnimatedDrawable2) r4, new MultiLinkPaidViewBinder$ItemViewHolder$bind$2$onFinalImageSet$1(this));
        return;
    }
}
