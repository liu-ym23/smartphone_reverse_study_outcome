package com.facebook.imagepipeline.producers;

import android.util.Pair;
import com.facebook.common.util.TriState;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.imageutils.HeifFormatUtil;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes2.dex */
public abstract class MultiplexProducer<K, T extends Closeable> implements Producer<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f8350a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Producer f8351b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f8352c;
    public final String d;

    public class Multiplexer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f8353a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final CopyOnWriteArraySet f8354b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Closeable f8355c;
        public float d;
        public int e;
        public BaseProducerContext f;
        public ForwardingConsumer g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ MultiplexProducer f8356h;

        public class ForwardingConsumer extends BaseConsumer<T> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Multiplexer f8359b;

            public ForwardingConsumer(Multiplexer r5) {
                this.f8359b = r5;
            }

            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            public final void b() {
                FrescoSystrace.a().getClass();     // Catch: Throwable -> L15
                Multiplexer r5 = this.f8359b;     // Catch: Throwable -> L15
                monitor-enter(r5);     // Catch: Throwable -> L15
            L8:
                th = move-exception;
                throw th;     // Catch: Throwable -> L15
            L5:
                if (r5.g == this) goto L10;
                monitor-exit(r5);     // Catch: Throwable -> L8
            L13:
                FrescoSystrace.a().getClass();
                return;
            L10:
                r5.g = null;     // Catch: Throwable -> L8
                r5.f = null;     // Catch: Throwable -> L8
                Multiplexer.a(r5.f8355c);     // Catch: Throwable -> L8
                r5.f8355c = null;     // Catch: Throwable -> L8
                monitor-exit(r5);     // Catch: Throwable -> L8
                r5.a(TriState.f7698c);     // Catch: Throwable -> L15
            L15:
                th = move-exception;
                FrescoSystrace.a().getClass();
                throw th;
            }

            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            public final void b(Throwable r5) {
                FrescoSystrace.a().getClass();     // Catch: Throwable -> L5
                this.f8359b.a(this, r5);     // Catch: Throwable -> L5
                FrescoSystrace.a().getClass();
                return;
            L5:
                th = move-exception;
                FrescoSystrace.a().getClass();
                throw th;
            }

            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            public final void b(float r5) {
                FrescoSystrace.a().getClass();     // Catch: Throwable -> L5
                this.f8359b.a(this, r5);     // Catch: Throwable -> L5
                FrescoSystrace.a().getClass();
                return;
            L5:
                th = move-exception;
                FrescoSystrace.a().getClass();
                throw th;
            }

            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            public final void b(Object r5, int r10) {
                Closeable r11 = (Closeable) r5;
                FrescoSystrace.a().getClass();     // Catch: Throwable -> L6
                this.f8359b.a(this, r11, r10);     // Catch: Throwable -> L6
                FrescoSystrace.a().getClass();
                return;
            L6:
                th = move-exception;
                FrescoSystrace.a().getClass();
                throw th;
            }
        }

        public Multiplexer(MultiplexProducer r5, Object r10) {
            this.f8356h = r5;
            this.f8354b = new CopyOnWriteArraySet();
            this.f8353a = r10;
        }

        public final boolean a(Consumer r10, ProducerContext r11) {
            final Pair r5 = Pair.create(r10, r11);
            monitor-enter(this);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (this.f8356h.b(this.f8353a) == this) goto L11;
            monitor-exit(this);     // Catch: Throwable -> L9
            return false;
        L11:
            this.f8354b.add(r5);     // Catch: Throwable -> L9
            ArrayList r12 = e();     // Catch: Throwable -> L9
            ArrayList r13 = f();     // Catch: Throwable -> L9
            ArrayList r14 = d();     // Catch: Throwable -> L9
            Closeable r15 = this.f8355c;     // Catch: Throwable -> L9
            float r16 = this.d;     // Catch: Throwable -> L9
            int r17 = this.e;     // Catch: Throwable -> L9
            monitor-exit(this);     // Catch: Throwable -> L9
            BaseProducerContext.b(r12);
            BaseProducerContext.c(r13);
            BaseProducerContext.a(r14);
            monitor-enter(r5);
            monitor-enter(this);     // Catch: Throwable -> L28
        L21:
            th = move-exception;
            throw th;     // Catch: Throwable -> L28
        L17:
            if (r15 == this.f8355c) goto L19;
            r15 = null;
        L23:
            monitor-exit(this);     // Catch: Throwable -> L21
            if (r15 != null) goto L26;
        L31:
            monitor-exit(r5);     // Catch: Throwable -> L28
            BaseProducerContext r18 = (BaseProducerContext) r11;
            r18.a(new AnonymousClass1(this, r5));
            return true;
        L26:
            if (r16 <= 0.0f) goto L30;
            ((BaseConsumer) r10).a(r16);     // Catch: Throwable -> L28
        L30:
            ((BaseConsumer) r10).a(r15, r17);     // Catch: Throwable -> L28
            a(r15);     // Catch: Throwable -> L28
            goto L31
        L19:
            if (r15 == null) goto L23;
            r15 = this.f8356h.a(r15);     // Catch: Throwable -> L21
        L28:
            th = move-exception;
            throw th;
        }

        public final synchronized boolean b() {
            monitor-enter(this);
            Iterator r5 = this.f8354b.iterator();     // Catch: Throwable -> L11
        L5:
            if (r5.hasNext() == false) goto L13;
            if (((BaseProducerContext) ((ProducerContext) ((Pair) r5.next()).second)).d() == true) goto L5;
            monitor-exit(this);
            return false;
        L13:
            monitor-exit(this);
            return true;
        L11:
            th = move-exception;
            throw th;
        }

        public final synchronized Priority c() {
            monitor-enter(this);
            Priority r5 = Priority.f8048a;     // Catch: Throwable -> L15
            Iterator r10 = this.f8354b.iterator();     // Catch: Throwable -> L15
        L5:
            if (r10.hasNext() == false) goto L17;
            Priority r11 = ((BaseProducerContext) ((ProducerContext) ((Pair) r10.next()).second)).b();     // Catch: Throwable -> L15
            if (r5 == null) goto L14;
            if (r11 == null) goto L5;
            if (r5.ordinal() > r11.ordinal()) goto L5;
        L14:
            r5 = r11;
            goto L5
        L17:
            monitor-exit(this);
            return r5;
        L15:
            th = move-exception;
            throw th;
        }

        public final synchronized ArrayList d() {
            monitor-enter(this);
            BaseProducerContext r5 = this.f;     // Catch: Throwable -> L11
            if (r5 != null) goto L8;
            monitor-exit(this);
            return null;
        L8:
            ArrayList r10 = r5.a(a());     // Catch: Throwable -> L11
            monitor-exit(this);
            return r10;
        L11:
            th = move-exception;
            throw th;
        }

        public final synchronized ArrayList e() {
            monitor-enter(this);
            BaseProducerContext r5 = this.f;     // Catch: Throwable -> L11
            if (r5 != null) goto L8;
            monitor-exit(this);
            return null;
        L8:
            ArrayList r10 = r5.b(b());     // Catch: Throwable -> L11
            monitor-exit(this);
            return r10;
        L11:
            th = move-exception;
            throw th;
        }

        public final synchronized ArrayList f() {
            monitor-enter(this);
            BaseProducerContext r5 = this.f;     // Catch: Throwable -> L11
            if (r5 != null) goto L8;
            monitor-exit(this);
            return null;
        L8:
            ArrayList r10 = r5.a(c());     // Catch: Throwable -> L11
            monitor-exit(this);
            return r10;
        L11:
            th = move-exception;
            throw th;
        }

        public final void a(TriState r14) {
            monitor-enter(this);
        L12:
            th = move-exception;
            throw th;
        L4:
            if (this.f != null) goto L41;
            if (this.g != null) goto L39;
            if (this.f8354b.isEmpty() == false) goto L14;
            this.f8356h.a(this.f8353a, this);     // Catch: Throwable -> L12
            monitor-exit(this);     // Catch: Throwable -> L12
            return;
        L14:
            ProducerContext r5 = (ProducerContext) ((Pair) this.f8354b.iterator().next()).second;     // Catch: Throwable -> L12
            BaseProducerContext r12 = new BaseProducerContext(((BaseProducerContext) r5).f8257a, ((BaseProducerContext) r5).f8258b, ((BaseProducerContext) r5).f8259c, ((BaseProducerContext) r5).d, ((BaseProducerContext) r5).e, ((BaseProducerContext) r5).f, b(), a(), c(), ((BaseProducerContext) r5).f8265m);     // Catch: Throwable -> L12
            this.f = r12;     // Catch: Throwable -> L12
            HashMap r10 = ((BaseProducerContext) r5).g;     // Catch: Throwable -> L12
            if (r10 == null) goto L22;
            Iterator r11 = r10.entrySet().iterator();     // Catch: Throwable -> L12
        L19:
            if (r11.hasNext() == false) goto L22;
            Map.Entry r13 = (Map.Entry) r11.next();     // Catch: Throwable -> L12
            r12.a((String) r13.getKey(), r13.getValue());     // Catch: Throwable -> L12
        L22:
            if (r14 == TriState.f7698c) goto L34;
            BaseProducerContext r15 = this.f;     // Catch: Throwable -> L12
            int r16 = r14.ordinal();     // Catch: Throwable -> L12
            boolean r17 = true;
            if (r16 == 0) goto L33;
            if (r16 != 1) goto L27;
            r17 = false;
            goto L33
        L27:
            if (r16 == 2) goto L31;
            throw new IllegalStateException("Unrecognized TriState value: " + r14);     // Catch: Throwable -> L12
        L31:
            throw new IllegalStateException("No boolean equivalent for UNSET");     // Catch: Throwable -> L12
        L33:
            r15.a("started_as_prefetch", Boolean.valueOf(r17));     // Catch: Throwable -> L12
        L34:
            ForwardingConsumer r18 = new ForwardingConsumer(this);     // Catch: Throwable -> L12
            this.g = r18;     // Catch: Throwable -> L12
            BaseProducerContext r19 = this.f;     // Catch: Throwable -> L12
            monitor-exit(this);     // Catch: Throwable -> L12
            this.f8356h.f8351b.a(r18, r19);
            return;
        L39:
            throw new IllegalArgumentException();     // Catch: Throwable -> L12
        L41:
            throw new IllegalArgumentException();     // Catch: Throwable -> L12
        }

        public final synchronized boolean a() {
            monitor-enter(this);
            Iterator r5 = this.f8354b.iterator();     // Catch: Throwable -> L11
        L5:
            if (r5.hasNext() == false) goto L13;
            if (((BaseProducerContext) ((ProducerContext) ((Pair) r5.next()).second)).c() == false) goto L5;
            monitor-exit(this);
            return true;
        L13:
            monitor-exit(this);
            return false;
        L11:
            th = move-exception;
            throw th;
        }

        public final void a(ForwardingConsumer r10, Throwable r11) {
            monitor-enter(this);
        L7:
            th = move-exception;
            throw th;
        L4:
            if (this.g == r10) goto L9;
            monitor-exit(this);     // Catch: Throwable -> L7
            return;
        L9:
            Iterator r12 = this.f8354b.iterator();     // Catch: Throwable -> L7
            this.f8354b.clear();     // Catch: Throwable -> L7
            this.f8356h.a(this.f8353a, this);     // Catch: Throwable -> L7
            a(this.f8355c);     // Catch: Throwable -> L7
            this.f8355c = null;     // Catch: Throwable -> L7
            monitor-exit(this);     // Catch: Throwable -> L7
        L12:
            if (r12.hasNext() == false) goto L21;
            Pair r5 = (Pair) r12.next();
            monitor-enter(r5);
            Object r13 = r5.second;     // Catch: Throwable -> L18
            ((BaseProducerContext) ((ProducerContext) r13)).f8259c.a((ProducerContext) r13, this.f8356h.f8352c, r11, null);     // Catch: Throwable -> L18
            ((BaseConsumer) ((Consumer) r5.first)).a(r11);     // Catch: Throwable -> L18
            monitor-exit(r5);     // Catch: Throwable -> L18
        L18:
            th = move-exception;
            throw th;
        }

        public final void a(ForwardingConsumer r10, Closeable r11, int r12) {
            monitor-enter(this);
        L7:
            th = move-exception;
            throw th;
        L4:
            if (this.g == r10) goto L9;
            monitor-exit(this);     // Catch: Throwable -> L7
            return;
        L9:
            a(this.f8355c);     // Catch: Throwable -> L7
            this.f8355c = null;     // Catch: Throwable -> L7
            Iterator r5 = this.f8354b.iterator();     // Catch: Throwable -> L7
            int r13 = this.f8354b.size();     // Catch: Throwable -> L7
            if (BaseConsumer.a(r12) == true) goto L12;
            this.f8355c = this.f8356h.a(r11);     // Catch: Throwable -> L7
            this.e = r12;     // Catch: Throwable -> L7
        L13:
            monitor-exit(this);     // Catch: Throwable -> L7
            int r14 = 0;
        L16:
            if (r5.hasNext() == false) goto L56;
            Pair r15 = (Pair) r5.next();
            monitor-enter(r15);
        L30:
            th = move-exception;
            throw th;
        L20:
            if (BaseConsumer.a(r12) == false) goto L51;
            Object r16 = r15.second;     // Catch: Throwable -> L30
            ((BaseProducerContext) ((ProducerContext) r16)).f8259c.a((ProducerContext) r16, this.f8356h.f8352c, null);     // Catch: Throwable -> L30
            BaseProducerContext r17 = this.f;     // Catch: Throwable -> L30
            if (r17 == null) goto L32;
            ProducerContext r18 = (ProducerContext) r15.second;     // Catch: Throwable -> L30
            HashMap r19 = r17.g;     // Catch: Throwable -> L30
            BaseProducerContext r20 = (BaseProducerContext) r18;     // Catch: Throwable -> L30
            r20.getClass();     // Catch: Throwable -> L30
            if (r19 == null) goto L32;
            Iterator r21 = r19.entrySet().iterator();     // Catch: Throwable -> L30
        L28:
            if (r21.hasNext() == false) goto L32;
            Map.Entry r22 = (Map.Entry) r21.next();     // Catch: Throwable -> L30
            r20.a((String) r22.getKey(), r22.getValue());     // Catch: Throwable -> L30
        L32:
            ((BaseProducerContext) ((ProducerContext) r15.second)).a(this.f8356h.d, Integer.valueOf(r13));     // Catch: Throwable -> L30
            int r23 = r14 + 1;     // Catch: Throwable -> L30
            if (r14 == 0) goto L50;
            if (this.f8356h.c(r11) != HeifFormatUtil.a()) goto L39;
            Closeable r24 = this.f8356h.b(r11);     // Catch: Throwable -> L30
        L40:
            if (r24 == null) goto L48;
            ((BaseConsumer) ((Consumer) r15.first)).a(r24, r12);     // Catch: Throwable -> L45
            a(r24);     // Catch: Throwable -> L30
            monitor-exit(r15);     // Catch: Throwable -> L30
            r14 = r23;
            goto L16
        L45:
            th = move-exception;
            a(r24);     // Catch: Throwable -> L30
            throw th;     // Catch: Throwable -> L30
        L48:
            if (r24 == null) goto L50;
            a(r24);     // Catch: Throwable -> L30
            goto L50
        L39:
            r24 = null;
        L50:
            r14 = r23;
        L51:
            ((BaseConsumer) ((Consumer) r15.first)).a(r11, r12);     // Catch: Throwable -> L30
            monitor-exit(r15);     // Catch: Throwable -> L30
            goto L16
        L56:
            return;
        L12:
            this.f8354b.clear();     // Catch: Throwable -> L7
            this.f8356h.a(this.f8353a, this);     // Catch: Throwable -> L7
            goto L13
        }

        public final void a(ForwardingConsumer r5, float r10) {
            monitor-enter(this);
        L7:
            th = move-exception;
            throw th;
        L4:
            if (this.g == r5) goto L9;
            monitor-exit(this);     // Catch: Throwable -> L7
            return;
        L9:
            this.d = r10;     // Catch: Throwable -> L7
            Iterator r11 = this.f8354b.iterator();     // Catch: Throwable -> L7
            monitor-exit(this);     // Catch: Throwable -> L7
        L12:
            if (r11.hasNext() == false) goto L21;
            Pair r12 = (Pair) r11.next();
            monitor-enter(r12);
            ((BaseConsumer) ((Consumer) r12.first)).a(r10);     // Catch: Throwable -> L18
            monitor-exit(r12);     // Catch: Throwable -> L18
        L18:
            th = move-exception;
            throw th;
        }

        public static void a(Closeable r5) {
            if (r5 != null) goto L9;
            return;
        L9:
            r5.close();     // Catch: IOException -> L5
            return;
        L5:
            e = move-exception;
            throw new RuntimeException(e);
        }
    }

    public MultiplexProducer(Producer r5, String r10, String r11) {
        this.f8351b = r5;
        this.f8350a = new HashMap();
        this.f8352c = r10;
        this.d = r11;
    }

    public abstract Closeable a(Closeable r5);

    public abstract Object a(ProducerContext r5);

    @Override // com.facebook.imagepipeline.producers.Producer
    public final void a(Consumer r5, ProducerContext r10) {
        FrescoSystrace.a().getClass();     // Catch: Throwable -> L17
        ((BaseProducerContext) r10).f8259c.a(r10, this.f8352c);     // Catch: Throwable -> L17
        Object r11 = a(r10);     // Catch: Throwable -> L17
    L3:
        monitor-enter(this);     // Catch: Throwable -> L17
        Multiplexer r12 = b(r11);     // Catch: Throwable -> L7
        if (r12 != null) goto L9;
        r12 = a(r11);     // Catch: Throwable -> L7
        boolean r13 = true;
    L10:
        monitor-exit(this);     // Catch: Throwable -> L7
        if (r12.a(r5, r10) == false) goto L3;
        if (r13 == true) goto L15;
    L21:
        FrescoSystrace.a().getClass();
        return;
    L15:
        if (((BaseProducerContext) r10).d() == false) goto L19;
        TriState r14 = TriState.f7696a;     // Catch: Throwable -> L17
    L20:
        r12.a(r14);     // Catch: Throwable -> L17
        goto L21
    L19:
        r14 = TriState.f7697b;     // Catch: Throwable -> L17
        goto L20
    L9:
        r13 = false;
        goto L10
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        FrescoSystrace.a().getClass();
        throw th;
    }

    public Closeable b(Closeable r5) {
        return null;
    }

    public abstract ImageFormat c(Closeable r5);

    public final synchronized Multiplexer b(Object r5) {
        monitor-enter(this);
        Multiplexer r10 = (Multiplexer) this.f8350a.get(r5);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized Multiplexer a(Object r5) {
        monitor-enter(this);
        Multiplexer r10 = new Multiplexer(this, r5);     // Catch: Throwable -> L6
        this.f8350a.put(r5, r10);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void a(Object r5, Multiplexer r10) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.f8350a.get(r5) != r10) goto L10;
        this.f8350a.remove(r5);     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L10:
        monitor-exit(this);
    }
}
