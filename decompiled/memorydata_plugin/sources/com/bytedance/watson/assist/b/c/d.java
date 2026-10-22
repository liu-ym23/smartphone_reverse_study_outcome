package com.bytedance.watson.assist.b.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class d implements com.bytedance.watson.assist.c.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected String f3375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected int f3376b;
    protected long c;
    protected long d;
    protected long e;
    protected double f;
    protected double g;
    protected double h;
    protected double i;

    public d() {
        this.f3375a = null;
        this.f3376b = -1;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0.0d;
        this.g = 0.0d;
        this.h = 0.0d;
        this.i = 0.0d;
    }

    public long a() {
        return this.d;
    }

    public void a(int r1) {
        this.f3376b = r1;
    }

    public void a(long r5) {
        if (this.d >= 0) goto L5;
        return;
    L5:
        if (r5 <= 0) goto L9;
        this.f = a() / r5;
        return;
    }

    public void a(com.bytedance.watson.assist.c.b r7) {
        com.bytedance.watson.assist.c.b r8 = (com.bytedance.watson.assist.c.b) ZeusTransformUtils.wrapperContextForParams(r7, com.bytedance.watson.assist.c.b.class, "com.obric.memorydata.plugin");
        long r2 = b();
        if (r8 != null) goto L5;
        long r0 = 0;
    L6:
        long r3 = r2 - r0;
        this.d = r3;
        if (this.e != 0) goto L10;
        this.e = r3;
        return;
    L10:
        return;
    L5:
        r0 = ((d) ZeusTransformUtils.preCheckCast(r8, d.class, "com.obric.memorydata.plugin")).b();
        goto L6
    }

    public void a(String r1) {
        this.f3375a = r1;
    }

    public long b() {
        return this.c;
    }

    public void b(long r5) {
        if (this.d >= 0) goto L5;
        return;
    L5:
        if (r5 <= 0) goto L9;
        this.h = a() / r5;
        return;
    }

    public void c() {
        this.f3375a = null;
        this.f3376b = -1;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0.0d;
        this.g = 0.0d;
        this.h = 0.0d;
        this.i = 0.0d;
    }

    public void c(long r1) {
        this.c = r1;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("proc_stat:{pid=").append(this.f3376b).append(" process_name:").append(this.f3375a).append(" delta cpu_time:").append(a()).append(" cpu_usage:").append(this.f * 100.0d).append("%").append(" cpu_rate:").append(this.h).append("}");
        return r0.toString();
    }
}
