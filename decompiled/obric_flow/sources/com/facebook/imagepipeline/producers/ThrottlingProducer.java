package com.facebook.imagepipeline.producers;

import android.util.Pair;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes2.dex */
public class ThrottlingProducer<T> implements Producer<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Producer f8400a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8401b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentLinkedQueue f8402c;
    public final ExecutorService d;

    public class ThrottlerConsumer extends DelegatingConsumer<T, T> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ThrottlingProducer f8403c;

        public ThrottlerConsumer(ThrottlingProducer r5, Consumer r10) {
            this.f8403c = r5;
            super(r10);
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public final void b() {
            ((BaseConsumer) this.f8287b).a();
            c();
        }

        public final void c() {
            ThrottlingProducer r5 = this.f8403c;
            monitor-enter(r5);
            final Pair r10 = (Pair) this.f8403c.f8402c.poll();     // Catch: Throwable -> L7
            if (r10 != null) goto L9;
            this.f8403c.f8401b--;     // Catch: Throwable -> L7
        L9:
            monitor-exit(r5);     // Catch: Throwable -> L7
            if (r10 == null) goto L17;
            this.f8403c.d.execute(new AnonymousClass1(this, r10));
            return;
        L17:
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public final void b(Throwable r5) {
            ((BaseConsumer) this.f8287b).a(r5);
            c();
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public final void b(Object r5, int r10) {
            ((BaseConsumer) this.f8287b).a(r5, r10);
            if (BaseConsumer.a(r10) == false) goto L6;
            c();
            return;
        }
    }

    public ThrottlingProducer(ExecutorService r5, Producer r10) {
        r5.getClass();
        this.d = r5;
        this.f8400a = r10;
        this.f8402c = new ConcurrentLinkedQueue();
        this.f8401b = 0;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public final void a(Consumer r5, ProducerContext r10) {
        BaseProducerContext r11 = (BaseProducerContext) r10;
        r11.f8259c.a(r10, "ThrottlingProducer");
        monitor-enter(this);
        int r12 = this.f8401b;     // Catch: Throwable -> L7
        boolean r13 = true;
        if (r12 < 5) goto L9;
        this.f8402c.add(Pair.create(r5, r10));     // Catch: Throwable -> L7
    L10:
        monitor-exit(this);     // Catch: Throwable -> L7
        if (r13 == true) goto L18;
        r11.f8259c.a(r10, "ThrottlingProducer", null);
        this.f8400a.a(new ThrottlerConsumer(this, r5), r10);
        return;
    L18:
        return;
    L9:
        this.f8401b = r12 + 1;     // Catch: Throwable -> L7
        r13 = false;
    L7:
        th = move-exception;
        throw th;
    }
}
