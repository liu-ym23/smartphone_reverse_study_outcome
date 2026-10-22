package com.facebook.imagepipeline.core;

import android.util.Log;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.cache.disk.DiskStorageCache;
import com.facebook.cache.disk.FileCache;
import com.facebook.common.logging.FLogDefaultLoggingDelegate;
import com.facebook.common.memory.NoOpMemoryTrimmableRegistry;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteStreams;
import com.facebook.common.util.Lazy;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactoryProvider;
import com.facebook.imagepipeline.cache.BitmapCountingMemoryCacheFactory;
import com.facebook.imagepipeline.cache.BitmapMemoryCacheFactory;
import com.facebook.imagepipeline.cache.BitmapMemoryCacheTrimStrategy;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.cache.DefaultBitmapMemoryCacheParamsSupplier;
import com.facebook.imagepipeline.cache.InstrumentedMemoryCache;
import com.facebook.imagepipeline.decoder.DefaultImageDecoder;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.memory.GenericByteArrayPool;
import com.facebook.imagepipeline.memory.PoolConfig;
import com.facebook.imagepipeline.memory.PoolFactory;
import com.facebook.imagepipeline.platform.PlatformDecoder;
import com.facebook.imagepipeline.platform.PlatformDecoderFactory;
import com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue;
import com.facebook.imagepipeline.producers.ThreadHandoffProducerQueueImpl;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.imagepipeline.transcoder.MultiImageTranscoderFactory;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class ImagePipelineFactory {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static ImagePipelineFactory f8097u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static ImageDecoder f8098v;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f8099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CloseableReferenceFactory f8100b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f8101c;
    public CountingMemoryCache d;
    public InstrumentedMemoryCache e;
    public CountingMemoryCache f;
    public InstrumentedMemoryCache g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public BufferedDiskCache f8102h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public DiskStorageCache f8103i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public DefaultImageDecoder f8104j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ImagePipeline f8105k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public MultiImageTranscoderFactory f8106l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ProducerFactory f8107m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ProducerSequenceFactory f8108n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public BufferedDiskCache f8109o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public HashMap f8110p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public DiskStorageCache f8111q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public HashMap f8112r;
    public PlatformBitmapFactory s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public PlatformDecoder f8113t;

    public ImagePipelineFactory(ImagePipelineConfig r5) {
        Lazy<ThreadHandoffProducerQueue> r10 = new AnonymousClass1(this);
        this.f8099a = r10;
        Lazy<ImagePipelineConfig> r11 = new AnonymousClass2(this);
        this.f8101c = r11;
        FrescoSystrace.a().getClass();
        this.f8100b = new CloseableReferenceFactory(r5.f8087v);
        r11.f7695b = r5;
        r10.f7695b = new ThreadHandoffProducerQueueImpl(r5.g.d);
        FrescoSystrace.a().getClass();
    }

    public static synchronized void a(ImagePipelineConfig r5) {
        monitor-enter(ImagePipelineFactory.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (f8097u != null) goto L7;
    L11:
        f8097u = new ImagePipelineFactory(r5);     // Catch: Throwable -> L9
        monitor-exit(ImagePipelineFactory.class);
        return;
    L7:
        if (FLogDefaultLoggingDelegate.f7658a.a(5) == false) goto L11;
        Log.println(5, FLogDefaultLoggingDelegate.a("ImagePipelineFactory"), "ImagePipelineFactory has already been initialized! `ImagePipelineFactory.initialize(...)` should only be called once to avoid unexpected behavior.");     // Catch: Throwable -> L9
        goto L11
    }

    public final CountingMemoryCache b() {
        if (this.d != null) goto L6;
        DefaultBitmapMemoryCacheParamsSupplier r5 = ((ImagePipelineConfig) this.f8101c.a()).f8071a;
        NoOpMemoryTrimmableRegistry r10 = ((ImagePipelineConfig) this.f8101c.a()).f8077k;
        BitmapMemoryCacheTrimStrategy r11 = ((ImagePipelineConfig) this.f8101c.a()).f8072b;
        ((ImagePipelineConfig) this.f8101c.a()).getClass();
        this.d = BitmapCountingMemoryCacheFactory.a(r5, r10);
    L6:
        return this.d;
    }

    public final InstrumentedMemoryCache c() {
        if (this.e != null) goto L6;
        ((ImagePipelineConfig) this.f8101c.a()).getClass();
        b();
        this.e = BitmapMemoryCacheFactory.a(b(), ((ImagePipelineConfig) this.f8101c.a()).f8074h);
    L6:
        return this.e;
    }

    public final HashMap d() {
        if (this.f8110p != null) goto L21;
        this.f8110p = new HashMap();
        if (this.f8112r != null) goto L10;
        this.f8112r = new HashMap();
        HashMap r5 = ((ImagePipelineConfig) this.f8101c.a()).s;
        Iterator r10 = r5.keySet().iterator();
    L8:
        if (r10.hasNext() == false) goto L10;
        String r11 = (String) r10.next();
        DiskStorageCache r12 = ((ImagePipelineConfig) this.f8101c.a()).e.a((DiskCacheConfig) r5.get(r11));
        this.f8112r.put(r11, r12);
    L10:
        HashMap r13 = this.f8112r;
        Iterator r14 = r13.keySet().iterator();
    L12:
        if (r14.hasNext() == false) goto L21;
        String r15 = (String) r14.next();
        FileCache r16 = (FileCache) r13.get(r15);
        PoolFactory r17 = ((ImagePipelineConfig) this.f8101c.a()).f8079m;
        ((ImagePipelineConfig) this.f8101c.a()).getClass();
        PooledByteBufferFactory r18 = r17.b(0);
        PoolFactory r19 = ((ImagePipelineConfig) this.f8101c.a()).f8079m;
        if (r19.f8245h != null) goto L19;
        if (r19.f8246i != null) goto L18;
        PoolConfig r20 = r19.f8242a;
        r19.f8246i = new GenericByteArrayPool(r20.d, r20.g, r20.f8239h);
    L18:
        r19.f8245h = new PooledByteStreams(r19.f8246i);
    L19:
        BufferedDiskCache r110 = new BufferedDiskCache(r16, r18, r19.f8245h, ((ImagePipelineConfig) this.f8101c.a()).g.f8059a, ((ImagePipelineConfig) this.f8101c.a()).g.f8059a, ((ImagePipelineConfig) this.f8101c.a()).f8074h);
        DiskCacheConfig r21 = (DiskCacheConfig) ((ImagePipelineConfig) this.f8101c.a()).s.get(r15);
        this.f8110p.put(r15, r110);
    L21:
        return this.f8110p;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r1v1 com.facebook.imagepipeline.core.ImagePipeline, still in use, count: 3, list:
          (r1v1 com.facebook.imagepipeline.core.ImagePipeline) from 0x02fa: MOVE (r22v0 com.facebook.imagepipeline.core.ImagePipeline) = (r1v1 com.facebook.imagepipeline.core.ImagePipeline)
          (r1v1 com.facebook.imagepipeline.core.ImagePipeline) from 0x0219: MOVE (r22v2 com.facebook.imagepipeline.core.ImagePipeline) = (r1v1 com.facebook.imagepipeline.core.ImagePipeline)
          (r1v1 com.facebook.imagepipeline.core.ImagePipeline) from 0x021d: PHI (r22v3 com.facebook.imagepipeline.core.ImagePipeline) = (r22v2 com.facebook.imagepipeline.core.ImagePipeline), (r1v1 com.facebook.imagepipeline.core.ImagePipeline) binds: [B:31:0x0219, B:30:0x01aa] A[DONT_GENERATE, DONT_INLINE]
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:93)
        	at jadx.core.utils.InsnRemover.addAndUnbind(InsnRemover.java:59)
        	at jadx.core.dex.visitors.ModVisitor.removeStep(ModVisitor.java:463)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:97)
        */
    public final com.facebook.imagepipeline.core.ImagePipeline e() {
        com.facebook.imagepipeline.core.ImagePipeline r1 = r24.f8105k;
        if (r1 != null) goto L47;
        com.facebook.common.util.Lazy r2 = r24.f8101c;
        java.lang.Object r2 = r2.a();
        com.facebook.imagepipeline.core.ImagePipelineConfig r2 = (com.facebook.imagepipeline.core.ImagePipelineConfig) r2;
        com.facebook.imagepipeline.core.ImagePipelineExperiments r2 = r2.f8085t;
        r2.getClass();
        com.facebook.imagepipeline.core.ProducerSequenceFactory r2 = r24.f8108n;
        if (r2 != null) goto L36;
        com.facebook.common.util.Lazy r3 = r24.f8101c;
        java.lang.Object r3 = r3.a();
        com.facebook.imagepipeline.core.ImagePipelineConfig r3 = (com.facebook.imagepipeline.core.ImagePipelineConfig) r3;
        android.content.Context r3 = r3.d;
        android.content.Context r3 = r3.getApplicationContext();
        android.content.ContentResolver r4 = r3.getContentResolver();
        com.facebook.imagepipeline.core.ProducerFactory r3 = r24.f8107m;
        if (r3 != null) goto L31;
        com.facebook.common.util.Lazy r3 = r24.f8101c;
        java.lang.Object r3 = r3.a();
        com.facebook.imagepipeline.core.ImagePipelineConfig r3 = (com.facebook.imagepipeline.core.ImagePipelineConfig) r3;
        com.facebook.imagepipeline.core.ImagePipelineExperiments r3 = r3.f8085t;
        com.facebook.imagepipeline.core.ImagePipelineExperiments.DefaultProducerFactoryMethod r3 = r3.f8091a;
        com.facebook.common.util.Lazy r3 = r24.f8101c;
        java.lang.Object r3 = r3.a();
        com.facebook.imagepipeline.core.ImagePipelineConfig r3 = (com.facebook.imagepipeline.core.ImagePipelineConfig) r3;
        android.content.Context r6 = r3.d;
        com.facebook.common.util.Lazy r3 = r24.f8101c;
        java.lang.Object r3 = r3.a();
        com.facebook.imagepipeline.core.ImagePipelineConfig r3 = (com.facebook.imagepipeline.core.ImagePipelineConfig) r3;
        com.facebook.imagepipeline.memory.PoolFactory r3 = r3.f8079m;
        com.facebook.imagepipeline.memory.GenericByteArrayPool r5 = r3.f8246i;
        if (r5 != null) goto L11;
        com.facebook.imagepipeline.memory.PoolConfig r7 = r3.f8242a;
        com.facebook.common.memory.NoOpMemoryTrimmableRegistry r8 = r7.d;
        com.facebook.imagepipeline.memory.PoolParams r9 = r7.g;
        com.facebook.imagepipeline.memory.NoOpPoolStatsTracker r7 = r7.f8239h;
        com.facebook.imagepipeline.memory.GenericByteArrayPool r5 = new com.facebook.imagepipeline.memory.GenericByteArrayPool(r8, r9, r7);
        r3.f8246i = r5;
    L11:
        com.facebook.imagepipeline.memory.GenericByteArrayPool r7 = r3.f8246i;
        com.facebook.imagepipeline.decoder.DefaultImageDecoder r3 = r24.f8104j;
        if (r3 != null) goto L17;
        com.facebook.common.util.Lazy r3 = r24.f8101c;
        java.lang.Object r3 = r3.a();
        com.facebook.imagepipeline.core.ImagePipelineConfig r3 = (com.facebook.imagepipeline.core.ImagePipelineConfig) r3;
        r3.getClass();
        a();
        com.facebook.imagepipeline.decoder.ImageDecoder r3 = com.facebook.imagepipeline.core.ImagePipelineFactory.f8098v;
        if (r3 == null) goto L50;
    L16:
        com.facebook.common.util.Lazy r3 = r24.f8101c;
        java.lang.Object r3 = r3.a();
        com.facebook.imagepipeline.core.ImagePipelineConfig r3 = (com.facebook.imagepipeline.core.ImagePipelineConfig) r3;
        r3.getClass();
        com.facebook.imagepipeline.platform.PlatformDecoder r8 = h();
        com.facebook.imagepipeline.decoder.DefaultImageDecoder r3 = new com.facebook.imagepipeline.decoder.DefaultImageDecoder(r8);
        r24.f8104j = r3;
        goto L17
    L50:
        java.lang.Class<?> r3 = java.lang.Class.forName("com.bytedance.fresco.heif.HeifDecoder$HeifFormatDecoder");     // Catch: java.lang.Throwable -> L49
        java.lang.Class<?>[] r8 = {com.facebook.common.memory.PooledByteBufferFactory.class};     // Catch: java.lang.Throwable -> L49
        java.lang.reflect.Constructor<?> r3 = r3.getConstructor(r8);     // Catch: java.lang.Throwable -> L49
        com.facebook.common.util.Lazy r8 = r24.f8101c;     // Catch: java.lang.Throwable -> L49
        java.lang.Object r8 = r8.a();     // Catch: java.lang.Throwable -> L49
        com.facebook.imagepipeline.core.ImagePipelineConfig r8 = (com.facebook.imagepipeline.core.ImagePipelineConfig) r8;     // Catch: java.lang.Throwable -> L49
        com.facebook.imagepipeline.memory.PoolFactory r8 = r8.f8079m;     // Catch: java.lang.Throwable -> L49
        com.facebook.common.memory.PooledByteBufferFactory r8 = r8.b(0);     // Catch: java.lang.Throwable -> L49
        java.lang.Object[] r8 = {r8};     // Catch: java.lang.Throwable -> L49
        java.lang.Object r3 = r3.newInstance(r8);     // Catch: java.lang.Throwable -> L49
        com.facebook.imagepipeline.decoder.ImageDecoder r3 = (com.facebook.imagepipeline.decoder.ImageDecoder) r3;     // Catch: java.lang.Throwable -> L49
        com.facebook.imagepipeline.core.ImagePipelineFactory.f8098v = r3;     // Catch: java.lang.Throwable -> L49
    L17:
        com.facebook.imagepipeline.decoder.DefaultImageDecoder r8 = r24.f8104j;
        com.facebook.common.util.Lazy r3 = r24.f8101c;
        java.lang.Object r3 = r3.a();
        com.facebook.imagepipeline.core.ImagePipelineConfig r3 = (com.facebook.imagepipeline.core.ImagePipelineConfig) r3;
        com.facebook.imagepipeline.decoder.SimpleProgressiveJpegConfig r9 = r3.f8080n;
        com.facebook.common.util.Lazy r3 = r24.f8101c;
        java.lang.Object r3 = r3.a();
        com.facebook.imagepipeline.core.ImagePipelineConfig r3 = (com.facebook.imagepipeline.core.ImagePipelineConfig) r3;
        r3.getClass();
        com.facebook.common.util.Lazy r3 = r24.f8101c;
        java.lang.Object r3 = r3.a();
        com.facebook.imagepipeline.core.ImagePipelineConfig r3 = (com.facebook.imagepipeline.core.ImagePipelineConfig) r3;
        boolean r10 = r3.f8083q;
        com.facebook.common.util.Lazy r3 = r24.f8101c;
        java.lang.Object r3 = r3.a();
        com.facebook.imagepipeline.core.ImagePipelineConfig r3 = (com.facebook.imagepipeline.core.ImagePipelineConfig) r3;
        com.facebook.imagepipeline.core.ImagePipelineExperiments r3 = r3.f8085t;
        r3.getClass();
        com.facebook.common.util.Lazy r3 = r24.f8101c;
        java.lang.Object r3 = r3.a();
        com.facebook.imagepipeline.core.ImagePipelineConfig r3 = (com.facebook.imagepipeline.core.ImagePipelineConfig) r3;
        com.facebook.imagepipeline.core.DefaultExecutorSupplier r11 = r3.g;
        com.facebook.common.util.Lazy r3 = r24.f8101c;
        java.lang.Object r3 = r3.a();
        com.facebook.imagepipeline.core.ImagePipelineConfig r3 = (com.facebook.imagepipeline.core.ImagePipelineConfig) r3;
        com.facebook.imagepipeline.memory.PoolFactory r3 = r3.f8079m;
        com.facebook.common.util.Lazy r12 = r24.f8101c;
        java.lang.Object r12 = r12.a();
        com.facebook.imagepipeline.core.ImagePipelineConfig r12 = (com.facebook.imagepipeline.core.ImagePipelineConfig) r12;
        r12.getClass();
        com.facebook.common.memory.PooledByteBufferFactory r12 = r3.b(0);
        com.facebook.imagepipeline.cache.InstrumentedMemoryCache r13 = c();
        com.facebook.imagepipeline.cache.InstrumentedMemoryCache r3 = r24.g;
        if (r3 != null) goto L26;
        com.facebook.common.util.Lazy r3 = r24.f8101c;
        java.lang.Object r3 = r3.a();
        com.facebook.imagepipeline.core.ImagePipelineConfig r3 = (com.facebook.imagepipeline.core.ImagePipelineConfig) r3;
        r3.getClass();
        com.facebook.imagepipeline.cache.CountingMemoryCache r3 = r24.f;
        if (r3 != null) goto L22;
        com.facebook.common.util.Lazy r3 = r24.f8101c;
        java.lang.Object r3 = r3.a();
        com.facebook.imagepipeline.core.ImagePipelineConfig r3 = (com.facebook.imagepipeline.core.ImagePipelineConfig) r3;
        com.facebook.imagepipeline.cache.DefaultEncodedMemoryCacheParamsSupplier r3 = r3.f;
        com.facebook.common.util.Lazy r5 = r24.f8101c;
        java.lang.Object r5 = r5.a();
        com.facebook.imagepipeline.core.ImagePipelineConfig r5 = (com.facebook.imagepipeline.core.ImagePipelineConfig) r5;
        com.facebook.common.memory.NoOpMemoryTrimmableRegistry r5 = r5.f8077k;
        com.facebook.imagepipeline.cache.CountingMemoryCache r3 = com.facebook.imagepipeline.cache.EncodedCountingMemoryCacheFactory.a(r3, r5);
        r24.f = r3;
    L22:
        com.facebook.imagepipeline.cache.CountingMemoryCache r3 = r24.f;
        if (r3 != null) goto L25;
        com.facebook.common.util.Lazy r3 = r24.f8101c;
        java.lang.Object r3 = r3.a();
        com.facebook.imagepipeline.core.ImagePipelineConfig r3 = (com.facebook.imagepipeline.core.ImagePipelineConfig) r3;
        com.facebook.imagepipeline.cache.DefaultEncodedMemoryCacheParamsSupplier r3 = r3.f;
        com.facebook.common.util.Lazy r5 = r24.f8101c;
        java.lang.Object r5 = r5.a();
        com.facebook.imagepipeline.core.ImagePipelineConfig r5 = (com.facebook.imagepipeline.core.ImagePipelineConfig) r5;
        com.facebook.common.memory.NoOpMemoryTrimmableRegistry r5 = r5.f8077k;
        com.facebook.imagepipeline.cache.CountingMemoryCache r3 = com.facebook.imagepipeline.cache.EncodedCountingMemoryCacheFactory.a(r3, r5);
        r24.f = r3;
    L25:
        com.facebook.imagepipeline.cache.CountingMemoryCache r3 = r24.f;
        com.facebook.common.util.Lazy r5 = r24.f8101c;
        java.lang.Object r5 = r5.a();
        com.facebook.imagepipeline.core.ImagePipelineConfig r5 = (com.facebook.imagepipeline.core.ImagePipelineConfig) r5;
        com.facebook.imagepipeline.cache.NoOpImageCacheStatsTracker r5 = r5.f8074h;
        com.facebook.imagepipeline.cache.InstrumentedMemoryCache r3 = com.facebook.imagepipeline.cache.EncodedMemoryCacheFactory.a(r3, r5);
        r24.g = r3;
    L26:
        com.facebook.imagepipeline.cache.InstrumentedMemoryCache r14 = r24.g;
        com.facebook.imagepipeline.cache.BufferedDiskCache r15 = f();
        com.facebook.imagepipeline.cache.BufferedDiskCache r16 = i();
        java.util.HashMap r17 = d();
        com.facebook.common.util.Lazy r3 = r24.f8101c;
        java.lang.Object r3 = r3.a();
        com.facebook.imagepipeline.core.ImagePipelineConfig r3 = (com.facebook.imagepipeline.core.ImagePipelineConfig) r3;
        com.facebook.imagepipeline.cache.DefaultCacheKeyFactory r3 = r3.f8073c;
        com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory r5 = r24.s;
        if (r5 != null) goto L30;
        com.facebook.common.util.Lazy r5 = r24.f8101c;
        java.lang.Object r5 = r5.a();
        com.facebook.imagepipeline.core.ImagePipelineConfig r5 = (com.facebook.imagepipeline.core.ImagePipelineConfig) r5;
        com.facebook.imagepipeline.memory.PoolFactory r5 = r5.f8079m;
        com.facebook.imagepipeline.platform.PlatformDecoder r1 = h();
        com.facebook.imagepipeline.core.CloseableReferenceFactory r4 = r24.f8100b;
        com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory r1 = com.facebook.imagepipeline.bitmaps.PlatformBitmapFactoryProvider.a(r5, r1, r4);
        r24.s = r1;
    L30:
        com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory r1 = r24.s;
        com.facebook.common.util.Lazy r1 = r24.f8101c;
        java.lang.Object r1 = r1.a();
        com.facebook.imagepipeline.core.ImagePipelineConfig r1 = (com.facebook.imagepipeline.core.ImagePipelineConfig) r1;
        com.facebook.imagepipeline.core.ImagePipelineExperiments r1 = r1.f8085t;
        r1.getClass();
        com.facebook.common.util.Lazy r1 = r24.f8101c;
        java.lang.Object r1 = r1.a();
        com.facebook.imagepipeline.core.ImagePipelineConfig r1 = (com.facebook.imagepipeline.core.ImagePipelineConfig) r1;
        com.facebook.imagepipeline.core.ImagePipelineExperiments r1 = r1.f8085t;
        r1.getClass();
        com.facebook.common.util.Lazy r1 = r24.f8101c;
        java.lang.Object r1 = r1.a();
        com.facebook.imagepipeline.core.ImagePipelineConfig r1 = (com.facebook.imagepipeline.core.ImagePipelineConfig) r1;
        com.facebook.imagepipeline.core.ImagePipelineExperiments r1 = r1.f8085t;
        r1.getClass();
        com.facebook.common.util.Lazy r1 = r24.f8101c;
        java.lang.Object r1 = r1.a();
        com.facebook.imagepipeline.core.ImagePipelineConfig r1 = (com.facebook.imagepipeline.core.ImagePipelineConfig) r1;
        com.facebook.imagepipeline.core.ImagePipelineExperiments r1 = r1.f8085t;
        r1.getClass();
        com.facebook.imagepipeline.core.CloseableReferenceFactory r1 = r24.f8100b;
        com.facebook.common.util.Lazy r1 = r24.f8101c;
        java.lang.Object r1 = r1.a();
        com.facebook.imagepipeline.core.ImagePipelineConfig r1 = (com.facebook.imagepipeline.core.ImagePipelineConfig) r1;
        com.facebook.imagepipeline.core.ImagePipelineExperiments r1 = r1.f8085t;
        r1.getClass();
        com.facebook.common.util.Lazy r1 = r24.f8101c;
        java.lang.Object r1 = r1.a();
        com.facebook.imagepipeline.core.ImagePipelineConfig r1 = (com.facebook.imagepipeline.core.ImagePipelineConfig) r1;
        com.facebook.imagepipeline.core.ImagePipelineExperiments r1 = r1.f8085t;
        int r1 = r1.e;
        com.facebook.common.util.Lazy r1 = r24.f8101c;
        java.lang.Object r1 = r1.a();
        com.facebook.imagepipeline.core.ImagePipelineConfig r1 = (com.facebook.imagepipeline.core.ImagePipelineConfig) r1;
        com.facebook.imagepipeline.core.ImagePipelineExperiments r1 = r1.f8085t;
        r1.getClass();
        com.facebook.imagepipeline.core.ProducerFactory r1 = new com.facebook.imagepipeline.core.ProducerFactory(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r3, r1, r1, r1);
        r24.f8107m = r1;
    L32:
        com.facebook.imagepipeline.core.ProducerFactory r5 = r24.f8107m;
        com.facebook.common.util.Lazy r1 = r24.f8101c;
        java.lang.Object r1 = r1.a();
        com.facebook.imagepipeline.core.ImagePipelineConfig r1 = (com.facebook.imagepipeline.core.ImagePipelineConfig) r1;
        com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher r6 = r1.f8078l;
        com.facebook.common.util.Lazy r1 = r24.f8101c;
        java.lang.Object r1 = r1.a();
        com.facebook.imagepipeline.core.ImagePipelineConfig r1 = (com.facebook.imagepipeline.core.ImagePipelineConfig) r1;
        boolean r7 = r1.f8083q;
        com.facebook.common.util.Lazy r1 = r24.f8101c;
        java.lang.Object r1 = r1.a();
        com.facebook.imagepipeline.core.ImagePipelineConfig r1 = (com.facebook.imagepipeline.core.ImagePipelineConfig) r1;
        com.facebook.imagepipeline.core.ImagePipelineExperiments r1 = r1.f8085t;
        r1.getClass();
        com.facebook.common.util.Lazy r1 = r24.f8099a;
        java.lang.Object r1 = r1.a();
        com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue r8 = (com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue) r1;
        com.facebook.common.util.Lazy r1 = r24.f8101c;
        java.lang.Object r1 = r1.a();
        com.facebook.imagepipeline.core.ImagePipelineConfig r1 = (com.facebook.imagepipeline.core.ImagePipelineConfig) r1;
        r1.getClass();
        com.facebook.common.util.Lazy r1 = r24.f8101c;
        java.lang.Object r1 = r1.a();
        com.facebook.imagepipeline.core.ImagePipelineConfig r1 = (com.facebook.imagepipeline.core.ImagePipelineConfig) r1;
        com.facebook.imagepipeline.core.ImagePipelineExperiments r1 = r1.f8085t;
        r1.getClass();
        com.facebook.common.util.Lazy r1 = r24.f8101c;
        java.lang.Object r1 = r1.a();
        com.facebook.imagepipeline.core.ImagePipelineConfig r1 = (com.facebook.imagepipeline.core.ImagePipelineConfig) r1;
        boolean r9 = r1.f8086u;
        com.facebook.imagepipeline.transcoder.MultiImageTranscoderFactory r1 = r24.f8106l;
        if (r1 != null) goto L35;
        com.facebook.common.util.Lazy r1 = r24.f8101c;
        java.lang.Object r1 = r1.a();
        com.facebook.imagepipeline.core.ImagePipelineConfig r1 = (com.facebook.imagepipeline.core.ImagePipelineConfig) r1;
        r1.getClass();
        com.facebook.common.util.Lazy r1 = r24.f8101c;
        java.lang.Object r1 = r1.a();
        com.facebook.imagepipeline.core.ImagePipelineConfig r1 = (com.facebook.imagepipeline.core.ImagePipelineConfig) r1;
        r1.getClass();
        com.facebook.common.util.Lazy r1 = r24.f8101c;
        java.lang.Object r1 = r1.a();
        com.facebook.imagepipeline.core.ImagePipelineConfig r1 = (com.facebook.imagepipeline.core.ImagePipelineConfig) r1;
        com.facebook.imagepipeline.core.ImagePipelineExperiments r1 = r1.f8085t;
        r1.getClass();
        com.facebook.common.util.Lazy r3 = r24.f8101c;
        java.lang.Object r3 = r3.a();
        com.facebook.imagepipeline.core.ImagePipelineConfig r3 = (com.facebook.imagepipeline.core.ImagePipelineConfig) r3;
        com.facebook.imagepipeline.core.ImagePipelineExperiments r3 = r3.f8085t;
        r3.getClass();
        com.facebook.common.util.Lazy r3 = r24.f8101c;
        java.lang.Object r3 = r3.a();
        com.facebook.imagepipeline.core.ImagePipelineConfig r3 = (com.facebook.imagepipeline.core.ImagePipelineConfig) r3;
        com.facebook.imagepipeline.core.ImagePipelineExperiments r3 = r3.f8085t;
        r3.getClass();
        com.facebook.common.util.Lazy r3 = r24.f8101c;
        java.lang.Object r3 = r3.a();
        com.facebook.imagepipeline.core.ImagePipelineConfig r3 = (com.facebook.imagepipeline.core.ImagePipelineConfig) r3;
        r3.getClass();
        com.facebook.common.util.Lazy r3 = r24.f8101c;
        java.lang.Object r3 = r3.a();
        com.facebook.imagepipeline.core.ImagePipelineConfig r3 = (com.facebook.imagepipeline.core.ImagePipelineConfig) r3;
        r3.getClass();
        com.facebook.common.util.Lazy r3 = r24.f8101c;
        java.lang.Object r3 = r3.a();
        com.facebook.imagepipeline.core.ImagePipelineConfig r3 = (com.facebook.imagepipeline.core.ImagePipelineConfig) r3;
        com.facebook.imagepipeline.core.ImagePipelineExperiments r3 = r3.f8085t;
        boolean r3 = r3.d;
        com.facebook.imagepipeline.transcoder.MultiImageTranscoderFactory r1 = new com.facebook.imagepipeline.transcoder.MultiImageTranscoderFactory(r3);
        r24.f8106l = r1;
    L35:
        com.facebook.imagepipeline.transcoder.MultiImageTranscoderFactory r10 = r24.f8106l;
        com.facebook.common.util.Lazy r1 = r24.f8101c;
        java.lang.Object r1 = r1.a();
        com.facebook.imagepipeline.core.ImagePipelineConfig r1 = (com.facebook.imagepipeline.core.ImagePipelineConfig) r1;
        com.facebook.imagepipeline.core.ImagePipelineExperiments r1 = r1.f8085t;
        r1.getClass();
        com.facebook.common.util.Lazy r1 = r24.f8101c;
        java.lang.Object r1 = r1.a();
        com.facebook.imagepipeline.core.ImagePipelineConfig r1 = (com.facebook.imagepipeline.core.ImagePipelineConfig) r1;
        com.facebook.imagepipeline.core.ImagePipelineExperiments r1 = r1.f8085t;
        r1.getClass();
        android.content.ContentResolver r4 = r23;
        com.facebook.imagepipeline.core.ProducerSequenceFactory r2 = new com.facebook.imagepipeline.core.ProducerSequenceFactory(r4, r5, r6, r7, r8, r9, r10);
        r24.f8108n = r2;
    L37:
        com.facebook.imagepipeline.core.ProducerSequenceFactory r3 = r24.f8108n;
        com.facebook.common.util.Lazy r1 = r24.f8101c;
        java.lang.Object r1 = r1.a();
        com.facebook.imagepipeline.core.ImagePipelineConfig r1 = (com.facebook.imagepipeline.core.ImagePipelineConfig) r1;
        java.util.HashSet r1 = r1.f8081o;
        java.util.Set r4 = java.util.Collections.unmodifiableSet(r1);
        com.facebook.common.util.Lazy r1 = r24.f8101c;
        java.lang.Object r1 = r1.a();
        com.facebook.imagepipeline.core.ImagePipelineConfig r1 = (com.facebook.imagepipeline.core.ImagePipelineConfig) r1;
        java.util.HashSet r1 = r1.f8082p;
        java.util.Set r5 = java.util.Collections.unmodifiableSet(r1);
        com.facebook.common.util.Lazy r1 = r24.f8101c;
        java.lang.Object r1 = r1.a();
        com.facebook.imagepipeline.core.ImagePipelineConfig r1 = (com.facebook.imagepipeline.core.ImagePipelineConfig) r1;
        com.facebook.common.internal.Supplier r6 = r1.f8075i;
        com.facebook.imagepipeline.cache.InstrumentedMemoryCache r7 = c();
        com.facebook.imagepipeline.cache.InstrumentedMemoryCache r1 = r24.g;
        if (r1 != null) goto L46;
        com.facebook.common.util.Lazy r1 = r24.f8101c;
        java.lang.Object r1 = r1.a();
        com.facebook.imagepipeline.core.ImagePipelineConfig r1 = (com.facebook.imagepipeline.core.ImagePipelineConfig) r1;
        r1.getClass();
        com.facebook.imagepipeline.cache.CountingMemoryCache r1 = r24.f;
        if (r1 != null) goto L42;
        com.facebook.common.util.Lazy r1 = r24.f8101c;
        java.lang.Object r1 = r1.a();
        com.facebook.imagepipeline.core.ImagePipelineConfig r1 = (com.facebook.imagepipeline.core.ImagePipelineConfig) r1;
        com.facebook.imagepipeline.cache.DefaultEncodedMemoryCacheParamsSupplier r1 = r1.f;
        com.facebook.common.util.Lazy r2 = r24.f8101c;
        java.lang.Object r2 = r2.a();
        com.facebook.imagepipeline.core.ImagePipelineConfig r2 = (com.facebook.imagepipeline.core.ImagePipelineConfig) r2;
        com.facebook.common.memory.NoOpMemoryTrimmableRegistry r2 = r2.f8077k;
        com.facebook.imagepipeline.cache.CountingMemoryCache r1 = com.facebook.imagepipeline.cache.EncodedCountingMemoryCacheFactory.a(r1, r2);
        r24.f = r1;
    L42:
        com.facebook.imagepipeline.cache.CountingMemoryCache r1 = r24.f;
        if (r1 != null) goto L45;
        com.facebook.common.util.Lazy r1 = r24.f8101c;
        java.lang.Object r1 = r1.a();
        com.facebook.imagepipeline.core.ImagePipelineConfig r1 = (com.facebook.imagepipeline.core.ImagePipelineConfig) r1;
        com.facebook.imagepipeline.cache.DefaultEncodedMemoryCacheParamsSupplier r1 = r1.f;
        com.facebook.common.util.Lazy r2 = r24.f8101c;
        java.lang.Object r2 = r2.a();
        com.facebook.imagepipeline.core.ImagePipelineConfig r2 = (com.facebook.imagepipeline.core.ImagePipelineConfig) r2;
        com.facebook.common.memory.NoOpMemoryTrimmableRegistry r2 = r2.f8077k;
        com.facebook.imagepipeline.cache.CountingMemoryCache r1 = com.facebook.imagepipeline.cache.EncodedCountingMemoryCacheFactory.a(r1, r2);
        r24.f = r1;
    L45:
        com.facebook.imagepipeline.cache.CountingMemoryCache r1 = r24.f;
        com.facebook.common.util.Lazy r2 = r24.f8101c;
        java.lang.Object r2 = r2.a();
        com.facebook.imagepipeline.core.ImagePipelineConfig r2 = (com.facebook.imagepipeline.core.ImagePipelineConfig) r2;
        com.facebook.imagepipeline.cache.NoOpImageCacheStatsTracker r2 = r2.f8074h;
        com.facebook.imagepipeline.cache.InstrumentedMemoryCache r1 = com.facebook.imagepipeline.cache.EncodedMemoryCacheFactory.a(r1, r2);
        r24.g = r1;
    L46:
        f();
        i();
        d();
        com.facebook.common.util.Lazy r1 = r24.f8101c;
        java.lang.Object r1 = r1.a();
        com.facebook.imagepipeline.core.ImagePipelineConfig r1 = (com.facebook.imagepipeline.core.ImagePipelineConfig) r1;
        com.facebook.imagepipeline.cache.DefaultCacheKeyFactory r8 = r1.f8073c;
        com.facebook.common.util.Lazy r1 = r24.f8099a;
        java.lang.Object r1 = r1.a();
        com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue r1 = (com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue) r1;
        com.facebook.common.util.Lazy r1 = r24.f8101c;
        java.lang.Object r1 = r1.a();
        com.facebook.imagepipeline.core.ImagePipelineConfig r1 = (com.facebook.imagepipeline.core.ImagePipelineConfig) r1;
        com.facebook.imagepipeline.core.ImagePipelineExperiments r1 = r1.f8085t;
        com.facebook.common.internal.Supplier r9 = r1.f8092b;
        com.facebook.common.util.Lazy r1 = r24.f8101c;
        java.lang.Object r1 = r1.a();
        com.facebook.imagepipeline.core.ImagePipelineConfig r1 = (com.facebook.imagepipeline.core.ImagePipelineConfig) r1;
        com.facebook.imagepipeline.core.ImagePipelineExperiments r1 = r1.f8085t;
        r1.getClass();
        com.facebook.common.util.Lazy r1 = r24.f8101c;
        java.lang.Object r1 = r1.a();
        com.facebook.imagepipeline.core.ImagePipelineConfig r1 = (com.facebook.imagepipeline.core.ImagePipelineConfig) r1;
        r1.getClass();
        com.facebook.common.util.Lazy r1 = r24.f8101c;
        java.lang.Object r1 = r1.a();
        com.facebook.imagepipeline.core.ImagePipelineConfig r10 = (com.facebook.imagepipeline.core.ImagePipelineConfig) r1;
        new com.facebook.imagepipeline.core.ImagePipeline(r3, r4, r5, r6, r7, r8, r9, r10);
        com.facebook.imagepipeline.core.ImagePipeline r1 = r22;
        r24.f8105k = r1;
        goto L47
    L31:
        com.facebook.imagepipeline.core.ImagePipeline r1 = r1;
        r23 = r4;
        goto L32
    L36:
        r22 = r1;
    L47:
        com.facebook.imagepipeline.core.ImagePipeline r0 = r24.f8105k;
        return r0;
    }

    public final BufferedDiskCache f() {
        if (this.f8102h != null) goto L12;
        FileCache r5 = g();
        PoolFactory r10 = ((ImagePipelineConfig) this.f8101c.a()).f8079m;
        ((ImagePipelineConfig) this.f8101c.a()).getClass();
        PooledByteBufferFactory r11 = r10.b(0);
        PoolFactory r12 = ((ImagePipelineConfig) this.f8101c.a()).f8079m;
        if (r12.f8245h == null) goto L7;
    L10:
        this.f8102h = new BufferedDiskCache(r5, r11, r12.f8245h, ((ImagePipelineConfig) this.f8101c.a()).g.f8059a, ((ImagePipelineConfig) this.f8101c.a()).g.f8059a, ((ImagePipelineConfig) this.f8101c.a()).f8074h);
        ((ImagePipelineConfig) this.f8101c.a()).f8076j.getClass();
        BufferedDiskCache r13 = this.f8102h;
        ((ImagePipelineConfig) this.f8101c.a()).f8076j.getClass();
        r13.getClass();
        goto L12
    L7:
        if (r12.f8246i != null) goto L9;
        PoolConfig r14 = r12.f8242a;
        r12.f8246i = new GenericByteArrayPool(r14.d, r14.g, r14.f8239h);
    L9:
        r12.f8245h = new PooledByteStreams(r12.f8246i);
    L12:
        return this.f8102h;
    }

    public final FileCache g() {
        if (this.f8103i != null) goto L6;
        DiskCacheConfig r5 = ((ImagePipelineConfig) this.f8101c.a()).f8076j;
        this.f8103i = ((ImagePipelineConfig) this.f8101c.a()).e.a(r5);
    L6:
        return this.f8103i;
    }

    public final PlatformDecoder h() {
        if (this.f8113t != null) goto L6;
        PoolFactory r5 = ((ImagePipelineConfig) this.f8101c.a()).f8079m;
        ((ImagePipelineConfig) this.f8101c.a()).f8085t.getClass();
        ((ImagePipelineConfig) this.f8101c.a()).f8085t.getClass();
        this.f8113t = PlatformDecoderFactory.a(r5);
    L6:
        return this.f8113t;
    }

    public final BufferedDiskCache i() {
        if (this.f8109o != null) goto L15;
        if (this.f8111q != null) goto L7;
        DiskCacheConfig r5 = ((ImagePipelineConfig) this.f8101c.a()).f8084r;
        this.f8111q = ((ImagePipelineConfig) this.f8101c.a()).e.a(r5);
    L7:
        DiskStorageCache r10 = this.f8111q;
        PoolFactory r11 = ((ImagePipelineConfig) this.f8101c.a()).f8079m;
        ((ImagePipelineConfig) this.f8101c.a()).getClass();
        PooledByteBufferFactory r12 = r11.b(0);
        PoolFactory r13 = ((ImagePipelineConfig) this.f8101c.a()).f8079m;
        if (r13.f8245h == null) goto L10;
    L13:
        this.f8109o = new BufferedDiskCache(r10, r12, r13.f8245h, ((ImagePipelineConfig) this.f8101c.a()).g.f8059a, ((ImagePipelineConfig) this.f8101c.a()).g.f8059a, ((ImagePipelineConfig) this.f8101c.a()).f8074h);
        ((ImagePipelineConfig) this.f8101c.a()).f8076j.getClass();
        BufferedDiskCache r14 = this.f8109o;
        ((ImagePipelineConfig) this.f8101c.a()).f8076j.getClass();
        r14.getClass();
        goto L15
    L10:
        if (r13.f8246i != null) goto L12;
        PoolConfig r15 = r13.f8242a;
        r13.f8246i = new GenericByteArrayPool(r15.d, r15.g, r15.f8239h);
    L12:
        r13.f8245h = new PooledByteStreams(r13.f8246i);
    L15:
        return this.f8109o;
    }

    public final void a() {
        if (this.s != null) goto L5;
        this.s = PlatformBitmapFactoryProvider.a(((ImagePipelineConfig) this.f8101c.a()).f8079m, h(), this.f8100b);
    L5:
        PlatformBitmapFactory r5 = this.s;
        DefaultExecutorSupplier r10 = ((ImagePipelineConfig) this.f8101c.a()).g;
        CountingMemoryCache r11 = b();
        ((ImagePipelineConfig) this.f8101c.a()).f8085t.getClass();
        if (Class.forName("com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl").getConstructor(new Class[]{PlatformBitmapFactory.class, ExecutorSupplier.class, CountingMemoryCache.class, Boolean.TYPE}).newInstance(new Object[]{r5, r10, r11, Boolean.FALSE}) != null) goto L10;
        return;
    L10:
        throw new ClassCastException();     // Catch: Throwable -> L12
    }
}
