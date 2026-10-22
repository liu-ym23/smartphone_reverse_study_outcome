package com.bytedance.ies.bullet.web.pia;

import ai.j0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6237a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final rd.e f6238b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f6239c;

    public k(String r5, rd.e r10, String r11) {
        this.f6237a = r5;
        this.f6238b = r10;
        this.f6239c = r11;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof k) == true) goto L8;
        return false;
    L8:
        k r10 = (k) r5;
        String r11 = r10.f6237a;
        if (Intrinsics.areEqual(this.f6237a, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f6238b, r10.f6238b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f6239c, r10.f6239c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r5 = 0;
        String r10 = this.f6237a;
        if (r10 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = r11 * 31;
        rd.e r13 = this.f6238b;
        if (r13 != null) goto L9;
        int r14 = 0;
    L10:
        int r15 = (r12 + r14) * 31;
        String r16 = this.f6239c;
        if (r16 == null) goto L15;
        r5 = r16.hashCode();
    L15:
        return r15 + r5;
    L9:
        r14 = r13.f21723a.hashCode();
        goto L10
    L5:
        r11 = r10.hashCode();
        goto L6
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("Config(sessionId=");
        r5.append(this.f6237a);
        r5.append(", schemaModelUnion=");
        r5.append(this.f6238b);
        r5.append(", userAgent=");
        return j0.p(r5, this.f6239c, ')');
    }
}
