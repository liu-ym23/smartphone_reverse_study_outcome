package com.obric.memorydata.database.entity;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class bf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f8925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f8926b;
    private final String c;
    private final long d;
    private final long e;
    private final long f;
    private final String g;
    private final String h;
    private final long i;
    private final long j;

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, bf.class) == true) goto L8;
        return false;
    L8:
        bf r10 = (bf) ZeusTransformUtils.preCheckCast(r9, bf.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f8925a, r10.f8925a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f8926b, r10.f8926b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r10.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r10.d) goto L21;
        return false;
    L21:
        if (this.e == r10.e) goto L24;
        return false;
    L24:
        if (this.f == r10.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r10.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r10.h) == true) goto L33;
        return false;
    L33:
        if (this.i == r10.i) goto L36;
        return false;
    L36:
        if (this.j == r10.j) goto L38;
        return false;
    L38:
        return true;
    }

    public final String getType() {
        return this.f8925a;
    }

    public int hashCode() {
        return (((((((((((((((((this.f8925a.hashCode() * 31) + this.f8926b.hashCode()) * 31) + this.c.hashCode()) * 31) + Long.hashCode(this.d)) * 31) + Long.hashCode(this.e)) * 31) + Long.hashCode(this.f)) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + Long.hashCode(this.i)) * 31) + Long.hashCode(this.j);
    }

    public String toString() {
        return "ElementSummaryEntity(type=" + this.f8925a + ", name=" + this.f8926b + ", summary=" + this.c + ", lastTime=" + this.d + ", firstTime=" + this.e + ", count=" + this.f + ", kgSource=" + this.g + ", source=" + this.h + ", id=" + this.i + ", timestamp=" + this.j + ')';
    }
}
