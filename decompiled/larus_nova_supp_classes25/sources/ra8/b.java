package ra8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b {
    public final String a;
    public final String b;
    public final String c;
    public final boolean d;
    public final Boolean e;
    public final String f;
    public final Integer g;

    public b() {
        this(null, null, null, false, null, null, 127);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
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
        String r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        if (this.d == false) goto L17;
        int r10 = 1231;
    L18:
        int r11 = (r9 + r10) * 31;
        Boolean r12 = this.e;
        if (r12 != null) goto L21;
        int r13 = 0;
    L22:
        int r14 = (((r11 + r13) * 31) + this.f.hashCode()) * 31;
        Integer r15 = this.g;
        if (r15 == null) goto L27;
        r1 = r15.hashCode();
    L27:
        return r14 + r1;
    L21:
        r13 = r12.hashCode();
        goto L22
    L17:
        r10 = 1237;
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
        return "BlockRenderContext(messageId=" + this.a + ", senderId=" + this.b + ", conversationId=" + this.c + ", isTyping=" + this.d + ", isFinished=" + this.e + ", scene=" + this.f + ", messageStatus=" + this.g + ')';
    }

    public static b a(b r10, Boolean r11, String r12, int r13) {
        Integer r1 = null;
        if ((r13 & 1) == 0) goto L5;
        String r3 = r10.a;
    L7:
        if ((r13 & 2) == 0) goto L9;
        String r4 = r10.b;
    L11:
        if ((r13 & 4) == 0) goto L13;
        String r5 = r10.c;
    L15:
        if ((r13 & 8) == 0) goto L17;
        boolean r6 = r10.d;
    L19:
        if ((r13 & 16) == 0) goto L21;
        r11 = r10.e;
    L21:
        Boolean r7 = r11;
        if ((r13 & 32) == 0) goto L24;
        r12 = r10.f;
    L24:
        String r8 = r12;
        if ((r13 & 64) == 0) goto L27;
        r1 = r10.g;
    L27:
        r10.getClass();
        Intrinsics.checkNotNullParameter(r8, "scene");
        return new b(r3, r4, r5, r6, r7, r8, r1);
    L17:
        r6 = false;
        goto L19
    L13:
        r5 = null;
        goto L15
    L9:
        r4 = null;
        goto L11
    L5:
        r3 = null;
        goto L7
    }

    public /* synthetic */ b(String r11, String r12, String r13, boolean r14, Boolean r15, String r16, int r17) {
        if ((r17 & 1) == 0) goto L5;
        String r3 = null;
    L7:
        if ((r17 & 2) == 0) goto L9;
        String r4 = null;
    L11:
        if ((r17 & 4) == 0) goto L13;
        String r5 = null;
    L15:
        if ((r17 & 8) == 0) goto L17;
        boolean r6 = false;
    L19:
        if ((r17 & 16) == 0) goto L21;
        Boolean r7 = null;
    L23:
        if ((r17 & 32) == 0) goto L25;
        String r8 = "default";
    L26:
        this(r3, r4, r5, r6, r7, r8, null);
        return;
    L25:
        r8 = r16;
        goto L26
    L21:
        r7 = r15;
        goto L23
    L17:
        r6 = r14;
        goto L19
    L13:
        r5 = r13;
        goto L15
    L9:
        r4 = r12;
        goto L11
    L5:
        r3 = r11;
        goto L7
    }

    public b(String r2, String r3, String r4, boolean r5, Boolean r6, String r7, Integer r8) {
        Intrinsics.checkNotNullParameter(r7, "scene");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}
