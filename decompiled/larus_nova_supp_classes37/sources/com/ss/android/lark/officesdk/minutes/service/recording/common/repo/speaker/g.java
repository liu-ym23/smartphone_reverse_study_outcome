package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class g {
    public final boolean a;
    public final String b;
    public final c c;
    public final c d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return false;
    L8:
        g r6 = (g) r5;
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
        int r1 = ((((r0 * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        c r2 = this.d;
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
        StringBuilder r0 = new StringBuilder("MmSpeakerMarkResult(success=");
        r0.append(this.a);
        r0.append(", clusterId='");
        r0.append(this.b);
        r0.append("', oldSpeaker=");
        r0.append(this.c.a);
        r0.append(", newSpeaker=");
        c r1 = this.d;
        if (r1 == null) goto L5;
        String r2 = r1.a;
    L6:
        r0.append(r2);
        r0.append(')');
        return r0.toString();
    L5:
        r2 = null;
        goto L6
    }

    public /* synthetic */ g(String r3, c r4) {
        this(false, r3, r4, null);
    }

    public g(boolean r2, String r3, c r4, c r5) {
        Intrinsics.checkNotNullParameter(r3, "clusterId");
        Intrinsics.checkNotNullParameter(r4, "oldSpeaker");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
