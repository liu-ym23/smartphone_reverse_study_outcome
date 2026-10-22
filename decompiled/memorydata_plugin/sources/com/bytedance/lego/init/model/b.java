package com.bytedance.lego.init.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class b implements Comparable<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2783a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f2784b;
    public String c;
    public IInitTask d;
    public boolean e;
    public List<String> f;
    public float g;
    public List<String> h;
    public List<String> i;
    public List<String> j;
    public volatile InitPeriod k;
    public volatile long l;
    public volatile long m;
    public volatile boolean n;

    public b() {
        this.g = 0.0f;
    }

    public b(String r3, boolean r4, float r5, List<String> r6, List<String> r7, List<String> r8, List<String> r9, String r10, InitPeriod r11) {
        List<String> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        List<String> r13 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        List<String> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        List<String> r15 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        this.g = 0.0f;
        this.f2783a = r3;
        this.e = r4;
        this.f = r12;
        this.g = r5;
        this.h = r13;
        this.i = r14;
        this.j = r15;
        this.c = r10;
        this.k = r11;
    }

    public int a(b r4) {
        float r0 = r4.g - this.g;
        if (r0 <= 0.0f) goto L7;
        return 1;
    L7:
        if (r0 >= 0.0f) goto L11;
        return -1;
    L11:
        return this.c.compareTo(r4.c);
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(b r3) {
        return a((b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.memorydata.plugin"));
    }

    public String toString() {
        return this.g + "," + this.f2783a + "," + this.e;
    }
}
