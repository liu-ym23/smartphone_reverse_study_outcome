package com.bytedance.android.annie.card.web.resource;

import android.webkit.WebResourceResponse;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public final String a;
    public final String b;
    public final boolean c;
    public final long d;
    public final WebResourceResponse e;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof b) == true) goto L8;
        return false;
    L8:
        b r11 = (b) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r11.c) goto L18;
        return false;
    L18:
        if (this.d == r11.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r11.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        if (this.c == false) goto L5;
        int r1 = 1231;
    L6:
        int r10 = (r0 + r1) * 31;
        long r11 = this.d;
        int r12 = (r10 + ((int) (r11 ^ (r11 >>> 32)))) * 31;
        WebResourceResponse r13 = this.e;
        if (r13 != null) goto L9;
        int r14 = 0;
    L11:
        return r12 + r14;
    L9:
        r14 = r13.hashCode();
        goto L11
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "WebResourceResponseInfo(resFrom=" + this.a + ", resOriginFrom=" + this.b + ", useForest=" + this.c + ", geckoVersion=" + this.d + ", response=" + this.e + ')';
    }

    public b(String r10, String r11, boolean r12, long r13, WebResourceResponse r14) {
        Intrinsics.checkNotNullParameter(r10, "resFrom");
        Intrinsics.checkNotNullParameter(r11, "resOriginFrom");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
        this.e = r14;
    }

    public /* synthetic */ b(String r10, String r11, boolean r12, WebResourceResponse r13, int r14) {
        if ((r14 & 16) == 0) goto L5;
        r13 = null;
    L5:
        this(r10, r11, r12, 0, r13);
    }
}
