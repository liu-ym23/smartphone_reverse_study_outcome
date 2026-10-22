package com.larus.audio.call.tracer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public abstract class b {
    public b() {
    }

    public abstract void a(String r1, String r2, Integer r3);

    public abstract void c();

    public abstract String d();

    public abstract String e();

    public abstract void f(String r1, String r2);

    public static /* synthetic */ void b(b r1, String r2, String r3, int r4) {
        if ((r4 & 2) == 0) goto L5;
        r3 = null;
    L5:
        r1.a(r2, r3, null);
    }
}
