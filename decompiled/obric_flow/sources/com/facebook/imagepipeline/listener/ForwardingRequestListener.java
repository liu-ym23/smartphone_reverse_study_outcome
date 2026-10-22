package com.facebook.imagepipeline.listener;

import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class ForwardingRequestListener extends BaseRequestListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f8194a;

    public ForwardingRequestListener(Set r5) {
        this.f8194a = new ArrayList(r5.size());
        Iterator r10 = r5.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        RequestListener r11 = (RequestListener) r10.next();
        if (r11 == null) goto L4;
        this.f8194a.add(r11);
        goto L4
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
    public final void a(ImageRequest r10, Object r11, String r12, boolean r13) {
        int r5 = this.f8194a.size();
        int r14 = 0;
    L3:
        if (r14 >= r5) goto L10;
        ((RequestListener) this.f8194a.get(r14)).a(r10, r11, r12, r13);     // Catch: Exception -> L7
    L9:
        r14 = r14 + 1;
    L7:
        e = move-exception;
        FLog.a("ForwardingRequestListener", "InternalListener exception in onRequestStart", e);
        goto L9
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener
    public final void b(ImageRequest r10, String r11, boolean r12) {
        int r5 = this.f8194a.size();
        int r13 = 0;
    L3:
        if (r13 >= r5) goto L12;
        RequestListener r14 = (RequestListener) this.f8194a.get(r13);
    L9:
        e = move-exception;
        FLog.a("ForwardingRequestListener", "InternalListener exception in onRequestIntermediateResult", e);
    L11:
        r13 = r13 + 1;
        goto L3
    L6:
        if ((r14 instanceof BaseRequestListener) == false) goto L11;
        ((BaseRequestListener) r14).b(r10, r11, r12);     // Catch: Exception -> L9
        goto L11
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
    public final void c(String r10) {
        int r5 = this.f8194a.size();
        int r11 = 0;
    L3:
        if (r11 >= r5) goto L10;
        ((RequestListener) this.f8194a.get(r11)).c(r10);     // Catch: Exception -> L7
    L9:
        r11 = r11 + 1;
    L7:
        e = move-exception;
        FLog.a("ForwardingRequestListener", "InternalListener exception in onRequestCancellation", e);
        goto L9
    }

    public ForwardingRequestListener(RequestListener... r5) {
        this.f8194a = new ArrayList(r5.length);
        int r10 = r5.length;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L8;
        RequestListener r12 = r5[r11];
        if (r12 == null) goto L7;
        this.f8194a.add(r12);
    L7:
        r11 = r11 + 1;
        goto L3
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.producers.ProducerListener
    public final void a(String r10, String r11) {
        int r5 = this.f8194a.size();
        int r12 = 0;
    L3:
        if (r12 >= r5) goto L10;
        ((RequestListener) this.f8194a.get(r12)).a(r10, r11);     // Catch: Exception -> L7
    L9:
        r12 = r12 + 1;
    L7:
        e = move-exception;
        FLog.a("ForwardingRequestListener", "InternalListener exception in onProducerStart", e);
        goto L9
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.producers.ProducerListener
    public final boolean b(String r5) {
        int r10 = this.f8194a.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L9;
        if (((RequestListener) this.f8194a.get(r11)).b(r5) == true) goto L6;
        r11 = r11 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.producers.ProducerListener
    public final void a(String r10, String r11, Map r12) {
        int r5 = this.f8194a.size();
        int r13 = 0;
    L3:
        if (r13 >= r5) goto L10;
        ((RequestListener) this.f8194a.get(r13)).a(r10, r11, r12);     // Catch: Exception -> L7
    L9:
        r13 = r13 + 1;
    L7:
        e = move-exception;
        FLog.a("ForwardingRequestListener", "InternalListener exception in onProducerFinishWithSuccess", e);
        goto L9
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.producers.ProducerListener
    public final void a(String r10, String r11, Throwable r12, Map r13) {
        int r5 = this.f8194a.size();
        int r14 = 0;
    L3:
        if (r14 >= r5) goto L10;
        ((RequestListener) this.f8194a.get(r14)).a(r10, r11, r12, r13);     // Catch: Exception -> L7
    L9:
        r14 = r14 + 1;
    L7:
        e = move-exception;
        FLog.a("ForwardingRequestListener", "InternalListener exception in onProducerFinishWithFailure", e);
        goto L9
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.producers.ProducerListener
    public final void a(String r10, String r11, HashMap r12) {
        int r5 = this.f8194a.size();
        int r13 = 0;
    L3:
        if (r13 >= r5) goto L10;
        ((RequestListener) this.f8194a.get(r13)).a(r10, r11, r12);     // Catch: Exception -> L7
    L9:
        r13 = r13 + 1;
    L7:
        e = move-exception;
        FLog.a("ForwardingRequestListener", "InternalListener exception in onProducerFinishWithCancellation", e);
        goto L9
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.producers.ProducerListener
    public final void a(String r10) {
        int r5 = this.f8194a.size();
        int r11 = 0;
    L3:
        if (r11 >= r5) goto L10;
        ((RequestListener) this.f8194a.get(r11)).a(r10);     // Catch: Exception -> L7
    L9:
        r11 = r11 + 1;
    L7:
        e = move-exception;
        FLog.a("ForwardingRequestListener", "InternalListener exception in onIntermediateChunkStart", e);
        goto L9
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public final void a(String r10, String r11, boolean r12) {
        int r5 = this.f8194a.size();
        int r13 = 0;
    L3:
        if (r13 >= r5) goto L10;
        ((RequestListener) this.f8194a.get(r13)).a(r10, r11, r12);     // Catch: Exception -> L7
    L9:
        r13 = r13 + 1;
    L7:
        e = move-exception;
        FLog.a("ForwardingRequestListener", "InternalListener exception in onProducerFinishWithSuccess", e);
        goto L9
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
    public final void a(ImageRequest r10, String r11, boolean r12) {
        int r5 = this.f8194a.size();
        int r13 = 0;
    L3:
        if (r13 >= r5) goto L10;
        ((RequestListener) this.f8194a.get(r13)).a(r10, r11, r12);     // Catch: Exception -> L7
    L9:
        r13 = r13 + 1;
    L7:
        e = move-exception;
        FLog.a("ForwardingRequestListener", "InternalListener exception in onRequestSuccess", e);
        goto L9
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
    public final void a(ImageRequest r10, String r11, Throwable r12, boolean r13) {
        int r5 = this.f8194a.size();
        int r14 = 0;
    L3:
        if (r14 >= r5) goto L10;
        ((RequestListener) this.f8194a.get(r14)).a(r10, r11, r12, r13);     // Catch: Exception -> L7
    L9:
        r14 = r14 + 1;
    L7:
        e = move-exception;
        FLog.a("ForwardingRequestListener", "InternalListener exception in onRequestFailure", e);
        goto L9
    }
}
