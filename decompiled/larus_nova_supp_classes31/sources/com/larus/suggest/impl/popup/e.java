package com.larus.suggest.impl.popup;

import com.larus.bmhome.chat.bean.NexPulseCandidate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class e {
    public final NexPulseCandidate a;
    public final boolean b;
    public final String c;
    public final String d;

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
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        NexPulseCandidate r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        if (this.b == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (r3 + r4) * 31;
        String r6 = this.c;
        if (r6 == null) goto L15;
        r1 = r6.hashCode();
    L15:
        return ((r5 + r1) * 31) + this.d.hashCode();
    L9:
        r4 = 1237;
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "DialogReadyState(candidate=" + this.a + ", mediaReady=" + this.b + ", campaignTag=" + this.c + ", pcGuideSource=" + this.d + ')';
    }

    public e(NexPulseCandidate r2, boolean r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "pcGuideSource");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
