package com.bytedance.apm.config;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f1258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f1259b;
    private long c;
    private boolean d;
    private boolean e;
    private int f;
    private boolean g;
    private long h;
    private boolean i;
    private boolean j;
    private boolean k;
    private long l;
    private long m;
    private boolean n;
    private boolean o;
    private JSONObject p;

    public e() {
    }

    public void a(int r1) {
        this.f = r1;
    }

    public void a(long r1) {
        this.c = r1;
    }

    public void a(JSONObject r1) {
        this.p = r1;
    }

    public void a(boolean r1) {
        this.f1258a = r1;
    }

    public boolean a() {
        return this.d;
    }

    public void b(long r1) {
        this.h = r1;
    }

    public void b(boolean r1) {
        this.f1259b = r1;
    }

    public boolean b() {
        return this.e;
    }

    public int c() {
        return this.f;
    }

    public void c(long r1) {
        this.l = r1;
    }

    public void c(boolean r1) {
        this.d = r1;
    }

    public void d(long r1) {
        this.m = r1;
    }

    public void d(boolean r1) {
        this.e = r1;
    }

    public boolean d() {
        return this.g;
    }

    public long e() {
        return this.h;
    }

    public void e(boolean r1) {
        this.g = r1;
    }

    public long f() {
        return this.l;
    }

    public void f(boolean r1) {
        this.i = r1;
    }

    public long g() {
        return this.m;
    }

    public void g(boolean r1) {
        this.j = r1;
    }

    public void h(boolean r1) {
        this.k = r1;
    }

    public boolean h() {
        return this.n;
    }

    public void i(boolean r1) {
        this.n = r1;
    }

    public boolean i() {
        return this.o;
    }

    public void j(boolean r1) {
        this.o = r1;
    }

    public String toString() {
        return "FluencyConfig{enableStackSampling=" + this.f1258a + ", enableTrace=" + this.f1259b + ", atraceTag=" + this.c + ", blockDumpStackEnable=" + this.d + ", enableGfxMonitor=" + this.e + ", blockMonitorMode=" + this.f + ", seriousBlockEnableUpload=" + this.g + ", seriousBlockThreshold=" + this.h + ", slowMethodEnableUpload=" + this.i + ", dropEnableUpload=" + this.j + ", fpsEnableUpload=" + this.k + ", blockThreshold=" + this.l + ", slowMethodDropThreshold=" + this.m + ", blockEnableUpload=" + this.n + ", dropSlowMethodSwitch=" + this.o + '}';
    }
}
