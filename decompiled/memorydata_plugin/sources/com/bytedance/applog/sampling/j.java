package com.bytedance.applog.sampling;

/* JADX INFO: loaded from: classes.dex */
public class j implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f1874a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f1875b;
    private String c;
    private String d;
    private String e;

    public j(String r1, String r2) {
        this.f1874a = r1;
        this.f1875b = r2;
    }

    public j(String r1, String r2, String r3) {
        this(r1, r2);
        this.e = r3;
    }

    @Override // com.bytedance.applog.sampling.b
    public String a() {
        return this.f1874a;
    }

    public void a(String r1) {
        this.c = r1;
    }

    @Override // com.bytedance.applog.sampling.b
    public String b() {
        return this.f1875b;
    }

    public void b(String r1) {
        this.d = r1;
    }

    @Override // com.bytedance.applog.sampling.b
    public String c() {
        return this.c;
    }

    @Override // com.bytedance.applog.sampling.b
    public String d() {
        return this.d;
    }
}
