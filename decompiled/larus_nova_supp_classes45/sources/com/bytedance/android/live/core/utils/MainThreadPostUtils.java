package com.bytedance.android.live.core.utils;

import android.os.Handler;
import android.os.Looper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class MainThreadPostUtils {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, MainThreadPostUtils$sHandler$2.INSTANCE);
    }

    @JvmStatic
    public static final boolean a() {
        return Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper());
    }

    @JvmStatic
    public static final void b(Runnable r1) {
        if (r1 == null) goto L5;
        ((Handler) a.getValue()).post(r1);
        return;
    }

    @JvmStatic
    public static final void d(Runnable r1) {
        if (r1 == null) goto L5;
        ((Handler) a.getValue()).removeCallbacks(r1);
        return;
    }

    @JvmStatic
    public static final void e(Runnable r1) {
        if (a() == false) goto L5;
        r1.run();
        return;
    L5:
        b(r1);
    }

    @JvmStatic
    public static final void c(Runnable r1, long r2) {
        if (r1 == null) goto L5;
        ((Handler) a.getValue()).postDelayed(r1, r2);
        return;
    }
}
