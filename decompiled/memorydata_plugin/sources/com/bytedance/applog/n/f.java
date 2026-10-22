package com.bytedance.applog.n;

/* JADX INFO: loaded from: classes.dex */
public class f extends e {
    public f() {
        super(null, null);
    }

    public f(String r1, String r2) {
        super(r1, r2);
    }

    public static a a(e r3) {
        f r0 = new f(r3.m, r3.x);
        r0.y = r3.y;
        r0.v = r3.v;
        r0.a(r3.f1725b);
        r0.h = r3.h;
        r0.c = r3.c;
        r0.n = r3.n;
        r0.i = r3.i;
        r0.d = r3.d;
        r0.f = r3.f;
        r0.e = r3.e;
        r0.g = r3.g;
        r0.l = r3.l;
        r0.k = r3.k;
        r0.j = r3.j;
        r0.w = r3.w;
        r0.p = 1;
        r0.r = r3.r;
        r0.s = r3.s;
        return r0;
    }

    @Override // com.bytedance.applog.n.e
    public void a(com.bytedance.applog.priority.a r1) {
    }

    @Override // com.bytedance.applog.n.e, com.bytedance.applog.n.a
    String h() {
        return "forward_eventv3";
    }
}
