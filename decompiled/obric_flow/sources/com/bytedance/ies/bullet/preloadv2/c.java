package com.bytedance.ies.bullet.preloadv2;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.LazyKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f5880a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f5881b = 10;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f5882c = 10485760;
    public static final int d = 0;
    public static final int e = 0;
    public static final ThreadPoolExecutor f = null;

    static {
        int r5 = Runtime.getRuntime().availableProcessors();
        int r10 = RangesKt.coerceAtLeast(2, RangesKt.coerceAtMost(r5 - 1, 4));
        d = r10;
        int r11 = (r5 * 2) + 1;
        e = r11;
        f = new ThreadPoolExecutor(r10, r11, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), b.f5879a);
        LazyKt.lazy(PreloadV2$memReadHandler$2.f5878a);
    }
}
