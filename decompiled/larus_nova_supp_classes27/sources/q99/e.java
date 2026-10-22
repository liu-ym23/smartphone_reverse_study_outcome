package q99;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class e {
    public final String a;
    public final String b;
    public final Integer c;
    public final String d;
    public final String e;
    public final d f;
    public final Map<String, String> g;

    public e() {
        this(null, null, null, null, null, 127);
    }

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
        Integer r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        d r16 = this.f;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        Map<String, String> r20 = this.g;
        if (r20 == null) goto L31;
        r1 = r20.hashCode();
    L31:
        return r18 + r1;
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "FlowFeedbackDelivery(conversationId=" + this.a + ", messageId=" + this.b + ", feedbackScene=" + this.c + ", feedbackSceneName=" + this.d + ", logId=" + this.e + ", model=" + this.f + ", metricsInfo=" + this.g + ')';
    }

    public static e a(e r8, String r9, String r10, d r11, int r12) {
        if ((r12 & 1) == 0) goto L5;
        r9 = r8.a;
    L5:
        String r1 = r9;
        if ((r12 & 2) == 0) goto L8;
        r10 = r8.b;
    L8:
        String r2 = r10;
        if ((r12 & 4) == 0) goto L11;
        Integer r3 = r8.c;
    L13:
        if ((r12 & 8) == 0) goto L15;
        String r4 = r8.d;
    L17:
        if ((r12 & 16) == 0) goto L19;
        String r5 = r8.e;
    L21:
        if ((r12 & 32) == 0) goto L23;
        r11 = r8.f;
    L23:
        d r6 = r11;
        if ((r12 & 64) == 0) goto L26;
        Map<String, String> r7 = r8.g;
    L27:
        r8.getClass();
        return new e(r1, r2, r3, r4, r5, r6, r7);
    L26:
        r7 = null;
        goto L27
    L19:
        r5 = null;
        goto L21
    L15:
        r4 = null;
        goto L17
    L11:
        r3 = null;
        goto L13
    }

    public /* synthetic */ e(String r9, Integer r10, String r11, d r12, Map r13, int r14) {
        if ((r14 & 2) == 0) goto L6;
        r9 = null;
    L6:
        if ((r14 & 4) == 0) goto L8;
        Integer r3 = null;
    L10:
        if ((r14 & 8) == 0) goto L12;
        String r4 = null;
    L14:
        if ((r14 & 32) == 0) goto L16;
        d r6 = null;
    L18:
        if ((r14 & 64) == 0) goto L20;
        Map r7 = null;
    L21:
        this(null, r9, r3, r4, null, r6, r7);
        return;
    L20:
        r7 = r13;
        goto L21
    L16:
        r6 = r12;
        goto L18
    L12:
        r4 = r11;
        goto L14
    L8:
        r3 = r10;
        goto L10
    }

    public e(String r1, String r2, Integer r3, String r4, String r5, d r6, Map<String, String> r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }
}
