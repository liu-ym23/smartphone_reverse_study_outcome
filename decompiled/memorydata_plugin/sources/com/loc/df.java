package com.loc;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class df {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f5432a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, String> f5433b;
    boolean c;
    public byte[] d;
    public int e;

    public df() {
        this.f5433b = new HashMap();
        this.c = true;
        this.e = 10000;
    }

    public static String a() {
        return "lc_" + dc.a();
    }

    public static String b() {
        return dc.c() + "*" + dc.f();
    }
}
