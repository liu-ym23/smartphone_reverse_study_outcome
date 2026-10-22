package com.bytedance.apm.block.a;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long[] f1194a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1195b;

    public e() {
        this.f1194a = new long[4];
        this.f1195b = false;
    }

    public void a() {
        long[] r0 = this.f1194a;
        r0[0] = 0;
        r0[1] = 0;
        r0[2] = Long.MAX_VALUE;
        r0[3] = 0;
        this.f1195b = false;
    }

    public void a(long r7) {
        long[] r0 = this.f1194a;
        if (r0[0] != 0) goto L5;
        r0[0] = SystemClock.uptimeMillis();
    L5:
        long[] r1 = this.f1194a;
        r1[1] = r1[1] + 1;
        if (r7 >= r1[2]) goto L9;
        r1[2] = r7;
    L9:
        if (r7 <= r1[3]) goto L11;
        r1[3] = r7;
    L11:
        this.f1195b = true;
    }

    public boolean b() {
        long[] r5 = this.f1194a;
        if ((r5[0] - r5[2]) <= 100) goto L6;
        return true;
    L6:
        return false;
    }
}
