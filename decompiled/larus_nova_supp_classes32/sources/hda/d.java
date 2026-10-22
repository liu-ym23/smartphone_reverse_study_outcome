package hda;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d {
    public final String a;
    public final String b;
    public final boolean c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        if (r0 != null) goto L5;
        int r1 = 0;
    L6:
        int r2 = ((r1 * 31) + this.b.hashCode()) * 31;
        if (this.c == false) goto L9;
        int r3 = 1231;
    L11:
        return r2 + r3;
    L9:
        r3 = 1237;
        goto L11
    L5:
        r1 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "MemoryReviewChatBubble(speaker=" + this.a + ", text=" + this.b + ", self=" + this.c + ')';
    }

    public d(String r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "text");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
