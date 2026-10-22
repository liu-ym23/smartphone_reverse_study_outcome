package com.bytedance.apm.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class m<F, S> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public F f1494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public S f1495b;

    public m(F r1, S r2) {
        this.f1494a = r1;
        this.f1495b = r2;
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, m.class) == true) goto L5;
        return false;
    L5:
        m r5 = (m) ZeusTransformUtils.preCheckCast(r4, m.class, "com.obric.memorydata.plugin");
        if (l.a(r5.f1494a, this.f1494a) == true) goto L8;
        return false;
    L8:
        if (l.a(r5.f1495b, this.f1495b) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        F r0 = this.f1494a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        S r3 = this.f1495b;
        if (r3 == null) goto L11;
        r1 = r3.hashCode();
    L11:
        return r2 ^ r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "Pair{" + String.valueOf(this.f1494a) + " " + this.f1495b + "}";
    }
}
