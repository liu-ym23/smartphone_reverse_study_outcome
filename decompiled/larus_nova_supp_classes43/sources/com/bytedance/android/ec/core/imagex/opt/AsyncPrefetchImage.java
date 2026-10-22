package com.bytedance.android.ec.core.imagex.opt;

import com.bytedance.android.ec.ab.opt.LazyOptGetSettings;
import com.bytedance.android.ec.core.imagex.ImageExperiments;
import com.bytedance.android.ec.core.opt.ab.LazyFastSDKSettings;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AsyncPrefetchImage {
    public static final /* synthetic */ KProperty[] a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;
    public static final Lazy e = null;
    public static final Lazy f = null;
    public static final LazyOptGetSettings g = null;
    public static final Executor h = null;
    public static final AsyncPrefetchImage i = null;

    public static final class a implements ThreadFactory {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r10) {
            return new PthreadThreadV2(r10, "AsyncPrefetchImage$asyncWorker$2");
        }
    }

    static {
        a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(AsyncPrefetchImage.class, "priorityConfig", "getPriorityConfig()Lcom/bytedance/android/shopping/api/image/NetworkPriorityModel;", 0))};
        i = new AsyncPrefetchImage();
        b = LazyKt.lazy(AsyncPrefetchImage$enableOptValue$2.INSTANCE);
        c = LazyKt.lazy(AsyncPrefetchImage$enableOtherThreadOpt$2.INSTANCE);
        d = LazyKt.lazy(AsyncPrefetchImage$enableForcePriority$2.INSTANCE);
        e = LazyKt.lazy(AsyncPrefetchImage$enableOpt$2.INSTANCE);
        f = LazyKt.lazy(AsyncPrefetchImage$priority$2.INSTANCE);
        final String r10 = "ec_async_image_prefetch_priority_opt";
        final com.bytedance.android.shopping.api.image.e0 r11 = new com.bytedance.android.shopping.api.image.e0(null);
        AsyncPrefetchImage$priorityConfig$2 r12 = AsyncPrefetchImage$priorityConfig$2.INSTANCE;
        ImageXSettingKt$lazyImageXSettings$4 r13 = new ImageXSettingKt$lazyImageXSettings$4(null);
        if (z.b() == false) goto L5;
        LazyOptGetSettings r1 = new LazyFastSDKSettings("ec_async_image_prefetch_priority_opt", r11, null, r12, r13, new AsyncPrefetchImage$$special$$inlined$lazyImageXSettings$1(r10, r11));
    L6:
        g = r1;
        ImageExperiments.G.getClass();
        int r14 = ((Number) ImageExperiments.l.getValue()).intValue();
        if (r14 != 1) goto L9;
        PThreadPoolExecutor r0 = new com.bytedance.android.ec.core.imagex.common.b("AsyncPrefetchImageThread");
    L19:
        h = r0;
        return;
    L9:
        if (r14 != 2) goto L11;
        int r15 = Runtime.getRuntime().availableProcessors();     // Catch: Throwable -> L16
    L17:
        r0 = new PThreadPoolExecutor(r15, r15 * 2, 30, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("AsyncPrefetchImage"));
    L16:
        r15 = 4;
        goto L17
    L11:
        if (r14 == 3) goto L13;
        r0 = new PThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), a.a);
        goto L19
    L13:
        r0 = AsyncPrefetchImage$asyncWorker$1.a;
        goto L19
    L5:
        r1 = com.bytedance.android.ec.core.opt.ab.h.a("ec_async_image_prefetch_priority_opt", r11, null, r12, r13);
        goto L6
    }

    public AsyncPrefetchImage() {
    }

    public static final int a(AsyncPrefetchImage r0) {
        r0.getClass();
        return ((Number) b.getValue()).intValue();
    }
}
