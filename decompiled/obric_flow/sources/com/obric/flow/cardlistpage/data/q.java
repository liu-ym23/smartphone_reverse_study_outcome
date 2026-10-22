package com.obric.flow.cardlistpage.data;

import ai.j0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f11506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f11507c;
    public final int d;
    public final int e;
    public final String f;

    public q(String r5, String r10, int r11, int r12, String r13, int r14) {
        Intrinsics.checkNotNullParameter(r5, "originalId");
        Intrinsics.checkNotNullParameter(r10, "viewClass");
        Intrinsics.checkNotNullParameter(r13, "label");
        this.f11505a = r5;
        this.f11506b = r10;
        this.f11507c = r11;
        this.d = r12;
        this.e = r14;
        this.f = r13;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof q) == true) goto L8;
        return false;
    L8:
        q r10 = (q) r5;
        String r11 = r10.f11505a;
        if (Intrinsics.areEqual(this.f11505a, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f11506b, r10.f11506b) == true) goto L15;
        return false;
    L15:
        if (this.f11507c == r10.f11507c) goto L18;
        return false;
    L18:
        if (this.d == r10.d) goto L21;
        return false;
    L21:
        if (this.e == r10.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r10.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r5 = androidx.constraintlayout.motion.widget.a.c(this.f11505a.hashCode() * 31, 31, this.f11506b);
        int r10 = androidx.room.jarjarred.org.antlr.runtime.a.c(this.f11507c, r5, 31);
        int r11 = androidx.room.jarjarred.org.antlr.runtime.a.c(this.d, r10, 31);
        int r12 = androidx.room.jarjarred.org.antlr.runtime.a.c(this.e, r11, 31);
        return this.f.hashCode() + r12;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("ExternalCardTemplate(originalId=");
        r5.append(this.f11505a);
        r5.append(", viewClass=");
        r5.append(this.f11506b);
        r5.append(", spanX=");
        r5.append(this.f11507c);
        r5.append(", spanY=");
        r5.append(this.d);
        r5.append(", order=");
        r5.append(this.e);
        r5.append(", label=");
        return j0.q(r5, this.f, ")");
    }
}
