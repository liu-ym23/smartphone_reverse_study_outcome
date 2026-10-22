package com.facebook.imagepipeline.core;

import com.facebook.common.internal.Supplier;
import com.facebook.common.util.UriUtil;
import com.facebook.datasource.AbstractDataSource;
import com.facebook.datasource.DataSources;
import com.facebook.datasource.SimpleDataSource;
import com.facebook.drawee.backends.pipeline.info.ImageOriginRequestListener;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.cache.InstrumentedMemoryCache;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.datasource.CloseableProducerToDataSourceAdapter;
import com.facebook.imagepipeline.datasource.ProducerToDataSourceAdapter;
import com.facebook.imagepipeline.listener.BaseRequestListener;
import com.facebook.imagepipeline.listener.ForwardingRequestListener;
import com.facebook.imagepipeline.listener.ForwardingRequestListener2;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.producers.InternalRequestListener;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.SettableProducerContext;
import com.facebook.imagepipeline.producers.SwallowResultProducer;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public class ImagePipeline {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final CancellationException f8062k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ProducerSequenceFactory f8063a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ForwardingRequestListener f8064b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ForwardingRequestListener2 f8065c;
    public final Supplier d;
    public final InstrumentedMemoryCache e;
    public final DefaultCacheKeyFactory f;
    public final Supplier g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicLong f8066h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ImagePipelineConfig f8067i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final WebpOptSwitch f8068j;

    static {
        f8062k = new CancellationException("Prefetching is not enabled");
    }

    public ImagePipeline(ProducerSequenceFactory r5, Set r10, Set r11, Supplier r12, InstrumentedMemoryCache r13, DefaultCacheKeyFactory r14, Supplier r15, ImagePipelineConfig r16) {
        this.f8066h = new AtomicLong();
        this.f8063a = r5;
        this.f8064b = new ForwardingRequestListener(r10);
        this.f8065c = new ForwardingRequestListener2(r11);
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
        this.f8067i = r16;
        this.f8068j = new WebpOptSwitch();
    }

    public final AbstractDataSource a(Producer r13, ImageRequest r14, ImageRequest.RequestLevel r15, Object r16, BaseRequestListener r17, Priority r18) {
        FrescoSystrace.a().getClass();
        ForwardingRequestListener r5 = a(r14, r17);
        InternalRequestListener r10 = new InternalRequestListener(a(r14, r17), this.f8065c);
        ImageRequest.RequestLevel r11 = r14.f8419j;     // Catch: Throwable -> L14 Exception -> L16
        if (r11.f8433a <= r15.f8433a) goto L6;
        ImageRequest.RequestLevel r12 = r11;
    L7:
        String r19 = String.valueOf(this.f8066h.getAndIncrement());     // Catch: Throwable -> L14 Exception -> L16
        if (r14.e == false) goto L10;
    L18:
        boolean r20 = true;
    L13:
        boolean r21 = r20;
        SettableProducerContext r110 = new SettableProducerContext(r14, r19, r10, r5, r16, r12, r21, r18, this.f8067i);     // Catch: Throwable -> L14 Exception -> L16
        FrescoSystrace.a().getClass();     // Catch: Throwable -> L14 Exception -> L16
        CloseableProducerToDataSourceAdapter r22 = new CloseableProducerToDataSourceAdapter(r13, r110, r10);     // Catch: Throwable -> L14 Exception -> L16
        FrescoSystrace.a().getClass();     // Catch: Throwable -> L14 Exception -> L16
        FrescoSystrace.a().getClass();
        return r22;
    L10:
        if (UriUtil.b(r14.f8415b) == false) goto L18;
        r20 = false;
        goto L13
    L6:
        r12 = r15;
    L14:
        th = move-exception;
        FrescoSystrace.a().getClass();
        throw th;
    L16:
        e = move-exception;
        SimpleDataSource r23 = DataSources.a(e);     // Catch: Throwable -> L14
        FrescoSystrace.a().getClass();
        return r23;
    }

    public final Supplier a(final ImageRequest r5) {
        return new AnonymousClass1(this, r5);
    }

    public final AbstractDataSource a(ImageRequest r10, String r11, ImageRequest.RequestLevel r12, ImageOriginRequestListener r13) {
        if (r10 == null) goto L5;
        Priority r5 = r10.f8418i;
    L7:
        return a(r10, r11, r12, r13, r5);
    L5:
        r5 = Priority.f8050c;
        goto L7
    }

    public final ForwardingRequestListener a(ImageRequest r5, BaseRequestListener r10) {
        if (r10 != null) goto L5;
        r5.getClass();
        return this.f8064b;
    L5:
        r5.getClass();
        return new ForwardingRequestListener(new RequestListener[]{this.f8064b, r10});
    }

    public final AbstractDataSource a(ImageRequest r10, Object r11, ImageRequest.RequestLevel r12, BaseRequestListener r13, Priority r14) {
        return a(this.f8063a.b(r10), r10, r12, r11, r13, r14);
    L4:
        e = move-exception;
        return DataSources.a(e);
    }

    public final AbstractDataSource a(ImageRequest r5, Object r10) {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            this = this;
            com.facebook.common.internal.Supplier r0 = r4.d
            com.facebook.imagepipeline.core.ImagePipelineConfig$1 r0 = (com.facebook.imagepipeline.core.ImagePipelineConfig.AnonymousClass1) r0
            r0.getClass()
            com.facebook.common.internal.Supplier r0 = r4.g     // Catch: java.lang.Exception -> L1c
            java.lang.Object r0 = r0.get()     // Catch: java.lang.Exception -> L1c
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Exception -> L1c
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Exception -> L1c
            if (r0 == 0) goto L1e
            com.facebook.imagepipeline.core.ProducerSequenceFactory r0 = r4.f8063a     // Catch: java.lang.Exception -> L1c
            com.facebook.imagepipeline.producers.Producer r0 = r0.c(r5)     // Catch: java.lang.Exception -> L1c
            goto L44
        L1c:
            r4 = move-exception
            goto L4d
        L1e:
            com.facebook.imagepipeline.core.ProducerSequenceFactory r0 = r4.f8063a     // Catch: java.lang.Exception -> L1c
            com.facebook.imagepipeline.producers.Producer r1 = r0.a(r5)     // Catch: java.lang.Exception -> L1c
            monitor-enter(r0)     // Catch: java.lang.Exception -> L1c
            java.util.HashMap r2 = r0.f8155z     // Catch: java.lang.Throwable -> L38
            boolean r2 = r2.containsKey(r1)     // Catch: java.lang.Throwable -> L38
            if (r2 != 0) goto L3a
            com.facebook.imagepipeline.producers.SwallowResultProducer r2 = new com.facebook.imagepipeline.producers.SwallowResultProducer     // Catch: java.lang.Throwable -> L38
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L38
            java.util.HashMap r3 = r0.f8155z     // Catch: java.lang.Throwable -> L38
            r3.put(r1, r2)     // Catch: java.lang.Throwable -> L38
            goto L3a
        L38:
            r4 = move-exception
            goto L4b
        L3a:
            java.util.HashMap r2 = r0.f8155z     // Catch: java.lang.Throwable -> L38
            java.lang.Object r1 = r2.get(r1)     // Catch: java.lang.Throwable -> L38
            com.facebook.imagepipeline.producers.Producer r1 = (com.facebook.imagepipeline.producers.Producer) r1     // Catch: java.lang.Throwable -> L38
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L38
            r0 = r1
        L44:
            com.facebook.imagepipeline.common.Priority r1 = r5.f8418i     // Catch: java.lang.Exception -> L1c
            com.facebook.datasource.AbstractDataSource r4 = r4.a(r0, r5, r6, r1)     // Catch: java.lang.Exception -> L1c
            return r4
        L4b:
            monitor-exit(r0)     // Catch: java.lang.Exception -> L1c
            throw r4     // Catch: java.lang.Exception -> L1c
        L4d:
            com.facebook.datasource.SimpleDataSource r4 = com.facebook.datasource.DataSources.a(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.core.ImagePipeline.a(com.facebook.imagepipeline.request.ImageRequest, java.lang.Object):com.facebook.datasource.AbstractDataSource");
    }

    public final AbstractDataSource a(ImageRequest r5, Object r10, Priority r11) {
        ((ImagePipelineConfig.AnonymousClass1) this.d).getClass();
        return a(this.f8063a.c(r5), r5, r10, r11);
    L5:
        e = move-exception;
        return DataSources.a(e);
    }

    public final AbstractDataSource a(Producer r12, ImageRequest r13, Object r14, Priority r15) {
        ImageRequest.RequestLevel r5 = ImageRequest.RequestLevel.f8431b;
        ForwardingRequestListener r10 = this.f8064b;
        InternalRequestListener r11 = new InternalRequestListener(r10, this.f8065c);
        ImageRequest.RequestLevel r16 = r13.f8419j;     // Catch: Exception -> L16
        if (r16.f8433a <= 1) goto L6;
        ImageRequest.RequestLevel r17 = r16;
    L7:
        String r18 = String.valueOf(this.f8066h.getAndIncrement());     // Catch: Exception -> L16
        Priority r19 = Priority.f8049b;     // Catch: Exception -> L16
        if (r15 != null) goto L11;
    L13:
        Priority r20 = r19;
    L14:
        return new ProducerToDataSourceAdapter(r12, new SettableProducerContext(r13, r18, r11, r10, r14, r17, r20, this.f8067i), r11);
    L11:
        if (r15.ordinal() >= 1) goto L13;
        r20 = r15;
        goto L14
    L6:
        r17 = r5;
    L16:
        e = move-exception;
        return DataSources.a(e);
    }
}
