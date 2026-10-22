package com.facebook.imagepipeline.listener;

import com.facebook.imagepipeline.producers.ProducerListener;
import com.facebook.imagepipeline.request.ImageRequest;

/* JADX INFO: loaded from: classes2.dex */
public interface RequestListener extends ProducerListener {
    void a(ImageRequest r5, Object r10, String r11, boolean r12);

    void a(ImageRequest r5, String r10, Throwable r11, boolean r12);

    void a(ImageRequest r5, String r10, boolean r11);

    void c(String r5);
}
