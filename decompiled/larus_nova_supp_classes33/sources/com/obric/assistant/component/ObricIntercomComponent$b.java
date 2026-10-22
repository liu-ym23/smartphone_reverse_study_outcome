package com.obric.assistant.component;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ObricIntercomComponent$b {
    public final boolean a;
    public final Integer b;
    public final Long c;
    public final laa.n d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ObricIntercomComponent$b) == true) goto L8;
        return false;
    L8:
        ObricIntercomComponent$b r6 = (ObricIntercomComponent$b) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r1 = r0 * 31;
        Integer r2 = this.b;
        int r3 = 0;
        if (r2 != null) goto L9;
        int r4 = 0;
    L10:
        int r5 = (r1 + r4) * 31;
        Long r6 = this.c;
        if (r6 == null) goto L15;
        r3 = r6.hashCode();
    L15:
        return ((r5 + r3) * 31) + this.d.hashCode();
    L9:
        r4 = r2.hashCode();
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "PendingTouchSpeakRequest(needVibrate=" + this.a + ", vuiId=" + this.b + ", preStartTime=" + this.c + ", listeningUiHandle=" + this.d + ')';
    }

    public ObricIntercomComponent$b(boolean r2, Integer r3, Long r4, com.obric.assistant.view.listening.b r5) {
        Intrinsics.checkNotNullParameter(r5, "listeningUiHandle");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
