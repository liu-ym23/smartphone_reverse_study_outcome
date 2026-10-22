package com.bytedance.ai.resource;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class j {
    public final String a;
    public final String b;
    public final boolean c;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof j) == true) goto L8;
        return false;
    L8:
        j r11 = (j) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r11.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        if (this.c == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 + r1;
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "AppletGeckoConfig(accessKey=" + this.a + ", dirName=" + this.b + ", isRelative=" + this.c + ')';
    }

    public j(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "accessKey");
        Intrinsics.checkNotNullParameter(r11, "dirName");
        this.a = r10;
        this.b = r11;
        this.c = true;
    }
}
