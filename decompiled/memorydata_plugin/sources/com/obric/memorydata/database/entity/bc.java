package com.obric.memorydata.database.entity;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class bc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f8919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f8920b;
    private final long c;

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, bc.class) == true) goto L8;
        return false;
    L8:
        bc r8 = (bc) ZeusTransformUtils.preCheckCast(r7, bc.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f8919a, r8.f8919a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f8920b, r8.f8920b) == true) goto L15;
        return false;
    L15:
        if (this.c == r8.c) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.f8919a.hashCode() * 31) + this.f8920b.hashCode()) * 31) + Long.hashCode(this.c);
    }

    public String toString() {
        return "ElementRelMention2RelationEntity(mention=" + this.f8919a + ", normalizedRelation=" + this.f8920b + ", id=" + this.c + ')';
    }
}
