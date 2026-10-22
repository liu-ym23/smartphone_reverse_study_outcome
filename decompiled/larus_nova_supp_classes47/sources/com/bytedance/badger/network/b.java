package com.bytedance.badger.network;

import android.os.SystemClock;
import com.bytedance.android.live.saas.middleware.fresco.DefaultConfig;
import com.bytedance.badger.data.ReportStage;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    public final int a;
    public final z64.c b;
    public final z64.g c;
    public final ReportStage d;
    public final boolean e;
    public final long f;
    public final long g;
    public final long h;
    public final boolean i;

    public final boolean equals(Object r8) {
        if (this != r8) goto L5;
    L44:
        return true;
    L5:
        if ((r8 instanceof b) == false) goto L43;
        b r9 = (b) r8;
        if (this.a != r9.a) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == false) goto L43;
        if (Intrinsics.areEqual(this.b, r9.b) == false) goto L43;
        if (Intrinsics.areEqual(this.c, r9.c) == false) goto L43;
        if (Intrinsics.areEqual(this.d, r9.d) == false) goto L43;
        if (this.e != r9.e) goto L20;
        boolean r2 = true;
    L21:
        if (r2 == false) goto L43;
        if (this.f != r9.f) goto L25;
        boolean r3 = true;
    L26:
        if (r3 == false) goto L43;
        if (this.g != r9.g) goto L30;
        boolean r4 = true;
    L31:
        if (r4 == false) goto L43;
        if (this.h != r9.h) goto L35;
        boolean r5 = true;
    L36:
        if (r5 == false) goto L43;
        if (this.i != r9.i) goto L40;
        boolean r10 = true;
    L41:
        if (r10 == false) goto L43;
    L40:
        r10 = false;
        goto L41
    L35:
        r5 = false;
        goto L36
    L30:
        r4 = false;
        goto L31
    L25:
        r3 = false;
        goto L26
    L20:
        r2 = false;
        goto L21
    L9:
        r1 = false;
    L43:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4 */
    public final int hashCode() {
        int r0 = this.a * 31;
        z64.c r1 = this.b;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        z64.g r5 = this.c;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (r4 + r6) * 31;
        ReportStage r8 = this.d;
        if (r8 == null) goto L13;
        r2 = r8.hashCode();
    L13:
        int r9 = (r7 + r2) * 31;
        boolean r10 = this.e;
        ?? r12 = 1;
        ?? r13 = r10;
        if (r10 == false) goto L16;
        r13 = 1;
    L16:
        long r14 = this.f;
        int r15 = (((r9 + r13) * 31) + ((int) (r14 ^ (r14 >>> 32)))) * 31;
        long r16 = this.g;
        int r17 = (r15 + ((int) (r16 ^ (r16 >>> 32)))) * 31;
        long r18 = this.h;
        int r19 = (r17 + ((int) (r18 ^ (r18 >>> 32)))) * 31;
        boolean r20 = this.i;
        if (r20 == true) goto L21;
        r12 = r20;
    L21:
        return r19 + r12;
    L9:
        r6 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    public final String toString() {
        return "CustomReportContext(sceneId=" + this.a + ", badgerRequest=" + this.b + ", callback=" + this.c + ", reportStage=" + this.d + ", isTimeoutRetry=" + this.e + ", timeoutElapsedTimeMs=" + this.f + ", startTime=" + this.g + ", startUptime=" + this.h + ", ignoreCheckForeground=" + this.i + ")";
    }

    public b(int r3, z64.c r4, z64.g r5, ReportStage r6, boolean r7, long r8, long r10, long r12, boolean r14, int r15) {
        if ((r15 & 8) == 0) goto L6;
        r6 = ReportStage.FINAL;
    L6:
        if ((r15 & 16) == 0) goto L9;
        r7 = false;
    L9:
        if ((r15 & 32) == 0) goto L12;
        r8 = 0;
    L12:
        if ((r15 & 64) == 0) goto L15;
        r10 = SystemClock.elapsedRealtime();
    L15:
        if ((r15 & 128) == 0) goto L18;
        r12 = SystemClock.uptimeMillis();
    L18:
        if ((r15 & DefaultConfig.MAX_CACHE_ENTRIES) == 0) goto L20;
        r14 = false;
    L20:
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r10;
        this.h = r12;
        this.i = r14;
    }
}
