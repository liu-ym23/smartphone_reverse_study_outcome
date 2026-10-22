package com.obric.flow.cardlistpage.ui.component.popupdialog;

import ai.j0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class y implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f11748a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f11749b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f11750c;

    public y(e r5, e r10, boolean r11) {
        this.f11748a = r5;
        this.f11749b = r10;
        this.f11750c = r11;
    }

    public static y a(y r5, e r10, boolean r11, int r12) {
        e r13 = r5.f11748a;
        if ((r12 & 4) == 0) goto L5;
        r11 = r5.f11750c;
    L5:
        r5.getClass();
        return new y(r13, r10, r11);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof y) == true) goto L8;
        return false;
    L8:
        y r10 = (y) r5;
        e r11 = r10.f11748a;
        if (Intrinsics.areEqual(this.f11748a, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f11749b, r10.f11749b) == true) goto L15;
        return false;
    L15:
        if (this.f11750c == r10.f11750c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r5 = 0;
        e r10 = this.f11748a;
        if (r10 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = r11 * 31;
        e r13 = this.f11749b;
        if (r13 == null) goto L11;
        r5 = r13.hashCode();
    L11:
        return Boolean.hashCode(this.f11750c) + ((r12 + r5) * 31);
    L5:
        r11 = r10.hashCode();
        goto L6
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("Dismissing(currentDescriptor=");
        r5.append(this.f11748a);
        r5.append(", nextDescriptor=");
        r5.append(this.f11749b);
        r5.append(", withAnim=");
        return j0.r(r5, this.f11750c, ")");
    }
}
