package com.bytedance.apm;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f1273b;
    private String c;
    private int d;
    private String e;
    private int f;
    private String g;
    private String h;
    private JSONObject i;
    private Map<String, String> j;

    public int a() {
        return this.f1272a;
    }

    public String b() {
        return this.f1273b;
    }

    public long c() {
        if (b.t() != null) goto L5;
        return 0;
    L5:
        return b.t().b();
    }

    public String d() {
        if (b.t() != null) goto L5;
        return null;
    L5:
        return b.t().a();
    }

    public String e() {
        return this.c;
    }

    public int f() {
        return this.d;
    }

    public String g() {
        return this.e;
    }

    public int h() {
        return this.f;
    }

    public String i() {
        return this.g;
    }

    public String j() {
        return this.h;
    }

    public JSONObject k() {
        return this.i;
    }

    public Map<String, String> l() {
        return this.j;
    }
}
