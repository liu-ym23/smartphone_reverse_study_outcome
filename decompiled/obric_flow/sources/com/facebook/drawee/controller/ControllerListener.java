package com.facebook.drawee.controller;

import android.graphics.drawable.Animatable;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: loaded from: classes2.dex */
public interface ControllerListener<INFO> {
    void a(String r5);

    void a(String r5, ImageInfo r10);

    void a(String r5, ImageInfo r10, Animatable r11);

    void a(String r5, Object r10);

    void a(String r5, Throwable r10);

    void b(String r5, Throwable r10);
}
