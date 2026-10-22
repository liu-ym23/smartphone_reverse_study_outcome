package com.alibaba.excel.metadata.data;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f279a;

    public e() {
    }

    public e a() {
        e r0 = new e();
        r0.a(b());
        return r0;
    }

    public void a(String r1) {
        this.f279a = r1;
    }

    public boolean a(Object r1) {
        return ZeusTransformUtils.instanceOf(r1, e.class);
    }

    public String b() {
        return this.f279a;
    }

    public /* synthetic */ Object clone() {
        return a();
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
        return false;
    L8:
        e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.memorydata.plugin");
        if (r6.a(this) == true) goto L11;
        return false;
    L11:
        String r4 = b();
        String r7 = r6.b();
        if (r4 != null) goto L16;
        if (r7 != null) goto L17;
    L18:
        return true;
    L17:
        return false;
    L16:
        if (r4.equals(r7) == true) goto L18;
        goto L17
    }

    public int hashCode() {
        String r1 = b();
        if (r1 != null) goto L5;
        int r2 = 43;
    L7:
        return 59 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }
}
