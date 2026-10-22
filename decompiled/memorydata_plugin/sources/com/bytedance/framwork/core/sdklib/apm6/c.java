package com.bytedance.framwork.core.sdklib.apm6;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f2584a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f2585b;
    private byte[] c;

    public c(byte[] r1, long r2, long r4) {
        this.c = r1;
        this.f2584a = r4;
        this.f2585b = r2;
    }

    public byte[] a() {
        return this.c;
    }

    public long b() {
        return this.f2584a;
    }

    public long c() {
        return this.f2585b;
    }

    public String toString() {
        return new JSONObject(new String(this.c)).toString();
    L4:
        return "";
    }
}
