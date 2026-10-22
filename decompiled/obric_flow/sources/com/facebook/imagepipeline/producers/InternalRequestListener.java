package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.listener.ForwardingRequestListener;
import com.facebook.imagepipeline.listener.ForwardingRequestListener2;
import com.facebook.imagepipeline.listener.RequestListener2;
import com.facebook.imagepipeline.request.ImageRequest;

/* JADX INFO: loaded from: classes2.dex */
public class InternalRequestListener extends InternalProducerListener implements RequestListener2 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ForwardingRequestListener f8318c;
    public final ForwardingRequestListener2 d;

    public InternalRequestListener(ForwardingRequestListener r5, ForwardingRequestListener2 r10) {
        super(r5, r10);
        this.f8318c = r5;
        this.d = r10;
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener2
    public final void a(SettableProducerContext r10) {
        ForwardingRequestListener r5 = this.f8318c;
        if (r5 == null) goto L12;
        ImageRequest r11 = r10.f8257a;
        Object r12 = r10.e;
        String r13 = r10.f8258b;
        monitor-enter(r10);
        boolean r14 = r10.f8260h;     // Catch: Throwable -> L9
        monitor-exit(r10);     // Catch: Throwable -> L9
        r5.a(r11, r12, r13, r14);
    L9:
        th = move-exception;
        throw th;
    L12:
        ForwardingRequestListener2 r15 = this.d;
        if (r15 == null) goto L18;
        r15.a(r10);
        return;
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener2
    public final void c(ProducerContext r10) {
        ForwardingRequestListener r5 = this.f8318c;
        if (r5 == null) goto L12;
        BaseProducerContext r11 = (BaseProducerContext) r10;
        ImageRequest r12 = r11.f8257a;
        String r13 = r11.f8258b;
        monitor-enter(r11);
        boolean r14 = r11.f8260h;     // Catch: Throwable -> L9
        monitor-exit(r11);     // Catch: Throwable -> L9
        r5.a(r12, r13, r14);
    L9:
        th = move-exception;
        throw th;
    L12:
        ForwardingRequestListener2 r15 = this.d;
        if (r15 == null) goto L18;
        r15.c(r10);
        return;
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener2
    public final void a(ProducerContext r10, Throwable r11) {
        ForwardingRequestListener r5 = this.f8318c;
        if (r5 == null) goto L12;
        BaseProducerContext r12 = (BaseProducerContext) r10;
        ImageRequest r13 = r12.f8257a;
        String r14 = r12.f8258b;
        monitor-enter(r12);
        boolean r15 = r12.f8260h;     // Catch: Throwable -> L9
        monitor-exit(r12);     // Catch: Throwable -> L9
        r5.a(r13, r14, r11, r15);
    L9:
        th = move-exception;
        throw th;
    L12:
        ForwardingRequestListener2 r16 = this.d;
        if (r16 == null) goto L18;
        r16.a(r10, r11);
        return;
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener2
    public final void a(ProducerContext r5) {
        ForwardingRequestListener r10 = this.f8318c;
        if (r10 == null) goto L5;
        r10.c(((BaseProducerContext) r5).f8258b);
    L5:
        ForwardingRequestListener2 r11 = this.d;
        if (r11 == null) goto L9;
        r11.a(r5);
        return;
    }
}
