package com.bytedance.apm.util;

import android.os.SystemClock;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class t {
    public final int a;
    public final String b;
    public long c;
    public float d;
    public final long e;
    public final long f;
    public long g;

    public t(int r1, String r2, long r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = 0.0f;
    }

    public t(int r1, String r2, long r3, long r5, long r7) {
        this.a = r1;
        this.b = r2;
        this.e = r3;
        this.f = r5;
        this.c = r3 + r5;
        long r4 = ((SystemClock.elapsedRealtime() * b.f()) / 1000) - r7;
        this.g = r4;
        this.d = (this.c * 1.0f) / r4;
    }
}
