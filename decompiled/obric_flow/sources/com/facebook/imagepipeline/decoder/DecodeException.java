package com.facebook.imagepipeline.decoder;

import com.facebook.imagepipeline.image.EncodedImage;

/* JADX INFO: loaded from: classes2.dex */
public class DecodeException extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EncodedImage f8159a;

    public DecodeException(String r5, EncodedImage r10) {
        super(r5);
        this.f8159a = r10;
    }
}
