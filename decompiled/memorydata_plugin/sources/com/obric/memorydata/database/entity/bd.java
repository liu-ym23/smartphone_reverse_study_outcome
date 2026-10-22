package com.obric.memorydata.database.entity;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class bd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f8921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f8922b;
    private final String c;
    private final String d;
    private final long e;
    private final long f;
    private final long g;
    private final String h;
    private final long i;
    private final long j;

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, bd.class) == true) goto L8;
        return false;
    L8:
        bd r10 = (bd) ZeusTransformUtils.preCheckCast(r9, bd.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f8921a, r10.f8921a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f8922b, r10.f8922b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r10.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r10.e) goto L24;
        return false;
    L24:
        if (this.f == r10.f) goto L27;
        return false;
    L27:
        if (this.g == r10.g) goto L30;
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
        return this.f8922b;
    }

    public int hashCode() {
        return (((((((((((((((((this.f8921a.hashCode() * 31) + this.f8922b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + Long.hashCode(this.e)) * 31) + Long.hashCode(this.f)) * 31) + Long.hashCode(this.g)) * 31) + this.h.hashCode()) * 31) + Long.hashCode(this.i)) * 31) + Long.hashCode(this.j);
    }

    public String toString() {
        return "ElementRelationEntity(subject=" + this.f8921a + ", type=" + this.f8922b + ", relation=" + this.c + ", objectRel=" + this.d + ", lastTime=" + this.e + ", firstTime=" + this.f + ", count=" + this.g + ", source=" + this.h + ", id=" + this.i + ", timestamp=" + this.j + ')';
    }
}
