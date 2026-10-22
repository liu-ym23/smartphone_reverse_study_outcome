package com.bytedance.android.live.core.utils.fresco;

import android.app.ActivityManager;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.q6;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.executors.DefaultSerialExecutorService;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.NoOpMemoryTrimmableRegistry;
import com.facebook.common.time.RealtimeSinceBootClock;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.frame.FrameScheduler;
import com.facebook.imagepipeline.animated.util.AnimatedDrawableUtil;
import com.facebook.imagepipeline.cache.BitmapCountingMemoryCacheFactory;
import com.facebook.imagepipeline.cache.BitmapMemoryCacheTrimStrategy;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.cache.DefaultBitmapMemoryCacheParamsSupplier;
import com.facebook.imagepipeline.common.ImageDecodeOptionsBuilder;
import com.facebook.imagepipeline.core.DefaultExecutorSupplier;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.memory.PoolConfig;
import com.facebook.imagepipeline.memory.PoolFactory;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e {
    public static CountingMemoryCache<CacheKey, CloseableImage> a;
    public static final Method b = null;
    public static final Method c = null;
    public static final Field d = null;
    public static f e;
    public static AnimatedDrawableUtil f;

    public class a implements Supplier<Integer> {
        public a() {
        }

        public final Object get() {
            return 1;
        }
    }

    public class b implements Supplier<Integer> {
        public b() {
        }

        public final Object get() {
            return 0;
        }
    }

    static {
        b = ImageDecodeOptionsBuilder.class.getDeclaredMethod("setPreDecodeFrameCount", new Class[]{Integer.TYPE});     // Catch: Throwable -> L5
        ALogger.i("Fresco", "Reflect method `setPreDecodeFrameCount` success.");     // Catch: Throwable -> L5
    L21:
        c = AnimatedDrawable2.class.getDeclaredMethod("setPrivateFrameScheduler", new Class[]{FrameScheduler.class});     // Catch: Throwable -> L10
        ALogger.i("Fresco", "Reflect method `setPrivateFrameScheduler` success.");     // Catch: Throwable -> L10
    L13:
        if (c != null) goto L25;
        Field r1 = AnimatedDrawable2.class.getDeclaredField("mFrameScheduler");     // Catch: Throwable -> L16
        d = r1;     // Catch: Throwable -> L16
        r1.setAccessible(true);     // Catch: Throwable -> L16
        ALogger.i("Fresco", "Reflect field `mFrameScheduler` success.");     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        d = null;
        ALogger.e("Fresco", "Reflect field `mFrameScheduler` failed." + Log.getStackTraceString(th));
        return;
    L25:
        return;
    L10:
        th = move-exception;
        c = null;
        ALogger.e("Fresco", "Reflect method `setPrivateFrameScheduler` failed." + Log.getStackTraceString(th));
    L5:
        th = move-exception;
        ALogger.e("Fresco", "Reflect method `setPreDecodeFrameCount` failed." + Log.getStackTraceString(th));
        goto L21
    }

    public static void b(AnimatedDrawable2 r5, FrameScheduler r6) {
        if (r5 != null) goto L4;
        return;
    L4:
        Method r0 = c;
        if (r0 == null) goto L7;
    L9:
        boolean r1 = false;
        if (r0 != null) goto L26;
    L16:
        if (r1 == true) goto L28;
        Field r2 = d;
        if (r2 == null) goto L29;
        r2.set(r5, r6);     // Catch: Throwable -> L21
        return;
    L21:
        th = move-exception;
        ALogger.e("Fresco", "set sFrameSchedulerField failed." + Log.getStackTraceString(th));
        return;
    L29:
        return;
    L28:
        return;
    L26:
        r0.invoke(r5, new Object[]{r6});     // Catch: Throwable -> L14
        r1 = true;
    L14:
        th = move-exception;
        ALogger.e("Fresco", "invoke setFrameScheduler failed." + Log.getStackTraceString(th));
        goto L16
    L7:
        if (d != null) goto L9;
    }

    public static void a(Context r12, PipelineDraweeController r13, String r14, boolean r15) {
        if (r12 == null) goto L19;
        if (r13 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r14) == true) goto L21;
        a r8 = new a();
        b r9 = new b();
        DefaultSerialExecutorService r4 = new DefaultSerialExecutorService(new DefaultExecutorSupplier(new PoolFactory(PoolConfig.newBuilder().setBitmapPoolType("dummy").build()).getFlexByteArrayPoolMaxNumThreads()).forDecode());
        if (a != null) goto L15;
        if (((Boolean) q6.a.getValue()).booleanValue() == false) goto L12;
        com.bytedance.android.live.core.utils.fresco.a r0 = new com.bytedance.android.live.core.utils.fresco.a((ActivityManager) r12.getSystemService("activity"));
    L13:
        a = BitmapCountingMemoryCacheFactory.get(r0, NoOpMemoryTrimmableRegistry.getInstance(), new BitmapMemoryCacheTrimStrategy());
        goto L15
    L12:
        r0 = new DefaultBitmapMemoryCacheParamsSupplier((ActivityManager) r12.getSystemService("activity"));
    L15:
        if (e != null) goto L17;
        e = new f();
    L17:
        r13.setCustomDrawableFactories(ImmutableList.of(new DrawableFactory[]{new n(e, UiThreadImmediateExecutorService.getInstance(), r4, RealtimeSinceBootClock.get(), ImagePipelineFactory.getInstance().getPlatformBitmapFactory(), a, r8, r9, r14, r15)}));
        return;
    L21:
        return;
    }
}
