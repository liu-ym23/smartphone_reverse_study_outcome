package com.drakeet.multitype;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f7571a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final um.a f7572b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.frameworks.baselib.network.http.cronet.b f7573c;

    public b(Class r5, um.a r10, com.bytedance.frameworks.baselib.network.http.cronet.b r11) {
        Intrinsics.checkNotNullParameter(r5, "clazz");
        Intrinsics.checkNotNullParameter(r10, "delegate");
        Intrinsics.checkNotNullParameter(r11, "linker");
        this.f7571a = r5;
        this.f7572b = r10;
        this.f7573c = r11;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof b) == false) goto L12;
        b r10 = (b) r5;
        Class r11 = r10.f7571a;
        if (Intrinsics.areEqual(this.f7571a, r11) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f7572b, r10.f7572b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f7573c, r10.f7573c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        int r5 = 0;
        Class r10 = this.f7571a;
        if (r10 == null) goto L5;
        int r11 = r10.hashCode();
    L6:
        int r12 = r11 * 31;
        um.a r13 = this.f7572b;
        if (r13 == null) goto L9;
        int r14 = r13.hashCode();
    L10:
        int r15 = (r12 + r14) * 31;
        com.bytedance.frameworks.baselib.network.http.cronet.b r16 = this.f7573c;
        if (r16 == null) goto L14;
        r5 = r16.hashCode();
    L14:
        return r15 + r5;
    L9:
        r14 = 0;
        goto L10
    L5:
        r11 = 0;
        goto L6
    }

    public final String toString() {
        return "Type(clazz=" + this.f7571a + ", delegate=" + this.f7572b + ", linker=" + this.f7573c + ")";
    }
}
