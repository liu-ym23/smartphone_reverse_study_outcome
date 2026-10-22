package com.google.common.cache;

import com.google.common.base.k;
import com.google.common.base.n;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f4356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f4357b;
    private final long c;
    private final long d;
    private final long e;
    private final long f;

    public c(long r19, long r21, long r23, long r25, long r27, long r29) {
        boolean r16 = true;
        if (r19 < 0) goto L5;
        boolean r15 = true;
    L6:
        n.a(r15);
        if (r21 < 0) goto L9;
        boolean r17 = true;
    L10:
        n.a(r17);
        if (r23 < 0) goto L13;
        boolean r18 = true;
    L14:
        n.a(r18);
        if (r25 < 0) goto L17;
        boolean r110 = true;
    L18:
        n.a(r110);
        if (r27 < 0) goto L21;
        boolean r111 = true;
    L22:
        n.a(r111);
        if (r29 >= 0) goto L26;
        r16 = false;
    L26:
        n.a(r16);
        this.f4356a = r19;
        this.f4357b = r21;
        this.c = r23;
        this.d = r25;
        this.e = r27;
        this.f = r29;
        return;
    L21:
        r111 = false;
        goto L22
    L17:
        r110 = false;
        goto L18
    L13:
        r18 = false;
        goto L14
    L9:
        r17 = false;
        goto L10
    L5:
        r15 = false;
        goto L6
    }

    public long a() {
        return this.f4356a;
    }

    public long b() {
        return this.f4357b;
    }

    public long c() {
        return this.c;
    }

    public long d() {
        return this.d;
    }

    public long e() {
        return this.e;
    }

    public boolean equals(Object r6) {
        if (ZeusTransformUtils.instanceOf(r6, c.class) == false) goto L18;
        c r7 = (c) ZeusTransformUtils.preCheckCast(r6, c.class, "com.obric.memorydata.plugin");
        if (this.f4356a == r7.f4356a) goto L7;
        return false;
    L7:
        if (this.f4357b == r7.f4357b) goto L9;
        return false;
    L9:
        if (this.c == r7.c) goto L11;
        return false;
    L11:
        if (this.d == r7.d) goto L13;
        return false;
    L13:
        if (this.e == r7.e) goto L15;
        return false;
    L15:
        if (this.f != r7.f) goto L24;
        return true;
    L24:
        return false;
    L18:
        return false;
    }

    public long f() {
        return this.f;
    }

    public int hashCode() {
        return k.a(new Object[]{Long.valueOf(this.f4356a), Long.valueOf(this.f4357b), Long.valueOf(this.c), Long.valueOf(this.d), Long.valueOf(this.e), Long.valueOf(this.f)});
    }

    public String toString() {
        return com.google.common.base.i.a(this).a("hitCount", this.f4356a).a("missCount", this.f4357b).a("loadSuccessCount", this.c).a("loadExceptionCount", this.d).a("totalLoadTime", this.e).a("evictionCount", this.f).toString();
    }
}
