package com.larus.bmhome.chat.component.bottom.core.inputtext.mention;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d1 {
    public final boolean a;
    public final String b;

    public d1() {
        this(false, null);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d1) == true) goto L8;
        return false;
    L8:
        d1 r6 = (d1) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r1 = r0 * 31;
        String r2 = this.b;
        if (r2 != null) goto L9;
        int r3 = 0;
    L11:
        return r1 + r3;
    L9:
        r3 = r2.hashCode();
        goto L11
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "MentionSearchPageInfo(hasMore=" + this.a + ", nextCursor=" + this.b + ')';
    }

    public final boolean a() {
        if (this.a == false) goto L14;
        String r0 = this.b;
        if (r0 != null) goto L7;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == true) goto L15;
        return true;
    L15:
        return false;
    L7:
        if (StringsKt.isBlank(r0) == true) goto L10;
        r1 = false;
        goto L11
    L14:
        return false;
    }

    public d1(boolean r1, String r2) {
        this.a = r1;
        this.b = r2;
    }
}
