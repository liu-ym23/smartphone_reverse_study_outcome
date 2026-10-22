package com.bytedance.apm.util;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f1501b;
    public long c;
    public float d;
    public long e;
    public long f;
    public long g;
    public long h;

    public s(int r1, String r2, long r3) {
        this.f1500a = r1;
        this.f1501b = r2;
        this.c = r3;
        this.d = 0.0f;
    }

    public s(int r1, String r2, long r3, long r5, long r7) {
        this.f1500a = r1;
        this.f1501b = r2;
        this.e = r3;
        this.f = r5;
        this.c = r3 + r5;
        this.g = r7;
        long r4 = ((SystemClock.elapsedRealtime() * b.a(100)) / 1000) - r7;
        this.h = r4;
        this.d = (this.c * 1.0f) / r4;
    }

    public void a(long r1) {
        this.c = r1;
    }
}
