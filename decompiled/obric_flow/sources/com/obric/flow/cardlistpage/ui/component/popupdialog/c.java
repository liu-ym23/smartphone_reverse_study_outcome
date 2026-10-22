package com.obric.flow.cardlistpage.ui.component.popupdialog;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f11721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f11722b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c0 f11723c;

    public c(a r5, b r10, c0 r11) {
        Intrinsics.checkNotNullParameter(r5, "anchorDescriptor");
        Intrinsics.checkNotNullParameter(r10, "cardDescriptor");
        Intrinsics.checkNotNullParameter(r11, "providerDescriptor");
        this.f11721a = r5;
        this.f11722b = r10;
        this.f11723c = r11;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r10 = (c) r5;
        a r11 = r10.f11721a;
        if (Intrinsics.areEqual(this.f11721a, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f11722b, r10.f11722b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f11723c, r10.f11723c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f11721a.hashCode() * 31;
        int r10 = (this.f11722b.hashCode() + r5) * 31;
        return this.f11723c.hashCode() + r10;
    }

    public final String toString() {
        return "EditPopupDescriptor(anchorDescriptor=" + this.f11721a + ", cardDescriptor=" + this.f11722b + ", providerDescriptor=" + this.f11723c + ")";
    }
}
