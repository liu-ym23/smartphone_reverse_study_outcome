package com.obric.aikernel.middleware.impl.obric;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f4580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f4581b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f4582c;

    public i(String r10, String r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "packageName");
        Intrinsics.checkNotNullParameter(r11, "className");
        this.f4580a = r10;
        this.f4581b = r11;
        this.f4582c = r12;
    }

    public final String a() {
        return this.f4581b;
    }

    public final String b() {
        return this.f4580a;
    }

    public final boolean c() {
        return this.f4582c;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof i) == true) goto L8;
        return false;
    L8:
        i r11 = (i) r10;
        if (Intrinsics.areEqual(this.f4580a, r11.f4580a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f4581b, r11.f4581b) == true) goto L15;
        return false;
    L15:
        if (this.f4582c == r11.f4582c) goto L17;
        return false;
    L17:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        int r10 = ((this.f4580a.hashCode() * 31) + this.f4581b.hashCode()) * 31;
        boolean r11 = this.f4582c;
        ?? r12 = r11;
        if (r11 == false) goto L6;
        r12 = 1;
    L6:
        return r10 + r12;
    }

    public String toString() {
        return "SilentUpdateServiceTarget(packageName=" + this.f4580a + ", className=" + this.f4581b + ", skipBindResume=" + this.f4582c + ')';
    }
}
