package com.bytedance.lego.init.model;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f2785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private IPeriodTask f2786b;
    private String c;

    public String a() {
        return this.f2785a;
    }

    public IPeriodTask b() {
        return this.f2786b;
    }

    public ExecutionPeriod c() {
        return ExecutionPeriod.from(this.c);
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append(this.f2785a);
        r0.append(", " + this.f2786b);
        r0.append(", " + this.c);
        return r0.toString();
    }
}
