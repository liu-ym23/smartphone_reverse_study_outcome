package q99;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class m {
    public final yc9.m a;
    public final Integer b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final Map<String, String> g;

    public m() {
        throw null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof m) == true) goto L8;
        return false;
    L8:
        m r6 = (m) r5;
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
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        Integer r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.c;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.d;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.e;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.f;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        Map<String, String> r17 = this.g;
        if (r17 == null) goto L27;
        r2 = r17.hashCode();
    L27:
        return r16 + r2;
    L21:
        r15 = r14.hashCode();
        goto L22
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
        return "FlowMessageFeedbackRequest(imRequest=" + this.a + ", feedbackScene=" + this.b + ", feedbackId=" + this.c + ", sectionId=" + this.d + ", clickFrom=" + this.e + ", callId=" + this.f + ", extraParams=" + this.g + ')';
    }

    public m(yc9.m r3, Integer r4, String r5, String r6, String r7, String r8, Map r9, int r10) {
        if ((r10 & 2) == 0) goto L6;
        r4 = null;
    L6:
        if ((r10 & 4) == 0) goto L9;
        r5 = null;
    L9:
        if ((r10 & 8) == 0) goto L12;
        r6 = null;
    L12:
        if ((r10 & 16) == 0) goto L15;
        r7 = null;
    L15:
        if ((r10 & 32) == 0) goto L18;
        r8 = null;
    L18:
        if ((r10 & 64) == 0) goto L20;
        r9 = null;
    L20:
        Intrinsics.checkNotNullParameter(r3, "imRequest");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
    }
}
