package com.facebook.drawee.controller;

import android.content.Context;
import com.facebook.common.internal.Supplier;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSources;
import com.facebook.datasource.IncreasingQualityDataSourceSupplier;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerFactory;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.imagepipeline.cache.BitmapMemoryCacheKey;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractDraweeControllerBuilder<BUILDER extends AbstractDraweeControllerBuilder<BUILDER, REQUEST, IMAGE, INFO>, REQUEST, IMAGE, INFO> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ControllerListener f7792i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final NullPointerException f7793j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final AtomicLong f7794k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7795a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f7796b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageRequest f7797c;
    public ImageRequest d;
    public ControllerListener e;
    public boolean f;
    public boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public DraweeController f7798h;

    public static final enum CacheLevel extends Enum<CacheLevel> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final CacheLevel f7802a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ CacheLevel[] f7803b = null;

        static {
            CacheLevel r5 = new CacheLevel("FULL_FETCH", 0);
            f7802a = r5;
            f7803b = new CacheLevel[]{r5, new CacheLevel("DISK_CACHE", 1), new CacheLevel("BITMAP_MEMORY_CACHE", 2)};
        }

        public CacheLevel(String r5, int r10) {
            super(r5, r10);
        }

        public static CacheLevel valueOf(String r5) {
            return (CacheLevel) Enum.valueOf(CacheLevel.class, r5);
        }

        public static CacheLevel[] values() {
            return (CacheLevel[]) f7803b.clone();
        }
    }

    public abstract class CustomSupplier<D> implements Supplier<DataSource<IMAGE>> {
        public CustomSupplier() {
        }
    }

    static {
        f7792i = new AnonymousClass1();
        f7793j = new NullPointerException("No image request was specified!");
        f7794k = new AtomicLong();
    }

    public AbstractDraweeControllerBuilder(Context r5) {
        this.f7795a = r5;
        b();
    }

    public final PipelineDraweeController a() {
        BitmapMemoryCacheKey r5 = null;
        if (this.f7797c != null) goto L7;
        ImageRequest r10 = this.d;
        if (r10 == null) goto L7;
        this.f7797c = r10;
        this.d = null;
    L7:
        FrescoSystrace.a().getClass();
        PipelineDraweeControllerBuilder r11 = (PipelineDraweeControllerBuilder) this;
        FrescoSystrace.a().getClass();
        DraweeController r12 = r11.f7798h;     // Catch: Throwable -> L11
        String r13 = String.valueOf(f7794k.getAndIncrement());     // Catch: Throwable -> L11
        if ((r12 instanceof PipelineDraweeController) == false) goto L13;
        PipelineDraweeController r14 = (PipelineDraweeController) r12;     // Catch: Throwable -> L11
    L14:
        r14.getClass();     // Catch: Throwable -> L11
        Supplier r15 = r11.a(r14, r13);     // Catch: Throwable -> L11
        ImageRequest r16 = r11.f7797c;     // Catch: Throwable -> L11
        DefaultCacheKeyFactory r17 = r11.f7735l.f;     // Catch: Throwable -> L11
        if (r17 == null) goto L21;
        if (r16 == null) goto L21;
        if (r16.f8422m == null) goto L20;
        r5 = r17.b(r16, r11.f7796b);     // Catch: Throwable -> L11
        goto L21
    L20:
        r5 = r17.a(r16, r11.f7796b);     // Catch: Throwable -> L11
    L21:
        PipelineDraweeController r18 = r14;
        r18.a(r15, r13, r5, r11.f7796b, r11.f7737n, r11.f7797c);     // Catch: Throwable -> L11
        monitor-enter(r14);     // Catch: Throwable -> L11
        r14.C = r11.f7797c;     // Catch: Throwable -> L39
        r14.D = r11.d;     // Catch: Throwable -> L39
        monitor-exit(r14);     // Catch: Throwable -> L39
        FrescoSystrace.a().getClass();
        r14.f7783m = this.g;
        r14.f7788r = this.f7797c;
        r14.s = this.d;
        ControllerListener r19 = this.e;
        if (r19 == null) goto L28;
        r14.a(r19);
    L28:
        Object r20 = r14.d;
        if (r20 != null) goto L32;
        r20 = BaseControllerListener.f7804a;
    L32:
        if ((r20 instanceof BaseControllerListener) == false) goto L35;
        System.currentTimeMillis();
        ((BaseControllerListener) r20).a();
    L35:
        if (this.f == false) goto L37;
        r14.a(f7792i);
    L37:
        FrescoSystrace.a().getClass();
        return r14;
    L39:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L13:
        PipelineDraweeControllerFactory r21 = r11.f7736m;     // Catch: Throwable -> L11
        r14 = new PipelineDraweeController(r21.f7741a, r21.f7742b, r21.f7743c, r21.d);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        FrescoSystrace.a().getClass();
        throw th;
    }

    public final void b() {
        this.f7796b = null;
        this.f7797c = null;
        this.d = null;
        this.e = null;
        this.f = false;
        this.f7798h = null;
    }

    public final Supplier a(final PipelineDraweeController r10, final String r11) {
        final ImageRequest r5 = this.f7797c;
        if (r5 == null) goto L5;
        final CacheLevel r12 = CacheLevel.f7802a;
        final Object r13 = this.f7796b;
        Supplier r14 = new AnonymousClass2(this, r5, r10, r11, r13, r12);
    L6:
        if (r14 != null) goto L8;
    L10:
        if (r14 == null) goto L12;
        return r14;
    L12:
        return DataSources.a(f7793j);
    L8:
        if (this.d == null) goto L10;
        ArrayList r15 = new ArrayList(2);
        r15.add(r14);
        final ImageRequest r16 = this.d;
        final CacheLevel r17 = CacheLevel.f7802a;
        final Object r18 = this.f7796b;
        r15.add(new AnonymousClass2(this, r16, r10, r11, r18, r17));
        r14 = new IncreasingQualityDataSourceSupplier(r15);
        goto L10
    L5:
        r14 = null;
        goto L6
    }
}
