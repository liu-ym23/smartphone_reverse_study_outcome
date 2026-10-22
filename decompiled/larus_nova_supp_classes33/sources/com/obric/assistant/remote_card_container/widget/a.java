package com.obric.assistant.remote_card_container.widget;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a {
    public final String a;
    public final String b;
    public final String c;
    public final int d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        String r1 = this.c;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + this.d;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "MsgCardData(cardUri=" + this.a + ", localMessageId=" + this.b + ')';
    }

    public a(String r2, String r3, String r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "cardUri");
        Intrinsics.checkNotNullParameter(r3, "localMessageId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
