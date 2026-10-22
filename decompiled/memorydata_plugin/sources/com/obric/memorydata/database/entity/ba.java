package com.obric.memorydata.database.entity;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ba {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f8915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f8916b;
    private final String c;
    private final long d;
    private final String e;
    private final long f;

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, ba.class) == true) goto L8;
        return false;
    L8:
        ba r10 = (ba) ZeusTransformUtils.preCheckCast(r9, ba.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f8915a, r10.f8915a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f8916b, r10.f8916b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r10.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r10.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r10.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r10.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final String getType() {
        return this.f8915a;
    }

    public int hashCode() {
        return (((((((((this.f8915a.hashCode() * 31) + this.f8916b.hashCode()) * 31) + this.c.hashCode()) * 31) + Long.hashCode(this.d)) * 31) + this.e.hashCode()) * 31) + Long.hashCode(this.f);
    }

    public String toString() {
        return "ElementMention2Entity(type=" + this.f8915a + ", mention=" + this.f8916b + ", objEntity=" + this.c + ", lastTime=" + this.d + ", source=" + this.e + ", id=" + this.f + ')';
    }
}
