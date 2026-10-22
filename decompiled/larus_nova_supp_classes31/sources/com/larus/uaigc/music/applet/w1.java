package com.larus.uaigc.music.applet;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class w1 {
    public final bq8.a a;
    public final String b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof w1) == true) goto L8;
        return false;
    L8:
        w1 r6 = (w1) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "UseTemplateEvent(template=" + this.a + ", enterFrom=" + this.b + ')';
    }

    public w1(bq8.a r3) {
        Intrinsics.checkNotNullParameter(r3, "template");
        Intrinsics.checkNotNullParameter("template_detail_button", "enterFrom");
        this.a = r3;
        this.b = "template_detail_button";
    }
}
