package com.obric.memorydata.database.entity;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f9280b;
    private final String c;
    private final String d;
    private final long e;

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, m.class) == true) goto L8;
        return false;
    L8:
        m r10 = (m) ZeusTransformUtils.preCheckCast(r9, m.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f9279a, r10.f9279a) == true) goto L12;
        return false;
    L12:
        if (this.f9280b == r10.f9280b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r10.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r10.e) goto L23;
        return false;
    L23:
        return true;
    }

    public final String getType() {
        return this.f9279a;
    }

    public int hashCode() {
        return (((((((this.f9279a.hashCode() * 31) + Long.hashCode(this.f9280b)) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + Long.hashCode(this.e);
    }

    public String toString() {
        return "AppElementMapIDEntity(type=" + this.f9279a + ", appEntityID=" + this.f9280b + ", databaseName=" + this.c + ", targetIdList=" + this.d + ", id=" + this.e + ')';
    }
}
