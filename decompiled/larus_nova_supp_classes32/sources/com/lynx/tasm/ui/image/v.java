package com.lynx.tasm.ui.image;

import android.content.Context;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSources;
import com.facebook.datasource.IncreasingQualityDataSourceSupplier;
import com.facebook.drawee.backends.pipeline.DefaultDrawableFactory;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.info.ImageOriginListener;
import com.facebook.drawee.backends.pipeline.info.ImageOriginRequestListener;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class v extends LynxAbstractDraweeControllerBuilder<v, ImageRequest, CloseableReference<CloseableImage>, ImageInfo> {
    public final ImagePipeline m;
    public final DrawableFactory n;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[LynxAbstractDraweeControllerBuilder.CacheLevel.values().length];
            a = r0;
            r0[LynxAbstractDraweeControllerBuilder.CacheLevel.FULL_FETCH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            a[LynxAbstractDraweeControllerBuilder.CacheLevel.DISK_CACHE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            a[LynxAbstractDraweeControllerBuilder.CacheLevel.BITMAP_MEMORY_CACHE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public final u b() {
        q r0 = this.i;
        String r1 = String.valueOf(LynxAbstractDraweeControllerBuilder.l.getAndIncrement());
        if ((r0 instanceof u) == false) goto L6;
        u r2 = (u) r0;
    L17:
        REQUEST r7 = this.d;
        if (r7 == 0) goto L20;
        u r5 = r2;
        IncreasingQualityDataSourceSupplier r10 = new s(this, r5, r1, r7, this.c, LynxAbstractDraweeControllerBuilder.CacheLevel.FULL_FETCH);
    L22:
        if (r10 != null) goto L24;
    L26:
        if (r10 != null) goto L28;
        r10 = DataSources.getFailedDataSourceSupplier(LynxAbstractDraweeControllerBuilder.k);
    L28:
        Object r3 = this.c;
        r2.t = null;
        r2.h(r1, r3);
        r2.j = false;
        r2.s = r10;
        return r2;
    L24:
        if (this.e == 0) goto L26;
        ArrayList r12 = new ArrayList(2);
        r12.add(r10);
        u r6 = r2;
        r12.add(new s(this, r6, r1, this.e, this.c, LynxAbstractDraweeControllerBuilder.CacheLevel.FULL_FETCH));
        r10 = IncreasingQualityDataSourceSupplier.create(r12, false);
        goto L26
    L20:
        r10 = null;
        goto L22
    L6:
        monitor-enter(com.lynx.tasm.ui.image.a.class);
    L30:
        th = move-exception;
        throw th;
    L8:
        if (com.lynx.tasm.ui.image.a.c != null) goto L10;
        com.lynx.tasm.ui.image.a.c = new com.lynx.tasm.ui.image.a();     // Catch: Throwable -> L30
    L10:
        com.lynx.tasm.ui.image.a r4 = com.lynx.tasm.ui.image.a.c;     // Catch: Throwable -> L30
        monitor-exit(com.lynx.tasm.ui.image.a.class);
        DrawableFactory r8 = this.n;
        if (this.b == false) goto L15;
        l8a.e r9 = l8a.e.a();
    L16:
        r2 = new u(r4, r8, r9, this.m.getBitmapMemoryCache());
        goto L17
    L15:
        r9 = UiThreadImmediateExecutorService.getInstance();
        goto L16
    }

    public v(Context r1, DefaultDrawableFactory r2) {
        super(r1);
        this.m = Fresco.getImagePipeline();
        this.n = r2;
    }

    @Override // com.lynx.tasm.ui.image.LynxAbstractDraweeControllerBuilder
    public final DataSource a(q r5, Object r6, Object r7, LynxAbstractDraweeControllerBuilder.CacheLevel r8) {
        ImageRequest r9 = (ImageRequest) r6;
        ImagePipeline r0 = this.m;
        int r1 = a.a[r8.ordinal()];
        if (r1 != 1) goto L5;
        ImageRequest.RequestLevel r10 = ImageRequest.RequestLevel.FULL_FETCH;
    L13:
        ImageOriginRequestListener r2 = null;
        if ((r5 instanceof u) == false) goto L26;
        u r11 = (u) r5;
        monitor-enter(r11);
        ImageOriginListener r3 = r11.t;     // Catch: Throwable -> L22
        if (r3 == null) goto L20;
        r2 = new ImageOriginRequestListener(r11.o, r3);     // Catch: Throwable -> L22
    L20:
        monitor-exit(r11);
    L22:
        th = move-exception;
        throw th;
    L26:
        return r0.fetchDecodedImage(r9, r7, r10, r2);
    L5:
        if (r1 != 2) goto L7;
        r10 = ImageRequest.RequestLevel.DISK_CACHE;
        goto L13
    L7:
        if (r1 != 3) goto L10;
        r10 = ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE;
        goto L13
    L10:
        throw new RuntimeException("Cache level" + r8 + "is not supported. ");
    }
}
