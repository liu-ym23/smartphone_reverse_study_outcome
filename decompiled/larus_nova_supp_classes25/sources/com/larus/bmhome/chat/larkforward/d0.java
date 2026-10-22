package com.larus.bmhome.chat.larkforward;

import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d0 {
    public final String a;
    public final String b;
    public final Drawable c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d0) == true) goto L8;
        return false;
    L8:
        d0 r6 = (d0) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        Drawable r1 = this.c;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "FlowLarkToDoubaoTarget(id=" + this.a + ", name=" + this.b + ", icon=" + this.c + ')';
    }

    public d0(String r3, Drawable r4) {
        Intrinsics.checkNotNullParameter("doubao_main_bot", "id");
        Intrinsics.checkNotNullParameter(r3, "name");
        this.a = "doubao_main_bot";
        this.b = r3;
        this.c = r4;
    }
}
