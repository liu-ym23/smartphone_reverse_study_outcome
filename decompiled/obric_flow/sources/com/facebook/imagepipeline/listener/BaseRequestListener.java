package com.facebook.imagepipeline.listener;

import com.facebook.imagepipeline.request.ImageRequest;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseRequestListener implements RequestListener {
    public BaseRequestListener() {
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener
    public void a(ImageRequest r5, Object r10, String r11, boolean r12) {
    }

    public void b(ImageRequest r5, String r10, boolean r11) {
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener
    public void c(String r5) {
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener
    public void a(ImageRequest r5, String r10, Throwable r11, boolean r12) {
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public boolean b(String r5) {
        return false;
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener
    public void a(ImageRequest r5, String r10, boolean r11) {
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public void a(String r5) {
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public void a(String r5, String r10) {
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public void a(String r5, String r10, Throwable r11, Map r12) {
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public void a(String r5, String r10, HashMap r11) {
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public void a(String r5, String r10, Map r11) {
    }
}
