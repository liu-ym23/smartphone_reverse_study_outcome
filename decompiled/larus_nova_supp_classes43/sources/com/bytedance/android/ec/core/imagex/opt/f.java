package com.bytedance.android.ec.core.imagex.opt;

import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f implements RequestListener {
    public final /* synthetic */ RequestListener a;

    public final void onRequestFailure(ImageRequest r1, String r10, Throwable r11, boolean r12) {
    }

    public f(RequestListener r1) {
        this.a = r1;
    }

    public final void onRequestCancellation(String r10) {
        this.a.onRequestCancellation(r10);
    }

    public final boolean requiresExtraMap(String r10) {
        return this.a.requiresExtraMap(r10);
    }

    public final void onProducerStart(String r10, String r11) {
        this.a.onProducerStart(r10, r11);
    }

    public final void onProducerEvent(String r10, String r11, String r12) {
        this.a.onProducerEvent(r10, r11, r12);
    }

    public final void onProducerFinishWithCancellation(String r10, String r11, Map<String, String> r12) {
        this.a.onProducerFinishWithCancellation(r10, r11, r12);
    }

    public final void onProducerFinishWithSuccess(String r10, String r11, Map<String, String> r12) {
        this.a.onProducerFinishWithSuccess(r10, r11, r12);
    }

    public final void onRequestSuccess(ImageRequest r10, String r11, boolean r12) {
        this.a.onRequestSuccess(r10, r11, r12);
    }

    public final void onUltimateProducerReached(String r10, String r11, boolean r12) {
        this.a.onUltimateProducerReached(r10, r11, r12);
    }

    public final void onProducerFinishWithFailure(String r10, String r11, Throwable r12, Map<String, String> r13) {
        this.a.onProducerFinishWithFailure(r10, r11, r12, r13);
    }

    public final void onRequestStart(ImageRequest r10, Object r11, String r12, boolean r13) {
        this.a.onRequestStart(r10, r11, r12, r13);
    }
}
