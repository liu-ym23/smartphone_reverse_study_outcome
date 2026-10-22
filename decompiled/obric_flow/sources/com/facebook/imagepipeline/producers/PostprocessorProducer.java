package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.DefaultCloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.facebook.imagepipeline.request.Postprocessor;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes2.dex */
public class PostprocessorProducer implements Producer<CloseableReference<CloseableImage>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Producer f8369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PlatformBitmapFactory f8370b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ExecutorService f8371c;

    public class PostprocessorConsumer extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final InternalRequestListener f8372c;
        public final ProducerContext d;
        public final Postprocessor e;
        public boolean f;
        public CloseableReference g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f8373h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f8374i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f8375j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ PostprocessorProducer f8376k;

        public PostprocessorConsumer(PostprocessorProducer r5, Consumer r10, InternalRequestListener r11, Postprocessor r12, ProducerContext r13) {
            this.f8376k = r5;
            super(r10);
            this.g = null;
            this.f8373h = 0;
            this.f8374i = false;
            this.f8375j = false;
            this.f8372c = r11;
            this.e = r12;
            this.d = r13;
            BaseProducerContext r14 = (BaseProducerContext) r13;
            r14.a(new AnonymousClass1(this));
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public static void a(PostprocessorConsumer r10, CloseableReference r11, int r12) {
            r10.getClass();
            if (CloseableReference.b(r11) == false) goto L41;
            monitor-enter(r11);
            Object r5 = r11.f7671b.d();     // Catch: Throwable -> L37
            monitor-exit(r11);     // Catch: Throwable -> L37
            if ((((CloseableImage) r5) instanceof CloseableStaticBitmap) == true) goto L11;
            r10.a(r11, r12);
            return;
        L11:
            HashMap r13 = new HashMap();
            r10.f8372c.a(r10.d, "PostprocessorProducer");
            DefaultCloseableReference r14 = null;
            Map r15 = null;
            DefaultCloseableReference r16 = r10.a((CloseableImage) r11.c());     // Catch: Throwable -> L23 Exception -> L25
        L46:
            InternalRequestListener r17 = r10.f8372c;     // Catch: Throwable -> L21
            ProducerContext r18 = r10.d;     // Catch: Throwable -> L21
            Postprocessor r19 = r10.e;     // Catch: Throwable -> L21
            if (r17.b(r18, "PostprocessorProducer") == false) goto L17;
            r13.put("Postprocessor", r19.getName());     // Catch: Throwable -> L21
            r15 = Collections.unmodifiableMap(r13);     // Catch: Throwable -> L21
        L17:
            r17.a(r18, "PostprocessorProducer", r15);     // Catch: Throwable -> L21
            r10.a(r16, r12);     // Catch: Throwable -> L21
            if (r16 == null) goto L48;
            r16.close();
            return;
        L48:
            return;
        L21:
            th = th;
            r14 = r16;
        L34:
            if (r14 == null) goto L36;
            r14.close();
        L36:
            throw th;
        L23:
            th = th;
        L25:
            e = move-exception;
            InternalRequestListener r20 = r10.f8372c;     // Catch: Throwable -> L23
            ProducerContext r21 = r10.d;     // Catch: Throwable -> L23
            Postprocessor r22 = r10.e;     // Catch: Throwable -> L23
            if (r20.b(r21, "PostprocessorProducer") == true) goto L29;
            Map r23 = null;
        L30:
            r20.a(r21, "PostprocessorProducer", e, r23);     // Catch: Throwable -> L23
            if (r10.c() == false) goto L49;
            ((BaseConsumer) r10.f8287b).a(e);     // Catch: Throwable -> L23
            return;
        L49:
            return;
        L29:
            r13.put("Postprocessor", r22.getName());     // Catch: Throwable -> L23
            r23 = Collections.unmodifiableMap(r13);     // Catch: Throwable -> L23
        L37:
            th = move-exception;
            throw th;
        L41:
            throw new IllegalArgumentException();
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public final void b(Object r5, int r10) {
            CloseableReference r11 = (CloseableReference) r5;
            CloseableReference r12 = null;
            if (CloseableReference.b(r11) == false) goto L5;
            monitor-enter(this);
        L13:
            th = move-exception;
            throw th;
        L10:
            if (this.f == false) goto L15;
            monitor-exit(this);     // Catch: Throwable -> L13
            return;
        L15:
            CloseableReference r13 = this.g;     // Catch: Throwable -> L13
            if (r11 == null) goto L18;
            r12 = r11.b();     // Catch: Throwable -> L13
        L18:
            this.g = r12;     // Catch: Throwable -> L13
            this.f8373h = r10;     // Catch: Throwable -> L13
            this.f8374i = true;     // Catch: Throwable -> L13
            boolean r14 = d();     // Catch: Throwable -> L13
            monitor-exit(this);     // Catch: Throwable -> L13
            if (r13 == null) goto L22;
            r13.close();
        L22:
            if (r14 == false) goto L29;
            e();
            return;
        L29:
            return;
        L5:
            if (BaseConsumer.a(r10) == false) goto L28;
            a(null, r10);
            return;
        }

        public final boolean c() {
            monitor-enter(this);
        L8:
            th = move-exception;
            throw th;
        L4:
            if (this.f == false) goto L10;
            monitor-exit(this);     // Catch: Throwable -> L8
            return false;
        L10:
            CloseableReference r5 = this.g;     // Catch: Throwable -> L8
            this.g = null;     // Catch: Throwable -> L8
            this.f = true;     // Catch: Throwable -> L8
            monitor-exit(this);     // Catch: Throwable -> L8
            if (r5 == null) goto L14;
            r5.close();
        L14:
            return true;
        }

        public final synchronized boolean d() {
            monitor-enter(this);
        L14:
            th = move-exception;
            throw th;
        L4:
            if (this.f == false) goto L6;
        L16:
            monitor-exit(this);
            return false;
        L6:
            if (this.f8374i == false) goto L16;
            if (this.f8375j == true) goto L16;
            if (CloseableReference.b(this.g) == false) goto L16;
            this.f8375j = true;     // Catch: Throwable -> L14
            monitor-exit(this);
            return true;
        }

        public final void e() {
            ExecutorService r5 = this.f8376k.f8371c;
            BaseProducerContext r10 = (BaseProducerContext) this.d;
            monitor-enter(r10);
            Priority r11 = r10.f8261i;     // Catch: Throwable -> L8
            monitor-exit(r10);     // Catch: Throwable -> L8
            r11.ordinal();
            r5.execute(new AnonymousClass2(this));
            return;
        L8:
            th = move-exception;
            throw th;
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public final void b(Throwable r5) {
            if (c() == false) goto L6;
            ((BaseConsumer) this.f8287b).a(r5);
            return;
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public final void b() {
            if (c() == false) goto L6;
            ((BaseConsumer) this.f8287b).a();
            return;
        }

        public static void a(PostprocessorConsumer r5) {
            monitor-enter(r5);
            r5.f8375j = false;     // Catch: Throwable -> L9
            boolean r10 = r5.d();     // Catch: Throwable -> L9
            monitor-exit(r5);     // Catch: Throwable -> L9
            if (r10 == false) goto L14;
            r5.e();
            return;
        L14:
            return;
        L9:
            th = move-exception;
            throw th;
        }

        public final DefaultCloseableReference a(CloseableImage r11) {
            CloseableStaticBitmap r5 = (CloseableStaticBitmap) r11;
            Bitmap r10 = r5.g;
            Postprocessor r12 = this.e;
            if ((r12 instanceof BasePostprocessor) == false) goto L5;
            CloseableReference r13 = ((BasePostprocessor) r12).a(r10, this.f8376k.f8370b);
        L6:
            int r14 = r5.f8172i;
            int r15 = r5.f8173j;
            Rect r16 = r5.f8174k;
            Rect r17 = r5.f8175l;
            int r18 = r5.f8176m;
            CloseableReference r19 = r13;
            CloseableStaticBitmap r20 = new CloseableStaticBitmap(r19, r11.c(), r14, r15, r16, r17, r18);     // Catch: Throwable -> L10
            r20.a(r5.f8169b);     // Catch: Throwable -> L10
            DefaultCloseableReference r110 = CloseableReference.a(r20, CloseableReference.e, CloseableReference.f);     // Catch: Throwable -> L10
            r13.close();
            return r110;
        L10:
            th = move-exception;
            if (r13 == null) goto L13;
            r13.close();
        L13:
            throw th;
        L5:
            r13 = r12.a(r10, this.f8376k.f8370b);
            goto L6
        }

        public final void a(CloseableReference r5, int r10) {
            boolean r11 = BaseConsumer.a(r10);
            if (r11 == true) goto L12;
            monitor-enter(this);
            boolean r12 = this.f;     // Catch: Throwable -> L9
            monitor-exit(this);     // Catch: Throwable -> L9
            if (r12 == true) goto L12;
        L15:
            ((BaseConsumer) this.f8287b).a(r5, r10);
            return;
        L9:
            th = move-exception;
            throw th;
        L12:
            if (r11 == true) goto L14;
            return;
        L14:
            if (c() == true) goto L15;
        }
    }

    public class SingleUsePostprocessorConsumer extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> {
        public SingleUsePostprocessorConsumer(PostprocessorConsumer r5) {
            super(r5);
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public final void b(Object r5, int r10) {
            CloseableReference r11 = (CloseableReference) r5;
            if (BaseConsumer.a(r10) == true) goto L5;
            return;
        L5:
            ((BaseConsumer) this.f8287b).a(r11, r10);
        }
    }

    public PostprocessorProducer(Producer r5, PlatformBitmapFactory r10, ExecutorService r11) {
        r5.getClass();
        this.f8369a = r5;
        this.f8370b = r10;
        r11.getClass();
        this.f8371c = r11;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public final void a(Consumer r10, ProducerContext r11) {
        BaseProducerContext r5 = (BaseProducerContext) r11;
        SingleUsePostprocessorConsumer r12 = new SingleUsePostprocessorConsumer(new PostprocessorConsumer(this, r10, r5.f8259c, r5.f8257a.f8422m, r11));
        this.f8369a.a(r12, r11);
    }
}
