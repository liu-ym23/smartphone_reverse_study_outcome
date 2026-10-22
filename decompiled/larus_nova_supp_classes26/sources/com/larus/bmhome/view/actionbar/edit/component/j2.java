package com.larus.bmhome.view.actionbar.edit.component;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class j2 {
    public final String a;
    public final String b;
    public final p1 c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof j2) == true) goto L8;
        return false;
    L8:
        j2 r6 = (j2) r5;
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
        int r0 = this.a.hashCode() * 31;
        String r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        p1 r5 = this.c;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "StartParam(targetPageRouter=" + this.a + ", selectedId=" + this.b + ", mobParam=" + this.c + ')';
    }

    public j2(String r2, String r3, p1 r4) {
        Intrinsics.checkNotNullParameter(r2, "targetPageRouter");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
