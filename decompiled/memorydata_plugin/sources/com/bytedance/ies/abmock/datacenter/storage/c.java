package com.bytedance.ies.abmock.datacenter.storage;

import com.google.gson.Gson;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class c implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f2709a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e f2710b;
    private Gson c;

    static {
        f2709a = new c();
    }

    private c() {
        e r0 = com.bytedance.ies.abmock.datacenter.e.a().c().g();
        if (ZeusTransformUtils.instanceOf(r0, com.bytedance.ies.abmock.datacenter.f.class) == true) goto L5;
        this.f2710b = new com.bytedance.ies.abmock.datacenter.g(r0);
        return;
    L5:
        this.f2710b = r0;
    }

    private String c(String r1) {
        return r1;
    }

    @Override // com.bytedance.ies.abmock.datacenter.storage.d
    public double a(String r1, double r2) {
        String r3 = c(r1);
        return this.f2710b.a(r3, r2);
    }

    @Override // com.bytedance.ies.abmock.datacenter.storage.d
    public float a(String r1, float r2) {
        String r3 = c(r1);
        return this.f2710b.a(r3, r2);
    }

    @Override // com.bytedance.ies.abmock.datacenter.storage.d
    public int a(String r1, int r2) {
        String r3 = c(r1);
        return this.f2710b.a(r3, r2);
    }

    @Override // com.bytedance.ies.abmock.datacenter.storage.d
    public long a(String r1, long r2) {
        String r3 = c(r1);
        return this.f2710b.a(r3, r2);
    }

    public Gson a() {
        if (this.c != null) goto L6;
        this.c = new Gson();
    L6:
        return this.c;
    }

    @Override // com.bytedance.ies.abmock.datacenter.storage.d
    public Object a(String r3, Class r4) {
        String r5 = c(r3);
        return a().fromJson(this.f2710b.a(r5, null), r4);
    L5:
        th = move-exception;
        com.bytedance.ies.abmock.datacenter.event.a.a(th, "HybridConfigCenterRepo");
        return null;
    }

    @Override // com.bytedance.ies.abmock.datacenter.storage.d
    public String a(String r1, String r2) {
        String r3 = c(r1);
        return this.f2710b.a(r3, r2);
    }

    @Override // com.bytedance.ies.abmock.datacenter.storage.d
    public boolean a(String r1, boolean r2) {
        String r3 = c(r1);
        return this.f2710b.a(r3, r2);
    }

    @Override // com.bytedance.ies.abmock.datacenter.storage.d
    public String[] a(String r2) {
        String r3 = c(r2);
        return this.f2710b.a(r3, null);
    }

    @Override // com.bytedance.ies.abmock.datacenter.storage.d
    public boolean b(String r1) {
        String r2 = c(r1);
        return this.f2710b.a(r2);
    }
}
