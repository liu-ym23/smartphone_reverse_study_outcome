package com.ss.android.socialbase.downloader.b.a.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<String> f15263a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<String> f15264b;
    private int c;
    private int d;
    private int e;

    public g(List<String> r3, List<String> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        this.f15263a = new ArrayList();
        this.f15264b = new ArrayList();
        this.c = -1;
        this.d = -1;
        if (r5 != null) goto L5;
    L7:
        if (r6 == null) goto L12;
        if (r6.isEmpty() == true) goto L12;
        this.f15263a.addAll(r6);
    L12:
        if (this.f15264b.isEmpty() == true) goto L14;
        int r7 = 1;
    L15:
        this.e = r7;
        return;
    L14:
        r7 = 2;
        goto L15
    L5:
        if (r5.isEmpty() == true) goto L7;
        this.f15264b.addAll(r5);
        goto L7
    }

    public String a() {
        int r0 = this.e;
        if (r0 == 1) goto L15;
        if (r0 == 2) goto L9;
        return null;
    L9:
        if (this.c >= 0) goto L11;
        this.c = 0;
    L11:
        List<String> r1 = this.f15263a;
        int r4 = this.c;
    L13:
        return (String) ZeusTransformUtils.preCheckCast(r1.get(r4 % r1.size()), String.class, "com.obric.memorydata.plugin");
    L15:
        if (this.d >= 0) goto L17;
        this.d = 0;
    L17:
        r1 = this.f15264b;
        r4 = this.d;
        goto L13
    }

    public boolean b() {
        if (this.f15263a.isEmpty() == false) goto L5;
        return false;
    L5:
        if (this.e == 2) goto L11;
        this.e = 2;
        return true;
    L11:
        return false;
    }

    public boolean c() {
        if (this.e == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public void d() {
        if (c() == false) goto L13;
        if (this.f15264b.isEmpty() == true) goto L13;
        if (this.d >= (this.f15264b.size() - 1)) goto L9;
    L10:
        this.d++;
        return;
    L9:
        if (this.f15263a.isEmpty() == true) goto L10;
    L13:
        if (this.f15263a.isEmpty() == true) goto L16;
        this.c++;
        this.e = 2;
        return;
    }

    public g e() {
        g r0 = new g(this.f15264b, this.f15263a);
        r0.e = this.e;
        r0.d = this.d;
        r0.c = this.c;
        return r0;
    }
}
