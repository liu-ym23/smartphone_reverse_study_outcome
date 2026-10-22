package com.bytedance.android.annie.service.resource;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d {
    public final String a;
    public final String b;
    public final String c;

    public d() {
        this(0);
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof d) == true) goto L8;
        return false;
    L8:
        d r11 = (d) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r11.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "GeckoResourceInfo(accessKey=" + this.a + ", channel=" + this.b + ", bundle=" + this.c + ')';
    }

    public /* synthetic */ d(int r1) {
        this("", "", "");
    }

    public d(String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "accessKey");
        Intrinsics.checkNotNullParameter(r11, "channel");
        Intrinsics.checkNotNullParameter(r12, "bundle");
        this.a = r10;
        this.b = r11;
        this.c = r12;
    }
}
