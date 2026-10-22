package com.facebook.drawee.debug.listener;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.debug.DebugControllerOverlayDrawable;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: loaded from: classes2.dex */
public class ImageLoadingTimeControllerListener extends BaseControllerListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f7827b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DebugControllerOverlayDrawable f7828c;

    public ImageLoadingTimeControllerListener(DebugControllerOverlayDrawable r5) {
        this.f7827b = -1;
        this.f7828c = r5;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void a(String r5, Object r10) {
        this.f7827b = System.currentTimeMillis();
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void a(String r5, ImageInfo r10, Animatable r11) {
        long r12 = System.currentTimeMillis();
        DebugControllerOverlayDrawable r13 = this.f7828c;
        r13.s = r12 - this.f7827b;
        r13.invalidateSelf();
    }
}
