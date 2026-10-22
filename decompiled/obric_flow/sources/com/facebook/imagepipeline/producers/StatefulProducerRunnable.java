package com.facebook.imagepipeline.producers;

import com.facebook.common.executors.StatefulRunnable;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class StatefulProducerRunnable<T> extends StatefulRunnable<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Consumer f8389b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InternalRequestListener f8390c;
    public final String d;
    public final ProducerContext e;

    public StatefulProducerRunnable(Consumer r5, InternalRequestListener r10, ProducerContext r11, String r12) {
        this.f8389b = r5;
        this.f8390c = r10;
        this.d = r12;
        this.e = r11;
        r10.a(r11, r12);
    }

    @Override // com.facebook.common.executors.StatefulRunnable
    public void a(Exception r5) {
        InternalRequestListener r10 = this.f8390c;
        ProducerContext r11 = this.e;
        String r12 = this.d;
        r10.b(r11, r12);
        r10.a(r11, r12, r5, null);
        ((BaseConsumer) this.f8389b).a(r5);
    }

    @Override // com.facebook.common.executors.StatefulRunnable
    public void b(Object r5) {
        InternalRequestListener r10 = this.f8390c;
        ProducerContext r11 = this.e;
        String r12 = this.d;
        if (r10.b(r11, r12) == false) goto L5;
        Map r13 = c(r5);
    L6:
        r10.a(r11, r12, r13);
        ((BaseConsumer) this.f8389b).a(r5, 1);
        return;
    L5:
        r13 = null;
        goto L6
    }

    public Map c(Object r5) {
        return null;
    }

    public void b() {
        InternalRequestListener r5 = this.f8390c;
        ProducerContext r10 = this.e;
        String r11 = this.d;
        r5.b(r10, r11);
        r5.a(r10, r11, null);
        ((BaseConsumer) this.f8389b).a();
    }
}
