package kc8;

import com.larus.bmhome.chat.bean.DeepThinkFoldStatus;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class r {
    public final DeepThinkFoldStatus a;
    public final boolean b;
    public final Integer c;
    public final Integer d;
    public final Integer e;
    public final boolean f;

    public r() {
        this(null, null, null, null, 63);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof r) == true) goto L8;
        return false;
    L8:
        r r6 = (r) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
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
        if (this.f == r6.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        DeepThinkFoldStatus r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        int r4 = 1231;
        if (this.b == false) goto L9;
        int r5 = 1231;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.e;
        if (r13 == null) goto L22;
        r1 = r13.hashCode();
    L22:
        int r14 = (r12 + r1) * 31;
        if (this.f == true) goto L27;
        r4 = 1237;
    L27:
        return r14 + r4;
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = 1237;
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "DeepThinkBlockUIConfig(initialDeepThinkFoldStatus=" + this.a + ", showHeader=" + this.b + ", expandAllDividerColor=" + this.c + ", expandAllMaskRes=" + this.d + ", halfFoldExpandHeight=" + this.e + ", ignoreMessageDeepThinkTyping=" + this.f + ')';
    }

    public /* synthetic */ r(DeepThinkFoldStatus r10, Integer r11, Integer r12, Integer r13, int r14) {
        if ((r14 & 1) == 0) goto L5;
        DeepThinkFoldStatus r3 = null;
    L7:
        if ((r14 & 2) == 0) goto L9;
        boolean r4 = true;
    L11:
        if ((r14 & 4) == 0) goto L13;
        Integer r5 = null;
    L15:
        if ((r14 & 8) == 0) goto L17;
        Integer r6 = null;
    L19:
        if ((r14 & 16) == 0) goto L21;
        Integer r7 = null;
    L22:
        this(r3, r4, r5, r6, r7, false);
        return;
    L21:
        r7 = r13;
        goto L22
    L17:
        r6 = r12;
        goto L19
    L13:
        r5 = r11;
        goto L15
    L9:
        r4 = false;
        goto L11
    L5:
        r3 = r10;
        goto L7
    }

    public r(DeepThinkFoldStatus r1, boolean r2, Integer r3, Integer r4, Integer r5, boolean r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
