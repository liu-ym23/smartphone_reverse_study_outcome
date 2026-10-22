package com.facebook.imagepipeline.cache;

import android.app.ActivityManager;
import com.facebook.common.internal.Supplier;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class DefaultBitmapMemoryCacheParamsSupplier implements Supplier<MemoryCacheParams> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f8029b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ActivityManager f8030a;

    static {
        f8029b = TimeUnit.MINUTES.toMillis(5);
    }

    public DefaultBitmapMemoryCacheParamsSupplier(ActivityManager r5) {
        this.f8030a = r5;
    }

    @Override // com.facebook.common.internal.Supplier
    public final Object get() {
        int r10 = Math.min(this.f8030a.getMemoryClass() * 1048576, Integer.MAX_VALUE);
        if (r10 >= 33554432) goto L7;
        int r11 = 4194304;
    L5:
        int r5 = r11;
        return new MemoryCacheParams(r5, 256, Integer.MAX_VALUE, Integer.MAX_VALUE, f8029b);
    L7:
        if (r10 >= 67108864) goto L9;
        r11 = 6291456;
        goto L5
    L9:
        r11 = r10 / 4;
        goto L5
    }
}
