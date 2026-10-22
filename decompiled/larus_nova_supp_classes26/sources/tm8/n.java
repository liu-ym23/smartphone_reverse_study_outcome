package tm8;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class n {
    public final String a;
    public final String b;
    public final boolean c;
    public final List<a> d;
    public final String e;
    public final Integer f;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof n) == true) goto L8;
        return false;
    L8:
        n r6 = (n) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        if (this.c == false) goto L13;
        int r7 = 1231;
    L14:
        int r8 = (((r6 + r7) * 31) + this.d.hashCode()) * 31;
        String r9 = this.e;
        if (r9 != null) goto L17;
        int r10 = 0;
    L18:
        int r11 = (r8 + r10) * 31;
        Integer r12 = this.f;
        if (r12 == null) goto L23;
        r1 = r12.hashCode();
    L23:
        return r11 + r1;
    L17:
        r10 = r9.hashCode();
        goto L18
    L13:
        r7 = 1237;
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "QuickReplyViewInput(messageId=" + this.a + ", uniqueId=" + this.b + ", useHorizontalLayout=" + this.c + ", items=" + this.d + ", guideText=" + this.e + ", itemBackgroundRes=" + this.f + ')';
    }

    public n(String r2, String r3, List r4, String r5, Integer r6) {
        Intrinsics.checkNotNullParameter(r4, "items");
        this.a = r2;
        this.b = r3;
        this.c = false;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
