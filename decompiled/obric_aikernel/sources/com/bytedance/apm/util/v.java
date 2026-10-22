package com.bytedance.apm.util;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1149a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f1150b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f1151c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f1152d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f1153e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f1154f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f1155g;

    public v(int r10, String r11, long r12) {
        this.f1149a = r10;
        this.f1150b = r11;
        this.f1151c = r12;
        this.f1152d = 0.0f;
    }

    public v(int r10, String r11, long r12, long r13, long r14) {
        this.f1149a = r10;
        this.f1150b = r11;
        this.f1153e = r12;
        this.f1154f = r13;
        this.f1151c = r12 + r13;
        long r15 = ((SystemClock.elapsedRealtime() * b.k(100)) / 1000) - r14;
        this.f1155g = r15;
        this.f1152d = (this.f1151c * 1.0f) / r15;
    }

    public void a(long r10) {
        this.f1151c = r10;
    }
}
