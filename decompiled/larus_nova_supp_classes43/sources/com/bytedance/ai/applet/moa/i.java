package com.bytedance.ai.applet.moa;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class i {
    public final String a;
    public final String b;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof i) == true) goto L8;
        return false;
    L8:
        i r11 = (i) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "MoaGrantingKey(appletId=" + this.a + ", authorizationID=" + this.b + ')';
    }

    public i(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "appletId");
        Intrinsics.checkNotNullParameter(r11, "authorizationID");
        this.a = r10;
        this.b = r11;
    }
}
