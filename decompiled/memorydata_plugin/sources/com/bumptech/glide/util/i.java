package com.bumptech.glide.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Class<?> f987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Class<?> f988b;
    private Class<?> c;

    public i() {
    }

    public i(Class<?> r1, Class<?> r2, Class<?> r3) {
        a(r1, r2, r3);
    }

    public void a(Class<?> r1, Class<?> r2, Class<?> r3) {
        this.f987a = r1;
        this.f988b = r2;
        this.c = r3;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L20:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L20;
        i r6 = (i) ZeusTransformUtils.preCheckCast(r5, i.class, "com.obric.memorydata.plugin");
        if (this.f987a.equals(r6.f987a) == true) goto L14;
        return false;
    L14:
        if (this.f988b.equals(r6.f988b) == true) goto L17;
        return false;
    L17:
        if (k.a(this.c, r6.c) == true) goto L19;
        return false;
    L19:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.f987a.hashCode() * 31) + this.f988b.hashCode()) * 31;
        Class<?> r2 = this.c;
        if (r2 == null) goto L5;
        int r3 = r2.hashCode();
    L7:
        return r0 + r3;
    L5:
        r3 = 0;
        goto L7
    }

    public String toString() {
        return "MultiClassKey{first=" + this.f987a + ", second=" + this.f988b + '}';
    }
}
