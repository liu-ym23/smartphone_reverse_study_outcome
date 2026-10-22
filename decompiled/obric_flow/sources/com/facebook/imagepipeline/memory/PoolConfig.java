package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import com.facebook.common.memory.NoOpMemoryTrimmableRegistry;
import com.facebook.imagepipeline.systrace.FrescoSystrace;

/* JADX INFO: loaded from: classes2.dex */
public class PoolConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PoolParams f8236a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final NoOpPoolStatsTracker f8237b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PoolParams f8238c;
    public final NoOpMemoryTrimmableRegistry d;
    public final PoolParams e;
    public final NoOpPoolStatsTracker f;
    public final PoolParams g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final NoOpPoolStatsTracker f8239h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f8240i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f8241j;

    public static class Builder {
        public Builder() {
        }
    }

    public PoolConfig(Builder r14) {
        FrescoSystrace.a().getClass();
        SparseIntArray r15 = DefaultBitmapPoolParams.f8218a;
        int r5 = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        if (r5 <= 16777216) goto L5;
        int r10 = (r5 / 4) * 3;
    L6:
        this.f8236a = new PoolParams(0, r10, DefaultBitmapPoolParams.f8218a, -1);
        monitor-enter(NoOpPoolStatsTracker.class);
    L11:
        th = move-exception;
        throw th;
    L9:
        if (NoOpPoolStatsTracker.f8235a != null) goto L13;
        NoOpPoolStatsTracker.f8235a = new NoOpPoolStatsTracker();     // Catch: Throwable -> L11
    L13:
        NoOpPoolStatsTracker r11 = NoOpPoolStatsTracker.f8235a;     // Catch: Throwable -> L11
        monitor-exit(NoOpPoolStatsTracker.class);     // Catch: Throwable -> L11
        this.f8237b = r11;
        int r12 = DefaultFlexByteArrayPoolParams.f8219a;
        int r13 = r12 * 4194304;
        SparseIntArray r16 = new SparseIntArray();
        int r17 = 131072;
    L16:
        if (r17 > 4194304) goto L18;
        r16.put(r17, r12);
        r17 = r17 * 2;
        goto L16
    L18:
        this.f8238c = new PoolParams(4194304, r13, r16, DefaultFlexByteArrayPoolParams.f8219a);
        this.d = NoOpMemoryTrimmableRegistry.a();
        SparseIntArray r18 = new SparseIntArray();
        r18.put(1024, 5);
        r18.put(2048, 5);
        r18.put(4096, 5);
        r18.put(8192, 5);
        r18.put(16384, 5);
        r18.put(32768, 5);
        r18.put(65536, 5);
        r18.put(131072, 5);
        r18.put(262144, 2);
        r18.put(524288, 2);
        r18.put(1048576, 2);
        int r19 = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        if (r19 >= 16777216) goto L22;
        int r110 = 3145728;
    L25:
        int r20 = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        if (r20 >= 16777216) goto L28;
        int r21 = r20 / 2;
    L29:
        this.e = new PoolParams(r110, r21, r18, -1);
        this.f = NoOpPoolStatsTracker.a();
        SparseIntArray r111 = new SparseIntArray();
        r111.put(16384, 5);
        this.g = new PoolParams(81920, 1048576, r111, -1);
        this.f8239h = NoOpPoolStatsTracker.a();
        this.f8240i = "legacy";
        this.f8241j = 4194304;
        FrescoSystrace.a().getClass();
        return;
    L28:
        r21 = (r20 / 4) * 3;
        goto L29
    L22:
        if (r19 >= 33554432) goto L24;
        r110 = 6291456;
        goto L25
    L24:
        r110 = 12582912;
        goto L25
    L5:
        r10 = r5 / 2;
        goto L6
    }
}
