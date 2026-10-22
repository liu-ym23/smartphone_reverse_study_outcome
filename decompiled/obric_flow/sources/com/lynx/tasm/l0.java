package com.lynx.tasm;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Float f10898a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.lynx.tasm.behavior.c f10899b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k f10900c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f10901h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f10902i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f10903j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f10904k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f10905l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f10906m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f10907n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f10908o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f10909p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ThreadStrategyForRendering f10910q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f10911r;
    public int s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public wc.f f10912t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f10913u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final fo.c f10914v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ln.b f10915w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final boolean f10916x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public HashMap f10917y;

    public l0() {
        this.g = false;
        this.f10901h = false;
        this.f10902i = false;
        this.f10903j = false;
        this.f10904k = true;
        this.f10905l = false;
        this.f10908o = 1.0f;
        this.f10909p = false;
        this.f10910q = ThreadStrategyForRendering.f10065b;
        this.f10911r = -1;
        this.s = -1;
        this.f10913u = false;
        LynxEnv.inst().lazyInitIfNeeded();
        this.f10900c = new k();
        this.f10899b = new com.lynx.tasm.behavior.c(LynxEnv.inst().getBehaviorMap());
        this.f10912t = new wc.f(8);
        this.f10916x = LynxEnv.inst().isLayoutOnlyEnabled();
        LynxEnv.inst().lazyInitIfNeeded();
        this.f10914v = LynxEnv.inst().getTemplateProvider();
    }

    public final void a(Class r5, Object r10, String r11) {
        k r12 = this.f10900c;
        r12.getClass();
        com.lynx.jsbridge.r r13 = new com.lynx.jsbridge.r();
        r13.f9940b = r5;
        r13.f9941c = r10;
        r13.f9939a = r11;
        r12.d.add(r13);
    }

    public final void b(String r5, fo.h r10) {
        this.f10900c.e.put(r5, r10);
    }

    public final void c(List r5) {
        com.lynx.tasm.behavior.c r10 = this.f10899b;
        r10.getClass();
        if (r5 == null) goto L9;
        Iterator r11 = r5.iterator();
    L7:
        if (r11.hasNext() == false) goto L11;
        r10.b((com.lynx.tasm.behavior.a) r11.next());
        goto L7
    L11:
        return;
    }
}
