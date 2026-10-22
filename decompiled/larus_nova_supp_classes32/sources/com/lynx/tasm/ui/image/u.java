package com.lynx.tasm.ui.image;

import android.graphics.drawable.Drawable;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.executors.HandlerExecutorServiceImpl;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawable.base.DrawableWithCaches;
import com.facebook.drawee.backends.pipeline.info.ImageOriginListener;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class u extends q<CloseableReference<CloseableImage>, ImageInfo> {
    public final DrawableFactory q;
    public final MemoryCache<CacheKey, CloseableImage> r;
    public Supplier<DataSource<CloseableReference<CloseableImage>>> s;
    public ImageOriginListener t;

    @Override // com.lynx.tasm.ui.image.q
    public final DataSource<CloseableReference<CloseableImage>> e() {
        return (DataSource) this.s.get();
    }

    @Override // com.lynx.tasm.ui.image.q
    public final String toString() {
        return Objects.toStringHelper(this).add("super", super.toString()).add("dataSourceSupplier", this.s).toString();
    }

    @Override // com.lynx.tasm.ui.image.q
    public final Drawable c(CloseableReference<CloseableImage> r4) {
        CloseableReference<CloseableImage> r5 = r4;
        Preconditions.checkState(CloseableReference.isValid(r5));
        CloseableImage r6 = (CloseableImage) r5.get();
        Drawable r0 = this.q.createDrawable(r6);
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new UnsupportedOperationException("Unrecognized image class: " + r6);
    }

    @Override // com.lynx.tasm.ui.image.q
    public final int f(CloseableReference<CloseableImage> r1) {
        CloseableReference<CloseableImage> r2 = r1;
        if (r2 != null) goto L7;
        return 0;
    L7:
        return r2.getValueHash();
    }

    @Override // com.lynx.tasm.ui.image.q
    public final ImageInfo g(CloseableReference<CloseableImage> r2) {
        CloseableReference<CloseableImage> r3 = r2;
        Preconditions.checkState(CloseableReference.isValid(r3));
        return (ImageInfo) r3.get();
    }

    @Override // com.lynx.tasm.ui.image.q
    public final void k(Drawable r2) {
        if ((r2 instanceof DrawableWithCaches) == false) goto L6;
        ((DrawableWithCaches) r2).dropCaches();
        return;
    }

    @Override // com.lynx.tasm.ui.image.q
    public final void m(CloseableReference<CloseableImage> r1) {
        CloseableReference.closeSafely(r1);
    }

    public u(a r1, DrawableFactory r2, HandlerExecutorServiceImpl r3, MemoryCache r4) {
        super(r1, r3);
        this.q = r2;
        this.r = r4;
    }
}
