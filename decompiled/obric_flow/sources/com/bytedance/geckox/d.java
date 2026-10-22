package com.bytedance.geckox;

import ai.j0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4743a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f4744b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f4745c;

    public d(String r5, Long r10) {
        this.f4743a = r5;
        this.f4744b = r10;
        this.f4745c = null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof d) == false) goto L12;
        d r10 = (d) r5;
        String r11 = r10.f4743a;
        if (Intrinsics.areEqual(this.f4743a, r11) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f4744b, r10.f4744b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f4745c, r10.f4745c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        int r5 = 0;
        String r10 = this.f4743a;
        if (r10 == null) goto L5;
        int r11 = r10.hashCode();
    L6:
        int r12 = r11 * 31;
        Long r13 = this.f4744b;
        if (r13 == null) goto L9;
        int r14 = r13.hashCode();
    L10:
        int r15 = (r12 + r14) * 31;
        String r16 = this.f4745c;
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
        StringBuilder r5 = new StringBuilder("GeckoBuildInPath(path=");
        r5.append(this.f4743a);
        r5.append(", version=");
        r5.append(this.f4744b);
        r5.append(", failMsg=");
        return j0.q(r5, this.f4745c, ")");
    }

    public d(Long r5, String r10, String r11) {
        this.f4743a = r10;
        this.f4744b = r5;
        this.f4745c = r11;
    }
}
