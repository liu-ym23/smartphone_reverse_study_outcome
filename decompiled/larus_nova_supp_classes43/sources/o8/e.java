package o8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e {
    public String a;
    public String b;
    public boolean c;

    public e() {
        this(0);
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof e) == true) goto L8;
        return false;
    L8:
        e r11 = (e) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r11.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r10 = 0;
    L6:
        int r11 = r10 * 31;
        String r12 = this.b;
        if (r12 == null) goto L10;
        r1 = r12.hashCode();
    L10:
        int r13 = (r11 + r1) * 31;
        if (this.c == false) goto L13;
        int r14 = 1231;
    L15:
        return r13 + r14;
    L13:
        r14 = 1237;
        goto L15
    L5:
        r10 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "JsbInfo(nameSpace=" + this.a + ", jsObjectName=" + this.b + ", isShouldFlattenData=" + this.c + ')';
    }

    public e(int r1) {
        this.a = "webcast";
        this.b = "ToutiaoJSBridge";
        this.c = true;
    }
}
