package com.larus.dora.impl.ota.g2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class AndroidG2OtaRuntime$b {
    private volatile int downloadId;
    private volatile long lastBytes;
    private volatile int lastPercent;
    private volatile BlockReason pauseReason;

    public final int a() {
        return this.downloadId;
    }

    public final long b() {
        return this.lastBytes;
    }

    public final int c() {
        return this.lastPercent;
    }

    public final BlockReason d() {
        return this.pauseReason;
    }

    public AndroidG2OtaRuntime$b(long r2) {
        this.pauseReason = BlockReason.NONE;
        this.lastBytes = r2;
        this.lastPercent = -1;
    }

    public final void e(int r1) {
        this.downloadId = r1;
    }

    public final void f(long r1) {
        this.lastBytes = r1;
    }

    public final void g(int r1) {
        this.lastPercent = r1;
    }

    public final void h(BlockReason r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.pauseReason = r2;
    }
}
