package com.facebook.imagepipeline.listener;

import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.imagepipeline.producers.SettableProducerContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class ForwardingRequestListener2 implements RequestListener2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f8195a;

    public ForwardingRequestListener2(Set r5) {
        this.f8195a = new ArrayList(r5.size());
        Iterator r10 = r5.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        RequestListener2 r11 = (RequestListener2) r10.next();
        if (r11 == null) goto L4;
        this.f8195a.add(r11);
        goto L4
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener2
    public final void a(SettableProducerContext r10) {
        int r5 = this.f8195a.size();
        int r11 = 0;
    L3:
        if (r11 >= r5) goto L10;
        ((RequestListener2) this.f8195a.get(r11)).a(r10);     // Catch: Exception -> L7
    L9:
        r11 = r11 + 1;
    L7:
        e = move-exception;
        FLog.a("ForwardingRequestListener2", "InternalListener exception in onRequestStart", e);
        goto L9
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public final void b(ProducerContext r10) {
        int r5 = this.f8195a.size();
        int r11 = 0;
    L3:
        if (r11 >= r5) goto L10;
        ((RequestListener2) this.f8195a.get(r11)).b(r10);     // Catch: Exception -> L7
    L9:
        r11 = r11 + 1;
    L7:
        e = move-exception;
        FLog.a("ForwardingRequestListener2", "InternalListener exception in onIntermediateChunkStart", e);
        goto L9
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener2
    public final void c(ProducerContext r10) {
        int r5 = this.f8195a.size();
        int r11 = 0;
    L3:
        if (r11 >= r5) goto L10;
        ((RequestListener2) this.f8195a.get(r11)).c(r10);     // Catch: Exception -> L7
    L9:
        r11 = r11 + 1;
    L7:
        e = move-exception;
        FLog.a("ForwardingRequestListener2", "InternalListener exception in onRequestSuccess", e);
        goto L9
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public final void a(ProducerContext r10, String r11) {
        int r5 = this.f8195a.size();
        int r12 = 0;
    L3:
        if (r12 >= r5) goto L10;
        ((RequestListener2) this.f8195a.get(r12)).a(r10, r11);     // Catch: Exception -> L7
    L9:
        r12 = r12 + 1;
    L7:
        e = move-exception;
        FLog.a("ForwardingRequestListener2", "InternalListener exception in onProducerStart", e);
        goto L9
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public final boolean b(ProducerContext r5, String r10) {
        int r11 = this.f8195a.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L9;
        if (((RequestListener2) this.f8195a.get(r12)).b(r5, r10) == true) goto L6;
        r12 = r12 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public final void a(ProducerContext r10, String r11, Map r12) {
        int r5 = this.f8195a.size();
        int r13 = 0;
    L3:
        if (r13 >= r5) goto L10;
        ((RequestListener2) this.f8195a.get(r13)).a(r10, r11, r12);     // Catch: Exception -> L7
    L9:
        r13 = r13 + 1;
    L7:
        e = move-exception;
        FLog.a("ForwardingRequestListener2", "InternalListener exception in onProducerFinishWithSuccess", e);
        goto L9
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public final void a(ProducerContext r10, String r11, Throwable r12, Map r13) {
        int r5 = this.f8195a.size();
        int r14 = 0;
    L3:
        if (r14 >= r5) goto L10;
        ((RequestListener2) this.f8195a.get(r14)).a(r10, r11, r12, r13);     // Catch: Exception -> L7
    L9:
        r14 = r14 + 1;
    L7:
        e = move-exception;
        FLog.a("ForwardingRequestListener2", "InternalListener exception in onProducerFinishWithFailure", e);
        goto L9
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public final void a(ProducerContext r10, String r11, HashMap r12) {
        int r5 = this.f8195a.size();
        int r13 = 0;
    L3:
        if (r13 >= r5) goto L10;
        ((RequestListener2) this.f8195a.get(r13)).a(r10, r11, r12);     // Catch: Exception -> L7
    L9:
        r13 = r13 + 1;
    L7:
        e = move-exception;
        FLog.a("ForwardingRequestListener2", "InternalListener exception in onProducerFinishWithCancellation", e);
        goto L9
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public final void a(ProducerContext r10, String r11, boolean r12) {
        int r5 = this.f8195a.size();
        int r13 = 0;
    L3:
        if (r13 >= r5) goto L10;
        ((RequestListener2) this.f8195a.get(r13)).a(r10, r11, r12);     // Catch: Exception -> L7
    L9:
        r13 = r13 + 1;
    L7:
        e = move-exception;
        FLog.a("ForwardingRequestListener2", "InternalListener exception in onProducerFinishWithSuccess", e);
        goto L9
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener2
    public final void a(ProducerContext r10, Throwable r11) {
        int r5 = this.f8195a.size();
        int r12 = 0;
    L3:
        if (r12 >= r5) goto L10;
        ((RequestListener2) this.f8195a.get(r12)).a(r10, r11);     // Catch: Exception -> L7
    L9:
        r12 = r12 + 1;
    L7:
        e = move-exception;
        FLog.a("ForwardingRequestListener2", "InternalListener exception in onRequestFailure", e);
        goto L9
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener2
    public final void a(ProducerContext r10) {
        int r5 = this.f8195a.size();
        int r11 = 0;
    L3:
        if (r11 >= r5) goto L10;
        ((RequestListener2) this.f8195a.get(r11)).a(r10);     // Catch: Exception -> L7
    L9:
        r11 = r11 + 1;
    L7:
        e = move-exception;
        FLog.a("ForwardingRequestListener2", "InternalListener exception in onRequestCancellation", e);
        goto L9
    }
}
