package com.bytedance.apm.agent.tracing;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f1096b;
    public long c;
    public long d;
    public long e;
    public long f;
    public long g;

    public b(String r1, long r2) {
        this.f1095a = r1;
        this.f1096b = r2;
    }

    public boolean a() {
        if (this.f1096b > 0) goto L5;
    L11:
        return false;
    L5:
        if (this.c <= 0) goto L11;
        if (this.d <= 0) goto L11;
        if (this.e <= 0) goto L11;
        return true;
    }
}
