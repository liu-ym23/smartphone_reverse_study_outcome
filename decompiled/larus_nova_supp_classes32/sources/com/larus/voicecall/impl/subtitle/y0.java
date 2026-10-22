package com.larus.voicecall.impl.subtitle;

import com.larus.audio.call.subtitle.SubtitleAction;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class y0 {
    public final SubtitleAction a;
    public final int b;
    public final int c;
    public final boolean d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof y0) == true) goto L8;
        return false;
    L8:
        y0 r6 = (y0) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b) * 31) + this.c) * 31;
        if (this.d == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 + r1;
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "action=" + this.a + ", startIndex=" + this.b + ", endIndex=" + this.c;
    }

    public y0(SubtitleAction r3, int r4, int r5, boolean r6, int r7) {
        if ((r7 & 2) == 0) goto L6;
        r4 = -1;
    L6:
        if ((r7 & 4) == 0) goto L9;
        r5 = -1;
    L9:
        if ((r7 & 8) == 0) goto L11;
        r6 = false;
    L11:
        Intrinsics.checkNotNullParameter(r3, "action");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
    }
}
