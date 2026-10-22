package com.larus.bmhome.chat.component.bottom.voice.service;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e {
    public final CharSequence a;
    public final boolean b;
    public final int c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r6 = (e) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L7:
        return ((r0 + r1) * 31) + this.c;
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "NonStreamText(spannableStream=" + this.a + ", isStream=" + this.b + ", streamResultLength=" + this.c + ')';
    }

    public e(CharSequence r2, boolean r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "spannableStream");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
