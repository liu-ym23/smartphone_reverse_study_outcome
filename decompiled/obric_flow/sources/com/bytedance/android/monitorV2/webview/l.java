package com.bytedance.android.monitorV2.webview;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3801a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f3802b;

    public l(String r5, b r10) {
        this.f3801a = r5;
        this.f3802b = r10;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof l) == true) goto L8;
        return false;
    L8:
        l r10 = (l) r5;
        String r11 = r10.f3801a;
        if (Intrinsics.areEqual(this.f3801a, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f3802b, r10.f3802b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r5 = 0;
        String r10 = this.f3801a;
        if (r10 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = r11 * 31;
        b r13 = this.f3802b;
        if (r13 == null) goto L11;
        r5 = r13.hashCode();
    L11:
        return r12 + r5;
    L5:
        r11 = r10.hashCode();
        goto L6
    }

    public final String toString() {
        return "ConfigObj(source=" + this.f3801a + ", config=" + this.f3802b + ')';
    }
}
