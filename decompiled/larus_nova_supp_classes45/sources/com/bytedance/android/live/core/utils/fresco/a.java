package com.bytedance.android.live.core.utils.fresco;

import android.app.ActivityManager;
import com.facebook.common.internal.Supplier;
import com.facebook.imagepipeline.cache.MemoryCacheParams;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements Supplier<MemoryCacheParams> {
    public final WeakReference<ActivityManager> a;

    /* JADX INFO: renamed from: com.bytedance.android.live.core.utils.fresco.a$a, reason: collision with other inner class name */
    public static final class C0171a {
    }

    static {
    }

    public final Object get() {
        ActivityManager r0 = this.a.get();
        if (r0 == null) goto L5;
        int r1 = r0.getMemoryClass();
    L6:
        int r2 = Math.min(r1 * 1048576, Integer.MAX_VALUE);
        if (r2 >= 33554432) goto L10;
        int r3 = 4194304;
    L14:
        return new MemoryCacheParams(r3, 256, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
    L10:
        if (r2 >= 67108864) goto L12;
        r3 = 6291456;
        goto L14
    L12:
        r3 = r2 / 4;
        goto L14
    L5:
        r1 = 256;
        goto L6
    }

    public a(ActivityManager r2) {
        Intrinsics.checkNotNullParameter(r2, "activityManager");
        this.a = new WeakReference(r2);
    }
}
