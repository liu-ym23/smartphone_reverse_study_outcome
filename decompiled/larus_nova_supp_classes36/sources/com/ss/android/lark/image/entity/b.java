package com.ss.android.lark.image.entity;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class b {
    public final String a;

    public abstract String b();

    public b() {
        this("");
    }

    public final String toString() {
        return "key=" + a() + ",level=" + b();
    }

    public String a() {
        return this.a;
    }

    public b(String r1) {
        this.a = r1;
    }
}
