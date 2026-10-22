package com.obric.flow.cardlistpage.ui.component.popupdialog;

import ai.j0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f11725b;

    public c0(String r5, String r10) {
        this.f11724a = r5;
        this.f11725b = r10;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c0) == true) goto L8;
        return false;
    L8:
        c0 r10 = (c0) r5;
        String r11 = r10.f11724a;
        if (Intrinsics.areEqual(this.f11724a, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f11725b, r10.f11725b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r5 = 0;
        String r10 = this.f11724a;
        if (r10 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = r11 * 31;
        String r13 = this.f11725b;
        if (r13 == null) goto L11;
        r5 = r13.hashCode();
    L11:
        return r12 + r5;
    L5:
        r11 = r10.hashCode();
        goto L6
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("ProviderDescriptor(label=");
        r5.append(this.f11724a);
        r5.append(", configureClassName=");
        return j0.q(r5, this.f11725b, ")");
    }
}
