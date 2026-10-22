package com.bytedance.apm.h.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class h implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f1353b;
    public long c;
    public int d;
    public long e;

    public h(String r1, long r2, String r4) {
        this.f1352a = r1;
        this.c = r2;
        this.e = System.currentTimeMillis();
        this.d = 1;
        this.f1353b = r4;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object r4) {
        h r5 = (h) ZeusTransformUtils.preCheckCast(r4, h.class, "com.obric.memorydata.plugin");
        long r0 = this.c;
        long r3 = r5.c;
        if (r0 != r3) goto L7;
        return 0;
    L7:
        if (r0 <= r3) goto L10;
        return 1;
    L10:
        return -1;
    }
}
