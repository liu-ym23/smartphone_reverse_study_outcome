package com.loc;

import com.amap.api.location.AMapLocation;

/* JADX INFO: loaded from: classes3.dex */
@w(a = "c")
public class ej {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @x(a = "a2", b = 6)
    private String f5493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @x(a = "a3", b = 5)
    private long f5494b;

    @x(a = "a4", b = 6)
    private String c;
    private AMapLocation d;

    public ej() {
    }

    public final AMapLocation a() {
        return this.d;
    }

    public final void a(long r1) {
        this.f5494b = r1;
    }

    public final void a(AMapLocation r1) {
        this.d = r1;
    }

    public final void a(String r1) {
        this.c = r1;
    }

    public final String b() {
        return this.c;
    }

    public final void b(String r1) {
        this.f5493a = r1;
    }

    public final String c() {
        return this.f5493a;
    }

    public final long d() {
        return this.f5494b;
    }
}
