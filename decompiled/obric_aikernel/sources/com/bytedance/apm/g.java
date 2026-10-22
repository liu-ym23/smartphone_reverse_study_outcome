package com.bytedance.apm;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f943b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f944c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f945d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f946e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f947f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f948g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f949h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private JSONObject f950i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Map<String, String> f951j;

    public g() {
    }

    public int a() {
        return this.f942a;
    }

    public String b() {
        return this.f948g;
    }

    public String c() {
        return this.f944c;
    }

    public String d() {
        return this.f943b;
    }

    public int e() {
        return this.f947f;
    }

    public Map<String, String> f() {
        return this.f951j;
    }

    public String g() {
        return this.f949h;
    }

    public String h() {
        if (d.i() != null) goto L5;
        return null;
    L5:
        return d.i().getSessionId();
    }

    public JSONObject i() {
        return this.f950i;
    }

    public long j() {
        if (d.i() != null) goto L5;
        return 0;
    L5:
        return d.i().getUid();
    }

    public int k() {
        return this.f945d;
    }

    public String l() {
        return this.f946e;
    }

    public void m(int r10) {
        this.f942a = r10;
    }

    public void n(String r10) {
        this.f948g = r10;
    }

    public void o(String r10) {
        this.f944c = r10;
    }

    public void p(String r10) {
        this.f943b = r10;
    }

    public void q(int r10) {
        this.f947f = r10;
    }

    public void r(Map<String, String> r10) {
        this.f951j = r10;
    }

    public void s(String r10) {
    }

    public void t(String r10) {
        this.f949h = r10;
    }

    public void u(JSONObject r10) {
        this.f950i = r10;
    }

    public void v(int r10) {
        this.f945d = r10;
    }

    public void w(int r10) {
    }

    public void x(String r10) {
        this.f946e = r10;
    }
}
