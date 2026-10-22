package com.bytedance.android.live.core.utils.fresco;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.executors.DefaultSerialExecutorService;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.internal.Supplier;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.time.RealtimeSinceBootClock;
import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.backend.AnimationBackendDelegate;
import com.facebook.fresco.animation.backend.AnimationBackendDelegateWithInactivityCheck;
import com.facebook.fresco.animation.bitmap.BitmapAnimationBackend;
import com.facebook.fresco.animation.bitmap.BitmapFrameCache;
import com.facebook.fresco.animation.bitmap.cache.FrescoFrameCache;
import com.facebook.fresco.animation.bitmap.cache.KeepLastFrameCache;
import com.facebook.fresco.animation.bitmap.cache.NoOpCache;
import com.facebook.fresco.animation.bitmap.preparation.BitmapFramePreparationStrategy;
import com.facebook.fresco.animation.bitmap.preparation.BitmapFramePreparer;
import com.facebook.fresco.animation.bitmap.preparation.DefaultBitmapFramePreparer;
import com.facebook.fresco.animation.bitmap.preparation.FixedNumberBitmapFramePreparationStrategy;
import com.facebook.fresco.animation.bitmap.wrapper.AnimatedDrawableBackendAnimationInformation;
import com.facebook.fresco.animation.bitmap.wrapper.AnimatedDrawableBackendFrameRenderer;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.factory.ExperimentalBitmapAnimationDrawableFactory;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendProvider;
import com.facebook.imagepipeline.animated.impl.AnimatedFrameCache;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableAnimatedImage;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class n implements DrawableFactory {
    public final AnimatedDrawableBackendProvider a;
    public final ScheduledExecutorService b;
    public final ExecutorService c;
    public final MonotonicClock d;
    public final PlatformBitmapFactory e;
    public final CountingMemoryCache<CacheKey, CloseableImage> f;
    public final Supplier<Integer> g;
    public final Supplier<Integer> h;
    public final String i;
    public final boolean j;

    public final AnimatedFrameCache a(AnimatedImageResult r9) {
        String r1 = this.i;
    L8:
        th = move-exception;
        Log.getStackTraceString(th);
    L10:
        CloseableReference r2 = null;
    L16:
        th = move-exception;
        Log.getStackTraceString(th);
        String r0 = null;
    L18:
        if (r0 != null) goto L20;
    L21:
        r0 = this.i;
    L23:
        if (TextUtils.isEmpty(r0) == false) goto L25;
        int r3 = r9.hashCode();
    L27:
        if (this.j == false) goto L29;
        AnimatedFrameCache r4 = new l(new ExperimentalBitmapAnimationDrawableFactory.AnimationFrameCacheKey(r3), this.f);
    L30:
        int r5 = r9.getDecodedFrameSize();
        if (r5 <= 0) goto L46;
        int r6 = 0;
    L33:
        if (r6 >= r5) goto L46;
        if (r9.hasDecodedFrame(r6) == false) goto L45;
        CloseableReference r7 = CloseableReference.of(new CloseableStaticBitmap(r9.getDecodedFrame(r6), ImmutableQualityInfo.FULL_QUALITY, 0));     // Catch: Throwable -> L42
        r4.cache(r6, r7);     // Catch: Throwable -> L40
        CloseableReference.closeSafely(r7);
    L40:
        th = th;
        r2 = r7;
    L43:
        CloseableReference.closeSafely(r2);
        throw th;
    L42:
        th = th;
    L45:
        r6 = r6 + 1;
    L46:
        return r4;
    L29:
        r4 = new AnimatedFrameCache(new ExperimentalBitmapAnimationDrawableFactory.AnimationFrameCacheKey(r3), this.f);
        goto L30
    L25:
        r3 = r0.hashCode();
        goto L27
    L20:
        if (TextUtils.isEmpty(r0) == false) goto L23;
    L12:
        if (g.a != null) goto L14;
        Field r8 = AnimatedImageResult.class.getDeclaredField("mSourceUri");     // Catch: Throwable -> L16
        g.a = r8;     // Catch: Throwable -> L16
        r8.setAccessible(true);     // Catch: Throwable -> L16
    L14:
        r0 = (String) g.a.get(r9);     // Catch: Throwable -> L16
        goto L18
    L4:
        if (g.a != null) goto L6;
        Field r11 = AnimatedImageResult.class.getDeclaredField("mSourceUri");     // Catch: Throwable -> L8
        g.a = r11;     // Catch: Throwable -> L8
        r11.setAccessible(true);     // Catch: Throwable -> L8
    L6:
        g.a.set(r9, r1);     // Catch: Throwable -> L8
        goto L10
    }

    public final AnimatedDrawable2 b(CloseableImage r18) {
        CloseableAnimatedImage r1 = (CloseableAnimatedImage) r18;
        AnimatedImageResult r2 = r1.getImageResult();
        if (r2.getImage().getFrameCount() > 0) goto L5;
        return null;
    L5:
        int r3 = ((Integer) this.g.get()).intValue();
        if (r3 == 1) goto L12;
        if (r3 == 2) goto L11;
        if (r3 == 3) goto L10;
        NoOpCache r4 = new NoOpCache();
    L13:
        int r5 = r2.getImage().getDecodeStatus();
        AnimatedImageResult r9 = r1.getImageResult();
        AnimatedImage r11 = r9.getImage();
        AnimatedDrawableBackend r12 = this.a.get(r9, new Rect(0, 0, r11.getWidth(), r11.getHeight()));
        AnimatedDrawableBackendFrameRenderer r14 = new AnimatedDrawableBackendFrameRenderer(r4, r12);
        int r13 = r1.getOptions().preDecodeFrameCount;
        if (r13 > 0) goto L17;
        r13 = ((Integer) this.h.get()).intValue();
    L17:
        if (r13 <= 0) goto L19;
        BitmapFramePreparationStrategy r15 = new FixedNumberBitmapFramePreparationStrategy(r13);
        BitmapFramePreparer r16 = new DefaultBitmapFramePreparer(this.e, r14, r1.getOptions().bitmapConfig, this.c);
    L20:
        BitmapAnimationBackend r17 = new BitmapAnimationBackend(this.e, r4, new AnimatedDrawableBackendAnimationInformation(r12), r14, r15, r16);
        r17.setBitmapConfig(r1.getOptions().bitmapConfig);
        AnimationBackendDelegate r6 = AnimationBackendDelegateWithInactivityCheck.createForBackend(r17, this.d, this.b);
        Object r7 = r1.getOptions().decodeContext;
        ImageFormat r19 = DefaultImageFormats.WEBP_ANIMATED;
        if (g.b != null) goto L24;
        g.b = AnimatedDrawable2.class.getConstructor(new Class[]{AnimationBackend.class, Object.class, BitmapFrameCache.class, Integer.TYPE, ImageFormat.class});     // Catch: Throwable -> L26
    L24:
        return g.b.newInstance(new Object[]{r6, r7, r4, Integer.valueOf(r5), r19});
    L27:
        if (g.b == null) goto L33;
    L30:
        return null;
    L33:
        Constructor<AnimatedDrawable2> r21 = AnimatedDrawable2.class.getConstructor(new Class[]{AnimationBackend.class, Object.class, BitmapFrameCache.class, Integer.TYPE});     // Catch: Throwable -> L32
        g.b = r21;     // Catch: Throwable -> L32
        return r21.newInstance(new Object[]{r6, r7, r4, Integer.valueOf(r5)});
    L19:
        r15 = null;
        r16 = null;
        goto L20
    L10:
        r4 = new KeepLastFrameCache();
        goto L13
    L11:
        r4 = new FrescoFrameCache(a(r2), false);
        goto L13
    L12:
        r4 = new FrescoFrameCache(a(r2), true);
        goto L13
    }

    public final /* bridge */ /* synthetic */ Drawable createDrawable(CloseableImage r1) {
        return b(r1);
    }

    public final boolean supportsImageType(CloseableImage r1) {
        return r1 instanceof CloseableAnimatedImage;
    }

    public final Drawable createDrawable(CloseableImage r2, Drawable r3) {
        if (((CloseableAnimatedImage) r2).getImageResult().getImage().getFrameCount() > 0) goto L5;
        return r3;
    L5:
        boolean r4 = r3 instanceof AnimatedDrawable2;
        return b(r2);
    }

    public n(f r1, UiThreadImmediateExecutorService r2, DefaultSerialExecutorService r3, RealtimeSinceBootClock r4, PlatformBitmapFactory r5, CountingMemoryCache r6, e.a r7, e.b r8, String r9, boolean r11) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r11;
    }
}
