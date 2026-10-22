package com.obric.memorydata.database.entity;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class be {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f8923a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f8924b;

    public be() {
        this(null, 0, 3, null);
    }

    public be(String r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "settings");
        this.f8923a = r2;
        this.f8924b = r3;
    }

    public /* synthetic */ be(String r1, long r2, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = "";
    L6:
        if ((r4 & 2) == 0) goto L8;
        r2 = 0;
    L8:
        this(r1, r2);
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, be.class) == true) goto L8;
        return false;
    L8:
        be r8 = (be) ZeusTransformUtils.preCheckCast(r7, be.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f8923a, r8.f8923a) == true) goto L12;
        return false;
    L12:
        if (this.f8924b == r8.f8924b) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f8923a.hashCode() * 31) + Long.hashCode(this.f8924b);
    }

    public String toString() {
        return "ElementSettingsEntity(settings=" + this.f8923a + ", id=" + this.f8924b + ')';
    }
}
