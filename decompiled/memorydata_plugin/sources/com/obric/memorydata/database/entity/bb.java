package com.obric.memorydata.database.entity;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class bb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f8917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f8918b;
    private final long c;
    private final String d;
    private final String e;
    private final long f;
    private final long g;
    private final long h;
    private final String i;
    private final long j;
    private final long k;

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, bb.class) == true) goto L8;
        return false;
    L8:
        bb r10 = (bb) ZeusTransformUtils.preCheckCast(r9, bb.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f8917a, r10.f8917a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f8918b, r10.f8918b) == true) goto L15;
        return false;
    L15:
        if (this.c == r10.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r10.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r10.f) goto L27;
        return false;
    L27:
        if (this.g == r10.g) goto L30;
        return false;
    L30:
        if (this.h == r10.h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r10.i) == true) goto L36;
        return false;
    L36:
        if (this.j == r10.j) goto L39;
        return false;
    L39:
        if (this.k == r10.k) goto L41;
        return false;
    L41:
        return true;
    }

    public final String getType() {
        return this.f8918b;
    }

    public int hashCode() {
        return (((((((((((((((((((this.f8917a.hashCode() * 31) + this.f8918b.hashCode()) * 31) + Long.hashCode(this.c)) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + Long.hashCode(this.f)) * 31) + Long.hashCode(this.g)) * 31) + Long.hashCode(this.h)) * 31) + this.i.hashCode()) * 31) + Long.hashCode(this.j)) * 31) + Long.hashCode(this.k);
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("ElementPropertyEntity(entity=").append(this.f8917a).append(", type=").append(this.f8918b).append(", actionTime=").append(this.c).append(", property=").append(this.d).append(", value=").append(this.e).append(", lastTime=").append(this.f).append(", firstTime=").append(this.g).append(", count=").append(this.h).append(", source=").append(this.i).append(", id=").append(this.j).append(", timestamp=").append(this.k).append(')');
        return r0.toString();
    }
}
