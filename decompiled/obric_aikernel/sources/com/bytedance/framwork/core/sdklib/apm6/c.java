package com.bytedance.framwork.core.sdklib.apm6;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f1902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f1903b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private byte[] f1904c;

    public c(byte[] r10, long r11, long r12) {
        this.f1904c = r10;
        this.f1902a = r12;
        this.f1903b = r11;
    }

    public long a() {
        return this.f1903b;
    }

    public byte[] b() {
        return this.f1904c;
    }

    public long c() {
        return this.f1902a;
    }

    public String toString() {
        return new JSONObject(new String(this.f1904c)).toString();
    L4:
        return "";
    }
}
