package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.listener.RequestListener2;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class InternalProducerListener implements ProducerListener2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RequestListener f8316a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RequestListener2 f8317b;

    public InternalProducerListener(RequestListener r5, RequestListener2 r10) {
        this.f8316a = r5;
        this.f8317b = r10;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public final void a(ProducerContext r5, String r10) {
        RequestListener r11 = this.f8316a;
        if (r11 == null) goto L5;
        r11.a(((BaseProducerContext) r5).f8258b, r10);
    L5:
        RequestListener2 r12 = this.f8317b;
        if (r12 == null) goto L9;
        r12.a(r5, r10);
        return;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public final void b(ProducerContext r5) {
        RequestListener r10 = this.f8316a;
        if (r10 == null) goto L5;
        r10.a(((BaseProducerContext) r5).f8258b);
    L5:
        RequestListener2 r11 = this.f8317b;
        if (r11 == null) goto L9;
        r11.b(r5);
        return;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public final void a(ProducerContext r5, String r10, Map r11) {
        RequestListener r12 = this.f8316a;
        if (r12 == null) goto L5;
        r12.a(((BaseProducerContext) r5).f8258b, r10, r11);
    L5:
        RequestListener2 r13 = this.f8317b;
        if (r13 == null) goto L9;
        r13.a(r5, r10, r11);
        return;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public final boolean b(ProducerContext r5, String r10) {
        RequestListener r11 = this.f8316a;
        if (r11 == null) goto L5;
        boolean r12 = r11.b(((BaseProducerContext) r5).f8258b);
    L6:
        if (r12 == true) goto L11;
        RequestListener2 r13 = this.f8317b;
        if (r13 == null) goto L11;
        return r13.b(r5, r10);
    L11:
        return r12;
    L5:
        r12 = false;
        goto L6
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public final void a(ProducerContext r5, String r10, Throwable r11, Map r12) {
        RequestListener r13 = this.f8316a;
        if (r13 == null) goto L5;
        r13.a(((BaseProducerContext) r5).f8258b, r10, r11, r12);
    L5:
        RequestListener2 r14 = this.f8317b;
        if (r14 == null) goto L9;
        r14.a(r5, r10, r11, r12);
        return;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public final void a(ProducerContext r5, String r10, HashMap r11) {
        RequestListener r12 = this.f8316a;
        if (r12 == null) goto L5;
        r12.a(((BaseProducerContext) r5).f8258b, r10, r11);
    L5:
        RequestListener2 r13 = this.f8317b;
        if (r13 == null) goto L9;
        r13.a(r5, r10, r11);
        return;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public final void a(ProducerContext r5, String r10, boolean r11) {
        RequestListener r12 = this.f8316a;
        if (r12 == null) goto L5;
        r12.a(((BaseProducerContext) r5).f8258b, r10, r11);
    L5:
        RequestListener2 r13 = this.f8317b;
        if (r13 == null) goto L9;
        r13.a(r5, r10, r11);
        return;
    }
}
