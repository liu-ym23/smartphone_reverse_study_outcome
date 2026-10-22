package ib8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a {
    public final n a;
    public final lb8.g b;
    public final kb8.i c;
    public final nb8.i d;
    public final com.larus.bmhome.chat.standarduikit.vlm.view.a e;
    public final tk8.e f;

    public a() {
        this(null, null, null, null, null, null, 63);
    }

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
        int r0 = this.a.hashCode() * 31;
        lb8.g r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        kb8.i r5 = this.c;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        nb8.i r8 = this.d;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        com.larus.bmhome.chat.standarduikit.vlm.view.a r11 = this.e;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        tk8.e r14 = this.f;
        if (r14 == null) goto L23;
        r2 = r14.hashCode();
    L23:
        return r13 + r2;
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "ContainerViewInput(foldContainerViewInput=" + this.a + ", deepThinkBlockList=" + this.b + ", queryQueryKeywordReferencesViewInput=" + this.c + ", deepThinkContentInput=" + this.d + ", flowVlmViewInput=" + this.e + ", elapsedBlockContentInput=" + this.f + ')';
    }

    public a(n r33, lb8.g r34, kb8.i r35, nb8.i r36, com.larus.bmhome.chat.standarduikit.vlm.view.a r37, tk8.e r38, int r39) {
        if ((r39 & 1) == 0) goto L5;
        n r1 = new n(false, false, null, null, false, false, false, false, false, null, false, false, false, null, false, false, null, null, null, null, null, false, false, 0, 0, false, 0, false, 1073741823);
    L6:
        tk8.e r3 = null;
        if ((r39 & 2) == 0) goto L9;
        lb8.g r2 = null;
    L11:
        if ((r39 & 4) == 0) goto L13;
        kb8.i r4 = null;
    L15:
        if ((r39 & 8) == 0) goto L17;
        nb8.i r5 = null;
    L19:
        if ((r39 & 16) == 0) goto L21;
        com.larus.bmhome.chat.standarduikit.vlm.view.a r6 = null;
    L23:
        if ((r39 & 32) != 0) goto L26;
        r3 = r38;
    L26:
        Intrinsics.checkNotNullParameter(r1, "foldContainerViewInput");
        this.a = r1;
        this.b = r2;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r3;
        return;
    L21:
        r6 = r37;
        goto L23
    L17:
        r5 = r36;
        goto L19
    L13:
        r4 = r35;
        goto L15
    L9:
        r2 = r34;
        goto L11
    L5:
        r1 = r33;
        goto L6
    }
}
