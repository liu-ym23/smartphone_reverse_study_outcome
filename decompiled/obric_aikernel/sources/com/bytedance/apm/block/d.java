package com.bytedance.apm.block;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    String f750b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f751c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f752d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f753e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f754f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    long f755g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    long f756h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    long f757i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    boolean f758j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    boolean f759k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    volatile boolean f760l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    boolean f761m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    long f762n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    long f763o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    StackTraceElement[] f764p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    StackTraceElement[] f765q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    String f766r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    String f767s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    String f768t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    JSONObject f769u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    JSONObject f770v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    JSONObject f771w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    JSONObject f772x;

    d(long r10, String r11) {
        this.f749a = true;
        this.f751c = false;
        this.f752d = false;
        this.f753e = false;
        this.f754f = false;
        this.f755g = -1;
        this.f756h = -1;
        this.f758j = false;
        this.f759k = false;
        this.f760l = false;
        this.f755g = r10;
        this.f750b = r11;
    }

    d a() {
        d r10 = new d(this.f755g, this.f750b);
        r10.f756h = this.f756h;
        r10.f749a = this.f749a;
        r10.f751c = this.f751c;
        r10.f752d = this.f752d;
        r10.f753e = this.f753e;
        r10.f754f = this.f754f;
        r10.f757i = this.f757i;
        r10.f758j = this.f758j;
        r10.f759k = this.f759k;
        r10.f762n = this.f762n;
        r10.f763o = this.f763o;
        r10.f764p = this.f764p;
        r10.f765q = this.f765q;
        r10.f766r = this.f766r;
        r10.f767s = this.f767s;
        r10.f768t = this.f768t;
        r10.f769u = this.f769u;
        r10.f770v = this.f770v;
        r10.f771w = this.f771w;
        r10.f772x = this.f772x;
        r10.f761m = this.f761m;
        return r10;
    }

    void b() {
        this.f749a = true;
        this.f751c = false;
        this.f752d = false;
        this.f753e = false;
        this.f754f = false;
        this.f757i = 0;
        this.f758j = false;
        this.f760l = false;
        this.f759k = false;
        this.f761m = false;
        this.f762n = 0;
        this.f763o = 0;
        this.f764p = null;
        this.f765q = null;
        this.f766r = null;
        this.f767s = null;
        this.f768t = null;
        this.f769u = null;
        this.f770v = null;
        this.f771w = null;
        this.f772x = null;
    }

    void c(long r10, String r11) {
        this.f755g = r10;
        this.f750b = r11;
        this.f756h = -1;
        this.f749a = false;
    }
}
