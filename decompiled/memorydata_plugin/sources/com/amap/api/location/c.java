package com.amap.api.location;

import com.loc.ev;

/* JADX INFO: loaded from: classes.dex */
public class c implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    AMapLocationClientOption.AMapLocationMode f493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f494b;
    private int c;
    private int d;
    private String e;
    private long f;
    private boolean g;

    public c() {
        this.f494b = false;
        this.c = 2;
        this.d = 0;
        this.e = "UNKNOWN";
        this.f = 0;
        this.g = false;
        this.f493a = AMapLocationClientOption.AMapLocationMode.Hight_Accuracy;
    }

    public c a() {
        c r0 = new c();
        super.clone();     // Catch: Throwable -> L9
    L12:
        r0.a(this.c);     // Catch: Throwable -> L6
        r0.b(this.d);     // Catch: Throwable -> L6
        r0.a(this.f494b);     // Catch: Throwable -> L6
        r0.a(this.f);     // Catch: Throwable -> L6
        r0.a(this.e);     // Catch: Throwable -> L6
        r0.a(this.f493a);     // Catch: Throwable -> L6
        r0.b(this.g);     // Catch: Throwable -> L6
    L8:
        return r0;
    L6:
        th = move-exception;
        ev.a(th, "AMapLocationQualityReport", "clone");
        goto L8
    }

    public void a(int r1) {
        this.c = r1;
    }

    public void a(long r1) {
        this.f = r1;
    }

    public void a(AMapLocationClientOption.AMapLocationMode r1) {
        this.f493a = r1;
    }

    public void a(String r1) {
        this.e = r1;
    }

    public void a(boolean r1) {
        this.f494b = r1;
    }

    public void b(int r1) {
        this.d = r1;
    }

    public void b(boolean r1) {
        this.g = r1;
    }

    public /* synthetic */ Object clone() {
        return a();
    }
}
