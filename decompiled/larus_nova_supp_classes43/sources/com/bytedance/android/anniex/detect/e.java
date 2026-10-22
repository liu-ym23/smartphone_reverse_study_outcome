package com.bytedance.android.anniex.detect;

import android.net.Uri;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e {
    public final String a;
    public final String b;
    public final a36.c c;
    public final Uri d;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof e) == true) goto L8;
        return false;
    L8:
        e r11 = (e) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r11.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r11.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public final String toString() {
        return "BlankDetectorItemConfig bdhmBid=" + this.a + ", urlBase=" + this.b;
    }

    public final a36.c getIdentifier() {
        return this.c;
    }

    public e(String r10, String r11, a36.a r12, Uri r13) {
        Intrinsics.checkNotNullParameter(r10, "bdhmBid");
        Intrinsics.checkNotNullParameter(r11, "urlBase");
        Intrinsics.checkNotNullParameter(r12, "identifier");
        Intrinsics.checkNotNullParameter(r13, "originUri");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
    }
}
