package com.lynx.tasm.ui.image;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: loaded from: classes2.dex */
public final class j0 extends BaseControllerListener {
    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void a(String r5, ImageInfo r10, Animatable r11) {
        if (r11 == null) goto L5;
        r11.start();
        return;
    }
}
