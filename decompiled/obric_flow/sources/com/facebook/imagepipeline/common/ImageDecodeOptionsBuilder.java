package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.common.ImageDecodeOptionsBuilder;
import com.facebook.imagepipeline.decoder.ImageDecoder;

/* JADX INFO: loaded from: classes2.dex */
public class ImageDecodeOptionsBuilder<T extends ImageDecodeOptionsBuilder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8045a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Bitmap.Config f8046b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageDecoder f8047c;
    public boolean d;

    public ImageDecodeOptionsBuilder() {
        this.f8045a = 0;
        this.f8046b = Bitmap.Config.ARGB_8888;
    }

    public ImageDecodeOptionsBuilder a(int r5) {
        this.f8045a = r5;
        return this;
    }
}
