package com.bytedance.retrofit2.mime;

import java.io.OutputStream;
import r4.f;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected volatile boolean f2552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected volatile String f2553b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected volatile String f2554c;

    public a() {
    }

    @Override // r4.f
    public String a() {
        return null;
    }

    @Override // r4.f
    public String b() {
        return null;
    }

    @Override // r4.f
    public String d() {
        return this.f2554c;
    }

    public String e() {
        return this.f2553b;
    }

    public abstract TTRequestCompressManager.b f(String r10, String r11, boolean r12);

    public String g() {
        return this.f2554c;
    }

    public abstract boolean h();

    public boolean i() {
        return this.f2552a;
    }

    @Override // r4.f
    public long length() {
        return 0;
    }

    @Override // r4.f
    public void writeTo(OutputStream r10) {
    }
}
