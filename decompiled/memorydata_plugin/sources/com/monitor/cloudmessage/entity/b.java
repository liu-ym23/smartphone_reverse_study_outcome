package com.monitor.cloudmessage.entity;

import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f5852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f5853b;
    private HashMap<String, String> c;

    private b(boolean r1, String r2, HashMap<String, String> r3) {
        this.f5852a = r1;
        this.f5853b = r2;
        this.c = r3;
    }

    public static b a(boolean r1, String r2, HashMap<String, String> r3) {
        return new b(r1, r2, r3);
    }

    public boolean a() {
        return this.f5852a;
    }

    public String b() {
        return this.f5853b;
    }

    public HashMap<String, String> c() {
        return this.c;
    }
}
