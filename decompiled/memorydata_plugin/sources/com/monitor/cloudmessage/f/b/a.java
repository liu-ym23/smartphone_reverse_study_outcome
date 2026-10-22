package com.monitor.cloudmessage.f.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class a extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected String f5855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected com.monitor.cloudmessage.f.a.a f5856b;
    protected boolean c;
    protected boolean d;
    protected boolean e;
    protected boolean f;
    protected boolean g;
    private List<String> o;

    public a(String r7, long r8, boolean r10, String r11, com.monitor.cloudmessage.f.a.a r12, HashMap<String, String> r13) {
        com.monitor.cloudmessage.f.a.a r14 = (com.monitor.cloudmessage.f.a.a) ZeusTransformUtils.wrapperContextForParams(r12, com.monitor.cloudmessage.f.a.a.class, "com.obric.memorydata.plugin");
        super(r8, r10, r11, r13);
        this.c = true;
        this.d = true;
        this.e = true;
        this.f = false;
        this.g = false;
        this.f5855a = r7;
        this.f5856b = r14;
    }

    public String a() {
        return this.f5855a;
    }

    public void a(List<String> r3) {
        this.o = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    public void a(boolean r1) {
        this.d = r1;
    }

    public com.monitor.cloudmessage.f.a.a b() {
        return this.f5856b;
    }

    public void b(boolean r1) {
        this.f = r1;
    }

    public void c(boolean r1) {
        this.g = r1;
    }

    public boolean c() {
        return this.c;
    }

    public boolean d() {
        return this.d;
    }

    public boolean e() {
        return this.e;
    }

    public boolean f() {
        return this.f;
    }

    public List<String> g() {
        return this.o;
    }

    public boolean h() {
        return this.g;
    }
}
