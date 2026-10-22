package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.graphics.drawable.Animatable;
import com.bytedance.android.live.core.widget.HSImageView;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b4 extends BaseControllerListener<ImageInfo> {
    public final /* synthetic */ c4 a;

    public b4(c4 r1) {
        this.a = r1;
    }

    public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
        ImageInfo r4 = (ImageInfo) r2;
        HSImageView r5 = this.a.g;
        if (r5 == null) goto L6;
        r5.setVisibility(8);
        return;
    }
}
