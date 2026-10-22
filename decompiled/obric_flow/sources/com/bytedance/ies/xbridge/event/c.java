package com.bytedance.ies.xbridge.event;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ug.e f6330b;

    public c(String r5, ug.e r10) {
        Intrinsics.checkNotNullParameter(r5, "eventName");
        this.f6329a = r5;
        this.f6330b = r10;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r10 = (c) r5;
        String r11 = r10.f6329a;
        if (Intrinsics.areEqual(this.f6329a, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f6330b, r10.f6330b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f6329a.hashCode() * 31;
        ug.e r10 = this.f6330b;
        if (r10 != null) goto L5;
        int r11 = 0;
    L7:
        return r5 + r11;
    L5:
        r11 = r10.hashCode();
        goto L7
    }

    public final String toString() {
        return "Js2NativeEvent(eventName=" + this.f6329a + ", params=" + this.f6330b + ')';
    }
}
