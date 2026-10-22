package d64;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import com.bytedance.awemeopen.servicesapi.context.AoHostService;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.common.disk.NoOpDiskTrimmableRegistry;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableOptions;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.net.FrescoTTNetFetcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    private static Context getContext() {
        int r0 = j64.b.a;
        return j64.b.a(AoHostService.class).getHostApplication();
    }

    public static void a() {
        if (Fresco.hasBeenInitialized() == false) goto L5;
        return;
    L5:
        Context r0 = getContext();
        ActivityManager r1 = (ActivityManager) r0.getSystemService("activity");
        DiskCacheConfig r2 = DiskCacheConfig.newBuilder(r0).setBaseDirectoryPath(r0.getExternalCacheDir()).setBaseDirectoryName("fresco_cache").setMaxCacheSize(10485760).setDiskTrimmableRegistry(NoOpDiskTrimmableRegistry.getInstance()).build();
        ImagePipelineConfig.Builder r3 = ImagePipelineConfig.newBuilder(r0).setNetworkFetcher(new FrescoTTNetFetcher()).setBitmapMemoryCacheParamsSupplier(new b(r1));
        monitor-enter(c.class);
    L14:
        th = move-exception;
        throw th;
    L8:
        if (c.c != null) goto L10;
        c.c = new c();     // Catch: Throwable -> L14
    L10:
        c r4 = c.c;     // Catch: Throwable -> L14
        monitor-exit(c.class);
        ImagePipelineConfig r5 = r3.setMemoryTrimmableRegistry(r4).setMainDiskCacheConfig(r2).setBitmapsConfig(Bitmap.Config.RGB_565).setDownsampleEnabled(true).build();
        AnimatedDrawableOptions.DEFAULTS = AnimatedDrawableOptions.newBuilder().setMaximumBytes(0).setAllowPrefetching(true).setForceKeepAllFramesInMemory(false).build();
        Fresco.initialize(r0, r5);
    }
}
